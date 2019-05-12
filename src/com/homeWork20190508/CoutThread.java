package com.homeWork20190508;

/**
 * 计算器（多线程）
 * */
public class CoutThread{
    private volatile int result = 0;

    public static void main(String[] args) {
        CoutThread coutThread = new CoutThread();
        coutThread.getCount1(coutThread);
        //coutThread.getCount2(coutThread);
    }

    /**
     * 计算
     * */
    public synchronized void getCount(int start,int end,CoutThread coutThread){
        for(int i = start;i<end;i++){
            result = result + i;
        }
    }

    /**
     * 非多线程计算
     * */
    public void getCount1(CoutThread coutThread){
        long startTime = System.currentTimeMillis();
        coutThread.getCount(0,1000000000,coutThread);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime-startTime) + "ms");
    }

    /**
     * 多线程计算
     * */
    public void getCount2(CoutThread coutThread){
        long startTime = System.currentTimeMillis();
        new Thread(()->{
            coutThread.getCount(0,500000000,coutThread);
        }).start();
        new Thread(()->{
            coutThread.getCount(500000000,1000000000,coutThread);
        }).start();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime-startTime) + "ms");
    }
}
