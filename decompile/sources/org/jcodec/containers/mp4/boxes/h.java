package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class h extends c {

    /* renamed from: a  reason: collision with root package name */
    private int f33504a;

    /* renamed from: b  reason: collision with root package name */
    private int f33505b;

    /* renamed from: c  reason: collision with root package name */
    private int f33506c;

    /* renamed from: d  reason: collision with root package name */
    private int f33507d;

    /* renamed from: e  reason: collision with root package name */
    private int f33508e;

    /* renamed from: f  reason: collision with root package name */
    private int f33509f;

    /* renamed from: g  reason: collision with root package name */
    private int f33510g;

    /* renamed from: h  reason: collision with root package name */
    private int f33511h;

    public h() {
        super(new y(a()));
    }

    public static String a() {
        return "clap";
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.f33511h);
        byteBuffer.putInt(this.f33510g);
        byteBuffer.putInt(this.f33509f);
        byteBuffer.putInt(this.f33508e);
        byteBuffer.putInt(this.f33507d);
        byteBuffer.putInt(this.f33506c);
        byteBuffer.putInt(this.f33505b);
        byteBuffer.putInt(this.f33504a);
    }
}
