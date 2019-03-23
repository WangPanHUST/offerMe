/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/21 22:04
 * @description 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 **/
public class numberOf1 {
    public static int NumberOf1(int n) {
        int count = 0,i = 1;

        while(i != 0){
            if((n & i) != 0)
                count++;
            i = i << 1;
        }

        //最优解 减1会将最右边的1变0,0变1
//        while(n != 0){
//            count++;
//            n = (n - 1) & n;
//        }
        return count;
    }

    public static void main(String[] args) {
        int a = -3;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(NumberOf1(a));
    }
}
