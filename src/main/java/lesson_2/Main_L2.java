package lesson_2;

import java.util.Arrays;

public class Main_L2 {
    public static void main(String[] args) {
//        testJdkArray();
//        testMyArrayImpl();
//        arraysSortingExample();
//        mySortedArrayTest();

        MyArray<Integer> array = new MyArrayImpl<>(5);
        array.add(1);
        array.add(5);
        array.add(3);
        array.add(2);
        array.add(4);
        array.add(6);

//        array.sortBubble();
//        array.sortSelect();
        array.sortInsert();
        array.display();

        System.out.println("Array size is " + array.size());
        System.out.println("Find 1: " + array.contains(1));
        System.out.println("Find 666: " + array.contains(666));
        System.out.println("Find index of 3: " + array.indexOf(3));

        array.remove(3);
        System.out.println("Find index of 3: " + array.indexOf(3));


        array.display();

    }

    private static void mySortedArrayTest() {
        MyArray<Integer> array = new MySortedArrayImpl<>(5);
        array.add(1);
        array.add(5);
        array.add(3);
        array.add(2);
        array.add(4);
        array.add(6);

        array.display();

        System.out.println("Array size is " + array.size());
        System.out.println("Find 1: " + array.contains(1));
        System.out.println("Find 666: " + array.contains(666));
        System.out.println("Find index of 3: " + array.indexOf(3));

        array.remove(3);
        System.out.println("Find index of 3: " + array.indexOf(3));

        array.display();
    }

    private static void arraysSortingExample() {
        int[] arr = {2,58,96,54,78,112,2,1};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void testMyArrayImpl() {
        MyArray<Integer> array = new MyArrayImpl<>(5);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);

        array.display();

        System.out.println("Array size is " + array.size());
        System.out.println("Find 1: " + array.contains(1));
        System.out.println("Find 666: " + array.contains(666));
        System.out.println("Find index of 3: " + array.indexOf(3));

        array.remove(3);
        System.out.println("Find index of 3: " + array.indexOf(3));

        array.display();
    }

    private static void testJdkArray() {
        int[] array1 = new int[6];
        int[] array2 = new int[] {1, 2, 3};
        int[] array3 = {1, 2, 3};
        array1[2] = 5;

        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println();

        array3[2] = 5;
        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + " ");
        }
    }
}
