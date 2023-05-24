package ru.intensive.week04;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExExamples {

    public static void main(String[] args) {
        System.out.println("1. Проверить что строка состоит из буквенно-числовых символов " +
                "и знаков подчеркивания(язык английский)");
        System.out.println("123_abc");
        System.out.println(checkCharDigitUnderscores("123_abc"));
        System.out.println("123$abc");
        System.out.println(checkCharDigitUnderscores("123$abc"));
        System.out.println(System.lineSeparator());


        System.out.println("2. Проверить что строка состоит из английских букв в нижнем регистре," +
                "соединенных подчеркиванием примеры допустимых записей:");
        System.out.println("java_exercises");
        System.out.println(checkLowRegCharUnderscoreCon("java_exercises"));
        System.out.println("java_exercises_double");
        System.out.println(checkLowRegCharUnderscoreCon("java_exercises_double"));
        System.out.println("privet_");
        System.out.println(checkLowRegCharUnderscoreCon("privet_"));
        System.out.println("privet_privet_");
        System.out.println(checkLowRegCharUnderscoreCon("privet_privet_"));
        System.out.println(System.lineSeparator());


        System.out.println("3. Проверить что строка содержит букву g, но при этом она не является началом," +
                " или концом ни одного из слов в строке");
        System.out.println("stay good");
        System.out.println(checkGinWordNotInStartOrEnd("stay good"));
        System.out.println("werwer");
        System.out.println(checkGinWordNotInStartOrEnd("werwer"));
        System.out.println("gerw");
        System.out.println(checkGinWordNotInStartOrEnd("gerw"));
        System.out.println("werg");
        System.out.println(checkGinWordNotInStartOrEnd("werg"));
        System.out.println("sage");
        System.out.println(checkGinWordNotInStartOrEnd("sage"));
        System.out.println(System.lineSeparator());


        System.out.println("4. Написать программу извлекающую из текста все html - теги");
        System.out.println(getHTMLTags("<p>Hello <code>Everybody</code> nice to meet u Hope to see u soon.</p>"));
        System.out.println(getHTMLTags("<p>Hello <code>Everybody</code> nice to meet u Hope to see u soon.</p>test<*p12> Test<p11$%*3> Test <p11&3>"));
        System.out.println(System.lineSeparator());

        System.out.println("5. Написать программу проверяющую, является ли входная строка email адресом");
        System.out.println("test@test.ru");
        System.out.println(isEmail("test@test.ru"));
        System.out.println("test@test_test.ru");
        System.out.println(isEmail("test@test_test.ru"));
        System.out.println(System.lineSeparator());

        System.out.println("6. Напишите программу, которая принимает на вход число и выводит его в денежном формате.");
        System.out.println("1234567.89");
        System.out.println(doFormat(1234567.89));
        System.out.println(System.lineSeparator());
    }

    public static boolean checkCharDigitUnderscores(String string) {
        return string != null && string.matches("^[\\w]+$");
    }

    public static boolean checkLowRegCharUnderscoreCon(String string) {
        return string != null && string.matches("([a-z]+_[a-z]+)+");
    }

    public static boolean checkGinWordNotInStartOrEnd(String string) {
        String pattern = "\\B[gG]\\B";
        return Pattern.compile(pattern).matcher(string).find();
    }

    public static List<String> getHTMLTags(String string) {
        List<String> rsl = new ArrayList<>();
        String pattern = "(</?[a-z]*>|</?[A-Z]*>)";
        Matcher matcher = Pattern.compile(pattern).matcher(string);
        while(matcher.find()) {
            rsl.add(matcher.group());
        }
        return rsl;
    }

    public static boolean isEmail(String string) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static String doFormat(double value) {
        Locale locale = Locale.US;
        String pattern = "$%,.2f";
        return String.format(locale, pattern, value);
    }
}