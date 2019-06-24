package lesson_5;

public class Factorial {

    public static void main(String[] args) {
        int factorial = factorial(5);
        System.out.println(factorial);
    }

    private static int factorial(int n) {
        if ( n <= 1 ){
            return 1;
        }
        return n * factorial(n - 1 );
    }
}
