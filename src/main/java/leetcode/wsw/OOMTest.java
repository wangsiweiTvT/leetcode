package leetcode.wsw;

public class OOMTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //1.sleep之前被interrupt   则 sleep方法抛出异常，再次查看isInterrupted为false，需要手动添加
                    //Thread.currentThread().interrupt(); 线程状态才得以修改正确
                    //添加前：
                    // ===================interrupt===================
                    //thread start====currentThread().isInterrupted()====>true
                    //before===>false
                    //after===>false
                    //thread end====currentThread().isInterrupted()====>false
                    //添加后：===================interrupt===================
                    //thread start====currentThread().isInterrupted()====>true
                    //before===>false
                    //after===>true
                    //thread end====currentThread().isInterrupted()====>true


                    //2.正在sleep时,被interrupt   sleep方法也抛出异常，再次查看isInterrupted为false，需要手动添加
                    //Thread.currentThread().interrupt(); 线程状态才得以修改正确
                    //添加前：
                    //thread start====currentThread().isInterrupted()====>false
                    //===================interrupt===================
                    //before===>false
                    //after===>false
                    //thread end====currentThread().isInterrupted()====>false
                    //添加后：
                    //thread start====currentThread().isInterrupted()====>false
                    //===================interrupt===================
                    //before===>false
                    //after===>true
                    //thread end====currentThread().isInterrupted()====>true

                    System.out.println("thread start====currentThread().isInterrupted()====>"+Thread.currentThread().isInterrupted());

                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    System.out.println("before===>"+Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();
                    System.out.println("after===>"+Thread.currentThread().isInterrupted());
                }

                System.out.println("thread end====currentThread().isInterrupted()====>"+Thread.currentThread().isInterrupted());

            }
        });
        thread.start();
        try {
            //主线程等子线程执行大概500ms之后 再interrupt子线程
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("===================interrupt===================");
        thread.interrupt();

    }

}
