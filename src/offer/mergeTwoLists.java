package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/23 20:53
 * @description 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 递归版本更简单，递归思想！！！
 **/
public class mergeTwoLists {

    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        else if(list2 == null)
            return list1;

        if(list1.val <= list2.val)
            return knowMinMerge(list1,list2);
        else{
            return knowMinMerge(list2,list1);
        }

//        if(list1 == null){
//            return list2;
//        }
//        if(list2 == null){
//            return list1;
//        }
//        if(list1.val <= list2.val){
//            list1.next = Merge(list1.next, list2);
//            return list1;
//        }else{
//            list2.next = Merge(list1, list2.next);
//            return list2;
//        }
    }

    private ListNode knowMinMerge(ListNode list1,ListNode list2){
        ListNode head = list1;
        ListNode head1;
        ListNode head2 = list2;
        if(list1.next != null)
            head1 = list1.next;
        else{
            //边缘条件
            head.next = list2;
            return head;
        }

        while (head1 != null && head2 != null){
            if(head2.val < head1.val){
                list1.next = head2;
                list1 = list1.next;
                head2 = head2.next;
                if(head2 == null)
                    list1.next = head1;
            }else {
                list1.next = head1;
                list1 = list1.next;
                head1 = head1.next;
                if(head1 == null)
                    list1.next = head2;
            }
        }

        return head;
    }

}
