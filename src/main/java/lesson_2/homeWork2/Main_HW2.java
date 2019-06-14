package lesson_2.homeWork2;

public class Main_HW2 {

    /**
     * У меня получилось следующее:
     * Время выполнения поиска методом пузырька: 53 631 мс.
     * Время выполнения поиска методом выбора: 12 475 мс.
     * Время выполнения поиска методом вставки: 16 304 мс.
     */

    private int maxNum = 100_000;
    private static MyArrayImplHW<Integer> array1;
    private static MyArrayImplHW<Integer> array2;
    private static MyArrayImplHW<Integer> array3;
    private long timePoint;
    private long executionTime;

    public static void main(String[] args) {
        Main_HW2 main = new Main_HW2();
        main.fillingArrays();
        main.bubbleRuntimeCheck(array1);
        main.selectRuntimeCheck(array2);
        main.insertRuntimeCheck(array3);

    }

    private void fillingArrays() {
        array1 = new MyArrayImplHW<>(maxNum);
        array2 = new MyArrayImplHW<>(maxNum);
        array3 = new MyArrayImplHW<>(maxNum);

        for (int i = 0; i < maxNum; i++) {
            array1.add((int) (Math.random() * maxNum));
            array2.add(array1.get(i));
            array3.add(array1.get(i));
        }
    }

    private void bubbleRuntimeCheck(MyArrayImplHW array){
        timePoint = System.currentTimeMillis();
        array.sortBubble();
        executionTime = System.currentTimeMillis() - timePoint;
        System.out.printf("Время выполнения поиска методом пузырька: %,d мс.%n", executionTime);
    }

    private void selectRuntimeCheck(MyArrayImplHW array){
        timePoint = System.currentTimeMillis();
        array.sortSelect();
        executionTime = System.currentTimeMillis() - timePoint;
        System.out.printf("Время выполнения поиска методом выбора: %,d мс.%n", executionTime);
    }

    private void insertRuntimeCheck(MyArrayImplHW array){
        timePoint = System.currentTimeMillis();
        array.sortInsert();
        executionTime = System.currentTimeMillis() - timePoint;
        System.out.printf("Время выполнения поиска методом вставки: %,d мс.%n", executionTime);
    }
}
