package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Placeholder extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f2608a = -1;

    /* renamed from: b  reason: collision with root package name */
    private View f2609b = null;

    /* renamed from: c  reason: collision with root package name */
    private int f2610c = 4;

    public Placeholder(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        super.setVisibility(this.f2610c);
        this.f2608a = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_placeholder);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_placeholder_content) {
                    this.f2608a = obtainStyledAttributes.getResourceId(index, this.f2608a);
                } else if (index == R.styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) {
                    this.f2610c = obtainStyledAttributes.getInt(index, this.f2610c);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void a(ConstraintLayout constraintLayout) {
        if (this.f2608a == -1 && !isInEditMode()) {
            setVisibility(this.f2610c);
        }
        View findViewById = constraintLayout.findViewById(this.f2608a);
        this.f2609b = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.LayoutParams) findViewById.getLayoutParams()).f2548ab = true;
            this.f2609b.setVisibility(0);
            setVisibility(0);
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f2609b != null) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f2609b.getLayoutParams();
            layoutParams2.f2560an.j(0);
            if (layoutParams.f2560an.S() != ConstraintWidget.DimensionBehaviour.FIXED) {
                layoutParams.f2560an.o(layoutParams2.f2560an.A());
            }
            if (layoutParams.f2560an.T() != ConstraintWidget.DimensionBehaviour.FIXED) {
                layoutParams.f2560an.p(layoutParams2.f2560an.B());
            }
            layoutParams2.f2560an.j(8);
        }
    }

    public View getContent() {
        return this.f2609b;
    }

    public int getEmptyVisibility() {
        return this.f2610c;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) height) / 2.0f) + (((float) rect.height()) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void setContentId(int i2) {
        View findViewById;
        if (this.f2608a != i2) {
            View view = this.f2609b;
            if (view != null) {
                view.setVisibility(0);
                ((ConstraintLayout.LayoutParams) this.f2609b.getLayoutParams()).f2548ab = false;
                this.f2609b = null;
            }
            this.f2608a = i2;
            if (i2 != -1 && (findViewById = ((View) getParent()).findViewById(i2)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public void setEmptyVisibility(int i2) {
        this.f2610c = i2;
    }
}
