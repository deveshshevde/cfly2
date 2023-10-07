package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

public class MotionHelper extends ConstraintHelper implements MotionLayout.g {

    /* renamed from: a  reason: collision with root package name */
    protected View[] f1688a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1689b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1690c = false;

    /* renamed from: d  reason: collision with root package name */
    private float f1691d;

    public MotionHelper(Context context) {
        super(context);
    }

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionHelper);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MotionHelper_onShow) {
                    this.f1689b = obtainStyledAttributes.getBoolean(index, this.f1689b);
                } else if (index == R.styleable.MotionHelper_onHide) {
                    this.f1690c = obtainStyledAttributes.getBoolean(index, this.f1690c);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void a(View view, float f2) {
    }

    public void a(MotionLayout motionLayout, int i2) {
    }

    public void a(MotionLayout motionLayout, int i2, int i3) {
    }

    public void a(MotionLayout motionLayout, int i2, int i3, float f2) {
    }

    public void a(MotionLayout motionLayout, int i2, boolean z2, float f2) {
    }

    public boolean a() {
        return this.f1689b;
    }

    public boolean b() {
        return this.f1690c;
    }

    public float getProgress() {
        return this.f1691d;
    }

    public void setProgress(float f2) {
        this.f1691d = f2;
        int i2 = 0;
        if (this.f2524k > 0) {
            this.f1688a = e((ConstraintLayout) getParent());
            while (i2 < this.f2524k) {
                a(this.f1688a[i2], f2);
                i2++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i2 < childCount) {
            View childAt = viewGroup.getChildAt(i2);
            if (!(childAt instanceof MotionHelper)) {
                a(childAt, f2);
            }
            i2++;
        }
    }
}
