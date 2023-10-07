package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.tasks.c;

public abstract class s<A extends a.b, ResultT> {

    /* renamed from: a  reason: collision with root package name */
    private final Feature[] f17632a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17633b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17634c;

    public static class a<A extends a.b, ResultT> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public o<A, c<ResultT>> f17635a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f17636b = true;

        /* renamed from: c  reason: collision with root package name */
        private Feature[] f17637c;

        /* renamed from: d  reason: collision with root package name */
        private int f17638d = 0;

        private a() {
        }

        /* synthetic */ a(cf cfVar) {
        }

        public a<A, ResultT> a(o<A, c<ResultT>> oVar) {
            this.f17635a = oVar;
            return this;
        }

        public a<A, ResultT> a(boolean z2) {
            this.f17636b = z2;
            return this;
        }

        public a<A, ResultT> a(Feature... featureArr) {
            this.f17637c = featureArr;
            return this;
        }

        public s<A, ResultT> a() {
            m.a(this.f17635a != null, (Object) "execute parameter required");
            return new ce(this, this.f17637c, this.f17636b, this.f17638d);
        }
    }

    protected s(Feature[] featureArr, boolean z2, int i2) {
        this.f17632a = featureArr;
        boolean z3 = false;
        if (featureArr != null && z2) {
            z3 = true;
        }
        this.f17633b = z3;
        this.f17634c = i2;
    }

    public static <A extends a.b, ResultT> a<A, ResultT> a() {
        return new a<>((cf) null);
    }

    /* access modifiers changed from: protected */
    public abstract void a(A a2, c<ResultT> cVar) throws RemoteException;

    public boolean b() {
        return this.f17633b;
    }

    public final int c() {
        return this.f17634c;
    }

    public final Feature[] d() {
        return this.f17632a;
    }
}
