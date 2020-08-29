package deecyn.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 225.用队列实现栈；
 */
public class LC225_ImplementStackWithQueue {

}

class MyStack {
        Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.add(x);
            for(int i = 1; i < queue.size(); i++)
                queue.add(queue.remove());
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.size() == 0;
        }
}
