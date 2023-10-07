package com.google.protobuf;

import com.google.protobuf.Utf8;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CodedOutputStream extends c {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f20042a = Logger.getLogger(CodedOutputStream.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f20043b = r.a();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final long f20044c = r.c();

    public static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }

        OutOfSpaceException(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    private static class a extends CodedOutputStream {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f20045a;

        /* renamed from: b  reason: collision with root package name */
        private final int f20046b;

        /* renamed from: c  reason: collision with root package name */
        private final int f20047c;

        /* renamed from: d  reason: collision with root package name */
        private int f20048d;

        a(byte[] bArr, int i2, int i3) {
            super();
            Objects.requireNonNull(bArr, "buffer");
            int i4 = i2 + i3;
            if ((i2 | i3 | (bArr.length - i4)) >= 0) {
                this.f20045a = bArr;
                this.f20046b = i2;
                this.f20048d = i2;
                this.f20047c = i4;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
        }

        public final int a() {
            return this.f20047c - this.f20048d;
        }

        public final void a(int i2) throws IOException {
            if (!CodedOutputStream.f20043b || a() < 10) {
                while ((i2 & -128) != 0) {
                    byte[] bArr = this.f20045a;
                    int i3 = this.f20048d;
                    this.f20048d = i3 + 1;
                    bArr[i3] = (byte) ((i2 & 127) | 128);
                    i2 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f20045a;
                    int i4 = this.f20048d;
                    this.f20048d = i4 + 1;
                    bArr2[i4] = (byte) i2;
                } catch (IndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f20048d), Integer.valueOf(this.f20047c), 1}), e2);
                }
            } else {
                long d2 = CodedOutputStream.f20044c + ((long) this.f20048d);
                while ((i2 & -128) != 0) {
                    r.a(this.f20045a, d2, (byte) ((i2 & 127) | 128));
                    this.f20048d++;
                    i2 >>>= 7;
                    d2 = 1 + d2;
                }
                r.a(this.f20045a, d2, (byte) i2);
                this.f20048d++;
            }
        }

        public final void a(int i2, int i3) throws IOException {
            e(i2, 0);
            g(i3);
        }

        public final void a(int i2, ByteString byteString) throws IOException {
            e(i2, 2);
            b(byteString);
        }

        public final void a(int i2, k kVar) throws IOException {
            e(i2, 2);
            b(kVar);
        }

        public final void a(int i2, String str) throws IOException {
            e(i2, 2);
            b(str);
        }

        public final void a(long j2) throws IOException {
            if (!CodedOutputStream.f20043b || a() < 10) {
                while ((j2 & -128) != 0) {
                    byte[] bArr = this.f20045a;
                    int i2 = this.f20048d;
                    this.f20048d = i2 + 1;
                    bArr[i2] = (byte) ((((int) j2) & 127) | 128);
                    j2 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f20045a;
                    int i3 = this.f20048d;
                    this.f20048d = i3 + 1;
                    bArr2[i3] = (byte) ((int) j2);
                } catch (IndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f20048d), Integer.valueOf(this.f20047c), 1}), e2);
                }
            } else {
                long d2 = CodedOutputStream.f20044c + ((long) this.f20048d);
                while ((j2 & -128) != 0) {
                    r.a(this.f20045a, d2, (byte) ((((int) j2) & 127) | 128));
                    this.f20048d++;
                    j2 >>>= 7;
                    d2 = 1 + d2;
                }
                r.a(this.f20045a, d2, (byte) ((int) j2));
                this.f20048d++;
            }
        }

        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            c(bArr, i2, i3);
        }

        public final void b(ByteString byteString) throws IOException {
            a(byteString.b());
            byteString.a((c) this);
        }

        public final void b(k kVar) throws IOException {
            a(kVar.l());
            kVar.a(this);
        }

        public final void b(String str) throws IOException {
            int a2;
            int i2 = this.f20048d;
            try {
                int d2 = d(str.length() * 3);
                int d3 = d(str.length());
                if (d3 == d2) {
                    int i3 = i2 + d3;
                    this.f20048d = i3;
                    a2 = Utf8.a(str, this.f20045a, i3, a());
                    this.f20048d = i2;
                    a((a2 - i2) - d3);
                } else {
                    a(Utf8.a((CharSequence) str));
                    a2 = Utf8.a(str, this.f20045a, this.f20048d, a());
                }
                this.f20048d = a2;
            } catch (Utf8.UnpairedSurrogateException e2) {
                this.f20048d = i2;
                a(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        public final void c(byte[] bArr, int i2, int i3) throws IOException {
            try {
                System.arraycopy(bArr, i2, this.f20045a, this.f20048d, i3);
                this.f20048d += i3;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f20048d), Integer.valueOf(this.f20047c), Integer.valueOf(i3)}), e2);
            }
        }

        public final void e(int i2, int i3) throws IOException {
            a(WireFormat.a(i2, i3));
        }

        public final void g(int i2) throws IOException {
            if (i2 >= 0) {
                a(i2);
            } else {
                a((long) i2);
            }
        }
    }

    private CodedOutputStream() {
    }

    public static int a(ByteString byteString) {
        return f(byteString.b());
    }

    public static int a(k kVar) {
        return f(kVar.l());
    }

    public static int a(String str) {
        int i2;
        try {
            i2 = Utf8.a((CharSequence) str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            i2 = str.getBytes(h.f20137a).length;
        }
        return f(i2);
    }

    public static CodedOutputStream a(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }

    public static int b(int i2) {
        return d(WireFormat.a(i2, 0));
    }

    public static int b(int i2, ByteString byteString) {
        return b(i2) + a(byteString);
    }

    public static int b(int i2, k kVar) {
        return b(i2) + a(kVar);
    }

    public static int b(int i2, String str) {
        return b(i2) + a(str);
    }

    public static CodedOutputStream b(byte[] bArr, int i2, int i3) {
        return new a(bArr, i2, i3);
    }

    public static int c(int i2) {
        if (i2 >= 0) {
            return d(i2);
        }
        return 10;
    }

    public static int c(int i2, int i3) {
        return b(i2) + c(i3);
    }

    public static int d(int i2) {
        if ((i2 & -128) == 0) {
            return 1;
        }
        if ((i2 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i2) == 0) {
            return 3;
        }
        return (i2 & -268435456) == 0 ? 4 : 5;
    }

    public static int d(int i2, int i3) {
        return b(i2) + e(i3);
    }

    public static int e(int i2) {
        return c(i2);
    }

    static int f(int i2) {
        return d(i2) + i2;
    }

    public abstract int a();

    public abstract void a(int i2) throws IOException;

    public abstract void a(int i2, int i3) throws IOException;

    public abstract void a(int i2, ByteString byteString) throws IOException;

    public abstract void a(int i2, k kVar) throws IOException;

    public abstract void a(int i2, String str) throws IOException;

    /* access modifiers changed from: package-private */
    public final void a(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        f20042a.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", unpairedSurrogateException);
        byte[] bytes = str.getBytes(h.f20137a);
        try {
            a(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e2) {
            throw new OutOfSpaceException(e2);
        } catch (OutOfSpaceException e3) {
            throw e3;
        }
    }

    public abstract void a(byte[] bArr, int i2, int i3) throws IOException;

    public final void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void b(int i2, int i3) throws IOException {
        a(i2, i3);
    }
}
