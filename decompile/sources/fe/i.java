package fe;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.e;
import fg.j;
import java.util.ArrayList;
import java.util.List;

public class i extends o {

    /* renamed from: a  reason: collision with root package name */
    protected Paint f27131a;

    /* renamed from: b  reason: collision with root package name */
    protected Paint f27132b;

    /* renamed from: c  reason: collision with root package name */
    protected Legend f27133c;

    /* renamed from: d  reason: collision with root package name */
    protected List<e> f27134d = new ArrayList(16);

    /* renamed from: e  reason: collision with root package name */
    protected Paint.FontMetrics f27135e = new Paint.FontMetrics();

    /* renamed from: f  reason: collision with root package name */
    private Path f27136f = new Path();

    /* renamed from: fe.i$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27137a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f27138b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f27139c;

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ int[] f27140d;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|19|20|(2:21|22)|23|25|26|27|28|29|30|31|33|34|35|36|37|38|40) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|19|20|21|22|23|25|26|27|28|29|30|31|33|34|35|36|37|38|40) */
        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|19|20|21|22|23|25|26|27|28|29|30|31|33|34|35|36|37|38|40) */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0075 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x009a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00a4 */
        static {
            /*
                com.github.mikephil.charting.components.Legend$LegendForm[] r0 = com.github.mikephil.charting.components.Legend.LegendForm.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27140d = r0
                r1 = 1
                com.github.mikephil.charting.components.Legend$LegendForm r2 = com.github.mikephil.charting.components.Legend.LegendForm.NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f27140d     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.components.Legend$LegendForm r3 = com.github.mikephil.charting.components.Legend.LegendForm.EMPTY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f27140d     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.github.mikephil.charting.components.Legend$LegendForm r4 = com.github.mikephil.charting.components.Legend.LegendForm.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f27140d     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.github.mikephil.charting.components.Legend$LegendForm r4 = com.github.mikephil.charting.components.Legend.LegendForm.CIRCLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = f27140d     // Catch:{ NoSuchFieldError -> 0x003e }
                com.github.mikephil.charting.components.Legend$LegendForm r4 = com.github.mikephil.charting.components.Legend.LegendForm.SQUARE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r3 = f27140d     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.github.mikephil.charting.components.Legend$LegendForm r4 = com.github.mikephil.charting.components.Legend.LegendForm.LINE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                com.github.mikephil.charting.components.Legend$LegendOrientation[] r3 = com.github.mikephil.charting.components.Legend.LegendOrientation.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f27139c = r3
                com.github.mikephil.charting.components.Legend$LegendOrientation r4 = com.github.mikephil.charting.components.Legend.LegendOrientation.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x005a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r3 = f27139c     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.github.mikephil.charting.components.Legend$LegendOrientation r4 = com.github.mikephil.charting.components.Legend.LegendOrientation.VERTICAL     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment[] r3 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f27138b = r3
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r4 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.TOP     // Catch:{ NoSuchFieldError -> 0x0075 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0075 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0075 }
            L_0x0075:
                int[] r3 = f27138b     // Catch:{ NoSuchFieldError -> 0x007f }
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r4 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.BOTTOM     // Catch:{ NoSuchFieldError -> 0x007f }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                int[] r3 = f27138b     // Catch:{ NoSuchFieldError -> 0x0089 }
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r4 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.CENTER     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment[] r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f27137a = r3
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r4 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.LEFT     // Catch:{ NoSuchFieldError -> 0x009a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x009a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x009a }
            L_0x009a:
                int[] r1 = f27137a     // Catch:{ NoSuchFieldError -> 0x00a4 }
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.RIGHT     // Catch:{ NoSuchFieldError -> 0x00a4 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a4 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x00a4 }
            L_0x00a4:
                int[] r0 = f27137a     // Catch:{ NoSuchFieldError -> 0x00ae }
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r1 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.CENTER     // Catch:{ NoSuchFieldError -> 0x00ae }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ae }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ae }
            L_0x00ae:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.i.AnonymousClass1.<clinit>():void");
        }
    }

    public i(j jVar, Legend legend) {
        super(jVar);
        this.f27133c = legend;
        Paint paint = new Paint(1);
        this.f27131a = paint;
        paint.setTextSize(fg.i.a(9.0f));
        this.f27131a.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.f27132b = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    public Paint a() {
        return this.f27131a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x016e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.graphics.Canvas r33) {
        /*
            r32 = this;
            r6 = r32
            r7 = r33
            com.github.mikephil.charting.components.Legend r0 = r6.f27133c
            boolean r0 = r0.y()
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            com.github.mikephil.charting.components.Legend r0 = r6.f27133c
            android.graphics.Typeface r0 = r0.v()
            if (r0 == 0) goto L_0x001a
            android.graphics.Paint r1 = r6.f27131a
            r1.setTypeface(r0)
        L_0x001a:
            android.graphics.Paint r0 = r6.f27131a
            com.github.mikephil.charting.components.Legend r1 = r6.f27133c
            float r1 = r1.w()
            r0.setTextSize(r1)
            android.graphics.Paint r0 = r6.f27131a
            com.github.mikephil.charting.components.Legend r1 = r6.f27133c
            int r1 = r1.x()
            r0.setColor(r1)
            android.graphics.Paint r0 = r6.f27131a
            android.graphics.Paint$FontMetrics r1 = r6.f27135e
            float r8 = fg.i.a((android.graphics.Paint) r0, (android.graphics.Paint.FontMetrics) r1)
            android.graphics.Paint r0 = r6.f27131a
            android.graphics.Paint$FontMetrics r1 = r6.f27135e
            float r0 = fg.i.b((android.graphics.Paint) r0, (android.graphics.Paint.FontMetrics) r1)
            com.github.mikephil.charting.components.Legend r1 = r6.f27133c
            float r1 = r1.n()
            float r1 = fg.i.a((float) r1)
            float r9 = r0 + r1
            android.graphics.Paint r0 = r6.f27131a
            java.lang.String r1 = "ABC"
            int r0 = fg.i.b((android.graphics.Paint) r0, (java.lang.String) r1)
            float r0 = (float) r0
            r10 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r10
            float r11 = r8 - r0
            com.github.mikephil.charting.components.Legend r0 = r6.f27133c
            com.github.mikephil.charting.components.e[] r12 = r0.a()
            com.github.mikephil.charting.components.Legend r0 = r6.f27133c
            float r0 = r0.o()
            float r13 = fg.i.a((float) r0)
            com.github.mikephil.charting.components.Legend r0 = r6.f27133c
            float r0 = r0.m()
            float r14 = fg.i.a((float) r0)
            com.github.mikephil.charting.components.Legend r0 = r6.f27133c
            com.github.mikephil.charting.components.Legend$LegendOrientation r0 = r0.f()
            com.github.mikephil.charting.components.Legend r1 = r6.f27133c
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r15 = r1.d()
            com.github.mikephil.charting.components.Legend r1 = r6.f27133c
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r1 = r1.e()
            com.github.mikephil.charting.components.Legend r2 = r6.f27133c
            com.github.mikephil.charting.components.Legend$LegendDirection r5 = r2.h()
            com.github.mikephil.charting.components.Legend r2 = r6.f27133c
            float r2 = r2.j()
            float r16 = fg.i.a((float) r2)
            com.github.mikephil.charting.components.Legend r2 = r6.f27133c
            float r2 = r2.p()
            float r4 = fg.i.a((float) r2)
            com.github.mikephil.charting.components.Legend r2 = r6.f27133c
            float r2 = r2.u()
            com.github.mikephil.charting.components.Legend r3 = r6.f27133c
            float r3 = r3.t()
            int[] r17 = fe.i.AnonymousClass1.f27137a
            int r18 = r15.ordinal()
            r10 = r17[r18]
            r17 = r4
            r4 = 2
            r20 = 0
            r21 = r14
            r14 = 1
            if (r10 == r14) goto L_0x0149
            if (r10 == r4) goto L_0x0129
            r4 = 3
            if (r10 == r4) goto L_0x00c9
            r26 = r8
            r14 = r9
            r7 = 0
            goto L_0x0163
        L_0x00c9:
            com.github.mikephil.charting.components.Legend$LegendOrientation r4 = com.github.mikephil.charting.components.Legend.LegendOrientation.VERTICAL
            if (r0 != r4) goto L_0x00d7
            fg.j r4 = r6.f27179o
            float r4 = r4.n()
            r10 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r10
            goto L_0x00e7
        L_0x00d7:
            r10 = 1073741824(0x40000000, float:2.0)
            fg.j r4 = r6.f27179o
            float r4 = r4.f()
            fg.j r14 = r6.f27179o
            float r14 = r14.i()
            float r14 = r14 / r10
            float r4 = r4 + r14
        L_0x00e7:
            com.github.mikephil.charting.components.Legend$LegendDirection r10 = com.github.mikephil.charting.components.Legend.LegendDirection.LEFT_TO_RIGHT
            if (r5 != r10) goto L_0x00ed
            r10 = r3
            goto L_0x00ee
        L_0x00ed:
            float r10 = -r3
        L_0x00ee:
            float r4 = r4 + r10
            com.github.mikephil.charting.components.Legend$LegendOrientation r10 = com.github.mikephil.charting.components.Legend.LegendOrientation.VERTICAL
            if (r0 != r10) goto L_0x0125
            r14 = r9
            double r9 = (double) r4
            com.github.mikephil.charting.components.Legend$LegendDirection r4 = com.github.mikephil.charting.components.Legend.LegendDirection.LEFT_TO_RIGHT
            r24 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r5 != r4) goto L_0x010e
            com.github.mikephil.charting.components.Legend r4 = r6.f27133c
            float r4 = r4.f14852a
            float r4 = -r4
            r26 = r8
            double r7 = (double) r4
            java.lang.Double.isNaN(r7)
            double r7 = r7 / r24
            double r3 = (double) r3
            java.lang.Double.isNaN(r3)
            double r7 = r7 + r3
            goto L_0x011f
        L_0x010e:
            r26 = r8
            com.github.mikephil.charting.components.Legend r4 = r6.f27133c
            float r4 = r4.f14852a
            double r7 = (double) r4
            java.lang.Double.isNaN(r7)
            double r7 = r7 / r24
            double r3 = (double) r3
            java.lang.Double.isNaN(r3)
            double r7 = r7 - r3
        L_0x011f:
            java.lang.Double.isNaN(r9)
            double r9 = r9 + r7
            float r4 = (float) r9
            goto L_0x0147
        L_0x0125:
            r26 = r8
            r14 = r9
            goto L_0x0147
        L_0x0129:
            r26 = r8
            r14 = r9
            com.github.mikephil.charting.components.Legend$LegendOrientation r4 = com.github.mikephil.charting.components.Legend.LegendOrientation.VERTICAL
            if (r0 != r4) goto L_0x0137
            fg.j r4 = r6.f27179o
            float r4 = r4.n()
            goto L_0x013d
        L_0x0137:
            fg.j r4 = r6.f27179o
            float r4 = r4.g()
        L_0x013d:
            float r4 = r4 - r3
            com.github.mikephil.charting.components.Legend$LegendDirection r3 = com.github.mikephil.charting.components.Legend.LegendDirection.LEFT_TO_RIGHT
            if (r5 != r3) goto L_0x0147
            com.github.mikephil.charting.components.Legend r3 = r6.f27133c
            float r3 = r3.f14852a
            float r4 = r4 - r3
        L_0x0147:
            r7 = r4
            goto L_0x0163
        L_0x0149:
            r26 = r8
            r14 = r9
            com.github.mikephil.charting.components.Legend$LegendOrientation r4 = com.github.mikephil.charting.components.Legend.LegendOrientation.VERTICAL
            if (r0 != r4) goto L_0x0151
            goto L_0x0158
        L_0x0151:
            fg.j r4 = r6.f27179o
            float r4 = r4.f()
            float r3 = r3 + r4
        L_0x0158:
            com.github.mikephil.charting.components.Legend$LegendDirection r4 = com.github.mikephil.charting.components.Legend.LegendDirection.RIGHT_TO_LEFT
            if (r5 != r4) goto L_0x0162
            com.github.mikephil.charting.components.Legend r4 = r6.f27133c
            float r4 = r4.f14852a
            float r4 = r4 + r3
            goto L_0x0147
        L_0x0162:
            r7 = r3
        L_0x0163:
            int[] r3 = fe.i.AnonymousClass1.f27139c
            int r0 = r0.ordinal()
            r0 = r3[r0]
            r3 = 1
            if (r0 == r3) goto L_0x0272
            r4 = 2
            if (r0 == r4) goto L_0x0173
            goto L_0x03bf
        L_0x0173:
            int[] r0 = fe.i.AnonymousClass1.f27138b
            int r1 = r1.ordinal()
            r0 = r0[r1]
            if (r0 == r3) goto L_0x01b3
            if (r0 == r4) goto L_0x019b
            r1 = 3
            if (r0 == r1) goto L_0x0184
            r0 = 0
            goto L_0x01c0
        L_0x0184:
            fg.j r0 = r6.f27179o
            float r0 = r0.m()
            r1 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r1
            com.github.mikephil.charting.components.Legend r2 = r6.f27133c
            float r2 = r2.f14853b
            float r2 = r2 / r1
            float r0 = r0 - r2
            com.github.mikephil.charting.components.Legend r1 = r6.f27133c
            float r1 = r1.u()
            float r0 = r0 + r1
            goto L_0x01c0
        L_0x019b:
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r0 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.CENTER
            if (r15 != r0) goto L_0x01a6
            fg.j r0 = r6.f27179o
            float r0 = r0.m()
            goto L_0x01ac
        L_0x01a6:
            fg.j r0 = r6.f27179o
            float r0 = r0.h()
        L_0x01ac:
            com.github.mikephil.charting.components.Legend r1 = r6.f27133c
            float r1 = r1.f14853b
            float r1 = r1 + r2
            float r0 = r0 - r1
            goto L_0x01c0
        L_0x01b3:
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r0 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.CENTER
            if (r15 != r0) goto L_0x01b9
            r0 = 0
            goto L_0x01bf
        L_0x01b9:
            fg.j r0 = r6.f27179o
            float r0 = r0.e()
        L_0x01bf:
            float r0 = r0 + r2
        L_0x01c0:
            r9 = r0
            r10 = 0
            r15 = 0
            r18 = 0
        L_0x01c5:
            int r0 = r12.length
            if (r15 >= r0) goto L_0x03bf
            r4 = r12[r15]
            com.github.mikephil.charting.components.Legend$LegendForm r0 = r4.f14953b
            com.github.mikephil.charting.components.Legend$LegendForm r1 = com.github.mikephil.charting.components.Legend.LegendForm.NONE
            if (r0 == r1) goto L_0x01d3
            r19 = 1
            goto L_0x01d5
        L_0x01d3:
            r19 = 0
        L_0x01d5:
            float r0 = r4.f14954c
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 == 0) goto L_0x01e0
            r21 = r16
            goto L_0x01e8
        L_0x01e0:
            float r0 = r4.f14954c
            float r0 = fg.i.a((float) r0)
            r21 = r0
        L_0x01e8:
            if (r19 == 0) goto L_0x0218
            com.github.mikephil.charting.components.Legend$LegendDirection r0 = com.github.mikephil.charting.components.Legend.LegendDirection.LEFT_TO_RIGHT
            if (r5 != r0) goto L_0x01f1
            float r0 = r7 + r18
            goto L_0x01f5
        L_0x01f1:
            float r0 = r21 - r18
            float r0 = r7 - r0
        L_0x01f5:
            r22 = r0
            float r3 = r9 + r11
            com.github.mikephil.charting.components.Legend r2 = r6.f27133c
            r0 = r32
            r1 = r33
            r24 = r2
            r2 = r22
            r8 = r17
            r17 = r4
            r27 = r11
            r11 = r5
            r5 = r24
            r0.a(r1, r2, r3, r4, r5)
            com.github.mikephil.charting.components.Legend$LegendDirection r0 = com.github.mikephil.charting.components.Legend.LegendDirection.LEFT_TO_RIGHT
            if (r11 != r0) goto L_0x0215
            float r22 = r22 + r21
        L_0x0215:
            r0 = r17
            goto L_0x0220
        L_0x0218:
            r27 = r11
            r8 = r17
            r11 = r5
            r0 = r4
            r22 = r7
        L_0x0220:
            java.lang.String r1 = r0.f14952a
            if (r1 == 0) goto L_0x0262
            if (r19 == 0) goto L_0x0232
            if (r10 != 0) goto L_0x0232
            com.github.mikephil.charting.components.Legend$LegendDirection r1 = com.github.mikephil.charting.components.Legend.LegendDirection.LEFT_TO_RIGHT
            if (r11 != r1) goto L_0x022e
            r1 = r13
            goto L_0x022f
        L_0x022e:
            float r1 = -r13
        L_0x022f:
            float r22 = r22 + r1
            goto L_0x0236
        L_0x0232:
            if (r10 == 0) goto L_0x0236
            r22 = r7
        L_0x0236:
            com.github.mikephil.charting.components.Legend$LegendDirection r1 = com.github.mikephil.charting.components.Legend.LegendDirection.RIGHT_TO_LEFT
            if (r11 != r1) goto L_0x0245
            android.graphics.Paint r1 = r6.f27131a
            java.lang.String r2 = r0.f14952a
            int r1 = fg.i.a((android.graphics.Paint) r1, (java.lang.String) r2)
            float r1 = (float) r1
            float r22 = r22 - r1
        L_0x0245:
            r1 = r22
            if (r10 != 0) goto L_0x0250
            float r2 = r9 + r26
            java.lang.String r0 = r0.f14952a
            r5 = r33
            goto L_0x0259
        L_0x0250:
            r5 = r33
            float r2 = r26 + r14
            float r9 = r9 + r2
            float r2 = r9 + r26
            java.lang.String r0 = r0.f14952a
        L_0x0259:
            r6.a(r5, r1, r2, r0)
            float r0 = r26 + r14
            float r9 = r9 + r0
            r18 = 0
            goto L_0x0269
        L_0x0262:
            r5 = r33
            float r21 = r21 + r8
            float r18 = r18 + r21
            r10 = 1
        L_0x0269:
            int r15 = r15 + 1
            r17 = r8
            r5 = r11
            r11 = r27
            goto L_0x01c5
        L_0x0272:
            r27 = r11
            r8 = r17
            r11 = r5
            r5 = r33
            com.github.mikephil.charting.components.Legend r0 = r6.f27133c
            java.util.List r9 = r0.z()
            com.github.mikephil.charting.components.Legend r0 = r6.f27133c
            java.util.List r10 = r0.r()
            com.github.mikephil.charting.components.Legend r0 = r6.f27133c
            java.util.List r4 = r0.s()
            int[] r0 = fe.i.AnonymousClass1.f27138b
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r3 = 1
            if (r0 == r3) goto L_0x02bb
            r1 = 2
            if (r0 == r1) goto L_0x02ae
            r1 = 3
            if (r0 == r1) goto L_0x029e
            r2 = 0
            goto L_0x02bb
        L_0x029e:
            fg.j r0 = r6.f27179o
            float r0 = r0.m()
            com.github.mikephil.charting.components.Legend r1 = r6.f27133c
            float r1 = r1.f14853b
            float r0 = r0 - r1
            r1 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r1
            float r2 = r2 + r0
            goto L_0x02bb
        L_0x02ae:
            fg.j r0 = r6.f27179o
            float r0 = r0.m()
            float r0 = r0 - r2
            com.github.mikephil.charting.components.Legend r1 = r6.f27133c
            float r1 = r1.f14853b
            float r2 = r0 - r1
        L_0x02bb:
            int r1 = r12.length
            r17 = r7
            r0 = 0
            r3 = 0
        L_0x02c0:
            if (r0 >= r1) goto L_0x03bf
            r5 = r12[r0]
            r18 = r1
            com.github.mikephil.charting.components.Legend$LegendForm r1 = r5.f14953b
            r20 = r12
            com.github.mikephil.charting.components.Legend$LegendForm r12 = com.github.mikephil.charting.components.Legend.LegendForm.NONE
            if (r1 == r12) goto L_0x02d0
            r12 = 1
            goto L_0x02d1
        L_0x02d0:
            r12 = 0
        L_0x02d1:
            float r1 = r5.f14954c
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x02dc
            r22 = r16
            goto L_0x02e4
        L_0x02dc:
            float r1 = r5.f14954c
            float r1 = fg.i.a((float) r1)
            r22 = r1
        L_0x02e4:
            int r1 = r4.size()
            if (r0 >= r1) goto L_0x02fd
            java.lang.Object r1 = r4.get(r0)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x02fd
            float r1 = r26 + r14
            float r2 = r2 + r1
            r17 = r2
            r1 = r7
            goto L_0x0301
        L_0x02fd:
            r1 = r17
            r17 = r2
        L_0x0301:
            int r2 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r2 != 0) goto L_0x032d
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r2 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.CENTER
            if (r15 != r2) goto L_0x032d
            int r2 = r9.size()
            if (r3 >= r2) goto L_0x032d
            com.github.mikephil.charting.components.Legend$LegendDirection r2 = com.github.mikephil.charting.components.Legend.LegendDirection.RIGHT_TO_LEFT
            if (r11 != r2) goto L_0x031c
            java.lang.Object r2 = r9.get(r3)
            fg.b r2 = (fg.b) r2
            float r2 = r2.f27215a
            goto L_0x0325
        L_0x031c:
            java.lang.Object r2 = r9.get(r3)
            fg.b r2 = (fg.b) r2
            float r2 = r2.f27215a
            float r2 = -r2
        L_0x0325:
            r19 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r19
            float r1 = r1 + r2
            int r3 = r3 + 1
            goto L_0x032f
        L_0x032d:
            r19 = 1073741824(0x40000000, float:2.0)
        L_0x032f:
            r24 = r3
            java.lang.String r2 = r5.f14952a
            if (r2 != 0) goto L_0x0338
            r28 = 1
            goto L_0x033a
        L_0x0338:
            r28 = 0
        L_0x033a:
            if (r12 == 0) goto L_0x0366
            com.github.mikephil.charting.components.Legend$LegendDirection r2 = com.github.mikephil.charting.components.Legend.LegendDirection.RIGHT_TO_LEFT
            if (r11 != r2) goto L_0x0342
            float r1 = r1 - r22
        L_0x0342:
            r29 = r1
            float r3 = r17 + r27
            com.github.mikephil.charting.components.Legend r2 = r6.f27133c
            r1 = r0
            r0 = r32
            r6 = r1
            r1 = r33
            r30 = r2
            r2 = r29
            r23 = 1
            r31 = r4
            r4 = r5
            r5 = r30
            r0.a(r1, r2, r3, r4, r5)
            com.github.mikephil.charting.components.Legend$LegendDirection r0 = com.github.mikephil.charting.components.Legend.LegendDirection.LEFT_TO_RIGHT
            if (r11 != r0) goto L_0x0363
            float r1 = r29 + r22
            goto L_0x036b
        L_0x0363:
            r1 = r29
            goto L_0x036b
        L_0x0366:
            r6 = r0
            r31 = r4
            r23 = 1
        L_0x036b:
            if (r28 != 0) goto L_0x039e
            if (r12 == 0) goto L_0x0377
            com.github.mikephil.charting.components.Legend$LegendDirection r0 = com.github.mikephil.charting.components.Legend.LegendDirection.RIGHT_TO_LEFT
            if (r11 != r0) goto L_0x0375
            float r0 = -r13
            goto L_0x0376
        L_0x0375:
            r0 = r13
        L_0x0376:
            float r1 = r1 + r0
        L_0x0377:
            com.github.mikephil.charting.components.Legend$LegendDirection r0 = com.github.mikephil.charting.components.Legend.LegendDirection.RIGHT_TO_LEFT
            if (r11 != r0) goto L_0x0384
            java.lang.Object r0 = r10.get(r6)
            fg.b r0 = (fg.b) r0
            float r0 = r0.f27215a
            float r1 = r1 - r0
        L_0x0384:
            com.github.mikephil.charting.components.Legend$LegendDirection r0 = com.github.mikephil.charting.components.Legend.LegendDirection.LEFT_TO_RIGHT
            if (r11 != r0) goto L_0x0391
            java.lang.Object r0 = r10.get(r6)
            fg.b r0 = (fg.b) r0
            float r0 = r0.f27215a
            float r1 = r1 + r0
        L_0x0391:
            com.github.mikephil.charting.components.Legend$LegendDirection r0 = com.github.mikephil.charting.components.Legend.LegendDirection.RIGHT_TO_LEFT
            if (r11 != r0) goto L_0x0399
            r0 = r21
            float r2 = -r0
            goto L_0x039c
        L_0x0399:
            r0 = r21
            r2 = r0
        L_0x039c:
            float r1 = r1 + r2
            goto L_0x03a8
        L_0x039e:
            r0 = r21
            com.github.mikephil.charting.components.Legend$LegendDirection r2 = com.github.mikephil.charting.components.Legend.LegendDirection.RIGHT_TO_LEFT
            if (r11 != r2) goto L_0x03a6
            float r4 = -r8
            goto L_0x03a7
        L_0x03a6:
            r4 = r8
        L_0x03a7:
            float r1 = r1 + r4
        L_0x03a8:
            int r2 = r6 + 1
            r6 = r32
            r5 = r33
            r21 = r0
            r0 = r2
            r2 = r17
            r12 = r20
            r3 = r24
            r4 = r31
            r17 = r1
            r1 = r18
            goto L_0x02c0
        L_0x03bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.i.a(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f2, float f3, e eVar, Legend legend) {
        if (eVar.f14957f != 1122868 && eVar.f14957f != 1122867 && eVar.f14957f != 0) {
            int save = canvas.save();
            Legend.LegendForm legendForm = eVar.f14953b;
            if (legendForm == Legend.LegendForm.DEFAULT) {
                legendForm = legend.i();
            }
            this.f27132b.setColor(eVar.f14957f);
            float a2 = fg.i.a(Float.isNaN(eVar.f14954c) ? legend.j() : eVar.f14954c);
            float f4 = a2 / 2.0f;
            int i2 = AnonymousClass1.f27140d[legendForm.ordinal()];
            if (i2 == 3 || i2 == 4) {
                this.f27132b.setStyle(Paint.Style.FILL);
                canvas.drawCircle(f2 + f4, f3, f4, this.f27132b);
            } else if (i2 == 5) {
                this.f27132b.setStyle(Paint.Style.FILL);
                canvas.drawRect(f2, f3 - f4, f2 + a2, f3 + f4, this.f27132b);
            } else if (i2 == 6) {
                float a3 = fg.i.a(Float.isNaN(eVar.f14955d) ? legend.k() : eVar.f14955d);
                DashPathEffect l2 = eVar.f14956e == null ? legend.l() : eVar.f14956e;
                this.f27132b.setStyle(Paint.Style.STROKE);
                this.f27132b.setStrokeWidth(a3);
                this.f27132b.setPathEffect(l2);
                this.f27136f.reset();
                this.f27136f.moveTo(f2, f3);
                this.f27136f.lineTo(f2 + a2, f3);
                canvas.drawPath(this.f27136f, this.f27132b);
            }
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f2, float f3, String str) {
        canvas.drawText(str, f2, f3, this.f27131a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: com.github.mikephil.charting.data.h<?>} */
    /* JADX WARNING: type inference failed for: r7v2, types: [fc.e] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.github.mikephil.charting.data.h<?> r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            com.github.mikephil.charting.components.Legend r2 = r0.f27133c
            boolean r2 = r2.c()
            if (r2 != 0) goto L_0x01c1
            java.util.List<com.github.mikephil.charting.components.e> r2 = r0.f27134d
            r2.clear()
            r3 = 0
        L_0x0012:
            int r4 = r19.c()
            if (r3 >= r4) goto L_0x01a7
            fc.e r4 = r1.a((int) r3)
            java.util.List r5 = r4.b()
            int r6 = r4.u()
            boolean r7 = r4 instanceof fc.a
            if (r7 == 0) goto L_0x0096
            r7 = r4
            fc.a r7 = (fc.a) r7
            boolean r8 = r7.v()
            if (r8 == 0) goto L_0x0096
            java.lang.String[] r6 = r7.F()
            r8 = 0
        L_0x0036:
            int r9 = r5.size()
            if (r8 >= r9) goto L_0x0074
            int r9 = r7.A()
            if (r8 >= r9) goto L_0x0074
            java.util.List<com.github.mikephil.charting.components.e> r9 = r0.f27134d
            com.github.mikephil.charting.components.e r15 = new com.github.mikephil.charting.components.e
            int r10 = r6.length
            int r10 = r8 % r10
            r11 = r6[r10]
            com.github.mikephil.charting.components.Legend$LegendForm r12 = r4.l()
            float r13 = r4.m()
            float r14 = r4.n()
            android.graphics.DashPathEffect r16 = r4.o()
            java.lang.Object r10 = r5.get(r8)
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r17 = r10.intValue()
            r10 = r15
            r2 = r15
            r15 = r16
            r16 = r17
            r10.<init>(r11, r12, r13, r14, r15, r16)
            r9.add(r2)
            int r8 = r8 + 1
            goto L_0x0036
        L_0x0074:
            java.lang.String r2 = r7.f()
            if (r2 == 0) goto L_0x0093
            java.util.List<com.github.mikephil.charting.components.e> r2 = r0.f27134d
            com.github.mikephil.charting.components.e r12 = new com.github.mikephil.charting.components.e
            java.lang.String r6 = r4.f()
            com.github.mikephil.charting.components.Legend$LegendForm r7 = com.github.mikephil.charting.components.Legend.LegendForm.NONE
            r8 = 2143289344(0x7fc00000, float:NaN)
            r9 = 2143289344(0x7fc00000, float:NaN)
            r10 = 0
            r11 = 1122867(0x112233, float:1.573472E-39)
            r5 = r12
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r2.add(r12)
        L_0x0093:
            r2 = r1
            goto L_0x01a2
        L_0x0096:
            boolean r2 = r4 instanceof fc.i
            if (r2 == 0) goto L_0x00fe
            r2 = r4
            fc.i r2 = (fc.i) r2
            r7 = 0
        L_0x009e:
            int r8 = r5.size()
            if (r7 >= r8) goto L_0x00dd
            if (r7 >= r6) goto L_0x00dd
            java.util.List<com.github.mikephil.charting.components.e> r8 = r0.f27134d
            com.github.mikephil.charting.components.e r15 = new com.github.mikephil.charting.components.e
            com.github.mikephil.charting.data.Entry r9 = r2.d(r7)
            com.github.mikephil.charting.data.PieEntry r9 = (com.github.mikephil.charting.data.PieEntry) r9
            java.lang.String r10 = r9.a()
            com.github.mikephil.charting.components.Legend$LegendForm r11 = r4.l()
            float r12 = r4.m()
            float r13 = r4.n()
            android.graphics.DashPathEffect r14 = r4.o()
            java.lang.Object r9 = r5.get(r7)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r16 = r9.intValue()
            r9 = r15
            r1 = r15
            r15 = r16
            r9.<init>(r10, r11, r12, r13, r14, r15)
            r8.add(r1)
            int r7 = r7 + 1
            r1 = r19
            goto L_0x009e
        L_0x00dd:
            java.lang.String r1 = r2.f()
            if (r1 == 0) goto L_0x01a0
            java.util.List<com.github.mikephil.charting.components.e> r1 = r0.f27134d
            com.github.mikephil.charting.components.e r2 = new com.github.mikephil.charting.components.e
            java.lang.String r6 = r4.f()
            com.github.mikephil.charting.components.Legend$LegendForm r7 = com.github.mikephil.charting.components.Legend.LegendForm.NONE
            r8 = 2143289344(0x7fc00000, float:NaN)
            r9 = 2143289344(0x7fc00000, float:NaN)
            r10 = 0
            r11 = 1122867(0x112233, float:1.573472E-39)
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r1.add(r2)
            goto L_0x01a0
        L_0x00fe:
            boolean r1 = r4 instanceof fc.d
            if (r1 == 0) goto L_0x0153
            r1 = r4
            fc.d r1 = (fc.d) r1
            int r2 = r1.F()
            r7 = 1122867(0x112233, float:1.573472E-39)
            if (r2 == r7) goto L_0x0153
            int r14 = r1.F()
            int r1 = r1.E()
            java.util.List<com.github.mikephil.charting.components.e> r2 = r0.f27134d
            com.github.mikephil.charting.components.e r5 = new com.github.mikephil.charting.components.e
            r9 = 0
            com.github.mikephil.charting.components.Legend$LegendForm r10 = r4.l()
            float r11 = r4.m()
            float r12 = r4.n()
            android.graphics.DashPathEffect r13 = r4.o()
            r8 = r5
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r2.add(r5)
            java.util.List<com.github.mikephil.charting.components.e> r2 = r0.f27134d
            com.github.mikephil.charting.components.e r12 = new com.github.mikephil.charting.components.e
            java.lang.String r6 = r4.f()
            com.github.mikephil.charting.components.Legend$LegendForm r7 = r4.l()
            float r8 = r4.m()
            float r9 = r4.n()
            android.graphics.DashPathEffect r10 = r4.o()
            r5 = r12
            r11 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r2.add(r12)
            goto L_0x01a0
        L_0x0153:
            r1 = 0
        L_0x0154:
            int r2 = r5.size()
            if (r1 >= r2) goto L_0x01a0
            if (r1 >= r6) goto L_0x01a0
            int r2 = r5.size()
            int r2 = r2 + -1
            if (r1 >= r2) goto L_0x016d
            int r2 = r6 + -1
            if (r1 >= r2) goto L_0x016d
            r2 = 0
            r9 = r2
            r2 = r19
            goto L_0x0178
        L_0x016d:
            r2 = r19
            fc.e r7 = r2.a((int) r3)
            java.lang.String r7 = r7.f()
            r9 = r7
        L_0x0178:
            java.util.List<com.github.mikephil.charting.components.e> r7 = r0.f27134d
            com.github.mikephil.charting.components.e r15 = new com.github.mikephil.charting.components.e
            com.github.mikephil.charting.components.Legend$LegendForm r10 = r4.l()
            float r11 = r4.m()
            float r12 = r4.n()
            android.graphics.DashPathEffect r13 = r4.o()
            java.lang.Object r8 = r5.get(r1)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r14 = r8.intValue()
            r8 = r15
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r7.add(r15)
            int r1 = r1 + 1
            goto L_0x0154
        L_0x01a0:
            r2 = r19
        L_0x01a2:
            int r3 = r3 + 1
            r1 = r2
            goto L_0x0012
        L_0x01a7:
            com.github.mikephil.charting.components.Legend r1 = r0.f27133c
            com.github.mikephil.charting.components.e[] r1 = r1.b()
            if (r1 == 0) goto L_0x01ba
            java.util.List<com.github.mikephil.charting.components.e> r1 = r0.f27134d
            com.github.mikephil.charting.components.Legend r2 = r0.f27133c
            com.github.mikephil.charting.components.e[] r2 = r2.b()
            java.util.Collections.addAll(r1, r2)
        L_0x01ba:
            com.github.mikephil.charting.components.Legend r1 = r0.f27133c
            java.util.List<com.github.mikephil.charting.components.e> r2 = r0.f27134d
            r1.a((java.util.List<com.github.mikephil.charting.components.e>) r2)
        L_0x01c1:
            com.github.mikephil.charting.components.Legend r1 = r0.f27133c
            android.graphics.Typeface r1 = r1.v()
            if (r1 == 0) goto L_0x01ce
            android.graphics.Paint r2 = r0.f27131a
            r2.setTypeface(r1)
        L_0x01ce:
            android.graphics.Paint r1 = r0.f27131a
            com.github.mikephil.charting.components.Legend r2 = r0.f27133c
            float r2 = r2.w()
            r1.setTextSize(r2)
            android.graphics.Paint r1 = r0.f27131a
            com.github.mikephil.charting.components.Legend r2 = r0.f27133c
            int r2 = r2.x()
            r1.setColor(r2)
            com.github.mikephil.charting.components.Legend r1 = r0.f27133c
            android.graphics.Paint r2 = r0.f27131a
            fg.j r3 = r0.f27179o
            r1.a(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.i.a(com.github.mikephil.charting.data.h):void");
    }
}
