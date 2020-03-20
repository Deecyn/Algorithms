package datastructure.stack_queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Deecyn
 * @Date: Created in 8:24 2019/4/3
 * @Description: <描述>
 */
public class StackOfArrayList<T> {

    private List<T> theStack;
    public StackOfArrayList(){
        theStack = new ArrayList<>(10);
    }

    public void push(T item){
        theStack.add(item);
    }

    public T pop(){
        return theStack.remove(theStack.size()-1);
    }

    public T peek(){
       return theStack.get(theStack.size()-1);
    }

    public boolean empty(){
        return theStack.size() == 0;
    }

}
