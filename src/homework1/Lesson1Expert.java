package homework1;

public class Lesson1Expert {
    public static void main(String[] args) {

//    String data = "<client>(Какие то данные)<data>7999211463</data></client>";
//    String data = "<client>(Какие то данные)<data>Иванов Иван Иванович;79991113344</data></client>";
        String data = "<client>(Какие то данные)<data>test@gmailx.com;Иванов Иван Иванович;79991113344</data></client>";
//    String data = "<client>(Какие то данные)<data>79991113344;test@yandex.ru;Иванов Иван Иванович</data></client>";

        String masking = masking(data);
        System.out.println(masking);
    }

    public static String masking(String data) {
        String maskedData = data;

        int dataTagStartIndex = maskedData.lastIndexOf("<data>") + 5;

        int dataTagEndIndex = maskedData.lastIndexOf("</data>") + 1;

        String mainSubstring = maskedData.substring(dataTagStartIndex, dataTagEndIndex);

        String divider = ";";

        String[] fields = mainSubstring.split(divider);
        for (String field :
                fields) {
            if (field.contains("@")) {
                String tempSubstring = mainSubstring.substring(
                        mainSubstring.indexOf("@") - 1,
                        (mainSubstring.indexOf(".", mainSubstring.indexOf("@")))
                );
                String maskedEMail = "*@" + "*".repeat(tempSubstring.length() - 2);
                maskedData = maskedData.replaceAll(tempSubstring, maskedEMail);
            } else if (field.contains("7")) {
                String tempSubstring = mainSubstring.substring(
                        mainSubstring.indexOf("7"), (mainSubstring.indexOf("7") + 11)
                );
                String maskedPhoneNumber = tempSubstring.substring(0, 4) + "***" + tempSubstring.substring(7, 11);
                maskedData = maskedData.replaceAll(tempSubstring, maskedPhoneNumber);
            } else {
                String surnameSubstring = field.substring(0, field.indexOf(" "));
                String maskedFullName = "";
                maskedFullName += surnameSubstring.charAt(0);
                maskedFullName += "*".repeat(surnameSubstring.length() - 2);
                maskedFullName += surnameSubstring.charAt(surnameSubstring.length() - 1);
                String firstNameSubstring = field.substring(field.indexOf(" "), field.lastIndexOf(" ") + 1);
                maskedFullName += firstNameSubstring;
                String patronymicSubstring = field.substring(field.lastIndexOf(" ") + 1);
                maskedFullName += patronymicSubstring.charAt(0) + ".";
                maskedData = maskedData.replaceAll(field, maskedFullName);
            }
        }
        return maskedData;
    }
}

