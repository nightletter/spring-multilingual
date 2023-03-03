package me.nightletter.springmultilingual.modules.product.repository;

import me.nightletter.springmultilingual.modules.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p inner join fetch p.productProperties pp where pp.language =:userLocale")
    List<Product> findAll(@Param("userLocale") String userLocale);
}
