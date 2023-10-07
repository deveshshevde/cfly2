package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.jcodec.common.g;
import org.jcodec.common.i;

public class bj extends aq {

    /* renamed from: a  reason: collision with root package name */
    private static final a f33435a = new a();

    /* renamed from: b  reason: collision with root package name */
    private short f33436b;

    /* renamed from: c  reason: collision with root package name */
    private short f33437c;

    /* renamed from: d  reason: collision with root package name */
    private String f33438d;

    /* renamed from: e  reason: collision with root package name */
    private int f33439e;

    /* renamed from: f  reason: collision with root package name */
    private int f33440f;

    /* renamed from: g  reason: collision with root package name */
    private short f33441g;

    /* renamed from: h  reason: collision with root package name */
    private short f33442h;

    /* renamed from: l  reason: collision with root package name */
    private float f33443l;

    /* renamed from: m  reason: collision with root package name */
    private float f33444m;

    /* renamed from: n  reason: collision with root package name */
    private short f33445n;

    /* renamed from: o  reason: collision with root package name */
    private String f33446o;

    /* renamed from: p  reason: collision with root package name */
    private short f33447p;

    /* renamed from: q  reason: collision with root package name */
    private short f33448q;

    public static class a extends d {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, Class<? extends c>> f33449a;

        public a() {
            HashMap hashMap = new HashMap();
            this.f33449a = hashMap;
            hashMap.put(an.b(), an.class);
            this.f33449a.put(k.a(), k.class);
            this.f33449a.put(v.a(), v.class);
            this.f33449a.put(h.a(), h.class);
            this.f33449a.put(r.a(), r.class);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bj(y yVar, short s2, short s3, String str, int i2, int i3, short s4, short s5, long j2, long j3, short s6, String str2, short s7, short s8, short s9) {
        super(yVar, s8);
        y yVar2 = yVar;
        this.f33332k = f33435a;
        this.f33436b = s2;
        this.f33437c = s3;
        this.f33438d = str;
        this.f33439e = i2;
        this.f33440f = i3;
        this.f33441g = s4;
        this.f33442h = s5;
        this.f33443l = (float) j2;
        this.f33444m = (float) j3;
        this.f33445n = s6;
        this.f33446o = str2;
        this.f33447p = s7;
        this.f33448q = s9;
    }

    public int a() {
        return this.f33441g;
    }

    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putShort(this.f33436b);
        byteBuffer.putShort(this.f33437c);
        byteBuffer.put(g.a(this.f33438d), 0, 4);
        byteBuffer.putInt(this.f33439e);
        byteBuffer.putInt(this.f33440f);
        byteBuffer.putShort(this.f33441g);
        byteBuffer.putShort(this.f33442h);
        byteBuffer.putInt((int) (this.f33443l * 65536.0f));
        byteBuffer.putInt((int) (this.f33444m * 65536.0f));
        byteBuffer.putInt(0);
        byteBuffer.putShort(this.f33445n);
        i.a(byteBuffer, this.f33446o, 31);
        byteBuffer.putShort(this.f33447p);
        byteBuffer.putShort(this.f33448q);
        c(byteBuffer);
    }

    public int c() {
        return this.f33442h;
    }
}
