/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/14 20:43
 * @description 统计一个数字在排序数组中出现的次数。
 * 使用改进的二分法查找，即利用二分找到该数出现的首位和末位，算法不难，主要是对越界的考虑，访问数组务必确保没有超出索引
 **/
public class getNumberOfk {
    private static int low = -1,high = -2;

    public static int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0)
            return 0;
        if(array[0] > k || array[array.length - 1] < k)
            return 0;

        number(array,0,array.length - 1,k);
        return high - low + 1;
    }

    private static void number(int[] array,int start,int end,int k){
        //程序中对数组的start end时候，一定要有意识判断end>=start成立不
        if(start > end)
            return;

        int mid = start + (end - start) / 2;

        if(k < array[mid])
            number(array,start,mid - 1,k);
        else if(k > array[mid])
            number(array,mid + 1,end,k);
        else{
            if(low == -1){
                //访问数组的某位时候，要先看该位是否超出了索引！
                if(mid > 0 && array[mid - 1] == k)
                   number(array,start,mid - 1,k);
                else
                    low = mid;
            }

            if(mid < array.length - 1 && array[mid + 1] == k)
                number(array,mid + 1,end,k);
            else
                high = mid;
        }
        System.out.println(low + " " + high);
    }

    public static void main(String[] args) {
        int[] a = {3,3,3,3,4,5};
        System.out.println(GetNumberOfK(a,3));
    }
}
