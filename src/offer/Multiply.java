package offer;

import java.util.Arrays;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/23 14:41
 * @description 给定一个数组a[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=a[0]*a[1]*...*a[i-1]*a[i+1]*...*a[n-1]。不能使用除法。
 * 思路：暴力解法，B中的每个元素都用n次乘法实现，复杂度为o(n2)
 * 利用空间换时间，将右侧分为两部分，a[0]*a[1]*...*a[i-1] 和 a[i+1]*...*a[n-1]
 **/
public class Multiply {
    public static int[] multiply(int[] a) {
        int[] left = new int[a.length];
        int[] result = new int[a.length];
        int right = 1;
        left[0] = 1;

        for (int i = 1; i < a.length; i++) {
            left[i] = a[i-1] * left[i-1];
        }

        for (int i = a.length - 1; i >= 0 ; i--) {
            result[i] = left[i] * right;
            right *= a[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        System.out.println(Arrays.toString(multiply(a)));
    }
}