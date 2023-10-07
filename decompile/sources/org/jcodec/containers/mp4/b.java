package org.jcodec.containers.mp4;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.jcodec.common.Codec;
import org.jcodec.common.j;
import org.jcodec.containers.mp4.boxes.ae;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Codec, String> f33282a;

    static {
        HashMap hashMap = new HashMap();
        f33282a = hashMap;
        hashMap.put(Codec.MPEG2, "m2v1");
        f33282a.put(Codec.H264, "avc1");
        f33282a.put(Codec.J2K, "mjp2");
    }

    public static void a(j jVar, ae aeVar) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(16777216);
        aeVar.b(allocate);
        allocate.flip();
        jVar.write(allocate);
    }
}
