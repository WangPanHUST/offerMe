package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/19 13:23
 * @description 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * while判断条件如果pNode.next = null，则pNode.next.right会报无效指针的错误，注意对判断情况的合并
 **/
public class GetNextNode {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public static TreeLinkNode getNext(TreeLinkNode pNode)
    {
        if(pNode == null) {
            return null;
        }

        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }else{
            while (pNode.next != null){
                if(pNode == pNode.next.left) {
                    return pNode.next;
                }
                pNode = pNode.next;
            }
            //System.out.println(pNode.val);
            return null;
        }


//这里的while判断条件如果pNode.next = null，则pNode.next.right会报无效指针的错误
//        else if(pNode.right == null && pNode.next.right == pNode){
//            while(pNode.next != null && pNode == pNode.next.right){
//                pNode = pNode.next;
//                System.out.println(pNode.val);
//            }
//            if(pNode.next == null)
//                pNode = null;
//            else
//                pNode = pNode.next;
//        }
    }

    public static void main(String[] args) {
        TreeLinkNode treeLinkNode = new TreeLinkNode(1);
        TreeLinkNode treeLinkNode1 = new TreeLinkNode(2);
        TreeLinkNode treeLinkNode2 = new TreeLinkNode(3);
        treeLinkNode.right = treeLinkNode1;
        treeLinkNode1.right = treeLinkNode2;
        treeLinkNode1.next = treeLinkNode;
        treeLinkNode2.next = treeLinkNode1;
        TreeLinkNode a = getNext(treeLinkNode2);
        if(a != null) {
            System.out.println(a.val);
        }
    }
}
