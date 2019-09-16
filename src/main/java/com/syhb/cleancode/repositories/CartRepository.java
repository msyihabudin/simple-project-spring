package com.syhb.cleancode.repositories;

import com.syhb.cleancode.dao.CartDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartDao, Integer> {
    CartDao findCartDaoById(int id);
}
