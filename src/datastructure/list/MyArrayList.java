package datastructure.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Deecyn
 * @version 1.0
 * Description: Created in 2019/7/26 14:01.
 */
public class MyArrayList<T> implements Iterable<T> {

    /** 数组列表的基础容量 */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 数组列表的当前长度--当前元素个数，从 1 开始计数；
     *   A[theSize-1] 表示数组的最后一个元素，
     *   而 A[theSize] 表示新添加的项可以被放置的位置
     */
    private int theSize;

    /**
     * 当前数组列表
     */
    private T[] theArrays;
    
    public MyArrayList(){
        theArrays = (T[])new Object[DEFAULT_CAPACITY];
        doClear();
    }

    /**
     * 仅供内部调用的，
     * 清空数组列表的具体实现
     */
    private void doClear() {
        // 设置当前长度为 0
        theSize = 0;

        // 扩充为初始容量
        expandCapacity(DEFAULT_CAPACITY);
    }

    /**
     * 扩充数组容量
     * @param newCapacity 新的容量
     */
    private void expandCapacity(int newCapacity) {
        if (newCapacity < theSize){
            return;
        }

        T[] newArrays = (T[])new Object[newCapacity];
        // 利用 System.arraycopy() 方法拷贝数组，完成数组容量的扩充
        System.arraycopy(theArrays,0,newArrays,0,theSize);
        theArrays = newArrays;
    }

    /**
     * 根据下标返回、得到元素的值
     * @param idx
     * @return
     */
    public T get(int idx){
        if ( idx<0 || idx >= theSize){
            throw new ArrayIndexOutOfBoundsException();
        }
        return theArrays[idx];
    }

    /**
     * 根据下标设置、修改元素的值
     * @param idx
     * @param newVal
     * @return
     */
    public T set(int idx,T newVal){
        if (idx <0 || idx >= theSize){
            throw new ArrayIndexOutOfBoundsException();
        }
        T oldVal = theArrays[idx];
        theArrays[idx] = newVal;
        return oldVal;
    }

    /**
     * 根据下标向列表中插入新元素
     * @param idx
     * @param newVal
     * @return
     */
    public boolean add(int idx,T newVal){
        if (idx <0 || idx >= theSize){
            throw new ArrayIndexOutOfBoundsException();
        }

        if (theArrays.length == theSize){
            expandCapacity(theSize*2+1);
        }

        for (int i=theSize;i>idx;i--){
            theArrays[i] = theArrays[i-1];
        }
        theArrays[idx] = newVal;
        theSize++;
        return true;
    }

    /**
     * 在列表末尾添加元素
     * @param newVal
     * @return
     */
    public boolean add(T newVal){
        add(theSize,newVal);
        return true;
    }

    public T remove(int idx){
        if (idx <0 || idx >= theSize){
            throw new ArrayIndexOutOfBoundsException();
        }

        T removedElem = theArrays[idx];
        for (int i=idx;i<theSize-1;i++){
            theArrays[i] = theArrays[i+1];
        }
        theSize--;

        return removedElem;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T>{

        /**
         * 初始时当前位置为 0
         */
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current<theSize;
        }

        @Override
        public T next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            return theArrays[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
