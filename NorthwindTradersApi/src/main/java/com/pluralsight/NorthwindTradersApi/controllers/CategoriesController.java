package com.pluralsight.NorthwindTradersApi.controllers;

import com.pluralsight.NorthwindTradersApi.models.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {
    Category category;
    List<Category> categories = new ArrayList<>();



    @GetMapping("/category")
    public List<Category> showCategory() {
        categories.add(new Category(1, "Electronics"));
        categories.add(new Category(2, "Food"));
        return categories;
    }
    @GetMapping("category/{categoryid}")
    public Category getCategoryById(@PathVariable int categoryId) {
        JdbcCategoryDAO dao = new JdbcCategoryDAO();
        return dao.getById(categoryId);
    }
    @GetMapping("/category")
    public List<Category> getAllCategories() {
        JdbcCategoryDAO dao = new JdbcCategoryDAO();

        return dao.getAll();
    }


}





