package stackTest;

import lesson_3.stack.Stack;
import lesson_3.stack.StackImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestStackImpl {

    private Stack<Integer> stack;
    private int lastValue;
    private int size;

    @Before
    public void init(){
        stack = new StackImpl<>(10);
    }

    @Test
    public void pushTest(){
        boolean bool = false;
        lastValue = 9;
        stack.push(lastValue);
        if (stack.peek().equals(lastValue)){
            bool = true;
        }
        Assert.assertTrue(bool);
    }

    @Test
    public void peekTest(){
        lastValue = 4;
        stack.push(lastValue);
        Assert.assertEquals(lastValue, (int) stack.peek());
    }

    @Test
    public void popTest(){
        lastValue = 5;
        stack.push(lastValue);
        Assert.assertEquals(lastValue, (int) stack.pop());
    }

    @Test
    public void sizeTest(){
        lastValue = 3;
        size = 0;

        for (size = 0; size < 10; size++) {
            stack.push(lastValue);
            lastValue++;
        }

        Assert.assertEquals(size, stack.size());
    }

    @Test
    public void isFullTest(){
        lastValue = 7;

        for (int i = 0; i < 10; i++) {
            stack.push(lastValue);
            lastValue++;
        }

        Assert.assertTrue(stack.isFull());

        stack.pop();

        Assert.assertFalse(stack.isFull());
    }

    @Test
    public void isEmptyTest(){
        Assert.assertTrue(stack.isEmpty());

        stack.push(8);

        Assert.assertFalse(stack.isEmpty());
    }
}
