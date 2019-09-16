package com.syhb.cleancode.controllers;

import com.syhb.cleancode.dao.ProductDao;
import com.syhb.cleancode.exceptions.NotEnoughProductsInStockException;
import com.syhb.cleancode.services.CartService;
import com.syhb.cleancode.services.ProductService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CartController {

    private final CartService cartService;

    private final ProductService productService;

    @Autowired
    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping("/cart")
    public String listcart() {
        Map<ProductDao, Integer> map = cartService.getCart();

        JSONArray jsonArray = new JSONArray();

        map.forEach((key, value) -> {
            try {
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("item", key.getName());
                jsonObject1.put("price", key.getPrice());
                jsonObject1.put("qty", value);
                jsonObject1.put("subtotal", key.getPrice() * value);

                jsonArray.put(jsonObject1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("cartitem", jsonArray);
            jsonObject.put("total", cartService.getTotal());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject.toString();
    }

    @GetMapping("/cart/total")
    public BigDecimal totalcart() {
        return cartService.getTotal();
    }

    @PostMapping("/cart/add")
    public ResponseEntity<String> addToCart(@RequestBody String productid) {
        System.out.println("In CartService add");

        productService.findById(Integer.parseInt(productid)).ifPresent(cartService::addToCart);

        return ResponseEntity.status(HttpStatus.OK).body("Add to cart successfully");
    }

    @PostMapping("/cart/remove")
    public ResponseEntity<String> removeFromCart(@RequestBody String productid) {
        System.out.println("In CartService add");

        productService.findById(Integer.parseInt(productid)).ifPresent(cartService::removeFromCart);

        return ResponseEntity.status(HttpStatus.OK).body("Remove from cart successfully");
    }

    @GetMapping("/cart/checkout")
    public ResponseEntity<String> checkout() {
        try {
            cartService.checkout();
        } catch (NotEnoughProductsInStockException e) {
            return ResponseEntity.status(HttpStatus.OK).body("outOfStockMessage: "+ e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("Checkout successfully ");
    }

}
