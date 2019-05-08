package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/26 20:19
 * @description 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * Queue数据结构new时，用LinkedList或ArrayList可以实现
 **/
public class PrintTNFromTopToBottom {
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        if(root == null) {
            return null;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if(temp.left != null) {
                queue.offer(temp.left);
            }
            if(temp.right != null) {
                queue.offer(temp.right);
            }
            arrayList.add(temp.val);
        }
        return arrayList;
    }
}
