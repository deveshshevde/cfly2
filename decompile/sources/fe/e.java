package fe;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.g;
import ex.a;
import fb.d;
import fg.i;
import fg.j;
import java.util.List;

public class e extends l {

    /* renamed from: a  reason: collision with root package name */
    protected d f27115a;

    /* renamed from: b  reason: collision with root package name */
    private float[] f27116b = new float[8];

    /* renamed from: c  reason: collision with root package name */
    private float[] f27117c = new float[4];

    /* renamed from: d  reason: collision with root package name */
    private float[] f27118d = new float[4];

    /* renamed from: e  reason: collision with root package name */
    private float[] f27119e = new float[4];

    /* renamed from: l  reason: collision with root package name */
    private float[] f27120l = new float[4];

    public e(d dVar, a aVar, j jVar) {
        super(aVar, jVar);
        this.f27115a = dVar;
    }

    public void a() {
    }

    public void a(Canvas canvas) {
        for (fc.d dVar : this.f27115a.getCandleData().h()) {
            if (dVar.s()) {
                a(canvas, dVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0160  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.graphics.Canvas r26, fc.d r27) {
        /*
            r25 = this;
            r0 = r25
            r1 = r27
            fb.d r2 = r0.f27115a
            com.github.mikephil.charting.components.YAxis$AxisDependency r3 = r27.t()
            fg.g r2 = r2.a(r3)
            ex.a r3 = r0.f27125g
            float r3 = r3.a()
            float r4 = r27.v()
            boolean r5 = r27.A()
            fe.c$a r6 = r0.f27106f
            fb.d r7 = r0.f27115a
            r6.a(r7, r1)
            android.graphics.Paint r6 = r0.f27126h
            float r7 = r27.B()
            r6.setStrokeWidth(r7)
            fe.c$a r6 = r0.f27106f
            int r6 = r6.f27107a
        L_0x0030:
            fe.c$a r7 = r0.f27106f
            int r7 = r7.f27109c
            fe.c$a r8 = r0.f27106f
            int r8 = r8.f27107a
            int r7 = r7 + r8
            if (r6 > r7) goto L_0x0264
            com.github.mikephil.charting.data.Entry r7 = r1.d(r6)
            com.github.mikephil.charting.data.CandleEntry r7 = (com.github.mikephil.charting.data.CandleEntry) r7
            if (r7 != 0) goto L_0x0047
            r12 = r26
            goto L_0x0260
        L_0x0047:
            float r8 = r7.i()
            float r9 = r7.e()
            float r10 = r7.d()
            float r11 = r7.a()
            float r7 = r7.c()
            r13 = 1122867(0x112233, float:1.573472E-39)
            r14 = 2
            r15 = 0
            r16 = 3
            r17 = 1
            if (r5 == 0) goto L_0x01b4
            float[] r12 = r0.f27116b
            r12[r15] = r8
            r12[r14] = r8
            r19 = 4
            r12[r19] = r8
            r19 = 6
            r12[r19] = r8
            r19 = 7
            r20 = 5
            int r21 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r21 <= 0) goto L_0x008d
            float r11 = r11 * r3
            r12[r17] = r11
            float r11 = r9 * r3
            r12[r16] = r11
            float r7 = r7 * r3
            r12[r20] = r7
            float r7 = r10 * r3
            r12[r19] = r7
            goto L_0x00b0
        L_0x008d:
            int r21 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            float r11 = r11 * r3
            if (r21 >= 0) goto L_0x00a2
            r12[r17] = r11
            float r11 = r10 * r3
            r12[r16] = r11
            float r7 = r7 * r3
            r12[r20] = r7
            float r7 = r9 * r3
            r12[r19] = r7
            goto L_0x00b0
        L_0x00a2:
            r12[r17] = r11
            float r11 = r9 * r3
            r12[r16] = r11
            float r7 = r7 * r3
            r12[r20] = r7
            r7 = r12[r16]
            r12[r19] = r7
        L_0x00b0:
            r2.a((float[]) r12)
            boolean r7 = r27.I()
            if (r7 == 0) goto L_0x00eb
            int r7 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r7 <= 0) goto L_0x00cb
            android.graphics.Paint r7 = r0.f27126h
            int r11 = r27.F()
            if (r11 != r13) goto L_0x00c6
            goto L_0x00f3
        L_0x00c6:
            int r11 = r27.F()
            goto L_0x00fc
        L_0x00cb:
            int r7 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x00dd
            android.graphics.Paint r7 = r0.f27126h
            int r11 = r27.E()
            if (r11 != r13) goto L_0x00d8
            goto L_0x00f3
        L_0x00d8:
            int r11 = r27.E()
            goto L_0x00fc
        L_0x00dd:
            android.graphics.Paint r7 = r0.f27126h
            int r11 = r27.D()
            if (r11 != r13) goto L_0x00e6
            goto L_0x00f3
        L_0x00e6:
            int r11 = r27.D()
            goto L_0x00fc
        L_0x00eb:
            android.graphics.Paint r7 = r0.f27126h
            int r11 = r27.C()
            if (r11 != r13) goto L_0x00f8
        L_0x00f3:
            int r11 = r1.a((int) r6)
            goto L_0x00fc
        L_0x00f8:
            int r11 = r27.C()
        L_0x00fc:
            r7.setColor(r11)
            android.graphics.Paint r7 = r0.f27126h
            android.graphics.Paint$Style r11 = android.graphics.Paint.Style.STROKE
            r7.setStyle(r11)
            float[] r7 = r0.f27116b
            android.graphics.Paint r11 = r0.f27126h
            r12 = r26
            r12.drawLines(r7, r11)
            float[] r7 = r0.f27117c
            r11 = 1056964608(0x3f000000, float:0.5)
            float r18 = r8 - r11
            float r18 = r18 + r4
            r7[r15] = r18
            float r18 = r10 * r3
            r7[r17] = r18
            float r8 = r8 + r11
            float r8 = r8 - r4
            r7[r14] = r8
            float r8 = r9 * r3
            r7[r16] = r8
            r2.a((float[]) r7)
            int r7 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r7 <= 0) goto L_0x0160
            int r7 = r27.F()
            if (r7 != r13) goto L_0x0139
            android.graphics.Paint r7 = r0.f27126h
            int r8 = r1.a((int) r6)
            goto L_0x013f
        L_0x0139:
            android.graphics.Paint r7 = r0.f27126h
            int r8 = r27.F()
        L_0x013f:
            r7.setColor(r8)
            android.graphics.Paint r7 = r0.f27126h
            android.graphics.Paint$Style r8 = r27.H()
            r7.setStyle(r8)
            float[] r7 = r0.f27117c
            r20 = r7[r15]
            r21 = r7[r16]
            r22 = r7[r14]
            r23 = r7[r17]
        L_0x0155:
            android.graphics.Paint r7 = r0.f27126h
            r19 = r26
            r24 = r7
            r19.drawRect(r20, r21, r22, r23, r24)
            goto L_0x0260
        L_0x0160:
            int r7 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x018e
            int r7 = r27.E()
            if (r7 != r13) goto L_0x0171
            android.graphics.Paint r7 = r0.f27126h
            int r8 = r1.a((int) r6)
            goto L_0x0177
        L_0x0171:
            android.graphics.Paint r7 = r0.f27126h
            int r8 = r27.E()
        L_0x0177:
            r7.setColor(r8)
            android.graphics.Paint r7 = r0.f27126h
            android.graphics.Paint$Style r8 = r27.G()
            r7.setStyle(r8)
            float[] r7 = r0.f27117c
            r20 = r7[r15]
            r21 = r7[r17]
            r22 = r7[r14]
            r23 = r7[r16]
            goto L_0x0155
        L_0x018e:
            int r7 = r27.D()
            if (r7 != r13) goto L_0x019b
            android.graphics.Paint r7 = r0.f27126h
            int r8 = r1.a((int) r6)
            goto L_0x01a1
        L_0x019b:
            android.graphics.Paint r7 = r0.f27126h
            int r8 = r27.D()
        L_0x01a1:
            r7.setColor(r8)
            float[] r7 = r0.f27117c
            r20 = r7[r15]
            r21 = r7[r17]
            r22 = r7[r14]
            r23 = r7[r16]
            android.graphics.Paint r7 = r0.f27126h
            r19 = r26
            goto L_0x025b
        L_0x01b4:
            r12 = r26
            float[] r13 = r0.f27118d
            r13[r15] = r8
            float r11 = r11 * r3
            r13[r17] = r11
            r13[r14] = r8
            float r7 = r7 * r3
            r13[r16] = r7
            float[] r7 = r0.f27119e
            r11 = 1056964608(0x3f000000, float:0.5)
            float r18 = r8 - r11
            float r18 = r18 + r4
            r7[r15] = r18
            float r18 = r9 * r3
            r7[r17] = r18
            r7[r14] = r8
            r7[r16] = r18
            float[] r7 = r0.f27120l
            float r11 = r11 + r8
            float r11 = r11 - r4
            r7[r15] = r11
            float r11 = r10 * r3
            r7[r17] = r11
            r7[r14] = r8
            r7[r16] = r11
            r2.a((float[]) r13)
            float[] r7 = r0.f27119e
            r2.a((float[]) r7)
            float[] r7 = r0.f27120l
            r2.a((float[]) r7)
            int r7 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r7 <= 0) goto L_0x0208
            int r7 = r27.F()
            r8 = 1122867(0x112233, float:1.573472E-39)
            if (r7 != r8) goto L_0x0203
        L_0x01fe:
            int r7 = r1.a((int) r6)
            goto L_0x0226
        L_0x0203:
            int r7 = r27.F()
            goto L_0x0226
        L_0x0208:
            r8 = 1122867(0x112233, float:1.573472E-39)
            int r7 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x021b
            int r7 = r27.E()
            if (r7 != r8) goto L_0x0216
            goto L_0x01fe
        L_0x0216:
            int r7 = r27.E()
            goto L_0x0226
        L_0x021b:
            int r7 = r27.D()
            if (r7 != r8) goto L_0x0222
            goto L_0x01fe
        L_0x0222:
            int r7 = r27.D()
        L_0x0226:
            android.graphics.Paint r8 = r0.f27126h
            r8.setColor(r7)
            float[] r7 = r0.f27118d
            r20 = r7[r15]
            r21 = r7[r17]
            r22 = r7[r14]
            r23 = r7[r16]
            android.graphics.Paint r7 = r0.f27126h
            r19 = r26
            r24 = r7
            r19.drawLine(r20, r21, r22, r23, r24)
            float[] r7 = r0.f27119e
            r20 = r7[r15]
            r21 = r7[r17]
            r22 = r7[r14]
            r23 = r7[r16]
            android.graphics.Paint r7 = r0.f27126h
            r24 = r7
            r19.drawLine(r20, r21, r22, r23, r24)
            float[] r7 = r0.f27120l
            r20 = r7[r15]
            r21 = r7[r17]
            r22 = r7[r14]
            r23 = r7[r16]
            android.graphics.Paint r7 = r0.f27126h
        L_0x025b:
            r24 = r7
            r19.drawLine(r20, r21, r22, r23, r24)
        L_0x0260:
            int r6 = r6 + 1
            goto L_0x0030
        L_0x0264:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.e.a(android.graphics.Canvas, fc.d):void");
    }

    public void a(Canvas canvas, String str, float f2, float f3, int i2) {
        this.f27129k.setColor(i2);
        canvas.drawText(str, f2, f3, this.f27129k);
    }

    public void a(Canvas canvas, fa.d[] dVarArr) {
        g candleData = this.f27115a.getCandleData();
        for (fa.d dVar : dVarArr) {
            fc.d dVar2 = (fc.d) candleData.a(dVar.f());
            if (dVar2 != null && dVar2.g()) {
                CandleEntry candleEntry = (CandleEntry) dVar2.b(dVar.a(), dVar.b());
                if (a(candleEntry, dVar2)) {
                    fg.d b2 = this.f27115a.a(dVar2.t()).b(candleEntry.i(), ((candleEntry.c() * this.f27125g.a()) + (candleEntry.a() * this.f27125g.a())) / 2.0f);
                    dVar.a((float) b2.f27218a, (float) b2.f27219b);
                    a(canvas, (float) b2.f27218a, (float) b2.f27219b, dVar2);
                }
            }
        }
    }

    public void b(Canvas canvas) {
        fc.d dVar;
        float f2;
        CandleEntry candleEntry;
        if (a((fb.e) this.f27115a)) {
            List h2 = this.f27115a.getCandleData().h();
            for (int i2 = 0; i2 < h2.size(); i2++) {
                fc.d dVar2 = (fc.d) h2.get(i2);
                if (a(dVar2) && dVar2.u() >= 1) {
                    b((fc.e) dVar2);
                    fg.g a2 = this.f27115a.a(dVar2.t());
                    this.f27106f.a(this.f27115a, dVar2);
                    float[] a3 = a2.a(dVar2, this.f27125g.b(), this.f27125g.a(), this.f27106f.f27107a, this.f27106f.f27108b);
                    float a4 = i.a(5.0f);
                    ez.d h3 = dVar2.h();
                    fg.e a5 = fg.e.a(dVar2.r());
                    a5.f27222a = i.a(a5.f27222a);
                    a5.f27223b = i.a(a5.f27223b);
                    int i3 = 0;
                    while (i3 < a3.length) {
                        float f3 = a3[i3];
                        float f4 = a3[i3 + 1];
                        if (!this.f27179o.h(f3)) {
                            break;
                        }
                        if (!this.f27179o.g(f3) || !this.f27179o.f(f4)) {
                            dVar = dVar2;
                        } else {
                            int i4 = i3 / 2;
                            CandleEntry candleEntry2 = (CandleEntry) dVar2.d(this.f27106f.f27107a + i4);
                            if (dVar2.p()) {
                                candleEntry = candleEntry2;
                                f2 = f4;
                                float f5 = f4 - a4;
                                dVar = dVar2;
                                a(canvas, h3.a(candleEntry2), f3, f5, dVar2.c(i4));
                            } else {
                                candleEntry = candleEntry2;
                                f2 = f4;
                                dVar = dVar2;
                            }
                            if (candleEntry.g() != null && dVar.q()) {
                                Drawable g2 = candleEntry.g();
                                i.a(canvas, g2, (int) (f3 + a5.f27222a), (int) (f2 + a5.f27223b), g2.getIntrinsicWidth(), g2.getIntrinsicHeight());
                            }
                        }
                        i3 += 2;
                        dVar2 = dVar;
                    }
                    fg.e.b(a5);
                }
            }
        }
    }

    public void c(Canvas canvas) {
    }
}
