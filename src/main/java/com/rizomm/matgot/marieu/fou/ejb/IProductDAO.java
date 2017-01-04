package com.rizomm.matgot.marieu.fou.ejb;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import com.rizomm.matgot.marieu.fou.model.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by margotelmadi on 04/01/2017.
 */
public interface IProductDAO {

    Product createProduct(Product product);

    Product findProductById(Long idProduct);

    List<Product> findAllProduct();

    int countAllProduct();

    int countAllProduct(int idCategory);

    void deleteAllProduct();

    Boolean deleteProductById(int idProduct);

    Boolean deleteProduct(Product product);

    Product updateProduct(Product product);

    Map<String, Object> convertJsonToProduct(String jsonString, ICategoryDAO CD);

    JSONObject convertProductsToJson(List<Product> products);

    JSONObject convertProductToJson(Product product) throws JSONException;

    List<Product> findAllProductByPage(int start, int limit);

    List<Product> findAllProductByPageAndCategory(int start, int limit, int idCategory);

    Map<String, Object> convertJsonToProduct(String jsonString, ICategoryDAO CD);

    Map<String,Object> convertJsonToProductForDelete(String jsonProduct);
}

