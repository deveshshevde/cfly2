package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Constraints extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    b f2596a;

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float aA;
        public float aB;

        /* renamed from: ap  reason: collision with root package name */
        public float f2597ap;

        /* renamed from: aq  reason: collision with root package name */
        public boolean f2598aq;

        /* renamed from: ar  reason: collision with root package name */
        public float f2599ar;

        /* renamed from: as  reason: collision with root package name */
        public float f2600as;

        /* renamed from: at  reason: collision with root package name */
        public float f2601at;

        /* renamed from: au  reason: collision with root package name */
        public float f2602au;

        /* renamed from: av  reason: collision with root package name */
        public float f2603av;

        /* renamed from: aw  reason: collision with root package name */
        public float f2604aw;

        /* renamed from: ax  reason: collision with root package name */
        public float f2605ax;

        /* renamed from: ay  reason: collision with root package name */
        public float f2606ay;

        /* renamed from: az  reason: collision with root package name */
        public float f2607az;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f2597ap = 1.0f;
            this.f2598aq = false;
            this.f2599ar = 0.0f;
            this.f2600as = 0.0f;
            this.f2601at = 0.0f;
            this.f2602au = 0.0f;
            this.f2603av = 1.0f;
            this.f2604aw = 1.0f;
            this.f2605ax = 0.0f;
            this.f2606ay = 0.0f;
            this.f2607az = 0.0f;
            this.aA = 0.0f;
            this.aB = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2597ap = 1.0f;
            this.f2598aq = false;
            this.f2599ar = 0.0f;
            this.f2600as = 0.0f;
            this.f2601at = 0.0f;
            this.f2602au = 0.0f;
            this.f2603av = 1.0f;
            this.f2604aw = 1.0f;
            this.f2605ax = 0.0f;
            this.f2606ay = 0.0f;
            this.f2607az = 0.0f;
            this.aA = 0.0f;
            this.aB = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintSet_android_alpha) {
                    this.f2597ap = obtainStyledAttributes.getFloat(index, this.f2597ap);
                } else if (index == R.styleable.ConstraintSet_android_elevation) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.f2599ar = obtainStyledAttributes.getFloat(index, this.f2599ar);
                        this.f2598aq = true;
                    }
                } else if (index == R.styleable.ConstraintSet_android_rotationX) {
                    this.f2601at = obtainStyledAttributes.getFloat(index, this.f2601at);
                } else if (index == R.styleable.ConstraintSet_android_rotationY) {
                    this.f2602au = obtainStyledAttributes.getFloat(index, this.f2602au);
                } else if (index == R.styleable.ConstraintSet_android_rotation) {
                    this.f2600as = obtainStyledAttributes.getFloat(index, this.f2600as);
                } else if (index == R.styleable.ConstraintSet_android_scaleX) {
                    this.f2603av = obtainStyledAttributes.getFloat(index, this.f2603av);
                } else if (index == R.styleable.ConstraintSet_android_scaleY) {
                    this.f2604aw = obtainStyledAttributes.getFloat(index, this.f2604aw);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotX) {
                    this.f2605ax = obtainStyledAttributes.getFloat(index, this.f2605ax);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotY) {
                    this.f2606ay = obtainStyledAttributes.getFloat(index, this.f2606ay);
                } else if (index == R.styleable.ConstraintSet_android_translationX) {
                    this.f2607az = obtainStyledAttributes.getFloat(index, this.f2607az);
                } else if (index == R.styleable.ConstraintSet_android_translationY) {
                    this.aA = obtainStyledAttributes.getFloat(index, this.aA);
                } else if (index == R.styleable.ConstraintSet_android_translationZ && Build.VERSION.SDK_INT >= 21) {
                    this.aB = obtainStyledAttributes.getFloat(index, this.aB);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(attributeSet);
        super.setVisibility(8);
    }

    private void b(AttributeSet attributeSet) {
        Log.v("Constraints", " ################# init");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public b getConstraintSet() {
        if (this.f2596a == null) {
            this.f2596a = new b();
        }
        this.f2596a.a(this);
        return this.f2596a;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
    }
}
