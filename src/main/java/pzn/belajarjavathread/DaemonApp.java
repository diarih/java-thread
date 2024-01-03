package pzn.belajarjavathread;

public class DaemonApp {
    public static void main(String[] args) {
        var thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("Hello Daemon");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.setDaemon(true);
        thread.start();
    }
}
