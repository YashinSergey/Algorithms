package lesson_3.homeWork3;

import lesson_3.stack.Stack;
import lesson_3.stack.StackImpl;

public class StringReverse {

    public static void main(String[] args) {
        String str = "I'm a batman!";
        System.out.println(reverseByStack(str));
        System.out.println(reverseByStack("!namtab a m'I"));
    }


    private static String reverseByStack(String str) {
        Stack<Character> stack = new StackImpl<>(20);
        for (Character ch : str.toCharArray()) {
            stack.push(ch);
        }
        StringBuilder sBuilder = new StringBuilder();
        while (stack.size() > 0) {
            sBuilder.append(stack.pop());
        }
        return sBuilder.toString();
    }
}
