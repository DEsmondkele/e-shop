package com.shop.service;

import com.shop.data.dto.ProductDto;
import com.shop.data.model.Product;
import com.shop.web.ProductDoesNotExistException;

import java.util.List;

public interface ProductService {
    Product save(Product product);

    List<Product> findAll();
     Product findById(Long id);
     void deleteById(Long id);
     Product updateProduct(Long id, ProductDto productDto) throws ProductDoesNotExistException;
//
//    Product patchProduct(Product product,Long id);
}
