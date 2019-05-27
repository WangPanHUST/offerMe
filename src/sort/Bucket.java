package sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/5/23 17:26
 * @description 桶排序，非比较排序
 **/
public class Bucket {

    private static void sort(int[] a) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int len = a.length;

        for (int i = 0; i < len; i++) {
            max = Math.max(max, a[i]);
            min = Math.min(min, a[i]);
        }

        int bucketNum = (max - min) / len + 1;
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new ArrayList<>());
        }

        for (int anA : a) {
            int index = (anA - min) / len;
            bucket.get(index).add(anA);
        }

        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(bucket.get(i));
        }

        System.out.println(bucket.toString());

    }

    public static void main(String[] args) {
        int[] a = new int[] {0,9,2,5,5,5,5,5};
        sort(a);
    }

}
