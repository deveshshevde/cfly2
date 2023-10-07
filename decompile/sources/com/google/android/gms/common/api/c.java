package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.common.api.internal.bh;
import com.google.android.gms.common.api.internal.bm;
import com.google.android.gms.common.api.internal.cd;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.common.api.internal.s;
import com.google.android.gms.common.api.internal.y;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.util.l;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public abstract class c<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    protected final f f11769a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f11770b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11771c;

    /* renamed from: d  reason: collision with root package name */
    private final a<O> f11772d;

    /* renamed from: e  reason: collision with root package name */
    private final O f11773e;

    /* renamed from: f  reason: collision with root package name */
    private final b<O> f11774f;

    /* renamed from: g  reason: collision with root package name */
    private final Looper f11775g;

    /* renamed from: h  reason: collision with root package name */
    private final int f11776h;
    @NotOnlyInitialized

    /* renamed from: i  reason: collision with root package name */
    private final d f11777i;

    /* renamed from: j  reason: collision with root package name */
    private final r f11778j;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f17391a = new C0121a().a();

        /* renamed from: b  reason: collision with root package name */
        public final r f17392b;

        /* renamed from: c  reason: collision with root package name */
        public final Looper f17393c;

        /* renamed from: com.google.android.gms.common.api.c$a$a  reason: collision with other inner class name */
        public static class C0121a {

            /* renamed from: a  reason: collision with root package name */
            private r f17394a;

            /* renamed from: b  reason: collision with root package name */
            private Looper f17395b;

            public a a() {
                if (this.f17394a == null) {
                    this.f17394a = new com.google.android.gms.common.api.internal.a();
                }
                if (this.f17395b == null) {
                    this.f17395b = Looper.getMainLooper();
                }
                return new a(this.f17394a, this.f17395b);
            }
        }

        private a(r rVar, Account account, Looper looper) {
            this.f17392b = rVar;
            this.f17393c = looper;
        }
    }

    private c(Context context, Activity activity, a<O> aVar, O o2, a aVar2) {
        m.a(context, (Object) "Null context is not permitted.");
        m.a(aVar, (Object) "Api must not be null.");
        m.a(aVar2, (Object) "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f11770b = context.getApplicationContext();
        String str = null;
        if (l.i()) {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(context, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        this.f11771c = str;
        this.f11772d = aVar;
        this.f11773e = o2;
        this.f11775g = aVar2.f17393c;
        b<O> a2 = b.a(aVar, o2, str);
        this.f11774f = a2;
        this.f11777i = new bm(this);
        f a3 = f.a(this.f11770b);
        this.f11769a = a3;
        this.f11776h = a3.a();
        this.f11778j = aVar2.f17392b;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            y.a(activity, a3, a2);
        }
        a3.a((c<?>) this);
    }

    public c(Context context, a<O> aVar, O o2, a aVar2) {
        this(context, (Activity) null, aVar, o2, aVar2);
    }

    private final <A extends a.b, T extends d.a<? extends g, A>> T a(int i2, T t2) {
        t2.zak();
        this.f11769a.a(this, i2, (d.a<? extends g, a.b>) t2);
        return t2;
    }

    private final <TResult, A extends a.b> com.google.android.gms.tasks.b<TResult> a(int i2, s<A, TResult> sVar) {
        com.google.android.gms.tasks.c cVar = new com.google.android.gms.tasks.c();
        this.f11769a.a(this, i2, sVar, cVar, this.f11778j);
        return cVar.a();
    }

    public Looper a() {
        return this.f11775g;
    }

    public final a.f a(Looper looper, bh<O> bhVar) {
        Looper looper2 = looper;
        a.f a2 = ((a.C0118a) m.a(this.f11772d.a())).a(this.f11770b, looper2, c().a(), this.f11773e, (d.b) bhVar, (d.c) bhVar);
        String d2 = d();
        if (d2 != null && (a2 instanceof com.google.android.gms.common.internal.d)) {
            ((com.google.android.gms.common.internal.d) a2).setAttributionTag(d2);
        }
        if (d2 != null && (a2 instanceof com.google.android.gms.common.api.internal.l)) {
            ((com.google.android.gms.common.api.internal.l) a2).a(d2);
        }
        return a2;
    }

    public final cd a(Context context, Handler handler) {
        return new cd(context, handler, c().a());
    }

    public <A extends a.b, T extends d.a<? extends g, A>> T a(T t2) {
        a(0, t2);
        return t2;
    }

    public <TResult, A extends a.b> com.google.android.gms.tasks.b<TResult> a(s<A, TResult> sVar) {
        return a(2, sVar);
    }

    public final b<O> b() {
        return this.f11774f;
    }

    public <A extends a.b, T extends d.a<? extends g, A>> T b(T t2) {
        a(1, t2);
        return t2;
    }

    /* access modifiers changed from: protected */
    public e.a c() {
        Account account;
        GoogleSignInAccount a2;
        GoogleSignInAccount a3;
        e.a aVar = new e.a();
        O o2 = this.f11773e;
        if (!(o2 instanceof a.d.b) || (a3 = ((a.d.b) o2).a()) == null) {
            O o3 = this.f11773e;
            account = o3 instanceof a.d.C0119a ? ((a.d.C0119a) o3).a() : null;
        } else {
            account = a3.a();
        }
        aVar.a(account);
        O o4 = this.f11773e;
        aVar.a((Collection<Scope>) (!(o4 instanceof a.d.b) || (a2 = ((a.d.b) o4).a()) == null) ? Collections.emptySet() : a2.j());
        aVar.b(this.f11770b.getClass().getName());
        aVar.a(this.f11770b.getPackageName());
        return aVar;
    }

    /* access modifiers changed from: protected */
    public String d() {
        return this.f11771c;
    }

    public final int e() {
        return this.f11776h;
    }
}
