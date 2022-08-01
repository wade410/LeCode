package leetcode.testCase;

/**
 * @Author HuWei05
 * @Date 2022/7/31
 **/
public class TestThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new TestRunable());
        thread.start();
    }
    public static class TestRunable implements Runnable{

        @Override
        public void run() {
            int i=0;
            while (true){
                try {
                    Thread.sleep(1000);
                    System.out.println(i++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
