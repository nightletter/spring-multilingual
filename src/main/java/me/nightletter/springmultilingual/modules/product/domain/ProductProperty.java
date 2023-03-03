package me.nightletter.springmultilingual.modules.product.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "product_property")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_property_seq")
    private Long productPropertySeq;

    private String language;

    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productSeq")
    private Product product;

    public ProductProperty(Product product, String language, String name, String description) {
        setProduct(product);
        this.language = language;
        this.name = name;
        this.description = description;
    }

    private void setProduct(Product product) {
        product.getProductProperties().add(this);
        this.product = product;
    }
}
