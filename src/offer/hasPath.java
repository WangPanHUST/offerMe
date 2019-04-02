package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/4/2 19:26
 * @description 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * 思路：回溯法，如果当前节点的上下左右四个节点都不符合下一个要求，要将当前节点的isVisited置为false，不能仅因为当前节点符合就将isVisited置为true，因此这里只需注意对目标str访问是否到结尾即可
 **/
public class hasPath {
    public int colNumber;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(matrix == null || rows < 1 || cols < 1 || str == null)
            return false;
        boolean[] isVisited = new boolean[rows * cols];
        int len = rows * cols - 1;
        colNumber = cols;

        for (int i = 0; i <= len; i++) {
            if(path(matrix,i,str,0,isVisited))
                return true;
        }
        return false;
    }

    private boolean path(char[] matrix,int m,char[] str,int s,boolean[] isVisited){
        if(s == str.length)
            return true;

        if(m < 0 || m >= matrix.length || isVisited[m])
            return false;

        boolean hasP = false;
        if(matrix[m] == str[s]){
            s++;
            isVisited[m] = true;

            hasP = path(matrix,m + 1,str,s,isVisited) ||
                    path(matrix,m - 1,str,s,isVisited) ||
                    path(matrix,m + colNumber,str,s,isVisited) ||
                    path(matrix,m - colNumber,str,s,isVisited);

            //回溯的关键，如果其周围四个节点都不符合，则判断到str的位置回退，但是访问位置false，表示以后还可能访问到这里
            if(!hasP){
                s--;
                //只要访问位为false，则在循环中就仍然有机会被访问到
                isVisited[m] = false;
            }
        }
        return hasP;

    }
}
