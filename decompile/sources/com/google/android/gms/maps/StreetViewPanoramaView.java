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
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import gj.ae;
import gj.af;
import gj.h;
import gj.k;
import gj.x;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final b f18157a;

    static class a implements k {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f18158a;

        /* renamed from: b  reason: collision with root package name */
        private final h f18159b;

        /* renamed from: c  reason: collision with root package name */
        private View f18160c;

        public a(ViewGroup viewGroup, h hVar) {
            this.f18159b = (h) m.a(hVar);
            this.f18158a = (ViewGroup) m.a(viewGroup);
        }

        public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        public final void a() {
            try {
                this.f18159b.c();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void a(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        public final void a(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                ae.a(bundle, bundle2);
                this.f18159b.a(bundle2);
                ae.a(bundle2, bundle);
                this.f18160c = (View) d.a(this.f18159b.e());
                this.f18158a.removeAllViews();
                this.f18158a.addView(this.f18160c);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void a(f fVar) {
            try {
                this.f18159b.a((x) new o(this, fVar));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void b() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        public final void b(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                ae.a(bundle, bundle2);
                this.f18159b.b(bundle2);
                ae.a(bundle2, bundle);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void c() {
            try {
                this.f18159b.d();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void d() {
            try {
                this.f18159b.b();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void e() {
            try {
                this.f18159b.a();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void f() {
            try {
                this.f18159b.f();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void g() {
            try {
                this.f18159b.g();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    static class b extends com.google.android.gms.dynamic.a<a> {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f18161a;

        /* renamed from: b  reason: collision with root package name */
        private final Context f18162b;

        /* renamed from: c  reason: collision with root package name */
        private e<a> f18163c;

        /* renamed from: d  reason: collision with root package name */
        private final StreetViewPanoramaOptions f18164d;

        /* renamed from: e  reason: collision with root package name */
        private final List<f> f18165e = new ArrayList();

        b(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.f18161a = viewGroup;
            this.f18162b = context;
            this.f18164d = streetViewPanoramaOptions;
        }

        /* access modifiers changed from: protected */
        public final void a(e<a> eVar) {
            this.f18163c = eVar;
            if (eVar != null && a() == null) {
                try {
                    d.a(this.f18162b);
                    this.f18163c.a(new a(this.f18161a, af.a(this.f18162b).a(d.a(this.f18162b), this.f18164d)));
                    for (f a2 : this.f18165e) {
                        ((a) a()).a(a2);
                    }
                    this.f18165e.clear();
                } catch (RemoteException e2) {
                    throw new RuntimeRemoteException(e2);
                } catch (GooglePlayServicesNotAvailableException unused) {
                }
            }
        }
    }

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.f18157a = new b(this, context, (StreetViewPanoramaOptions) null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18157a = new b(this, context, (StreetViewPanoramaOptions) null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18157a = new b(this, context, (StreetViewPanoramaOptions) null);
    }
}
