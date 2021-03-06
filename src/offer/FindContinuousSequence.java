package offer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/15 16:26
 * @description 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *标准思路：利用双指针，相当于一个窗口，当窗口内的和等于给定数字时得到一组解，当大于给定数字，则左边窗口右移移位，当小与给定数字时候，右边窗口右移移位。
 **/
public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        if(sum <= 2) {
            return null;
        }

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        int i = 2;
        int mid = 1;
        while (i < sum){
            mid = sum / i;

            if(mid < i / 2) {
                break;
            } else{
                if(i % 2 == 0 && sum % i == i / 2){
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int j = 1; j <= i; j++) {
                        arrayList.add(mid - i / 2 + j);
                    }
                    arrayLists.add(arrayList);
                }else if(i % 2 == 1 && sum % i == 0){
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int j = 0; j < i; j++) {
                        arrayList.add(mid - i / 2 + j);
                    }
                    arrayLists.add(arrayList);
                }
            }

            i++;
        }
        arrayLists.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size() < o2.size()) {
                    return 1;
                } else if(o1.size() > o2.size()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return arrayLists;
    }

    public static void main(String[] args) {
        //System.out.println(findContinuousSequence(100).toString());
        System.out.println(findSequence(9).toString());
    }

    //指针解法
    public static ArrayList<ArrayList<Integer>> findSequence(int sum) {
        if(sum <= 2) {
            return null;
        }

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        int low = 1, high = 2;
        //最少含有两个数，故high <= sum / 2 + 1
        while (high <= sum / 2 + 1) {
            int temp = low * (high - low + 1) + (high - low) * (high - low + 1) / 2;
            if (temp == sum) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = low; i <= high ; i++) {
                    arrayList.add(i);
                }
                arrayLists.add(arrayList);
                low++;
            }else if (temp > sum) {
                low++;
            }else {
                high++;
            }
        }

        return arrayLists;
    }
}
