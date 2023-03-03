package me.nightletter.springmultilingual.utils;

import lombok.RequiredArgsConstructor;
import me.nightletter.springmultilingual.modules.product.domain.Product;
import me.nightletter.springmultilingual.modules.product.domain.ProductProperty;
import me.nightletter.springmultilingual.modules.product.repository.ProductPropertyRepository;
import me.nightletter.springmultilingual.modules.product.repository.ProductRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

import static me.nightletter.springmultilingual.modules.product.domain.ProductType.COFFEE;

@Component
@RequiredArgsConstructor
public class BulkInsert {

    private final ProductRepository productRepository;
    private final ProductPropertyRepository productPropertyRepository;

    @PostConstruct
    public void bulkInsertProduct() {
        Product savedProduct = productRepository.save(new Product(COFFEE));

        productPropertyRepository.saveAll(
                Arrays.asList(new ProductProperty(savedProduct, "KO", "바닐라라떼", "라떼"),
                        new ProductProperty(savedProduct, "EN", "Vanilla Latte", "Latte"),
                        new ProductProperty(savedProduct, "JA", "バニララテ", "ラテ"),
                        new ProductProperty(savedProduct, "ZH", "香草拿铁", "拿铁"))
        );
    }
}
