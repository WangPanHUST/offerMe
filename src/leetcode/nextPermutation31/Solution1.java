package leetcode.nextPermutation31;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/8/7 21:08
 * @description
 **/
public class Solution1 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int end = nums.length - 1;
        int pre = Integer.MIN_VALUE;
        //从后往前寻找第一个小于后面数字的位置，这个位置存在下一个更大的字典序排列
        for (; ; end--) {
            if (end >= 0 && nums[end] >= pre) {
                pre = nums[end];
            }else {
                break;
            }
        }
        //如果不存在更大的字典序，将数组倒序
        if (end < 0) {
            reverse(nums, 0, nums.length - 1);
        }else {
            //如果存在更大的字典序，从后往前找到那个大于当前字典序的首数字
            // 3542 → 这里 4 与 3 进行交换
            int needExch = nums[end];
            for (int i = nums.length - 1; i >= 0 ; i--) {
                if (nums[i] > needExch) {
                    exch(nums, end, i);
                    break;
                }
            }
            //对后面的进行倒序
            reverse(nums, end + 1, nums.length - 1);
        }

    }

    private void reverse(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (end + start + 1) / 2;
        int total = start + end;
        while (start < mid) {
            exch(nums, start, total - start);
            start++;
        }
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
