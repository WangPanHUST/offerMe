package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/14 16:14
 * @description 输入两个链表，找出它们的第一个公共结点。
 * 这里公共节点的意思是，从该节点之后的所有节点都相同，注意节点是一个类，所以不仅是要val相同，而是这个类相同
 * 先遍历两个链表得到对应的长度，让长的链表先走多出的几步，之后两个链表同时遍历直到找到公共节点或遍历结束
 **/
public class findFirstCommonNode {

    public static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int v){
            this.val = v;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        int len1 = 0,len2 = 0;
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;

        while (node1.next != null){
            len1++;
            node1 = node1.next;
        }

        while (node2.next != null){
            len2++;
            node2 = node2.next;
        }

        if(len1 > len2){
            for (int i = 0; i < len1 - len2; i++)
                pHead1 = pHead1.next;
        }else {
            for (int i = 0; i < len2 - len1; i++)
                pHead2 = pHead2.next;
        }

        while (pHead1 != pHead2){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new  ListNode(3);
        n.next = n1;
        n1.next = n2;

        ListNode p = n;
        p = p.next;

        System.out.println(n.next.val);
        System.out.println(p.val);
    }
}
