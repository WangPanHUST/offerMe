package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/8 21:29
 * @description 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 更改list的比较规则！！！
 **/
public class minJoinNumber {
    public static  String PrintMinNumber(int [] numbers) {
        if(numbers.length == 1)
            return String.valueOf(numbers[0]);

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++)
            arrayList.add(numbers[i]);

        //重点，新的比较规则，用字符串的ascii码比较代替可能的大数比较，防止溢出
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1 + "" + o2;
                String str2 = o2 + "" + o1;
                return str1.compareTo(str2);
            }
        });

        String result = "";
        for (Integer in:
             arrayList) {
            result += in;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {3,32,321};
        System.out.println(PrintMinNumber(numbers));
    }
}






//import java.util.Scanner;
//
//public class OJ.Main {
//    public static void main(String[] args) {
//        //Scanner sc = new Scanner(System.in);
//        //int n = sc.nextInt();
////        int ans = 0, x;
////        for(int i = 0; i < n; i++){
////            for(int j = 0; j < n; j++){
////                //x = sc.nextInt();
////                ans += x;
////            }
////        }
//        //System.out.println(ans);
//    }
//}



