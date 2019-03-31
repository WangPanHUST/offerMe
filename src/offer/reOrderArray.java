package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/23 11:41
 * @description 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分。
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 插排思想，将奇数顺序移动到前面，剩下的顺序后移 利用新建数组也可以 Arrays.toString打印数组
 **/
public class reOrderArray {
    public static void reOrder(int[] array){
        if(array.length == 0 || array == null)
            return;

        int evenIndex = 0;
        while (evenIndex < array.length){
            if(isEven(array[evenIndex])){
                for (int oddIndex = evenIndex + 1; oddIndex < array.length; oddIndex++) {
                    //关键，将偶数位顺序后移！
                    if(!isEven(array[oddIndex])){
                        int temp = array[oddIndex];
                        while (oddIndex > evenIndex){
                            array[oddIndex] = array[oddIndex - 1];
                            oddIndex--;
                        }
                        array[evenIndex] = temp;
                        break;
                    }
                }
            }
            evenIndex++;
        }
    }

    private static boolean isEven(int n){
        if(n % 2 == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,6,6,9,5,2,0};
        reOrder(a);
        System.out.println(Arrays.toString(a));
    }
}
