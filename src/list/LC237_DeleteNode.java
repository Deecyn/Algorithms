package list;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 237.删除链表中的节点
 */
public class LC237_DeleteNode {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /**
     * 不知道前面节点的时候，可以与下一个节点交换内容，然后删除下一个节点
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
