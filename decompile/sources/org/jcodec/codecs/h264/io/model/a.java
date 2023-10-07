package org.jcodec.codecs.h264.io.model;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f32996a = new a(255);

    /* renamed from: b  reason: collision with root package name */
    private int f32997b;

    private a(int i2) {
        this.f32997b = i2;
    }

    public static a a(int i2) {
        a aVar = f32996a;
        return i2 == aVar.f32997b ? aVar : new a(i2);
    }

    public int a() {
        return this.f32997b;
    }
}
