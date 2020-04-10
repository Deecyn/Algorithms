package leetcode;


/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class $0_Practice {

    private static class ListNode{
        char val;
        ListNode next;
        ListNode(char ch){
            val = ch;
            next = null;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        } else {
            ListNode nextNode = head.next;
            head.next = swapPairs(nextNode.next);
            nextNode.next = head;
            return nextNode;
        }
    }

    public static void main(String[] args) {

    }
}
