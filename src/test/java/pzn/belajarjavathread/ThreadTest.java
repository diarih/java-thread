package pzn.belajarjavathread;

import org.junit.jupiter.api.Test;

public class ThreadTest {
    @Test
    void mainThread() {
        var name = Thread.currentThread().getName();
        System.out.println(name);
    }

    @Test
    void createThread() {
        Runnable runnable = () -> {
            System.out.println("Hello from thread " + Thread.currentThread().getName());
        };

        var thread = new Thread(runnable);
        thread.start();

    }

    @Test
    void createThreadSleep() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000L);
                System.out.println("Hello from thread " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        var thread = new Thread(runnable);
        thread.start();

        System.out.println("Program Selesai");

        Thread.sleep(3_000L);

    }

    @Test
    void threadJoin() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000L);
                System.out.println("Hello from thread " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        System.out.println("Menunggu Selesai");
        thread.join();
        System.out.println("Program Selesai");

    }

    @Test
    void threadInterrupt() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                // Manual Interrupted
                if (Thread.interrupted()) {
                    return;
                }
                System.out.println("Runnable " + i);
                try {
                    Thread.sleep(1_000L);
                    System.out.println("Hello from thread " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5_000L);
        thread.interrupt();
        System.out.println("Menunggu Selesai");
        thread.join();
        System.out.println("Program Selesai");

    }

    @Test
    void threadInterruptCorrect() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runnable " + i);
                try {
                    Thread.sleep(1_000L);
                    System.out.println("Hello from thread " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    return;
                }
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5_000L);
        thread.interrupt();
        System.out.println("Menunggu Selesai");
        thread.join();
        System.out.println("Program Selesai");

    }

    @Test
    void threadName() {

        var thread = new Thread(() -> {
            System.out.println("Run in thread " + Thread.currentThread().getName());
        });

        thread.setName("Ea");
        thread.start();

    }

    @Test
    void threadState() throws InterruptedException {

        var thread = new Thread(() -> {
            System.out.println("Current State Thread " + Thread.currentThread().getState());
            System.out.println("Run in thread " + Thread.currentThread().getName());
        });

        thread.setName("Ea");
        System.out.println(thread.getState());
        
        thread.start();
        thread.join();

        System.out.println(thread.getState());


    }
}
