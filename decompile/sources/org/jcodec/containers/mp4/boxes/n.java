package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class n extends al {

    /* renamed from: a  reason: collision with root package name */
    private static final a f33526a = new a();

    public static class a extends d {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, Class<? extends c>> f33527a;

        public a() {
            HashMap hashMap = new HashMap();
            this.f33527a = hashMap;
            hashMap.put(bh.a(), bh.class);
            this.f33527a.put(a.a(), a.class);
            this.f33527a.put("cios", a.class);
        }
    }

    public n() {
        this(new y(a()));
    }

    private n(y yVar) {
        super(yVar);
        this.f33332k = f33526a;
    }

    public static String a() {
        return "dref";
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt(0);
        byteBuffer.putInt(this.f33331j.size());
        super.a(byteBuffer);
    }
}
