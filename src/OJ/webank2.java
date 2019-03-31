package OJ;

import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/3/25 10:03
 * @description 有六种尺寸的货物，分别为边长为1-6的正方体，货车车厢是边长为6的正方体，高度和货物一致，给出6种货物的数量，问需要拉几趟。
 **/
public class webank2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[6];

        for (int i = 0; i < 6; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(count(nums));
    }

    public static int count(int[] nums) {
        int count = 0;
        //边长为6的货物每个都需要一趟
        count += nums[5];

        //边长为5的货物每个都需要一趟，剩下的可以拉边长为1的货物
        count += nums[4];
        nums[0] = (nums[0] > (nums[4] * 11))? (nums[0] - nums[4] * 11) : 0;

        //边长为4的货物每个都需要一趟，剩下的可以拉边长为2和1的货物，优先拉边长为2的，因为边长为1的货物只要有空位肯定能拉，优先级最低
        count += nums[3];
        if (nums[1] >= (nums[3] * 5)) {
            nums[1] -= nums[3] * 5;
        } else {
            int left1 = 20 * nums[3] - 4 * nums[1];
            nums[1] = 0;
            nums[0] = (nums[0] > left1)? (nums[0] - left1) : 0;
        }

        //边长为3的货物，有空闲位置可以拉2和1的货物
        if (nums[2] % 4 != 0) {
            count += (nums[2] / 4 + 1);
            int left = 36 - 9 * (nums[2] % 4);
            //剩下面积是27，可以拉5个2和7个1，剩下依次类推
            if (left == 27) {
                nums[1] = (nums[1] > 5) ? (nums[1] - 5) : 0;
                nums[0] = (nums[0] > 7) ? (nums[0] - 7) : 0;
            } else if (left == 18) {
                nums[1] = (nums[1] > 3) ? (nums[1] - 3) : 0;
                nums[0] = (nums[0] > 6) ? (nums[0] - 6) : 0;
            } else {
                nums[1] = (nums[1] > 1) ? (nums[1] - 1) : 0;
                nums[0] = (nums[0] > 5) ? (nums[0] - 5) : 0;
            }

        } else
            count += nums[2] / 4;


        if (nums[1] % 9 == 0)
            count += nums[1] / 9;
        else {
            count += nums[1] / 9 + 1;
            int left = 36 - 4 * (nums[1] % 9);
            nums[0] = (nums[0] > left) ? (nums[0] - left) : 0;
        }

        count = (nums[0] % 36 == 0)? (count + nums[0] / 36) : (count + nums[0] / 36 + 1);

        return count;
    }
}