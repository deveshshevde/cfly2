package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import gj.ae;
import gj.af;
import gj.c;
import gj.j;
import gj.q;
import java.util.ArrayList;
import java.util.List;

public class i extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final b f11842a = new b(this);

    static class a implements j {

        /* renamed from: a  reason: collision with root package name */
        private final Fragment f18173a;

        /* renamed from: b  reason: collision with root package name */
        private final c f18174b;

        public a(Fragment fragment, c cVar) {
            this.f18174b = (c) m.a(cVar);
            this.f18173a = (Fragment) m.a(fragment);
        }

        public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                ae.a(bundle, bundle2);
                com.google.android.gms.dynamic.b a2 = this.f18174b.a(d.a(layoutInflater), d.a(viewGroup), bundle2);
                ae.a(bundle2, bundle);
                return (View) d.a(a2);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void a() {
            try {
                this.f18174b.d();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void a(Activity activity, Bundle bundle, Bundle bundle2) {
            GoogleMapOptions googleMapOptions = (GoogleMapOptions) bundle.getParcelable("MapOptions");
            try {
                Bundle bundle3 = new Bundle();
                ae.a(bundle2, bundle3);
                this.f18174b.a(d.a(activity), googleMapOptions, bundle3);
                ae.a(bundle3, bundle2);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void a(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                ae.a(bundle, bundle2);
                Bundle arguments = this.f18173a.getArguments();
                if (arguments != null && arguments.containsKey("MapOptions")) {
                    ae.a(bundle2, "MapOptions", arguments.getParcelable("MapOptions"));
                }
                this.f18174b.a(bundle2);
                ae.a(bundle2, bundle);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void a(e eVar) {
            try {
                this.f18174b.a((q) new p(this, eVar));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void b() {
            try {
                this.f18174b.c();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void b(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                ae.a(bundle, bundle2);
                this.f18174b.b(bundle2);
                ae.a(bundle2, bundle);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void c() {
            try {
                this.f18174b.e();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void d() {
            try {
                this.f18174b.b();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void e() {
            try {
                this.f18174b.a();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void f() {
            try {
                this.f18174b.f();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void g() {
            try {
                this.f18174b.g();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    static class b extends com.google.android.gms.dynamic.a<a> {

        /* renamed from: a  reason: collision with root package name */
        private final Fragment f18175a;

        /* renamed from: b  reason: collision with root package name */
        private e<a> f18176b;

        /* renamed from: c  reason: collision with root package name */
        private Activity f18177c;

        /* renamed from: d  reason: collision with root package name */
        private final List<e> f18178d = new ArrayList();

        b(Fragment fragment) {
            this.f18175a = fragment;
        }

        /* access modifiers changed from: private */
        public final void a(Activity activity) {
            this.f18177c = activity;
            i();
        }

        private final void i() {
            if (this.f18177c != null && this.f18176b != null && a() == null) {
                try {
                    d.a(this.f18177c);
                    c a2 = af.a((Context) this.f18177c).a(d.a(this.f18177c));
                    if (a2 != null) {
                        this.f18176b.a(new a(this.f18175a, a2));
                        for (e a3 : this.f18178d) {
                            ((a) a()).a(a3);
                        }
                        this.f18178d.clear();
                    }
                } catch (RemoteException e2) {
                    throw new RuntimeRemoteException(e2);
                } catch (GooglePlayServicesNotAvailableException unused) {
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void a(e<a> eVar) {
            this.f18176b = eVar;
            i();
        }

        public final void a(e eVar) {
            if (a() != null) {
                ((a) a()).a(eVar);
            } else {
                this.f18178d.add(eVar);
            }
        }
    }

    public void a(e eVar) {
        m.b("getMapAsync must be called on the main thread.");
        this.f11842a.a(eVar);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(i.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11842a.a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11842a.a(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a2 = this.f11842a.a(layoutInflater, viewGroup, bundle);
        a2.setClickable(true);
        return a2;
    }

    public void onDestroy() {
        this.f11842a.b();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f11842a.c();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            this.f11842a.a(activity);
            GoogleMapOptions a2 = GoogleMapOptions.a(activity, attributeSet);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("MapOptions", a2);
            this.f11842a.a(activity, bundle2, bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void onLowMemory() {
        this.f11842a.d();
        super.onLowMemory();
    }

    public void onPause() {
        this.f11842a.e();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f11842a.f();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(i.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f11842a.b(bundle);
    }

    public void onStart() {
        super.onStart();
        this.f11842a.g();
    }

    public void onStop() {
        this.f11842a.h();
        super.onStop();
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
