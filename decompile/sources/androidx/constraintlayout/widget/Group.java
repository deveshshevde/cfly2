package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Group extends ConstraintHelper {
    public Group(Context context) {
        super(context);
    }

    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Group(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.f2527n = false;
    }

    public void b(ConstraintLayout constraintLayout) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f2560an.o(0);
        layoutParams.f2560an.p(0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
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
