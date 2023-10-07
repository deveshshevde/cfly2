package fx;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.p;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f28252a = {0, 7, 8, 15};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f28253b = {0, 119, -120, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f28254c = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: d  reason: collision with root package name */
    private final Paint f28255d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f28256e;

    /* renamed from: f  reason: collision with root package name */
    private final Canvas f28257f = new Canvas();

    /* renamed from: g  reason: collision with root package name */
    private final C0181b f28258g = new C0181b(719, 575, 0, 719, 0, 575);

    /* renamed from: h  reason: collision with root package name */
    private final a f28259h = new a(0, b(), c(), d());

    /* renamed from: i  reason: collision with root package name */
    private final h f28260i;

    /* renamed from: j  reason: collision with root package name */
    private Bitmap f28261j;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f28262a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f28263b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f28264c;

        /* renamed from: d  reason: collision with root package name */
        public final int[] f28265d;

        public a(int i2, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f28262a = i2;
            this.f28263b = iArr;
            this.f28264c = iArr2;
            this.f28265d = iArr3;
        }
    }

    /* renamed from: fx.b$b  reason: collision with other inner class name */
    private static final class C0181b {

        /* renamed from: a  reason: collision with root package name */
        public final int f28266a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28267b;

        /* renamed from: c  reason: collision with root package name */
        public final int f28268c;

        /* renamed from: d  reason: collision with root package name */
        public final int f28269d;

        /* renamed from: e  reason: collision with root package name */
        public final int f28270e;

        /* renamed from: f  reason: collision with root package name */
        public final int f28271f;

        public C0181b(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f28266a = i2;
            this.f28267b = i3;
            this.f28268c = i4;
            this.f28269d = i5;
            this.f28270e = i6;
            this.f28271f = i7;
        }
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f28272a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f28273b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f28274c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f28275d;

        public c(int i2, boolean z2, byte[] bArr, byte[] bArr2) {
            this.f28272a = i2;
            this.f28273b = z2;
            this.f28274c = bArr;
            this.f28275d = bArr2;
        }
    }

    private static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f28276a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28277b;

        /* renamed from: c  reason: collision with root package name */
        public final int f28278c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<e> f28279d;

        public d(int i2, int i3, int i4, SparseArray<e> sparseArray) {
            this.f28276a = i2;
            this.f28277b = i3;
            this.f28278c = i4;
            this.f28279d = sparseArray;
        }
    }

    private static final class e {

        /* renamed from: a  reason: collision with root package name */
        public final int f28280a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28281b;

        public e(int i2, int i3) {
            this.f28280a = i2;
            this.f28281b = i3;
        }
    }

    private static final class f {

        /* renamed from: a  reason: collision with root package name */
        public final int f28282a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f28283b;

        /* renamed from: c  reason: collision with root package name */
        public final int f28284c;

        /* renamed from: d  reason: collision with root package name */
        public final int f28285d;

        /* renamed from: e  reason: collision with root package name */
        public final int f28286e;

        /* renamed from: f  reason: collision with root package name */
        public final int f28287f;

        /* renamed from: g  reason: collision with root package name */
        public final int f28288g;

        /* renamed from: h  reason: collision with root package name */
        public final int f28289h;

        /* renamed from: i  reason: collision with root package name */
        public final int f28290i;

        /* renamed from: j  reason: collision with root package name */
        public final int f28291j;

        /* renamed from: k  reason: collision with root package name */
        public final SparseArray<g> f28292k;

        public f(int i2, boolean z2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, SparseArray<g> sparseArray) {
            this.f28282a = i2;
            this.f28283b = z2;
            this.f28284c = i3;
            this.f28285d = i4;
            this.f28286e = i5;
            this.f28287f = i6;
            this.f28288g = i7;
            this.f28289h = i8;
            this.f28290i = i9;
            this.f28291j = i10;
            this.f28292k = sparseArray;
        }

        public void a(f fVar) {
            SparseArray<g> sparseArray = fVar.f28292k;
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                this.f28292k.put(sparseArray.keyAt(i2), sparseArray.valueAt(i2));
            }
        }
    }

    private static final class g {

        /* renamed from: a  reason: collision with root package name */
        public final int f28293a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28294b;

        /* renamed from: c  reason: collision with root package name */
        public final int f28295c;

        /* renamed from: d  reason: collision with root package name */
        public final int f28296d;

        /* renamed from: e  reason: collision with root package name */
        public final int f28297e;

        /* renamed from: f  reason: collision with root package name */
        public final int f28298f;

        public g(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f28293a = i2;
            this.f28294b = i3;
            this.f28295c = i4;
            this.f28296d = i5;
            this.f28297e = i6;
            this.f28298f = i7;
        }
    }

    private static final class h {

        /* renamed from: a  reason: collision with root package name */
        public final int f28299a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28300b;

        /* renamed from: c  reason: collision with root package name */
        public final SparseArray<f> f28301c = new SparseArray<>();

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<a> f28302d = new SparseArray<>();

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<c> f28303e = new SparseArray<>();

        /* renamed from: f  reason: collision with root package name */
        public final SparseArray<a> f28304f = new SparseArray<>();

        /* renamed from: g  reason: collision with root package name */
        public final SparseArray<c> f28305g = new SparseArray<>();

        /* renamed from: h  reason: collision with root package name */
        public C0181b f28306h;

        /* renamed from: i  reason: collision with root package name */
        public d f28307i;

        public h(int i2, int i3) {
            this.f28299a = i2;
            this.f28300b = i3;
        }

        public void a() {
            this.f28301c.clear();
            this.f28302d.clear();
            this.f28303e.clear();
            this.f28304f.clear();
            this.f28305g.clear();
            this.f28306h = null;
            this.f28307i = null;
        }
    }

    public b(int i2, int i3) {
        Paint paint = new Paint();
        this.f28255d = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect((PathEffect) null);
        Paint paint2 = new Paint();
        this.f28256e = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect((PathEffect) null);
        this.f28260i = new h(i2, i3);
    }

    private static int a(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007b A[LOOP:0: B:1:0x0009->B:31:0x007b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(com.google.android.exoplayer2.util.p r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L_0x0009:
            r3 = 2
            int r4 = r13.c(r3)
            r5 = 1
            if (r4 == 0) goto L_0x0014
            r11 = r2
        L_0x0012:
            r12 = 1
            goto L_0x0059
        L_0x0014:
            boolean r4 = r13.e()
            r6 = 3
            if (r4 == 0) goto L_0x0028
            int r4 = r13.c(r6)
            int r4 = r4 + r6
        L_0x0020:
            int r3 = r13.c(r3)
            r11 = r2
            r12 = r4
            r4 = r3
            goto L_0x0059
        L_0x0028:
            boolean r4 = r13.e()
            if (r4 == 0) goto L_0x0031
            r11 = r2
            r4 = 0
            goto L_0x0012
        L_0x0031:
            int r4 = r13.c(r3)
            if (r4 == 0) goto L_0x0056
            if (r4 == r5) goto L_0x0052
            if (r4 == r3) goto L_0x004a
            if (r4 == r6) goto L_0x0041
            r11 = r2
            r4 = 0
        L_0x003f:
            r12 = 0
            goto L_0x0059
        L_0x0041:
            r4 = 8
            int r4 = r13.c(r4)
            int r4 = r4 + 29
            goto L_0x0020
        L_0x004a:
            r4 = 4
            int r4 = r13.c(r4)
            int r4 = r4 + 12
            goto L_0x0020
        L_0x0052:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L_0x0059
        L_0x0056:
            r4 = 0
            r11 = 1
            goto L_0x003f
        L_0x0059:
            if (r12 == 0) goto L_0x0077
            if (r8 == 0) goto L_0x0077
            if (r15 == 0) goto L_0x0061
            byte r4 = r15[r4]
        L_0x0061:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x0077:
            int r10 = r10 + r12
            if (r11 == 0) goto L_0x007b
            return r10
        L_0x007b:
            r2 = r11
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: fx.b.a(com.google.android.exoplayer2.util.p, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    private static C0181b a(p pVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        pVar.b(4);
        boolean e2 = pVar.e();
        pVar.b(3);
        int c2 = pVar.c(16);
        int c3 = pVar.c(16);
        if (e2) {
            int c4 = pVar.c(16);
            int c5 = pVar.c(16);
            int c6 = pVar.c(16);
            i2 = pVar.c(16);
            i4 = c5;
            i3 = c6;
            i5 = c4;
        } else {
            i4 = c2;
            i2 = c3;
            i5 = 0;
            i3 = 0;
        }
        return new C0181b(c2, c3, i5, i4, i3, i2);
    }

    private static d a(p pVar, int i2) {
        int c2 = pVar.c(8);
        int c3 = pVar.c(4);
        int c4 = pVar.c(2);
        pVar.b(2);
        int i3 = i2 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i3 > 0) {
            int c5 = pVar.c(8);
            pVar.b(8);
            i3 -= 6;
            sparseArray.put(c5, new e(pVar.c(16), pVar.c(16)));
        }
        return new d(c2, c3, c4, sparseArray);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0061, code lost:
        r7.put(r1, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.google.android.exoplayer2.util.p r6, fx.b.h r7) {
        /*
            r0 = 8
            int r0 = r6.c(r0)
            r1 = 16
            int r2 = r6.c(r1)
            int r1 = r6.c(r1)
            int r3 = r6.c()
            int r3 = r3 + r1
            int r4 = r1 * 8
            int r5 = r6.a()
            if (r4 <= r5) goto L_0x002c
            java.lang.String r7 = "DvbParser"
            java.lang.String r0 = "Data field length exceeds limit"
            com.google.android.exoplayer2.util.k.c(r7, r0)
            int r7 = r6.a()
            r6.b(r7)
            return
        L_0x002c:
            switch(r0) {
                case 16: goto L_0x0097;
                case 17: goto L_0x0070;
                case 18: goto L_0x0055;
                case 19: goto L_0x003d;
                case 20: goto L_0x0031;
                default: goto L_0x002f;
            }
        L_0x002f:
            goto L_0x00c1
        L_0x0031:
            int r0 = r7.f28299a
            if (r2 != r0) goto L_0x00c1
            fx.b$b r0 = a(r6)
            r7.f28306h = r0
            goto L_0x00c1
        L_0x003d:
            int r0 = r7.f28299a
            if (r2 != r0) goto L_0x004a
            fx.b$c r0 = b(r6)
            android.util.SparseArray<fx.b$c> r7 = r7.f28303e
        L_0x0047:
            int r1 = r0.f28272a
            goto L_0x0061
        L_0x004a:
            int r0 = r7.f28300b
            if (r2 != r0) goto L_0x00c1
            fx.b$c r0 = b(r6)
            android.util.SparseArray<fx.b$c> r7 = r7.f28305g
            goto L_0x0047
        L_0x0055:
            int r0 = r7.f28299a
            if (r2 != r0) goto L_0x0065
            fx.b$a r0 = c(r6, r1)
            android.util.SparseArray<fx.b$a> r7 = r7.f28302d
        L_0x005f:
            int r1 = r0.f28262a
        L_0x0061:
            r7.put(r1, r0)
            goto L_0x00c1
        L_0x0065:
            int r0 = r7.f28300b
            if (r2 != r0) goto L_0x00c1
            fx.b$a r0 = c(r6, r1)
            android.util.SparseArray<fx.b$a> r7 = r7.f28304f
            goto L_0x005f
        L_0x0070:
            fx.b$d r0 = r7.f28307i
            int r4 = r7.f28299a
            if (r2 != r4) goto L_0x00c1
            if (r0 == 0) goto L_0x00c1
            fx.b$f r1 = b(r6, r1)
            int r0 = r0.f28278c
            if (r0 != 0) goto L_0x008f
            android.util.SparseArray<fx.b$f> r0 = r7.f28301c
            int r2 = r1.f28282a
            java.lang.Object r0 = r0.get(r2)
            fx.b$f r0 = (fx.b.f) r0
            if (r0 == 0) goto L_0x008f
            r1.a(r0)
        L_0x008f:
            android.util.SparseArray<fx.b$f> r7 = r7.f28301c
            int r0 = r1.f28282a
            r7.put(r0, r1)
            goto L_0x00c1
        L_0x0097:
            int r0 = r7.f28299a
            if (r2 != r0) goto L_0x00c1
            fx.b$d r0 = r7.f28307i
            fx.b$d r1 = a((com.google.android.exoplayer2.util.p) r6, (int) r1)
            int r2 = r1.f28278c
            if (r2 == 0) goto L_0x00b7
            r7.f28307i = r1
            android.util.SparseArray<fx.b$f> r0 = r7.f28301c
            r0.clear()
            android.util.SparseArray<fx.b$a> r0 = r7.f28302d
            r0.clear()
            android.util.SparseArray<fx.b$c> r7 = r7.f28303e
            r7.clear()
            goto L_0x00c1
        L_0x00b7:
            if (r0 == 0) goto L_0x00c1
            int r0 = r0.f28277b
            int r2 = r1.f28277b
            if (r0 == r2) goto L_0x00c1
            r7.f28307i = r1
        L_0x00c1:
            int r7 = r6.c()
            int r3 = r3 - r7
            r6.e(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fx.b.a(com.google.android.exoplayer2.util.p, fx.b$h):void");
    }

    private static void a(c cVar, a aVar, int i2, int i3, int i4, Paint paint, Canvas canvas) {
        int[] iArr = i2 == 3 ? aVar.f28265d : i2 == 2 ? aVar.f28264c : aVar.f28263b;
        int i5 = i2;
        int i6 = i3;
        Paint paint2 = paint;
        Canvas canvas2 = canvas;
        a(cVar.f28274c, iArr, i5, i6, i4, paint2, canvas2);
        a(cVar.f28275d, iArr, i5, i6, i4 + 1, paint2, canvas2);
    }

    private static void a(byte[] bArr, int[] iArr, int i2, int i3, int i4, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        int i5 = i2;
        byte[] bArr5 = bArr;
        p pVar = new p(bArr);
        int i6 = i3;
        int i7 = i4;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        byte[] bArr8 = null;
        while (pVar.a() != 0) {
            int c2 = pVar.c(8);
            if (c2 != 240) {
                switch (c2) {
                    case 16:
                        if (i5 != 3) {
                            if (i5 != 2) {
                                bArr2 = null;
                                i6 = a(pVar, iArr, bArr2, i6, i7, paint, canvas);
                                break;
                            } else {
                                bArr3 = bArr8 == null ? f28252a : bArr8;
                            }
                        } else {
                            bArr3 = bArr6 == null ? f28253b : bArr6;
                        }
                        bArr2 = bArr3;
                        i6 = a(pVar, iArr, bArr2, i6, i7, paint, canvas);
                    case 17:
                        if (i5 == 3) {
                            bArr4 = bArr7 == null ? f28254c : bArr7;
                        } else {
                            bArr4 = null;
                        }
                        i6 = b(pVar, iArr, bArr4, i6, i7, paint, canvas);
                        break;
                    case 18:
                        i6 = c(pVar, iArr, (byte[]) null, i6, i7, paint, canvas);
                        continue;
                    default:
                        switch (c2) {
                            case 32:
                                bArr8 = a(4, 4, pVar);
                                break;
                            case 33:
                                bArr6 = a(4, 8, pVar);
                                break;
                            case 34:
                                bArr7 = a(16, 8, pVar);
                                break;
                            default:
                                continue;
                        }
                }
                pVar.f();
            } else {
                i7 += 2;
                i6 = i3;
            }
        }
    }

    private static byte[] a(int i2, int i3, p pVar) {
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) pVar.c(i3);
        }
        return bArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0085 A[LOOP:0: B:1:0x0009->B:34:0x0085, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0084 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int b(com.google.android.exoplayer2.util.p r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L_0x0009:
            r3 = 4
            int r4 = r13.c(r3)
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x0015
            r11 = r2
        L_0x0013:
            r12 = 1
            goto L_0x0065
        L_0x0015:
            boolean r4 = r13.e()
            r7 = 3
            if (r4 != 0) goto L_0x002b
            int r3 = r13.c(r7)
            if (r3 == 0) goto L_0x0028
            int r5 = r3 + 2
            r11 = r2
            r12 = r5
            r4 = 0
            goto L_0x0065
        L_0x0028:
            r4 = 0
            r11 = 1
            goto L_0x004c
        L_0x002b:
            boolean r4 = r13.e()
            if (r4 != 0) goto L_0x003e
            int r4 = r13.c(r5)
            int r5 = r4 + 4
        L_0x0037:
            int r4 = r13.c(r3)
            r11 = r2
            r12 = r5
            goto L_0x0065
        L_0x003e:
            int r4 = r13.c(r5)
            if (r4 == 0) goto L_0x0062
            if (r4 == r6) goto L_0x005e
            if (r4 == r5) goto L_0x0057
            if (r4 == r7) goto L_0x004e
            r11 = r2
            r4 = 0
        L_0x004c:
            r12 = 0
            goto L_0x0065
        L_0x004e:
            r4 = 8
            int r4 = r13.c(r4)
            int r5 = r4 + 25
            goto L_0x0037
        L_0x0057:
            int r4 = r13.c(r3)
            int r5 = r4 + 9
            goto L_0x0037
        L_0x005e:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L_0x0065
        L_0x0062:
            r11 = r2
            r4 = 0
            goto L_0x0013
        L_0x0065:
            if (r12 == 0) goto L_0x0081
            if (r8 == 0) goto L_0x0081
            if (r15 == 0) goto L_0x006d
            byte r4 = r15[r4]
        L_0x006d:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r5 = (float) r2
            int r2 = r1 + 1
            float r6 = (float) r2
            r2 = r19
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x0081:
            int r10 = r10 + r12
            if (r11 == 0) goto L_0x0085
            return r10
        L_0x0085:
            r2 = r11
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: fx.b.b(com.google.android.exoplayer2.util.p, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    private static c b(p pVar) {
        byte[] bArr;
        int c2 = pVar.c(16);
        pVar.b(4);
        int c3 = pVar.c(2);
        boolean e2 = pVar.e();
        pVar.b(1);
        byte[] bArr2 = null;
        if (c3 == 1) {
            pVar.b(pVar.c(8) * 16);
        } else if (c3 == 0) {
            int c4 = pVar.c(16);
            int c5 = pVar.c(16);
            if (c4 > 0) {
                bArr2 = new byte[c4];
                pVar.b(bArr2, 0, c4);
            }
            if (c5 > 0) {
                bArr = new byte[c5];
                pVar.b(bArr, 0, c5);
                return new c(c2, e2, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new c(c2, e2, bArr2, bArr);
    }

    private static f b(p pVar, int i2) {
        int i3;
        int i4;
        p pVar2 = pVar;
        int c2 = pVar2.c(8);
        pVar2.b(4);
        boolean e2 = pVar.e();
        pVar2.b(3);
        int i5 = 16;
        int c3 = pVar2.c(16);
        int c4 = pVar2.c(16);
        int c5 = pVar2.c(3);
        int c6 = pVar2.c(3);
        int i6 = 2;
        pVar2.b(2);
        int c7 = pVar2.c(8);
        int c8 = pVar2.c(8);
        int c9 = pVar2.c(4);
        int c10 = pVar2.c(2);
        pVar2.b(2);
        int i7 = i2 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i7 > 0) {
            int c11 = pVar2.c(i5);
            int c12 = pVar2.c(i6);
            int c13 = pVar2.c(i6);
            int c14 = pVar2.c(12);
            int i8 = c10;
            pVar2.b(4);
            int c15 = pVar2.c(12);
            i7 -= 6;
            if (c12 == 1 || c12 == 2) {
                i7 -= 2;
                i4 = pVar2.c(8);
                i3 = pVar2.c(8);
            } else {
                i4 = 0;
                i3 = 0;
            }
            sparseArray.put(c11, new g(c12, c13, c14, c15, i4, i3));
            c10 = i8;
            i6 = 2;
            i5 = 16;
        }
        return new f(c2, e2, c3, c4, c5, c6, c7, c8, c9, c10, sparseArray);
    }

    private static int[] b() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int c(com.google.android.exoplayer2.util.p r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L_0x0009:
            r3 = 8
            int r4 = r13.c(r3)
            r5 = 1
            if (r4 == 0) goto L_0x0015
            r11 = r2
            r12 = 1
            goto L_0x0035
        L_0x0015:
            boolean r4 = r13.e()
            r6 = 7
            if (r4 != 0) goto L_0x002a
            int r3 = r13.c(r6)
            if (r3 == 0) goto L_0x0026
            r11 = r2
            r12 = r3
            r4 = 0
            goto L_0x0035
        L_0x0026:
            r4 = 0
            r11 = 1
            r12 = 0
            goto L_0x0035
        L_0x002a:
            int r4 = r13.c(r6)
            int r3 = r13.c(r3)
            r11 = r2
            r12 = r4
            r4 = r3
        L_0x0035:
            if (r12 == 0) goto L_0x0053
            if (r8 == 0) goto L_0x0053
            if (r15 == 0) goto L_0x003d
            byte r4 = r15[r4]
        L_0x003d:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x0053:
            int r10 = r10 + r12
            if (r11 == 0) goto L_0x0057
            return r10
        L_0x0057:
            r2 = r11
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: fx.b.c(com.google.android.exoplayer2.util.p, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    private static a c(p pVar, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        p pVar2 = pVar;
        int i8 = 8;
        int c2 = pVar2.c(8);
        pVar2.b(8);
        int i9 = 2;
        int i10 = i2 - 2;
        int[] b2 = b();
        int[] c3 = c();
        int[] d2 = d();
        while (i10 > 0) {
            int c4 = pVar2.c(i8);
            int c5 = pVar2.c(i8);
            int i11 = i10 - 2;
            int[] iArr = (c5 & 128) != 0 ? b2 : (c5 & 64) != 0 ? c3 : d2;
            if ((c5 & 1) != 0) {
                i6 = pVar2.c(i8);
                i5 = pVar2.c(i8);
                i4 = pVar2.c(i8);
                i3 = pVar2.c(i8);
                i7 = i11 - 4;
            } else {
                i4 = pVar2.c(4) << 4;
                i7 = i11 - 2;
                int c6 = pVar2.c(4) << 4;
                i3 = pVar2.c(i9) << 6;
                i6 = pVar2.c(6) << i9;
                i5 = c6;
            }
            if (i6 == 0) {
                i5 = 0;
                i4 = 0;
                i3 = 255;
            }
            double d3 = (double) i6;
            double d4 = (double) (i5 - 128);
            Double.isNaN(d4);
            Double.isNaN(d3);
            double d5 = (double) (i4 - 128);
            Double.isNaN(d5);
            Double.isNaN(d3);
            Double.isNaN(d4);
            Double.isNaN(d5);
            Double.isNaN(d3);
            iArr[c4] = a((byte) (255 - (i3 & 255)), ad.a((int) (d3 + (1.402d * d4)), 0, 255), ad.a((int) ((d3 - (0.34414d * d5)) - (d4 * 0.71414d)), 0, 255), ad.a((int) (d3 + (d5 * 1.772d)), 0, 255));
            i10 = i7;
            c2 = c2;
            i8 = 8;
            i9 = 2;
        }
        return new a(c2, b2, c3, d2);
    }

    private static int[] c() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i2 = 1; i2 < 16; i2++) {
            if (i2 < 8) {
                iArr[i2] = a(255, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) != 0 ? 255 : 0);
            } else {
                int i3 = 127;
                int i4 = (i2 & 1) != 0 ? 127 : 0;
                int i5 = (i2 & 2) != 0 ? 127 : 0;
                if ((i2 & 4) == 0) {
                    i3 = 0;
                }
                iArr[i2] = a(255, i4, i5, i3);
            }
        }
        return iArr;
    }

    private static int[] d() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            int i3 = 255;
            if (i2 < 8) {
                int i4 = (i2 & 1) != 0 ? 255 : 0;
                int i5 = (i2 & 2) != 0 ? 255 : 0;
                if ((i2 & 4) == 0) {
                    i3 = 0;
                }
                iArr[i2] = a(63, i4, i5, i3);
            } else {
                int i6 = i2 & IChannelListener.CMD_CHANNEL_CARD_PROTECTED;
                int i7 = 170;
                int i8 = 85;
                if (i6 == 0) {
                    int i9 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0);
                    int i10 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0);
                    if ((i2 & 4) == 0) {
                        i8 = 0;
                    }
                    if ((i2 & 64) == 0) {
                        i7 = 0;
                    }
                    iArr[i2] = a(255, i9, i10, i8 + i7);
                } else if (i6 != 8) {
                    int i11 = 43;
                    if (i6 == 128) {
                        int i12 = ((i2 & 1) != 0 ? 43 : 0) + 127 + ((i2 & 16) != 0 ? 85 : 0);
                        int i13 = ((i2 & 2) != 0 ? 43 : 0) + 127 + ((i2 & 32) != 0 ? 85 : 0);
                        if ((i2 & 4) == 0) {
                            i11 = 0;
                        }
                        int i14 = i11 + 127;
                        if ((i2 & 64) == 0) {
                            i8 = 0;
                        }
                        iArr[i2] = a(255, i12, i13, i14 + i8);
                    } else if (i6 == 136) {
                        int i15 = ((i2 & 1) != 0 ? 43 : 0) + ((i2 & 16) != 0 ? 85 : 0);
                        int i16 = ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0);
                        if ((i2 & 4) == 0) {
                            i11 = 0;
                        }
                        if ((i2 & 64) == 0) {
                            i8 = 0;
                        }
                        iArr[i2] = a(255, i15, i16, i11 + i8);
                    }
                } else {
                    int i17 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0);
                    int i18 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0);
                    if ((i2 & 4) == 0) {
                        i8 = 0;
                    }
                    if ((i2 & 64) == 0) {
                        i7 = 0;
                    }
                    iArr[i2] = a(127, i17, i18, i8 + i7);
                }
            }
        }
        return iArr;
    }

    public List<com.google.android.exoplayer2.text.b> a(byte[] bArr, int i2) {
        int i3;
        SparseArray<g> sparseArray;
        p pVar = new p(bArr, i2);
        while (pVar.a() >= 48 && pVar.c(8) == 15) {
            a(pVar, this.f28260i);
        }
        d dVar = this.f28260i.f28307i;
        if (dVar == null) {
            return Collections.emptyList();
        }
        C0181b bVar = this.f28260i.f28306h != null ? this.f28260i.f28306h : this.f28258g;
        if (!(this.f28261j != null && bVar.f28266a + 1 == this.f28261j.getWidth() && bVar.f28267b + 1 == this.f28261j.getHeight())) {
            Bitmap createBitmap = Bitmap.createBitmap(bVar.f28266a + 1, bVar.f28267b + 1, Bitmap.Config.ARGB_8888);
            this.f28261j = createBitmap;
            this.f28257f.setBitmap(createBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray2 = dVar.f28279d;
        for (int i4 = 0; i4 < sparseArray2.size(); i4++) {
            this.f28257f.save();
            e valueAt = sparseArray2.valueAt(i4);
            f fVar = this.f28260i.f28301c.get(sparseArray2.keyAt(i4));
            int i5 = valueAt.f28280a + bVar.f28268c;
            int i6 = valueAt.f28281b + bVar.f28270e;
            this.f28257f.clipRect(i5, i6, Math.min(fVar.f28284c + i5, bVar.f28269d), Math.min(fVar.f28285d + i6, bVar.f28271f));
            a aVar = this.f28260i.f28302d.get(fVar.f28288g);
            if (aVar == null && (aVar = this.f28260i.f28304f.get(fVar.f28288g)) == null) {
                aVar = this.f28259h;
            }
            SparseArray<g> sparseArray3 = fVar.f28292k;
            int i7 = 0;
            while (i7 < sparseArray3.size()) {
                int keyAt = sparseArray3.keyAt(i7);
                g valueAt2 = sparseArray3.valueAt(i7);
                c cVar = this.f28260i.f28303e.get(keyAt);
                c cVar2 = cVar == null ? this.f28260i.f28305g.get(keyAt) : cVar;
                if (cVar2 != null) {
                    i3 = i7;
                    sparseArray = sparseArray3;
                    a(cVar2, aVar, fVar.f28287f, valueAt2.f28295c + i5, i6 + valueAt2.f28296d, cVar2.f28273b ? null : this.f28255d, this.f28257f);
                } else {
                    i3 = i7;
                    sparseArray = sparseArray3;
                }
                i7 = i3 + 1;
                sparseArray3 = sparseArray;
            }
            if (fVar.f28283b) {
                this.f28256e.setColor(fVar.f28287f == 3 ? aVar.f28265d[fVar.f28289h] : fVar.f28287f == 2 ? aVar.f28264c[fVar.f28290i] : aVar.f28263b[fVar.f28291j]);
                this.f28257f.drawRect((float) i5, (float) i6, (float) (fVar.f28284c + i5), (float) (fVar.f28285d + i6), this.f28256e);
            }
            arrayList.add(new com.google.android.exoplayer2.text.b(Bitmap.createBitmap(this.f28261j, i5, i6, fVar.f28284c, fVar.f28285d), ((float) i5) / ((float) bVar.f28266a), 0, ((float) i6) / ((float) bVar.f28267b), 0, ((float) fVar.f28284c) / ((float) bVar.f28266a), ((float) fVar.f28285d) / ((float) bVar.f28267b)));
            this.f28257f.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f28257f.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void a() {
        this.f28260i.a();
    }
}
