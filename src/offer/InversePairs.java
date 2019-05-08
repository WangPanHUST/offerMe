package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/12 21:23
 * @description 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 **/
public class InversePairs {
    private static int[] aux;
    private static int count;

    public static int inversePairs(int [] array) {
        if(array == null || array.length == 1) {
            return 0;
        }

        aux = new int[array.length];
        numInSubArray(array,0,array.length - 1);
        return count;
    }

    private static void numInSubArray(int[] array,int start,int end){
        if(end <= start) {
            return;
        }

        int mid = start + (end - start) / 2;
        numInSubArray(array,start,mid);
        numInSubArray(array,mid + 1,end);
        count += merge(array,start,mid,end);
    }

    private static int merge(int[] array,int start,int mid,int end){
        int i = start,j = mid + 1;

        for (int k = start; k <= end; k++) {
            aux[k] = array[k];
        }

        int result = 0;
        for (int k = start; k <= end ; k++) {
            if(i > mid){
                array[k] = aux[j];
                j++;
            }else if(j > end){
                array[k] = aux[i];
                i++;
            }else if(aux[i] < aux[j]){
                array[k] = aux[i];
                i++;
            }else {
                array[k] = aux[j];
                j++;
                result += mid + 1 - i;
            }
        }
        //System.out.println(start + " " + end + " " + Arrays.toString(array) + " " + result);
        return result;
    }

    public static void main(String[] args) {
        //int[] a = {5,6,7,4,3};
        int[] a = {1,2,3,4,5,6,7,0};
        System.out.println(inversePairs(a));
    }
}
