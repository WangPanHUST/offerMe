package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/23 10:42
 * @description 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。不考虑数值越界问题。
 * 尽量使用递归完成，代码简洁。移位运算 >> 1 相当于/2
 **/
public class power {
    public static double Power(double base, int exponent) {
        boolean exponentIsPos = true;

        if(Double.compare(0.0,base) == 0 && exponent < 0)
            return 0.0;

        if(exponent < 0){
            exponentIsPos = false;
            exponent = 0 - exponent;
        }

       if(exponentIsPos)
           return powerWithPostiveExponent(base,exponent);
       else
           return 1 / powerWithPostiveExponent(base,exponent);
    }

    private static double powerWithPostiveExponent(double base,int exponent){

        if(exponent == 0){
            return 1.0;
        }

        double result = 0.0;
        result = powerWithPostiveExponent(base,exponent >> 1);
        if(exponent % 2 == 0)
            return  result * result;
        else
            return base *  result * result;

    }

    public static void main(String[] args) {
        System.out.println(Power(2.0,-3));
    }
}
