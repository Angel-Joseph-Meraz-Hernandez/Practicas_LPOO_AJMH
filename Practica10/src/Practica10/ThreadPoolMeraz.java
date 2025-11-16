package Practica10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolMeraz {
    private final BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
    private final List<Worker> workers = new ArrayList<>();
    public ThreadPoolMeraz(int nThreads) {
        for (int i = 0; i < nThreads; i++) {
            Worker w = new Worker("Pool-Worker-" + i);
            workers.add(w);
            w.start();
        }
    }
    public void execute(Runnable task) {
        try { taskQueue.put(task); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
    public void shutdown() {
        for (Worker w : workers) w.interrupt();
    }
    private class Worker extends Thread {
        public Worker(String name) { super(name); }
        public void run() {
            while (!isInterrupted()) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        }
    }
}
