import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wy  wiseguy_sky@outlook.com
 * @create 2020-09-02 16:10
 */
public class MyTest {
    public static void main(String[] args) {
        /*A a = new A();
        new Thread(()->{for (int i = 0; i < 10; i++)a.increase();},"A线程").start();
        new Thread(()->{for (int i = 0; i < 10; i++)a.decrease();},"B线程").start();*/

        C c = new C();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) c.pA();
        }, "A线程").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) c.pB();
        }, "B线程").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) c.pC();
        }, "C线程").start();
        /*new Thread(() -> {
            for (int i = 0; i < 10; i++) c.pABC();
        }, "A线程").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) c.pABC();
        }, "B线程").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) c.pABC();
        }, "C线程").start();*/

    }

}

class C {
    private int flag = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    /*public void pABC() {

        try {
            while (flag != 1) {
                condition.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.print("A");
            }
            System.out.println();
            flag = 2;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }*//*

        String name = Thread.currentThread().getName();
        if ("A线程".equalsIgnoreCase(name)) {
            lock.lock();
            while (flag != 1) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 5; i++) {
                System.out.print("A");
            }
            System.out.println();
            flag = 2;
            condition.signalAll();
            lock.unlock();
        }
        if ("B线程".equalsIgnoreCase(name)) {
            while (flag != 2) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 10; i++) {
                System.out.print("B");
            }
            System.out.println();
            flag = 3;
            condition.signalAll();
        }
        if ("C线程".equalsIgnoreCase(name)) {
            while (flag != 1) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 15; i++) {
                System.out.print("C");
            }
            System.out.println();
            flag = 1;
            condition.signalAll();
        }

*//*


    }*/

    public void pA() {
        lock.lock();
        try {
            while (flag != 1) {
                condition1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.print("A");
            }
            System.out.println();
            flag = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void pB() {
        lock.lock();
        try {
            while (flag != 2) {
                condition2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.print("B");
            }
            System.out.println();
            flag = 3;
            condition3.signalAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void pC() {
        lock.lock();
        try {
            while (flag != 3) {
                condition3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.print("C");
            }
            System.out.println();
            flag = 1;
            condition1.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


class A {

    private int n = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /*public synchronized  void increase() {


        while (n != 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        n++;
        System.out.println(Thread.currentThread().getName()+"已增为：" + n);
        notify();



    }

    public synchronized  void decrease() {


        while (n == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        n--;
        System.out.println(Thread.currentThread().getName()+"已减为：" + n);
        notify();

    }*/
    public void increase() {

        lock.lock();


        try {
            while (n != 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            n++;
            System.out.println(Thread.currentThread().getName() + "已增为：" + n);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void decrease() {
        lock.lock();


        try {
            while (n == 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            n--;
            System.out.println(Thread.currentThread().getName() + "已减为：" + n);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


}

class Airconditioner {

    private static Airconditioner airconditioner = new Airconditioner();

    private Airconditioner() {

    }

    public static Airconditioner getAirconditioner() {
        return airconditioner;
    }


}
