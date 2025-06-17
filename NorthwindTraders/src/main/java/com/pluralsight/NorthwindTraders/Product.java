package com.pluralsight.NorthwindTraders;

import java.math.BigDecimal;

public class Product {
    int productID;
    String name;
    String category;
    BigDecimal price;
    public Product(int productID, String name, String category, BigDecimal price) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.price = price;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }


}
