package deecyn.stack_queue;

import java.util.LinkedList;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 232.用栈实现队列；
 *   剑指 Offer 09. 用两个栈实现队列
 */
public class LC232_ImplementQueueWithStack {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.peek();  // 返回 1
        queue.pop();   // 返回 1
        queue.empty(); // 返回 false
    }
}

class MyQueue {

    private LinkedList<Integer> pushStack, popStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new LinkedList<>();
        popStack = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        detectAndShift();

        if (popStack.isEmpty()) {
            throw new RuntimeException("队列中没有元素");
        }
        return popStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        detectAndShift();

        if (popStack.isEmpty()) {
            throw new RuntimeException("队列中没有元素");
        }
        return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    private void detectAndShift() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }
}
