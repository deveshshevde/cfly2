package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class u extends c {

    /* renamed from: a  reason: collision with root package name */
    protected byte f33538a;

    /* renamed from: b  reason: collision with root package name */
    protected int f33539b;

    public u(y yVar) {
        super(yVar);
    }

    public void a(int i2) {
        this.f33539b = i2;
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt((this.f33538a << 24) | (this.f33539b & 16777215));
    }
}
