package oj;

import java.util.Scanner;
/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/4/14 10:44
 * @description
 **/


public class byteDance3{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());

        int[] ens = new int[num + 1];
        for (int i = 1; i < num + 1; i++)
            ens[i] = in.nextInt();

        int next = 0;
        for (int i = num; i > 0; i--) {
            if ((ens[i] + next) % 2 == 0)
                next = (ens[i] + next) / 2;
            else
                next = (ens[i] + next) / 2 + 1;
        }

        System.out.println(next);
    }
}


