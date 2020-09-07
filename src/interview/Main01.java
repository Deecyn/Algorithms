package interview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Deecyn
 * @version 0.1
 * Description: 求链表的公共部分
 */

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Main01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ListNode listA = new ListNode(0, null);
        ListNode headA = listA;
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            headA.next = new ListNode(x, null);
            headA = headA.next;
        }

        n = sc.nextInt();
        ListNode listB = new ListNode(0, null);
        ListNode headB = listB;
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            headB.next = new ListNode(x, null);
            headB = headB.next;
        }

        ListNode result = checkPublic(listA, listB);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode checkPublic(ListNode headA, ListNode headB) {
        ListNode resultNode = new ListNode(0, null);
        Set<Integer> exists = new HashSet<>();

        while (headA != null) {
            exists.add(headA.val);
            headA = headA.next;
        }

        ListNode resultHead = resultNode;
        while (headB != null) {
            if (exists.contains(headB.val)) {
                resultHead.next = new ListNode(headB.val, null);
                resultHead = resultHead.next;
            }
            headB = headB.next;
        }
        return resultNode.next.next;
    }

}
