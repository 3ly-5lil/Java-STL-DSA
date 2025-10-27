package stack;

// the stack is a data structure that's implement
// LIFO access (Last In First Out)
// we can only access the top element only
@SuppressWarnings("unchecked")
public class StackArray<T> implements IStack<T> {
    private final Object[] arr;
    private final int capacity;
    private int top;

    public StackArray(int n) {
        capacity = n;
        top = -1;
        arr = new Object[n];
    }

    @Override
    public void push(T item) {
        if (isFull())
            throw new RuntimeException("the stack is full");

        arr[++top] = item;
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new RuntimeException("the stack is empty");

        return (T) arr[top--];
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("the stack is empty");

        return (T) arr[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top+1;
    }

    public boolean isFull() {
        return top == capacity -1;
    }
}
