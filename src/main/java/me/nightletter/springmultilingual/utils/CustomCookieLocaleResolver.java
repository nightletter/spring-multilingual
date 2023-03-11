package me.nightletter.springmultilingual.utils;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class CustomCookieLocaleResolver extends CookieLocaleResolver {

    @Override
    protected Locale determineDefaultLocale(HttpServletRequest httpServletRequest) {

        if (getDefaultLocale() == null) {

            if (LocaleContextHolder.getLocale() != null) {
                setDefaultLocale(LocaleContextHolder.getLocale());
            } else {
                setDefaultLocale(httpServletRequest.getLocale());
            }

        }

        return super.determineDefaultLocale(httpServletRequest);
    }
}

