package sort;

import java.util.Arrays;

//import chapter1.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/1/12 16:11
 * @description 求两个数组的逆序对数目，数组元素不重复
 *
 **/
public class KendallTau {

    public static int count(int[] a,int[] b){

        //Stopwatch timer2 = new Stopwatch();
        int count = 0;

        if(a.length != b.length){
            return -1;
        }

        int[] aIndex = new int[a.length];
        int[] bIndex = new int[b.length];

        //以value值存储索引，即aIndex[a[i]] = i
        for (int i = 0; i < aIndex.length; i++) {
            aIndex[a[i]] = i;
        }

        //以数组b中的value值对应aIndex中的索引，即以a为基准，b中元素依次对应的索引，即bIndex与标准顺序{0,1,...,N-1}的
        //相对关系，即为b与a的相对关系，所以只需求bIndex插入排序交换的次数即为逆序对数量
        for(int i =0;i < bIndex.length;i++){
            bIndex[i] = aIndex[b[i]];
        }

        for (int i = 1; i < bIndex.length ; i++) {
            for(int j = i;j > 0 && bIndex[j] < bIndex[j-1];j--){
                int temp = bIndex[j];
                bIndex[j] = bIndex[j-1];
                bIndex[j-1] = temp;
                count++;
            }
        }
        //System.out.println("count: " + timer2.elapsedTime());
        return count;
    }

    public static void main(String[] args) {
        //数组的初始化方法
//        int[] a = {0,3,1,6,2,5,4};
//        int[] b = {1,0,3,6,4,2,5};
        int N = 10000;
        int[] a = new int[N];
        int[] b = new int[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = b[i] = i;
        }
        StdRandom.shuffle(a);
        StdRandom.shuffle(b);
        //Arrays.toString(a)
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));

        System.out.println(count(a,b));
    }
}
