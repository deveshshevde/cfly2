package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeScroll extends Transition {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f4657a = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll() {
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void d(y yVar) {
        yVar.f4886a.put("android:changeScroll:x", Integer.valueOf(yVar.f4887b.getScrollX()));
        yVar.f4886a.put("android:changeScroll:y", Integer.valueOf(yVar.f4887b.getScrollY()));
    }

    public Animator a(ViewGroup viewGroup, y yVar, y yVar2) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = null;
        if (yVar == null || yVar2 == null) {
            return null;
        }
        View view = yVar2.f4887b;
        int intValue = ((Integer) yVar.f4886a.get("android:changeScroll:x")).intValue();
        int intValue2 = ((Integer) yVar2.f4886a.get("android:changeScroll:x")).intValue();
        int intValue3 = ((Integer) yVar.f4886a.get("android:changeScroll:y")).intValue();
        int intValue4 = ((Integer) yVar2.f4886a.get("android:changeScroll:y")).intValue();
        if (intValue != intValue2) {
            view.setScrollX(intValue);
            objectAnimator = ObjectAnimator.ofInt(view, "scrollX", new int[]{intValue, intValue2});
        } else {
            objectAnimator = null;
        }
        if (intValue3 != intValue4) {
            view.setScrollY(intValue3);
            objectAnimator2 = ObjectAnimator.ofInt(view, "scrollY", new int[]{intValue3, intValue4});
        }
        return x.a(objectAnimator, objectAnimator2);
    }

    public void a(y yVar) {
        d(yVar);
    }

    public String[] a() {
        return f4657a;
    }

    public void b(y yVar) {
        d(yVar);
    }
}
