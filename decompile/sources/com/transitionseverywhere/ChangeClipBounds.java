package com.transitionseverywhere;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import com.transitionseverywhere.utils.m;

public class ChangeClipBounds extends Transition {

    /* renamed from: a  reason: collision with root package name */
    public static final Property<View, Rect> f21798a = (Build.VERSION.SDK_INT >= 14 ? new Property<View, Rect>(Rect.class, "clipBounds") {
        /* renamed from: a */
        public Rect get(View view) {
            return m.a(view);
        }

        /* renamed from: a */
        public void set(View view, Rect rect) {
            m.a(view, rect);
        }
    } : null);

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f21799b = {"android:clipBounds:clip"};

    public ChangeClipBounds() {
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void d(h hVar) {
        View view = hVar.f21926a;
        if (view.getVisibility() != 8) {
            Rect a2 = m.a(view);
            hVar.f21927b.put("android:clipBounds:clip", a2);
            if (a2 == null) {
                hVar.f21927b.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.graphics.Rect} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: android.graphics.Rect} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator a(android.view.ViewGroup r5, com.transitionseverywhere.h r6, com.transitionseverywhere.h r7) {
        /*
            r4 = this;
            r5 = 0
            if (r6 == 0) goto L_0x006d
            if (r7 == 0) goto L_0x006d
            java.util.Map<java.lang.String, java.lang.Object> r0 = r6.f21927b
            java.lang.String r1 = "android:clipBounds:clip"
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x006d
            java.util.Map<java.lang.String, java.lang.Object> r0 = r7.f21927b
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L_0x0018
            goto L_0x006d
        L_0x0018:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r6.f21927b
            java.lang.Object r0 = r0.get(r1)
            android.graphics.Rect r0 = (android.graphics.Rect) r0
            java.util.Map<java.lang.String, java.lang.Object> r2 = r7.f21927b
            java.lang.Object r1 = r2.get(r1)
            android.graphics.Rect r1 = (android.graphics.Rect) r1
            if (r0 != 0) goto L_0x002d
            if (r1 != 0) goto L_0x002d
            return r5
        L_0x002d:
            java.lang.String r2 = "android:clipBounds:bounds"
            if (r0 != 0) goto L_0x003b
            java.util.Map<java.lang.String, java.lang.Object> r6 = r6.f21927b
            java.lang.Object r6 = r6.get(r2)
            r0 = r6
            android.graphics.Rect r0 = (android.graphics.Rect) r0
            goto L_0x0046
        L_0x003b:
            if (r1 != 0) goto L_0x0046
            java.util.Map<java.lang.String, java.lang.Object> r6 = r7.f21927b
            java.lang.Object r6 = r6.get(r2)
            r1 = r6
            android.graphics.Rect r1 = (android.graphics.Rect) r1
        L_0x0046:
            boolean r6 = r0.equals(r1)
            if (r6 == 0) goto L_0x004d
            return r5
        L_0x004d:
            android.view.View r5 = r7.f21926a
            com.transitionseverywhere.utils.m.a((android.view.View) r5, (android.graphics.Rect) r0)
            com.transitionseverywhere.utils.h r5 = new com.transitionseverywhere.utils.h
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>()
            r5.<init>(r6)
            android.view.View r6 = r7.f21926a
            android.util.Property<android.view.View, android.graphics.Rect> r7 = f21798a
            r2 = 2
            android.graphics.Rect[] r2 = new android.graphics.Rect[r2]
            r3 = 0
            r2[r3] = r0
            r0 = 1
            r2[r0] = r1
            android.animation.ObjectAnimator r5 = android.animation.ObjectAnimator.ofObject(r6, r7, r5, r2)
        L_0x006d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transitionseverywhere.ChangeClipBounds.a(android.view.ViewGroup, com.transitionseverywhere.h, com.transitionseverywhere.h):android.animation.Animator");
    }

    public void a(h hVar) {
        d(hVar);
    }

    public String[] a() {
        return f21799b;
    }

    public void b(h hVar) {
        d(hVar);
    }
}
