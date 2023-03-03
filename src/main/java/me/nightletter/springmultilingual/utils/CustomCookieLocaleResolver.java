package me.nightletter.springmultilingual.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Slf4j
public class CustomCookieLocaleResolver extends CookieLocaleResolver {

    @Override
    protected Locale determineDefaultLocale(HttpServletRequest httpServletRequest) {

        if (this.getDefaultLocale() == null) {
            this.setDefaultLocale(Locale.KOREAN);
        }

        return super.determineDefaultLocale(httpServletRequest);
    }
}
