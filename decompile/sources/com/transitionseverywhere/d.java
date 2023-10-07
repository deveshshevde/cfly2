package com.transitionseverywhere;

import android.graphics.Rect;
import android.view.ViewGroup;

public class d extends k {

    /* renamed from: a  reason: collision with root package name */
    private float f21910a = 3.0f;

    /* renamed from: b  reason: collision with root package name */
    private int f21911b = 80;

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000d, code lost:
        if (com.transitionseverywhere.utils.m.f(r5) != false) goto L_0x000f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        r0 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        if (com.transitionseverywhere.utils.m.f(r5) != false) goto L_0x0011;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(android.view.View r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13) {
        /*
            r4 = this;
            int r0 = r4.f21911b
            r1 = 5
            r2 = 3
            r3 = 8388611(0x800003, float:1.1754948E-38)
            if (r0 != r3) goto L_0x0013
            boolean r5 = com.transitionseverywhere.utils.m.f(r5)
            if (r5 == 0) goto L_0x0011
        L_0x000f:
            r0 = 5
            goto L_0x001f
        L_0x0011:
            r0 = 3
            goto L_0x001f
        L_0x0013:
            r3 = 8388613(0x800005, float:1.175495E-38)
            if (r0 != r3) goto L_0x001f
            boolean r5 = com.transitionseverywhere.utils.m.f(r5)
            if (r5 == 0) goto L_0x000f
            goto L_0x0011
        L_0x001f:
            r5 = 0
            if (r0 == r2) goto L_0x0045
            if (r0 == r1) goto L_0x003d
            r9 = 48
            if (r0 == r9) goto L_0x0035
            r9 = 80
            if (r0 == r9) goto L_0x002d
            goto L_0x004c
        L_0x002d:
            int r7 = r7 - r11
            int r8 = r8 - r6
            int r5 = java.lang.Math.abs(r8)
            int r5 = r5 + r7
            goto L_0x004c
        L_0x0035:
            int r13 = r13 - r7
            int r8 = r8 - r6
            int r5 = java.lang.Math.abs(r8)
            int r5 = r5 + r13
            goto L_0x004c
        L_0x003d:
            int r6 = r6 - r10
            int r9 = r9 - r7
            int r5 = java.lang.Math.abs(r9)
            int r5 = r5 + r6
            goto L_0x004c
        L_0x0045:
            int r12 = r12 - r6
            int r9 = r9 - r7
            int r5 = java.lang.Math.abs(r9)
            int r5 = r5 + r12
        L_0x004c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transitionseverywhere.d.a(android.view.View, int, int, int, int, int, int, int, int):int");
    }

    private int a(ViewGroup viewGroup) {
        int i2 = this.f21911b;
        return (i2 == 3 || i2 == 5 || i2 == 8388611 || i2 == 8388613) ? viewGroup.getWidth() : viewGroup.getHeight();
    }

    public long a(ViewGroup viewGroup, Transition transition, h hVar, h hVar2) {
        int i2;
        int i3;
        int i4;
        h hVar3 = hVar;
        if (hVar3 == null && hVar2 == null) {
            return 0;
        }
        Rect j2 = transition.j();
        if (hVar2 == null || b(hVar3) == 0) {
            i2 = -1;
        } else {
            hVar3 = hVar2;
            i2 = 1;
        }
        int c2 = c(hVar3);
        int d2 = d(hVar3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int round = iArr[0] + Math.round(viewGroup.getTranslationX());
        int round2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = round + viewGroup.getWidth();
        int height = round2 + viewGroup.getHeight();
        if (j2 != null) {
            i4 = j2.centerX();
            i3 = j2.centerY();
        } else {
            i4 = (round + width) / 2;
            i3 = (round2 + height) / 2;
        }
        float a2 = ((float) a(viewGroup, c2, d2, i4, i3, round, round2, width, height)) / ((float) a(viewGroup));
        long c3 = transition.c();
        if (c3 < 0) {
            c3 = 300;
        }
        return (long) Math.round((((float) (c3 * ((long) i2))) / this.f21910a) * a2);
    }

    public void a(int i2) {
        this.f21911b = i2;
    }
}
