package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class ai extends u {

    /* renamed from: c  reason: collision with root package name */
    private int f33321c;

    public ai() {
        super(new y(a()));
    }

    public static String a() {
        return "mfhd";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt(this.f33321c);
    }
}
