package producer_consumer_pattern;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class JobQueue implements Queue{
    private static final String NAME = "JOB QUEUE";
    private static final Object monitor = new Object();

    private LinkedList jobs = new LinkedList();

    private static JobQueue instance = new JobQueue();
    private JobQueue(){};

    public static JobQueue getInstance() {
        if (instance == null) {
            synchronized (JobQueue.class) {
                instance = new JobQueue();
            }
        }
        return instance;
    }

    @Override
    public String getName() {
        return NAME;
    }

    public LinkedList getLinkedList() {
        return jobs;
    }

    @Override
    public void clear() {
        synchronized (monitor) {
            jobs.clear();
        }
    }

    @Override
    public void put(Object o) {
        synchronized (monitor) {
            jobs.addLast(o);
            monitor.notify();
        }
    }

    @Override
    public Object pop() throws InterruptedException, NoSuchElementException {
        Object o = null;
        synchronized (monitor) {
            if (jobs.isEmpty()) {
                monitor.wait();
            }
            o = jobs.removeFirst();
        }
        if (o == null) throw new NoSuchElementException();
        return o;
    }

    @Override
    public int size() {
        return jobs.size();
    }
}
