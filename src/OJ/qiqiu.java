package OJ;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/9 21:22
 * @description
 **/
public class qiqiu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int color = in.nextInt();
        int[] array = new int[total];
        for (int i = 0; i < total ; i++) {
            array[i] = in.nextInt();
        }
        System.out.println(num(array,color));
    }

    public static int num(int[] array,int color){
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < array.length && hashSet.size() <= color; i++) {
            if(array[i] != 0)
                hashSet.add(array[i]);
        }

        for (int i = 0; i < color ; i++) {

        }

        return 6;
    }
}
