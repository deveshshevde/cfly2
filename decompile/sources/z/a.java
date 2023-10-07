package z;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

public class a {
    private static final byte[] A = "VP8X".getBytes(Charset.defaultCharset());
    private static final byte[] B = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] C = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] D = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] E = "ANMF".getBytes(Charset.defaultCharset());
    private static final byte[] F = "XMP ".getBytes(Charset.defaultCharset());
    private static SimpleDateFormat G;
    private static final c[] H;
    private static final c[] I;
    private static final c[] J;
    private static final c[] K;
    private static final c[] L;
    private static final c M = new c("StripOffsets", ci.a.HEADER_VIEW, 3);
    private static final c[] N;
    private static final c[] O;
    private static final c[] P;
    private static final c[] Q;
    private static final c[] R = {new c("SubIFDPointer", 330, 4), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("InteroperabilityIFDPointer", 40965, 4), new c("CameraSettingsIFDPointer", 8224, 1), new c("ImageProcessingIFDPointer", 8256, 1)};
    private static final c S = new c("JPEGInterchangeFormat", IChannelListener.DATA_CHANNEL_EVENT_GET_PROGRESS, 4);
    private static final c T = new c("JPEGInterchangeFormatLength", IChannelListener.DATA_CHANNEL_EVENT_GET_FINISH, 4);
    private static final HashMap<Integer, c>[] U;
    private static final HashMap<String, c>[] V;
    private static final HashSet<String> W = new HashSet<>(Arrays.asList(new String[]{"FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"}));
    private static final HashMap<Integer, Integer> X = new HashMap<>();
    private static final byte[] Y;

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f34687a = {8, 8, 8};

    /* renamed from: av  reason: collision with root package name */
    private static final Pattern f34688av = Pattern.compile(".*[1-9].*");

    /* renamed from: aw  reason: collision with root package name */
    private static final Pattern f34689aw = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f34690b = {4};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f34691c = {8};

    /* renamed from: d  reason: collision with root package name */
    static final byte[] f34692d = {-1, -40, -1};

    /* renamed from: e  reason: collision with root package name */
    static final String[] f34693e = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};

    /* renamed from: f  reason: collision with root package name */
    static final int[] f34694f = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* renamed from: g  reason: collision with root package name */
    static final byte[] f34695g = {65, 83, 67, 73, 73, 0, 0, 0};

    /* renamed from: h  reason: collision with root package name */
    static final c[][] f34696h;

    /* renamed from: i  reason: collision with root package name */
    static final Charset f34697i;

    /* renamed from: j  reason: collision with root package name */
    static final byte[] f34698j;

    /* renamed from: k  reason: collision with root package name */
    private static final boolean f34699k = Log.isLoggable("ExifInterface", 3);

    /* renamed from: l  reason: collision with root package name */
    private static final List<Integer> f34700l = Arrays.asList(new Integer[]{1, 6, 3, 8});

    /* renamed from: m  reason: collision with root package name */
    private static final List<Integer> f34701m = Arrays.asList(new Integer[]{2, 7, 4, 5});

    /* renamed from: n  reason: collision with root package name */
    private static final byte[] f34702n = {102, 116, 121, 112};

    /* renamed from: o  reason: collision with root package name */
    private static final byte[] f34703o = {109, 105, 102, 49};

    /* renamed from: p  reason: collision with root package name */
    private static final byte[] f34704p = {104, 101, 105, 99};

    /* renamed from: q  reason: collision with root package name */
    private static final byte[] f34705q = {79, 76, 89, 77, 80, 0};

    /* renamed from: r  reason: collision with root package name */
    private static final byte[] f34706r = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* renamed from: s  reason: collision with root package name */
    private static final byte[] f34707s = {-119, 80, 78, 71, 13, 10, 26, 10};

    /* renamed from: t  reason: collision with root package name */
    private static final byte[] f34708t = {101, 88, 73, 102};

    /* renamed from: u  reason: collision with root package name */
    private static final byte[] f34709u = {73, 72, 68, 82};

    /* renamed from: v  reason: collision with root package name */
    private static final byte[] f34710v = {73, 69, 78, 68};

    /* renamed from: w  reason: collision with root package name */
    private static final byte[] f34711w = {82, 73, 70, 70};

    /* renamed from: x  reason: collision with root package name */
    private static final byte[] f34712x = {87, 69, 66, 80};

    /* renamed from: y  reason: collision with root package name */
    private static final byte[] f34713y = {69, 88, 73, 70};

    /* renamed from: z  reason: collision with root package name */
    private static final byte[] f34714z = {-99, 1, 42};
    private String Z;

    /* renamed from: aa  reason: collision with root package name */
    private FileDescriptor f34715aa;

    /* renamed from: ab  reason: collision with root package name */
    private AssetManager.AssetInputStream f34716ab;

    /* renamed from: ac  reason: collision with root package name */
    private int f34717ac;

    /* renamed from: ad  reason: collision with root package name */
    private boolean f34718ad;

    /* renamed from: ae  reason: collision with root package name */
    private final HashMap<String, b>[] f34719ae;

    /* renamed from: af  reason: collision with root package name */
    private Set<Integer> f34720af;

    /* renamed from: ag  reason: collision with root package name */
    private ByteOrder f34721ag;

    /* renamed from: ah  reason: collision with root package name */
    private boolean f34722ah;

    /* renamed from: ai  reason: collision with root package name */
    private boolean f34723ai;

    /* renamed from: aj  reason: collision with root package name */
    private boolean f34724aj;

    /* renamed from: ak  reason: collision with root package name */
    private int f34725ak;

    /* renamed from: al  reason: collision with root package name */
    private int f34726al;

    /* renamed from: am  reason: collision with root package name */
    private byte[] f34727am;

    /* renamed from: an  reason: collision with root package name */
    private int f34728an;

    /* renamed from: ao  reason: collision with root package name */
    private int f34729ao;

    /* renamed from: ap  reason: collision with root package name */
    private int f34730ap;

    /* renamed from: aq  reason: collision with root package name */
    private int f34731aq;

    /* renamed from: ar  reason: collision with root package name */
    private int f34732ar;

    /* renamed from: as  reason: collision with root package name */
    private int f34733as;

    /* renamed from: at  reason: collision with root package name */
    private boolean f34734at;

    /* renamed from: au  reason: collision with root package name */
    private boolean f34735au;

    /* renamed from: z.a$a  reason: collision with other inner class name */
    private static class C0267a extends InputStream implements DataInput {

        /* renamed from: c  reason: collision with root package name */
        private static final ByteOrder f34739c = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: d  reason: collision with root package name */
        private static final ByteOrder f34740d = ByteOrder.BIG_ENDIAN;

        /* renamed from: a  reason: collision with root package name */
        final int f34741a;

        /* renamed from: b  reason: collision with root package name */
        int f34742b;

        /* renamed from: e  reason: collision with root package name */
        private DataInputStream f34743e;

        /* renamed from: f  reason: collision with root package name */
        private ByteOrder f34744f;

        public C0267a(InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        C0267a(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.f34744f = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f34743e = dataInputStream;
            int available = dataInputStream.available();
            this.f34741a = available;
            this.f34742b = 0;
            this.f34743e.mark(available);
            this.f34744f = byteOrder;
        }

        public C0267a(byte[] bArr) throws IOException {
            this((InputStream) new ByteArrayInputStream(bArr));
        }

        public int a() {
            return this.f34742b;
        }

        public void a(long j2) throws IOException {
            int i2 = this.f34742b;
            if (((long) i2) > j2) {
                this.f34742b = 0;
                this.f34743e.reset();
                this.f34743e.mark(this.f34741a);
            } else {
                j2 -= (long) i2;
            }
            int i3 = (int) j2;
            if (skipBytes(i3) != i3) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public void a(ByteOrder byteOrder) {
            this.f34744f = byteOrder;
        }

        public int available() throws IOException {
            return this.f34743e.available();
        }

        public long b() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        public int c() {
            return this.f34741a;
        }

        public int read() throws IOException {
            this.f34742b++;
            return this.f34743e.read();
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int read = this.f34743e.read(bArr, i2, i3);
            this.f34742b += read;
            return read;
        }

        public boolean readBoolean() throws IOException {
            this.f34742b++;
            return this.f34743e.readBoolean();
        }

        public byte readByte() throws IOException {
            int i2 = this.f34742b + 1;
            this.f34742b = i2;
            if (i2 <= this.f34741a) {
                int read = this.f34743e.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public char readChar() throws IOException {
            this.f34742b += 2;
            return this.f34743e.readChar();
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public void readFully(byte[] bArr) throws IOException {
            int length = this.f34742b + bArr.length;
            this.f34742b = length;
            if (length > this.f34741a) {
                throw new EOFException();
            } else if (this.f34743e.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public void readFully(byte[] bArr, int i2, int i3) throws IOException {
            int i4 = this.f34742b + i3;
            this.f34742b = i4;
            if (i4 > this.f34741a) {
                throw new EOFException();
            } else if (this.f34743e.read(bArr, i2, i3) != i3) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public int readInt() throws IOException {
            int i2 = this.f34742b + 4;
            this.f34742b = i2;
            if (i2 <= this.f34741a) {
                int read = this.f34743e.read();
                int read2 = this.f34743e.read();
                int read3 = this.f34743e.read();
                int read4 = this.f34743e.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.f34744f;
                    if (byteOrder == f34739c) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == f34740d) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    throw new IOException("Invalid byte order: " + this.f34744f);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public String readLine() throws IOException {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        public long readLong() throws IOException {
            int i2 = this.f34742b + 8;
            this.f34742b = i2;
            if (i2 <= this.f34741a) {
                int read = this.f34743e.read();
                int read2 = this.f34743e.read();
                int read3 = this.f34743e.read();
                int read4 = this.f34743e.read();
                int read5 = this.f34743e.read();
                int read6 = this.f34743e.read();
                int read7 = this.f34743e.read();
                int read8 = this.f34743e.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.f34744f;
                    if (byteOrder == f34739c) {
                        return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                    }
                    int i3 = read2;
                    if (byteOrder == f34740d) {
                        return (((long) read) << 56) + (((long) i3) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                    }
                    throw new IOException("Invalid byte order: " + this.f34744f);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            int i2 = this.f34742b + 2;
            this.f34742b = i2;
            if (i2 <= this.f34741a) {
                int read = this.f34743e.read();
                int read2 = this.f34743e.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f34744f;
                    if (byteOrder == f34739c) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == f34740d) {
                        return (short) ((read << 8) + read2);
                    }
                    throw new IOException("Invalid byte order: " + this.f34744f);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public String readUTF() throws IOException {
            this.f34742b += 2;
            return this.f34743e.readUTF();
        }

        public int readUnsignedByte() throws IOException {
            this.f34742b++;
            return this.f34743e.readUnsignedByte();
        }

        public int readUnsignedShort() throws IOException {
            int i2 = this.f34742b + 2;
            this.f34742b = i2;
            if (i2 <= this.f34741a) {
                int read = this.f34743e.read();
                int read2 = this.f34743e.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f34744f;
                    if (byteOrder == f34739c) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == f34740d) {
                        return (read << 8) + read2;
                    }
                    throw new IOException("Invalid byte order: " + this.f34744f);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public int skipBytes(int i2) throws IOException {
            int min = Math.min(i2, this.f34741a - this.f34742b);
            int i3 = 0;
            while (i3 < min) {
                i3 += this.f34743e.skipBytes(min - i3);
            }
            this.f34742b += i3;
            return i3;
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f34745a;

        /* renamed from: b  reason: collision with root package name */
        public final int f34746b;

        /* renamed from: c  reason: collision with root package name */
        public final long f34747c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f34748d;

        b(int i2, int i3, long j2, byte[] bArr) {
            this.f34745a = i2;
            this.f34746b = i3;
            this.f34747c = j2;
            this.f34748d = bArr;
        }

        b(int i2, int i3, byte[] bArr) {
            this(i2, i3, -1, bArr);
        }

        public static b a(int i2, ByteOrder byteOrder) {
            return a(new int[]{i2}, byteOrder);
        }

        public static b a(long j2, ByteOrder byteOrder) {
            return a(new long[]{j2}, byteOrder);
        }

        public static b a(String str) {
            byte[] bytes = (str + 0).getBytes(a.f34697i);
            return new b(2, bytes.length, bytes);
        }

        public static b a(d dVar, ByteOrder byteOrder) {
            return a(new d[]{dVar}, byteOrder);
        }

        public static b a(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.f34694f[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i2 : iArr) {
                wrap.putShort((short) i2);
            }
            return new b(3, iArr.length, wrap.array());
        }

        public static b a(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.f34694f[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j2 : jArr) {
                wrap.putInt((int) j2);
            }
            return new b(4, jArr.length, wrap.array());
        }

        public static b a(d[] dVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.f34694f[5] * dVarArr.length)]);
            wrap.order(byteOrder);
            for (d dVar : dVarArr) {
                wrap.putInt((int) dVar.f34753a);
                wrap.putInt((int) dVar.f34754b);
            }
            return new b(5, dVarArr.length, wrap.array());
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:164:0x01a7 A[SYNTHETIC, Splitter:B:164:0x01a7] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object a(java.nio.ByteOrder r11) {
            /*
                r10 = this;
                java.lang.String r0 = "IOException occurred while closing InputStream"
                java.lang.String r1 = "ExifInterface"
                r2 = 0
                z.a$a r3 = new z.a$a     // Catch:{ IOException -> 0x0191, all -> 0x018f }
                byte[] r4 = r10.f34748d     // Catch:{ IOException -> 0x0191, all -> 0x018f }
                r3.<init>((byte[]) r4)     // Catch:{ IOException -> 0x0191, all -> 0x018f }
                r3.a((java.nio.ByteOrder) r11)     // Catch:{ IOException -> 0x018d }
                int r11 = r10.f34745a     // Catch:{ IOException -> 0x018d }
                r4 = 1
                r5 = 0
                switch(r11) {
                    case 1: goto L_0x014c;
                    case 2: goto L_0x00fd;
                    case 3: goto L_0x00e3;
                    case 4: goto L_0x00c9;
                    case 5: goto L_0x00a6;
                    case 6: goto L_0x014c;
                    case 7: goto L_0x00fd;
                    case 8: goto L_0x008c;
                    case 9: goto L_0x0072;
                    case 10: goto L_0x004d;
                    case 11: goto L_0x0032;
                    case 12: goto L_0x0018;
                    default: goto L_0x0016;
                }     // Catch:{ IOException -> 0x018d }
            L_0x0016:
                goto L_0x0184
            L_0x0018:
                int r11 = r10.f34746b     // Catch:{ IOException -> 0x018d }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x018d }
            L_0x001c:
                int r4 = r10.f34746b     // Catch:{ IOException -> 0x018d }
                if (r5 >= r4) goto L_0x0029
                double r6 = r3.readDouble()     // Catch:{ IOException -> 0x018d }
                r11[r5] = r6     // Catch:{ IOException -> 0x018d }
                int r5 = r5 + 1
                goto L_0x001c
            L_0x0029:
                r3.close()     // Catch:{ IOException -> 0x002d }
                goto L_0x0031
            L_0x002d:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0031:
                return r11
            L_0x0032:
                int r11 = r10.f34746b     // Catch:{ IOException -> 0x018d }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x018d }
            L_0x0036:
                int r4 = r10.f34746b     // Catch:{ IOException -> 0x018d }
                if (r5 >= r4) goto L_0x0044
                float r4 = r3.readFloat()     // Catch:{ IOException -> 0x018d }
                double r6 = (double) r4     // Catch:{ IOException -> 0x018d }
                r11[r5] = r6     // Catch:{ IOException -> 0x018d }
                int r5 = r5 + 1
                goto L_0x0036
            L_0x0044:
                r3.close()     // Catch:{ IOException -> 0x0048 }
                goto L_0x004c
            L_0x0048:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x004c:
                return r11
            L_0x004d:
                int r11 = r10.f34746b     // Catch:{ IOException -> 0x018d }
                z.a$d[] r11 = new z.a.d[r11]     // Catch:{ IOException -> 0x018d }
            L_0x0051:
                int r4 = r10.f34746b     // Catch:{ IOException -> 0x018d }
                if (r5 >= r4) goto L_0x0069
                int r4 = r3.readInt()     // Catch:{ IOException -> 0x018d }
                long r6 = (long) r4     // Catch:{ IOException -> 0x018d }
                int r4 = r3.readInt()     // Catch:{ IOException -> 0x018d }
                long r8 = (long) r4     // Catch:{ IOException -> 0x018d }
                z.a$d r4 = new z.a$d     // Catch:{ IOException -> 0x018d }
                r4.<init>(r6, r8)     // Catch:{ IOException -> 0x018d }
                r11[r5] = r4     // Catch:{ IOException -> 0x018d }
                int r5 = r5 + 1
                goto L_0x0051
            L_0x0069:
                r3.close()     // Catch:{ IOException -> 0x006d }
                goto L_0x0071
            L_0x006d:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0071:
                return r11
            L_0x0072:
                int r11 = r10.f34746b     // Catch:{ IOException -> 0x018d }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x018d }
            L_0x0076:
                int r4 = r10.f34746b     // Catch:{ IOException -> 0x018d }
                if (r5 >= r4) goto L_0x0083
                int r4 = r3.readInt()     // Catch:{ IOException -> 0x018d }
                r11[r5] = r4     // Catch:{ IOException -> 0x018d }
                int r5 = r5 + 1
                goto L_0x0076
            L_0x0083:
                r3.close()     // Catch:{ IOException -> 0x0087 }
                goto L_0x008b
            L_0x0087:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x008b:
                return r11
            L_0x008c:
                int r11 = r10.f34746b     // Catch:{ IOException -> 0x018d }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x018d }
            L_0x0090:
                int r4 = r10.f34746b     // Catch:{ IOException -> 0x018d }
                if (r5 >= r4) goto L_0x009d
                short r4 = r3.readShort()     // Catch:{ IOException -> 0x018d }
                r11[r5] = r4     // Catch:{ IOException -> 0x018d }
                int r5 = r5 + 1
                goto L_0x0090
            L_0x009d:
                r3.close()     // Catch:{ IOException -> 0x00a1 }
                goto L_0x00a5
            L_0x00a1:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00a5:
                return r11
            L_0x00a6:
                int r11 = r10.f34746b     // Catch:{ IOException -> 0x018d }
                z.a$d[] r11 = new z.a.d[r11]     // Catch:{ IOException -> 0x018d }
            L_0x00aa:
                int r4 = r10.f34746b     // Catch:{ IOException -> 0x018d }
                if (r5 >= r4) goto L_0x00c0
                long r6 = r3.b()     // Catch:{ IOException -> 0x018d }
                long r8 = r3.b()     // Catch:{ IOException -> 0x018d }
                z.a$d r4 = new z.a$d     // Catch:{ IOException -> 0x018d }
                r4.<init>(r6, r8)     // Catch:{ IOException -> 0x018d }
                r11[r5] = r4     // Catch:{ IOException -> 0x018d }
                int r5 = r5 + 1
                goto L_0x00aa
            L_0x00c0:
                r3.close()     // Catch:{ IOException -> 0x00c4 }
                goto L_0x00c8
            L_0x00c4:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00c8:
                return r11
            L_0x00c9:
                int r11 = r10.f34746b     // Catch:{ IOException -> 0x018d }
                long[] r11 = new long[r11]     // Catch:{ IOException -> 0x018d }
            L_0x00cd:
                int r4 = r10.f34746b     // Catch:{ IOException -> 0x018d }
                if (r5 >= r4) goto L_0x00da
                long r6 = r3.b()     // Catch:{ IOException -> 0x018d }
                r11[r5] = r6     // Catch:{ IOException -> 0x018d }
                int r5 = r5 + 1
                goto L_0x00cd
            L_0x00da:
                r3.close()     // Catch:{ IOException -> 0x00de }
                goto L_0x00e2
            L_0x00de:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00e2:
                return r11
            L_0x00e3:
                int r11 = r10.f34746b     // Catch:{ IOException -> 0x018d }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x018d }
            L_0x00e7:
                int r4 = r10.f34746b     // Catch:{ IOException -> 0x018d }
                if (r5 >= r4) goto L_0x00f4
                int r4 = r3.readUnsignedShort()     // Catch:{ IOException -> 0x018d }
                r11[r5] = r4     // Catch:{ IOException -> 0x018d }
                int r5 = r5 + 1
                goto L_0x00e7
            L_0x00f4:
                r3.close()     // Catch:{ IOException -> 0x00f8 }
                goto L_0x00fc
            L_0x00f8:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00fc:
                return r11
            L_0x00fd:
                int r11 = r10.f34746b     // Catch:{ IOException -> 0x018d }
                byte[] r6 = z.a.f34695g     // Catch:{ IOException -> 0x018d }
                int r6 = r6.length     // Catch:{ IOException -> 0x018d }
                if (r11 < r6) goto L_0x011e
                r11 = 0
            L_0x0105:
                byte[] r6 = z.a.f34695g     // Catch:{ IOException -> 0x018d }
                int r6 = r6.length     // Catch:{ IOException -> 0x018d }
                if (r11 >= r6) goto L_0x0119
                byte[] r6 = r10.f34748d     // Catch:{ IOException -> 0x018d }
                byte r6 = r6[r11]     // Catch:{ IOException -> 0x018d }
                byte[] r7 = z.a.f34695g     // Catch:{ IOException -> 0x018d }
                byte r7 = r7[r11]     // Catch:{ IOException -> 0x018d }
                if (r6 == r7) goto L_0x0116
                r4 = 0
                goto L_0x0119
            L_0x0116:
                int r11 = r11 + 1
                goto L_0x0105
            L_0x0119:
                if (r4 == 0) goto L_0x011e
                byte[] r11 = z.a.f34695g     // Catch:{ IOException -> 0x018d }
                int r5 = r11.length     // Catch:{ IOException -> 0x018d }
            L_0x011e:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x018d }
                r11.<init>()     // Catch:{ IOException -> 0x018d }
            L_0x0123:
                int r4 = r10.f34746b     // Catch:{ IOException -> 0x018d }
                if (r5 >= r4) goto L_0x013f
                byte[] r4 = r10.f34748d     // Catch:{ IOException -> 0x018d }
                byte r4 = r4[r5]     // Catch:{ IOException -> 0x018d }
                if (r4 != 0) goto L_0x012e
                goto L_0x013f
            L_0x012e:
                r6 = 32
                if (r4 < r6) goto L_0x0137
                char r4 = (char) r4     // Catch:{ IOException -> 0x018d }
                r11.append(r4)     // Catch:{ IOException -> 0x018d }
                goto L_0x013c
            L_0x0137:
                r4 = 63
                r11.append(r4)     // Catch:{ IOException -> 0x018d }
            L_0x013c:
                int r5 = r5 + 1
                goto L_0x0123
            L_0x013f:
                java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x018d }
                r3.close()     // Catch:{ IOException -> 0x0147 }
                goto L_0x014b
            L_0x0147:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x014b:
                return r11
            L_0x014c:
                byte[] r11 = r10.f34748d     // Catch:{ IOException -> 0x018d }
                int r6 = r11.length     // Catch:{ IOException -> 0x018d }
                if (r6 != r4) goto L_0x0172
                byte r6 = r11[r5]     // Catch:{ IOException -> 0x018d }
                if (r6 < 0) goto L_0x0172
                byte r11 = r11[r5]     // Catch:{ IOException -> 0x018d }
                if (r11 > r4) goto L_0x0172
                java.lang.String r11 = new java.lang.String     // Catch:{ IOException -> 0x018d }
                char[] r4 = new char[r4]     // Catch:{ IOException -> 0x018d }
                byte[] r6 = r10.f34748d     // Catch:{ IOException -> 0x018d }
                byte r6 = r6[r5]     // Catch:{ IOException -> 0x018d }
                int r6 = r6 + 48
                char r6 = (char) r6     // Catch:{ IOException -> 0x018d }
                r4[r5] = r6     // Catch:{ IOException -> 0x018d }
                r11.<init>(r4)     // Catch:{ IOException -> 0x018d }
                r3.close()     // Catch:{ IOException -> 0x016d }
                goto L_0x0171
            L_0x016d:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0171:
                return r11
            L_0x0172:
                java.lang.String r11 = new java.lang.String     // Catch:{ IOException -> 0x018d }
                byte[] r4 = r10.f34748d     // Catch:{ IOException -> 0x018d }
                java.nio.charset.Charset r5 = z.a.f34697i     // Catch:{ IOException -> 0x018d }
                r11.<init>(r4, r5)     // Catch:{ IOException -> 0x018d }
                r3.close()     // Catch:{ IOException -> 0x017f }
                goto L_0x0183
            L_0x017f:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0183:
                return r11
            L_0x0184:
                r3.close()     // Catch:{ IOException -> 0x0188 }
                goto L_0x018c
            L_0x0188:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x018c:
                return r2
            L_0x018d:
                r11 = move-exception
                goto L_0x0193
            L_0x018f:
                r11 = move-exception
                goto L_0x01a5
            L_0x0191:
                r11 = move-exception
                r3 = r2
            L_0x0193:
                java.lang.String r4 = "IOException occurred during reading a value"
                android.util.Log.w(r1, r4, r11)     // Catch:{ all -> 0x01a3 }
                if (r3 == 0) goto L_0x01a2
                r3.close()     // Catch:{ IOException -> 0x019e }
                goto L_0x01a2
            L_0x019e:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x01a2:
                return r2
            L_0x01a3:
                r11 = move-exception
                r2 = r3
            L_0x01a5:
                if (r2 == 0) goto L_0x01af
                r2.close()     // Catch:{ IOException -> 0x01ab }
                goto L_0x01af
            L_0x01ab:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x01af:
                goto L_0x01b1
            L_0x01b0:
                throw r11
            L_0x01b1:
                goto L_0x01b0
            */
            throw new UnsupportedOperationException("Method not decompiled: z.a.b.a(java.nio.ByteOrder):java.lang.Object");
        }

        public double b(ByteOrder byteOrder) {
            Object a2 = a(byteOrder);
            if (a2 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (a2 instanceof String) {
                return Double.parseDouble((String) a2);
            } else {
                if (a2 instanceof long[]) {
                    long[] jArr = (long[]) a2;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a2 instanceof int[]) {
                    int[] iArr = (int[]) a2;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a2 instanceof double[]) {
                    double[] dArr = (double[]) a2;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a2 instanceof d[]) {
                    d[] dVarArr = (d[]) a2;
                    if (dVarArr.length == 1) {
                        return dVarArr[0].a();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int c(ByteOrder byteOrder) {
            Object a2 = a(byteOrder);
            if (a2 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (a2 instanceof String) {
                return Integer.parseInt((String) a2);
            } else {
                if (a2 instanceof long[]) {
                    long[] jArr = (long[]) a2;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a2 instanceof int[]) {
                    int[] iArr = (int[]) a2;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String d(ByteOrder byteOrder) {
            Object a2 = a(byteOrder);
            if (a2 == null) {
                return null;
            }
            if (a2 instanceof String) {
                return (String) a2;
            }
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            if (a2 instanceof long[]) {
                long[] jArr = (long[]) a2;
                while (i2 < jArr.length) {
                    sb.append(jArr[i2]);
                    i2++;
                    if (i2 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (a2 instanceof int[]) {
                int[] iArr = (int[]) a2;
                while (i2 < iArr.length) {
                    sb.append(iArr[i2]);
                    i2++;
                    if (i2 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (a2 instanceof double[]) {
                double[] dArr = (double[]) a2;
                while (i2 < dArr.length) {
                    sb.append(dArr[i2]);
                    i2++;
                    if (i2 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(a2 instanceof d[])) {
                return null;
            } else {
                d[] dVarArr = (d[]) a2;
                while (i2 < dVarArr.length) {
                    sb.append(dVarArr[i2].f34753a);
                    sb.append('/');
                    sb.append(dVarArr[i2].f34754b);
                    i2++;
                    if (i2 != dVarArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        public String toString() {
            return "(" + a.f34693e[this.f34745a] + ", data length:" + this.f34748d.length + ")";
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f34749a;

        /* renamed from: b  reason: collision with root package name */
        public final String f34750b;

        /* renamed from: c  reason: collision with root package name */
        public final int f34751c;

        /* renamed from: d  reason: collision with root package name */
        public final int f34752d;

        c(String str, int i2, int i3) {
            this.f34750b = str;
            this.f34749a = i2;
            this.f34751c = i3;
            this.f34752d = -1;
        }

        c(String str, int i2, int i3, int i4) {
            this.f34750b = str;
            this.f34749a = i2;
            this.f34751c = i3;
            this.f34752d = i4;
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i2) {
            int i3;
            int i4 = this.f34751c;
            if (i4 == 7 || i2 == 7 || i4 == i2 || (i3 = this.f34752d) == i2) {
                return true;
            }
            if ((i4 == 4 || i3 == 4) && i2 == 3) {
                return true;
            }
            if ((i4 == 9 || i3 == 9) && i2 == 8) {
                return true;
            }
            return (i4 == 12 || i3 == 12) && i2 == 11;
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        public final long f34753a;

        /* renamed from: b  reason: collision with root package name */
        public final long f34754b;

        d(long j2, long j3) {
            if (j3 == 0) {
                this.f34753a = 0;
                this.f34754b = 1;
                return;
            }
            this.f34753a = j2;
            this.f34754b = j3;
        }

        public double a() {
            double d2 = (double) this.f34753a;
            double d3 = (double) this.f34754b;
            Double.isNaN(d2);
            Double.isNaN(d3);
            return d2 / d3;
        }

        public String toString() {
            return this.f34753a + "/" + this.f34754b;
        }
    }

    static {
        c[] cVarArr = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ImageWidth", 256, 3, 4), new c("ImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", SubsamplingScaleImageView.ORIENTATION_270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", ci.a.HEADER_VIEW, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", IChannelListener.DATA_CHANNEL_EVENT_GET_PROGRESS, 4), new c("JPEGInterchangeFormatLength", IChannelListener.DATA_CHANNEL_EVENT_GET_FINISH, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("SensorTopBorder", 4, 4), new c("SensorLeftBorder", 5, 4), new c("SensorBottomBorder", 6, 4), new c("SensorRightBorder", 7, 4), new c("ISO", 23, 3), new c("JpgFromRaw", 46, 7), new c("Xmp", 700, 1)};
        H = cVarArr;
        c[] cVarArr2 = {new c("ExposureTime", 33434, 5), new c("FNumber", 33437, 5), new c("ExposureProgram", 34850, 3), new c("SpectralSensitivity", 34852, 2), new c("PhotographicSensitivity", 34855, 3), new c("OECF", 34856, 7), new c("SensitivityType", 34864, 3), new c("StandardOutputSensitivity", 34865, 4), new c("RecommendedExposureIndex", 34866, 4), new c("ISOSpeed", 34867, 4), new c("ISOSpeedLatitudeyyy", 34868, 4), new c("ISOSpeedLatitudezzz", 34869, 4), new c("ExifVersion", 36864, 2), new c("DateTimeOriginal", 36867, 2), new c("DateTimeDigitized", 36868, 2), new c("OffsetTime", 36880, 2), new c("OffsetTimeOriginal", 36881, 2), new c("OffsetTimeDigitized", 36882, 2), new c("ComponentsConfiguration", 37121, 7), new c("CompressedBitsPerPixel", 37122, 5), new c("ShutterSpeedValue", 37377, 10), new c("ApertureValue", 37378, 5), new c("BrightnessValue", 37379, 10), new c("ExposureBiasValue", 37380, 10), new c("MaxApertureValue", 37381, 5), new c("SubjectDistance", 37382, 5), new c("MeteringMode", 37383, 3), new c("LightSource", 37384, 3), new c("Flash", 37385, 3), new c("FocalLength", 37386, 5), new c("SubjectArea", 37396, 3), new c("MakerNote", 37500, 7), new c("UserComment", 37510, 7), new c("SubSecTime", 37520, 2), new c("SubSecTimeOriginal", 37521, 2), new c("SubSecTimeDigitized", 37522, 2), new c("FlashpixVersion", 40960, 7), new c("ColorSpace", 40961, 3), new c("PixelXDimension", 40962, 3, 4), new c("PixelYDimension", 40963, 3, 4), new c("RelatedSoundFile", 40964, 2), new c("InteroperabilityIFDPointer", 40965, 4), new c("FlashEnergy", 41483, 5), new c("SpatialFrequencyResponse", 41484, 7), new c("FocalPlaneXResolution", 41486, 5), new c("FocalPlaneYResolution", 41487, 5), new c("FocalPlaneResolutionUnit", 41488, 3), new c("SubjectLocation", 41492, 3), new c("ExposureIndex", 41493, 5), new c("SensingMethod", 41495, 3), new c("FileSource", 41728, 7), new c("SceneType", 41729, 7), new c("CFAPattern", 41730, 7), new c("CustomRendered", 41985, 3), new c("ExposureMode", 41986, 3), new c("WhiteBalance", 41987, 3), new c("DigitalZoomRatio", 41988, 5), new c("FocalLengthIn35mmFilm", 41989, 3), new c("SceneCaptureType", 41990, 3), new c("GainControl", 41991, 3), new c("Contrast", 41992, 3), new c("Saturation", 41993, 3), new c("Sharpness", 41994, 3), new c("DeviceSettingDescription", 41995, 7), new c("SubjectDistanceRange", 41996, 3), new c("ImageUniqueID", 42016, 2), new c("CameraOwnerName", 42032, 2), new c("BodySerialNumber", 42033, 2), new c("LensSpecification", 42034, 5), new c("LensMake", 42035, 2), new c("LensModel", 42036, 2), new c("Gamma", 42240, 5), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
        I = cVarArr2;
        c[] cVarArr3 = {new c("GPSVersionID", 0, 1), new c("GPSLatitudeRef", 1, 2), new c("GPSLatitude", 2, 5), new c("GPSLongitudeRef", 3, 2), new c("GPSLongitude", 4, 5), new c("GPSAltitudeRef", 5, 1), new c("GPSAltitude", 6, 5), new c("GPSTimeStamp", 7, 5), new c("GPSSatellites", 8, 2), new c("GPSStatus", 9, 2), new c("GPSMeasureMode", 10, 2), new c("GPSDOP", 11, 5), new c("GPSSpeedRef", 12, 2), new c("GPSSpeed", 13, 5), new c("GPSTrackRef", 14, 2), new c("GPSTrack", 15, 5), new c("GPSImgDirectionRef", 16, 2), new c("GPSImgDirection", 17, 5), new c("GPSMapDatum", 18, 2), new c("GPSDestLatitudeRef", 19, 2), new c("GPSDestLatitude", 20, 5), new c("GPSDestLongitudeRef", 21, 2), new c("GPSDestLongitude", 22, 5), new c("GPSDestBearingRef", 23, 2), new c("GPSDestBearing", 24, 5), new c("GPSDestDistanceRef", 25, 2), new c("GPSDestDistance", 26, 5), new c("GPSProcessingMethod", 27, 7), new c("GPSAreaInformation", 28, 7), new c("GPSDateStamp", 29, 2), new c("GPSDifferential", 30, 3), new c("GPSHPositioningError", 31, 5)};
        J = cVarArr3;
        c[] cVarArr4 = {new c("InteroperabilityIndex", 1, 2)};
        K = cVarArr4;
        c[] cVarArr5 = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ThumbnailImageWidth", 256, 3, 4), new c("ThumbnailImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", SubsamplingScaleImageView.ORIENTATION_270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", ci.a.HEADER_VIEW, 3, 4), new c("ThumbnailOrientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", IChannelListener.DATA_CHANNEL_EVENT_GET_PROGRESS, 4), new c("JPEGInterchangeFormatLength", IChannelListener.DATA_CHANNEL_EVENT_GET_FINISH, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
        L = cVarArr5;
        c[] cVarArr6 = {new c("ThumbnailImage", 256, 7), new c("CameraSettingsIFDPointer", 8224, 4), new c("ImageProcessingIFDPointer", 8256, 4)};
        N = cVarArr6;
        c[] cVarArr7 = {new c("PreviewImageStart", 257, 4), new c("PreviewImageLength", 258, 4)};
        O = cVarArr7;
        c[] cVarArr8 = {new c("AspectFrame", 4371, 3)};
        P = cVarArr8;
        c[] cVarArr9 = {new c("ColorSpace", 55, 3)};
        Q = cVarArr9;
        c[][] cVarArr10 = {cVarArr, cVarArr2, cVarArr3, cVarArr4, cVarArr5, cVarArr, cVarArr6, cVarArr7, cVarArr8, cVarArr9};
        f34696h = cVarArr10;
        U = new HashMap[cVarArr10.length];
        V = new HashMap[cVarArr10.length];
        Charset forName = Charset.forName("US-ASCII");
        f34697i = forName;
        f34698j = "Exif\u0000\u0000".getBytes(forName);
        Y = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        G = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i2 = 0;
        while (true) {
            c[][] cVarArr11 = f34696h;
            if (i2 < cVarArr11.length) {
                U[i2] = new HashMap<>();
                V[i2] = new HashMap<>();
                for (c cVar : cVarArr11[i2]) {
                    U[i2].put(Integer.valueOf(cVar.f34749a), cVar);
                    V[i2].put(cVar.f34750b, cVar);
                }
                i2++;
            } else {
                HashMap<Integer, Integer> hashMap = X;
                c[] cVarArr12 = R;
                hashMap.put(Integer.valueOf(cVarArr12[0].f34749a), 5);
                hashMap.put(Integer.valueOf(cVarArr12[1].f34749a), 1);
                hashMap.put(Integer.valueOf(cVarArr12[2].f34749a), 2);
                hashMap.put(Integer.valueOf(cVarArr12[3].f34749a), 3);
                hashMap.put(Integer.valueOf(cVarArr12[4].f34749a), 7);
                hashMap.put(Integer.valueOf(cVarArr12[5].f34749a), 8);
                return;
            }
        }
    }

    public a(File file) throws IOException {
        c[][] cVarArr = f34696h;
        this.f34719ae = new HashMap[cVarArr.length];
        this.f34720af = new HashSet(cVarArr.length);
        this.f34721ag = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(file, "file cannot be null");
        c(file.getAbsolutePath());
    }

    public a(InputStream inputStream) throws IOException {
        this(inputStream, false);
    }

    private a(InputStream inputStream, boolean z2) throws IOException {
        c[][] cVarArr = f34696h;
        this.f34719ae = new HashMap[cVarArr.length];
        this.f34720af = new HashSet(cVarArr.length);
        this.f34721ag = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(inputStream, "inputStream cannot be null");
        this.Z = null;
        if (z2) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            if (!b(bufferedInputStream)) {
                Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                return;
            }
            this.f34718ad = true;
            this.f34716ab = null;
            this.f34715aa = null;
            inputStream = bufferedInputStream;
        } else {
            if (inputStream instanceof AssetManager.AssetInputStream) {
                this.f34716ab = (AssetManager.AssetInputStream) inputStream;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (a(fileInputStream.getFD())) {
                        this.f34716ab = null;
                        this.f34715aa = fileInputStream.getFD();
                    }
                }
                this.f34716ab = null;
            }
            this.f34715aa = null;
        }
        a(inputStream);
    }

    public a(String str) throws IOException {
        c[][] cVarArr = f34696h;
        this.f34719ae = new HashMap[cVarArr.length];
        this.f34720af = new HashSet(cVarArr.length);
        this.f34721ag = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(str, "filename cannot be null");
        c(str);
    }

    private int a(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (a(bArr)) {
            return 4;
        }
        if (b(bArr)) {
            return 9;
        }
        if (c(bArr)) {
            return 12;
        }
        if (d(bArr)) {
            return 7;
        }
        if (e(bArr)) {
            return 10;
        }
        if (f(bArr)) {
            return 13;
        }
        return g(bArr) ? 14 : 0;
    }

    private void a() {
        for (int i2 = 0; i2 < this.f34719ae.length; i2++) {
            Log.d("ExifInterface", "The size of tag group[" + i2 + "]: " + this.f34719ae[i2].size());
            for (Map.Entry next : this.f34719ae[i2].entrySet()) {
                b bVar = (b) next.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) next.getKey()) + ", tagType: " + bVar.toString() + ", tagValue: '" + bVar.d(this.f34721ag) + "'");
            }
        }
    }

    private void a(int i2, int i3) throws IOException {
        String str;
        if (!this.f34719ae[i2].isEmpty() && !this.f34719ae[i3].isEmpty()) {
            b bVar = this.f34719ae[i2].get("ImageLength");
            b bVar2 = this.f34719ae[i2].get("ImageWidth");
            b bVar3 = this.f34719ae[i3].get("ImageLength");
            b bVar4 = this.f34719ae[i3].get("ImageWidth");
            if (bVar == null || bVar2 == null) {
                if (f34699k) {
                    str = "First image does not contain valid size information";
                } else {
                    return;
                }
            } else if (bVar3 != null && bVar4 != null) {
                int c2 = bVar.c(this.f34721ag);
                int c3 = bVar2.c(this.f34721ag);
                int c4 = bVar3.c(this.f34721ag);
                int c5 = bVar4.c(this.f34721ag);
                if (c2 < c4 && c3 < c5) {
                    HashMap<String, b>[] hashMapArr = this.f34719ae;
                    HashMap<String, b> hashMap = hashMapArr[i2];
                    hashMapArr[i2] = hashMapArr[i3];
                    hashMapArr[i3] = hashMap;
                    return;
                }
                return;
            } else if (f34699k) {
                str = "Second image does not contain valid size information";
            } else {
                return;
            }
            Log.d("ExifInterface", str);
        } else if (f34699k) {
            Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    private void a(InputStream inputStream) {
        Objects.requireNonNull(inputStream, "inputstream shouldn't be null");
        int i2 = 0;
        while (i2 < f34696h.length) {
            try {
                this.f34719ae[i2] = new HashMap<>();
                i2++;
            } catch (IOException e2) {
                this.f34734at = false;
                boolean z2 = f34699k;
                if (z2) {
                    Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e2);
                }
                b();
                if (!z2) {
                    return;
                }
            } catch (Throwable th) {
                b();
                if (f34699k) {
                    a();
                }
                throw th;
            }
        }
        if (!this.f34718ad) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            this.f34717ac = a(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        C0267a aVar = new C0267a(inputStream);
        if (!this.f34718ad) {
            switch (this.f34717ac) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 5:
                case 6:
                case 8:
                case 11:
                    a(aVar);
                    break;
                case 4:
                    a(aVar, 0, 0);
                    break;
                case 7:
                    e(aVar);
                    break;
                case 9:
                    b(aVar);
                    break;
                case 10:
                    f(aVar);
                    break;
                case 12:
                    c(aVar);
                    break;
                case 13:
                    g(aVar);
                    break;
                case 14:
                    h(aVar);
                    break;
            }
        } else {
            d(aVar);
        }
        j(aVar);
        this.f34734at = true;
        b();
        if (!f34699k) {
            return;
        }
        a();
    }

    private void a(C0267a aVar) throws IOException {
        b bVar;
        a(aVar, aVar.available());
        b(aVar, 0);
        d(aVar, 0);
        d(aVar, 5);
        d(aVar, 4);
        c();
        if (this.f34717ac == 8 && (bVar = this.f34719ae[1].get("MakerNote")) != null) {
            C0267a aVar2 = new C0267a(bVar.f34748d);
            aVar2.a(this.f34721ag);
            aVar2.a(6);
            b(aVar2, 9);
            b bVar2 = this.f34719ae[9].get("ColorSpace");
            if (bVar2 != null) {
                this.f34719ae[1].put("ColorSpace", bVar2);
            }
        }
    }

    private void a(C0267a aVar, int i2) throws IOException {
        ByteOrder i3 = i(aVar);
        this.f34721ag = i3;
        aVar.a(i3);
        int readUnsignedShort = aVar.readUnsignedShort();
        int i4 = this.f34717ac;
        if (i4 == 7 || i4 == 10 || readUnsignedShort == 42) {
            int readInt = aVar.readInt();
            if (readInt < 8 || readInt >= i2) {
                throw new IOException("Invalid first Ifd offset: " + readInt);
            }
            int i5 = readInt - 8;
            if (i5 > 0 && aVar.skipBytes(i5) != i5) {
                throw new IOException("Couldn't jump to first Ifd: " + i5);
            }
            return;
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x018d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(z.a.C0267a r20, int r21, int r22) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            boolean r4 = f34699k
            java.lang.String r5 = "ExifInterface"
            if (r4 == 0) goto L_0x0022
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "getJpegAttributes starting with: "
            r4.append(r6)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r5, r4)
        L_0x0022:
            java.nio.ByteOrder r4 = java.nio.ByteOrder.BIG_ENDIAN
            r1.a((java.nio.ByteOrder) r4)
            long r6 = (long) r2
            r1.a((long) r6)
            byte r4 = r20.readByte()
            java.lang.String r6 = "Invalid marker: "
            r7 = -1
            if (r4 != r7) goto L_0x01d7
            r8 = 1
            int r2 = r2 + r8
            byte r9 = r20.readByte()
            r10 = -40
            if (r9 != r10) goto L_0x01bc
            int r2 = r2 + r8
        L_0x003f:
            byte r4 = r20.readByte()
            if (r4 != r7) goto L_0x019f
            int r2 = r2 + r8
            byte r4 = r20.readByte()
            boolean r6 = f34699k
            if (r6 == 0) goto L_0x0068
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Found JPEG segment indicator: "
            r9.append(r10)
            r10 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r10 = java.lang.Integer.toHexString(r10)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r5, r9)
        L_0x0068:
            int r2 = r2 + r8
            r9 = -39
            if (r4 == r9) goto L_0x0199
            r9 = -38
            if (r4 != r9) goto L_0x0073
            goto L_0x0199
        L_0x0073:
            int r9 = r20.readUnsignedShort()
            int r9 = r9 + -2
            int r2 = r2 + 2
            if (r6 == 0) goto L_0x00a6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r10 = "JPEG segment: "
            r6.append(r10)
            r10 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r10 = java.lang.Integer.toHexString(r10)
            r6.append(r10)
            java.lang.String r10 = " (length: "
            r6.append(r10)
            int r10 = r9 + 2
            r6.append(r10)
            java.lang.String r10 = ")"
            r6.append(r10)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r5, r6)
        L_0x00a6:
            java.lang.String r6 = "Invalid length"
            if (r9 < 0) goto L_0x0193
            r10 = -31
            r11 = 0
            if (r4 == r10) goto L_0x0128
            r10 = -2
            if (r4 == r10) goto L_0x00fb
            switch(r4) {
                case -64: goto L_0x00c2;
                case -63: goto L_0x00c2;
                case -62: goto L_0x00c2;
                case -61: goto L_0x00c2;
                default: goto L_0x00b5;
            }
        L_0x00b5:
            switch(r4) {
                case -59: goto L_0x00c2;
                case -58: goto L_0x00c2;
                case -57: goto L_0x00c2;
                default: goto L_0x00b8;
            }
        L_0x00b8:
            switch(r4) {
                case -55: goto L_0x00c2;
                case -54: goto L_0x00c2;
                case -53: goto L_0x00c2;
                default: goto L_0x00bb;
            }
        L_0x00bb:
            switch(r4) {
                case -51: goto L_0x00c2;
                case -50: goto L_0x00c2;
                case -49: goto L_0x00c2;
                default: goto L_0x00be;
            }
        L_0x00be:
            r10 = r2
            r2 = 1
            goto L_0x0176
        L_0x00c2:
            int r4 = r1.skipBytes(r8)
            if (r4 != r8) goto L_0x00f3
            java.util.HashMap<java.lang.String, z.a$b>[] r4 = r0.f34719ae
            r4 = r4[r3]
            int r10 = r20.readUnsignedShort()
            long r10 = (long) r10
            java.nio.ByteOrder r12 = r0.f34721ag
            z.a$b r10 = z.a.b.a((long) r10, (java.nio.ByteOrder) r12)
            java.lang.String r11 = "ImageLength"
            r4.put(r11, r10)
            java.util.HashMap<java.lang.String, z.a$b>[] r4 = r0.f34719ae
            r4 = r4[r3]
            int r10 = r20.readUnsignedShort()
            long r10 = (long) r10
            java.nio.ByteOrder r12 = r0.f34721ag
            z.a$b r10 = z.a.b.a((long) r10, (java.nio.ByteOrder) r12)
            java.lang.String r11 = "ImageWidth"
            r4.put(r11, r10)
            int r9 = r9 + -5
            goto L_0x00be
        L_0x00f3:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid SOFx"
            r1.<init>(r2)
            throw r1
        L_0x00fb:
            byte[] r4 = new byte[r9]
            int r10 = r1.read(r4)
            if (r10 != r9) goto L_0x0120
            java.lang.String r9 = "UserComment"
            java.lang.String r10 = r0.a((java.lang.String) r9)
            if (r10 != 0) goto L_0x011d
            java.util.HashMap<java.lang.String, z.a$b>[] r10 = r0.f34719ae
            r10 = r10[r8]
            java.lang.String r12 = new java.lang.String
            java.nio.charset.Charset r13 = f34697i
            r12.<init>(r4, r13)
            z.a$b r4 = z.a.b.a((java.lang.String) r12)
            r10.put(r9, r4)
        L_0x011d:
            r10 = r2
        L_0x011e:
            r2 = 1
            goto L_0x0175
        L_0x0120:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid exif"
            r1.<init>(r2)
            throw r1
        L_0x0128:
            byte[] r4 = new byte[r9]
            r1.readFully(r4)
            int r10 = r2 + r9
            byte[] r12 = f34698j
            boolean r13 = a((byte[]) r4, (byte[]) r12)
            if (r13 == 0) goto L_0x0144
            int r13 = r12.length
            int r2 = r2 + r13
            int r12 = r12.length
            byte[] r4 = java.util.Arrays.copyOfRange(r4, r12, r9)
            r0.f34729ao = r2
            r0.a((byte[]) r4, (int) r3)
            goto L_0x011e
        L_0x0144:
            byte[] r12 = Y
            boolean r13 = a((byte[]) r4, (byte[]) r12)
            if (r13 == 0) goto L_0x011e
            int r13 = r12.length
            int r2 = r2 + r13
            int r12 = r12.length
            byte[] r4 = java.util.Arrays.copyOfRange(r4, r12, r9)
            java.lang.String r9 = "Xmp"
            java.lang.String r12 = r0.a((java.lang.String) r9)
            if (r12 != 0) goto L_0x011e
            java.util.HashMap<java.lang.String, z.a$b>[] r12 = r0.f34719ae
            r12 = r12[r11]
            z.a$b r15 = new z.a$b
            r14 = 1
            int r13 = r4.length
            long r7 = (long) r2
            r2 = r13
            r13 = r15
            r11 = r15
            r15 = r2
            r16 = r7
            r18 = r4
            r13.<init>(r14, r15, r16, r18)
            r12.put(r9, r11)
            r2 = 1
            r0.f34735au = r2
        L_0x0175:
            r9 = 0
        L_0x0176:
            if (r9 < 0) goto L_0x018d
            int r4 = r1.skipBytes(r9)
            if (r4 != r9) goto L_0x0185
            int r4 = r10 + r9
            r2 = r4
            r7 = -1
            r8 = 1
            goto L_0x003f
        L_0x0185:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid JPEG segment"
            r1.<init>(r2)
            throw r1
        L_0x018d:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r6)
            throw r1
        L_0x0193:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r6)
            throw r1
        L_0x0199:
            java.nio.ByteOrder r2 = r0.f34721ag
            r1.a((java.nio.ByteOrder) r2)
            return
        L_0x019f:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid marker:"
            r2.append(r3)
            r3 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01bc:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r3 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01d7:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r3 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            goto L_0x01f3
        L_0x01f2:
            throw r1
        L_0x01f3:
            goto L_0x01f2
        */
        throw new UnsupportedOperationException("Method not decompiled: z.a.a(z.a$a, int, int):void");
    }

    private void a(C0267a aVar, HashMap hashMap) throws IOException {
        b bVar = (b) hashMap.get("JPEGInterchangeFormat");
        b bVar2 = (b) hashMap.get("JPEGInterchangeFormatLength");
        if (bVar != null && bVar2 != null) {
            int c2 = bVar.c(this.f34721ag);
            int c3 = bVar2.c(this.f34721ag);
            if (this.f34717ac == 7) {
                c2 += this.f34730ap;
            }
            int min = Math.min(c3, aVar.c() - c2);
            if (c2 > 0 && min > 0) {
                this.f34722ah = true;
                int i2 = this.f34729ao + c2;
                this.f34725ak = i2;
                this.f34726al = min;
                if (this.Z == null && this.f34716ab == null && this.f34715aa == null) {
                    byte[] bArr = new byte[min];
                    aVar.a((long) i2);
                    aVar.readFully(bArr);
                    this.f34727am = bArr;
                }
            }
            if (f34699k) {
                Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + c2 + ", length: " + min);
            }
        }
    }

    private void a(byte[] bArr, int i2) throws IOException {
        C0267a aVar = new C0267a(bArr);
        a(aVar, bArr.length);
        b(aVar, i2);
    }

    private static boolean a(FileDescriptor fileDescriptor) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Os.lseek(fileDescriptor, 0, OsConstants.SEEK_CUR);
                return true;
            } catch (Exception unused) {
                if (f34699k) {
                    Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                }
            }
        }
        return false;
    }

    private boolean a(HashMap hashMap) throws IOException {
        b bVar;
        int c2;
        b bVar2 = (b) hashMap.get("BitsPerSample");
        if (bVar2 != null) {
            int[] iArr = (int[]) bVar2.a(this.f34721ag);
            int[] iArr2 = f34687a;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.f34717ac == 3 && (bVar = (b) hashMap.get("PhotometricInterpretation")) != null && (((c2 = bVar.c(this.f34721ag)) == 1 && Arrays.equals(iArr, f34691c)) || (c2 == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!f34699k) {
            return false;
        }
        Log.d("ExifInterface", "Unsupported data type value");
        return false;
    }

    private static boolean a(byte[] bArr) throws IOException {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f34692d;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static long[] a(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jArr[i2] = (long) iArr[i2];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }

    private b b(String str) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        if ("ISOSpeedRatings".equals(str)) {
            if (f34699k) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i2 = 0; i2 < f34696h.length; i2++) {
            b bVar = this.f34719ae[i2].get(str);
            if (bVar != null) {
                return bVar;
            }
        }
        return null;
    }

    private void b() {
        String a2 = a("DateTimeOriginal");
        if (a2 != null && a("DateTime") == null) {
            this.f34719ae[0].put("DateTime", b.a(a2));
        }
        if (a("ImageWidth") == null) {
            this.f34719ae[0].put("ImageWidth", b.a(0, this.f34721ag));
        }
        if (a("ImageLength") == null) {
            this.f34719ae[0].put("ImageLength", b.a(0, this.f34721ag));
        }
        if (a("Orientation") == null) {
            this.f34719ae[0].put("Orientation", b.a(0, this.f34721ag));
        }
        if (a("LightSource") == null) {
            this.f34719ae[1].put("LightSource", b.a(0, this.f34721ag));
        }
    }

    private void b(C0267a aVar) throws IOException {
        aVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        aVar.read(bArr);
        aVar.skipBytes(4);
        aVar.read(bArr2);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        a(aVar, i2, 5);
        aVar.a((long) i3);
        aVar.a(ByteOrder.BIG_ENDIAN);
        int readInt = aVar.readInt();
        if (f34699k) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + readInt);
        }
        for (int i4 = 0; i4 < readInt; i4++) {
            int readUnsignedShort = aVar.readUnsignedShort();
            int readUnsignedShort2 = aVar.readUnsignedShort();
            if (readUnsignedShort == M.f34749a) {
                short readShort = aVar.readShort();
                short readShort2 = aVar.readShort();
                b a2 = b.a((int) readShort, this.f34721ag);
                b a3 = b.a((int) readShort2, this.f34721ag);
                this.f34719ae[0].put("ImageLength", a2);
                this.f34719ae[0].put("ImageWidth", a3);
                if (f34699k) {
                    Log.d("ExifInterface", "Updated to length: " + readShort + ", width: " + readShort2);
                    return;
                }
                return;
            }
            aVar.skipBytes(readUnsignedShort2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02a0  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0147  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(z.a.C0267a r31, int r32) throws java.io.IOException {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            r2 = r32
            java.util.Set<java.lang.Integer> r3 = r0.f34720af
            int r4 = r1.f34742b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            int r3 = r1.f34742b
            r4 = 2
            int r3 = r3 + r4
            int r5 = r1.f34741a
            if (r3 <= r5) goto L_0x001a
            return
        L_0x001a:
            short r3 = r31.readShort()
            boolean r5 = f34699k
            java.lang.String r6 = "ExifInterface"
            if (r5 == 0) goto L_0x0038
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "numberOfDirectoryEntry: "
            r5.append(r7)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r6, r5)
        L_0x0038:
            int r5 = r1.f34742b
            int r7 = r3 * 12
            int r5 = r5 + r7
            int r7 = r1.f34741a
            if (r5 > r7) goto L_0x03fb
            if (r3 > 0) goto L_0x0045
            goto L_0x03fb
        L_0x0045:
            r5 = 0
            r7 = 0
        L_0x0047:
            r8 = 5
            if (r7 >= r3) goto L_0x037e
            int r13 = r31.readUnsignedShort()
            int r14 = r31.readUnsignedShort()
            int r15 = r31.readInt()
            int r9 = r31.a()
            long r9 = (long) r9
            r18 = 4
            long r9 = r9 + r18
            java.util.HashMap<java.lang.Integer, z.a$c>[] r20 = U
            r12 = r20[r2]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)
            java.lang.Object r4 = r12.get(r4)
            z.a$c r4 = (z.a.c) r4
            boolean r12 = f34699k
            r11 = 3
            if (r12 == 0) goto L_0x00a3
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.Integer r23 = java.lang.Integer.valueOf(r32)
            r8[r5] = r23
            java.lang.Integer r23 = java.lang.Integer.valueOf(r13)
            r20 = 1
            r8[r20] = r23
            if (r4 == 0) goto L_0x0087
            java.lang.String r5 = r4.f34750b
            goto L_0x0088
        L_0x0087:
            r5 = 0
        L_0x0088:
            r22 = 2
            r8[r22] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r14)
            r8[r11] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r15)
            r21 = 4
            r8[r21] = r5
            java.lang.String r5 = "ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d"
            java.lang.String r5 = java.lang.String.format(r5, r8)
            android.util.Log.d(r6, r5)
        L_0x00a3:
            r5 = 7
            if (r4 != 0) goto L_0x00c1
            if (r12 == 0) goto L_0x00bc
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r11 = "Skip the tag entry since tag number is not defined: "
            r8.append(r11)
            r8.append(r13)
        L_0x00b5:
            java.lang.String r8 = r8.toString()
            android.util.Log.d(r6, r8)
        L_0x00bc:
            r11 = r6
            r25 = r7
            goto L_0x013a
        L_0x00c1:
            if (r14 <= 0) goto L_0x0121
            int[] r8 = f34694f
            int r11 = r8.length
            if (r14 < r11) goto L_0x00c9
            goto L_0x0121
        L_0x00c9:
            boolean r11 = r4.a(r14)
            if (r11 != 0) goto L_0x00ed
            if (r12 == 0) goto L_0x00bc
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r11 = "Skip the tag entry since data format ("
            r8.append(r11)
            java.lang.String[] r11 = f34693e
            r11 = r11[r14]
            r8.append(r11)
            java.lang.String r11 = ") is unexpected for tag: "
            r8.append(r11)
            java.lang.String r11 = r4.f34750b
            r8.append(r11)
            goto L_0x00b5
        L_0x00ed:
            if (r14 != r5) goto L_0x00f1
            int r14 = r4.f34751c
        L_0x00f1:
            r11 = r6
            long r5 = (long) r15
            r8 = r8[r14]
            r25 = r7
            long r7 = (long) r8
            long r5 = r5 * r7
            r7 = 0
            int r26 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r26 < 0) goto L_0x010a
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r26 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r26 <= 0) goto L_0x0108
            goto L_0x010a
        L_0x0108:
            r7 = 1
            goto L_0x013d
        L_0x010a:
            if (r12 == 0) goto L_0x013c
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Skip the tag entry since the number of components is invalid: "
            r7.append(r8)
            r7.append(r15)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r11, r7)
            goto L_0x013c
        L_0x0121:
            r11 = r6
            r25 = r7
            if (r12 == 0) goto L_0x013a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Skip the tag entry since data format is invalid: "
            r5.append(r6)
            r5.append(r14)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r11, r5)
        L_0x013a:
            r5 = 0
        L_0x013c:
            r7 = 0
        L_0x013d:
            if (r7 != 0) goto L_0x0147
            r1.a((long) r9)
            r26 = r3
        L_0x0144:
            r13 = 2
            goto L_0x0372
        L_0x0147:
            java.lang.String r7 = "Compression"
            int r8 = (r5 > r18 ? 1 : (r5 == r18 ? 0 : -1))
            if (r8 <= 0) goto L_0x020f
            int r8 = r31.readInt()
            r26 = r3
            if (r12 == 0) goto L_0x016c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r18 = r14
            java.lang.String r14 = "seek to data offset: "
            r3.append(r14)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r11, r3)
            goto L_0x016e
        L_0x016c:
            r18 = r14
        L_0x016e:
            int r3 = r0.f34717ac
            r14 = 7
            if (r3 != r14) goto L_0x01ce
            java.lang.String r3 = r4.f34750b
            java.lang.String r14 = "MakerNote"
            boolean r3 = r14.equals(r3)
            if (r3 == 0) goto L_0x0180
            r0.f34730ap = r8
            goto L_0x01c9
        L_0x0180:
            r3 = 6
            if (r2 != r3) goto L_0x01c9
            java.lang.String r14 = r4.f34750b
            java.lang.String r3 = "ThumbnailImage"
            boolean r3 = r3.equals(r14)
            if (r3 == 0) goto L_0x01c9
            r0.f34731aq = r8
            r0.f34732ar = r15
            java.nio.ByteOrder r3 = r0.f34721ag
            r14 = 6
            z.a$b r3 = z.a.b.a((int) r14, (java.nio.ByteOrder) r3)
            int r14 = r0.f34731aq
            r19 = r15
            long r14 = (long) r14
            java.nio.ByteOrder r2 = r0.f34721ag
            z.a$b r2 = z.a.b.a((long) r14, (java.nio.ByteOrder) r2)
            int r14 = r0.f34732ar
            long r14 = (long) r14
            r24 = r13
            java.nio.ByteOrder r13 = r0.f34721ag
            z.a$b r13 = z.a.b.a((long) r14, (java.nio.ByteOrder) r13)
            java.util.HashMap<java.lang.String, z.a$b>[] r14 = r0.f34719ae
            r15 = 4
            r14 = r14[r15]
            r14.put(r7, r3)
            java.util.HashMap<java.lang.String, z.a$b>[] r3 = r0.f34719ae
            r3 = r3[r15]
            java.lang.String r14 = "JPEGInterchangeFormat"
            r3.put(r14, r2)
            java.util.HashMap<java.lang.String, z.a$b>[] r2 = r0.f34719ae
            r2 = r2[r15]
            java.lang.String r3 = "JPEGInterchangeFormatLength"
            r2.put(r3, r13)
            goto L_0x01e2
        L_0x01c9:
            r24 = r13
            r19 = r15
            goto L_0x01e2
        L_0x01ce:
            r24 = r13
            r19 = r15
            r2 = 10
            if (r3 != r2) goto L_0x01e2
            java.lang.String r2 = r4.f34750b
            java.lang.String r3 = "JpgFromRaw"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x01e2
            r0.f34733as = r8
        L_0x01e2:
            long r2 = (long) r8
            long r13 = r2 + r5
            int r15 = r1.f34741a
            r27 = r4
            r28 = r5
            long r4 = (long) r15
            int r6 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x01f4
            r1.a((long) r2)
            goto L_0x021b
        L_0x01f4:
            if (r12 == 0) goto L_0x020a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Skip the tag entry since data offset is invalid: "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r11, r2)
        L_0x020a:
            r1.a((long) r9)
            goto L_0x0144
        L_0x020f:
            r26 = r3
            r27 = r4
            r28 = r5
            r24 = r13
            r18 = r14
            r19 = r15
        L_0x021b:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r2 = X
            java.lang.Integer r3 = java.lang.Integer.valueOf(r24)
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r12 == 0) goto L_0x0248
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "nextIfdType: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r4 = " byteCount: "
            r3.append(r4)
            r5 = r28
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r11, r3)
            goto L_0x024a
        L_0x0248:
            r5 = r28
        L_0x024a:
            r3 = 8
            if (r2 == 0) goto L_0x02f4
            r4 = -1
            r14 = r18
            r6 = 3
            if (r14 == r6) goto L_0x0272
            r6 = 4
            if (r14 == r6) goto L_0x026d
            if (r14 == r3) goto L_0x0268
            r3 = 9
            if (r14 == r3) goto L_0x0263
            r3 = 13
            if (r14 == r3) goto L_0x0263
            goto L_0x0277
        L_0x0263:
            int r3 = r31.readInt()
            goto L_0x0276
        L_0x0268:
            short r3 = r31.readShort()
            goto L_0x0276
        L_0x026d:
            long r4 = r31.b()
            goto L_0x0277
        L_0x0272:
            int r3 = r31.readUnsignedShort()
        L_0x0276:
            long r4 = (long) r3
        L_0x0277:
            r13 = 2
            if (r12 == 0) goto L_0x0293
            java.lang.Object[] r3 = new java.lang.Object[r13]
            java.lang.Long r6 = java.lang.Long.valueOf(r4)
            r7 = 0
            r3[r7] = r6
            r8 = r27
            java.lang.String r6 = r8.f34750b
            r7 = 1
            r3[r7] = r6
            java.lang.String r6 = "Offset: %d, tagName: %s"
            java.lang.String r3 = java.lang.String.format(r6, r3)
            android.util.Log.d(r11, r3)
        L_0x0293:
            r6 = 0
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x02d9
            int r3 = r1.f34741a
            long r6 = (long) r3
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x02d9
            java.util.Set<java.lang.Integer> r3 = r0.f34720af
            int r6 = (int) r4
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            boolean r3 = r3.contains(r6)
            if (r3 != 0) goto L_0x02b8
            r1.a((long) r4)
            int r2 = r2.intValue()
            r0.b((z.a.C0267a) r1, (int) r2)
            goto L_0x02ef
        L_0x02b8:
            if (r12 == 0) goto L_0x02ef
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "Skip jump into the IFD since it has already been read: IfdType "
            r3.append(r6)
            r3.append(r2)
            java.lang.String r2 = " (at "
            r3.append(r2)
            r3.append(r4)
            java.lang.String r2 = ")"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            goto L_0x02ec
        L_0x02d9:
            if (r12 == 0) goto L_0x02ef
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Skip jump into the IFD since its offset is invalid: "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
        L_0x02ec:
            android.util.Log.d(r11, r2)
        L_0x02ef:
            r1.a((long) r9)
            goto L_0x0372
        L_0x02f4:
            r14 = r18
            r8 = r27
            r13 = 2
            int r2 = r31.a()
            int r4 = r0.f34729ao
            int r2 = r2 + r4
            int r4 = (int) r5
            byte[] r4 = new byte[r4]
            r1.readFully(r4)
            z.a$b r5 = new z.a$b
            r12 = r4
            long r3 = (long) r2
            r2 = r19
            r15 = r5
            r16 = r14
            r17 = r2
            r18 = r3
            r20 = r12
            r15.<init>(r16, r17, r18, r20)
            java.util.HashMap<java.lang.String, z.a$b>[] r2 = r0.f34719ae
            r2 = r2[r32]
            java.lang.String r3 = r8.f34750b
            r2.put(r3, r5)
            java.lang.String r2 = r8.f34750b
            java.lang.String r3 = "DNGVersion"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x032e
            r2 = 3
            r0.f34717ac = r2
        L_0x032e:
            java.lang.String r2 = r8.f34750b
            java.lang.String r3 = "Make"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0342
            java.lang.String r2 = r8.f34750b
            java.lang.String r3 = "Model"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0350
        L_0x0342:
            java.nio.ByteOrder r2 = r0.f34721ag
            java.lang.String r2 = r5.d(r2)
            java.lang.String r3 = "PENTAX"
            boolean r2 = r2.contains(r3)
            if (r2 != 0) goto L_0x0363
        L_0x0350:
            java.lang.String r2 = r8.f34750b
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x0367
            java.nio.ByteOrder r2 = r0.f34721ag
            int r2 = r5.c(r2)
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r2 != r3) goto L_0x0367
        L_0x0363:
            r2 = 8
            r0.f34717ac = r2
        L_0x0367:
            int r2 = r31.a()
            long r2 = (long) r2
            int r4 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r4 == 0) goto L_0x0372
            goto L_0x02ef
        L_0x0372:
            int r7 = r25 + 1
            short r7 = (short) r7
            r2 = r32
            r6 = r11
            r3 = r26
            r4 = 2
            r5 = 0
            goto L_0x0047
        L_0x037e:
            r11 = r6
            int r2 = r31.a()
            r3 = 4
            int r2 = r2 + r3
            int r3 = r1.f34741a
            if (r2 > r3) goto L_0x03fb
            int r2 = r31.readInt()
            boolean r3 = f34699k
            if (r3 == 0) goto L_0x03a4
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            r6 = 0
            r4[r6] = r5
            java.lang.String r5 = "nextIfdOffset: %d"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            android.util.Log.d(r11, r4)
        L_0x03a4:
            long r4 = (long) r2
            r6 = 0
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 <= 0) goto L_0x03e5
            int r6 = r1.f34741a
            if (r2 >= r6) goto L_0x03e5
            java.util.Set<java.lang.Integer> r6 = r0.f34720af
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)
            boolean r6 = r6.contains(r7)
            if (r6 != 0) goto L_0x03db
            r1.a((long) r4)
            java.util.HashMap<java.lang.String, z.a$b>[] r2 = r0.f34719ae
            r3 = 4
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x03cd
            r0.b((z.a.C0267a) r1, (int) r3)
            goto L_0x03fb
        L_0x03cd:
            java.util.HashMap<java.lang.String, z.a$b>[] r2 = r0.f34719ae
            r2 = r2[r8]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x03fb
            r0.b((z.a.C0267a) r1, (int) r8)
            goto L_0x03fb
        L_0x03db:
            if (r3 == 0) goto L_0x03fb
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since re-reading an IFD may cause an infinite loop: "
            goto L_0x03ee
        L_0x03e5:
            if (r3 == 0) goto L_0x03fb
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since a wrong offset may cause an infinite loop: "
        L_0x03ee:
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r11, r1)
        L_0x03fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z.a.b(z.a$a, int):void");
    }

    private void b(C0267a aVar, HashMap hashMap) throws IOException {
        String str;
        C0267a aVar2 = aVar;
        HashMap hashMap2 = hashMap;
        b bVar = (b) hashMap2.get("StripOffsets");
        b bVar2 = (b) hashMap2.get("StripByteCounts");
        if (bVar != null && bVar2 != null) {
            long[] a2 = a(bVar.a(this.f34721ag));
            long[] a3 = a(bVar2.a(this.f34721ag));
            if (a2 == null || a2.length == 0) {
                str = "stripOffsets should not be null or have zero length.";
            } else if (a3 == null || a3.length == 0) {
                str = "stripByteCounts should not be null or have zero length.";
            } else if (a2.length != a3.length) {
                str = "stripOffsets and stripByteCounts should have same length.";
            } else {
                long j2 = 0;
                for (long j3 : a3) {
                    j2 += j3;
                }
                int i2 = (int) j2;
                byte[] bArr = new byte[i2];
                this.f34724aj = true;
                this.f34723ai = true;
                this.f34722ah = true;
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < a2.length; i5++) {
                    int i6 = (int) a2[i5];
                    int i7 = (int) a3[i5];
                    if (i5 < a2.length - 1 && ((long) (i6 + i7)) != a2[i5 + 1]) {
                        this.f34724aj = false;
                    }
                    int i8 = i6 - i3;
                    if (i8 < 0) {
                        Log.d("ExifInterface", "Invalid strip offset value");
                    }
                    aVar2.a((long) i8);
                    int i9 = i3 + i8;
                    byte[] bArr2 = new byte[i7];
                    aVar2.read(bArr2);
                    i3 = i9 + i7;
                    System.arraycopy(bArr2, 0, bArr, i4, i7);
                    i4 += i7;
                }
                this.f34727am = bArr;
                if (this.f34724aj) {
                    this.f34725ak = ((int) a2[0]) + this.f34729ao;
                    this.f34726al = i2;
                    return;
                }
                return;
            }
            Log.w("ExifInterface", str);
        }
    }

    private static boolean b(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = f34698j;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i2 = 0;
        while (true) {
            byte[] bArr3 = f34698j;
            if (i2 >= bArr3.length) {
                return true;
            }
            if (bArr2[i2] != bArr3[i2]) {
                return false;
            }
            i2++;
        }
    }

    private boolean b(HashMap hashMap) throws IOException {
        b bVar = (b) hashMap.get("ImageLength");
        b bVar2 = (b) hashMap.get("ImageWidth");
        if (bVar == null || bVar2 == null) {
            return false;
        }
        return bVar.c(this.f34721ag) <= 512 && bVar2.c(this.f34721ag) <= 512;
    }

    private boolean b(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i2 = 0; i2 < bytes.length; i2++) {
            if (bArr[i2] != bytes[i2]) {
                return false;
            }
        }
        return true;
    }

    private void c() throws IOException {
        a(0, 5);
        a(0, 4);
        a(5, 4);
        b bVar = this.f34719ae[1].get("PixelXDimension");
        b bVar2 = this.f34719ae[1].get("PixelYDimension");
        if (!(bVar == null || bVar2 == null)) {
            this.f34719ae[0].put("ImageWidth", bVar);
            this.f34719ae[0].put("ImageLength", bVar2);
        }
        if (this.f34719ae[4].isEmpty() && b((HashMap) this.f34719ae[5])) {
            HashMap<String, b>[] hashMapArr = this.f34719ae;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!b((HashMap) this.f34719ae[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
    }

    private void c(String str) throws IOException {
        Objects.requireNonNull(str, "filename cannot be null");
        FileInputStream fileInputStream = null;
        this.f34716ab = null;
        this.Z = str;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                if (a(fileInputStream2.getFD())) {
                    this.f34715aa = fileInputStream2.getFD();
                } else {
                    this.f34715aa = null;
                }
                a((InputStream) fileInputStream2);
                a((Closeable) fileInputStream2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                a((Closeable) fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            a((Closeable) fileInputStream);
            throw th;
        }
    }

    private void c(final C0267a aVar) throws IOException {
        String str;
        String str2;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                mediaMetadataRetriever.setDataSource(new MediaDataSource() {

                    /* renamed from: a  reason: collision with root package name */
                    long f34736a;

                    public void close() throws IOException {
                    }

                    public long getSize() throws IOException {
                        return -1;
                    }

                    public int readAt(long j2, byte[] bArr, int i2, int i3) throws IOException {
                        if (i3 == 0) {
                            return 0;
                        }
                        if (j2 < 0) {
                            return -1;
                        }
                        try {
                            long j3 = this.f34736a;
                            if (j3 != j2) {
                                if (j3 >= 0 && j2 >= j3 + ((long) aVar.available())) {
                                    return -1;
                                }
                                aVar.a(j2);
                                this.f34736a = j2;
                            }
                            if (i3 > aVar.available()) {
                                i3 = aVar.available();
                            }
                            int read = aVar.read(bArr, i2, i3);
                            if (read >= 0) {
                                this.f34736a += (long) read;
                                return read;
                            }
                        } catch (IOException unused) {
                        }
                        this.f34736a = -1;
                        return -1;
                    }
                });
            } else {
                FileDescriptor fileDescriptor = this.f34715aa;
                if (fileDescriptor != null) {
                    mediaMetadataRetriever.setDataSource(fileDescriptor);
                } else {
                    String str3 = this.Z;
                    if (str3 != null) {
                        mediaMetadataRetriever.setDataSource(str3);
                    } else {
                        mediaMetadataRetriever.release();
                        return;
                    }
                }
            }
            String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
            String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
            String str4 = null;
            if ("yes".equals(extractMetadata3)) {
                str4 = mediaMetadataRetriever.extractMetadata(29);
                str2 = mediaMetadataRetriever.extractMetadata(30);
                str = mediaMetadataRetriever.extractMetadata(31);
            } else if ("yes".equals(extractMetadata4)) {
                str4 = mediaMetadataRetriever.extractMetadata(18);
                str2 = mediaMetadataRetriever.extractMetadata(19);
                str = mediaMetadataRetriever.extractMetadata(24);
            } else {
                str2 = null;
                str = null;
            }
            if (str4 != null) {
                this.f34719ae[0].put("ImageWidth", b.a(Integer.parseInt(str4), this.f34721ag));
            }
            if (str2 != null) {
                this.f34719ae[0].put("ImageLength", b.a(Integer.parseInt(str2), this.f34721ag));
            }
            if (str != null) {
                int i2 = 1;
                int parseInt = Integer.parseInt(str);
                if (parseInt == 90) {
                    i2 = 6;
                } else if (parseInt == 180) {
                    i2 = 3;
                } else if (parseInt == 270) {
                    i2 = 8;
                }
                this.f34719ae[0].put("Orientation", b.a(i2, this.f34721ag));
            }
            if (!(extractMetadata == null || extractMetadata2 == null)) {
                int parseInt2 = Integer.parseInt(extractMetadata);
                int parseInt3 = Integer.parseInt(extractMetadata2);
                if (parseInt3 > 6) {
                    aVar.a((long) parseInt2);
                    byte[] bArr = new byte[6];
                    if (aVar.read(bArr) == 6) {
                        int i3 = parseInt2 + 6;
                        int i4 = parseInt3 - 6;
                        if (Arrays.equals(bArr, f34698j)) {
                            byte[] bArr2 = new byte[i4];
                            if (aVar.read(bArr2) == i4) {
                                this.f34729ao = i3;
                                a(bArr2, 0);
                            } else {
                                throw new IOException("Can't read exif");
                            }
                        } else {
                            throw new IOException("Invalid identifier");
                        }
                    } else {
                        throw new IOException("Can't read identifier");
                    }
                } else {
                    throw new IOException("Invalid exif length");
                }
            }
            if (f34699k) {
                Log.d("ExifInterface", "Heif meta: " + str4 + "x" + str2 + ", rotation " + str);
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    private void c(C0267a aVar, int i2) throws IOException {
        b bVar;
        b bVar2 = this.f34719ae[i2].get("ImageLength");
        b bVar3 = this.f34719ae[i2].get("ImageWidth");
        if ((bVar2 == null || bVar3 == null) && (bVar = this.f34719ae[i2].get("JPEGInterchangeFormat")) != null) {
            a(aVar, bVar.c(this.f34721ag), i2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0092 A[Catch:{ all -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(byte[] r15) throws java.io.IOException {
        /*
            r14 = this;
            r0 = 0
            r1 = 0
            z.a$a r2 = new z.a$a     // Catch:{ Exception -> 0x008d }
            r2.<init>((byte[]) r15)     // Catch:{ Exception -> 0x008d }
            int r1 = r2.readInt()     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r3 = (long) r1     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r1 = 4
            byte[] r5 = new byte[r1]     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r2.read(r5)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            byte[] r6 = f34702n     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r5 = java.util.Arrays.equals(r5, r6)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r5 != 0) goto L_0x001e
            r2.close()
            return r0
        L_0x001e:
            r5 = 16
            r7 = 8
            r9 = 1
            int r11 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x0034
            long r3 = r2.readLong()     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            int r11 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r11 >= 0) goto L_0x0035
            r2.close()
            return r0
        L_0x0034:
            r5 = r7
        L_0x0035:
            int r11 = r15.length     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r11 = (long) r11     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            int r13 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x003d
            int r15 = r15.length     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r3 = (long) r15
        L_0x003d:
            long r3 = r3 - r5
            int r15 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r15 >= 0) goto L_0x0046
            r2.close()
            return r0
        L_0x0046:
            byte[] r15 = new byte[r1]     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r5 = 0
            r7 = 0
            r8 = 0
        L_0x004c:
            r11 = 4
            long r11 = r3 / r11
            int r13 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0081
            int r11 = r2.read(r15)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r11 == r1) goto L_0x005e
            r2.close()
            return r0
        L_0x005e:
            int r11 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x0063
            goto L_0x007f
        L_0x0063:
            byte[] r11 = f34703o     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r12 = 1
            if (r11 == 0) goto L_0x006e
            r7 = 1
            goto L_0x0077
        L_0x006e:
            byte[] r11 = f34704p     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r11 == 0) goto L_0x0077
            r8 = 1
        L_0x0077:
            if (r7 == 0) goto L_0x007f
            if (r8 == 0) goto L_0x007f
            r2.close()
            return r12
        L_0x007f:
            long r5 = r5 + r9
            goto L_0x004c
        L_0x0081:
            r2.close()
            goto L_0x009e
        L_0x0085:
            r15 = move-exception
            r1 = r2
            goto L_0x009f
        L_0x0088:
            r15 = move-exception
            r1 = r2
            goto L_0x008e
        L_0x008b:
            r15 = move-exception
            goto L_0x009f
        L_0x008d:
            r15 = move-exception
        L_0x008e:
            boolean r2 = f34699k     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x0099
            java.lang.String r2 = "ExifInterface"
            java.lang.String r3 = "Exception parsing HEIF file type box."
            android.util.Log.d(r2, r3, r15)     // Catch:{ all -> 0x008b }
        L_0x0099:
            if (r1 == 0) goto L_0x009e
            r1.close()
        L_0x009e:
            return r0
        L_0x009f:
            if (r1 == 0) goto L_0x00a4
            r1.close()
        L_0x00a4:
            goto L_0x00a6
        L_0x00a5:
            throw r15
        L_0x00a6:
            goto L_0x00a5
        */
        throw new UnsupportedOperationException("Method not decompiled: z.a.c(byte[]):boolean");
    }

    private void d(C0267a aVar) throws IOException {
        byte[] bArr = f34698j;
        aVar.skipBytes(bArr.length);
        byte[] bArr2 = new byte[aVar.available()];
        aVar.readFully(bArr2);
        this.f34729ao = bArr.length;
        a(bArr2, 0);
    }

    private void d(C0267a aVar, int i2) throws IOException {
        b bVar;
        b bVar2;
        StringBuilder sb;
        String arrays;
        b bVar3 = this.f34719ae[i2].get("DefaultCropSize");
        b bVar4 = this.f34719ae[i2].get("SensorTopBorder");
        b bVar5 = this.f34719ae[i2].get("SensorLeftBorder");
        b bVar6 = this.f34719ae[i2].get("SensorBottomBorder");
        b bVar7 = this.f34719ae[i2].get("SensorRightBorder");
        if (bVar3 != null) {
            if (bVar3.f34745a == 5) {
                d[] dVarArr = (d[]) bVar3.a(this.f34721ag);
                if (dVarArr == null || dVarArr.length != 2) {
                    sb = new StringBuilder();
                    sb.append("Invalid crop size values. cropSize=");
                    arrays = Arrays.toString(dVarArr);
                } else {
                    bVar2 = b.a(dVarArr[0], this.f34721ag);
                    bVar = b.a(dVarArr[1], this.f34721ag);
                    this.f34719ae[i2].put("ImageWidth", bVar2);
                    this.f34719ae[i2].put("ImageLength", bVar);
                    return;
                }
            } else {
                int[] iArr = (int[]) bVar3.a(this.f34721ag);
                if (iArr == null || iArr.length != 2) {
                    sb = new StringBuilder();
                    sb.append("Invalid crop size values. cropSize=");
                    arrays = Arrays.toString(iArr);
                } else {
                    bVar2 = b.a(iArr[0], this.f34721ag);
                    bVar = b.a(iArr[1], this.f34721ag);
                    this.f34719ae[i2].put("ImageWidth", bVar2);
                    this.f34719ae[i2].put("ImageLength", bVar);
                    return;
                }
            }
            sb.append(arrays);
            Log.w("ExifInterface", sb.toString());
        } else if (bVar4 == null || bVar5 == null || bVar6 == null || bVar7 == null) {
            c(aVar, i2);
        } else {
            int c2 = bVar4.c(this.f34721ag);
            int c3 = bVar6.c(this.f34721ag);
            int c4 = bVar7.c(this.f34721ag);
            int c5 = bVar5.c(this.f34721ag);
            if (c3 > c2 && c4 > c5) {
                b a2 = b.a(c3 - c2, this.f34721ag);
                b a3 = b.a(c4 - c5, this.f34721ag);
                this.f34719ae[i2].put("ImageLength", a2);
                this.f34719ae[i2].put("ImageWidth", a3);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean d(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            z.a$a r2 = new z.a$a     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            java.nio.ByteOrder r4 = r3.i(r2)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r3.f34721ag = r4     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r2.a((java.nio.ByteOrder) r4)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r1 = 20306(0x4f52, float:2.8455E-41)
            if (r4 == r1) goto L_0x001c
            r1 = 21330(0x5352, float:2.989E-41)
            if (r4 != r1) goto L_0x001d
        L_0x001c:
            r0 = 1
        L_0x001d:
            r2.close()
            return r0
        L_0x0021:
            r4 = move-exception
            r1 = r2
            goto L_0x0027
        L_0x0024:
            r1 = r2
            goto L_0x002e
        L_0x0026:
            r4 = move-exception
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r1.close()
        L_0x002c:
            throw r4
        L_0x002d:
        L_0x002e:
            if (r1 == 0) goto L_0x0033
            r1.close()
        L_0x0033:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z.a.d(byte[]):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(z.a.C0267a r7) throws java.io.IOException {
        /*
            r6 = this;
            r6.a((z.a.C0267a) r7)
            java.util.HashMap<java.lang.String, z.a$b>[] r7 = r6.f34719ae
            r0 = 1
            r7 = r7[r0]
            java.lang.String r1 = "MakerNote"
            java.lang.Object r7 = r7.get(r1)
            z.a$b r7 = (z.a.b) r7
            if (r7 == 0) goto L_0x00f7
            z.a$a r1 = new z.a$a
            byte[] r7 = r7.f34748d
            r1.<init>((byte[]) r7)
            java.nio.ByteOrder r7 = r6.f34721ag
            r1.a((java.nio.ByteOrder) r7)
            byte[] r7 = f34705q
            int r2 = r7.length
            byte[] r2 = new byte[r2]
            r1.readFully(r2)
            r3 = 0
            r1.a((long) r3)
            byte[] r3 = f34706r
            int r4 = r3.length
            byte[] r4 = new byte[r4]
            r1.readFully(r4)
            boolean r7 = java.util.Arrays.equals(r2, r7)
            if (r7 == 0) goto L_0x003f
            r2 = 8
        L_0x003b:
            r1.a((long) r2)
            goto L_0x0048
        L_0x003f:
            boolean r7 = java.util.Arrays.equals(r4, r3)
            if (r7 == 0) goto L_0x0048
            r2 = 12
            goto L_0x003b
        L_0x0048:
            r7 = 6
            r6.b((z.a.C0267a) r1, (int) r7)
            java.util.HashMap<java.lang.String, z.a$b>[] r7 = r6.f34719ae
            r1 = 7
            r7 = r7[r1]
            java.lang.String r2 = "PreviewImageStart"
            java.lang.Object r7 = r7.get(r2)
            z.a$b r7 = (z.a.b) r7
            java.util.HashMap<java.lang.String, z.a$b>[] r2 = r6.f34719ae
            r1 = r2[r1]
            java.lang.String r2 = "PreviewImageLength"
            java.lang.Object r1 = r1.get(r2)
            z.a$b r1 = (z.a.b) r1
            if (r7 == 0) goto L_0x007c
            if (r1 == 0) goto L_0x007c
            java.util.HashMap<java.lang.String, z.a$b>[] r2 = r6.f34719ae
            r3 = 5
            r2 = r2[r3]
            java.lang.String r4 = "JPEGInterchangeFormat"
            r2.put(r4, r7)
            java.util.HashMap<java.lang.String, z.a$b>[] r7 = r6.f34719ae
            r7 = r7[r3]
            java.lang.String r2 = "JPEGInterchangeFormatLength"
            r7.put(r2, r1)
        L_0x007c:
            java.util.HashMap<java.lang.String, z.a$b>[] r7 = r6.f34719ae
            r1 = 8
            r7 = r7[r1]
            java.lang.String r1 = "AspectFrame"
            java.lang.Object r7 = r7.get(r1)
            z.a$b r7 = (z.a.b) r7
            if (r7 == 0) goto L_0x00f7
            java.nio.ByteOrder r1 = r6.f34721ag
            java.lang.Object r7 = r7.a((java.nio.ByteOrder) r1)
            int[] r7 = (int[]) r7
            int[] r7 = (int[]) r7
            if (r7 == 0) goto L_0x00dd
            int r1 = r7.length
            r2 = 4
            if (r1 == r2) goto L_0x009d
            goto L_0x00dd
        L_0x009d:
            r1 = 2
            r2 = r7[r1]
            r3 = 0
            r4 = r7[r3]
            if (r2 <= r4) goto L_0x00f7
            r2 = 3
            r4 = r7[r2]
            r5 = r7[r0]
            if (r4 <= r5) goto L_0x00f7
            r1 = r7[r1]
            r4 = r7[r3]
            int r1 = r1 - r4
            int r1 = r1 + r0
            r2 = r7[r2]
            r7 = r7[r0]
            int r2 = r2 - r7
            int r2 = r2 + r0
            if (r1 >= r2) goto L_0x00be
            int r1 = r1 + r2
            int r2 = r1 - r2
            int r1 = r1 - r2
        L_0x00be:
            java.nio.ByteOrder r7 = r6.f34721ag
            z.a$b r7 = z.a.b.a((int) r1, (java.nio.ByteOrder) r7)
            java.nio.ByteOrder r0 = r6.f34721ag
            z.a$b r0 = z.a.b.a((int) r2, (java.nio.ByteOrder) r0)
            java.util.HashMap<java.lang.String, z.a$b>[] r1 = r6.f34719ae
            r1 = r1[r3]
            java.lang.String r2 = "ImageWidth"
            r1.put(r2, r7)
            java.util.HashMap<java.lang.String, z.a$b>[] r7 = r6.f34719ae
            r7 = r7[r3]
            java.lang.String r1 = "ImageLength"
            r7.put(r1, r0)
            goto L_0x00f7
        L_0x00dd:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid aspect frame values. frame="
            r0.append(r1)
            java.lang.String r7 = java.util.Arrays.toString(r7)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.String r0 = "ExifInterface"
            android.util.Log.w(r0, r7)
        L_0x00f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z.a.e(z.a$a):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            z.a$a r2 = new z.a$a     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            java.nio.ByteOrder r4 = r3.i(r2)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r3.f34721ag = r4     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r2.a((java.nio.ByteOrder) r4)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r1 = 85
            if (r4 != r1) goto L_0x0019
            r0 = 1
        L_0x0019:
            r2.close()
            return r0
        L_0x001d:
            r4 = move-exception
            r1 = r2
            goto L_0x0023
        L_0x0020:
            r1 = r2
            goto L_0x002a
        L_0x0022:
            r4 = move-exception
        L_0x0023:
            if (r1 == 0) goto L_0x0028
            r1.close()
        L_0x0028:
            throw r4
        L_0x0029:
        L_0x002a:
            if (r1 == 0) goto L_0x002f
            r1.close()
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z.a.e(byte[]):boolean");
    }

    private void f(C0267a aVar) throws IOException {
        a(aVar);
        if (this.f34719ae[0].get("JpgFromRaw") != null) {
            a(aVar, this.f34733as, 5);
        }
        b bVar = this.f34719ae[0].get("ISO");
        b bVar2 = this.f34719ae[1].get("PhotographicSensitivity");
        if (bVar != null && bVar2 == null) {
            this.f34719ae[1].put("PhotographicSensitivity", bVar);
        }
    }

    private boolean f(byte[] bArr) throws IOException {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f34707s;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private void g(C0267a aVar) throws IOException {
        if (f34699k) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + aVar);
        }
        aVar.a(ByteOrder.BIG_ENDIAN);
        byte[] bArr = f34707s;
        aVar.skipBytes(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int readInt = aVar.readInt();
                int i2 = length + 4;
                byte[] bArr2 = new byte[4];
                if (aVar.read(bArr2) == 4) {
                    int i3 = i2 + 4;
                    if (i3 == 16) {
                        if (!Arrays.equals(bArr2, f34709u)) {
                            throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                        }
                    }
                    if (!Arrays.equals(bArr2, f34710v)) {
                        if (Arrays.equals(bArr2, f34708t)) {
                            byte[] bArr3 = new byte[readInt];
                            if (aVar.read(bArr3) == readInt) {
                                int readInt2 = aVar.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr2);
                                crc32.update(bArr3);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.f34729ao = i3;
                                    a(bArr3, 0);
                                    c();
                                    return;
                                }
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + h(bArr2));
                        }
                        int i4 = readInt + 4;
                        aVar.skipBytes(i4);
                        length = i3 + i4;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private boolean g(byte[] bArr) throws IOException {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f34711w;
            if (i2 >= bArr2.length) {
                int i3 = 0;
                while (true) {
                    byte[] bArr3 = f34712x;
                    if (i3 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[f34711w.length + i3 + 4] != bArr3[i3]) {
                        return false;
                    }
                    i3++;
                }
            } else if (bArr[i2] != bArr2[i2]) {
                return false;
            } else {
                i2++;
            }
        }
    }

    private static String h(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i2])}));
        }
        return sb.toString();
    }

    private void h(C0267a aVar) throws IOException {
        if (f34699k) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + aVar);
        }
        aVar.a(ByteOrder.LITTLE_ENDIAN);
        aVar.skipBytes(f34711w.length);
        int readInt = aVar.readInt() + 8;
        int skipBytes = aVar.skipBytes(f34712x.length) + 8;
        while (true) {
            try {
                byte[] bArr = new byte[4];
                if (aVar.read(bArr) == 4) {
                    int readInt2 = aVar.readInt();
                    int i2 = skipBytes + 4 + 4;
                    if (Arrays.equals(f34713y, bArr)) {
                        byte[] bArr2 = new byte[readInt2];
                        if (aVar.read(bArr2) == readInt2) {
                            this.f34729ao = i2;
                            a(bArr2, 0);
                            this.f34729ao = i2;
                            return;
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + h(bArr));
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    int i3 = i2 + readInt2;
                    if (i3 != readInt) {
                        if (i3 <= readInt) {
                            int skipBytes2 = aVar.skipBytes(readInt2);
                            if (skipBytes2 == readInt2) {
                                skipBytes = i2 + skipBytes2;
                            } else {
                                throw new IOException("Encountered WebP file with invalid chunk size");
                            }
                        } else {
                            throw new IOException("Encountered WebP file with invalid chunk size");
                        }
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    private ByteOrder i(C0267a aVar) throws IOException {
        short readShort = aVar.readShort();
        if (readShort == 18761) {
            if (f34699k) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        } else if (readShort == 19789) {
            if (f34699k) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        } else {
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
    }

    private void j(C0267a aVar) throws IOException {
        HashMap<String, b> hashMap = this.f34719ae[4];
        b bVar = hashMap.get("Compression");
        if (bVar != null) {
            int c2 = bVar.c(this.f34721ag);
            this.f34728an = c2;
            if (c2 != 1) {
                if (c2 != 6) {
                    if (c2 != 7) {
                        return;
                    }
                }
            }
            if (a((HashMap) hashMap)) {
                b(aVar, (HashMap) hashMap);
                return;
            }
            return;
        }
        this.f34728an = 6;
        a(aVar, (HashMap) hashMap);
    }

    public int a(String str, int i2) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        b b2 = b(str);
        if (b2 == null) {
            return i2;
        }
        try {
            return b2.c(this.f34721ag);
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public String a(String str) {
        String str2;
        Objects.requireNonNull(str, "tag shouldn't be null");
        b b2 = b(str);
        if (b2 != null) {
            if (!W.contains(str)) {
                return b2.d(this.f34721ag);
            }
            if (str.equals("GPSTimeStamp")) {
                if (b2.f34745a == 5 || b2.f34745a == 10) {
                    d[] dVarArr = (d[]) b2.a(this.f34721ag);
                    if (dVarArr == null || dVarArr.length != 3) {
                        str2 = "Invalid GPS Timestamp array. array=" + Arrays.toString(dVarArr);
                    } else {
                        return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) dVarArr[0].f34753a) / ((float) dVarArr[0].f34754b))), Integer.valueOf((int) (((float) dVarArr[1].f34753a) / ((float) dVarArr[1].f34754b))), Integer.valueOf((int) (((float) dVarArr[2].f34753a) / ((float) dVarArr[2].f34754b)))});
                    }
                } else {
                    str2 = "GPS Timestamp format is not rational. format=" + b2.f34745a;
                }
                Log.w("ExifInterface", str2);
                return null;
            }
            try {
                return Double.toString(b2.b(this.f34721ag));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }
}
