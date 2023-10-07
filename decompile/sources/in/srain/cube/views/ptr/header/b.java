package in.srain.cube.views.ptr.header;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.Random;

public class b extends Animation {

    /* renamed from: a  reason: collision with root package name */
    public PointF f13771a;

    /* renamed from: b  reason: collision with root package name */
    public float f13772b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f13773c;

    /* renamed from: d  reason: collision with root package name */
    private float f13774d;

    /* renamed from: e  reason: collision with root package name */
    private float f13775e;

    /* renamed from: f  reason: collision with root package name */
    private PointF f13776f;

    /* renamed from: g  reason: collision with root package name */
    private PointF f13777g;

    public void a(float f2) {
        this.f13773c.setAlpha((int) (f2 * 255.0f));
    }

    public void a(float f2, float f3) {
        this.f13774d = f2;
        this.f13775e = f3;
        super.start();
    }

    public void a(int i2) {
        this.f13772b = (float) ((-new Random().nextInt(i2)) + i2);
    }

    public void a(Canvas canvas) {
        canvas.drawLine(this.f13776f.x, this.f13776f.y, this.f13777g.x, this.f13777g.y, this.f13773c);
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f2, Transformation transformation) {
        float f3 = this.f13774d;
        a(f3 + ((this.f13775e - f3) * f2));
    }
}
