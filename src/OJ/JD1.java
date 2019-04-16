package OJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/4/13 19:56
 * @description 输入n代表树有n个节点，接下来n-1行，代表这两个节点之间有一条边,除根节点1节点处可同时容纳两个节点外，其他节点只能容纳一个，
 * 问需要几次将所有节点都移动到根节点，
 * 如：这里 2 6先移动到根节点，同时3到2,4到3，接着3到1，4到3，再4到1,5到4，再5到1，共4次
 * 6
 * 2 1
 * 3 2
 * 4 3
 * 5 2
 * 6 1
 **/
public class JD1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] tree = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            tree[i][0] = Integer.valueOf(in.next());
            tree[i][1] = Integer.valueOf(in.next());
        }

        //用来对含两个子节点的访问进行标记
        boolean[] modified = new boolean[n];
        if(tree.length == 1)
            System.out.println(0);

        System.out.println(getCount(tree,modified));
    }

    public static int getCount(int[][] tree,boolean[] modified){
        int count = 0;
        //数组的复制要用Arrays.copyOf，直接等于还是原来的引用
        int[][] temp = new int[tree.length][2];
        for (int i = 0; i < tree.length; i++)
            temp[i] = Arrays.copyOf(tree[i],2);

        while (!isFinished(tree)){
            for (int i = 0; i < tree.length; i++) {
                //对所有不跟1连的点进行移动，该节点尚未填充
                if(tree[i][1] > 1 && !modified[tree[i][1]]){
                    modified[tree[i][1]] = true;
                    for (int j = 0; j < tree.length; j++) {
                        if(temp[j][0] == tree[i][1])
                            tree[i][1] = temp[j][1];
                    }
                }
            }
            count++;
            //将所有不与1连的点的访问位置false
            for (int i = 0; i < tree.length; i++) {
                if(tree[i][1] > 1)
                    modified[tree[i][1]] = false;
            }

        }
        return count + 1;
    }

    private static boolean isFinished(int[][] tree){
        for (int[] b:
             tree) {
            if(b[1] != 1)
                return false;
        }
        return true;
    }
}
