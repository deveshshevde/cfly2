package com.xeagle.android.newUI.cameraManager;

import android.content.Context;
import android.util.Log;
import ch.a;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.util.e;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.login.amba.connectivity.DataChannel;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import com.xeagle.android.login.amba.connectivity.UsbDataChannel;
import com.xeagle.android.login.common.TimeUtil;
import io.reactivex.disposables.b;
import io.reactivex.f;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import lv.d;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;
import org.json.JSONException;
import org.json.JSONObject;

public class AmbaClient extends a implements IChannelListener {

    /* renamed from: a  reason: collision with root package name */
    protected static int f12692a;

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f12693c = Pattern.compile("\\d+");

    /* renamed from: q  reason: collision with root package name */
    private static final String[] f12694q = {"OK", "UNKNOW(-1)", "INVALID_ERROR(-2)", "SESSION_START_FAIL(-3)", "INVALID_SESSION(-4)", "REACH_MAX_CLIENT(-5)", "INVALID_ERROR(-6)", "JSON_PACKAGE_ERROR(-7)", "JSON_PACKAGE_TIMEOUT(-8)", "JSON_SYNTAX_ERROR(-9)", "INVALID_ERROR(-10)", "INVALID_ERROR(-11)", "INVALID_ERROR(-12)", "INVALID_OPTION_VALUE(-13)", "INVALID_OPERATION(-14)", "INVALID_ERROR(-15)", "HDMI_INSERTED(-16)", "NO_MORE_SPACE(-17)", "CARD_PROTECTED(-18)", "NO_MORE_MEMORY(-19)", "PIV_NOT_ALLOWED(-20)", "SYSTEM_BUSY(-21)", "APP_NOT_READY(-22)", "OPERATION_UNSUPPORTED(-23)", "INVALID_TYPE(-24)", "INVALID_PARAM(-25)", "INVALID_PATH(-26)"};

    /* renamed from: t  reason: collision with root package name */
    private static AmbaClient f12695t;
    private DataChannel A;
    private UsbDataChannel B;
    private DroneInterfaces.b C;
    private long D = 0;
    private long E = 0;
    private LinkedBlockingQueue<String> F = new LinkedBlockingQueue<>();
    private IChannelListener G;
    private Runnable H = new Runnable() {
        public void run() {
            AmbaClient.this.s();
        }
    };
    private b I;
    private boolean J = false;
    private b K;
    private boolean L = false;
    private boolean M = false;
    private boolean N = false;
    private b O;

