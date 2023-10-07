package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.j;
import com.google.android.material.R;
import gl.a;
import gl.b;
import gt.c;
import java.util.ArrayList;
import java.util.List;
import t.ac;

final class f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19847a;

    /* renamed from: b  reason: collision with root package name */
    private final TextInputLayout f19848b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f19849c;

    /* renamed from: d  reason: collision with root package name */
    private int f19850d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f19851e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Animator f19852f;

    /* renamed from: g  reason: collision with root package name */
    private final float f19853g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f19854h;

    /* renamed from: i  reason: collision with root package name */
    private int f19855i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f19856j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f19857k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public TextView f19858l;

    /* renamed from: m  reason: collision with root package name */
    private CharSequence f19859m;

    /* renamed from: n  reason: collision with root package name */
    private int f19860n;

    /* renamed from: o  reason: collision with root package name */
    private ColorStateList f19861o;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f19862p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f19863q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f19864r;

    /* renamed from: s  reason: collision with root package name */
    private int f19865s;

    /* renamed from: t  reason: collision with root package name */
    private ColorStateList f19866t;

    /* renamed from: u  reason: collision with root package name */
    private Typeface f19867u;

    public f(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f19847a = context;
        this.f19848b = textInputLayout;
        this.f19853g = (float) context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
    }

    private int a(boolean z2, int i2, int i3) {
        return z2 ? this.f19847a.getResources().getDimensionPixelSize(i2) : i3;
    }

    private ObjectAnimator a(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, new float[]{-this.f19853g, 0.0f});
        ofFloat.setDuration(217);
        ofFloat.setInterpolator(a.f28538d);
        return ofFloat;
    }

    private ObjectAnimator a(TextView textView, boolean z2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{z2 ? 1.0f : 0.0f});
        ofFloat.setDuration(167);
        ofFloat.setInterpolator(a.f28535a);
        return ofFloat;
    }

    private void a(int i2, int i3) {
        TextView d2;
        TextView d3;
        if (i2 != i3) {
            if (!(i3 == 0 || (d3 = d(i3)) == null)) {
                d3.setVisibility(0);
                d3.setAlpha(1.0f);
            }
            if (!(i2 == 0 || (d2 = d(i2)) == null)) {
                d2.setVisibility(4);
                if (i2 == 1) {
                    d2.setText((CharSequence) null);
                }
            }
            this.f19854h = i3;
        }
    }

    private void a(int i2, int i3, boolean z2) {
        boolean z3 = z2;
        if (i2 != i3) {
            if (z3) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f19852f = animatorSet;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = arrayList;
                int i4 = i2;
                int i5 = i3;
                a(arrayList2, this.f19863q, this.f19864r, 2, i4, i5);
                a(arrayList2, this.f19857k, this.f19858l, 1, i4, i5);
                b.a(animatorSet, arrayList);
                final TextView d2 = d(i2);
                final TextView d3 = d(i3);
                final int i6 = i3;
                final int i7 = i2;
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        int unused = f.this.f19854h = i6;
                        Animator unused2 = f.this.f19852f = null;
                        TextView textView = d2;
                        if (textView != null) {
                            textView.setVisibility(4);
                            if (i7 == 1 && f.this.f19858l != null) {
                                f.this.f19858l.setText((CharSequence) null);
                            }
                        }
                        TextView textView2 = d3;
                        if (textView2 != null) {
                            textView2.setTranslationY(0.0f);
                            d3.setAlpha(1.0f);
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        TextView textView = d3;
                        if (textView != null) {
                            textView.setVisibility(0);
                        }
                    }
                });
                animatorSet.start();
            } else {
                a(i2, i3);
            }
            this.f19848b.c();
            this.f19848b.a(z3);
            this.f19848b.i();
        }
    }

    private void a(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private void a(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void a(List<Animator> list, boolean z2, TextView textView, int i2, int i3, int i4) {
        if (textView != null && z2) {
            if (i2 == i4 || i2 == i3) {
                list.add(a(textView, i4 == i2));
                if (i4 == i2) {
                    list.add(a(textView));
                }
            }
        }
    }

    private boolean a(TextView textView, CharSequence charSequence) {
        return ac.G(this.f19848b) && this.f19848b.isEnabled() && (this.f19855i != this.f19854h || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    private TextView d(int i2) {
        if (i2 == 1) {
            return this.f19858l;
        }
        if (i2 != 2) {
            return null;
        }
        return this.f19864r;
    }

    private boolean e(int i2) {
        return i2 == 1 && this.f19858l != null && !TextUtils.isEmpty(this.f19856j);
    }

    private boolean n() {
        return (this.f19849c == null || this.f19848b.getEditText() == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        c();
        int i2 = this.f19854h;
        if (i2 == 2) {
            this.f19855i = 0;
        }
        a(i2, this.f19855i, a(this.f19864r, (CharSequence) null));
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        this.f19861o = colorStateList;
        TextView textView = this.f19858l;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Typeface typeface) {
        if (typeface != this.f19867u) {
            this.f19867u = typeface;
            a(this.f19858l, typeface);
            a(this.f19864r, typeface);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(TextView textView, int i2) {
        if (this.f19849c == null && this.f19851e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f19847a);
            this.f19849c = linearLayout;
            linearLayout.setOrientation(0);
            this.f19848b.addView(this.f19849c, -1, -2);
            this.f19851e = new FrameLayout(this.f19847a);
            this.f19849c.addView(this.f19851e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f19848b.getEditText() != null) {
                d();
            }
        }
        if (a(i2)) {
            this.f19851e.setVisibility(0);
            this.f19851e.addView(textView);
        } else {
            this.f19849c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f19849c.setVisibility(0);
        this.f19850d++;
    }

    /* access modifiers changed from: package-private */
    public void a(CharSequence charSequence) {
        c();
        this.f19862p = charSequence;
        this.f19864r.setText(charSequence);
        int i2 = this.f19854h;
        if (i2 != 2) {
            this.f19855i = 2;
        }
        a(i2, this.f19855i, a(this.f19864r, charSequence));
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        if (this.f19857k != z2) {
            c();
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(this.f19847a);
                this.f19858l = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_error);
                if (Build.VERSION.SDK_INT >= 17) {
                    this.f19858l.setTextAlignment(5);
                }
                Typeface typeface = this.f19867u;
                if (typeface != null) {
                    this.f19858l.setTypeface(typeface);
                }
                b(this.f19860n);
                a(this.f19861o);
                c(this.f19859m);
                this.f19858l.setVisibility(4);
                ac.d((View) this.f19858l, 1);
                a(this.f19858l, 0);
            } else {
                b();
                b(this.f19858l, 0);
                this.f19858l = null;
                this.f19848b.c();
                this.f19848b.i();
            }
            this.f19857k = z2;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2) {
        return i2 == 0 || i2 == 1;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f19856j = null;
        c();
        if (this.f19854h == 1) {
            this.f19855i = (!this.f19863q || TextUtils.isEmpty(this.f19862p)) ? 0 : 2;
        }
        a(this.f19854h, this.f19855i, a(this.f19858l, (CharSequence) null));
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        this.f19860n = i2;
        TextView textView = this.f19858l;
        if (textView != null) {
            this.f19848b.a(textView, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        this.f19866t = colorStateList;
        TextView textView = this.f19864r;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(TextView textView, int i2) {
        FrameLayout frameLayout;
        if (this.f19849c != null) {
            if (!a(i2) || (frameLayout = this.f19851e) == null) {
                this.f19849c.removeView(textView);
            } else {
                frameLayout.removeView(textView);
            }
            int i3 = this.f19850d - 1;
            this.f19850d = i3;
            a((ViewGroup) this.f19849c, i3);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(CharSequence charSequence) {
        c();
        this.f19856j = charSequence;
        this.f19858l.setText(charSequence);
        int i2 = this.f19854h;
        if (i2 != 1) {
            this.f19855i = 1;
        }
        a(i2, this.f19855i, a(this.f19858l, charSequence));
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        if (this.f19863q != z2) {
            c();
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(this.f19847a);
                this.f19864r = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_helper_text);
                if (Build.VERSION.SDK_INT >= 17) {
                    this.f19864r.setTextAlignment(5);
                }
                Typeface typeface = this.f19867u;
                if (typeface != null) {
                    this.f19864r.setTypeface(typeface);
                }
                this.f19864r.setVisibility(4);
                ac.d((View) this.f19864r, 1);
                c(this.f19865s);
                b(this.f19866t);
                a(this.f19864r, 1);
            } else {
                a();
                b(this.f19864r, 1);
                this.f19864r = null;
                this.f19848b.c();
                this.f19848b.i();
            }
            this.f19863q = z2;
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        Animator animator = this.f19852f;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        this.f19865s = i2;
        TextView textView = this.f19864r;
        if (textView != null) {
            j.a(textView, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(CharSequence charSequence) {
        this.f19859m = charSequence;
        TextView textView = this.f19858l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (n()) {
            EditText editText = this.f19848b.getEditText();
            boolean a2 = c.a(this.f19847a);
            ac.b(this.f19849c, a(a2, R.dimen.material_helper_text_font_1_3_padding_horizontal, ac.l(editText)), a(a2, R.dimen.material_helper_text_font_1_3_padding_top, this.f19847a.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top)), a(a2, R.dimen.material_helper_text_font_1_3_padding_horizontal, ac.m(editText)), 0);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.f19857k;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.f19863q;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return e(this.f19855i);
    }

    /* access modifiers changed from: package-private */
    public CharSequence h() {
        return this.f19856j;
    }

    /* access modifiers changed from: package-private */
    public CharSequence i() {
        return this.f19862p;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        TextView textView = this.f19858l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList k() {
        TextView textView = this.f19858l;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public CharSequence l() {
        return this.f19859m;
    }

    /* access modifiers changed from: package-private */
    public int m() {
        TextView textView = this.f19864r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }
}
