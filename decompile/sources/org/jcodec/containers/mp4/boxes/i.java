package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class i extends u {

    /* renamed from: c  reason: collision with root package name */
    private float f33512c;

    /* renamed from: d  reason: collision with root package name */
    private float f33513d;

    public i() {
        super(new y(a()));
    }

    public i(int i2, int i3) {
        this();
        this.f33512c = (float) i2;
        this.f33513d = (float) i3;
    }

    public i(y yVar) {
        super(yVar);
    }

    public i(y yVar, int i2, int i3) {
        super(yVar);
        this.f33512c = (float) i2;
        this.f33513d = (float) i3;
    }

    public static String a() {
        return "clef";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt((int) (this.f33512c * 65536.0f));
        byteBuffer.putInt((int) (this.f33513d * 65536.0f));
    }
}
