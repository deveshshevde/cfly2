package com.google.android.exoplayer2.audio;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.q;
import java.nio.ByteBuffer;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f15249a = {1, 2, 3, 6};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f15250b = {48000, 44100, 32000};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f15251c = {24000, 22050, 16000};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f15252d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f15253e = {32, 40, 48, 56, 64, 80, 96, 112, 128, GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 192, 224, 256, GlMapUtil.DEVICE_DISPLAY_DPI_HIGH, 384, 448, 512, 576, GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f15254f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* renamed from: com.google.android.exoplayer2.audio.a$a  reason: collision with other inner class name */
    public static final class C0108a {

        /* renamed from: a  reason: collision with root package name */
        public final String f15255a;

        /* renamed from: b  reason: collision with root package name */
        public final int f15256b;

        /* renamed from: c  reason: collision with root package name */
        public final int f15257c;

        /* renamed from: d  reason: collision with root package name */
        public final int f15258d;

        /* renamed from: e  reason: collision with root package name */
        public final int f15259e;

        /* renamed from: f  reason: collision with root package name */
        public final int f15260f;

        private C0108a(String str, int i2, int i3, int i4, int i5, int i6) {
            this.f15255a = str;
            this.f15256b = i2;
            this.f15258d = i3;
            this.f15257c = i4;
            this.f15259e = i5;
            this.f15260f = i6;
        }
    }

    private static int a(int i2, int i3) {
        int i4 = i3 / 2;
        if (i2 < 0) {
            return -1;
        }
        int[] iArr = f15250b;
        if (i2 >= iArr.length || i3 < 0) {
            return -1;
        }
        int[] iArr2 = f15254f;
        if (i4 >= iArr2.length) {
            return -1;
        }
        int i5 = iArr[i2];
        if (i5 == 44100) {
            return (iArr2[i4] + (i3 % 2)) * 2;
        }
        int i6 = f15253e[i4];
        return i5 == 32000 ? i6 * 6 : i6 * 4;
    }

    public static int a(ByteBuffer byteBuffer) {
        int i2 = 3;
        if (!(((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10)) {
            return 1536;
        }
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i2 = (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4;
        }
        return f15249a[i2] * 256;
    }

    public static int a(ByteBuffer byteBuffer, int i2) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i2) + ((byteBuffer.get((byteBuffer.position() + i2) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    public static int a(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (!(((bArr[5] & 248) >> 3) > 10)) {
            return a((bArr[4] & 192) >> 6, (int) bArr[4] & 63);
        }
        return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
    }

    public static Format a(q qVar, String str, String str2, DrmInitData drmInitData) {
        int i2 = f15250b[(qVar.h() & 192) >> 6];
        int h2 = qVar.h();
        int i3 = f15252d[(h2 & 56) >> 3];
        if ((h2 & 4) != 0) {
            i3++;
        }
        return Format.a(str, "audio/ac3", (String) null, -1, -1, i3, i2, (List<byte[]>) null, drmInitData, 0, str2);
    }

    public static C0108a a(p pVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        p pVar2 = pVar;
        int b2 = pVar.b();
        pVar2.b(40);
        boolean z2 = pVar2.c(5) > 10;
        pVar2.a(b2);
        int i13 = -1;
        if (z2) {
            pVar2.b(16);
            int c2 = pVar2.c(2);
            if (c2 == 0) {
                i13 = 0;
            } else if (c2 == 1) {
                i13 = 1;
            } else if (c2 == 2) {
                i13 = 2;
            }
            pVar2.b(3);
            int c3 = (pVar2.c(11) + 1) * 2;
            int c4 = pVar2.c(2);
            if (c4 == 3) {
                i7 = f15251c[pVar2.c(2)];
                i9 = 3;
                i8 = 6;
            } else {
                i9 = pVar2.c(2);
                i8 = f15249a[i9];
                i7 = f15250b[c4];
            }
            int i14 = i8 * 256;
            int c5 = pVar2.c(3);
            boolean e2 = pVar.e();
            int i15 = f15252d[c5] + (e2 ? 1 : 0);
            pVar2.b(10);
            if (pVar.e()) {
                pVar2.b(8);
            }
            if (c5 == 0) {
                pVar2.b(5);
                if (pVar.e()) {
                    pVar2.b(8);
                }
            }
            if (i13 == 1 && pVar.e()) {
                pVar2.b(16);
            }
            if (pVar.e()) {
                if (c5 > 2) {
                    pVar2.b(2);
                }
                if ((c5 & 1) == 0 || c5 <= 2) {
                    i11 = 6;
                } else {
                    i11 = 6;
                    pVar2.b(6);
                }
                if ((c5 & 4) != 0) {
                    pVar2.b(i11);
                }
                if (e2 && pVar.e()) {
                    pVar2.b(5);
                }
                if (i13 == 0) {
                    if (pVar.e()) {
                        i12 = 6;
                        pVar2.b(6);
                    } else {
                        i12 = 6;
                    }
                    if (c5 == 0 && pVar.e()) {
                        pVar2.b(i12);
                    }
                    if (pVar.e()) {
                        pVar2.b(i12);
                    }
                    int c6 = pVar2.c(2);
                    if (c6 == 1) {
                        pVar2.b(5);
                    } else if (c6 == 2) {
                        pVar2.b(12);
                    } else if (c6 == 3) {
                        int c7 = pVar2.c(5);
                        if (pVar.e()) {
                            pVar2.b(5);
                            if (pVar.e()) {
                                pVar2.b(4);
                            }
                            if (pVar.e()) {
                                pVar2.b(4);
                            }
                            if (pVar.e()) {
                                pVar2.b(4);
                            }
                            if (pVar.e()) {
                                pVar2.b(4);
                            }
                            if (pVar.e()) {
                                pVar2.b(4);
                            }
                            if (pVar.e()) {
                                pVar2.b(4);
                            }
                            if (pVar.e()) {
                                pVar2.b(4);
                            }
                            if (pVar.e()) {
                                if (pVar.e()) {
                                    pVar2.b(4);
                                }
                                if (pVar.e()) {
                                    pVar2.b(4);
                                }
                            }
                        }
                        if (pVar.e()) {
                            pVar2.b(5);
                            if (pVar.e()) {
                                pVar2.b(7);
                                if (pVar.e()) {
                                    pVar2.b(8);
                                }
                            }
                        }
                        pVar2.b((c7 + 2) * 8);
                        pVar.f();
                    }
                    if (c5 < 2) {
                        if (pVar.e()) {
                            pVar2.b(14);
                        }
                        if (c5 == 0 && pVar.e()) {
                            pVar2.b(14);
                        }
                    }
                    if (pVar.e()) {
                        if (i9 == 0) {
                            pVar2.b(5);
                        } else {
                            for (int i16 = 0; i16 < i8; i16++) {
                                if (pVar.e()) {
                                    pVar2.b(5);
                                }
                            }
                        }
                    }
                }
            }
            if (pVar.e()) {
                pVar2.b(5);
                if (c5 == 2) {
                    pVar2.b(4);
                }
                if (c5 >= 6) {
                    pVar2.b(2);
                }
                if (pVar.e()) {
                    pVar2.b(8);
                }
                if (c5 == 0 && pVar.e()) {
                    pVar2.b(8);
                }
                if (c4 < 3) {
                    pVar.d();
                }
            }
            if (i13 == 0 && i9 != 3) {
                pVar.d();
            }
            if (i13 != 2 || (i9 != 3 && !pVar.e())) {
                i10 = 6;
            } else {
                i10 = 6;
                pVar2.b(6);
            }
            str = (pVar.e() && pVar2.c(i10) == 1 && pVar2.c(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i6 = i13;
            i2 = i14;
            i3 = c3;
            i4 = i7;
            i5 = i15;
        } else {
            pVar2.b(32);
            int c8 = pVar2.c(2);
            String str2 = c8 == 3 ? null : "audio/ac3";
            int a2 = a(c8, pVar2.c(6));
            pVar2.b(8);
            int c9 = pVar2.c(3);
            if (!((c9 & 1) == 0 || c9 == 1)) {
                pVar2.b(2);
            }
            if ((c9 & 4) != 0) {
                pVar2.b(2);
            }
            if (c9 == 2) {
                pVar2.b(2);
            }
            int[] iArr = f15250b;
            str = str2;
            i3 = a2;
            i4 = c8 < iArr.length ? iArr[c8] : -1;
            i5 = f15252d[c9] + (pVar.e() ? 1 : 0);
            i6 = -1;
            i2 = 1536;
        }
        return new C0108a(str, i6, i5, i4, i3, i2);
    }

    public static int b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 10;
        for (int i2 = position; i2 <= limit; i2++) {
            if ((byteBuffer.getInt(i2 + 4) & -16777217) == -1167101192) {
                return i2 - position;
            }
        }
        return -1;
    }

    public static int b(byte[] bArr) {
        boolean z2 = false;
        if (bArr[4] != -8 || bArr[5] != 114 || bArr[6] != 111 || (bArr[7] & 254) != 186) {
            return 0;
        }
        if ((bArr[7] & 255) == 187) {
            z2 = true;
        }
        return 40 << ((bArr[z2 ? (char) 9 : 8] >> 4) & 7);
    }

    public static Format b(q qVar, String str, String str2, DrmInitData drmInitData) {
        q qVar2 = qVar;
        qVar.d(2);
        int i2 = f15250b[(qVar.h() & 192) >> 6];
        int h2 = qVar.h();
        int i3 = f15252d[(h2 & 14) >> 1];
        if ((h2 & 1) != 0) {
            i3++;
        }
        if (((qVar.h() & 30) >> 1) > 0 && (2 & qVar.h()) != 0) {
            i3 += 2;
        }
        return Format.a(str, (qVar.b() <= 0 || (qVar.h() & 1) == 0) ? "audio/eac3" : "audio/eac3-joc", (String) null, -1, -1, i3, i2, (List<byte[]>) null, drmInitData, 0, str2);
    }
}
