package leetcode;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 第 206 题，反转链表。
 */
public class $206_ReverseLinkedList {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /**
     * 迭代法
     * @param head 待反转链表头指针
     * @return 反转后链表的新头指针
     */
    public ListNode byIteration(ListNode head){
        // 当前结点指向头结点
        ListNode curr = head;
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

    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode byRecursion(ListNode head){
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

    /**
     * main() 方法，测试用
     * @param args
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = node1.next = new ListNode(3);
        ListNode node3 = node2.next = new ListNode(5);
        ListNode node4 = node3.next = new ListNode(7);

        ListNode newNode = new $206_ReverseLinkedList().byIteration(node1);
        printList(newNode);
    }

    public static void printList(ListNode head){
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

}
