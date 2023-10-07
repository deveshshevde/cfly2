package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import gj.ae;
import gj.af;
import gj.d;
import gj.j;
import gj.q;
import java.util.ArrayList;
import java.util.List;

public class MapView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final b f18138a;

    static class a implements j {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f18139a;

        /* renamed from: b  reason: collision with root package name */
        private final d f18140b;

        /* renamed from: c  reason: collision with root package name */
        private View f18141c;

        public a(ViewGroup viewGroup, d dVar) {
            this.f18140b = (d) m.a(dVar);
            this.f18139a = (ViewGroup) m.a(viewGroup);
        }

        public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public final void a() {
            try {
                this.f18140b.c();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void a(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public final void a(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                ae.a(bundle, bundle2);
                this.f18140b.a(bundle2);
                ae.a(bundle2, bundle);
                this.f18141c = (View) com.google.android.gms.dynamic.d.a(this.f18140b.e());
                this.f18139a.removeAllViews();
                this.f18139a.addView(this.f18141c);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void a(e eVar) {
            try {
                this.f18140b.a((q) new m(this, eVar));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void b() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public final void b(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                ae.a(bundle, bundle2);
                this.f18140b.b(bundle2);
                ae.a(bundle2, bundle);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void c() {
            try {
                this.f18140b.d();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void d() {
            try {
                this.f18140b.b();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void e() {
            try {
                this.f18140b.a();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void f() {
            try {
                this.f18140b.f();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void g() {
            try {
                this.f18140b.g();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    static class b extends com.google.android.gms.dynamic.a<a> {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f18142a;

        /* renamed from: b  reason: collision with root package name */
        private final Context f18143b;

        /* renamed from: c  reason: collision with root package name */
        private e<a> f18144c;

        /* renamed from: d  reason: collision with root package name */
        private final GoogleMapOptions f18145d;

        /* renamed from: e  reason: collision with root package name */
        private final List<e> f18146e = new ArrayList();

        b(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.f18142a = viewGroup;
            this.f18143b = context;
            this.f18145d = googleMapOptions;
        }

        /* access modifiers changed from: protected */
        public final void a(e<a> eVar) {
            this.f18144c = eVar;
            if (eVar != null && a() == null) {
                try {
                    d.a(this.f18143b);
                    d a2 = af.a(this.f18143b).a(com.google.android.gms.dynamic.d.a(this.f18143b), this.f18145d);
                    if (a2 != null) {
                        this.f18144c.a(new a(this.f18142a, a2));
                        for (e a3 : this.f18146e) {
                            ((a) a()).a(a3);
                        }
                        this.f18146e.clear();
                    }
                } catch (RemoteException e2) {
                    throw new RuntimeRemoteException(e2);
                } catch (GooglePlayServicesNotAvailableException unused) {
                }
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.f18138a = new b(this, context, (GoogleMapOptions) null);
        setClickable(true);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18138a = new b(this, context, GoogleMapOptions.a(context, attributeSet));
        setClickable(true);
    }

    public MapView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18138a = new b(this, context, GoogleMapOptions.a(context, attributeSet));
        setClickable(true);
    }
}
