package lesson_5.homeWork5.backpack;

public class Things {

    private String name;
    int weight;
    int cost;

    public Things(String name, int weight, int cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Things thing = (Things) obj;

        if ( weight != thing.weight) return false;
        if ( cost != thing.cost ) return false;
        return name != null ? name.equals(thing.name) : thing.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + weight;
        result = 31 * result + cost;
        return result;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }
}
