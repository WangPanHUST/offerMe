/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/15 21:11
 * @description 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 **/
public class twoDimSearch {
    public static boolean Find(int target, int [][] array) {

        int lRow = array.length;
        int lCol = array[0].length;

        if(lRow != lCol)
            return false;

        int i = 0,j = lCol - 1;
        while (i < lRow && j >= 0){
            if(target == array[i][j])
                return true;
            else if(target > array[i][j])
                i++;
            else
                j--;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};

        Boolean is = Find(16,a);
        System.out.println(is);
    }
}
