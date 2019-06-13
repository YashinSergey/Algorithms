package lesson_2;

public class InvalidArrayStateException extends RuntimeException {

    public InvalidArrayStateException(int index, int size) {
        super(String.format("Invalid index value: %d; array size is %d", index, size));
    }
}
