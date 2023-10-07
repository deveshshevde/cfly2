package com.myusb.proxy.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.f;
import com.google.protobuf.h;
import com.google.protobuf.k;
import com.google.protobuf.l;
import com.google.protobuf.n;
import java.io.IOException;
import java.util.Objects;

public final class Proxy {

    public enum ConnType implements h.a {
        TCP(0),
        UDP(1),
        RELAY(2),
        FTP(3),
        HTTP(4),
        RTSP(5),
        TTY(6),
        UNRECOGNIZED(-1);
        

        /* renamed from: i  reason: collision with root package name */
        private static final h.b<ConnType> f11933i = null;

        /* renamed from: j  reason: collision with root package name */
        private final int f11935j;

        static {
            f11933i = new h.b<ConnType>() {
            };
        }

        private ConnType(int i2) {
            this.f11935j = i2;
        }

        public static ConnType a(int i2) {
            switch (i2) {
                case 0:
                    return TCP;
                case 1:
                    return UDP;
                case 2:
                    return RELAY;
                case 3:
                    return FTP;
                case 4:
                    return HTTP;
                case 5:
                    return RTSP;
                case 6:
                    return TTY;
                default:
                    return null;
            }
        }

        public final int a() {
            return this.f11935j;
        }
    }

    public enum MsgType implements h.a {
        CONNECT(0),
        SEND(1),
        RECV(2),
        CLOSE(3),
        ERROR(4),
        CREATE(5),
        RESULT(6),
        CLOSE_ALL(7),
        USB_HEART_BEAT(8),
        RELAY_VERSION(9),
        RELAY_WIFI_RENAME(10),
        RELAY_WIFI_STRENGTH(11),
        RELAY_WIFI_LIST(12),
        RELAY_WIFI_UPDATE(13),
        RELAY_WIFI_VERSION(14),
        RTSP_START(15),
        RTSP_STOP(16),
        FTP_DELETE_FILE(17),
        FTP_DOWNLOAD_START(18),
        FTP_DOWNLOAD_STOP(19),
        FTP_UPLOAD_START(20),
        FTP_UPLOAD_STOP(21),
        HTTP_PROGRESS(22),
        TTY_VERSION(23),
        TTY_ENABLE_POWER(24),
        TTY_SWTICH_METHOD(25),
        CREATE_ERROR(26),
        CONNECT_ERROR(27),
        SEND_ERROR(28),
        CLOSE_ERROR(29),
        UNRECOGNIZED(-1);
        
        private static final h.b<MsgType> F = null;
        private final int G;

        static {
            F = new h.b<MsgType>() {
            };
        }

        private MsgType(int i2) {
            this.G = i2;
        }

        public static MsgType a(int i2) {
            switch (i2) {
                case 0:
                    return CONNECT;
                case 1:
                    return SEND;
                case 2:
                    return RECV;
                case 3:
                    return CLOSE;
                case 4:
                    return ERROR;
                case 5:
                    return CREATE;
                case 6:
                    return RESULT;
                case 7:
                    return CLOSE_ALL;
                case 8:
                    return USB_HEART_BEAT;
                case 9:
                    return RELAY_VERSION;
                case 10:
                    return RELAY_WIFI_RENAME;
                case 11:
                    return RELAY_WIFI_STRENGTH;
                case 12:
                    return RELAY_WIFI_LIST;
                case 13:
                    return RELAY_WIFI_UPDATE;
                case 14:
                    return RELAY_WIFI_VERSION;
                case 15:
                    return RTSP_START;
                case 16:
                    return RTSP_STOP;
                case 17:
                    return FTP_DELETE_FILE;
                case 18:
                    return FTP_DOWNLOAD_START;
                case 19:
                    return FTP_DOWNLOAD_STOP;
                case 20:
                    return FTP_UPLOAD_START;
                case 21:
                    return FTP_UPLOAD_STOP;
                case 22:
                    return HTTP_PROGRESS;
                case 23:
                    return TTY_VERSION;
                case 24:
                    return TTY_ENABLE_POWER;
                case 25:
                    return TTY_SWTICH_METHOD;
                case 26:
                    return CREATE_ERROR;
                case 27:
                    return CONNECT_ERROR;
                case 28:
                    return SEND_ERROR;
                case 29:
                    return CLOSE_ERROR;
                default:
                    return null;
            }
        }

