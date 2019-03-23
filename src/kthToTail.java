/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/23 19:59
 * @description 输入一个链表，输出该链表中倒数第k个结点。
 * 使用两个指针，一个先走k步，另一个再从头走
 * null变量没有next！即head.next == null，则运行head.next.next会为空指针错误
 **/
public class kthToTail {

    public class ListNode{
        int val;
        ListNode next = null;
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0)
            return null;

        ListNode result = head;
        for(int i = 0;i < k - 1;i++){
            //null变量没有next！即head.next == null，则运行head.next.next会为空指针错误
            if(head.next != null)
                head = head.next;
            else
                return null;
        }

        while(head.next != null){
            head = head.next;
            result = result.next;
        }
        return result;
    }
}
