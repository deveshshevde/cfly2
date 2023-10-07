package jp.co.cyberagent.android.gpuimage;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import mh.a;

public class b extends a {

    /* renamed from: g  reason: collision with root package name */
    protected List<a> f29668g;

    /* renamed from: h  reason: collision with root package name */
    protected List<a> f29669h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f29670i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f29671j;

    /* renamed from: k  reason: collision with root package name */
    private final FloatBuffer f29672k;

    /* renamed from: l  reason: collision with root package name */
    private final FloatBuffer f29673l;

    /* renamed from: m  reason: collision with root package name */
    private final FloatBuffer f29674m;

    public b() {
        this((List<a>) null);
    }

    public b(List<a> list) {
        this.f29668g = list;
        if (list == null) {
            this.f29668g = new ArrayList();
        } else {
            m();
        }
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(d.f29683a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f29672k = asFloatBuffer;
        asFloatBuffer.put(d.f29683a).position(0);
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(a.f31202a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f29673l = asFloatBuffer2;
        asFloatBuffer2.put(a.f31202a).position(0);
        float[] a2 = a.a(Rotation.NORMAL, false, true);
        FloatBuffer asFloatBuffer3 = ByteBuffer.allocateDirect(a2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f29674m = asFloatBuffer3;
        asFloatBuffer3.put(a2).position(0);
    }

    private void n() {
        int[] iArr = this.f29671j;
        if (iArr != null) {
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
            this.f29671j = null;
        }
        int[] iArr2 = this.f29670i;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(iArr2.length, iArr2, 0);
            this.f29670i = null;
        }
    }

    public void a(int i2, int i3) {
        super.a(i2, i3);
        if (this.f29670i != null) {
            n();
        }
        int size = this.f29668g.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.f29668g.get(i4).a(i2, i3);
        }
        int i5 = i2;
        int i6 = i3;
        List<a> list = this.f29669h;
        if (list != null && list.size() > 0) {
            int i7 = 1;
            int size2 = this.f29669h.size() - 1;
            this.f29670i = new int[size2];
            this.f29671j = new int[size2];
            int i8 = 0;
            while (i8 < size2) {
                GLES20.glGenFramebuffers(i7, this.f29670i, i8);
                GLES20.glGenTextures(i7, this.f29671j, i8);
                GLES20.glBindTexture(3553, this.f29671j[i8]);
                GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, (Buffer) null);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                GLES20.glBindFramebuffer(36160, this.f29670i[i8]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f29671j[i8], 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
                i8++;
                i7 = 1;
            }
        }
    }

    public void a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        List<a> list;
        FloatBuffer floatBuffer3;
        FloatBuffer floatBuffer4;
        g();
        if (h() && this.f29670i != null && this.f29671j != null && (list = this.f29669h) != null) {
            int size = list.size();
            int i3 = 0;
            while (i3 < size) {
                a aVar = this.f29669h.get(i3);
                int i4 = size - 1;
                boolean z2 = i3 < i4;
                if (z2) {
                    GLES20.glBindFramebuffer(36160, this.f29670i[i3]);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                }
                if (i3 == 0) {
                    aVar.a(i2, floatBuffer, floatBuffer2);
                } else {
                    if (i3 == i4) {
                        floatBuffer4 = this.f29672k;
                        if (size % 2 == 0) {
                            floatBuffer3 = this.f29674m;
                            aVar.a(i2, floatBuffer4, floatBuffer3);
                        }
                    } else {
                        floatBuffer4 = this.f29672k;
                    }
                    floatBuffer3 = this.f29673l;
                    aVar.a(i2, floatBuffer4, floatBuffer3);
                }
                if (z2) {
                    GLES20.glBindFramebuffer(36160, 0);
                    i2 = this.f29671j[i3];
                }
                i3++;
            }
        }
    }

    public void b() {
        super.b();
        for (a a2 : this.f29668g) {
            a2.a();
        }
    }

    public void e() {
        n();
        for (a d2 : this.f29668g) {
            d2.d();
        }
        super.e();
    }

    public List<a> l() {
        return this.f29669h;
    }

    public void m() {
        if (this.f29668g != null) {
            List<a> list = this.f29669h;
            if (list == null) {
                this.f29669h = new ArrayList();
            } else {
                list.clear();
            }
            for (a next : this.f29668g) {
                if (next instanceof b) {
                    b bVar = (b) next;
                    bVar.m();
                    List<a> l2 = bVar.l();
                    if (l2 != null && !l2.isEmpty()) {
                        this.f29669h.addAll(l2);
                    }
                } else {
                    this.f29669h.add(next);
                }
            }
        }
    }
}
