package stack;

public class Stack<T> {

    private T[] s;
    int top = 0;

    @SuppressWarnings("unchecked")
    public Stack(int length) {
	s = (T[]) new Object[length];
    }

    public T pop() {
	if (top < 0) {
	    return null;
	}
	T value = s[--top];
	s[top] = null;
	System.out.print(value + " ");
	return value;
    }

    public T peek() {
	return s[top - 1];
    }

    public T popWithoutPrint() {
	if (top < 0) {
	    return null;
	}
	T value = s[--top];
	s[top] = null;
	// System.out.print(value + " ");
	return value;
    }

    public void push(T value) {

	s[top++] = value;
    }

    public boolean isEmpty() {
	return top <= 0 ? true : false;
    }

    public void printStack() {
	System.out.println();
	for (int i = 0; i < top; i++) {
	    System.out.print(s[i].toString() + "  ");

	}
    }

}
