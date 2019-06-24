package offer;

import java.util.ArrayList;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/6/24 20:56
 * @description 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。如果当前字符流没有存在出现一次的字符，返回#字符。
 * 使用ArrayList来存储数据流中的字符，使用HashSet，其中的hash方法按照char的大小进行hash，故hash值小的字符会存在hashSet的前面，
 * 用iterator来遍历时候不会获取第一个插入的，而是hash值最小的那个
 * HashSet不保证插入的顺序存储，也不保证其他大小顺序等
 * It makes no guarantees as to the iteration order of the set;
 * in particular, it does not guarantee that the order will remain constant over time.
 **/
public class FirstCharAppearingOnce {

    static ArrayList<Character> arrayList = new ArrayList<>();

    public static void Insert(char ch) {
        if (!arrayList.isEmpty() && arrayList.contains(ch)) {
            //ArrayList的remove方法有两个，直接使用remove(ch)，会将ch作为一个ascii码代表的数字，使用remove(index)方法
            arrayList.remove(new Character(ch));
        }else {
            arrayList.add(ch);
        }
    }

    public static char FirstAppearingOnce() {

       if (!arrayList.isEmpty()) {
           return arrayList.get(0);
       }

        return '#';
    }

    public static void main(String[] args) {
        Insert('g');
        System.out.print(FirstAppearingOnce());
        Insert('o');
        System.out.print(FirstAppearingOnce());
        Insert('o');
        System.out.print(FirstAppearingOnce());
        Insert('g');
        System.out.print(FirstAppearingOnce());
        Insert('l');
        System.out.print(FirstAppearingOnce());
        Insert('e');
        System.out.print(FirstAppearingOnce());
    }
}
