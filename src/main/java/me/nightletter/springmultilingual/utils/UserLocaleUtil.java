package me.nightletter.springmultilingual.utils;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;

public class UserLocaleUtil {

    private static final String LOCALE_PARAM_NAME = "locale";

    private static final String LOCALE_COOKIE_NAME = "userLocale";

    private static final Locale DEFAULT_LOCALE = Locale.KOREAN;
    private static final Set<Locale> SUPPORT_LOCALE_SET = Set.of(Locale.ENGLISH, Locale.KOREAN, Locale.CHINESE, Locale.JAPANESE);

    public static void changeUserLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String requestLocale = httpServletRequest.getParameter(LOCALE_PARAM_NAME);

        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(httpServletRequest);
        localeResolver.setLocale(httpServletRequest, httpServletResponse, matchedLocale(requestLocale));
    }


    public static String getCookieLocale(HttpServletRequest httpServletRequest) {

        String cookieUserLocale = DEFAULT_LOCALE.getLanguage();

        if (httpServletRequest.getCookies() != null) {

            String extractUserLocale = Arrays.stream(httpServletRequest.getCookies())
                    .filter(cookie -> cookie.getName().equals(LOCALE_COOKIE_NAME))
                    .map(cookie -> cookie.getValue())
                    .findAny()
                    .orElse(DEFAULT_LOCALE.getLanguage());

            return extractUserLocale;
        }

        return cookieUserLocale;
    }

    private static Locale matchedLocale(String userLocale) {
        Locale matchedLocale = SUPPORT_LOCALE_SET.stream()
                .filter(locale -> locale.getLanguage().equals(userLocale))
                .findAny()
                .orElse(DEFAULT_LOCALE);

        return matchedLocale;
    }
}
