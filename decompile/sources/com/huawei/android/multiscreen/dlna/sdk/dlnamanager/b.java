package com.huawei.android.multiscreen.dlna.sdk.dlnamanager;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.multiscreen.dlna.sdk.dmc.e;
import com.huawei.android.multiscreen.dlna.sdk.jni.DlnaUniswitch;
import com.huawei.android.multiscreen.dlna.sdk.networkmanager.ENetworkType;
import ic.c;
import ie.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b implements e {

    /* renamed from: i  reason: collision with root package name */
    private static e f20784i;

    /* renamed from: k  reason: collision with root package name */
    private static /* synthetic */ int[] f20785k;

    /* renamed from: l  reason: collision with root package name */
    private static /* synthetic */ int[] f20786l;

    /* renamed from: a  reason: collision with root package name */
    private Context f20787a;

    /* renamed from: b  reason: collision with root package name */
    private com.huawei.android.multiscreen.dlna.sdk.dms.b f20788b;

    /* renamed from: c  reason: collision with root package name */
    private c f20789c;

    /* renamed from: d  reason: collision with root package name */
    private e f20790d = new com.huawei.android.multiscreen.dlna.sdk.dmc.b();

    /* renamed from: e  reason: collision with root package name */
    private List<c> f20791e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private EDlnaInitMode f20792f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f20793g;

    /* renamed from: h  reason: collision with root package name */
    private com.huawei.android.multiscreen.dlna.sdk.networkmanager.b f20794h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f20795j = false;

    private b() {
    }

    public static synchronized e a() {
        e eVar;
        synchronized (b.class) {
            if (f20784i == null) {
                f20784i = new b();
            }
            eVar = f20784i;
        }
        return eVar;
    }

    private void a(ESystemEventType eSystemEventType, Object obj) {
        synchronized (this.f20791e) {
            Iterator<c> it2 = this.f20791e.iterator();
            while (it2.hasNext()) {
                c next = it2.next();
                if (next == null) {
                    it2.remove();
                } else {
                    next.a(eSystemEventType, obj);
                }
            }
        }
    }

    private boolean b(EDlnaInitMode eDlnaInitMode) {
        switch (k()[eDlnaInitMode.ordinal()]) {
            case 1:
            case 2:
                return !TextUtils.isEmpty(g().a()) && !TextUtils.isEmpty(f().a());
            case 3:
            case 4:
            case 8:
                return !TextUtils.isEmpty(g().a());
            case 6:
            case 7:
                return !TextUtils.isEmpty(f().a());
            default:
                return true;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(24:3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|(2:24|25)|26|28) */
    /* JADX WARNING: Can't wrap try/catch for region: R(25:3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|28) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0028 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0032 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0044 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x004e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0057 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0060 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x006a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0016 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int[] k() {
        /*
            int[] r0 = f20785k
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode[] r0 = com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode r1 = com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode.DMC     // Catch:{ NoSuchFieldError -> 0x0016 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0016 }
            r2 = 10
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
        L_0x0016:
            com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode r1 = com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode.DMP     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode r1 = com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode.DMR     // Catch:{ NoSuchFieldError -> 0x0028 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
        L_0x0028:
            com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode r1 = com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode.DMR_DMC     // Catch:{ NoSuchFieldError -> 0x0032 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
            r2 = 9
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
        L_0x0032:
            com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode r1 = com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode.DMR_DMP     // Catch:{ NoSuchFieldError -> 0x003b }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
            r2 = 7
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
        L_0x003b:
            com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode r1 = com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode.DMS     // Catch:{ NoSuchFieldError -> 0x0044 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
        L_0x0044:
            com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode r1 = com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode.DMS_DMC     // Catch:{ NoSuchFieldError -> 0x004e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
            r2 = 8
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
        L_0x004e:
            com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode r1 = com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode.DMS_DMP     // Catch:{ NoSuchFieldError -> 0x0057 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0057 }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0057 }
        L_0x0057:
            com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode r1 = com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode.DMS_DMR     // Catch:{ NoSuchFieldError -> 0x0060 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
        L_0x0060:
            com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode r1 = com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode.DMS_DMR_DMC     // Catch:{ NoSuchFieldError -> 0x006a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006a }
            r2 = 11
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006a }
        L_0x006a:
            com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode r1 = com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode.DMS_DMR_DMP     // Catch:{ NoSuchFieldError -> 0x0073 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0073 }
        L_0x0073:
            f20785k = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.multiscreen.dlna.sdk.dlnamanager.b.k():int[]");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:3|4|5|6|7|8|9|10|11|12|14) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int[] l() {
        /*
            int[] r0 = f20786l
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            com.huawei.android.multiscreen.dlna.sdk.dlnamanager.ELogLevel[] r0 = com.huawei.android.multiscreen.dlna.sdk.dlnamanager.ELogLevel.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            com.huawei.android.multiscreen.dlna.sdk.dlnamanager.ELogLevel r1 = com.huawei.android.multiscreen.dlna.sdk.dlnamanager.ELogLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x0015 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0015 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
        L_0x0015:
            com.huawei.android.multiscreen.dlna.sdk.dlnamanager.ELogLevel r1 = com.huawei.android.multiscreen.dlna.sdk.dlnamanager.ELogLevel.INFO     // Catch:{ NoSuchFieldError -> 0x001e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001e }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
        L_0x001e:
            com.huawei.android.multiscreen.dlna.sdk.dlnamanager.ELogLevel r1 = com.huawei.android.multiscreen.dlna.sdk.dlnamanager.ELogLevel.TRACE     // Catch:{ NoSuchFieldError -> 0x0027 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0027 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0027 }
        L_0x0027:
            com.huawei.android.multiscreen.dlna.sdk.dlnamanager.ELogLevel r1 = com.huawei.android.multiscreen.dlna.sdk.dlnamanager.ELogLevel.WARNING     // Catch:{ NoSuchFieldError -> 0x0030 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0030 }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0030 }
        L_0x0030:
            f20786l = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.multiscreen.dlna.sdk.dlnamanager.b.l():int[]");
    }

    private void m() {
        this.f20792f = null;
    }

    public void a(ELogLevel eLogLevel) {
        int i2;
        if (eLogLevel != null) {
            int i3 = l()[eLogLevel.ordinal()];
            if (i3 == 1) {
                i2 = 6;
            } else if (i3 != 2) {
                if (i3 == 3) {
                    a.a(4);
                } else if (i3 == 4) {
                    a.a(2);
                }
                DlnaUniswitch.a().dlnaApiSetLogLevel(eLogLevel.a());
            } else {
                i2 = 5;
            }
            a.a(i2);
            DlnaUniswitch.a().dlnaApiSetLogLevel(eLogLevel.a());
        }
    }

    public void a(com.huawei.android.multiscreen.dlna.sdk.networkmanager.a aVar) {
        com.huawei.android.multiscreen.dlna.sdk.networkmanager.c.a().a(aVar);
        if (aVar != null) {
            this.f20795j = true;
        }
    }

    public boolean a(EDlnaInitMode eDlnaInitMode) {
        com.huawei.android.multiscreen.dlna.sdk.networkmanager.a b2;
        if (!(eDlnaInitMode == null || !this.f20795j || (b2 = com.huawei.android.multiscreen.dlna.sdk.networkmanager.c.a().b()) == null || b2.b() == ENetworkType.NO_NETWORK)) {
            this.f20792f = eDlnaInitMode;
            if (!b(eDlnaInitMode)) {
                return false;
            }
            File file = new File(this.f20787a.getFilesDir().getParentFile(), "databases");
            if (!file.exists() && !file.mkdir()) {
                return false;
            }
            String str = String.valueOf(file.getAbsolutePath()) + "/";
            if (DlnaUniswitch.a().dlnaApiSetDmcAutoBrowseDisable(1) == 0 && DlnaUniswitch.a().dlnaApiStackInit(eDlnaInitMode.a(), str) == 0) {
                this.f20793g = true;
                a(ESystemEventType.DlnaServiceUp, (Object) null);
                return true;
            }
        }
        return false;
    }

    public boolean b() {
        if (DlnaUniswitch.a().dlnaApiStackDestroy() != 0) {
            return false;
        }
        this.f20793g = false;
        a(ESystemEventType.DlnaServiceDown, (Object) null);
        ((com.huawei.android.multiscreen.dlna.sdk.dmc.b) this.f20790d).a();
        return true;
    }

    public boolean c() {
        if (!this.f20793g) {
            return true;
        }
        m();
        return b();
    }

    public Context d() {
        return this.f20787a;
    }

    public e e() {
        return this.f20790d;
    }

    public c f() {
        if (this.f20789c == null) {
            this.f20789c = new ic.a();
        }
        return this.f20789c;
    }

    public com.huawei.android.multiscreen.dlna.sdk.dms.b g() {
        if (this.f20788b == null) {
            this.f20788b = new com.huawei.android.multiscreen.dlna.sdk.dms.a();
        }
        return this.f20788b;
    }

    public boolean h() {
        return this.f20793g;
    }

    public EDlnaInitMode i() {
        return this.f20792f;
    }

    public com.huawei.android.multiscreen.dlna.sdk.networkmanager.b j() {
        return this.f20794h;
    }
}
