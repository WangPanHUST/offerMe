package binarytree;

import java.util.Stack;
import offer.TreeNode;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/4/20 19:08
 * @description 二叉树的中序遍历，循环版本
 **/
public class InOrder {

    public static void in(TreeNode root){
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            //首先让这个节点的所有左节点一次入栈
            while (root.left != null){
                stack.push(root.left);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            System.out.println(temp.val);
            //出栈节点的右节点如果不是null则要进栈，对其右子树进行中序遍历
            if(temp.right != null){
                root = temp.right;
                stack.push(root);
            }
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(9);

        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode2.left = treeNode5;
        in(root);
    }
}
