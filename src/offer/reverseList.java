package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/23 20:15
 * @description 输入一个链表，反转链表后，输出新链表的表头。
 * 反转之前先保存当前节点，及保存了后续的所有节点 顺序遍历一次即可
 **/
public class reverseList {

    public ListNode ReverseList(ListNode head) {
        if(head == null)
            return null;
        else if(head.next == null)
            return head;

        ListNode reverseHead = null;
        ListNode next = null;
        ListNode pre = null;
        while (head != null){
            next = head.next;
            if(next == null)
                reverseHead = head;

            //反转当前head
            head.next = pre;
            pre = head;
            head = next;
        }

        return reverseHead;
    }
}
