package kz;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.flypro.core.MAVLink.b;
import com.flypro.core.util.e;
import com.liulishuo.filedownloader.g;
import com.liulishuo.filedownloader.i;
import com.liulishuo.filedownloader.q;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.communication.ftp.FtpBase;
import com.xeagle.android.dialogs.ah;
import com.xeagle.android.dialogs.an;
import com.xeagle.android.dialogs.c;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.dialogs.m;
import com.xeagle.android.dialogs.r;
import com.xeagle.android.login.beans.ApkVersion;
import com.xeagle.android.login.beans.DroneFwBeans;
import com.xeagle.android.login.beans.DroneFwInfo;
import com.xeagle.android.login.beans.ImageFwBeans;
import com.xeagle.android.login.beans.ImageFwInfo;
import com.xeagle.android.login.beans.RepeaterFwBeans;
import com.xeagle.android.login.beans.RepeaterFwInfo;
import com.xeagle.android.login.retrofitLogin.RegContract;
import com.xeagle.android.login.retrofitLogin.RegPresenter;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.newUI.cameraManager.AmbaClient;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kz.a;

public class a implements RegContract.lLoadView {

    /* renamed from: a  reason: collision with root package name */
    public boolean f13915a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13916b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Context f13917c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public AppCompatActivity f13918d;

    /* renamed from: e  reason: collision with root package name */
    private RegPresenter f13919e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public an f13920f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ah f13921g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public m f13922h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public m f13923i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public m f13924j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public m f13925k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public m f13926l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public m f13927m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public m f13928n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public c f13929o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public String f13930p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public ImageFwBeans f13931q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public AtomicBoolean f13932r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public AtomicBoolean f13933s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public boolean f13934t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f13935u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f13936v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public int f13937w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public Handler f13938x;

