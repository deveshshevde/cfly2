package com.xeagle.android.proxy.updateFirmware;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.utils.w;
import en.a;
import fg.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.zip.CRC32;
import jo.bb;
import kx.b;
import kx.g;
import org.greenrobot.eventbus.c;

public class FirmwareManager implements DroneInterfaces.e {
    private static FirmwareManager B = null;

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ boolean f24228c = true;
    private int A = 0;
    private a C;
    private com.xeagle.android.utils.prefs.a D;
    /* access modifiers changed from: private */
    public boolean E = false;
    private boolean F = false;
    private byte[] G = new byte[0];
    private Runnable H = new Runnable() {
        public void run() {
            UploadParser uploadParser = new UploadParser();
            byte[] bArr = new byte[2048];
            while (!FirmwareManager.this.E) {
                FirmwareManager firmwareManager = FirmwareManager.this;
                FirmwareManager.this.a(uploadParser, firmwareManager.a(bArr, 0, firmwareManager.f24247t, FirmwareManager.this.f24247t.a()), bArr);
            }
        }
    };
    private Runnable I = new Runnable() {
        public void run() {
            while (!FirmwareManager.this.f24253z) {
                FirmwareManager.this.e();
                SystemClock.sleep(1000);
            }
        }
    };
    private int J;
    private int K = -1;
    private int L;
    private int M = -1;
    private String N;
    private int O;
    private int P = -1;
    private int Q = -1;
    private int R = 0;
    private String S;
    private boolean T = false;
    private boolean U = false;
    private int V = -1;
    private int W = 0;
    private int X = 0;
    private int Y = 0;

    /* renamed from: a  reason: collision with root package name */
    public double f24229a = i.f27244a;

    /* renamed from: b  reason: collision with root package name */
    UploadStates f24230b = UploadStates.REBOOT_STATE;

    /* renamed from: d  reason: collision with root package name */
    private int f24231d = 5;

    /* renamed from: e  reason: collision with root package name */
    private int f24232e = 18;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f24233f = 32;

    /* renamed from: g  reason: collision with root package name */
    private int f24234g = 16;

    /* renamed from: h  reason: collision with root package name */
    private int f24235h = 17;

    /* renamed from: i  reason: collision with root package name */
    private int f24236i = 19;

    /* renamed from: j  reason: collision with root package name */
    private int f24237j = 20;

    /* renamed from: k  reason: collision with root package name */
    private int f24238k = 64;

    /* renamed from: l  reason: collision with root package name */
    private int f24239l = 255;

    /* renamed from: m  reason: collision with root package name */
    private int f24240m = 1;

    /* renamed from: n  reason: collision with root package name */
    private int f24241n = 2;

    /* renamed from: o  reason: collision with root package name */
    private int f24242o = 3;

    /* renamed from: p  reason: collision with root package name */
    private int f24243p = 4;

    /* renamed from: q  reason: collision with root package name */
    private int f24244q = 5;

    /* renamed from: r  reason: collision with root package name */
    private Context f24245r;

    /* renamed from: s  reason: collision with root package name */
    private ArrayList<byte[]> f24246s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public b f24247t = new b(1024);

    /* renamed from: u  reason: collision with root package name */
    private w f24248u;

    /* renamed from: v  reason: collision with root package name */
    private int f24249v = 10;

    /* renamed from: w  reason: collision with root package name */
    private int f24250w = 0;

    /* renamed from: x  reason: collision with root package name */
    private String f24251x = "";

    /* renamed from: y  reason: collision with root package name */
    private Thread f24252y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public boolean f24253z = false;

    /* renamed from: com.xeagle.android.proxy.updateFirmware.FirmwareManager$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24258a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates[] r0 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.UploadStates.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24258a = r0
                com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates r1 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.UploadStates.SYNC_REQUEST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24258a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates r1 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.UploadStates.GET_FIRMWARE_VERSION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f24258a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates r1 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.UploadStates.GET_FIRMWARE_SIZE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f24258a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates r1 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.UploadStates.CRC_FIRST     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f24258a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates r1 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.UploadStates.ERASE_UPDATE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f24258a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates r1 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.UploadStates.UPLOADING_FIRMWARE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f24258a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates r1 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.UploadStates.CRC_LAST     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f24258a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates r1 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.UploadStates.PROTO_BOOT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f24258a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates r1 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.UploadStates.START_UPLOAD     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.proxy.updateFirmware.FirmwareManager.AnonymousClass4.<clinit>():void");
        }
    }

    enum UploadStates {
        REBOOT_STATE,
        SYNC_REQUEST,
        SYNC_ERROR,
        GET_FIRMWARE_VERSION,
        GET_FIRMWARE_SIZE,
        CRC_FIRST,
        ERASE_UPDATE,
        START_UPLOAD,
        UPLOADING_FIRMWARE,
        UPLOAD_ERROR,
        CRC_LAST,
        PROTO_BOOT
    }

    public FirmwareManager(Context context, a aVar) {
        this.f24245r = context;
        w wVar = new w(this);
        this.f24248u = wVar;
        wVar.a(this.f24249v);
        Log.i("UPLOAD", "FirmwareManager: ---->>>>init");
        c();
        SystemClock.sleep(100);
        a(aVar);
    }

    /* access modifiers changed from: private */
    public int a(byte[] bArr, int i2, b bVar, int i3) {
        Objects.requireNonNull(bArr);
        if (i2 < 0 || i3 < 0 || i3 > bArr.length - i2) {
            Log.e("google", "error: offset-->" + i2 + "---len-->" + i3 + "---buffer:" + bArr.length);
        } else if (i3 == 0) {
            return 0;
        }
        int b2 = bVar.b();
        if (b2 == -1) {
            return -1;
        }
        bArr[i2] = (byte) b2;
        int i4 = 1;
        while (i4 < i3) {
            int b3 = bVar.b();
            if (b3 == -1) {
                break;
            }
            bArr[i2 + i4] = (byte) b3;
            i4++;
        }
        return i4;
    }

