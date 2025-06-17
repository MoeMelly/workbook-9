package com.pluralsight.NorthwindTraders;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProductManager {
    private static final Logger logger = Logger.getLogger(ProductManager.class.getName());
    private static final String url = "jdbc:mysql://localhost:3306/northwind?user=root&password=yearup";
    private static final BasicDataSource source = new BasicDataSource();

    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    public boolean insert(Product product) {
        if (product == null) return false;
        String sql = "INSERT INTO products (productID, productName, Category, UnitPrice) VALUES (?, ?, ?, ?,)";
        try (Connection connection = source.getConnection();
             PreparedStatement statement = connection().prepareStatement(sql)) {
            statement.setInt(1, product.getProductID());
            statement.setString(2, product.getName());
            statement.setString(3, product.getCategory());
            statement.setBigDecimal(4, product.getPrice());
            int rowsAdd = statement.executeUpdate();
            return rowsAdd > 0;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean update(Product product) {
        if (product == null || product.getProductID() == 0 || product.getName() == null || product.getCategory() == null || product.getPrice() == null) {
            return false;
    }
        String sql = "UPDATE products SET productName = ?, UnitPrice = ?, category = ? WHERE product = ?";
        try (Connection connection = source.getConnection();
             PreparedStatement s = connection.prepareStatement(sql)) {
            s.setInt(1, product.getProductID());
            s.setString(2, product.getName());
            s.setBigDecimal(3, product.getPrice());
            s.setString(4, product.getCategory());
            int rowsUpdated = s.executeUpdate();
            return rowsUpdated > 0;




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection connection = source.getConnection();
            PreparedStatement s = connection.prepareStatement(sql);
            ResultSet r = s.executeQuery()) {
            while (r.next()) {
                Product p = new Product(
                        r.getInt("id"),
                        r.getString("productName"),
                        r.getString("category"),
                        r.getBigDecimal("UnitPrice") != null ? r.getBigDecimal("UnitPrice") : null
                );
                products.add(p);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return products;
    }
    public boolean deleteProducts(int productID) {
        String sql = "DELETE FROM products WHERE id = ?";
        try (Connection connection = source.getConnection();
             PreparedStatement p = connection().prepareStatement(sql)) {
            p.setInt(1, productID);
            int rowsAffected = p.executeUpdate();
            return p.executeUpdate() > 0;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}



