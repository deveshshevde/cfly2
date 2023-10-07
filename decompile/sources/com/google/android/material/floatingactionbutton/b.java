package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import gl.a;
import gl.h;
import java.util.ArrayList;
import java.util.List;
import s.f;

abstract class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19089a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ExtendedFloatingActionButton f19090b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<Animator.AnimatorListener> f19091c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final a f19092d;

    /* renamed from: e  reason: collision with root package name */
    private h f19093e;

    /* renamed from: f  reason: collision with root package name */
    private h f19094f;

    b(ExtendedFloatingActionButton extendedFloatingActionButton, a aVar) {
        this.f19090b = extendedFloatingActionButton;
        this.f19089a = extendedFloatingActionButton.getContext();
        this.f19092d = aVar;
    }

    public final h a() {
        h hVar = this.f19094f;
        if (hVar != null) {
            return hVar;
        }
        if (this.f19093e == null) {
            this.f19093e = h.a(this.f19089a, h());
        }
        return (h) f.a(this.f19093e);
    }

    public void a(Animator animator) {
        this.f19092d.a(animator);
    }

    public final void a(h hVar) {
        this.f19094f = hVar;
    }

    /* access modifiers changed from: package-private */
    public AnimatorSet b(h hVar) {
        ArrayList arrayList = new ArrayList();
        if (hVar.c("opacity")) {
            arrayList.add(hVar.a("opacity", this.f19090b, View.ALPHA));
        }
        if (hVar.c("scale")) {
            arrayList.add(hVar.a("scale", this.f19090b, View.SCALE_Y));
            arrayList.add(hVar.a("scale", this.f19090b, View.SCALE_X));
        }
        if (hVar.c("width")) {
            arrayList.add(hVar.a("width", this.f19090b, ExtendedFloatingActionButton.f19027b));
        }
        if (hVar.c("height")) {
            arrayList.add(hVar.a("height", this.f19090b, ExtendedFloatingActionButton.f19028c));
        }
        if (hVar.c("paddingStart")) {
            arrayList.add(hVar.a("paddingStart", this.f19090b, ExtendedFloatingActionButton.f19029e));
        }
        if (hVar.c("paddingEnd")) {
            arrayList.add(hVar.a("paddingEnd", this.f19090b, ExtendedFloatingActionButton.f19030f));
        }
        if (hVar.c("labelOpacity")) {
            arrayList.add(hVar.a("labelOpacity", this.f19090b, new Property<ExtendedFloatingActionButton, Float>(Float.class, "LABEL_OPACITY_PROPERTY") {
                /* renamed from: a */
                public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
                    return Float.valueOf(a.a(0.0f, 1.0f, (((float) Color.alpha(extendedFloatingActionButton.getCurrentTextColor())) / 255.0f) / ((float) Color.alpha(extendedFloatingActionButton.f19032a.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.f19090b.f19032a.getDefaultColor())))));
                }

                /* renamed from: a */
                public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f2) {
                    int colorForState = extendedFloatingActionButton.f19032a.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.f19090b.f19032a.getDefaultColor());
                    ColorStateList valueOf = ColorStateList.valueOf(Color.argb((int) (a.a(0.0f, ((float) Color.alpha(colorForState)) / 255.0f, f2.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
                    if (f2.floatValue() == 1.0f) {
                        extendedFloatingActionButton.a(extendedFloatingActionButton.f19032a);
                    } else {
                        extendedFloatingActionButton.a(valueOf);
                    }
                }
            }));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        gl.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final List<Animator.AnimatorListener> b() {
        return this.f19091c;
    }

    public h c() {
        return this.f19094f;
    }

    public void d() {
        this.f19092d.b();
    }

    public void e() {
        this.f19092d.b();
    }

    public AnimatorSet f() {
        return b(a());
    }
}
