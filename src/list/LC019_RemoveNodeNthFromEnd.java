package list;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 19.删除链表的倒数第 N 个节点
 *
 */
public class LC019_RemoveNodeNthFromEnd {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /**
     * 两次遍历解法
     */
    public ListNode doubleIterate(ListNode head, int n) {
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }

        if (n == len) {
            head = head.next;
            return head;
        }

        int prevIdx = len - n - 1;
        tmp = head;
        while (prevIdx > 0) {
            prevIdx--;
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;

        return head;
    }

    /**
     * 双指针解法
     */
    public ListNode doublePointer(ListNode head, int n) {
        // 设置预先指针，一种技巧，解决头指针可能被删的问题
        ListNode prev = new ListNode(0);
        prev.next = head;

        ListNode first = prev;
        ListNode second = prev;

        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return prev.next;
    }

}
