package fi;

import com.blankj.utilcode.constant.MemoryConstants;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public final b f13098a = new b();

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f13099b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13100c;

    /* renamed from: d  reason: collision with root package name */
    public long f13101d;

    /* renamed from: e  reason: collision with root package name */
    public ByteBuffer f13102e;

    /* renamed from: f  reason: collision with root package name */
    private final int f13103f;

    public e(int i2) {
        this.f13103f = i2;
    }

    public static e a() {
        return new e(0);
    }

    private ByteBuffer c(int i2) {
        int i3 = this.f13103f;
        if (i3 == 1) {
            return ByteBuffer.allocate(i2);
        }
        if (i3 == 2) {
            return ByteBuffer.allocateDirect(i2);
        }
        ByteBuffer byteBuffer = this.f13099b;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i2);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }

    @EnsuresNonNull({"supplementalData"})
    public void a(int i2) {
        ByteBuffer byteBuffer = this.f13102e;
        if (byteBuffer == null || byteBuffer.capacity() < i2) {
            this.f13102e = ByteBuffer.allocate(i2);
        } else {
            this.f13102e.clear();
        }
    }

    @EnsuresNonNull({"data"})
    public void b(int i2) {
        ByteBuffer byteBuffer = this.f13099b;
        if (byteBuffer == null) {
            this.f13099b = c(i2);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.f13099b.position();
        int i3 = i2 + position;
        if (capacity < i3) {
            ByteBuffer c2 = c(i3);
            c2.order(this.f13099b.order());
            if (position > 0) {
                this.f13099b.flip();
                c2.put(this.f13099b);
            }
            this.f13099b = c2;
        }
    }

    public final boolean b() {
        return this.f13099b == null && this.f13103f == 0;
    }

    public final boolean c() {
        return getFlag(MemoryConstants.GB);
    }

    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.f13099b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f13102e;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f13100c = false;
    }

    public final void d() {
        this.f13099b.flip();
        ByteBuffer byteBuffer = this.f13102e;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
    }
}
