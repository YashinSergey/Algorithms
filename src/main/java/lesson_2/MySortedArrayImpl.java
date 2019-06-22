package lesson_2;

public class MySortedArrayImpl<E extends Object & Comparable<? super E>> extends MyArrayImpl<E> {

    public MySortedArrayImpl(int initialCapacity) {
        super(initialCapacity);
    }

    public MySortedArrayImpl() {
    }

    @Override // O(n)
    public void add(E value) {
        checkGrow();
        int index = size;
        for (int i = 0; i < size; i++) {
            if(data[i].compareTo(value) > 0){
                index = i;
                break;
            }
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    @Override // O(log^2 n)
    public int indexOf(E value) {
        int low = 0;
        int high = size -1;

        while (low <= high){
            int mid = (low + high) / 2;
            if(data[mid].equals(value)){
                return mid;
            } else if(value.compareTo(data[mid]) > 0){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
