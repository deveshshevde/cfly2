package gv;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

public class a {

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f28610g = new int[3];

    /* renamed from: h  reason: collision with root package name */
    private static final float[] f28611h = {0.0f, 0.5f, 1.0f};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f28612i = new int[4];

    /* renamed from: j  reason: collision with root package name */
    private static final float[] f28613j = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    private final Paint f28614a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f28615b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f28616c;

    /* renamed from: d  reason: collision with root package name */
    private int f28617d;

    /* renamed from: e  reason: collision with root package name */
    private int f28618e;

    /* renamed from: f  reason: collision with root package name */
    private int f28619f;

    /* renamed from: k  reason: collision with root package name */
    private final Path f28620k;

    /* renamed from: l  reason: collision with root package name */
    private Paint f28621l;

    public a() {
        this(-16777216);
    }

    public a(int i2) {
        this.f28620k = new Path();
        this.f28621l = new Paint();
        this.f28614a = new Paint();
        a(i2);
        this.f28621l.setColor(0);
        Paint paint = new Paint(4);
        this.f28615b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f28616c = new Paint(paint);
    }

    public Paint a() {
        return this.f28614a;
    }

    public void a(int i2) {
        this.f28617d = m.a.b(i2, 68);
        this.f28618e = m.a.b(i2, 20);
        this.f28619f = m.a.b(i2, 0);
        this.f28614a.setColor(this.f28617d);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i2) {
        rectF.bottom += (float) i2;
        rectF.offset(0.0f, (float) (-i2));
        int[] iArr = f28610g;
        iArr[0] = this.f28619f;
        iArr[1] = this.f28618e;
        iArr[2] = this.f28617d;
        this.f28616c.setShader(new LinearGradient(rectF.left, rectF.top, rectF.left, rectF.bottom, iArr, f28611h, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f28616c);
        canvas.restore();
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i2, float f2, float f3) {
        Canvas canvas2 = canvas;
        RectF rectF2 = rectF;
        int i3 = i2;
        float f4 = f3;
        boolean z2 = f4 < 0.0f;
        Path path = this.f28620k;
        if (z2) {
            int[] iArr = f28612i;
            iArr[0] = 0;
            iArr[1] = this.f28619f;
            iArr[2] = this.f28618e;
            iArr[3] = this.f28617d;
            float f5 = f2;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF2, f2, f4);
            path.close();
            float f6 = (float) (-i3);
            rectF2.inset(f6, f6);
            int[] iArr2 = f28612i;
            iArr2[0] = 0;
            iArr2[1] = this.f28617d;
            iArr2[2] = this.f28618e;
            iArr2[3] = this.f28619f;
        }
        float width = rectF.width() / 2.0f;
        if (width > 0.0f) {
            float f7 = 1.0f - (((float) i3) / width);
            float[] fArr = f28613j;
            fArr[1] = f7;
            fArr[2] = ((1.0f - f7) / 2.0f) + f7;
            this.f28615b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, f28612i, fArr, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix);
            canvas2.scale(1.0f, rectF.height() / rectF.width());
            if (!z2) {
                canvas2.clipPath(path, Region.Op.DIFFERENCE);
                canvas2.drawPath(path, this.f28621l);
            }
            canvas.drawArc(rectF, f2, f3, true, this.f28615b);
            canvas.restore();
        }
    }
}
