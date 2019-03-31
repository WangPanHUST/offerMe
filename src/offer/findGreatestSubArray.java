package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/6 21:00
 * @description 求数组中所有子数组中的最大和
 * 动态规划
 **/
public class findGreatestSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null)
            return 0;
        if (array.length == 1)
            return array[0];

        int curSum = array[0],max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(curSum < 0)
                curSum = array[i];
            else
                curSum += array[i];

            if(curSum > max)
                max = curSum;
        }

        return max;
    }


}
