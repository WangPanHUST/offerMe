package sort;

import java.util.Arrays;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/1/12 14:38
 * @description 归并排序，使用了辅助数组，空间复杂度增加为o(n)，时间复杂度为o(nlgn)，且时间复杂度稳定，对每一层的元素进行归并都需要n的时间复杂度，有lgn层
 **/
public class Merge {

    private static Comparable[] aux;

    public static void merge(Comparable[] a,int low,int mid,int high){
        int i = low,j = mid + 1;

        //理解递归过程中对辅助数组的逐步填充
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        for(int k = low;k <= high;k++){
            //一定要先判断归并的一侧是否已经到头了
            if(i > mid){
                a[k] = aux[j];
                j++;
            }else if(j > high){
                a[k] = aux[i];
                i++;
            }else if(Insertion.less(aux[i],aux[j])){
                a[k] = aux[i];
                i++;
            }else{
                a[k] = aux[j];
                j++;
            }
        }

    }

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length - 1);
    }

    public static void sort(Comparable[] a,int low,int high){
        if(high <= low){
            return;
        }
        int mid = low + (high - low)/2;
        sort(a,low,mid);
        sort(a,mid + 1,high);
        merge(a,low,mid,high);
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
