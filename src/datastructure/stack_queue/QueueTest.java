package datastructure.stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class QueueTest {
    public static void main(String[] args) {
        Deque<String> queue = new LinkedList<>();

        queue.add("one");
        queue.add("two");
        queue.offer("three");
        queue.offer("four");

        System.out.println(queue);
        queue.remove();
        queue.poll();

    }
}
