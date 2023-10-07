package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import kotlin.jvm.internal.h;

public final class e {
    public static final StackTraceElement a(BaseContinuationImpl baseContinuationImpl) {
        String str;
        h.d(baseContinuationImpl, "$this$getStackTraceElementImpl");
        d b2 = b(baseContinuationImpl);
        if (b2 == null) {
            return null;
        }
        a(1, b2.a());
        int c2 = c(baseContinuationImpl);
        int i2 = c2 < 0 ? -1 : b2.c()[c2];
        String a2 = g.f30215b.a(baseContinuationImpl);
        if (a2 == null) {
            str = b2.e();
        } else {
            str = a2 + '/' + b2.e();
        }
        return new StackTraceElement(str, b2.d(), b2.b(), i2);
    }

    private static final void a(int i2, int i3) {
        if (i3 > i2) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i2 + ", got " + i3 + ". Please update the Kotlin standard library.").toString());
        }
    }

    private static final d b(BaseContinuationImpl baseContinuationImpl) {
        return (d) baseContinuationImpl.getClass().getAnnotation(d.class);
    }

    private static final int c(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            h.b(declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }
}
