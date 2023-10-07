package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    ValueAnimator f19305a = null;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<a> f19306b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private a f19307c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Animator.AnimatorListener f19308d = new AnimatorListenerAdapter() {
        public void onAnimationEnd(Animator animator) {
            if (h.this.f19305a == animator) {
                h.this.f19305a = null;
            }
        }
    };

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final int[] f19310a;

        /* renamed from: b  reason: collision with root package name */
        final ValueAnimator f19311b;

        a(int[] iArr, ValueAnimator valueAnimator) {
            this.f19310a = iArr;
            this.f19311b = valueAnimator;
        }
    }

    private void a(a aVar) {
        ValueAnimator valueAnimator = aVar.f19311b;
        this.f19305a = valueAnimator;
        valueAnimator.start();
    }

    private void b() {
        ValueAnimator valueAnimator = this.f19305a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f19305a = null;
        }
    }

    public void a() {
        ValueAnimator valueAnimator = this.f19305a;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f19305a = null;
        }
    }

    public void a(int[] iArr) {
        a aVar;
        int size = this.f19306b.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                aVar = null;
                break;
            }
            aVar = this.f19306b.get(i2);
            if (StateSet.stateSetMatches(aVar.f19310a, iArr)) {
                break;
            }
            i2++;
        }
        a aVar2 = this.f19307c;
        if (aVar != aVar2) {
            if (aVar2 != null) {
                b();
            }
            this.f19307c = aVar;
            if (aVar != null) {
                a(aVar);
            }
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        a aVar = new a(iArr, valueAnimator);
        valueAnimator.addListener(this.f19308d);
        this.f19306b.add(aVar);
    }
}
