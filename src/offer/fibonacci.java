package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/21 19:20
 * @description 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * 青蛙跳台阶问题也是，但是当n=2有两种跳法，不同于斐波那契
 **/
public class fibonacci {
    public int Fibonacci(int n) {
        if(n <= 0)
            return 0;
        else if(n == 1)
            return 1;

        int a = 0,b = 1,c = 0;
        for(int i = 2;i <= n;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;

    }
}
