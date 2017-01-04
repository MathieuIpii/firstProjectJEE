package com.rizomm.matgot.marieu.fou.ejb;

import com.rizomm.matgot.marieu.fou.model.Product;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * Created by Mathieu on 17/11/2016.
 */
public interface ProductEJBIT {
    Product createProduct(Product product);

    Product findProductById(int idProduct);

    List<Product> findAllProduct();

    int countAllProduct();

    int countAllProduct(int idCategory);

    void deleteAllProduct();

    Boolean deleteProductById(int idProduct);

    Boolean deleteProduct(Product product);

    Product updateProduct(Product product);

    Map<String, Object> convertJsonToProduct(String jsonString, CategoryEJB CD);

    JSONObject convertProductsToJson(List<Product> products);

    JSONObject convertProductToJson(Product product) throws JSONException;

    List<Product> findAllProductByPage(int start, int limit);

    List<Product> findAllProductByPageAndCategory(int start, int limit, int idCategory);

    Map<String,Object> convertJsonToProductForDelete(String jsonProduct);
}
