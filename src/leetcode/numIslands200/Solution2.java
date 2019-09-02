package leetcode.numIslands200;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/8/5 18:55
 * @description https://leetcode-cn.com/problems/number-of-islands/
 * dfs
 **/
public class Solution2 {
    boolean[][] visited;
    int rows, cols;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols
                || grid[r][c] == '0' || visited[r][c]) {
            return;
        }

        //当不能改变数组时，需要额外的数组保存是否已访问的标志，可以更改数组，则直接将 '1' 置 '0' 节省空间
        visited[r][c] = true;

        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
        //当嵌套的循环到这来时，执行dfs(grid, r - 1, c)，肯定返回空，接着返回上一个循环，开始执行dfs(grid, r, c - 1)！
        dfs(grid, r - 1, c);

    }

}
