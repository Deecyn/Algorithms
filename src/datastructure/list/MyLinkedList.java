package datastructure.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Deecyn
 * @version 1.0
 * Description: MyLinkedList,提供了 List ADT 的双链表实现
 */
public class MyLinkedList<T> implements Iterable {

    private static class Node<T>{
        public T data;
        public Node<T> prev;
        public Node<T> next;
        public Node(T data,Node<T> prev,Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private int theSize;

    private int modCount;

    private Node<T> header;

    private Node<T> tail;

    public MyLinkedList(){
        doClear();
    }

    private void doClear(){
        header = new Node<T>(null,null,null);
        tail = new Node<>(null,header,null);
        header.next = tail;

        theSize = 0;
        modCount++;
    }

    public void clear(){
        doClear();
    }

    public int size(){
        return theSize;
    }
    public boolean isEmpty(){
        return size() == 0;
    }

    private Node<T> getNode(int idx,int lower,int upper){
        Node<T> point;
        if (idx < lower || idx > upper){
            throw new IndexOutOfBoundsException();
        }

        if (idx < size()/2){
            point = header.next;
            for (int i = 0; i < idx; i++) {
                point = point.next;
            }
        }else {
            point = tail.prev;
            for (int i = size()-1; i > idx; i--) {
                point = point.prev;
            }
        }
        return point;
    }

    private Node<T> getNode(int idx){
        return getNode(idx,0,size()-1);
    }

    public void addBefore(Node<T> point,T x){
        Node<T> newNode = new Node<>(x,point.prev,point);
        point.prev.next = newNode;
        point.prev = newNode;

        theSize++;
        modCount++;
    }

    public void add(int idx,T x){
        addBefore(getNode(idx,0,size()),x);
    }

    public boolean add(T x){
        add(size(),x);
        return true;
    }

    public T get(int idx){
        return getNode(idx).data;
    }

    public T set(int idx,T newVal){
        Node<T> point = getNode(idx);
        T oldVal = point.data;
        point.data = newVal;
        return oldVal;
    }

    public T remove(Node<T> point){
        point.prev.next = point.next;
        point.next.prev = point.prev;
        theSize--;
        modCount++;

        return point.data;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T>{

        private Node<T> current = header.next;

        private int expectedModCount = modCount;

        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != tail;
        }

        @Override
        public T next() {
            if (modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }

            if (!hasNext()){
                throw new NoSuchElementException();
            }
            T nextItem = current.data;
            current = current.next;

            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }

            if (!okToRemove){
                throw new IllegalStateException();
            }

            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }
    }
}











