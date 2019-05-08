package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/15 19:19
 * @description 翻转字符串，输入 i am a student. 输出 student. a am i
 * 思路：翻转两次，先翻转句子再翻转单词，不利用额外空间
 * 这里使用了split方法，用了额外空间
 **/
public class ReverseSentence {
    public static String reverseSentence(String str) {
        //trim方法删除基础串前后的空白符
        if(str == null || "".equals(str.trim())) {
            return str;
        }

        String[] strings = str.split(" ");
        StringBuffer newString = new StringBuffer();
        for (int i = strings.length - 1; i >= 0 ; i--) {
            if(i > 0) {
                newString.append(strings[i] + " ");
            } else {
                newString.append(strings[i]);
            }
        }

        return newString.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseSentence("  a "));

    }
}