        public final int a() {
            return this.G;
        }
    }

    public static final class c extends GeneratedMessageLite<c, a> implements d {
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public static final c f11962l;

        /* renamed from: m  reason: collision with root package name */
        private static volatile n<c> f11963m;

        /* renamed from: d  reason: collision with root package name */
        private int f11964d;

        /* renamed from: e  reason: collision with root package name */
        private int f11965e;

        /* renamed from: f  reason: collision with root package name */
        private int f11966f;

        /* renamed from: g  reason: collision with root package name */
        private int f11967g;

        /* renamed from: h  reason: collision with root package name */
        private int f11968h;

        /* renamed from: i  reason: collision with root package name */
        private String f11969i = "";

        /* renamed from: j  reason: collision with root package name */
        private int f11970j;

        /* renamed from: k  reason: collision with root package name */
        private a f11971k;

        public static final class a extends GeneratedMessageLite.a<c, a> implements d {
            private a() {
                super(c.f11962l);
            }

            /* synthetic */ a(AnonymousClass1 r1) {
                this();
            }

            public a a(int i2) {
                b();
                ((c) this.f20061a).a(i2);
                return this;
            }

            public a a(ConnType connType) {
                b();
                ((c) this.f20061a).a(connType);
                return this;
            }

            public a a(MsgType msgType) {
                b();
                ((c) this.f20061a).a(msgType);
                return this;
            }

            public a a(a aVar) {
                b();
                ((c) this.f20061a).a(aVar);
                return this;
            }

            public a a(String str) {
                b();
                ((c) this.f20061a).a(str);
                return this;
            }

            public a b(int i2) {
                b();
                ((c) this.f20061a).b(i2);
                return this;
            }

            public a c(int i2) {
                b();
                ((c) this.f20061a).c(i2);
                return this;
            }

            public a d(int i2) {
                b();
                ((c) this.f20061a).d(i2);
                return this;
            }
        }

        static {
            c cVar = new c();
            f11962l = cVar;
            cVar.g();
        }

        private c() {
        }

        public static c a(byte[] bArr) throws InvalidProtocolBufferException {
            return (c) GeneratedMessageLite.a(f11962l, bArr);
        }

        /* access modifiers changed from: private */
        public void a(int i2) {
            this.f11964d = i2;
        }

        /* access modifiers changed from: private */
        public void a(ConnType connType) {
            Objects.requireNonNull(connType);
            this.f11967g = connType.a();
        }

        /* access modifiers changed from: private */
        public void a(MsgType msgType) {
            Objects.requireNonNull(msgType);
            this.f11968h = msgType.a();
        }

        /* access modifiers changed from: private */
        public void a(a aVar) {
            Objects.requireNonNull(aVar);
            this.f11971k = aVar;
        }

        /* access modifiers changed from: private */
        public void a(String str) {
            Objects.requireNonNull(str);
            this.f11969i = str;
        }

        /* access modifiers changed from: private */
        public void b(int i2) {
            this.f11965e = i2;
        }

        /* access modifiers changed from: private */
        public void c(int i2) {
            this.f11966f = i2;
        }

        /* access modifiers changed from: private */
        public void d(int i2) {
            this.f11970j = i2;
        }

        public static a u() {
            return (a) f11962l.j();
        }

