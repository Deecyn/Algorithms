package deecyn.list;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 206.反转链表
 *
 * tags: 链表
 */
public class LC206_ReverseLinkedList {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /**
     * 递归法
     */
    public ListNode byRecursion(ListNode head) {
        // 递归终止条件：当前为空，或下一个为空
        if (head == null || head.next == null){
            return head;
        }

        // 当"递"完成之后，当前结点 curr 指向最后一个结点
        ListNode curr = byRecursion(head.next);

        // 这里的 head 是 curr 的前一个结点；若 head 是最后一个结点，则不满足递归终止条件。
        // 进行反转：即从 curr 开始，后继指针向前指，一直向前"归"
        head.next.next = head;

        //防止链表循环，需要将 head.next 设置为空
        head.next = null;
        return curr;
    }
}
