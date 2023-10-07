package com.flypro.core.drone.variables.helpers;

import com.flypro.core.MAVLink.m;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.parameters.Parameter;
import dy.al;
import dy.r;
import fg.i;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lp.a;
import lp.b;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class MagnetometerCalibration implements DroneInterfaces.c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final DroneInterfaces.b f11585a;

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f11586b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final a f11587c = new a();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final a f11588d = new a();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<b> f11589e = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<b> f11590f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f11591g = new Runnable() {
        public void run() {
            MagnetometerCalibration.this.f11585a.removeCallbacks(this);
            if (MagnetometerCalibration.this.f11598n != null) {
                MagnetometerCalibration.this.f11598n.newEstimation(MagnetometerCalibration.this.f11587c, MagnetometerCalibration.this.f11588d, MagnetometerCalibration.this.f11589e, MagnetometerCalibration.this.f11590f, MagnetometerCalibration.this.f11596l, MagnetometerCalibration.this.f11597m);
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private final Runnable f11592h = new Runnable() {
        public void run() {
            MagnetometerCalibration.this.f11585a.removeCallbacks(this);
            if (MagnetometerCalibration.this.f11598n != null) {
                MagnetometerCalibration.this.f11598n.finished(MagnetometerCalibration.this.f11587c);
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f11593i = new Runnable() {
        public void run() {
            System.out.println("Runnable StopCalibration");
            MagnetometerCalibration.this.f11585a.removeCallbacks(this);
            MagnetometerCalibration.this.a();
        }
    };

    /* renamed from: j  reason: collision with root package name */
    private boolean f11594j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f11595k = false;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f11596l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public int f11597m = 0;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public OnMagCalibrationListener f11598n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public en.a f11599o;

    /* renamed from: p  reason: collision with root package name */
    private String f11600p;

    /* renamed from: q  reason: collision with root package name */
    private String f11601q;

    public interface OnMagCalibrationListener {
        void finished(a aVar);

        void newEstimation(a aVar, a aVar2, List<b> list, List<b> list2, int i2, int i3);
    }

    /* renamed from: com.flypro.core.drone.variables.helpers.MagnetometerCalibration$6  reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14343a;

        static {
            int[] iArr = new int[DroneInterfaces.DroneEventsType.values().length];
            f14343a = iArr;
            try {
                iArr[DroneInterfaces.DroneEventsType.MAGNETOMETER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public MagnetometerCalibration(en.a aVar, OnMagCalibrationListener onMagCalibrationListener, DroneInterfaces.b bVar) {
        this.f11599o = aVar;
        this.f11598n = onMagCalibrationListener;
        this.f11585a = bVar;
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
    }

    private void d() {
        try {
            Parameter b2 = this.f11599o.e().b("COMPASS_DEV_ID");
            Parameter b3 = this.f11599o.e().b("COMPASS_DEV_ID2");
            this.f11600p = b2.a();
            this.f11601q = b3.a();
            b2.f14456b = i.f27244a;
            this.f11599o.e().a(b2);
            b3.f14456b = i.f27244a;
            this.f11599o.e().a(b3);
            b2.f14456b = Double.valueOf(this.f11600p).doubleValue();
            this.f11599o.e().a(b2);
            b3.f14456b = Double.valueOf(this.f11601q).doubleValue();
            this.f11599o.e().a(b3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void e() {
        try {
            Parameter b2 = this.f11599o.e().b("SR1_EXT_STAT");
            Parameter b3 = this.f11599o.e().b("SR1_EXTRA1");
            Parameter b4 = this.f11599o.e().b("SR1_EXTRA2");
            Parameter b5 = this.f11599o.e().b("SR1_EXTRA3");
            Parameter b6 = this.f11599o.e().b("SR1_PARAMS");
            Parameter b7 = this.f11599o.e().b("SR1_POSITION");
            Parameter b8 = this.f11599o.e().b("SR1_RAW_CTRL");
            Parameter b9 = this.f11599o.e().b("SR1_RAW_SENS");
            Parameter b10 = this.f11599o.e().b("SR1_RC_CHAN");
            b2.f14456b = i.f27244a;
            this.f11599o.e().a(b2);
            b3.f14456b = i.f27244a;
            this.f11599o.e().a(b3);
            b4.f14456b = i.f27244a;
            this.f11599o.e().a(b4);
            b5.f14456b = i.f27244a;
            this.f11599o.e().a(b5);
            b6.f14456b = i.f27244a;
            this.f11599o.e().a(b6);
            b7.f14456b = i.f27244a;
            this.f11599o.e().a(b7);
            b8.f14456b = i.f27244a;
            this.f11599o.e().a(b8);
            b9.f14456b = i.f27244a;
            this.f11599o.e().a(b9);
            b10.f14456b = i.f27244a;
            this.f11599o.e().a(b10);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void f() {
        try {
            Parameter b2 = this.f11599o.e().b("SR1_EXT_STAT");
            Parameter b3 = this.f11599o.e().b("SR1_EXTRA1");
            Parameter b4 = this.f11599o.e().b("SR1_EXTRA2");
            Parameter b5 = this.f11599o.e().b("SR1_EXTRA3");
            Parameter b6 = this.f11599o.e().b("SR1_PARAMS");
            Parameter b7 = this.f11599o.e().b("SR1_POSITION");
            Parameter b8 = this.f11599o.e().b("SR1_RAW_CTRL");
            Parameter b9 = this.f11599o.e().b("SR1_RAW_SENS");
            Parameter b10 = this.f11599o.e().b("SR1_RC_CHAN");
            b2.f14456b = 2.0d;
            this.f11599o.e().a(b2);
            b3.f14456b = 10.0d;
            this.f11599o.e().a(b3);
            b4.f14456b = 2.0d;
            this.f11599o.e().a(b4);
            b5.f14456b = 2.0d;
            this.f11599o.e().a(b5);
            b6.f14456b = 10.0d;
            this.f11599o.e().a(b6);
            b7.f14456b = 3.0d;
            this.f11599o.e().a(b7);
            b8.f14456b = 3.0d;
            this.f11599o.e().a(b8);
            b9.f14456b = 2.0d;
            this.f11599o.e().a(b9);
            b10.f14456b = 5.0d;
            this.f11599o.e().a(b10);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void g() {
        try {
            Parameter b2 = this.f11599o.e().b("COMPASS_OFS_X");
            Parameter b3 = this.f11599o.e().b("COMPASS_OFS_Y");
            Parameter b4 = this.f11599o.e().b("COMPASS_OFS_Z");
            if (b2 != null && b3 != null && b4 != null) {
                b2.f14456b = i.f27244a;
                b3.f14456b = i.f27244a;
                b4.f14456b = i.f27244a;
                this.f11599o.e().a(b2);
                this.f11599o.e().a(b3);
                this.f11599o.e().a(b4);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void h() {
        try {
            Parameter b2 = this.f11599o.e().b("COMPASS_OFS2_X");
            Parameter b3 = this.f11599o.e().b("COMPASS_OFS2_Y");
            Parameter b4 = this.f11599o.e().b("COMPASS_OFS2_Z");
            if (b2 != null && b3 != null && b4 != null) {
                b2.f14456b = i.f27244a;
                b3.f14456b = i.f27244a;
                b4.f14456b = i.f27244a;
                this.f11599o.e().a(b2);
                this.f11599o.e().a(b3);
                this.f11599o.e().a(b4);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public int a(b bVar) {
        MagnetometerCalibration magnetometerCalibration = this;
        b bVar2 = bVar;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < magnetometerCalibration.f11589e.size(); i2++) {
            b bVar3 = new b(magnetometerCalibration.f11589e.get(i2).f30971a, magnetometerCalibration.f11589e.get(i2).f30972b, magnetometerCalibration.f11589e.get(i2).f30973c);
            double d2 = (double) f2;
            double sqrt = Math.sqrt(Math.pow(bVar3.f30971a + bVar2.f30971a, 2.0d) + Math.pow(bVar3.f30972b + bVar2.f30972b, 2.0d) + Math.pow(bVar3.f30973c + bVar2.f30973c, 2.0d));
            Double.isNaN(d2);
            f2 = (float) (d2 + sqrt);
        }
        float size = f2 / ((float) magnetometerCalibration.f11589e.size());
        int i3 = 3;
        int i4 = 4;
        float f3 = size / 3.0f;
        int i5 = 0;
        int i6 = 0;
        while (i5 <= i3) {
            double d3 = (double) i5;
            Double.isNaN(d3);
            double d4 = (double) i3;
            Double.isNaN(d4);
            double d5 = ((d3 + 0.5d) * 3.141592653589793d) / d4;
            int i7 = 0;
            while (i7 <= i4) {
                double d6 = (double) i7;
                Double.isNaN(d6);
                double d7 = (double) i4;
                Double.isNaN(d7);
                double d8 = (d6 * 6.283185307179586d) / d7;
                size = size;
                double d9 = (double) size;
                Double.isNaN(d9);
                double d10 = d5;
                Double.isNaN(d9);
                double cos = Math.cos(d10);
                Double.isNaN(d9);
                b bVar4 = new b((double) ((float) (Math.sin(d5) * Math.cos(d8) * d9)), (double) ((float) (Math.sin(d10) * Math.cos(d8) * d9)), (double) ((float) (d9 * cos)));
                bVar4.f30971a -= bVar2.f30971a;
                bVar4.f30972b -= bVar2.f30972b;
                bVar4.f30973c -= bVar2.f30973c;
                int i8 = 0;
                while (true) {
                    if (i8 >= magnetometerCalibration.f11589e.size()) {
                        break;
                    }
                    b bVar5 = new b(magnetometerCalibration.f11589e.get(i8).f30971a, magnetometerCalibration.f11589e.get(i8).f30972b, magnetometerCalibration.f11589e.get(i8).f30973c);
                    if (Math.sqrt(Math.pow(bVar4.f30971a + bVar5.f30971a, 2.0d) + Math.pow(bVar4.f30972b + bVar5.f30972b, 2.0d) + Math.pow(bVar4.f30973c + bVar5.f30973c, 2.0d)) < ((double) f3)) {
                        i6++;
                        break;
                    }
                    i8++;
                    magnetometerCalibration = this;
                    b bVar6 = bVar;
                }
                i7++;
                i4 = 4;
                magnetometerCalibration = this;
                bVar2 = bVar;
                d5 = d10;
            }
            i5++;
            i3 = 3;
            i4 = 4;
            magnetometerCalibration = this;
            bVar2 = bVar;
        }
        return i6;
    }

    public void a() {
        this.f11599o.b((DroneInterfaces.c) this);
        System.out.println("Stop Calibration.");
        c.a().d(new al(7));
        d();
        ExecutorService executorService = this.f11586b;
        if (executorService != null) {
            executorService.shutdownNow();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0069, code lost:
        if (r0.f11594j == false) goto L_0x004e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(en.a r19) {
        /*
            r18 = this;
            r0 = r18
            com.flypro.core.drone.variables.m r1 = r19.B()
            int[] r2 = r1.h()
            r3 = 1
            if (r2 != 0) goto L_0x0023
            lp.b r2 = new lp.b
            int r4 = r1.a()
            double r5 = (double) r4
            int r4 = r1.c()
            double r7 = (double) r4
            int r4 = r1.e()
            double r9 = (double) r4
            r4 = r2
            r4.<init>(r5, r7, r9)
            goto L_0x0046
        L_0x0023:
            lp.b r4 = new lp.b
            int r5 = r1.a()
            r6 = 0
            r6 = r2[r6]
            int r5 = r5 - r6
            double r12 = (double) r5
            int r5 = r1.c()
            r6 = r2[r3]
            int r5 = r5 - r6
            double r14 = (double) r5
            int r5 = r1.e()
            r6 = 2
            r2 = r2[r6]
            int r5 = r5 - r2
            double r5 = (double) r5
            r11 = r4
            r16 = r5
            r11.<init>(r12, r14, r16)
            r2 = r4
        L_0x0046:
            java.util.ArrayList<lp.b> r4 = r0.f11589e
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0054
        L_0x004e:
            java.util.ArrayList<lp.b> r4 = r0.f11589e
            r4.add(r2)
            goto L_0x006c
        L_0x0054:
            java.util.ArrayList<lp.b> r4 = r0.f11589e
            int r5 = r4.size()
            int r5 = r5 - r3
            java.lang.Object r4 = r4.get(r5)
            lp.b r4 = (lp.b) r4
            boolean r4 = r0.a(r4, r2)
            if (r4 != 0) goto L_0x006c
            boolean r4 = r0.f11594j
            if (r4 != 0) goto L_0x006c
            goto L_0x004e
        L_0x006c:
            boolean r2 = r1.g()
            if (r2 == 0) goto L_0x00ad
            lp.b r2 = new lp.b
            int r4 = r1.b()
            double r5 = (double) r4
            int r4 = r1.d()
            double r7 = (double) r4
            int r1 = r1.f()
            double r9 = (double) r1
            r4 = r2
            r4.<init>(r5, r7, r9)
            java.util.ArrayList<lp.b> r1 = r0.f11590f
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0095
        L_0x008f:
            java.util.ArrayList<lp.b> r1 = r0.f11590f
            r1.add(r2)
            goto L_0x00ad
        L_0x0095:
            java.util.ArrayList<lp.b> r1 = r0.f11590f
            int r4 = r1.size()
            int r4 = r4 - r3
            java.lang.Object r1 = r1.get(r4)
            lp.b r1 = (lp.b) r1
            boolean r1 = r0.a(r1, r2)
            if (r1 != 0) goto L_0x00ad
            boolean r1 = r0.f11595k
            if (r1 != 0) goto L_0x00ad
            goto L_0x008f
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flypro.core.drone.variables.helpers.MagnetometerCalibration.a(en.a):void");
    }

    public void a(List<? extends b> list) {
        System.out.println("Calibration Start...");
        this.f11594j = false;
        this.f11595k = false;
        this.f11596l = 0;
        this.f11597m = 0;
        this.f11589e.clear();
        this.f11590f.clear();
        g();
        h();
        e();
        if (list != null && !list.isEmpty()) {
            this.f11589e.addAll(list);
        }
        ExecutorService executorService = this.f11586b;
        if (executorService != null && !executorService.isShutdown()) {
            this.f11586b.shutdownNow();
        }
        this.f11586b = Executors.newSingleThreadExecutor();
        m.a(this.f11599o.j(), 0, 0, 0, 0, 0, 0, 50, 0, 0);
        this.f11599o.a((DroneInterfaces.c) this);
    }

    /* access modifiers changed from: package-private */
    public boolean a(b bVar, b bVar2) {
        return bVar.f30971a - bVar2.f30971a < 15.0d && bVar.f30972b - bVar2.f30972b < 15.0d && bVar.f30973c - bVar2.f30973c < 15.0d;
    }

    /* access modifiers changed from: package-private */
    public int b(b bVar) {
        MagnetometerCalibration magnetometerCalibration = this;
        b bVar2 = bVar;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < magnetometerCalibration.f11590f.size(); i2++) {
            b bVar3 = new b(magnetometerCalibration.f11590f.get(i2).f30971a, magnetometerCalibration.f11590f.get(i2).f30972b, magnetometerCalibration.f11590f.get(i2).f30973c);
            double d2 = (double) f2;
            double sqrt = Math.sqrt(Math.pow(bVar3.f30971a + bVar2.f30971a, 2.0d) + Math.pow(bVar3.f30972b + bVar2.f30972b, 2.0d) + Math.pow(bVar3.f30973c + bVar2.f30973c, 2.0d));
            Double.isNaN(d2);
            f2 = (float) (d2 + sqrt);
        }
        float size = f2 / ((float) magnetometerCalibration.f11590f.size());
        int i3 = 3;
        int i4 = 4;
        float f3 = size / 3.0f;
        int i5 = 0;
        int i6 = 0;
        while (i5 <= i3) {
            double d3 = (double) i5;
            Double.isNaN(d3);
            double d4 = (double) i3;
            Double.isNaN(d4);
            double d5 = ((d3 + 0.5d) * 3.141592653589793d) / d4;
            int i7 = 0;
            while (i7 <= i4) {
                double d6 = (double) i7;
                Double.isNaN(d6);
                double d7 = (double) i4;
                Double.isNaN(d7);
                double d8 = (d6 * 6.283185307179586d) / d7;
                size = size;
                double d9 = (double) size;
                Double.isNaN(d9);
                double d10 = d5;
                Double.isNaN(d9);
                double cos = Math.cos(d10);
                Double.isNaN(d9);
                b bVar4 = new b((double) ((float) (Math.sin(d5) * Math.cos(d8) * d9)), (double) ((float) (Math.sin(d10) * Math.cos(d8) * d9)), (double) ((float) (d9 * cos)));
                bVar4.f30971a -= bVar2.f30971a;
                bVar4.f30972b -= bVar2.f30972b;
                bVar4.f30973c -= bVar2.f30973c;
                int i8 = 0;
                while (true) {
                    if (i8 >= magnetometerCalibration.f11590f.size()) {
                        break;
                    }
                    b bVar5 = new b(magnetometerCalibration.f11590f.get(i8).f30971a, magnetometerCalibration.f11590f.get(i8).f30972b, magnetometerCalibration.f11590f.get(i8).f30973c);
                    if (Math.sqrt(Math.pow(bVar4.f30971a + bVar5.f30971a, 2.0d) + Math.pow(bVar4.f30972b + bVar5.f30972b, 2.0d) + Math.pow(bVar4.f30973c + bVar5.f30973c, 2.0d)) < ((double) f3)) {
                        i6++;
                        break;
                    }
                    i8++;
                    magnetometerCalibration = this;
                    b bVar6 = bVar;
                }
                i7++;
                i4 = 4;
                magnetometerCalibration = this;
                bVar2 = bVar;
                d5 = d10;
            }
            i5++;
            i3 = 3;
            i4 = 4;
            magnetometerCalibration = this;
            bVar2 = bVar;
        }
        return i6;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!this.f11589e.isEmpty()) {
            if (!this.f11594j || !this.f11595k) {
                this.f11587c.a(this.f11589e);
                if (this.f11599o.B().g()) {
                    this.f11588d.a(this.f11590f);
                }
                if (this.f11598n != null) {
                    this.f11585a.post(this.f11591g);
                }
                if (this.f11587c.f30965a != null) {
                    this.f11596l = a(new b(-this.f11587c.f30965a.a(0), -this.f11587c.f30965a.a(1), -this.f11587c.f30965a.a(2)));
                    this.f11597m = (!this.f11599o.B().g() || this.f11590f.size() <= 10 || this.f11588d.f30965a == null) ? this.f11596l : b(new b(-this.f11588d.f30965a.a(0), -this.f11588d.f30965a.a(1), -this.f11588d.f30965a.a(2)));
                    if (!this.f11594j && this.f11589e.size() >= 100) {
                        if (this.f11596l >= 11) {
                            this.f11594j = true;
                        }
                        if (this.f11587c.a() >= 0.92d) {
                            this.f11594j = true;
                        }
                    }
                    if (!this.f11599o.B().g()) {
                        this.f11595k = this.f11594j;
                    } else if (!this.f11595k && this.f11590f.size() >= 100) {
                        if (this.f11597m >= 11) {
                            this.f11595k = true;
                        }
                        if (this.f11588d.a() >= 0.92d) {
                            this.f11595k = true;
                        }
                    }
                    System.out.println(String.format("fit Result(1:2): samples:%d,%d fitness:%.4f,%.4f pointhit:%d,%d", new Object[]{Integer.valueOf(this.f11589e.size()), Integer.valueOf(this.f11590f.size()), Double.valueOf(this.f11587c.a()), Double.valueOf(this.f11588d.a()), Integer.valueOf(this.f11596l), Integer.valueOf(this.f11597m)}));
                    if (this.f11594j || this.f11595k) {
                        if (this.f11598n != null) {
                            this.f11585a.post(this.f11592h);
                        }
                        this.f11585a.post(this.f11593i);
                    }
                }
            }
        }
    }

    public double[] c() throws Exception {
        Parameter b2 = this.f11599o.e().b("COMPASS_OFS_X");
        Parameter b3 = this.f11599o.e().b("COMPASS_OFS_Y");
        Parameter b4 = this.f11599o.e().b("COMPASS_OFS_Z");
        if (b2 == null || b3 == null || b4 == null) {
            throw new Exception("Parameters COMPASS_OFS have not been loaded");
        }
        double[] offsets = getOffsets();
        b2.f14456b = offsets[0];
        b3.f14456b = offsets[1];
        b4.f14456b = offsets[2];
        this.f11599o.e().a(b2);
        this.f11599o.e().a(b3);
        this.f11599o.e().a(b4);
        System.out.println(String.format("Compass1 offsets x=%.2f y=%.2f z=%.2f", new Object[]{Double.valueOf(b2.f14456b), Double.valueOf(b3.f14456b), Double.valueOf(b4.f14456b)}));
        Parameter b5 = this.f11599o.e().b("COMPASS_OFS2_X");
        Parameter b6 = this.f11599o.e().b("COMPASS_OFS2_Y");
        Parameter b7 = this.f11599o.e().b("COMPASS_OFS2_Z");
        if (b5 == null || b6 == null || b7 == null) {
            throw new Exception("Parameters COMPASS_OFS2 have not been loaded");
        }
        double[] offsets2 = this.f11599o.B().g() ? new double[]{getOffsets()[3], getOffsets()[4], getOffsets()[5]} : getOffsets();
        b5.f14456b = offsets2[0];
        b6.f14456b = offsets2[1];
        b7.f14456b = offsets2[2];
        this.f11599o.e().a(b5);
        this.f11599o.e().a(b6);
        this.f11599o.e().a(b7);
        System.out.println(String.format("Compass2 offsets x=%.2f y=%.2f z=%.2f", new Object[]{Double.valueOf(b5.f14456b), Double.valueOf(b6.f14456b), Double.valueOf(b7.f14456b)}));
        f();
        return getOffsets();
    }

    @l(a = ThreadMode.ASYNC)
    public void droneMagnetometerEvent(r rVar) {
        if (rVar.a() == 42) {
            a(this.f11599o);
            this.f11586b.execute(new Runnable() {
                public void run() {
                    MagnetometerCalibration.this.b();
                    m.a(MagnetometerCalibration.this.f11599o.j(), 0, 0, 0, 0, 0, 0, 50, 0, 0);
                }
            });
        }
    }

    public double[] getOffsets() {
        double[] dArr = {i.f27244a, i.f27244a, i.f27244a, i.f27244a, i.f27244a, i.f27244a};
        if (this.f11587c.f30965a != null) {
            dArr[0] = (double) ((short) ((int) (-this.f11587c.f30965a.a(0))));
            dArr[1] = (double) ((short) ((int) (-this.f11587c.f30965a.a(1))));
            dArr[2] = (double) ((short) ((int) (-this.f11587c.f30965a.a(2))));
        }
        if (this.f11588d.f30965a != null) {
            dArr[3] = (double) ((short) ((int) (-this.f11588d.f30965a.a(0))));
            dArr[4] = (double) ((short) ((int) (-this.f11588d.f30965a.a(1))));
            dArr[5] = (double) ((short) ((int) (-this.f11588d.f30965a.a(2))));
        }
        return dArr;
    }

    public List<b> getPoints() {
        return this.f11589e;
    }

    public List<b> getPoints2() {
        return this.f11590f;
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, final en.a aVar) {
        if (AnonymousClass6.f14343a[droneEventsType.ordinal()] == 1) {
            a(aVar);
            this.f11586b.execute(new Runnable() {
                public void run() {
                    MagnetometerCalibration.this.b();
                    m.a(aVar.j(), 0, 0, 0, 0, 0, 0, 50, 0, 0);
                }
            });
        }
    }
}
