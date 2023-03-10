package me.nightletter.springmultilingual.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.nightletter.springmultilingual.utils.CustomCookieLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class WebConfigurer implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        CustomCookieLocaleResolver resolver = new CustomCookieLocaleResolver();
        resolver.setCookieName("userLocale");
        resolver.setCookiePath("/");
        resolver.setCookieMaxAge(Integer.MAX_VALUE);
        resolver.setCookieHttpOnly(true);

        return resolver;
    }
}

