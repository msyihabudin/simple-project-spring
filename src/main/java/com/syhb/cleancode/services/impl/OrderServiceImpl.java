package com.syhb.cleancode.services.impl;

import com.syhb.cleancode.dao.OrderDao;
import com.syhb.cleancode.repositories.OrderRepository;
import com.syhb.cleancode.services.OrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderDao> listorder() {
        return orderRepository.findAll();
    }
}
