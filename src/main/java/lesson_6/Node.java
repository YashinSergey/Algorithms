package lesson_6;

public class Node<E extends Comparable<? super E>> {

    private final E value;

    private Node<E> left;
    private Node<E> right;

    public Node(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public boolean shouldBeLeft(E value){
        return value.compareTo(getValue()) < 0;
    }

    public boolean isLeaf() {
        return getLeft() == null && getRight() == null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
