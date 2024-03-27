public class Generic_Stack<T> {
    private int top;
    private T[] stack;

    public Generic_Stack(int capacity) {
        stack = (T[]) new Object[capacity];
        top = -1;
    }

    public void push(T data) {
        stack[++top] = data;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        // no need to assign a value on top as in an example video
        return stack[top--];
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    public void show() {
        for (T n : stack) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

