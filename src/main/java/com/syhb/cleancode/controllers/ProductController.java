package com.syhb.cleancode.controllers;

import com.syhb.cleancode.dao.ProductDao;
import com.syhb.cleancode.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/list")
    public List<ProductDao> listproduct() {
        return productService.listproduct();
    }

    @PostMapping("/product/filter/bypricerange")
    public List<ProductDao> filterproductbypricerange(@RequestBody Map<String, String> body) {
        long startprice = Long.parseLong(body.get("startprice"));
        long endprice = Long.parseLong(body.get("endprice"));

        return productService.filterproductbypricerange(startprice, endprice);
    }

    @PostMapping("/product/filter/byname")
    public List<ProductDao> filterproductbyname(@RequestBody String name) {
        return productService.filterproductbyname(name);
    }

}
