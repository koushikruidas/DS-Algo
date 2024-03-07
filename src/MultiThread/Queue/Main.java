package MultiThread.Queue;

public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue();
        PutThread put = new PutThread(queue);
        GetThread get = new GetThread(queue);

    }
}
