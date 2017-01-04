package com.rizomm.matgot.marieu.fou.Controller;

import com.rizomm.matgot.marieu.fou.dao.CategoryDao;
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

    public List<Category> findAllCategory(){
        return CD.findAllCategory();
    }

    public double getCountAllProduct() {
        int countProduct = PD.countAllProduct();
        return Math.ceil((double) countProduct / 9) ;
    }

    public void doFindProduct() {
        product = PD.findProductById(product.getId());
    }

    public Product getProduct() {
        return product;
    }

    public String getPriceDixieme() {
        return Utils.convertDoubleToStringWithDixieme(product.getPrice());
    }

}