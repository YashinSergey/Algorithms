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
    public void insertTest(){
        boolean bool = false;
        lastValue = 9;
        queue.insert(lastValue);
        if (queue.peek().equals(lastValue)){
            bool = true;
        }
        Assert.assertTrue(bool);
    }

    @Test
    public void peekTest(){
        lastValue = 4;
        queue.insert(lastValue);
        Assert.assertEquals(lastValue, (int) queue.peek());
    }

    @Test
    public void popTest(){
        lastValue = 5;
        queue.insert(lastValue);
        Assert.assertEquals(lastValue, (int) queue.remove());
    }

    @Test
    public void sizeTest(){
        lastValue = 3;
        size = 0;

        for (size = 0; size < 10; size++) {
            queue.insert(lastValue);
            lastValue++;
        }

        Assert.assertEquals(size, queue.size());
    }

    @Test
    public void isFullTest(){
        lastValue = 7;

        for (int i = 0; i < 10; i++) {
            queue.insert(lastValue);
            lastValue++;
        }

        Assert.assertTrue(queue.isFull());

        queue.remove();

        Assert.assertFalse(queue.isFull());
    }

    @Test
    public void isEmptyTest(){
        Assert.assertTrue(queue.isEmpty());

        queue.insert(8);

        Assert.assertFalse(queue.isEmpty());
    }
}
