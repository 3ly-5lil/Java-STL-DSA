import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import stack.StackArray;
import stack.StackLinkedList;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class StackTests {

    public static class StackArrayTests {
        int size = 10;
        StackArray<Integer> stackArray = new StackArray<>(size);

        @Test
        public void testPush() {
            assertTrue(stackArray.isEmpty());
            Integer i = 0;

            while (i < size/2) {
                stackArray.push(i);
                assertEquals(i, stackArray.peek());
                i++;
            }

            assertEquals(size/2, stackArray.size());
            assertFalse(stackArray.isFull());
            assertFalse(stackArray.isEmpty());

            while (i < size) {
                stackArray.push(i);
                assertEquals(i, stackArray.peek());
                i++;
            }

            assertTrue(stackArray.isFull());
        }


        @Test
        public void shouldThrowArrayFullException() {
            int i = 0;
            while (!stackArray.isFull()) {
                stackArray.push(i++);
            }

            assertThrows("the stack is full", RuntimeException.class, () -> stackArray.push(10));
        }

        @Test
        public void testPop() {
            Integer i = 0;

            while (!stackArray.isFull()) {
                stackArray.push(i++);
            }

            while (i >= size / 2) {
                i--;
                assertEquals(i, stackArray.pop());
            }

            assertFalse(stackArray.isEmpty());

            while (i > 0) {
                i--;
                assertEquals(i, stackArray.pop());
            }

            assertTrue(stackArray.isEmpty());
        }

        @Test
        public void testPeek() {
            Integer i = 0;
            while (!stackArray.isFull()) {
                stackArray.push(i);
                assertEquals(stackArray.peek(), i++);
            }
        }
        @Test
        public void shouldThrowArrayEmptyException() {
            assertThrows("the stack is empty", RuntimeException.class, stackArray::pop);
            assertThrows("the stack is empty", RuntimeException.class, stackArray::peek);
        }
    }

    public static class StackLinkedListTests {
        StackLinkedList<Integer> stackLinkedList = new StackLinkedList<>();

        @Test
        public void testPush() {
            assertTrue(stackLinkedList.isEmpty());
            Integer i = 0;

            while (i < 5) {
                stackLinkedList.push(i);
                assertEquals(i, stackLinkedList.peek());
                i++;
            }

            assertFalse(stackLinkedList.isEmpty());
        }

        @Test
        public void testPop() {
            Integer i = 0;
            int size = 10;
            while (i < 10) {
                stackLinkedList.push(i++);
            }

            while (i >= size / 2) {
                i--;
                assertEquals(i, stackLinkedList.pop());
            }

            assertFalse(stackLinkedList.isEmpty());

            while (i > 0) {
                i--;
                assertEquals(i, stackLinkedList.pop());
            }

            assertTrue(stackLinkedList.isEmpty());
        }

        @Test
        public void testPeek() {
            Integer i = 0;
            assertTrue(stackLinkedList.isEmpty());

            while (i < 5) {
                stackLinkedList.push(i);
                assertEquals(stackLinkedList.peek(), i);
                i++;
            }

            assertFalse(stackLinkedList.isEmpty());
        }
        @Test
        public void shouldThrowArrayEmptyException() {
            assertThrows("the stack is empty", RuntimeException.class, stackLinkedList::pop);
            assertThrows("the stack is empty", RuntimeException.class, stackLinkedList::peek);
        }
    }
}
