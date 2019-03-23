import java.util.Arrays;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/23 14:41
 * @description 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 思路：暴力解法，B中的每个元素都用n次乘法实现，复杂度为o(n2)
 * 利用空间换时间，将右侧分为两部分，A[0]*A[1]*...*A[i-1] 和 A[i+1]*...*A[n-1]
 **/
public class multiply {
    public static int[] multiply(int[] A) {
        int[] left = new int[A.length];
        int[] result = new int[A.length];
        int right = 1;
        left[0] = 1;

        for (int i = 1; i < A.length; i++)
            left[i] = A[i-1] * left[i-1];

        for (int i = A.length - 1; i >= 0 ; i--) {
            result[i] = left[i] * right;
            right *= A[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a ={1,2,3,4};
        System.out.println(Arrays.toString(multiply(a)));
    }
}
