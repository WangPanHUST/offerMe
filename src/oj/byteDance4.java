package oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/4/14 11:24
 * @description 输入第一行代表有n个城市，下面每i行是第i个城市到其他城市的票价，问从第一个城市出发，每个城市去一次，最后回到第一个城市，问最少花费
 * 如输入：则最小花费为12，数组p初始为[0,1,2,3,0]，minCost函数求中间3位的排列组合，最后判断所有组合中花费最小的值
 * 4
 * 0 1 2 6
 * 1 0 3 4
 * 2 3 0 5
 * 6 4 5 0
 **/
public class byteDance4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] strs = in.nextLine().split(" ");
            for (int j = 0; j < n; j++)
                cost[i][j] = Integer.valueOf(strs[j]);
        }

        Integer[] p = new Integer[n + 1];
        p[n] = 0;
        for (int i = 0; i < n; i++)
            p[i] = i;

        HashSet<Integer[]> hashSet = new HashSet<>();
        hashSet = minCost(p,1,hashSet);

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer[] i:
             hashSet) {
            int c = 0;
            System.out.println(Arrays.toString(i));
            for (int j = 0; j < i.length - 1; j++) {
                c += cost[i[j]][i[j + 1]];
            }
            System.out.println(c);
            System.out.println();
            arrayList.add(c);
        }
        Collections.sort(arrayList);
        System.out.println(arrayList.get(0));
    }

    public static HashSet<Integer[]> minCost(Integer[] p,int start, HashSet<Integer[]> hashSet){

        if(start == p.length - 1)
            return hashSet;

        for (int i = 1; i < p.length - 1; i++) {
            int temp = p[start];
            p[start] = p[i];
            p[i] = temp;

            //数组的的复制
            Integer[] t = Arrays.copyOf(p,p.length);
            hashSet.add(t);

            hashSet = minCost(t,start + 1,hashSet);

            int temp1 = p[i];
            p[i] = p[start];
            p[start] = temp1;
        }

        return hashSet;
    }
}
