package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

public final class fl {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8787a = fg.c("SYmFja3Vwcw");

    /* renamed from: b  reason: collision with root package name */
    public static final String f8788b = fg.c("SLmFkaXU");

    /* renamed from: c  reason: collision with root package name */
    public static final String f8789c = fg.c("JIw");

    private static String a(Context context) {
        StorageManager storageManager = Build.VERSION.SDK_INT >= 9 ? (StorageManager) context.getSystemService("storage") : null;
        try {
            Class<?> cls = Class.forName(fg.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(fg.c("FZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
            Method method2 = cls.getMethod(fg.c("ZZ2V0UGF0aA"), new Class[0]);
            Method method3 = cls.getMethod(fg.c("AaXNSZW1vdmFibGUK"), new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = Array.get(invoke, i2);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
            return null;
        } catch (Throwable unused) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.nio.channels.FileChannel} */
    /* JADX WARNING: type inference failed for: r5v3, types: [java.io.Closeable] */
    /* JADX WARNING: Can't wrap try/catch for region: R(16:7|8|9|10|11|(1:15)|16|17|18|19|20|(1:22)|(2:24|25)|(2:28|29)|30|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0086, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0082 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008d A[SYNTHETIC, Splitter:B:41:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0094 A[SYNTHETIC, Splitter:B:45:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009b A[SYNTHETIC, Splitter:B:49:0x009b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.Class<com.amap.api.mapcore.util.fl> r0 = com.amap.api.mapcore.util.fl.class
            monitor-enter(r0)
            java.lang.String r3 = a(r3)     // Catch:{ all -> 0x00a0 }
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00a0 }
            if (r1 == 0) goto L_0x000f
            monitor-exit(r0)
            return
        L_0x000f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a0 }
            r1.<init>()     // Catch:{ all -> 0x00a0 }
            r1.append(r4)     // Catch:{ all -> 0x00a0 }
            java.lang.String r4 = f8789c     // Catch:{ all -> 0x00a0 }
            r1.append(r4)     // Catch:{ all -> 0x00a0 }
            r1.append(r5)     // Catch:{ all -> 0x00a0 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x00a0 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a0 }
            r5.<init>()     // Catch:{ all -> 0x00a0 }
            r5.append(r3)     // Catch:{ all -> 0x00a0 }
            java.lang.String r3 = java.io.File.separator     // Catch:{ all -> 0x00a0 }
            r5.append(r3)     // Catch:{ all -> 0x00a0 }
            java.lang.String r3 = f8787a     // Catch:{ all -> 0x00a0 }
            r5.append(r3)     // Catch:{ all -> 0x00a0 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x00a0 }
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x00a0 }
            r5.<init>(r3)     // Catch:{ all -> 0x00a0 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x00a0 }
            java.lang.String r1 = f8788b     // Catch:{ all -> 0x00a0 }
            r3.<init>(r5, r1)     // Catch:{ all -> 0x00a0 }
            r1 = 0
            boolean r2 = r5.exists()     // Catch:{ all -> 0x0089 }
            if (r2 == 0) goto L_0x0052
            boolean r2 = r5.isDirectory()     // Catch:{ all -> 0x0089 }
            if (r2 == 0) goto L_0x0055
        L_0x0052:
            r5.mkdirs()     // Catch:{ all -> 0x0089 }
        L_0x0055:
            r3.createNewFile()     // Catch:{ all -> 0x0089 }
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0089 }
            java.lang.String r2 = "rws"
            r5.<init>(r3, r2)     // Catch:{ all -> 0x0089 }
            java.nio.channels.FileChannel r3 = r5.getChannel()     // Catch:{ all -> 0x0087 }
            java.nio.channels.FileLock r1 = r3.tryLock()     // Catch:{ all -> 0x008b }
            if (r1 == 0) goto L_0x0076
            java.lang.String r2 = "UTF-8"
            byte[] r4 = r4.getBytes(r2)     // Catch:{ all -> 0x008b }
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.wrap(r4)     // Catch:{ all -> 0x008b }
            r3.write(r4)     // Catch:{ all -> 0x008b }
        L_0x0076:
            if (r1 == 0) goto L_0x007d
            r1.release()     // Catch:{ IOException -> 0x007c }
            goto L_0x007d
        L_0x007c:
        L_0x007d:
            if (r3 == 0) goto L_0x0082
            r3.close()     // Catch:{ IOException -> 0x0082 }
        L_0x0082:
            r5.close()     // Catch:{ all -> 0x0085 }
        L_0x0085:
            monitor-exit(r0)
            return
        L_0x0087:
            r3 = r1
            goto L_0x008b
        L_0x0089:
            r3 = r1
            r5 = r3
        L_0x008b:
            if (r1 == 0) goto L_0x0092
            r1.release()     // Catch:{ IOException -> 0x0091 }
            goto L_0x0092
        L_0x0091:
        L_0x0092:
            if (r3 == 0) goto L_0x0099
            r3.close()     // Catch:{ IOException -> 0x0098 }
            goto L_0x0099
        L_0x0098:
        L_0x0099:
            if (r5 == 0) goto L_0x009e
            r5.close()     // Catch:{ all -> 0x009e }
        L_0x009e:
            monitor-exit(r0)
            return
        L_0x00a0:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.fl.a(android.content.Context, java.lang.String, java.lang.String):void");
    }
}
