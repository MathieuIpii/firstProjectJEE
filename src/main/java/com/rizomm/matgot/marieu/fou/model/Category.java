package com.rizomm.matgot.marieu.fou.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

import static com.rizomm.matgot.marieu.fou.model.Category.FIND_ALL;
import static com.rizomm.matgot.marieu.fou.model.Category.DELETE_ALL;

/**
 * Created by Mathieu on 17/11/2016.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = FIND_ALL, query = "select c from Category c"),
        @NamedQuery(name = DELETE_ALL, query = "delete from Category"),
})
public class Category implements Serializable{

    public static final String FIND_ALL = "Category.findAllCategory";
    public static final String DELETE_ALL = "Category.deleteAllCategory";
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    @Size(min = 1, max = 30, message = "Le label doit être entre 1 and 30")
    private String label;

    public Category(){}

    public Category(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
