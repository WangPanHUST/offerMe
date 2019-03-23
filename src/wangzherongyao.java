import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/9 19:56
 * @description -1,2，-3,4，-5...... 给出起点和终点，问着中间的数值的和是多少 （腾讯提前批2题）
 **/
public class wangzherongyao {

    public static void print(int[][] index,int len){
        int start = 0,end = 0;

        for (int i = 0; i < len; i++) {
            start = index[i][0];
            end  = index[i][1];
            System.out.println(sum(start,end));
        }

        return;
    }

    private static int sum(int start,int end){
        if(start == end){
            if(end % 2 == 0)
                return start;
            else
                return 0 - start;
        }

        int result = 0;
        int len = end - start;

        if(start % 2 == 0 && end % 2 == 0)
            result = (0 - len / 2) + end;
        else if (start % 2 == 1 && end % 2 == 1)
            result = len / 2 + (0 - end);
        else if(start % 2 == 1 && end % 2 == 0)
            result = (len + 1) / 2;
        else
            result = 0 - (len + 1) / 2;

        return result;
    }

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int len = in.nextInt();
        int[][] index = new int[len][2];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 2; j++) {
                index[i][j] = in.nextInt();
            }
        }

        print(index,len);
    }
}
