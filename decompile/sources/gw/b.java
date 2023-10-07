package gw;

import android.graphics.RectF;
import java.util.Arrays;

public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final c f13136a;

    /* renamed from: b  reason: collision with root package name */
    private final float f13137b;

    public b(float f2, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f13136a;
            f2 += ((b) cVar).f13137b;
        }
        this.f13136a = cVar;
        this.f13137b = f2;
    }

    public float a(RectF rectF) {
        return Math.max(0.0f, this.f13136a.a(rectF) + this.f13137b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f13136a.equals(bVar.f13136a) && this.f13137b == bVar.f13137b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f13136a, Float.valueOf(this.f13137b)});
    }
}
