package com.syhb.cleancode.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetail")
public class OrderItemDao {

    @EmbeddedId
    @JsonIgnore
    private OrderProductPK pk;

    private int qty;

    public OrderItemDao() { }

    public OrderItemDao(OrderDao order, ProductDao product, int qty) {
        pk = new OrderProductPK();
        pk.setOrder(order);
        pk.setProduct(product);
        this.qty = qty;
    }

    public OrderProductPK getPk() {
        return pk;
    }

    public void setPk(OrderProductPK pk) {
        this.pk = pk;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
