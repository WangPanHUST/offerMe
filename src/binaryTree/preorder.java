package binaryTree;

import java.util.Stack;
import offer.TreeNode;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/4/20 17:01
 * @description 二叉树的前序遍历，循环版本
 **/
public class preorder {

    public static void pre(TreeNode root){
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.println(temp.val);
            //每出栈一个依次把右左子点入栈
            if(temp.right != null)
                stack.push(temp.right);
            if(temp.left != null)
                stack.push(temp.left);
        }
    }

    public static void main(String[] args) {
       TreeNode root = new TreeNode(1);
       TreeNode treeNode1 = new TreeNode(3);
       TreeNode treeNode2 = new TreeNode(7);
       TreeNode treeNode3 = new TreeNode(6);
       TreeNode treeNode4 = new TreeNode(5);

        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode2.right = treeNode4;
        pre(root);
    }

}
