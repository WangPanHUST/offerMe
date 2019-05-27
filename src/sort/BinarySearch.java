package sort;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/4/22 14:16
 * @description 二分查找，要求待查数组有序
 **/
public class BinarySearch {
    public static int binarySearch(int[] arr,int key){
        int start = 0,end = arr.length - 1;
        int mid = 0;

        if(start > end || key < arr[start] | key > arr[end]) {
            return -1;
        }

        while (start <= end){
            mid = (start + end) / 2;
            if(key > arr[mid]) {
                start = mid + 1;
            } else if(key < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }

        System.out.println(binarySearch(arr,2));
    }
}
