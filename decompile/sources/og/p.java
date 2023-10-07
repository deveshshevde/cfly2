package og;

import org.jcodec.common.model.b;

public class p implements f {
    public void a(b bVar, b bVar2) {
        int[] a2 = bVar.a(0);
        int[] a3 = bVar.a(1);
        int[] a4 = bVar.a(2);
        int[] a5 = bVar2.a(0);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < bVar2.b(); i4++) {
            int i5 = 0;
            while (i5 < bVar2.a()) {
                g.a(a2[i2], a3[i2], a4[i2], a5, i3);
                i5++;
                i2++;
                i3 += 3;
            }
        }
    }
}
