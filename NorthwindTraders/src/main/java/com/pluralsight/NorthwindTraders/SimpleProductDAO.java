package com.pluralsight.NorthwindTraders;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDAO implements ProductDAO {
    List<Product> products = new ArrayList<>();

    public SimpleProductDAO() {
        products = new ArrayList<>();
        products.add(new Product(1, "Apples", "Fruits", new BigDecimal("213.89")));
        products.add(new Product(2, "Celery", "Vegetables", new BigDecimal("90.98")));
        products.add(new Product(3, "Candy", "Sweets", new BigDecimal("20.00")));
        products.add(new Product(4, "Fried Chicken", "Meats", new BigDecimal("45.99")));
        products.add(new Product(5, "Grape Kool-Aid", "Sweetened Juice", new BigDecimal("50.00")));

    }


    @Override
    public boolean add(Product product) {
        if (product == null) return false;
        return products.add(product);

    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
