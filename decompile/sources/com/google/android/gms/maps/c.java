package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.internal.maps.zzac;
import com.google.android.gms.internal.maps.zzt;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.e;
import com.google.android.gms.maps.model.f;
import com.google.android.gms.maps.model.g;
import gj.o;
import gj.s;
import gj.u;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final gj.b f18168a;

    /* renamed from: b  reason: collision with root package name */
    private k f18169b;

    public interface a {
        void a(LatLng latLng);
    }

    public interface b {
        void a(LatLng latLng);
    }

    /* renamed from: com.google.android.gms.maps.c$c  reason: collision with other inner class name */
    public interface C0125c {
        boolean a(com.google.android.gms.maps.model.d dVar);
    }

    public interface d {
        void a(com.google.android.gms.maps.model.d dVar);

        void b(com.google.android.gms.maps.model.d dVar);

        void c(com.google.android.gms.maps.model.d dVar);
    }

    public c(gj.b bVar) {
        this.f18168a = (gj.b) m.a(bVar);
    }

    public final CameraPosition a() {
        try {
            return this.f18168a.a();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final com.google.android.gms.maps.model.c a(CircleOptions circleOptions) {
        try {
            return new com.google.android.gms.maps.model.c(this.f18168a.a(circleOptions));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final com.google.android.gms.maps.model.d a(MarkerOptions markerOptions) {
        try {
            zzt a2 = this.f18168a.a(markerOptions);
            if (a2 != null) {
                return new com.google.android.gms.maps.model.d(a2);
            }
            return null;
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final e a(PolygonOptions polygonOptions) {
        try {
            return new e(this.f18168a.a(polygonOptions));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final f a(PolylineOptions polylineOptions) {
        try {
            return new f(this.f18168a.a(polylineOptions));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final g a(TileOverlayOptions tileOverlayOptions) {
        try {
            zzac a2 = this.f18168a.a(tileOverlayOptions);
            if (a2 != null) {
                return new g(a2);
            }
            return null;
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void a(int i2) {
        try {
            this.f18168a.a(i2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        try {
            this.f18168a.a(i2, i3, i4, i5);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void a(a aVar) {
        try {
            this.f18168a.a(aVar.a());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void a(a aVar) {
        if (aVar == null) {
            try {
                this.f18168a.a((gj.m) null);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        } else {
            this.f18168a.a((gj.m) new u(this, aVar));
        }
    }

    public final void a(b bVar) {
        if (bVar == null) {
            try {
                this.f18168a.a((o) null);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        } else {
            this.f18168a.a((o) new v(this, bVar));
        }
    }

    public final void a(C0125c cVar) {
        if (cVar == null) {
            try {
                this.f18168a.a((s) null);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        } else {
            this.f18168a.a((s) new s(this, cVar));
        }
    }

    public final void a(d dVar) {
        if (dVar == null) {
            try {
                this.f18168a.a((u) null);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        } else {
            this.f18168a.a((u) new t(this, dVar));
        }
    }

    public final void a(boolean z2) {
        try {
            this.f18168a.a(z2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final k b() {
        try {
            if (this.f18169b == null) {
                this.f18169b = new k(this.f18168a.b());
            }
            return this.f18169b;
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void b(a aVar) {
        try {
            this.f18168a.b(aVar.a());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final g c() {
        try {
            return new g(this.f18168a.c());
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
