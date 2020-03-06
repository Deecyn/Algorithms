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
        return byHashSet(head);
    }

    /**
     * 通过检查一个结点此前是否被访问过来判断链表是否为环形链表，
     * 使用哈希表来存储之前的遍历结果。
     */
    public boolean byHashSet(ListNode head){
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

    /**
     * 使用快、慢双指针遍历：
     * 若链表中不存在环，则快指针直接先到达链表尾部，此时可以返回 false；
     * 若链表中存在环，则快指针不停地在环上遍历，最终与慢指针相遇，此时可以返回 true
     */
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
