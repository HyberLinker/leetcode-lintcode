package interview.threadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        ExecutorService e = Executors.newFixedThreadPool(2);
        MyCallable c = new MyCallable();
        e.submit(r);
        e.submit(c);
        e.shutdown();
    }


}
class MyCallable implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"I am callable");
        return null;
    }
}