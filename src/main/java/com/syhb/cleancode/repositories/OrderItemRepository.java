package com.syhb.cleancode.repositories;

import com.syhb.cleancode.dao.OrderItemDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemDao, Integer> {
}
