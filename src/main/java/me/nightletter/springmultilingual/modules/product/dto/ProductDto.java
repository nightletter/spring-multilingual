package me.nightletter.springmultilingual.modules.product.dto;

import lombok.Getter;
import me.nightletter.springmultilingual.modules.product.domain.ProductProperty;
import me.nightletter.springmultilingual.modules.product.domain.ProductType;

import java.io.Serializable;

@Getter
public class ProductDto implements Serializable {

    private Long productSeq;
    private ProductType productType;

    private Long productPropertySeq;
    private String productName;
    private String productDesc;

    public ProductDto(ProductProperty productProperty) {
        this.productSeq = productProperty.getProduct().getProductSeq();
        this.productType = productProperty.getProduct().getProductType();

        this.productPropertySeq = productProperty.getProductPropertySeq();
        this.productName = productProperty.getName();
        this.productDesc = productProperty.getDescription();
    }
}
