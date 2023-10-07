package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import org.jcodec.common.g;

public class ak extends c {

    /* renamed from: a  reason: collision with root package name */
    private String f33330a;

    public ak() {
        super(new y(a()));
    }

    public ak(String str) {
        this();
        this.f33330a = str;
    }

    public static String a() {
        return "name";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        byteBuffer.put(g.a(this.f33330a));
        byteBuffer.putInt(0);
    }
}
