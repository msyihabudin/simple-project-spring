package com.syhb.cleancode.repositories;

import com.syhb.cleancode.dao.OrderDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderDao, Integer> {


}
