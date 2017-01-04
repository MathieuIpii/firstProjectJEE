package com.rizomm.matgot.marieu.fou.rest;

import com.rizomm.matgot.marieu.fou.ejb.ICategoryDAO;
import com.rizomm.matgot.marieu.fou.ejb.IProductDAO;
import com.rizomm.matgot.marieu.fou.ejb.ProductEJB;
import com.rizomm.matgot.marieu.fou.helper.Utils;
import com.rizomm.matgot.marieu.fou.model.Product;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

/**
 * Created by margotelmadi on 15/12/2016.
 */

@Path("/product")
@Named
@RequestScoped
public class ProductRest {

    @EJB
    private IProductDAO PD;

    @EJB
    private ICategoryDAO CD;

    @POST
    @Produces("application/json")
    public Response addProduct(String productString) {
        Map<String, Object> result = PD.convertJsonToProduct(productString, CD);

        if (!(boolean)result.get("ERROR")) {
            Product productResult = (Product) result.get("PRODUCT");
            if (Utils.isNotEmpty(productResult.getId()) && Utils.isNotEmpty(PD.findProductById(productResult.getId()))) {
                result = Utils.generateMessageError400("Le produit existe déja, utiliser la methode PUT pour le modifier.");
            } else {
                Product product = PD.createProduct(productResult);
                result = Utils.generateMessageSuccess201("Produit créé avec l'id : " + product.getId() + " et avec la catégorie id : " + product.getCategory().getId());
            }
        }

        return Response.status((Integer) result.get("CODE_HTTP")).entity(result.get("MESSAGE_HTTP")).build();
    }

    @PUT
    @Produces("application/json")
    public Response updateProduct(String productString) {
        Map<String, Object> result = PD.convertJsonToProduct(productString, CD);

        if (!((boolean) result.get("ERROR"))) {
            Product productResult = (Product) result.get("PRODUCT");
            Product product;
            if (Utils.isNotEmpty(productResult.getId()) && Utils.isNotEmpty(PD.findProductById(productResult.getId()))) {
                product = PD.updateProduct(productResult);
                result = Utils.generateMessageSuccess200("Produit modifié avec succés");
            } else {
                result = Utils.generateMessageError400("Le produit n'existe pas, utiliser la méthode POST pour l'ajouter.");
            }
        }

        return Response.status((Integer) result.get("CODE_HTTP")).entity(result.get("MESSAGE_HTTP")).build();
    }

    @DELETE
    @Produces("application/json")
    public Response deleteProduct(String jsonProduct) {
        Map<String, Object> result = PD.convertJsonToProductForDelete(jsonProduct);

        if (!((boolean) result.get("ERROR"))) {
            if (PD.deleteProductById((Integer) result.get("idProduct"))) {
                result = Utils.generateMessageSuccess200("Produit supprimé avec succés.");
            } else {
                result = Utils.generateMessageError400("Le produit n'existe pas.");
            }
        }

        return Response.status((Integer) result.get("CODE_HTTP")).entity(result.get("MESSAGE_HTTP")).build();
    }

    @GET
    @Path("/{numberPage : \\d+}/page")
    @Produces("application/json")
    public Response getAllProductByPage(String productString, @PathParam("numberPage") int numberPage) {
        int start = numberPage * 9;
        int limit = numberPage + 1 * 9;
        List<Product> listProduct = PD.findAllProductByPage(start, limit);

        JSONObject jsonProducts = PD.convertProductsToJson(listProduct);

        Map<String, Object> result = Utils.generateMessageSuccess200(jsonProducts);

        return Response.status((Integer) result.get("CODE_HTTP")).entity(result.get("MESSAGE_HTTP")).build();
    }

    @GET
    @Path("/{numberPage : \\d+}/page/{idCategory : \\d+}/category")
    @Produces("application/json")
    public Response getAllProductByPageAndCategory(String productString
            , @PathParam("numberPage") int numberPage
            , @PathParam("idCategory") int idCategory) {
        int start = numberPage * 9;
        int limit = numberPage + 1 * 9;
        List<Product> listProduct = PD.findAllProductByPageAndCategory(start, limit, idCategory);

        JSONObject jsonProducts = PD.convertProductsToJson(listProduct);

        Map<String, Object> result = Utils.generateMessageSuccess200(jsonProducts);

        return Response.status((Integer) result.get("CODE_HTTP")).entity(result.get("MESSAGE_HTTP")).build();
    }

    @GET
    @Path("/count")
    @Produces("application/json")
    public Response getCountAllProduct(String productString) {
        int countProduct = PD.countAllProduct();

        JSONObject jsonCountProducts = new JSONObject();
        try {
            jsonCountProducts.put("COUNT_PRODUCT", countProduct);
            jsonCountProducts.put("COUNT_PAGE", Math.ceil((double) countProduct / 9));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Map<String, Object> result = Utils.generateMessageSuccess200(jsonCountProducts);

        return Response.status((Integer) result.get("CODE_HTTP")).entity(result.get("MESSAGE_HTTP")).build();
    }

    @GET
    @Path("/count/{idCategory : \\d+}/category")
    @Produces("application/json")
    public Response getCountAllProductByCategory(String productString, @PathParam("idCategory") int idCategory) {
        int countProduct = PD.countAllProduct(idCategory);

        JSONObject jsonCountProducts = new JSONObject();
        try {
            jsonCountProducts.put("COUNT_PRODUCT", countProduct);
            jsonCountProducts.put("COUNT_PAGE", Math.ceil((double) countProduct / 9));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Map<String, Object> result = Utils.generateMessageSuccess200(jsonCountProducts);

        return Response.status((Integer) result.get("CODE_HTTP")).entity(result.get("MESSAGE_HTTP")).build();
    }
}
