package com.xeagle.android.newUI.cameraManager;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import com.flypro.core.drone.DroneInterfaces;
import hf.d;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a {
    private static final int CONN_TIME_OUT = 3000;
    private static final int READ_TIME_OUT = 5000;
    private static final String TAG = "a";
    public static final int TCP_CONNECTED = 2;
    public static final int TCP_CONNECTING = 1;
    public static final int TCP_DISCONNECTED = 0;
    private Handler mBgHandler;
    private HandlerThread mBgHandlerThread;
    private final Runnable mConnectingTask = new Runnable() {
        public void run() {
            a.this.loadIpAndPort();
            try {
                a.this.connectToTcp();
                a.this.handleConnectStatus(true);
                while (a.this.mConnectionStatus.get() == 2) {
                    if (a.this.isUnbind()) {
                        a.this.disconnect();
                        a.this.disconnect();
                        return;
                    }
                    String readFromChannel = a.this.readFromChannel();
                    a.this.handleMsg(readFromChannel);
                    a.this.reportReceivedMsg(readFromChannel);
                }
            } catch (IOException e2) {
                if (!a.this.isUnbind()) {
                    if (a.this.mConnectionStatus.get() != 0) {
                        a aVar = a.this;
                        aVar.reportConnectFail(aVar.cameraType(), e2.getMessage());
                    }
                }
            } catch (Throwable th) {
                a.this.disconnect();
                throw th;
            }
            a.this.disconnect();
        }
    };
    /* access modifiers changed from: private */
    public final AtomicInteger mConnectionStatus = new AtomicInteger(0);
    private final Runnable mDriverRunnable = new Runnable() {
        public final void run() {
            a.this.lambda$new$0$a();
        }
    };
    private Thread mDriverThread;
    private final ConcurrentHashMap<String, b> mListenner = new ConcurrentHashMap<>();
    private DroneInterfaces.b mMainHandler;
    private final LinkedBlockingQueue<C0148a> mTaskQueue = new LinkedBlockingQueue<>();
    private final C0148a stopTask = new C0148a() {
        /* access modifiers changed from: protected */
        public void a() {
            a.this.stop();
        }
    };
    private ScheduledExecutorService taskExecutor;

    /* renamed from: com.xeagle.android.newUI.cameraManager.a$a  reason: collision with other inner class name */
    public static abstract class C0148a implements Runnable {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f23972a = false;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public a f23973b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public LinkedBlockingQueue<C0148a> f23974c;

        /* access modifiers changed from: protected */
        public abstract void a();

        public void run() {
            if (!this.f23973b.isConnected()) {
                this.f23974c.offer(this);
            } else {
                a();
            }
        }
    }

    public interface b {
        void a(int i2);

        void a(int i2, String str);

        void b(int i2);

        void b(int i2, String str);

        void c(int i2, String str);
    }

    private void destroyBgHandler() {
        HandlerThread handlerThread = this.mBgHandlerThread;
        if (handlerThread != null && handlerThread.isAlive()) {
            this.mBgHandlerThread.quit();
            this.mBgHandlerThread.interrupt();
            this.mBgHandlerThread = null;
        }
        this.mBgHandler = null;
    }

    private void destroyDriverThread() {
        Thread thread = this.mDriverThread;
        if (thread != null && thread.isAlive()) {
            this.mDriverThread.interrupt();
            this.mDriverThread = null;
        }
        this.mMainHandler = null;
    }

    private void initializeBgHandler() {
        HandlerThread handlerThread = this.mBgHandlerThread;
        if (handlerThread == null || handlerThread.isInterrupted()) {
            HandlerThread handlerThread2 = new HandlerThread("Camera Manager Background Thread");
            this.mBgHandlerThread = handlerThread2;
            handlerThread2.start();
            this.mBgHandler = null;
        }
        if (this.mBgHandler == null) {
            this.mBgHandler = new Handler(this.mBgHandlerThread.getLooper());
        }
    }

    private void initializeDriverThread(DroneInterfaces.b bVar) {
        Thread thread = this.mDriverThread;
        if (thread == null || thread.isInterrupted()) {
            Thread thread2 = new Thread(this.mDriverRunnable, "Camera Manager Driver Thread");
            this.mDriverThread = thread2;
            thread2.start();
        }
        if (this.mMainHandler == null) {
            this.mMainHandler = bVar;
        }
    }

    private void onConnected(DroneInterfaces.b bVar) {
        initializeBgHandler();
        initializeDriverThread(bVar);
    }

    private void reportConnect() {
        for (b a2 : this.mListenner.values()) {
            a2.a(cameraType());
        }
    }

    /* access modifiers changed from: private */
    public void reportConnectFail(int i2, String str) {
        if (!this.mListenner.isEmpty()) {
            for (b c2 : this.mListenner.values()) {
                c2.c(i2, str);
            }
        }
    }

    /* access modifiers changed from: private */
    public void reportReceivedMsg(String str) {
        if (!this.mListenner.isEmpty()) {
            for (b a2 : this.mListenner.values()) {
                a2.a(cameraType(), str);
            }
        }
    }

    private void startHandle(DroneInterfaces.b bVar) {
        LinkedBlockingQueue<C0148a> linkedBlockingQueue = this.mTaskQueue;
        if (linkedBlockingQueue != null && linkedBlockingQueue.size() > 0) {
            this.mTaskQueue.clear();
        }
        onConnected(bVar);
    }

    /* access modifiers changed from: private */
    public void stop() {
        destroyDriverThread();
        destroyBgHandler();
        this.mTaskQueue.clear();
    }

    private void stopSafely() {
        addTask(this.stopTask);
    }

    public boolean addTask(C0148a aVar) {
        if (this.mConnectionStatus.get() == 0) {
            Log.d("FTP", "addTask: --CameraClientManager is not started.");
            return false;
        }
        a unused = aVar.f23973b = this;
        LinkedBlockingQueue unused2 = aVar.f23974c = this.mTaskQueue;
        boolean unused3 = aVar.f23972a = false;
        return this.mTaskQueue.offer(aVar);
    }

    public boolean addTaskToBackground(C0148a aVar) {
        if (this.mConnectionStatus.get() == 0) {
            Log.d(TAG, "addTaskToBackground: --cameraClientManager is not started.");
            disconnect();
            SystemClock.sleep(100);
            connect(2);
            return false;
        }
        a unused = aVar.f23973b = this;
        LinkedBlockingQueue unused2 = aVar.f23974c = this.mTaskQueue;
        boolean unused3 = aVar.f23972a = true;
        return this.mTaskQueue.offer(aVar);
    }

    public void addTcpConnectionStatusListener(String str, b bVar) {
        this.mListenner.put(str, bVar);
        if (getConnectionStatus() == 2) {
            bVar.a(cameraType());
        }
    }

    /* access modifiers changed from: protected */
    public abstract int cameraType();

    public void connect(int i2) {
        Log.i(TAG + "test", "connect: " + i2);
        if (!isUnbind() && this.mConnectionStatus.compareAndSet(0, 1)) {
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.taskExecutor = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.execute(this.mConnectingTask);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void connectToTcp() throws IOException;

    public void disconnect() {
        if (this.mConnectionStatus.get() != 0 && this.taskExecutor != null) {
            try {
                this.mConnectionStatus.set(0);
                d.b("RTSP", "disconnect: ====SHUT DOWN");
                ScheduledExecutorService scheduledExecutorService = this.taskExecutor;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                    this.taskExecutor = null;
                }
                stop();
                disconnectTcp();
                reportDisconnect();
            } catch (IOException e2) {
                if (!isUnbind()) {
                    reportCommunicationError(e2.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void disconnectTcp() throws IOException;

    public int getCameraType() {
        return cameraType();
    }

    public int getConnectionStatus() {
        return this.mConnectionStatus.get();
    }

    /* access modifiers changed from: protected */
    public abstract DroneInterfaces.b getMainHandler();

    public void handleConnectStatus(boolean z2) {
        if (z2) {
            this.mConnectionStatus.set(2);
            reportConnect();
            startHandle(getMainHandler());
            return;
        }
        this.mConnectionStatus.set(0);
    }

    /* access modifiers changed from: protected */
    public abstract void handleMsg(String str);

    public boolean isConnected() {
        return this.mConnectionStatus.get() == 2;
    }

    public boolean isConnecting() {
        return this.mConnectionStatus.get() == 1;
    }

    /* access modifiers changed from: protected */
    public abstract boolean isUnbind();

    public /* synthetic */ void lambda$new$0$a() {
        while (this.mConnectionStatus.get() == 2) {
            Log.i("UsbDataProxy", ": =====mDriverRunnable tcp  connect");
            try {
                C0148a take = this.mTaskQueue.take();
                Log.i("UsbDataProxy", ": =====mDriverRunnable tcp  take");
                if (take != null) {
                    if (take.f23972a) {
                        Handler handler = this.mBgHandler;
                        if (handler != null) {
                            handler.post(take);
                        }
                    } else {
                        DroneInterfaces.b bVar = this.mMainHandler;
                        if (bVar != null) {
                            bVar.post(take);
                        }
                    }
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
                Log.e("UsbDataProxy", "====mCDriverRunnable====error=== " + e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void loadIpAndPort();

    /* access modifiers changed from: protected */
    public abstract String readFromChannel();

    public void removeTcpConnectionListener(String str) {
        this.mListenner.remove(str);
    }

    public void reportCommunicationError(String str) {
        if (!this.mListenner.isEmpty()) {
            for (b b2 : this.mListenner.values()) {
                b2.b(cameraType(), str);
            }
        }
    }

    public void reportDisconnect() {
        if (!this.mListenner.isEmpty()) {
            for (b b2 : this.mListenner.values()) {
                b2.b(cameraType());
            }
        }
    }

    public boolean sendCameraMsg(final String str) {
        return addTask(new C0148a() {
            /* access modifiers changed from: protected */
            public void a() {
                a.this.sendMsg(str.getBytes());
            }
        });
    }

    public boolean sendCameraMsgByBackground(final String str) {
        Log.e("CameraClient", "sendCameraMsgByBackground:--- " + str);
        return addTaskToBackground(new C0148a() {
            /* access modifiers changed from: protected */
            public void a() {
                a.this.sendMsg(str.getBytes());
            }
        });
    }

    public void sendMsg(byte[] bArr) {
        try {
            writeToChannel(bArr);
        } catch (IOException e2) {
            Log.e("UsbDataProxy", "run: ====sendMsg====error==" + e2.getMessage());
            e2.printStackTrace();
            reportCommunicationError(e2.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public abstract void writeToChannel(byte[] bArr) throws IOException;
}
