package com.syhb.cleancode.services.impl;

import com.syhb.cleancode.dao.ProductDao;
import com.syhb.cleancode.repositories.ProductRepository;
import com.syhb.cleancode.services.ProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDao> listproduct() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductDao> filterproductbypricerange(long start, long end) {
        return productRepository.findProductDaosByPriceBetween(start, end);
    }

    @Override
    public List<ProductDao> filterproductbyname(String name) {
        return productRepository.findProductDaosByNameContains(name);
    }

    @Override
    public Optional<ProductDao> findById(int id) {
        return productRepository.findById(id);
    }
}
