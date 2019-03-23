import java.util.ArrayList;

import java.util.Collections;
import java.util.TreeSet;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/5 15:52
 * @description 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 **/
public class lastKNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
//        if(input == null)
//            return null;
//
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        if(k > input.length || k == 0 || input.length == 0)
//            return arrayList;
//
//        TreeSet<Integer> treeSet = new TreeSet<>();
//        for (int i = 0; i < input.length; i++) {
//            if(treeSet.size() < k)
//                treeSet.add(input[i]);
//            else {
//                if(input[i] < treeSet.last()){
//                    treeSet.pollLast();
//                    treeSet.add(input[i]);
//                }
//            }
//        }
//
//        for (int i:
//             treeSet) {
//            arrayList.add(i);
//        }
//        arrayList.sort();
//        return arrayList;
        return null;
    }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(1);
        System.out.println(treeSet.size());
    }
}
