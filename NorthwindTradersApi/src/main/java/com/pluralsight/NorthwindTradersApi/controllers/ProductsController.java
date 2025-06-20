package com.pluralsight.NorthwindTradersApi.controllers;

import com.pluralsight.NorthwindTradersApi.models.JdbcProductDAO;
import com.pluralsight.NorthwindTradersApi.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {
    Product product;
    List<Product> products = new ArrayList<>();

    @GetMapping("/products")
    public List<Product> getProducts() {
        products.add(new Product(1, "Apple", 1, new BigDecimal("199.99")));
        products.add(new Product(2, "ASUS", 4, new BigDecimal("599.99")));
        products.add(new Product(3, "Alienware", 6, new BigDecimal("2000")));
        products.add(new Product(4, "Dell", 9, new BigDecimal("499.99")));
        return products;
    }

    @GetMapping("/products/{productId}")
    public List<Product> getAllProducts() {
        JdbcProductDAO dao = new JdbcProductDAO();
        return dao.getAll();
    }


    @GetMapping("/products/{categoryId}")
    public Product getProductByCategoryId(@PathVariable int categoryId) {
        JdbcProductDAO dao = new JdbcProductDAO();
        return dao.getByInt(categoryId);

    }
}




