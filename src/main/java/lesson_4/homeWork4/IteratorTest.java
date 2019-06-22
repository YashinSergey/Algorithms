package lesson_4.homeWork4;

import lesson_4.simpleLinkedList.MyLinkedList;
import lesson_4.simpleLinkedList.MySimpleLinkedListImpl;

public class IteratorTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MySimpleLinkedListImpl<>();
        list.insertFirst(8);
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(9);

        displayAll(list);

        System.out.println("-----------");

        MyIterator<Integer> iterator = (MyIterator<Integer>) list.iterator();
        iterator.reset();
        iterator.insertAfter(4);
        iterator.next();
        iterator.remove();
        iterator.insertBefore(9);

        displayAll(list);
        System.out.println("-----------");

        iterator = (MyIterator<Integer>) list.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
            displayAll(list);
            System.out.println("-----------");
        }

    }

    private static void displayAll(MyLinkedList<Integer> list) {
        for (Integer value : list) {
            System.out.println(value);
        }
    }
}
