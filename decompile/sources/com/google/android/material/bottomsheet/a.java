package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.e;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.blankj.utilcode.constant.MemoryConstants;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import gw.h;
import t.ac;
import t.ak;
import t.u;
import u.c;

public class a extends e {

    /* renamed from: a  reason: collision with root package name */
    boolean f18654a;

    /* renamed from: b  reason: collision with root package name */
    boolean f18655b = true;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public BottomSheetBehavior<FrameLayout> f18656c;

    /* renamed from: d  reason: collision with root package name */
    private FrameLayout f18657d;

    /* renamed from: e  reason: collision with root package name */
    private CoordinatorLayout f18658e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f18659f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18660g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f18661h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public BottomSheetBehavior.a f18662i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f18663j;

    /* renamed from: k  reason: collision with root package name */
    private BottomSheetBehavior.a f18664k = new BottomSheetBehavior.a() {
        public void a(View view, float f2) {
        }

        public void a(View view, int i2) {
            if (i2 == 5) {
                a.this.cancel();
            }
        }
    };

    /* renamed from: com.google.android.material.bottomsheet.a$a  reason: collision with other inner class name */
    private static class C0126a extends BottomSheetBehavior.a {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f18670a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f18671b;

        /* renamed from: c  reason: collision with root package name */
        private final ak f18672c;

        private C0126a(View view, ak akVar) {
            int color;
            this.f18672c = akVar;
            boolean z2 = Build.VERSION.SDK_INT >= 23 && (view.getSystemUiVisibility() & 8192) != 0;
            this.f18671b = z2;
            h f2 = BottomSheetBehavior.b(view).f();
            ColorStateList N = f2 != null ? f2.N() : ac.C(view);
            if (N != null) {
                color = N.getDefaultColor();
            } else if (view.getBackground() instanceof ColorDrawable) {
                color = ((ColorDrawable) view.getBackground()).getColor();
            } else {
                this.f18670a = z2;
                return;
            }
            this.f18670a = gn.a.a(color);
        }

        private void a(View view) {
            int paddingLeft;
            int i2;
            if (view.getTop() < this.f18672c.b()) {
                a.a(view, this.f18670a);
                paddingLeft = view.getPaddingLeft();
                i2 = this.f18672c.b() - view.getTop();
            } else if (view.getTop() != 0) {
                a.a(view, this.f18671b);
                paddingLeft = view.getPaddingLeft();
                i2 = 0;
            } else {
                return;
            }
            view.setPadding(paddingLeft, i2, view.getPaddingRight(), view.getPaddingBottom());
        }

        public void a(View view, float f2) {
            a(view);
        }

        public void a(View view, int i2) {
            a(view);
        }
    }

    public a(Context context, int i2) {
        super(context, a(context, i2));
        a(1);
        this.f18663j = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    private static int a(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : R.style.Theme_Design_Light_BottomSheetDialog;
    }

    private View a(int i2, View view, ViewGroup.LayoutParams layoutParams) {
        f();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f18657d.findViewById(R.id.coordinator);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, coordinatorLayout, false);
        }
        if (this.f18663j) {
            ac.a((View) this.f18659f, (u) new u() {
                public ak a(View view, ak akVar) {
                    if (a.this.f18662i != null) {
                        a.this.f18656c.b(a.this.f18662i);
                    }
                    if (akVar != null) {
                        a aVar = a.this;
                        BottomSheetBehavior.a unused = aVar.f18662i = new C0126a(aVar.f18659f, akVar);
                        a.this.f18656c.a(a.this.f18662i);
                    }
                    return akVar;
                }
            });
        }
        this.f18659f.removeAllViews();
        FrameLayout frameLayout = this.f18659f;
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (a.this.f18655b && a.this.isShowing() && a.this.d()) {
                    a.this.cancel();
                }
            }
        });
        ac.a((View) this.f18659f, (t.a) new t.a() {
            public void a(View view, c cVar) {
                boolean z2;
                super.a(view, cVar);
                if (a.this.f18655b) {
                    cVar.a((int) MemoryConstants.MB);
                    z2 = true;
                } else {
                    z2 = false;
                }
                cVar.m(z2);
            }

            public boolean a(View view, int i2, Bundle bundle) {
                if (i2 != 1048576 || !a.this.f18655b) {
                    return super.a(view, i2, bundle);
                }
                a.this.cancel();
                return true;
            }
        });
        this.f18659f.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        return this.f18657d;
    }

    public static void a(View view, boolean z2) {
        if (Build.VERSION.SDK_INT >= 23) {
            int systemUiVisibility = view.getSystemUiVisibility();
            view.setSystemUiVisibility(z2 ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
        }
    }

    private FrameLayout f() {
        if (this.f18657d == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, (ViewGroup) null);
            this.f18657d = frameLayout;
            this.f18658e = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.f18657d.findViewById(R.id.design_bottom_sheet);
            this.f18659f = frameLayout2;
            BottomSheetBehavior<FrameLayout> b2 = BottomSheetBehavior.b(frameLayout2);
            this.f18656c = b2;
            b2.a(this.f18664k);
            this.f18656c.b(this.f18655b);
        }
        return this.f18657d;
    }

    public BottomSheetBehavior<FrameLayout> a() {
        if (this.f18656c == null) {
            f();
        }
        return this.f18656c;
    }

    public boolean c() {
        return this.f18654a;
    }

    public void cancel() {
        BottomSheetBehavior<FrameLayout> a2 = a();
        if (!this.f18654a || a2.e() == 5) {
            super.cancel();
        } else {
            a2.e(5);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        if (!this.f18661h) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.f18660g = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.f18661h = true;
        }
        return this.f18660g;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f18656c.b(this.f18664k);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null && Build.VERSION.SDK_INT >= 21) {
            boolean z2 = this.f18663j && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.f18657d;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z2);
            }
            CoordinatorLayout coordinatorLayout = this.f18658e;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z2);
            }
            if (z2) {
                window.getDecorView().setSystemUiVisibility(768);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.setStatusBarColor(0);
                window.addFlags(Integer.MIN_VALUE);
                if (Build.VERSION.SDK_INT < 23) {
                    window.addFlags(67108864);
                }
            }
            window.setLayout(-1, -1);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f18656c;
        if (bottomSheetBehavior != null && bottomSheetBehavior.e() == 5) {
            this.f18656c.e(4);
        }
    }

    public void setCancelable(boolean z2) {
        super.setCancelable(z2);
        if (this.f18655b != z2) {
            this.f18655b = z2;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f18656c;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.b(z2);
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean z2) {
        super.setCanceledOnTouchOutside(z2);
        if (z2 && !this.f18655b) {
            this.f18655b = true;
        }
        this.f18660g = z2;
        this.f18661h = true;
    }

    public void setContentView(int i2) {
        super.setContentView(a(i2, (View) null, (ViewGroup.LayoutParams) null));
    }

    public void setContentView(View view) {
        super.setContentView(a(0, view, (ViewGroup.LayoutParams) null));
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(a(0, view, layoutParams));
    }
}
