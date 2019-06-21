package lesson_4.twoSideLinkedList.lilnkedQueue;

import lesson_3.queue.Queue;
import lesson_4.twoSideLinkedList.TwoSideMyLinkedList;
import lesson_4.twoSideLinkedList.TwoSideMyLinkedListImpl;

public class LinkedQueueImple<E> implements Queue<E> {

    private TwoSideMyLinkedList<E> data = new TwoSideMyLinkedListImpl<>();

    @Override
    public boolean insertLast(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E removeFirst() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirstElement();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
