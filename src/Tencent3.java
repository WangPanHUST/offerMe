import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/9 20:25
 * @description 给出得分和总局数，求方案种类，对1e9 + 7 取余，快速幂算法和取余防止溢出
 **/
public class Tencent3 {

    public static long sum(int num, int score){
        long result = 1;
        if(score == num)
            return result;

        long big = (long) (1e9 + 7);

        if(score == 0)
            result = quickPow(2,num,big);

        BigInteger total = new BigInteger("1");
        BigInteger sub = new BigInteger("1");

        for (int i = 0; i < score; i++) {
            total = total.multiply(new BigInteger(String.valueOf(num - i)));
            sub = sub.multiply(new BigInteger(String.valueOf(score - i)));
        }

        BigInteger bigInteger = new BigInteger("1000000007");
        long ans = Long.valueOf(total.divide(sub).mod(bigInteger).toString());

        System.out.println(ans);

        result = (ans * quickPow(2,num - score,big)) % big;

        return result;
    }

    //快速幂取余算法，核心是下面的公式 (a * b) % c = (a % c * b % c) % c;
    private static long quickPow(long num,long exponent,long big){
        //a^b % c = (a % c)^ b % c
        num = num % big;
        long ans = 1;

        //如3^5 % 6 = （3^4 % 6 * 3^1 % 6）% 6，4和1对应101，第一位表示4，第三位表示1，每次向右移位1，相当于除2，如果是1，则表示该位需要进入最后的计算
        //num = (num * num) % big，不断加倍，这里进入结果运算的 3^4 % 6 = (3^2 % 6 * 3^2 % 6) % 6
        while (exponent != 0){
            //判断当前位置是不是1，是1则需要参与运算，不是则不需要
            if((exponent & 1) == 1)
                ans = (ans * num) % big;
            exponent >>= 1;
            num = (num * num) % big;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int score = in.nextInt();

        for (int i = 0; i < num; i++) {

        }

        System.out.println(sum(num,score));
    }
}






