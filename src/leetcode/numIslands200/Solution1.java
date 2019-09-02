package leetcode.numIslands200;

import java.util.Stack;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/8/4 20:16
 * @description https://leetcode-cn.com/problems/number-of-islands/
 * dfs 不需要栈来保存坐标 这种很麻烦
 **/
public class Solution1 {
    private Stack<Integer[]> stack;
    boolean[][] visited;
    int rows, cols;
    boolean init = true;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
                init = true;
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (!init && stack.size() == 0) {
            return;
        }
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return;
        }
        if (grid[r][c] == '0' && !visited[r][c]) {
            visited[r][c] = true;
            Integer[] temp =  stack.peek();
            int i = temp[0], j = temp[1];
            dfs(grid, i, j);
        }
        if (!visited[r][c]) {
            visited[r][c] = true;
            stack.push(getIndex(r, c));
        }else {
            return;
        }

        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
        dfs(grid, r - 1, c);

        stack.pop();
        if (stack.size() == 0) {
            init = false;
        }
    }

    private Integer[] getIndex(int r, int c) {
        Integer[] index = new Integer[2];
        index[0] = r;
        index[1] = c;
        return index;
    }

    public static void main(String[] args) {
        int c = 0;

        System.out.println(c);
    }
}
