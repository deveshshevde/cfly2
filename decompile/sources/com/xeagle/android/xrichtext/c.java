package com.xeagle.android.xrichtext;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xeagle.android.xrichtext.XRichText;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f26234a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f26235b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f26236c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f26237d;

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadFactory f26238e;

    /* renamed from: f  reason: collision with root package name */
    private static Handler f26239f = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null && message.obj != null && (message.obj instanceof XRichText.b)) {
                ((XRichText.b) message.obj).a();
            }
        }
    };

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f26235b = availableProcessors;
        int i2 = availableProcessors + 1;
        f26236c = i2;
        int i3 = (availableProcessors * 2) + 1;
        f26237d = i3;
        AnonymousClass1 r8 = new ThreadFactory() {

            /* renamed from: a  reason: collision with root package name */
            private final AtomicInteger f26240a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "LoaderTask#" + this.f26240a.getAndIncrement());
            }
        };
        f26238e = r8;
        f26234a = new ThreadPoolExecutor(i2, i3, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), r8);
    }

    public static Handler a() {
        return f26239f;
    }

    public static Executor b() {
        return f26234a;
    }
}
