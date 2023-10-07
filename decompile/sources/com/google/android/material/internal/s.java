package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import com.google.android.material.R;
import t.ac;
import t.ak;
import t.u;

public class s {

    public interface a {
        ak a(View view, ak akVar, b bVar);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f19338a;

        /* renamed from: b  reason: collision with root package name */
        public int f19339b;

        /* renamed from: c  reason: collision with root package name */
        public int f19340c;

        /* renamed from: d  reason: collision with root package name */
        public int f19341d;

        public b(int i2, int i3, int i4, int i5) {
            this.f19338a = i2;
            this.f19339b = i3;
            this.f19340c = i4;
            this.f19341d = i5;
        }

        public b(b bVar) {
            this.f19338a = bVar.f19338a;
            this.f19339b = bVar.f19339b;
            this.f19340c = bVar.f19340c;
            this.f19341d = bVar.f19341d;
        }

        public void a(View view) {
            ac.b(view, this.f19338a, this.f19339b, this.f19340c, this.f19341d);
        }
    }

    public static float a(Context context, int i2) {
        return TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics());
    }

    public static PorterDuff.Mode a(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void a(View view, AttributeSet attributeSet, int i2, int i3, final a aVar) {
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.Insets, i2, i3);
        final boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingBottomSystemWindowInsets, false);
        final boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingLeftSystemWindowInsets, false);
        final boolean z4 = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingRightSystemWindowInsets, false);
        obtainStyledAttributes.recycle();
        a(view, (a) new a() {
            public ak a(View view, ak akVar, b bVar) {
                if (z2) {
                    bVar.f19341d += akVar.d();
                }
                boolean a2 = s.a(view);
                if (z3) {
                    if (a2) {
                        bVar.f19340c += akVar.a();
                    } else {
                        bVar.f19338a += akVar.a();
                    }
                }
                if (z4) {
                    if (a2) {
                        bVar.f19338a += akVar.c();
                    } else {
                        bVar.f19340c += akVar.c();
                    }
                }
                bVar.a(view);
                a aVar = aVar;
                return aVar != null ? aVar.a(view, akVar, bVar) : akVar;
            }
        });
    }

    public static void a(View view, final a aVar) {
        final b bVar = new b(ac.l(view), view.getPaddingTop(), ac.m(view), view.getPaddingBottom());
        ac.a(view, (u) new u() {
            public ak a(View view, ak akVar) {
                return aVar.a(view, akVar, new b(bVar));
            }
        });
        c(view);
    }

    public static boolean a(View view) {
        return ac.i(view) == 1;
    }

    public static void b(final View view) {
        view.requestFocus();
        view.post(new Runnable() {
            public void run() {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
            }
        });
    }

    public static void c(View view) {
        if (ac.J(view)) {
            ac.w(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(View view) {
                    view.removeOnAttachStateChangeListener(this);
                    ac.w(view);
                }

                public void onViewDetachedFromWindow(View view) {
                }
            });
        }
    }

    public static float d(View view) {
        float f2 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f2 += ac.s((View) parent);
        }
        return f2;
    }

    public static r e(View view) {
        if (view == null) {
            return null;
        }
        return Build.VERSION.SDK_INT >= 18 ? new q(view) : p.a(view);
    }

    public static ViewGroup f(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(16908290);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    public static r g(View view) {
        return e(f(view));
    }
}
