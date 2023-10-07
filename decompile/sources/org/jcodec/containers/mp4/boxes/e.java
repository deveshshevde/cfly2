package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class e extends u {

    /* renamed from: c  reason: collision with root package name */
    private int f33496c;

    /* renamed from: d  reason: collision with root package name */
    private int f33497d;

    /* renamed from: e  reason: collision with root package name */
    private a[] f33498e;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f33499a;

        /* renamed from: b  reason: collision with root package name */
        private int f33500b;

        /* renamed from: c  reason: collision with root package name */
        private float[] f33501c;

        public int a() {
            return this.f33499a;
        }

        public int b() {
            return this.f33500b;
        }

        public float[] c() {
            return this.f33501c;
        }
    }

    public e() {
        super(new y(a()));
    }

    public static String a() {
        return "chan";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt(this.f33496c);
        byteBuffer.putInt(this.f33497d);
        byteBuffer.putInt(this.f33498e.length);
        for (a aVar : this.f33498e) {
            byteBuffer.putInt(aVar.a());
            byteBuffer.putInt(aVar.b());
            byteBuffer.putFloat(aVar.c()[0]);
            byteBuffer.putFloat(aVar.c()[1]);
            byteBuffer.putFloat(aVar.c()[2]);
        }
    }
}
