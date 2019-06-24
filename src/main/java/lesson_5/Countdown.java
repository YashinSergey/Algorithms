package lesson_5;

public class Countdown {

    public static void main(String[] args) {
//        countdownLoop(5);

        countdownRecursion(5);
    }

    private static void countdownRecursion(int n) {
        if (n > 0) {                  // рекурсивный случай
            System.out.println(n);
            countdownRecursion(--n);
        }

        // else базовый случай
    }

    private static void countdownLoop(int n) {
        while (n > 0) {
            System.out.println(n);
            n--;
        }
    }
}
