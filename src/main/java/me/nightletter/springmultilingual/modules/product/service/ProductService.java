package me.nightletter.springmultilingual.modules.product.service;

import lombok.RequiredArgsConstructor;
import me.nightletter.springmultilingual.modules.product.domain.ProductProperty;
import me.nightletter.springmultilingual.modules.product.dto.ProductDto;
import me.nightletter.springmultilingual.modules.product.repository.ProductPropertyRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductPropertyRepository productPropertyRepository;

    public List<ProductDto> findAll(HttpServletRequest httpServletRequest) {

        String userLocale = checkCustomerLocaleCookie(httpServletRequest);
        List<ProductProperty> data = productPropertyRepository.findAll(userLocale);
        List<ProductDto> result = new ArrayList<>();

        data.forEach(o -> {
            result.add(new ProductDto(o));
        });

        return result;
    }

    private String checkCustomerLocaleCookie(HttpServletRequest httpServletRequest) {
        return Arrays.stream(httpServletRequest.getCookies())
                .filter(cookie -> cookie.getName().equals("userLocale"))
                .findAny()
                .orElse(new Cookie("userLocale", Locale.KOREAN.getLanguage()))
                .getValue()
                .toUpperCase();
    }
}
