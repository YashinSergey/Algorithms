package lesson_3.homeWork3;

import lesson_3.queue.Queue;

public interface Deque<E> extends Queue<E> {


    boolean insertLast(E value);
    boolean insertFirst(E value);



    public E removeLast();
    public E removeFirst();

}
