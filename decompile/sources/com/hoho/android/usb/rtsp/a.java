package com.hoho.android.usb.rtsp;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.hoho.android.usb.usb.data_proxy.a;
import com.myusb.proxy.proto.Proxy;
import com.xeagle.android.login.pickImage.Constants;
import com.xeagle.android.login.retrofitLogin.CameraGlobal;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final C0133a f11873d = new C0133a((f) null);
    private Handler A;
    /* access modifiers changed from: private */
    public boolean B;
    /* access modifiers changed from: private */
    public int C;
    /* access modifiers changed from: private */
    public final ArrayList<byte[]> D = new ArrayList<>();
    /* access modifiers changed from: private */
    public boolean E;
    /* access modifiers changed from: private */
    public final HashMap<Long, byte[]> F = new HashMap<>();
    private d G;
    private e H;
    private a.C0135a I = new h(this);
    private a.C0135a J = new g();
    private a.C0135a K = new l(this);
    private a.C0135a L = new k(this);
    private final Thread M;
    private final Thread N;
    private Runnable O;
    private com.hoho.android.usb.usb.data_proxy.d P;
    /* access modifiers changed from: private */
    public final hb.a Q;
    /* access modifiers changed from: private */
    public final Context R;

    /* renamed from: a  reason: collision with root package name */
    public boolean f11874a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f11875b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f11876c;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f11877e = f11873d.getClass().getName();

    /* renamed from: f  reason: collision with root package name */
    private com.hoho.android.usb.usb.data_proxy.c f11878f;

    /* renamed from: g  reason: collision with root package name */
    private com.hoho.android.usb.usb.data_proxy.b f11879g;

    /* renamed from: h  reason: collision with root package name */
    private com.hoho.android.usb.usb.data_proxy.b f11880h;

    /* renamed from: i  reason: collision with root package name */
    private com.hoho.android.usb.usb.data_proxy.c f11881i;

    /* renamed from: j  reason: collision with root package name */
    private com.hoho.android.usb.usb.data_proxy.b f11882j;

    /* renamed from: k  reason: collision with root package name */
    private String f11883k = "";

    /* renamed from: l  reason: collision with root package name */
    private final String f11884l = "/track1";

    /* renamed from: m  reason: collision with root package name */
    private int f11885m;

    /* renamed from: n  reason: collision with root package name */
    private final String f11886n;

    /* renamed from: o  reason: collision with root package name */
    private final String f11887o;

    /* renamed from: p  reason: collision with root package name */
    private String f11888p = "";

    /* renamed from: q  reason: collision with root package name */
    private int f11889q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public b f11890r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public final boolean f11891s = true;

    /* renamed from: t  reason: collision with root package name */
    private RtspPacketDecode f11892t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public final LinkedBlockingQueue<byte[]> f11893u = new LinkedBlockingQueue<>();
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public final ArrayList<byte[]> f11894v = new ArrayList<>();

    /* renamed from: w  reason: collision with root package name */
    private final int f11895w = 1280;

    /* renamed from: x  reason: collision with root package name */
    private final int f11896x = Constants.PORTRAIT_IMAGE_WIDTH;

    /* renamed from: y  reason: collision with root package name */
    private final boolean f11897y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public final Object f11898z = new Object();

    public interface d {
        void a(int i2);

        void a(int i2, String str);

        void b(int i2);

        void b(int i2, String str);

        void c(int i2);

        void c(int i2, String str);

        void d(int i2);

        void d(int i2, String str);
    }

    public interface e {
        void a(int i2);

        void a(int i2, String str);

        void b(int i2);

        void b(int i2, String str);
    }

    /* renamed from: com.hoho.android.usb.rtsp.a$a  reason: collision with other inner class name */
    public static final class C0133a {
        private C0133a() {
        }

        public /* synthetic */ C0133a(f fVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final Pair<String, String> a(ArrayList<Pair<String, String>> arrayList) {
            Iterator<Pair<String, String>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Pair next = it2.next();
                Object obj = next.first;
                kotlin.jvm.internal.h.b(obj, "head.first");
                String str = (String) obj;
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = str.toLowerCase();
                kotlin.jvm.internal.h.b(lowerCase, "(this as java.lang.String).toLowerCase()");
                if (kotlin.jvm.internal.h.a((Object) "www-authenticate", (Object) lowerCase)) {
                    Object obj2 = next.second;
                    kotlin.jvm.internal.h.b(obj2, "head.second");
                    String str2 = (String) obj2;
                    Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                    String lowerCase2 = str2.toLowerCase();
                    kotlin.jvm.internal.h.b(lowerCase2, "(this as java.lang.String).toLowerCase()");
                    if (kotlin.text.f.b(lowerCase2, "digest", false, 2, (Object) null)) {
                        Object obj3 = next.second;
                        kotlin.jvm.internal.h.b(obj3, "head.second");
                        String str3 = (String) obj3;
                        Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
                        String substring = str3.substring(7);
                        kotlin.jvm.internal.h.b(substring, "(this as java.lang.String).substring(startIndex)");
                        CharSequence charSequence = substring;
                        int length = charSequence.length() - 1;
                        int i2 = 0;
                        boolean z2 = false;
                        while (i2 <= length) {
                            boolean z3 = kotlin.jvm.internal.h.a((int) charSequence.charAt(!z2 ? i2 : length), 32) <= 0;
                            if (!z2) {
                                if (!z3) {
                                    z2 = true;
                                } else {
                                    i2++;
                                }
                            } else if (!z3) {
                                break;
                            } else {
                                length--;
                            }
                        }
                        String obj4 = charSequence.subSequence(i2, length + 1).toString();
                        CharSequence charSequence2 = obj4;
                        CharSequence charSequence3 = charSequence2;
                        int a2 = kotlin.text.f.a(charSequence3, '\"', kotlin.text.f.a(charSequence3, "realm=", 0, false, 6, (Object) null), false, 4, (Object) null) + 1;
                        int a3 = kotlin.text.f.a(charSequence3, '\"', a2, false, 4, (Object) null);
                        Objects.requireNonNull(obj4, "null cannot be cast to non-null type java.lang.String");
                        String substring2 = obj4.substring(a2, a3);
                        kotlin.jvm.internal.h.b(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        CharSequence charSequence4 = charSequence2;
                        int a4 = 1 + kotlin.text.f.a(charSequence4, '\"', kotlin.text.f.a(charSequence4, "nonce=", 0, false, 6, (Object) null), false, 4, (Object) null);
                        int a5 = kotlin.text.f.a(charSequence2, '\"', a4, false, 4, (Object) null);
                        Objects.requireNonNull(obj4, "null cannot be cast to non-null type java.lang.String");
                        String substring3 = obj4.substring(a4, a5);
                        kotlin.jvm.internal.h.b(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        return Pair.create(substring2, substring3);
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public final String a(ArrayList<Pair<String, String>> arrayList, String str) {
            Iterator<Pair<String, String>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Pair next = it2.next();
                Object obj = next.first;
                kotlin.jvm.internal.h.b(obj, "head.first");
                String str2 = (String) obj;
                Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = str2.toLowerCase();
                kotlin.jvm.internal.h.b(lowerCase, "(this as java.lang.String).toLowerCase()");
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String lowerCase2 = str.toLowerCase();
                kotlin.jvm.internal.h.b(lowerCase2, "(this as java.lang.String).toLowerCase()");
                if (kotlin.jvm.internal.h.a((Object) lowerCase2, (Object) lowerCase)) {
                    return (String) next.second;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public final List<Pair<String, String>> a(String str) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : TextUtils.split(str, "\r\n")) {
                kotlin.jvm.internal.h.b(str2, "param");
                int a2 = kotlin.text.f.a((CharSequence) str2, '=', 0, false, 6, (Object) null);
                if (a2 > 0) {
                    String substring = str2.substring(0, a2);
                    kotlin.jvm.internal.h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    CharSequence charSequence = substring;
                    int length = charSequence.length() - 1;
                    int i2 = 0;
                    boolean z2 = false;
                    while (i2 <= length) {
                        boolean z3 = kotlin.jvm.internal.h.a((int) charSequence.charAt(!z2 ? i2 : length), 32) <= 0;
                        if (!z2) {
                            if (!z3) {
                                z2 = true;
                            } else {
                                i2++;
                            }
                        } else if (!z3) {
                            break;
                        } else {
                            length--;
                        }
                    }
                    String obj = charSequence.subSequence(i2, length + 1).toString();
                    String substring2 = str2.substring(a2 + 1);
                    kotlin.jvm.internal.h.b(substring2, "(this as java.lang.String).substring(startIndex)");
                    arrayList.add(Pair.create(obj, substring2));
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public final String b(ArrayList<Pair<String, String>> arrayList) {
            Iterator<Pair<String, String>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Pair next = it2.next();
                Object obj = next.first;
                kotlin.jvm.internal.h.b(obj, "head.first");
                String str = (String) obj;
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = str.toLowerCase();
                kotlin.jvm.internal.h.b(lowerCase, "(this as java.lang.String).toLowerCase()");
                Object obj2 = next.second;
                kotlin.jvm.internal.h.b(obj2, "head.second");
                String str2 = (String) obj2;
                Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                String lowerCase2 = str2.toLowerCase();
                kotlin.jvm.internal.h.b(lowerCase2, "(this as java.lang.String).toLowerCase()");
                if (kotlin.jvm.internal.h.a((Object) "www-authenticate", (Object) lowerCase) && kotlin.text.f.b(lowerCase2, "basic", false, 2, (Object) null)) {
                    Objects.requireNonNull(lowerCase2, "null cannot be cast to non-null type java.lang.String");
                    String substring = lowerCase2.substring(6);
                    kotlin.jvm.internal.h.b(substring, "(this as java.lang.String).substring(startIndex)");
                    CharSequence charSequence = substring;
                    int length = charSequence.length() - 1;
                    int i2 = 0;
                    boolean z2 = false;
                    while (i2 <= length) {
                        boolean z3 = kotlin.jvm.internal.h.a((int) charSequence.charAt(!z2 ? i2 : length), 32) <= 0;
                        if (!z2) {
                            if (!z3) {
                                z2 = true;
                            } else {
                                i2++;
                            }
                        } else if (!z3) {
                            break;
                        } else {
                            length--;
                        }
                    }
                    String[] split = TextUtils.split(charSequence.subSequence(i2, length + 1).toString(), "\"");
                    if (split.length > 2) {
                        return split[1];
                    }
                }
            }
            return null;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public f f20236a;

        /* renamed from: b  reason: collision with root package name */
        private String f20237b;

        /* renamed from: c  reason: collision with root package name */
        private String f20238c;

        public final void a(String str) {
            this.f20237b = str;
        }

        public final void b(String str) {
            this.f20238c = str;
        }
    }

    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        private String f20239a;

        /* renamed from: b  reason: collision with root package name */
        private int f20240b;

        public final int a() {
            return this.f20240b;
        }

        public final void a(int i2) {
            this.f20240b = i2;
        }

        public final void a(String str) {
            this.f20239a = str;
        }
    }

    public static final class f extends c {

        /* renamed from: a  reason: collision with root package name */
        public int f20241a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f20242b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f20243c;
    }

    public static final class g implements a.C0135a {
        g() {
        }

        public void a(int i2, String str, int i3, int i4, int i5, String str2) {
            kotlin.jvm.internal.h.d(str, IjkMediaPlayer.OnNativeInvokeListener.ARG_IP);
            kotlin.jvm.internal.h.d(str2, "des");
            Log.e("UsbDatapROXY", "onError: ==camera tcp connect error num==" + i4 + "==des==" + str2);
        }

        public void a(byte[] bArr, String str, int i2) {
            kotlin.jvm.internal.h.d(bArr, AeUtil.ROOT_DATA_PATH_OLD_NAME);
            kotlin.jvm.internal.h.d(str, IjkMediaPlayer.OnNativeInvokeListener.ARG_IP);
            org.greenrobot.eventbus.c.a().d(new ha.f(1, bArr));
        }
    }

    public static final class h implements a.C0135a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20244a;

        h(a aVar) {
            this.f20244a = aVar;
        }

        public void a(int i2, String str, int i3, int i4, int i5, String str2) {
            kotlin.jvm.internal.h.d(str, IjkMediaPlayer.OnNativeInvokeListener.ARG_IP);
            kotlin.jvm.internal.h.d(str2, "des");
            String a2 = this.f20244a.f11877e;
            Log.i(a2, "onError: ==drone udp connect error num==" + i4 + "==des==" + str2);
        }

        public void a(byte[] bArr, String str, int i2) {
            kotlin.jvm.internal.h.d(bArr, AeUtil.ROOT_DATA_PATH_OLD_NAME);
            kotlin.jvm.internal.h.d(str, IjkMediaPlayer.OnNativeInvokeListener.ARG_IP);
            org.greenrobot.eventbus.c.a().d(new ha.g(3, bArr));
        }
    }

    public static final class i extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20245a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(a aVar, String str) {
            super(str);
            this.f20245a = aVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:47:0x011c  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x000b A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r13 = this;
                com.hoho.android.usb.rtsp.a r0 = r13.f20245a
                java.lang.String r0 = r0.f11877e
                java.lang.String r1 = "mFrameThread已启动"
                android.util.Log.i(r0, r1)
            L_0x000b:
                com.hoho.android.usb.rtsp.a r0 = r13.f20245a
                boolean r0 = r0.f11891s
                if (r0 == 0) goto L_0x013f
                com.hoho.android.usb.rtsp.a r0 = r13.f20245a
                java.util.ArrayList r0 = r0.f11894v
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x002a
                r0 = 1
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0025 }
                goto L_0x000b
            L_0x0025:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x000b
            L_0x002a:
                com.hoho.android.usb.rtsp.a r0 = r13.f20245a
                java.lang.Object r0 = r0.f11898z
                monitor-enter(r0)
                com.hoho.android.usb.rtsp.a r1 = r13.f20245a     // Catch:{ all -> 0x013c }
                java.util.ArrayList r1 = r1.f11894v     // Catch:{ all -> 0x013c }
                r2 = 0
                java.lang.Object r1 = r1.remove(r2)     // Catch:{ all -> 0x013c }
                byte[] r1 = (byte[]) r1     // Catch:{ all -> 0x013c }
                kotlin.l r3 = kotlin.l.f30254a     // Catch:{ all -> 0x013c }
                monitor-exit(r0)
                com.hoho.android.usb.rtsp.a r0 = r13.f20245a
                java.util.ArrayList r0 = r0.D
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                boolean r0 = kotlin.collections.h.a(r0, r1)
                r3 = 1
                if (r0 == 0) goto L_0x0069
                com.hoho.android.usb.rtsp.a r0 = r13.f20245a
                java.util.ArrayList r0 = r0.D
                java.util.Collection r0 = (java.util.Collection) r0
                java.lang.String r4 = "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>"
                java.util.Objects.requireNonNull(r0, r4)
                java.util.Collection r0 = kotlin.jvm.internal.m.a((java.lang.Object) r0)
                r0.remove(r1)
                com.hoho.android.usb.rtsp.a r0 = r13.f20245a
                r0.E = r3
            L_0x0069:
                com.hoho.android.usb.rtsp.a r0 = r13.f20245a
                com.hoho.android.usb.rtsp.RtspPacketDecode r0 = com.hoho.android.usb.rtsp.a.l(r0)
                kotlin.jvm.internal.h.a((java.lang.Object) r1)
                int r4 = r1.length
                byte[] r6 = r0.rtp2h264ByJni(r1, r4)
                if (r6 == 0) goto L_0x000b
                com.hoho.android.usb.rtsp.a r0 = r13.f20245a
                boolean r0 = r0.E
                if (r0 == 0) goto L_0x0087
                com.hoho.android.usb.rtsp.a r0 = r13.f20245a
                r0.E = r2
                goto L_0x000b
            L_0x0087:
                r0 = 4
                byte r1 = r6[r0]
                r1 = r1 & 31
                r2 = 5
                if (r1 != r2) goto L_0x009c
                com.hoho.android.usb.rtsp.a r1 = r13.f20245a
                boolean r1 = r1.B
                if (r1 != 0) goto L_0x009c
                com.hoho.android.usb.rtsp.a r1 = r13.f20245a
                r1.B = r3
            L_0x009c:
                com.hoho.android.usb.rtsp.a r1 = r13.f20245a
                boolean r1 = r1.B
                if (r1 == 0) goto L_0x000b
                byte r1 = r6[r0]
                r1 = r1 & 31
                r4 = 6
                if (r1 != r4) goto L_0x00ad
                goto L_0x000b
            L_0x00ad:
                byte r1 = r6[r0]
                r1 = r1 & 31
                r4 = 7
                if (r1 == r4) goto L_0x0127
                byte r1 = r6[r0]
                r1 = r1 & 31
                r4 = 8
                if (r1 != r4) goto L_0x00bd
                goto L_0x0127
            L_0x00bd:
                byte r0 = r6[r0]
                r0 = r0 & 31
                if (r0 != r2) goto L_0x010b
                com.hoho.android.usb.rtsp.a r0 = r13.f20245a
                java.util.HashMap r0 = r0.F
                int r0 = r0.size()
                if (r0 < r3) goto L_0x0114
                com.hoho.android.usb.rtsp.a r0 = r13.f20245a
                java.util.HashMap r0 = r0.F
                java.util.Map r0 = (java.util.Map) r0
                java.util.Set r0 = r0.entrySet()
                java.util.Iterator r0 = r0.iterator()
            L_0x00df:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x010b
                java.lang.Object r1 = r0.next()
                java.util.Map$Entry r1 = (java.util.Map.Entry) r1
                java.lang.Object r2 = r1.getKey()
                java.lang.Number r2 = (java.lang.Number) r2
                long r11 = r2.longValue()
                java.lang.Object r1 = r1.getValue()
                r8 = r1
                byte[] r8 = (byte[]) r8
                com.hoho.android.usb.rtsp.a r1 = r13.f20245a
                hb.a r7 = r1.Q
                kotlin.jvm.internal.h.a((java.lang.Object) r7)
                r9 = 0
                int r10 = r8.length
                r7.a(r8, r9, r10, r11)
                goto L_0x00df
            L_0x010b:
                com.hoho.android.usb.rtsp.a r0 = r13.f20245a
                java.util.HashMap r0 = r0.F
                r0.clear()
            L_0x0114:
                com.hoho.android.usb.rtsp.a r0 = r13.f20245a
                hb.a r5 = r0.Q
                if (r5 == 0) goto L_0x000b
                r7 = 0
                int r8 = r6.length
                long r9 = java.lang.System.currentTimeMillis()
                r5.a(r6, r7, r8, r9)
                goto L_0x000b
            L_0x0127:
                com.hoho.android.usb.rtsp.a r0 = r13.f20245a
                java.util.HashMap r0 = r0.F
                java.util.Map r0 = (java.util.Map) r0
                long r1 = java.lang.System.currentTimeMillis()
                java.lang.Long r1 = java.lang.Long.valueOf(r1)
                r0.put(r1, r6)
                goto L_0x000b
            L_0x013c:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            L_0x013f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hoho.android.usb.rtsp.a.i.run():void");
        }
    }

    public static final class j extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20246a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(a aVar, String str) {
            super(str);
            this.f20246a = aVar;
        }

        public void run() {
            hb.a j2;
            while (this.f20246a.f11891s) {
                byte[] bArr = (byte[]) this.f20246a.f11893u.poll();
                if (bArr != null) {
                    String str = new String(bArr, kotlin.text.d.f30261a);
                    if (kotlin.text.f.b(str, "RTSP", false, 2, (Object) null)) {
                        this.f20246a.a(str);
                    } else if (this.f20246a.f11875b) {
                        this.f20246a.f11875b = false;
                        this.f20246a.d(str);
                        this.f20246a.d(16);
                        b i2 = this.f20246a.f11890r;
                        if (!(i2 == null || (j2 = this.f20246a.Q) == null)) {
                            j2.a(i2);
                        }
                    }
                }
            }
        }
    }

    public static final class k implements a.C0135a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20247a;

        /* renamed from: com.hoho.android.usb.rtsp.a$k$a  reason: collision with other inner class name */
        static final class C0134a<T> implements Comparator<byte[]> {

            /* renamed from: a  reason: collision with root package name */
            public static final C0134a f20248a = new C0134a();

            C0134a() {
            }

            /* renamed from: a */
            public final int compare(byte[] bArr, byte[] bArr2) {
                return Integer.compare(hf.a.a(bArr, 2), hf.a.a(bArr2, 2));
            }
        }

        k(a aVar) {
            this.f20247a = aVar;
        }

        public void a(int i2, String str, int i3, int i4, int i5, String str2) {
            kotlin.jvm.internal.h.d(str, IjkMediaPlayer.OnNativeInvokeListener.ARG_IP);
            kotlin.jvm.internal.h.d(str2, "des");
            String a2 = this.f20247a.f11877e;
            Log.i(a2, "onError: ==rtsp udp connect error num==" + i4 + "==des==" + str2);
        }

        public void a(byte[] bArr, String str, int i2) {
            kotlin.jvm.internal.h.d(bArr, AeUtil.ROOT_DATA_PATH_OLD_NAME);
            kotlin.jvm.internal.h.d(str, IjkMediaPlayer.OnNativeInvokeListener.ARG_IP);
            synchronized (this.f20247a.f11898z) {
                this.f20247a.f11894v.add(bArr);
                kotlin.collections.h.a(this.f20247a.f11894v, C0134a.f20248a);
                int a2 = hf.a.a(bArr, 2);
                a aVar = this.f20247a;
                if (aVar.C != 0) {
                    if (this.f20247a.C + 1 != a2) {
                        this.f20247a.D.add(bArr);
                    }
                }
                aVar.C = a2;
                kotlin.l lVar = kotlin.l.f30254a;
            }
        }
    }

    public static final class l implements a.C0135a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20249a;

        l(a aVar) {
            this.f20249a = aVar;
        }

        public void a(int i2, String str, int i3, int i4, int i5, String str2) {
            kotlin.jvm.internal.h.d(str, IjkMediaPlayer.OnNativeInvokeListener.ARG_IP);
            kotlin.jvm.internal.h.d(str2, "des");
            Log.i("LOOK_LOGFail", "mTcpConnERRor: " + i4 + str2);
        }

        public void a(byte[] bArr, String str, int i2) {
            kotlin.jvm.internal.h.d(bArr, AeUtil.ROOT_DATA_PATH_OLD_NAME);
            kotlin.jvm.internal.h.d(str, IjkMediaPlayer.OnNativeInvokeListener.ARG_IP);
            if (this.f20249a.f11876c) {
                this.f20249a.f11893u.add(bArr);
            } else {
                this.f20249a.e(bArr);
            }
        }
    }

    static final class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20250a;

        m(a aVar) {
            this.f20250a = aVar;
        }

        public final void run() {
            this.f20250a.k();
        }
    }

    static final class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20251a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f20252b;

        n(a aVar, String str) {
            this.f20251a = aVar;
            this.f20252b = str;
        }

        public final void run() {
            Toast.makeText(this.f20251a.R, this.f20252b, 0).show();
        }
    }

    public a(com.hoho.android.usb.usb.data_proxy.d dVar, hb.a aVar, Context context) {
        kotlin.jvm.internal.h.d(context, "mContext");
        this.P = dVar;
        this.Q = aVar;
        this.R = context;
        Thread jVar = new j(this, "readThread");
        this.M = jVar;
        Thread iVar = new i(this, "frameThread");
        this.N = iVar;
        this.O = new m(this);
        this.f11892t = new RtspPacketDecode(1280, Constants.PORTRAIT_IMAGE_WIDTH);
        jVar.start();
        iVar.start();
    }

    private final b a(List<? extends Pair<String, String>> list) {
        b bVar = new b();
        bVar.f20236a = (f) b(list)[0];
        for (Pair pair : list) {
            String str = (String) pair.first;
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != 105) {
                    if (hashCode == 115 && str.equals("s")) {
                        bVar.a((String) pair.second);
                    }
                } else if (str.equals("i")) {
                    bVar.b((String) pair.second);
                }
            }
        }
        return bVar;
    }

    private final String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append(":");
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Basic ");
        Charset charset = StandardCharsets.ISO_8859_1;
        kotlin.jvm.internal.h.b(charset, "StandardCharsets.ISO_8859_1");
        Objects.requireNonNull(sb2, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = sb2.getBytes(charset);
        kotlin.jvm.internal.h.b(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] encode = Base64.encode(bytes, 2);
        kotlin.jvm.internal.h.b(encode, "Base64.encode(\n         …e64.NO_WRAP\n            )");
        sb3.append(new String(encode, kotlin.text.d.f30261a));
        return sb3.toString();
    }

    private final String a(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            Charset charset = StandardCharsets.ISO_8859_1;
            kotlin.jvm.internal.h.b(charset, "StandardCharsets.ISO_8859_1");
            byte[] bytes = str.getBytes(charset);
            kotlin.jvm.internal.h.b(bytes, "(this as java.lang.String).getBytes(charset)");
            instance.update(bytes);
            byte b2 = (byte) 58;
            instance.update(b2);
            Charset charset2 = StandardCharsets.ISO_8859_1;
            kotlin.jvm.internal.h.b(charset2, "StandardCharsets.ISO_8859_1");
            if (str5 != null) {
                byte[] bytes2 = str5.getBytes(charset2);
                kotlin.jvm.internal.h.b(bytes2, "(this as java.lang.String).getBytes(charset)");
                instance.update(bytes2);
                instance.update(b2);
                Charset charset3 = StandardCharsets.ISO_8859_1;
                kotlin.jvm.internal.h.b(charset3, "StandardCharsets.ISO_8859_1");
                byte[] bytes3 = str2.getBytes(charset3);
                kotlin.jvm.internal.h.b(bytes3, "(this as java.lang.String).getBytes(charset)");
                instance.update(bytes3);
                byte[] digest = instance.digest();
                kotlin.jvm.internal.h.b(digest, "md.digest()");
                instance.reset();
                Charset charset4 = StandardCharsets.ISO_8859_1;
                kotlin.jvm.internal.h.b(charset4, "StandardCharsets.ISO_8859_1");
                if (str3 != null) {
                    byte[] bytes4 = str3.getBytes(charset4);
                    kotlin.jvm.internal.h.b(bytes4, "(this as java.lang.String).getBytes(charset)");
                    instance.update(bytes4);
                    instance.update(b2);
                    Charset charset5 = StandardCharsets.ISO_8859_1;
                    kotlin.jvm.internal.h.b(charset5, "StandardCharsets.ISO_8859_1");
                    if (str4 != null) {
                        byte[] bytes5 = str4.getBytes(charset5);
                        kotlin.jvm.internal.h.b(bytes5, "(this as java.lang.String).getBytes(charset)");
                        instance.update(bytes5);
                        byte[] digest2 = instance.digest();
                        String f2 = f(digest);
                        Charset charset6 = StandardCharsets.ISO_8859_1;
                        kotlin.jvm.internal.h.b(charset6, "StandardCharsets.ISO_8859_1");
                        if (f2 != null) {
                            byte[] bytes6 = f2.getBytes(charset6);
                            kotlin.jvm.internal.h.b(bytes6, "(this as java.lang.String).getBytes(charset)");
                            instance.update(bytes6);
                            instance.update(b2);
                            Charset charset7 = StandardCharsets.ISO_8859_1;
                            kotlin.jvm.internal.h.b(charset7, "StandardCharsets.ISO_8859_1");
                            if (str6 != null) {
                                byte[] bytes7 = str6.getBytes(charset7);
                                kotlin.jvm.internal.h.b(bytes7, "(this as java.lang.String).getBytes(charset)");
                                instance.update(bytes7);
                                instance.update(b2);
                                kotlin.jvm.internal.h.b(digest2, "ha2");
                                String f3 = f(digest2);
                                Charset charset8 = StandardCharsets.ISO_8859_1;
                                kotlin.jvm.internal.h.b(charset8, "StandardCharsets.ISO_8859_1");
                                if (f3 != null) {
                                    byte[] bytes8 = f3.getBytes(charset8);
                                    kotlin.jvm.internal.h.b(bytes8, "(this as java.lang.String).getBytes(charset)");
                                    instance.update(bytes8);
                                    byte[] digest3 = instance.digest();
                                    kotlin.jvm.internal.h.b(digest3, "md.digest()");
                                    String f4 = f(digest3);
                                    return "Digest username=\"" + str + "\", realm=\"" + str5 + "\", nonce=\"" + str6 + "\", uri=\"" + str4 + "\", response=\"" + f4 + '\"';
                                }
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private final List<Pair<String, String>> a(Pair<String, String> pair) {
        Pair<String, String> pair2 = pair;
        if (kotlin.jvm.internal.h.a((Object) (String) pair2.first, (Object) "a")) {
            Object obj = pair2.second;
            kotlin.jvm.internal.h.b(obj, "param.second");
            if (kotlin.text.f.b((String) obj, "fmtp:", false, 2, (Object) null)) {
                Object obj2 = pair2.second;
                kotlin.jvm.internal.h.b(obj2, "param.second");
                String str = (String) obj2;
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String substring = str.substring(8);
                kotlin.jvm.internal.h.b(substring, "(this as java.lang.String).substring(startIndex)");
                CharSequence charSequence = substring;
                int length = charSequence.length() - 1;
                int i2 = 0;
                boolean z2 = false;
                while (i2 <= length) {
                    boolean z3 = kotlin.jvm.internal.h.a((int) charSequence.charAt(!z2 ? i2 : length), 32) <= 0;
                    if (!z2) {
                        if (!z3) {
                            z2 = true;
                        } else {
                            i2++;
                        }
                    } else if (!z3) {
                        break;
                    } else {
                        length--;
                    }
                }
                String[] split = TextUtils.split(charSequence.subSequence(i2, length + 1).toString(), ";");
                ArrayList arrayList = new ArrayList();
                for (String str2 : split) {
                    kotlin.jvm.internal.h.b(str2, "paramA");
                    CharSequence charSequence2 = str2;
                    int length2 = charSequence2.length() - 1;
                    int i3 = 0;
                    boolean z4 = false;
                    while (i3 <= length2) {
                        boolean z5 = kotlin.jvm.internal.h.a((int) charSequence2.charAt(!z4 ? i3 : length2), 32) <= 0;
                        if (!z4) {
                            if (!z5) {
                                z4 = true;
                            } else {
                                i3++;
                            }
                        } else if (!z5) {
                            break;
                        } else {
                            length2--;
                        }
                    }
                    String obj3 = charSequence2.subSequence(i3, length2 + 1).toString();
                    int a2 = kotlin.text.f.a((CharSequence) obj3, "=", 0, false, 6, (Object) null);
                    if (a2 != -1) {
                        Objects.requireNonNull(obj3, "null cannot be cast to non-null type java.lang.String");
                        String substring2 = obj3.substring(0, a2);
                        kotlin.jvm.internal.h.b(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        Objects.requireNonNull(obj3, "null cannot be cast to non-null type java.lang.String");
                        String substring3 = obj3.substring(a2 + 1);
                        kotlin.jvm.internal.h.b(substring3, "(this as java.lang.String).substring(startIndex)");
                        arrayList.add(Pair.create(substring2, substring3));
                    }
                }
                return arrayList;
            }
        }
        com.hoho.android.usb.usb.data_proxy.log.b.h(this.f11877e, "Not a valid fmtp", new Object[0]);
        return null;
    }

    private final void a(int i2, int i3, int i4) {
    }

    private final void a(f fVar, Pair<String, String> pair) {
        List<Pair<String, String>> a2 = a(pair);
        if (a2 != null) {
            for (Pair next : a2) {
                Object obj = next.first;
                kotlin.jvm.internal.h.b(obj, "pair.first");
                String str = (String) obj;
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = str.toLowerCase();
                kotlin.jvm.internal.h.b(lowerCase, "(this as java.lang.String).toLowerCase()");
                if (lowerCase.hashCode() == 1191896140 && lowerCase.equals("sprop-parameter-sets")) {
                    String[] split = TextUtils.split((String) next.second, ",");
                    if (split == null) {
                        return;
                    }
                    if (split.length > 1) {
                        byte[] decode = Base64.decode(split[0], 2);
                        byte[] decode2 = Base64.decode(split[1], 2);
                        byte[] bArr = new byte[(decode.length + 4)];
                        byte[] bArr2 = new byte[(decode2.length + 4)];
                        bArr[0] = 0;
                        bArr[1] = 0;
                        bArr[2] = 0;
                        bArr[3] = 1;
                        System.arraycopy(decode, 0, bArr, 4, decode.length);
                        bArr2[0] = 0;
                        bArr2[1] = 0;
                        bArr2[2] = 0;
                        bArr2[3] = 1;
                        System.arraycopy(decode2, 0, bArr2, 4, decode2.length);
                        fVar.f20242b = bArr;
                        fVar.f20243c = bArr2;
                    }
                }
            }
        }
    }

    private final void a(Proxy.c cVar, int i2) {
        ConcurrentHashMap<Integer, com.hoho.android.usb.usb.data_proxy.a> c2;
        com.hoho.android.usb.usb.data_proxy.a aVar;
        a.C0135a a2;
        d dVar;
        Log.e("setStatus", "processReceivedMsg: port" + cVar.s());
        int s2 = cVar.s();
        Proxy.a t2 = cVar.t();
        kotlin.jvm.internal.h.b(t2, "proxyMsg.data");
        int m2 = t2.m();
        Proxy.a t3 = cVar.t();
        kotlin.jvm.internal.h.b(t3, "proxyMsg.data");
        a(s2, m2, t3.n());
        if (cVar.s() == 554) {
            d dVar2 = this.G;
            if (dVar2 != null) {
                dVar2.a(cVar.o(), "554连接失败");
            }
        } else if (cVar.s() == 7878 && (dVar = this.G) != null) {
            dVar.c(cVar.o(), "7878连接失败");
        }
        String str = this.f11877e;
        StringBuilder sb = new StringBuilder();
        sb.append("processReceivedMsg:===onError:== ");
        Proxy.a t4 = cVar.t();
        kotlin.jvm.internal.h.b(t4, "proxyMsg.data");
        sb.append(t4.o());
        sb.append("===");
        sb.append(cVar.o());
        sb.append("===connType===");
        sb.append(cVar.p());
        Log.e(str, sb.toString());
        com.hoho.android.usb.usb.data_proxy.d dVar3 = this.P;
        if (dVar3 != null && (c2 = dVar3.c()) != null && (aVar = c2.get(Integer.valueOf(i2))) != null && (a2 = aVar.a()) != null) {
            int o2 = cVar.o();
            String r2 = cVar.r();
            int s3 = cVar.s();
            Proxy.a t5 = cVar.t();
            kotlin.jvm.internal.h.b(t5, "proxyMsg.data");
            int m3 = t5.m();
            Proxy.a t6 = cVar.t();
            kotlin.jvm.internal.h.b(t6, "proxyMsg.data");
            int n2 = t6.n();
            Proxy.a t7 = cVar.t();
            kotlin.jvm.internal.h.b(t7, "proxyMsg.data");
            a2.a(o2, r2, s3, m3, n2, t7.o());
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        hf.e eVar = hf.e.f13323a;
        kotlin.jvm.internal.h.a((Object) str);
        int a2 = eVar.a(str);
        if (a2 == 200) {
            b(str);
        } else if (a2 == 401) {
            e(str);
        }
    }

    private final void b(Proxy.c cVar) {
        com.hoho.android.usb.usb.data_proxy.d dVar = this.P;
        if (dVar != null) {
            Proxy.c cVar2 = dVar.d().get(Integer.valueOf(cVar.o()));
            ConcurrentHashMap<Integer, Proxy.c> d2 = dVar.d();
            if (cVar2 == null) {
                d2.put(Integer.valueOf(cVar.o()), cVar);
                Log.i(this.f11877e, "processReceivedMsg: ==mUsbDataProxy.mProxyMap==null");
                return;
            }
            Proxy.c cVar3 = d2.get(Integer.valueOf(cVar.o()));
            Proxy.MsgType q2 = cVar3 != null ? cVar3.q() : null;
            if (q2 != null) {
                int i2 = b.f20254b[q2.ordinal()];
                if (i2 == 1) {
                    c(cVar);
                } else if (i2 == 2) {
                    d(cVar);
                }
            }
        }
    }

    private final void b(String str) {
        int i2 = this.f11889q;
        if (i2 == 2) {
            d(4);
        } else if (i2 == 4) {
            ArrayList<Pair<String, String>> f2 = f(str);
            d(str);
            d(16);
            hb.a aVar = this.Q;
            if (aVar != null) {
                b bVar = this.f11890r;
                kotlin.jvm.internal.h.a((Object) bVar);
                aVar.a(bVar);
            }
            if (f2.size() <= 10) {
                this.f11875b = true;
                return;
            }
            return;
        } else if (i2 == 16) {
            if (!c(str)) {
                m();
                return;
            } else {
                d(32);
                return;
            }
        } else if (i2 == 256) {
            m();
        } else if (i2 == 32 && !this.f11876c) {
            l();
            this.f11876c = true;
            return;
        } else {
            return;
        }
        this.f11876c = false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.hoho.android.usb.rtsp.a.c[] b(java.util.List<? extends android.util.Pair<java.lang.String, java.lang.String>> r15) {
        /*
            r14 = this;
            r0 = 2
            com.hoho.android.usb.rtsp.a$c[] r1 = new com.hoho.android.usb.rtsp.a.c[r0]
            r2 = 0
            r3 = r2
            com.hoho.android.usb.rtsp.a$c r3 = (com.hoho.android.usb.rtsp.a.c) r3
            java.util.Iterator r15 = r15.iterator()
            r4 = r3
        L_0x000c:
            boolean r5 = r15.hasNext()
            if (r5 == 0) goto L_0x01a3
            java.lang.Object r5 = r15.next()
            android.util.Pair r5 = (android.util.Pair) r5
            java.lang.Object r6 = r5.first
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x001f
            goto L_0x000c
        L_0x001f:
            int r7 = r6.hashCode()
            r8 = 97
            java.lang.String r9 = "\""
            java.lang.String r10 = " "
            r11 = 1
            java.lang.String r12 = "param.second"
            r13 = 0
            if (r7 == r8) goto L_0x00ae
            r8 = 109(0x6d, float:1.53E-43)
            if (r7 == r8) goto L_0x0034
            goto L_0x000c
        L_0x0034:
            java.lang.String r7 = "m"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x000c
            java.lang.Object r6 = r5.second
            kotlin.jvm.internal.h.b(r6, r12)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = "video"
            boolean r6 = kotlin.text.f.b(r6, r7, r13, r0, r2)
            if (r6 == 0) goto L_0x0055
            com.hoho.android.usb.rtsp.a$f r4 = new com.hoho.android.usb.rtsp.a$f
            r4.<init>()
            com.hoho.android.usb.rtsp.a$c r4 = (com.hoho.android.usb.rtsp.a.c) r4
            r1[r13] = r4
            goto L_0x0068
        L_0x0055:
            java.lang.Object r6 = r5.second
            kotlin.jvm.internal.h.b(r6, r12)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = "audio"
            boolean r6 = kotlin.text.f.b(r6, r7, r13, r0, r2)
            if (r6 == 0) goto L_0x0067
            r1[r11] = r4
            goto L_0x0068
        L_0x0067:
            r4 = r3
        L_0x0068:
            if (r4 == 0) goto L_0x000c
            java.lang.Object r6 = r5.second
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String[] r6 = android.text.TextUtils.split(r6, r10)
            int r7 = r6.length
            r8 = -1
            r10 = 3
            if (r7 <= r10) goto L_0x0083
            r6 = r6[r10]
            java.lang.String r7 = "values[3]"
            kotlin.jvm.internal.h.b(r6, r7)
            int r6 = java.lang.Integer.parseInt(r6)
            goto L_0x0084
        L_0x0083:
            r6 = -1
        L_0x0084:
            r4.a((int) r6)
            int r6 = r4.a()
            if (r6 != r8) goto L_0x000c
            java.lang.String r6 = r14.f11877e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Failed to get payload type from \"m="
            r7.append(r8)
            java.lang.Object r5 = r5.second
            java.lang.String r5 = (java.lang.String) r5
            r7.append(r5)
            r7.append(r9)
            java.lang.String r5 = r7.toString()
            java.lang.Object[] r7 = new java.lang.Object[r13]
            com.hoho.android.usb.usb.data_proxy.log.b.h(r6, r5, r7)
            goto L_0x000c
        L_0x00ae:
            java.lang.String r7 = "a"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x000c
            if (r4 == 0) goto L_0x000c
            java.lang.Object r6 = r5.second
            kotlin.jvm.internal.h.b(r6, r12)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = "control:"
            boolean r6 = kotlin.text.f.b(r6, r7, r13, r0, r2)
            java.lang.String r7 = "null cannot be cast to non-null type java.lang.String"
            if (r6 == 0) goto L_0x00e3
            java.lang.Object r5 = r5.second
            kotlin.jvm.internal.h.b(r5, r12)
            java.lang.String r5 = (java.lang.String) r5
            r6 = 8
            java.util.Objects.requireNonNull(r5, r7)
            java.lang.String r5 = r5.substring(r6)
            java.lang.String r6 = "(this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.h.b(r5, r6)
            r4.a((java.lang.String) r5)
            goto L_0x000c
        L_0x00e3:
            java.lang.Object r6 = r5.second
            kotlin.jvm.internal.h.b(r6, r12)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r8 = "fmtp:"
            boolean r6 = kotlin.text.f.b(r6, r8, r13, r0, r2)
            if (r6 == 0) goto L_0x0102
            boolean r6 = r4 instanceof com.hoho.android.usb.rtsp.a.f
            if (r6 == 0) goto L_0x000c
            r6 = r1[r13]
            com.hoho.android.usb.rtsp.a$f r6 = (com.hoho.android.usb.rtsp.a.f) r6
            kotlin.jvm.internal.h.a((java.lang.Object) r6)
            r14.a((com.hoho.android.usb.rtsp.a.f) r6, (android.util.Pair<java.lang.String, java.lang.String>) r5)
            goto L_0x000c
        L_0x0102:
            java.lang.Object r6 = r5.second
            kotlin.jvm.internal.h.b(r6, r12)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r8 = "rtpmap:"
            boolean r6 = kotlin.text.f.b(r6, r8, r13, r0, r2)
            if (r6 == 0) goto L_0x000c
            boolean r6 = r4 instanceof com.hoho.android.usb.rtsp.a.f
            if (r6 == 0) goto L_0x000c
            java.lang.Object r5 = r5.second
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String[] r5 = android.text.TextUtils.split(r5, r10)
            int r6 = r5.length
            if (r6 <= r11) goto L_0x000c
            r5 = r5[r11]
            java.lang.String r6 = "/"
            java.lang.String[] r5 = android.text.TextUtils.split(r5, r6)
            int r6 = r5.length
            if (r6 <= 0) goto L_0x000c
            r6 = r5[r13]
            java.lang.String r8 = "values[0]"
            kotlin.jvm.internal.h.b(r6, r8)
            java.util.Objects.requireNonNull(r6, r7)
            java.lang.String r6 = r6.toLowerCase()
            java.lang.String r7 = "(this as java.lang.String).toLowerCase()"
            kotlin.jvm.internal.h.b(r6, r7)
            int r7 = r6.hashCode()
            switch(r7) {
                case 3148040: goto L_0x0158;
                case 3148041: goto L_0x0146;
                default: goto L_0x0145;
            }
        L_0x0145:
            goto L_0x016a
        L_0x0146:
            java.lang.String r7 = "h265"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x016a
            r6 = r1[r13]
            com.hoho.android.usb.rtsp.a$f r6 = (com.hoho.android.usb.rtsp.a.f) r6
            kotlin.jvm.internal.h.a((java.lang.Object) r6)
            r6.f20241a = r11
            goto L_0x0187
        L_0x0158:
            java.lang.String r7 = "h264"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x016a
            r6 = r1[r13]
            com.hoho.android.usb.rtsp.a$f r6 = (com.hoho.android.usb.rtsp.a.f) r6
            kotlin.jvm.internal.h.a((java.lang.Object) r6)
            r6.f20241a = r13
            goto L_0x0187
        L_0x016a:
            java.lang.String r6 = r14.f11877e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Unknown video codec \""
            r7.append(r8)
            r8 = r5[r13]
            r7.append(r8)
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r13]
            com.hoho.android.usb.usb.data_proxy.log.b.g(r6, r7, r8)
        L_0x0187:
            java.lang.String r6 = r14.f11877e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Video: "
            r7.append(r8)
            r5 = r5[r13]
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            java.lang.Object[] r7 = new java.lang.Object[r13]
            com.hoho.android.usb.usb.data_proxy.log.b.e(r6, r5, r7)
            goto L_0x000c
        L_0x01a3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hoho.android.usb.rtsp.a.b(java.util.List):com.hoho.android.usb.rtsp.a$c[]");
    }

    private final void c(Proxy.c cVar) {
        ConcurrentHashMap<Integer, Proxy.c> d2;
        ConcurrentHashMap<Integer, Proxy.c> d3;
        ConcurrentHashMap<Integer, Proxy.c> d4;
        ConcurrentHashMap<Integer, Proxy.c> d5;
        int s2 = cVar.s();
        if (s2 == 554) {
            Proxy.a t2 = cVar.t();
            kotlin.jvm.internal.h.b(t2, "proxyMsg.data");
            if (t2.m() == 0) {
                com.hoho.android.usb.usb.data_proxy.b bVar = new com.hoho.android.usb.usb.data_proxy.b(this.P, cVar.o());
                this.f11879g = bVar;
                if (bVar != null) {
                    bVar.a(this.K);
                    com.hoho.android.usb.usb.data_proxy.d dVar = this.P;
                    if (dVar != null) {
                        dVar.a(cVar.o(), (com.hoho.android.usb.usb.data_proxy.a) bVar);
                    }
                }
                com.hoho.android.usb.usb.data_proxy.d dVar2 = this.P;
                if (!(dVar2 == null || (d2 = dVar2.d()) == null)) {
                    Proxy.c remove = d2.remove(Integer.valueOf(cVar.o()));
                }
                d dVar3 = this.G;
                if (dVar3 != null) {
                    dVar3.a(cVar.o());
                    return;
                }
                return;
            }
            d dVar4 = this.G;
            if (dVar4 != null) {
                dVar4.a(cVar.o(), "554创建失败");
            }
        } else if (s2 == 7878) {
            Proxy.a t3 = cVar.t();
            kotlin.jvm.internal.h.b(t3, "proxyMsg.data");
            if (t3.m() == 0) {
                com.hoho.android.usb.usb.data_proxy.b bVar2 = new com.hoho.android.usb.usb.data_proxy.b(this.P, cVar.o());
                this.f11880h = bVar2;
                if (bVar2 != null) {
                    bVar2.a(this.J);
                    Log.i(this.f11877e, "tcpCreateAndConnect: 7878创建成功");
                    com.hoho.android.usb.usb.data_proxy.d dVar5 = this.P;
                    if (dVar5 != null) {
                        dVar5.a(cVar.o(), (com.hoho.android.usb.usb.data_proxy.a) bVar2);
                    }
                }
                com.hoho.android.usb.usb.data_proxy.d dVar6 = this.P;
                if (!(dVar6 == null || (d3 = dVar6.d()) == null)) {
                    Proxy.c remove2 = d3.remove(Integer.valueOf(cVar.o()));
                }
                d dVar7 = this.G;
                if (dVar7 != null) {
                    dVar7.c(cVar.o());
                    return;
                }
                return;
            }
            Log.i(this.f11877e, "tcpCreateAndConnect: 7878创建失败");
            this.f11874a = false;
            d dVar8 = this.G;
            if (dVar8 != null) {
                dVar8.c(cVar.o(), "7878创建失败");
            }
        } else if (s2 == 9898) {
            Proxy.a t4 = cVar.t();
            kotlin.jvm.internal.h.b(t4, "proxyMsg.data");
            if (t4.m() == 0) {
                com.hoho.android.usb.usb.data_proxy.c cVar2 = new com.hoho.android.usb.usb.data_proxy.c(this.P, cVar.o());
                this.f11878f = cVar2;
                if (cVar2 != null) {
                    cVar2.a(this.L);
                    com.hoho.android.usb.usb.data_proxy.d dVar9 = this.P;
                    if (dVar9 != null) {
                        dVar9.a(cVar.o(), (com.hoho.android.usb.usb.data_proxy.a) cVar2);
                    }
                }
                com.hoho.android.usb.usb.data_proxy.d dVar10 = this.P;
                if (!(dVar10 == null || (d4 = dVar10.d()) == null)) {
                    Proxy.c remove3 = d4.remove(Integer.valueOf(cVar.o()));
                }
                e eVar = this.H;
                if (eVar != null) {
                    eVar.a(cVar.o());
                    return;
                }
                return;
            }
            e eVar2 = this.H;
            if (eVar2 != null) {
                eVar2.a(cVar.o(), "9898连接失败");
            }
        } else if (s2 == 10001) {
            this.f11874a = false;
            String str = this.f11877e;
            StringBuilder sb = new StringBuilder();
            sb.append("tcpCreateAndConnect 10005创建code:");
            Proxy.a t5 = cVar.t();
            kotlin.jvm.internal.h.b(t5, "proxyMsg.data");
            sb.append(t5.m());
            Log.i(str, sb.toString());
            Proxy.a t6 = cVar.t();
            kotlin.jvm.internal.h.b(t6, "proxyMsg.data");
            if (t6.m() == 0) {
                com.hoho.android.usb.usb.data_proxy.c cVar3 = new com.hoho.android.usb.usb.data_proxy.c(this.P, cVar.o());
                this.f11881i = cVar3;
                if (cVar3 != null) {
                    cVar3.a(this.I);
                    com.hoho.android.usb.usb.data_proxy.d dVar11 = this.P;
                    if (dVar11 != null) {
                        dVar11.a(cVar.o(), (com.hoho.android.usb.usb.data_proxy.a) cVar3);
                    }
                }
                com.hoho.android.usb.usb.data_proxy.d dVar12 = this.P;
                if (!(dVar12 == null || (d5 = dVar12.d()) == null)) {
                    Proxy.c remove4 = d5.remove(Integer.valueOf(cVar.o()));
                }
                e eVar3 = this.H;
                if (eVar3 != null) {
                    eVar3.b(cVar.o());
                    return;
                }
                return;
            }
            e eVar4 = this.H;
            if (eVar4 != null) {
                eVar4.b(cVar.o(), "10001连接失败");
            }
        }
    }

    private final boolean c(String str) {
        ArrayList<Pair<String, String>> f2 = f(str);
        this.f11883k = f11873d.a(f2, "Session");
        g("Session:" + this.f11883k);
        com.hoho.android.usb.usb.data_proxy.log.b.e(this.f11877e, f2.toString(), new Object[0]);
        if (!TextUtils.isEmpty(this.f11883k)) {
            String[] split = TextUtils.split(this.f11883k, ";");
            this.f11883k = split[0];
            if (split.length > 1) {
                String[] split2 = TextUtils.split(split[1], "=");
                if (split2.length > 1) {
                    try {
                        String str2 = split2[1];
                        kotlin.jvm.internal.h.b(str2, "params[1]");
                        this.f11885m = Integer.parseInt(str2);
                    } catch (NumberFormatException unused) {
                        com.hoho.android.usb.usb.data_proxy.log.b.h(this.f11877e, "Failed to parse RTSP session timeout", new Object[0]);
                        return false;
                    }
                }
            }
        }
        String str3 = this.f11883k;
        if (str3 == null || str3 == null) {
            return false;
        }
        if (!(str3.length() > 0)) {
            return false;
        }
        String str4 = this.f11883k;
        return (str4 != null ? str4.length() : 0) > 0;
    }

    private final void d(Proxy.c cVar) {
        ConcurrentHashMap<Integer, Proxy.c> concurrentHashMap;
        int s2 = cVar.s();
        if (s2 == 554) {
            Proxy.a t2 = cVar.t();
            kotlin.jvm.internal.h.b(t2, "proxyMsg.data");
            if (t2.m() == 0) {
                d dVar = this.G;
                if (dVar != null) {
                    dVar.b(cVar.o());
                }
                com.hoho.android.usb.usb.data_proxy.d dVar2 = this.P;
                if (dVar2 == null || (concurrentHashMap = dVar2.d()) == null) {
                    return;
                }
            } else {
                d dVar3 = this.G;
                if (dVar3 != null) {
                    dVar3.b(cVar.o(), "554连接失败");
                    return;
                }
                return;
            }
        } else if (s2 == 7878) {
            Proxy.a t3 = cVar.t();
            kotlin.jvm.internal.h.b(t3, "proxyMsg.data");
            if (t3.m() == 0) {
                Log.i("setStatus", "tcpCreateAndConnect: 7878连接成功");
                d dVar4 = this.G;
                if (dVar4 != null) {
                    dVar4.d(cVar.o());
                }
                com.hoho.android.usb.usb.data_proxy.d dVar5 = this.P;
                if (dVar5 == null || (concurrentHashMap = dVar5.d()) == null) {
                    return;
                }
            } else {
                Log.i("setStatus", "tcpCreateAndConnect: 7878连接失败");
                d dVar6 = this.G;
                if (dVar6 != null) {
                    dVar6.d(cVar.o(), "7878连接失败");
                    return;
                }
                return;
            }
        } else {
            return;
        }
        Proxy.c remove = concurrentHashMap.remove(Integer.valueOf(cVar.o()));
    }

    /* access modifiers changed from: private */
    public final void d(String str) {
        this.f11890r = new b();
        try {
            C0133a aVar = f11873d;
            kotlin.jvm.internal.h.a((Object) str);
            this.f11890r = a((List<? extends Pair<String, String>>) aVar.a(str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final void e(String str) {
        String b2;
        String a2;
        ArrayList<Pair<String, String>> f2 = f(str);
        C0133a aVar = f11873d;
        Pair a3 = aVar.a(f2);
        if (a3 != null) {
            int i2 = this.f11889q;
            byte[] bArr = null;
            if (i2 == 2) {
                String str2 = this.f11886n;
                String str3 = this.f11887o;
                Object obj = a3.first;
                kotlin.jvm.internal.h.b(obj, "digestRealmNonce.first");
                Object obj2 = a3.second;
                kotlin.jvm.internal.h.b(obj2, "digestRealmNonce.second");
                String a4 = a(str2, str3, "OPTIONS", CameraGlobal.amba_rtsp_url, (String) obj, (String) obj2);
                this.f11888p = a4;
                com.hoho.android.usb.usb.data_proxy.b bVar = this.f11879g;
                if (bVar != null) {
                    if (!(bVar == null || (a2 = bVar.a((String) CameraGlobal.amba_rtsp_url, "", a4)) == null)) {
                        Charset charset = kotlin.text.d.f30261a;
                        Objects.requireNonNull(a2, "null cannot be cast to non-null type java.lang.String");
                        bArr = a2.getBytes(charset);
                        kotlin.jvm.internal.h.b(bArr, "(this as java.lang.String).getBytes(charset)");
                    }
                    bVar.a(bArr);
                }
            } else if (i2 == 4) {
                String str4 = this.f11886n;
                String str5 = this.f11887o;
                Object obj3 = a3.first;
                kotlin.jvm.internal.h.b(obj3, "digestRealmNonce.first");
                Object obj4 = a3.second;
                kotlin.jvm.internal.h.b(obj4, "digestRealmNonce.second");
                String a5 = a(str4, str5, "DESCRIBE", CameraGlobal.amba_rtsp_url, (String) obj3, (String) obj4);
                this.f11888p = a5;
                com.hoho.android.usb.usb.data_proxy.b bVar2 = this.f11879g;
                if (bVar2 != null) {
                    if (!(bVar2 == null || (b2 = bVar2.b(CameraGlobal.amba_rtsp_url, "", a5)) == null)) {
                        Charset charset2 = kotlin.text.d.f30261a;
                        Objects.requireNonNull(b2, "null cannot be cast to non-null type java.lang.String");
                        bArr = b2.getBytes(charset2);
                        kotlin.jvm.internal.h.b(bArr, "(this as java.lang.String).getBytes(charset)");
                    }
                    bVar2.a(bArr);
                }
            }
        } else if (!TextUtils.isEmpty(aVar.b(f2))) {
            this.f11888p = a(this.f11886n, this.f11887o);
        }
    }

    /* access modifiers changed from: private */
    public final void e(byte[] bArr) {
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = i3;
                break;
            }
            if (bArr[i2] == ((byte) 10)) {
                if (this.f11889q == 4) {
                    i2 = bArr.length;
                    break;
                } else if (i2 == i3 + 2) {
                    break;
                } else {
                    i3 = i2;
                }
            }
            i2++;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        this.f11893u.offer(bArr2);
        com.hoho.android.usb.usb.data_proxy.log.b.e(this.f11877e, Arrays.toString(bArr2), new Object[0]);
        synchronized (this.f11898z) {
            if (i2 < bArr.length - 10) {
                int length2 = bArr.length;
                while (true) {
                    if (i2 < length2) {
                        if (bArr[i2] == 36 && bArr[i2 + 1] == 0) {
                            byte[] bArr3 = new byte[(bArr.length - i2)];
                            System.arraycopy(bArr, i2, bArr3, 0, bArr.length - i2);
                            this.f11894v.add(bArr3);
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            }
            kotlin.l lVar = kotlin.l.f30254a;
        }
    }

    private final String f(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte valueOf : bArr) {
            kotlin.jvm.internal.l lVar = kotlin.jvm.internal.l.f30252a;
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(valueOf)}, 1));
            kotlin.jvm.internal.h.b(format, "java.lang.String.format(format, *args)");
            sb.append(format);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.h.b(sb2, "buf.toString()");
        return sb2;
    }

    private final ArrayList<Pair<String, String>> f(String str) {
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        kotlin.jvm.internal.h.a((Object) str);
        Object[] array = kotlin.text.f.a((CharSequence) str, new String[]{"\n"}, false, 0, 6, (Object) null).toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        String[] strArr = (String[]) array;
        int length = strArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            String[] split = TextUtils.split(strArr[i2], ":");
            if (split.length == 2) {
                String str2 = split[0];
                kotlin.jvm.internal.h.b(str2, "pairs[0]");
                CharSequence charSequence = str2;
                int length2 = charSequence.length() - 1;
                int i3 = 0;
                boolean z2 = false;
                while (i3 <= length2) {
                    boolean z3 = kotlin.jvm.internal.h.a((int) charSequence.charAt(!z2 ? i3 : length2), 32) <= 0;
                    if (!z2) {
                        if (!z3) {
                            z2 = true;
                        } else {
                            i3++;
                        }
                    } else if (!z3) {
                        break;
                    } else {
                        length2--;
                    }
                }
                String obj = charSequence.subSequence(i3, length2 + 1).toString();
                String str3 = split[1];
                kotlin.jvm.internal.h.b(str3, "pairs[1]");
                CharSequence charSequence2 = str3;
                int length3 = charSequence2.length() - 1;
                int i4 = 0;
                boolean z4 = false;
                while (i4 <= length3) {
                    boolean z5 = kotlin.jvm.internal.h.a((int) charSequence2.charAt(!z4 ? i4 : length3), 32) <= 0;
                    if (!z4) {
                        if (!z5) {
                            z4 = true;
                        } else {
                            i4++;
                        }
                    } else if (!z5) {
                        break;
                    } else {
                        length3--;
                    }
                }
                arrayList.add(Pair.create(obj, charSequence2.subSequence(i4, length3 + 1).toString()));
            }
        }
        return arrayList;
    }

    private final void g(String str) {
        Context context = this.R;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(new n(this, str));
        }
    }

    public static final /* synthetic */ RtspPacketDecode l(a aVar) {
        RtspPacketDecode rtspPacketDecode = aVar.f11892t;
        if (rtspPacketDecode == null) {
            kotlin.jvm.internal.h.b("mRtspDecode");
        }
        return rtspPacketDecode;
    }

    public final int a(byte[] bArr) {
        String str = this.f11877e;
        StringBuilder sb = new StringBuilder();
        sb.append("send: ===command===");
        kotlin.jvm.internal.h.a((Object) bArr);
        sb.append(new String(bArr, kotlin.text.d.f30261a));
        Log.i(str, sb.toString());
        return -1;
    }

    public final void a(int i2) {
        if (i2 != 554) {
            g();
            if (i2 == 7878) {
                return;
            }
        }
        h();
    }

    public final void a(d dVar) {
        this.G = dVar;
    }

    public final void a(e eVar) {
        this.H = eVar;
    }

    public final void a(Proxy.c cVar) {
        kotlin.jvm.internal.h.d(cVar, "proxyMsg");
        int o2 = cVar.o();
        Proxy.MsgType q2 = cVar.q();
        if (q2 != null) {
            switch (b.f20253a[q2.ordinal()]) {
                case 1:
                    com.hoho.android.usb.usb.data_proxy.d dVar = this.P;
                    kotlin.jvm.internal.h.a((Object) dVar);
                    if (dVar.a()) {
                        b(cVar);
                        return;
                    }
                    return;
                case 2:
                    com.hoho.android.usb.usb.data_proxy.d dVar2 = this.P;
                    kotlin.jvm.internal.h.a((Object) dVar2);
                    if (!dVar2.a()) {
                        c(cVar);
                        return;
                    }
                    return;
                case 3:
                    com.hoho.android.usb.usb.data_proxy.d dVar3 = this.P;
                    kotlin.jvm.internal.h.a((Object) dVar3);
                    if (!dVar3.a()) {
                        d(cVar);
                        return;
                    }
                    return;
                case 4:
                    Proxy.a t2 = cVar.t();
                    kotlin.jvm.internal.h.b(t2, "proxyMsg.data");
                    if (t2.m() == 0) {
                        return;
                    }
                    break;
                case 5:
                    break;
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    com.hoho.android.usb.usb.data_proxy.d dVar4 = this.P;
                    kotlin.jvm.internal.h.a((Object) dVar4);
                    for (com.hoho.android.usb.usb.data_proxy.g onRelay : dVar4.b().values()) {
                        Proxy.MsgType q3 = cVar.q();
                        kotlin.jvm.internal.h.b(q3, "proxyMsg.msgType");
                        Proxy.a t3 = cVar.t();
                        kotlin.jvm.internal.h.b(t3, "proxyMsg.data");
                        byte[] d2 = t3.p().d();
                        kotlin.jvm.internal.h.b(d2, "proxyMsg.data.arg4.toByteArray()");
                        onRelay.onRelay(q3, d2);
                    }
                    return;
                default:
                    return;
            }
            a(cVar, o2);
        }
    }

    public final boolean a() {
        return this.f11897y;
    }

    public final void b() {
        this.f11883k = "";
        this.f11874a = false;
        e();
        a(554);
        a(7878);
        o();
        m();
        j();
        this.M.interrupt();
        this.N.interrupt();
        this.P = null;
        Log.i(this.f11877e, "setStatus:processReceivedMsg: ==destroy==242");
    }

    public final void b(int i2) {
        String str = this.f11877e;
        Log.i(str, "createTcp: 创建554--->" + i2);
        a(554);
        com.hoho.android.usb.usb.data_proxy.d dVar = this.P;
        if (dVar != null) {
            dVar.a(1, 554);
        }
    }

    public final void b(byte[] bArr) {
        if (bArr != null) {
            String str = this.f11877e;
            Log.i(str, "sendCameraDataMsg: =====" + new String(bArr, kotlin.text.d.f30261a));
            com.hoho.android.usb.usb.data_proxy.b bVar = this.f11882j;
            if (bVar != null) {
                bVar.a(bArr);
            }
        }
    }

    public final void c() {
        if (!this.f11874a) {
            d dVar = this.G;
            if (dVar != null) {
                dVar.c(1, "close connect");
            }
            j();
            o();
            g();
            h();
            com.hoho.android.usb.usb.data_proxy.d dVar2 = this.P;
            if (dVar2 != null) {
                dVar2.l();
            }
            c(4);
            this.f11874a = true;
        }
    }

    public final void c(int i2) {
        Log.i(this.f11877e + "test", "createCameraTcp: " + i2);
        g();
        com.hoho.android.usb.usb.data_proxy.d dVar = this.P;
        if (dVar != null) {
            dVar.a(1, 7878);
        }
    }

    public final void c(byte[] bArr) {
        if (bArr != null) {
            Log.i("sendCameraMsg", "sendCameraMsg: =====" + new String(bArr, kotlin.text.d.f30261a));
            com.hoho.android.usb.usb.data_proxy.b bVar = this.f11880h;
            if (bVar != null) {
                bVar.a(bArr);
            }
        }
    }

    public final int d(byte[] bArr) {
        com.hoho.android.usb.usb.data_proxy.c cVar = this.f11881i;
        if (cVar != null) {
            return cVar.a(bArr, "172.50.10.1", IMediaPlayer.MEDIA_INFO_OPEN_INPUT);
        }
        return -1;
    }

    public final void d() {
        com.hoho.android.usb.usb.data_proxy.b bVar = this.f11879g;
        if (bVar != null) {
            bVar.a("172.50.10.1", 554);
        }
        Log.i(this.f11877e, "connectTcp: TCP连接成功");
    }

    public final void d(int i2) {
        String a2;
        String b2;
        com.hoho.android.usb.usb.data_proxy.b bVar;
        String c2;
        com.hoho.android.usb.usb.data_proxy.b bVar2;
        String b3;
        this.f11889q = i2;
        byte[] bArr = null;
        if (i2 == 2) {
            this.f11888p = "";
            com.hoho.android.usb.usb.data_proxy.b bVar3 = this.f11879g;
            if (bVar3 != null) {
                if (!(bVar3 == null || (a2 = bVar3.a((String) CameraGlobal.amba_rtsp_url, "", "")) == null)) {
                    Charset charset = kotlin.text.d.f30261a;
                    Objects.requireNonNull(a2, "null cannot be cast to non-null type java.lang.String");
                    bArr = a2.getBytes(charset);
                    kotlin.jvm.internal.h.b(bArr, "(this as java.lang.String).getBytes(charset)");
                }
                bVar3.a(bArr);
            }
        } else if (i2 == 4) {
            com.hoho.android.usb.usb.data_proxy.b bVar4 = this.f11879g;
            if (bVar4 != null) {
                if (!(bVar4 == null || (b2 = bVar4.b(CameraGlobal.amba_rtsp_url, "", this.f11888p)) == null)) {
                    Charset charset2 = kotlin.text.d.f30261a;
                    Objects.requireNonNull(b2, "null cannot be cast to non-null type java.lang.String");
                    bArr = b2.getBytes(charset2);
                    kotlin.jvm.internal.h.b(bArr, "(this as java.lang.String).getBytes(charset)");
                }
                bVar4.a(bArr);
            }
        } else if (i2 == 16) {
            com.hoho.android.usb.usb.data_proxy.b bVar5 = this.f11879g;
            if (bVar5 != null) {
                if (bVar5 != null) {
                    String a3 = bVar5.a(CameraGlobal.amba_rtsp_url + this.f11884l, "", this.f11888p, this.f11883k, "0-1");
                    if (a3 != null) {
                        Charset charset3 = kotlin.text.d.f30261a;
                        Objects.requireNonNull(a3, "null cannot be cast to non-null type java.lang.String");
                        bArr = a3.getBytes(charset3);
                        kotlin.jvm.internal.h.b(bArr, "(this as java.lang.String).getBytes(charset)");
                    }
                }
                bVar5.a(bArr);
            }
        } else if (i2 == 32) {
            String str = this.f11883k;
            if (str != null && (bVar = this.f11879g) != null) {
                if (!(bVar == null || (c2 = bVar.c(CameraGlobal.amba_rtsp_url, "", this.f11888p, str)) == null)) {
                    Charset charset4 = kotlin.text.d.f30261a;
                    Objects.requireNonNull(c2, "null cannot be cast to non-null type java.lang.String");
                    bArr = c2.getBytes(charset4);
                    kotlin.jvm.internal.h.b(bArr, "(this as java.lang.String).getBytes(charset)");
                }
                bVar.a(bArr);
            }
        } else if (i2 == 256 && (bVar2 = this.f11879g) != null) {
            if (!(bVar2 == null || (b3 = bVar2.b(CameraGlobal.amba_rtsp_url, "", this.f11888p, this.f11883k)) == null)) {
                Charset charset5 = kotlin.text.d.f30261a;
                Objects.requireNonNull(b3, "null cannot be cast to non-null type java.lang.String");
                bArr = b3.getBytes(charset5);
                kotlin.jvm.internal.h.b(bArr, "(this as java.lang.String).getBytes(charset)");
            }
            bVar2.a(bArr);
        }
    }

    public final void e() {
        com.hoho.android.usb.usb.data_proxy.b bVar = this.f11882j;
        if (bVar != null) {
            bVar.b();
        }
        com.hoho.android.usb.usb.data_proxy.b bVar2 = this.f11882j;
        if (bVar2 != null) {
            bVar2.a((a.C0135a) null);
        }
        this.f11882j = null;
    }

    public final void f() {
        com.hoho.android.usb.usb.data_proxy.b bVar = this.f11880h;
        if (bVar != null) {
            bVar.a("172.50.10.1", 7878);
        }
        Log.i(this.f11877e, "connectCameraTcp: =====");
    }

    public final void g() {
        com.hoho.android.usb.usb.data_proxy.b bVar = this.f11880h;
        if (bVar != null) {
            bVar.b();
        }
        com.hoho.android.usb.usb.data_proxy.b bVar2 = this.f11880h;
        if (bVar2 != null) {
            bVar2.a((a.C0135a) null);
        }
        this.f11880h = null;
    }

    public final void h() {
        this.f11883k = "";
        com.hoho.android.usb.usb.data_proxy.b bVar = this.f11879g;
        if (bVar != null) {
            bVar.b();
        }
        com.hoho.android.usb.usb.data_proxy.b bVar2 = this.f11879g;
        if (bVar2 != null) {
            bVar2.a((a.C0135a) null);
        }
        this.f11879g = null;
    }

    public final void i() {
        j();
        com.hoho.android.usb.usb.data_proxy.d dVar = this.P;
        if (dVar != null) {
            dVar.a(2, 9898);
        }
    }

    public final void j() {
        com.hoho.android.usb.usb.data_proxy.c cVar = this.f11878f;
        if (cVar != null) {
            cVar.b();
        }
        com.hoho.android.usb.usb.data_proxy.c cVar2 = this.f11878f;
        if (cVar2 != null) {
            cVar2.a((a.C0135a) null);
        }
        this.f11878f = null;
    }

    public final void k() {
        com.hoho.android.usb.usb.data_proxy.b bVar;
        byte[] bArr;
        String a2;
        String str = this.f11883k;
        if (str != null) {
            CharSequence charSequence = str;
            if (!(charSequence == null || charSequence.length() == 0) && (bVar = this.f11879g) != null) {
                if (bVar == null || (a2 = bVar.a(CameraGlobal.amba_rtsp_url, "", this.f11883k, "")) == null) {
                    bArr = null;
                } else {
                    Charset charset = kotlin.text.d.f30261a;
                    Objects.requireNonNull(a2, "null cannot be cast to non-null type java.lang.String");
                    bArr = a2.getBytes(charset);
                    kotlin.jvm.internal.h.b(bArr, "(this as java.lang.String).getBytes(charset)");
                }
                bVar.a(bArr);
            }
        }
        Handler handler = this.A;
        if (handler != null) {
            handler.removeCallbacks(this.O);
        }
        Handler handler2 = this.A;
        if (handler2 != null) {
            handler2.postDelayed(this.O, 10000);
        }
    }

    public final void l() {
        if (this.A == null) {
            this.A = new Handler(Looper.getMainLooper());
        }
        Handler handler = this.A;
        if (handler != null) {
            handler.removeCallbacks(this.O);
        }
        Handler handler2 = this.A;
        if (handler2 != null) {
            handler2.postDelayed(this.O, 10000);
        }
    }

    public final void m() {
        Handler handler = this.A;
        if (handler != null) {
            handler.removeCallbacks(this.O);
        }
        this.A = null;
    }

    public final void n() {
        Log.i(this.f11877e, "createDroneUdp: ======");
        o();
        com.hoho.android.usb.usb.data_proxy.d dVar = this.P;
        if (dVar != null) {
            dVar.a(2, 10001);
        }
    }

    public final void o() {
        Log.i(this.f11877e, "setStatus:=====closeDroneUdp: ");
        com.hoho.android.usb.usb.data_proxy.c cVar = this.f11881i;
        if (cVar != null) {
            cVar.b();
        }
        com.hoho.android.usb.usb.data_proxy.c cVar2 = this.f11881i;
        if (cVar2 != null) {
            cVar2.a((a.C0135a) null);
        }
        this.f11881i = null;
    }
}
