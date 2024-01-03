package pzn.belajarjavathread;

public class Counter {
    private Long value = 0L;

    public void increment() {
        value++;
    }

    // Synchronized Method (Handle Race Condition)
    public synchronized void incrementSync() {
        value++;
    }

    // Synchronized Statement (Handle Race Condition)
    public void incrementSyncState() {
        synchronized (this) {
            value++;
        }
    }

    public Long getValue() {
        return value;
    }
}
