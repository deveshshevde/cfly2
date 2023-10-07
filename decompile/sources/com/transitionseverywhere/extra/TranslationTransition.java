package com.transitionseverywhere.extra;

import android.animation.Animator;
import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.h;
import com.transitionseverywhere.utils.a;
import com.transitionseverywhere.utils.g;

public class TranslationTransition extends Transition {

    /* renamed from: a  reason: collision with root package name */
    private static final g<View> f21924a = (Build.VERSION.SDK_INT >= 14 ? new g<View>() {
        /* renamed from: a */
        public PointF get(View view) {
            return new PointF(view.getTranslationX(), view.getTranslationY());
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            view.setTranslationX(pointF.x);
            view.setTranslationY(pointF.y);
        }
    } : null);

    public TranslationTransition() {
    }

    public TranslationTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void d(h hVar) {
        hVar.f21927b.put("TranslationTransition:translationX", Float.valueOf(hVar.f21926a.getTranslationX()));
        hVar.f21927b.put("TranslationTransition:translationY", Float.valueOf(hVar.f21926a.getTranslationY()));
    }

    public Animator a(ViewGroup viewGroup, h hVar, h hVar2) {
        g<View> gVar;
        if (hVar == null || hVar2 == null || (gVar = f21924a) == null) {
            return null;
        }
        float floatValue = ((Float) hVar.f21927b.get("TranslationTransition:translationX")).floatValue();
        float floatValue2 = ((Float) hVar.f21927b.get("TranslationTransition:translationY")).floatValue();
        float floatValue3 = ((Float) hVar2.f21927b.get("TranslationTransition:translationX")).floatValue();
        float floatValue4 = ((Float) hVar2.f21927b.get("TranslationTransition:translationY")).floatValue();
        hVar2.f21926a.setTranslationX(floatValue);
        hVar2.f21926a.setTranslationY(floatValue2);
        return a.a(hVar2.f21926a, gVar, k(), floatValue, floatValue2, floatValue3, floatValue4);
    }

    public void a(h hVar) {
        d(hVar);
    }

    public void b(h hVar) {
        d(hVar);
    }
}
