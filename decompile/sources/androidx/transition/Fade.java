package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import l.g;
import org.xmlpull.v1.XmlPullParser;
import t.ac;

public class Fade extends Visibility {

    private static class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f4693a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f4694b = false;

        a(View view) {
            this.f4693a = view;
        }

        public void onAnimationEnd(Animator animator) {
            aj.a(this.f4693a, 1.0f);
            if (this.f4694b) {
                this.f4693a.setLayerType(0, (Paint) null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (ac.A(this.f4693a) && this.f4693a.getLayerType() == 0) {
                this.f4694b = true;
                this.f4693a.setLayerType(2, (Paint) null);
            }
        }
    }

    public Fade() {
    }

    public Fade(int i2) {
        b(i2);
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.f4867f);
        b(g.a(obtainStyledAttributes, (XmlPullParser) (XmlResourceParser) attributeSet, "fadingMode", 0, s()));
        obtainStyledAttributes.recycle();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = (java.lang.Float) r1.f4886a.get("android:fade:transitionAlpha");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float a(androidx.transition.y r1, float r2) {
        /*
            if (r1 == 0) goto L_0x0012
            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.f4886a
            java.lang.String r0 = "android:fade:transitionAlpha"
            java.lang.Object r1 = r1.get(r0)
            java.lang.Float r1 = (java.lang.Float) r1
            if (r1 == 0) goto L_0x0012
            float r2 = r1.floatValue()
        L_0x0012:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Fade.a(androidx.transition.y, float):float");
    }

    private Animator a(final View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        aj.a(view, f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, aj.f4795a, new float[]{f3});
        ofFloat.addListener(new a(view));
        a((Transition.c) new u() {
            public void b(Transition transition) {
                aj.a(view, 1.0f);
                aj.e(view);
                transition.b((Transition.c) this);
            }
        });
        return ofFloat;
    }

    public Animator a(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        float f2 = 0.0f;
        float a2 = a(yVar, 0.0f);
        if (a2 != 1.0f) {
            f2 = a2;
        }
        return a(view, f2, 1.0f);
    }

    public void a(y yVar) {
        super.a(yVar);
        yVar.f4886a.put("android:fade:transitionAlpha", Float.valueOf(aj.c(yVar.f4887b)));
    }

    public Animator b(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        aj.d(view);
        return a(view, a(yVar, 1.0f), 0.0f);
    }
}
