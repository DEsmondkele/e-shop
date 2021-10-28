package com.shop.web;

public class ProductDoesNotExistException extends Throwable {
    public ProductDoesNotExistException(String s) {
    super(s);
    }
}
