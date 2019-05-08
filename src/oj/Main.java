package oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/17 19:52
 * @description n条桌腿，稳定条件：保证最长桌腿长度的数量大于总数量的一半，卸掉每条桌腿需要不同的能量，为了保持稳定，求需要能量的最小值
 * 输入 桌腿长度：2 3 3 5，对应的能量：1 3 3 3，则最小值为3，卸掉长度为5的桌腿
 **/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] lens = new int[n];
        int[] ds = new int[n];

        for(int i = 0; i < n; i++)
            lens[i] = sc.nextInt();

        for (int i = 0; i < n; i++) {
            ds[i] = sc.nextInt();
        }

        System.out.println(energy(lens,ds));
    }

    private static int energy(int[] lens,int[] ds){
        if(lens.length == 1)
            return 0;
        if(lens.length == 2){
            if(ds[0] == ds[1])
                return 0;
            else
                return (ds[0] < ds[1])? ds[0]:ds[1];
        }

        //思路有问题
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < lens.length; i++)
            treeMap.put(lens[i],ds[i]);

        int[] num = new int[201];
        for (int i:
             ds) {
            num[i]++;
        }

        Arrays.sort(lens);
        int newLen = 0;
        int left = 0;
        int ans = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();

        Collections.sort(arrayList);
        return arrayList.get(0);
    }
}
