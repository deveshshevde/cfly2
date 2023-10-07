package com.android.volley.toolbox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    protected static final Comparator<byte[]> f9957a = new Comparator<byte[]>() {
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private List<byte[]> f9958b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    private List<byte[]> f9959c = new ArrayList(64);

    /* renamed from: d  reason: collision with root package name */
    private int f9960d = 0;

    /* renamed from: e  reason: collision with root package name */
    private final int f9961e;

    public b(int i2) {
        this.f9961e = i2;
    }

    private synchronized void a() {
        while (this.f9960d > this.f9961e) {
            byte[] remove = this.f9958b.remove(0);
            this.f9959c.remove(remove);
            this.f9960d -= remove.length;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(byte[] r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x002e
            int r0 = r3.length     // Catch:{ all -> 0x002b }
            int r1 = r2.f9961e     // Catch:{ all -> 0x002b }
            if (r0 <= r1) goto L_0x0009
            goto L_0x002e
        L_0x0009:
            java.util.List<byte[]> r0 = r2.f9958b     // Catch:{ all -> 0x002b }
            r0.add(r3)     // Catch:{ all -> 0x002b }
            java.util.List<byte[]> r0 = r2.f9959c     // Catch:{ all -> 0x002b }
            java.util.Comparator<byte[]> r1 = f9957a     // Catch:{ all -> 0x002b }
            int r0 = java.util.Collections.binarySearch(r0, r3, r1)     // Catch:{ all -> 0x002b }
            if (r0 >= 0) goto L_0x001b
            int r0 = -r0
            int r0 = r0 + -1
        L_0x001b:
            java.util.List<byte[]> r1 = r2.f9959c     // Catch:{ all -> 0x002b }
            r1.add(r0, r3)     // Catch:{ all -> 0x002b }
            int r0 = r2.f9960d     // Catch:{ all -> 0x002b }
            int r3 = r3.length     // Catch:{ all -> 0x002b }
            int r0 = r0 + r3
            r2.f9960d = r0     // Catch:{ all -> 0x002b }
            r2.a()     // Catch:{ all -> 0x002b }
            monitor-exit(r2)
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x002e:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.b.a(byte[]):void");
    }

    public synchronized byte[] a(int i2) {
        for (int i3 = 0; i3 < this.f9959c.size(); i3++) {
            byte[] bArr = this.f9959c.get(i3);
            if (bArr.length >= i2) {
                this.f9960d -= bArr.length;
                this.f9959c.remove(i3);
                this.f9958b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i2];
    }
}
