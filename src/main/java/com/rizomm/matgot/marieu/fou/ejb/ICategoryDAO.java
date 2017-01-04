package com.rizomm.matgot.marieu.fou.ejb;

import java.util.List;
import java.util.Map;

/**
 * Created by margotelmadi on 04/01/2017.
 */
public interface ICategoryDao {

    Category createCategory(Category category);

    Category findCategoryById(int idCategory);

    void deleteAllCategory();

    Boolean deleteCategoryById(int idCategory);

    List<Category> findAllCategory();

    Category updateCategory(Category category);

    Boolean deleteCategory(Category category);

    Map<String, Object> convertJsonToProduct(String category);
}