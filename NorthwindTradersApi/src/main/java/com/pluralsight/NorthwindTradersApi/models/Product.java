package com.pluralsight.NorthwindTradersApi.models;

import java.math.BigDecimal;

public record Product(int productId, String productName, int categoryId, BigDecimal unitPrice) {


}
