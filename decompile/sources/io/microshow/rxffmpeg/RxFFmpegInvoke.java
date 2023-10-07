package io.microshow.rxffmpeg;

import io.reactivex.BackpressureStrategy;
import io.reactivex.b;
import io.reactivex.c;
import io.reactivex.d;
import lz.a;

public class RxFFmpegInvoke {
    public static final String TAG = "RxFFmpegInvoke";
    private static volatile RxFFmpegInvoke instance;
    private IFFmpegListener ffmpegListener;

    public interface IFFmpegListener {
        void onCancel();

        void onError(String str);

        void onFinish();

        void onProgress(int i2, long j2);
    }

    static {
        System.loadLibrary("rxffmpeg-core");
        System.loadLibrary("rxffmpeg-invoke");
    }

    private RxFFmpegInvoke() {
    }

    public static RxFFmpegInvoke getInstance() {
        if (instance == null) {
            synchronized (RxFFmpegInvoke.class) {
                if (instance == null) {
                    instance = new RxFFmpegInvoke();
                }
            }
        }
        return instance;
    }

    public native void exit();

    public IFFmpegListener getFFmpegListener() {
        return this.ffmpegListener;
    }

    public native String getMediaInfo(String str);

    public void onCancel() {
        IFFmpegListener iFFmpegListener = this.ffmpegListener;
        if (iFFmpegListener != null) {
            iFFmpegListener.onCancel();
        }
    }

    public void onClean() {
        if (this.ffmpegListener != null) {
            this.ffmpegListener = null;
        }
    }

    public void onDestroy() {
        if (this.ffmpegListener != null) {
            this.ffmpegListener = null;
        }
        if (instance != null) {
            instance = null;
        }
    }

    public void onError(String str) {
        IFFmpegListener iFFmpegListener = this.ffmpegListener;
        if (iFFmpegListener != null) {
            iFFmpegListener.onError(str);
        }
    }

    public void onFinish() {
        IFFmpegListener iFFmpegListener = this.ffmpegListener;
        if (iFFmpegListener != null) {
            iFFmpegListener.onFinish();
        }
    }

    public void onProgress(int i2, long j2) {
        IFFmpegListener iFFmpegListener = this.ffmpegListener;
        if (iFFmpegListener != null) {
            iFFmpegListener.onProgress(i2, j2);
        }
    }

    public int runCommand(String[] strArr, IFFmpegListener iFFmpegListener) {
        int runFFmpegCmd;
        setFFmpegListener(iFFmpegListener);
        synchronized (RxFFmpegInvoke.class) {
            runFFmpegCmd = runFFmpegCmd(strArr);
            onClean();
        }
        return runFFmpegCmd;
    }

    public void runCommandAsync(final String[] strArr, IFFmpegListener iFFmpegListener) {
        setFFmpegListener(iFFmpegListener);
        synchronized (RxFFmpegInvoke.class) {
            new Thread(new Runnable() {
                public void run() {
                    RxFFmpegInvoke.this.runFFmpegCmd(strArr);
                    RxFFmpegInvoke.this.onClean();
                }
            }).start();
        }
    }

    public b<RxFFmpegProgress> runCommandRxJava(final String[] strArr) {
        return b.a(new d<RxFFmpegProgress>() {
            public void subscribe(final c<RxFFmpegProgress> cVar) {
                RxFFmpegInvoke.this.setFFmpegListener(new IFFmpegListener() {
                    public void onCancel() {
                        cVar.a(new RxFFmpegProgress(RxFFmpegSubscriber.STATE_CANCEL));
                    }

                    public void onError(String str) {
                        cVar.a(new Throwable(str));
                    }

                    public void onFinish() {
                        cVar.a();
                    }

                    public void onProgress(int i2, long j2) {
                        cVar.a(new RxFFmpegProgress(RxFFmpegSubscriber.STATE_PROGRESS, i2, j2));
                    }
                });
                RxFFmpegInvoke.this.runFFmpegCmd(strArr);
                RxFFmpegInvoke.this.onClean();
            }
        }, BackpressureStrategy.BUFFER).b(a.b()).a(lu.a.a());
    }

    public native int runFFmpegCmd(String[] strArr);

    public native void setDebug(boolean z2);

    public void setFFmpegListener(IFFmpegListener iFFmpegListener) {
        this.ffmpegListener = iFFmpegListener;
    }
}
