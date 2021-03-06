package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/15 11:13
 * @description 输入一棵二叉树，判断该二叉树是否是平衡二叉树。平衡二叉树即其左右子树的高度差不超过1，且左右子树均为平衡二叉树。
 * 运用递归判断它的所有节点是否都是平衡二叉树。用前序遍历的方式，每个子树会被重复遍历，浪费时间
 * 在遍历子树的时候发现不是平衡二叉树直接返回，不再判断，避免重复判断，后序遍历，动态规划思想
 **/
public class IsBalanced {
    public boolean isBalancedSolution(TreeNode root) {
        return treeDepth(root) == -1;
    }

    private int treeDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftLen = treeDepth(root.left);
        if(leftLen == -1) {
            return -1;
        }

        int rightLen = treeDepth(root.right);
        if(rightLen == -1) {
            return -1;
        }

        if(Math.abs(leftLen - rightLen) <= 1) {
            return (leftLen > rightLen) ? (leftLen + 1):(rightLen + 1);
        } else {
            return -1;
        }
    }

}
