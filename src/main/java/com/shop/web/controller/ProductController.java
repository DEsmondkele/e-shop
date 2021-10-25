package com.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.shop.data.model.Product;
import com.shop.service.ProductService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productServiceImpl;

    @Autowired
    public  ProductController(ProductService productServiceImpl){
        this.productServiceImpl = productServiceImpl;
    }

    @GetMapping("/")
    public List<Product> findAll(){
        return  productServiceImpl.findAll();

    }
    @PostMapping("/")
    public  Product save(@RequestBody Product product){
      log.info("product request -> {}",product);
      return productServiceImpl.save(product);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productServiceImpl.deleteById(id);
        return  ResponseEntity.noContent().build();
    }
}
