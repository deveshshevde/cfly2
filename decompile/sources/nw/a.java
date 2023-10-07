package nw;

import org.jcodec.codecs.h264.c;

public class a {
    public static int a(od.a aVar) {
        int i2 = 0;
        while (aVar.b() == 0 && i2 < 31) {
            i2++;
        }
        if (i2 <= 0) {
            return 0;
        }
        return (int) (((long) ((1 << i2) - 1)) + ((long) aVar.a(i2)));
    }

    public static int a(od.a aVar, int i2, String str) {
        int a2 = aVar.a(i2);
        org.jcodec.common.tools.a.a(str, Integer.valueOf(a2));
        return a2;
    }

    public static int a(od.a aVar, String str) {
        int a2 = a(aVar);
        org.jcodec.common.tools.a.a(str, Integer.valueOf(a2));
        return a2;
    }

    public static int b(od.a aVar, String str) {
        int a2 = c.a(a(aVar));
        org.jcodec.common.tools.a.a(str, Integer.valueOf(a2));
        return a2;
    }

    public static boolean c(od.a aVar, String str) {
        boolean z2 = aVar.b() != 0;
        org.jcodec.common.tools.a.a(str, Integer.valueOf(z2 ? 1 : 0));
        return z2;
    }
}
