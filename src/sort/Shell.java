package sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/1/2 21:39
 * @description 希尔排序
 **/
public class Shell {

    public static void sort(Comparable[] a){

        int N = a.length;
        int h = 1;
        while(h < N/3){
            h = 3 * h + 1;
        }

        while(h >= 1){
            for (int i = h; i < N ; i++) {
                for(int j = i;j >= h && less(a[j],a[j-h]);j -= h){
                    exch(a,j,j-h);
                }
            }
            h = h/3;
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

        int N = Integer.parseInt(args[0]);
        //这里不能使用int[] a，因为这样a不是数组对象，得使用 Integer[]表示引用类型
        Integer[] a = new Integer[N];
        for(int i = 0;i < N;i++){
            a[i] = StdRandom.uniform(N);
        }
        show(a);
        sort(a);
        show(a);
    }
}
