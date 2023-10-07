package ln;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.xeagle.android.widgets.wheelView.common.a;
import com.xeagle.android.widgets.wheelView.widget.WheelView;

public class c extends d {

    /* renamed from: d  reason: collision with root package name */
    private Paint f30957d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f30958e;

    /* renamed from: f  reason: collision with root package name */
    private int f30959f;

    /* renamed from: g  reason: collision with root package name */
    private int f30960g;

    public c(int i2, int i3, WheelView.c cVar, int i4, int i5) {
        super(i2, i3, cVar);
        this.f30959f = i4;
        this.f30960g = i5;
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f30957d = paint;
        paint.setColor(this.f30963c.f26189a != -1 ? this.f30963c.f26189a : -1);
        Paint paint2 = new Paint();
        this.f30958e = paint2;
        paint2.setStrokeWidth(this.f30963c.f26191c != -1 ? (float) this.f30963c.f26191c : 3.0f);
        this.f30958e.setColor(this.f30963c.f26190b != -1 ? this.f30963c.f26190b : a.f26145b);
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (float) this.f30961a, (float) this.f30962b, this.f30957d);
        int i2 = this.f30960g;
        if (i2 != 0) {
            canvas.drawLine(0.0f, (float) (i2 * (this.f30959f / 2)), (float) this.f30961a, (float) (this.f30960g * (this.f30959f / 2)), this.f30958e);
            canvas.drawLine(0.0f, (float) (this.f30960g * ((this.f30959f / 2) + 1)), (float) this.f30961a, (float) (this.f30960g * ((this.f30959f / 2) + 1)), this.f30958e);
        }
    }
}
