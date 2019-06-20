package lesson_3;

import lesson_3.queue.PriorityQueue;
import lesson_3.queue.Queue;
import lesson_3.queue.QueueImpl;
import lesson_3.stack.Brackets;
import lesson_3.stack.Stack;
import lesson_3.stack.StackImpl;

public class Main_L3 {


    public static void main(String[] args) {
//        stackTest();
//        checkBracketsTest();

//        queueTest();

        Queue<Integer> queue = new PriorityQueue<>(5);
        System.out.println(queue.insertLast(3));
        System.out.println(queue.insertLast(5));
        System.out.println(queue.insertLast(1));
        System.out.println(queue.insertLast(2));
        System.out.println(queue.insertLast(6));
        System.out.println(queue.insertLast(4));

        System.out.println("Queue peek is " + queue.peek());
        System.out.println("Queue size is " + queue.size());
        System.out.println("Queue is full: " + queue.isFull());

        while (!queue.isEmpty()){
            System.out.println(queue.removeFirst());
        }

        System.out.println("Queue size is " + queue.size());
        System.out.println("Queue is full: " + queue.isFull());

    }

    private static void queueTest() {
        Queue<Integer> queue = new QueueImpl<>(5);
        System.out.println(queue.insertLast(1));
        System.out.println(queue.insertLast(2));
        System.out.println(queue.insertLast(3));
        System.out.println(queue.insertLast(4));
        System.out.println(queue.insertLast(5));
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

    private static void checkBracketsTest() {
        String text = "public StackImpl(int maxSize) {    this.data = (E[]) new Object[maxSize];    }";
        Brackets brackets = new Brackets(text);
        brackets.checkBrackets();
    }

    private static void stackTest() {
        Stack<Integer> stack = new StackImpl<>(5);

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
}
