package lesson_3.queue;

public interface Queue<E> {

    boolean insertLast(E value);

    E removeFirst();

    E peek();

    int size();

    boolean isEmpty();
    boolean isFull();

}
