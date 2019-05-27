package sort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/1/8 21:43
 * @description 快速排序，利用递归每次查找哨兵的位置，将哨兵两侧的元素递归排序
 * 时间复杂度：最好o(nlgn)，平均o(1.39nlgn)，最坏o(n2)
 **/
public class Quick {

    public static void sort(Comparable[]a){
        StdRandom.shuffle(a);
        sort(a,0,a.length - 1);
    }

    public static void sort(Comparable[] a, int low, int high) {
        //终止递归的条件
        if(high <= low){
            return;
        }
        int j = partitioin(a,low,high);
        //排序的部分不包含a[j]，否则会死循环
        sort(a,low,j - 1);
        sort(a,j + 1,high);
    }

    public static int partitioin(Comparable[] a,int low,int high){
        Comparable v = a[low];
        //这种比较方式没有死循环
        int i = low,j = high + 1;
        while (true){
            //从左开始寻找比v大的值，//当数组长度为1时，这里可能会索引无效，注意
            while (Insertion.less(a[++i],v)){
                if(i == high){
                    break;
                }
            }
            //从右开始寻找比v小的值
            while (Insertion.less(v,a[--j])){
                if(j == low){
                    break;
                }
            }
            //终止循环的条件，指针相遇
            if(i >= j){
                break;
            }
            Insertion.exch(a,i,j);
        }
        //将a[low]与a[j]交换，因为a[j]是小于a[low]的最右边的值，同理a[i]是大于a[low]的最左边的值
        //交换之后可以保证i < j 时，a[j] < a[low]，而右边的数都是大于等于a[low]的
        Insertion.show(a);
        Insertion.exch(a,low,j);
        return j;
    }

    public static void main(String[] args) {
//        int N = Integer.parseInt(args[0]);
//        Integer[] a = new Integer[N];
//        for (int i = 0; i < N ; i++) {
//            a[i] = StdRandom.uniform(0,N);
//        }
        Integer[] a = {3,2,5,1,6};

        sort(a);
        Insertion.show(a);
    }
}
