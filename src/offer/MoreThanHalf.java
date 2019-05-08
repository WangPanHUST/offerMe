package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/5 14:11
 * @description 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 寻找第k大的数字，寻找出中位数，再看是否出现了超过一半
 **/
public class MoreThanHalf {
    public static int moreThanHalfNumSolution(int [] array) {
        int result = 0;
        if(array == null) {
            return result;
        }

        if(array.length == 1) {
            return array[0];
        }

        int start = 0;
        int end = array.length - 1;
        int middle = array.length / 2;
        int index = partition(array,start,end);
        System.out.println(index);

        while (index != middle){
            if(index > middle){
                end = index - 1;
                index = partition(array,start,end);
            }else {
                start = index + 1;
                index = partition(array,start,end);
            }
        }

        int num = 0;
        for (int e:
             array) {
            if(e == array[middle]) {
                num++;
            }
        }


       if(2 * num > array.length) {
           result = array[middle];
       }

       return result;
    }

    //返回的是第一个数在数组中的位置，即排完序后array[]中的索引
    private static int partition(int[] array,int start,int end){
        int v = array[start];

        int i = start,j = end + 1;
        while (true){
            //当数组长度为1时，这里可能会索引无效，注意
            while (array[++i] < v){
                if(i == end) {
                    break;
                }
            }

            while (v < array[--j]){
                if(j == start) {
                    break;
                }
            }

            if(i >= j) {
                break;
            }

            exch(array,i,j);
        }
        exch(array,j,start);

        return j;
    }

    private static void exch(int[] array,int i,int j){
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
        return;
    }


    public static void main(String[] args) {
        int[] a = {2,1,3};
        int result = moreThanHalfNumSolution(a);
        System.out.println(result);
    }
}
