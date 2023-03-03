package me.nightletter.springmultilingual.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Locale;

@Getter
@RequiredArgsConstructor
public enum LanguageCode {

    KO(Locale.KOREAN),
    EN(Locale.ENGLISH),
    JA(Locale.JAPANESE),
    ZH(Locale.CHINESE);

    private final Locale locale;

    public static Locale matchedLocale(String languageParam) {
        LanguageCode matchedLanguageCode = Arrays.stream(LanguageCode.values())
                .filter(code -> code.locale.getLanguage().equals(languageParam.toLowerCase()))
                .findAny()
                .orElse(LanguageCode.KO);

        return matchedLanguageCode.locale;
    }
}
