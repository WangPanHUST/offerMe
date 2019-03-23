/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/17 20:28
 * @description 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 **/
public class reConstructBT {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x;}
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in){
        if(pre.length == 0 || in.length == 0 || pre.length != in.length)
            return null;

        //静态方法必须引用静态变量
        TreeNode treeNode = new TreeNode(pre[0]);
        TreeNode leftNode;
        TreeNode rightNode;

        int i = 0;
        while (in[i] != pre[0])
            i++;

        if(i > 0){
            int[] leftPre = new int[i];
            System.arraycopy(pre,1,leftPre,0,i);
            int[] leftIn = new int[i];
            System.arraycopy(in,0,leftIn,0,i);
            leftNode = reConstructBinaryTree(leftPre,leftIn);
        }else{leftNode = null;}


        if(pre.length -1 - i > 0){
            int[] rightPre = new int[pre.length - 1 - i];
            System.arraycopy(pre,i + 1,rightPre,0,pre.length - 1 - i);
            int[] rightIn = new int[pre.length - 1 - i];
            System.arraycopy(in,i + 1,rightIn,0,pre.length - 1 - i);
            rightNode = reConstructBinaryTree(rightPre,rightIn);
        }else{rightNode = null;}

        treeNode.left = leftNode;
        treeNode.right = rightNode;

        return treeNode;
    }

    public static TreeNode reCounstructBinaryTree(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
        if(startPre > endPre || startIn > endIn)
            return null;

        TreeNode treeNode = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if(in[i] == pre[startPre]){
                //关于pre的start和end 注意不要直接使用i
                treeNode.left = reCounstructBinaryTree(pre,startPre + 1,i - startIn + startPre,in,startIn,i - 1);
                treeNode.right = reCounstructBinaryTree(pre,endPre - (endIn - i) + 1,endPre,in,i + 1,endIn);
                break; //跳出循环
            }
        }

        return treeNode;
    }

    public static void main(String[] args) {
//        int[] pre = {1,2,4,7,3,5,6,8,};
//        int[] in = {4,7,2,1,5,3,8,6};
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        TreeNode treeNode = reConstructBinaryTree(pre,in);
        TreeNode treeNode1 = reCounstructBinaryTree(pre,0,pre.length - 1,in,0,in.length - 1);
        System.out.println(treeNode1.left.right.val);
        System.out.println(treeNode.left.right.left == null);
    }
}



