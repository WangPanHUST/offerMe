import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/11 20:31
 * @description 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * 第一种方法，使用hashmap，遍历一遍，把每个字符作为key，出现的次数作为value，存入hashmap，再遍历char数组，找到第一个value为1的char，返回它的位置
 * 第二种方法，使用连个链表，遍历一遍，第一个链表存入所有的char，第二个链表只存储出现次数为1的char，最后再遍历char数组找到对应的char，返回位置
 **/
public class firstNotRepeationChar {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0)
            return -1;

        char[] chars = str.toCharArray();
        int result = 1;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        hashMap.put(chars[0],1);
        for (int i = 1; i < chars.length; i++) {
            if(hashMap.containsKey(chars[i]))
                hashMap.put(chars[i],hashMap.get(chars[i]) + 1);
            else
                hashMap.put(chars[i],1);
        }

        for (int i = 0; i < chars.length; i++) {
            if(hashMap.get(chars[i]) == 1){
                result = i;
                break;
            }
        }

        return result;
    }

    public int find(String str){
        if(str == null || str.length() == 0)
            return -1;

        char[] chars = str.toCharArray();
        int result = 1;

        Queue<Character> queue = new LinkedList<>();
        Queue<Character> unique = new LinkedList<>();
        queue.add(chars[0]);
        unique.add(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            if(queue.contains(chars[i])){
                ((LinkedList<Character>) queue).addLast(chars[i]);
                if(unique.contains(chars[i]))
                    unique.remove(chars[i]);
            }else{
                ((LinkedList<Character>) queue).addLast(chars[i]);
                ((LinkedList<Character>) unique).addLast(chars[i]);
            }

        }
        char c = ((LinkedList<Character>) unique).getFirst();

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == c){
                result = i;
                break;
            }
        }
        return result;
    }
}
