package me.nightletter.springmultilingual.modules.product.repository;

import me.nightletter.springmultilingual.modules.product.domain.ProductProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductPropertyRepository extends JpaRepository<ProductProperty, Long> {

    @Query("select pp from ProductProperty pp inner join fetch pp.product where pp.language =:userLocale")
    List<ProductProperty> findAll(@Param("userLocale") String userLocale);
}
