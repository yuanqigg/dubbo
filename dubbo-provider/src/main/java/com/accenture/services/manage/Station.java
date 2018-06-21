package com.accenture.services.manage;

public class Station implements Runnable {
    private  static int tickt = 20;

    private Object obj =new Object();

        public void run() {
            while (tickt>0){
                synchronized (obj){
                    System.out.println(""+ "卖出了第" + tickt + "张票");
                }
            }

        }
}
