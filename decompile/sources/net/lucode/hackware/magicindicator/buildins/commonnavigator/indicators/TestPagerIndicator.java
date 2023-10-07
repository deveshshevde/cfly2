package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import java.util.List;
import mz.c;
import na.a;

public class TestPagerIndicator extends View implements c {

    /* renamed from: a  reason: collision with root package name */
    private Paint f31490a;

    /* renamed from: b  reason: collision with root package name */
    private int f31491b;

    /* renamed from: c  reason: collision with root package name */
    private int f31492c;

    /* renamed from: d  reason: collision with root package name */
    private RectF f31493d = new RectF();

    /* renamed from: e  reason: collision with root package name */
    private RectF f31494e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private List<a> f31495f;

    public TestPagerIndicator(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.f31490a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f31491b = -65536;
        this.f31492c = -16711936;
    }

    public void a(int i2) {
    }

    public void a(int i2, float f2, int i3) {
        List<a> list = this.f31495f;
        if (list != null && !list.isEmpty()) {
            a a2 = net.lucode.hackware.magicindicator.a.a(this.f31495f, i2);
            a a3 = net.lucode.hackware.magicindicator.a.a(this.f31495f, i2 + 1);
            this.f31493d.left = ((float) a2.f31303a) + (((float) (a3.f31303a - a2.f31303a)) * f2);
            this.f31493d.top = ((float) a2.f31304b) + (((float) (a3.f31304b - a2.f31304b)) * f2);
            this.f31493d.right = ((float) a2.f31305c) + (((float) (a3.f31305c - a2.f31305c)) * f2);
            this.f31493d.bottom = ((float) a2.f31306d) + (((float) (a3.f31306d - a2.f31306d)) * f2);
            this.f31494e.left = ((float) a2.f31307e) + (((float) (a3.f31307e - a2.f31307e)) * f2);
            this.f31494e.top = ((float) a2.f31308f) + (((float) (a3.f31308f - a2.f31308f)) * f2);
            this.f31494e.right = ((float) a2.f31309g) + (((float) (a3.f31309g - a2.f31309g)) * f2);
            this.f31494e.bottom = ((float) a2.f31310h) + (((float) (a3.f31310h - a2.f31310h)) * f2);
            invalidate();
        }
    }

    public void a(List<a> list) {
        this.f31495f = list;
    }

    public void b(int i2) {
    }

    public int getInnerRectColor() {
        return this.f31492c;
    }

    public int getOutRectColor() {
        return this.f31491b;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f31490a.setColor(this.f31491b);
        canvas.drawRect(this.f31493d, this.f31490a);
        this.f31490a.setColor(this.f31492c);
        canvas.drawRect(this.f31494e, this.f31490a);
    }

    public void setInnerRectColor(int i2) {
        this.f31492c = i2;
    }

    public void setOutRectColor(int i2) {
        this.f31491b = i2;
    }
}
