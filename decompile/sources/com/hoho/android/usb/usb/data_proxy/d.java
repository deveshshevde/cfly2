package com.hoho.android.usb.usb.data_proxy;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.t;
import com.blankj.utilcode.constant.MemoryConstants;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.protobuf.ByteString;
import com.hoho.android.usb.usb.data_proxy.a;
import com.myusb.proxy.proto.Proxy;
import ha.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.coroutines.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.l;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.az;
import kotlinx.coroutines.bg;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    private static int A;
    /* access modifiers changed from: private */
    public static boolean B;
    /* access modifiers changed from: private */
    public static d C;

    /* renamed from: b  reason: collision with root package name */
    public static final b f11899b = new b((f) null);

    /* renamed from: z  reason: collision with root package name */
    private static int f11900z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f11901a;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11902c;

    /* renamed from: d  reason: collision with root package name */
    private bg f11903d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f11904e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private final AppCompatActivity f11905f;

    /* renamed from: g  reason: collision with root package name */
    private final UsbManager f11906g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ParcelFileDescriptor f11907h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f11908i;

    /* renamed from: j  reason: collision with root package name */
    private final ConcurrentHashMap<String, g> f11909j = new ConcurrentHashMap<>();

    /* renamed from: k  reason: collision with root package name */
    private final ConcurrentHashMap<String, f> f11910k = new ConcurrentHashMap<>();

    /* renamed from: l  reason: collision with root package name */
    private final ConcurrentHashMap<String, Object> f11911l = new ConcurrentHashMap<>();

    /* renamed from: m  reason: collision with root package name */
    private final ConcurrentHashMap<Integer, a> f11912m = new ConcurrentHashMap<>();

    /* renamed from: n  reason: collision with root package name */
    private final ConcurrentHashMap<Integer, Proxy.c> f11913n = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final LinkedBlockingQueue<Proxy.c> f11914o = new LinkedBlockingQueue<>();
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f11915p;

    /* renamed from: q  reason: collision with root package name */
    private final BroadcastReceiver f11916q = new UsbDataProxy$mReceiver$1(this);

    /* renamed from: r  reason: collision with root package name */
    private PendingIntent f11917r;

    /* renamed from: s  reason: collision with root package name */
    private bg f11918s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public final hd.a f11919t = new hd.a(MemoryConstants.MB);

    /* renamed from: u  reason: collision with root package name */
    private FileOutputStream f11920u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public int f11921v = 1000;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public boolean f11922w;

    /* renamed from: x  reason: collision with root package name */
    private HandlerThread f11923x;

    /* renamed from: y  reason: collision with root package name */
    private c f11924y;

    static final class a<T> implements t<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20270a;

        a(d dVar) {
            this.f20270a = dVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0047, code lost:
            if (r3 < r5) goto L_0x004b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0057, code lost:
            if (r3 < r7) goto L_0x004b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onChanged(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.String r0 = "null cannot be cast to non-null type com.hoho.android.eventbus.UsbVersionEvent"
                java.util.Objects.requireNonNull(r12, r0)
                ha.h r12 = (ha.h) r12
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "onChanged: ===="
                r0.append(r1)
                java.lang.String r2 = r12.a()
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                java.lang.String r2 = "asdsadasd"
                android.util.Log.i(r2, r0)
                java.lang.String r0 = r12.a()
                int r0 = hf.b.b(r0)
                java.lang.String r12 = r12.a()
                long r3 = hf.b.a(r12)
                java.lang.String r12 = "1.5.0-20220511-2"
                long r5 = hf.b.a(r12)
                java.lang.String r12 = "1.6.0-20220511-2"
                long r7 = hf.b.a(r12)
                r12 = 150(0x96, float:2.1E-43)
                r9 = 1
                r10 = 0
                if (r0 != r12) goto L_0x004f
                com.hoho.android.usb.usb.data_proxy.d r12 = r11.f20270a
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x004a
                goto L_0x004b
            L_0x004a:
                r9 = 0
            L_0x004b:
                r12.a((boolean) r9)
                goto L_0x005a
            L_0x004f:
                r12 = 160(0xa0, float:2.24E-43)
                if (r0 != r12) goto L_0x005a
                com.hoho.android.usb.usb.data_proxy.d r12 = r11.f20270a
                int r0 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
                if (r0 >= 0) goto L_0x004a
                goto L_0x004b
            L_0x005a:
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                r12.append(r1)
                com.hoho.android.usb.usb.data_proxy.d r0 = r11.f20270a
                boolean r0 = r0.a()
                r12.append(r0)
                java.lang.String r12 = r12.toString()
                android.util.Log.i(r2, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hoho.android.usb.usb.data_proxy.d.a.onChanged(java.lang.Object):void");
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        private final void a(d dVar) {
            d.C = dVar;
        }

        public final d a() {
            return d.C;
        }

        public final d a(AppCompatActivity appCompatActivity) {
            h.d(appCompatActivity, "context");
            b bVar = this;
            if (bVar.a() == null) {
                bVar.a(new d(appCompatActivity));
            }
            return bVar.a();
        }

        public final void a(boolean z2) {
            d.B = z2;
        }
    }

    public final class c extends Handler {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Looper looper) {
            super(looper);
            h.a((Object) looper);
        }

        public void handleMessage(Message message) {
            h.d(message, "msg");
            if (message.what == 1) {
                d.this.a(-1, Proxy.ConnType.TCP, Proxy.MsgType.USB_HEART_BEAT, "", 0, 0, 0, "heartbeat", (byte[]) null);
                if (!d.this.f11922w) {
                    Log.i("UsbDataProxy", "heart_handleMessage: ");
                    sendEmptyMessageDelayed(1, (long) d.this.f11921v);
                }
            }
        }
    }

    public d(AppCompatActivity appCompatActivity) {
        h.d(appCompatActivity, "context");
        Log.i("UsbDataProxy", "UsbDataProxy:=====create usb dataProxy ");
        this.f11905f = appCompatActivity;
        Object systemService = appCompatActivity.getSystemService("usb");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.hardware.usb.UsbManager");
        this.f11906g = (UsbManager) systemService;
        f();
        ha.b.a().a("VERSION_USB").b(appCompatActivity, new a(this));
    }

    private final int a(byte[] bArr) {
        int i2 = 0;
        while (i2 != bArr.length) {
            int min = Math.min(16384, bArr.length - i2);
            try {
                FileOutputStream fileOutputStream = this.f11920u;
                h.a((Object) fileOutputStream);
                fileOutputStream.write(bArr, i2, min);
                i2 += min;
            } catch (IOException e2) {
                j();
                Log.e("UsbDataProxy", "writeToUsb:===error=== " + e2.getMessage());
                e2.printStackTrace();
            }
        }
        return i2;
    }

    public static final d a(AppCompatActivity appCompatActivity) {
        return f11899b.a(appCompatActivity);
    }

    private final void a(int i2) {
        if (this.f11924y == null) {
            this.f11921v = i2;
            this.f11922w = false;
            HandlerThread handlerThread = new HandlerThread("heartbeat");
            this.f11923x = handlerThread;
            h.a((Object) handlerThread);
            handlerThread.start();
            HandlerThread handlerThread2 = this.f11923x;
            h.a((Object) handlerThread2);
            c cVar = new c(handlerThread2.getLooper());
            this.f11924y = cVar;
            h.a((Object) cVar);
            cVar.sendEmptyMessage(1);
            com.hoho.android.usb.usb.data_proxy.log.b.f("UsbDataProxy", "start usb heartbeat", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public final void b(Proxy.c cVar) {
        a.C0135a a2;
        cVar.m();
        int o2 = cVar.o();
        cVar.n();
        boolean z2 = true;
        if (cVar.s() == 10005) {
            B = true;
            if (cVar.q() != Proxy.MsgType.SEND) {
                org.greenrobot.eventbus.c.a().d(new e(9, true));
            }
        }
        org.greenrobot.eventbus.c.a().d(new e(8, true));
        Proxy.ConnType p2 = cVar.p();
        if (p2 != null) {
            int i2 = e.f20272a[p2.ordinal()];
            if (i2 == 1) {
                org.greenrobot.eventbus.c a3 = org.greenrobot.eventbus.c.a();
                Proxy.a t2 = cVar.t();
                h.b(t2, "proxyMsg.data");
                if (t2.m() != 0) {
                    z2 = false;
                }
                a3.d(new ha.d(z2));
                return;
            } else if (i2 == 2) {
                d(cVar);
                return;
            } else if (i2 == 3) {
                c(cVar);
                return;
            }
        }
        if (cVar.q() == Proxy.MsgType.RECV) {
            a aVar = this.f11912m.get(Integer.valueOf(o2));
            if (aVar != null && (a2 = aVar.a()) != null) {
                Proxy.a t3 = cVar.t();
                h.b(t3, "proxyMsg.data");
                a2.a(t3.p().d(), cVar.r(), cVar.s());
                return;
            }
            return;
        }
        org.greenrobot.eventbus.c.a().d(cVar);
    }

    private final void c(Proxy.c cVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("processReceivedMsg: ");
        sb.append(cVar.q());
        sb.append("---------");
        Proxy.a t2 = cVar.t();
        h.b(t2, "proxyMsg.data");
        sb.append(t2.o());
        Log.i("UsbDataProxy", sb.toString());
        Proxy.MsgType q2 = cVar.q();
        if (q2 != null) {
            int i2 = e.f20273b[q2.ordinal()];
            if (i2 == 1) {
                for (f a2 : this.f11910k.values()) {
                    int o2 = cVar.o();
                    Proxy.a t3 = cVar.t();
                    h.b(t3, "proxyMsg.data");
                    int m2 = t3.m();
                    Proxy.a t4 = cVar.t();
                    h.b(t4, "proxyMsg.data");
                    int n2 = t4.n();
                    Proxy.a t5 = cVar.t();
                    h.b(t5, "proxyMsg.data");
                    String o3 = t5.o();
                    h.b(o3, "proxyMsg.data.arg3");
                    Proxy.a t6 = cVar.t();
                    h.b(t6, "proxyMsg.data");
                    byte[] d2 = t6.p().d();
                    h.b(d2, "proxyMsg.data.arg4.toByteArray()");
                    a2.a(o2, m2, n2, o3, d2);
                }
            } else if (i2 == 2) {
                for (f a3 : this.f11910k.values()) {
                    int o4 = cVar.o();
                    Proxy.a t7 = cVar.t();
                    h.b(t7, "proxyMsg.data");
                    int n3 = t7.n();
                    Proxy.a t8 = cVar.t();
                    h.b(t8, "proxyMsg.data");
                    String o5 = t8.o();
                    h.b(o5, "proxyMsg.data.arg3");
                    Proxy.ConnType p2 = cVar.p();
                    h.b(p2, "proxyMsg.connType");
                    a3.a(o4, n3, o5, p2);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("processReceivedMsg: ");
                Proxy.a t9 = cVar.t();
                h.b(t9, "proxyMsg.data");
                sb2.append(t9.n());
                sb2.append("---------");
                Proxy.a t10 = cVar.t();
                h.b(t10, "proxyMsg.data");
                sb2.append(t10.o());
                Log.i("UsbDataProxy", sb2.toString());
            } else if (i2 == 3) {
                for (f a4 : this.f11910k.values()) {
                    int o6 = cVar.o();
                    Proxy.a t11 = cVar.t();
                    h.b(t11, "proxyMsg.data");
                    String o7 = t11.o();
                    h.b(o7, "proxyMsg.data.arg3");
                    Proxy.a t12 = cVar.t();
                    h.b(t12, "proxyMsg.data");
                    int n4 = t12.n();
                    Proxy.ConnType p3 = cVar.p();
                    h.b(p3, "proxyMsg.connType");
                    a4.a(o6, o7, n4, p3);
                }
            }
        }
    }

    private final void d(Proxy.c cVar) {
        Proxy.MsgType q2 = cVar.q();
        if (q2 != null) {
            int i2 = e.f20274c[q2.ordinal()];
            if (i2 == 1) {
                for (f a2 : this.f11910k.values()) {
                    int o2 = cVar.o();
                    Proxy.a t2 = cVar.t();
                    h.b(t2, "proxyMsg.data");
                    int m2 = t2.m();
                    Proxy.a t3 = cVar.t();
                    h.b(t3, "proxyMsg.data");
                    int n2 = t3.n();
                    Proxy.a t4 = cVar.t();
                    h.b(t4, "proxyMsg.data");
                    String o3 = t4.o();
                    h.b(o3, "proxyMsg.data.arg3");
                    Proxy.a t5 = cVar.t();
                    h.b(t5, "proxyMsg.data");
                    byte[] d2 = t5.p().d();
                    h.b(d2, "proxyMsg.data.arg4.toByteArray()");
                    a2.a(o2, m2, n2, o3, d2);
                }
            } else if (i2 == 2) {
                StringBuilder sb = new StringBuilder();
                sb.append("processReceivedMsg: ");
                Proxy.a t6 = cVar.t();
                h.b(t6, "proxyMsg.data");
                sb.append(t6.n());
                sb.append("---------");
                Proxy.a t7 = cVar.t();
                h.b(t7, "proxyMsg.data");
                sb.append(t7.o());
                Log.i("UsbDataProxy", sb.toString());
            } else if (i2 == 3) {
                Proxy.a t8 = cVar.t();
                h.b(t8, "proxyMsg.data");
                if (t8.m() == 0) {
                    for (f a3 : this.f11910k.values()) {
                        int o4 = cVar.o();
                        Proxy.a t9 = cVar.t();
                        h.b(t9, "proxyMsg.data");
                        String o5 = t9.o();
                        h.b(o5, "proxyMsg.data.arg3");
                        a3.a(o4, o5, Proxy.ConnType.HTTP);
                    }
                }
            } else if (i2 == 4) {
                Proxy.a t10 = cVar.t();
                h.b(t10, "proxyMsg.data");
                if (t10.m() == 200) {
                    for (f a4 : this.f11910k.values()) {
                        int o6 = cVar.o();
                        Proxy.a t11 = cVar.t();
                        h.b(t11, "proxyMsg.data");
                        String o7 = t11.o();
                        h.b(o7, "proxyMsg.data.arg3");
                        Proxy.a t12 = cVar.t();
                        h.b(t12, "proxyMsg.data");
                        a4.a(o6, o7, t12.n(), Proxy.ConnType.HTTP);
                    }
                }
            } else if (i2 == 5) {
                Proxy.a t13 = cVar.t();
                h.b(t13, "proxyMsg.data");
                if (t13.n() == 0) {
                    for (f a5 : this.f11910k.values()) {
                        int o8 = cVar.o();
                        Proxy.a t14 = cVar.t();
                        h.b(t14, "proxyMsg.data");
                        String o9 = t14.o();
                        h.b(o9, "proxyMsg.data.arg3");
                        Proxy.a t15 = cVar.t();
                        h.b(t15, "proxyMsg.data");
                        a5.a(o8, o9, t15.n(), Proxy.ConnType.HTTP);
                    }
                }
            }
        }
    }

    private final bg n() {
        return g.a(az.f30335a, (f) null, (CoroutineStart) null, new UsbDataProxy$sendThread$1(this, (kotlin.coroutines.c) null), 3, (Object) null);
    }

    private final bg o() {
        return g.a(az.f30335a, (f) null, (CoroutineStart) null, new UsbDataProxy$recvThread$1(this, (kotlin.coroutines.c) null), 3, (Object) null);
    }

    private final int p() {
        int i2;
        synchronized (this.f11904e) {
            i2 = f11900z;
            f11900z = (i2 + 1) % SubsamplingScaleImageView.TILE_SIZE_AUTO;
        }
        return i2;
    }

    private final int q() {
        int i2;
        synchronized (this.f11904e) {
            i2 = A;
            A = (i2 + 1) % SubsamplingScaleImageView.TILE_SIZE_AUTO;
        }
        return i2;
    }

    private final void r() {
        this.f11922w = true;
        c cVar = this.f11924y;
        if (cVar != null) {
            cVar.removeMessages(1);
        }
        c cVar2 = this.f11924y;
        if (cVar2 != null) {
            cVar2.removeCallbacksAndMessages((Object) null);
        }
        HandlerThread handlerThread = this.f11923x;
        h.a((Object) handlerThread);
        handlerThread.quit();
        this.f11924y = null;
        com.hoho.android.usb.usb.data_proxy.log.b.f("UsbDataProxy", "stop usb heartbeat", new Object[0]);
    }

    public final int a(int i2, Proxy.ConnType connType, Proxy.MsgType msgType, String str, int i3, int i4, int i5, String str2, byte[] bArr) {
        h.d(msgType, "msgType");
        if (!this.f11908i) {
            return 12005;
        }
        int q2 = q();
        Proxy.a.C0141a q3 = Proxy.a.q();
        Proxy.a.C0141a b2 = q3.a(i4).b(i5);
        h.b(b2, "msgDataBuilder.setArg1(arg1).setArg2(arg2)");
        if (str2 == null) {
            str2 = "";
        }
        b2.a(str2);
        if (bArr != null) {
            h.b(q3, "msgDataBuilder");
            q3.a(ByteString.a(bArr));
        }
        Proxy.c.a u2 = Proxy.c.u();
        Proxy.c.a d2 = u2.a(q2).b(-1).c(i2).a(connType).a(msgType).a(str).d(i3);
        h.b(d2, "builder.setMsgId(msgId)\n…           .setPort(port)");
        d2.a((Proxy.a) q3.g());
        Proxy.c cVar = (Proxy.c) u2.g();
        int i6 = 0;
        if (!this.f11914o.offer(cVar)) {
            i6 = 12002;
        } else if (Proxy.MsgType.CREATE == msgType || Proxy.MsgType.CONNECT == msgType) {
            Integer valueOf = Integer.valueOf(i2);
            h.b(cVar, "proxyMsg");
            this.f11913n.put(valueOf, cVar);
        }
        if (Proxy.MsgType.CLOSE == msgType) {
            this.f11912m.remove(Integer.valueOf(i2));
        }
        return i6;
    }

    public final void a(int i2, int i3) {
        byte[] bArr;
        String str;
        int i4;
        int i5;
        String str2;
        Proxy.MsgType msgType;
        Proxy.ConnType connType;
        if (this.f11908i) {
            int p2 = p();
            if (i2 == 1) {
                connType = Proxy.ConnType.TCP;
                msgType = Proxy.MsgType.CREATE;
                i5 = 0;
                i4 = 0;
                str = null;
                bArr = null;
                str2 = "172.50.10.254";
            } else if (i2 == 2) {
                connType = Proxy.ConnType.UDP;
                msgType = Proxy.MsgType.CREATE;
                i5 = 0;
                i4 = 0;
                str = null;
                bArr = null;
                str2 = "";
            } else {
                return;
            }
            a(p2, connType, msgType, str2, i3, i5, i4, str, bArr);
        }
    }

    public final void a(int i2, a aVar) {
        h.d(aVar, "netConnection");
        this.f11912m.put(Integer.valueOf(i2), aVar);
    }

    public final void a(String str) {
        h.d(str, "tag");
        this.f11909j.remove(str);
    }

    public final void a(String str, f fVar) {
        h.d(str, "tag");
        if (fVar != null) {
            this.f11910k.put(str, fVar);
        }
    }

    public final void a(String str, g gVar) {
        h.d(str, "tag");
        if (gVar != null) {
            this.f11909j.put(str, gVar);
        }
    }

    public final void a(boolean z2) {
        this.f11902c = z2;
    }

    public final boolean a() {
        return this.f11902c;
    }

    public final boolean a(Proxy.c cVar) {
        h.d(cVar, "proxyMsg");
        byte[] b2 = cVar.b();
        int length = b2.length + 17;
        byte[] bArr = new byte[length];
        byte[] bytes = "#frame-begin#".getBytes(kotlin.text.d.f30261a);
        h.b(bytes, "(this as java.lang.String).getBytes(charset)");
        System.arraycopy(bytes, 0, bArr, 0, 13);
        byte[] a2 = he.a.a(b2.length);
        System.arraycopy(a2, 0, bArr, 13, a2.length);
        System.arraycopy(b2, 0, bArr, 17, b2.length);
        return a(bArr) == length;
    }

    public final boolean a(String str, String str2, Handler handler, int i2) {
        Handler handler2 = handler;
        h.d(handler2, "handler");
        String c2 = c(str);
        File file = new File(str);
        long length = file.length() / ((long) 100);
        Log.i("FTP", "uploadRepeatFile: ==md5===" + c2 + "==fileLength==" + file.length());
        int i3 = 0;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            byte[] bArr = new byte[8192];
            long j2 = 0;
            long j3 = 0;
            while (true) {
                int read = randomAccessFile.read(bArr);
                if (read == -1) {
                    return true;
                }
                byte[] bArr2 = new byte[read];
                System.arraycopy(bArr, i3, bArr2, i3, read);
                JSONObject jSONObject = new JSONObject();
                RandomAccessFile randomAccessFile2 = randomAccessFile;
                jSONObject.put("fileName", str2);
                jSONObject.put("md5", c2);
                StringBuilder sb = new StringBuilder();
                String str3 = c2;
                sb.append("length:");
                sb.append(read);
                Log.i("UsbDataProxy", sb.toString());
                if (read < 8192 && j2 == 0) {
                    a(-1, Proxy.ConnType.RELAY, Proxy.MsgType.RELAY_WIFI_UPDATE, "", 0, 3, 0, jSONObject.toString(), bArr2);
                } else if (j2 == 0) {
                    a(-1, Proxy.ConnType.RELAY, Proxy.MsgType.RELAY_WIFI_UPDATE, "", 0, 1, 0, jSONObject.toString(), bArr2);
                } else {
                    long j4 = ((long) read) + j2;
                    if (j4 < file.length()) {
                        a(-1, Proxy.ConnType.RELAY, Proxy.MsgType.RELAY_WIFI_UPDATE, "", 0, 2, 0, jSONObject.toString(), bArr2);
                    } else if (j4 == file.length()) {
                        a(-1, Proxy.ConnType.RELAY, Proxy.MsgType.RELAY_WIFI_UPDATE, "", 0, 3, 0, jSONObject.toString(), bArr2);
                        Log.i("UsbDataProxy", "uploadRepeatFile: ======total===" + j4);
                    }
                }
                j2 += (long) read;
                if (j2 / length != j3) {
                    j3 = j2 / length;
                    Message message = new Message();
                    message.obj = Long.valueOf(j3);
                    message.arg1 = i2;
                    handler2.sendMessage(message);
                } else {
                    int i4 = i2;
                }
                randomAccessFile = randomAccessFile2;
                c2 = str3;
                i3 = 0;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        } catch (JSONException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public final ConcurrentHashMap<String, g> b() {
        return this.f11909j;
    }

    public final void b(String str) {
        h.d(str, "tag");
        this.f11910k.remove(str);
    }

    public final boolean b(String str, String str2, Handler handler, int i2) {
        Handler handler2 = handler;
        h.d(handler2, "handler");
        File file = new File(str);
        long length = file.length() / ((long) 100);
        int i3 = 0;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            byte[] bArr = new byte[8192];
            long j2 = 0;
            long j3 = 0;
            while (true) {
                int read = randomAccessFile.read(bArr);
                if (read == -1) {
                    return true;
                }
                byte[] bArr2 = new byte[read];
                System.arraycopy(bArr, i3, bArr2, i3, read);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fileName", str2);
                StringBuilder sb = new StringBuilder();
                RandomAccessFile randomAccessFile2 = randomAccessFile;
                sb.append("length:");
                sb.append(read);
                Log.i("UsbDataProxy", sb.toString());
                if (read < 8192 && j2 == 0) {
                    a(-1, Proxy.ConnType.FTP, Proxy.MsgType.FTP_UPLOAD_START, "", 0, 3, 0, jSONObject.toString(), bArr2);
                } else if (j2 == 0) {
                    a(-1, Proxy.ConnType.FTP, Proxy.MsgType.FTP_UPLOAD_START, "", 0, 1, 0, jSONObject.toString(), bArr2);
                } else {
                    long j4 = ((long) read) + j2;
                    if (j4 < file.length()) {
                        a(-1, Proxy.ConnType.FTP, Proxy.MsgType.FTP_UPLOAD_START, "", 0, 2, 0, jSONObject.toString(), bArr2);
                    } else if (j4 == file.length()) {
                        a(-1, Proxy.ConnType.FTP, Proxy.MsgType.FTP_UPLOAD_START, "", 0, 3, 0, jSONObject.toString(), bArr2);
                        Log.i("UsbDataProxy", "uploadRepeatFile: ======total===" + j4);
                    }
                }
                j2 += (long) read;
                if (j2 / length != j3) {
                    j3 = j2 / length;
                    Message message = new Message();
                    message.obj = Long.valueOf(j3);
                    message.arg1 = i2;
                    handler2.sendMessage(message);
                } else {
                    int i4 = i2;
                }
                randomAccessFile = randomAccessFile2;
                i3 = 0;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        } catch (JSONException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public final String c(String str) {
        String str2 = null;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(new File(str));
            byte[] bArr = new byte[4096];
            MessageDigest instance = MessageDigest.getInstance("MD5");
            while (true) {
                int read = fileInputStream2.read(bArr);
                if (read <= 0) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                l lVar = l.f30252a;
                String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf((byte) (b2 & ((byte) 255)))}, 1));
                h.b(format, "java.lang.String.format(format, *args)");
                sb.append(format);
            }
            String sb2 = sb.toString();
            Log.i("FTP", "startBurnDrone:===MD5=== " + sb2);
            fileInputStream2.close();
            return sb2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final ConcurrentHashMap<Integer, a> c() {
        return this.f11912m;
    }

    public final ConcurrentHashMap<Integer, Proxy.c> d() {
        return this.f11913n;
    }

    public final boolean e() {
        return this.f11915p;
    }

    public final void f() {
        this.f11917r = Build.VERSION.SDK_INT >= 31 ? PendingIntent.getBroadcast(this.f11905f, 0, new Intent("com.cfly.uav_pro.usb.permission"), 33554432) : PendingIntent.getBroadcast(this.f11905f, 0, new Intent("com.cfly.uav_pro.usb.permission"), 0);
        IntentFilter intentFilter = new IntentFilter("com.cfly.uav_pro.usb.permission");
        intentFilter.addAction("android.hardware.usb.action.USB_STATE");
        intentFilter.addAction("android.hardware.usb.action.USB_ACCESSORY_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_ACCESSORY_DETACHED");
        this.f11905f.registerReceiver(this.f11916q, intentFilter);
        this.f11901a = true;
        Log.i("UsbDataProxy", "registerReceivers: 注册广播");
    }

    public final void g() {
        if (this.f11901a) {
            Log.i("UsbDataProxy", "unregisterReceivers: Android " + Build.VERSION.SDK_INT);
            if (Build.VERSION.SDK_INT > 29) {
                Log.i("UsbDataProxy", "unregisterReceivers: 解注册广播");
                this.f11905f.unregisterReceiver(this.f11916q);
                this.f11901a = false;
            }
        }
    }

    public final int h() {
        if (this.f11908i) {
            Log.i("UsbDataProxy", "connect: =====usb已连接");
            return 10003;
        }
        UsbAccessory[] accessoryList = this.f11906g.getAccessoryList();
        if (accessoryList == null) {
            Log.i("UsbDataProxy", "connect: =====usb权限列表为空");
            return 12003;
        }
        Log.i("UsbDataProxy", "connect: ===usb accessory==" + accessoryList.length);
        UsbAccessory usbAccessory = accessoryList[0];
        if (!this.f11906g.hasPermission(usbAccessory)) {
            Log.i("UsbDataProxy", "connect: =====usb权限请求");
            this.f11906g.requestPermission(usbAccessory, this.f11917r);
            return 12004;
        }
        ParcelFileDescriptor openAccessory = this.f11906g.openAccessory(usbAccessory);
        this.f11907h = openAccessory;
        if (openAccessory == null) {
            Log.i("UsbDataProxy", "connect: =====未获取到USB通信");
            org.greenrobot.eventbus.c.a().d(new e(7, true));
            return -1;
        }
        ParcelFileDescriptor parcelFileDescriptor = this.f11907h;
        h.a((Object) parcelFileDescriptor);
        this.f11920u = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
        bg bgVar = this.f11918s;
        if (bgVar != null) {
            bg.a.a(bgVar, (CancellationException) null, 1, (Object) null);
        }
        this.f11918s = o();
        bg bgVar2 = this.f11903d;
        if (bgVar2 != null) {
            bg.a.a(bgVar2, (CancellationException) null, 1, (Object) null);
        }
        this.f11903d = n();
        Log.i("UsbDataProxy", "connect: =====usb已建立通信");
        this.f11908i = true;
        a(1000);
        org.greenrobot.eventbus.c.a().e(new e(3, false));
        return 0;
    }

    public final boolean i() {
        return this.f11908i;
    }

    public final void j() {
        com.hoho.android.usb.usb.data_proxy.log.b.e("UsbDataProxy", "disconnect thread...", new Object[0]);
        this.f11908i = false;
        r();
        l();
        bg bgVar = this.f11918s;
        if (bgVar != null) {
            bg.a.a(bgVar, (CancellationException) null, 1, (Object) null);
        }
        bg bgVar2 = this.f11903d;
        if (bgVar2 != null) {
            bg.a.a(bgVar2, (CancellationException) null, 1, (Object) null);
        }
        ParcelFileDescriptor parcelFileDescriptor = this.f11907h;
        if (parcelFileDescriptor != null) {
            try {
                h.a((Object) parcelFileDescriptor);
                parcelFileDescriptor.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        Log.i("UsbDataProxy", "disconnect: 关闭连接成功mIsConnected=" + this.f11908i);
    }

    public final void k() {
        com.hoho.android.usb.usb.data_proxy.log.b.e("UsbDataProxy", "destroy Proxy...", new Object[0]);
        j();
        g();
        C = null;
    }

    public final void l() {
        this.f11912m.clear();
        a(p(), Proxy.ConnType.TCP, Proxy.MsgType.CLOSE_ALL, "", 0, 0, 0, (String) null, (byte[]) null);
    }
}
