package lesson_4.twoSideLinkedList;

import lesson_4.simpleLinkedList.MySimpleLinkedListImpl;

public class TwoSideMyLinkedListImpl<E> extends MySimpleLinkedListImpl<E> implements TwoSideMyLinkedList<E> {

    private Entry<E> lastElement;

    @Override
    public void insertLast(E value) {
        Entry<E> entry = new Entry<>(value);

        if (isEmpty()) {
            firstElement = entry;
        } else {
            lastElement.next = entry;
        }

        lastElement = entry;
        size++;
    }

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size() == 1) {
            lastElement = firstElement;
        }
    }

    @Override
    public E removeFirst() {
        E removedElement = super.removeFirst();
        if (isEmpty()) {
            lastElement = null;
        }
        return removedElement;
    }

    @Override
    public boolean remove(E value) {
        Entry<E> previous = null;
        Entry<E> current = firstElement;

        while (current != null){
            if (current.value.equals(value)){
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }
        if (current == firstElement){
            firstElement = firstElement.next;
        } else if(current == lastElement) {
             lastElement = previous;
             previous.next = null;
        } else {
            previous.next = current.next;
        }

        size--;
        return true;
    }
}
