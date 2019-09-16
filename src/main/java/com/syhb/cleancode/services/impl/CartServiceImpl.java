package com.syhb.cleancode.services.impl;

import com.syhb.cleancode.dao.OrderDao;
import com.syhb.cleancode.dao.OrderItemDao;
import com.syhb.cleancode.dao.ProductDao;
import com.syhb.cleancode.exceptions.NotEnoughProductsInStockException;
import com.syhb.cleancode.repositories.OrderItemRepository;
import com.syhb.cleancode.repositories.OrderRepository;
import com.syhb.cleancode.repositories.ProductRepository;
import com.syhb.cleancode.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    private final OrderRepository orderRepository;

    private final OrderItemRepository orderItemRepository;

    private final ProductRepository productRepository;

    private Map<ProductDao, Integer> carts = new HashMap<>();

    private List<OrderItemDao> orderItemDaoList = new ArrayList<>();

    @Autowired
    public CartServiceImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void addToCart(ProductDao product) {
        if (carts.containsKey(product)) {
            carts.replace(product, carts.get(product) + 1);
        } else {
            carts.put(product, 1);
        }
    }

    @Override
    public void removeFromCart(ProductDao product) {
        if (carts.containsKey(product)) {
            if (carts.get(product) > 1)
                carts.replace(product, carts.get(product) - 1);
            else if (carts.get(product) == 1) {
                carts.remove(product);
            }
        }
    }

    @Override
    public Map<ProductDao, Integer> getCart() {
        return Collections.unmodifiableMap(carts);
    }

    @Override
    public void checkout() throws NotEnoughProductsInStockException {
        ProductDao product;
        OrderDao order = new OrderDao(10);

        for (Map.Entry<ProductDao, Integer> entry : carts.entrySet()) {
            product = productRepository.findProductDaoById(entry.getKey().getId());
            if (product.getStock() < entry.getValue())
                throw new NotEnoughProductsInStockException(product);
            entry.getKey().setStock(product.getStock() - entry.getValue());

            OrderItemDao orderitem = new OrderItemDao(order, product, entry.getValue());
            orderItemDaoList.add(orderitem);
        }

        productRepository.saveAll(carts.keySet());
        productRepository.flush();

        orderRepository.save(order);
        orderItemRepository.saveAll(orderItemDaoList);

        carts.clear();
    }

    @Override
    public BigDecimal getTotal() {
        long result = 0;
        for (Map.Entry<ProductDao, Integer> entry : carts.entrySet()) {
            result += entry.getValue() * entry.getKey().getPrice();
        }

        return new BigDecimal(result);
    }
}
