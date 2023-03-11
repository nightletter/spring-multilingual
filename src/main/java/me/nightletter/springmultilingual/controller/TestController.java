package me.nightletter.springmultilingual.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.nightletter.springmultilingual.modules.product.service.ProductService;
import me.nightletter.springmultilingual.utils.UserLocaleUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TestController {

    private final ProductService productService;

    @PutMapping("change-locale")
    public String setUserLocale(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse) {
        UserLocaleUtil.changeUserLocale(httpServletRequest, httpServletResponse);
        return "redirect:/";
    }

    @GetMapping
    public String index(Model model, HttpServletRequest httpServletRequest) {
        model.addAttribute("products", productService.findAll(httpServletRequest));
        return "index";
    }
}
