package od;

import java.nio.ByteBuffer;

public class a {

    /* renamed from: a  reason: collision with root package name */
    protected int f31668a = 0;

    /* renamed from: b  reason: collision with root package name */
    protected int f31669b = a();

    /* renamed from: c  reason: collision with root package name */
    private ByteBuffer f31670c;

    /* renamed from: d  reason: collision with root package name */
    private int f31671d;

    public a(ByteBuffer byteBuffer) {
        this.f31670c = byteBuffer;
        this.f31671d = byteBuffer.position();
    }

    private int c() {
        this.f31668a -= this.f31670c.remaining() << 3;
        byte b2 = 0;
        if (this.f31670c.hasRemaining()) {
            b2 = 0 | (this.f31670c.get() & 255);
        }
        int i2 = b2 << 8;
        if (this.f31670c.hasRemaining()) {
            i2 |= this.f31670c.get() & 255;
        }
        int i3 = i2 << 8;
        if (this.f31670c.hasRemaining()) {
            i3 |= this.f31670c.get() & 255;
        }
        int i4 = i3 << 8;
        return this.f31670c.hasRemaining() ? i4 | (this.f31670c.get() & 255) : i4;
    }

    public final int a() {
        if (this.f31670c.remaining() < 4) {
            return c();
        }
        this.f31668a -= 32;
        return ((this.f31670c.get() & 255) << 24) | ((this.f31670c.get() & 255) << 16) | ((this.f31670c.get() & 255) << 8) | (this.f31670c.get() & 255);
    }

    public int a(int i2) {
        if (i2 <= 32) {
            int i3 = 0;
            int i4 = this.f31668a;
            if (i2 + i4 > 31) {
                i2 -= 32 - i4;
                i3 = (0 | (this.f31669b >>> i4)) << i2;
                this.f31668a = 32;
                this.f31669b = a();
            }
            if (i2 == 0) {
                return i3;
            }
            int i5 = this.f31669b;
            int i6 = i3 | (i5 >>> (32 - i2));
            this.f31669b = i5 << i2;
            this.f31668a += i2;
            return i6;
        }
        throw new IllegalArgumentException("Can not read more then 32 bit");
    }

    public int b() {
        int i2 = this.f31669b;
        int i3 = i2 >>> 31;
        this.f31669b = i2 << 1;
        int i4 = this.f31668a + 1;
        this.f31668a = i4;
        if (i4 == 32) {
            this.f31669b = a();
        }
        return i3;
    }
}
