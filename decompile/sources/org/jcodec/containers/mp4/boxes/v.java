package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class v extends c {

    /* renamed from: a  reason: collision with root package name */
    private float f33540a;

    public static String a() {
        return "gama";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt((int) (this.f33540a * 65536.0f));
    }
}
