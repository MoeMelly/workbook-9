package com.pluralsight.NorthwindTradersApi.models;

import java.util.List;

public interface ProductDAO {
    List<Product> getAll();
    Product getByInt(int id);
    Product insert(Product product);
}
