package com.shop.data.model;

public enum Currency {
    NGN("Naira"), USD("Dollar"), SRC("Singapore Dollar"), EUR("Euro"), GBP("British Pounds"), FRC("Franc"), GHC("Ghana Cedis");

    private String name;

    Currency(String s) {
        this.name = s;
    }

    private String get() {
        return this.name;
    }
}
