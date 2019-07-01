package leetcode.addtwonumbers1;

import leetcode.ListNode;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/5/8 14:50
 * @description https://leetcode-cn.com/problems/add-two-numbers/ 时间复杂度O(max(m,n)) 空间复杂度O(max(m,n))，新链表最大长度为max(m,n) + 1max(m,n)+1
 **/
public class Solution1 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1, head2 = l2, newHead, result = null;
        int sum = 0, carry = 0;
        newHead = new ListNode(-1);

        while (head1 != null || head2 != null) {
            sum += carry;
            if (head1 != null) {
                sum += head1.val;
            }
            if (head2 != null) {
                sum += head2.val;
            }

            carry = sum / 10;
            newHead.next = new ListNode(sum % 10);
            if (l1.equals(head1) && l2.equals(head2)) {
                result = newHead.next;
            }

            newHead = newHead.next;
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
            sum = 0;
        }
        //最后的进位不要忘记
        if (carry != 0) {
            newHead.next = new ListNode(carry);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(9);
        ListNode ans = addTwoNumbers(a,b);
        System.out.println(ans.val);
        System.out.println(ans.next.val);
    }
}
