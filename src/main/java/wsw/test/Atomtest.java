package wsw.test;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomtest {


    private static volatile int i=0;
    private static AtomicInteger ati=new AtomicInteger(0);
    private static final int THREAD_COUNT=10;
    public static void main(String[] args) {

        System.out.println(Thread.activeCount());

        for (int c=0;c<THREAD_COUNT;c++){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j=0;j<1000;j++){
                        ati.getAndIncrement();
                    }
                }
            }).start();


        }
        while (Thread.activeCount()>0) {
            System.out.println(Thread.activeCount());
            Thread.yield();
        }
        System.out.println(ati.get());


    }

}
