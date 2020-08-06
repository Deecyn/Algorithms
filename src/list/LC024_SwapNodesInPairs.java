package list;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 24.两两交换链表中的节点
 *
 */
public class LC024_SwapNodesInPairs {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /**
     * 递归解法
     */
    public ListNode byRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = head.next;
        head.next = byRecursion(head.next.next);
        nextNode.next = head;

        return nextNode;
    }

}
