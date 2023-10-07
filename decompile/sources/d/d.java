package d;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;

public class d extends Drawable {

    /* renamed from: b  reason: collision with root package name */
    private static final float f26670b = ((float) Math.toRadians(45.0d));

    /* renamed from: a  reason: collision with root package name */
    private final Paint f26671a;

    /* renamed from: c  reason: collision with root package name */
    private float f26672c;

    /* renamed from: d  reason: collision with root package name */
    private float f26673d;

    /* renamed from: e  reason: collision with root package name */
    private float f26674e;

    /* renamed from: f  reason: collision with root package name */
    private float f26675f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f26676g;

    /* renamed from: h  reason: collision with root package name */
    private final Path f26677h;

    /* renamed from: i  reason: collision with root package name */
    private final int f26678i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f26679j;

    /* renamed from: k  reason: collision with root package name */
    private float f26680k;

    /* renamed from: l  reason: collision with root package name */
    private float f26681l;

    /* renamed from: m  reason: collision with root package name */
    private int f26682m;

    private static float a(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * f4);
    }

    public void a(float f2) {
        if (this.f26680k != f2) {
            this.f26680k = f2;
            invalidateSelf();
        }
    }

    public void a(boolean z2) {
        if (this.f26679j != z2) {
            this.f26679j = z2;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        Canvas canvas2 = canvas;
        Rect bounds = getBounds();
        int i2 = this.f26682m;
        boolean z2 = false;
        if (i2 != 0 && (i2 == 1 || (i2 == 3 ? a.i(this) == 0 : a.i(this) == 1))) {
            z2 = true;
        }
        float f2 = this.f26672c;
        float a2 = a(this.f26673d, (float) Math.sqrt((double) (f2 * f2 * 2.0f)), this.f26680k);
        float a3 = a(this.f26673d, this.f26674e, this.f26680k);
        float round = (float) Math.round(a(0.0f, this.f26681l, this.f26680k));
        float a4 = a(0.0f, f26670b, this.f26680k);
        double d2 = (double) a2;
        float a5 = a(z2 ? 0.0f : -180.0f, z2 ? 180.0f : 0.0f, this.f26680k);
        double d3 = (double) a4;
        double cos = Math.cos(d3);
        Double.isNaN(d2);
        boolean z3 = z2;
        float round2 = (float) Math.round(cos * d2);
        double sin = Math.sin(d3);
        Double.isNaN(d2);
        float round3 = (float) Math.round(d2 * sin);
        this.f26677h.rewind();
        float a6 = a(this.f26675f + this.f26671a.getStrokeWidth(), -this.f26681l, this.f26680k);
        float f3 = (-a3) / 2.0f;
        this.f26677h.moveTo(f3 + round, 0.0f);
        this.f26677h.rLineTo(a3 - (round * 2.0f), 0.0f);
        this.f26677h.moveTo(f3, a6);
        this.f26677h.rLineTo(round2, round3);
        this.f26677h.moveTo(f3, -a6);
        this.f26677h.rLineTo(round2, -round3);
        this.f26677h.close();
        canvas.save();
        float strokeWidth = this.f26671a.getStrokeWidth();
        float height = ((float) bounds.height()) - (3.0f * strokeWidth);
        float f4 = this.f26675f;
        canvas2.translate((float) bounds.centerX(), ((float) ((((int) (height - (2.0f * f4))) / 4) * 2)) + (strokeWidth * 1.5f) + f4);
        if (this.f26676g) {
            canvas2.rotate(a5 * ((float) (this.f26679j ^ z3 ? -1 : 1)));
        } else if (z3) {
            canvas2.rotate(180.0f);
        }
        canvas2.drawPath(this.f26677h, this.f26671a);
        canvas.restore();
    }

    public int getIntrinsicHeight() {
        return this.f26678i;
    }

    public int getIntrinsicWidth() {
        return this.f26678i;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i2) {
        if (i2 != this.f26671a.getAlpha()) {
            this.f26671a.setAlpha(i2);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f26671a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
