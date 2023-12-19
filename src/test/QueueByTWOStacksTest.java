package test;

import API_practices.QueueByTwoStacks;

public class QueueByTWOStacksTest {
    public static void main(String[] args) {
        QueueByTwoStacks qs = new QueueByTwoStacks();
        qs.offer(1);
        qs.offer(2);
        qs.offer(3);
        System.out.println(qs.size());
        System.out.println(qs.poll());
        System.out.println(qs.peek());
        qs.offer(4);
        System.out.println(qs.poll());
        System.out.println(qs.poll());
        System.out.println(qs.poll());
        System.out.println(qs.isEmpty());
        System.out.println(qs.peek());
    }
}
