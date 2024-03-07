package MultiThread.Queue;

public class Queue {
    private int n;
    private boolean ready = false;
    synchronized public void put(int n){
        while(ready) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        this.n = n;
        ready = true;
        System.out.println("Put: " + n);
        notify();
    }

    synchronized public void get(){
        while(!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        System.out.println("Got: " + n);
        ready = false;
        notify();
    }
}
