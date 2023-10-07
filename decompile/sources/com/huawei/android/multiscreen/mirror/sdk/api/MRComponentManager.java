package com.huawei.android.multiscreen.mirror.sdk.api;

import android.content.Context;
import android.util.Log;
import java.io.File;
import p000if.a;

public class MRComponentManager {

    /* renamed from: e  reason: collision with root package name */
    private static MRComponentManager f20932e;

    /* renamed from: f  reason: collision with root package name */
    private static /* synthetic */ int[] f20933f;

    /* renamed from: a  reason: collision with root package name */
    private MRSource f20934a = null;

    /* renamed from: b  reason: collision with root package name */
    private MRSink f20935b = null;

    /* renamed from: c  reason: collision with root package name */
    private MRDiscovery f20936c = null;

    /* renamed from: d  reason: collision with root package name */
    private Context f20937d;

    public MRComponentManager(Context context) {
        Log.d("MIRROR_SDK", "MRComponentManager::MRComponentManager()");
        this.f20937d = context;
        b(context.getPackageName());
        f20932e = this;
        new a(this.f20937d).a();
        if (nativeSetXMLPath(this.f20937d.getApplicationContext().getFilesDir().getAbsolutePath()) != 0) {
            Log.e("MIRROR_SDK", "MRComponentManager set xml file path fail");
        }
        nativeNew();
    }

    private a a(String str) {
        Log.d("MIRROR_SDK", "GetMRComponent by id: " + str);
        long nativeGetComponent = nativeGetComponent(str);
        Log.d("MRComponentManagerJNI", "nativePointer is " + nativeGetComponent);
        if (0 == nativeGetComponent) {
            return null;
        }
        if ("ICOS.MIRROR.DISCOVERY".equals(str)) {
            if (this.f20936c == null) {
                this.f20936c = new MRDiscovery();
            }
            this.f20936c.a(nativeGetComponent);
            return this.f20936c;
        } else if ("ICOS.MIRROR.SOURCE".equals(str)) {
            if (this.f20934a == null) {
                this.f20934a = new MRSource();
            }
            this.f20934a.a(nativeGetComponent);
            return this.f20934a;
        } else if (!"ICOS.MIRROR.SINK".equals(str)) {
            return null;
        } else {
            if (this.f20935b == null) {
                this.f20935b = new MRSink();
            }
            this.f20935b.a(nativeGetComponent);
            return this.f20935b;
        }
    }

    private void a(String str, String str2) {
        String str3 = "/data/data/" + str + "/lib/" + str2;
        if (new File(str3).exists()) {
            System.load(str3);
        } else {
            System.loadLibrary(str2);
        }
    }

    private void b(String str) {
        Log.d("MRSDK", " loading MRSDK!");
        a(str, "avutil");
        a(str, "avcodec");
        a(str, "avformat");
        a(str, "sqlite3");
        a(str, "threadutil");
        a(str, "ixml");
        a(str, "upnp");
        a(str, "vppdlna");
        a(str, "airsharing_platform");
        a(str, "mirror_media");
        a(str, "MRSDK");
        Log.d("MRSDK", " end loading MRSDK!");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:3|4|5|6|7|8|9|10|11|12|14) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int[] e() {
        /*
            int[] r0 = f20933f
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            com.huawei.android.multiscreen.mirror.sdk.api.EMirrorLogLevel[] r0 = com.huawei.android.multiscreen.mirror.sdk.api.EMirrorLogLevel.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            com.huawei.android.multiscreen.mirror.sdk.api.EMirrorLogLevel r1 = com.huawei.android.multiscreen.mirror.sdk.api.EMirrorLogLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x0015 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0015 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
        L_0x0015:
            com.huawei.android.multiscreen.mirror.sdk.api.EMirrorLogLevel r1 = com.huawei.android.multiscreen.mirror.sdk.api.EMirrorLogLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x001e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001e }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
        L_0x001e:
            com.huawei.android.multiscreen.mirror.sdk.api.EMirrorLogLevel r1 = com.huawei.android.multiscreen.mirror.sdk.api.EMirrorLogLevel.INFO     // Catch:{ NoSuchFieldError -> 0x0027 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0027 }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0027 }
        L_0x0027:
            com.huawei.android.multiscreen.mirror.sdk.api.EMirrorLogLevel r1 = com.huawei.android.multiscreen.mirror.sdk.api.EMirrorLogLevel.WARN     // Catch:{ NoSuchFieldError -> 0x0030 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0030 }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0030 }
        L_0x0030:
            f20933f = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.multiscreen.mirror.sdk.api.MRComponentManager.e():int[]");
    }

    public int a() {
        if (this.f20934a != null) {
            this.f20934a = null;
        }
        if (this.f20935b != null) {
            this.f20935b = null;
        }
        if (this.f20936c != null) {
            this.f20936c = null;
        }
        return nativeClearComponents();
    }

    public int a(String str, boolean z2) {
        return nativeBuildComponent(str, z2);
    }

    public void a(EMirrorLogLevel eMirrorLogLevel) {
        int i2 = e()[eMirrorLogLevel.ordinal()];
        int i3 = 4;
        if (i2 != 2) {
            i3 = i2 != 3 ? i2 != 4 ? 3 : 6 : 5;
        }
        nativeSetLogLevel(i3);
    }

    public MRSink b() {
        return (MRSink) a("ICOS.MIRROR.SINK");
    }

    public MRDiscovery c() {
        return (MRDiscovery) a("ICOS.MIRROR.DISCOVERY");
    }

    public MRSource d() {
        return (MRSource) a("ICOS.MIRROR.SOURCE");
    }

    /* access modifiers changed from: protected */
    public native int nativeBuildComponent(String str, boolean z2);

    /* access modifiers changed from: protected */
    public native int nativeClearComponents();

    /* access modifiers changed from: protected */
    public native long nativeGetComponent(String str);

    /* access modifiers changed from: protected */
    public native int nativeGetLogLevel();

    /* access modifiers changed from: protected */
    public native void nativeNew();

    /* access modifiers changed from: protected */
    public native void nativeSetLogLevel(int i2);

    /* access modifiers changed from: protected */
    public native int nativeSetXMLPath(String str);

    /* access modifiers changed from: protected */
    public native int nativeStart();

    /* access modifiers changed from: protected */
    public native int nativeStop();
}
