class RunThreads implements Runnable {
    public void run() {
        go();
    }

    public void go() {
        try { Thread.sleep(100); }
        catch (Exception ex) { ex.printStackTrace(); }
        System.out.println("one");
    }
}

public class MultiThread {
    public static void main (String[] args) {
        RunThreads runner = new RunThreads();

        Thread thread1 = new Thread(runner);
        Thread thread2 = new Thread(runner);
        Thread thread3 = new Thread(runner);

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Done");
    }
}
