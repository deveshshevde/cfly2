package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class EndianBox extends c {

    /* renamed from: a  reason: collision with root package name */
    private Endian f33283a;

    public enum Endian {
        LITTLE_ENDIAN,
        BIG_ENDIAN
    }

    public static String a() {
        return "enda";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putShort((short) (this.f33283a == Endian.LITTLE_ENDIAN ? 1 : 0));
    }
}
