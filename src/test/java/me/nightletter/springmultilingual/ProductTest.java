package me.nightletter.springmultilingual;

import me.nightletter.springmultilingual.modules.product.repository.ProductPropertyRepository;
import me.nightletter.springmultilingual.modules.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductPropertyRepository productPropertyRepository;

    @Test
    void create() {
    }
}
