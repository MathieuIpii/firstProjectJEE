package com.rizomm.matgot.marieu.fou.service;

import com.rizomm.matgot.marieu.fou.ejb.IProductDAO;
import com.rizomm.matgot.marieu.fou.model.OrderLine;
import com.rizomm.matgot.marieu.fou.model.Product;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.rizomm.matgot.marieu.fou.helper.Utils.*;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 1000)
@Remote
public class CartService implements IShoppingCartService {

    private List<OrderLine> listShoppingCart = new ArrayList();

    @Override
    public Map<String, Object> addProductCart(String jsonString, IProductDAO PD) {
        return null;
    }

    @Override
    public Map<String, Object> deleteProductToCart(String jsonString) {
        return null;
    }

    @Override
    public JSONObject getCart(IProductDAO PD) {
        return null;
    }

    @Override
    public boolean payer() {
        return false;
    }
/*
    @Override
    public Map<String, Object> addProductCart(String jsonString, IProductDAO PD) {
        Map<String, Object> result = new HashMap();
        int newQty = 1;
        try {
            JSONObject json = new JSONObject(jsonString);

            if (isEmpty(json, "id")) {
                return generateMessageError400("L'id du produit est nul");
            } else if (!isInt(json.getString("id"))) {
                return generateMessageError400("L'id doit être un int");
            } else if (json.getInt("id") < 0) {
                return generateMessageError400("L'id doit être un int positif");
            }

            if (isEmpty(json, "quantity")) {
                return generateMessageError400("La quantité ne doit pas être nulle.");
            } else if (!isInt(json.getString("quantity"))) {
                return generateMessageError400("La quantité doit être un int.");
            } else if (json.getInt("quantity") != 1 && json.getInt("quantity") != -1) {
                return generateMessageError400("La quantité doit être +1 ou -1");
            }

            Product product = PD.findProductById(json.getInt("id"));

            if (isEmpty(product)) {
                return generateMessageError400("Le produit n'existe pas. Veuillez l'ajouter.");
            }

            newQty = json.getInt("quantity");
            boolean existCart = false;
            for (OrderLine shoppingCart : listShoppingCart) {
                if (shoppingCart.getProd().getId() == product.getId()) {
                    newQty = shoppingCart.getQuantity() + newQty;
                    if (newQty <= 0) {
                        return deleteProductToCart(jsonString);
                    } else {
                        shoppingCart.setQuantity(newQty);
                    }
                    existCart = true;
                    break;
                }
            }

            if (!existCart) {
                if(newQty == -1){
                    return generateMessageError400("Vous ne pouvez pas diminuer la quantité d'un produit qui n'est pas dans votre panier.");
                }
                listShoppingCart.add(new OrderLine(product, newQty));
            }

        } catch (JSONException e) {
            return generateMessageError400("La requête n'est pas bien écrite.");
        } catch (Exception e) {
            return generateMessageError400("Une erreur est survenue.");
        }

        return generateMessageSuccess201("Le produit a été ajouté au panier. (" + newQty + ")");
    }

    @Override
    public Map<String, Object> deleteProductToCart(String jsonString) {
        Map<String, Object> result = new HashMap();

        try {

            JSONObject json = new JSONObject(jsonString);

            if (isEmpty(json, "id")) {
                return generateMessageError400("L'id du produit est nul");
            } else if (!isInt(json.getString("id"))) {
                return generateMessageError400("L'id doit être un int");
            } else if (json.getInt("id") < 0) {
                return generateMessageError400("L'id doit être un int positif");
            }


            boolean existCart = false;
            OrderLine shoppingCartToDelete = null;
            for (OrderLine shoppingCart : listShoppingCart) {
                if (shoppingCart.getProd().getId() == json.getInt("id")) {
                    shoppingCartToDelete = shoppingCart;
                    existCart = true;
                }
            }

            if (!existCart) {
                return generateMessageError400("Ce produit n'existe pas dans votre panier.");
            }else{
                listShoppingCart.remove(shoppingCartToDelete);
            }

        } catch (Exception e) {
            return generateMessageError400("Une erreur est survenue");
        }

        return generateMessageSuccess201("Le produit a été supprimé avec succés.");
    }

    @Override
    public JSONObject getCart(IProductDAO PD) {
        List<OrderLine> listShoppingCartToDelete = new ArrayList();
        JSONObject jsonCart = new JSONObject();

        try {
            JSONArray arrayProducts = new JSONArray();
            double totalCart = 0d;

            for (OrderLine shoppingCart : listShoppingCart) {
                Product product = shoppingCart.getProd();
                if(isNotEmpty(PD.findProductById(product.getId()))){
                    JSONObject jsonProduct = convertShoppingCartToJson(shoppingCart, PD);
                    arrayProducts.put(jsonProduct);
                    totalCart = totalCart + jsonProduct.getDouble("totalDouble");
                }else{
                    listShoppingCartToDelete.add(shoppingCart);
                }
            }

            for (OrderLine shoppingCartToDelete : listShoppingCartToDelete) {
                listShoppingCart.remove(shoppingCartToDelete);
            }

            jsonCart.put("products", arrayProducts);
            jsonCart.put("total", convertDoubleToStringWithDixieme(totalCart));
            jsonCart.put("qty", listShoppingCart.size());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonCart;
    }

    private JSONObject convertShoppingCartToJson(OrderLine shoppingCart, IProductDAO PD) throws JSONException {
        JSONObject jsonproduct = PD.convertProductToJson(shoppingCart.getProd());
        double totalProduct = shoppingCart.getQuantity() * shoppingCart.getProd().getPrice();
        jsonproduct.put("qty", shoppingCart.getQuantity());
        jsonproduct.put("total", convertDoubleToStringWithDixieme(totalProduct));
        jsonproduct.put("totalDouble", totalProduct);

        return jsonproduct;

    }


    @Override
    public boolean payer() {

        return false;
    }
    */
}
