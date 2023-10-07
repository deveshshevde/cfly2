package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class l extends u {

    /* renamed from: c  reason: collision with root package name */
    private a[] f33523c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f33524a;

        /* renamed from: b  reason: collision with root package name */
        public int f33525b;

        public a(int i2, int i3) {
            this.f33524a = i2;
            this.f33525b = i3;
        }

        public int a() {
            return this.f33525b;
        }
    }

    public l() {
        super(new y(a()));
    }

    public l(a[] aVarArr) {
        super(new y(a()));
        this.f33523c = aVarArr;
    }

    public static String a() {
        return "ctts";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt(this.f33523c.length);
        int i2 = 0;
        while (true) {
            a[] aVarArr = this.f33523c;
            if (i2 < aVarArr.length) {
                byteBuffer.putInt(aVarArr[i2].f33524a);
                byteBuffer.putInt(this.f33523c[i2].f33525b);
                i2++;
            } else {
                return;
            }
        }
    }
}
