package lesson_8.homeWork;

import lesson_8.HashTable;
import lesson_8.Item;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyHashTableImpl implements HashTable {

   private static class Entry {

        private Item key;
        public Map<String, Integer> itemMap;
        Entry(Item key, HashMap<String, Integer> map) {
            this.key = key;
            itemMap = map;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", itemMap=" + itemMap +
                    '}';
        }
    }


    private Entry[] data;
    private int size;
    private int maxSize;

    public MyHashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        this.data = new Entry[maxSize * 2];
    }

    private int hashFunc(Item key){
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(Item item, Integer cost) {
        if (size == maxSize) {
            return false;
        }

        int count = 0;

        int index = hashFunc(item);
        while (data[index] != null) {
            if (data[index].key.equals(item)) {
                data[index].itemMap.put(item.getName(), cost);
                return true;
            }
            if (count >= data.length) {
                return false;
            }
            count++;
            index += getStep(item);
            index %= data.length;
        }

//        data[index] = new Entry(item, data[index].itemMap.put(item.getName(), cost));
        size++;

        return true;
    }

    protected int getStep(Item item) {
        return 1;
    }

    @Override
    public Integer get(Item item) {
        int index = indexOf(item);
        return index != -1 ? data[index].itemMap.get(item) : null;
    }

    @Override
    public boolean remove(Item item) {
        int index = indexOf(item);
        if (index != -1) {
            data[index] = null;
            size--;
            return true;
        }
        return false;
    }

    private int indexOf(Item item) {
        int index = hashFunc(item);
        int count = 0;
        while (data[index] != null && count <= data.length) {
            Entry entry = data[index];
            if (entry.key.equals(item)) {
                return index;
            }
            index += getStep(item);
            index %= data.length;
            count++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].itemMap.size(); j++) {
                System.out.printf("%d = [%s]%n", i, data[i].itemMap.values()); // ????
            }
        }
        System.out.println("----------");
    }
}
