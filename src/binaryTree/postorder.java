package binaryTree;

import java.util.ArrayList;
import java.util.Stack;

import offer.TreeNode;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/4/20 19:33
 * @description 二叉树的后序遍历，循环版本，利用两个栈，一个主栈一个辅助栈，当两个栈栈顶元素相同时输出，在中序遍历的基础上进行改进
 **/
public class postorder {

    public static void post(TreeNode root){
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        //stack1用来保存那些暂时不输出的根节点
        Stack<TreeNode> stack1 = new Stack<>();
        stack.push(root);
        System.out.println("postorder output:");
        while (!stack.isEmpty()){
            while (root.left != null){
                stack.push(root.left);
                root = root.left;
            }

            TreeNode temp = stack.peek();
            //右节点为null时这个节点可以输出，无论其是左节点还是右节点
            if(temp.right == null){
                System.out.print(stack.pop().val + " ");
                //当temp是右节点时候要把根节点也输出，输出的条件是两个栈的栈顶元素相同
                while(!stack1.isEmpty() && stack.peek() == stack1.peek()){
                    System.out.print(stack1.pop().val + " ");
                    stack.pop();
                }
            } else {
                stack1.push(temp);//根节点要进入stack1
                root = temp.right;
                stack.push(root);
            }
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(9);
        TreeNode treeNode6 = new TreeNode(8);
        TreeNode treeNode7 = new TreeNode(10);
        TreeNode treeNode8 = new TreeNode(88);

        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        treeNode6.left = treeNode7;
        treeNode6.right = treeNode8;
        post(root);
    }
}
