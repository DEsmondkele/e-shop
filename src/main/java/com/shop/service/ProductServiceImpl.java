package com.shop.service;

import com.shop.data.dto.ProductDto;
import com.shop.data.model.Product;
import com.shop.data.repository.ProductRepository;
import com.shop.service.mapper.ProductMapper;
import com.shop.web.ProductDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements  ProductService{

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductMapper productMapper;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {

        productRepository.deleteById(id);
    }

//    @Override
//    public Product patchProduct(Product product,Long id) {
//
//        if (productRepository.findById(id).isPresent()) {
//           Product existingProduct = productRepository.findById(id).get();
//            existingProduct.setName(product.getName());
//            existingProduct.setPrice(product.getPrice());
//            existingProduct.setCurrency(product.getCurrency());
//        return productRepository.save(existingProduct);}
//        else {
//            return  null;
//        }
//        }
//    public void productName(String name){
//        Product product = new Product();
//        if(product.getName() != null)
//          product.setName(name);
//
//    }
//    public void productCurrency(Currency currency){
//        Product product = new Product();
//        if (product.getCurrency() != null)
//            product.setCurrency(currency);
//    }
//    public void productPrice(Double price){
//        Product product = new Product();
//        if (product.getPrice() != 0.0)
//            product.setPrice(price);
//    }

    @Override
    public  Product updateProduct(Long id, ProductDto productDto) throws ProductDoesNotExistException {
        if(productDto == null){
            throw new NullPointerException("product Dto cannot be null");
        }
        Optional<Product> result = productRepository.findById(id);
        if (result.isPresent()){
    Product product = result.get();
    productMapper.mapDtoToProduct(productDto, product);
    return  productRepository.save(product);
        }
      else{
          throw new ProductDoesNotExistException
                  ("product with id " + id + "does not exist");
        }
    }



}
