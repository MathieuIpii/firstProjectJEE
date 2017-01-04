package com.rizomm.matgot.marieu.fou.ejb;

import com.rizomm.matgot.marieu.fou.model.Category;
import com.rizomm.matgot.marieu.fou.model.Product;
import org.codehaus.jettison.json.JSONArray;
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
import static com.rizomm.matgot.marieu.fou.model.Product.*;
//import static com.rizomm.matgot.marieu.fou.model.Product.FIND_ALL;

/**
 * Created by margotelmadi on 04/01/2017.
 */
@Stateless
@Remote
@Named
public class ProductDAO implements IProductDAO, Serializable {

    @PersistenceContext(unitName = "projectJ2ee")
    protected EntityManager em;
    protected boolean isNotTest = true;

    @Override
    public Product createProduct(Product product) {
        if (isNotEmpty(product.getName())) {
            em.persist(product);
            if(isNotTest){
                em.flush();
            }
            return product;
        }
        return null;
    }

    @Override
    public Product findProductById(int idProduct) {
        Product findProduct = em.find(Product.class, idProduct);
        return findProduct;
    }

    @Override
    public Product findProductById(Long idProduct) {
        Product findProduct = em.find(Product.class, idProduct);
        return findProduct;
    }

    @Override
    public List<Product> findAllProduct() {
        TypedQuery<Product> query = em.createNamedQuery(FIND_ALL, Product.class);
        if (isNotTest) {
            em.joinTransaction();
        }
        return query.getResultList();
    }

    @Override
    public List<Product> findAllProductByPage(int start, int limit) {
        TypedQuery<Product> query = em.createNamedQuery(FIND_ALL, Product.class)
                .setFirstResult(start)
                .setMaxResults(limit);
        if (isNotTest) {
            em.joinTransaction();
        }
        return query.getResultList();
    }

    @Override
    public List<Product> findAllProductByPageAndCategory(int start, int limit, int idCategory) {
        TypedQuery<Product> query = em.createNamedQuery(FIND_ALL_BY_CATEGORY, Product.class)
                .setFirstResult(start)
                .setMaxResults(limit)
                .setParameter("idCategory", idCategory);
        if (isNotTest) {
            em.joinTransaction();
        }
        return query.getResultList();
    }


    @Override
    public int countAllProduct() {
        TypedQuery<Integer> query = em.createNamedQuery(COUNT_ALL, Integer.class);
        if (isNotTest) {
            em.joinTransaction();
        }
        return ((Number) query.getSingleResult()).intValue();
    }

    @Override
    public int countAllProduct(int idCategory) {
        TypedQuery<Integer> query = em.createNamedQuery(COUNT_ALL_BY_CATEGORY, Integer.class)
                .setParameter("idCategory", idCategory);
        if (isNotTest) {
            em.joinTransaction();
        }
        return ((Number) query.getSingleResult()).intValue();
    }

    @Override
    public void deleteAllProduct() {
        em.createNamedQuery(DELETE_ALL, Product.class).executeUpdate();
    }

    @Override
    public Boolean deleteProductById(int idProduct) {
        Product product = em.find(Product.class, idProduct);
        if (isNotEmpty(product)) {
            return deleteProduct(product);
        }
        return false;
    }

    @Override
    public Boolean deleteProduct(Product product) {
        em.remove(product);
        Product findProduct = em.find(Product.class, product.getId());
        if (isEmpty(findProduct)) {
            return true;
        }
        return false;
    }

    @Override
    public Product updateProduct(Product product) {
        return em.merge(product);
    }

    @Override
    public Map<String, Object> convertJsonToProduct(String jsonString) {
        Map<String, Object> result = new HashMap();
        Product product = new Product();

        try {
            JSONObject json = new JSONObject(jsonString);

            if(isEmpty(json,"id")){
                return generateMessageError400("L'id est obligatoire !");
            }else if(!isInt(json.getString("id"))){
                return generateMessageError400("L'id doit être un chiffre !");
            }else if(json.getInt("id") < 0){
                return generateMessageError400("L'id doit être un chiffre positif !");
            }

            result.put("ID",json.getInt("id"));
            result.put("ERROR",false);
        } catch (JSONException e) {
            return generateMessageError400("Le format de la requête n'est pas respecté !");
        }catch (Exception e) {
            return generateMessageError400("Aie, une erreur est survenue !");
        }

        return result;
    }

