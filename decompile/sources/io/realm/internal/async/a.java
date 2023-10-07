package io.realm.internal.async;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public class a extends ThreadPoolExecutor {

    /* renamed from: a  reason: collision with root package name */
    private static final int f29022a = b();

    /* renamed from: b  reason: collision with root package name */
    private boolean f29023b;

    /* renamed from: c  reason: collision with root package name */
    private ReentrantLock f29024c;

    /* renamed from: d  reason: collision with root package name */
    private Condition f29025d;

    private a(int i2, int i3) {
        super(i2, i3, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(100));
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f29024c = reentrantLock;
        this.f29025d = reentrantLock.newCondition();
    }

    private static int a(String str, String str2) {
        final Pattern compile = Pattern.compile(str2);
        try {
            File[] listFiles = new File(str).listFiles(new FileFilter() {
                public boolean accept(File file) {
                    return compile.matcher(file.getName()).matches();
                }
            });
            if (listFiles == null) {
                return 0;
            }
            return listFiles.length;
        } catch (SecurityException unused) {
            return 0;
        }
    }

    public static a a() {
        int i2 = f29022a;
        return new a(i2, i2);
    }

    private static int b() {
        int a2 = a("/sys/devices/system/cpu/", "cpu[0-9]+");
        if (a2 <= 0) {
            a2 = Runtime.getRuntime().availableProcessors();
        }
        if (a2 <= 0) {
            return 1;
        }
        return 1 + (a2 * 2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:7|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        r0.f29024c.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r1.interrupt();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void beforeExecute(java.lang.Thread r1, java.lang.Runnable r2) {
        /*
            r0 = this;
            super.beforeExecute(r1, r2)
            java.util.concurrent.locks.ReentrantLock r2 = r0.f29024c
            r2.lock()
        L_0x0008:
            boolean r2 = r0.f29023b     // Catch:{ InterruptedException -> 0x001a }
            if (r2 == 0) goto L_0x0012
            java.util.concurrent.locks.Condition r2 = r0.f29025d     // Catch:{ InterruptedException -> 0x001a }
            r2.await()     // Catch:{ InterruptedException -> 0x001a }
            goto L_0x0008
        L_0x0012:
            java.util.concurrent.locks.ReentrantLock r1 = r0.f29024c
            r1.unlock()
            goto L_0x001e
        L_0x0018:
            r1 = move-exception
            goto L_0x001f
        L_0x001a:
            r1.interrupt()     // Catch:{ all -> 0x0018 }
            goto L_0x0012
        L_0x001e:
            return
        L_0x001f:
            java.util.concurrent.locks.ReentrantLock r2 = r0.f29024c
            r2.unlock()
            goto L_0x0026
        L_0x0025:
            throw r1
        L_0x0026:
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.internal.async.a.beforeExecute(java.lang.Thread, java.lang.Runnable):void");
    }
}
