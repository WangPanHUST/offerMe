
package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/1 20:34
 * @description 请实现两个函数，分别用来序列化和反序列化二叉树
 * 序列化二叉树的时使用前序遍历的方式，对为null的左右子树添加"s"来标记，反序列化的过程仍然是一个前序遍历的过程，注意好递归的写法
 **/
public class SeriAndDeseri {

    private static StringBuffer stringBuffer = new StringBuffer();
    private static int i = -1;
    private static final String SIGN = "s";

    public static String serialize(TreeNode root) {
        if(root == null) {
            return null;
        }

        String s = Integer.toString(root.val);
        stringBuffer.append(s);
        stringBuffer.append(",");

        if(root.left == null) {
            stringBuffer.append("s,");
        }
        serialize(root.left);

        if(root.right == null) {
            stringBuffer.append("s,");
        }
        serialize(root.right);

        return stringBuffer.toString();
    }

    public static TreeNode deserialize(String str) {

        if(str == null) {
            return null;
        }

        TreeNode root = null;
        String[] elements = str.split(",");
        i++;
        if(i >= elements.length) {
            return root;
        }

        if(!SIGN.equals(elements[i])) {
            root = new TreeNode(Integer.parseInt(elements[i]));
            root.left = deserialize(str);
            root.right = deserialize(str);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode left = new TreeNode(6);
        TreeNode right = new TreeNode(5);
        root.left = left;
        root.right = right;
        String str = serialize(root);
        System.out.println(str);

        TreeNode treeNode = deserialize("5,4,s,3,s,2");
        System.out.println(treeNode.left.val);
    }
}