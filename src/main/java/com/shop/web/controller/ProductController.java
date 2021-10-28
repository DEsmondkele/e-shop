package com.shop.web.controller;

import com.shop.data.dto.ProductDto;
import com.shop.web.ProductDoesNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.shop.data.model.Product;
import com.shop.service.ProductService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(method = {RequestMethod.POST})
public class ProductController {

    @Autowired
    ProductService productServiceImpl;

    @Autowired
    public  ProductController(ProductService productServiceImpl){

        this.productServiceImpl = productServiceImpl;
    }

    @RequestMapping(value="/find", method=RequestMethod.GET)
    public List<Product> findAll(){
        return  productServiceImpl.findAll();

    }
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public  Product save(@RequestBody Product product){
      log.info("product request -> {}",product);
      return productServiceImpl.save(product);
    }
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productServiceImpl.deleteById(id);
        return  ResponseEntity.noContent().build();
    }
    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public Product findProductById(@PathVariable Long id){
        return productServiceImpl.findById(id);
    }

    @RequestMapping(value="/update/{id}", method=RequestMethod.PATCH)
    public  ResponseEntity<?> updateProduct(@PathVariable Long id,
                                            @RequestBody ProductDto productDto) {
        log.info("Request id -->{}",id);

        Product product;
        try {
            product = productServiceImpl.updateProduct(id, productDto);
        } catch (NullPointerException | ProductDoesNotExistException ex){
            log.info(ex.getMessage());
            return  ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok().body(product);
    }
}
