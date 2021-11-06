package interview.threadTest;

public class CreateThread {


    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyThread mt = new MyThread();
        mt.start();

        MyRunnable mr = new MyRunnable();
        Thread t = new Thread(mr);
        t.start();
    }


}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"I am runnable");
    }
}

