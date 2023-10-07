package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.jcodec.common.i;

public class bh extends u {

    /* renamed from: c  reason: collision with root package name */
    private String f33430c;

    public static String a() {
        return "url ";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        Charset forName = Charset.forName("utf-8");
        String str = this.f33430c;
        if (str != null) {
            i.a(byteBuffer, ByteBuffer.wrap(str.getBytes(forName)));
            byteBuffer.put((byte) 0);
        }
    }
}
