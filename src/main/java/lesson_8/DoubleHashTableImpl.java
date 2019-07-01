package lesson_8;

public class DoubleHashTableImpl extends HashTableImpl {


    public static final int DOUBLE_HASH_CONST = 5;

    public DoubleHashTableImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    protected int getStep(Item item) {
        return doubleHashFunc(item);
    }

    private int doubleHashFunc(Item key) {
        return DOUBLE_HASH_CONST - (key.hashCode() % DOUBLE_HASH_CONST);
    }
}
