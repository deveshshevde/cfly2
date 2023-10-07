package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import java.util.List;

public class p extends u {

    /* renamed from: c  reason: collision with root package name */
    private List<o> f33531c;

    public p() {
        this(new y(a()));
    }

    public p(List<o> list) {
        this();
        this.f33531c = list;
    }

    public p(y yVar) {
        super(yVar);
    }

    public static String a() {
        return "elst";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt(this.f33531c.size());
        for (o next : this.f33531c) {
            byteBuffer.putInt((int) next.a());
            byteBuffer.putInt((int) next.b());
            byteBuffer.putInt((int) (next.c() * 65536.0f));
        }
    }
}
