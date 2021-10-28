package com.shop.data.dto;

import com.shop.data.model.Currency;
import lombok.Data;

@Data
public class ProductDto {
    private String name;

    private  Double price;

    private Currency currency;

    private String details;

}
