package lesson_2;

import java.util.Arrays;

public class MyArrayImpl<E extends Object & Comparable<? super E>> implements MyArray<E> {

    private static final int INITIAL_CAPACITY = 16;

    protected E[] data;
    protected int size;

    public MyArrayImpl() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public MyArrayImpl(int initialCapacity) {
        this.data =(E[]) new Object[initialCapacity];
    }

    @Override // O(n)
    public void add(E value) {
        checkGrow();
        data[size++] = value;
    }

    protected void checkGrow() {
        if(size == data.length){
            data = grow();
        }
    }

    private E[] grow() {
        return Arrays.copyOf(data, data.length * 2);
    }

    @Override // O(1)
    public E get(int index) {
        checkedIndex(index);
        return data[index];
    }

    private void checkedIndex(int index) {
        if(index < 0 || index >= size){
            throw new InvalidArrayStateException(index, size);
        }
    }

    @Override // O(n)
    public boolean remove(E value) {
        int index = indexOf(value);
        if(index == -1){
            return false;
        }

        for (int i = index; i < size -1; i++) {
            data[i] = data[i + 1];
        }
        data[size -1] = null;
        size--;
        return true;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(value)){
                return i;
            }
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
        System.out.println("------");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        System.out.println("------");
    }

    @Override // O(n^2)
    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if(data[j].compareTo(data[j + 1]) > 0 ){
                    swap(j, j + 1);
                }
            }
        }
    }

    @Override //O(n^2)
    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if(data[j].compareTo(data[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    @Override //O(n^2)
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            E temp = data[i];
            int in = i;
            while (in > 0 && data[in - 1].compareTo(temp) >= 0){
                data[in] = data[in - 1];
                in--;
            }
            data[in] = temp;
        }
    }

    private void swap(int index_1, int index_2) {
        E temporary = data[index_1];
        data[index_1] = data[index_2];
        data[index_2] = temporary;
    }
}