    /* renamed from: b  reason: collision with root package name */
    Runnable f12696b = new Runnable() {
        public final void run() {
            AmbaClient.this.c();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private Socket f12697d;

    /* renamed from: e  reason: collision with root package name */
    private BufferedInputStream f12698e;

    /* renamed from: f  reason: collision with root package name */
    private BufferedOutputStream f12699f;

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f12700g = new byte[1024];

    /* renamed from: h  reason: collision with root package name */
    private Socket f12701h;

    /* renamed from: i  reason: collision with root package name */
    private String f12702i;

    /* renamed from: j  reason: collision with root package name */
    private int f12703j;

    /* renamed from: k  reason: collision with root package name */
    private String f12704k;

    /* renamed from: l  reason: collision with root package name */
    private int f12705l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f12706m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f12707n;

    /* renamed from: o  reason: collision with root package name */
    private final Object f12708o = new Object();

    /* renamed from: p  reason: collision with root package name */
    private boolean f12709p;

    /* renamed from: r  reason: collision with root package name */
    private Context f12710r;

    /* renamed from: s  reason: collision with root package name */
    private XEagleApp f12711s;

    /* renamed from: u  reason: collision with root package name */
    private String f12712u;

    /* renamed from: v  reason: collision with root package name */
    private String f12713v;

    /* renamed from: w  reason: collision with root package name */
    private String f12714w;

    /* renamed from: x  reason: collision with root package name */
    private String f12715x;

    /* renamed from: y  reason: collision with root package name */
    private int f12716y;

    /* renamed from: z  reason: collision with root package name */
    private String f12717z;

    public enum UpgradeDroneState {
        NOTIFY_DATA_TRAN_START(0, "NOTIFY_DATA_TRAN_START"),
        NOTIFY_DATA_TRAN_RESTART(1, "NOTIFY_DATA_TRAN_RESTART"),
        NOTIFY_DATA_TRAN_RUNNING(2, "NOTIFY_DATA_TRAN_RUNNING"),
        NOTIFY_DATA_TRAN_DONE(3, "NOTIFY_DATA_TRAN_DONE"),
        NOTIFY_DATA_TRAN_ABORT(4, "NOTIFY_DATA_TRAN_ABORT"),
        NOTIFY_DATA_TRAN_PKT_HEAD_ERR(5, "NOTIFY_DATA_TRAN_PKT_HEAD_ERR"),
        NOTIFY_DATA_TRAN_PKT_TAIL_ERR(6, "NOTIFY_DATA_TRAN_PKT_TAIL_ERR"),
        NOTIFY_DATA_TRAN_PKT_VARIFY_ERR(7, "NOTIFY_DATA_TRAN_PKT_TAIL_ERR"),
        NOTIFY_DATA_TRAN_ERR(8, "NOTIFY_DATA_TRAN_ERR"),
        NOTIFY_DATA_PROG_ERR(9, "NOTIFY_DATA_PROG_ERR"),
        NOTIFY_SAME_CODE_ERR(10, "NOTIFY_SAME_CODE_ERR"),
        NOTIFY_TRAN_RESTART_ERR(11, "NOTIFY_TRAN_RESTART_ERR"),
        NOTIFY_MCU_IN_BOOT(12, "NOTIFY_MCU_IN_BOOT"),
        NOTIFY_FW_CHECKSUM_ERR(13, "NOTIFY_FW_CHECKSUM_ERR"),
        NOTIFY_FW_NOT_FOUND(14, "NOTIFY_FW_NOT_FOUND");
        

        /* renamed from: p  reason: collision with root package name */
        private final int f23959p;

        /* renamed from: q  reason: collision with root package name */
        private final String f23960q;

        private UpgradeDroneState(int i2, String str) {
            this.f23959p = i2;
            this.f23960q = str;
        }

        public int a() {
            return this.f23959p;
        }
    }

    public AmbaClient(Context context, DroneInterfaces.b bVar, IChannelListener iChannelListener) {
        this.f12710r = context.getApplicationContext();
        this.f12711s = (XEagleApp) context.getApplicationContext();
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
        this.f12706m = false;
        this.f12707n = true;
        this.C = bVar;
        a(iChannelListener);
    }

    private void B() {
        if (!this.f12711s.c()) {
            Socket socket = new Socket();
            this.f12701h = socket;
            try {
                socket.connect(new InetSocketAddress(this.f12702i, this.f12703j), 20000);
                this.f12701h.setSoTimeout(1000);
                if (this.A == null) {
                    this.A = new DataChannel(this);
                    UsbDataChannel usbDataChannel = this.B;
                    if (usbDataChannel != null) {
                        usbDataChannel.unRegisterEventbus();
                        this.B = null;
                    }
                }
                this.A.setStream(this.f12701h.getInputStream(), this.f12701h.getOutputStream());
            } catch (IOException e2) {
                e2.printStackTrace();
                String str = "Can't connect to " + this.f12702i + "/" + this.f12703j;
                this.G.onChannelEvent(4, str, new String[0]);
                Log.e("RTSP", "connect error:--- " + str);
            }
        } else if (this.f12711s.f() != null) {
            UsbDataChannel usbDataChannel2 = this.B;
            if (usbDataChannel2 != null) {
                usbDataChannel2.registerEventbus();
                return;
            }
            UsbDataChannel usbDataChannel3 = new UsbDataChannel(this.f12710r, this);
            this.B = usbDataChannel3;
            usbDataChannel3.registerEventbus();
            if (this.A != null) {
                this.A = null;
            }
        }
    }

    public static AmbaClient a(Context context, DroneInterfaces.b bVar, IChannelListener iChannelListener) {
        if (f12695t == null) {
            f12695t = new AmbaClient(context, bVar, iChannelListener);
        }
        return f12695t;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Long l2) throws Exception {
        if (!this.M) {
            z();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, Long l2) throws Exception {
        if (!this.J) {
            b(str);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, Long l2) throws Exception {
        if (!this.N) {
            e(str, str2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Long l2) throws Exception {
        if (!this.L) {
            m();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(Long l2) throws Exception {
        String a2 = kw.c.a(TimeUtil.DEF_FORMAT, System.currentTimeMillis());
        a("\"type\":\"camera_clock\",\"param\":\"" + a2 + "\"");
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x03c5  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x03ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void q(java.lang.String r15) {
        /*
            r14 = this;
            java.lang.String r0 = "duration"
            java.lang.String r1 = "thumb_file"
            java.lang.String r2 = "CameraClient"
            java.lang.String r3 = "setStatus"
            r4 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0398 }
            r5.<init>()     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r6 = "handleResponse: ---msg---"
            r5.append(r6)     // Catch:{ JSONException -> 0x0398 }
            r5.append(r15)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x0398 }
            android.util.Log.i(r3, r5)     // Catch:{ JSONException -> 0x0398 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0398 }
            r5.<init>(r15)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r6 = "rval"
            int r6 = r5.getInt(r6)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r7 = "msg_id"
            int r7 = r5.getInt(r7)     // Catch:{ JSONException -> 0x0398 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0398 }
            r8.<init>()     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r9 = "handleResponse: ---error-rval---"
            r8.append(r9)     // Catch:{ JSONException -> 0x0398 }
            r8.append(r6)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r9 = "--msgId---"
            r8.append(r9)     // Catch:{ JSONException -> 0x0398 }
            r8.append(r7)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x0398 }
            android.util.Log.i(r2, r8)     // Catch:{ JSONException -> 0x0398 }
            r8 = -31
            r9 = 0
            if (r6 == r8) goto L_0x038a
            r8 = -4
            java.lang.String r10 = "CmdChannel"
            if (r6 == r8) goto L_0x037b
            r8 = -18
            if (r6 == r8) goto L_0x0371
            r8 = -17
            if (r6 == r8) goto L_0x0367
            r8 = 8
            r11 = 1
            if (r7 == r8) goto L_0x034b
            r12 = 11
            r13 = 9
            if (r7 == r13) goto L_0x0342
            if (r7 == r12) goto L_0x0337
            r12 = 769(0x301, float:1.078E-42)
            if (r7 == r12) goto L_0x032c
            r12 = 1800(0x708, float:2.522E-42)
            if (r7 == r12) goto L_0x0310
            r12 = 1281(0x501, float:1.795E-42)
            if (r7 == r12) goto L_0x0306
            r12 = 1282(0x502, float:1.796E-42)
            if (r7 == r12) goto L_0x02e4
            r10 = 1285(0x505, float:1.8E-42)
            java.lang.String r12 = "size"
            if (r7 == r10) goto L_0x02be
            r10 = 1286(0x506, float:1.802E-42)
            if (r7 == r10) goto L_0x02b0
            java.lang.String r2 = "param"
            java.lang.String r10 = "type"
            switch(r7) {
                case 1: goto L_0x0273;
                case 2: goto L_0x024d;
                case 3: goto L_0x0242;
                case 4: goto L_0x0237;
                case 5: goto L_0x0223;
                case 6: goto L_0x0214;
                default: goto L_0x008a;
            }
        L_0x008a:
            switch(r7) {
                case 13: goto L_0x01f4;
                case 14: goto L_0x01e5;
                case 15: goto L_0x01d6;
                default: goto L_0x008d;
            }
        L_0x008d:
            switch(r7) {
                case 257: goto L_0x018d;
                case 258: goto L_0x0189;
                case 259: goto L_0x0177;
                case 260: goto L_0x015a;
                default: goto L_0x0090;
            }
        L_0x0090:
            switch(r7) {
                case 513: goto L_0x014f;
                case 514: goto L_0x0144;
                case 515: goto L_0x0139;
                default: goto L_0x0093;
            }
        L_0x0093:
            switch(r7) {
                case 1025: goto L_0x012e;
                case 1026: goto L_0x00a7;
                case 1027: goto L_0x0098;
                default: goto L_0x0096;
            }
        L_0x0096:
            goto L_0x0442
        L_0x0098:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 36
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String[] r3 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r2, r3)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x00a7:
            boolean r2 = r5.has(r1)     // Catch:{ JSONException -> 0x0398 }
            if (r2 != 0) goto L_0x00b0
            java.lang.String r1 = ""
            goto L_0x00c5
        L_0x00b0:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0398 }
            r2.<init>()     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r3 = "thumb: "
            r2.append(r3)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r1 = r5.getString(r1)     // Catch:{ JSONException -> 0x0398 }
            r2.append(r1)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r1 = r2.toString()     // Catch:{ JSONException -> 0x0398 }
        L_0x00c5:
            boolean r2 = r5.has(r0)     // Catch:{ JSONException -> 0x0398 }
            if (r2 == 0) goto L_0x00e3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0398 }
            r2.<init>()     // Catch:{ JSONException -> 0x0398 }
            r2.append(r1)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r1 = "\nduration: "
            r2.append(r1)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r0 = r5.getString(r0)     // Catch:{ JSONException -> 0x0398 }
            r2.append(r0)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r1 = r2.toString()     // Catch:{ JSONException -> 0x0398 }
        L_0x00e3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0398 }
            r0.<init>()     // Catch:{ JSONException -> 0x0398 }
            r0.append(r1)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r1 = "\nresolution: "
            r0.append(r1)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r1 = "resolution"
            java.lang.String r1 = r5.getString(r1)     // Catch:{ JSONException -> 0x0398 }
            r0.append(r1)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r1 = "\nsize: "
            r0.append(r1)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r1 = r5.getString(r12)     // Catch:{ JSONException -> 0x0398 }
            r0.append(r1)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r1 = "\ndate: "
            r0.append(r1)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r1 = "date"
            java.lang.String r1 = r5.getString(r1)     // Catch:{ JSONException -> 0x0398 }
            r0.append(r1)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r1 = "\ntype: "
            r0.append(r1)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r1 = "media_type"
            java.lang.String r1 = r5.getString(r1)     // Catch:{ JSONException -> 0x0398 }
            r0.append(r1)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0398 }
            com.xeagle.android.login.amba.connectivity.IChannelListener r1 = r14.G     // Catch:{ JSONException -> 0x0398 }
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r1.onChannelEvent(r8, r0, r2)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x012e:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 37
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x0139:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 21
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x0144:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 53
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r9, r2)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x014f:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 52
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r9, r2)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x015a:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 22
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r9, r2)     // Catch:{ JSONException -> 0x0398 }
            com.flypro.core.drone.DroneInterfaces$b r0 = r14.C     // Catch:{ JSONException -> 0x0398 }
            if (r0 == 0) goto L_0x0442
            java.lang.Runnable r1 = r14.H     // Catch:{ JSONException -> 0x0398 }
            r0.removeCallbacks(r1)     // Catch:{ JSONException -> 0x0398 }
            com.flypro.core.drone.DroneInterfaces$b r0 = r14.C     // Catch:{ JSONException -> 0x0398 }
            java.lang.Runnable r1 = r14.H     // Catch:{ JSONException -> 0x0398 }
            r2 = 3000(0xbb8, double:1.482E-320)
            r0.postDelayed(r1, r2)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x0177:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            java.lang.String[] r1 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r13, r9, r1)     // Catch:{ JSONException -> 0x0398 }
            com.flypro.core.drone.DroneInterfaces$b r0 = r14.C     // Catch:{ JSONException -> 0x0398 }
            if (r0 == 0) goto L_0x0442
            java.lang.Runnable r1 = r14.H     // Catch:{ JSONException -> 0x0398 }
            r0.removeCallbacks(r1)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x0189:
            f12692a = r4     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x018d:
            java.lang.String r0 = r5.getString(r2)     // Catch:{ JSONException -> 0x0398 }
            java.util.regex.Pattern r1 = f12693c     // Catch:{ JSONException -> 0x0398 }
            java.util.regex.Matcher r0 = r1.matcher(r0)     // Catch:{ JSONException -> 0x0398 }
            boolean r1 = r0.find()     // Catch:{ JSONException -> 0x0398 }
            if (r1 == 0) goto L_0x01c2
            java.lang.String r0 = r0.group(r4)     // Catch:{ JSONException -> 0x0398 }
            java.util.Objects.requireNonNull(r0)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x0398 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ JSONException -> 0x0398 }
            f12692a = r0     // Catch:{ JSONException -> 0x0398 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0398 }
            r0.<init>()     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r1 = "mSessionId: "
            r0.append(r1)     // Catch:{ JSONException -> 0x0398 }
            int r1 = f12692a     // Catch:{ JSONException -> 0x0398 }
            r0.append(r1)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0398 }
            android.util.Log.i(r3, r0)     // Catch:{ JSONException -> 0x0398 }
        L_0x01c2:
            r14.g()     // Catch:{ JSONException -> 0x0398 }
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 23
            int r2 = f12692a     // Catch:{ JSONException -> 0x0398 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String[] r3 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r2, r3)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x01d6:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 39
            java.lang.String r2 = r5.getString(r2)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String[] r3 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r2, r3)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x01e5:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 38
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String[] r3 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r2, r3)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x01f4:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 20
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0398 }
            r3.<init>()     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r6 = "Battery Level: "
            r3.append(r6)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r2 = r5.getString(r2)     // Catch:{ JSONException -> 0x0398 }
            r3.append(r2)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r2 = r3.toString()     // Catch:{ JSONException -> 0x0398 }
            java.lang.String[] r3 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r2, r3)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x0214:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 16
            java.lang.String r2 = r5.getString(r2)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String[] r3 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r2, r3)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x0223:
            java.lang.String r0 = "FTP"
            java.lang.String r1 = "handleResponse:===== AMBA_GET_SPACE"
            android.util.Log.i(r0, r1)     // Catch:{ JSONException -> 0x0398 }
            r14.M = r11     // Catch:{ JSONException -> 0x0398 }
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 15
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x0237:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 18
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x0242:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 10
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r15, r2)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x024d:
            java.lang.String r0 = r5.getString(r10)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r1 = "camera_clock"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ JSONException -> 0x0398 }
            if (r0 == 0) goto L_0x0268
            io.reactivex.disposables.b r0 = r14.I     // Catch:{ JSONException -> 0x0398 }
            if (r0 == 0) goto L_0x0268
            boolean r0 = r0.isDisposed()     // Catch:{ JSONException -> 0x0398 }
            if (r0 != 0) goto L_0x0268
            io.reactivex.disposables.b r0 = r14.I     // Catch:{ JSONException -> 0x0398 }
            r0.dispose()     // Catch:{ JSONException -> 0x0398 }
        L_0x0268:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 12
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x0273:
            java.lang.String r0 = "sw_version"
            java.lang.String r1 = r5.getString(r10)     // Catch:{ JSONException -> 0x0398 }
            boolean r0 = r0.equals(r1)     // Catch:{ JSONException -> 0x0398 }
            if (r0 != 0) goto L_0x02a5
            java.lang.String r0 = "hw_version"
            java.lang.String r1 = r5.getString(r10)     // Catch:{ JSONException -> 0x0398 }
            boolean r0 = r0.equals(r1)     // Catch:{ JSONException -> 0x0398 }
            if (r0 == 0) goto L_0x028c
            goto L_0x02a5
        L_0x028c:
            java.lang.String r0 = "Vertical_Rec"
            java.lang.String r1 = r5.getString(r10)     // Catch:{ JSONException -> 0x0398 }
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ JSONException -> 0x0398 }
            if (r0 == 0) goto L_0x029a
            r14.L = r11     // Catch:{ JSONException -> 0x0398 }
        L_0x029a:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 55
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x02a5:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 51
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x02b0:
            java.lang.String r0 = "handleResponse:===put file "
            android.util.Log.i(r2, r0)     // Catch:{ JSONException -> 0x0398 }
            r0 = 19
            java.lang.String[] r1 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r14.onChannelEvent(r0, r9, r1)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x02be:
            java.lang.String r0 = "RTSP"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0398 }
            r1.<init>()     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r2 = "handleResponse: ---file-----"
            r1.append(r2)     // Catch:{ JSONException -> 0x0398 }
            r1.append(r5)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0398 }
            android.util.Log.i(r0, r1)     // Catch:{ JSONException -> 0x0398 }
            int r0 = r5.getInt(r12)     // Catch:{ JSONException -> 0x0398 }
            r1 = 7
            java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r14.onChannelEvent(r1, r0, r2)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x02e4:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0398 }
            r0.<init>()     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r1 = "handleCmdChannelEvent: ----parser---"
            r0.append(r1)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r1 = r5.toString()     // Catch:{ JSONException -> 0x0398 }
            r0.append(r1)     // Catch:{ JSONException -> 0x0398 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0398 }
            android.util.Log.i(r10, r0)     // Catch:{ JSONException -> 0x0398 }
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 5
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x0306:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 6
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r9, r2)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x0310:
            r14.N = r11     // Catch:{ JSONException -> 0x0398 }
            io.reactivex.disposables.b r0 = r14.O     // Catch:{ JSONException -> 0x0398 }
            if (r0 == 0) goto L_0x0321
            boolean r0 = r0.isDisposed()     // Catch:{ JSONException -> 0x0398 }
            if (r0 != 0) goto L_0x0321
            io.reactivex.disposables.b r0 = r14.O     // Catch:{ JSONException -> 0x0398 }
            r0.dispose()     // Catch:{ JSONException -> 0x0398 }
        L_0x0321:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 65
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x032c:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 41
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x0337:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 17
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x0342:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            java.lang.String[] r1 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r12, r5, r1)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x034b:
            r14.J = r11     // Catch:{ JSONException -> 0x0398 }
            io.reactivex.disposables.b r0 = r14.K     // Catch:{ JSONException -> 0x0398 }
            if (r0 == 0) goto L_0x035c
            boolean r0 = r0.isDisposed()     // Catch:{ JSONException -> 0x0398 }
            if (r0 != 0) goto L_0x035c
            io.reactivex.disposables.b r0 = r14.K     // Catch:{ JSONException -> 0x0398 }
            r0.dispose()     // Catch:{ JSONException -> 0x0398 }
        L_0x035c:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 64
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r5, r2)     // Catch:{ JSONException -> 0x0398 }
            goto L_0x0442
        L_0x0367:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 135(0x87, float:1.89E-43)
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r9, r2)     // Catch:{ JSONException -> 0x0398 }
            return
        L_0x0371:
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 136(0x88, float:1.9E-43)
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r9, r2)     // Catch:{ JSONException -> 0x0398 }
            return
        L_0x037b:
            java.lang.String r0 = "handleResponse:=== "
            android.util.Log.i(r10, r0)     // Catch:{ JSONException -> 0x0398 }
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 129(0x81, float:1.81E-43)
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r9, r2)     // Catch:{ JSONException -> 0x0398 }
            return
        L_0x038a:
            r0 = 257(0x101, float:3.6E-43)
            if (r7 != r0) goto L_0x0397
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x0398 }
            r1 = 137(0x89, float:1.92E-43)
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0398 }
            r0.onChannelEvent(r1, r9, r2)     // Catch:{ JSONException -> 0x0398 }
        L_0x0397:
            return
        L_0x0398:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "JSON Error: "
            r1.append(r2)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = "=====msg==="
            r1.append(r0)
            r1.append(r15)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "Client"
            android.util.Log.e(r1, r0)
            java.lang.String r0 = "stop_record"
            boolean r1 = r15.contains(r0)
            r2 = 40
            if (r1 == 0) goto L_0x03ce
            com.xeagle.android.login.amba.connectivity.IChannelListener r15 = r14.G
            java.lang.String[] r1 = new java.lang.String[r4]
            r15.onChannelEvent(r2, r0, r1)
            goto L_0x0442
        L_0x03ce:
            java.lang.String r0 = "remote_video_key_stop"
            boolean r1 = r15.contains(r0)
            if (r1 == 0) goto L_0x03de
            com.xeagle.android.login.amba.connectivity.IChannelListener r15 = r14.G
            java.lang.String[] r1 = new java.lang.String[r4]
            r15.onChannelEvent(r2, r0, r1)
            goto L_0x0442
        L_0x03de:
            java.lang.String r0 = "stop_normal_record"
            boolean r1 = r15.contains(r0)
            if (r1 == 0) goto L_0x03ee
            com.xeagle.android.login.amba.connectivity.IChannelListener r15 = r14.G
            java.lang.String[] r1 = new java.lang.String[r4]
            r15.onChannelEvent(r2, r0, r1)
            goto L_0x0442
        L_0x03ee:
            java.lang.String r0 = "start_normal_record"
            boolean r1 = r15.contains(r0)
            if (r1 == 0) goto L_0x03fe
            com.xeagle.android.login.amba.connectivity.IChannelListener r15 = r14.G
            java.lang.String[] r1 = new java.lang.String[r4]
            r15.onChannelEvent(r2, r0, r1)
            goto L_0x0442
        L_0x03fe:
            java.lang.String r0 = "start_record"
            boolean r1 = r15.contains(r0)
            if (r1 == 0) goto L_0x0415
            java.lang.String r15 = "newUI"
            java.lang.String r1 = "handleResponse: ----start record"
            android.util.Log.e(r15, r1)
            com.xeagle.android.login.amba.connectivity.IChannelListener r15 = r14.G
            java.lang.String[] r1 = new java.lang.String[r4]
            r15.onChannelEvent(r2, r0, r1)
            goto L_0x0442
        L_0x0415:
            java.lang.String r0 = "remote_video_key_start"
            boolean r1 = r15.contains(r0)
            if (r1 == 0) goto L_0x0425
            com.xeagle.android.login.amba.connectivity.IChannelListener r15 = r14.G
            java.lang.String[] r1 = new java.lang.String[r4]
            r15.onChannelEvent(r2, r0, r1)
            goto L_0x0442
        L_0x0425:
            java.lang.String r0 = "\"msg_id\":1801,\"state\":14"
            boolean r15 = r15.contains(r0)
            if (r15 == 0) goto L_0x0442
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ JSONException -> 0x043e }
            java.lang.String r0 = "{\"msg_id\":1801,\"state\":14,\"progress\":0}"
            r15.<init>(r0)     // Catch:{ JSONException -> 0x043e }
            com.xeagle.android.login.amba.connectivity.IChannelListener r0 = r14.G     // Catch:{ JSONException -> 0x043e }
            r1 = 57
            java.lang.String[] r2 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x043e }
            r0.onChannelEvent(r1, r15, r2)     // Catch:{ JSONException -> 0x043e }
            goto L_0x0442
        L_0x043e:
            r15 = move-exception
            r15.printStackTrace()
        L_0x0442:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.newUI.cameraManager.AmbaClient.q(java.lang.String):void");
    }

    private void r(String str) {
        try {
            if (com.xeagle.android.utils.c.a(str, "}") == 1) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getInt("msg_id") == 7) {
                    String string = jSONObject.getString("type");
                    if (!"fw_upgrade_failed".equals(string)) {
                        if (!"fw_upgrade_complete".equals(string)) {
                            Log.e("Client", "unhandled notification " + string + "!!!");
                            this.G.onChannelEvent(40, string, new String[0]);
                            return;
                        }
                    }
                    this.G.onChannelEvent(4, string, new String[0]);
                } else if (jSONObject.getInt("msg_id") == 1793) {
                    this.G.onChannelEvent(54, (Object) null, new String[0]);
                } else if (jSONObject.getInt("msg_id") == 2049) {
                    this.G.onChannelEvent(56, jSONObject, new String[0]);
                } else if (jSONObject.getInt("msg_id") == 1801) {
                    this.G.onChannelEvent(57, jSONObject, new String[0]);
                }
            } else {
                String replace = str.replace("}{", "}|{");
                for (String str2 : replace.split("\\|")) {
                    if (str2.contains("\"msg_id\":7")) {
                        Log.i("newUI", "handleNotification: ----" + str2);
                        this.G.onChannelEvent(40, new JSONObject(str2).get("type"), new String[0]);
                    } else if (replace.contains("\"msg_id\":1801,\"state\":14")) {
                        try {
                            this.G.onChannelEvent(57, new JSONObject("{\"msg_id\":1801,\"state\":14,\"progress\":0}"), new String[0]);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void A() {
        p("total");
        p("free");
    }

    public void a() {
        this.f12712u = "/tmp/SD0/";
        f12692a = 0;
    }

    public void a(IChannelListener iChannelListener) {
        this.G = iChannelListener;
        if (this.f12711s.c()) {
            this.B = new UsbDataChannel(this.f12710r, this);
        } else {
            this.A = new DataChannel(this);
        }
    }

    public boolean a(int i2) {
        return d() && b("DigitalZoom", i2);
    }

    public boolean a(String str) {
        if (d()) {
            if (sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + 2 + "," + str + "}")) {
                return true;
            }
        }
        return false;
    }

    public boolean a(String str, int i2) {
        this.G.onChannelEvent(50, Integer.valueOf(i2), new String[0]);
        this.G.onChannelEvent(49, str, new String[0]);
        if (!d()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{\"token\":");
        sb.append(f12692a);
        sb.append(",\"msg_id\":");
        sb.append(1281);
        sb.append(",\"param\":\"");
        sb.append(str);
        sb.append("\"}");
        return sendCameraMsgByBackground(sb.toString());
    }

    public boolean a(String str, String str2) {
        String str3 = "\"type\":\"" + str + "\",\"param\":\"" + str2 + "\"";
        if (d()) {
            if (sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + 2 + "," + str3 + "}")) {
                return true;
            }
        }
        return false;
    }

    public String b(String str, String str2) {
        return "cfly_msg chanbw\t" + str + "\t" + f12692a + "\t" + str2;
    }

    public void b() {
        a();
    }

    public boolean b(String str) {
        this.J = false;
        Log.i("FTP", "burnFW: =========image file");
        b bVar = this.K;
        if (bVar != null && !bVar.isDisposed()) {
            this.K.dispose();
        }
        this.K = f.a(5, TimeUnit.SECONDS).a(new d(str) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                AmbaClient.this.a(this.f$1, (Long) obj);
            }
        });
        if (!d()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{\"token\":");
        sb.append(f12692a);
        sb.append(",\"msg_id\":");
        sb.append(8);
        sb.append(",\"param\":\"");
        sb.append(str);
        sb.append("\"}");
        return sendCameraMsgByBackground(sb.toString());
    }

    public boolean b(String str, int i2) {
        if (d()) {
            if (sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + 2 + ",\"type\":\"" + str + "\",\"param\":\"" + i2 + "\"}")) {
                return true;
            }
        }
        return false;
    }

    public void c() {
        sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + 6666 + "}");
        this.C.removeCallbacks(this.f12696b);
        this.C.postDelayed(this.f12696b, 5000);
    }

    public boolean c(String str) {
        if (d()) {
            if (sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + 1 + ",\"type\":\"" + str + "\"}")) {
                return true;
            }
        }
        return false;
    }

    public boolean c(String str, String str2) {
        if (d()) {
            if (sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + 2 + ",\"type\":\"" + str + "\",\"param\":\"" + str2 + "\"}")) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public int cameraType() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void connectToTcp() throws IOException {
        if (this.f12711s.c()) {
            this.E = System.currentTimeMillis();
            if (this.f12711s.f() != null) {
                this.f12711s.g();
                if (f12692a <= 0) {
                    this.f12711s.f().c(1);
                }
            } else {
                return;
            }
        } else {
            InetAddress byName = InetAddress.getByName(this.f12704k);
            Socket socket = new Socket();
            this.f12697d = socket;
            socket.connect(new InetSocketAddress(byName, this.f12705l));
            this.f12698e = new BufferedInputStream(this.f12697d.getInputStream());
            this.f12699f = new BufferedOutputStream(this.f12697d.getOutputStream());
        }
        B();
        c();
    }

    public boolean d() {
        if (this.f12706m && f12692a <= 0) {
            if (!this.f12707n) {
                this.G.onChannelEvent(IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN, (Object) null, new String[0]);
                return false;
            }
            e();
        }
        return true;
    }

    public boolean d(String str) {
        return a("Wifi_Channel", str);
    }

    public boolean d(String str, String str2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            byte[] bArr = new byte[4096];
            MessageDigest instance = MessageDigest.getInstance("MD5");
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            int length = digest.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02x", new Object[]{Integer.valueOf(digest[i2] & 255)}));
            }
            String sb2 = sb.toString();
            Log.i("FTP", "startBurnDrone:===MD5=== " + sb2);
            fileInputStream.close();
            return e(str2, sb2);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return false;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return false;
        } catch (IOException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void disconnectTcp() throws IOException {
        if (this.f12711s.c()) {
            UsbDataChannel usbDataChannel = this.B;
            if (usbDataChannel != null) {
                usbDataChannel.unRegisterEventbus();
            }
            if (this.f12711s.f() != null) {
                this.C.removeCallbacks(this.f12696b);
                return;
            }
            return;
        }
        Socket socket = this.f12697d;
        if (socket != null) {
            socket.close();
            this.C.removeCallbacks(this.f12696b);
        }
        Socket socket2 = this.f12701h;
        if (socket2 != null) {
            socket2.close();
        }
    }

    public void e() {
        String str;
        if (!((XEagleApp) this.f12710r).m().d()) {
            e a2 = this.f12711s.a();
            Log.i("CmdChannel", "startSession: ---ip---" + a2.g() + "---mac---" + a.a());
            if (this.f12711s.c()) {
                str = "{\"token\":0,\"msg_id\":257,\"ip\":\"172.50.10.22\",\"mac\":\"" + a.a() + "\"}";
            } else if (a2.g().contains("172.50.10") || a2.g().contains("192.168.10")) {
                str = "{\"token\":0,\"msg_id\":257,\"ip\":\"" + a2.g() + "\",\"mac\":\"" + a.a() + "\"}";
            } else {
                return;
            }
            sendCameraMsgByBackground(str);
            String str2 = this.f12712u;
            if (str2 == null || "/tmp/SD0/".equals(str2)) {
                this.f12712u = "/tmp/SD0/";
            }
        }
    }

    public boolean e(String str) {
        return d() && c("Vertical_Rec", str);
    }

    public boolean e(String str, String str2) {
        Log.i("FTP", "startBurnDroneFirmware:==session== " + f12692a);
        this.N = false;
        b bVar = this.O;
        if (bVar != null && !bVar.isDisposed()) {
            this.O.dispose();
        }
        this.O = f.a(5, TimeUnit.SECONDS).a(new d(str, str2) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void accept(Object obj) {
                AmbaClient.this.a(this.f$1, this.f$2, (Long) obj);
            }
        });
        if (!d()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{\"token\":");
        sb.append(f12692a);
        sb.append(",\"msg_id\":");
        sb.append(1800);
        sb.append(",\"fn\":\"");
        sb.append(str);
        sb.append("\",\"md5\":\"");
        sb.append(str2);
        sb.append("\"}");
        return sendCameraMsgByBackground(sb.toString());
    }

    public boolean f() {
        if (d()) {
            if (sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + 258 + "}")) {
                return true;
            }
        }
        return false;
    }

    public boolean f(String str) {
        return a("SecStream_resolution", str);
    }

    public void g() {
        this.I = f.a(5, TimeUnit.SECONDS).a(new d() {
            public final void accept(Object obj) {
                AmbaClient.this.c((Long) obj);
            }
        });
    }

    public boolean g(String str) {
        return a("SecStream_BitRate", str);
    }

    /* access modifiers changed from: protected */
    public DroneInterfaces.b getMainHandler() {
        return null;
    }

    public boolean h() {
        return a("\"type\":\"Switch_mode\",\"param\":\"nil\"");
    }

    public boolean h(String str) {
        return a("video_timelapse", str);
    }

    /* access modifiers changed from: protected */
    public void handleMsg(String str) {
        if (str != null) {
            if (str.contains("rval")) {
                q(str);
                this.f12709p = true;
                synchronized (this.f12708o) {
                    this.f12708o.notify();
                }
                return;
            }
            this.f12709p = true;
            synchronized (this.f12708o) {
                this.f12708o.notify();
            }
            r(str);
        }
    }

    public boolean i() {
        if (d()) {
            if (sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + 8 + "\"}")) {
                return true;
            }
        }
        return false;
    }

    public boolean i(String str) {
        return a("Metering", str);
    }

    /* access modifiers changed from: protected */
    public boolean isUnbind() {
        return ((XEagleApp) this.f12710r).m().d();
    }

    public String j(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            byte[] bArr = new byte[4096];
            MessageDigest instance = MessageDigest.getInstance("MD5");
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            int length = digest.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02x", new Object[]{Integer.valueOf(digest[i2] & 255)}));
            }
            String sb2 = sb.toString();
            Log.i("FTP", "startBurnDrone:===MD5=== " + sb2);
            fileInputStream.close();
            return sb2;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return null;
        } catch (IOException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public boolean j() {
        return c("Wifi_ChanBW");
    }

    public void k(String str) {
        if (d()) {
            sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + 1287 + ",\"param\":\"" + str + "\"}");
        }
        if (this.f12711s.c()) {
            UsbDataChannel usbDataChannel = this.B;
            if (usbDataChannel != null) {
                usbDataChannel.cancelGetFile();
                return;
            }
            return;
        }
        DataChannel dataChannel = this.A;
        if (dataChannel != null) {
            dataChannel.cancelGetFile();
        }
    }

    public boolean k() {
        return c("Wifi_Channel");
    }

    public boolean l() {
        return c("DigitalZoom");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean l(java.lang.String r5) {
        /*
            r4 = this;
            com.xeagle.android.XEagleApp r0 = r4.f12711s
            boolean r0 = r0.c()
            r1 = 0
            if (r0 == 0) goto L_0x0012
            com.xeagle.android.login.amba.connectivity.UsbDataChannel r0 = r4.B
            if (r0 == 0) goto L_0x001b
            int r0 = r0.cancelPutFile()
            goto L_0x001c
        L_0x0012:
            com.xeagle.android.login.amba.connectivity.DataChannel r0 = r4.A
            if (r0 == 0) goto L_0x001b
            int r0 = r0.cancelPutFile()
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            boolean r2 = r4.d()
            if (r2 == 0) goto L_0x005b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "{\"token\":"
            r2.append(r3)
            int r3 = f12692a
            r2.append(r3)
            java.lang.String r3 = ",\"msg_id\":"
            r2.append(r3)
            r3 = 1287(0x507, float:1.803E-42)
            r2.append(r3)
            java.lang.String r3 = ",\"param\":\""
            r2.append(r3)
            r2.append(r5)
            java.lang.String r5 = "\",\"sent_size\":"
            r2.append(r5)
            r2.append(r0)
            java.lang.String r5 = "}"
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            boolean r5 = r4.sendCameraMsgByBackground(r5)
            if (r5 == 0) goto L_0x005b
            r1 = 1
        L_0x005b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.newUI.cameraManager.AmbaClient.l(java.lang.String):boolean");
    }

    /* access modifiers changed from: protected */
    public void loadIpAndPort() {
        this.f12704k = "172.50.10.1";
        this.f12705l = 7878;
        this.f12702i = "172.50.10.1";
        this.f12703j = 8787;
    }

    public boolean m() {
        this.L = false;
        f.a(5, TimeUnit.SECONDS).a(new d() {
            public final void accept(Object obj) {
                AmbaClient.this.b((Long) obj);
            }
        });
        return c("Vertical_Rec");
    }

    public boolean m(String str) {
        if (d()) {
            if (sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + 2 + ",\"param\":\"Drone-" + str + "\",\"type\":\"wifi_ssid\"}")) {
                return true;
            }
        }
        return false;
    }

    public boolean n() {
        return c("SecStream_FPS");
    }

    public boolean n(String str) {
        Log.i("CmdChannel", "getVersion:==session=== " + f12692a);
        if (d()) {
            if (sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + 1 + ",\"type\":\"" + str + "\"}")) {
                return true;
            }
        }
        return false;
    }

    public boolean o() {
        return c("SecStream_resolution");
    }

    public boolean o(String str) {
        if (d()) {
            if (sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + 4 + ",\"param\":\"" + str + "\"}")) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x021b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onChannelEvent(int r7, java.lang.Object r8, java.lang.String... r9) {
        /*
            r6 = this;
            java.lang.String r9 = "media_folder"
            r0 = 7
            r1 = 0
            java.lang.String r2 = "/"
            if (r7 == r0) goto L_0x01aa
            r0 = 19
            if (r7 == r0) goto L_0x0174
            r0 = 37
            java.lang.String r3 = "rval"
            r4 = 0
            if (r7 == r0) goto L_0x0126
            r0 = 39
            r2 = 1
            if (r7 == r0) goto L_0x0117
            r0 = 16
            if (r7 == r0) goto L_0x00c6
            r0 = 17
            if (r7 == r0) goto L_0x002b
            com.xeagle.android.login.amba.connectivity.IChannelListener r9 = r6.G
            if (r9 == 0) goto L_0x0222
            java.lang.String[] r0 = new java.lang.String[r4]
            r9.onChannelEvent(r7, r8, r0)
            goto L_0x0222
        L_0x002b:
            org.json.JSONObject r8 = (org.json.JSONObject) r8     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r0 = r6.f12712u     // Catch:{ JSONException -> 0x00c0 }
            if (r0 != 0) goto L_0x006f
            boolean r7 = r8.has(r9)     // Catch:{ JSONException -> 0x00c0 }
            if (r7 == 0) goto L_0x0052
            java.lang.String r7 = r8.getString(r9)     // Catch:{ JSONException -> 0x00c0 }
            int r8 = r7.length()     // Catch:{ JSONException -> 0x00c0 }
            int r8 = r8 - r2
            java.lang.String r7 = r7.substring(r4, r8)     // Catch:{ JSONException -> 0x00c0 }
            r8 = 47
            int r8 = r7.lastIndexOf(r8)     // Catch:{ JSONException -> 0x00c0 }
            int r8 = r8 + r2
            java.lang.String r7 = r7.substring(r4, r8)     // Catch:{ JSONException -> 0x00c0 }
        L_0x004f:
            r6.f12712u = r7     // Catch:{ JSONException -> 0x00c0 }
            goto L_0x0055
        L_0x0052:
            java.lang.String r7 = "/tmp/fuse_d/"
            goto L_0x004f
        L_0x0055:
            java.lang.String r7 = "CmdChannel"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00c0 }
            r8.<init>()     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r9 = "SD directory: "
            r8.append(r9)     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r9 = r6.f12712u     // Catch:{ JSONException -> 0x00c0 }
            r8.append(r9)     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x00c0 }
            android.util.Log.e(r7, r8)     // Catch:{ JSONException -> 0x00c0 }
            goto L_0x0222
        L_0x006f:
            java.util.Iterator r9 = r8.keys()     // Catch:{ JSONException -> 0x00c0 }
        L_0x0073:
            boolean r0 = r9.hasNext()     // Catch:{ JSONException -> 0x00c0 }
            if (r0 == 0) goto L_0x00b3
            java.lang.Object r0 = r9.next()     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x00c0 }
            boolean r2 = r3.equals(r0)     // Catch:{ JSONException -> 0x00c0 }
            if (r2 != 0) goto L_0x0073
            java.lang.String r2 = "msg_id"
            boolean r2 = r2.equals(r0)     // Catch:{ JSONException -> 0x00c0 }
            if (r2 == 0) goto L_0x008e
            goto L_0x0073
        L_0x008e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00c0 }
            r2.<init>()     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r5 = r6.f12717z     // Catch:{ JSONException -> 0x00c0 }
            r2.append(r5)     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r5 = "\n"
            r2.append(r5)     // Catch:{ JSONException -> 0x00c0 }
            r2.append(r0)     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r5 = ": "
            r2.append(r5)     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r0 = r8.getString(r0)     // Catch:{ JSONException -> 0x00c0 }
            r2.append(r0)     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r0 = r2.toString()     // Catch:{ JSONException -> 0x00c0 }
            r6.f12717z = r0     // Catch:{ JSONException -> 0x00c0 }
            goto L_0x0073
        L_0x00b3:
            com.xeagle.android.login.amba.connectivity.IChannelListener r8 = r6.G     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r9 = r6.f12717z     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String[] r0 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x00c0 }
            r8.onChannelEvent(r7, r9, r0)     // Catch:{ JSONException -> 0x00c0 }
            r6.f12717z = r1     // Catch:{ JSONException -> 0x00c0 }
            goto L_0x0222
        L_0x00c0:
            r7 = move-exception
            r7.printStackTrace()
            goto L_0x0222
        L_0x00c6:
            int r7 = r6.f12716y
            int r7 = r7 + r2
            r6.f12716y = r7
            if (r7 != r2) goto L_0x00e3
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = r6.f12717z
            r7.append(r9)
            java.lang.String r9 = "\nPhoto Files: "
        L_0x00d9:
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            r6.f12717z = r7
            goto L_0x0100
        L_0x00e3:
            r9 = 2
            if (r7 != r9) goto L_0x00f3
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = r6.f12717z
            r7.append(r9)
            java.lang.String r9 = "\nVideo Files: "
            goto L_0x00d9
        L_0x00f3:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = r6.f12717z
            r7.append(r9)
            java.lang.String r9 = "\nTotal Files: "
            goto L_0x00d9
        L_0x0100:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = r6.f12717z
            r7.append(r9)
            java.lang.String r8 = (java.lang.String) r8
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.f12717z = r7
            goto L_0x0222
        L_0x0117:
            com.xeagle.android.login.amba.connectivity.IChannelListener r9 = r6.G
            java.lang.String r0 = r6.f12715x
            java.lang.String[] r1 = new java.lang.String[r2]
            java.lang.String r8 = (java.lang.String) r8
            r1[r4] = r8
            r9.onChannelEvent(r7, r0, r1)
            goto L_0x0222
        L_0x0126:
            org.json.JSONObject r8 = (org.json.JSONObject) r8
            int r7 = r8.getInt(r3)     // Catch:{ JSONException -> 0x00c0 }
            if (r7 == 0) goto L_0x013a
            com.xeagle.android.login.amba.connectivity.IChannelListener r7 = r6.G     // Catch:{ JSONException -> 0x00c0 }
            r8 = 4
            java.lang.String r9 = "GET_THUMB failed"
            java.lang.String[] r0 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x00c0 }
            r7.onChannelEvent(r8, r9, r0)     // Catch:{ JSONException -> 0x00c0 }
            goto L_0x0222
        L_0x013a:
            java.lang.String r7 = "size"
            int r7 = r8.getInt(r7)     // Catch:{ JSONException -> 0x00c0 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00c0 }
            r8.<init>()     // Catch:{ JSONException -> 0x00c0 }
            android.content.Context r9 = r6.f12710r     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r9 = kx.d.p(r9)     // Catch:{ JSONException -> 0x00c0 }
            r8.append(r9)     // Catch:{ JSONException -> 0x00c0 }
            r8.append(r2)     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r9 = r6.f12713v     // Catch:{ JSONException -> 0x00c0 }
            r8.append(r9)     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x00c0 }
            com.xeagle.android.XEagleApp r9 = r6.f12711s     // Catch:{ JSONException -> 0x00c0 }
            boolean r9 = r9.c()     // Catch:{ JSONException -> 0x00c0 }
            if (r9 == 0) goto L_0x016b
            com.xeagle.android.login.amba.connectivity.UsbDataChannel r9 = r6.B     // Catch:{ JSONException -> 0x00c0 }
            if (r9 == 0) goto L_0x0222
            r9.getFile(r8, r7)     // Catch:{ JSONException -> 0x00c0 }
            goto L_0x0222
        L_0x016b:
            com.xeagle.android.login.amba.connectivity.DataChannel r9 = r6.A     // Catch:{ JSONException -> 0x00c0 }
            if (r9 == 0) goto L_0x0222
            r9.getFile(r8, r7)     // Catch:{ JSONException -> 0x00c0 }
            goto L_0x0222
        L_0x0174:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "onChannelEvent:----put firmware--- "
            r7.append(r8)
            java.lang.String r8 = r6.f12714w
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "CameraClient"
            android.util.Log.i(r8, r7)
            com.xeagle.android.XEagleApp r7 = r6.f12711s
            boolean r7 = r7.c()
            if (r7 == 0) goto L_0x019f
            com.xeagle.android.login.amba.connectivity.UsbDataChannel r7 = r6.B
            if (r7 == 0) goto L_0x0222
            java.lang.String r8 = r6.f12714w
            r7.putFile(r8)
            goto L_0x0222
        L_0x019f:
            com.xeagle.android.login.amba.connectivity.DataChannel r7 = r6.A
            if (r7 == 0) goto L_0x0222
            java.lang.String r8 = r6.f12714w
            r7.putFile(r8)
            goto L_0x0222
        L_0x01aa:
            java.lang.String r8 = (java.lang.String) r8
            int r7 = java.lang.Integer.parseInt(r8)
            java.lang.String r8 = r6.f12713v
            java.lang.String r9 = "MP4"
            boolean r8 = r8.contains(r9)
            if (r8 == 0) goto L_0x01d5
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            android.content.Context r9 = r6.f12710r
            java.lang.String r9 = kx.d.q(r9)
        L_0x01c5:
            r8.append(r9)
            r8.append(r2)
            java.lang.String r9 = r6.f12713v
            r8.append(r9)
            java.lang.String r1 = r8.toString()
            goto L_0x01eb
        L_0x01d5:
            java.lang.String r8 = r6.f12713v
            java.lang.String r9 = "JPG"
            boolean r8 = r8.contains(r9)
            if (r8 == 0) goto L_0x01eb
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            android.content.Context r9 = r6.f12710r
            java.lang.String r9 = kx.d.s(r9)
            goto L_0x01c5
        L_0x01eb:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "onChannelEvent: --file size----"
            r8.append(r9)
            r8.append(r7)
            java.lang.String r9 = "==fileName=="
            r8.append(r9)
            java.lang.String r9 = r6.f12713v
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "RTSP"
            android.util.Log.i(r9, r8)
            com.xeagle.android.XEagleApp r8 = r6.f12711s
            boolean r8 = r8.c()
            if (r8 == 0) goto L_0x021b
            com.xeagle.android.login.amba.connectivity.UsbDataChannel r8 = r6.B
            if (r8 == 0) goto L_0x0222
            r8.getFile(r1, r7)
            goto L_0x0222
        L_0x021b:
            com.xeagle.android.login.amba.connectivity.DataChannel r8 = r6.A
            if (r8 == 0) goto L_0x0222
            r8.getFile(r1, r7)
        L_0x0222:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.newUI.cameraManager.AmbaClient.onChannelEvent(int, java.lang.Object, java.lang.String[]):void");
    }

    public boolean p() {
        return c("SecStream_BitRate");
    }

    public boolean p(String str) {
        if (d()) {
            if (sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + 5 + ",\"type\":\"" + str + "\"}")) {
                return true;
            }
        }
        return false;
    }

    public boolean q() {
        return c("video_timelapse");
    }

    public boolean r() {
        return c("Metering");
    }

    /* access modifiers changed from: protected */
    public String readFromChannel() {
        if (this.f12711s.c()) {
            try {
                if (System.currentTimeMillis() - this.E > 8000) {
                    reportCommunicationError("camera receive error");
                }
                String take = this.F.take();
                this.E = System.currentTimeMillis();
                return take;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            try {
                BufferedInputStream bufferedInputStream = this.f12698e;
                if (bufferedInputStream == null) {
                    return null;
                }
                return new String(this.f12700g, 0, bufferedInputStream.read(this.f12700g));
            } catch (IOException e3) {
                e3.printStackTrace();
                if (((XEagleApp) this.f12710r).m().d()) {
                    return null;
                }
                reportCommunicationError(e3.getMessage());
                return null;
            } catch (StringIndexOutOfBoundsException unused) {
                return null;
            }
        }
    }

    public boolean s() {
        if (d()) {
            if (sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + 259 + ",\"param\":\"none_force\"}")) {
                return true;
            }
        }
        return false;
    }

    public boolean t() {
        if (d()) {
            if (sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + 260 + "}")) {
                return true;
            }
        }
        return false;
    }

    public boolean u() {
        if (d()) {
            if (sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + IChannelListener.DATA_CHANNEL_EVENT_PUT_START + "}")) {
                return true;
            }
        }
        return false;
    }

    @l(a = ThreadMode.BACKGROUND)
    public void usbTcpRecDataEvent(ha.f fVar) {
        if (fVar.b() == 1) {
            String str = new String(fVar.a());
            if (str.contains("1801")) {
                try {
                    this.G.onChannelEvent(57, new JSONObject(str), new String[0]);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } else {
                if (getConnectionStatus() == 0) {
                    connect(1);
                }
                if (!this.F.offer(str)) {
                    Log.e("RTSP", "recData: 获取失败====" + fVar.a().length);
                }
            }
        }
    }

    public boolean v() {
        if (d()) {
            if (sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + 769 + "}")) {
                return true;
            }
        }
        return false;
    }

    public boolean w() {
        if (d()) {
            if (sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + IChannelListener.DATA_CHANNEL_EVENT_GET_PROGRESS + "}")) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void writeToChannel(byte[] bArr) throws IOException {
        if (!this.f12711s.c()) {
            BufferedOutputStream bufferedOutputStream = this.f12699f;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.write(bArr);
                this.f12699f.flush();
            }
        } else if (this.f12711s.f() != null) {
            Log.i("writeToChannel", "writeToChannel: ");
            this.f12711s.f().c(bArr);
        }
    }

    public boolean x() {
        if (d()) {
            if (sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + IChannelListener.DATA_CHANNEL_EVENT_GET_FINISH + "}")) {
                return true;
            }
        }
        return false;
    }

    public boolean y() {
        if (d()) {
            if (sendCameraMsgByBackground("{\"token\":" + f12692a + ",\"msg_id\":" + 5 + ",\"type\":\"info\"}")) {
                return true;
            }
        }
        return false;
    }

    public boolean z() {
        this.M = false;
        f.a(5, TimeUnit.SECONDS).a(new d() {
            public final void accept(Object obj) {
                AmbaClient.this.a((Long) obj);
            }
        });
        return p("total");
    }
}
