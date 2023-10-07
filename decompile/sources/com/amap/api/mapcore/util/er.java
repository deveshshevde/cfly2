package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.LBSTraceBase;
import com.amap.api.trace.LBSTraceClient;
import com.amap.api.trace.TraceListener;
import com.amap.api.trace.TraceLocation;
import com.amap.api.trace.TraceStatusListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class er implements LocationSource.OnLocationChangedListener, LBSTraceBase {

    /* renamed from: a  reason: collision with root package name */
    int f8550a = Runtime.getRuntime().availableProcessors();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f8551b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public CoordinateConverter f8552c;

    /* renamed from: d  reason: collision with root package name */
    private id f8553d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public id f8554e;

    /* renamed from: f  reason: collision with root package name */
    private long f8555f = 2000;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f8556g = 5;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TraceStatusListener f8557h;

    /* renamed from: i  reason: collision with root package name */
    private ak f8558i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public List<TraceLocation> f8559j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    private int f8560k = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f8561l = 0;

    /* renamed from: m  reason: collision with root package name */
    private long f8562m = 0;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public c f8563n;

    /* renamed from: o  reason: collision with root package name */
    private TraceLocation f8564o = null;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public List<LatLng> f8565p = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public List<LatLng> f8566q = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public List<LatLng> f8567r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    private BlockingQueue<Runnable> f8568s = new LinkedBlockingQueue();

    /* renamed from: t  reason: collision with root package name */
    private BlockingQueue<Runnable> f8569t = new LinkedBlockingQueue();

    class a extends ie {

        /* renamed from: b  reason: collision with root package name */
        private List<TraceLocation> f8571b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private int f8572c;

        /* renamed from: d  reason: collision with root package name */
        private int f8573d;

        /* renamed from: e  reason: collision with root package name */
        private List<TraceLocation> f8574e;

        /* renamed from: g  reason: collision with root package name */
        private String f8575g;

        /* renamed from: h  reason: collision with root package name */
        private TraceListener f8576h;

        public a(int i2, List<TraceLocation> list, int i3, TraceListener traceListener) {
            this.f8572c = i3;
            this.f8573d = i2;
            this.f8574e = list;
            this.f8575g = dd.a();
            this.f8576h = traceListener;
        }

        private int a() {
            List<TraceLocation> list = this.f8574e;
            int i2 = 0;
            if (!(list == null || list.size() == 0)) {
                ArrayList arrayList = new ArrayList();
                for (TraceLocation next : this.f8574e) {
                    if (next != null) {
                        if (((double) next.getSpeed()) < 0.01d) {
                            arrayList.add(next);
                        } else {
                            i2 += a(arrayList);
                            arrayList.clear();
                        }
                    }
                }
            }
            return i2;
        }

        private static int a(List<TraceLocation> list) {
            int size = list.size();
            if (size <= 1) {
                return 0;
            }
            TraceLocation traceLocation = list.get(0);
            TraceLocation traceLocation2 = list.get(size - 1);
            if (traceLocation == null || traceLocation2 == null || traceLocation == null || traceLocation2 == null) {
                return 0;
            }
            return (int) ((traceLocation2.getTime() - traceLocation.getTime()) / 1000);
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x00c3 A[Catch:{ InterruptedException -> 0x010c, all -> 0x0125 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void runTask() {
            /*
                r15 = this;
                com.amap.api.mapcore.util.er r0 = com.amap.api.mapcore.util.er.this     // Catch:{ all -> 0x0125 }
                com.amap.api.mapcore.util.er$c r0 = r0.f8563n     // Catch:{ all -> 0x0125 }
                com.amap.api.trace.TraceListener r1 = r15.f8576h     // Catch:{ all -> 0x0125 }
                r0.a(r1)     // Catch:{ all -> 0x0125 }
                int r0 = r15.a()     // Catch:{ all -> 0x0125 }
                java.util.List<com.amap.api.trace.TraceLocation> r1 = r15.f8574e     // Catch:{ all -> 0x0125 }
                if (r1 == 0) goto L_0x0114
                int r1 = r1.size()     // Catch:{ all -> 0x0125 }
                r2 = 2
                if (r1 >= r2) goto L_0x001c
                goto L_0x0114
            L_0x001c:
                java.util.List<com.amap.api.trace.TraceLocation> r1 = r15.f8574e     // Catch:{ all -> 0x0125 }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0125 }
            L_0x0022:
                boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0125 }
                if (r3 == 0) goto L_0x004c
                java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0125 }
                com.amap.api.trace.TraceLocation r3 = (com.amap.api.trace.TraceLocation) r3     // Catch:{ all -> 0x0125 }
                com.amap.api.trace.TraceLocation r3 = r3.copy()     // Catch:{ all -> 0x0125 }
                if (r3 == 0) goto L_0x0022
                double r4 = r3.getLatitude()     // Catch:{ all -> 0x0125 }
                r6 = 0
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 <= 0) goto L_0x0022
                double r4 = r3.getLongitude()     // Catch:{ all -> 0x0125 }
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 <= 0) goto L_0x0022
                java.util.List<com.amap.api.trace.TraceLocation> r4 = r15.f8571b     // Catch:{ all -> 0x0125 }
                r4.add(r3)     // Catch:{ all -> 0x0125 }
                goto L_0x0022
            L_0x004c:
                java.util.List<com.amap.api.trace.TraceLocation> r1 = r15.f8571b     // Catch:{ all -> 0x0125 }
                int r1 = r1.size()     // Catch:{ all -> 0x0125 }
                int r1 = r1 - r2
                r3 = 500(0x1f4, float:7.0E-43)
                int r1 = r1 / r3
                com.amap.api.mapcore.util.es r4 = com.amap.api.mapcore.util.es.a()     // Catch:{ all -> 0x0125 }
                java.lang.String r5 = r15.f8575g     // Catch:{ all -> 0x0125 }
                int r6 = r15.f8573d     // Catch:{ all -> 0x0125 }
                r4.a(r5, r6, r1, r0)     // Catch:{ all -> 0x0125 }
                r0 = 0
                r4 = 500(0x1f4, float:7.0E-43)
                r11 = 0
            L_0x0065:
                if (r11 > r1) goto L_0x0113
                if (r11 != r1) goto L_0x006f
                java.util.List<com.amap.api.trace.TraceLocation> r4 = r15.f8571b     // Catch:{ all -> 0x0125 }
                int r4 = r4.size()     // Catch:{ all -> 0x0125 }
            L_0x006f:
                r12 = r4
                java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0125 }
                r7.<init>()     // Catch:{ all -> 0x0125 }
                r4 = 0
            L_0x0076:
                if (r4 >= r12) goto L_0x00d3
                java.util.List<com.amap.api.trace.TraceLocation> r5 = r15.f8571b     // Catch:{ all -> 0x0125 }
                java.lang.Object r5 = r5.remove(r0)     // Catch:{ all -> 0x0125 }
                com.amap.api.trace.TraceLocation r5 = (com.amap.api.trace.TraceLocation) r5     // Catch:{ all -> 0x0125 }
                if (r5 == 0) goto L_0x00d0
                int r6 = r15.f8572c     // Catch:{ all -> 0x0125 }
                r8 = 1
                if (r6 == r8) goto L_0x00cd
                r8 = 3
                if (r6 != r8) goto L_0x0096
                com.amap.api.mapcore.util.er r6 = com.amap.api.mapcore.util.er.this     // Catch:{ all -> 0x0125 }
                com.amap.api.maps.CoordinateConverter r6 = r6.f8552c     // Catch:{ all -> 0x0125 }
                com.amap.api.maps.CoordinateConverter$CoordType r8 = com.amap.api.maps.CoordinateConverter.CoordType.BAIDU     // Catch:{ all -> 0x0125 }
            L_0x0092:
                r6.from(r8)     // Catch:{ all -> 0x0125 }
                goto L_0x00a1
            L_0x0096:
                if (r6 != r2) goto L_0x00a1
                com.amap.api.mapcore.util.er r6 = com.amap.api.mapcore.util.er.this     // Catch:{ all -> 0x0125 }
                com.amap.api.maps.CoordinateConverter r6 = r6.f8552c     // Catch:{ all -> 0x0125 }
                com.amap.api.maps.CoordinateConverter$CoordType r8 = com.amap.api.maps.CoordinateConverter.CoordType.GPS     // Catch:{ all -> 0x0125 }
                goto L_0x0092
            L_0x00a1:
                com.amap.api.maps.model.LatLng r6 = new com.amap.api.maps.model.LatLng     // Catch:{ all -> 0x0125 }
                double r8 = r5.getLatitude()     // Catch:{ all -> 0x0125 }
                double r13 = r5.getLongitude()     // Catch:{ all -> 0x0125 }
                r6.<init>(r8, r13)     // Catch:{ all -> 0x0125 }
                com.amap.api.mapcore.util.er r8 = com.amap.api.mapcore.util.er.this     // Catch:{ all -> 0x0125 }
                com.amap.api.maps.CoordinateConverter r8 = r8.f8552c     // Catch:{ all -> 0x0125 }
                r8.coord(r6)     // Catch:{ all -> 0x0125 }
                com.amap.api.mapcore.util.er r6 = com.amap.api.mapcore.util.er.this     // Catch:{ all -> 0x0125 }
                com.amap.api.maps.CoordinateConverter r6 = r6.f8552c     // Catch:{ all -> 0x0125 }
                com.amap.api.maps.model.LatLng r6 = r6.convert()     // Catch:{ all -> 0x0125 }
                if (r6 == 0) goto L_0x00cd
                double r8 = r6.latitude     // Catch:{ all -> 0x0125 }
                r5.setLatitude(r8)     // Catch:{ all -> 0x0125 }
                double r8 = r6.longitude     // Catch:{ all -> 0x0125 }
                r5.setLongitude(r8)     // Catch:{ all -> 0x0125 }
            L_0x00cd:
                r7.add(r5)     // Catch:{ all -> 0x0125 }
            L_0x00d0:
                int r4 = r4 + 1
                goto L_0x0076
            L_0x00d3:
                int r4 = r7.size()     // Catch:{ all -> 0x0125 }
                if (r4 < r2) goto L_0x0110
                int r4 = r7.size()     // Catch:{ all -> 0x0125 }
                if (r4 > r3) goto L_0x0110
                com.amap.api.mapcore.util.eq r13 = new com.amap.api.mapcore.util.eq     // Catch:{ all -> 0x0125 }
                com.amap.api.mapcore.util.er r4 = com.amap.api.mapcore.util.er.this     // Catch:{ all -> 0x0125 }
                android.content.Context r5 = r4.f8551b     // Catch:{ all -> 0x0125 }
                com.amap.api.mapcore.util.er r4 = com.amap.api.mapcore.util.er.this     // Catch:{ all -> 0x0125 }
                com.amap.api.mapcore.util.er$c r6 = r4.f8563n     // Catch:{ all -> 0x0125 }
                java.lang.String r8 = r15.f8575g     // Catch:{ all -> 0x0125 }
                int r9 = r15.f8573d     // Catch:{ all -> 0x0125 }
                r4 = r13
                r10 = r11
                r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0125 }
                com.amap.api.mapcore.util.er r4 = com.amap.api.mapcore.util.er.this     // Catch:{ all -> 0x0125 }
                com.amap.api.mapcore.util.id r4 = r4.f8554e     // Catch:{ all -> 0x0125 }
                com.amap.api.mapcore.util.er$a$1 r5 = new com.amap.api.mapcore.util.er$a$1     // Catch:{ all -> 0x0125 }
                r5.<init>(r13)     // Catch:{ all -> 0x0125 }
                r4.a(r5)     // Catch:{ all -> 0x0125 }
                int r11 = r11 + 1
                r4 = 50
                java.lang.Thread.sleep(r4)     // Catch:{ InterruptedException -> 0x010c }
                goto L_0x0110
            L_0x010c:
                r4 = move-exception
                r4.printStackTrace()     // Catch:{ all -> 0x0125 }
            L_0x0110:
                r4 = r12
                goto L_0x0065
            L_0x0113:
                return
            L_0x0114:
                com.amap.api.mapcore.util.es.a()     // Catch:{ all -> 0x0125 }
                com.amap.api.mapcore.util.er r0 = com.amap.api.mapcore.util.er.this     // Catch:{ all -> 0x0125 }
                com.amap.api.mapcore.util.er$c r0 = r0.f8563n     // Catch:{ all -> 0x0125 }
                int r1 = r15.f8573d     // Catch:{ all -> 0x0125 }
                java.lang.String r2 = "轨迹点太少或距离太近,轨迹纠偏失败"
                com.amap.api.mapcore.util.es.a((android.os.Handler) r0, (int) r1, (java.lang.String) r2)     // Catch:{ all -> 0x0125 }
                return
            L_0x0125:
                r0 = move-exception
                r0.printStackTrace()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.er.a.runTask():void");
        }
    }

    class b implements TraceListener {

        /* renamed from: b  reason: collision with root package name */
        private final List<TraceLocation> f8580b;

        public b(List<TraceLocation> list) {
            this.f8580b = list;
        }

        private void a(int i2, List<LatLng> list) {
            List c2;
            List a2;
            try {
                synchronized (er.this.f8567r) {
                    er.this.f8567r.clear();
                    er.this.f8567r.addAll(list);
                }
                er.this.f8566q.clear();
                if (i2 == 0) {
                    c2 = er.this.f8566q;
                    a2 = er.this.f8567r;
                } else {
                    er.this.f8566q.addAll(er.this.f8565p);
                    c2 = er.this.f8566q;
                    a2 = er.this.f8567r;
                }
                c2.addAll(a2);
                er.this.f8557h.onTraceStatus(er.this.f8559j, er.this.f8566q, LBSTraceClient.TRACE_SUCCESS);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public final void onFinished(int i2, List<LatLng> list, int i3, int i4) {
            a(i2, list);
        }

        public final void onRequestFailed(int i2, String str) {
            ArrayList arrayList = new ArrayList();
            if (er.this.f8567r != null) {
                arrayList.addAll(er.this.f8567r);
            }
            List<TraceLocation> list = this.f8580b;
            if (list != null) {
                int size = list.size();
                if (this.f8580b.size() > er.this.f8556g) {
                    for (int b2 = size - er.this.f8556g; b2 < size; b2++) {
                        TraceLocation traceLocation = this.f8580b.get(b2);
                        if (traceLocation != null) {
                            arrayList.add(new LatLng(traceLocation.getLatitude(), traceLocation.getLongitude()));
                        }
                    }
                }
            }
            a(i2, arrayList);
        }

        public final void onTraceProcessing(int i2, int i3, List<LatLng> list) {
        }
    }

    static class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private TraceListener f8581a;

        public c(Looper looper) {
            super(looper);
        }

        public final void a(TraceListener traceListener) {
            this.f8581a = traceListener;
        }

        public final void handleMessage(Message message) {
            Bundle data;
            try {
                if (this.f8581a != null && (data = message.getData()) != null) {
                    int i2 = data.getInt("lineID");
                    switch (message.what) {
                        case 100:
                            this.f8581a.onTraceProcessing(i2, message.arg1, (List) message.obj);
                            return;
                        case 101:
                            this.f8581a.onFinished(i2, (List) message.obj, message.arg1, message.arg2);
                            return;
                        case 102:
                            this.f8581a.onRequestFailed(i2, (String) message.obj);
                            return;
                        default:
                            return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public er(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f8551b = applicationContext;
        this.f8552c = new CoordinateConverter(applicationContext);
        this.f8563n = new c(Looper.getMainLooper());
        fb.a().a(this.f8551b);
        this.f8553d = dk.a(this.f8550a * 2, this.f8568s, "AMapTraceManagerProcess");
        this.f8554e = dk.a(this.f8550a * 2, this.f8569t, "AMapTraceManagerRequest");
    }

    private static double a(double d2, double d3, double d4, double d5) {
        double d6 = d2 > d4 ? d2 - d4 : d4 - d2;
        double d7 = d3 > d5 ? d3 - d5 : d5 - d3;
        return Math.sqrt((d6 * d6) + (d7 * d7));
    }

    private void a() {
        int size = this.f8559j.size();
        if (size >= this.f8556g) {
            if (size <= 50) {
                ArrayList arrayList = new ArrayList(this.f8559j);
                queryProcessedTrace(0, arrayList, 1, new b(arrayList));
                return;
            }
            int i2 = size - 50;
            if (i2 >= 0) {
                a((List<TraceLocation>) new ArrayList(this.f8559j.subList(i2 - this.f8556g, i2)));
                ArrayList arrayList2 = new ArrayList(this.f8559j.subList(i2, size));
                queryProcessedTrace(i2, arrayList2, 1, new b(arrayList2));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.util.List<com.amap.api.trace.TraceLocation> r19) {
        /*
            r18 = this;
            r1 = r18
            java.util.List<com.amap.api.maps.model.LatLng> r2 = r1.f8567r
            monitor-enter(r2)
            int r0 = r19.size()     // Catch:{ all -> 0x009c }
            if (r0 > 0) goto L_0x000d
            monitor-exit(r2)     // Catch:{ all -> 0x009c }
            return
        L_0x000d:
            java.util.List<com.amap.api.maps.model.LatLng> r0 = r1.f8567r     // Catch:{ all -> 0x009c }
            int r0 = r0.size()     // Catch:{ all -> 0x009c }
            if (r0 > 0) goto L_0x0017
            monitor-exit(r2)     // Catch:{ all -> 0x009c }
            return
        L_0x0017:
            java.util.Iterator r0 = r19.iterator()     // Catch:{ all -> 0x009c }
            r3 = 0
            r4 = 0
            r6 = r3
            r7 = r4
        L_0x0020:
            boolean r9 = r0.hasNext()     // Catch:{ all -> 0x009c }
            if (r9 == 0) goto L_0x004e
            java.lang.Object r9 = r0.next()     // Catch:{ all -> 0x009c }
            com.amap.api.trace.TraceLocation r9 = (com.amap.api.trace.TraceLocation) r9     // Catch:{ all -> 0x009c }
            if (r9 == 0) goto L_0x0020
            if (r6 != 0) goto L_0x0032
        L_0x0030:
            r6 = r9
            goto L_0x0020
        L_0x0032:
            double r10 = r6.getLatitude()     // Catch:{ all -> 0x009c }
            double r12 = r6.getLongitude()     // Catch:{ all -> 0x009c }
            double r14 = r9.getLatitude()     // Catch:{ all -> 0x009c }
            double r16 = r9.getLongitude()     // Catch:{ all -> 0x009c }
            double r10 = a(r10, r12, r14, r16)     // Catch:{ all -> 0x009c }
            r12 = 4636737291354636288(0x4059000000000000, double:100.0)
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 > 0) goto L_0x0020
            double r7 = r7 + r10
            goto L_0x0030
        L_0x004e:
            java.util.List<com.amap.api.maps.model.LatLng> r0 = r1.f8567r     // Catch:{ all -> 0x009c }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x009c }
        L_0x0054:
            boolean r6 = r0.hasNext()     // Catch:{ all -> 0x009c }
            if (r6 == 0) goto L_0x009a
            java.lang.Object r6 = r0.next()     // Catch:{ all -> 0x009c }
            com.amap.api.maps.model.LatLng r6 = (com.amap.api.maps.model.LatLng) r6     // Catch:{ all -> 0x009c }
            if (r6 != 0) goto L_0x0066
            r0.remove()     // Catch:{ all -> 0x009c }
            goto L_0x0054
        L_0x0066:
            if (r3 != 0) goto L_0x0072
            java.util.List<com.amap.api.maps.model.LatLng> r3 = r1.f8565p     // Catch:{ all -> 0x009c }
            r3.add(r6)     // Catch:{ all -> 0x009c }
            r0.remove()     // Catch:{ all -> 0x009c }
        L_0x0070:
            r3 = r6
            goto L_0x0054
        L_0x0072:
            double r9 = r3.latitude     // Catch:{ all -> 0x009c }
            double r11 = r3.longitude     // Catch:{ all -> 0x009c }
            double r13 = r6.latitude     // Catch:{ all -> 0x009c }
            r19 = r0
            double r0 = r6.longitude     // Catch:{ all -> 0x0096 }
            r15 = r0
            double r0 = a(r9, r11, r13, r15)     // Catch:{ all -> 0x0096 }
            double r4 = r4 + r0
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0093
            r1 = r18
            java.util.List<com.amap.api.maps.model.LatLng> r0 = r1.f8565p     // Catch:{ all -> 0x009c }
            r0.add(r6)     // Catch:{ all -> 0x009c }
            r19.remove()     // Catch:{ all -> 0x009c }
            r0 = r19
            goto L_0x0070
        L_0x0093:
            r1 = r18
            goto L_0x009a
        L_0x0096:
            r0 = move-exception
            r1 = r18
            goto L_0x009d
        L_0x009a:
            monitor-exit(r2)     // Catch:{ all -> 0x009c }
            return
        L_0x009c:
            r0 = move-exception
        L_0x009d:
            monitor-exit(r2)     // Catch:{ all -> 0x009c }
            goto L_0x00a0
        L_0x009f:
            throw r0
        L_0x00a0:
            goto L_0x009f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.er.a(java.util.List):void");
    }

    private static boolean a(TraceLocation traceLocation, TraceLocation traceLocation2) {
        return traceLocation != null && traceLocation.getLatitude() == traceLocation2.getLatitude() && traceLocation.getLongitude() == traceLocation2.getLongitude();
    }

    private void b() {
        ak akVar = this.f8558i;
        if (akVar != null) {
            akVar.deactivate();
            this.f8558i = null;
        }
    }

    private void c() {
        this.f8568s.clear();
        this.f8569t.clear();
        List<TraceLocation> list = this.f8559j;
        if (list != null) {
            synchronized (list) {
                List<TraceLocation> list2 = this.f8559j;
                if (list2 != null) {
                    list2.clear();
                }
                this.f8561l = 0;
                this.f8560k = 0;
                this.f8562m = 0;
                this.f8564o = null;
            }
        }
    }

    public final void destroy() {
        try {
            stopTrace();
            id idVar = this.f8553d;
            if (idVar != null) {
                idVar.c();
                this.f8553d = null;
            }
            id idVar2 = this.f8554e;
            if (idVar2 != null) {
                idVar2.c();
                this.f8554e = null;
            }
            this.f8559j = null;
            this.f8557h = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f8551b = null;
        this.f8552c = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0098, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onLocationChanged(android.location.Location r12) {
        /*
            r11 = this;
            com.amap.api.trace.TraceStatusListener r0 = r11.f8557h
            if (r0 == 0) goto L_0x00a0
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x009c }
            long r2 = r11.f8562m     // Catch:{ all -> 0x009c }
            long r0 = r0 - r2
            r2 = 30000(0x7530, double:1.4822E-319)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x001b
            com.amap.api.trace.TraceStatusListener r0 = r11.f8557h     // Catch:{ all -> 0x009c }
            if (r0 == 0) goto L_0x001b
            java.lang.String r1 = "定位超时"
            r2 = 0
            r0.onTraceStatus(r2, r2, r1)     // Catch:{ all -> 0x009c }
        L_0x001b:
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x009c }
            r11.f8562m = r0     // Catch:{ all -> 0x009c }
            android.os.Bundle r0 = r12.getExtras()     // Catch:{ all -> 0x009c }
            java.lang.String r1 = "errorCode"
            int r1 = r0.getInt(r1)     // Catch:{ all -> 0x009c }
            if (r1 == 0) goto L_0x0054
            java.lang.String r12 = "LBSTraceClient"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x009c }
            java.lang.String r3 = "Locate failed [errorCode:\""
            r2.<init>(r3)     // Catch:{ all -> 0x009c }
            r2.append(r1)     // Catch:{ all -> 0x009c }
            java.lang.String r1 = "\"  errorInfo:"
            r2.append(r1)     // Catch:{ all -> 0x009c }
            java.lang.String r1 = "errorInfo"
            java.lang.String r0 = r0.getString(r1)     // Catch:{ all -> 0x009c }
            r2.append(r0)     // Catch:{ all -> 0x009c }
            java.lang.String r0 = "\"]"
            r2.append(r0)     // Catch:{ all -> 0x009c }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x009c }
            android.util.Log.w(r12, r0)     // Catch:{ all -> 0x009c }
            return
        L_0x0054:
            java.util.List<com.amap.api.trace.TraceLocation> r0 = r11.f8559j     // Catch:{ all -> 0x009c }
            monitor-enter(r0)     // Catch:{ all -> 0x009c }
            com.amap.api.trace.TraceLocation r10 = new com.amap.api.trace.TraceLocation     // Catch:{ all -> 0x0099 }
            double r2 = r12.getLatitude()     // Catch:{ all -> 0x0099 }
            double r4 = r12.getLongitude()     // Catch:{ all -> 0x0099 }
            float r6 = r12.getSpeed()     // Catch:{ all -> 0x0099 }
            float r7 = r12.getBearing()     // Catch:{ all -> 0x0099 }
            long r8 = r12.getTime()     // Catch:{ all -> 0x0099 }
            r1 = r10
            r1.<init>(r2, r4, r6, r7, r8)     // Catch:{ all -> 0x0099 }
            com.amap.api.trace.TraceLocation r12 = r11.f8564o     // Catch:{ all -> 0x0099 }
            boolean r12 = a(r12, r10)     // Catch:{ all -> 0x0099 }
            if (r12 == 0) goto L_0x007b
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            return
        L_0x007b:
            java.util.List<com.amap.api.trace.TraceLocation> r12 = r11.f8559j     // Catch:{ all -> 0x0099 }
            r12.add(r10)     // Catch:{ all -> 0x0099 }
            r11.f8564o = r10     // Catch:{ all -> 0x0099 }
            int r12 = r11.f8560k     // Catch:{ all -> 0x0099 }
            int r12 = r12 + 1
            r11.f8560k = r12     // Catch:{ all -> 0x0099 }
            int r1 = r11.f8556g     // Catch:{ all -> 0x0099 }
            if (r12 != r1) goto L_0x0097
            int r1 = r11.f8561l     // Catch:{ all -> 0x0099 }
            int r1 = r1 + r12
            r11.f8561l = r1     // Catch:{ all -> 0x0099 }
            r11.a()     // Catch:{ all -> 0x0099 }
            r12 = 0
            r11.f8560k = r12     // Catch:{ all -> 0x0099 }
        L_0x0097:
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            return
        L_0x0099:
            r12 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            throw r12     // Catch:{ all -> 0x009c }
        L_0x009c:
            r12 = move-exception
            r12.printStackTrace()
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.er.onLocationChanged(android.location.Location):void");
    }

    public final void queryProcessedTrace(int i2, List<TraceLocation> list, int i3, TraceListener traceListener) {
        try {
            this.f8553d.a(new a(i2, list, i3, traceListener));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLocationInterval(long j2) {
        this.f8555f = j2;
    }

    public final void setTraceStatusInterval(int i2) {
        this.f8556g = Math.max(i2, 2);
    }

    public final void startTrace(TraceStatusListener traceStatusListener) {
        if (this.f8551b == null) {
            Log.w("LBSTraceClient", "Context need to be initialized");
            return;
        }
        this.f8562m = System.currentTimeMillis();
        this.f8557h = traceStatusListener;
        if (this.f8558i == null) {
            ak akVar = new ak(this.f8551b);
            this.f8558i = akVar;
            akVar.a(this.f8555f);
            this.f8558i.activate(this);
        }
    }

    public final void stopTrace() {
        b();
        c();
    }
}
