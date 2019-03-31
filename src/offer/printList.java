package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/17 19:38
 * @description 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 知识点：
 * 倒序的特点要联想到栈
 * 也可以使用递归结构实现，递归本质结构也是一个栈
 **/
public class printList {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){

        //这里即使listNode为null，输出也该为[]，而不是null
//        if(listNode == null)
//            return null;

        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!stack.isEmpty())
            arrayList.add(stack.pop());

        return arrayList;
    }

    public static void main(String[] args) {

    }
}
