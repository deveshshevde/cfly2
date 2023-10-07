package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.l;
import java.lang.ref.WeakReference;

public final class d extends e {

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<ImageManager.a> f17731c;

    /* access modifiers changed from: protected */
    public final void a(Drawable drawable, boolean z2, boolean z3, boolean z4) {
        ImageManager.a aVar;
        if (!z3 && (aVar = (ImageManager.a) this.f17731c.get()) != null) {
            aVar.a(this.f17732a.f17730a, drawable, z4);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        ImageManager.a aVar = (ImageManager.a) this.f17731c.get();
        ImageManager.a aVar2 = (ImageManager.a) dVar.f17731c.get();
        return aVar2 != null && aVar != null && l.a(aVar2, aVar) && l.a(dVar.f17732a, this.f17732a);
    }

    public final int hashCode() {
        return l.a(this.f17732a);
    }
}
