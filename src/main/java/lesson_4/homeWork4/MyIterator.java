package lesson_4.homeWork4;

import java.util.Iterator;

public interface MyIterator<E> extends Iterator<E> {

    void reset();

    void insertBefore(E value);

    void insertAfter(E value);
}
