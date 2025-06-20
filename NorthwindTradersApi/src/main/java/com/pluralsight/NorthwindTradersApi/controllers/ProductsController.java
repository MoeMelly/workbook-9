package com.pluralsight.NorthwindTradersApi.controllers;

import com.pluralsight.NorthwindTradersApi.models.JdbcProductDAO;
import com.pluralsight.NorthwindTradersApi.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {
   private final JdbcProductDAO productDAO;

   public ProductsController() {
       this.productDAO = new JdbcProductDAO();
   }



    @GetMapping("/products")
    public List<Product> getAllProducts() {
        JdbcProductDAO dao = new JdbcProductDAO();
        return dao.getAll();
    }


    @GetMapping("/products/{categoryId}")
    public Product getProductByCategoryId(@PathVariable int categoryId) {
        JdbcProductDAO dao = new JdbcProductDAO();
        return dao.getByInt(categoryId);

    }
    @PostMapping("/products")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Product addProduct (@RequestBody Product product) {
       JdbcProductDAO dao = new JdbcProductDAO();
       return dao.insert(product);
    }
}




