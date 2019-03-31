package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/14 21:57
 * @description 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 运用二叉树的递归遍历的变体，对每个根节点，如果左子树的深度大于右子树，则深度就是 1 + 左子树的深度，反之是加右子树的深度，可以运用递归的思想做
 **/
public class treeDepth {
    public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;

        int leftLen = TreeDepth(root.left);
        int rightLen = TreeDepth(root.right);
        return (leftLen > rightLen) ? (leftLen + 1):(rightLen + 1);
    }
}
