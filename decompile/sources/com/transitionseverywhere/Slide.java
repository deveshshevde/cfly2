package com.transitionseverywhere;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.transitionseverywhere.utils.m;

public class Slide extends Visibility {
    private static final a G = new b() {
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    };
    private static final a H = new b() {
        public float a(ViewGroup viewGroup, View view) {
            boolean f2 = m.f(viewGroup);
            float translationX = view.getTranslationX();
            float width = (float) viewGroup.getWidth();
            return f2 ? translationX + width : translationX - width;
        }
    };
    private static final a I = new c() {
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - ((float) viewGroup.getHeight());
        }
    };
    private static final a J = new b() {
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    };
    private static final a K = new b() {
        public float a(ViewGroup viewGroup, View view) {
            boolean f2 = m.f(viewGroup);
            float translationX = view.getTranslationX();
            float width = (float) viewGroup.getWidth();
            return f2 ? translationX - width : translationX + width;
        }
    };
    private static final a L = new c() {
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + ((float) viewGroup.getHeight());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    protected static final TimeInterpolator f21838a = new DecelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    protected static final TimeInterpolator f21839b = new AccelerateInterpolator();
    private int F = 80;

    /* renamed from: c  reason: collision with root package name */
    protected a f21840c = L;

    protected interface a {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    protected static abstract class b implements a {
        protected b() {
        }

        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }
    }

    protected static abstract class c implements a {
        protected c() {
        }

        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }
    }

    public Slide() {
        a(80);
    }

    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Slide);
        int i2 = obtainStyledAttributes.getInt(R.styleable.Slide_slideEdge, 80);
        obtainStyledAttributes.recycle();
        a(i2);
    }

    public Animator a(ViewGroup viewGroup, View view, h hVar, h hVar2) {
        if (hVar2 == null) {
            return null;
        }
        int[] iArr = (int[]) hVar2.f21927b.get("android:visibility:screenLocation");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return j.a(view, hVar2, iArr[0], iArr[1], this.f21840c.a(viewGroup, view), this.f21840c.b(viewGroup, view), translationX, translationY, f21838a, this);
    }

    public void a(int i2) {
        a aVar;
        if (i2 == 3) {
            aVar = G;
        } else if (i2 == 5) {
            aVar = J;
        } else if (i2 == 48) {
            aVar = I;
        } else if (i2 == 80) {
            aVar = L;
        } else if (i2 == 8388611) {
            aVar = H;
        } else if (i2 == 8388613) {
            aVar = K;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
        this.f21840c = aVar;
        this.F = i2;
        d dVar = new d();
        dVar.a(i2);
        a((f) dVar);
    }

    public Animator b(ViewGroup viewGroup, View view, h hVar, h hVar2) {
        if (hVar == null) {
            return null;
        }
        int[] iArr = (int[]) hVar.f21927b.get("android:visibility:screenLocation");
        return j.a(view, hVar, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.f21840c.a(viewGroup, view), this.f21840c.b(viewGroup, view), f21839b, this);
    }
}
