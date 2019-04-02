package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/4/2 21:23
 * @description 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 思路：这里也是回溯法，但是这里只要访问过的节点，无论是否符合规定都要将标志位置为true
 * @see hasPath 不同于该题寻找路径的问题，寻找路径的问题中如果当前位置的周围四个点不符合条件，则仍将标志位置为false，表示以后仍然可以进行访问
 **/
public class movingCount {
    private int r,c;
    public int movingCount(int threshold, int rows, int cols){
        r = rows;
        c = cols;
        boolean[][] isVisited = new boolean[r][c];
        return step(threshold,0,0,isVisited);
    }

    private int step(int threshold,int row,int col,boolean[][] isVisited){
        if(row < 0 || row >= r || col < 0 || col >= c || isVisited[row][col] || bitSum(row) + bitSum(col) > threshold)
            return 0;
        isVisited[row][col] = true;
        return 1 + step(threshold,row + 1,col,isVisited)
                + step(threshold,row - 1,col,isVisited)
                + step(threshold,row,col + 1,isVisited)
                + step(threshold,row,col - 1,isVisited);
    }

    private int bitSum(int n){
        int sum = 0;
        while (n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
