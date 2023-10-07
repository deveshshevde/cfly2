package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import org.jcodec.common.g;

public class t extends c {

    /* renamed from: a  reason: collision with root package name */
    private String f33537a;

    public static String a() {
        return "frma";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        byteBuffer.put(g.a(this.f33537a));
    }
}
