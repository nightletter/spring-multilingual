package me.nightletter.springmultilingual.modules.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.nightletter.springmultilingual.modules.product.domain.ProductProperty;
import me.nightletter.springmultilingual.modules.product.dto.ProductDto;
import me.nightletter.springmultilingual.modules.product.repository.ProductPropertyRepository;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductPropertyRepository productPropertyRepository;

    public List<ProductDto> findAll(HttpServletRequest httpServletRequest) {
        String locale = getCookieLocale(httpServletRequest);

        List<ProductProperty> data = productPropertyRepository.findAll(locale);
        List<ProductDto> result = new ArrayList<>();

        data.forEach(o -> {
            result.add(new ProductDto(o));
        });

        return result;
    }

    // TODO: 2023/03/10 이거 테스트하기
    private String getCookieLocale(HttpServletRequest httpServletRequest) {

        String defaultUserLocale = LocaleContextHolder.getLocale().getLanguage();

        if (httpServletRequest.getCookies() != null) {

            String extractUserLocale = Arrays.stream(httpServletRequest.getCookies())
                    .filter(cookie -> cookie.getName().equals("userLocale"))
                    .map(cookie -> cookie.getValue())
                    .findAny()
                    .orElse(defaultUserLocale);

            return extractUserLocale.toUpperCase();
        }

        return defaultUserLocale.toUpperCase();
    }
}
