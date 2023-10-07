package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class jr {

    /* renamed from: r  reason: collision with root package name */
    private static int f9512r = 0;

    /* renamed from: v  reason: collision with root package name */
    private static boolean f9513v = false;

    /* renamed from: a  reason: collision with root package name */
    int f9514a = 0;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<jq> f9515b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    ArrayList<ji> f9516c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    TelephonyManager f9517d = null;

    /* renamed from: e  reason: collision with root package name */
    long f9518e = 0;

    /* renamed from: f  reason: collision with root package name */
    CellLocation f9519f;

    /* renamed from: g  reason: collision with root package name */
    boolean f9520g = false;

    /* renamed from: h  reason: collision with root package name */
    PhoneStateListener f9521h = null;

    /* renamed from: i  reason: collision with root package name */
    String f9522i = null;

    /* renamed from: j  reason: collision with root package name */
    boolean f9523j = false;

    /* renamed from: k  reason: collision with root package name */
    StringBuilder f9524k = null;

    /* renamed from: l  reason: collision with root package name */
    private Context f9525l;

    /* renamed from: m  reason: collision with root package name */
    private String f9526m = null;

    /* renamed from: n  reason: collision with root package name */
    private ArrayList<jq> f9527n = new ArrayList<>();

    /* renamed from: o  reason: collision with root package name */
    private int f9528o = -113;

    /* renamed from: p  reason: collision with root package name */
    private jp f9529p = null;

    /* renamed from: q  reason: collision with root package name */
    private Object f9530q;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public long f9531s = 0;

    /* renamed from: t  reason: collision with root package name */
    private TelephonyManager.CellInfoCallback f9532t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public boolean f9533u = false;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public jo f9534w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public boolean f9535x = false;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public Object f9536y = new Object();

    class a extends TelephonyManager.CellInfoCallback {
        a() {
        }

        public final void onCellInfo(List<CellInfo> list) {
            try {
                boolean unused = jr.this.f9533u = true;
                CellLocation a2 = jr.this.a(list);
                if (a2 != null) {
                    jr.this.f9519f = a2;
                    jr.this.f9520g = true;
                    jr.this.s();
                    long unused2 = jr.this.f9531s = is.b();
                }
                jr.this.q();
            } catch (SecurityException e2) {
                jr.this.f9522i = e2.getMessage();
            } catch (Throwable th) {
                io.a(th, "Cgi", "cellInfo");
            }
        }
    }

    class b extends PhoneStateListener {
        b() {
        }

        public final void onCellInfoChanged(List<CellInfo> list) {
            try {
                if (jr.this.f9534w != null) {
                    jr.this.f9534w.a();
                }
            } catch (Throwable unused) {
            }
        }

        public final void onCellLocationChanged(CellLocation cellLocation) {
            try {
                if (jr.this.a(cellLocation)) {
                    jr.this.f9519f = cellLocation;
                    jr.this.f9520g = true;
                    jr.this.s();
                    long unused = jr.this.f9531s = is.b();
                    jr.this.q();
                }
            } catch (Throwable unused2) {
            }
        }

        public final void onServiceStateChanged(ServiceState serviceState) {
            try {
                int state = serviceState.getState();
                if (state == 0) {
                    jr.this.b();
                } else if (state == 1) {
                    jr.this.i();
                }
            } catch (Throwable unused) {
            }
        }

        public final void onSignalStrengthChanged(int i2) {
            int i3 = -113;
            try {
                int i4 = jr.this.f9514a;
                if (i4 == 1 || i4 == 2) {
                    i3 = is.a(i2);
                }
                jr.this.b(i3);
            } catch (Throwable unused) {
            }
        }

        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (signalStrength != null) {
                int i2 = -113;
                try {
                    int i3 = jr.this.f9514a;
                    if (i3 == 1) {
                        i2 = is.a(signalStrength.getGsmSignalStrength());
                    } else if (i3 == 2) {
                        i2 = signalStrength.getCdmaDbm();
                    }
                    jr.this.b(i2);
                    if (jr.this.f9534w != null) {
                        jr.this.f9534w.a();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public jr(Context context) {
        this.f9525l = context;
        if (this.f9517d == null) {
            this.f9517d = (TelephonyManager) is.a(context, "phone");
        }
        k();
        this.f9529p = new jp();
    }

    private CellLocation a(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Object a2 = iq.a(obj, str, objArr);
            CellLocation cellLocation = a2 != null ? (CellLocation) a2 : null;
            if (b(cellLocation)) {
                return cellLocation;
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: android.telephony.cdma.CdmaCellLocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: android.telephony.cdma.CdmaCellLocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.telephony.cdma.CdmaCellLocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: android.telephony.cdma.CdmaCellLocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.telephony.cdma.CdmaCellLocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.telephony.cdma.CdmaCellLocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: android.telephony.cdma.CdmaCellLocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: android.telephony.gsm.GsmCellLocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.telephony.cdma.CdmaCellLocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: android.telephony.cdma.CdmaCellLocation} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0057, code lost:
        if (r0 != null) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0059, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005a, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x005f, code lost:
        return null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.telephony.CellLocation a(java.util.List<android.telephony.CellInfo> r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            if (r11 == 0) goto L_0x005e
            boolean r1 = r11.isEmpty()     // Catch:{ all -> 0x005b }
            if (r1 == 0) goto L_0x000b
            goto L_0x005e
        L_0x000b:
            r1 = 0
            r2 = r0
        L_0x000d:
            int r3 = r11.size()     // Catch:{ all -> 0x005b }
            if (r1 >= r3) goto L_0x0024
            java.lang.Object r3 = r11.get(r1)     // Catch:{ all -> 0x005b }
            android.telephony.CellInfo r3 = (android.telephony.CellInfo) r3     // Catch:{ all -> 0x005b }
            if (r3 == 0) goto L_0x0021
            com.amap.api.mapcore.util.jq r2 = r10.a((android.telephony.CellInfo) r3)     // Catch:{ all -> 0x0021 }
            if (r2 != 0) goto L_0x0024
        L_0x0021:
            int r1 = r1 + 1
            goto L_0x000d
        L_0x0024:
            if (r2 == 0) goto L_0x0055
            int r11 = r2.f9505l     // Catch:{ all -> 0x0050 }
            r1 = 2
            if (r11 != r1) goto L_0x003f
            android.telephony.cdma.CdmaCellLocation r11 = new android.telephony.cdma.CdmaCellLocation     // Catch:{ all -> 0x0050 }
            r11.<init>()     // Catch:{ all -> 0x0050 }
            int r4 = r2.f9503j     // Catch:{ all -> 0x0051 }
            int r5 = r2.f9499f     // Catch:{ all -> 0x0051 }
            int r6 = r2.f9500g     // Catch:{ all -> 0x0051 }
            int r7 = r2.f9501h     // Catch:{ all -> 0x0051 }
            int r8 = r2.f9502i     // Catch:{ all -> 0x0051 }
            r3 = r11
            r3.setCellLocationData(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0051 }
            goto L_0x0051
        L_0x003f:
            android.telephony.gsm.GsmCellLocation r11 = new android.telephony.gsm.GsmCellLocation     // Catch:{ all -> 0x0050 }
            r11.<init>()     // Catch:{ all -> 0x0050 }
            int r1 = r2.f9496c     // Catch:{ all -> 0x004c }
            int r2 = r2.f9497d     // Catch:{ all -> 0x004c }
            r11.setLacAndCid(r1, r2)     // Catch:{ all -> 0x004c }
            goto L_0x0056
        L_0x004c:
            r9 = r0
            r0 = r11
            r11 = r9
            goto L_0x0051
        L_0x0050:
            r11 = r0
        L_0x0051:
            r9 = r0
            r0 = r11
            r11 = r9
            goto L_0x0056
        L_0x0055:
            r11 = r0
        L_0x0056:
            monitor-exit(r10)
            if (r0 != 0) goto L_0x005a
            return r11
        L_0x005a:
            return r0
        L_0x005b:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        L_0x005e:
            monitor-exit(r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.jr.a(java.util.List):android.telephony.CellLocation");
    }

    private static jq a(int i2, boolean z2, int i3, int i4, int i5, int i6, int i7) {
        jq jqVar = new jq(i2, z2);
        jqVar.f9494a = i3;
        jqVar.f9495b = i4;
        jqVar.f9496c = i5;
        jqVar.f9497d = i6;
        jqVar.f9504k = i7;
        return jqVar;
    }

    private jq a(CellInfo cellInfo) {
        boolean isRegistered = cellInfo.isRegistered();
        if (cellInfo instanceof CellInfoCdma) {
            return a((CellInfoCdma) cellInfo, isRegistered);
        }
        if (cellInfo instanceof CellInfoGsm) {
            return a((CellInfoGsm) cellInfo, isRegistered);
        }
        if (cellInfo instanceof CellInfoWcdma) {
            return a((CellInfoWcdma) cellInfo, isRegistered);
        }
        if (cellInfo instanceof CellInfoLte) {
            return a((CellInfoLte) cellInfo, isRegistered);
        }
        if (Build.VERSION.SDK_INT < 29 || !(cellInfo instanceof CellInfoNr)) {
            return null;
        }
        return a((CellInfoNr) cellInfo, isRegistered);
    }

    private jq a(CellInfoCdma cellInfoCdma, boolean z2) {
        int i2;
        int i3;
        int i4;
        if (!(cellInfoCdma == null || cellInfoCdma.getCellIdentity() == null)) {
            CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
            if (cellIdentity.getSystemId() > 0 && cellIdentity.getNetworkId() >= 0 && cellIdentity.getBasestationId() >= 0) {
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                String[] a2 = is.a(this.f9517d);
                try {
                    i4 = Integer.parseInt(a2[0]);
                    try {
                        i2 = Integer.parseInt(a2[1]);
                        i3 = i4;
                    } catch (Throwable unused) {
                        i3 = i4;
                        i2 = 0;
                        jq a3 = a(2, z2, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                        a3.f9501h = cellIdentity2.getSystemId();
                        a3.f9502i = cellIdentity2.getNetworkId();
                        a3.f9503j = cellIdentity2.getBasestationId();
                        a3.f9499f = cellIdentity2.getLatitude();
                        a3.f9500g = cellIdentity2.getLongitude();
                        return a3;
                    }
                } catch (Throwable unused2) {
                    i4 = 0;
                    i3 = i4;
                    i2 = 0;
                    jq a32 = a(2, z2, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                    a32.f9501h = cellIdentity2.getSystemId();
                    a32.f9502i = cellIdentity2.getNetworkId();
                    a32.f9503j = cellIdentity2.getBasestationId();
                    a32.f9499f = cellIdentity2.getLatitude();
                    a32.f9500g = cellIdentity2.getLongitude();
                    return a32;
                }
                jq a322 = a(2, z2, i3, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                a322.f9501h = cellIdentity2.getSystemId();
                a322.f9502i = cellIdentity2.getNetworkId();
                a322.f9503j = cellIdentity2.getBasestationId();
                a322.f9499f = cellIdentity2.getLatitude();
                a322.f9500g = cellIdentity2.getLongitude();
                return a322;
            }
        }
        return null;
    }

    private static jq a(CellInfoGsm cellInfoGsm, boolean z2) {
        if (!(cellInfoGsm == null || cellInfoGsm.getCellIdentity() == null)) {
            CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
            if (c(cellIdentity.getLac()) && d(cellIdentity.getCid())) {
                jq a2 = a(1, z2, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
                a2.f9509p = cellInfoGsm.getCellIdentity().getBsic();
                a2.f9510q = cellInfoGsm.getCellIdentity().getArfcn();
                a2.f9511r = cellInfoGsm.getCellSignalStrength().getTimingAdvance();
                return a2;
            }
        }
        return null;
    }

    private static jq a(CellInfoLte cellInfoLte, boolean z2) {
        if (!(cellInfoLte == null || cellInfoLte.getCellIdentity() == null)) {
            CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
            if (c(cellIdentity.getTac()) && d(cellIdentity.getCi())) {
                jq a2 = a(3, z2, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
                a2.f9509p = cellIdentity.getPci();
                a2.f9510q = cellIdentity.getEarfcn();
                a2.f9511r = cellInfoLte.getCellSignalStrength().getTimingAdvance();
                return a2;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.amap.api.mapcore.util.jq a(android.telephony.CellInfoNr r14, boolean r15) {
        /*
            if (r14 == 0) goto L_0x0089
            android.telephony.CellIdentity r0 = r14.getCellIdentity()
            if (r0 != 0) goto L_0x000a
            goto L_0x0089
        L_0x000a:
            android.telephony.CellIdentity r0 = r14.getCellIdentity()
            android.telephony.CellIdentityNr r0 = (android.telephony.CellIdentityNr) r0
            int r1 = r0.getTac()
            r2 = 2147483647(0x7fffffff, float:NaN)
            r3 = 0
            if (r1 != r2) goto L_0x0031
            java.lang.String r2 = android.os.Build.MANUFACTURER
            java.lang.String r4 = "HUAWEI"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0031
            java.lang.String r2 = "getHwTac"
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x002d }
            int r1 = com.amap.api.mapcore.util.iq.b(r0, r2, r4)     // Catch:{ all -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0031:
            long r4 = r0.getNci()
            java.lang.String r2 = r0.getMccString()     // Catch:{ all -> 0x004a }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x004a }
            java.lang.String r6 = r0.getMncString()     // Catch:{ all -> 0x0048 }
            int r3 = java.lang.Integer.parseInt(r6)     // Catch:{ all -> 0x0048 }
            r9 = r2
            r10 = r3
            goto L_0x0051
        L_0x0048:
            r6 = move-exception
            goto L_0x004c
        L_0x004a:
            r6 = move-exception
            r2 = 0
        L_0x004c:
            r6.printStackTrace()
            r9 = r2
            r10 = 0
        L_0x0051:
            android.telephony.CellSignalStrength r14 = r14.getCellSignalStrength()
            android.telephony.CellSignalStrengthNr r14 = (android.telephony.CellSignalStrengthNr) r14
            int r13 = r14.getSsRsrp()
            r7 = 5
            int r11 = r0.getTac()
            r12 = 0
            r8 = r15
            com.amap.api.mapcore.util.jq r14 = a(r7, r8, r9, r10, r11, r12, r13)
            r14.f9498e = r4
            r15 = 16777215(0xffffff, float:2.3509886E-38)
            r2 = 65535(0xffff, float:9.1834E-41)
            if (r1 <= r15) goto L_0x0073
            r14.f9496c = r2
            goto L_0x007c
        L_0x0073:
            if (r1 <= r2) goto L_0x007a
            r14.f9496c = r2
            r14.f9511r = r1
            goto L_0x007c
        L_0x007a:
            r14.f9496c = r1
        L_0x007c:
            int r15 = r0.getPci()
            r14.f9509p = r15
            int r15 = r0.getNrarfcn()
            r14.f9510q = r15
            return r14
        L_0x0089:
            r14 = 0
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.jr.a(android.telephony.CellInfoNr, boolean):com.amap.api.mapcore.util.jq");
    }

    private static jq a(CellInfoWcdma cellInfoWcdma, boolean z2) {
        if (!(cellInfoWcdma == null || cellInfoWcdma.getCellIdentity() == null)) {
            CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
            if (c(cellIdentity.getLac()) && d(cellIdentity.getCid())) {
                jq a2 = a(4, z2, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
                a2.f9509p = cellIdentity.getPsc();
                a2.f9510q = cellInfoWcdma.getCellIdentity().getUarfcn();
                return a2;
            }
        }
        return null;
    }

    private jq a(CellLocation cellLocation, String[] strArr) {
        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
        jq jqVar = new jq(1, true);
        jqVar.f9494a = is.d(strArr[0]);
        jqVar.f9495b = is.d(strArr[1]);
        jqVar.f9496c = gsmCellLocation.getLac();
        jqVar.f9497d = gsmCellLocation.getCid();
        jqVar.f9504k = this.f9528o;
        return jqVar;
    }

    private static jq a(NeighboringCellInfo neighboringCellInfo, String[] strArr) {
        try {
            jq jqVar = new jq(1, false);
            jqVar.f9494a = Integer.parseInt(strArr[0]);
            jqVar.f9495b = Integer.parseInt(strArr[1]);
            jqVar.f9496c = iq.b(neighboringCellInfo, "getLac", new Object[0]);
            jqVar.f9497d = neighboringCellInfo.getCid();
            jqVar.f9504k = is.a(neighboringCellInfo.getRssi());
            return jqVar;
        } catch (Throwable th) {
            io.a(th, "CgiManager", "getGsm");
            return null;
        }
    }

    public static boolean a(int i2) {
        return i2 > 0 && i2 <= 15;
    }

    private static boolean a(int i2, int i3) {
        return (i2 == -1 || i2 == 0 || i2 > 65535 || i3 == -1 || i3 == 0 || i3 == 65535 || i3 >= 268435455) ? false : true;
    }

    /* access modifiers changed from: private */
    public synchronized void b(int i2) {
        if (i2 == -113) {
            this.f9528o = -113;
            return;
        }
        this.f9528o = i2;
        int i3 = this.f9514a;
        if (i3 == 1 || i3 == 2) {
            ArrayList<jq> arrayList = this.f9515b;
            if (arrayList != null && !arrayList.isEmpty()) {
                try {
                    this.f9515b.get(0).f9504k = this.f9528o;
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0073, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0075, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void b(android.telephony.CellLocation r4, java.lang.String[] r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 == 0) goto L_0x0079
            android.telephony.TelephonyManager r0 = r3.f9517d     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x0009
            goto L_0x0079
        L_0x0009:
            java.util.ArrayList<com.amap.api.mapcore.util.jq> r0 = r3.f9515b     // Catch:{ all -> 0x0076 }
            r0.clear()     // Catch:{ all -> 0x0076 }
            boolean r0 = r3.b((android.telephony.CellLocation) r4)     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x0016
            monitor-exit(r3)
            return
        L_0x0016:
            r0 = 1
            r3.f9514a = r0     // Catch:{ all -> 0x0076 }
            java.util.ArrayList<com.amap.api.mapcore.util.jq> r0 = r3.f9515b     // Catch:{ all -> 0x0076 }
            com.amap.api.mapcore.util.jq r4 = r3.a((android.telephony.CellLocation) r4, (java.lang.String[]) r5)     // Catch:{ all -> 0x0076 }
            r0.add(r4)     // Catch:{ all -> 0x0076 }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0076 }
            r0 = 28
            if (r4 > r0) goto L_0x0074
            android.telephony.TelephonyManager r4 = r3.f9517d     // Catch:{ all -> 0x0076 }
            java.lang.String r0 = "getNeighboringCellInfo"
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0076 }
            java.lang.Object r4 = com.amap.api.mapcore.util.iq.a(r4, r0, r1)     // Catch:{ all -> 0x0076 }
            java.util.List r4 = (java.util.List) r4     // Catch:{ all -> 0x0076 }
            if (r4 == 0) goto L_0x0072
            boolean r0 = r4.isEmpty()     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x003e
            goto L_0x0072
        L_0x003e:
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0076 }
        L_0x0042:
            boolean r0 = r4.hasNext()     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x0074
            java.lang.Object r0 = r4.next()     // Catch:{ all -> 0x0076 }
            android.telephony.NeighboringCellInfo r0 = (android.telephony.NeighboringCellInfo) r0     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x0042
            int r1 = r0.getLac()     // Catch:{ all -> 0x0076 }
            int r2 = r0.getCid()     // Catch:{ all -> 0x0076 }
            boolean r1 = a((int) r1, (int) r2)     // Catch:{ all -> 0x0076 }
            if (r1 == 0) goto L_0x0042
            com.amap.api.mapcore.util.jq r0 = a((android.telephony.NeighboringCellInfo) r0, (java.lang.String[]) r5)     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x0042
            java.util.ArrayList<com.amap.api.mapcore.util.jq> r1 = r3.f9515b     // Catch:{ all -> 0x0076 }
            boolean r1 = r1.contains(r0)     // Catch:{ all -> 0x0076 }
            if (r1 != 0) goto L_0x0042
            java.util.ArrayList<com.amap.api.mapcore.util.jq> r1 = r3.f9515b     // Catch:{ all -> 0x0076 }
            r1.add(r0)     // Catch:{ all -> 0x0076 }
            goto L_0x0042
        L_0x0072:
            monitor-exit(r3)
            return
        L_0x0074:
            monitor-exit(r3)
            return
        L_0x0076:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x0079:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.jr.b(android.telephony.CellLocation, java.lang.String[]):void");
    }

    private boolean b(CellLocation cellLocation) {
        boolean a2 = a(cellLocation);
        if (!a2) {
            this.f9514a = 0;
        }
        return a2;
    }

    private int c(CellLocation cellLocation) {
        if (this.f9523j || cellLocation == null) {
            return 0;
        }
        if (cellLocation instanceof GsmCellLocation) {
            return 1;
        }
        try {
            Class.forName("android.telephony.cdma.CdmaCellLocation");
            return 2;
        } catch (Throwable th) {
            io.a(th, "Utils", "getCellLocT");
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0037 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(android.telephony.CellLocation r5, java.lang.String[] r6) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            java.util.ArrayList<com.amap.api.mapcore.util.jq> r0 = r4.f9515b
            r0.clear()
            java.lang.Object r0 = r4.f9530q     // Catch:{ all -> 0x00c0 }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0038
            java.lang.Class r0 = r5.getClass()     // Catch:{ all -> 0x0034 }
            java.lang.String r3 = "mGsmCellLoc"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r3)     // Catch:{ all -> 0x0034 }
            boolean r3 = r0.isAccessible()     // Catch:{ all -> 0x0034 }
            if (r3 != 0) goto L_0x0021
            r0.setAccessible(r1)     // Catch:{ all -> 0x0034 }
        L_0x0021:
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x0034 }
            android.telephony.gsm.GsmCellLocation r0 = (android.telephony.gsm.GsmCellLocation) r0     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0034
            boolean r3 = r4.b((android.telephony.CellLocation) r0)     // Catch:{ all -> 0x0034 }
            if (r3 == 0) goto L_0x0034
            r4.b(r0, r6)     // Catch:{ all -> 0x0034 }
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            if (r0 == 0) goto L_0x0038
            return
        L_0x0038:
            boolean r0 = r4.b((android.telephony.CellLocation) r5)     // Catch:{ all -> 0x00c0 }
            if (r0 != 0) goto L_0x003f
            return
        L_0x003f:
            r0 = 2
            r4.f9514a = r0     // Catch:{ all -> 0x00c0 }
            com.amap.api.mapcore.util.jq r3 = new com.amap.api.mapcore.util.jq     // Catch:{ all -> 0x00c0 }
            r3.<init>(r0, r1)     // Catch:{ all -> 0x00c0 }
            r0 = r6[r2]     // Catch:{ all -> 0x00c0 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x00c0 }
            r3.f9494a = r0     // Catch:{ all -> 0x00c0 }
            r6 = r6[r1]     // Catch:{ all -> 0x00c0 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ all -> 0x00c0 }
            r3.f9495b = r6     // Catch:{ all -> 0x00c0 }
            java.lang.String r6 = "getSystemId"
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x00c0 }
            int r6 = com.amap.api.mapcore.util.iq.b(r5, r6, r0)     // Catch:{ all -> 0x00c0 }
            r3.f9501h = r6     // Catch:{ all -> 0x00c0 }
            java.lang.String r6 = "getNetworkId"
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x00c0 }
            int r6 = com.amap.api.mapcore.util.iq.b(r5, r6, r0)     // Catch:{ all -> 0x00c0 }
            r3.f9502i = r6     // Catch:{ all -> 0x00c0 }
            java.lang.String r6 = "getBaseStationId"
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x00c0 }
            int r6 = com.amap.api.mapcore.util.iq.b(r5, r6, r0)     // Catch:{ all -> 0x00c0 }
            r3.f9503j = r6     // Catch:{ all -> 0x00c0 }
            int r6 = r4.f9528o     // Catch:{ all -> 0x00c0 }
            r3.f9504k = r6     // Catch:{ all -> 0x00c0 }
            java.lang.String r6 = "getBaseStationLatitude"
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x00c0 }
            int r6 = com.amap.api.mapcore.util.iq.b(r5, r6, r0)     // Catch:{ all -> 0x00c0 }
            r3.f9499f = r6     // Catch:{ all -> 0x00c0 }
            java.lang.String r6 = "getBaseStationLongitude"
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x00c0 }
            int r5 = com.amap.api.mapcore.util.iq.b(r5, r6, r0)     // Catch:{ all -> 0x00c0 }
            r3.f9500g = r5     // Catch:{ all -> 0x00c0 }
            int r5 = r3.f9499f     // Catch:{ all -> 0x00c0 }
            int r6 = r3.f9500g     // Catch:{ all -> 0x00c0 }
            if (r5 != r6) goto L_0x0098
            int r5 = r3.f9499f     // Catch:{ all -> 0x00c0 }
            if (r5 <= 0) goto L_0x0098
            goto L_0x0099
        L_0x0098:
            r1 = 0
        L_0x0099:
            int r5 = r3.f9499f     // Catch:{ all -> 0x00c0 }
            if (r5 < 0) goto L_0x00ae
            int r5 = r3.f9500g     // Catch:{ all -> 0x00c0 }
            if (r5 < 0) goto L_0x00ae
            int r5 = r3.f9499f     // Catch:{ all -> 0x00c0 }
            r6 = 2147483647(0x7fffffff, float:NaN)
            if (r5 == r6) goto L_0x00ae
            int r5 = r3.f9500g     // Catch:{ all -> 0x00c0 }
            if (r5 == r6) goto L_0x00ae
            if (r1 == 0) goto L_0x00b2
        L_0x00ae:
            r3.f9499f = r2     // Catch:{ all -> 0x00c0 }
            r3.f9500g = r2     // Catch:{ all -> 0x00c0 }
        L_0x00b2:
            java.util.ArrayList<com.amap.api.mapcore.util.jq> r5 = r4.f9515b     // Catch:{ all -> 0x00c0 }
            boolean r5 = r5.contains(r3)     // Catch:{ all -> 0x00c0 }
            if (r5 != 0) goto L_0x00bf
            java.util.ArrayList<com.amap.api.mapcore.util.jq> r5 = r4.f9515b     // Catch:{ all -> 0x00c0 }
            r5.add(r3)     // Catch:{ all -> 0x00c0 }
        L_0x00bf:
            return
        L_0x00c0:
            r5 = move-exception
            java.lang.String r6 = "CgiManager"
            java.lang.String r0 = "hdlCdmaLocChange"
            com.amap.api.mapcore.util.io.a(r5, r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.jr.c(android.telephony.CellLocation, java.lang.String[]):void");
    }

    private static boolean c(int i2) {
        return (i2 == -1 || i2 == 0 || i2 > 65535) ? false : true;
    }

    private static boolean d(int i2) {
        return (i2 == -1 || i2 == 0 || i2 == 65535 || i2 >= 268435455) ? false : true;
    }

    private void k() {
        Object a2;
        TelephonyManager telephonyManager = this.f9517d;
        if (telephonyManager != null) {
            try {
                this.f9514a = c(telephonyManager.getCellLocation());
            } catch (SecurityException e2) {
                this.f9522i = e2.getMessage();
            } catch (Throwable th) {
                this.f9522i = null;
                io.a(th, "CgiManager", "CgiManager");
                this.f9514a = 0;
            }
            try {
                int i2 = f9512r;
                if (i2 != 1) {
                    a2 = is.a(i2 != 2 ? this.f9525l : this.f9525l, "phone2");
                } else {
                    a2 = is.a(this.f9525l, "phone_msim");
                }
                this.f9530q = a2;
            } catch (Throwable unused) {
            }
            fz.d().submit(new Runnable() {
                public final void run() {
                    synchronized (jr.this.f9536y) {
                        if (!jr.this.f9535x) {
                            jr.this.l();
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        int i2;
        this.f9521h = new b();
        try {
            i2 = iq.b("android.telephony.PhoneStateListener", "LISTEN_SIGNAL_STRENGTHS");
        } catch (Throwable unused) {
            i2 = 0;
        }
        if (i2 == 0) {
            try {
                this.f9517d.listen(this.f9521h, 16);
            } catch (Throwable unused2) {
            }
        } else {
            try {
                this.f9517d.listen(this.f9521h, i2 | 16);
            } catch (Throwable unused3) {
            }
        }
    }

    private CellLocation m() {
        TelephonyManager telephonyManager = this.f9517d;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = telephonyManager.getCellLocation();
                this.f9522i = null;
                if (b(cellLocation)) {
                    this.f9519f = cellLocation;
                    return cellLocation;
                }
            } catch (SecurityException e2) {
                this.f9522i = e2.getMessage();
            } catch (Throwable th) {
                this.f9522i = null;
                io.a(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    private boolean n() {
        return !this.f9523j && is.b() - this.f9518e >= 10000;
    }

    private void o() {
        i();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void p() {
        /*
            r3 = this;
            monitor-enter(r3)
            int r0 = r3.f()     // Catch:{ all -> 0x0026 }
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x0018
            r1 = 2
            if (r0 == r1) goto L_0x000d
            goto L_0x0024
        L_0x000d:
            java.util.ArrayList<com.amap.api.mapcore.util.jq> r0 = r3.f9515b     // Catch:{ all -> 0x0026 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0024
            r3.f9514a = r2     // Catch:{ all -> 0x0026 }
            goto L_0x0024
        L_0x0018:
            java.util.ArrayList<com.amap.api.mapcore.util.jq> r0 = r3.f9515b     // Catch:{ all -> 0x0026 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0024
            r3.f9514a = r2     // Catch:{ all -> 0x0026 }
            monitor-exit(r3)
            return
        L_0x0024:
            monitor-exit(r3)
            return
        L_0x0026:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.jr.p():void");
    }

    /* access modifiers changed from: private */
    public void q() {
        ArrayList<jq> arrayList = this.f9527n;
        if (arrayList != null && arrayList.size() > 0) {
            this.f9514a |= 4;
        }
        TelephonyManager telephonyManager = this.f9517d;
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            this.f9526m = networkOperator;
            if (!TextUtils.isEmpty(networkOperator)) {
                this.f9514a |= 8;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:1|2|(6:6|(3:10|(1:12)|13)|14|(1:16)|17|(1:19)(2:20|(1:22)))|23|(1:25)|26|27|(1:29)|30|31|(2:33|(1:35))|36) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0080 */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void r() {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.f9523j     // Catch:{ all -> 0x0098 }
            if (r0 != 0) goto L_0x0067
            android.telephony.TelephonyManager r0 = r5.f9517d     // Catch:{ all -> 0x0098 }
            if (r0 == 0) goto L_0x0067
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0098 }
            r1 = 29
            if (r0 < r1) goto L_0x002f
            android.content.Context r0 = r5.f9525l     // Catch:{ all -> 0x0098 }
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()     // Catch:{ all -> 0x0098 }
            int r0 = r0.targetSdkVersion     // Catch:{ all -> 0x0098 }
            if (r0 < r1) goto L_0x002f
            android.telephony.TelephonyManager$CellInfoCallback r0 = r5.f9532t     // Catch:{ all -> 0x0098 }
            if (r0 != 0) goto L_0x0024
            com.amap.api.mapcore.util.jr$a r0 = new com.amap.api.mapcore.util.jr$a     // Catch:{ all -> 0x0098 }
            r0.<init>()     // Catch:{ all -> 0x0098 }
            r5.f9532t = r0     // Catch:{ all -> 0x0098 }
        L_0x0024:
            android.telephony.TelephonyManager r0 = r5.f9517d     // Catch:{ all -> 0x0098 }
            java.util.concurrent.ExecutorService r1 = com.amap.api.mapcore.util.fz.d()     // Catch:{ all -> 0x0098 }
            android.telephony.TelephonyManager$CellInfoCallback r2 = r5.f9532t     // Catch:{ all -> 0x0098 }
            r0.requestCellInfoUpdate(r1, r2)     // Catch:{ all -> 0x0098 }
        L_0x002f:
            android.telephony.CellLocation r0 = r5.t()     // Catch:{ all -> 0x0098 }
            boolean r1 = r5.b((android.telephony.CellLocation) r0)     // Catch:{ all -> 0x0098 }
            if (r1 != 0) goto L_0x003d
            android.telephony.CellLocation r0 = r5.u()     // Catch:{ all -> 0x0098 }
        L_0x003d:
            boolean r1 = r5.b((android.telephony.CellLocation) r0)     // Catch:{ all -> 0x0098 }
            if (r1 == 0) goto L_0x004c
            r5.f9519f = r0     // Catch:{ all -> 0x0098 }
            long r0 = com.amap.api.mapcore.util.is.b()     // Catch:{ all -> 0x0098 }
            r5.f9531s = r0     // Catch:{ all -> 0x0098 }
            goto L_0x0067
        L_0x004c:
            long r0 = com.amap.api.mapcore.util.is.b()     // Catch:{ all -> 0x0098 }
            long r2 = r5.f9531s     // Catch:{ all -> 0x0098 }
            long r0 = r0 - r2
            r2 = 60000(0xea60, double:2.9644E-319)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0067
            r0 = 0
            r5.f9519f = r0     // Catch:{ all -> 0x0098 }
            java.util.ArrayList<com.amap.api.mapcore.util.jq> r0 = r5.f9515b     // Catch:{ all -> 0x0098 }
            r0.clear()     // Catch:{ all -> 0x0098 }
            java.util.ArrayList<com.amap.api.mapcore.util.jq> r0 = r5.f9527n     // Catch:{ all -> 0x0098 }
            r0.clear()     // Catch:{ all -> 0x0098 }
        L_0x0067:
            r0 = 1
            r5.f9520g = r0     // Catch:{ all -> 0x0098 }
            android.telephony.CellLocation r0 = r5.f9519f     // Catch:{ all -> 0x0098 }
            boolean r0 = r5.b((android.telephony.CellLocation) r0)     // Catch:{ all -> 0x0098 }
            if (r0 == 0) goto L_0x0075
            r5.s()     // Catch:{ all -> 0x0098 }
        L_0x0075:
            int r0 = com.amap.api.mapcore.util.is.c()     // Catch:{ all -> 0x0080 }
            r1 = 18
            if (r0 < r1) goto L_0x0080
            r5.w()     // Catch:{ all -> 0x0080 }
        L_0x0080:
            android.telephony.TelephonyManager r0 = r5.f9517d     // Catch:{ all -> 0x0098 }
            if (r0 == 0) goto L_0x0096
            java.lang.String r0 = r0.getNetworkOperator()     // Catch:{ all -> 0x0098 }
            r5.f9526m = r0     // Catch:{ all -> 0x0098 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0098 }
            if (r0 != 0) goto L_0x0096
            int r0 = r5.f9514a     // Catch:{ all -> 0x0098 }
            r0 = r0 | 8
            r5.f9514a = r0     // Catch:{ all -> 0x0098 }
        L_0x0096:
            monitor-exit(r5)
            return
        L_0x0098:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.jr.r():void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void s() {
        /*
            r3 = this;
            monitor-enter(r3)
            android.telephony.TelephonyManager r0 = r3.f9517d     // Catch:{ all -> 0x0022 }
            java.lang.String[] r0 = com.amap.api.mapcore.util.is.a((android.telephony.TelephonyManager) r0)     // Catch:{ all -> 0x0022 }
            android.telephony.CellLocation r1 = r3.f9519f     // Catch:{ all -> 0x0022 }
            int r1 = r3.c((android.telephony.CellLocation) r1)     // Catch:{ all -> 0x0022 }
            r2 = 1
            if (r1 == r2) goto L_0x001b
            r2 = 2
            if (r1 == r2) goto L_0x0014
            goto L_0x0019
        L_0x0014:
            android.telephony.CellLocation r1 = r3.f9519f     // Catch:{ all -> 0x0022 }
            r3.c(r1, r0)     // Catch:{ all -> 0x0022 }
        L_0x0019:
            monitor-exit(r3)
            return
        L_0x001b:
            android.telephony.CellLocation r1 = r3.f9519f     // Catch:{ all -> 0x0022 }
            r3.b(r1, r0)     // Catch:{ all -> 0x0022 }
            monitor-exit(r3)
            return
        L_0x0022:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.jr.s():void");
    }

    private CellLocation t() {
        TelephonyManager telephonyManager = this.f9517d;
        CellLocation cellLocation = null;
        if (telephonyManager == null) {
            return null;
        }
        if (is.c() >= 18) {
            try {
                cellLocation = a(telephonyManager.getAllCellInfo());
            } catch (SecurityException e2) {
                this.f9522i = e2.getMessage();
            }
        }
        if (cellLocation != null) {
            return cellLocation;
        }
        CellLocation m2 = m();
        if (b(m2)) {
            return m2;
        }
        CellLocation a2 = a(telephonyManager, "getCellLocationExt", 1);
        if (a2 != null) {
            return a2;
        }
        return a(telephonyManager, "getCellLocationGemini", 1);
    }

    private CellLocation u() {
        if (!f9513v) {
            f9513v = true;
        }
        Object obj = this.f9530q;
        CellLocation cellLocation = null;
        if (obj == null) {
            return null;
        }
        try {
            Class<?> v2 = v();
            if (v2.isInstance(obj)) {
                Object cast = v2.cast(obj);
                CellLocation a2 = a(cast, "getCellLocation", new Object[0]);
                if (a2 != null) {
                    return a2;
                }
                CellLocation a3 = a(cast, "getCellLocation", 1);
                if (a3 != null) {
                    return a3;
                }
                CellLocation a4 = a(cast, "getCellLocationGemini", 1);
                if (a4 != null) {
                    return a4;
                }
                cellLocation = a(cast, "getAllCellInfo", 1);
                if (cellLocation != null) {
                    return cellLocation;
                }
            }
        } catch (Throwable th) {
            io.a(th, "CgiManager", "getSim2Cgi");
        }
        return cellLocation;
    }

    private static Class<?> v() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        int i2 = f9512r;
        try {
            return systemClassLoader.loadClass(i2 != 0 ? i2 != 1 ? i2 != 2 ? null : "android.telephony.TelephonyManager2" : "android.telephony.MSimTelephonyManager" : "android.telephony.TelephonyManager");
        } catch (Throwable th) {
            io.a(th, "CgiManager", "getSim2TmClass");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void w() {
        /*
            r11 = this;
            android.telephony.TelephonyManager r0 = r11.f9517d
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.util.ArrayList<com.amap.api.mapcore.util.jq> r1 = r11.f9527n
            com.amap.api.mapcore.util.jp r2 = r11.f9529p
            r3 = 0
            java.util.List r0 = r0.getAllCellInfo()     // Catch:{ SecurityException -> 0x0013 }
            r11.f9522i = r3     // Catch:{ SecurityException -> 0x0011 }
            goto L_0x001d
        L_0x0011:
            r3 = move-exception
            goto L_0x0017
        L_0x0013:
            r0 = move-exception
            r10 = r3
            r3 = r0
            r0 = r10
        L_0x0017:
            java.lang.String r3 = r3.getMessage()
            r11.f9522i = r3
        L_0x001d:
            if (r0 == 0) goto L_0x0051
            int r3 = r0.size()
            if (r3 == 0) goto L_0x0051
            if (r1 == 0) goto L_0x002a
            r1.clear()
        L_0x002a:
            r4 = 0
        L_0x002b:
            if (r4 >= r3) goto L_0x0051
            java.lang.Object r5 = r0.get(r4)
            android.telephony.CellInfo r5 = (android.telephony.CellInfo) r5
            if (r5 == 0) goto L_0x004e
            com.amap.api.mapcore.util.jq r5 = r11.a((android.telephony.CellInfo) r5)     // Catch:{ all -> 0x004e }
            if (r5 != 0) goto L_0x003c
            goto L_0x004e
        L_0x003c:
            r6 = 65535(0xffff, double:3.23786E-319)
            long r8 = r2.a((com.amap.api.mapcore.util.jq) r5)     // Catch:{ all -> 0x004e }
            long r6 = java.lang.Math.min(r6, r8)     // Catch:{ all -> 0x004e }
            int r7 = (int) r6     // Catch:{ all -> 0x004e }
            short r6 = (short) r7     // Catch:{ all -> 0x004e }
            r5.f9506m = r6     // Catch:{ all -> 0x004e }
            r1.add(r5)     // Catch:{ all -> 0x004e }
        L_0x004e:
            int r4 = r4 + 1
            goto L_0x002b
        L_0x0051:
            if (r1 == 0) goto L_0x0062
            int r0 = r1.size()
            if (r0 <= 0) goto L_0x0062
            int r0 = r11.f9514a
            r0 = r0 | 4
            r11.f9514a = r0
            r2.a((java.util.ArrayList<? extends com.amap.api.mapcore.util.jq>) r1)
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.jr.w():void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: com.amap.api.mapcore.util.jm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: com.amap.api.mapcore.util.jk} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.amap.api.mapcore.util.jl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: com.amap.api.mapcore.util.jj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: com.amap.api.mapcore.util.jm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: com.amap.api.mapcore.util.jm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: com.amap.api.mapcore.util.jl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: com.amap.api.mapcore.util.jl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: com.amap.api.mapcore.util.jm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: com.amap.api.mapcore.util.jm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: com.amap.api.mapcore.util.jl} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.amap.api.mapcore.util.ji> a() {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.telephony.TelephonyManager r1 = r8.f9517d
            java.util.List r1 = r1.getAllCellInfo()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 17
            if (r2 < r3) goto L_0x0191
            if (r1 == 0) goto L_0x0191
            java.util.Iterator r1 = r1.iterator()
        L_0x0017:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0191
            java.lang.Object r2 = r1.next()
            android.telephony.CellInfo r2 = (android.telephony.CellInfo) r2
            boolean r3 = r2 instanceof android.telephony.CellInfoCdma
            r4 = 1
            if (r3 == 0) goto L_0x006e
            r3 = r2
            android.telephony.CellInfoCdma r3 = (android.telephony.CellInfoCdma) r3
            android.telephony.CellIdentityCdma r5 = r3.getCellIdentity()
            com.amap.api.mapcore.util.jj r6 = new com.amap.api.mapcore.util.jj
            boolean r2 = r2.isRegistered()
            r6.<init>(r2, r4)
            int r2 = r5.getLatitude()
            r6.f9464m = r2
            int r2 = r5.getLongitude()
            r6.f9465n = r2
            int r2 = r5.getSystemId()
            r6.f9461j = r2
            int r2 = r5.getNetworkId()
            r6.f9462k = r2
            int r2 = r5.getBasestationId()
            r6.f9463l = r2
            android.telephony.CellSignalStrengthCdma r2 = r3.getCellSignalStrength()
            int r2 = r2.getAsuLevel()
            r6.f9455d = r2
            android.telephony.CellSignalStrengthCdma r2 = r3.getCellSignalStrength()
            int r2 = r2.getCdmaDbm()
            r6.f9454c = r2
        L_0x006a:
            r0.add(r6)
            goto L_0x0017
        L_0x006e:
            boolean r3 = r2 instanceof android.telephony.CellInfoGsm
            r5 = 24
            if (r3 == 0) goto L_0x00cd
            r3 = r2
            android.telephony.CellInfoGsm r3 = (android.telephony.CellInfoGsm) r3
            android.telephony.CellIdentityGsm r6 = r3.getCellIdentity()
            com.amap.api.mapcore.util.jk r7 = new com.amap.api.mapcore.util.jk
            boolean r2 = r2.isRegistered()
            r7.<init>(r2, r4)
            int r2 = r6.getMcc()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r7.f9452a = r2
            int r2 = r6.getMnc()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r7.f9453b = r2
            int r2 = r6.getLac()
            r7.f9466j = r2
            int r2 = r6.getCid()
            r7.f9467k = r2
            android.telephony.CellSignalStrengthGsm r2 = r3.getCellSignalStrength()
            int r2 = r2.getDbm()
            r7.f9454c = r2
            android.telephony.CellSignalStrengthGsm r2 = r3.getCellSignalStrength()
            int r2 = r2.getAsuLevel()
            r7.f9455d = r2
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r5) goto L_0x00c8
            int r2 = r6.getArfcn()
            r7.f9469m = r2
            int r2 = r6.getBsic()
            r7.f9470n = r2
        L_0x00c8:
            r0.add(r7)
            goto L_0x0017
        L_0x00cd:
            boolean r3 = r2 instanceof android.telephony.CellInfoLte
            if (r3 == 0) goto L_0x0131
            r3 = r2
            android.telephony.CellInfoLte r3 = (android.telephony.CellInfoLte) r3
            android.telephony.CellIdentityLte r4 = r3.getCellIdentity()
            com.amap.api.mapcore.util.jl r6 = new com.amap.api.mapcore.util.jl
            boolean r2 = r2.isRegistered()
            r6.<init>(r2)
            int r2 = r4.getMcc()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r6.f9452a = r2
            int r2 = r4.getMnc()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r6.f9453b = r2
            int r2 = r4.getPci()
            r6.f9474l = r2
            android.telephony.CellSignalStrengthLte r2 = r3.getCellSignalStrength()
            int r2 = r2.getAsuLevel()
            r6.f9455d = r2
            int r2 = r4.getCi()
            r6.f9473k = r2
            int r2 = r4.getTac()
            r6.f9472j = r2
            android.telephony.CellSignalStrengthLte r2 = r3.getCellSignalStrength()
            int r2 = r2.getTimingAdvance()
            r6.f9476n = r2
            android.telephony.CellSignalStrengthLte r2 = r3.getCellSignalStrength()
            int r2 = r2.getDbm()
            r6.f9454c = r2
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r5) goto L_0x006a
            int r2 = r4.getEarfcn()
            r6.f9475m = r2
            goto L_0x006a
        L_0x0131:
            int r3 = android.os.Build.VERSION.SDK_INT
            r6 = 18
            if (r3 < r6) goto L_0x0017
            boolean r3 = r2 instanceof android.telephony.CellInfoWcdma
            if (r3 == 0) goto L_0x0017
            r3 = r2
            android.telephony.CellInfoWcdma r3 = (android.telephony.CellInfoWcdma) r3
            android.telephony.CellIdentityWcdma r6 = r3.getCellIdentity()
            com.amap.api.mapcore.util.jm r7 = new com.amap.api.mapcore.util.jm
            boolean r2 = r2.isRegistered()
            r7.<init>(r2, r4)
            int r2 = r6.getMcc()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r7.f9452a = r2
            int r2 = r6.getMnc()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r7.f9453b = r2
            int r2 = r6.getLac()
            r7.f9477j = r2
            int r2 = r6.getCid()
            r7.f9478k = r2
            int r2 = r6.getPsc()
            r7.f9479l = r2
            android.telephony.CellSignalStrengthWcdma r2 = r3.getCellSignalStrength()
            int r2 = r2.getAsuLevel()
            r7.f9455d = r2
            android.telephony.CellSignalStrengthWcdma r2 = r3.getCellSignalStrength()
            int r2 = r2.getDbm()
            r7.f9454c = r2
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r5) goto L_0x00c8
            int r2 = r6.getUarfcn()
            r7.f9480m = r2
            goto L_0x00c8
        L_0x0191:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.jr.a():java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final boolean a(CellLocation cellLocation) {
        String str;
        boolean z2 = false;
        if (cellLocation == null) {
            return false;
        }
        int c2 = c(cellLocation);
        if (c2 == 1) {
            try {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                return a(gsmCellLocation.getLac(), gsmCellLocation.getCid());
            } catch (Throwable th) {
                th = th;
                str = "cgiUseful Cgi.I_GSM_T";
                io.a(th, "CgiManager", str);
                return true;
            }
        } else if (c2 != 2) {
            return true;
        } else {
            try {
                if (iq.b(cellLocation, "getSystemId", new Object[0]) > 0 && iq.b(cellLocation, "getNetworkId", new Object[0]) >= 0 && iq.b(cellLocation, "getBaseStationId", new Object[0]) >= 0) {
                    z2 = true;
                }
                return z2;
            } catch (Throwable th2) {
                th = th2;
                str = "cgiUseful Cgi.I_CDMA_T";
                io.a(th, "CgiManager", str);
                return true;
            }
        }
    }

    public final synchronized void b() {
        try {
            this.f9523j = is.a(this.f9525l);
            if (n() || this.f9515b.isEmpty()) {
                r();
                this.f9518e = is.b();
            }
            if (this.f9523j) {
                o();
            } else {
                p();
            }
            q();
        } catch (SecurityException e2) {
            this.f9522i = e2.getMessage();
        } catch (Throwable th) {
            io.a(th, "CgiManager", "refresh");
        }
    }

    public final synchronized ArrayList<jq> c() {
        return this.f9515b;
    }

    public final ArrayList<jq> d() {
        return this.f9527n;
    }

    public final int e() {
        return this.f9514a;
    }

    public final int f() {
        return this.f9514a & 3;
    }

    public final TelephonyManager g() {
        return this.f9517d;
    }

    public final void h() {
        PhoneStateListener phoneStateListener;
        this.f9529p.a();
        this.f9531s = 0;
        synchronized (this.f9536y) {
            this.f9535x = true;
        }
        TelephonyManager telephonyManager = this.f9517d;
        if (!(telephonyManager == null || (phoneStateListener = this.f9521h) == null)) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
            } catch (Throwable th) {
                io.a(th, "CgiManager", "destroy");
            }
        }
        this.f9521h = null;
        this.f9528o = -113;
        this.f9517d = null;
        this.f9530q = null;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void i() {
        this.f9522i = null;
        this.f9519f = null;
        this.f9514a = 0;
        this.f9515b.clear();
        this.f9527n.clear();
    }

    public final String j() {
        return this.f9526m;
    }
}