    private long a(int i2) {
        byte[] bArr = this.G;
        int length = bArr.length + 1024;
        byte[] bArr2 = new byte[length];
        double d2 = (double) length;
        this.f24229a = d2;
        if (d2 > ((double) i2)) {
            return -1;
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        for (int length2 = this.G.length; length2 < length; length2++) {
            bArr2[length2] = -1;
        }
        ArrayList<byte[]> a2 = g.a(bArr2, 96);
        ArrayList<byte[]> arrayList = this.f24246s;
        if (arrayList != null) {
            arrayList.clear();
            this.f24246s.addAll(a2);
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr2, 0, bArr3, 0, this.G.length);
        for (int length3 = this.G.length; length3 < i2; length3++) {
            bArr3[length3] = -1;
        }
        CRC32 crc32 = new CRC32();
        crc32.update(bArr3, 0, i2);
        int value = (int) crc32.getValue();
        Log.i("UPLOAD", "crc32Firmware: hex crc value..." + Integer.toHexString(value));
        return (long) value;
    }

    public static FirmwareManager a(Context context, a aVar) {
        if (B == null) {
            Log.i("UPLOAD", "getInstance: ------");
            B = new FirmwareManager(context, aVar);
        }
        return B;
    }

    private UploadPacket a(int i2, byte[] bArr) {
        UploadPacket uploadPacket = new UploadPacket();
        uploadPacket.f24282a = bArr.length;
        uploadPacket.f24283b = i2;
        for (byte b2 : bArr) {
            uploadPacket.f24286e.b(b2);
        }
        return uploadPacket;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0415, code lost:
        r0.f24248u.a(1200);
        r0.f24248u.c();
        g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x04af, code lost:
        r0.f24248u.a(1200);
        r0.f24248u.c();
        e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0534, code lost:
        r0.f24248u.a(1200);
        r0.f24248u.c();
        f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x060e, code lost:
        r3.append("handleData: getFirmwareSize-->>>error:");
        r4 = r0.J;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0613, code lost:
        r3.append(r4);
        r3 = r3.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x061a, code lost:
        android.util.Log.i("UPLOAD", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x012a, code lost:
        r0.f24248u.a(1200);
        r0.f24248u.c();
        i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0183, code lost:
        r3.d(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0273, code lost:
        r3.append("length progress:");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0276, code lost:
        r4 = r0.A;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x035c, code lost:
        r0.f24248u.a(20000);
        r0.f24248u.c();
        h();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.xeagle.android.proxy.updateFirmware.UploadParser r18, int r19, byte[] r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            r2 = 1
            if (r1 >= r2) goto L_0x0008
            return
        L_0x0008:
            r3 = 0
            r4 = 0
        L_0x000a:
            if (r4 >= r1) goto L_0x06a6
            byte r5 = r20[r4]
            r6 = 255(0xff, float:3.57E-43)
            r5 = r5 & r6
            r7 = r18
            com.xeagle.android.proxy.updateFirmware.UploadPacket r5 = r7.a(r5)
            if (r5 == 0) goto L_0x069e
            com.xeagle.android.proxy.updateFirmware.UploadMessage r8 = r5.e()
            int r5 = r5.f24282a
            java.lang.String r9 = "...status..."
            r10 = 4
            r11 = 2
            java.lang.String r12 = "UPLOAD"
            if (r5 == 0) goto L_0x00ab
            if (r5 == r11) goto L_0x0066
            if (r5 == r10) goto L_0x002d
            goto L_0x00d7
        L_0x002d:
            com.xeagle.android.proxy.updateFirmware.RecIntAckMsg r8 = (com.xeagle.android.proxy.updateFirmware.RecIntAckMsg) r8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r13 = "handleData: ack count:-->>>"
            r5.append(r13)
            byte r13 = r8.f24273b
            r13 = r13 & r6
            r5.append(r13)
            r5.append(r9)
            byte r9 = r8.f24275d
            r5.append(r9)
            java.lang.String r9 = "...data_info..."
            r5.append(r9)
            int r9 = r8.f24276e
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            android.util.Log.i(r12, r5)
            byte r5 = r8.f24273b
            r5 = r5 & r6
            r0.O = r5
            byte r5 = r8.f24275d
            r0.P = r5
            int r5 = r8.f24276e
            r0.Q = r5
            goto L_0x00d7
        L_0x0066:
            com.xeagle.android.proxy.updateFirmware.BootloaderAckMsg r8 = (com.xeagle.android.proxy.updateFirmware.BootloaderAckMsg) r8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r9 = "handleData:boot count:-->>>"
            r5.append(r9)
            byte r9 = r8.f24220b
            r9 = r9 & r6
            r5.append(r9)
            java.lang.String r9 = "..status..."
            r5.append(r9)
            byte r9 = r8.f24222d
            r5.append(r9)
            java.lang.String r9 = "...data..."
            r5.append(r9)
            byte[] r9 = r8.f24223e
            java.lang.String r9 = com.flypro.core.util.d.a((byte[]) r9)
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            android.util.Log.i(r12, r5)
            byte r5 = r8.f24220b
            r5 = r5 & r6
            r0.L = r5
            byte r5 = r8.f24222d
            r0.M = r5
            byte[] r5 = r8.f24223e
            java.lang.String r5 = com.flypro.core.util.d.a((byte[]) r5)
            r0.N = r5
            r0.T = r2
            goto L_0x00d7
        L_0x00ab:
            com.xeagle.android.proxy.updateFirmware.DataAckMsg r8 = (com.xeagle.android.proxy.updateFirmware.DataAckMsg) r8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r13 = "handleData: data-->>>"
            r5.append(r13)
            byte r13 = r8.f24225b
            r13 = r13 & r6
            r5.append(r13)
            r5.append(r9)
            byte r9 = r8.f24227d
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            android.util.Log.i(r12, r5)
            byte r5 = r8.f24225b
            r5 = r5 & r6
            r0.J = r5
            byte r5 = r8.f24227d
            r0.K = r5
            r0.U = r2
        L_0x00d7:
            boolean r5 = r0.T
            if (r5 == 0) goto L_0x069e
            r0.T = r3
            boolean r5 = r0.U
            if (r5 == 0) goto L_0x069e
            r0.U = r3
            com.xeagle.android.utils.w r5 = r0.f24248u
            r5.b()
            int[] r5 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.AnonymousClass4.f24258a
            com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates r8 = r0.f24230b
            int r8 = r8.ordinal()
            r5 = r5[r8]
            java.lang.String r8 = "\t\t"
            java.lang.String r9 = "handleData: crc compare"
            java.lang.String r15 = "length progress:"
            java.lang.String r13 = "1210"
            java.lang.String r14 = "handleData: getFirmwareSize-->>>error:"
            java.lang.String r10 = "handleData: getFirmwareSize-->>>"
            r16 = r4
            r3 = 1200(0x4b0, double:5.93E-321)
            switch(r5) {
                case 1: goto L_0x061f;
                case 2: goto L_0x0513;
                case 3: goto L_0x048e;
                case 4: goto L_0x03f4;
                case 5: goto L_0x033b;
                case 6: goto L_0x0226;
                case 7: goto L_0x019e;
                case 8: goto L_0x0107;
                default: goto L_0x0105;
            }
        L_0x0105:
            goto L_0x06a0
        L_0x0107:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r10)
            int r8 = r0.W
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            android.util.Log.i(r12, r5)
            int r5 = r0.J
            int r8 = r0.W
            if (r5 != r8) goto L_0x0188
            int r5 = r0.K
            if (r5 == r2) goto L_0x0139
            if (r5 != r11) goto L_0x0128
            goto L_0x0139
        L_0x0128:
            r0.F = r2
        L_0x012a:
            com.xeagle.android.utils.w r5 = r0.f24248u
            r5.a((long) r3)
            com.xeagle.android.utils.w r3 = r0.f24248u
            r3.c()
            r17.i()
            goto L_0x06a0
        L_0x0139:
            boolean r5 = f24228c
            if (r5 != 0) goto L_0x0148
            java.lang.String r5 = r0.N
            if (r5 == 0) goto L_0x0142
            goto L_0x0148
        L_0x0142:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x0148:
            int r5 = r0.M
            if (r5 != 0) goto L_0x0128
            java.lang.String r5 = r0.N
            boolean r5 = r5.equalsIgnoreCase(r13)
            if (r5 == 0) goto L_0x0128
            int r3 = r0.Q
            r0.V = r3
            int r3 = r0.W
            r0.Y = r3
            int r3 = r3 + r2
            r0.W = r3
            if (r3 <= r6) goto L_0x0163
            r0.W = r2
        L_0x0163:
            java.lang.String r3 = "handleData: --->>>complete"
            android.util.Log.i(r12, r3)
            com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates r3 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.UploadStates.SYNC_REQUEST
            r0.f24230b = r3
            boolean r3 = r0.F
            if (r3 == 0) goto L_0x06a0
            com.xeagle.android.utils.prefs.a r3 = r0.D
            r4 = 0
            r3.i((boolean) r4)
            r0.E = r2
            org.greenrobot.eventbus.c r3 = org.greenrobot.eventbus.c.a()
            jo.bb r4 = new jo.bb
            r5 = 115(0x73, float:1.61E-43)
            r4.<init>(r5, r2)
        L_0x0183:
            r3.d(r4)
            goto L_0x06a0
        L_0x0188:
            org.greenrobot.eventbus.c r3 = org.greenrobot.eventbus.c.a()
            jo.bb r4 = new jo.bb
            r5 = 117(0x75, float:1.64E-43)
            r6 = 0
            r4.<init>(r5, r6)
            r3.d(r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x060e
        L_0x019e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r10)
            int r10 = r0.W
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            android.util.Log.i(r12, r5)
            int r5 = r0.J
            int r10 = r0.W
            if (r5 != r10) goto L_0x0210
            int r5 = r0.K
            if (r5 == r2) goto L_0x01be
            if (r5 != r11) goto L_0x0415
        L_0x01be:
            boolean r5 = f24228c
            if (r5 != 0) goto L_0x01cd
            java.lang.String r5 = r0.N
            if (r5 == 0) goto L_0x01c7
            goto L_0x01cd
        L_0x01c7:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x01cd:
            int r5 = r0.M
            if (r5 != 0) goto L_0x0415
            java.lang.String r5 = r0.N
            boolean r5 = r5.equalsIgnoreCase(r13)
            if (r5 == 0) goto L_0x0415
            int r5 = r0.Q
            r0.V = r5
            int r5 = r0.W
            r0.Y = r5
            int r5 = r5 + r2
            r0.W = r5
            if (r5 <= r6) goto L_0x01e8
            r0.W = r2
        L_0x01e8:
            int r5 = r0.R
            long r5 = r0.a((int) r5)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r9)
            int r9 = r0.V
            r10.append(r9)
            r10.append(r8)
            r10.append(r5)
            java.lang.String r5 = r10.toString()
            android.util.Log.i(r12, r5)
            r0.F = r2
            com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates r5 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.UploadStates.PROTO_BOOT
            r0.f24230b = r5
            goto L_0x012a
        L_0x0210:
            org.greenrobot.eventbus.c r3 = org.greenrobot.eventbus.c.a()
            jo.bb r4 = new jo.bb
            r5 = 117(0x75, float:1.64E-43)
            r6 = 0
            r4.<init>(r5, r6)
            r3.d(r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x060e
        L_0x0226:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r10)
            int r8 = r0.W
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            android.util.Log.i(r12, r5)
            int r5 = r0.J
            int r8 = r0.W
            if (r5 != r8) goto L_0x0325
            int r5 = r0.K
            if (r5 == r2) goto L_0x027a
            if (r5 != r11) goto L_0x0247
            goto L_0x027a
        L_0x0247:
            com.xeagle.android.utils.w r5 = r0.f24248u
            r5.a((long) r3)
            com.xeagle.android.utils.w r3 = r0.f24248u
            r3.c()
            java.util.ArrayList<byte[]> r3 = r0.f24246s
            int r4 = r0.A
            java.lang.Object r3 = r3.get(r4)
            byte[] r3 = (byte[]) r3
            r0.b((byte[]) r3)
            org.greenrobot.eventbus.c r3 = org.greenrobot.eventbus.c.a()
            jo.bb r4 = new jo.bb
            int r5 = r0.A
            r6 = 114(0x72, float:1.6E-43)
            r4.<init>(r6, r5)
            r3.d(r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x0273:
            r3.append(r15)
        L_0x0276:
            int r4 = r0.A
            goto L_0x0613
        L_0x027a:
            boolean r5 = f24228c
            if (r5 != 0) goto L_0x0289
            java.lang.String r5 = r0.N
            if (r5 == 0) goto L_0x0283
            goto L_0x0289
        L_0x0283:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x0289:
            int r5 = r0.M
            if (r5 != 0) goto L_0x02f7
            java.lang.String r5 = r0.N
            boolean r5 = r5.equalsIgnoreCase(r13)
            if (r5 == 0) goto L_0x02f7
            int r5 = r0.A
            int r5 = r5 + r2
            r0.A = r5
            int r8 = r0.W
            r0.Y = r8
            int r8 = r8 + r2
            r0.W = r8
            if (r8 <= r6) goto L_0x02a5
            r0.W = r2
        L_0x02a5:
            java.util.ArrayList<byte[]> r6 = r0.f24246s
            int r6 = r6.size()
            if (r5 != r6) goto L_0x02c9
            com.xeagle.android.utils.w r5 = r0.f24248u
            r5.a((long) r3)
            com.xeagle.android.utils.w r3 = r0.f24248u
            r3.c()
            com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates r3 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.UploadStates.CRC_LAST
            r0.f24230b = r3
            r17.g()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "length progress complete:"
            r3.append(r4)
            goto L_0x0276
        L_0x02c9:
            com.xeagle.android.utils.w r5 = r0.f24248u
            r5.a((long) r3)
            com.xeagle.android.utils.w r3 = r0.f24248u
            r3.c()
            java.util.ArrayList<byte[]> r3 = r0.f24246s
            int r4 = r0.A
            java.lang.Object r3 = r3.get(r4)
            byte[] r3 = (byte[]) r3
            r0.b((byte[]) r3)
            org.greenrobot.eventbus.c r3 = org.greenrobot.eventbus.c.a()
            jo.bb r4 = new jo.bb
            int r5 = r0.A
            r6 = 114(0x72, float:1.6E-43)
            r4.<init>(r6, r5)
            r3.d(r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x0273
        L_0x02f7:
            com.xeagle.android.utils.w r5 = r0.f24248u
            r5.a((long) r3)
            com.xeagle.android.utils.w r3 = r0.f24248u
            r3.c()
            java.util.ArrayList<byte[]> r3 = r0.f24246s
            int r4 = r0.A
            java.lang.Object r3 = r3.get(r4)
            byte[] r3 = (byte[]) r3
            r0.b((byte[]) r3)
            org.greenrobot.eventbus.c r3 = org.greenrobot.eventbus.c.a()
            jo.bb r4 = new jo.bb
            int r5 = r0.A
            r6 = 114(0x72, float:1.6E-43)
            r4.<init>(r6, r5)
            r3.d(r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x0273
        L_0x0325:
            org.greenrobot.eventbus.c r3 = org.greenrobot.eventbus.c.a()
            jo.bb r4 = new jo.bb
            r5 = 117(0x75, float:1.64E-43)
            r6 = 0
            r4.<init>(r5, r6)
            r3.d(r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x060e
        L_0x033b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r10)
            int r8 = r0.W
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            android.util.Log.i(r12, r5)
            int r5 = r0.J
            int r8 = r0.W
            if (r5 != r8) goto L_0x03de
            int r5 = r0.K
            if (r5 == r2) goto L_0x036d
            if (r5 != r11) goto L_0x035c
            goto L_0x036d
        L_0x035c:
            com.xeagle.android.utils.w r3 = r0.f24248u
            r4 = 20000(0x4e20, double:9.8813E-320)
            r3.a((long) r4)
            com.xeagle.android.utils.w r3 = r0.f24248u
            r3.c()
            r17.h()
            goto L_0x06a0
        L_0x036d:
            boolean r5 = f24228c
            if (r5 != 0) goto L_0x037c
            java.lang.String r5 = r0.N
            if (r5 == 0) goto L_0x0376
            goto L_0x037c
        L_0x0376:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x037c:
            int r5 = r0.M
            if (r5 != 0) goto L_0x035c
            java.lang.String r5 = r0.N
            boolean r5 = r5.equalsIgnoreCase(r13)
            if (r5 == 0) goto L_0x035c
            int r5 = r0.W
            r0.Y = r5
            int r5 = r5 + r2
            r0.W = r5
            if (r5 <= r6) goto L_0x0393
            r0.W = r2
        L_0x0393:
            com.xeagle.android.utils.prefs.a r5 = r0.D
            r5.i((boolean) r2)
            com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates r5 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.UploadStates.UPLOADING_FIRMWARE
            r0.f24230b = r5
            org.greenrobot.eventbus.c r5 = org.greenrobot.eventbus.c.a()
            jo.bb r6 = new jo.bb
            r8 = 111(0x6f, float:1.56E-43)
            r9 = 0
            r6.<init>(r8, r9)
            r5.d(r6)
            com.xeagle.android.utils.w r5 = r0.f24248u
            r5.a((long) r3)
            com.xeagle.android.utils.w r3 = r0.f24248u
            r3.c()
            java.lang.String r3 = "handleData: ---->>>update start"
            android.util.Log.i(r12, r3)
            java.util.ArrayList<byte[]> r3 = r0.f24246s
            int r4 = r0.A
            java.lang.Object r3 = r3.get(r4)
            byte[] r3 = (byte[]) r3
            r0.b((byte[]) r3)
            org.greenrobot.eventbus.c r3 = org.greenrobot.eventbus.c.a()
            jo.bb r4 = new jo.bb
            int r5 = r0.A
            r6 = 114(0x72, float:1.6E-43)
            r4.<init>(r6, r5)
            r3.d(r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x0273
        L_0x03de:
            org.greenrobot.eventbus.c r3 = org.greenrobot.eventbus.c.a()
            jo.bb r4 = new jo.bb
            r5 = 117(0x75, float:1.64E-43)
            r6 = 0
            r4.<init>(r5, r6)
            r3.d(r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x060e
        L_0x03f4:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r10)
            int r10 = r0.W
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            android.util.Log.i(r12, r5)
            int r5 = r0.J
            int r10 = r0.W
            if (r5 != r10) goto L_0x0478
            int r5 = r0.K
            if (r5 == r2) goto L_0x0424
            if (r5 != r11) goto L_0x0415
            goto L_0x0424
        L_0x0415:
            com.xeagle.android.utils.w r5 = r0.f24248u
            r5.a((long) r3)
            com.xeagle.android.utils.w r3 = r0.f24248u
            r3.c()
            r17.g()
            goto L_0x06a0
        L_0x0424:
            boolean r5 = f24228c
            if (r5 != 0) goto L_0x0433
            java.lang.String r5 = r0.N
            if (r5 == 0) goto L_0x042d
            goto L_0x0433
        L_0x042d:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x0433:
            int r5 = r0.M
            if (r5 != 0) goto L_0x0415
            int r5 = r0.P
            if (r5 != 0) goto L_0x0415
            java.lang.String r5 = r0.N
            boolean r5 = r5.equalsIgnoreCase(r13)
            if (r5 == 0) goto L_0x0415
            int r3 = r0.Q
            r0.V = r3
            int r3 = r0.W
            r0.Y = r3
            int r3 = r3 + r2
            r0.W = r3
            if (r3 <= r6) goto L_0x0452
            r0.W = r2
        L_0x0452:
            int r3 = r0.R
            long r3 = r0.a((int) r3)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r9)
            int r6 = r0.V
            r5.append(r6)
            r5.append(r8)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            android.util.Log.i(r12, r3)
            com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates r3 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.UploadStates.ERASE_UPDATE
            r0.f24230b = r3
            goto L_0x035c
        L_0x0478:
            org.greenrobot.eventbus.c r3 = org.greenrobot.eventbus.c.a()
            jo.bb r4 = new jo.bb
            r5 = 117(0x75, float:1.64E-43)
            r6 = 0
            r4.<init>(r5, r6)
            r3.d(r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x060e
        L_0x048e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r10)
            int r8 = r0.W
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            android.util.Log.i(r12, r5)
            int r5 = r0.J
            int r8 = r0.W
            if (r5 != r8) goto L_0x04fd
            int r5 = r0.K
            if (r5 == r2) goto L_0x04be
            if (r5 != r11) goto L_0x04af
            goto L_0x04be
        L_0x04af:
            com.xeagle.android.utils.w r5 = r0.f24248u
            r5.a((long) r3)
            com.xeagle.android.utils.w r3 = r0.f24248u
            r3.c()
            r17.e()
            goto L_0x06a0
        L_0x04be:
            boolean r5 = f24228c
            if (r5 != 0) goto L_0x04cd
            java.lang.String r5 = r0.N
            if (r5 == 0) goto L_0x04c7
            goto L_0x04cd
        L_0x04c7:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x04cd:
            int r5 = r0.M
            if (r5 != 0) goto L_0x04af
            int r5 = r0.P
            if (r5 != 0) goto L_0x04af
            java.lang.String r5 = r0.N
            boolean r5 = r5.equalsIgnoreCase(r13)
            if (r5 == 0) goto L_0x04af
            int r5 = r0.Q
            r0.R = r5
            int r8 = r0.W
            r0.Y = r8
            int r8 = r8 + r2
            r0.W = r8
            if (r8 <= r6) goto L_0x04ec
            r0.W = r2
        L_0x04ec:
            double r8 = r0.f24229a
            double r5 = (double) r5
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 > 0) goto L_0x04f9
            com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates r5 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.UploadStates.CRC_FIRST
            r0.f24230b = r5
            goto L_0x0415
        L_0x04f9:
            java.lang.String r3 = "handleData: upload firmware is too large"
            goto L_0x061a
        L_0x04fd:
            org.greenrobot.eventbus.c r3 = org.greenrobot.eventbus.c.a()
            jo.bb r4 = new jo.bb
            r5 = 117(0x75, float:1.64E-43)
            r6 = 0
            r4.<init>(r5, r6)
            r3.d(r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x060e
        L_0x0513:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r10)
            int r8 = r0.W
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            android.util.Log.i(r12, r5)
            int r5 = r0.J
            int r8 = r0.W
            if (r5 != r8) goto L_0x05fa
            int r5 = r0.K
            if (r5 == r2) goto L_0x0543
            if (r5 != r11) goto L_0x0534
            goto L_0x0543
        L_0x0534:
            com.xeagle.android.utils.w r5 = r0.f24248u
            r5.a((long) r3)
            com.xeagle.android.utils.w r3 = r0.f24248u
            r3.c()
            r17.f()
            goto L_0x06a0
        L_0x0543:
            boolean r5 = f24228c
            if (r5 != 0) goto L_0x0552
            java.lang.String r5 = r0.N
            if (r5 == 0) goto L_0x054c
            goto L_0x0552
        L_0x054c:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x0552:
            int r5 = r0.M
            if (r5 != 0) goto L_0x0534
            int r5 = r0.P
            if (r5 != 0) goto L_0x0534
            java.lang.String r5 = r0.N
            boolean r5 = r5.equalsIgnoreCase(r13)
            if (r5 == 0) goto L_0x0534
            int r5 = r0.Q
            int r8 = r5 >> 24
            r8 = r8 & r6
            byte r8 = (byte) r8
            int r9 = r5 >> 16
            r9 = r9 & r6
            byte r9 = (byte) r9
            int r10 = r5 >> 8
            r10 = r10 & r6
            byte r10 = (byte) r10
            r13 = 0
            int r5 = r5 >> r13
            r5 = r5 & r6
            byte r5 = (byte) r5
            r14 = 4
            java.lang.Object[] r14 = new java.lang.Object[r14]
            java.lang.Integer r15 = java.lang.Integer.valueOf(r8)
            r14[r13] = r15
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r14[r2] = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r10)
            r14[r11] = r9
            r9 = 3
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r14[r9] = r5
            java.lang.String r5 = "v.%d.%d.%d.%d"
            java.lang.String r5 = java.lang.String.format(r5, r14)
            r0.S = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r9 = "handleData: ---firmware version:::"
            r5.append(r9)
            java.lang.String r9 = r0.S
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            android.util.Log.i(r12, r5)
            java.lang.String r5 = r0.f24251x
            if (r5 == 0) goto L_0x05d9
            java.lang.String r9 = "Obtain"
            boolean r5 = r5.contains(r9)
            if (r5 == 0) goto L_0x05bc
            if (r8 == r11) goto L_0x05c8
        L_0x05bc:
            java.lang.String r5 = r0.f24251x
            java.lang.String r9 = "Dream"
            boolean r5 = r5.contains(r9)
            if (r5 == 0) goto L_0x05d9
            if (r8 != r2) goto L_0x05d9
        L_0x05c8:
            int r5 = r0.W
            r0.Y = r5
            int r5 = r5 + r2
            r0.W = r5
            if (r5 <= r6) goto L_0x05d3
            r0.W = r2
        L_0x05d3:
            com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates r5 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.UploadStates.GET_FIRMWARE_SIZE
            r0.f24230b = r5
            goto L_0x04af
        L_0x05d9:
            r5 = 0
            r0.F = r5
            com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates r6 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.UploadStates.PROTO_BOOT
            r0.f24230b = r6
            com.xeagle.android.utils.w r6 = r0.f24248u
            r6.a((long) r3)
            com.xeagle.android.utils.w r3 = r0.f24248u
            r3.c()
            r17.i()
            org.greenrobot.eventbus.c r3 = org.greenrobot.eventbus.c.a()
            jo.bb r4 = new jo.bb
            r6 = 118(0x76, float:1.65E-43)
            r4.<init>(r6, r5)
            goto L_0x0183
        L_0x05fa:
            org.greenrobot.eventbus.c r3 = org.greenrobot.eventbus.c.a()
            jo.bb r4 = new jo.bb
            r5 = 117(0x75, float:1.64E-43)
            r6 = 0
            r4.<init>(r5, r6)
            r3.d(r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x060e:
            r3.append(r14)
            int r4 = r0.J
        L_0x0613:
            r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x061a:
            android.util.Log.i(r12, r3)
            goto L_0x06a0
        L_0x061f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r10)
            int r8 = r0.W
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            android.util.Log.i(r12, r5)
            int r5 = r0.J
            int r8 = r0.W
            if (r5 != r8) goto L_0x067a
            int r5 = r0.K
            if (r5 == r2) goto L_0x064e
            if (r5 != r11) goto L_0x0640
            goto L_0x064e
        L_0x0640:
            com.xeagle.android.utils.w r5 = r0.f24248u
            r5.a((long) r3)
            com.xeagle.android.utils.w r3 = r0.f24248u
            r3.c()
            r17.b()
            goto L_0x06a0
        L_0x064e:
            boolean r5 = f24228c
            if (r5 != 0) goto L_0x065d
            java.lang.String r5 = r0.N
            if (r5 == 0) goto L_0x0657
            goto L_0x065d
        L_0x0657:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x065d:
            int r5 = r0.M
            if (r5 != 0) goto L_0x0640
            java.lang.String r5 = r0.N
            boolean r5 = r5.equalsIgnoreCase(r13)
            if (r5 == 0) goto L_0x0640
            int r5 = r0.W
            r0.Y = r5
            int r5 = r5 + r2
            r0.W = r5
            if (r5 <= r6) goto L_0x0674
            r0.W = r2
        L_0x0674:
            com.xeagle.android.proxy.updateFirmware.FirmwareManager$UploadStates r5 = com.xeagle.android.proxy.updateFirmware.FirmwareManager.UploadStates.GET_FIRMWARE_VERSION
            r0.f24230b = r5
            goto L_0x0534
        L_0x067a:
            org.greenrobot.eventbus.c r3 = org.greenrobot.eventbus.c.a()
            jo.bb r4 = new jo.bb
            r5 = 117(0x75, float:1.64E-43)
            r6 = 0
            r4.<init>(r5, r6)
            r3.d(r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r14)
            int r4 = r0.J
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.i(r12, r3)
            goto L_0x06a1
        L_0x069e:
            r16 = r4
        L_0x06a0:
            r6 = 0
        L_0x06a1:
            int r4 = r16 + 1
            r3 = 0
            goto L_0x000a
        L_0x06a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.proxy.updateFirmware.FirmwareManager.a(com.xeagle.android.proxy.updateFirmware.UploadParser, int, byte[]):void");
    }

    private void a(byte[] bArr) {
    }

    private void b(final byte[] bArr) {
        new Thread(new Runnable() {
            public void run() {
                byte[] bArr = bArr;
                byte[] bArr2 = new byte[(bArr.length + 3)];
                bArr2[0] = 39;
                bArr2[1] = (byte) bArr.length;
                System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
                bArr2[bArr.length + 2] = (byte) FirmwareManager.this.f24233f;
                FirmwareManager.this.c(bArr2);
            }
        }, "firmwareM").start();
    }

    private void c() {
        a(new byte[]{-2, 33, 79, -1, 1, 76, 0, 0, Byte.MIN_VALUE, 63, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 0, -1, 1, 0, 2, -68});
    }

    /* access modifiers changed from: private */
    public synchronized void c(byte[] bArr) {
        a(a(this.W, bArr).d());
    }

    private void d() {
        this.C = null;
        this.A = 0;
        this.W = 0;
        this.Q = -1;
        this.P = -1;
        this.O = -1;
        this.K = -1;
        this.J = -1;
        this.N = "";
        this.M = -1;
        this.L = -1;
        this.R = -1;
        this.V = -1;
        this.S = "";
        this.f24229a = -1.0d;
        this.f24251x = "";
        this.E = false;
        this.T = false;
        this.U = false;
        this.F = false;
    }

    /* access modifiers changed from: private */
    public void e() {
        c(new byte[]{34, 4, (byte) this.f24233f});
    }

    private void f() {
        c(new byte[]{34, 15, (byte) this.f24233f});
    }

    private void g() {
        c(new byte[]{41, (byte) this.f24233f});
    }

    private void h() {
        c(new byte[]{35, (byte) this.f24233f});
        c.a().d(new bb(113, 0));
    }

    private void i() {
        c(new byte[]{48, (byte) this.f24233f});
        if (this.F) {
            c.a().d(new bb(116, 0));
        }
    }

    public void a() {
        if (B != null) {
            B = null;
        }
        this.E = false;
        d();
        Thread thread = this.f24252y;
        if (thread != null) {
            if (thread.isAlive()) {
                this.f24252y.interrupt();
            }
            this.f24252y = null;
        }
        this.f24230b = UploadStates.REBOOT_STATE;
    }

    public void a(a aVar) {
        this.f24246s = new ArrayList<>();
        this.C = aVar;
        Thread thread = new Thread(this.H, "rec_callback");
        this.f24252y = thread;
        thread.start();
        this.f24251x = aVar.A();
        this.f24248u.a(1200);
        this.f24248u.c();
        this.f24230b = UploadStates.SYNC_REQUEST;
        b();
        this.D = new com.xeagle.android.utils.prefs.a(this.f24245r);
        try {
            this.G = g.a(this.f24245r, aVar);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f24229a = (double) (this.G.length + 1024);
        Log.i("UPLOAD", "LENGTH:" + this.G.length);
    }

    public void b() {
        c(new byte[]{33, (byte) this.f24233f});
    }

    public void notifyTimeOut(int i2) {
        Log.i("UPLOAD", "notifyTimeOut: -->>>> timeout:" + i2);
        if (i2 >= this.f24248u.a()) {
            Log.i("UPLOAD", "notifyTimeOut: -->>>> timeout:" + this.f24230b.name());
            this.f24230b = UploadStates.REBOOT_STATE;
            c.a().d(new bb(117, 0));
            return;
        }
        this.f24248u.a(false);
        switch (AnonymousClass4.f24258a[this.f24230b.ordinal()]) {
            case 1:
                c();
                SystemClock.sleep(100);
                b();
                return;
            case 2:
                f();
                return;
            case 3:
                e();
                return;
            case 4:
            case 7:
                g();
                return;
            case 5:
                h();
                return;
            case 6:
                b(this.f24246s.get(this.A));
                c.a().d(new bb(114, this.A));
                Log.i("UPLOAD", "length progress:" + this.A);
                return;
            case 8:
                Log.i("UPLOAD", "proto boot");
                i();
                return;
            default:
                return;
        }
    }
}
