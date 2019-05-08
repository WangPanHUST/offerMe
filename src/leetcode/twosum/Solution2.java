package leetcode.twosum;

import java.util.HashMap;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/5/8 14:47
 * @description https://leetcode-cn.com/problems/two-sum/ 时间o(n) 空间o(n)
 **/
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++){
            if(hashMap.containsKey(target - nums[i])){
                ans[0] = hashMap.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            //必须先判断再put
            hashMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
