package offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/6/23 17:52
 * @description 得到一个数据流中的中位数，排序之后中间的那个数
 * 使用两个堆，左侧大顶堆，右侧小顶堆，保证可以在o(1)的时间复杂度内获取中位数
 * PriorityQueue默认为小顶堆，可以添加Comparator构造大顶堆
 **/
public class Median {

    /**
    设计使用的数据结构，保证插入和获取中位数时候都有不错的时间复杂度
     */
    int count = 0;
    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public void Insert(Integer num) {
        count++;
        if (count % 2 == 1) {
            maxHeap.add(num);
        }else {
            minHeap.add(num);
        }

        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            int temp = maxHeap.remove();
            maxHeap.add(minHeap.remove());
            minHeap.add(temp);
        }
    }

    public Double GetMedian() {
        double result = 0;
        if (minHeap.size() % 2 == 0 && maxHeap.size() % 2 == 0
             || minHeap.size() % 2 == 1 && maxHeap.size() % 2 == 1) {
            result = ((double) (maxHeap.peek() + minHeap.peek())) / 2;
        }else {
            result = maxHeap.peek();
        }

        return result;
    }
}
