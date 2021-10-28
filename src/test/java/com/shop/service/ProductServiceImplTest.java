package com.shop.service;

import com.shop.data.dto.ProductDto;
import com.shop.data.model.Product;
import com.shop.data.repository.ProductRepository;
import com.shop.web.ProductDoesNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@SpringBootTest
@Sql(scripts = {"/db/insert.sql"})
public class ProductServiceImplTest {
    @Autowired
    ProductService productServiceImpl;

    @Autowired
    ProductRepository productRepository;
    @Test
    void updateProductTest() throws ProductDoesNotExistException {
        Product product = productRepository.findById(110L).orElse(null);
        assertThat(product).isNotNull();
        assertThat(product.getName()).isEqualTo("luxury chair");

        ProductDto productDto = new ProductDto();
        productDto.setName("mexician chair");
        //call the service update method
        product= productServiceImpl.updateProduct(110L,productDto);
        assertThat(product.getName()).isEqualTo(productDto.getName());
        assertThat(product.getPrice()).isEqualTo(4500.0);

    }
}
