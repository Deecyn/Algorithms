package leetcode;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 第 24 题，两两交换链表中的节点
 */
public class $024_SwapNodesInPairs {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head){
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode curr = pre;
        while (curr.next != null && curr.next.next != null){
            ListNode front = curr.next;
            ListNode back = curr.next.next;

            front.next = back.next;
            back.next = front;
            curr.next = back;
            curr = front;
        }
        return pre.next;
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
        ListNode node5 = node4.next = new ListNode(9);

        ListNode newNode = new $024_SwapNodesInPairs().swapPairs(node1);
        printList(newNode);
    }

    public static void printList(ListNode head){
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }


}
