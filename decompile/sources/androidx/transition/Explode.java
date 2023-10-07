package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class Explode extends Visibility {

    /* renamed from: a  reason: collision with root package name */
    private static final TimeInterpolator f4688a = new DecelerateInterpolator();

    /* renamed from: i  reason: collision with root package name */
    private static final TimeInterpolator f4689i = new AccelerateInterpolator();

    /* renamed from: j  reason: collision with root package name */
    private int[] f4690j = new int[2];

    public Explode() {
        a((w) new c());
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a((w) new c());
    }

    private static float a(float f2, float f3) {
        return (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
    }

    private static float a(View view, int i2, int i3) {
        return a((float) Math.max(i2, view.getWidth() - i2), (float) Math.max(i3, view.getHeight() - i3));
    }

    private void a(View view, Rect rect, int[] iArr) {
        int i2;
        int i3;
        View view2 = view;
        view2.getLocationOnScreen(this.f4690j);
        int[] iArr2 = this.f4690j;
        int i4 = iArr2[0];
        int i5 = iArr2[1];
        Rect o2 = o();
        if (o2 == null) {
            i3 = (view.getWidth() / 2) + i4 + Math.round(view.getTranslationX());
            i2 = (view.getHeight() / 2) + i5 + Math.round(view.getTranslationY());
        } else {
            int centerX = o2.centerX();
            i2 = o2.centerY();
            i3 = centerX;
        }
        float centerX2 = (float) (rect.centerX() - i3);
        float centerY = (float) (rect.centerY() - i2);
        if (centerX2 == 0.0f && centerY == 0.0f) {
            centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float a2 = a(centerX2, centerY);
        float a3 = a(view2, i3 - i4, i2 - i5);
        iArr[0] = Math.round((centerX2 / a2) * a3);
        iArr[1] = Math.round(a3 * (centerY / a2));
    }

    private void d(y yVar) {
        View view = yVar.f4887b;
        view.getLocationOnScreen(this.f4690j);
        int[] iArr = this.f4690j;
        int i2 = iArr[0];
        int i3 = iArr[1];
        yVar.f4886a.put("android:explode:screenBounds", new Rect(i2, i3, view.getWidth() + i2, view.getHeight() + i3));
    }

    public Animator a(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        if (yVar2 == null) {
            return null;
        }
        Rect rect = (Rect) yVar2.f4886a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        a((View) viewGroup, rect, this.f4690j);
        int[] iArr = this.f4690j;
        return aa.a(view, yVar2, rect.left, rect.top, translationX + ((float) iArr[0]), translationY + ((float) iArr[1]), translationX, translationY, f4688a, this);
    }

    public void a(y yVar) {
        super.a(yVar);
        d(yVar);
    }

    public Animator b(ViewGroup viewGroup, View view, y yVar, y yVar2) {
        float f2;
        float f3;
        if (yVar == null) {
            return null;
        }
        Rect rect = (Rect) yVar.f4886a.get("android:explode:screenBounds");
        int i2 = rect.left;
        int i3 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) yVar.f4887b.getTag(R.id.transition_position);
        if (iArr != null) {
            f3 = ((float) (iArr[0] - rect.left)) + translationX;
            f2 = ((float) (iArr[1] - rect.top)) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f3 = translationX;
            f2 = translationY;
        }
        a((View) viewGroup, rect, this.f4690j);
        int[] iArr2 = this.f4690j;
        return aa.a(view, yVar, i2, i3, translationX, translationY, f3 + ((float) iArr2[0]), f2 + ((float) iArr2[1]), f4689i, this);
    }

    public void b(y yVar) {
        super.b(yVar);
        d(yVar);
    }
}
