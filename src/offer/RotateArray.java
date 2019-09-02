package offer;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/21 20:03
 * @description 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 返回类型为int的决不能返回null，数组的长度，array.length，length不是函数
 **/
public class RotateArray {
    public static int minNumberInRotateArray(int [] array) {
        if(array.length == 0) {
            return 0;
        }

        int i = 0,j = array.length - 1;
        if(j == 0) {
            return array[0];
        } else if(j == 1){
            if(array[0] <= array[1]) {
                return array[0];
            } else {
                return array[1];
            }
        }else{
            while(j >= i){

                //ij相邻的情况先于三个数值都相等
                if(j - i == 1) {
                    return array[j];
                }

                if(array[(i+j)/2] == array[i] && array[(i+j)/2] == array[j]) {
                    return minInOrder(array,i,j);
                }

                //判断是在左侧递增数组还是右侧递增数组
                if(array[(i+j)/2] >= array[i]) {
                    i = (i+j)/2;
                } else if(array[(i+j)/2] <= array[j]) {
                    j = (i+j)/2;
                }
            }
            return array[j];
        }

    }

    private static int minInOrder(int[] array, int i, int j) {
        int min = array[i];
        for (int k = i + 1; k <= j ; k++) {
            if(array[k] < min) {
                min = array[k];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] a = {1,0,1,1,1};
        System.out.println(minNumberInRotateArray(a));
    }
}
