package stackTest;


import lesson_3.queue.QueueImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueImplTest {

    private QueueImpl<Integer> queue;
    private int lastValue;
    private int size;

    @Before
    public void init(){
        queue = new QueueImpl<>(10);
    }

    @Test
    public void insertLastTest(){
        boolean bool = false;
        lastValue = 9;
        queue.insertLast(lastValue);
        if (queue.peek().equals(lastValue)){
            bool = true;
        }
        Assert.assertTrue(bool);
    }

    @Test
    public void peekTest(){
        lastValue = 4;
        queue.insertLast(lastValue);
        Assert.assertEquals(lastValue, (int) queue.peek());
    }

    @Test
    public void removeFirstTest(){
        lastValue = 5;
        queue.insertLast(lastValue);
        Assert.assertEquals(lastValue, (int) queue.removeFirst());
    }

    @Test
    public void sizeTest(){
        lastValue = 3;
        size = 0;

        for (size = 0; size < 10; size++) {
            queue.insertLast(lastValue);
            lastValue++;
        }

        Assert.assertEquals(size, queue.size());
    }

    @Test
    public void isFullTest(){
        lastValue = 7;

        for (int i = 0; i < 10; i++) {
            queue.insertLast(lastValue);
            lastValue++;
        }

        Assert.assertTrue(queue.isFull());

        queue.removeFirst();

        Assert.assertFalse(queue.isFull());
    }

    @Test
    public void isEmptyTest(){
        Assert.assertTrue(queue.isEmpty());

        queue.insertLast(8);

        Assert.assertFalse(queue.isEmpty());
    }
}
