package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import org.jcodec.common.g;

public class x extends u {

    /* renamed from: c  reason: collision with root package name */
    private String f33546c;

    /* renamed from: d  reason: collision with root package name */
    private String f33547d;

    /* renamed from: e  reason: collision with root package name */
    private String f33548e;

    /* renamed from: f  reason: collision with root package name */
    private int f33549f;

    /* renamed from: g  reason: collision with root package name */
    private int f33550g;

    /* renamed from: h  reason: collision with root package name */
    private String f33551h;

    public x() {
        super(new y(a()));
    }

    public x(String str, String str2, String str3, int i2, int i3) {
        super(new y("hdlr"));
        this.f33546c = str;
        this.f33547d = str2;
        this.f33548e = str3;
        this.f33549f = i2;
        this.f33550g = i3;
        this.f33551h = "";
    }

    public static String a() {
        return "hdlr";
    }

    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.put(g.a(this.f33546c));
        byteBuffer.put(g.a(this.f33547d));
        byteBuffer.put(g.a(this.f33548e));
        byteBuffer.putInt(this.f33549f);
        byteBuffer.putInt(this.f33550g);
        String str = this.f33551h;
        if (str != null) {
            byteBuffer.put(g.a(str));
        }
    }
}
