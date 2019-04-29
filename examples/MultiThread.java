class RunThreads implements Runnable {
    public void run() {
        go();
    }

    public void go() {
        try { Thread.sleep(100); }
        catch (Exception ex) { ex.printStackTrace(); }
        for (int i = 0; i < 6; i++) {
            String threadname = Thread.currentThread().getName();
            System.out.println(threadname + " is running");
        }
    }
}

public class MultiThread {
    public static void main (String[] args) {
        RunThreads runner = new RunThreads();

        Thread thread1 = new Thread(runner);
        Thread thread2 = new Thread(runner);
        Thread thread3 = new Thread(runner);

        thread1.setName("1");
        thread2.setName("2");
        thread3.setName("3");

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Done");
    }
}
