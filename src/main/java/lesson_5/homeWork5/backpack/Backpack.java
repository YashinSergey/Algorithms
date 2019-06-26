package lesson_5.homeWork5.backpack;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private int maxWeight;
    private int bestCost;
    private List<Things> bestSet = null;

    public int count;

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int calcWeight(List<Things> things){
        int sumWeight = 0;
        for (Things thing : things) {
            sumWeight += thing.weight;
        }
        return sumWeight;
    }

    public int calcCost(List<Things> things){
        int sumCost = 0;
        for (Things thing : things) {
            sumCost += thing.cost;
        }
        return sumCost;
    }

    public void bestSet(List<Things> things) {
        if ( bestSet == null ) {
            if ( calcWeight(things) <= maxWeight ) {
                bestSet = things;
                bestCost = calcCost(things);
            }
        } else {
            if ( calcWeight(things) <= maxWeight && calcCost(things) > bestCost) {
                bestSet = things;
                bestCost = calcCost(things);
            }
        }
    }

    public void calcBestSet(List<Things> things) {
        count++;
        if (things.size() > 0) {
            bestSet(things);
        }

        for (int i = 0; i < things.size(); i++) {
            List<Things> list = new ArrayList<>(things);
            list.remove(i);
            calcBestSet(list);
        }
    }

    public List<Things> getBestSet() {
        return bestSet;
    }

    public int getBestCost() {
        return bestCost;
    }
}
