package com.accenture.services.manage;

public class ThreadUseTest implements Runnable {

    private  int count;
    public int getCount(){
        return this.count;
    };
    public void run() {
        for(int i=1; i < 5; i++){
            doSomething(i);
            count++;
        }
    }
    public Object lock = new Object();
    public void doSomething(int i){
        try {
//            synchronized (lock) {
//                Thread.sleep(2000);
//                System.out.println(Thread.currentThread().getName()+"==="+i);
//            }
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName()+"==="+i);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main (String [] args) throws InterruptedException {
        ThreadUseTest th =new ThreadUseTest();
        Thread thread = new Thread(th,"t1");
        Thread thread2 = new Thread(th,"t2");
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println("Processing count="+th.getCount());

    }
}
