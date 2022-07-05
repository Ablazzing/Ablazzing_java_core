package lesson9.task;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {
    private static final Random RANDOM = new Random(1);
    public static void main(String[] args) throws URISyntaxException, IOException {

        for (int i = 1; i < 1001; i++) {
            String path = "E:\\tutorial\\untitled\\data\\" + i + "_report.txt";
            FileWriter writer = new FileWriter(path);
            String header = "name;price;self_price;count;discount\n";
            writer.write(header);
            List<Report> reports = generateReport();
            for (Report report : reports) {
                writer.write(report.toString() + "\n");
            }
            writer.close();
        }
    }

    public static List<Report> generateReport() {
        String[] goods = {"cola", "cheese", "beer", "bread", "milk", "water", "tomato", "salt", "sugar", "malboro"};
        int[] prices = {100, 500, 100, 20, 50, 20, 180, 80, 70, 250};
        int[] selfPrices = {90, 400, 50, 25, 60, 15, 180, 40, 30, 175};
        ArrayList<Good> goodsList = new ArrayList<>();
        for (int i = 0; i < goods.length; i++) {
            goodsList.add(Good.of(goods[i], prices[i], selfPrices[i]));
        }

        ArrayList<Report> reports = new ArrayList<>();
        for (int i = 0; i < RANDOM.nextInt(100) + 1; i++) {
            Good good = goodsList.get(RANDOM.nextInt(goodsList.size()));
            Discount discount = Discount.values()[RANDOM.nextInt(Discount.values().length)];
            Report report = new Report(good, RANDOM.nextInt(10) + 1, discount);
            reports.add(report);
        }
        return reports;
    }
}
