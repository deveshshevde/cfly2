package fe;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.i;
import ex.a;
import fa.d;
import fg.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class f extends g {

    /* renamed from: a  reason: collision with root package name */
    protected List<g> f27121a = new ArrayList(5);

    /* renamed from: b  reason: collision with root package name */
    protected WeakReference<Chart> f27122b;

    /* renamed from: c  reason: collision with root package name */
    protected List<d> f27123c = new ArrayList();

    /* renamed from: fe.f$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27124a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.github.mikephil.charting.charts.CombinedChart$DrawOrder[] r0 = com.github.mikephil.charting.charts.CombinedChart.DrawOrder.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27124a = r0
                com.github.mikephil.charting.charts.CombinedChart$DrawOrder r1 = com.github.mikephil.charting.charts.CombinedChart.DrawOrder.BAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27124a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.charts.CombinedChart$DrawOrder r1 = com.github.mikephil.charting.charts.CombinedChart.DrawOrder.BUBBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f27124a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.github.mikephil.charting.charts.CombinedChart$DrawOrder r1 = com.github.mikephil.charting.charts.CombinedChart.DrawOrder.LINE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f27124a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.github.mikephil.charting.charts.CombinedChart$DrawOrder r1 = com.github.mikephil.charting.charts.CombinedChart.DrawOrder.CANDLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f27124a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.github.mikephil.charting.charts.CombinedChart$DrawOrder r1 = com.github.mikephil.charting.charts.CombinedChart.DrawOrder.SCATTER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.f.AnonymousClass1.<clinit>():void");
        }
    }

    public f(CombinedChart combinedChart, a aVar, j jVar) {
        super(aVar, jVar);
        this.f27122b = new WeakReference<>(combinedChart);
        b();
    }

    public void a() {
        for (g a2 : this.f27121a) {
            a2.a();
        }
    }

    public void a(Canvas canvas) {
        for (g a2 : this.f27121a) {
            a2.a(canvas);
        }
    }

    public void a(Canvas canvas, d[] dVarArr) {
        Chart chart = (Chart) this.f27122b.get();
        if (chart != null) {
            for (g next : this.f27121a) {
                Object obj = null;
                if (next instanceof b) {
                    obj = ((b) next).f27100a.getBarData();
                } else if (next instanceof j) {
                    obj = ((j) next).f27141a.getLineData();
                } else if (next instanceof e) {
                    obj = ((e) next).f27115a.getCandleData();
                } else if (next instanceof p) {
                    obj = ((p) next).f27180a.getScatterData();
                } else if (next instanceof d) {
                    obj = ((d) next).f27111a.getBubbleData();
                }
                int indexOf = obj == null ? -1 : ((i) chart.getData()).o().indexOf(obj);
                this.f27123c.clear();
                for (d dVar : dVarArr) {
                    if (dVar.e() == indexOf || dVar.e() == -1) {
                        this.f27123c.add(dVar);
                    }
                }
                List<d> list = this.f27123c;
                next.a(canvas, (d[]) list.toArray(new d[list.size()]));
            }
        }
    }

    public void b() {
        Object obj;
        List<g> list;
        this.f27121a.clear();
        CombinedChart combinedChart = (CombinedChart) this.f27122b.get();
        if (combinedChart != null) {
            for (CombinedChart.DrawOrder ordinal : combinedChart.getDrawOrder()) {
                int i2 = AnonymousClass1.f27124a[ordinal.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 == 5 && combinedChart.getScatterData() != null) {
                                    list = this.f27121a;
                                    obj = new p(combinedChart, this.f27125g, this.f27179o);
                                }
                            } else if (combinedChart.getCandleData() != null) {
                                list = this.f27121a;
                                obj = new e(combinedChart, this.f27125g, this.f27179o);
                            }
                        } else if (combinedChart.getLineData() != null) {
                            list = this.f27121a;
                            obj = new j(combinedChart, this.f27125g, this.f27179o);
                        }
                    } else if (combinedChart.getBubbleData() != null) {
                        list = this.f27121a;
                        obj = new d(combinedChart, this.f27125g, this.f27179o);
                    }
                } else if (combinedChart.getBarData() != null) {
                    list = this.f27121a;
                    obj = new b(combinedChart, this.f27125g, this.f27179o);
                }
                list.add(obj);
            }
        }
    }

    public void b(Canvas canvas) {
        for (g b2 : this.f27121a) {
            b2.b(canvas);
        }
    }

    public void c(Canvas canvas) {
        for (g c2 : this.f27121a) {
            c2.c(canvas);
        }
    }
}
