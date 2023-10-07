package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import org.jcodec.common.model.c;

public class an extends c {

    /* renamed from: a  reason: collision with root package name */
    private int f33333a;

    /* renamed from: b  reason: collision with root package name */
    private int f33334b;

    public an() {
        super(new y(b()));
    }

    public static String b() {
        return "pasp";
    }

    public c a() {
        return new c(this.f33333a, this.f33334b);
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.f33333a);
        byteBuffer.putInt(this.f33334b);
    }
}
