package offer;

import java.util.Arrays;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/11 19:22
 * @description 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 2 3 5都是质数，称为质因子，用当前数组的数分别去乘2 3 5，分别得到第一个大于当前数组最大值的值，同时记下乘以2对应的位置p2，以及p3 p5，然后顺次更新数组
 **/
public class UglyNumber {
    public static int getUglyNumberSolution(int index) {
        if(index <= 0) {
            return 0;
        }

        int[] uglyNum = new int[index];

        if(index <= 5) {
            return index;
        }

        for (int i = 0; i < 5; i++) {
            uglyNum[i] = i + 1;
        }

        int p2 = 1,p3 = 1,p5 = 1;
        int m2 = 1,m3 = 1,m5 = 1,min = 1;
        for (int i = 5; i < index; i++) {
            for (int j = p2; j < i; j++) {
                m2 = 2 * uglyNum[j];
                if(m2 > uglyNum[i - 1]){
                    p2 = j;
                    min = m2;
                    break;
                }
            }

            for (int j = p3; j < i; j++) {
                m3 = 3 * uglyNum[j];
                if(m3 > uglyNum[i - 1]){
                    p3 = j;
                    break;
                }
            }

            if(m3 < min) {
                min = m3;
            }

            for (int j = p5; j < i; j++) {
                m5 = 5 * uglyNum[j];
                if(m5 > uglyNum[i - 1]){
                    p5 = j;
                    break;
                }
            }

            if(m5 < min) {
                min = m5;
            }

            uglyNum[i] = min;
        }
        System.out.println(Arrays.toString(uglyNum));
        return uglyNum[index - 1];
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumberSolution(15));
    }
}
