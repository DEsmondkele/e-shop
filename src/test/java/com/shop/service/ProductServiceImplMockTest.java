package com.shop.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.shop.data.model.Product;
import com.shop.data.repository.ProductRepository;

import static org.mockito.Mockito.*;

class ProductServiceImplMockTest {
    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productServiceImpl;
    @BeforeEach
    void setUp(){
       productServiceImpl = new  ProductServiceImpl();
        MockitoAnnotations.openMocks(this);
    }
@Test
    void saveProductMockTest(){
        Product product = new Product();
        when(productServiceImpl.save(product)).thenReturn(product);
        productServiceImpl.save(product);
        verify(productRepository,times(1)).save(product);

}

}