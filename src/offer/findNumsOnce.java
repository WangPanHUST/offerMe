package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/15 15:34
 * @description 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 * {2,4,3,5,6,5,3,2},这里只出现一次的数字就是4和6
 * 先考虑只有1个数字出现1次，则所有的数字按位异或之后得到的result就是那个只出现一次的值，因为相同的数字异或之后都是0
 * 接下来考虑把数组分为两个数组，分别只含有一个只出现一次的数组，再分别进行全体异或得到
 * 全部异或得到的result中从左向右第一个为1的位置，该位置上两个数一个为1，一个为0，根据这个特性将数组分为两个子数组
 * 这里的时间复杂度是o(n)，空间复杂度o(1)
 **/
public class findNumsOnce {
    public static String FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length == 1)
            return " ";

        num1[0] = 0;
        num2[0] = 0;

        int res = 0;
        //获得整体异或之后的值
        for (int i:
             array) {
            res = res ^ i;
        }

        //找到第一个为1的位置，index
        int index = 1,v = 1;
        while ((res & v) == 0){
            index++;
            v <<= 1;
        }

        for (int j:
             array) {
            if(is1Ink(j,index))
                num1[0] ^= j;
            else
                num2[0] ^= j;
        }

        return num1[0] + " " + num2[0];
    }

    private static boolean is1Ink(int i,int k){
        int res = 1;
        for (int j = 0; j < k - 1; j++) {
            res <<= 1;
        }
        if((i & res) == 0)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        int[] a = {2,4,3,5,6,5,3,2};
        int[] num1 = {0};
        int[] num2 = {0};
        System.out.println(FindNumsAppearOnce(a,num1,num2));
    }
}
