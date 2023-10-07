package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import org.jcodec.common.g;

public class k extends c {

    /* renamed from: a  reason: collision with root package name */
    private short f33519a;

    /* renamed from: b  reason: collision with root package name */
    private short f33520b;

    /* renamed from: c  reason: collision with root package name */
    private short f33521c;

    /* renamed from: d  reason: collision with root package name */
    private final String f33522d = "nclc";

    public k() {
        super(new y(a()));
    }

    public static String a() {
        return "colr";
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.put(g.a("nclc"));
        byteBuffer.putShort(this.f33519a);
        byteBuffer.putShort(this.f33520b);
        byteBuffer.putShort(this.f33521c);
    }
}
