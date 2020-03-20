package datastructure.stack_queue;

/**
 * @author Deecyn
 * @version 1.0
 * Description: Created in 2019/8/3 20:36.
 */
public class LinkedStack<T> {

    private static class Node<T>{
        private T data;
        private Node<T> under;
        public Node(T data,Node<T> under){
            this.data = data;
            this.under = under;
        }
    }

    private int theSize;
    private Node<T> top;

    public LinkedStack(){
        clear();
    }
    public void clear(){
        top = new Node<>(null,null);
        theSize = 0;
    }

    public boolean empty(){
        return top==null || top.data == null;
    }

    public void push(T data){
        if (data == null){
            return;
        }

        if (this.top == null){
            this.top = new Node<>(data,null);
        }else if (this.top.data == null){
            this.top.data = data;
        }else{
            Node<T> point = new Node<>(data,top);
            top = point;
        }
        theSize++;
    }

    public T pop(){
        if(empty()){
            return null;
        }
        T data = top.data;
        top = top.under;
        theSize--;
        return  data;
    }

    public T peek(){
        if (empty()){
            return null;
        }
        return top.data;
    }
}
