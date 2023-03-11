package me.nightletter.springmultilingual.modules.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.nightletter.springmultilingual.modules.product.dto.ProductDto;
import me.nightletter.springmultilingual.modules.product.repository.ProductPropertyRepository;
import me.nightletter.springmultilingual.utils.UserLocaleUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductPropertyRepository productPropertyRepository;

    public List<ProductDto> findAll(HttpServletRequest httpServletRequest) {
        String locale = UserLocaleUtil.getCookieLocale(httpServletRequest);
        List<ProductDto> result = new ArrayList<>();

        productPropertyRepository.findAll(locale)
                .forEach(product -> result.add(new ProductDto(product)));

        return result;
    }
}



