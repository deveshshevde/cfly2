package og;

import org.jcodec.common.model.b;

public class h implements f {

    /* renamed from: a  reason: collision with root package name */
    public static int f31740a = 7168;

    public void a(b bVar, b bVar2) {
        int[] a2 = bVar.a(0);
        int[] a3 = bVar2.a(0);
        for (int i2 = 0; i2 < bVar.b(0) * bVar.c(0); i2++) {
            a3[i2] = ((a2[i2] * f31740a) >> 13) + 16;
        }
        int[] a4 = bVar.a(1);
        int[] a5 = bVar2.a(1);
        for (int i3 = 0; i3 < bVar.b(1) * bVar.c(1); i3++) {
            a5[i3] = (((a4[i3] - 128) * f31740a) >> 13) + 128;
        }
        int[] a6 = bVar.a(2);
        int[] a7 = bVar2.a(2);
        for (int i4 = 0; i4 < bVar.b(2) * bVar.c(2); i4++) {
            a7[i4] = (((a6[i4] - 128) * f31740a) >> 13) + 128;
        }
    }
}
