/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/25 9:56
 * @description 微众银行笔试题1，数字以之字形对角线排列，给出某一数字，输出其所在的行和列，如下所示，输入6 输出 1/3
 * 1/1(1) 1/2(2) 1/3(6)...
 * 2/1(3) 2/2(5)...
 * 3/1(4)...
 **/
public class webank1 {
    public static String result(int n){
        int rows = rows(n);
        //最后一个对角线含有的元素个数
        int left = n - (rows - 1) * rows / 2;
        int col = 0;
        int row = 0;

        if(rows % 2 == 1){
            col = left;
            row = rows + 1 - col;
        }else{
            row = left;
            col = rows + 1 - row;
        }
        return row + "/" + col;
    }

    //找出包含该数字的最大行数
    private static int rows(int n){
        int i = 1;
        while (n > i*(i + 1) /2)
            i++;

        return i;
    }

    public static void main(String[] args) {
        System.out.println(result(7));
    }
}
