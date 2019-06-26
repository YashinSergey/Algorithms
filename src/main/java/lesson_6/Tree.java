package lesson_6;

public interface Tree<E> {

    enum TraverseMode {IN_ORDER, PRE_ORDER, POST_ORDER}

    boolean add(E value);
    boolean find(E value);
    boolean remove(E value);

    boolean isEmpty();
    int size();

    void travers(TraverseMode mode);

    void display();
}
