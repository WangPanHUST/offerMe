package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/1 12:06
 * @description 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 **/
public class CloneRandomLN {

    private static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static RandomListNode clone(RandomListNode pHead)
    {
        if(pHead == null) {
            return null;
        }

        RandomListNode p1 = pHead;
        while (p1 != null){
            RandomListNode nHead = new RandomListNode(p1.label);
            nHead.next = p1.next;
            p1.next = nHead;
            p1 = nHead.next;
        }

        RandomListNode p2 = pHead;
        while (p2 != null){
            p2.next.random = p2.random == null ? null : p2.random.next;
            p2 = p2.next.next;
        }

        RandomListNode p3 = pHead.next;
        RandomListNode result = p3;

        while (pHead != null){
            pHead.next = p3.next;
            if (p3.next != null) {
                p3.next = p3.next.next;
            }
            pHead = pHead.next;
            p3 = p3.next;
        }

        //不能使用如下的判断条件 p3.next != null，这样最后一组的原始节点与复制节点的next关系还在，即 3.next还是3',这个关系没有清除
//        RandomListNode oriHead = pHead;
//        while (p3.next != null){
//            oriHead.next = p3.next;
//            p3.next = p3.next.next;
//            oriHead = oriHead.next;
//            p3 = p3.next;
//        }

        return result;

    }

    public static void main(String[] args) {
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        a.next = b;
        b.next = c;
        a.random = c;
        b.random = a;

        RandomListNode result = clone(a);
        System.out.println(result.random.label);
    }
}
