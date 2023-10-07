package com.facebook.soloader;

import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SoLoader {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f11384a;

    /* renamed from: b  reason: collision with root package name */
    static f f11385b;

    /* renamed from: c  reason: collision with root package name */
    private static final ReentrantReadWriteLock f11386c = new ReentrantReadWriteLock();

    /* renamed from: d  reason: collision with root package name */
    private static g[] f11387d = null;

    /* renamed from: e  reason: collision with root package name */
    private static int f11388e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static i[] f11389f;

    /* renamed from: g  reason: collision with root package name */
    private static a f11390g;

    /* renamed from: h  reason: collision with root package name */
    private static final HashSet<String> f11391h = new HashSet<>();

    /* renamed from: i  reason: collision with root package name */
    private static final Map<String, Object> f11392i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    private static final Set<String> f11393j = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: k  reason: collision with root package name */
    private static h f11394k = null;

    private static class Api14Utils {
        private Api14Utils() {
        }
    }

    public static final class WrongAbiError extends UnsatisfiedLinkError {
        WrongAbiError(Throwable th) {
            super("APK was built for a different platform");
            initCause(th);
        }
    }

    static {
        boolean z2 = false;
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                z2 = true;
            }
        } catch (NoClassDefFoundError | UnsatisfiedLinkError unused) {
        }
        f11384a = z2;
    }

    private static void a() {
        ReentrantReadWriteLock reentrantReadWriteLock = f11386c;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (f11387d != null) {
                reentrantReadWriteLock.readLock().unlock();
                return;
            }
            throw new RuntimeException("SoLoader.init() not yet called");
        } catch (Throwable th) {
            f11386c.readLock().unlock();
            throw th;
        }
    }

    static void a(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        a(str, (String) null, (String) null, i2, threadPolicy);
    }

    public static boolean a(String str) {
        return a(str, 0);
    }

    public static boolean a(String str, int i2) throws UnsatisfiedLinkError {
        boolean z2;
        ReentrantReadWriteLock reentrantReadWriteLock = f11386c;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (f11387d == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    a();
                } else {
                    synchronized (SoLoader.class) {
                        z2 = !f11391h.contains(str);
                        if (z2) {
                            h hVar = f11394k;
                            if (hVar != null) {
                                hVar.a(str);
                            } else {
                                System.loadLibrary(str);
                            }
                        }
                    }
                    reentrantReadWriteLock.readLock().unlock();
                    return z2;
                }
            }
            reentrantReadWriteLock.readLock().unlock();
            String a2 = e.a(str);
            return a(System.mapLibraryName(a2 != null ? a2 : str), str, a2, i2 | 2, (StrictMode.ThreadPolicy) null);
        } catch (Throwable th) {
            f11386c.readLock().unlock();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        if (r3 != false) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0042, code lost:
        if (r1.contains(r9) == false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0044, code lost:
        if (r11 != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0046, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0048, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0049, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004b, code lost:
        if (r3 != false) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        android.util.Log.d("SoLoader", "About to load: " + r9);
        b(r9, r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        android.util.Log.d("SoLoader", "Loaded: " + r9);
        r1.add(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0080, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0085, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0086, code lost:
        r10 = r9.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x008a, code lost:
        if (r10 == null) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0099, code lost:
        throw new com.facebook.soloader.SoLoader.WrongAbiError(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x009a, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x009b, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00a1, code lost:
        throw new java.lang.RuntimeException(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00a9, code lost:
        if (android.text.TextUtils.isEmpty(r10) != false) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00b1, code lost:
        if (f11393j.contains(r10) == false) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00b3, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00b4, code lost:
        if (r11 == null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00b6, code lost:
        if (r2 != false) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00b8, code lost:
        r11 = f11384a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00ba, code lost:
        if (r11 == false) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00bc, code lost:
        com.facebook.soloader.Api18TraceUtils.a("MergedSoMapping.invokeJniOnload[" + r10 + "]");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        android.util.Log.d("SoLoader", "About to merge: " + r10 + " / " + r9);
        com.facebook.soloader.e.b(r10);
        f11393j.add(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00fb, code lost:
        if (r11 == false) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        com.facebook.soloader.Api18TraceUtils.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0101, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0104, code lost:
        if (f11384a != false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0106, code lost:
        com.facebook.soloader.Api18TraceUtils.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0109, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x010a, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x010d, code lost:
        return !r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, android.os.StrictMode.ThreadPolicy r13) {
        /*
            java.lang.Class<com.facebook.soloader.SoLoader> r0 = com.facebook.soloader.SoLoader.class
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            r2 = 0
            if (r1 != 0) goto L_0x0012
            java.util.Set<java.lang.String> r1 = f11393j
            boolean r1 = r1.contains(r10)
            if (r1 == 0) goto L_0x0012
            return r2
        L_0x0012:
            monitor-enter(r0)
            java.util.HashSet<java.lang.String> r1 = f11391h     // Catch:{ all -> 0x0111 }
            boolean r3 = r1.contains(r9)     // Catch:{ all -> 0x0111 }
            r4 = 1
            if (r3 == 0) goto L_0x0022
            if (r11 != 0) goto L_0x0020
            monitor-exit(r0)     // Catch:{ all -> 0x0111 }
            return r2
        L_0x0020:
            r3 = 1
            goto L_0x0023
        L_0x0022:
            r3 = 0
        L_0x0023:
            java.util.Map<java.lang.String, java.lang.Object> r5 = f11392i     // Catch:{ all -> 0x0111 }
            boolean r6 = r5.containsKey(r9)     // Catch:{ all -> 0x0111 }
            if (r6 == 0) goto L_0x0030
            java.lang.Object r5 = r5.get(r9)     // Catch:{ all -> 0x0111 }
            goto L_0x0039
        L_0x0030:
            java.lang.Object r6 = new java.lang.Object     // Catch:{ all -> 0x0111 }
            r6.<init>()     // Catch:{ all -> 0x0111 }
            r5.put(r9, r6)     // Catch:{ all -> 0x0111 }
            r5 = r6
        L_0x0039:
            monitor-exit(r0)     // Catch:{ all -> 0x0111 }
            monitor-enter(r5)
            if (r3 != 0) goto L_0x00a5
            monitor-enter(r0)     // Catch:{ all -> 0x010e }
            boolean r6 = r1.contains(r9)     // Catch:{ all -> 0x00a2 }
            if (r6 == 0) goto L_0x004a
            if (r11 != 0) goto L_0x0049
            monitor-exit(r0)     // Catch:{ all -> 0x00a2 }
            monitor-exit(r5)     // Catch:{ all -> 0x010e }
            return r2
        L_0x0049:
            r3 = 1
        L_0x004a:
            monitor-exit(r0)     // Catch:{ all -> 0x00a2 }
            if (r3 != 0) goto L_0x00a5
            java.lang.String r6 = "SoLoader"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x009b, UnsatisfiedLinkError -> 0x0085 }
            r7.<init>()     // Catch:{ IOException -> 0x009b, UnsatisfiedLinkError -> 0x0085 }
            java.lang.String r8 = "About to load: "
            r7.append(r8)     // Catch:{ IOException -> 0x009b, UnsatisfiedLinkError -> 0x0085 }
            r7.append(r9)     // Catch:{ IOException -> 0x009b, UnsatisfiedLinkError -> 0x0085 }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x009b, UnsatisfiedLinkError -> 0x0085 }
            android.util.Log.d(r6, r7)     // Catch:{ IOException -> 0x009b, UnsatisfiedLinkError -> 0x0085 }
            b(r9, r12, r13)     // Catch:{ IOException -> 0x009b, UnsatisfiedLinkError -> 0x0085 }
            monitor-enter(r0)     // Catch:{ all -> 0x010e }
            java.lang.String r12 = "SoLoader"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
            r13.<init>()     // Catch:{ all -> 0x0082 }
            java.lang.String r6 = "Loaded: "
            r13.append(r6)     // Catch:{ all -> 0x0082 }
            r13.append(r9)     // Catch:{ all -> 0x0082 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0082 }
            android.util.Log.d(r12, r13)     // Catch:{ all -> 0x0082 }
            r1.add(r9)     // Catch:{ all -> 0x0082 }
            monitor-exit(r0)     // Catch:{ all -> 0x0082 }
            goto L_0x00a5
        L_0x0082:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0082 }
            throw r9     // Catch:{ all -> 0x010e }
        L_0x0085:
            r9 = move-exception
            java.lang.String r10 = r9.getMessage()     // Catch:{ all -> 0x010e }
            if (r10 == 0) goto L_0x009a
            java.lang.String r11 = "unexpected e_machine:"
            boolean r10 = r10.contains(r11)     // Catch:{ all -> 0x010e }
            if (r10 == 0) goto L_0x009a
            com.facebook.soloader.SoLoader$WrongAbiError r10 = new com.facebook.soloader.SoLoader$WrongAbiError     // Catch:{ all -> 0x010e }
            r10.<init>(r9)     // Catch:{ all -> 0x010e }
            throw r10     // Catch:{ all -> 0x010e }
        L_0x009a:
            throw r9     // Catch:{ all -> 0x010e }
        L_0x009b:
            r9 = move-exception
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ all -> 0x010e }
            r10.<init>(r9)     // Catch:{ all -> 0x010e }
            throw r10     // Catch:{ all -> 0x010e }
        L_0x00a2:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a2 }
            throw r9     // Catch:{ all -> 0x010e }
        L_0x00a5:
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x010e }
            if (r12 != 0) goto L_0x00b4
            java.util.Set<java.lang.String> r12 = f11393j     // Catch:{ all -> 0x010e }
            boolean r12 = r12.contains(r10)     // Catch:{ all -> 0x010e }
            if (r12 == 0) goto L_0x00b4
            r2 = 1
        L_0x00b4:
            if (r11 == 0) goto L_0x010a
            if (r2 != 0) goto L_0x010a
            boolean r11 = f11384a     // Catch:{ all -> 0x010e }
            if (r11 == 0) goto L_0x00d5
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r12.<init>()     // Catch:{ all -> 0x010e }
            java.lang.String r13 = "MergedSoMapping.invokeJniOnload["
            r12.append(r13)     // Catch:{ all -> 0x010e }
            r12.append(r10)     // Catch:{ all -> 0x010e }
            java.lang.String r13 = "]"
            r12.append(r13)     // Catch:{ all -> 0x010e }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x010e }
            com.facebook.soloader.Api18TraceUtils.a(r12)     // Catch:{ all -> 0x010e }
        L_0x00d5:
            java.lang.String r12 = "SoLoader"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0101 }
            r13.<init>()     // Catch:{ all -> 0x0101 }
            java.lang.String r0 = "About to merge: "
            r13.append(r0)     // Catch:{ all -> 0x0101 }
            r13.append(r10)     // Catch:{ all -> 0x0101 }
            java.lang.String r0 = " / "
            r13.append(r0)     // Catch:{ all -> 0x0101 }
            r13.append(r9)     // Catch:{ all -> 0x0101 }
            java.lang.String r9 = r13.toString()     // Catch:{ all -> 0x0101 }
            android.util.Log.d(r12, r9)     // Catch:{ all -> 0x0101 }
            com.facebook.soloader.e.b(r10)     // Catch:{ all -> 0x0101 }
            java.util.Set<java.lang.String> r9 = f11393j     // Catch:{ all -> 0x0101 }
            r9.add(r10)     // Catch:{ all -> 0x0101 }
            if (r11 == 0) goto L_0x010a
            com.facebook.soloader.Api18TraceUtils.a()     // Catch:{ all -> 0x010e }
            goto L_0x010a
        L_0x0101:
            r9 = move-exception
            boolean r10 = f11384a     // Catch:{ all -> 0x010e }
            if (r10 == 0) goto L_0x0109
            com.facebook.soloader.Api18TraceUtils.a()     // Catch:{ all -> 0x010e }
        L_0x0109:
            throw r9     // Catch:{ all -> 0x010e }
        L_0x010a:
            monitor-exit(r5)     // Catch:{ all -> 0x010e }
            r9 = r3 ^ 1
            return r9
        L_0x010e:
            r9 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x010e }
            throw r9
        L_0x0111:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0111 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.a(java.lang.String, java.lang.String, java.lang.String, int, android.os.StrictMode$ThreadPolicy):boolean");
    }

    /* JADX INFO: finally extract failed */
    private static void b(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        boolean z2;
        boolean z3;
        ReentrantReadWriteLock reentrantReadWriteLock = f11386c;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (f11387d != null) {
                reentrantReadWriteLock.readLock().unlock();
                if (threadPolicy == null) {
                    threadPolicy = StrictMode.allowThreadDiskReads();
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (f11384a) {
                    Api18TraceUtils.a("SoLoader.loadLibrary[" + str + "]");
                }
                int i3 = 0;
                do {
                    try {
                        f11386c.readLock().lock();
                        int i4 = f11388e;
                        int i5 = 0;
                        while (true) {
                            if (i3 != 0) {
                                break;
                            }
                            g[] gVarArr = f11387d;
                            if (i5 < gVarArr.length) {
                                i3 = gVarArr[i5].a(str, i2, threadPolicy);
                                if (i3 == 3 && f11389f != null) {
                                    Log.d("SoLoader", "Trying backup SoSource for " + str);
                                    i[] iVarArr = f11389f;
                                    int length = iVarArr.length;
                                    int i6 = 0;
                                    while (true) {
                                        if (i6 >= length) {
                                            break;
                                        }
                                        i iVar = iVarArr[i6];
                                        iVar.a(str);
                                        int a2 = iVar.a(str, i2, threadPolicy);
                                        if (a2 == 1) {
                                            i3 = a2;
                                            break;
                                        }
                                        i6++;
                                    }
                                } else {
                                    i5++;
                                }
                            } else {
                                break;
                            }
                        }
                        ReentrantReadWriteLock reentrantReadWriteLock2 = f11386c;
                        reentrantReadWriteLock2.readLock().unlock();
                        if ((i2 & 2) == 2 && i3 == 0) {
                            reentrantReadWriteLock2.writeLock().lock();
                            a aVar = f11390g;
                            if (aVar != null && aVar.a()) {
                                f11388e++;
                            }
                            z3 = f11388e != i4;
                            reentrantReadWriteLock2.writeLock().unlock();
                            continue;
                        } else {
                            z3 = false;
                            continue;
                        }
                    } catch (Throwable th) {
                        if (f11384a) {
                            Api18TraceUtils.a();
                        }
                        if (z2) {
                            StrictMode.setThreadPolicy(threadPolicy);
                        }
                        if (i3 == 0 || i3 == 3) {
                            String str2 = "couldn't find DSO to load: " + str;
                            String message = th.getMessage();
                            if (message == null) {
                                message = th.toString();
                            }
                            String str3 = str2 + " caused by: " + message;
                            Log.e("SoLoader", str3);
                            throw new UnsatisfiedLinkError(str3);
                        }
                        return;
                    }
                } while (z3);
                if (f11384a) {
                    Api18TraceUtils.a();
                }
                if (z2) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                if (i3 == 0 || i3 == 3) {
                    String str4 = "couldn't find DSO to load: " + str;
                    Log.e("SoLoader", str4);
                    throw new UnsatisfiedLinkError(str4);
                }
                return;
            }
            Log.e("SoLoader", "Could not load: " + str + " because no SO source exists");
            throw new UnsatisfiedLinkError("couldn't find DSO to load: " + str);
        } catch (Throwable th2) {
            f11386c.readLock().unlock();
            throw th2;
        }
    }
}
