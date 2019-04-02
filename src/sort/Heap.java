package sort;

import java.util.HashMap;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/1/11 21:32
 * @description 堆排序，堆排序N个元素，只需少于 2NlgN + 2N 次比较
 * 首先将元素构造为大顶堆，即每个根节点都比叶子节点大，从最后一个非叶子节点开始，依次判断该节点是否符合都大于叶子的条件
 * 大顶堆确保了最大元素始终位于堆顶，从堆顶开始依次将堆顶元素交换至数组末尾，然后对长度减1的数组进行大顶堆的重构造，只需将现在的堆顶元素进行sink操作，放到合适的位置即可
 **/
public class Heap {

    public static void sort(Comparable[] a){
        int N = a.length - 1;

        //对每个非叶子节点进行sink构造大顶堆，最后一个非叶子节点即是 N/2
        for(int k = N / 2 - 1;k >= 0;k--)
            sink(a,k,N);

        while (N > 0){
            //将最小值交换至末尾
            Insertion.exch(a,0,N--);

            //树的长度减1，把剩下的数组进行堆有序操作，只用对更换的根节点进行sink操作
            sink(a,0,N);
        }
    }

    public static void sink(Comparable[] a, int k, int n) {
        while (2 * k + 1 <= n){
            int j = 2 * k + 1;
            //选取最大的子树
            if(j < n && Insertion.less(a[j],a[j+1])){
                j++;
            }

            //如果根节点即最大，则不需交换，直接退出
            if(!Insertion.less(a[k],a[j])) break;

            //将最大子树交换至根节点
            Insertion.exch(a,k,j);
            k = j;
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
        Insertion.show(a);
    }

}
