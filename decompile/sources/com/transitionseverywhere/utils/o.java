package com.transitionseverywhere.utils;

import android.graphics.PointF;
import android.transition.ChangeBounds;
import android.util.Property;
import android.view.View;

class o extends n {

    /* renamed from: a  reason: collision with root package name */
    private static final Property<View, PointF> f21988a = a("POSITION_PROPERTY");

    /* renamed from: b  reason: collision with root package name */
    private static final Property<View, PointF> f21989b = a("BOTTOM_RIGHT_ONLY_PROPERTY");

    /* renamed from: c  reason: collision with root package name */
    private static final PointF f21990c = new PointF();

    o() {
    }

    private static Property<View, PointF> a(String str) {
        Object a2 = i.a((Object) null, (Object) null, i.a(ChangeBounds.class, str));
        if (!(a2 instanceof Property)) {
            return null;
        }
        Property<View, PointF> property = (Property) a2;
        try {
            property.set((Object) null, new PointF());
        } catch (NullPointerException unused) {
        } catch (Exception unused2) {
            return null;
        }
        return property;
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        Property<View, PointF> property;
        Property<View, PointF> property2 = f21988a;
        if (property2 == null || (property = f21989b) == null) {
            super.a(view, i2, i3, i4, i5);
            return;
        }
        PointF pointF = f21990c;
        pointF.set((float) i2, (float) i3);
        property2.set(view, pointF);
        pointF.set((float) i4, (float) i5);
        property.set(view, pointF);
    }
}
