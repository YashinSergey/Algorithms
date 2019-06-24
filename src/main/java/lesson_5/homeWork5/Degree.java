package lesson_5.homeWork5;

public class Degree {


    public static void main(String[] args) {
        System.out.println(raiseToDegree(3, 4));
    }

    private static int raiseToDegree(int base, int degree) {
        if ( base == 0 ) {
            return 0;
        }
        if (degree == 0) {
            return 1;
        }
        if ( degree < 0 ) {
            throw new  RuntimeException("Неподдерживаемая операция");
        }
        if (degree % 2 == 1) {
            return raiseToDegree(base, degree - 1) * base;
        } else {
            int res = raiseToDegree (base, degree/2);
            return res * res;
        }
    }
}
