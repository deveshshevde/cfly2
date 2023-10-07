package bj;

import android.graphics.Bitmap;
import bj.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5714a = "e";

    /* renamed from: b  reason: collision with root package name */
    private int[] f5715b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f5716c;

    /* renamed from: d  reason: collision with root package name */
    private final a.C0050a f5717d;

    /* renamed from: e  reason: collision with root package name */
    private ByteBuffer f5718e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f5719f;

    /* renamed from: g  reason: collision with root package name */
    private short[] f5720g;

    /* renamed from: h  reason: collision with root package name */
    private byte[] f5721h;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f5722i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f5723j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f5724k;

    /* renamed from: l  reason: collision with root package name */
    private int f5725l;

    /* renamed from: m  reason: collision with root package name */
    private c f5726m;

    /* renamed from: n  reason: collision with root package name */
    private Bitmap f5727n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f5728o;

    /* renamed from: p  reason: collision with root package name */
    private int f5729p;

    /* renamed from: q  reason: collision with root package name */
    private int f5730q;

    /* renamed from: r  reason: collision with root package name */
    private int f5731r;

    /* renamed from: s  reason: collision with root package name */
    private int f5732s;

    /* renamed from: t  reason: collision with root package name */
    private Boolean f5733t;

    /* renamed from: u  reason: collision with root package name */
    private Bitmap.Config f5734u;

    public e(a.C0050a aVar) {
        this.f5716c = new int[256];
        this.f5734u = Bitmap.Config.ARGB_8888;
        this.f5717d = aVar;
        this.f5726m = new c();
    }

    public e(a.C0050a aVar, c cVar, ByteBuffer byteBuffer, int i2) {
        this(aVar);
        a(cVar, byteBuffer, i2);
    }

    private int a(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.f5730q + i2; i10++) {
            byte[] bArr = this.f5723j;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.f5715b[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.f5730q + i12; i13++) {
            byte[] bArr2 = this.f5723j;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.f5715b[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    private Bitmap a(b bVar, b bVar2) {
        Bitmap bitmap;
        int[] iArr = this.f5724k;
        int i2 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.f5727n;
            if (bitmap2 != null) {
                this.f5717d.a(bitmap2);
            }
            this.f5727n = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f5692g == 3 && this.f5727n == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f5692g > 0) {
            if (bVar2.f5692g == 2) {
                if (!bVar.f5691f) {
                    int i3 = this.f5726m.f5708l;
                    if (bVar.f5696k == null || this.f5726m.f5706j != bVar.f5693h) {
                        i2 = i3;
                    }
                }
                int i4 = bVar2.f5689d / this.f5730q;
                int i5 = bVar2.f5687b / this.f5730q;
                int i6 = bVar2.f5688c / this.f5730q;
                int i7 = bVar2.f5686a / this.f5730q;
                int i8 = this.f5732s;
                int i9 = (i5 * i8) + i7;
                int i10 = (i4 * i8) + i9;
                while (i9 < i10) {
                    int i11 = i9 + i6;
                    for (int i12 = i9; i12 < i11; i12++) {
                        iArr[i12] = i2;
                    }
                    i9 += this.f5732s;
                }
            } else if (bVar2.f5692g == 3 && (bitmap = this.f5727n) != null) {
                int i13 = this.f5732s;
                bitmap.getPixels(iArr, 0, i13, 0, 0, i13, this.f5731r);
            }
        }
        c(bVar);
        if (bVar.f5690e || this.f5730q != 1) {
            b(bVar);
        } else {
            a(bVar);
        }
        if (this.f5728o && (bVar.f5692g == 0 || bVar.f5692g == 1)) {
            if (this.f5727n == null) {
                this.f5727n = l();
            }
            Bitmap bitmap3 = this.f5727n;
            int i14 = this.f5732s;
            bitmap3.setPixels(iArr, 0, i14, 0, 0, i14, this.f5731r);
        }
        Bitmap l2 = l();
        int i15 = this.f5732s;
        l2.setPixels(iArr, 0, i15, 0, 0, i15, this.f5731r);
        return l2;
    }

    private void a(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.f5724k;
        int i2 = bVar2.f5689d;
        int i3 = bVar2.f5687b;
        int i4 = bVar2.f5688c;
        int i5 = bVar2.f5686a;
        boolean z2 = this.f5725l == 0;
        int i6 = this.f5732s;
        byte[] bArr = this.f5723j;
        int[] iArr2 = this.f5715b;
        int i7 = 0;
        byte b2 = -1;
        while (i7 < i2) {
            int i8 = (i7 + i3) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            int i12 = bVar2.f5688c * i7;
            int i13 = i9;
            while (i13 < i10) {
                byte b3 = bArr[i12];
                int i14 = i2;
                byte b4 = b3 & 255;
                if (b4 != b2) {
                    int i15 = iArr2[b4];
                    if (i15 != 0) {
                        iArr[i13] = i15;
                    } else {
                        b2 = b3;
                    }
                }
                i12++;
                i13++;
                b bVar3 = bVar;
                i2 = i14;
            }
            int i16 = i2;
            i7++;
            bVar2 = bVar;
        }
        Boolean bool = this.f5733t;
        this.f5733t = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.f5733t == null && z2 && b2 != -1));
    }

    private void b(b bVar) {
        Boolean bool;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        b bVar2 = bVar;
        int[] iArr = this.f5724k;
        int i7 = bVar2.f5689d / this.f5730q;
        int i8 = bVar2.f5687b / this.f5730q;
        int i9 = bVar2.f5688c / this.f5730q;
        int i10 = bVar2.f5686a;
        int i11 = this.f5730q;
        int i12 = i10 / i11;
        boolean z2 = this.f5725l == 0;
        int i13 = this.f5732s;
        int i14 = this.f5731r;
        byte[] bArr = this.f5723j;
        int[] iArr2 = this.f5715b;
        Boolean bool2 = this.f5733t;
        int i15 = 8;
        int i16 = 0;
        int i17 = 0;
        int i18 = 1;
        while (true) {
            bool = bool2;
            if (i16 >= i7) {
                break;
            }
            if (bVar2.f5690e) {
                if (i17 >= i7) {
                    i2 = i7;
                    int i19 = i18 + 1;
                    if (i19 == 2) {
                        i18 = i19;
                        i17 = 4;
                    } else if (i19 != 3) {
                        i18 = i19;
                        if (i19 == 4) {
                            i17 = 1;
                            i15 = 2;
                        }
                    } else {
                        i18 = i19;
                        i17 = 2;
                        i15 = 4;
                    }
                } else {
                    i2 = i7;
                }
                i3 = i17 + i15;
            } else {
                i2 = i7;
                i3 = i17;
                i17 = i16;
            }
            int i20 = i17 + i8;
            boolean z3 = i11 == 1;
            if (i20 < i14) {
                int i21 = i20 * i13;
                int i22 = i21 + i12;
                int i23 = i22 + i9;
                int i24 = i21 + i13;
                if (i24 < i23) {
                    i23 = i24;
                }
                i4 = i3;
                int i25 = i16 * i11 * bVar2.f5688c;
                if (z3) {
                    int i26 = i22;
                    while (true) {
                        i6 = i8;
                        if (i26 >= i23) {
                            break;
                        }
                        int i27 = iArr2[bArr[i25] & 255];
                        if (i27 != 0) {
                            iArr[i26] = i27;
                        } else if (z2 && bool == null) {
                            bool = 1;
                        }
                        i25 += i11;
                        i26++;
                        i8 = i6;
                    }
                } else {
                    i6 = i8;
                    int i28 = ((i23 - i22) * i11) + i25;
                    int i29 = i22;
                    while (true) {
                        i5 = i9;
                        if (i29 >= i23) {
                            break;
                        }
                        int a2 = a(i25, i28, bVar2.f5688c);
                        if (a2 != 0) {
                            iArr[i29] = a2;
                        } else if (z2 && bool == null) {
                            bool = 1;
                        }
                        i25 += i11;
                        i29++;
                        i9 = i5;
                    }
                    bool2 = bool;
                    i16++;
                    i8 = i6;
                    i9 = i5;
                    i7 = i2;
                    i17 = i4;
                }
            } else {
                i4 = i3;
                i6 = i8;
            }
            i5 = i9;
            bool2 = bool;
            i16++;
            i8 = i6;
            i9 = i5;
            i7 = i2;
            i17 = i4;
        }
        if (this.f5733t == null) {
            this.f5733t = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r7v13, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(bj.b r29) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            if (r1 == 0) goto L_0x000d
            java.nio.ByteBuffer r2 = r0.f5718e
            int r3 = r1.f5695j
            r2.position(r3)
        L_0x000d:
            if (r1 != 0) goto L_0x001a
            bj.c r1 = r0.f5726m
            int r1 = r1.f5702f
            bj.c r2 = r0.f5726m
            int r2 = r2.f5703g
            int r1 = r1 * r2
            goto L_0x0020
        L_0x001a:
            int r2 = r1.f5688c
            int r1 = r1.f5689d
            int r1 = r1 * r2
        L_0x0020:
            byte[] r2 = r0.f5723j
            if (r2 == 0) goto L_0x0027
            int r2 = r2.length
            if (r2 >= r1) goto L_0x002f
        L_0x0027:
            bj.a$a r2 = r0.f5717d
            byte[] r2 = r2.a((int) r1)
            r0.f5723j = r2
        L_0x002f:
            byte[] r2 = r0.f5723j
            short[] r3 = r0.f5720g
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 != 0) goto L_0x003b
            short[] r3 = new short[r4]
            r0.f5720g = r3
        L_0x003b:
            short[] r3 = r0.f5720g
            byte[] r5 = r0.f5721h
            if (r5 != 0) goto L_0x0045
            byte[] r5 = new byte[r4]
            r0.f5721h = r5
        L_0x0045:
            byte[] r5 = r0.f5721h
            byte[] r6 = r0.f5722i
            if (r6 != 0) goto L_0x0051
            r6 = 4097(0x1001, float:5.741E-42)
            byte[] r6 = new byte[r6]
            r0.f5722i = r6
        L_0x0051:
            byte[] r6 = r0.f5722i
            int r7 = r28.j()
            r8 = 1
            int r9 = r8 << r7
            int r10 = r9 + 1
            int r11 = r9 + 2
            int r7 = r7 + r8
            int r12 = r8 << r7
            int r12 = r12 - r8
            r13 = 0
            r14 = 0
        L_0x0064:
            if (r14 >= r9) goto L_0x006e
            r3[r14] = r13
            byte r15 = (byte) r14
            r5[r14] = r15
            int r14 = r14 + 1
            goto L_0x0064
        L_0x006e:
            byte[] r14 = r0.f5719f
            r15 = -1
            r23 = r7
            r21 = r11
            r22 = r12
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r24 = -1
            r25 = 0
            r26 = 0
        L_0x0087:
            if (r13 >= r1) goto L_0x0150
            if (r16 != 0) goto L_0x0098
            int r16 = r28.k()
            if (r16 > 0) goto L_0x0096
            r3 = 3
            r0.f5729p = r3
            goto L_0x0150
        L_0x0096:
            r17 = 0
        L_0x0098:
            byte r4 = r14[r17]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r18
            int r19 = r19 + r4
            int r18 = r18 + 8
            int r17 = r17 + 1
            int r16 = r16 + -1
            r4 = r18
            r8 = r21
            r15 = r23
            r0 = r24
            r23 = r7
            r7 = r25
        L_0x00b2:
            if (r4 < r15) goto L_0x013a
            r24 = r11
            r11 = r19 & r22
            int r19 = r19 >> r15
            int r4 = r4 - r15
            if (r11 != r9) goto L_0x00c6
            r22 = r12
            r15 = r23
            r8 = r24
            r11 = r8
            r0 = -1
            goto L_0x00b2
        L_0x00c6:
            if (r11 != r10) goto L_0x00dd
            r18 = r4
            r25 = r7
            r21 = r8
            r7 = r23
            r11 = r24
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r24 = r0
            r23 = r15
            r15 = -1
            r0 = r28
            goto L_0x0087
        L_0x00dd:
            r25 = r4
            r4 = -1
            if (r0 != r4) goto L_0x00f1
            byte r0 = r5[r11]
            r2[r20] = r0
            int r20 = r20 + 1
            int r13 = r13 + 1
            r0 = r11
            r7 = r0
            r11 = r24
            r4 = r25
            goto L_0x00b2
        L_0x00f1:
            if (r11 < r8) goto L_0x00fa
            byte r7 = (byte) r7
            r6[r26] = r7
            int r26 = r26 + 1
            r7 = r0
            goto L_0x00fb
        L_0x00fa:
            r7 = r11
        L_0x00fb:
            if (r7 < r9) goto L_0x0106
            byte r21 = r5[r7]
            r6[r26] = r21
            int r26 = r26 + 1
            short r7 = r3[r7]
            goto L_0x00fb
        L_0x0106:
            byte r7 = r5[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r7
            r2[r20] = r4
        L_0x010d:
            int r20 = r20 + 1
            int r13 = r13 + 1
            if (r26 <= 0) goto L_0x011a
            int r26 = r26 + -1
            byte r27 = r6[r26]
            r2[r20] = r27
            goto L_0x010d
        L_0x011a:
            r27 = r6
            r6 = 4096(0x1000, float:5.74E-42)
            if (r8 >= r6) goto L_0x0131
            short r0 = (short) r0
            r3[r8] = r0
            r5[r8] = r4
            int r8 = r8 + 1
            r0 = r8 & r22
            if (r0 != 0) goto L_0x0131
            if (r8 >= r6) goto L_0x0131
            int r15 = r15 + 1
            int r22 = r22 + r8
        L_0x0131:
            r0 = r11
            r11 = r24
            r4 = r25
            r6 = r27
            goto L_0x00b2
        L_0x013a:
            r25 = r4
            r24 = r0
            r21 = r8
            r18 = r25
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r0 = r28
            r25 = r7
            r7 = r23
            r23 = r15
            r15 = -1
            goto L_0x0087
        L_0x0150:
            r13 = r20
            r0 = 0
            java.util.Arrays.fill(r2, r13, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bj.e.c(bj.b):void");
    }

    private int j() {
        return this.f5718e.get() & 255;
    }

    private int k() {
        int j2 = j();
        if (j2 <= 0) {
            return j2;
        }
        ByteBuffer byteBuffer = this.f5718e;
        byteBuffer.get(this.f5719f, 0, Math.min(j2, byteBuffer.remaining()));
        return j2;
    }

    private Bitmap l() {
        Boolean bool = this.f5733t;
        Bitmap a2 = this.f5717d.a(this.f5732s, this.f5731r, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f5734u);
        a2.setHasAlpha(true);
        return a2;
    }

    public int a(int i2) {
        if (i2 < 0 || i2 >= this.f5726m.f5699c) {
            return -1;
        }
        return this.f5726m.f5701e.get(i2).f5694i;
    }

    public ByteBuffer a() {
        return this.f5718e;
    }

    public void a(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.f5734u = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    public synchronized void a(c cVar, ByteBuffer byteBuffer, int i2) {
        if (i2 > 0) {
            int highestOneBit = Integer.highestOneBit(i2);
            this.f5729p = 0;
            this.f5726m = cVar;
            this.f5725l = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f5718e = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f5718e.order(ByteOrder.LITTLE_ENDIAN);
            this.f5728o = false;
            Iterator<b> it2 = cVar.f5701e.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().f5692g == 3) {
                        this.f5728o = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.f5730q = highestOneBit;
            this.f5732s = cVar.f5702f / highestOneBit;
            this.f5731r = cVar.f5703g / highestOneBit;
            this.f5723j = this.f5717d.a(cVar.f5702f * cVar.f5703g);
            this.f5724k = this.f5717d.b(this.f5732s * this.f5731r);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
    }

    public void b() {
        this.f5725l = (this.f5725l + 1) % this.f5726m.f5699c;
    }

    public int c() {
        int i2;
        if (this.f5726m.f5699c <= 0 || (i2 = this.f5725l) < 0) {
            return 0;
        }
        return a(i2);
    }

    public int d() {
        return this.f5726m.f5699c;
    }

    public int e() {
        return this.f5725l;
    }

    public void f() {
        this.f5725l = -1;
    }

    public int g() {
        return this.f5718e.limit() + this.f5723j.length + (this.f5724k.length * 4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e9, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap h() {
        /*
            r8 = this;
            monitor-enter(r8)
            bj.c r0 = r8.f5726m     // Catch:{ all -> 0x00ea }
            int r0 = r0.f5699c     // Catch:{ all -> 0x00ea }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x000d
            int r0 = r8.f5725l     // Catch:{ all -> 0x00ea }
            if (r0 >= 0) goto L_0x0039
        L_0x000d:
            java.lang.String r0 = f5714a     // Catch:{ all -> 0x00ea }
            boolean r3 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00ea }
            if (r3 == 0) goto L_0x0037
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            r3.<init>()     // Catch:{ all -> 0x00ea }
            java.lang.String r4 = "Unable to decode frame, frameCount="
            r3.append(r4)     // Catch:{ all -> 0x00ea }
            bj.c r4 = r8.f5726m     // Catch:{ all -> 0x00ea }
            int r4 = r4.f5699c     // Catch:{ all -> 0x00ea }
            r3.append(r4)     // Catch:{ all -> 0x00ea }
            java.lang.String r4 = ", framePointer="
            r3.append(r4)     // Catch:{ all -> 0x00ea }
            int r4 = r8.f5725l     // Catch:{ all -> 0x00ea }
            r3.append(r4)     // Catch:{ all -> 0x00ea }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00ea }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x00ea }
        L_0x0037:
            r8.f5729p = r2     // Catch:{ all -> 0x00ea }
        L_0x0039:
            int r0 = r8.f5729p     // Catch:{ all -> 0x00ea }
            r3 = 0
            if (r0 == r2) goto L_0x00ca
            r4 = 2
            if (r0 != r4) goto L_0x0043
            goto L_0x00ca
        L_0x0043:
            r0 = 0
            r8.f5729p = r0     // Catch:{ all -> 0x00ea }
            byte[] r5 = r8.f5719f     // Catch:{ all -> 0x00ea }
            if (r5 != 0) goto L_0x0054
            bj.a$a r5 = r8.f5717d     // Catch:{ all -> 0x00ea }
            r6 = 255(0xff, float:3.57E-43)
            byte[] r5 = r5.a((int) r6)     // Catch:{ all -> 0x00ea }
            r8.f5719f = r5     // Catch:{ all -> 0x00ea }
        L_0x0054:
            bj.c r5 = r8.f5726m     // Catch:{ all -> 0x00ea }
            java.util.List<bj.b> r5 = r5.f5701e     // Catch:{ all -> 0x00ea }
            int r6 = r8.f5725l     // Catch:{ all -> 0x00ea }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x00ea }
            bj.b r5 = (bj.b) r5     // Catch:{ all -> 0x00ea }
            int r6 = r8.f5725l     // Catch:{ all -> 0x00ea }
            int r6 = r6 - r2
            if (r6 < 0) goto L_0x0070
            bj.c r7 = r8.f5726m     // Catch:{ all -> 0x00ea }
            java.util.List<bj.b> r7 = r7.f5701e     // Catch:{ all -> 0x00ea }
            java.lang.Object r6 = r7.get(r6)     // Catch:{ all -> 0x00ea }
            bj.b r6 = (bj.b) r6     // Catch:{ all -> 0x00ea }
            goto L_0x0071
        L_0x0070:
            r6 = r3
        L_0x0071:
            int[] r7 = r5.f5696k     // Catch:{ all -> 0x00ea }
            if (r7 == 0) goto L_0x0078
            int[] r7 = r5.f5696k     // Catch:{ all -> 0x00ea }
            goto L_0x007c
        L_0x0078:
            bj.c r7 = r8.f5726m     // Catch:{ all -> 0x00ea }
            int[] r7 = r7.f5697a     // Catch:{ all -> 0x00ea }
        L_0x007c:
            r8.f5715b = r7     // Catch:{ all -> 0x00ea }
            if (r7 != 0) goto L_0x00a2
            java.lang.String r0 = f5714a     // Catch:{ all -> 0x00ea }
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00ea }
            if (r1 == 0) goto L_0x009e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            r1.<init>()     // Catch:{ all -> 0x00ea }
            java.lang.String r4 = "No valid color table found for frame #"
            r1.append(r4)     // Catch:{ all -> 0x00ea }
            int r4 = r8.f5725l     // Catch:{ all -> 0x00ea }
            r1.append(r4)     // Catch:{ all -> 0x00ea }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ea }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00ea }
        L_0x009e:
            r8.f5729p = r2     // Catch:{ all -> 0x00ea }
            monitor-exit(r8)
            return r3
        L_0x00a2:
            boolean r1 = r5.f5691f     // Catch:{ all -> 0x00ea }
            if (r1 == 0) goto L_0x00c4
            int[] r1 = r8.f5715b     // Catch:{ all -> 0x00ea }
            int[] r3 = r8.f5716c     // Catch:{ all -> 0x00ea }
            int r7 = r1.length     // Catch:{ all -> 0x00ea }
            java.lang.System.arraycopy(r1, r0, r3, r0, r7)     // Catch:{ all -> 0x00ea }
            int[] r1 = r8.f5716c     // Catch:{ all -> 0x00ea }
            r8.f5715b = r1     // Catch:{ all -> 0x00ea }
            int r3 = r5.f5693h     // Catch:{ all -> 0x00ea }
            r1[r3] = r0     // Catch:{ all -> 0x00ea }
            int r0 = r5.f5692g     // Catch:{ all -> 0x00ea }
            if (r0 != r4) goto L_0x00c4
            int r0 = r8.f5725l     // Catch:{ all -> 0x00ea }
            if (r0 != 0) goto L_0x00c4
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x00ea }
            r8.f5733t = r0     // Catch:{ all -> 0x00ea }
        L_0x00c4:
            android.graphics.Bitmap r0 = r8.a(r5, r6)     // Catch:{ all -> 0x00ea }
            monitor-exit(r8)
            return r0
        L_0x00ca:
            java.lang.String r0 = f5714a     // Catch:{ all -> 0x00ea }
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00ea }
            if (r1 == 0) goto L_0x00e8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            r1.<init>()     // Catch:{ all -> 0x00ea }
            java.lang.String r2 = "Unable to decode frame, status="
            r1.append(r2)     // Catch:{ all -> 0x00ea }
            int r2 = r8.f5729p     // Catch:{ all -> 0x00ea }
            r1.append(r2)     // Catch:{ all -> 0x00ea }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ea }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00ea }
        L_0x00e8:
            monitor-exit(r8)
            return r3
        L_0x00ea:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bj.e.h():android.graphics.Bitmap");
    }

    public void i() {
        this.f5726m = null;
        byte[] bArr = this.f5723j;
        if (bArr != null) {
            this.f5717d.a(bArr);
        }
        int[] iArr = this.f5724k;
        if (iArr != null) {
            this.f5717d.a(iArr);
        }
        Bitmap bitmap = this.f5727n;
        if (bitmap != null) {
            this.f5717d.a(bitmap);
        }
        this.f5727n = null;
        this.f5718e = null;
        this.f5733t = null;
        byte[] bArr2 = this.f5719f;
        if (bArr2 != null) {
            this.f5717d.a(bArr2);
        }
    }
}
