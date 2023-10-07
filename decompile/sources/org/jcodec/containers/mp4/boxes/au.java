package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.LinkedList;
import org.jcodec.common.g;

public class au extends c {

    /* renamed from: a  reason: collision with root package name */
    private String f33357a;

    /* renamed from: b  reason: collision with root package name */
    private int f33358b;

    /* renamed from: c  reason: collision with root package name */
    private Collection<String> f33359c = new LinkedList();

    public au() {
        super(new y(a()));
    }

    public static String a() {
        return "styp";
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.put(g.a(this.f33357a));
        byteBuffer.putInt(this.f33358b);
        for (String a2 : this.f33359c) {
            byteBuffer.put(g.a(a2));
        }
    }
}
