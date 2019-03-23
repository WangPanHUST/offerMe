/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/25 19:38
 * @description 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 树的遍历一般是递归，这里先对树A进行遍历寻找与B的根相等的节点，找到之后对B进行遍历，判断是否每个节点都相等。
 **/
public class hasSubTree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null)
            return false;

        boolean result = false;

        if(root1.val == root2.val)
            result = hasLandR(root1,root2);
        if(!result)
            result = HasSubtree(root1.left,root2);
        if(!result)
            result = HasSubtree(root1.right,root2);

        return result;
    }

    private boolean hasLandR(TreeNode root1,TreeNode root2){
        //递归的特质 先判断最后一步的结果，其他递归
        // if(root2 == null)
        // 	return true;
        // if(root1 == null)
        // 	return false;
        // if(root1.val != root2.val)
        // 	return false;

        // return hasLandR(root1.left,root2.left) && hasLandR(root1.right,root2.right);

        boolean left = false;
        boolean right = false;

        if(root2.left == null)
            left = true;
        else{
            if(root1.left == null)
                left = false;
            else{
                if(root2.left.val == root1.left.val)
                    left = hasLandR(root1.left,root2.left);
                else
                    left = false;
            }
        }

        if(left){
            if(root2.right == null)
                right = true;
            else{
                if(root1.right == null)
                    right = false;
                else{
                    if(root2.right.val == root1.right.val)
                        right = hasLandR(root1.right,root2.right);
                    else
                        right = false;
                }

            }
        }

        return left && right;
    }

    public static void main(String[] args) {

    }

}
