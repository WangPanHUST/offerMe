package sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/1/1 21:30
 * @description 选择排序，将全部元素从左向右依次与右边所有元素比较，依次把最小的元素放到对应的位置
 * 选择排序是冒泡排序的倒置版本，每次遍历保证索引为i的位置上是第i+1小的数
 **/
public class Selection {

    public static void sort(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            //将a[i]与右侧元素中的最小元素交换
            for(int j = i + 1;j < a.length;j++){
                if(less(a[j],a[i])){
                    exch(a,i,j);
                }
            }
        }
    }

    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a,int i,int j){
        Comparable t = a[j];
        a[j] = a[i];
        a[i] = t;
    }

    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(0,N);
        }
        sort(a);
        show(a);
    }
}
