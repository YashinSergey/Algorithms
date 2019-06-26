package lesson_5.homeWork5.backpack;

import java.util.ArrayList;
import java.util.List;

public class Main_bp {
    public static void main(String[] args) {
        List<Things> stuff = new ArrayList<>();
        stuff.add(new Things("Книга", 1, 600));
        stuff.add(new Things("Бинокль", 2, 5000));
        stuff.add(new Things("Аптечка", 4, 1500));
        stuff.add(new Things("Ноутбук", 2, 40000));
        stuff.add(new Things("Котелок", 1, 500));

        Backpack backpack = new Backpack(5);
        backpack.calcBestSet(stuff);

        stuff = backpack.getBestSet();

        for (int i = 0; i < stuff.size(); i++) {
            System.out.println(stuff.get(i).getName() + " " + stuff.get(i).getCost());
        }

        System.out.println("Best cost is " + backpack.getBestCost());
        System.out.println("Count is " + backpack.count);
    }

}
