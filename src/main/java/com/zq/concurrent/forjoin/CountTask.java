package com.zq.concurrent.forjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/14
 * Time: 14:00
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD =2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum=0;
        boolean canCompute =(end - start)<=THRESHOLD;
        if (canCompute){
            for (int i = start; i < end; i++) {
                sum+=i;
            }
        }else{
            // > 阈值
            int middle = (start+end)/2;
            CountTask left = new CountTask(start,middle);
            CountTask right = new CountTask(middle+1,end);

            left.fork();
            right.fork();

            int leftResult = left.join();
            int rightResult = right.join();
            sum = leftResult+rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        CountTask task = new CountTask(1,4);

        Future<Integer> result = forkJoinPool.submit(task);

        try{
            System.out.println(result.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
