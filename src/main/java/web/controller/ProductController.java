package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.data.model.Product;
import shop.service.ProductService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {

    ProductService productServiceImpl;
    @Autowired
    public  ProductController(ProductService productServiceImpl){
        this.productServiceImpl = productServiceImpl;
    }

    @GetMapping("/get-product")
    public List<Product> getAll(){
        return  productServiceImpl.findAll();

    }
    @PostMapping("/save-product")
    public  Product save(@RequestBody Product product){
      log.info("product request --> {}",product);
      return productServiceImpl.save(product);
    }
}
