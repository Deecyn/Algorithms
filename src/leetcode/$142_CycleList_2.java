package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class $142_CycleList_2 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode byHashSet(ListNode head){
        Set<ListNode> visitedSet = new HashSet<>();
        while (head != null){
            if (visitedSet.contains(head)){
                return head;
            }
            visitedSet.add(head);
            head = head.next;
        }
        return null;
    }

    public ListNode byDoublePointer(ListNode head){
        ListNode fast = head, slow = head;
        while (true){
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;;
        }
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
