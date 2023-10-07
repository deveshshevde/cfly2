package hm;

public class g extends e {
    public g(int i2) {
        super(i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x00a1, code lost:
        r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.HORIZONTAL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00ae, code lost:
        r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.VERTICAL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00b0, code lost:
        a(0, 3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r11 = this;
            int r0 = r11.f13366a
            r1 = 1048576000(0x3e800000, float:0.25)
            r2 = 1053609165(0x3ecccccd, float:0.4)
            r3 = 4
            r4 = 1061158912(0x3f400000, float:0.75)
            r5 = 2
            r6 = 1059760811(0x3f2aaaab, float:0.6666667)
            r7 = 1056964608(0x3f000000, float:0.5)
            r8 = 3
            r9 = 1
            r10 = 0
            switch(r0) {
                case 0: goto L_0x00a4;
                case 1: goto L_0x0097;
                case 2: goto L_0x008e;
                case 3: goto L_0x0080;
                case 4: goto L_0x0075;
                case 5: goto L_0x0060;
                case 6: goto L_0x004b;
                case 7: goto L_0x0029;
                case 8: goto L_0x0018;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x00b3
        L_0x0018:
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.HORIZONTAL
            r11.a((int) r10, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r1)
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.HORIZONTAL
            r11.a((int) r9, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r6)
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.VERTICAL
            r11.a((int) r5, (int) r8, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0)
            goto L_0x00ae
        L_0x0029:
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.VERTICAL
            r11.a((int) r10, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r1)
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.VERTICAL
            r11.a((int) r9, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r6)
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.HORIZONTAL
            r11.a((int) r5, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r7)
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.HORIZONTAL
            r11.a((int) r9, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r4)
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.HORIZONTAL
            r1 = 1051372203(0x3eaaaaab, float:0.33333334)
            r11.a((int) r9, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r1)
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.HORIZONTAL
            r11.a((int) r10, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r7)
            goto L_0x00b3
        L_0x004b:
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.VERTICAL
            r11.a((int) r10, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r6)
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.HORIZONTAL
            r11.a((int) r9, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r4)
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.VERTICAL
            r11.a((int) r10, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r7)
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.HORIZONTAL
            r11.a((int) r9, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r2)
            goto L_0x00a1
        L_0x0060:
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.HORIZONTAL
            r11.a((int) r10, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r6)
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.VERTICAL
            r11.a((int) r9, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r4)
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.HORIZONTAL
            r11.a((int) r10, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r7)
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.VERTICAL
            r11.a((int) r9, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r2)
            goto L_0x00ae
        L_0x0075:
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.VERTICAL
            r11.a((int) r10, (int) r8, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0)
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.HORIZONTAL
            r11.a((int) r5, (int) r8, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0)
            goto L_0x00a1
        L_0x0080:
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.HORIZONTAL
            r11.a((int) r10, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r6)
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.VERTICAL
            r11.a((int) r9, (int) r8, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0)
            r11.a(r10, r7)
            goto L_0x00b3
        L_0x008e:
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.HORIZONTAL
            r11.a((int) r10, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r7)
            r11.a((int) r9, (int) r9, (int) r5)
            goto L_0x00b3
        L_0x0097:
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.VERTICAL
            r11.a((int) r10, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r7)
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.HORIZONTAL
            r11.a((int) r9, (int) r3, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0)
        L_0x00a1:
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.HORIZONTAL
            goto L_0x00b0
        L_0x00a4:
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.HORIZONTAL
            r11.a((int) r10, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0, (float) r7)
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.VERTICAL
            r11.a((int) r9, (int) r3, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0)
        L_0x00ae:
            com.huantansheng.easyphotos.models.puzzle.Line$Direction r0 = com.huantansheng.easyphotos.models.puzzle.Line.Direction.VERTICAL
        L_0x00b0:
            r11.a((int) r10, (int) r8, (com.huantansheng.easyphotos.models.puzzle.Line.Direction) r0)
        L_0x00b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: hm.g.a():void");
    }

    public int i() {
        return 9;
    }
}
