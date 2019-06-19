package lesson_3.homeWork3;

import lesson_3.queue.QueueImpl;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean insertLast(E value) {
        if (isFull()){
            return false;
        }

        if (tail == lastIndex()) {
            tail = DEFAULT_TAIL;
        }
        data[++tail] = value;
        size++;

        return true;
    }

    @Override
    public boolean insertFirst(E value) {
        if (isFull()){
            return false;
        }
        if (head == 0) {
            head = lastIndex();
        }

        data[--head] = value;
        size++;

        return true;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (tail < 0) {
            tail = lastIndex();
        }

        E removedValue = data[tail];
        data[tail--] = null;
        size--;

        return removedValue;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        if (head == data.length) {
            head = DEFAULT_HEAD;
        }

        E removedValue = data[head];
        data[head++] = null;
        size--;

        return removedValue;
    }

    @Override
    public E getFirst() {
        return data[head];
    }

    @Override
    public E getLast() {
        return data[tail];
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new DequeImpl<>(10);

        deque.insertLast(4);
        deque.insertFirst(6);
        deque.insertLast(3);
        deque.insertLast(2);
        deque.insertLast(1);
        deque.insertFirst(8);
        deque.insertFirst(9);
        deque.insertFirst(10);

        while (!deque.isEmpty()) {
            System.out.println(deque.removeLast());
        }
    }
}
