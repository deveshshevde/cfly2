package kotlinx.coroutines.internal;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import kotlin.text.f;

final /* synthetic */ class z {
    public static final int a(String str, int i2, int i3, int i4) {
        return (int) x.a(str, (long) i2, (long) i3, (long) i4);
    }

    public static /* synthetic */ int a(String str, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i3 = 1;
        }
        if ((i5 & 8) != 0) {
            i4 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        }
        return x.a(str, i2, i3, i4);
    }

    public static final long a(String str, long j2, long j3, long j4) {
        String a2 = x.a(str);
        if (a2 == null) {
            return j2;
        }
        Long b2 = f.b(a2);
        if (b2 != null) {
            long longValue = b2.longValue();
            if (j3 <= longValue && j4 >= longValue) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j3 + ".." + j4 + ", but is '" + longValue + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + a2 + '\'').toString());
    }

    public static /* synthetic */ long a(String str, long j2, long j3, long j4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j3 = 1;
        }
        long j5 = j3;
        if ((i2 & 8) != 0) {
            j4 = Long.MAX_VALUE;
        }
        return x.a(str, j2, j5, j4);
    }

    public static final boolean a(String str, boolean z2) {
        String a2 = x.a(str);
        return a2 != null ? Boolean.parseBoolean(a2) : z2;
    }
}
