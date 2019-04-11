package OJ;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/4/10 10:39
 * @description
 **/
public class duxiaoman1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Long.valueOf(in.next());
        }

        for (long i:
             numbers) {
            System.out.println(Sort(i));
        }
    }

    private static String Sort(long number){
        if(number < 0)
            return "G";

        HashSet<Long> hashSet = new HashSet<>();
        long v = number;
        while (number > 0){
            hashSet.add(number % 10);
            number /= 10;
        }

        int sum = 0;
        Iterator<Long> iterator = hashSet.iterator();
        for (int i = 0; i < hashSet.size(); i++) {
            long next = iterator.next();
            //坑爹的要求
            if(next == 0){
                sum++;
                continue;
            }
            if(next != 0 && v % next == 0)
                sum++;
        }

        if(sum == hashSet.size())
            return "G";
        else if(sum == 0)
            return "S";
        else
            return "H";
    }
}
