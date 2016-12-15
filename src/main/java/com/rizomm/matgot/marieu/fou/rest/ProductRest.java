package com.rizomm.matgot.marieu.fou.rest;

import com.rizomm.matgot.marieu.fou.ejb.ProductEJB;
import com.rizomm.matgot.marieu.fou.model.Product;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by margotelmadi on 15/12/2016.
 */

@Path("/json/product")
public class ProductRest {

    @EJB
    private ProductEJB PD;

    @POST
    @Consumes("application/json")
    public Response addProduct(Product product){
        String result = "Reponse "+product.getName() + " a bien été créer";
        PD.create(product);
        return Response.status(201).entity(result).build();
    }
}
