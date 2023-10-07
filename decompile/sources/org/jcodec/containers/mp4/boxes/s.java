package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.LinkedList;
import org.jcodec.common.g;

public class s extends c {

    /* renamed from: a  reason: collision with root package name */
    private String f33534a;

    /* renamed from: b  reason: collision with root package name */
    private int f33535b;

    /* renamed from: c  reason: collision with root package name */
    private Collection<String> f33536c = new LinkedList();

    public s() {
        super(new y(a()));
    }

    public s(String str, int i2, Collection<String> collection) {
        super(new y(a()));
        this.f33534a = str;
        this.f33535b = i2;
        this.f33536c = collection;
    }

    public static String a() {
        return "ftyp";
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.put(g.a(this.f33534a));
        byteBuffer.putInt(this.f33535b);
        for (String a2 : this.f33536c) {
            byteBuffer.put(g.a(a2));
        }
    }
}
