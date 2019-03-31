package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/26 20:56
 * @description 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 二叉搜索树，左子树都比跟小，右子树都比根大
 **/
public class verifySquenceofBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)
            return false;

        int start = 0,end = sequence.length - 1;
        return isBST(sequence,start,end);
     }

    private boolean isBST(int[] sequence,int start,int end) {
        if (start >= end)
            return true;

        int root = sequence[end];
        int middle = end - 1;
        for (int i = start; i < end; i++) {
            if (sequence[i] > root) {
                if (i > 0)
                    middle = i - 1;
                else
                    middle = start;
                break;
            }
        }

        boolean result = false;
        for (int j = middle + 1; j < end; j++) {
            if (sequence[j] < root)
                return result;
        }

        result = isBST(sequence, start, middle) && isBST(sequence, middle + 1, end - 1);

        return result;
    }
}
