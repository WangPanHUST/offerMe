package offer;

import java.util.Stack;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/4/4 14:55
 * @description 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 * 思路：利用二叉树的非递归中序遍历，没出栈一个，就判断当前的count即中序遍历的第几个数，是否等于k
 **/
public class kthNode {
    private int count = 0;

    public TreeNode KthNode(TreeNode pRoot, int k){
        //二叉树的中序遍历，利用栈，
        Stack<TreeNode> stack = new Stack<>();
        while (pRoot != null || !stack.isEmpty()){
            while (pRoot != null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            pRoot = stack.pop();
            if(k == ++count)
                return pRoot;
            pRoot = pRoot.right;
        }
        return null;
    }


}


//递归解法

//思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
//     所以，按照中序遍历顺序找到第k个结点就是结果。
//public class Solution {
//    int index = 0; //计数器
//    TreeNode KthNode(TreeNode root, int k)
//    {
//        if(root != null){ //中序遍历寻找第k个
//            TreeNode node = KthNode(root.left,k);
//            if(node != null)
//                return node;
//            index ++;
//            if(index == k)
//                return root;
//            node = KthNode(root.right,k);
//            if(node != null)
//                return node;
//        }
//        return null;
//    }
//}
