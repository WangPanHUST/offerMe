package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 19-3-30 下午5:19
 * @description 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。即统计每一行的个数。
 * @see printTNFromTopToBottom
 * 思路：设置两个变量，一个是待出队的数量，即本层剩下的节点数，一个是下一层的节点数，当本层的节点出队完毕时候，待出队的数量等于下一层的节点数量。
 **/
public class printTNwithLine {
    public ArrayList<ArrayList<Integer>> PrintInLine(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(pRoot == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int nextLine = 0,toBeDelete = 1;

        while (!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if(temp.left != null){
                queue.offer(temp.left);
                nextLine++;
            }
            if(temp.right != null){
                queue.offer(temp.right);
                nextLine++;
            }
            arrayList.add(temp.val);
            toBeDelete--;

            if(toBeDelete == 0){
                result.add(arrayList);
                toBeDelete = nextLine;
                nextLine = 0;
                arrayList = new ArrayList<>();
            }
        }

        return result;
    }
}
