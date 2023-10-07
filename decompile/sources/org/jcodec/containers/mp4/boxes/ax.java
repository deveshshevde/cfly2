package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class ax extends u {

    /* renamed from: c  reason: collision with root package name */
    private a[] f33362c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f33363a;

        /* renamed from: b  reason: collision with root package name */
        int f33364b;

        public a(int i2, int i3) {
            this.f33363a = i2;
            this.f33364b = i3;
        }

        public int a() {
            return this.f33363a;
        }

        public int b() {
            return this.f33364b;
        }
    }

    public ax() {
        super(new y(a()));
    }

    public ax(a[] aVarArr) {
        super(new y(a()));
        this.f33362c = aVarArr;
    }

    public static String a() {
        return "stts";
    }

    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt(this.f33362c.length);
        for (a aVar : this.f33362c) {
            byteBuffer.putInt(aVar.a());
            byteBuffer.putInt(aVar.b());
        }
    }
}
