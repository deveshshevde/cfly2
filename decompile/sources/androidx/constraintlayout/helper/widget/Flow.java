package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.e;
import androidx.constraintlayout.solver.widgets.h;
import androidx.constraintlayout.solver.widgets.j;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.constraintlayout.widget.b;

public class Flow extends VirtualLayout {

    /* renamed from: a  reason: collision with root package name */
    private e f1669a;

    public Flow(Context context) {
        super(context);
    }

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Flow(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.f1669a = new e();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_android_orientation) {
                    this.f1669a.a(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_padding) {
                    this.f1669a.K(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingStart) {
                    if (Build.VERSION.SDK_INT >= 17) {
                        this.f1669a.L(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingEnd) {
                    if (Build.VERSION.SDK_INT >= 17) {
                        this.f1669a.M(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingLeft) {
                    this.f1669a.N(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingTop) {
                    this.f1669a.O(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingRight) {
                    this.f1669a.P(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingBottom) {
                    this.f1669a.Q(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_wrapMode) {
                    this.f1669a.F(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.f1669a.B(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.f1669a.C(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.f1669a.b(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.f1669a.z(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.f1669a.y(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.f1669a.A(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.f1669a.e(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.f1669a.g(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.f1669a.i(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.f1669a.h(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.f1669a.j(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalBias) {
                    this.f1669a.f(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.f1669a.D(obtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.f1669a.E(obtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.f1669a.G(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalGap) {
                    this.f1669a.H(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.f1669a.I(obtainStyledAttributes.getInt(index, -1));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f2526m = this.f1669a;
        c();
    }

    public void a(ConstraintWidget constraintWidget, boolean z2) {
        this.f1669a.a(z2);
    }

    public void a(j jVar, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (jVar != null) {
            jVar.b(mode, size, mode2, size2);
            setMeasuredDimension(jVar.X(), jVar.Y());
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public void a(b.a aVar, h hVar, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        super.a(aVar, hVar, layoutParams, sparseArray);
        if (hVar instanceof e) {
            e eVar = (e) hVar;
            if (layoutParams.S != -1) {
                eVar.a(layoutParams.S);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        a(this.f1669a, i2, i3);
    }

    public void setFirstHorizontalBias(float f2) {
        this.f1669a.g(f2);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i2) {
        this.f1669a.b(i2);
        requestLayout();
    }

    public void setFirstVerticalBias(float f2) {
        this.f1669a.h(f2);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i2) {
        this.f1669a.y(i2);
        requestLayout();
    }

    public void setHorizontalAlign(int i2) {
        this.f1669a.D(i2);
        requestLayout();
    }

    public void setHorizontalBias(float f2) {
        this.f1669a.e(f2);
        requestLayout();
    }

    public void setHorizontalGap(int i2) {
        this.f1669a.G(i2);
        requestLayout();
    }

    public void setHorizontalStyle(int i2) {
        this.f1669a.B(i2);
        requestLayout();
    }

    public void setMaxElementsWrap(int i2) {
        this.f1669a.I(i2);
        requestLayout();
    }

    public void setOrientation(int i2) {
        this.f1669a.a(i2);
        requestLayout();
    }

    public void setPadding(int i2) {
        this.f1669a.K(i2);
        requestLayout();
    }

    public void setPaddingBottom(int i2) {
        this.f1669a.Q(i2);
        requestLayout();
    }

    public void setPaddingLeft(int i2) {
        this.f1669a.N(i2);
        requestLayout();
    }

    public void setPaddingRight(int i2) {
        this.f1669a.P(i2);
        requestLayout();
    }

    public void setPaddingTop(int i2) {
        this.f1669a.O(i2);
        requestLayout();
    }

    public void setVerticalAlign(int i2) {
        this.f1669a.E(i2);
        requestLayout();
    }

    public void setVerticalBias(float f2) {
        this.f1669a.f(f2);
        requestLayout();
    }

    public void setVerticalGap(int i2) {
        this.f1669a.H(i2);
        requestLayout();
    }

    public void setVerticalStyle(int i2) {
        this.f1669a.C(i2);
        requestLayout();
    }

    public void setWrapMode(int i2) {
        this.f1669a.F(i2);
        requestLayout();
    }
}
