package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class aq extends al {

    /* renamed from: a  reason: collision with root package name */
    private short f33336a;

    public aq(y yVar) {
        super(yVar);
    }

    public aq(y yVar, short s2) {
        super(yVar);
        this.f33336a = s2;
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        byteBuffer.put(new byte[]{0, 0, 0, 0, 0, 0});
        byteBuffer.putShort(this.f33336a);
    }

    /* access modifiers changed from: protected */
    public void c(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
    }
}
