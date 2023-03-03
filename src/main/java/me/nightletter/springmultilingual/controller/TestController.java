package me.nightletter.springmultilingual.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.nightletter.springmultilingual.constants.LanguageCode;
import me.nightletter.springmultilingual.modules.product.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TestController {

    private final ProductService productService;

    @PutMapping("locale-change")
    public String setUserLocale(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                @RequestParam("locale") String locale) {
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(httpServletRequest);
        localeResolver.setLocale(httpServletRequest, httpServletResponse, LanguageCode.matchedLocale(locale));

        return "redirect:/";
    }

    @GetMapping
    public String index(HttpServletRequest httpServletRequest,
                        Model model) {

        model.addAttribute("products", productService.findAll(httpServletRequest));
        return "index";
    }
}
