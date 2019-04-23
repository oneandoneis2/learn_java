class MyRunnable1 implements Runnable {
    public void run() {
        go();
    }

    public void go() {
        try { Thread.sleep(100); }
        catch (Exception ex) { ex.printStackTrace(); }
        System.out.println("one");
    }
}

class MyRunnable2 implements Runnable {
    public void run() {
        go();
    }

    public void go() {
        try { Thread.sleep(100); }
        catch (Exception ex) { ex.printStackTrace(); }
        System.out.println("two");
    }
}

class MyRunnable3 implements Runnable {
    public void run() {
        go();
    }

    public void go() {
        try { Thread.sleep(100); }
        catch (Exception ex) { ex.printStackTrace(); }
        System.out.println("three");
    }
}

public class MultiThread {
    public static void main (String[] args) {
        Runnable job1 = new MyRunnable1();
        Runnable job2 = new MyRunnable2();
        Runnable job3 = new MyRunnable3();

        Thread thread1 = new Thread(job1);
        Thread thread2 = new Thread(job2);
        Thread thread3 = new Thread(job3);

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Done");
    }
}
