package sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/1/1 20:52
 * @description 插入排序，索引i左侧的元素总是有序的，即将索引为i的元素插入到左边i-1个元素中合适的位置，内循环从右向左开始判断，
 * 只用当右侧小与左侧时，才发生交换，故时间复杂度最坏o(n2)，最好时候只需外循环，为o(n)
 **/
public class Insertion {

    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i = 1;i < N;i++){
            for(int j = i;j > 0 && less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
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

    public static void main(String[] args){
        //args type:String
        int N = Integer.parseInt(args[0]);
        //这里不能使用int[] a，因为这样a不是数组对象，得使用 Integer[]表示引用类型
        Integer[] a = new Integer[N];
        for(int i = 1;i <= N;i++){
            a[i] = StdRandom.uniform(N);
        }
        sort(a);
        show(a);
    }
}
