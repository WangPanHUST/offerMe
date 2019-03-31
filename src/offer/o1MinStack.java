package offer;

import java.util.Stack;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2019/2/25 21:33
 * @description 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 * pop()栈中间会出现弹出操作，stack1弹出时候，剩下的栈中的最小值可能会变化，这时候Stack2也应该弹出
 **/
public class o1MinStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
        if(stack2.isEmpty()){
            stack2.push(node);
            return;
        }

        if(node < stack2.peek())
            stack2.push(node);
    }

    public void pop() {
        if(stack1.peek() == stack2.peek()){
            stack1.pop();
            stack2.pop();
        }else
            stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
