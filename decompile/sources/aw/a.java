package aw;

import android.graphics.Color;
import java.util.Arrays;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.l;

public final class a {
    public static final Integer a(String str) {
        h.c(str, "$this$toColor");
        try {
            return Integer.valueOf(Color.parseColor('#' + str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String a(int i2, boolean z2) {
        if (i2 == 0) {
            return z2 ? "00000000" : "000000";
        }
        if (z2) {
            String hexString = Integer.toHexString(i2);
            h.a((Object) hexString, "Integer.toHexString(this)");
            if (hexString.length() != 6) {
                return hexString;
            }
            return "00" + hexString;
        }
        l lVar = l.f30252a;
        String format = String.format("%06X", Arrays.copyOf(new Object[]{Integer.valueOf(i2 & 16777215)}, 1));
        h.a((Object) format, "java.lang.String.format(format, *args)");
        return format;
    }
}
