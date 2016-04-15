package com.zq.concurrent.tools;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/14
 * Time: 15:12
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class BackWaterService implements Runnable {

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4,this);

    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String,Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count(){
        for (int i = 0; i < 4; i++) {
            final int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    //计算当前sheet的流水数据
                    sheetBankWaterCount.put(Thread.currentThread().getName(), finalI);

                    //计算完成，插入屏障
                    try{
                        cyclicBarrier.await();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }

    }

    //执行完上面的4个线程之后,调用run汇总
    @Override
    public void run() {
        int result =0;
        for (Map.Entry<String, Integer> sheet:sheetBankWaterCount.entrySet()){
            result+=sheet.getValue();
        }
        sheetBankWaterCount.put("result",result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BackWaterService backWaterService = new BackWaterService();
        backWaterService.count();
    }
}
