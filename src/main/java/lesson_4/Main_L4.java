package lesson_4;

import lesson_3.queue.Queue;
import lesson_3.queue.QueueImpl;
import lesson_3.stack.Stack;
import lesson_4.simpleLinkedList.linkedStack.MyLinkedStackImpl;
import lesson_4.simpleLinkedList.MyLinkedList;
import lesson_4.simpleLinkedList.MySimpleLinkedListImpl;
import lesson_4.twoSideLinkedList.TwoSideMyLinkedList;
import lesson_4.twoSideLinkedList.TwoSideMyLinkedListImpl;
import lesson_4.twoSideLinkedList.lilnkedQueue.LinkedQueueImple;

public class Main_L4 {

    public static void main(String[] args) {
//        mySimpleLinkedListTest();

//        TwoSideMyLinkedListImplTest();

//        linkedStackTest();

        linkedQueueTest();

    }

    private static void linkedQueueTest() {
//        Queue<Integer> queue = new QueueImpl<>(5);
        Queue<Integer> queue = new LinkedQueueImple<>();
        System.out.println(queue.insertLast(2));
        System.out.println(queue.insertLast(3));
        System.out.println(queue.insertLast(1));
        System.out.println(queue.insertLast(5));
        System.out.println(queue.insertLast(4));
        System.out.println(queue.insertLast(6));

        System.out.println("Queue peek is " + queue.peek());
        System.out.println("Queue size is " + queue.size());
        System.out.println("Queue is full: " + queue.isFull());

        while (!queue.isEmpty()){
            System.out.println(queue.removeFirst());
        }

        System.out.println("Queue size is " + queue.size());
        System.out.println("Queue is full: " + queue.isFull());
    }

    private static void linkedStackTest() {
//        Stack<Integer> stack = new StackImpl<>(5);
        Stack<Integer> stack = new MyLinkedStackImpl<>();

        addToStack(stack,1);
        addToStack(stack,2);
        addToStack(stack,3);
        addToStack(stack,4);
        addToStack(stack,5);
        addToStack(stack,6);
        System.out.println("Stack size is " + stack.size());
        System.out.println("Stack top is " + stack.peek());

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    private static void addToStack(Stack<Integer> stack, int value) {
        if(!stack.isFull()) {
            stack.push(value);
        }
    }

    private static void TwoSideMyLinkedListImplTest() {
        TwoSideMyLinkedList<Integer> myLinkedList = new TwoSideMyLinkedListImpl<>();

        myLinkedList.insertFirst(1);
        myLinkedList.insertFirst(2);
        myLinkedList.insertFirst(3);
        myLinkedList.insertFirst(4);
        myLinkedList.insertLast(5);

        myLinkedList.display();

        System.out.println("Find 2: " + myLinkedList.contains(2));
        System.out.println("Find 1: " + myLinkedList.contains(1));
        System.out.println("Find 4: " + myLinkedList.contains(4));
        System.out.println("Find 654: " + myLinkedList.contains(654));

        myLinkedList.removeFirst();
        myLinkedList.remove(3);

        myLinkedList.display();
    }

    private static void mySimpleLinkedListTest() {
        MyLinkedList<Integer> myLinkedList = new MySimpleLinkedListImpl<>();

        myLinkedList.insertFirst(1);
        myLinkedList.insertFirst(2);
        myLinkedList.insertFirst(3);
        myLinkedList.insertFirst(4);
        myLinkedList.insertFirst(5);

        myLinkedList.display();

        System.out.println("Find 2: " + myLinkedList.contains(2));
        System.out.println("Find 1: " + myLinkedList.contains(1));
        System.out.println("Find 4: " + myLinkedList.contains(4));
        System.out.println("Find 654: " + myLinkedList.contains(654));

        myLinkedList.removeFirst();
        myLinkedList.remove(3);

        myLinkedList.display();
    }
}
