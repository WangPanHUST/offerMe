import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 19-3-30 下午4:15
 * @description 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * @see printTNFromTopToBottom
 * 思路：之字形打印的过程与顺序打印的区别，奇数层与偶数层的打印顺序相反，可以考虑使用两个栈，但是进栈的顺序不一致，即偶数层从左向右进，奇数层从右向左进
 * 这里偶数层使用栈和奇数层使用List，List进入的顺序从右向左每次都是放在第一位，链表的插入时间复杂度为o(1)，等效于一个栈从右向左进入，设置flag区分奇偶层
 **/
public class printTNwithZhi {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(pRoot == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        int flag = 0;
        queue.offer(pRoot);

        while (!queue.isEmpty() || !stack.isEmpty()){
            if(flag == 0){
                ArrayList<Integer> arrayList = new ArrayList<>();
                while (!queue.isEmpty()){
                    TreeNode temp = queue.remove();
                    if(temp.left != null)
                        stack.push(temp.left);
                    if(temp.right != null)
                        stack.push(temp.right);
                    arrayList.add(temp.val);
                }
                result.add(arrayList);
                flag = 1;
            }else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                while (!stack.isEmpty()){
                    TreeNode temp = stack.pop();
                    if(temp.right != null)
                        ((LinkedList<TreeNode>) queue).addFirst(temp.right);
                    if(temp.left != null)
                        ((LinkedList<TreeNode>) queue).addFirst(temp.left);
                    arrayList.add(temp.val);
                }
                result.add(arrayList);
                flag = 0;
            }
        }
        return result;
    }
}
