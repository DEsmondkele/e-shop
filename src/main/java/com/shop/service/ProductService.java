package shop.service;

import shop.data.model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);

    List<Product> findAll();
     Product findBId(Long id);
     void deleteById(Long id);
}
