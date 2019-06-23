package offer;

import java.util.ArrayList;


/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/6/23 15:50
 * @description 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 **/
public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {

        ArrayList<Integer> arrayList = new ArrayList();

        if (num == null || size <= 0 || size > num.length) {
            return arrayList;
        }

        int maxIndex = 0, lastMaxIndex = 0;

        for (int i = 0; i <= num.length - size ; i++) {
            if (i == 0) {
                maxIndex = maxOfIndex(num, size, -1, 0);
            }else {
                maxIndex = maxOfIndex(num, size, lastMaxIndex, i);
            }

            lastMaxIndex = maxIndex;
            arrayList.add(num[maxIndex]);
        }

        return arrayList;
    }

    private int maxOfIndex(int[] num, int size, int lastMaxIndex, int start) {

        int maxIndex = 0;

        if (lastMaxIndex >= start) {
            maxIndex = num[lastMaxIndex] > num[start + size - 1] ? lastMaxIndex : start + size - 1;
        }else {
            maxIndex = start;
            for (int i = 1; i < size; i++) {
                if (num[start + i] >= num[maxIndex]) {
                    maxIndex = start + i;
                }
            }
        }

        return maxIndex;
    }
}
