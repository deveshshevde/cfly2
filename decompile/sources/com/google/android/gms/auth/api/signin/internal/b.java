package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.m;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Lock f17349a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    private static b f17350b;

    /* renamed from: c  reason: collision with root package name */
    private final Lock f17351c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    private final SharedPreferences f17352d;

    b(Context context) {
        this.f17352d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static b a(Context context) {
        m.a(context);
        Lock lock = f17349a;
        lock.lock();
        try {
            if (f17350b == null) {
                f17350b = new b(context.getApplicationContext());
            }
            b bVar = f17350b;
            lock.unlock();
            return bVar;
        } catch (Throwable th) {
            f17349a.unlock();
            throw th;
        }
    }

    private static final String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    public GoogleSignInAccount a() {
        String a2;
        String a3 = a("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(a3) || (a2 = a(a("googleSignInAccount", a3))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.a(a2);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final String a(String str) {
        this.f17351c.lock();
        try {
            return this.f17352d.getString(str, (String) null);
        } finally {
            this.f17351c.unlock();
        }
    }
}
