package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;

class r {

    /* renamed from: a  reason: collision with root package name */
    final a f4312a;

    interface a {
        a.b a(int i2, int i3, int i4, Object obj);

        void a(a.b bVar);
    }

    r(a aVar) {
        this.f4312a = aVar;
    }

    private void a(List<a.b> list, int i2, int i3) {
        a.b bVar = list.get(i2);
        a.b bVar2 = list.get(i3);
        int i4 = bVar2.f4096a;
        if (i4 == 1) {
            c(list, i2, bVar, i3, bVar2);
        } else if (i4 == 2) {
            a(list, i2, bVar, i3, bVar2);
        } else if (i4 == 4) {
            b(list, i2, bVar, i3, bVar2);
        }
    }

    private int b(List<a.b> list) {
        boolean z2 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f4096a != 8) {
                z2 = true;
            } else if (z2) {
                return size;
            }
        }
        return -1;
    }

    private void c(List<a.b> list, int i2, a.b bVar, int i3, a.b bVar2) {
        int i4 = bVar.f4099d < bVar2.f4097b ? -1 : 0;
        if (bVar.f4097b < bVar2.f4097b) {
            i4++;
        }
        if (bVar2.f4097b <= bVar.f4097b) {
            bVar.f4097b += bVar2.f4099d;
        }
        if (bVar2.f4097b <= bVar.f4099d) {
            bVar.f4099d += bVar2.f4099d;
        }
        bVar2.f4097b += i4;
        list.set(i2, bVar2);
        list.set(i3, bVar);
    }

    /* access modifiers changed from: package-private */
    public void a(List<a.b> list) {
        while (true) {
            int b2 = b(list);
            if (b2 != -1) {
                a(list, b2, b2 + 1);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c6, code lost:
        if (r11.f4099d > r13.f4097b) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f6, code lost:
        if (r11.f4099d >= r13.f4097b) goto L_0x00f8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.List<androidx.recyclerview.widget.a.b> r9, int r10, androidx.recyclerview.widget.a.b r11, int r12, androidx.recyclerview.widget.a.b r13) {
        /*
            r8 = this;
            int r0 = r11.f4097b
            int r1 = r11.f4099d
            r2 = 0
            r3 = 1
            if (r0 >= r1) goto L_0x001b
            int r0 = r13.f4097b
            int r1 = r11.f4097b
            if (r0 != r1) goto L_0x0019
            int r0 = r13.f4099d
            int r1 = r11.f4099d
            int r4 = r11.f4097b
            int r1 = r1 - r4
            if (r0 != r1) goto L_0x0019
            r0 = 0
            goto L_0x002c
        L_0x0019:
            r0 = 0
            goto L_0x002f
        L_0x001b:
            int r0 = r13.f4097b
            int r1 = r11.f4099d
            int r1 = r1 + r3
            if (r0 != r1) goto L_0x002e
            int r0 = r13.f4099d
            int r1 = r11.f4097b
            int r4 = r11.f4099d
            int r1 = r1 - r4
            if (r0 != r1) goto L_0x002e
            r0 = 1
        L_0x002c:
            r2 = 1
            goto L_0x002f
        L_0x002e:
            r0 = 1
        L_0x002f:
            int r1 = r11.f4099d
            int r4 = r13.f4097b
            r5 = 2
            if (r1 >= r4) goto L_0x003c
            int r1 = r13.f4097b
            int r1 = r1 - r3
            r13.f4097b = r1
            goto L_0x005b
        L_0x003c:
            int r1 = r11.f4099d
            int r4 = r13.f4097b
            int r6 = r13.f4099d
            int r4 = r4 + r6
            if (r1 >= r4) goto L_0x005b
            int r10 = r13.f4099d
            int r10 = r10 - r3
            r13.f4099d = r10
            r11.f4096a = r5
            r11.f4099d = r3
            int r10 = r13.f4099d
            if (r10 != 0) goto L_0x005a
            r9.remove(r12)
            androidx.recyclerview.widget.r$a r9 = r8.f4312a
            r9.a(r13)
        L_0x005a:
            return
        L_0x005b:
            int r1 = r11.f4097b
            int r4 = r13.f4097b
            r6 = 0
            if (r1 > r4) goto L_0x0068
            int r1 = r13.f4097b
            int r1 = r1 + r3
            r13.f4097b = r1
            goto L_0x0089
        L_0x0068:
            int r1 = r11.f4097b
            int r4 = r13.f4097b
            int r7 = r13.f4099d
            int r4 = r4 + r7
            if (r1 >= r4) goto L_0x0089
            int r1 = r13.f4097b
            int r4 = r13.f4099d
            int r1 = r1 + r4
            int r4 = r11.f4097b
            int r1 = r1 - r4
            androidx.recyclerview.widget.r$a r4 = r8.f4312a
            int r7 = r11.f4097b
            int r7 = r7 + r3
            androidx.recyclerview.widget.a$b r6 = r4.a(r5, r7, r1, r6)
            int r1 = r11.f4097b
            int r3 = r13.f4097b
            int r1 = r1 - r3
            r13.f4099d = r1
        L_0x0089:
            if (r2 == 0) goto L_0x0097
            r9.set(r10, r13)
            r9.remove(r12)
            androidx.recyclerview.widget.r$a r9 = r8.f4312a
            r9.a(r11)
            return
        L_0x0097:
            if (r0 == 0) goto L_0x00c9
            if (r6 == 0) goto L_0x00b5
            int r0 = r11.f4097b
            int r1 = r6.f4097b
            if (r0 <= r1) goto L_0x00a8
            int r0 = r11.f4097b
            int r1 = r6.f4099d
            int r0 = r0 - r1
            r11.f4097b = r0
        L_0x00a8:
            int r0 = r11.f4099d
            int r1 = r6.f4097b
            if (r0 <= r1) goto L_0x00b5
            int r0 = r11.f4099d
            int r1 = r6.f4099d
            int r0 = r0 - r1
            r11.f4099d = r0
        L_0x00b5:
            int r0 = r11.f4097b
            int r1 = r13.f4097b
            if (r0 <= r1) goto L_0x00c2
            int r0 = r11.f4097b
            int r1 = r13.f4099d
            int r0 = r0 - r1
            r11.f4097b = r0
        L_0x00c2:
            int r0 = r11.f4099d
            int r1 = r13.f4097b
            if (r0 <= r1) goto L_0x00ff
            goto L_0x00f8
        L_0x00c9:
            if (r6 == 0) goto L_0x00e5
            int r0 = r11.f4097b
            int r1 = r6.f4097b
            if (r0 < r1) goto L_0x00d8
            int r0 = r11.f4097b
            int r1 = r6.f4099d
            int r0 = r0 - r1
            r11.f4097b = r0
        L_0x00d8:
            int r0 = r11.f4099d
            int r1 = r6.f4097b
            if (r0 < r1) goto L_0x00e5
            int r0 = r11.f4099d
            int r1 = r6.f4099d
            int r0 = r0 - r1
            r11.f4099d = r0
        L_0x00e5:
            int r0 = r11.f4097b
            int r1 = r13.f4097b
            if (r0 < r1) goto L_0x00f2
            int r0 = r11.f4097b
            int r1 = r13.f4099d
            int r0 = r0 - r1
            r11.f4097b = r0
        L_0x00f2:
            int r0 = r11.f4099d
            int r1 = r13.f4097b
            if (r0 < r1) goto L_0x00ff
        L_0x00f8:
            int r0 = r11.f4099d
            int r1 = r13.f4099d
            int r0 = r0 - r1
            r11.f4099d = r0
        L_0x00ff:
            r9.set(r10, r13)
            int r13 = r11.f4097b
            int r0 = r11.f4099d
            if (r13 == r0) goto L_0x010c
            r9.set(r12, r11)
            goto L_0x010f
        L_0x010c:
            r9.remove(r12)
        L_0x010f:
            if (r6 == 0) goto L_0x0114
            r9.add(r10, r6)
        L_0x0114:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.r.a(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.util.List<androidx.recyclerview.widget.a.b> r8, int r9, androidx.recyclerview.widget.a.b r10, int r11, androidx.recyclerview.widget.a.b r12) {
        /*
            r7 = this;
            int r0 = r10.f4099d
            int r1 = r12.f4097b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto L_0x000f
            int r0 = r12.f4097b
            int r0 = r0 - r4
            r12.f4097b = r0
            goto L_0x0028
        L_0x000f:
            int r0 = r10.f4099d
            int r1 = r12.f4097b
            int r5 = r12.f4099d
            int r1 = r1 + r5
            if (r0 >= r1) goto L_0x0028
            int r0 = r12.f4099d
            int r0 = r0 - r4
            r12.f4099d = r0
            androidx.recyclerview.widget.r$a r0 = r7.f4312a
            int r1 = r10.f4097b
            java.lang.Object r5 = r12.f4098c
            androidx.recyclerview.widget.a$b r0 = r0.a(r2, r1, r4, r5)
            goto L_0x0029
        L_0x0028:
            r0 = r3
        L_0x0029:
            int r1 = r10.f4097b
            int r5 = r12.f4097b
            if (r1 > r5) goto L_0x0035
            int r1 = r12.f4097b
            int r1 = r1 + r4
            r12.f4097b = r1
            goto L_0x0056
        L_0x0035:
            int r1 = r10.f4097b
            int r5 = r12.f4097b
            int r6 = r12.f4099d
            int r5 = r5 + r6
            if (r1 >= r5) goto L_0x0056
            int r1 = r12.f4097b
            int r3 = r12.f4099d
            int r1 = r1 + r3
            int r3 = r10.f4097b
            int r1 = r1 - r3
            androidx.recyclerview.widget.r$a r3 = r7.f4312a
            int r5 = r10.f4097b
            int r5 = r5 + r4
            java.lang.Object r4 = r12.f4098c
            androidx.recyclerview.widget.a$b r3 = r3.a(r2, r5, r1, r4)
            int r2 = r12.f4099d
            int r2 = r2 - r1
            r12.f4099d = r2
        L_0x0056:
            r8.set(r11, r10)
            int r10 = r12.f4099d
            if (r10 <= 0) goto L_0x0061
            r8.set(r9, r12)
            goto L_0x0069
        L_0x0061:
            r8.remove(r9)
            androidx.recyclerview.widget.r$a r10 = r7.f4312a
            r10.a(r12)
        L_0x0069:
            if (r0 == 0) goto L_0x006e
            r8.add(r9, r0)
        L_0x006e:
            if (r3 == 0) goto L_0x0073
            r8.add(r9, r3)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.r.b(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }
}
