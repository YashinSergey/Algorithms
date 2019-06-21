package lesson_4.simpleLinkedList.linkedStack;

import lesson_3.stack.Stack;
import lesson_4.simpleLinkedList.MyLinkedList;
import lesson_4.simpleLinkedList.MySimpleLinkedListImpl;

public class MyLinkedStackImpl<E> implements Stack<E> {

    private MyLinkedList<E> data = new MySimpleLinkedListImpl<>();

    @Override
    public void push(E value) {
        data.insertFirst(value);
    }

    @Override
    public E pop() {
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
