package offer;

import java.util.ArrayList;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/6/24 18:45
 * @description 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 时间复杂度o(n)，扫描一遍数组即可
 **/
public class FindNumberWithSum {

    public static void main(String[] args) {
        int[] array = new int[] {1,2,4,7,11,15};
        ArrayList<Integer> arrayList = findNumbersWithSum(array, 15);
        System.out.println(arrayList.toString());
    }

    public static ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();

        if (array == null) {
            return result;
        }

        int low = 0, high = array.length - 1;
        int multiply = Integer.MAX_VALUE;

        while (low < high) {
            if (array[low] + array[high] == sum) {
                int temp = array[low] * array[high];
                if (temp < multiply) {
                    if (!result.isEmpty()) {
                        result.set(0, array[low]);
                        result.set(1, array[high]);
                    }else {
                        result.add(array[low]);
                        result.add(array[high]);
                    }
                    multiply = temp;
                }
                low++;
                high--;
            }else if (array[low] + array[high] < sum) {
                low++;
            }else {
                high--;
            }
        }

        return result;
    }

}
