package com.google.protobuf;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class ByteString implements Serializable, Iterable<Byte> {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteString f20030a = new LiteralByteString(h.f20139c);

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f20031b = true;

    /* renamed from: c  reason: collision with root package name */
    private static final b f20032c;

    /* renamed from: d  reason: collision with root package name */
    private int f20033d = 0;

    private static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;

        /* renamed from: d  reason: collision with root package name */
        private final int f20037d;

        /* renamed from: e  reason: collision with root package name */
        private final int f20038e;

        BoundedByteString(byte[] bArr, int i2, int i3) {
            super(bArr);
            b(i2, i2 + i3, bArr.length);
            this.f20037d = i2;
            this.f20038e = i3;
        }

        public byte a(int i2) {
            b(i2, b());
            return this.f20039c[this.f20037d + i2];
        }

        /* access modifiers changed from: protected */
        public void a(byte[] bArr, int i2, int i3, int i4) {
            System.arraycopy(this.f20039c, g() + i2, bArr, i3, i4);
        }

        public int b() {
            return this.f20038e;
        }

        /* access modifiers changed from: protected */
        public int g() {
            return this.f20037d;
        }
    }

    static abstract class LeafByteString extends ByteString {
        LeafByteString() {
        }

        /* access modifiers changed from: package-private */
        public abstract boolean a(ByteString byteString, int i2, int i3);

        public /* synthetic */ Iterator iterator() {
            return ByteString.super.iterator();
        }
    }

    private static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;

        /* renamed from: c  reason: collision with root package name */
        protected final byte[] f20039c;

        LiteralByteString(byte[] bArr) {
            this.f20039c = bArr;
        }

        public byte a(int i2) {
            return this.f20039c[i2];
        }

        /* access modifiers changed from: protected */
        public final int a(int i2, int i3, int i4) {
            return h.a(i2, this.f20039c, g() + i3, i4);
        }

        public final ByteString a(int i2, int i3) {
            int b2 = b(i2, i3, b());
            return b2 == 0 ? ByteString.f20030a : new BoundedByteString(this.f20039c, g() + i2, b2);
        }

        /* access modifiers changed from: package-private */
        public final void a(c cVar) throws IOException {
            cVar.a(this.f20039c, g(), b());
        }

        /* access modifiers changed from: protected */
        public void a(byte[] bArr, int i2, int i3, int i4) {
            System.arraycopy(this.f20039c, i2, bArr, i3, i4);
        }

        /* access modifiers changed from: package-private */
        public final boolean a(ByteString byteString, int i2, int i3) {
            if (i3 <= byteString.b()) {
                int i4 = i2 + i3;
                if (i4 > byteString.b()) {
                    throw new IllegalArgumentException("Ran off end of other: " + i2 + ", " + i3 + ", " + byteString.b());
                } else if (!(byteString instanceof LiteralByteString)) {
                    return byteString.a(i2, i4).equals(a(0, i3));
                } else {
                    LiteralByteString literalByteString = (LiteralByteString) byteString;
                    byte[] bArr = this.f20039c;
                    byte[] bArr2 = literalByteString.f20039c;
                    int g2 = g() + i3;
                    int g3 = g();
                    int g4 = literalByteString.g() + i2;
                    while (g3 < g2) {
                        if (bArr[g3] != bArr2[g4]) {
                            return false;
                        }
                        g3++;
                        g4++;
                    }
                    return true;
                }
            } else {
                throw new IllegalArgumentException("Length too large: " + i3 + b());
            }
        }

        public int b() {
            return this.f20039c.length;
        }

        public final d e() {
            return d.a(this.f20039c, g(), b(), true);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || b() != ((ByteString) obj).b()) {
                return false;
            }
            if (b() == 0) {
                return true;
            }
            if (!(obj instanceof LiteralByteString)) {
                return obj.equals(this);
            }
            LiteralByteString literalByteString = (LiteralByteString) obj;
            int f2 = f();
            int f3 = literalByteString.f();
            if (f2 == 0 || f3 == 0 || f2 == f3) {
                return a((ByteString) literalByteString, 0, b());
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public int g() {
            return 0;
        }
    }

    private static final class a implements b {
        private a() {
        }

        public byte[] a(byte[] bArr, int i2, int i3) {
            return Arrays.copyOfRange(bArr, i2, i3 + i2);
        }
    }

    private interface b {
        byte[] a(byte[] bArr, int i2, int i3);
    }

    public interface c extends Iterator<Byte> {
    }

    static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final CodedOutputStream f20040a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f20041b;

        private d(int i2) {
            byte[] bArr = new byte[i2];
            this.f20041b = bArr;
            this.f20040a = CodedOutputStream.a(bArr);
        }

        public ByteString a() {
            this.f20040a.b();
            return new LiteralByteString(this.f20041b);
        }

        public CodedOutputStream b() {
            return this.f20040a;
        }
    }

    private static final class e implements b {
        private e() {
        }

        public byte[] a(byte[] bArr, int i2, int i3) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            return bArr2;
        }
    }

    static {
        boolean z2 = true;
        try {
            Class.forName("android.content.Context");
        } catch (ClassNotFoundException unused) {
            z2 = false;
        }
        f20032c = z2 ? new e() : new a();
    }

    ByteString() {
    }

    public static ByteString a(String str) {
        return new LiteralByteString(str.getBytes(h.f20137a));
    }

    public static ByteString a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static ByteString a(byte[] bArr, int i2, int i3) {
        return new LiteralByteString(f20032c.a(bArr, i2, i3));
    }

    static int b(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i2 + " < 0");
        } else if (i3 < i2) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i2 + ", " + i3);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i3 + " >= " + i4);
        }
    }

    static d b(int i2) {
        return new d(i2);
    }

    static ByteString b(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    static ByteString b(byte[] bArr, int i2, int i3) {
        return new BoundedByteString(bArr, i2, i3);
    }

    static void b(int i2, int i3) {
        if (((i3 - (i2 + 1)) | i2) >= 0) {
            return;
        }
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i2);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i2 + ", " + i3);
    }

    public abstract byte a(int i2);

    /* access modifiers changed from: protected */
    public abstract int a(int i2, int i3, int i4);

    /* renamed from: a */
    public final c iterator() {
        return new c() {

            /* renamed from: b  reason: collision with root package name */
            private int f20035b = 0;

            /* renamed from: c  reason: collision with root package name */
            private final int f20036c;

            {
                this.f20036c = ByteString.this.b();
            }

            /* renamed from: a */
            public Byte next() {
                return Byte.valueOf(b());
            }

            public byte b() {
                try {
                    ByteString byteString = ByteString.this;
                    int i2 = this.f20035b;
                    this.f20035b = i2 + 1;
                    return byteString.a(i2);
                } catch (IndexOutOfBoundsException e2) {
                    throw new NoSuchElementException(e2.getMessage());
                }
            }

            public boolean hasNext() {
                return this.f20035b < this.f20036c;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public abstract ByteString a(int i2, int i3);

    /* access modifiers changed from: package-private */
    public abstract void a(c cVar) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void a(byte[] bArr, int i2, int i3, int i4);

    public abstract int b();

    public final boolean c() {
        return b() == 0;
    }

    public final byte[] d() {
        int b2 = b();
        if (b2 == 0) {
            return h.f20139c;
        }
        byte[] bArr = new byte[b2];
        a(bArr, 0, 0, b2);
        return bArr;
    }

    public abstract d e();

    public abstract boolean equals(Object obj);

    /* access modifiers changed from: protected */
    public final int f() {
        return this.f20033d;
    }

    public final int hashCode() {
        int i2 = this.f20033d;
        if (i2 == 0) {
            int b2 = b();
            i2 = a(b2, 0, b2);
            if (i2 == 0) {
                i2 = 1;
            }
            this.f20033d = i2;
        }
        return i2;
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(b())});
    }
}
