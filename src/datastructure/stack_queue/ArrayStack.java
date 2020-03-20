package datastructure.stack_queue;

/**
 * @author Deecyn
 * @version 1.0
 * Description: Created in 2019/8/3 20:24.
 */
public class ArrayStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] theStack;

    private int top = -1;
    private int theSize;

    public ArrayStack(){
        theStack = (T[])new Object[DEFAULT_CAPACITY];
        clear();
    }

    public void clear(){
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    private void ensureCapacity(int newCapacity){
        if (newCapacity <= theSize){
            return;
        }

        T[] newStack = (T[])new Object[newCapacity];
        System.arraycopy(theStack,0,newStack,0,theSize);
        theStack = newStack;
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public void push(T data){
        if (theStack.length == theSize){
            ensureCapacity(theSize*2+1);
        }
        theStack[++top] = data;
        theSize++;
    }

    public T pop(){
        if (isEmpty()){
            return null;
        }
        theSize--;
        return theStack[top--];
    }

    public T peek(){
        if (isEmpty()){
            return null;
        }
        return theStack[top];
    }
}
