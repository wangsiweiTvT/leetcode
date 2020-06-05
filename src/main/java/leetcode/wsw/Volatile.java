package leetcode.wsw;

class AnotherClass{
    volatile int a=0;
    public void add(){
        this.a=60;
    }

}

public class Volatile {


    public static void main(String[] args) {

        AnotherClass anotherClass = new AnotherClass();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                anotherClass.add();
                System.out.println("finish");
            }
        }).start();

        while (anotherClass.a == 0) {

        }

    }

}
