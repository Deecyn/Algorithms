package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class $141_CycleList {


    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public boolean hasCycle(ListNode head) {
        return byHashMap(head);
    }

    public boolean byHashMap(ListNode head){
        Set<ListNode> visitedSet = new HashSet<>();
        while (head != null){
            if (visitedSet.contains(head)){
                return true;
            }else {
                visitedSet.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public boolean byDoublePointer(ListNode head){
        if (head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
