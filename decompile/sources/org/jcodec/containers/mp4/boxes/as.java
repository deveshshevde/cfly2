package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class as extends u {

    /* renamed from: c  reason: collision with root package name */
    private a[] f33340c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private long f33341a;

        /* renamed from: b  reason: collision with root package name */
        private int f33342b;

        /* renamed from: c  reason: collision with root package name */
        private int f33343c;

        public a(long j2, int i2, int i3) {
            this.f33341a = j2;
            this.f33342b = i2;
            this.f33343c = i3;
        }

        public long a() {
            return this.f33341a;
        }

        public int b() {
            return this.f33342b;
        }

        public int c() {
            return this.f33343c;
        }
    }

    public as() {
        super(new y(a()));
    }

    public as(a[] aVarArr) {
        super(new y(a()));
        this.f33340c = aVarArr;
    }

    public static String a() {
        return "stsc";
    }

    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt(this.f33340c.length);
        for (a aVar : this.f33340c) {
            byteBuffer.putInt((int) aVar.a());
            byteBuffer.putInt(aVar.b());
            byteBuffer.putInt(aVar.c());
        }
    }
}
