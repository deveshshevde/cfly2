package androidx.work;

import android.content.Context;

public abstract class s {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5461a = j.a("WorkerFactory");

    public static s a() {
        return new s() {
            public ListenableWorker a(Context context, String str, WorkerParameters workerParameters) {
                return null;
            }
        };
    }

    public abstract ListenableWorker a(Context context, String str, WorkerParameters workerParameters);

    public final ListenableWorker b(Context context, String str, WorkerParameters workerParameters) {
        ListenableWorker a2 = a(context, str, workerParameters);
        if (a2 == null) {
            Class<? extends U> cls = null;
            try {
                cls = Class.forName(str).asSubclass(ListenableWorker.class);
            } catch (Throwable th) {
                j a3 = j.a();
                String str2 = f5461a;
                a3.e(str2, "Invalid class: " + str, th);
            }
            if (cls != null) {
                try {
                    a2 = (ListenableWorker) cls.getDeclaredConstructor(new Class[]{Context.class, WorkerParameters.class}).newInstance(new Object[]{context, workerParameters});
                } catch (Throwable th2) {
                    j a4 = j.a();
                    String str3 = f5461a;
                    a4.e(str3, "Could not instantiate " + str, th2);
                }
            }
        }
        if (a2 == null || !a2.i()) {
            return a2;
        }
        throw new IllegalStateException(String.format("WorkerFactory (%s) returned an instance of a ListenableWorker (%s) which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.", new Object[]{getClass().getName(), str}));
    }
}
