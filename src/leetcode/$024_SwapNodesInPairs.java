package leetcode;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 第 24 题，两两交换链表中的节点
 */
public class $024_SwapNodesInPairs {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /**
     * 迭代解法：
     */
    public ListNode byIteration(ListNode head){
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        ListNode prevNode = headNode;
        while (prevNode.next != null && prevNode.next.next != null){
            ListNode front = prevNode.next;
            ListNode back = prevNode.next.next;

            front.next = back.next;
            back.next = front;

            // 对于链表最前面两个元素，只需修改两个指针；但对于链表中间部分的元素需要修改三个指针；
            // 即 prevNode.next = back 对于链表中间部分的元素才会有实际意义；
            // 对于链表中间部分的元素，引用 prevNode 指向的是待交换两个结点的前驱结点；
            prevNode.next = back;
            prevNode = front;
        }
        return headNode.next;
    }

    /**
     * 递归解法：
     */
    public ListNode byRecursion(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode nextNode = head.next;
        head.next = byRecursion(nextNode.next);
        nextNode.next = head;
        return nextNode;
    }
}
