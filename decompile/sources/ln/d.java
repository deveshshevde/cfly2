package ln;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.xeagle.android.widgets.wheelView.widget.WheelView;

public class d extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    protected int f30961a;

    /* renamed from: b  reason: collision with root package name */
    protected int f30962b;

    /* renamed from: c  reason: collision with root package name */
    protected WheelView.c f30963c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f30964d;

    public d(int i2, int i3, WheelView.c cVar) {
        this.f30961a = i2;
        this.f30962b = i3;
        this.f30963c = cVar;
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f30964d = paint;
        int i2 = -1;
        if (this.f30963c.f26189a != -1) {
            i2 = this.f30963c.f26189a;
        }
        paint.setColor(i2);
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (float) this.f30961a, (float) this.f30962b, this.f30964d);
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i2) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
