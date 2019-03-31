package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/25 22:08
 * @description 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * pushIndex < length && pushA[pushIndex] != popA[popIndex] 注意判断条件的先后
 * 这里用stack来做更简单
 **/
public class isPopOrder {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null)
            return false;
        else if(pushA.length != popA.length)
            return false;

        int pushIndex = 0,popIndex = 0;
        int length = pushA.length;
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (pushIndex < length){
            //当指针大小判断与数组判断同时时，可能出现数组没索引的情况，注意条件先后顺序
            while (pushIndex < length && pushA[pushIndex] != popA[popIndex]){
                arrayList.add(pushA[pushIndex]);
                pushIndex++;
            }

            //边界条件，最后就不需要再加了
            if(pushIndex == length)
                break;
            else {
                pushIndex++;
                popIndex++;
            }
        }

        if(popIndex == length)
            return true;

        int i = arrayList.size() - 1;
        while (popIndex < length){
            if(popA[popIndex] == arrayList.get(i)){
                i--;
                popIndex++;
            }else
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {4,3,5,1,2};
        System.out.println(IsPopOrder(a,b));
    }
}
