import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/26 22:02
 * @description 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * 递归算法理解，return的含义，result.add(new ArrayList<>(arrayList));使用new避免之后的操作影响arrayList
 **/
public class findPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        ArrayList<Integer> arrayList = new ArrayList<>();
        result = path(root,target,0,arrayList,result);
        return result;
    }

    private ArrayList<ArrayList<Integer>> path(TreeNode root, int target,int currentSum,ArrayList<Integer> arrayList,ArrayList<ArrayList<Integer>> result) {
        arrayList.add(root.val);
        currentSum += root.val;
        boolean isLeaf = root.left == null && root.right == null;

        Comparator<ArrayList<Integer>> comparator = new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a1, ArrayList<Integer> a2) {
                if(a1.size() < a2.size())
                    return 1;
                else if(a1.size() > a2.size())
                    return -1;
                else
                    return 0;
            }
        };

        if(currentSum == target && isLeaf){
            result.add(new ArrayList<>(arrayList));
            Collections.sort(result, comparator);
        }

        if(root.left != null)
            result = path(root.left,target,currentSum,arrayList,result);

        if(root.right != null)
            result = path(root.right,target,currentSum,arrayList,result);

        arrayList.remove(arrayList.size() - 1);

        return result;
    }
}
