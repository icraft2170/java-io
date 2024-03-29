package producer_consumer_pattern;

public class Producer implements Runnable{
    private Queue queue = null;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("[START PRODUCER .. ]");
        try {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                queue.put(Integer.toString(i++));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("[END PRODUCER...]");
        }
    }
}
