package leetcode.maxArea11;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/7/2 20:55
 * @description https://leetcode-cn.com/problems/container-with-most-water/
 **/
public class Solution1 {
    public int maxArea(int[] height) {
        int leftIndex = 0, rightIndex = height.length - 1;
        int maxArea = height[leftIndex] * height[rightIndex];

        while (rightIndex > leftIndex) {

        }

        return maxArea;
    }
}
