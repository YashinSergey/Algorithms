package lesson_2.homeWork2;

public class Main_HW2 {

    /**
     * У меня получилось следующее:
     * Время выполнения поиска методом пузырька: 53 631 мс.
     * Время выполнения поиска методом выбора: 12 475 мс.
     * Время выполнения поиска методом вставки: 16 304 мс.
     */

    private final static int MAX_NUM = 100_000;

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
        array1 = new MyArrayImplHW<>(MAX_NUM);
        array2 = new MyArrayImplHW<>(MAX_NUM);
        array3 = new MyArrayImplHW<>(MAX_NUM);
        
        for (int i = 0; i < MAX_NUM; i++) {
            int num = (int) (Math.random() * MAX_NUM);
            array1.add(num);
            array2.add(num);
            array3.add(num);
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
