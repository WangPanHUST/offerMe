package sort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/1/11 21:32
 * @description 堆排序，堆排序N个元素，只需少于 2NlgN + 2N 次比较
 * 首先将元素构造为大顶堆，即每个根节点都比叶子节点大，从最后一个非叶子节点开始，依次判断该节点是否符合
 **/
public class Heap {

    public static void sort(Comparable[] a){
        int N = a.length;

        //对每个非叶子节点进行sink构造大顶堆，最后一个非叶子节点即是 N/2
        for(int k = N/2;k >= 1;k--){
            sink(a,k,N);
        }
        while (N > 1){
            //将最小值交换至末尾
            exch(a,1,N--);

            //树的长度减1，把剩下的数组进行堆有序操作，只用对更换的根节点进行sink操作
            sink(a,1,N);
        }
    }

    public static void sink(Comparable[] a, int k, int n) {
        while (2*k <= n){
            int j =2*k;
            //选取最大的子树
            if(j < n && less(a,j,j+1)){
                j++;
            }
            //如果根节点即最大，则不需交换，直接退出
            if(!less(a,k,j)) break;

            //将最大子树交换至根节点
            exch(a,k,j);
            k = j;
        }
    }


    //树的位置是从1开始的，但是数组索引是从0开始，故应重写成这样
    public static boolean less(Comparable[] a, int i, int j) {
        return a[i-1].compareTo(a[j-1]) < 0;
    }

    public static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Integer[] a = new Integer[N];
        for (int i = 0; i < N ; i++) {
            a[i] = StdRandom.uniform(0,N);
        }
        Insertion.show(a);
        sort(a);
        Insertion.show(a);
    }

}
