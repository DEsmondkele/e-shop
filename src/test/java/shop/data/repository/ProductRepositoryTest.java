package shop.data.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import shop.data.model.Currency;
import shop.data.model.Product;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
@SpringBootTest
@Slf4j
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepositoryImpl;

    @BeforeEach
    void setUp() {
    }
    @Test
   public void createProductTest(){
        Product product = new Product();
        product.setName("Luxury Sofa");
        product.setPrice(400D);
        product.setCurrency(Currency.NGN);
        product.setDetails("This is a very good chair!");

        assertThat(product).isNotNull();
        assertThat(product.getId()).isNull();
        log.info("product before saving->{}",product);
        productRepositoryImpl.save(product);
        assertThat(product.getId()).isNotNull();
        log.info("product after saving->{}",product);

   }
 @Test
 @Transactional
 public void whenFindAllIsCalledThenProductListIsReturned(){
        List<Product> products = productRepositoryImpl.findAll();
        assertThat(products).hasSize(4);
        log.info("product returned from database -->{}", products);
 }


   }
