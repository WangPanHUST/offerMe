package leetcode.search33;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/8/8 10:24
 * @description https://leetcode-cn.com/problems/search-in-rotated-sorted-array/submissions/
 **/
public class Solution1 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }

        return getIndex(nums, target);
    }

    private int getIndex(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            if (nums[start] == target) {
                return start;
            }
            if (nums[end] == target) {
                return end;
            }
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            //mid每次与左侧判断，判断左侧是递增数组，还是右侧是递增数组
            if (nums[mid] > nums[start]) {
                //在 start - mid 是递增数组，与target判断，看是否在左侧数组中
                if (nums[start] <= target && nums[mid] >= target) {
                    end = mid;
                }else {
                    start = mid + 1;
                }
            }else if (nums[mid] < nums[start]){
                //在 mid - end 是递增数组，与target判断，看是否在右侧数组中
                if (nums[mid] <= target && nums[end] >= target){
                    start = mid;
                }else {
                    end = mid - 1;
                }
            }else {
                //相等的情况，此时只有 end - start = 1
                if (nums[start] == target) {
                    return start;
                }
                if (nums[end] == target) {
                    return end;
                }
                return -1;
            }
        }
        return -1;
    }
}
