package MultiThread.Queue;

public class GetThread implements Runnable{

    private Queue queue;

    GetThread(Queue queue){
        this.queue = queue;
        new Thread(this,"consumer").start();
    }
    @Override
    public void run() {
        while(true){
            queue.get();
        }
    }
}
