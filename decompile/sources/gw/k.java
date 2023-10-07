package gw;

import android.graphics.RectF;
import java.util.Arrays;

public final class k implements c {

    /* renamed from: a  reason: collision with root package name */
    private final float f13191a;

    public k(float f2) {
        this.f13191a = f2;
    }

    public float a(RectF rectF) {
        return this.f13191a * rectF.height();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k) && this.f13191a == ((k) obj).f13191a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f13191a)});
    }
}
