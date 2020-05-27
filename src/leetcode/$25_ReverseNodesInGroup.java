package leetcode;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class $25_ReverseNodesInGroup {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        // 当前结点指向头结点
        ListNode curr = head;
        while (curr != null){
            length++;
            curr = curr.next;
        }

        int totalGroup = length / k;


        curr = head;
        // 申请新的当前结点，始终位于 curr 结点的前一个位置，初始化前为空
        ListNode prev = null;
        // 遍历当前结点，处理其相邻结点的 next 的指向关系
        while (curr != null){
            // 记录当前结点的下一个结点
            ListNode tempNext = curr.next;
            // 进行反转：当前结点的后继指针指向 prev
            curr.next = prev;

            // curr 和 newCurr 结点向前进一位，以处理下一个结点的后继指向关系
            prev = curr;
            curr = tempNext;
        }
        return prev;

    }
}
