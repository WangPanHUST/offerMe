package sort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/1/10 19:44
 * @description 三向切分的快速排序，对重复的元素不再排序
 **/
public class Quick3way {

    public static void sort(Comparable[]a){
        StdRandom.shuffle(a);
        sort(a,0,a.length - 1);
    }

    public static void sort(Comparable[] a, int low, int high) {
        Insertion.show(a);
        if(high <= low){
            return;
        }
        int lt = low,i = low + 1,gt = high;
        Comparable v = a[low];
        while (i <= gt){
            int com = a[i].compareTo(v);
            if (com < 0){
                Insertion.exch(a,lt,i);
                lt++;
                i++;
            }else if(com > 0){
                Insertion.exch(a,i,gt);
                gt--;
            }else {
                i++;
            }
        }
        sort(a,low,lt - 1);
        sort(a,gt + 1,high);
    }

    public static void main(String[] args) {
//        int N = Integer.parseInt(args[0]);
//        Integer[] a = new Integer[N];
//        for (int i = 0; i < N ; i++) {
//            a[i] = StdRandom.uniform(0,N);
//        }
        Integer[] a = {3,2,5,1,6,3,3,3};

        sort(a);
        Insertion.show(a);
    }
}
