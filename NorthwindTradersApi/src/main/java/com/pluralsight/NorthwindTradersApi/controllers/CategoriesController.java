package com.pluralsight.NorthwindTradersApi.controllers;

import com.pluralsight.NorthwindTradersApi.models.Category;
import com.pluralsight.NorthwindTradersApi.models.JdbcProductDAO;
import com.pluralsight.NorthwindTradersApi.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {
    private JdbcCategoryDAO categoryDAO;


    public CategoriesController() {
        this.categoryDAO = new JdbcCategoryDAO();
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

    @PostMapping("/products")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Category insertProduct(@RequestBody Category category) {
        JdbcCategoryDAO dao = new JdbcCategoryDAO();
        return dao.insert(category);

    }
}





