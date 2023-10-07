package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import org.jcodec.common.i;

public class z extends c {

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f33555a;

    public z(y yVar, ByteBuffer byteBuffer) {
        super(yVar);
        this.f33555a = byteBuffer;
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        i.a(byteBuffer, this.f33555a);
    }
}
