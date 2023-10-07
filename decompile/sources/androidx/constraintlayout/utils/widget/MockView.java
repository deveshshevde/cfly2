package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R;

public class MockView extends View {

    /* renamed from: a  reason: collision with root package name */
    protected String f2484a = null;

    /* renamed from: b  reason: collision with root package name */
    private Paint f2485b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    private Paint f2486c = new Paint();

    /* renamed from: d  reason: collision with root package name */
    private Paint f2487d = new Paint();

    /* renamed from: e  reason: collision with root package name */
    private boolean f2488e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2489f = true;

    /* renamed from: g  reason: collision with root package name */
    private Rect f2490g = new Rect();

    /* renamed from: h  reason: collision with root package name */
    private int f2491h = Color.argb(255, 0, 0, 0);

    /* renamed from: i  reason: collision with root package name */
    private int f2492i = Color.argb(255, 200, 200, 200);

    /* renamed from: j  reason: collision with root package name */
    private int f2493j = Color.argb(255, 50, 50, 50);

    /* renamed from: k  reason: collision with root package name */
    private int f2494k = 4;

    public MockView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MockView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MockView_mock_label) {
                    this.f2484a = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MockView_mock_showDiagonals) {
                    this.f2488e = obtainStyledAttributes.getBoolean(index, this.f2488e);
                } else if (index == R.styleable.MockView_mock_diagonalsColor) {
                    this.f2491h = obtainStyledAttributes.getColor(index, this.f2491h);
                } else if (index == R.styleable.MockView_mock_labelBackgroundColor) {
                    this.f2493j = obtainStyledAttributes.getColor(index, this.f2493j);
                } else if (index == R.styleable.MockView_mock_labelColor) {
                    this.f2492i = obtainStyledAttributes.getColor(index, this.f2492i);
                } else if (index == R.styleable.MockView_mock_showLabel) {
                    this.f2489f = obtainStyledAttributes.getBoolean(index, this.f2489f);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f2484a == null) {
            try {
                this.f2484a = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.f2485b.setColor(this.f2491h);
        this.f2485b.setAntiAlias(true);
        this.f2486c.setColor(this.f2492i);
        this.f2486c.setAntiAlias(true);
        this.f2487d.setColor(this.f2493j);
        this.f2494k = Math.round(((float) this.f2494k) * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f2488e) {
            width--;
            height--;
            float f2 = (float) width;
            float f3 = (float) height;
            canvas.drawLine(0.0f, 0.0f, f2, f3, this.f2485b);
            Canvas canvas2 = canvas;
            float f4 = f2;
            canvas2.drawLine(0.0f, f3, f4, 0.0f, this.f2485b);
            canvas2.drawLine(0.0f, 0.0f, f4, 0.0f, this.f2485b);
            float f5 = f2;
            float f6 = f3;
            canvas2.drawLine(f5, 0.0f, f4, f6, this.f2485b);
            float f7 = f3;
            canvas2.drawLine(f5, f7, 0.0f, f6, this.f2485b);
            canvas2.drawLine(0.0f, f7, 0.0f, 0.0f, this.f2485b);
        }
        String str = this.f2484a;
        if (str != null && this.f2489f) {
            this.f2486c.getTextBounds(str, 0, str.length(), this.f2490g);
            float width2 = ((float) (width - this.f2490g.width())) / 2.0f;
            float height2 = (((float) (height - this.f2490g.height())) / 2.0f) + ((float) this.f2490g.height());
            this.f2490g.offset((int) width2, (int) height2);
            Rect rect = this.f2490g;
            rect.set(rect.left - this.f2494k, this.f2490g.top - this.f2494k, this.f2490g.right + this.f2494k, this.f2490g.bottom + this.f2494k);
            canvas.drawRect(this.f2490g, this.f2487d);
            canvas.drawText(this.f2484a, width2, height2, this.f2486c);
        }
    }
}
