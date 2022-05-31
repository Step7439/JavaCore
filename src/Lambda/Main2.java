package Lambda;

public class Main2 {
    public static void main(String[] args) {
        Worker.OnTaskDoneListener listener = System.out::println;
        Worker.OnTaskErrorListener listenerError = System.out::println;
        Worker worker = new Worker(listener);
        //worker.start();
        Worker worker1 = new Worker(listenerError);
        worker1.startError();

    }
}
class Worker {
    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskErrorListener errorCallback) {
        this.errorCallback = errorCallback;
    }
    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }
    private OnTaskDoneListener callback;
    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;
    }
    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) errorCallback.onError("Error " + i);
            else callback.onDone("Task " + i + " is done");
        }
    }
    public void startError() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) errorCallback.onError("Error " + i);
            else System.out.println("Task " + i + " is done");

        }
    }
}

