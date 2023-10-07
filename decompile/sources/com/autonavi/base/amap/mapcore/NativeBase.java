package com.autonavi.base.amap.mapcore;

import com.autonavi.base.amap.mapcore.annotations.ParameterIsClass;
import java.util.ArrayList;

public abstract class NativeBase {
    private static final String CREATE_OVERLAY = "createOverlay";
    private static final int STACK_NUMBER = 3;
    private static final String UPDATE_OPTIONS = "updateOptions";
    protected volatile boolean destroy = false;
    private boolean mCalledFuntion = false;
    ArrayList<Method> methodMap = new ArrayList<>();
    ArrayList<Runnable> runnableArrayList = new ArrayList<>();
    protected boolean useRunnable = true;

    public static class Method {
        private boolean baseClass;
        /* access modifiers changed from: private */
        public Class<?>[] clazz;
        /* access modifiers changed from: private */
        public String methodName;
        /* access modifiers changed from: private */
        public Object object;
        /* access modifiers changed from: private */
        public Object[] param;

        public Method(Object obj, String str, boolean z2, Object... objArr) {
            this.object = obj;
            this.methodName = str;
            this.baseClass = z2;
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        this.clazz = new Class[objArr.length];
                        z2 = (NativeBase.CREATE_OVERLAY.equals(str) || NativeBase.UPDATE_OPTIONS.equals(str)) ? true : z2;
                        int i2 = 0;
                        if (z2) {
                            while (i2 < objArr.length) {
                                if (i2 == 1) {
                                    this.clazz[i2] = objArr[i2].getClass().getSuperclass();
                                } else {
                                    this.clazz[i2] = objArr[i2].getClass();
                                }
                                i2++;
                            }
                        } else {
                            while (i2 < objArr.length) {
                                this.clazz[i2] = objArr[i2].getClass();
                                i2++;
                            }
                        }
                        this.param = new Object[objArr.length];
                        for (int i3 = 0; i3 < objArr.length; i3++) {
                            this.param[i3] = objArr[i3];
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x008c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void callAllFunction() {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.isReady()     // Catch:{ all -> 0x008d }
            if (r0 == 0) goto L_0x008b
            boolean r0 = r6.destroy     // Catch:{ all -> 0x008d }
            if (r0 == 0) goto L_0x000d
            goto L_0x008b
        L_0x000d:
            boolean r0 = r6.mCalledFuntion     // Catch:{ all -> 0x008d }
            r1 = 1
            if (r0 != r1) goto L_0x0014
            monitor-exit(r6)
            return
        L_0x0014:
            r6.mCalledFuntion = r1     // Catch:{ all -> 0x0089 }
            boolean r0 = r6.useRunnable     // Catch:{ all -> 0x0089 }
            if (r0 == 0) goto L_0x003c
        L_0x001a:
            java.util.ArrayList<java.lang.Runnable> r0 = r6.runnableArrayList     // Catch:{ all -> 0x0089 }
            int r0 = r0.size()     // Catch:{ all -> 0x0089 }
            if (r0 <= 0) goto L_0x003a
            boolean r0 = r6.destroy     // Catch:{ all -> 0x0089 }
            if (r0 != 0) goto L_0x003a
            java.util.ArrayList<java.lang.Runnable> r0 = r6.runnableArrayList     // Catch:{ all -> 0x0089 }
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0089 }
            java.lang.Runnable r0 = (java.lang.Runnable) r0     // Catch:{ all -> 0x0089 }
            if (r0 == 0) goto L_0x0034
            r0.run()     // Catch:{ all -> 0x0089 }
        L_0x0034:
            java.util.ArrayList<java.lang.Runnable> r0 = r6.runnableArrayList     // Catch:{ all -> 0x0089 }
            r0.remove(r1)     // Catch:{ all -> 0x0089 }
            goto L_0x001a
        L_0x003a:
            monitor-exit(r6)
            return
        L_0x003c:
            java.util.ArrayList<com.autonavi.base.amap.mapcore.NativeBase$Method> r0 = r6.methodMap     // Catch:{ all -> 0x0089 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0089 }
        L_0x0042:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0089 }
            if (r2 == 0) goto L_0x0082
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0089 }
            com.autonavi.base.amap.mapcore.NativeBase$Method r2 = (com.autonavi.base.amap.mapcore.NativeBase.Method) r2     // Catch:{ all -> 0x0089 }
            boolean r3 = r6.destroy     // Catch:{ all -> 0x0042 }
            if (r3 == 0) goto L_0x0053
            goto L_0x0082
        L_0x0053:
            java.lang.Object r3 = r2.object     // Catch:{ all -> 0x0042 }
            if (r3 != 0) goto L_0x005a
            goto L_0x0042
        L_0x005a:
            java.lang.Object r3 = r2.object     // Catch:{ all -> 0x0042 }
            java.lang.Class r3 = r3.getClass()     // Catch:{ all -> 0x0042 }
            if (r3 != 0) goto L_0x0065
            goto L_0x0042
        L_0x0065:
            java.lang.String r4 = r2.methodName     // Catch:{ all -> 0x0042 }
            java.lang.Class[] r5 = r2.clazz     // Catch:{ all -> 0x0042 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ all -> 0x0042 }
            if (r3 == 0) goto L_0x0042
            r3.setAccessible(r1)     // Catch:{ all -> 0x0042 }
            java.lang.Object r4 = r2.object     // Catch:{ all -> 0x0042 }
            java.lang.Object[] r2 = r2.param     // Catch:{ all -> 0x0042 }
            r3.invoke(r4, r2)     // Catch:{ all -> 0x0042 }
            goto L_0x0042
        L_0x0082:
            java.util.ArrayList<com.autonavi.base.amap.mapcore.NativeBase$Method> r0 = r6.methodMap     // Catch:{ all -> 0x0089 }
            r0.clear()     // Catch:{ all -> 0x0089 }
            monitor-exit(r6)
            return
        L_0x0089:
            monitor-exit(r6)
            return
        L_0x008b:
            monitor-exit(r6)
            return
        L_0x008d:
            r0 = move-exception
            monitor-exit(r6)
            goto L_0x0091
        L_0x0090:
            throw r0
        L_0x0091:
            goto L_0x0090
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.amap.mapcore.NativeBase.callAllFunction():void");
    }

