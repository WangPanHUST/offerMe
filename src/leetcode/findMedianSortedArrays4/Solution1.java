package leetcode.findMedianSortedArrays4;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/7/1 9:53
 * @description https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 时间复杂度 o(log(m+n))
 **/
public class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m == 0) {
            return getMedian(nums2);
        }
        if (n == 0) {
            return getMedian(nums1);
        }
        int total = m + n;
        //如果总长度为奇数，寻找中间数字即可
        if (total % 2 == 1) {
            return getMedian(nums1, 0, nums2, 0, total / 2 + 1);
        }else {
            return (getMedian(nums1, 0, nums2, 0, total / 2) +
                    getMedian(nums1, 0, nums2, 0, total / 2 + 1)) / 2.0;
        }
    }

    private double getMedian(int[] arr) {
        if (arr.length % 2 == 1) {
            return arr[arr.length / 2];
        }else {
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.0;
        }
    }

    private double getMedian(int[] m,int mBegin, int[] n, int nBegin, int k) {
        if (mBegin >= m.length) {
            return n[nBegin + k - 1];
        }
        if (nBegin >= n.length) {
            return m[mBegin + k - 1];
        }
        if (k == 1) {
            return Math.min(m[mBegin], n[nBegin]);
        }
        //如果范围超出的话，则对应哪个数组更长则它的开始索引要增加
        int midOfM = Integer.MAX_VALUE, midOfN = Integer.MAX_VALUE;
        if (mBegin + k / 2 - 1 < m.length) {
            midOfM = m[mBegin + k / 2 - 1];
        }
        if (nBegin + k / 2 - 1 < n.length) {
            midOfN = n[nBegin + k / 2 - 1];
        }

        //范围缩小了k个数，此时总的第 k 个数实际上等于新的范围内的第 k - k / 2个数，依次递归
        //对应另一半索引未变的数组的末尾的 k/2 个数也不在范围内了
        if (midOfM < midOfN) {
            return getMedian(m, mBegin + k / 2, n, nBegin, k - k / 2);
        }else {
            return getMedian(m, mBegin, n, nBegin + k / 2, k - k / 2);
        }
    }

}
