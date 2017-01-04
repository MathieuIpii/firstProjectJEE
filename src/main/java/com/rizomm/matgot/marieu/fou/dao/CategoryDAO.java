package com.rizomm.matgot.marieu.fou.dao;

import com.rizomm.matgot.marieu.fou.ejb.ICategoryDAO;
import com.rizomm.matgot.marieu.fou.model.Category;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.rizomm.matgot.marieu.fou.helper.Utils.*;
import static com.rizomm.matgot.marieu.fou.model.Product.DELETE_ALL;
import static com.rizomm.matgot.marieu.fou.model.Product.FIND_ALL;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Stateless
@Remote
@Named
public class CategoryDAO implements ICategoryDAO, Serializable {

    @PersistenceContext(unitName = "projectJ2ee")
    protected EntityManager em;
    protected boolean isNotTest = true;

    @Override
    public Category createCategory(Category category) {
        if (isNotEmpty(category.getLabel())) {
            em.persist(category);
            if(isNotTest){
                em.flush();
            }
            return category;
        }
        return null;
    }

    @Override
    public Category findCategoryById(Long idCategory) {
        Category findCategory = em.find(Category.class, idCategory);
        return findCategory;
    }

    @Override
    public List<Category> findAllCategory() {
        TypedQuery<Category> query = em.createNamedQuery(FIND_ALL, Category.class);
        if (isNotTest) {
            em.joinTransaction();
        }
        return query.getResultList();
    }

    @Override
    public void deleteAllCategory() {
        em.createNamedQuery(DELETE_ALL, Category.class).executeUpdate();
    }

    @Override
    public Boolean deleteCategoryById(int idCategory) {
        Category category = em.find(Category.class, idCategory);
        if (isNotEmpty(category)) {
            return deleteCategory(category);
        }
        return false;
    }

    @Override
    public Boolean deleteCategory(Category category) {
        em.remove(category);
        Category findCategory = em.find(Category.class, category.getId());
        if (isEmpty(findCategory)) {
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Object> convertJsonToProduct(String categoryString) {
        JSONObject jsonCategory = null;
        Map<String, Object> result = new HashMap();
        Category category = new Category();

        try {

            jsonCategory = new JSONObject(categoryString);

            if(isNotEmpty(jsonCategory,"id")){

                String idString = jsonCategory.getString("id");

                if(!isInt(idString)){
                    return generateMessageError400("L'id de la catégorie doit être un int.");
                }

                category.setId((long) Integer.parseInt(idString));

            }else if(isNotEmpty(jsonCategory,"label")){

                if(isTooLarge(jsonCategory,"label",255)){
                    return generateMessageError400("Le label de la catégorie est trop long.");
                }

                category.setLabel(jsonCategory.getString("label"));
            }else{
                return generateMessageError400("La categorie n'est pas bien renseignée ! ");
            }

        } catch (JSONException e) {
            return generateMessageError400(e.getMessage());
        }

        result.put("ERROR",false);
        result.put("CATEGORY",category);
        return result;

    }

    @Override
    public Category updateCategory(Category category) {
        return em.merge(category);
    }

}