    /* access modifiers changed from: protected */
    public abstract void createNative();

    public void destroy() {
        this.destroy = true;
        synchronized (this) {
            this.runnableArrayList.clear();
            this.methodMap.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        try {
            finalizeNative();
        } catch (Throwable th) {
            getClass().getSimpleName();
            th.toString();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void finalizeNative();

    /* access modifiers changed from: protected */
    public abstract long getNative();

    /* access modifiers changed from: protected */
    public boolean isReady() {
        return getNative() != 0;
    }

    public synchronized void storeUncallFunction(Object obj, Object obj2, Object... objArr) {
        try {
            if (!this.useRunnable || obj2 == null) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (stackTrace != null && stackTrace.length >= 3) {
                    this.methodMap.add(new Method(obj, stackTrace[3].getMethodName(), false, objArr));
                }
            } else {
                synchronized (this.runnableArrayList) {
                    this.runnableArrayList.add((Runnable) obj2);
                }
            }
            this.mCalledFuntion = false;
        } catch (Throwable unused) {
        }
    }

    public synchronized void storeUncallFunctionArray(Object obj, Object obj2, Object[] objArr) {
        try {
            if (!this.useRunnable || obj2 == null) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (stackTrace != null && stackTrace.length >= 3) {
                    this.methodMap.add(new Method(obj, stackTrace[3].getMethodName(), false, objArr));
                }
            } else {
                synchronized (this.runnableArrayList) {
                    this.runnableArrayList.add((Runnable) obj2);
                }
            }
            this.mCalledFuntion = false;
        } catch (Throwable unused) {
        }
    }

    public void validate() {
        ParameterIsClass parameterIsClass;
        Class[] parameterTypes;
        java.lang.reflect.Method[] methods = getClass().getMethods();
        if (methods != null) {
            for (java.lang.reflect.Method method : methods) {
                if (method.isAnnotationPresent(ParameterIsClass.class) && (parameterIsClass = (ParameterIsClass) method.getAnnotation(ParameterIsClass.class)) != null && parameterIsClass.required() && (parameterTypes = method.getParameterTypes()) != null) {
                    int length = parameterTypes.length;
                    int i2 = 0;
                    while (i2 < length) {
                        if (parameterTypes[i2] instanceof Object) {
                            i2++;
                        } else {
                            throw new RuntimeException("函数：" + method + " 参数不是对象类型");
                        }
                    }
                    continue;
                }
            }
        }
    }
}
