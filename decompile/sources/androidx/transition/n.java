package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

class n<T> extends Property<T, Float> {

    /* renamed from: a  reason: collision with root package name */
    private final Property<T, PointF> f4851a;

    /* renamed from: b  reason: collision with root package name */
    private final PathMeasure f4852b;

    /* renamed from: c  reason: collision with root package name */
    private final float f4853c;

    /* renamed from: d  reason: collision with root package name */
    private final float[] f4854d = new float[2];

    /* renamed from: e  reason: collision with root package name */
    private final PointF f4855e = new PointF();

    /* renamed from: f  reason: collision with root package name */
    private float f4856f;

    n(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f4851a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f4852b = pathMeasure;
        this.f4853c = pathMeasure.getLength();
    }

    /* renamed from: a */
    public Float get(T t2) {
        return Float.valueOf(this.f4856f);
    }

    /* renamed from: a */
    public void set(T t2, Float f2) {
        this.f4856f = f2.floatValue();
        this.f4852b.getPosTan(this.f4853c * f2.floatValue(), this.f4854d, (float[]) null);
        this.f4855e.x = this.f4854d[0];
        this.f4855e.y = this.f4854d[1];
        this.f4851a.set(t2, this.f4855e);
    }
}
