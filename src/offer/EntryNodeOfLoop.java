package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/6/24 20:05
 * @description 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 时间复杂度o(n)
 * 思路：先判断是否有环，两个指针，一个一次移动一步，另一个一次移动两步，如果相遇则有换，如果走的快的指针成为了null，则无环
 * 有环之后再求出环的长度loopLen，再给出两个指针，一个指针先从头移动loopLen，之后两个指针同时移动，直到相遇即为环的入口
 **/
public class EntryNodeOfLoop {

    public ListNode entryNodeOfLoop(ListNode pHead) {

        if (pHead == null || pHead.next == null) {
            return null;
        }

        ListNode p1 = pHead;
        ListNode p2 = pHead.next.next;

        if (p2 == null) {
            return null;
        }

        if (p1 == p2) {
            return p1;
        }

        while (p2 != null) {
            if (p1 == p2) {
                return getEntryNode(p1, p2, pHead);
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }

        return null;
    }

    private ListNode getEntryNode(ListNode p1, ListNode p2, ListNode pHead) {
        int loopLen = 0;

        while (p1 != p2 || loopLen == 0) {
            loopLen++;
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode p3 = pHead;
        for (int i = 0; i < loopLen; i++) {
            p3 = p3.next;
        }

        while (pHead != p3) {
            p3 = p3.next;
            pHead = pHead.next;
        }

        return p3;
    }
}
