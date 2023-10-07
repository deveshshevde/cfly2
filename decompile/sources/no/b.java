package no;

public class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final a f31605a;

    public b(a aVar) {
        super("AWT-DataTransferThread");
        setDaemon(true);
        this.f31605a = aVar;
    }

    public void run() {
        synchronized (this) {
            try {
                this.f31605a.b();
                notifyAll();
            } catch (Throwable th) {
                notifyAll();
                throw th;
            }
        }
        this.f31605a.c();
    }

    public void start() {
        synchronized (this) {
            super.start();
            try {
                wait();
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            }
        }
    }
}
