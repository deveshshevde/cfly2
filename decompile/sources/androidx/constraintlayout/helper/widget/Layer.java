package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import fg.i;

public class Layer extends ConstraintHelper {

    /* renamed from: a  reason: collision with root package name */
    ConstraintLayout f1670a;

    /* renamed from: b  reason: collision with root package name */
    protected float f1671b = Float.NaN;

    /* renamed from: c  reason: collision with root package name */
    protected float f1672c = Float.NaN;

    /* renamed from: d  reason: collision with root package name */
    protected float f1673d = Float.NaN;

    /* renamed from: e  reason: collision with root package name */
    protected float f1674e = Float.NaN;

    /* renamed from: f  reason: collision with root package name */
    protected float f1675f = Float.NaN;

    /* renamed from: g  reason: collision with root package name */
    protected float f1676g = Float.NaN;

    /* renamed from: h  reason: collision with root package name */
    boolean f1677h = true;

    /* renamed from: i  reason: collision with root package name */
    View[] f1678i = null;

    /* renamed from: q  reason: collision with root package name */
    private float f1679q = Float.NaN;

    /* renamed from: r  reason: collision with root package name */
    private float f1680r = Float.NaN;

    /* renamed from: s  reason: collision with root package name */
    private float f1681s = Float.NaN;

    /* renamed from: t  reason: collision with root package name */
    private float f1682t = 1.0f;

    /* renamed from: u  reason: collision with root package name */
    private float f1683u = 1.0f;

    /* renamed from: v  reason: collision with root package name */
    private float f1684v = 0.0f;

    /* renamed from: w  reason: collision with root package name */
    private float f1685w = 0.0f;

    /* renamed from: x  reason: collision with root package name */
    private boolean f1686x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f1687y;

    public Layer(Context context) {
        super(context);
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Layer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    private void b() {
        if (this.f1670a != null && this.f2524k != 0) {
            View[] viewArr = this.f1678i;
            if (viewArr == null || viewArr.length != this.f2524k) {
                this.f1678i = new View[this.f2524k];
            }
            for (int i2 = 0; i2 < this.f2524k; i2++) {
                this.f1678i[i2] = this.f1670a.d(this.f2523j[i2]);
            }
        }
    }

    private void e() {
        if (this.f1670a != null) {
            if (this.f1678i == null) {
                b();
            }
            a();
            double radians = Float.isNaN(this.f1681s) ? i.f27244a : Math.toRadians((double) this.f1681s);
            float sin = (float) Math.sin(radians);
            float cos = (float) Math.cos(radians);
            float f2 = this.f1682t;
            float f3 = f2 * cos;
            float f4 = this.f1683u;
            float f5 = (-f4) * sin;
            float f6 = f2 * sin;
            float f7 = f4 * cos;
            for (int i2 = 0; i2 < this.f2524k; i2++) {
                View view = this.f1678i[i2];
                float left = ((float) ((view.getLeft() + view.getRight()) / 2)) - this.f1671b;
                float top = ((float) ((view.getTop() + view.getBottom()) / 2)) - this.f1672c;
                view.setTranslationX((((f3 * left) + (f5 * top)) - left) + this.f1684v);
                view.setTranslationY((((left * f6) + (f7 * top)) - top) + this.f1685w);
                view.setScaleY(this.f1683u);
                view.setScaleX(this.f1682t);
                if (!Float.isNaN(this.f1681s)) {
                    view.setRotation(this.f1681s);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (this.f1670a != null) {
            if (!this.f1677h && !Float.isNaN(this.f1671b) && !Float.isNaN(this.f1672c)) {
                return;
            }
            if (Float.isNaN(this.f1679q) || Float.isNaN(this.f1680r)) {
                View[] e2 = e(this.f1670a);
                int left = e2[0].getLeft();
                int top = e2[0].getTop();
                int right = e2[0].getRight();
                int bottom = e2[0].getBottom();
                for (int i2 = 0; i2 < this.f2524k; i2++) {
                    View view = e2[i2];
                    left = Math.min(left, view.getLeft());
                    top = Math.min(top, view.getTop());
                    right = Math.max(right, view.getRight());
                    bottom = Math.max(bottom, view.getBottom());
                }
                this.f1673d = (float) right;
                this.f1674e = (float) bottom;
                this.f1675f = (float) left;
                this.f1676g = (float) top;
                this.f1671b = Float.isNaN(this.f1679q) ? (float) ((left + right) / 2) : this.f1679q;
                this.f1672c = Float.isNaN(this.f1680r) ? (float) ((top + bottom) / 2) : this.f1680r;
                return;
            }
            this.f1672c = this.f1680r;
            this.f1671b = this.f1679q;
        }
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.f2527n = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.f1686x = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.f1687y = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void a(ConstraintLayout constraintLayout) {
        this.f1670a = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f || !Float.isNaN(this.f1681s)) {
            this.f1681s = rotation;
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        b();
        this.f1671b = Float.NaN;
        this.f1672c = Float.NaN;
        ConstraintWidget a2 = ((ConstraintLayout.LayoutParams) getLayoutParams()).a();
        a2.o(0);
        a2.p(0);
        a();
        layout(((int) this.f1675f) - getPaddingLeft(), ((int) this.f1676g) - getPaddingTop(), ((int) this.f1673d) + getPaddingRight(), ((int) this.f1674e) + getPaddingBottom());
        e();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1670a = (ConstraintLayout) getParent();
        if (this.f1686x || this.f1687y) {
            int visibility = getVisibility();
            float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
            for (int i2 = 0; i2 < this.f2524k; i2++) {
                View d2 = this.f1670a.d(this.f2523j[i2]);
                if (d2 != null) {
                    if (this.f1686x) {
                        d2.setVisibility(visibility);
                    }
                    if (this.f1687y && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
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

    public void setPivotX(float f2) {
        this.f1679q = f2;
        e();
    }

    public void setPivotY(float f2) {
        this.f1680r = f2;
        e();
    }

    public void setRotation(float f2) {
        this.f1681s = f2;
        e();
    }

    public void setScaleX(float f2) {
        this.f1682t = f2;
        e();
    }

    public void setScaleY(float f2) {
        this.f1683u = f2;
        e();
    }

    public void setTranslationX(float f2) {
        this.f1684v = f2;
        e();
    }

    public void setTranslationY(float f2) {
        this.f1685w = f2;
        e();
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        d();
    }
}
