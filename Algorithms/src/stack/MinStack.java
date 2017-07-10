package stack;

/**
 * Created by vasant on 6/3/16.
 */
public class MinStack<T extends Comparable<T>> {

    Stack<T> stack;

    Stack<T> minStack;

    public MinStack(int size) {
         stack = new Stack(size);
        minStack= new Stack(size);
    }

    public void push(T e) {
        if(stack.isEmpty()) {
            stack.push(e);
            minStack.push(e);
        }
        //current min
        stack.push(e);
        T x = minStack.peek();

        if(e.compareTo(x)<=0) {
            minStack.push(e);
        }
    }

    public T pop() {
        if(stack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }


            T e = stack.pop();
            T x = minStack.peek();

            if(x.compareTo(e)==0) {
                minStack.pop();
            }

        return e;
    }

    public T min() {
        return minStack.peek();
    }
}
