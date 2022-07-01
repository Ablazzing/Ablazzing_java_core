package homework4.lesson7advanced;

import homework4.lesson7advanced.Task1.*;
import homework4.lesson7advanced.Task2.Brand;
import homework4.lesson7advanced.Task2.Store;
import homework4.lesson7advanced.Task2.Watch;
import homework4.lesson7advanced.Task2.Worker;

public class Lesson7Advanced {
    public static void main(String[] args) {


        //Продвинутый уровень
        //Задача №1
        //1. Создать следующую структуру из классов и интерфейсов:
        // дерево -> ель (имеет шишки, умеет пахнуть)
        // дерево -> сосна (имеет шишки, умеет пахнуть)
        // растение -> роза (умеет цвести, умеет пахнуть)
        // растение -> папоротник (умеет цвести)
        // Создать у каждого класса по объекту, распределить по массивам интерфейсов
        // И у каждого массива вызвать характерный метод
        //Ожидание:
        // ель : умееть пахнуть
        // роза: умееть пахнуть
        // роза: умеет цвести
        // папоротник: умеет цвести

        Plant[] plants = {new Rose(), new Fern()};
        for (Plant plant :
                plants) {
            plant.canSmell();
            plant.canBloom();
        }

        Tree[] trees = {new Pine(), new Spruce()};
        for (Tree tree :
                trees) {
            tree.canSmell();
            tree.hasPinecones();
        }


        //Задача №2
        //2. Создать следующую структуру из классов и интерфейсов
        // магазин (обладает работниками)
        // работник (обладает часами)
        // часы (умеют тикать, если сломаны выкидывают ошибку WatchBrokenError)
        // Бренд (обладает массивом магазинов)
        // Создать бренд, положить в него два магазина, в каждом магазине будет по работнику,
        // у каждого работника по часам. У одного работника часы сломаны, у второго нет.
        // После создания бренда, вытащить из него все часы и вызвать у всех часов метод тикать,
        // обработать ошибку сломанных часов.
        // Ожидание вывода на экран:
        // Часы тикают
        // Ошибка: Часы сломались.


//        Watch watch1 = new Watch(true);
//        Watch watch2 = new Watch(false);
//        Worker worker1 =  new Worker(watch1);
//        Worker worker2 =  new Worker(watch2);


        Store store1 = new Store(worker1);
        Store store2 = new Store(worker2);

        Store[] stores = {store1, store2};


        Brand brand = new Brand(stores);
        for (Store store :
                brand.getStores()) {

        }


    }
}
