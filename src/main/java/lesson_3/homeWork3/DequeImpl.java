package lesson_3.homeWork3;

import lesson_3.queue.QueueImpl;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {


    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean insertFirst(E value) {
        if (isFull()) {
            return false;
        }

        if ( head - 1 < 0) {
            head = data.length;
        }

        data[--head] = value;
        size++;
        return true;
    }

    @Override
    public boolean insertLast(E value) {
        return super.insertLast(value);
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return  null;
        }
        if (tail < 0)
            tail = data.length - 1;

        size--;
        return data[tail--];
    }

    @Override
    public E removeFirst() {
        return super.removeFirst();
    }

    @Override
    public E getFirst() {
        return data[head];
    }

    @Override
    public E getLast() {
        return data[tail];
    }
}
