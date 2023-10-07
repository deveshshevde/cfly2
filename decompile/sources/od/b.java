package od;

import java.nio.ByteBuffer;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f31672a;

    /* renamed from: b  reason: collision with root package name */
    private int f31673b;

    /* renamed from: c  reason: collision with root package name */
    private int f31674c;

    /* renamed from: d  reason: collision with root package name */
    private int f31675d;

    public b(ByteBuffer byteBuffer) {
        this.f31672a = byteBuffer;
        this.f31675d = byteBuffer.position();
    }

    private b(ByteBuffer byteBuffer, int i2, int i3, int i4) {
        this.f31672a = byteBuffer;
        this.f31674c = i2;
        this.f31673b = i3;
        this.f31675d = i4;
    }

    private final void b(int i2) {
        this.f31672a.put((byte) (i2 >>> 24));
        this.f31672a.put((byte) (i2 >> 16));
        this.f31672a.put((byte) (i2 >> 8));
        this.f31672a.put((byte) i2);
    }

    public void a() {
        int i2 = (this.f31674c + 7) >> 3;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f31672a.put((byte) (this.f31673b >>> 24));
            this.f31673b <<= 8;
        }
    }

    public void a(int i2) {
        int i3 = this.f31673b;
        int i4 = this.f31674c;
        int i5 = (i2 << ((32 - i4) - 1)) | i3;
        this.f31673b = i5;
        int i6 = i4 + 1;
        this.f31674c = i6;
        if (i6 == 32) {
            b(i5);
            this.f31674c = 0;
            this.f31673b = 0;
        }
    }

    public final void a(int i2, int i3) {
        if (i3 > 32) {
            throw new IllegalArgumentException("Max 32 bit to write");
        } else if (i3 != 0) {
            int i4 = i2 & (-1 >>> (32 - i3));
            int i5 = this.f31674c;
            if (32 - i5 >= i3) {
                int i6 = (i4 << ((32 - i5) - i3)) | this.f31673b;
                this.f31673b = i6;
                int i7 = i5 + i3;
                this.f31674c = i7;
                if (i7 == 32) {
                    b(i6);
                    this.f31674c = 0;
                    this.f31673b = 0;
                    return;
                }
                return;
            }
            int i8 = i3 - (32 - i5);
            int i9 = this.f31673b | (i4 >>> i8);
            this.f31673b = i9;
            b(i9);
            this.f31673b = i4 << (32 - i8);
            this.f31674c = i8;
        }
    }

    public b b() {
        return new b(this.f31672a.duplicate(), this.f31674c, this.f31673b, this.f31675d);
    }

    public int c() {
        return ((this.f31672a.position() - this.f31675d) << 3) + this.f31674c;
    }

    public ByteBuffer d() {
        return this.f31672a;
    }
}
