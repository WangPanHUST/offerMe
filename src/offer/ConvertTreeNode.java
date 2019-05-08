package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/1 15:19
 * @description 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 **/
public class ConvertTreeNode {
    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode convert(TreeNode root) {
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        //根据左根右的中序遍历进行递归，先递归左子树，遍历之后的pre即是最后的节点，中间是对根节点的操作，最后对右节点遍历！
        //递归出现的顺序与遍历二叉树的顺序一致
        inOrder(node.left);
        node.left = pre;
        if (pre != null) {
            pre.right = node;
        }
        pre = node;
        if (head == null) {
            head = node;
        }
        inOrder(node.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        TreeNode treeNode1 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(14);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        //System.out.println(convert(treeNode).val);
    }
}
