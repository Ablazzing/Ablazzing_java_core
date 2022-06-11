package lesson1.Expert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeworkExpertRegex {
    public static void main(String[] args) {
        String before = "<client>(Какие то данные)<data>Иванов Иван Иванович;79991113344;test@yandex.ru</data></client>";
        //String before = "<client>(Какие то данные)<data></data></client>";
        //String before = "<client>(Какие то данные)<data>Иванов Иван Иванович;79991113344</data></client>";
        String after = masking(before);
        System.out.println(after);
    }

    public static String masking(String text) {
        String data = findFirstGroup(text, "<data>(.+)</data>");
        if (data != null) {
            String maskedData = data;
            maskedData = replaceInFirstGroup(maskedData, MaskingTypes.PHONE.getPattern(), MaskingTypes.PHONE.getReplacement(), false);
            maskedData = replaceInFirstGroup(maskedData, "@(\\w+)", "*", false);
            maskedData = replaceInFirstGroup(maskedData, "^\\p{L}(\\p{L}+)\\p{L}", "*", false);
            maskedData = replaceInFirstGroup(maskedData, "\\p{L}+ \\p{L}+ \\p{L}(\\p{L}+)", ".", true);
            return text.replaceAll(data, maskedData);
        }
        return text;
    }

    public static String findFirstGroup(String text, String pattern) {
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return text;
    }

    public static String replaceInFirstGroup(String text,
                                             String pattern,
                                             String replacement,
                                             boolean onlyOneReplacement) {
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        StringBuilder stringBuilder = new StringBuilder(text);
        if (matcher.find()) {
            int startIndex = matcher.start(1);
            int endIndex = matcher.end(1);
            String forReplace = onlyOneReplacement ? replacement : replacement.repeat(endIndex - startIndex);
            return stringBuilder.replace(startIndex, endIndex, forReplace).toString();
        }
        return text;
    }
}
