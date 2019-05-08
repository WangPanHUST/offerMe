package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/17 13:37
 * @description 左旋字符串，将字符串的前n位依次放到字符串末尾
 * 思路：类似旋转字符串，位置不再以空格为分界
 **/
public class LeftRotateString {
    public String leftRotateString(String str, int n) {
        if(str == null || n > str.length()) {
            return null;
        }

        int len = str.length() - 1;
        str = rotate(str,0,len);
        str = rotate(str,0,len - n);
        return rotate(str,len - n + 1,len);
    }

    private String rotate(String str,int start,int end){
        if(start >= end) {
            return str;
        }

        StringBuffer stringBuffer = new StringBuffer(str);
        while (start < end){
            char temp = stringBuffer.charAt(start);
            stringBuffer.setCharAt(start,stringBuffer.charAt(end));
            stringBuffer.setCharAt(end,temp);
            start++;
            end--;
        }
        return stringBuffer.toString();
    }
}
