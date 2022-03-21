package io.github.redkcn.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of
 * a normal stack (push, top, pop, and empty).
 * <p>
 * Implement the MyStack class:
 * <p>
 * void push(int x) Pushes element x to the top of the stack. int pop() Removes the element on the top of the stack and returns it. int top() Returns the
 * element on the top of the stack. boolean empty() Returns true if the stack is empty, false otherwise. Notes:
 * <p>
 * You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid. Depending
 * on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a
 * queue's standard operations.
 * <p>
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 *
 * @author vicente
 * @date 2022/3/19
 */
public class QueueImplementStack {

    private Queue<Integer> queue;
    private int topElement;

    private QueueImplementStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
        topElement = x;
    }

    public int pop() {
        int size = queue.size();
        while (size > 2) {
            queue.offer(queue.poll());
            size--;
        }

        topElement = queue.peek();
        queue.offer(queue.poll());

        return queue.poll();
    }

    public int top() {
        return topElement;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}
