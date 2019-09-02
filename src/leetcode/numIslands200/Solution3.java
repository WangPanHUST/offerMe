package leetcode.numIslands200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/8/5 19:07
 * @description https://leetcode-cn.com/problems/number-of-islands/
 * bfs 要使用队列实现 直接
 **/
public class Solution3 {
    boolean[][] visited;
    int rows, cols;
    Queue<Integer[]> queue = new LinkedList<>();

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
                    queue.add(getIndex(i, j));
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int r, int c) {

        visited[r][c] = true;

        if (r - 1 >= 0 && !visited[r - 1][c] && grid[r - 1][c] == '1') {
            visited[r - 1][c] = true;
            queue.add(getIndex(r - 1, c));
        }
        if (r + 1 < rows && !visited[r + 1][c] && grid[r + 1][c] == '1') {
            visited[r + 1][c] = true;
            queue.add(getIndex(r + 1, c));
        }
        if (c - 1 >= 0 && !visited[r][c - 1] && grid[r][c - 1] == '1') {
            visited[r][c - 1] = true;
            queue.add(getIndex(r, c - 1));
        }
        if (c + 1 < cols && !visited[r][c + 1] && grid[r][c + 1] == '1') {
            visited[r][c + 1] = true;
            queue.add(getIndex(r, c + 1));
        }

        queue.poll();
        Integer[] t = queue.peek();
        if (t != null) {
            bfs(grid, t[0], t[1]);
        }

    }

    private Integer[] getIndex(int r, int c) {
        Integer[] index = new Integer[2];
        index[0] = r;
        index[1] = c;
        return index;
    }
}
