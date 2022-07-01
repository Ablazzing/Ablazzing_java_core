package lesson7.pro_task2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Shop> shops = new ArrayList<>();
        Brand brand = new Brand(shops);

        shops.add(new Shop(new Worker[]{new Worker(new Watch(true))}));
        shops.add(new Shop(new Worker[]{new Worker(new Watch(false))}));

        for (Shop shop: brand.shops) {
            for (Worker worker: shop.workers) {
                try {
                    if (worker.watch.isBroken()) {
                        throw new TickException("часы сломаны");
                    } else {
                        System.out.println("часы тикают");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        }
    }
}
