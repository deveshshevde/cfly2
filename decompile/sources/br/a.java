package br;

import com.bumptech.glide.load.data.e;
import java.nio.ByteBuffer;

public class a implements e<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f5979a;

    /* renamed from: br.a$a  reason: collision with other inner class name */
    public static class C0058a implements e.a<ByteBuffer> {
        public e<ByteBuffer> a(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f5979a = byteBuffer;
    }

    public void b() {
    }

    /* renamed from: c */
    public ByteBuffer a() {
        this.f5979a.position(0);
        return this.f5979a;
    }
}
