package com.syhb.cleancode.dao;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int stock;
    private long price;

    public ProductDao() { }

    public ProductDao(String name, int stock, long price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public ProductDao(ProductDao key, Integer value) {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public long getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
