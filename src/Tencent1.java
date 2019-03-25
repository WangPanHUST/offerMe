import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/9 19:36
 * @description 有1-n，n种面值的货币且数量不限，问给出金钱，货币最少的数量是多少 （腾讯提前批1题）
 **/
public class Tencent1 {

    public static int num(int money,int total){
        if(total == 0)
            return 0;

        if(total <= money)
            return 1;

        int result = 0;

        if(total % money == 0)
            result = total / money;
        else
            result = total / money + 1;

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int money = in.nextInt();
        int total = in.nextInt();
        System.out.println(num(money,total));
    }
}
