package lesson1.Expert;

public class HomeworkExpert {
    private static final String OPEN_TAG = "<data>";
    private static final String CLOSE_TAG = "</data>";
    private static final String DELIMITER = ";";
    private static final String EMAIL_SYMBOL = "@";
    private static final String DOT_SYMBOL = ".";
    private static final String MASKING_SYMBOL = "*";
    private static final String PHONE_NUMBER_START = "7";
    private static final String FULL_NAME_DELIMITER = " ";

    public static void main(String[] args) {
//        String before = "<client>(Какие то данные)<data>79991113344;test@yandex.ru;Иванов Иван Иванович</data></client>";
//        String before = "<client>(Какие то данные)<data></data></client>";
        String before = "<client>(Какие то данные)<data>Иванов Иван Иванович;79991113344</data></client>";
        String after = masking(before);
        System.out.println(after);
    }

    public static String masking(String text) {
        int indexStartData = text.indexOf(OPEN_TAG) + OPEN_TAG.length();
        int indexEndData = text.indexOf(CLOSE_TAG, indexStartData);

        StringBuilder resultBuilder = new StringBuilder();

        if ((indexEndData - indexStartData) > 0) {
            String clientData = text.substring(indexStartData, indexEndData);
            for (String field : clientData.split(DELIMITER)) {
                if (field.contains(EMAIL_SYMBOL)) {
                    maskingEmail(field, resultBuilder);
                }
                else if (field.startsWith(PHONE_NUMBER_START) && field.length() == 11) {
                    maskingPhoneNumber(field, resultBuilder);
                }
                else {
                    maskingFullName(field, resultBuilder);
                }
            }
            String result = resultBuilder.toString();
            return result.substring(0, result.length() - 1);
        }

        return text;
    }

    public static void maskingFullName(String text, StringBuilder resultBuilder) {
        int secondNameStartIndex = text.indexOf(FULL_NAME_DELIMITER) + 1;
        int fatherNameStartIndex = text.indexOf(FULL_NAME_DELIMITER, secondNameStartIndex) + 1;
        String maskingFio = new StringBuilder()
                .append(text, 0, 1)
                .append(MASKING_SYMBOL.repeat(4))
                .append(text, 5, secondNameStartIndex - 1)
                .append(FULL_NAME_DELIMITER)
                .append(text, secondNameStartIndex, fatherNameStartIndex)
                .append(text.charAt(fatherNameStartIndex))
                .append(DOT_SYMBOL)
                .append(DELIMITER)
                .toString();
        resultBuilder.append(maskingFio);
    }

    public static void maskingPhoneNumber(String text, StringBuilder resultBuilder) {
        String maskedPhone = new StringBuilder()
                .append(text, 0, 4)
                .append(MASKING_SYMBOL.repeat(3))
                .append(text.substring(7))
                .append(DELIMITER)
                .toString();
        resultBuilder.append(maskedPhone);
    }

    public static void maskingEmail(String text, StringBuilder resultBuilder) {
        int emailSymbolIndex = text.indexOf(EMAIL_SYMBOL);
        int endDomainIndex = text.indexOf(DOT_SYMBOL, emailSymbolIndex);
        String maskedEmail = new StringBuilder()
                .append(text, 0, emailSymbolIndex - 1)
                .append(MASKING_SYMBOL)
                .append(EMAIL_SYMBOL)
                .append(MASKING_SYMBOL.repeat(endDomainIndex - emailSymbolIndex))
                .append(text.substring(endDomainIndex))
                .append(DELIMITER)
                .toString();
        resultBuilder.append(maskedEmail);
    }
}
