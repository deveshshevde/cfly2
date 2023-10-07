package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.R;
import com.google.android.material.internal.k;
import com.google.android.material.textfield.TextInputLayout;
import gl.a;
import gw.h;
import gw.m;
import t.ac;
import u.c;

class d extends e {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f19815d = (Build.VERSION.SDK_INT >= 21);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final TextWatcher f19816e = new k() {
        public void afterTextChanged(Editable editable) {
            final AutoCompleteTextView a2 = d.c(d.this.f19844a.getEditText());
            if (d.this.f19826o.isTouchExplorationEnabled() && d.d((EditText) a2) && !d.this.f19846c.hasFocus()) {
                a2.dismissDropDown();
            }
            a2.post(new Runnable() {
                public void run() {
                    boolean isPopupShowing = a2.isPopupShowing();
                    d.this.b(isPopupShowing);
                    boolean unused = d.this.f19821j = isPopupShowing;
                }
            });
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final View.OnFocusChangeListener f19817f = new View.OnFocusChangeListener() {
        public void onFocusChange(View view, boolean z2) {
            d.this.f19844a.setEndIconActivated(z2);
            if (!z2) {
                d.this.b(false);
                boolean unused = d.this.f19821j = false;
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final TextInputLayout.a f19818g = new TextInputLayout.a(this.f19844a) {
        public void a(View view, c cVar) {
            super.a(view, cVar);
            if (!d.d(d.this.f19844a.getEditText())) {
                cVar.b((CharSequence) Spinner.class.getName());
            }
            if (cVar.z()) {
                cVar.g((CharSequence) null);
            }
        }

        public void c(View view, AccessibilityEvent accessibilityEvent) {
            super.c(view, accessibilityEvent);
            AutoCompleteTextView a2 = d.c(d.this.f19844a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && d.this.f19826o.isTouchExplorationEnabled() && !d.d(d.this.f19844a.getEditText())) {
                d.this.a(a2);
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private final TextInputLayout.b f19819h = new TextInputLayout.b() {
        public void a(TextInputLayout textInputLayout) {
            AutoCompleteTextView a2 = d.c(textInputLayout.getEditText());
            d.this.b(a2);
            d.this.c(a2);
            d.this.d(a2);
            a2.setThreshold(0);
            a2.removeTextChangedListener(d.this.f19816e);
            a2.addTextChangedListener(d.this.f19816e);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!d.d((EditText) a2)) {
                ac.b((View) d.this.f19846c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(d.this.f19818g);
            textInputLayout.setEndIconVisible(true);
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private final TextInputLayout.c f19820i = new TextInputLayout.c() {
        public void a(TextInputLayout textInputLayout, int i2) {
            final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView != null && i2 == 3) {
                autoCompleteTextView.post(new Runnable() {
                    public void run() {
                        autoCompleteTextView.removeTextChangedListener(d.this.f19816e);
                    }
                });
                if (autoCompleteTextView.getOnFocusChangeListener() == d.this.f19817f) {
                    autoCompleteTextView.setOnFocusChangeListener((View.OnFocusChangeListener) null);
                }
                autoCompleteTextView.setOnTouchListener((View.OnTouchListener) null);
                if (d.f19815d) {
                    autoCompleteTextView.setOnDismissListener((AutoCompleteTextView.OnDismissListener) null);
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f19821j = false;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f19822k = false;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public long f19823l = Long.MAX_VALUE;

    /* renamed from: m  reason: collision with root package name */
    private StateListDrawable f19824m;

    /* renamed from: n  reason: collision with root package name */
    private h f19825n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public AccessibilityManager f19826o;

    /* renamed from: p  reason: collision with root package name */
    private ValueAnimator f19827p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public ValueAnimator f19828q;

    d(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    private ValueAnimator a(int i2, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(a.f28535a);
        ofFloat.setDuration((long) i2);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.f19846c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }

    private h a(float f2, float f3, float f4, int i2) {
        m a2 = m.a().b(f2).c(f2).e(f3).d(f3).a();
        h a3 = h.a(this.f19845b, f4);
        a3.setShapeAppearanceModel(a2);
        a3.a(0, i2, 0, i2);
        return a3;
    }

    /* access modifiers changed from: private */
    public void a(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView != null) {
            if (d()) {
                this.f19821j = false;
            }
            if (!this.f19821j) {
                if (f19815d) {
                    b(!this.f19822k);
                } else {
                    this.f19822k = !this.f19822k;
                    this.f19846c.toggle();
                }
                if (this.f19822k) {
                    autoCompleteTextView.requestFocus();
                    autoCompleteTextView.showDropDown();
                    return;
                }
                autoCompleteTextView.dismissDropDown();
                return;
            }
            this.f19821j = false;
        }
    }

    private void a(AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, h hVar) {
        LayerDrawable layerDrawable;
        int a2 = gn.a.a((View) autoCompleteTextView, R.attr.colorSurface);
        h hVar2 = new h(hVar.M());
        int a3 = gn.a.a(i2, a2, 0.1f);
        hVar2.g(new ColorStateList(iArr, new int[]{a3, 0}));
        if (f19815d) {
            hVar2.setTint(a2);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{a3, a2});
            h hVar3 = new h(hVar.M());
            hVar3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, hVar2, hVar3), hVar});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{hVar2, hVar});
        }
        ac.a((View) autoCompleteTextView, (Drawable) layerDrawable);
    }

    /* access modifiers changed from: private */
    public void b(AutoCompleteTextView autoCompleteTextView) {
        Drawable drawable;
        if (f19815d) {
            int boxBackgroundMode = this.f19844a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                drawable = this.f19825n;
            } else if (boxBackgroundMode == 1) {
                drawable = this.f19824m;
            } else {
                return;
            }
            autoCompleteTextView.setDropDownBackgroundDrawable(drawable);
        }
    }

    private void b(AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, h hVar) {
        int boxBackgroundColor = this.f19844a.getBoxBackgroundColor();
        int[] iArr2 = {gn.a.a(i2, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (f19815d) {
            ac.a((View) autoCompleteTextView, (Drawable) new RippleDrawable(new ColorStateList(iArr, iArr2), hVar, hVar));
            return;
        }
        h hVar2 = new h(hVar.M());
        hVar2.g(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{hVar, hVar2});
        int l2 = ac.l(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int m2 = ac.m(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        ac.a((View) autoCompleteTextView, (Drawable) layerDrawable);
        ac.b(autoCompleteTextView, l2, paddingTop, m2, paddingBottom);
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        if (this.f19822k != z2) {
            this.f19822k = z2;
            this.f19828q.cancel();
            this.f19827p.start();
        }
    }

    /* access modifiers changed from: private */
    public static AutoCompleteTextView c(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    /* access modifiers changed from: private */
    public void c(AutoCompleteTextView autoCompleteTextView) {
        if (!d((EditText) autoCompleteTextView)) {
            int boxBackgroundMode = this.f19844a.getBoxBackgroundMode();
            h boxBackground = this.f19844a.getBoxBackground();
            int a2 = gn.a.a((View) autoCompleteTextView, R.attr.colorControlHighlight);
            int[][] iArr = {new int[]{16842919}, new int[0]};
            if (boxBackgroundMode == 2) {
                a(autoCompleteTextView, a2, iArr, boxBackground);
            } else if (boxBackgroundMode == 1) {
                b(autoCompleteTextView, a2, iArr, boxBackground);
            }
        }
    }

    /* access modifiers changed from: private */
    public void d(final AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    if (d.this.d()) {
                        boolean unused = d.this.f19821j = false;
                    }
                    d.this.a(autoCompleteTextView);
                }
                return false;
            }
        });
        autoCompleteTextView.setOnFocusChangeListener(this.f19817f);
        if (f19815d) {
            autoCompleteTextView.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() {
                public void onDismiss() {
                    boolean unused = d.this.f19821j = true;
                    long unused2 = d.this.f19823l = System.currentTimeMillis();
                    d.this.b(false);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public boolean d() {
        long currentTimeMillis = System.currentTimeMillis() - this.f19823l;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    /* access modifiers changed from: private */
    public static boolean d(EditText editText) {
        return editText.getKeyListener() != null;
    }

    private void e() {
        this.f19828q = a(67, 0.0f, 1.0f);
        ValueAnimator a2 = a(50, 1.0f, 0.0f);
        this.f19827p = a2;
        a2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                d.this.f19846c.setChecked(d.this.f19822k);
                d.this.f19828q.start();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a() {
        float dimensionPixelOffset = (float) this.f19845b.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = (float) this.f19845b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f19845b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        h a2 = a(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        h a3 = a(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.f19825n = a2;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f19824m = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, a2);
        this.f19824m.addState(new int[0], a3);
        this.f19844a.setEndIconDrawable(c.a.b(this.f19845b, f19815d ? R.drawable.mtrl_dropdown_arrow : R.drawable.mtrl_ic_arrow_drop_down));
        this.f19844a.setEndIconContentDescription(this.f19844a.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.f19844a.setEndIconOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                d.this.a((AutoCompleteTextView) d.this.f19844a.getEditText());
            }
        });
        this.f19844a.a(this.f19819h);
        this.f19844a.a(this.f19820i);
        e();
        this.f19826o = (AccessibilityManager) this.f19845b.getSystemService("accessibility");
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2) {
        return i2 != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return true;
    }
}
