package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class ar extends u {

    /* renamed from: c  reason: collision with root package name */
    private int f33337c;

    /* renamed from: d  reason: collision with root package name */
    private int f33338d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f33339e;

    public ar() {
        super(new y(a()));
    }

    public ar(int[] iArr) {
        this();
        this.f33339e = iArr;
    }

    public static String a() {
        return "stsz";
    }

    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt(this.f33337c);
        if (this.f33337c == 0) {
            byteBuffer.putInt(this.f33339e.length);
            for (int i2 : this.f33339e) {
                byteBuffer.putInt((int) ((long) i2));
            }
            return;
        }
        byteBuffer.putInt(this.f33338d);
    }
}
