package me.nightletter.springmultilingual.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Slf4j
public class CustomCookieLocaleResolver extends CookieLocaleResolver {

    @Override
    protected Locale determineDefaultLocale(HttpServletRequest httpServletRequest) {

        if (super.getDefaultLocale() == null) {
            setDefaultLocale(Locale.KOREA);
        }

        return super.determineDefaultLocale(httpServletRequest);
    }
}
