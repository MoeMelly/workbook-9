package com.pluralsight.NorthwindTradersApi.controllers;

import com.pluralsight.NorthwindTradersApi.models.Category;
import com.pluralsight.NorthwindTradersApi.models.CategoryDAO;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCategoryDAO implements CategoryDAO {
    private DataSource source;


    public JdbcCategoryDAO(DataSource source) {
        this.source = source;
    }

    public JdbcCategoryDAO() {

    }

    @Override
    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM categories";

        try(Connection connection = source.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Category category = new Category(
                        rs.getInt("CategoryID"),
                        rs.getString("CategoryName"));
                list.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return List.of();
    }

    @Override
    public Category getById(int CategoryID) {
        if (CategoryID <= 0) {
            return null;
        }
        String sql = "SELECT * FROM categories WHERE id = ?";

        try(Connection connection = source.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, CategoryID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
               return new Category(
                        rs.getInt("CategoryID"),
                        rs.getString("CategoryName"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot find id with id: " + CategoryID,e);
        }

    }
}
