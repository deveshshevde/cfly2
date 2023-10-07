package gw;

import android.graphics.RectF;
import java.util.Arrays;

public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final float f13135a;

    public a(float f2) {
        this.f13135a = f2;
    }

    public float a(RectF rectF) {
        return this.f13135a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f13135a == ((a) obj).f13135a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f13135a)});
    }
}
