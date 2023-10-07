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
import gj.g;
import gj.k;
import gj.x;
import java.util.ArrayList;
import java.util.List;

public class j extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final b f18179a = new b(this);

    static class a implements k {

        /* renamed from: a  reason: collision with root package name */
        private final Fragment f18180a;

        /* renamed from: b  reason: collision with root package name */
        private final g f18181b;

        public a(Fragment fragment, g gVar) {
            this.f18181b = (g) m.a(gVar);
            this.f18180a = (Fragment) m.a(fragment);
        }

        public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                ae.a(bundle, bundle2);
                com.google.android.gms.dynamic.b a2 = this.f18181b.a(d.a(layoutInflater), d.a(viewGroup), bundle2);
                ae.a(bundle2, bundle);
                return (View) d.a(a2);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void a() {
            try {
                this.f18181b.d();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void a(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                Bundle bundle3 = new Bundle();
                ae.a(bundle2, bundle3);
                this.f18181b.a(d.a(activity), (StreetViewPanoramaOptions) null, bundle3);
                ae.a(bundle3, bundle2);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void a(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                ae.a(bundle, bundle2);
                Bundle arguments = this.f18180a.getArguments();
                if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                    ae.a(bundle2, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
                }
                this.f18181b.a(bundle2);
                ae.a(bundle2, bundle);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void a(f fVar) {
            try {
                this.f18181b.a((x) new q(this, fVar));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void b() {
            try {
                this.f18181b.c();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void b(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                ae.a(bundle, bundle2);
                this.f18181b.b(bundle2);
                ae.a(bundle2, bundle);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void c() {
            try {
                this.f18181b.e();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void d() {
            try {
                this.f18181b.b();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void e() {
            try {
                this.f18181b.a();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void f() {
            try {
                this.f18181b.f();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void g() {
            try {
                this.f18181b.g();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    static class b extends com.google.android.gms.dynamic.a<a> {

        /* renamed from: a  reason: collision with root package name */
        private final Fragment f18182a;

        /* renamed from: b  reason: collision with root package name */
        private e<a> f18183b;

        /* renamed from: c  reason: collision with root package name */
        private Activity f18184c;

        /* renamed from: d  reason: collision with root package name */
        private final List<f> f18185d = new ArrayList();

        b(Fragment fragment) {
            this.f18182a = fragment;
        }

        /* access modifiers changed from: private */
        public final void a(Activity activity) {
            this.f18184c = activity;
            i();
        }

        private final void i() {
            if (this.f18184c != null && this.f18183b != null && a() == null) {
                try {
                    d.a(this.f18184c);
                    this.f18183b.a(new a(this.f18182a, af.a((Context) this.f18184c).b(d.a(this.f18184c))));
                    for (f a2 : this.f18185d) {
                        ((a) a()).a(a2);
                    }
                    this.f18185d.clear();
                } catch (RemoteException e2) {
                    throw new RuntimeRemoteException(e2);
                } catch (GooglePlayServicesNotAvailableException unused) {
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void a(e<a> eVar) {
            this.f18183b = eVar;
            i();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(j.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f18179a.a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f18179a.a(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f18179a.a(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        this.f18179a.b();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f18179a.c();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            this.f18179a.a(activity);
            this.f18179a.a(activity, new Bundle(), bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void onLowMemory() {
        this.f18179a.d();
        super.onLowMemory();
    }

    public void onPause() {
        this.f18179a.e();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f18179a.f();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(j.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f18179a.b(bundle);
    }

    public void onStart() {
        super.onStart();
        this.f18179a.g();
    }

    public void onStop() {
        this.f18179a.h();
        super.onStop();
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
