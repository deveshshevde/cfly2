package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import org.jcodec.common.i;

public class ay extends u {

    /* renamed from: c  reason: collision with root package name */
    private short f33365c;

    /* renamed from: d  reason: collision with root package name */
    private short f33366d;

    /* renamed from: e  reason: collision with root package name */
    private short f33367e;

    /* renamed from: f  reason: collision with root package name */
    private short[] f33368f;

    /* renamed from: g  reason: collision with root package name */
    private short[] f33369g;

    /* renamed from: h  reason: collision with root package name */
    private String f33370h;

    public ay(y yVar) {
        super(yVar);
        this.f33368f = new short[3];
        this.f33369g = new short[3];
    }

    public ay(short s2, short s3, short s4, short[] sArr, short[] sArr2, String str) {
        this(new y(a()));
        this.f33365c = s2;
        this.f33366d = s3;
        this.f33367e = s4;
        this.f33368f = sArr;
        this.f33369g = sArr2;
        this.f33370h = str;
    }

    public static String a() {
        return "tcmi";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putShort(this.f33365c);
        byteBuffer.putShort(this.f33366d);
        byteBuffer.putShort(this.f33367e);
        byteBuffer.putShort(0);
        byteBuffer.putShort(this.f33368f[0]);
        byteBuffer.putShort(this.f33368f[1]);
        byteBuffer.putShort(this.f33368f[2]);
        byteBuffer.putShort(this.f33369g[0]);
        byteBuffer.putShort(this.f33369g[1]);
        byteBuffer.putShort(this.f33369g[2]);
        i.a(byteBuffer, this.f33370h);
    }
}
