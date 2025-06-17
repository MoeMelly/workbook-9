package com.pluralsight.NorthwindTraders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController {
    ProductDAO productDAO;

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    @GetMapping("/products")
    public List<Product> displayAllProducts() {
        return productDAO.getAll();
    }
    public void addProduct() {
        Product product = new Product(1,"Black","Fruits",new BigDecimal("2098.90"));
       productDAO.add(product);
    }
}
