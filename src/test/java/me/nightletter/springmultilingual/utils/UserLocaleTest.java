package me.nightletter.springmultilingual.utils;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Set;

public class UserLocaleTest {

    @Test
    void locale() {
        final Set<Locale> SUPPORT_LANGUAGE_SET = Set.of(Locale.ENGLISH, Locale.KOREAN, Locale.CHINESE, Locale.JAPANESE);
        final Set<Locale> SUPPORT_LOCALE_SET = Set.of(Locale.KOREA, Locale.US, Locale.CHINA, Locale.JAPAN);
    }
}
