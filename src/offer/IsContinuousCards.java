package offer;

import java.util.Arrays;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/17 14:59
 * @description 从一副牌中抽出5张，看是否连续，其中大小王为0，可以抵任意牌
 * 思路：先排序，看0的个数是否大于空缺的个数，且不能出现对子
 * 当n较小时候，利用辅助哈希数组存储每个数字出现的个数，之后对原数组重新装填，完成排序，时间复杂度o(n)
 **/
public class IsContinuousCards {
    public static boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length != 5) {
            return false;
        }

        sort(numbers);

        int numOf0 = 0;
        int numOfGap = 0;

        int index0 = 0;
        while (numbers[index0] == 0){
            numOf0++;
            index0++;
            if(numOf0 > 2) {
                return false;
            }
        }

        int pre = numbers[index0];
        for (int i = index0 + 1; i < numbers.length; i++) {
            if (numOfGap > numOf0) {
                return false;
            }

            int gap = numbers[i] - pre;
            if (gap == 0) {
                return false;
            } else {
                numOfGap += gap - 1;
            }

            pre = numbers[i];
        }
        return numOf0 >= numOfGap;
    }

    private static void sort(int[] numbers){
        //辅助哈希数组存储每个数字出现的次数
        int[] times = new int[14];
        for (int i:
             numbers) {
            times[i]++;
        }

        int index = 0;
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < times[i]; j++) {
                numbers[index] = i;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0,3,2,5,4};
        System.out.println(isContinuous(a));
    }
}
