package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/7 21:40
 * @description 求1-n这n个数中1出现的次数，注意不是包含1，而是1出现的次数
 * 判断每个位数为0、1或者大于1，当为0时候，在该位上出现的次数由前几位确定，如12033，百位上出现1的次数就是前两位 12 * 100，即1200次，
 * 同理大于1时候，如12300，次数为（12 + 1）* 100；等于1时，如12133，次数为12 * 100 + 33 + 1 ，后两位再加1
 **/
public class numberOf1Between1AndN {

    public static int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0)
            return 0;
        int count = 0;

        StringBuffer stringBuffer = new StringBuffer(Integer.toString(n));
        int len = stringBuffer.length() - 1;
        int positon = 1;
        int right = 0;
        int left = 0;

        for (int i = len; i >= 0 ; i--) {
            String s = new String(String.valueOf(stringBuffer.charAt(i)));
            int number = Integer.parseInt(s);

            if(i == 0)
                left = 0;
            else
                left = Integer.parseInt(stringBuffer.substring(0,i));

            if(i == len)
                right = 0;
            else
                right = Integer.parseInt(stringBuffer.substring(i + 1,len + 1));

            if(number == 0)
                count += left * positon;
            else if(number == 1)
                count += left * positon + right + 1;
            else
                count += (left + 1) * positon;

            positon = positon * 10;
        }
        return count;
    }

    public static void main(String[] args) {
        int count = NumberOf1Between1AndN_Solution(999);
        System.out.println(count);
    }
}
