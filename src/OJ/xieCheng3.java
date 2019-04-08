package OJ;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/4/8 20:26
 * @description
 **/
public class xieCheng3 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //String str = in.next();
        String  str = "5 /order/pnrList/pnrPriceList /order/pnrList/pnrPriceList/price /order/pnrList/pnrPriceList/price /order/pnrList/pnrPriceList /order/pnrList/pnrPriceList";
        print(str);
    }
    public static void print(String str){
        String[] input = str.split(" ");
        HashMap<String,Integer> hashMap = new HashMap<>();
        boolean isPrint = true;

        for (int i = 1; i < input.length; i++) {
            if(i == input.length - 1)
                isPrint = false;

            if(hashMap.isEmpty()){
                hashMap.put(input[i],1);
                printPath(input[i],hashMap.get(input[i]),isPrint);
            }else{
                if(hashMap.containsKey(input[i])){
                    hashMap.replace(input[i],hashMap.get(input[i]) + 1);
                    printPath(input[i],hashMap.get(input[i]),isPrint);
                }else {
                    hashMap.put(input[i],1);
                    printPath(input[i],hashMap.get(input[i]),isPrint);
                }
            }

        }
    }

    private static void printPath(String string,int count,boolean isPrint){
        String[] s = string.split("/");
        System.out.print(1);
        for (int i = 0; i < s.length - 3; i++)
            System.out.print(count);
        System.out.print(1);
        if(isPrint)
            System.out.print(" ");
    }
}
