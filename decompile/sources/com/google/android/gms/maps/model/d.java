package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.maps.zzt;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final zzt f18314a;

    public d(zzt zzt) {
        this.f18314a = (zzt) m.a(zzt);
    }

    public final void a() {
        try {
            this.f18314a.remove();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void a(float f2) {
        try {
            this.f18314a.setRotation(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void a(float f2, float f3) {
        try {
            this.f18314a.setAnchor(f2, f3);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void a(LatLng latLng) {
        if (latLng != null) {
            try {
                this.f18314a.setPosition(latLng);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        } else {
            throw new IllegalArgumentException("latlng cannot be null - a position is required.");
        }
    }

    public final void a(a aVar) {
        if (aVar == null) {
            try {
                this.f18314a.zzg((b) null);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        } else {
            this.f18314a.zzg(aVar.a());
        }
    }

    public final void a(String str) {
        try {
            this.f18314a.setTitle(str);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void a(boolean z2) {
        try {
            this.f18314a.setDraggable(z2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final LatLng b() {
        try {
            return this.f18314a.getPosition();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void b(float f2) {
        try {
            this.f18314a.setAlpha(f2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void b(float f2, float f3) {
        try {
            this.f18314a.setInfoWindowAnchor(f2, f3);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void b(String str) {
        try {
            this.f18314a.setSnippet(str);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void b(boolean z2) {
        try {
            this.f18314a.setVisible(z2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void c() {
        try {
            this.f18314a.showInfoWindow();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void c(boolean z2) {
        try {
            this.f18314a.setFlat(z2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void d() {
        try {
            this.f18314a.hideInfoWindow();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        try {
            return this.f18314a.zzj(((d) obj).f18314a);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final int hashCode() {
        try {
            return this.f18314a.zzj();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
