package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class az extends aq {

    /* renamed from: a  reason: collision with root package name */
    private static final a f33371a = new a();

    /* renamed from: b  reason: collision with root package name */
    private int f33372b;

    /* renamed from: c  reason: collision with root package name */
    private int f33373c;

    /* renamed from: d  reason: collision with root package name */
    private int f33374d;

    /* renamed from: e  reason: collision with root package name */
    private byte f33375e;

    public static class a extends d {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, Class<? extends c>> f33376a = new HashMap();
    }

    public az() {
        super(new y("tmcd"));
        this.f33332k = f33371a;
    }

    public az(int i2, int i3, int i4, int i5) {
        super(new y("tmcd"));
        this.f33372b = i2;
        this.f33373c = i3;
        this.f33374d = i4;
        this.f33375e = (byte) i5;
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt(0);
        byteBuffer.putInt(this.f33372b);
        byteBuffer.putInt(this.f33373c);
        byteBuffer.putInt(this.f33374d);
        byteBuffer.put(this.f33375e);
        byteBuffer.put((byte) -49);
    }
}
