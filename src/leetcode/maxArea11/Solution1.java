package leetcode.maxArea11;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/7/2 20:55
 * @description https://leetcode-cn.com/problems/container-with-most-water/
 * 双指针法，时间复杂度o(n)
 **/
public class Solution1 {
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;
        int max = 0;

        while (start < end) {
            int cur = (end - start) * Math.min(height[start], height[end]);
            max = Math.max(max, cur);

            //将指针从较短的地方移动，因为当前面积的制约是因为短的边，所以移动短的看下一个能不能更长
            if (height[start] < height[end]) {
                start++;
            }else {
                end--;
            }
        }

        return max;
    }
}
