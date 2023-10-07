package com.google.android.exoplayer2.audio;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.q;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoView;
import com.xeagle.android.login.retrofitLogin.CameraGlobal;
import java.nio.ByteBuffer;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f15261a = {CameraGlobal.GET_DEVICE_INFO, GSYVideoView.CHANGE_DELAY_TIME, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH, 400, 400, 2048};

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f15262a;

        /* renamed from: b  reason: collision with root package name */
        public final int f15263b;

        /* renamed from: c  reason: collision with root package name */
        public final int f15264c;

        /* renamed from: d  reason: collision with root package name */
        public final int f15265d;

        /* renamed from: e  reason: collision with root package name */
        public final int f15266e;

        private a(int i2, int i3, int i4, int i5, int i6) {
            this.f15262a = i2;
            this.f15264c = i3;
            this.f15263b = i4;
            this.f15265d = i5;
            this.f15266e = i6;
        }
    }

    private static int a(p pVar, int i2) {
        int i3 = 0;
        while (true) {
            int c2 = i3 + pVar.c(i2);
            if (!pVar.e()) {
                return c2;
            }
            i3 = (c2 + 1) << i2;
        }
    }

    public static int a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int position = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        return a(new p(bArr)).f15266e;
    }

    public static int a(byte[] bArr, int i2) {
        int i3 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        byte b2 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (b2 == 65535) {
            b2 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i3 = 4;
        }
        if (i2 == 44097) {
            i3 += 2;
        }
        return b2 + i3;
    }

    public static Format a(q qVar, String str, String str2, DrmInitData drmInitData) {
        qVar.d(1);
        return Format.a(str, "audio/ac4", (String) null, -1, -1, 2, ((qVar.h() & 32) >> 5) == 1 ? 48000 : 44100, (List<byte[]>) null, drmInitData, 0, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0086, code lost:
        if (r10 != 11) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008b, code lost:
        if (r10 != 11) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0090, code lost:
        if (r10 != 8) goto L_0x0093;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.audio.b.a a(com.google.android.exoplayer2.util.p r10) {
        /*
            r0 = 16
            int r1 = r10.c(r0)
            int r0 = r10.c(r0)
            r2 = 4
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r0 != r3) goto L_0x0018
            r0 = 24
            int r0 = r10.c(r0)
            r3 = 7
            goto L_0x0019
        L_0x0018:
            r3 = 4
        L_0x0019:
            int r0 = r0 + r3
            r3 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r3) goto L_0x0021
            int r0 = r0 + 2
        L_0x0021:
            r7 = r0
            r0 = 2
            int r1 = r10.c(r0)
            r3 = 3
            if (r1 != r3) goto L_0x002f
            int r4 = a((com.google.android.exoplayer2.util.p) r10, (int) r0)
            int r1 = r1 + r4
        L_0x002f:
            r4 = r1
            r1 = 10
            int r1 = r10.c(r1)
            boolean r5 = r10.e()
            if (r5 == 0) goto L_0x0045
            int r5 = r10.c(r3)
            if (r5 <= 0) goto L_0x0045
            r10.b(r0)
        L_0x0045:
            boolean r5 = r10.e()
            r6 = 48000(0xbb80, float:6.7262E-41)
            r8 = 44100(0xac44, float:6.1797E-41)
            if (r5 == 0) goto L_0x0055
            r9 = 48000(0xbb80, float:6.7262E-41)
            goto L_0x0058
        L_0x0055:
            r9 = 44100(0xac44, float:6.1797E-41)
        L_0x0058:
            int r10 = r10.c(r2)
            r5 = 0
            if (r9 != r8) goto L_0x0069
            r8 = 13
            if (r10 != r8) goto L_0x0069
            int[] r0 = f15261a
            r10 = r0[r10]
            r8 = r10
            goto L_0x0099
        L_0x0069:
            if (r9 != r6) goto L_0x0098
            int[] r6 = f15261a
            int r8 = r6.length
            if (r10 >= r8) goto L_0x0098
            r5 = r6[r10]
            int r1 = r1 % 5
            r6 = 8
            r8 = 1
            if (r1 == r8) goto L_0x008e
            r8 = 11
            if (r1 == r0) goto L_0x0089
            if (r1 == r3) goto L_0x008e
            if (r1 == r2) goto L_0x0082
            goto L_0x0093
        L_0x0082:
            if (r10 == r3) goto L_0x0095
            if (r10 == r6) goto L_0x0095
            if (r10 != r8) goto L_0x0093
            goto L_0x0095
        L_0x0089:
            if (r10 == r6) goto L_0x0095
            if (r10 != r8) goto L_0x0093
            goto L_0x0095
        L_0x008e:
            if (r10 == r3) goto L_0x0095
            if (r10 != r6) goto L_0x0093
            goto L_0x0095
        L_0x0093:
            r8 = r5
            goto L_0x0099
        L_0x0095:
            int r5 = r5 + 1
            goto L_0x0093
        L_0x0098:
            r8 = 0
        L_0x0099:
            com.google.android.exoplayer2.audio.b$a r10 = new com.google.android.exoplayer2.audio.b$a
            r5 = 2
            r0 = 0
            r3 = r10
            r6 = r9
            r9 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.b.a(com.google.android.exoplayer2.util.p):com.google.android.exoplayer2.audio.b$a");
    }

    public static void a(int i2, q qVar) {
        qVar.a(7);
        qVar.f17159a[0] = -84;
        qVar.f17159a[1] = 64;
        qVar.f17159a[2] = -1;
        qVar.f17159a[3] = -1;
        qVar.f17159a[4] = (byte) ((i2 >> 16) & 255);
        qVar.f17159a[5] = (byte) ((i2 >> 8) & 255);
        qVar.f17159a[6] = (byte) (i2 & 255);
    }
}
