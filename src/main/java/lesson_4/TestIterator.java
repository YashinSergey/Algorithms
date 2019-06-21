package lesson_4;

import lesson_4.simpleLinkedList.MyLinkedList;
import lesson_4.simpleLinkedList.MySimpleLinkedListImpl;

import java.util.Iterator;
import java.util.LinkedList;

public class TestIterator {

    public static void main(String[] args) {
        int[] array = {1,2,3};

        System.out.println("----------");
        for (int i = 0; hasNext(array, i); i++) {
            int value = next(array, i);
            System.out.println(value);
        }
        System.out.println("----------");

        for (int value : array) {
            System.out.println(value);
        }
        System.out.println("----------");

        MyLinkedList<Integer> myLinkedList = new MySimpleLinkedListImpl<>();
        myLinkedList.insertFirst(1);
        myLinkedList.insertFirst(2);
        myLinkedList.insertFirst(3);

        MyLinkedList.Entry current = myLinkedList.getFirst();
        while (current != null){
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println("----------");

        LinkedList<Integer> linkedListJdk = new LinkedList<>();
        linkedListJdk.add(1);
        linkedListJdk.add(2);
        linkedListJdk.add(3);

        for (Integer value : linkedListJdk) {
            System.out.println(value);
        }
        System.out.println("----------");

        Iterator<Integer> iterator = linkedListJdk.iterator();
        while (iterator.hasNext()){
            Integer value = iterator.next();
            System.out.println(value);
        }

    }

    private static int next(int[] array, int i) {
        return array[i];
    }

    private static boolean hasNext(int[] array, int i) {
        return i < array.length;
    }
}
