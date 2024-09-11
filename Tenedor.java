import java.util.concurrent.locks.ReentrantLock;

public class Tenedor {
    private final ReentrantLock lock = new ReentrantLock();

    public boolean tomar() {
        return lock.tryLock();
    }

    public void soltar() {
        lock.unlock();
    }
}
