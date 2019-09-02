package leetcode.threeSum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/8/5 20:59
 * @description https://leetcode-cn.com/problems/3sum/solution/
 * 三数之和等于零求解，排序 + 双指针，o(n2)
 **/
public class Solution1 {
    List<List<Integer>> lists;
    public List<List<Integer>> threeSum(int[] nums) {
        lists = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return lists;
        }

        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            //如果与之前的数字一样，直接跳过，否则可能出现重复的
            if (nums[i] != pre) {
                check(nums, i);
                pre = nums[i];
            }

        }
        return lists;
    }

    private void check(int[] nums, int start) {
        int low = start + 1, high = nums.length - 1;
        while (high > low) {
            if (nums[low] + nums[high] + nums[start] > 0) {
                high--;
            }else if (nums[low] + nums[high] + nums[start] < 0) {
                low++;
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[start]);
                list.add(nums[low]);
                list.add(nums[high]);
                lists.add(list);
                int a = nums[low], b = nums[high];

                //数组下标时刻注意判断是否越界
                while (low < nums.length && nums[low] == a) {
                    low++;
                }
                while (high >=0 && nums[high] == b) {
                    high--;
                }
            }
        }

    }
}
