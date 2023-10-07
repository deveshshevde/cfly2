package io.realm.internal.android;

import android.os.Looper;

public class a implements io.realm.internal.a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f29019a = false;

    /* renamed from: b  reason: collision with root package name */
    private final Looper f29020b = Looper.myLooper();

    /* renamed from: c  reason: collision with root package name */
    private final boolean f29021c = c();

    private boolean b() {
        return this.f29020b != null;
    }

    private static boolean c() {
        String name = Thread.currentThread().getName();
        return name != null && name.startsWith("IntentService[");
    }

    public void a(String str) {
        String str2 = "";
        if (!b()) {
            if (str != null) {
                str2 = str + " " + "Realm cannot be automatically updated on a thread without a looper.";
            }
            throw new IllegalStateException(str2);
        } else if (this.f29021c) {
            if (str != null) {
                str2 = str + " " + "Realm cannot be automatically updated on an IntentService thread.";
            }
            throw new IllegalStateException(str2);
        }
    }

    public boolean a() {
        return b() && !this.f29021c;
    }
}
