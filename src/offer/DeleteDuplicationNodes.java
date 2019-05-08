package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/29 21:09
 * @description 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 思路：对节点进行遍历操作，判断当前节点有没有连续重复，有的话删除直到不重复节点，重点是3->3->4->4这样的连续重复节点，
 * 使用return nextNode != null? getHead(nextNode):null;进行重复删除
 **/
public class DeleteDuplicationNodes {
    public static ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode result = null,newNext = null;
        result = getHead(pHead);
        newNext = result;

        //对获得的链表剩下的节点进行删除操作
        while (result != null && result.next != null){
            result.next = getHead(result.next);
            result = result.next;
        }

        return newNext;
    }

    //获取以当前节点为头结点的头结点
    private static ListNode getHead(ListNode head) {
        ListNode nextNode = head.next;
        if (nextNode == null) {
            return head;
        } else {
            if (nextNode.val != head.val) {
                return head;
            } else{
                while (nextNode != null && nextNode.val == head.val) {
                    nextNode = nextNode.next;
                }
                //返回值中首先进行判断nextNode是不是null，是的话不符合开头的ListNode nextNode = head.next，并且返回getHead(nextNode)，针对的是3 3 4 4这种连续的重复节点
                return nextNode != null? getHead(nextNode):null;
            }
        }
    }

    //想做的递归做法
/*
    public class Solution {
        public offer.ListNode deleteDuplication(offer.ListNode pHead) {
            if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
                return pHead;
            }
            if (pHead.val == pHead.next.val) { // 当前结点是重复结点
                offer.ListNode pNode = pHead.next;
                while (pNode != null && pNode.val == pHead.val) {
                    // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                    pNode = pNode.next;
                }
                return deleteDuplication(pNode); // 从第一个与当前结点不同的结点开始递归
            } else { // 当前结点不是重复结点
                pHead.next = deleteDuplication(pHead.next); // 保留当前结点，从下一个结点开始递归
                return pHead;
            }
        }
    } */

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        a.next = b;
        b.next = c;

        System.out.println(deleteDuplication(a).val);
    }
}