        /* access modifiers changed from: protected */
        public final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z2 = false;
            switch (AnonymousClass1.f21481a[methodToInvoke.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return f11962l;
                case 3:
                    return null;
                case 4:
                    return new a((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.h hVar = (GeneratedMessageLite.h) obj;
                    c cVar = (c) obj2;
                    int i2 = this.f11964d;
                    boolean z3 = i2 != 0;
                    int i3 = cVar.f11964d;
                    this.f11964d = hVar.a(z3, i2, i3 != 0, i3);
                    int i4 = this.f11965e;
                    boolean z4 = i4 != 0;
                    int i5 = cVar.f11965e;
                    this.f11965e = hVar.a(z4, i4, i5 != 0, i5);
                    int i6 = this.f11966f;
                    boolean z5 = i6 != 0;
                    int i7 = cVar.f11966f;
                    this.f11966f = hVar.a(z5, i6, i7 != 0, i7);
                    int i8 = this.f11967g;
                    boolean z6 = i8 != 0;
                    int i9 = cVar.f11967g;
                    this.f11967g = hVar.a(z6, i8, i9 != 0, i9);
                    int i10 = this.f11968h;
                    boolean z7 = i10 != 0;
                    int i11 = cVar.f11968h;
                    this.f11968h = hVar.a(z7, i10, i11 != 0, i11);
                    this.f11969i = hVar.a(!this.f11969i.isEmpty(), this.f11969i, !cVar.f11969i.isEmpty(), cVar.f11969i);
                    int i12 = this.f11970j;
                    boolean z8 = i12 != 0;
                    int i13 = cVar.f11970j;
                    if (i13 != 0) {
                        z2 = true;
                    }
                    this.f11970j = hVar.a(z8, i12, z2, i13);
                    this.f11971k = (a) hVar.a(this.f11971k, cVar.f11971k);
                    GeneratedMessageLite.g gVar = GeneratedMessageLite.g.f20070a;
                    return this;
                case 6:
                    com.google.protobuf.d dVar = (com.google.protobuf.d) obj;
                    f fVar = (f) obj2;
                    while (!z2) {
                        try {
                            int a2 = dVar.a();
                            if (a2 != 0) {
                                if (a2 == 8) {
                                    this.f11964d = dVar.c();
                                } else if (a2 == 16) {
                                    this.f11965e = dVar.c();
                                } else if (a2 == 24) {
                                    this.f11966f = dVar.c();
                                } else if (a2 == 32) {
                                    this.f11967g = dVar.f();
                                } else if (a2 == 40) {
                                    this.f11968h = dVar.f();
                                } else if (a2 == 50) {
                                    this.f11969i = dVar.d();
                                } else if (a2 == 56) {
                                    this.f11970j = dVar.c();
                                } else if (a2 == 66) {
                                    a aVar = this.f11971k;
                                    a.C0141a aVar2 = aVar != null ? (a.C0141a) aVar.j() : null;
                                    a aVar3 = (a) dVar.a(a.s(), fVar);
                                    this.f11971k = aVar3;
                                    if (aVar2 != null) {
                                        aVar2.b(aVar3);
                                        this.f11971k = (a) aVar2.d();
                                    }
                                } else if (!dVar.b(a2)) {
                                }
                            }
                            z2 = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.a(this));
                        } catch (IOException e3) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).a(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (f11963m == null) {
                        synchronized (c.class) {
                            if (f11963m == null) {
                                f11963m = new GeneratedMessageLite.b(f11962l);
                            }
                        }
                    }
                    return f11963m;
                default:
                    throw new UnsupportedOperationException();
            }
            return f11962l;
        }

        public void a(CodedOutputStream codedOutputStream) throws IOException {
            int i2 = this.f11964d;
            if (i2 != 0) {
                codedOutputStream.a(1, i2);
            }
            int i3 = this.f11965e;
            if (i3 != 0) {
                codedOutputStream.a(2, i3);
            }
            int i4 = this.f11966f;
            if (i4 != 0) {
                codedOutputStream.a(3, i4);
            }
            if (this.f11967g != ConnType.TCP.a()) {
                codedOutputStream.b(4, this.f11967g);
            }
            if (this.f11968h != MsgType.CONNECT.a()) {
                codedOutputStream.b(5, this.f11968h);
            }
            if (!this.f11969i.isEmpty()) {
                codedOutputStream.a(6, r());
            }
            int i5 = this.f11970j;
            if (i5 != 0) {
                codedOutputStream.a(7, i5);
            }
            if (this.f11971k != null) {
                codedOutputStream.a(8, (k) t());
            }
        }

        public int l() {
            int i2 = this.f11844c;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            int i4 = this.f11964d;
            if (i4 != 0) {
                i3 = 0 + CodedOutputStream.c(1, i4);
            }
            int i5 = this.f11965e;
            if (i5 != 0) {
                i3 += CodedOutputStream.c(2, i5);
            }
            int i6 = this.f11966f;
            if (i6 != 0) {
                i3 += CodedOutputStream.c(3, i6);
            }
            if (this.f11967g != ConnType.TCP.a()) {
                i3 += CodedOutputStream.d(4, this.f11967g);
            }
            if (this.f11968h != MsgType.CONNECT.a()) {
                i3 += CodedOutputStream.d(5, this.f11968h);
            }
            if (!this.f11969i.isEmpty()) {
                i3 += CodedOutputStream.b(6, r());
            }
            int i7 = this.f11970j;
            if (i7 != 0) {
                i3 += CodedOutputStream.c(7, i7);
            }
            if (this.f11971k != null) {
                i3 += CodedOutputStream.b(8, (k) t());
            }
            this.f11844c = i3;
            return i3;
        }

        public int m() {
            return this.f11964d;
        }

        public int n() {
            return this.f11965e;
        }

        public int o() {
            return this.f11966f;
        }

        public ConnType p() {
            ConnType a2 = ConnType.a(this.f11967g);
            return a2 == null ? ConnType.UNRECOGNIZED : a2;
        }

        public MsgType q() {
            MsgType a2 = MsgType.a(this.f11968h);
            return a2 == null ? MsgType.UNRECOGNIZED : a2;
        }

        public String r() {
            return this.f11969i;
        }

        public int s() {
            return this.f11970j;
        }

        public a t() {
            a aVar = this.f11971k;
            return aVar == null ? a.r() : aVar;
        }
    }

    public interface d extends l {
    }

    /* renamed from: com.myusb.proxy.proto.Proxy$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21481a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21481a = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21481a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f21481a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f21481a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f21481a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.VISIT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f21481a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f21481a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f21481a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.myusb.proxy.proto.Proxy.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class a extends GeneratedMessageLite<a, C0141a> implements b {
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public static final a f21482h;

        /* renamed from: i  reason: collision with root package name */
        private static volatile n<a> f21483i;

        /* renamed from: d  reason: collision with root package name */
        private int f21484d;

        /* renamed from: e  reason: collision with root package name */
        private int f21485e;

        /* renamed from: f  reason: collision with root package name */
        private String f21486f = "";

        /* renamed from: g  reason: collision with root package name */
        private ByteString f21487g = ByteString.f20030a;

        /* renamed from: com.myusb.proxy.proto.Proxy$a$a  reason: collision with other inner class name */
        public static final class C0141a extends GeneratedMessageLite.a<a, C0141a> implements b {
            private C0141a() {
                super(a.f21482h);
            }

            /* synthetic */ C0141a(AnonymousClass1 r1) {
                this();
            }

            public C0141a a(int i2) {
                b();
                ((a) this.f20061a).a(i2);
                return this;
            }

            public C0141a a(ByteString byteString) {
                b();
                ((a) this.f20061a).a(byteString);
                return this;
            }

            public C0141a a(String str) {
                b();
                ((a) this.f20061a).a(str);
                return this;
            }

            public C0141a b(int i2) {
                b();
                ((a) this.f20061a).b(i2);
                return this;
            }
        }

        static {
            a aVar = new a();
            f21482h = aVar;
            aVar.g();
        }

        private a() {
        }

        /* access modifiers changed from: private */
        public void a(int i2) {
            this.f21484d = i2;
        }

        /* access modifiers changed from: private */
        public void a(ByteString byteString) {
            Objects.requireNonNull(byteString);
            this.f21487g = byteString;
        }

        /* access modifiers changed from: private */
        public void a(String str) {
            Objects.requireNonNull(str);
            this.f21486f = str;
        }

        /* access modifiers changed from: private */
        public void b(int i2) {
            this.f21485e = i2;
        }

        public static C0141a q() {
            return (C0141a) f21482h.j();
        }

        public static a r() {
            return f21482h;
        }

        public static n<a> s() {
            return f21482h.d();
        }

        /* access modifiers changed from: protected */
        public final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z2 = false;
            switch (AnonymousClass1.f21481a[methodToInvoke.ordinal()]) {
                case 1:
                    return new a();
                case 2:
                    return f21482h;
                case 3:
                    return null;
                case 4:
                    return new C0141a((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.h hVar = (GeneratedMessageLite.h) obj;
                    a aVar = (a) obj2;
                    int i2 = this.f21484d;
                    boolean z3 = i2 != 0;
                    int i3 = aVar.f21484d;
                    this.f21484d = hVar.a(z3, i2, i3 != 0, i3);
                    int i4 = this.f21485e;
                    boolean z4 = i4 != 0;
                    int i5 = aVar.f21485e;
                    this.f21485e = hVar.a(z4, i4, i5 != 0, i5);
                    this.f21486f = hVar.a(!this.f21486f.isEmpty(), this.f21486f, !aVar.f21486f.isEmpty(), aVar.f21486f);
                    boolean z5 = this.f21487g != ByteString.f20030a;
                    ByteString byteString = this.f21487g;
                    if (aVar.f21487g != ByteString.f20030a) {
                        z2 = true;
                    }
                    this.f21487g = hVar.a(z5, byteString, z2, aVar.f21487g);
                    GeneratedMessageLite.g gVar = GeneratedMessageLite.g.f20070a;
                    return this;
                case 6:
                    com.google.protobuf.d dVar = (com.google.protobuf.d) obj;
                    f fVar = (f) obj2;
                    while (!z2) {
                        try {
                            int a2 = dVar.a();
                            if (a2 != 0) {
                                if (a2 == 8) {
                                    this.f21484d = dVar.c();
                                } else if (a2 == 16) {
                                    this.f21485e = dVar.c();
                                } else if (a2 == 26) {
                                    this.f21486f = dVar.d();
                                } else if (a2 == 34) {
                                    this.f21487g = dVar.e();
                                } else if (!dVar.b(a2)) {
                                }
                            }
                            z2 = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.a(this));
                        } catch (IOException e3) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).a(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (f21483i == null) {
                        synchronized (a.class) {
                            if (f21483i == null) {
                                f21483i = new GeneratedMessageLite.b(f21482h);
                            }
                        }
                    }
                    return f21483i;
                default:
                    throw new UnsupportedOperationException();
            }
            return f21482h;
        }

        public void a(CodedOutputStream codedOutputStream) throws IOException {
            int i2 = this.f21484d;
            if (i2 != 0) {
                codedOutputStream.a(1, i2);
            }
            int i3 = this.f21485e;
            if (i3 != 0) {
                codedOutputStream.a(2, i3);
            }
            if (!this.f21486f.isEmpty()) {
                codedOutputStream.a(3, o());
            }
            if (!this.f21487g.c()) {
                codedOutputStream.a(4, this.f21487g);
            }
        }

        public int l() {
            int i2 = this.f11844c;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            int i4 = this.f21484d;
            if (i4 != 0) {
                i3 = 0 + CodedOutputStream.c(1, i4);
            }
            int i5 = this.f21485e;
            if (i5 != 0) {
                i3 += CodedOutputStream.c(2, i5);
            }
            if (!this.f21486f.isEmpty()) {
                i3 += CodedOutputStream.b(3, o());
            }
            if (!this.f21487g.c()) {
                i3 += CodedOutputStream.b(4, this.f21487g);
            }
            this.f11844c = i3;
            return i3;
        }

        public int m() {
            return this.f21484d;
        }

        public int n() {
            return this.f21485e;
        }

        public String o() {
            return this.f21486f;
        }

        public ByteString p() {
            return this.f21487g;
        }
    }

    public interface b extends l {
    }
}