    @Override
    public Map<String, Object> convertJsonToProduct(String jsonString, ICategoryDAO CD) {

        Map<String, Object> result = new HashMap();
        Product product = new Product();

        try {
            JSONObject json = new JSONObject(jsonString);


            if(isEmpty(json,"stock")){
                return generateMessageError400("Le stock est obligatoire !");
            }else if(!isInt(json.getString("stock"))){
                return generateMessageError400("Le stock doit être un chiffre !");
            }else if(json.getInt("stock") < 0){
                return generateMessageError400("Le stock doit être un chiffre positif !");
            }

            if(isEmpty(json,"price")){
                return generateMessageError400("Le prix est obligatoire !");
            }else if(!isDouble(json.getString("price"))){
                return generateMessageError400("Le prix doit être un nombre !");
            }else if(isNotConvertDoubleToDixieme( Double.parseDouble(json.getString("price")))){
                return generateMessageError400("Le prix est trop grand !");
            }else if(convertDoubleToDixieme(json.getString("price")) < 0){
                return generateMessageError400("Le prix doit être un chiffre positif !");
            }

            if(isEmpty(json,"name")){
                return generateMessageError400("Le nom est obligatoire !");
            }else if(isTooLarge(json,"name",255)){
                return generateMessageError400("Le nom est trop long !");
            }

            if(isEmpty(json,"urlPicture")){
                return generateMessageError400("L'url de l'image est obligatoire !");
            }else if(isTooLarge(json,"urlPicture",255)){
                return generateMessageError400("L'url de l'image est trop longue !");
            }

            if(isEmpty(json,"description")){
                return generateMessageError400("La description est obligatoire !");
            }

            product.setStock(json.getInt("stock"));
            product.setPrice(convertDoubleToDixieme(json.getString("price")));
            product.setName(json.getString("name"));
            product.setUrlPicture(json.getString("urlPicture"));
            product.setDescription(json.getString("description"));

            if(isNotEmpty(json,"id")){
                if(!isInt(json.getString("id"))){
                    return generateMessageError400("L'id doit être un nombre !");
                }
                product.setId(json.getInt("id"));
            }


            if (json.has("category") && !json.isNull("category")) {
                Map<String, Object> resultCategory = CD.convertJsonToProduct(json.getString("category"));

                if((boolean) resultCategory.get("ERROR")){
                    return resultCategory;
                }

                Category category = (Category) resultCategory.get("CATEGORY");

                if(category.getId() == 0){
                    category.setId(CD.createCategory(category).getId());
                }else{
                    Long idCategory = category.getId();
                    category = CD.findCategoryById(idCategory);
                    if(category == null){
                        return generateMessageError400("La catégorie avec l'id : " + idCategory + " n'éxiste pas");
                    }
                }

                product.setCategory(category);

            }else{
                return generateMessageError400("Une catégorie est obligatoire !");
            }

            result.put("PRODUCT",product);
            result.put("ERROR",false);
        } catch (JSONException e) {
            return generateMessageError400("Le format de la requête n'est pas respecté !");
        }catch (Exception e) {
            return generateMessageError400("Aie, une erreur est survenue !");
        }

        return result;
    }

    @Override
    public Map<String, Object> convertJsonToProductForDelete(String jsonString) {
        Map<String, Object> result = new HashMap();
        Product product = new Product();

        try {
            JSONObject json = new JSONObject(jsonString);

            if(isEmpty(json,"id")){
                return generateMessageError400("L'id est obligatoire !");
            }else if(!isInt(json.getString("id"))){
                return generateMessageError400("L'id doit être un chiffre !");
            }else if(json.getInt("id") < 0){
                return generateMessageError400("L'id doit être un chiffre positif !");
            }

            result.put("ID",json.getInt("id"));
            result.put("ERROR",false);
        } catch (JSONException e) {
            return generateMessageError400("Le format de la requête n'est pas respecté !");
        }catch (Exception e) {
            return generateMessageError400("Aie, une erreur est survenue !");
        }

        return result;
    }

    @Override
    public JSONObject convertProductsToJson(List<Product> products) {
        JSONObject jsonProducts = new JSONObject();

        try {
            JSONArray jsonArray = new JSONArray();
            for(Product product : products){
                jsonArray.put(convertProductToJson(product));
            }
            jsonProducts.put("products", jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonProducts;
    }

    @Override
    public JSONObject convertProductToJson(Product product) throws JSONException {
        JSONObject jsonproduct = new JSONObject();
        jsonproduct.put("id", product.getId());
        jsonproduct.put("description", product.getShortDescription());
        jsonproduct.put("idCategory", product.getCategory().getId());
        jsonproduct.put("labelCategory", product.getCategory().getLabel());
        jsonproduct.put("name", product.getName());
        jsonproduct.put("price", convertDoubleToStringWithDixieme(product.getPrice()));
        jsonproduct.put("stock", product.getStock());
        jsonproduct.put("urlPicture", product.getUrlPicture());
        return jsonproduct;
    }

}
