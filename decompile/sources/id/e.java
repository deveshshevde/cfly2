package id;

import com.huawei.android.multiscreen.dlna.sdk.dms.ShareOperationFlagEnum;
import com.huawei.android.multiscreen.dlna.sdk.dms.ShareStateEnum;
import com.huawei.android.multiscreen.dlna.sdk.jni.DlnaDmsShareDir;
import com.huawei.android.multiscreen.dlna.sdk.jni.DlnaUniswitch;
import com.huawei.android.multiscreen.dlna.sdk.jni.a;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f13532a = null;

    /* renamed from: b  reason: collision with root package name */
    private static int f13533b = 500;

    /* renamed from: c  reason: collision with root package name */
    private static int f13534c = 4500;

    /* renamed from: d  reason: collision with root package name */
    private a f13535d = new a();

    /* renamed from: e  reason: collision with root package name */
    private g f13536e = g.a();

    /* renamed from: f  reason: collision with root package name */
    private boolean f13537f = false;

    /* renamed from: g  reason: collision with root package name */
    private Object f13538g = new Object();

    protected e() {
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (f13532a == null) {
                f13532a = new e();
            }
            eVar = f13532a;
        }
        return eVar;
    }

    public boolean a(a aVar, ShareOperationFlagEnum shareOperationFlagEnum) {
        DlnaDmsShareDir dlnaDmsShareDir;
        if (aVar == null) {
            return false;
        }
        this.f13536e.b();
        if (aVar.d()) {
            dlnaDmsShareDir = (DlnaDmsShareDir) aVar;
            dlnaDmsShareDir.b(ShareStateEnum.ALL_SHARE_FLAG.a());
        } else {
            DlnaDmsShareDir dlnaDmsShareDir2 = new DlnaDmsShareDir(aVar.k());
            dlnaDmsShareDir2.b(ShareStateEnum.PART_SHARE_FLAG.a());
            dlnaDmsShareDir2.c().put(aVar.i(), aVar);
            dlnaDmsShareDir = dlnaDmsShareDir2;
        }
        dlnaDmsShareDir.a(shareOperationFlagEnum.a());
        dlnaDmsShareDir.g();
        ie.a.d("ShareFileNotification", "it is share before!");
        if (DlnaUniswitch.a().dlnaApiDmsUpdateSharedFiles(new DlnaDmsShareDir[]{dlnaDmsShareDir}, 1) == 0) {
            ie.a.d("ShareFileNotification", "it is share success!");
            return true;
        }
        ie.a.d("ShareFileNotification", "it is share failed!");
        return false;
    }

    public boolean a(a aVar) {
        if (aVar == null) {
            return false;
        }
        this.f13536e.b();
        return DlnaUniswitch.a().dlnaApiDmsUpdateSharedFiles(aVar.d(), aVar.b()) == 0;
    }
}