    /* renamed from: kz.a$a  reason: collision with other inner class name */
    private static final class C0213a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30650a = new a();
    }

    private a() {
        this.f13932r = new AtomicBoolean(false);
        this.f13933s = new AtomicBoolean(false);
        this.f13934t = false;
        this.f13937w = 13;
        this.f13938x = new Handler(Looper.getMainLooper()) {
            /* JADX WARNING: Removed duplicated region for block: B:38:0x00d6  */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x0101  */
            /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void handleMessage(android.os.Message r13) {
                /*
                    r12 = this;
                    super.handleMessage(r13)
                    java.lang.Object r0 = r13.obj
                    java.lang.Long r0 = (java.lang.Long) r0
                    long r0 = r0.longValue()
                    int r13 = r13.arg1
                    r2 = 28
                    r3 = 1
                    r4 = 0
                    r5 = 100
                    r6 = 2131823061(0x7f1109d5, float:1.9278911E38)
                    r7 = 100
                    r9 = 14
                    if (r13 != r9) goto L_0x005e
                    int r9 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                    if (r9 >= 0) goto L_0x005e
                    kz.a r9 = kz.a.this
                    com.xeagle.android.dialogs.an r9 = r9.f13920f
                    if (r9 != 0) goto L_0x00ce
                    kz.a r9 = kz.a.this
                    boolean r9 = r9.a()
                    if (r9 != 0) goto L_0x00ce
                    kz.a r9 = kz.a.this
                    android.content.Context r10 = r9.f13917c
                    r11 = 2131821388(0x7f11034c, float:1.9275518E38)
                    java.lang.String r10 = r10.getString(r11)
                L_0x003d:
                    kz.a r11 = kz.a.this
                    android.content.Context r11 = r11.f13917c
                    java.lang.String r6 = r11.getString(r6)
                    r9.a((java.lang.String) r10, (java.lang.String) r6, (int) r5)
                    kz.a r5 = kz.a.this
                    com.xeagle.android.dialogs.an r5 = r5.f13920f
                    r5.a((boolean) r3)
                L_0x0053:
                    kz.a r3 = kz.a.this
                    com.xeagle.android.dialogs.an r3 = r3.f13920f
                    r3.setCancelable(r4)
                    goto L_0x00ce
                L_0x005e:
                    r9 = 21
                    if (r13 != r9) goto L_0x0091
                    int r9 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                    if (r9 >= 0) goto L_0x0091
                    kz.a r3 = kz.a.this
                    com.xeagle.android.dialogs.an r3 = r3.f13920f
                    if (r3 != 0) goto L_0x00ce
                    kz.a r3 = kz.a.this
                    boolean r3 = r3.a()
                    if (r3 != 0) goto L_0x00ce
                    kz.a r3 = kz.a.this
                    android.content.Context r9 = r3.f13917c
                    r10 = 2131823140(0x7f110a24, float:1.9279071E38)
                    java.lang.String r9 = r9.getString(r10)
                    kz.a r10 = kz.a.this
                    android.content.Context r10 = r10.f13917c
                    java.lang.String r6 = r10.getString(r6)
                    r3.a((java.lang.String) r9, (java.lang.String) r6, (int) r5)
                    goto L_0x0053
                L_0x0091:
                    r9 = 15
                    r10 = 2131822516(0x7f1107b4, float:1.9277806E38)
                    if (r13 != r9) goto L_0x00b7
                    int r9 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                    if (r9 >= 0) goto L_0x00b7
                    kz.a r9 = kz.a.this
                    com.xeagle.android.dialogs.an r9 = r9.f13920f
                    if (r9 != 0) goto L_0x00ce
                    kz.a r9 = kz.a.this
                    boolean r9 = r9.a()
                    if (r9 != 0) goto L_0x00ce
                L_0x00ac:
                    kz.a r9 = kz.a.this
                    android.content.Context r11 = r9.f13917c
                    java.lang.String r10 = r11.getString(r10)
                    goto L_0x003d
                L_0x00b7:
                    if (r13 != r2) goto L_0x00ce
                    int r9 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                    if (r9 >= 0) goto L_0x00ce
                    kz.a r9 = kz.a.this
                    com.xeagle.android.dialogs.an r9 = r9.f13920f
                    if (r9 != 0) goto L_0x00ce
                    kz.a r9 = kz.a.this
                    boolean r9 = r9.a()
                    if (r9 != 0) goto L_0x00ce
                    goto L_0x00ac
                L_0x00ce:
                    kz.a r3 = kz.a.this
                    com.xeagle.android.dialogs.an r3 = r3.f13920f
                    if (r3 == 0) goto L_0x00df
                    kz.a r3 = kz.a.this
                    com.xeagle.android.dialogs.an r3 = r3.f13920f
                    r3.a((long) r0)
                L_0x00df:
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "Handler progress = "
                    r3.append(r4)
                    r3.append(r0)
                    java.lang.String r4 = " uploadType = "
                    r3.append(r4)
                    r3.append(r13)
                    java.lang.String r3 = r3.toString()
                    java.lang.String r4 = "UsbCheckFirmwareUtils"
                    android.util.Log.d(r4, r3)
                    int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                    if (r3 < 0) goto L_0x0129
                    kz.a r0 = kz.a.this
                    r0.m()
                    kz.a r0 = kz.a.this
                    com.xeagle.android.dialogs.ah r0 = r0.f13921g
                    if (r0 != 0) goto L_0x0129
                    kz.a r0 = kz.a.this
                    r0.a((int) r13)
                    r0 = 100000(0x186a0, float:1.4013E-40)
                    if (r13 != r2) goto L_0x011b
                    r0 = 120000(0x1d4c0, float:1.68156E-40)
                L_0x011b:
                    kz.a r13 = kz.a.this
                    com.xeagle.android.dialogs.ah r13 = r13.f13921g
                    kz.a$1$1 r1 = new kz.a$1$1
                    r1.<init>()
                    com.xeagle.android.utils.d.a(r13, r0, r1)
                L_0x0129:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: kz.a.AnonymousClass1.handleMessage(android.os.Message):void");
            }
        };
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        Context context;
        int i3;
        if (this.f13921g == null) {
            String string = this.f13917c.getString(R.string.upload_back_warn);
            if (i2 == 14) {
                context = this.f13917c;
                i3 = R.string.fly_upgrading;
            } else if (i2 == 21) {
                context = this.f13917c;
                i3 = R.string.relay_upgrading;
            } else {
                if (i2 == 15 || i2 == 28) {
                    context = this.f13917c;
                    i3 = R.string.video_upgrading;
                }
                this.f13921g = ah.a(this.f13917c.getString(R.string.upload_success), string, 100);
                Log.d("UsbCheckFirmwareUtils", "initUpgradeProgressDlg init");
            }
            string = context.getString(i3);
            this.f13921g = ah.a(this.f13917c.getString(R.string.upload_success), string, 100);
            Log.d("UsbCheckFirmwareUtils", "initUpgradeProgressDlg init");
        }
        if (!this.f13921g.isAdded()) {
            this.f13921g.show(this.f13918d.getSupportFragmentManager(), "updateApk");
            Log.d("UsbCheckFirmwareUtils", "initUpgradeProgressDlg show");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0064, code lost:
        if (r8.f13931q.getForce() == 1) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0088, code lost:
        if (r8.f13931q.getForce() == 1) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x008c, code lost:
        r7 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r9) {
        /*
            r8 = this;
            com.xeagle.android.login.beans.ImageFwBeans r0 = r8.f13931q
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.Context r1 = r8.f13917c
            android.content.Context r1 = r1.getApplicationContext()
            java.lang.String r1 = kx.d.i(r1)
            r0.append(r1)
            com.xeagle.android.login.beans.ImageFwBeans r1 = r8.f13931q
            java.lang.String r1 = r1.getPbaUrl()
            java.lang.String r1 = com.flypro.core.util.d.b(r1)
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r1 = r0.exists()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0074
            java.lang.String r1 = com.xeagle.android.utils.c.g(r4)
            java.util.Objects.requireNonNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            com.xeagle.android.login.beans.ImageFwBeans r5 = r8.f13931q
            java.lang.String r5 = r5.getPbaMd5()
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x0067
            boolean r9 = r0.delete()
            if (r9 == 0) goto L_0x0092
            com.xeagle.android.login.beans.ImageFwBeans r9 = r8.f13931q
            java.lang.String r9 = r9.getPbaUrl()
            com.xeagle.android.login.beans.ImageFwBeans r0 = r8.f13931q
            java.lang.String r5 = r0.getPbaMd5()
            r6 = 28
            com.xeagle.android.login.beans.ImageFwBeans r0 = r8.f13931q
            int r0 = r0.getForce()
            if (r0 != r3) goto L_0x008c
            goto L_0x008a
        L_0x0067:
            com.xeagle.android.login.beans.ImageFwBeans r0 = r8.f13931q
            int r0 = r0.getForce()
            if (r0 != r3) goto L_0x0070
            r2 = 1
        L_0x0070:
            r8.a((java.lang.String) r9, (java.lang.String) r4, (boolean) r2)
            goto L_0x0092
        L_0x0074:
            com.xeagle.android.login.beans.ImageFwBeans r9 = r8.f13931q
            java.lang.String r9 = r9.getPbaUrl()
            com.xeagle.android.login.beans.ImageFwBeans r0 = r8.f13931q
            java.lang.String r5 = r0.getPbaMd5()
            r6 = 28
            com.xeagle.android.login.beans.ImageFwBeans r0 = r8.f13931q
            int r0 = r0.getForce()
            if (r0 != r3) goto L_0x008c
        L_0x008a:
            r7 = 1
            goto L_0x008d
        L_0x008c:
            r7 = 0
        L_0x008d:
            r2 = r8
            r3 = r9
            r2.a(r3, r4, r5, r6, r7)
        L_0x0092:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kz.a.a(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, int i2) {
        if (this.f13920f == null) {
            this.f13920f = new an(this.f13918d, str, str2, (long) i2, new an.a() {
                public void a() {
                    q.a().b();
                    a.this.m();
                }
            });
        }
        if (!this.f13920f.isShowing()) {
            this.f13920f.show();
        }
    }

    private void a(final String str, final String str2, c.a aVar) {
        if (this.f13929o == null) {
            this.f13929o = r.a().a(str, str2, aVar);
        } else {
            this.f13938x.post(new Runnable() {
                public void run() {
                    a.this.f13929o.a(str);
                    a.this.f13929o.b(str2);
                }
            });
        }
        if (!this.f13929o.isAdded()) {
            this.f13929o.show(this.f13918d.getSupportFragmentManager(), "warnDlg");
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, String str3, int i2, boolean z2) {
        final String str4 = str2;
        final String str5 = str3;
        final String str6 = str;
        final int i3 = i2;
        final boolean z3 = z2;
        q.a().a(str).a((i) new i() {
            /* access modifiers changed from: protected */
            public void a(com.liulishuo.filedownloader.a aVar, int i2, int i3) {
            }

            /* access modifiers changed from: protected */
            public void a(com.liulishuo.filedownloader.a aVar, String str, boolean z2, int i2, int i3) {
                super.a(aVar, str, z2, i2, i3);
                if (!a.this.a()) {
                    if (a.this.f13920f == null) {
                        a aVar2 = a.this;
                        aVar2.a(aVar2.f13917c.getString(R.string.firmware_downloading), a.this.f13917c.getString(R.string.upgrade_warning), i3);
                    } else {
                        a.this.f13920f.a(a.this.f13917c.getString(R.string.firmware_downloading));
                        a.this.f13920f.a(i3);
                    }
                    a.this.f13920f.b(false);
                    a.this.f13920f.a(0);
                    if (!a.this.f13920f.isShowing()) {
                        a.this.f13920f.show();
                    }
                }
            }

            /* access modifiers changed from: protected */
            public void a(com.liulishuo.filedownloader.a aVar, Throwable th) {
                Log.i("UsbCheckFirmwareUtils", "error: ===download===" + th.getMessage());
                if (a.this.f13920f != null) {
                    a.this.f13920f.a(a.this.f13917c.getString(R.string.download_fail_network));
                    a.this.f13920f.b(true);
                } else {
                    ToastUtils.showShort((CharSequence) a.this.f13917c.getString(R.string.download_fail_network));
                }
                a.this.f13932r.set(false);
            }

            /* access modifiers changed from: protected */
            public void b(com.liulishuo.filedownloader.a aVar, int i2, int i3) {
                if (!a.this.a()) {
                    if (a.this.f13920f == null) {
                        a aVar2 = a.this;
                        aVar2.a(aVar2.f13917c.getString(R.string.download), a.this.f13917c.getString(R.string.upgrade_warning), i3);
                    }
                    a.this.f13920f.a((long) i2);
                }
            }

            /* access modifiers changed from: protected */
            public void c(com.liulishuo.filedownloader.a aVar) {
                Toast.makeText(a.this.f13917c, R.string.file_is_downloaded, 0).show();
                if (a.this.f13920f != null) {
                    a.this.f13920f.dismiss();
                }
                Log.i("UsbCheckFirmwareUtils", "completed: ======对比md5值");
                String g2 = com.xeagle.android.utils.c.g(str4);
                if (g2 == null) {
                    return;
                }
                if (!g2.equals(str5)) {
                    Log.i("UsbCheckFirmwareUtils", "completed: ======对比md5值不一致");
                    File file = new File(str4);
                    if (file.exists()) {
                        file.delete();
                    }
                    d a2 = d.a(a.this.f13917c.getString(R.string.warning), a.this.f13917c.getString(R.string.error_md5_download), new d.a() {
                        public void onNo() {
                            a.this.f13932r.set(false);
                        }

                        public void onYes() {
                            a.this.a(str6, str4, str5, i3, z3);
                        }
                    });
                    if (!a2.isAdded()) {
                        a2.show(a.this.f13918d.getSupportFragmentManager(), "md5Error");
                        return;
                    }
                    return;
                }
                Log.i("UsbCheckFirmwareUtils", "completed: ======对比md5值一致，开始升级======" + i3);
                int i2 = i3;
                if (i2 == 14) {
                    a.this.b(str4, z3);
                } else if (i2 == 21) {
                    a.this.a(str5, z3);
                } else if (i2 == 15) {
                    a.this.a(str4);
                } else if (i2 != 28) {
                } else {
                    if (a.this.f13931q != null) {
                        a.this.a(kx.d.i(a.this.f13917c.getApplicationContext()) + com.flypro.core.util.d.b(a.this.f13931q.getUrl()), str4, z3);
                        return;
                    }
                    Log.e("UsbCheckFirmwareUtils", "completed: =====imageFwBean is null");
                }
            }

            /* access modifiers changed from: protected */
            public void c(com.liulishuo.filedownloader.a aVar, int i2, int i3) {
            }

            /* access modifiers changed from: protected */
            public void d(com.liulishuo.filedownloader.a aVar) {
            }
        }).a(str2).c();
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, boolean z2) {
        if (XEagleApp.d().c()) {
            final en.a k2 = XEagleApp.d().k();
            if (!k2.d().c()) {
                if (!XEagleApp.d().j().aY()) {
                    this.f13932r.set(false);
                    a(this.f13917c.getString(R.string.warning), this.f13917c.getString(R.string.upgrade_image_sd_error), (c.a) null);
                    if (!this.f13916b) {
                        j();
                        return;
                    }
                    return;
                }
                if (this.f13928n == null) {
                    this.f13928n = r.a().a(this.f13917c.getString(R.string.warning), this.f13917c.getString(R.string.upgrade_image_warn));
                }
                final String str3 = str;
                final String str4 = str2;
                final boolean z3 = z2;
                this.f13928n.a((m.a) new m.a() {
                    public void a() {
                        ka.a.a().b().execute(new Runnable() {
                            public void run() {
                                b.a(k2, (byte) 33);
                                if (FtpBase.UploadStatus.UPLOAD_NEW_FILE_SUCCESS == a.this.b(str3, "/tmp/SD0/DRONE_FWUPDATE.bin", 15) && a.this.b(str4, "/tmp/SD0/PBA_FWUPDATE.bin", 28) == FtpBase.UploadStatus.UPLOAD_NEW_FILE_SUCCESS) {
                                    XEagleApp.d().g().b("/tmp/SD0/DRONE_FWUPDATE.bin");
                                    File file = new File(str3);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    File file2 = new File(str4);
                                    if (file2.exists()) {
                                        file2.delete();
                                    }
                                }
                            }
                        });
                    }

                    public void b() {
                        if (a.this.f13937w == 15) {
                            a.this.f13932r.set(false);
                            if (!a.this.f13916b) {
                                a.this.j();
                            }
                        }
                    }

                    public void c() {
                        if (z3) {
                            a.this.f13928n.a(false);
                            a.this.f13928n.b(true);
                            return;
                        }
                        a.this.f13928n.a(true);
                        a.this.f13928n.b(false);
                    }
                });
                if (!this.f13928n.isAdded()) {
                    this.f13928n.show(this.f13918d.getSupportFragmentManager(), "uploadImage");
                    return;
                }
                return;
            }
        }
        this.f13932r.set(false);
    }

    /* access modifiers changed from: private */
    public void a(String str, final boolean z2) {
        if (!XEagleApp.d().c()) {
            this.f13932r.set(false);
            Log.i("UsbCheckFirmwareUtils", "upgradeRepeaterFwVersion: =======usb is disconnected");
            return;
        }
        final String str2 = kx.d.i(this.f13917c.getApplicationContext()) + "proxyserver";
        Log.i("UsbCheckFirmwareUtils", "onFinish: ====repeater====upgrade====" + str2);
        if (str.equals(com.xeagle.android.utils.c.g(str2))) {
            final en.a k2 = XEagleApp.d().k();
            if (k2.d().c()) {
                this.f13932r.set(false);
                return;
            }
            if (this.f13927m == null) {
                this.f13927m = r.a().a(this.f13917c.getString(R.string.warning), this.f13917c.getString(R.string.upgrade_repeater_tips));
            }
            this.f13927m.a((m.a) new m.a() {
                public void a() {
                    ka.a.a().b().execute(new Runnable() {
                        public void run() {
                            b.a(k2, (byte) 33);
                            XEagleApp.d().e().a(str2, "/tmp/proxyserver", a.this.f13938x, 21);
                            File file = new File(str2);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                    });
                }

                public void b() {
                    a.this.f13932r.set(false);
                    a.this.j();
                }

                public void c() {
                    if (z2) {
                        a.this.f13927m.a(false);
                        a.this.f13927m.b(true);
                        return;
                    }
                    a.this.f13927m.a(true);
                    a.this.f13927m.b(false);
                }
            });
            if (!this.f13927m.isAdded()) {
                this.f13927m.show(this.f13918d.getSupportFragmentManager(), "repeaterUploadDlg");
            }
        }
    }

    /* access modifiers changed from: private */
    public FtpBase.UploadStatus b(String str, String str2, int i2) {
        m();
        return ((XEagleApp) this.f13917c.getApplicationContext()).e().b(str, str2, this.f13938x, i2) ? FtpBase.UploadStatus.UPLOAD_NEW_FILE_SUCCESS : FtpBase.UploadStatus.UPLOAD_NEW_FILE_FAIL;
    }

    private void b(int i2) {
        this.f13932r.set(false);
        if (13 == i2) {
            l();
            return;
        }
        if (21 != i2) {
            if (14 == i2) {
                k();
                return;
            } else if (15 == i2) {
                this.f13932r.set(false);
                if (this.f13916b) {
                    return;
                }
            } else {
                return;
            }
        }
        j();
    }

    /* access modifiers changed from: private */
    public void b(final String str, final boolean z2) {
        if (XEagleApp.d().c()) {
            final en.a k2 = XEagleApp.d().k();
            if (k2.y() != null && !k2.d().c()) {
                if (this.f13926l == null) {
                    this.f13926l = r.a().a(this.f13917c.getString(R.string.warning), this.f13917c.getString(R.string.upgrade_drone_tips));
                }
                this.f13926l.a((m.a) new m.a() {
                    public void a() {
                        ka.a.a().b().execute(new Runnable() {
                            public void run() {
                                b.a(k2, (byte) 33);
                                File file = new File(str);
                                a aVar = a.this;
                                String str = str;
                                if (FtpBase.UploadStatus.UPLOAD_NEW_FILE_SUCCESS == aVar.b(str, "/pref/" + file.getName(), 14)) {
                                    a aVar2 = a.this;
                                    String unused = aVar2.f13930p = "/pref/" + file.getName();
                                    AmbaClient g2 = XEagleApp.d().g();
                                    String str2 = str;
                                    g2.d(str2, "/pref/" + file.getName());
                                    a.this.f13933s.set(true);
                                }
                                if (file.exists()) {
                                    file.delete();
                                }
                            }
                        });
                    }

                    public void b() {
                        a.this.f13932r.set(false);
                        a.this.k();
                    }

                    public void c() {
                        if (z2) {
                            a.this.f13926l.b(true);
                            a.this.f13926l.a(false);
                            return;
                        }
                        a.this.f13926l.b(false);
                        a.this.f13926l.a(true);
                    }
                });
                if (!this.f13926l.isAdded()) {
                    this.f13926l.show(this.f13918d.getSupportFragmentManager(), "droneUploadDlg");
                    return;
                }
                return;
            }
        }
        this.f13932r.set(false);
    }

    public static a e() {
        return C0213a.f30650a;
    }

    /* access modifiers changed from: private */
    public void m() {
        an anVar = this.f13920f;
        if (anVar != null) {
            if (anVar.isShowing()) {
                try {
                    this.f13920f.dismiss();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.f13920f = null;
        }
    }

    public void a(Context context) {
        this.f13917c = context;
        this.f13919e = new RegPresenter(this);
        q.a(context);
        q.a().a(1);
    }

    public void a(AppCompatActivity appCompatActivity) {
        this.f13918d = appCompatActivity;
        this.f13934t = false;
        this.f13932r.set(false);
    }

    public void a(XEagleApp xEagleApp) {
        com.xeagle.android.communication.ftp.c.a().a(xEagleApp);
        m();
        a(this.f13917c.getString(R.string.warning), this.f13917c.getString(R.string.upgrade_sd_warn), (c.a) null);
    }

    public void a(boolean z2) {
        this.f13936v = z2;
    }

    public boolean a() {
        ah ahVar = this.f13921g;
        return ahVar != null && ahVar.isAdded();
    }

    public boolean b() {
        return this.f13932r.get();
    }

    public boolean c() {
        return this.f13933s.get();
    }

    public void d() {
        this.f13933s.set(false);
    }

    public void f() {
        ah ahVar = this.f13921g;
        if (ahVar != null && ahVar.isAdded()) {
            if (this.f13921g.a() >= 100 || 100 - this.f13921g.a() > 5) {
                this.f13938x.postDelayed(new Runnable() {
                    /* access modifiers changed from: private */
                    public /* synthetic */ void a() {
                        a.this.h();
                    }

                    public void run() {
                        if (a.this.f13921g != null) {
                            com.xeagle.android.utils.d.a();
                            a.this.f13921g.a(100);
                            a.this.f13921g.a(a.this.f13917c.getString(R.string.upgrade_complete));
                            a.this.f13938x.postDelayed(new Runnable() {
                                public final void run() {
                                    a.AnonymousClass10.this.a();
                                }
                            }, 1000);
                        }
                    }
                }, 5000);
            } else {
                this.f13938x.postDelayed(new Runnable() {
                    /* access modifiers changed from: private */
                    public /* synthetic */ void a() {
                        a.this.h();
                    }

                    public void run() {
                        if (a.this.f13921g != null) {
                            com.xeagle.android.utils.d.a();
                            a.this.f13921g.a(100);
                            a.this.f13921g.a(a.this.f13917c.getString(R.string.upgrade_complete));
                            a.this.f13938x.postDelayed(new Runnable() {
                                public final void run() {
                                    a.AnonymousClass9.this.a();
                                }
                            }, 1000);
                        }
                    }
                }, (long) Math.abs(100 - this.f13921g.a()));
            }
        }
    }

    public void g() {
        if (new e(this.f13917c.getApplicationContext()).a(this.f13917c.getApplicationContext())) {
            this.f13934t = true;
            this.f13935u = true;
            this.f13932r.set(false);
            l();
        }
    }

    public void h() {
        ah ahVar = this.f13921g;
        if (ahVar != null && ahVar.isAdded()) {
            this.f13921g.dismissAllowingStateLoss();
            this.f13932r.set(false);
        }
        this.f13921g = null;
    }

    public FtpBase.UploadStatus i() throws Exception {
        return com.xeagle.android.communication.ftp.c.a().a() ? this.f13930p != null ? com.xeagle.android.communication.ftp.c.a().a(this.f13930p) : FtpBase.UploadStatus.DELETE_REMOTE_FAIL : FtpBase.UploadStatus.DELETE_REMOTE_FAIL;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0072, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void j() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.xeagle.android.XEagleApp r0 = com.xeagle.android.XEagleApp.d()     // Catch:{ all -> 0x0073 }
            en.a r0 = r0.k()     // Catch:{ all -> 0x0073 }
            com.flypro.core.drone.variables.aa r0 = r0.d()     // Catch:{ all -> 0x0073 }
            boolean r0 = r0.c()     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x0015
            monitor-exit(r3)
            return
        L_0x0015:
            boolean r0 = r3.b()     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x001d
            monitor-exit(r3)
            return
        L_0x001d:
            boolean r0 = r3.f13916b     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x0023
            monitor-exit(r3)
            return
        L_0x0023:
            r0 = 1
            r3.f13916b = r0     // Catch:{ all -> 0x0073 }
            java.util.concurrent.atomic.AtomicBoolean r1 = r3.f13932r     // Catch:{ all -> 0x0073 }
            r1.set(r0)     // Catch:{ all -> 0x0073 }
            java.lang.String r0 = "UsbCheckFirmwareUtils"
            java.lang.String r1 = "----> checkDroneVersion"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0073 }
            com.xeagle.android.XEagleApp r0 = com.xeagle.android.XEagleApp.d()     // Catch:{ all -> 0x0073 }
            com.hoho.android.usb.usb.data_proxy.d r0 = r0.e()     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x0071
            com.xeagle.android.XEagleApp r0 = com.xeagle.android.XEagleApp.d()     // Catch:{ all -> 0x0073 }
            com.hoho.android.usb.usb.data_proxy.d r0 = r0.e()     // Catch:{ all -> 0x0073 }
            boolean r0 = r0.i()     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x0071
            java.lang.String r0 = com.xeagle.android.utils.c.a()     // Catch:{ all -> 0x0073 }
            java.util.Locale r1 = java.util.Locale.CHINA     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = r1.getCountry()     // Catch:{ all -> 0x0073 }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x005d
            java.lang.String r0 = "upload/firmware_cn/drone_fw_info.json"
            goto L_0x005f
        L_0x005d:
            java.lang.String r0 = "upload/firmware_en/drone_fw_info.json"
        L_0x005f:
            com.xeagle.android.login.retrofitLogin.RegPresenter r1 = r3.f13919e     // Catch:{ all -> 0x0073 }
            java.lang.String r2 = "https://file.cfly-cn.com/"
            r1.getDroneFwInfo(r2, r0)     // Catch:{ all -> 0x0073 }
            r0 = 14
            r3.f13937w = r0     // Catch:{ all -> 0x0073 }
            java.lang.String r0 = "UsbCheckFirmwareUtils"
            java.lang.String r1 = "----> checkDroneVersion request url"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0073 }
        L_0x0071:
            monitor-exit(r3)
            return
        L_0x0073:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kz.a.j():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0078, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void k() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.xeagle.android.XEagleApp r0 = com.xeagle.android.XEagleApp.d()     // Catch:{ all -> 0x0079 }
            en.a r0 = r0.k()     // Catch:{ all -> 0x0079 }
            com.flypro.core.drone.variables.aa r0 = r0.d()     // Catch:{ all -> 0x0079 }
            boolean r0 = r0.c()     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x0015
            monitor-exit(r3)
            return
        L_0x0015:
            boolean r0 = r3.b()     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x001d
            monitor-exit(r3)
            return
        L_0x001d:
            boolean r0 = r3.f13936v     // Catch:{ all -> 0x0079 }
            if (r0 != 0) goto L_0x0023
            monitor-exit(r3)
            return
        L_0x0023:
            boolean r0 = r3.f13915a     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x0029
            monitor-exit(r3)
            return
        L_0x0029:
            r0 = 1
            r3.f13915a = r0     // Catch:{ all -> 0x0079 }
            java.util.concurrent.atomic.AtomicBoolean r1 = r3.f13932r     // Catch:{ all -> 0x0079 }
            r1.set(r0)     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = "UsbCheckFirmwareUtils"
            java.lang.String r1 = "----> checkImageVersion"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0079 }
            com.xeagle.android.XEagleApp r0 = com.xeagle.android.XEagleApp.d()     // Catch:{ all -> 0x0079 }
            com.hoho.android.usb.usb.data_proxy.d r0 = r0.e()     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x0077
            com.xeagle.android.XEagleApp r0 = com.xeagle.android.XEagleApp.d()     // Catch:{ all -> 0x0079 }
            com.hoho.android.usb.usb.data_proxy.d r0 = r0.e()     // Catch:{ all -> 0x0079 }
            boolean r0 = r0.i()     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x0077
            java.lang.String r0 = com.xeagle.android.utils.c.a()     // Catch:{ all -> 0x0079 }
            java.util.Locale r1 = java.util.Locale.CHINA     // Catch:{ all -> 0x0079 }
            java.lang.String r1 = r1.getCountry()     // Catch:{ all -> 0x0079 }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x0063
            java.lang.String r0 = "upload/firmware_cn/image_fw_info.json"
            goto L_0x0065
        L_0x0063:
            java.lang.String r0 = "upload/firmware_en/image_fw_info.json"
        L_0x0065:
            com.xeagle.android.login.retrofitLogin.RegPresenter r1 = r3.f13919e     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = "https://file.cfly-cn.com/"
            r1.getImageFwInfo(r2, r0)     // Catch:{ all -> 0x0079 }
            r0 = 15
            r3.f13937w = r0     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = "UsbCheckFirmwareUtils"
            java.lang.String r1 = "----> checkImageVersion request url"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0079 }
        L_0x0077:
            monitor-exit(r3)
            return
        L_0x0079:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kz.a.k():void");
    }

    public void l() {
        if (!XEagleApp.d().k().d().c()) {
            Log.d("UsbCheckFirmwareUtils", "----> checkRepeaterVersion");
            if (XEagleApp.d().c() && XEagleApp.d().j().p() && this.f13934t && !b()) {
                this.f13932r.set(true);
                this.f13919e.getRepeaterFwInfo(UserGlobal.DOWNLOAD_LINK_URL, com.xeagle.android.utils.c.a().equals(Locale.CHINA.getCountry()) ? UserGlobal.DOWNLOAD_REPEATER_JSON_CN : UserGlobal.DOWNLOAD_REPEATER_JSON_EN);
                this.f13937w = 21;
                Log.d("UsbCheckFirmwareUtils", "----> checkRepeaterVersion request url");
            }
        }
    }

    public void regError(int i2, String str) {
        b(i2);
        Log.e("UsbCheckFirmwareUtils", "regError: ===type---" + i2 + "---error===" + str);
    }

    public void regFailure(int i2) {
        b(i2);
    }

    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v34, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v35 */
    public void regSuccess(int i2, Object obj) {
        String str;
        String str2;
        m mVar;
        FragmentManager supportFragmentManager;
        m mVar2;
        FragmentManager supportFragmentManager2;
        final int i3 = i2;
        en.a k2 = XEagleApp.d().k();
        int i4 = 1;
        ? r6 = 0;
        if (i3 == 13) {
            final ApkVersion apkVersion = (ApkVersion) obj;
            Log.i("UsbCheckFirmwareUtils", "-----> check Apk " + apkVersion.toString());
            if (apkVersion.getVersionCode() <= com.xeagle.android.utils.c.d(this.f13917c.getApplicationContext())) {
                this.f13934t = true;
                this.f13932r.set(false);
                l();
            } else if (k2.d().c()) {
                this.f13932r.set(false);
                this.f13935u = false;
            } else {
                if (this.f13922h == null) {
                    this.f13922h = r.a().a(this.f13917c.getString(R.string.version_update_apk), apkVersion.getUpdate_info());
                }
                this.f13922h.a((m.a) new m.a() {
                    public void a() {
                        final String str = kx.d.j(a.this.f13917c.getApplicationContext()) + "C-FLY2_" + apkVersion.getApk_version().replace(".", "_") + ".apk";
                        q.a().a(apkVersion.getApk_url()).a((i) new g() {
                            /* access modifiers changed from: protected */
                            public void a(com.liulishuo.filedownloader.a aVar, long j2, long j3) {
                            }

                            /* access modifiers changed from: protected */
                            public void a(com.liulishuo.filedownloader.a aVar, String str, boolean z2, long j2, long j3) {
                                super.a(aVar, str, z2, j2, j3);
                                Log.i("APK", "connected:------- " + j2);
                                if (!a.this.a()) {
                                    if (a.this.f13920f == null) {
                                        a.this.a(a.this.f13917c.getString(R.string.download), apkVersion.getUpdate_info(), (int) j3);
                                    } else {
                                        a.this.f13920f.a(a.this.f13917c.getString(R.string.download));
                                        a.this.f13920f.a((int) j3);
                                    }
                                    an a2 = a.this.f13920f;
                                    boolean z3 = true;
                                    if (apkVersion.getNeed_upgrade() != 1) {
                                        z3 = false;
                                    }
                                    a2.b(z3);
                                    a.this.f13920f.a(0);
                                    a.this.f13920f.b(apkVersion.getUpdate_info());
                                    if (!a.this.f13920f.isShowing()) {
                                        a.this.f13920f.show();
                                    }
                                }
                            }

                            /* access modifiers changed from: protected */
                            public void a(com.liulishuo.filedownloader.a aVar, Throwable th) {
                                if (a.this.f13920f != null) {
                                    a.this.f13920f.a(a.this.f13917c.getString(R.string.download_fail_network));
                                    a.this.f13920f.b(true);
                                }
                                Log.i("APK", "error:--download---- " + th.getMessage());
                                boolean unused = a.this.f13934t = true;
                                a.this.f13932r.set(false);
                                a.this.l();
                            }

                            /* access modifiers changed from: protected */
                            public void b(com.liulishuo.filedownloader.a aVar, long j2, long j3) {
                                Log.i("APK", "progress: ----SOFAR--" + j2 + "--total--" + j3);
                                if (!a.this.a()) {
                                    if (a.this.f13920f == null) {
                                        a.this.a(a.this.f13917c.getString(R.string.download), a.this.f13917c.getString(R.string.upgrade_warning), (int) j3);
                                        a.this.f13920f.b(apkVersion.getUpdate_info());
                                    }
                                    a.this.f13920f.a(j2);
                                }
                            }

                            /* access modifiers changed from: protected */
                            public void c(com.liulishuo.filedownloader.a aVar) {
                                Toast.makeText(a.this.f13917c, R.string.file_is_downloaded, 0).show();
                                if (a.this.f13920f != null) {
                                    a.this.f13920f.dismiss();
                                }
                                Log.i("APK", "completed:----path--- " + str);
                                AppUtils.installApp(str);
                            }

                            /* access modifiers changed from: protected */
                            public void c(com.liulishuo.filedownloader.a aVar, long j2, long j3) {
                            }

                            /* access modifiers changed from: protected */
                            public void d(com.liulishuo.filedownloader.a aVar) {
                            }
                        }).a(str).c();
                    }

                    public void b() {
                        boolean unused = a.this.f13934t = true;
                        a.this.f13932r.set(false);
                        a.this.l();
                    }

                    public void c() {
                        if (apkVersion.getNeed_upgrade() == 1) {
                            a.this.f13922h.b(true);
                            a.this.f13922h.a(false);
                            return;
                        }
                        a.this.f13922h.b(false);
                        a.this.f13922h.a(true);
                    }
                });
                if (!this.f13922h.isAdded()) {
                    this.f13922h.show(this.f13918d.getSupportFragmentManager(), "apkUpgrade");
                }
            }
        } else {
            String str3 = "-";
            if (i3 == 14) {
                DroneFwInfo droneFwInfo = (DroneFwInfo) obj;
                Log.i("UsbCheckFirmwareUtils", "-----> check drone " + droneFwInfo.toString());
                ArrayList<DroneFwBeans> drone_firmware = droneFwInfo.getDrone_firmware();
                String n2 = XEagleApp.d().m().n();
                String y2 = k2.y();
                if (y2 == null || n2 == null) {
                    Log.i("UsbCheckFirmwareUtils", "regSuccess: =====droneVersion is null");
                    this.f13916b = false;
                    this.f13932r.set(false);
                    k();
                    return;
                }
                String[] split = n2.split(str3);
                double parseDouble = Double.parseDouble(y2.substring(y2.indexOf("v") + 1, y2.indexOf("v") + 4));
                Log.i("UsbCheckFirmwareUtils", "regSuccess: ====droneType====" + n2);
                int i5 = 0;
                while (i5 < drone_firmware.size()) {
                    final DroneFwBeans droneFwBeans = drone_firmware.get(i5);
                    if (droneFwBeans.getDrone_type().equalsIgnoreCase(split[r6]) && droneFwBeans.getChip_type().equalsIgnoreCase(split[i4])) {
                        try {
                            String firmware_version = droneFwBeans.getFirmware_version();
                            double parseDouble2 = Double.parseDouble(firmware_version.substring(firmware_version.indexOf("v") + i4, firmware_version.indexOf("v") + 4));
                            Log.i("UsbCheckFirmwareUtils", "regSuccess: ===droneVersion==" + parseDouble + "===netDroneVersion===" + parseDouble2);
                            if (parseDouble >= parseDouble2) {
                                this.f13932r.set(false);
                                k();
                                return;
                            } else if (!k2.d().c()) {
                                Log.i("UsbCheckFirmwareUtils", "==> 飞控升级匹配到该版本 = " + droneFwBeans);
                                final String str4 = kx.d.i(this.f13917c.getApplicationContext()) + com.flypro.core.util.d.b(droneFwBeans.getFile_path());
                                File file = new File(str4);
                                if (file.exists()) {
                                    String g2 = com.xeagle.android.utils.c.g(str4);
                                    Objects.requireNonNull(g2);
                                    if (g2.equals(droneFwBeans.getMd5())) {
                                        b(str4, droneFwBeans.getEnforce() == 1);
                                        return;
                                    } else if (file.delete()) {
                                        if (this.f13923i == null) {
                                            this.f13923i = r.a().a(this.f13917c.getString(R.string.drone_warning), droneFwBeans.getContent());
                                        }
                                        this.f13923i.a((m.a) new m.a() {
                                            public void a() {
                                                a.this.a(droneFwBeans.getFile_path(), str4, droneFwBeans.getMd5(), i3, droneFwBeans.getEnforce() == 1);
                                            }

                                            public void b() {
                                                a.this.f13932r.set(false);
                                                a.this.k();
                                            }

                                            public void c() {
                                                if (droneFwBeans.getEnforce() == 1) {
                                                    a.this.f13923i.a(false);
                                                    a.this.f13923i.b(true);
                                                    return;
                                                }
                                                a.this.f13923i.a(true);
                                                a.this.f13923i.b(false);
                                            }
                                        });
                                        if (!this.f13923i.isAdded()) {
                                            mVar2 = this.f13923i;
                                            supportFragmentManager2 = this.f13918d.getSupportFragmentManager();
                                        } else {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } else {
                                    if (this.f13923i == null) {
                                        this.f13923i = r.a().a(this.f13917c.getString(R.string.drone_warning), droneFwBeans.getContent());
                                    }
                                    this.f13923i.a((m.a) new m.a() {
                                        public void a() {
                                            a.this.a(droneFwBeans.getFile_path(), str4, droneFwBeans.getMd5(), i3, droneFwBeans.getEnforce() == 1);
                                        }

                                        public void b() {
                                            a.this.f13932r.set(false);
                                            a.this.k();
                                        }

                                        public void c() {
                                            if (droneFwBeans.getEnforce() == 1) {
                                                a.this.f13923i.a(false);
                                                a.this.f13923i.b(true);
                                                return;
                                            }
                                            a.this.f13923i.a(true);
                                            a.this.f13923i.b(false);
                                        }
                                    });
                                    if (!this.f13923i.isAdded()) {
                                        mVar2 = this.f13923i;
                                        supportFragmentManager2 = this.f13918d.getSupportFragmentManager();
                                    } else {
                                        return;
                                    }
                                }
                                mVar2.show(supportFragmentManager2, "droneUpgrade");
                                return;
                            } else {
                                return;
                            }
                        } catch (Exception e2) {
                            this.f13932r.set(false);
                            k();
                            e2.printStackTrace();
                        }
                    } else if (i5 == drone_firmware.size() - 1) {
                        this.f13932r.set(r6);
                        k();
                    }
                    i5++;
                    i4 = 1;
                    r6 = 0;
                }
            } else if (i3 == 21) {
                RepeaterFwInfo repeaterFwInfo = (RepeaterFwInfo) obj;
                Log.i("UsbCheckFirmwareUtils", "-----> check repeater " + repeaterFwInfo.toString());
                ArrayList<RepeaterFwBeans> repeater_firmware = repeaterFwInfo.getRepeater_firmware();
                if (repeater_firmware == null || repeater_firmware.isEmpty()) {
                    this.f13932r.set(false);
                    this.f13932r.set(false);
                    j();
                    return;
                }
                String q2 = XEagleApp.d().j().q();
                long parseLong = Long.parseLong(q2.replace(".", "").replace(str3, ""));
                int i6 = 0;
                while (i6 < repeater_firmware.size()) {
                    final RepeaterFwBeans repeaterFwBeans = repeater_firmware.get(i6);
                    try {
                        String firmware_version2 = repeaterFwBeans.getFirmware_version();
                        long parseLong2 = Long.parseLong(firmware_version2.replace(".", "").replace(str3, ""));
                        str2 = str3;
                        try {
                            if (com.xeagle.android.utils.c.i(q2) != com.xeagle.android.utils.c.i(firmware_version2) || parseLong >= parseLong2) {
                                str = q2;
                                if (i6 == repeater_firmware.size() - 1) {
                                    this.f13932r.set(false);
                                    j();
                                }
                                i6++;
                                q2 = str;
                                str3 = str2;
                            } else if (!k2.d().c()) {
                                Log.i("UsbCheckFirmwareUtils", "==> 中继升级匹配到该版本 = " + repeaterFwBeans);
                                final String str5 = kx.d.i(this.f13917c.getApplicationContext()) + "proxyserver";
                                File file2 = new File(str5);
                                str = q2;
                                if (file2.exists()) {
                                    try {
                                        String g3 = com.xeagle.android.utils.c.g(str5);
                                        Objects.requireNonNull(g3);
                                        if (g3.equals(repeaterFwBeans.getMd5())) {
                                            a(repeaterFwBeans.getMd5(), repeaterFwBeans.getEnforce() == 1);
                                            return;
                                        } else if (file2.delete()) {
                                            if (this.f13924j == null) {
                                                this.f13924j = r.a().a(this.f13917c.getString(R.string.repeater_warning), repeaterFwBeans.getContent());
                                            }
                                            this.f13924j.a((m.a) new m.a() {
                                                public void a() {
                                                    a.this.a(repeaterFwBeans.getFile_path(), str5, repeaterFwBeans.getMd5(), i3, repeaterFwBeans.getEnforce() == 1);
                                                }

                                                public void b() {
                                                    a.this.f13932r.set(false);
                                                    a.this.f13932r.set(false);
                                                    a.this.j();
                                                }

                                                public void c() {
                                                    if (repeaterFwBeans.getEnforce() == 1) {
                                                        a.this.f13924j.b(true);
                                                        a.this.f13924j.a(false);
                                                        return;
                                                    }
                                                    a.this.f13924j.b(false);
                                                    a.this.f13924j.a(true);
                                                }
                                            });
                                            if (!this.f13924j.isAdded()) {
                                                mVar = this.f13924j;
                                                supportFragmentManager = this.f13918d.getSupportFragmentManager();
                                            } else {
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        e.printStackTrace();
                                        this.f13932r.set(false);
                                        j();
                                        i6++;
                                        q2 = str;
                                        str3 = str2;
                                    }
                                } else {
                                    if (this.f13924j == null) {
                                        this.f13924j = r.a().a(this.f13917c.getString(R.string.repeater_warning), repeaterFwBeans.getContent());
                                    }
                                    this.f13924j.a((m.a) new m.a() {
                                        public void a() {
                                            a.this.a(repeaterFwBeans.getFile_path(), str5, repeaterFwBeans.getMd5(), i3, repeaterFwBeans.getEnforce() == 1);
                                        }

                                        public void b() {
                                            a.this.f13932r.set(false);
                                            a.this.j();
                                        }

                                        public void c() {
                                            if (repeaterFwBeans.getEnforce() == 1) {
                                                a.this.f13924j.b(true);
                                                a.this.f13924j.a(false);
                                                return;
                                            }
                                            a.this.f13924j.b(false);
                                            a.this.f13924j.a(true);
                                        }
                                    });
                                    if (!this.f13924j.isAdded()) {
                                        mVar = this.f13924j;
                                        supportFragmentManager = this.f13918d.getSupportFragmentManager();
                                    } else {
                                        return;
                                    }
                                }
                                mVar.show(supportFragmentManager, "repeaterUpgrade");
                                return;
                            } else {
                                return;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            str = q2;
                            e.printStackTrace();
                            this.f13932r.set(false);
                            j();
                            i6++;
                            q2 = str;
                            str3 = str2;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        str = q2;
                        str2 = str3;
                        e.printStackTrace();
                        this.f13932r.set(false);
                        j();
                        i6++;
                        q2 = str;
                        str3 = str2;
                    }
                }
            } else if (i3 == 15) {
                ImageFwInfo imageFwInfo = (ImageFwInfo) obj;
                Log.i("UsbCheckFirmwareUtils", "-----> check imager " + imageFwInfo.toString());
                ArrayList<ImageFwBeans> image_firmware = imageFwInfo.getImage_firmware();
                com.xeagle.android.utils.prefs.a j2 = XEagleApp.d().j();
                String t2 = j2.t();
                String j3 = j2.j();
                long parseLong3 = Long.parseLong(t2.substring(t2.lastIndexOf("_") + 1));
                for (int i7 = 0; i7 < image_firmware.size(); i7++) {
                    final ImageFwBeans imageFwBeans = image_firmware.get(i7);
                    if (t2.contains(imageFwBeans.getSubType()) && imageFwBeans.getUrl().contains(j3)) {
                        String version = imageFwBeans.getVersion();
                        if (parseLong3 < Long.parseLong(version.substring(version.lastIndexOf("_") + 1))) {
                            if (k2.d().c()) {
                                this.f13932r.set(false);
                                return;
                            }
                            this.f13931q = imageFwBeans;
                            Log.i("UsbCheckFirmwareUtils", "==> 影像升级匹配到该版本 = " + imageFwBeans);
                            final String str6 = kx.d.i(this.f13917c.getApplicationContext()) + com.flypro.core.util.d.b(imageFwBeans.getUrl());
                            File file3 = new File(str6);
                            if (file3.exists()) {
                                String g4 = com.xeagle.android.utils.c.g(str6);
                                Objects.requireNonNull(g4);
                                if (g4.equals(imageFwBeans.getMd5())) {
                                    a(str6);
                                    return;
                                } else if (file3.delete()) {
                                    if (this.f13925k == null) {
                                        this.f13925k = r.a().a(this.f13917c.getString(R.string.image_warning), imageFwBeans.getContent());
                                    }
                                    this.f13925k.a((m.a) new m.a() {
                                        public void a() {
                                            a.this.a(imageFwBeans.getUrl(), str6, imageFwBeans.getMd5(), i3, imageFwBeans.getForce() == 1);
                                        }

                                        public void b() {
                                            a.this.f13932r.set(false);
                                            if (!a.this.f13916b) {
                                                a.this.j();
                                            }
                                        }

                                        public void c() {
                                            if (imageFwBeans.getForce() == 1) {
                                                a.this.f13925k.a(false);
                                                a.this.f13925k.b(true);
                                                return;
                                            }
                                            a.this.f13925k.a(true);
                                            a.this.f13925k.b(false);
                                        }
                                    });
                                    if (this.f13925k.isAdded()) {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                if (this.f13925k == null) {
                                    this.f13925k = r.a().a(this.f13917c.getString(R.string.image_warning), imageFwBeans.getContent());
                                }
                                this.f13925k.a((m.a) new m.a() {
                                    public void a() {
                                        a.this.a(imageFwBeans.getUrl(), str6, imageFwBeans.getMd5(), i3, imageFwBeans.getForce() == 1);
                                    }

                                    public void b() {
                                        a.this.f13932r.set(false);
                                        if (!a.this.f13916b) {
                                            a.this.j();
                                        }
                                    }

                                    public void c() {
                                        if (imageFwBeans.getForce() == 1) {
                                            a.this.f13925k.a(false);
                                            a.this.f13925k.b(true);
                                            return;
                                        }
                                        a.this.f13925k.a(true);
                                        a.this.f13925k.b(false);
                                    }
                                });
                                if (this.f13925k.isAdded()) {
                                    return;
                                }
                            }
                            this.f13925k.show(this.f13918d.getSupportFragmentManager(), "upgradeImage");
                            return;
                        }
                    } else if (i7 == image_firmware.size() - 1) {
                        this.f13932r.set(false);
                        if (!this.f13916b) {
                            j();
                        }
                    }
                }
            }
        }
    }
}
