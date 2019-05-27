package oj;

import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/5/25 2:38
 * @description 输入一矩阵，内全部都是0和1，1的节点的上下左右和对角的1，连接成一个区块，问有多少个区块
 * 如 0 1 0                       1
 *    1 0 0   共两个区块，左侧   1   构成一个，右下角单独的1构成一个
 *    1 0 1                      1
 **/

public class ByteCamp2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] nums = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        boolean[][] visited = new boolean[rows][cols];
        int ans = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && nums[i][j] == 1) {
                    ans++;
                    //将该区块内的所有1进行标记
                    chain(visited, nums, i, j);
                }
            }
        }
        System.out.println(ans);
    }

    //把某个区块对应的方块都标记为已访问，且是属于某一区块
    private static void chain(boolean[][] visited, int[][] nums, int i, int j) {
        if (i < 0 || j < 0 || i > nums.length - 1 || j > nums[0].length - 1 || nums[i][j] == 0) {
            return;
        }
        if (nums[i][j] == 1 && visited[i][j]) {
            return;
        }
        visited[i][j] = true;

        chain(visited, nums, i - 1 , j - 1);
        chain(visited, nums, i - 1 , j);
        chain(visited, nums, i - 1, j + 1);
        chain(visited, nums, i, j - 1);
        chain(visited, nums, i, j + 1);
        chain(visited, nums, i + 1 , j - 1);
        chain(visited, nums, i + 1, j);
        chain(visited, nums, i + 1, j + 1);
    }
}