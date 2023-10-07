package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.av;
import com.google.android.gms.common.api.internal.cj;
import com.google.android.gms.common.api.internal.cr;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.internal.da;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.api.internal.h;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.internal.v;
import gk.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
public abstract class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Set<d> f11779a = Collections.newSetFromMap(new WeakHashMap());

    @Deprecated
    public interface b extends e {
    }

    @Deprecated
    public interface c extends m {
    }

    @Deprecated
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Account f17396a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<Scope> f17397b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private final Set<Scope> f17398c = new HashSet();

        /* renamed from: d  reason: collision with root package name */
        private int f17399d;

        /* renamed from: e  reason: collision with root package name */
        private View f17400e;

        /* renamed from: f  reason: collision with root package name */
        private String f17401f;

        /* renamed from: g  reason: collision with root package name */
        private String f17402g;

        /* renamed from: h  reason: collision with root package name */
        private final Map<a<?>, v> f17403h = new j.a();

        /* renamed from: i  reason: collision with root package name */
        private final Context f17404i;

        /* renamed from: j  reason: collision with root package name */
        private final Map<a<?>, a.d> f17405j = new j.a();

        /* renamed from: k  reason: collision with root package name */
        private h f17406k;

        /* renamed from: l  reason: collision with root package name */
        private int f17407l = -1;

        /* renamed from: m  reason: collision with root package name */
        private c f17408m;

        /* renamed from: n  reason: collision with root package name */
        private Looper f17409n;

        /* renamed from: o  reason: collision with root package name */
        private com.google.android.gms.common.c f17410o = com.google.android.gms.common.c.a();

        /* renamed from: p  reason: collision with root package name */
        private a.C0118a<? extends f, gk.a> f17411p = gk.e.f28529c;

        /* renamed from: q  reason: collision with root package name */
        private final ArrayList<b> f17412q = new ArrayList<>();

        /* renamed from: r  reason: collision with root package name */
        private final ArrayList<c> f17413r = new ArrayList<>();

        public a(Context context) {
            this.f17404i = context;
            this.f17409n = context.getMainLooper();
            this.f17401f = context.getPackageName();
            this.f17402g = context.getClass().getName();
        }

        public a a(a<? extends a.d.e> aVar) {
            com.google.android.gms.common.internal.m.a(aVar, (Object) "Api must not be null");
            this.f17405j.put(aVar, (Object) null);
            List<Scope> a2 = ((a.e) com.google.android.gms.common.internal.m.a(aVar.c(), (Object) "Base client builder must not be null")).a(null);
            this.f17398c.addAll(a2);
            this.f17397b.addAll(a2);
            return this;
        }

        public a a(b bVar) {
            com.google.android.gms.common.internal.m.a(bVar, (Object) "Listener must not be null");
            this.f17412q.add(bVar);
            return this;
        }

        public a a(c cVar) {
            com.google.android.gms.common.internal.m.a(cVar, (Object) "Listener must not be null");
            this.f17413r.add(cVar);
            return this;
        }

        public d a() {
            com.google.android.gms.common.internal.m.a(!this.f17405j.isEmpty(), (Object) "must call addApi() to add at least one API");
            com.google.android.gms.common.internal.e b2 = b();
            Map<a<?>, v> i2 = b2.i();
            j.a aVar = new j.a();
            j.a aVar2 = new j.a();
            ArrayList arrayList = new ArrayList();
            a aVar3 = null;
            boolean z2 = false;
            for (a next : this.f17405j.keySet()) {
                a.d dVar = this.f17405j.get(next);
                boolean z3 = i2.get(next) != null;
                aVar.put(next, Boolean.valueOf(z3));
                da daVar = new da(next, z3);
                arrayList.add(daVar);
                a.C0118a aVar4 = (a.C0118a) com.google.android.gms.common.internal.m.a(next.a());
                a aVar5 = next;
                a.f a2 = aVar4.a(this.f17404i, this.f17409n, b2, dVar, (b) daVar, (c) daVar);
                aVar2.put(aVar5.b(), a2);
                if (aVar4.a() == 1) {
                    z2 = dVar != null;
                }
                if (a2.providesSignIn()) {
                    if (aVar3 == null) {
                        aVar3 = aVar5;
                    } else {
                        String d2 = aVar5.d();
                        String d3 = aVar3.d();
                        StringBuilder sb = new StringBuilder(String.valueOf(d2).length() + 21 + String.valueOf(d3).length());
                        sb.append(d2);
                        sb.append(" cannot be used with ");
                        sb.append(d3);
                        throw new IllegalStateException(sb.toString());
                    }
                }
            }
            if (aVar3 != null) {
                if (!z2) {
                    com.google.android.gms.common.internal.m.b(this.f17396a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", aVar3.d());
                    com.google.android.gms.common.internal.m.b(this.f17397b.equals(this.f17398c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", aVar3.d());
                } else {
                    String d4 = aVar3.d();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(d4).length() + 82);
                    sb2.append("With using ");
                    sb2.append(d4);
                    sb2.append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                    throw new IllegalStateException(sb2.toString());
                }
            }
            av avVar = new av(this.f17404i, new ReentrantLock(), this.f17409n, b2, this.f17410o, this.f17411p, aVar, this.f17412q, this.f17413r, aVar2, this.f17407l, av.a((Iterable<a.f>) aVar2.values(), true), arrayList);
            synchronized (d.f11779a) {
                d.f11779a.add(avVar);
            }
            if (this.f17407l >= 0) {
                cr.b(this.f17406k).a(this.f17407l, avVar, this.f17408m);
            }
            return avVar;
        }

        public final com.google.android.gms.common.internal.e b() {
            gk.a aVar = gk.a.f28517a;
            if (this.f17405j.containsKey(gk.e.f28533g)) {
                aVar = (gk.a) this.f17405j.get(gk.e.f28533g);
            }
            return new com.google.android.gms.common.internal.e(this.f17396a, this.f17397b, this.f17403h, this.f17399d, this.f17400e, this.f17401f, this.f17402g, aVar, false);
        }
    }

    public Looper a() {
        throw new UnsupportedOperationException();
    }

    public <C extends a.f> C a(a.c<C> cVar) {
        throw new UnsupportedOperationException();
    }

    public <A extends a.b, R extends g, T extends d.a<R, A>> T a(T t2) {
        throw new UnsupportedOperationException();
    }

    public abstract void a(c cVar);

    public void a(cj cjVar) {
        throw new UnsupportedOperationException();
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public <A extends a.b, T extends d.a<? extends g, A>> T b(T t2) {
        throw new UnsupportedOperationException();
    }

    public abstract void b();

    public abstract void b(c cVar);

    public void b(cj cjVar) {
        throw new UnsupportedOperationException();
    }

    public abstract void c();

    public abstract boolean d();

    public abstract boolean e();
}
