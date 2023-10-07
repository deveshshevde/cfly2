package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.circularreveal.b;

public interface c extends b.a {

    public static class a implements TypeEvaluator<d> {

        /* renamed from: a  reason: collision with root package name */
        public static final TypeEvaluator<d> f18857a = new a();

        /* renamed from: b  reason: collision with root package name */
        private final d f18858b = new d();

        /* renamed from: a */
        public d evaluate(float f2, d dVar, d dVar2) {
            this.f18858b.a(gs.a.a(dVar.f18861a, dVar2.f18861a, f2), gs.a.a(dVar.f18862b, dVar2.f18862b, f2), gs.a.a(dVar.f18863c, dVar2.f18863c, f2));
            return this.f18858b;
        }
    }

    public static class b extends Property<c, d> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<c, d> f18859a = new b("circularReveal");

        private b(String str) {
            super(d.class, str);
        }

        /* renamed from: a */
        public d get(c cVar) {
            return cVar.getRevealInfo();
        }

        /* renamed from: a */
        public void set(c cVar, d dVar) {
            cVar.setRevealInfo(dVar);
        }
    }

    /* renamed from: com.google.android.material.circularreveal.c$c  reason: collision with other inner class name */
    public static class C0128c extends Property<c, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<c, Integer> f18860a = new C0128c("circularRevealScrimColor");

        private C0128c(String str) {
            super(Integer.class, str);
        }

        /* renamed from: a */
        public Integer get(c cVar) {
            return Integer.valueOf(cVar.getCircularRevealScrimColor());
        }

        /* renamed from: a */
        public void set(c cVar, Integer num) {
            cVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public float f18861a;

        /* renamed from: b  reason: collision with root package name */
        public float f18862b;

        /* renamed from: c  reason: collision with root package name */
        public float f18863c;

        private d() {
        }

        public d(float f2, float f3, float f4) {
            this.f18861a = f2;
            this.f18862b = f3;
            this.f18863c = f4;
        }

        public d(d dVar) {
            this(dVar.f18861a, dVar.f18862b, dVar.f18863c);
        }

        public void a(float f2, float f3, float f4) {
            this.f18861a = f2;
            this.f18862b = f3;
            this.f18863c = f4;
        }

        public void a(d dVar) {
            a(dVar.f18861a, dVar.f18862b, dVar.f18863c);
        }

        public boolean a() {
            return this.f18863c == Float.MAX_VALUE;
        }
    }

    void a();

    int getCircularRevealScrimColor();

    d getRevealInfo();

    void q_();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i2);

    void setRevealInfo(d dVar);
}
