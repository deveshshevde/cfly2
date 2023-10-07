package com.xeagle.android;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.Log;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.common.msg_statustext;
import com.blankj.utilcode.util.Utils;
import com.flypro.core.MAVLink.a;
import com.flypro.core.MAVLink.i;
import com.flypro.core.database.LitepalContext;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.gcs.follow.Follow;
import com.hoho.android.usb.rtsp.a;
import com.hoho.android.usb.usb.data_proxy.d;
import com.myusb.proxy.proto.Proxy;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.shuyu.gsyvideoplayer.utils.GSYVideoType;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.login.retrofitLogin.sochip.SochipPresenter;
import com.xeagle.android.newUI.cameraManager.AmbaClient;
import com.xeagle.android.newUI.cameraManager.b;
import com.xeagle.android.newUI.cameraManager.c;
import com.xeagle.android.utils.q;
import dy.ap;
import dy.k;
import dy.l;
import ea.e;
import io.microshow.rxffmpeg.RxFFmpegInvoke;
import iv.c;
import iv.h;
import ja.f;
import ja.g;
import ja.j;
import java.util.concurrent.TimeUnit;
import jo.am;
import jo.an;
import jo.aw;
import jo.ax;
import km.a;
import org.greenrobot.eventbus.ThreadMode;
import org.litepal.LitePal;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class XEagleApp extends ErrorReportApp {

    /* renamed from: a  reason: collision with root package name */
    public static Context f12203a;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static XEagleApp f12204p;

    /* renamed from: b  reason: collision with root package name */
    public a f12205b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public en.a f12206c;

    /* renamed from: d  reason: collision with root package name */
    private Follow f12207d;

    /* renamed from: e  reason: collision with root package name */
    private kn.a f12208e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public i f12209f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public com.xeagle.android.utils.prefs.a f12210g;

    /* renamed from: h  reason: collision with root package name */
    private kd.a f12211h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f12212i;

    /* renamed from: j  reason: collision with root package name */
    private e f12213j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public b f12214k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public AmbaClient f12215l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public SochipPresenter f12216m;

    /* renamed from: n  reason: collision with root package name */
    private com.flypro.core.util.e f12217n;

    /* renamed from: o  reason: collision with root package name */
    private DroneInterfaces.b f12218o;

    /* renamed from: q  reason: collision with root package name */
    private d f12219q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public com.hoho.android.usb.rtsp.a f12220r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public hb.a f12221s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public boolean f12222t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public boolean f12223u = false;

    /* renamed from: v  reason: collision with root package name */
    private long f12224v = 0;

    /* renamed from: w  reason: collision with root package name */
    private io.reactivex.disposables.b f12225w;

    /* renamed from: x  reason: collision with root package name */
    private Runnable f12226x = new Runnable() {
        public final void run() {
            XEagleApp.this.w();
        }
    };

    static {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator($$Lambda$XEagleApp$6L5FuAsKX0QPi5_UHWItwXEo0.INSTANCE);
        SmartRefreshLayout.setDefaultRefreshFooterCreator($$Lambda$XEagleApp$Xx5cZVpaNAQFOPRIdaarKNEjL5E.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ f a(Context context, j jVar) {
        return (ClassicsFooter) new ClassicsFooter(context).a(20.0f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Long l2) throws Exception {
        if (System.currentTimeMillis() - this.f12224v > 5000) {
            if (com.flypro.core.util.a.a().h()) {
                com.flypro.core.util.a.a().b(f12203a);
            }
            io.reactivex.disposables.b bVar = this.f12225w;
            if (bVar != null) {
                bVar.dispose();
                this.f12225w = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ g b(Context context, j jVar) {
        return new ClassicsHeader(context);
    }

    public static XEagleApp d() {
        return f12204p;
    }

    private void r() {
        iv.f.a((c) new iv.a(h.a().a(false).a(0).b(7).a("LOOK_LOG").a()) {
            public boolean a(int i2, String str) {
                return true;
            }
        });
    }

    private void s() {
        this.f12214k = b.a(this, this.f12218o, new c.a() {
            public void a(int i2) {
                org.greenrobot.eventbus.c a2;
                ax axVar;
                if (!XEagleApp.this.m().d()) {
                    if (i2 == 1) {
                        hf.d.b("CmdChannel", "tcpConnectSuccess: ");
                        XEagleApp.this.f12212i.a(1);
                        if (!XEagleApp.this.f12222t) {
                            a2 = org.greenrobot.eventbus.c.a();
                            axVar = new ax(1);
                        } else {
                            return;
                        }
                    } else if (i2 == 2) {
                        hf.d.b("Sochip", "tcpConnectSuccess: ");
                        XEagleApp.this.f12212i.a(2);
                        if (!XEagleApp.this.f12222t) {
                            a2 = org.greenrobot.eventbus.c.a();
                            axVar = new ax(2);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                    a2.e(axVar);
                }
            }

            public void a(int i2, String str) {
            }

            public void b(int i2) {
                hf.d.b("CmdChannel", "reportDisconnect:--- " + i2);
            }

            public void b(int i2, String str) {
                if (!XEagleApp.this.m().d()) {
                    int i3 = 1;
                    if (i2 == 1) {
                        hf.d.b("CmdChannel", "tcpConnectError:---- " + str);
                        if (XEagleApp.this.f12215l != null && !XEagleApp.this.c()) {
                            XEagleApp.this.f12215l.disconnect();
                            XEagleApp.this.f12214k.a();
                            SystemClock.sleep(200);
                        } else {
                            return;
                        }
                    } else {
                        i3 = 2;
                        if (i2 == 2 && XEagleApp.this.f12216m != null) {
                            Log.e("Sochip", "tcpConnectError:------ " + str);
                            if (!"length=1024; regionStart=0; regionLength=-1".equalsIgnoreCase(str)) {
                                XEagleApp.this.f12216m.disconnect();
                                XEagleApp.this.f12214k.a();
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    XEagleApp.this.f12214k.a(i3);
                }
            }

            public void c(int i2, String str) {
                if (!XEagleApp.this.m().d()) {
                    if (i2 == 1) {
                        if (!XEagleApp.this.c()) {
                            hf.d.b("RTSP", "tcpConnectFail: --" + str);
                            org.greenrobot.eventbus.c.a().e(new aw(str));
                            if (XEagleApp.this.f12215l != null) {
                                XEagleApp.this.f12215l.a();
                                XEagleApp.this.f12215l.disconnect();
                            }
                            XEagleApp.this.f12214k.a();
                            XEagleApp.this.f12214k.a(2);
                        }
                    } else if (i2 == 2) {
                        Log.e("Sochip", "tcpConnectFail: -----sochip present--");
                        XEagleApp.this.f12212i.a(1);
                        if (XEagleApp.this.f12216m != null) {
                            XEagleApp.this.f12216m.disconnect();
                        }
                        XEagleApp.this.f12214k.a();
                        XEagleApp.this.f12214k.a(1);
                    }
                }
            }
        }, new c.C0090c() {
            public void a(int i2, int i3, Object obj, String... strArr) {
                org.greenrobot.eventbus.c a2;
                Object gVar;
                if (i2 == 1) {
                    a2 = org.greenrobot.eventbus.c.a();
                    gVar = new jo.c(i3, obj);
                } else if (i2 == 2) {
                    a2 = org.greenrobot.eventbus.c.a();
                    gVar = new jp.g(i3, obj);
                } else {
                    return;
                }
                a2.d(gVar);
            }
        }, new c.b() {
            public void a(int i2, int i3) {
                if (i2 == 2) {
                    org.greenrobot.eventbus.c.a().d(new jp.e(i3));
                }
            }

            public void a(int i2, int i3, Object obj) {
                if (i2 == 2) {
                    org.greenrobot.eventbus.c.a().d(new jp.f(i3, obj));
                }
            }

            public void a(int i2, int i3, String str) {
                if (i2 == 2) {
                    org.greenrobot.eventbus.c.a().d(new jp.d(i3, str));
                }
            }
        });
        hf.d.b("Sochip", "socSuccess:------ ");
        this.f12214k.a(1);
    }

    private void t() {
        com.xeagle.android.communication.service.a aVar = new com.xeagle.android.communication.service.a(this, new a.b() {
            public void a() {
                org.greenrobot.eventbus.c.a().d(new k(0));
            }

            public void a(MAVLinkMessage mAVLinkMessage) {
                if (mAVLinkMessage.f6280c == 253) {
                    String a2 = ((msg_statustext) mAVLinkMessage).a();
                    if (a2.contains("FLIGHT-") && (a2.contains(UserGlobal.DRONE_TYPE_DF808) || a2.contains(UserGlobal.DRONE_TYPE_DF812) || a2.contains(UserGlobal.DRONE_TYPE_DF809) || a2.contains(UserGlobal.DRONE_TYPE_DF816) || a2.contains(UserGlobal.DRONE_TYPE_DF817))) {
                        org.greenrobot.eventbus.c.a().d(new ha.a(true));
                    }
                }
                XEagleApp.this.f12209f.a(mAVLinkMessage);
            }

            public void b() {
                org.greenrobot.eventbus.c.a().d(new l(1));
            }
        });
        AnonymousClass8 r3 = new DroneInterfaces.a() {
            public long a() {
                return SystemClock.elapsedRealtime();
            }
        };
        AnonymousClass9 r4 = new DroneInterfaces.b() {

            /* renamed from: a  reason: collision with root package name */
            final Handler f12237a = new Handler(Looper.myLooper());

            public void post(Runnable runnable) {
                this.f12237a.post(runnable);
            }

            public void postDelayed(Runnable runnable, long j2) {
                this.f12237a.postDelayed(runnable, j2);
            }

            public void removeCallbacks(Runnable runnable) {
                this.f12237a.removeCallbacks(runnable);
            }
        };
        this.f12218o = r4;
        this.f12206c = new com.flypro.core.drone.c(f12203a, aVar, r3, r4, this.f12210g);
        com.flypro.core.util.a.a().a(this.f12206c);
        com.flypro.core.util.a.a().a(this.f12217n);
        this.f12209f = new i(k(), f12203a);
    }

    private void u() {
        com.hoho.android.usb.rtsp.a aVar = new com.hoho.android.usb.rtsp.a(this.f12219q, new hb.a() {
            public void a(a.b bVar) {
                if (XEagleApp.this.f12221s != null) {
                    XEagleApp.this.f12221s.a(bVar);
                }
            }

            public void a(byte[] bArr, int i2, int i3, long j2) {
                if (XEagleApp.this.f12221s != null) {
                    XEagleApp.this.f12221s.a(bArr, i2, i3, j2);
                }
            }
        }, this);
        this.f12220r = aVar;
        aVar.a((a.d) new a.d() {
            public void a(int i2) {
                XEagleApp.this.f12220r.d();
            }

            public void a(int i2, String str) {
                org.greenrobot.eventbus.c.a().d(new am(false));
            }

            public void b(int i2) {
                Log.i("setStatus", "connectUsbTcpSuccess: " + i2);
                XEagleApp.this.f12220r.i();
            }

            public void b(int i2, String str) {
                Log.i("setStatus", "connectUsbTcpFail: " + str);
                org.greenrobot.eventbus.c.a().d(new am(false));
            }

            public void c(int i2) {
                boolean unused = XEagleApp.this.f12223u = true;
                Log.i("setStatus", "createUsbCameraTcpSuccess: 1");
                XEagleApp.this.f12215l.a();
                XEagleApp.this.f12220r.f();
            }

            public void c(int i2, String str) {
                boolean unused = XEagleApp.this.f12223u = false;
            }

            public void d(int i2) {
                boolean unused = XEagleApp.this.f12223u = true;
                XEagleApp.this.a(true);
                XEagleApp.this.f12212i.a(1);
                if (XEagleApp.f12204p.g() != null) {
                    Log.i("setStatus", "connectUsbCameraTcpSuccess: 1");
                    XEagleApp.f12204p.g().e();
                }
                SystemClock.sleep(500);
                XEagleApp.this.f12206c.j().a(1);
                Log.e("UsbDatapROXY", "onError: ==camera tcp connect connectUsbCameraTcpSuccess  222");
            }

            public void d(int i2, String str) {
                Log.i("setStatus", "connectUsbCameraTcpFail: 1");
                boolean unused = XEagleApp.this.f12223u = false;
                XEagleApp.this.f12220r.c(625);
            }
        });
        this.f12220r.a((a.e) new a.e() {
            public void a(int i2) {
                org.greenrobot.eventbus.c.a().d(new am(true));
            }

            public void a(int i2, String str) {
                XEagleApp.this.f12220r.a(554);
                XEagleApp.this.f12220r.j();
                org.greenrobot.eventbus.c.a().d(new am(false));
            }

            public void b(int i2) {
                org.greenrobot.eventbus.c.a().d(new an());
            }

            public void b(int i2, String str) {
                Log.i("setStatus", "connectUsbDroneUdpFail: " + str);
                XEagleApp.this.f12220r.n();
            }
        });
    }

    private void v() {
        if (this.f12222t) {
            this.f12223u = false;
            this.f12215l.a();
            this.f12214k.a();
            if (this.f12206c.j().a()) {
                this.f12206c.j().b();
            }
            hf.d.b("RTSPdb", "onAccessoryDetached: ");
            a(false);
            com.hoho.android.usb.rtsp.a aVar = this.f12220r;
            if (aVar != null) {
                aVar.a((a.e) null);
                this.f12220r.a((a.d) null);
                this.f12220r.b();
                this.f12220r = null;
            }
            d dVar = this.f12219q;
            if (dVar != null) {
                dVar.k();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w() {
        Log.i("LOOK_LOG", "usbConnectStateEvent: timeout");
        if (this.f12222t) {
            org.greenrobot.eventbus.c.a().d(new ha.e(2, false));
        }
    }

    public com.flypro.core.util.e a() {
        return this.f12217n;
    }

    public void a(d dVar) {
        this.f12219q = dVar;
    }

    public void a(hb.a aVar) {
        this.f12221s = aVar;
    }

    public void a(boolean z2) {
        if (this.f12222t != z2) {
            Log.i("setStatus", "setUsb:================= " + z2);
        }
        ha.b.a().a("USB_STATE").a(Boolean.valueOf(z2));
        this.f12222t = z2;
    }

    public boolean b() {
        return this.f12223u;
    }

    public boolean c() {
        return this.f12222t;
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.ASYNC)
    public void droneHeartBeat(dy.ax axVar) {
        io.reactivex.disposables.b bVar;
        this.f12224v = System.currentTimeMillis();
        if (!kz.a.e().c()) {
            if (this.f12206c.d().c() && com.flypro.core.util.a.a().i().equalsIgnoreCase("-")) {
                com.flypro.core.util.a.a().a(f12203a);
                if (this.f12225w == null) {
                    bVar = io.reactivex.f.a(100, 500, TimeUnit.MILLISECONDS).a(new lv.d() {
                        public final void accept(Object obj) {
                            XEagleApp.this.a((Long) obj);
                        }
                    });
                } else {
                    return;
                }
            } else if (!this.f12206c.d().c() && !com.flypro.core.util.a.a().i().equalsIgnoreCase("-")) {
                if (com.flypro.core.util.a.a().h()) {
                    com.flypro.core.util.a.a().b(f12203a);
                }
                io.reactivex.disposables.b bVar2 = this.f12225w;
                if (bVar2 != null) {
                    bVar2.dispose();
                    bVar = null;
                } else {
                    return;
                }
            } else {
                return;
            }
            this.f12225w = bVar;
        } else if (!this.f12206c.d().c() && !kz.a.e().b()) {
            kz.a.e().d();
        }
    }

    public d e() {
        return this.f12219q;
    }

    public com.hoho.android.usb.rtsp.a f() {
        return this.f12220r;
    }

    public AmbaClient g() {
        if (this.f12214k.b() == null) {
            return null;
        }
        if (this.f12214k.b() instanceof AmbaClient) {
            this.f12215l = (AmbaClient) this.f12214k.b();
        } else if (this.f12214k.b() instanceof SochipPresenter) {
            this.f12216m = (SochipPresenter) this.f12214k.b();
        }
        return this.f12215l;
    }

    public SochipPresenter h() {
        if (this.f12214k.b() == null) {
            return null;
        }
        if (this.f12214k.b() instanceof AmbaClient) {
            this.f12215l = (AmbaClient) this.f12214k.b();
        } else if (this.f12214k.b() instanceof SochipPresenter) {
            this.f12216m = (SochipPresenter) this.f12214k.b();
        }
        return this.f12216m;
    }

    public km.a i() {
        return this.f12205b;
    }

    public com.xeagle.android.utils.prefs.a j() {
        return this.f12210g;
    }

    public en.a k() {
        return this.f12206c;
    }

    public Follow l() {
        return this.f12207d;
    }

    public a m() {
        return this.f12212i;
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.ASYNC)
    public void missionRecEvent(ap apVar) {
        if (apVar.a() == 21) {
            this.f12208e.d();
        }
    }

    public e n() {
        return this.f12213j;
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.ASYNC)
    public void netConnectEvent(Proxy.c cVar) {
        com.hoho.android.usb.rtsp.a aVar = this.f12220r;
        if (aVar != null) {
            aVar.a(cVar);
        }
    }

    public kn.a o() {
        return this.f12208e;
    }

    public void onCreate() {
        super.onCreate();
        if (getApplicationInfo().packageName.equals(com.xeagle.android.utils.c.b((Context) this, Process.myPid()))) {
            if (!org.greenrobot.eventbus.c.a().b(this)) {
                org.greenrobot.eventbus.c.a().a((Object) this);
            }
            f12203a = getApplicationContext();
            f12204p = this;
            com.xeagle.android.utils.a.b();
            RxFFmpegInvoke.getInstance().setDebug(true);
            r();
            this.f12217n = new com.flypro.core.util.e(this);
            kz.a.e().a((Context) this);
            this.f12210g = new com.xeagle.android.utils.prefs.a(f12203a);
            t();
            this.f12212i = new a();
            if (Build.VERSION.SDK_INT >= 24) {
                StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
            }
            this.f12205b = new km.a(f12203a);
            this.f12208e = new kn.a(k().r());
            this.f12211h = new kd.a(f12203a);
            this.f12207d = new Follow(f12203a, k(), this.f12218o, this.f12211h);
            this.f12213j = new e(com.xeagle.android.utils.c.c(f12203a), q.c(), q.d(), q.b(), q.a());
            ji.e.a(ji.d.class);
            GSYVideoType.enableMediaCodec();
            GSYVideoType.enableMediaCodecTexture();
            GSYVideoType.setRenderType(1);
            GSYVideoType.setShowType(0);
            Utils.init(this);
            s();
            LitePal.initialize(new LitepalContext(this));
            kt.a.a(this);
            kt.a.a(f12203a);
        }
    }

    public kd.a p() {
        return this.f12211h;
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.BACKGROUND, b = true)
    public void usbConnectStateEvent(ha.e eVar) {
        int a2 = eVar.a();
        if (a2 != 1) {
            if (a2 == 2) {
                Log.i("LOOK_LOGFail", "USB_DETACH:");
                v();
            } else if (a2 != 3) {
                if (a2 == 5) {
                    this.f12223u = false;
                }
            } else if (!a().c()) {
                Log.i("LOOK_LOGFail", "USB_CONNECTED:");
                a(true);
                if (this.f12220r == null) {
                    u();
                }
                this.f12220r.f11874a = false;
                d dVar = this.f12219q;
                if (dVar != null) {
                    dVar.a("USB");
                    this.f12219q.a("USB", (com.hoho.android.usb.usb.data_proxy.g) new com.hoho.android.usb.usb.data_proxy.g() {
                        public void onRelay(Proxy.MsgType msgType, byte[] bArr) {
                            if (msgType == Proxy.MsgType.RELAY_VERSION) {
                                String str = new String(bArr);
                                hf.d.b("UsbDataProxy", "onRelay: ====wifi list====" + str);
                                XEagleApp.this.f12210g.e(str);
                                ha.b.a().a("VERSION_USB").a(new ha.h(str));
                            } else if (msgType == Proxy.MsgType.TTY_VERSION) {
                                String str2 = new String(bArr);
                                hf.d.b("UsbDataProxy", "onRelay:===rc version=== " + str2);
                                XEagleApp.this.f12210g.f(str2);
                            }
                        }
                    });
                    this.f12219q.a(-1, Proxy.ConnType.RELAY, Proxy.MsgType.RELAY_VERSION, "", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE, 0, 0, (String) null, (byte[]) null);
                    this.f12219q.a(-1, Proxy.ConnType.TTY, Proxy.MsgType.TTY_VERSION, "", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE, 0, 0, (String) null, (byte[]) null);
                    if (this.f12206c.j().a()) {
                        this.f12206c.j().b();
                    }
                    this.f12214k.a();
                    hf.d.b("LOOK_LOG", "USB_PERMISSION_YES: ");
                    this.f12214k.a(1);
                }
            }
        } else if (!a().c() && this.f12220r == null) {
            u();
        }
    }
}
