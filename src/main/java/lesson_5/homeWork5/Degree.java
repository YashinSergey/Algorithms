package lesson_5.homeWork5;

public class Degree {

    public static void main(String[] args) {
        System.out.println(raiseToDegree(3, -2));
        System.out.println(raiseToDegree(3, 2));
        System.out.println(raiseToDegree(5, 0));
        System.out.println(raiseToDegree(2, 3));
        System.out.println(raiseToDegree(0, 7));
//        System.out.println(raiseToDegree(0, -9));
    }

    private static double raiseToDegree(double base, int degree) {
        if ( base == 0 ) {
            if ( degree > 0 ) {
            return 0;
            } else {
                throw new IllegalArgumentException("Invalid degree " + degree + " for base " + base);
            }
        }

        if ( degree < 0 ) {
            return  1 / (base * raiseToDegree(base, Math.abs(degree) - 1));
        } else if ( degree > 0 ) {
            return raiseToDegree(base, degree - 1) * base;
        } else {
            return 1;
        }
    }
}
