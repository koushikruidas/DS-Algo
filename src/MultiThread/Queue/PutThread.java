package MultiThread.Queue;

public class PutThread implements Runnable{
    Queue queue;
    PutThread(Queue queue){
        this.queue = queue;
        new Thread(this,"producer").start();
    }
    @Override
    public void run() {
        int i = 0;
        while(true){
            queue.put(i++);
        }
    }
}
