package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class $141_CycleList {


    private class ListNode {
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
     * 使用哈希表来存储之前的遍历结果。时间复杂度 O(n)。
     *
     * 但使用哈希表时，new 对象与映射寻址也需要的时间，虽然时间量级为 O(1)，
     * 但实际时间比 O(1) 大一些。所以，使用哈希表会比双指针的解法，实际耗费时间多一些。
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
     *   若链表中不存在环，则快指针直接先到达链表尾部，此时可以返回 false；
     *   若链表中存在环，则快指针不停地在环上遍历，最终与慢指针相遇，此时可以返回 true。
     * 时间复杂度 O(n)。
     */
    public boolean byDoublePointer(ListNode head){
        if (head == null || head.next == null) return false;

        ListNode slow = head, fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }

            slow = slow.next;
            // 因为仅需两个结点就能成环，所以快指针一次只能走两步
            fast = fast.next.next;
        }
        return true;
    }

}
