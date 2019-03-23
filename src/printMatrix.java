import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/25 20:04
 * @description 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 考虑每次进行下一步前的判断，及变量此时的值，经过循环后是大于判断条件的
 **/
public class printMatrix {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null)
            return null;
        if(matrix.length <= 0 && matrix[0].length <= 0)
            return null;

        ArrayList<Integer> arrayList = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;

        while (2 * start < rows && 2 * start < cols){
            arrayList =  printCircle(arrayList,matrix,start,rows,cols);
            start++;
        }

        return arrayList;
    }

    private static ArrayList<Integer> printCircle(ArrayList<Integer> arrayList,int[][] matrix,int start,int rows,int cols){
        int rowStart = start;
        int colStart = start;

        while (colStart <= cols - 1 - start){
            arrayList.add(matrix[rowStart][colStart]);
            colStart++;
        }

        //考虑每次进行下一步前的判断，及变量此时的值，经过循环后是大于判断条件的
        rowStart++;
        colStart--;
        if(rowStart <= rows - 1 - start){
            while (rowStart <= rows - 1 - start){
                arrayList.add(matrix[rowStart][colStart]);
                rowStart++;
            }
        }else
            return arrayList;


        colStart--;
        rowStart--;
        if(colStart >= start){
            while (colStart >= start){
                arrayList.add(matrix[rowStart][colStart]);
                colStart--;
            }
        }else
            return arrayList;


        rowStart--;
        colStart++;
        if(rowStart > start){
            while (rowStart > start){
                arrayList.add(matrix[rowStart][colStart]);
                rowStart--;
            }
        }else
            return arrayList;


        return arrayList;
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,8},{6,5,2},{1,6,8}};
        ArrayList<Integer> arrayList = printMatrix(a);
        System.out.println(Arrays.toString(arrayList.toArray()));
    }
}
