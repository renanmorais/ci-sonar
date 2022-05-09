package com.cisonar.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorEmail {
    private ValidadorEmail() {
    }

    private static final String EMAIL_PATTERN = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE).toString();

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

    public static boolean isEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
