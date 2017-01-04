package com.rizomm.matgot.marieu.fou.ejb;

import java.util.List;
import java.util.Map;
import com.rizomm.matgot.marieu.fou.model.Category;

/**
 * Created by margotelmadi on 04/01/2017.
 */
public interface ICategoryDAO {

    Category createCategory(Category category);

    Category findCategoryById(Long idCategory);

    void deleteAllCategory();

    Boolean deleteCategoryById(int idCategory);

    List<Category> findAllCategory();

    Category updateCategory(Category category);

    Boolean deleteCategory(Category category);

    Map<String, Object> convertJsonToProduct(String category);

    Map<String, Object> convertJsonToProduct(String category, ICategoryDAO CD);
}