package com.rizomm.matgot.marieu.fou.Controller;

import com.rizomm.matgot.marieu.fou.ejb.ICategoryDAO;
import com.rizomm.matgot.marieu.fou.ejb.IProductDAO;
import com.rizomm.matgot.marieu.fou.model.Category;
import com.rizomm.matgot.marieu.fou.model.Product;
import com.rizomm.matgot.marieu.fou.helper.Utils;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by margotelmadi on 15/12/2016.
 */
@Named
@RequestScoped
public class ProductController implements Serializable {

    @EJB
    private ICategoryDAO CD;

    @EJB
    private IProductDAO PD;

    private Product product = new Product();
    private static final long serialVersionUID = 1L;

    public Product getProduct() {
        return product;
    }

    public List<Product> findAllProduct(){
        return PD.findAllProduct();
    }

    public void addToCart(){
        PD.addToCart(product);
    }

    public String display(String page, int id){
        product.setId(id);
        return page+".xhtml";
    }

    public void createProductTest(){
        PD.deleteAllProduct();
        createCat();

        Product product1 = new Product(1, 20, 24.99f, "Petite table basse", "une petite table basse tranquille", "table-haute.jpg");
        Product product2 = new Product(1, 10, 69.99f, "Table à manger", "une belle table tranquille", "table-haute.jpg");
        Product product3 = new Product(1, 50, 9.99f, "Dinette", "une petite dinette tranquille", "dinette.jpg");
        Product product4 = new Product(2, 10, 49.99f, "Grande lampe", "une belle lampe de salon posée", "lampe-salon.jpg");
        Product product5 = new Product(2, 20, 24.99f, "Petite lampe de chevet", "une petite lampe de chevet posée", "lampe.jpg");
        Product product6 = new Product(2, 50, 14.99f, "Spot de soirée", "pour faire une grosse fête ou juste une soirée posée", "spot.jpg");

        PD.createProduct(product1);
        PD.createProduct(product2);
        PD.createProduct(product3);
        PD.createProduct(product4);
        PD.createProduct(product5);
        PD.createProduct(product6);
    }

    public void createCat(){
        Category cat1 = new Category(1, "Table");
        Category cat2 = new Category(2, "Lampe");
        CD.createCategory(cat1);
        CD.createCategory(cat2);
    }
}