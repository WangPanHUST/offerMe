package sort;

import edu.princeton.cs.algs4.StdRandom;
import sort.Insertion;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/1/13 13:12
 * @description 冒泡排序每次交换相邻的一对元素，一趟排序将最大的数交换的到队尾
 * 时间复杂度：o(n2)，可以设置标志位当没发生交换时候跳出外层循环，一定程度上可以降低复杂度。
 **/
public class Bubble {

    //变体：设置标志位即交换次数，当交换次数为0时，数组已经有序
    //变体：先从低到高，即一趟排序，先将最大的数放到队尾，再从高到底排序，将最小的数放到队首
    public static void sort(Comparable[] a){
        int N = a.length - 1;
        for (int n = N; n > 0; n--) {
            for (int i = 0; i < n; i++) {
                if(Insertion.less(a[i+1],a[i])){
                    Insertion.exch(a,i,i+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Integer[] a = new Integer[N];
        for (int i = 0; i < N ; i++) {
            a[i] = StdRandom.uniform(0,N);
        }
        Insertion.show(a);
        sort(a);
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Insertion.show(a);
    }
}
