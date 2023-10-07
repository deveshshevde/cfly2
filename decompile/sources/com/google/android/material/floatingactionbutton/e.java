package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.R;
import gv.b;
import gw.h;
import gw.m;
import java.util.ArrayList;
import s.f;

class e extends d {

    static class a extends h {
        a(m mVar) {
            super(mVar);
        }

        public boolean isStateful() {
            return true;
        }
    }

    e(FloatingActionButton floatingActionButton, b bVar) {
        super(floatingActionButton, bVar);
    }

    private Animator a(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f19131s, "elevation", new float[]{f2}).setDuration(0)).with(ObjectAnimator.ofFloat(this.f19131s, View.TRANSLATION_Z, new float[]{f3}).setDuration(100));
        animatorSet.setInterpolator(f19113a);
        return animatorSet;
    }

    public float a() {
        return this.f19131s.getElevation();
    }

    /* access modifiers changed from: package-private */
    public c a(int i2, ColorStateList colorStateList) {
        Context context = this.f19131s.getContext();
        c cVar = new c((m) f.a(this.f19120b));
        cVar.a(androidx.core.content.b.c(context, R.color.design_fab_stroke_top_outer_color), androidx.core.content.b.c(context, R.color.design_fab_stroke_top_inner_color), androidx.core.content.b.c(context, R.color.design_fab_stroke_end_inner_color), androidx.core.content.b.c(context, R.color.design_fab_stroke_end_outer_color));
        cVar.a((float) i2);
        cVar.a(colorStateList);
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT == 21) {
            this.f19131s.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(f19114m, a(f2, f4));
            stateListAnimator.addState(f19115n, a(f2, f3));
            stateListAnimator.addState(f19116o, a(f2, f3));
            stateListAnimator.addState(f19117p, a(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.f19131s, "elevation", new float[]{f2}).setDuration(0));
            if (Build.VERSION.SDK_INT >= 22 && Build.VERSION.SDK_INT <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(this.f19131s, View.TRANSLATION_Z, new float[]{this.f19131s.getTranslationZ()}).setDuration(100));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.f19131s, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(f19113a);
            stateListAnimator.addState(f19118q, animatorSet);
            stateListAnimator.addState(f19119r, a(0.0f, 0.0f));
            this.f19131s.setStateListAnimator(stateListAnimator);
        }
        if (p()) {
            o();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable drawable;
        this.f19121c = u();
        this.f19121c.setTintList(colorStateList);
        if (mode != null) {
            this.f19121c.setTintMode(mode);
        }
        this.f19121c.a(this.f19131s.getContext());
        if (i2 > 0) {
            this.f19123e = a(i2, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{(Drawable) f.a(this.f19123e), (Drawable) f.a(this.f19121c)});
        } else {
            this.f19123e = null;
            drawable = this.f19121c;
        }
        this.f19122d = new RippleDrawable(gu.b.b(colorStateList2), drawable, (Drawable) null);
        this.f19124f = this.f19122d;
    }

    /* access modifiers changed from: package-private */
    public void a(Rect rect) {
        if (this.f19132t.a()) {
            super.a(rect);
            return;
        }
        int sizeDimension = !h() ? (this.f19130l - this.f19131s.getSizeDimension()) / 2 : 0;
        rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
    }

    /* access modifiers changed from: package-private */
    public void a(int[] iArr) {
        FloatingActionButton floatingActionButton;
        if (Build.VERSION.SDK_INT == 21) {
            float f2 = 0.0f;
            if (this.f19131s.isEnabled()) {
                this.f19131s.setElevation(this.f19127i);
                if (this.f19131s.isPressed()) {
                    floatingActionButton = this.f19131s;
                    f2 = this.f19129k;
                } else if (this.f19131s.isFocused() || this.f19131s.isHovered()) {
                    floatingActionButton = this.f19131s;
                    f2 = this.f19128j;
                }
                floatingActionButton.setTranslationZ(f2);
            }
            this.f19131s.setElevation(0.0f);
            floatingActionButton = this.f19131s;
            floatingActionButton.setTranslationZ(f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        if (this.f19122d instanceof RippleDrawable) {
            ((RippleDrawable) this.f19122d).setColor(gu.b.b(colorStateList));
        } else {
            super.b(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
    }

    /* access modifiers changed from: package-private */
    public void n() {
        o();
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.f19132t.a() || !h();
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public h u() {
        return new a((m) f.a(this.f19120b));
    }

    /* access modifiers changed from: package-private */
    public void x() {
    }
}
