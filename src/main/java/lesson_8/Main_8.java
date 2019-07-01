package lesson_8;

public class Main_8 {

    public static void main(String[] args) {
//        HashTable hashTable = new HashTableImpl(5);
        HashTable hashTable = new DoubleHashTableImpl(5);

        hashTable.put(new Item(1, "Orange"), 150);
        hashTable.put(new Item(77, "Banana"), 111);
        hashTable.put(new Item(60, "Apple"), 70);
        hashTable.put(new Item(21, "Papaya"), 212);
        hashTable.put(new Item(52, "Lemon"), 255);

        System.out.println("Size is " + hashTable.size());
        hashTable.display();

        System.out.println("Papaya cost is " + hashTable.get(new Item(21, "Papaya")));
        System.out.println("Banana cost is " + hashTable.get(new Item(77, "Banana")));

        hashTable.remove(new Item(21, "Papaya"));
        hashTable.remove(new Item(77, "Banana"));

        hashTable.display();
        System.out.println("Size is " + hashTable.size());
    }
}
