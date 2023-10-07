package id;

import com.huawei.android.multiscreen.dlna.sdk.dms.ShareOperationFlagEnum;
import com.huawei.android.multiscreen.dlna.sdk.dms.ShareStateEnum;
import com.huawei.android.multiscreen.dlna.sdk.dms.c;
import com.huawei.android.multiscreen.dlna.sdk.jni.DlnaDmsShareDir;
import com.huawei.android.multiscreen.dlna.sdk.jni.a;
import java.io.File;
import java.util.List;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f13522a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13523b;

    /* renamed from: c  reason: collision with root package name */
    private DlnaDmsShareDir f13524c;

    /* renamed from: d  reason: collision with root package name */
    private DlnaDmsShareDir f13525d;

    /* renamed from: e  reason: collision with root package name */
    private a f13526e;

    /* renamed from: f  reason: collision with root package name */
    private b f13527f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f13528g;

    /* renamed from: h  reason: collision with root package name */
    private e f13529h;

    /* renamed from: i  reason: collision with root package name */
    private c f13530i;

    /* renamed from: j  reason: collision with root package name */
    private c f13531j;

    public d() {
        this.f13523b = File.separatorChar == '\\' ? "\\\\" : File.separator;
        this.f13524c = new DlnaDmsShareDir("/");
        this.f13528g = false;
        this.f13526e = new a();
        this.f13527f = new b();
        this.f13525d = new DlnaDmsShareDir("/");
        this.f13529h = e.a();
        this.f13531j = new c();
    }

    private DlnaDmsShareDir a(String str, DlnaDmsShareDir dlnaDmsShareDir) {
        DlnaDmsShareDir dlnaDmsShareDir2;
        if (dlnaDmsShareDir.c().containsKey(str)) {
            a aVar = dlnaDmsShareDir.c().get(str);
            if (!aVar.d()) {
                dlnaDmsShareDir.c().remove(str);
                dlnaDmsShareDir2 = new DlnaDmsShareDir(String.valueOf(dlnaDmsShareDir.j()) + this.f13523b + str);
            } else if (aVar.b() == ShareStateEnum.ALL_SHARE_FLAG.a()) {
                return null;
            } else {
                return (DlnaDmsShareDir) aVar;
            }
        } else {
            dlnaDmsShareDir2 = new DlnaDmsShareDir(String.valueOf(dlnaDmsShareDir.j()) + this.f13523b + str);
            dlnaDmsShareDir2.a(dlnaDmsShareDir);
            str = dlnaDmsShareDir2.i();
        }
        dlnaDmsShareDir.a(str, dlnaDmsShareDir2);
        return dlnaDmsShareDir2;
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f13522a == null) {
                f13522a = new d();
            }
            dVar = f13522a;
        }
        return dVar;
    }

    private a b(String str, DlnaDmsShareDir dlnaDmsShareDir) {
        if (str == null || !b(str)) {
            return null;
        }
        a c2 = this.f13527f.c(str);
        if (c2.d() && (c2 instanceof DlnaDmsShareDir)) {
            ((DlnaDmsShareDir) c2).b(ShareStateEnum.ALL_SHARE_FLAG.a());
        }
        if (dlnaDmsShareDir.j().length() + 1 > str.length()) {
            return null;
        }
        String[] split = str.substring(dlnaDmsShareDir.j().length() + 1).split(this.f13523b);
        for (int i2 = 0; i2 < split.length; i2++) {
            String str2 = split[i2];
            if (i2 < split.length - 1) {
                dlnaDmsShareDir = a(str2, dlnaDmsShareDir);
                if (dlnaDmsShareDir == null) {
                    break;
                }
            } else {
                if (dlnaDmsShareDir.c().containsKey(str2)) {
                    a aVar = dlnaDmsShareDir.c().get(str2);
                    if (aVar.d()) {
                        DlnaDmsShareDir dlnaDmsShareDir2 = (DlnaDmsShareDir) aVar;
                        if (dlnaDmsShareDir2.b() == ShareStateEnum.PART_SHARE_FLAG.a()) {
                            dlnaDmsShareDir.c().remove(str2);
                            dlnaDmsShareDir2.f();
                        }
                    }
                }
                dlnaDmsShareDir.a(c2.i(), c2);
            }
        }
        return c2;
    }

    public boolean a(String str) {
        if (this.f13528g) {
            ie.a.a("ShareFileManagerEx", "start add Path with transaction" + str);
            if (b(str, this.f13525d) != null) {
                this.f13526e.a(str, ShareOperationFlagEnum.ADD_SHARE_FLAG);
            }
            ie.a.a("ShareFileManagerEx", "end add Path with transaction" + str);
            return true;
        }
        ie.a.d("sharefilter", "共享路径out：" + str);
        if (b(str, this.f13524c) != null) {
            ie.a.d("sharefilter", "共享路径in：" + str);
            if (this.f13529h.a(this.f13527f.c(str), ShareOperationFlagEnum.ADD_SHARE_FLAG)) {
                ie.a.d("sharefilter", "共享成功！");
                return true;
            }
            ie.a.d("sharefilter", "共享失败！");
        }
        return false;
    }

    public void b() {
        this.f13528g = true;
        DlnaDmsShareDir dlnaDmsShareDir = this.f13525d;
        if (dlnaDmsShareDir != null) {
            dlnaDmsShareDir.f();
        }
        this.f13526e.a();
        this.f13525d = this.f13524c.h();
    }

    public boolean b(String str) {
        String str2;
        c cVar = this.f13531j;
        boolean z2 = true;
        if (cVar == null) {
            return true;
        }
        if (!cVar.a(str)) {
            return false;
        }
        c cVar2 = this.f13530i;
        if (cVar2 != null) {
            z2 = cVar2.a(str);
            str2 = "mShareFileFilterClient equals not null!!!";
        } else {
            str2 = "mShareFileFilterClient equals null!!!";
        }
        ie.a.d("ShareFileManagerEx", str2);
        return z2;
    }

    public boolean c() {
        boolean z2;
        if (!this.f13528g) {
            return false;
        }
        if (this.f13526e.b() > 0) {
            this.f13524c.f();
            this.f13524c = this.f13525d;
            this.f13525d = new DlnaDmsShareDir("/");
            z2 = this.f13529h.a(this.f13526e);
            this.f13526e.a();
        } else {
            z2 = false;
        }
        this.f13528g = false;
        return z2;
    }

    public DlnaDmsShareDir d() {
        return this.f13524c;
    }

    public boolean e() {
        List<String> a2 = g.a().a("dlna_share_file_configuration.xml");
        if (a2 == null) {
            return false;
        }
        b();
        for (String a3 : a2) {
            a(a3);
        }
        return c();
    }

    public c f() {
        return this.f13531j;
    }
}
