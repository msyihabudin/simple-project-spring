package com.syhb.cleancode.dao;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class CartDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int productid;
    private int qty;

    public CartDao() { }

    public CartDao(int productid, int qty) {
        this.productid = productid;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public int getProductid() {
        return productid;
    }

    public int getQty() {
        return qty;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
