package com.pluralsight.NorthwindTradersApi.models;

import java.util.List;

public interface CategoryDAO {
    List<Category> getAll();
    Category getById(int id);
}
