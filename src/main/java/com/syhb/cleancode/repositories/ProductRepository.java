package com.syhb.cleancode.repositories;

import com.syhb.cleancode.dao.ProductDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductDao, Integer> {
    List<ProductDao> findProductDaosByPriceBetween(long priceStart, long priceEnd);
    List<ProductDao> findProductDaosByNameContains(String name);

    ProductDao findProductDaoById(int id);

    Optional<ProductDao> findById(int id);

}
