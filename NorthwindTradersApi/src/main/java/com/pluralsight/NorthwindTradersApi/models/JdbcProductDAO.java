package com.pluralsight.NorthwindTradersApi.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDAO implements ProductDAO {
    private DataSource source;


    @Autowired
    public JdbcProductDAO(DataSource source) {
        this.source = source;

    }
    public JdbcProductDAO() {

    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection con = source.getConnection()) {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rows = statement.executeQuery();
            while (rows.next()) {
                Product product = new Product(
                        rows.getInt("ProductID"),
                        rows.getString("ProductName"),
                        rows.getInt("CategoryID"),
                        rows.getBigDecimal("UnitPrice"));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public Product getByInt(int id) {
        if (id <= 0) {
            return null;
        }

        String sql = "SELECT * FROM products WHERE id = ?";

        try (Connection con = source.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Product(
                        rs.getInt("id"),
                        rs.getString("ProductName"),
                        rs.getInt("CategoryID"),
                        rs.getBigDecimal("UnitPrice"));


            } else {
                return null;
            }
        } catch (SQLException e) {
           throw new RuntimeException("Product not found with id: " + id, e);
        }
    }
}
