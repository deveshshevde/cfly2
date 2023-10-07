package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public class s extends aq {

    /* renamed from: a  reason: collision with root package name */
    private float f4860a = 3.0f;

    /* renamed from: b  reason: collision with root package name */
    private int f4861b = 80;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        if (r4 != false) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        if (r4 != false) goto L_0x0015;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r0 = 3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(android.view.View r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15) {
        /*
            r6 = this;
            int r0 = r6.f4861b
            r1 = 5
            r2 = 3
            r3 = 0
            r4 = 1
            r5 = 8388611(0x800003, float:1.1754948E-38)
            if (r0 != r5) goto L_0x0019
            int r7 = t.ac.i(r7)
            if (r7 != r4) goto L_0x0012
            goto L_0x0013
        L_0x0012:
            r4 = 0
        L_0x0013:
            if (r4 == 0) goto L_0x0017
        L_0x0015:
            r0 = 5
            goto L_0x0029
        L_0x0017:
            r0 = 3
            goto L_0x0029
        L_0x0019:
            r5 = 8388613(0x800005, float:1.175495E-38)
            if (r0 != r5) goto L_0x0029
            int r7 = t.ac.i(r7)
            if (r7 != r4) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r4 = 0
        L_0x0026:
            if (r4 == 0) goto L_0x0015
            goto L_0x0017
        L_0x0029:
            if (r0 == r2) goto L_0x0051
            if (r0 == r1) goto L_0x0048
            r7 = 48
            if (r0 == r7) goto L_0x003f
            r7 = 80
            if (r0 == r7) goto L_0x0036
            goto L_0x0059
        L_0x0036:
            int r9 = r9 - r13
            int r10 = r10 - r8
            int r7 = java.lang.Math.abs(r10)
            int r3 = r9 + r7
            goto L_0x0059
        L_0x003f:
            int r15 = r15 - r9
            int r10 = r10 - r8
            int r7 = java.lang.Math.abs(r10)
            int r3 = r15 + r7
            goto L_0x0059
        L_0x0048:
            int r8 = r8 - r12
            int r11 = r11 - r9
            int r7 = java.lang.Math.abs(r11)
            int r3 = r8 + r7
            goto L_0x0059
        L_0x0051:
            int r14 = r14 - r8
            int r11 = r11 - r9
            int r7 = java.lang.Math.abs(r11)
            int r3 = r14 + r7
        L_0x0059:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.s.a(android.view.View, int, int, int, int, int, int, int, int):int");
    }

    private int a(ViewGroup viewGroup) {
        int i2 = this.f4861b;
        return (i2 == 3 || i2 == 5 || i2 == 8388611 || i2 == 8388613) ? viewGroup.getWidth() : viewGroup.getHeight();
    }

    public long a(ViewGroup viewGroup, Transition transition, y yVar, y yVar2) {
        int i2;
        int i3;
        int i4;
        y yVar3 = yVar;
        if (yVar3 == null && yVar2 == null) {
            return 0;
        }
        Rect o2 = transition.o();
        if (yVar2 == null || b(yVar3) == 0) {
            i2 = -1;
        } else {
            yVar3 = yVar2;
            i2 = 1;
        }
        int c2 = c(yVar3);
        int d2 = d(yVar3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int round = iArr[0] + Math.round(viewGroup.getTranslationX());
        int round2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = round + viewGroup.getWidth();
        int height = round2 + viewGroup.getHeight();
        if (o2 != null) {
            i4 = o2.centerX();
            i3 = o2.centerY();
        } else {
            i4 = (round + width) / 2;
            i3 = (round2 + height) / 2;
        }
        float a2 = ((float) a(viewGroup, c2, d2, i4, i3, round, round2, width, height)) / ((float) a(viewGroup));
        long b2 = transition.b();
        if (b2 < 0) {
            b2 = 300;
        }
        return (long) Math.round((((float) (b2 * ((long) i2))) / this.f4860a) * a2);
    }

    public void a(int i2) {
        this.f4861b = i2;
    }
}
