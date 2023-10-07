package nz;

import od.b;

public class a {
    public static void a(b bVar) {
        bVar.a(1);
        bVar.a();
    }

    public static void a(b bVar, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= 15) {
                i3 = 0;
                break;
            }
            int i5 = (1 << i3) + i4;
            if (i2 < i5) {
                break;
            }
            i3++;
            i4 = i5;
        }
        bVar.a(0, i3);
        bVar.a(1);
        bVar.a(i2 - i4, i3);
    }

    public static void a(b bVar, int i2, int i3) {
        bVar.a(i2, i3);
    }

    public static void a(b bVar, int i2, int i3, String str) {
        bVar.a(i2, i3);
        org.jcodec.common.tools.a.a(str, Integer.valueOf(i2));
    }

    public static void a(b bVar, int i2, String str) {
        a(bVar, i2);
        org.jcodec.common.tools.a.a(str, Integer.valueOf(i2));
    }

    public static void a(b bVar, long j2, int i2, String str) {
        for (int i3 = 0; i3 < i2; i3++) {
            bVar.a(1 & ((int) (j2 >> ((i2 - i3) - 1))));
        }
        org.jcodec.common.tools.a.a(str, Long.valueOf(j2));
    }

    public static void a(b bVar, boolean z2, String str) {
        bVar.a(z2 ? 1 : 0);
        org.jcodec.common.tools.a.a(str, Integer.valueOf(z2));
    }

    public static void b(b bVar, int i2) {
        a(bVar, org.jcodec.common.tools.b.b(i2));
    }

    public static void b(b bVar, int i2, String str) {
        a(bVar, org.jcodec.common.tools.b.b(i2));
        org.jcodec.common.tools.a.a(str, Integer.valueOf(i2));
    }
}
