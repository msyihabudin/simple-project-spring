package com.syhb.cleancode.controllers;

import com.syhb.cleancode.dao.OrderDao;
import com.syhb.cleancode.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/list")
    public List<OrderDao> index() {
        return orderService.listorder();
    }

}
