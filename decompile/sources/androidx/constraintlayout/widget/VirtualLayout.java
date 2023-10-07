package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.solver.widgets.j;

public abstract class VirtualLayout extends ConstraintHelper {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2613a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2614b;

    public VirtualLayout(Context context) {
        super(context);
    }

    public VirtualLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VirtualLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.f2613a = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.f2614b = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void a(j jVar, int i2, int i3) {
    }

    public void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.f2613a || this.f2614b) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
            for (int i2 = 0; i2 < this.f2524k; i2++) {
                View d2 = constraintLayout.d(this.f2523j[i2]);
                if (d2 != null) {
                    if (this.f2613a) {
                        d2.setVisibility(visibility);
                    }
                    if (this.f2614b && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                        d2.setTranslationZ(d2.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        d();
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        d();
    }
}
