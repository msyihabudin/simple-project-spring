package com.syhb.cleancode.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class OrderProductPK implements Serializable {

    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "orderid")
    private OrderDao order;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "productid")
    private ProductDao product;

    public OrderDao getOrder() {
        return order;
    }

    public void setOrder(OrderDao order) {
        this.order = order;
    }

    public ProductDao getProduct() {
        return product;
    }

    public void setProduct(ProductDao product) {
        this.product = product;
    }
}
