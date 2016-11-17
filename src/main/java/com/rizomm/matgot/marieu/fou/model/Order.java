package com.rizomm.matgot.marieu.fou.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Mathieu on 17/11/2016.
 */

@Entity
public class Order {
    @NotNull
    int id;

    List<OrderLine> lines;

}
