package ln;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import com.xeagle.android.widgets.wheelView.widget.WheelView;

public class a extends d {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f30948d = {-15658735, 11184810, 11184810};

    /* renamed from: e  reason: collision with root package name */
    private GradientDrawable f30949e;

    /* renamed from: f  reason: collision with root package name */
    private GradientDrawable f30950f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f30951g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f30952h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f30953i;

    /* renamed from: j  reason: collision with root package name */
    private Paint f30954j;

    /* renamed from: k  reason: collision with root package name */
    private int f30955k;

    /* renamed from: l  reason: collision with root package name */
    private int f30956l;

    public a(int i2, int i3, WheelView.c cVar, int i4, int i5) {
        super(i2, i3, cVar);
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        int[] iArr = f30948d;
        this.f30949e = new GradientDrawable(orientation, iArr);
        this.f30950f = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, iArr);
        this.f30955k = i4;
        this.f30956l = i5;
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f30951g = paint;
        paint.setColor(this.f30963c.f26189a != -1 ? this.f30963c.f26189a : com.xeagle.android.widgets.wheelView.common.a.f26144a);
        Paint paint2 = new Paint();
        this.f30952h = paint2;
        paint2.setColor(com.xeagle.android.widgets.wheelView.common.a.f26146c);
        Paint paint3 = new Paint();
        this.f30953i = paint3;
        paint3.setColor(com.xeagle.android.widgets.wheelView.common.a.f26147d);
        this.f30953i.setStrokeWidth(2.0f);
        Paint paint4 = new Paint();
        this.f30954j = paint4;
        paint4.setStrokeWidth(6.0f);
        this.f30954j.setColor(com.xeagle.android.widgets.wheelView.common.a.f26148e);
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (float) this.f30961a, (float) this.f30962b, this.f30951g);
        int i2 = this.f30956l;
        if (i2 != 0) {
            canvas.drawRect(0.0f, (float) (i2 * (this.f30955k / 2)), (float) this.f30961a, (float) (this.f30956l * ((this.f30955k / 2) + 1)), this.f30952h);
            canvas.drawLine(0.0f, (float) (this.f30956l * (this.f30955k / 2)), (float) this.f30961a, (float) (this.f30956l * (this.f30955k / 2)), this.f30953i);
            canvas.drawLine(0.0f, (float) (this.f30956l * ((this.f30955k / 2) + 1)), (float) this.f30961a, (float) (this.f30956l * ((this.f30955k / 2) + 1)), this.f30953i);
            this.f30949e.setBounds(0, 0, this.f30961a, this.f30956l);
            this.f30949e.draw(canvas);
            this.f30950f.setBounds(0, this.f30962b - this.f30956l, this.f30961a, this.f30962b);
            this.f30950f.draw(canvas);
            Canvas canvas2 = canvas;
            canvas2.drawLine(0.0f, 0.0f, 0.0f, (float) this.f30962b, this.f30954j);
            canvas2.drawLine((float) this.f30961a, 0.0f, (float) this.f30961a, (float) this.f30962b, this.f30954j);
        }
    }
}
