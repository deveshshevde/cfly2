package com.google.android.exoplayer2.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.aa;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.n;
import fi.e;
import java.util.Collections;
import java.util.List;

public final class k extends d implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f16605a;

    /* renamed from: b  reason: collision with root package name */
    private final j f16606b;

    /* renamed from: c  reason: collision with root package name */
    private final g f16607c;

    /* renamed from: d  reason: collision with root package name */
    private final o f16608d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16609e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16610f;

    /* renamed from: g  reason: collision with root package name */
    private int f16611g;

    /* renamed from: h  reason: collision with root package name */
    private Format f16612h;

    /* renamed from: i  reason: collision with root package name */
    private f f16613i;

    /* renamed from: j  reason: collision with root package name */
    private h f16614j;

    /* renamed from: k  reason: collision with root package name */
    private i f16615k;

    /* renamed from: l  reason: collision with root package name */
    private i f16616l;

    /* renamed from: m  reason: collision with root package name */
    private int f16617m;

    public k(j jVar, Looper looper) {
        this(jVar, looper, g.f16601a);
    }

    public k(j jVar, Looper looper, g gVar) {
        super(3);
        this.f16606b = (j) a.b(jVar);
        this.f16605a = looper == null ? null : ad.a(looper, (Handler.Callback) this);
        this.f16607c = gVar;
        this.f16608d = new o();
    }

    private void A() {
        this.f16614j = null;
        this.f16617m = -1;
        i iVar = this.f16615k;
        if (iVar != null) {
            iVar.release();
            this.f16615k = null;
        }
        i iVar2 = this.f16616l;
        if (iVar2 != null) {
            iVar2.release();
            this.f16616l = null;
        }
    }

    private void B() {
        A();
        this.f16613i.d();
        this.f16613i = null;
        this.f16611g = 0;
    }

    private void C() {
        B();
        this.f16613i = this.f16607c.b(this.f16612h);
    }

    private long D() {
        int i2 = this.f16617m;
        if (i2 == -1 || i2 >= this.f16615k.a()) {
            return Long.MAX_VALUE;
        }
        return this.f16615k.a(this.f16617m);
    }

    private void E() {
        a((List<b>) Collections.emptyList());
    }

    private void F() {
        E();
        if (this.f16611g != 0) {
            C();
            return;
        }
        A();
        this.f16613i.c();
    }

    private void a(SubtitleDecoderException subtitleDecoderException) {
        String valueOf = String.valueOf(this.f16612h);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39);
        sb.append("Subtitle decoding failed. streamFormat=");
        sb.append(valueOf);
        com.google.android.exoplayer2.util.k.b("TextRenderer", sb.toString(), subtitleDecoderException);
        F();
    }

    private void a(List<b> list) {
        Handler handler = this.f16605a;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            b(list);
        }
    }

    private void b(List<b> list) {
        this.f16606b.a(list);
    }

    public int a(Format format) {
        if (this.f16607c.a(format)) {
            return aa.CC.b(a((b<?>) null, format.f15095l) ? 4 : 2);
        }
        return aa.CC.b(n.c(format.f15092i) ? 1 : 0);
    }

    public void a(long j2, long j3) {
        boolean z2;
        if (!this.f16610f) {
            if (this.f16616l == null) {
                this.f16613i.a(j2);
                try {
                    this.f16616l = (i) this.f16613i.b();
                } catch (SubtitleDecoderException e2) {
                    a(e2);
                    return;
                }
            }
            if (m_() == 2) {
                if (this.f16615k != null) {
                    long D = D();
                    z2 = false;
                    while (D <= j2) {
                        this.f16617m++;
                        D = D();
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
                i iVar = this.f16616l;
                if (iVar != null) {
                    if (iVar.isEndOfStream()) {
                        if (!z2 && D() == Long.MAX_VALUE) {
                            if (this.f16611g == 2) {
                                C();
                            } else {
                                A();
                                this.f16610f = true;
                            }
                        }
                    } else if (this.f16616l.timeUs <= j2) {
                        i iVar2 = this.f16615k;
                        if (iVar2 != null) {
                            iVar2.release();
                        }
                        i iVar3 = this.f16616l;
                        this.f16615k = iVar3;
                        this.f16616l = null;
                        this.f16617m = iVar3.a(j2);
                        z2 = true;
                    }
                }
                if (z2) {
                    a(this.f16615k.b(j2));
                }
                if (this.f16611g != 2) {
                    while (!this.f16609e) {
                        try {
                            if (this.f16614j == null) {
                                h hVar = (h) this.f16613i.a();
                                this.f16614j = hVar;
                                if (hVar == null) {
                                    return;
                                }
                            }
                            if (this.f16611g == 1) {
                                this.f16614j.setFlags(4);
                                this.f16613i.a(this.f16614j);
                                this.f16614j = null;
                                this.f16611g = 2;
                                return;
                            }
                            int a2 = a(this.f16608d, (e) this.f16614j, false);
                            if (a2 == -4) {
                                if (this.f16614j.isEndOfStream()) {
                                    this.f16609e = true;
                                } else {
                                    this.f16614j.f16602f = this.f16608d.f15972c.f15096m;
                                    this.f16614j.d();
                                }
                                this.f16613i.a(this.f16614j);
                                this.f16614j = null;
                            } else if (a2 == -3) {
                                return;
                            }
                        } catch (SubtitleDecoderException e3) {
                            a(e3);
                            return;
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(long j2, boolean z2) {
        this.f16609e = false;
        this.f16610f = false;
        F();
    }

    /* access modifiers changed from: protected */
    public void a(Format[] formatArr, long j2) {
        Format format = formatArr[0];
        this.f16612h = format;
        if (this.f16613i != null) {
            this.f16611g = 1;
        } else {
            this.f16613i = this.f16607c.b(format);
        }
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            b((List) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: protected */
    public void r() {
        this.f16612h = null;
        E();
        B();
    }

    public boolean y() {
        return true;
    }

    public boolean z() {
        return this.f16610f;
    }
}
