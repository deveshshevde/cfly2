package cs;

import android.content.res.Resources;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class b extends a {

    /* renamed from: l  reason: collision with root package name */
    public List<a> f26264l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private Queue<a> f26265m = new ConcurrentLinkedQueue();

    /* renamed from: n  reason: collision with root package name */
    private int f26266n = 0;

    /* renamed from: o  reason: collision with root package name */
    private int f26267o = 0;

    /* renamed from: p  reason: collision with root package name */
    private int f26268p = 0;

    /* renamed from: q  reason: collision with root package name */
    private int f26269q = 2;

    /* renamed from: r  reason: collision with root package name */
    private int[] f26270r = new int[1];

    /* renamed from: s  reason: collision with root package name */
    private int[] f26271s = new int[1];

    /* renamed from: t  reason: collision with root package name */
    private int[] f26272t = new int[2];

    /* renamed from: u  reason: collision with root package name */
    private int f26273u = 0;

    public b(Resources resources) {
        super(resources);
    }

    private void o() {
        while (true) {
            a poll = this.f26265m.poll();
            if (poll != null) {
                poll.a();
                poll.a(this.f26266n, this.f26267o);
                this.f26264l.add(poll);
                this.f26268p++;
            } else {
                return;
            }
        }
    }

    private boolean p() {
        GLES20.glGenFramebuffers(1, this.f26270r, 0);
        GLES20.glGenRenderbuffers(1, this.f26271s, 0);
        q();
        GLES20.glBindFramebuffer(36160, this.f26270r[0]);
        GLES20.glBindRenderbuffer(36161, this.f26271s[0]);
        GLES20.glRenderbufferStorage(36161, 33189, this.f26266n, this.f26267o);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f26272t[0], 0);
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.f26271s[0]);
        r();
        return false;
    }

    private void q() {
        GLES20.glGenTextures(this.f26269q, this.f26272t, 0);
        for (int i2 = 0; i2 < this.f26269q; i2++) {
            GLES20.glBindTexture(3553, this.f26272t[i2]);
            GLES20.glTexImage2D(3553, 0, 6408, this.f26266n, this.f26267o, 0, 6408, 5121, (Buffer) null);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10241, 9729);
        }
    }

    private void r() {
        GLES20.glBindRenderbuffer(36161, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public void a(a aVar) {
        this.f26265m.add(aVar);
    }

    public void b() {
        o();
        this.f26273u = 0;
        GLES20.glViewport(0, 0, this.f26266n, this.f26267o);
        for (a next : this.f26264l) {
            GLES20.glBindFramebuffer(36160, this.f26270r[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f26272t[this.f26273u % 2], 0);
            GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.f26271s[0]);
            int i2 = this.f26273u;
            next.a(i2 == 0 ? e() : this.f26272t[(i2 - 1) % 2]);
            next.b();
            r();
            this.f26273u++;
        }
    }

    /* access modifiers changed from: protected */
    public void b(int i2, int i3) {
        this.f26266n = i2;
        this.f26267o = i3;
        o();
        p();
    }

    public int f() {
        return this.f26268p == 0 ? e() : this.f26272t[(this.f26273u - 1) % 2];
    }

    /* access modifiers changed from: protected */
    public void g() {
    }

    /* access modifiers changed from: protected */
    public void h() {
    }
}
