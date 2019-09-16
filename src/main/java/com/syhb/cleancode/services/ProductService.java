package com.syhb.cleancode.services;

import com.syhb.cleancode.dao.ProductDao;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDao> listproduct();
    List<ProductDao> filterproductbypricerange(long start, long end);
    List<ProductDao> filterproductbyname(String name);

    Optional<ProductDao> findById(int id);

}
