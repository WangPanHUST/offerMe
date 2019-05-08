package leetcode.twosum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/5/8 14:28
 * @description https://leetcode-cn.com/problems/two-sum/ 时间o(n) 空间o(n)
 **/
public class Solution1 {
    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i],i);
        }

        ////对于相同的key，后进来的value会进行覆盖，但是第二次遍历时从0开始，即使有相同的key，后面也会得到，且索引顺序正常
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hashMap.containsKey(complement) && hashMap.get(complement) != i) {
                return new int[] {i, hashMap.get(complement)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int target = 6;
        int[] nums = {3, 3};
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
}
