package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class aw extends u {

    /* renamed from: c  reason: collision with root package name */
    private int[] f33361c;

    public aw() {
        super(new y(b()));
    }

    public aw(y yVar) {
        super(yVar);
    }

    public aw(int[] iArr) {
        this();
        this.f33361c = iArr;
    }

    public static String b() {
        return "stss";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt(this.f33361c.length);
        int i2 = 0;
        while (true) {
            int[] iArr = this.f33361c;
            if (i2 < iArr.length) {
                byteBuffer.putInt(iArr[i2]);
                i2++;
            } else {
                return;
            }
        }
    }
}
