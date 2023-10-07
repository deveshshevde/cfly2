package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class r extends c {

    /* renamed from: a  reason: collision with root package name */
    private int f33532a;

    /* renamed from: b  reason: collision with root package name */
    private int f33533b;

    public r() {
        super(new y(a()));
    }

    public static String a() {
        return "fiel";
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) this.f33532a);
        byteBuffer.put((byte) this.f33533b);
    }
}
