package og;

import org.jcodec.common.model.b;

public class k implements f {
    public void a(b bVar, b bVar2) {
        int[] a2 = bVar.a(0);
        int[] a3 = bVar.a(1);
        int[] a4 = bVar.a(2);
        int[] a5 = bVar2.a(0);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < bVar2.b(); i4++) {
            for (int i5 = 0; i5 < bVar2.a(); i5 += 2) {
                g.a(a2[i2], a3[i3], a4[i3], a5, i2 * 3);
                int i6 = i2 + 1;
                g.a(a2[i6], a3[i3], a4[i3], a5, i6 * 3);
                i2 += 2;
                i3++;
            }
        }
    }
}
