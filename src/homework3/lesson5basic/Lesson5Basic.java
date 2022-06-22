package homework3.lesson5basic;

import java.io.*;

public class Lesson5Basic {
    public static void zadacha1basic() {
        Toyota toyota = new Toyota();
        toyota.canPlayMusic();
        toyota.canMove();
        toyota.canBeep();
        Lada lada = new Lada();
        lada.canBreak();
        lada.canMove();
        lada.canBeep();
    }

    public static void zadacha2basic() throws IOException {
        FileReader fileReader = new FileReader("resource/my_first_file.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String resultString = "";
        while (bufferedReader.ready()) {
            String tempString = bufferedReader.readLine();
            resultString += tempString + " ";
        }
        System.out.println(resultString.trim());

    }

    public static void zadacha3basic() throws IOException {
        FinancialRecord financialRecord = new FinancialRecord("500", "300");
        FileWriter fileWriter = new FileWriter("resource/report.txt");
        fileWriter.write(
                "доходы = " + financialRecord.getIncomes() + ", расходы = " + financialRecord.getOutcomes()
        );
        fileWriter.close();
    }

}
