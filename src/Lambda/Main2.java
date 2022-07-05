package Lambda;

public class Main2 {
    public static void main(String[] args) {
        Worker.OnTaskDoneListener listener = System.out::println;
        Worker.OnTaskErrorListener listenerError = System.out::println;
        Worker worker = new Worker(listener,listenerError);
        worker.start();
    }
}
class Worker {
    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }
    private OnTaskErrorListener errorCallback;
    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }
    private OnTaskDoneListener callback;
    public Worker(OnTaskDoneListener callback,OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }
    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) errorCallback.onError("Error " + i);
            else callback.onDone("Task " + i + " is done");
        }
    }
}

