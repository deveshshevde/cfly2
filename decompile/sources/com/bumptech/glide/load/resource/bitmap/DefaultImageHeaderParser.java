package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import cc.k;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f10423a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f10424b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    private interface Reader {

        public static final class EndOfFileException extends IOException {
            private static final long serialVersionUID = 1;

            EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a(byte[] bArr, int i2) throws IOException;

        long a(long j2) throws IOException;

        short a() throws IOException;

        int b() throws IOException;
    }

    private static final class a implements Reader {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f10425a;

        a(ByteBuffer byteBuffer) {
            this.f10425a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public int a(byte[] bArr, int i2) {
            int min = Math.min(i2, this.f10425a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f10425a.get(bArr, 0, min);
            return min;
        }

        public long a(long j2) {
            int min = (int) Math.min((long) this.f10425a.remaining(), j2);
            ByteBuffer byteBuffer = this.f10425a;
            byteBuffer.position(byteBuffer.position() + min);
            return (long) min;
        }

        public short a() throws Reader.EndOfFileException {
            if (this.f10425a.remaining() >= 1) {
                return (short) (this.f10425a.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        public int b() throws Reader.EndOfFileException {
            return (a() << 8) | a();
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f10426a;

        b(byte[] bArr, int i2) {
            this.f10426a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        private boolean a(int i2, int i3) {
            return this.f10426a.remaining() - i2 >= i3;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f10426a.remaining();
        }

        /* access modifiers changed from: package-private */
        public int a(int i2) {
            if (a(i2, 4)) {
                return this.f10426a.getInt(i2);
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public void a(ByteOrder byteOrder) {
            this.f10426a.order(byteOrder);
        }

        /* access modifiers changed from: package-private */
        public short b(int i2) {
            if (a(i2, 2)) {
                return this.f10426a.getShort(i2);
            }
            return -1;
        }
    }

    private static final class c implements Reader {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f10427a;

        c(InputStream inputStream) {
            this.f10427a = inputStream;
        }

        public int a(byte[] bArr, int i2) throws IOException {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2 && (i4 = this.f10427a.read(bArr, i3, i2 - i3)) != -1) {
                i3 += i4;
            }
            if (i3 != 0 || i4 != -1) {
                return i3;
            }
            throw new Reader.EndOfFileException();
        }

        public long a(long j2) throws IOException {
            if (j2 < 0) {
                return 0;
            }
            long j3 = j2;
            while (j3 > 0) {
                long skip = this.f10427a.skip(j3);
                if (skip <= 0) {
                    if (this.f10427a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j3 -= skip;
            }
            return j2 - j3;
        }

        public short a() throws IOException {
            int read = this.f10427a.read();
            if (read != -1) {
                return (short) read;
            }
            throw new Reader.EndOfFileException();
        }

        public int b() throws IOException {
            return (a() << 8) | a();
        }
    }

    private static int a(int i2, int i3) {
        return i2 + 2 + (i3 * 12);
    }

    private int a(Reader reader, bl.b bVar) throws IOException {
        byte[] bArr;
        try {
            int b2 = reader.b();
            if (!a(b2)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + b2);
                }
                return -1;
            }
            int b3 = b(reader);
            if (b3 == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            bArr = (byte[]) bVar.a(b3, byte[].class);
            int a2 = a(reader, bArr, b3);
            bVar.a(bArr);
            return a2;
        } catch (Reader.EndOfFileException unused) {
            return -1;
        } catch (Throwable th) {
            bVar.a(bArr);
            throw th;
        }
    }

    private int a(Reader reader, byte[] bArr, int i2) throws IOException {
        int a2 = reader.a(bArr, i2);
        if (a2 != i2) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i2 + ", actually read: " + a2);
            }
            return -1;
        } else if (a(bArr, i2)) {
            return a(new b(bArr, i2));
        } else {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    private static int a(b bVar) {
        ByteOrder byteOrder;
        String str;
        StringBuilder sb;
        String str2;
        short b2 = bVar.b(6);
        if (b2 != 18761) {
            if (b2 != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + b2);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.a(byteOrder);
        int a2 = bVar.a(10) + 6;
        short b3 = bVar.b(a2);
        for (int i2 = 0; i2 < b3; i2++) {
            int a3 = a(a2, i2);
            short b4 = bVar.b(a3);
            if (b4 == 274) {
                short b5 = bVar.b(a3 + 2);
                if (b5 >= 1 && b5 <= 12) {
                    int a4 = bVar.a(a3 + 4);
                    if (a4 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i2 + " tagType=" + b4 + " formatCode=" + b5 + " componentCount=" + a4);
                        }
                        int i3 = a4 + f10424b[b5];
                        if (i3 <= 4) {
                            int i4 = a3 + 8;
                            if (i4 < 0 || i4 > bVar.a()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    str = "Illegal tagValueOffset=" + i4 + " tagType=" + b4;
                                    Log.d("DfltImageHeaderParser", str);
                                }
                            } else if (i3 >= 0 && i3 + i4 <= bVar.a()) {
                                return bVar.b(i4);
                            } else {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    sb = new StringBuilder();
                                    sb.append("Illegal number of bytes for TI tag data tagType=");
                                    sb.append(b4);
                                    str = sb.toString();
                                    Log.d("DfltImageHeaderParser", str);
                                }
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            sb = new StringBuilder();
                            str2 = "Got byte count > 4, not orientation, continuing, formatCode=";
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        str = "Negative tiff component count";
                        Log.d("DfltImageHeaderParser", str);
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    sb = new StringBuilder();
                    str2 = "Got invalid format code = ";
                }
                sb.append(str2);
                sb.append(b5);
                str = sb.toString();
                Log.d("DfltImageHeaderParser", str);
            }
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        return com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0039 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bumptech.glide.load.ImageHeaderParser.ImageType a(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader r6) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r6.b()     // Catch:{ EndOfFileException -> 0x00b0 }
            r1 = 65496(0xffd8, float:9.178E-41)
            if (r0 != r1) goto L_0x000c
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.JPEG     // Catch:{ EndOfFileException -> 0x00b0 }
            return r6
        L_0x000c:
            int r0 = r0 << 8
            short r1 = r6.a()     // Catch:{ EndOfFileException -> 0x00b0 }
            r0 = r0 | r1
            r1 = 4671814(0x474946, float:6.546606E-39)
            if (r0 != r1) goto L_0x001b
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.GIF     // Catch:{ EndOfFileException -> 0x00b0 }
            return r6
        L_0x001b:
            int r0 = r0 << 8
            short r1 = r6.a()     // Catch:{ EndOfFileException -> 0x00b0 }
            r0 = r0 | r1
            r1 = -1991225785(0xffffffff89504e47, float:-2.5073895E-33)
            if (r0 != r1) goto L_0x003c
            r0 = 21
            r6.a(r0)     // Catch:{ EndOfFileException -> 0x00b0 }
            short r6 = r6.a()     // Catch:{ EndOfFileException -> 0x0039 }
            r0 = 3
            if (r6 < r0) goto L_0x0036
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG_A     // Catch:{ EndOfFileException -> 0x0039 }
            goto L_0x0038
        L_0x0036:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ EndOfFileException -> 0x0039 }
        L_0x0038:
            return r6
        L_0x0039:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ EndOfFileException -> 0x00b0 }
            return r6
        L_0x003c:
            r1 = 1380533830(0x52494646, float:2.16116855E11)
            if (r0 == r1) goto L_0x004d
            boolean r6 = r5.a((com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader) r6, (int) r0)     // Catch:{ EndOfFileException -> 0x00b0 }
            if (r6 == 0) goto L_0x004a
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.AVIF     // Catch:{ EndOfFileException -> 0x00b0 }
            goto L_0x004c
        L_0x004a:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00b0 }
        L_0x004c:
            return r6
        L_0x004d:
            r0 = 4
            r6.a(r0)     // Catch:{ EndOfFileException -> 0x00b0 }
            int r2 = r6.b()     // Catch:{ EndOfFileException -> 0x00b0 }
            int r2 = r2 << 16
            int r3 = r6.b()     // Catch:{ EndOfFileException -> 0x00b0 }
            r2 = r2 | r3
            r3 = 1464156752(0x57454250, float:2.16888601E14)
            if (r2 == r3) goto L_0x0065
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00b0 }
            return r6
        L_0x0065:
            int r2 = r6.b()     // Catch:{ EndOfFileException -> 0x00b0 }
            int r2 = r2 << 16
            int r3 = r6.b()     // Catch:{ EndOfFileException -> 0x00b0 }
            r2 = r2 | r3
            r3 = r2 & -256(0xffffffffffffff00, float:NaN)
            r4 = 1448097792(0x56503800, float:5.7234734E13)
            if (r3 == r4) goto L_0x007a
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00b0 }
            return r6
        L_0x007a:
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 88
            if (r2 != r3) goto L_0x0098
            r6.a(r0)     // Catch:{ EndOfFileException -> 0x00b0 }
            short r6 = r6.a()     // Catch:{ EndOfFileException -> 0x00b0 }
            r0 = r6 & 2
            if (r0 == 0) goto L_0x008e
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.ANIMATED_WEBP     // Catch:{ EndOfFileException -> 0x00b0 }
            return r6
        L_0x008e:
            r6 = r6 & 16
            if (r6 == 0) goto L_0x0095
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ EndOfFileException -> 0x00b0 }
            return r6
        L_0x0095:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00b0 }
            return r6
        L_0x0098:
            r3 = 76
            if (r2 != r3) goto L_0x00ad
            r6.a(r0)     // Catch:{ EndOfFileException -> 0x00b0 }
            short r6 = r6.a()     // Catch:{ EndOfFileException -> 0x00b0 }
            r6 = r6 & 8
            if (r6 == 0) goto L_0x00aa
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ EndOfFileException -> 0x00b0 }
            goto L_0x00ac
        L_0x00aa:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00b0 }
        L_0x00ac:
            return r6
        L_0x00ad:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00b0 }
            return r6
        L_0x00b0:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.a(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader):com.bumptech.glide.load.ImageHeaderParser$ImageType");
    }

    private static boolean a(int i2) {
        return (i2 & 65496) == 65496 || i2 == 19789 || i2 == 18761;
    }

    private boolean a(Reader reader, int i2) throws IOException {
        if (((reader.b() << 16) | reader.b()) != 1718909296) {
            return false;
        }
        int b2 = (reader.b() << 16) | reader.b();
        if (b2 == 1635150182 || b2 == 1635150195) {
            return true;
        }
        reader.a(4);
        int i3 = i2 - 16;
        if (i3 % 4 != 0) {
            return false;
        }
        int i4 = 0;
        while (i4 < 5 && i3 > 0) {
            int b3 = (reader.b() << 16) | reader.b();
            if (b3 == 1635150182 || b3 == 1635150195) {
                return true;
            }
            i4++;
            i3 -= 4;
        }
        return false;
    }

    private boolean a(byte[] bArr, int i2) {
        boolean z2 = bArr != null && i2 > f10423a.length;
        if (z2) {
            int i3 = 0;
            while (true) {
                byte[] bArr2 = f10423a;
                if (i3 >= bArr2.length) {
                    break;
                } else if (bArr[i3] != bArr2[i3]) {
                    return false;
                } else {
                    i3++;
                }
            }
        }
        return z2;
    }

    private int b(Reader reader) throws IOException {
        short a2;
        int b2;
        long j2;
        long a3;
        do {
            short a4 = reader.a();
            if (a4 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + a4);
                }
                return -1;
            }
            a2 = reader.a();
            if (a2 == 218) {
                return -1;
            }
            if (a2 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            b2 = reader.b() - 2;
            if (a2 == 225) {
                return b2;
            }
            j2 = (long) b2;
            a3 = reader.a(j2);
        } while (a3 == j2);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + a2 + ", wanted to skip: " + b2 + ", but actually skipped: " + a3);
        }
        return -1;
    }

    public int a(InputStream inputStream, bl.b bVar) throws IOException {
        return a((Reader) new c((InputStream) k.a(inputStream)), (bl.b) k.a(bVar));
    }

    public int a(ByteBuffer byteBuffer, bl.b bVar) throws IOException {
        return a((Reader) new a((ByteBuffer) k.a(byteBuffer)), (bl.b) k.a(bVar));
    }

    public ImageHeaderParser.ImageType a(InputStream inputStream) throws IOException {
        return a((Reader) new c((InputStream) k.a(inputStream)));
    }

    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) throws IOException {
        return a((Reader) new a((ByteBuffer) k.a(byteBuffer)));
    }
}
