package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/4 21:42
 * @description 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 理清思路，到底是start++还是i++，要与流程一样
 **/
public class Permutation {
    private static HashSet<String> strings = new HashSet<>();

    public static ArrayList<String> permutation(String str) {
        if(str == null) {
            return null;
        }

        strings = permu(strings,str,0);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String string : strings) {
            arrayList.add(string);
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static HashSet<String> permu(HashSet<String> hashSet,String str,int start){

        if(str == null || start == str.length()) {
            return hashSet;
        }

        int length = str.length();

        StringBuffer stringBuffer = new StringBuffer(str);

        for (int i = start; i < length; i++) {
            char temp = str.charAt(start);
            stringBuffer.setCharAt(start,stringBuffer.charAt(i));
            stringBuffer.setCharAt(i,temp);

            String newString = stringBuffer.toString();
            System.out.println(newString);
            hashSet.add(newString);

            hashSet = permu(hashSet,newString,start + 1);

            char a = newString.charAt(i);
            stringBuffer.setCharAt(i,stringBuffer.charAt(start));
            stringBuffer.setCharAt(start,a);
        }
        return hashSet;
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = permutation("abc");
        System.out.println(arrayList.toString());
    }
}
