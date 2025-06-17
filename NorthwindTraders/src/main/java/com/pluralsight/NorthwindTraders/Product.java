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


    public String getCategory() {
        return category;
    }



    public String getName() {
        return name;
    }



    public int getProductID() {
        return productID;
    }


    @Override
    public String toString() {
        String formatter = "%-4s|%-25s|%-25s|%-11s";
        return String.format(formatter, productID, name, category, price);
    }


}
