package com.syhb.cleancode.services;

import com.syhb.cleancode.dao.ProductDao;
import com.syhb.cleancode.exceptions.NotEnoughProductsInStockException;

import java.math.BigDecimal;
import java.util.Map;

public interface CartService {

    void addToCart(ProductDao product);

    void removeFromCart(ProductDao product);

    Map<ProductDao, Integer> getCart();

    void checkout() throws NotEnoughProductsInStockException;

    BigDecimal getTotal();

}
