package stack;

// the stack is a data structure that's implement
// LIFO access (Last In First Out)
// we can only access the top element
public class StackLinkedList<T> implements IStack<T>{

    static class Node<T> {
        final T data;
        Node<T> next;

        public Node(T value) {
            this.data = value;
        }
    }

    private Node<T> top;
    private int size;

    @Override
    public void push(T element) {
        Node<T> node = new Node<>(element);

        node.next = top;
        top = node;

        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new RuntimeException("the stack is empty");

        T value = top.data;
        top = top.next;
        size--;
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException("the stack is empty");

        return top.data;
    }

    @Override
    public int size() {return size;}

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}