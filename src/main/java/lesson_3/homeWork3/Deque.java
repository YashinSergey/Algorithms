package lesson_3.homeWork3;

import lesson_3.queue.Queue;

public interface Deque<E> extends Queue<E> {


    boolean insertLast(E value);
    boolean insertFirst(E value);



    E removeLast();
    E removeFirst();

    E getFirst();
    E getLast();


}
