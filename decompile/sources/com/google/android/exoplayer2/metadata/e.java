package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.aa;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class e extends d implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final b f15844a;

    /* renamed from: b  reason: collision with root package name */
    private final d f15845b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f15846c;

    /* renamed from: d  reason: collision with root package name */
    private final c f15847d;

    /* renamed from: e  reason: collision with root package name */
    private final Metadata[] f15848e;

    /* renamed from: f  reason: collision with root package name */
    private final long[] f15849f;

    /* renamed from: g  reason: collision with root package name */
    private int f15850g;

    /* renamed from: h  reason: collision with root package name */
    private int f15851h;

    /* renamed from: i  reason: collision with root package name */
    private a f15852i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f15853j;

    /* renamed from: k  reason: collision with root package name */
    private long f15854k;

    public e(d dVar, Looper looper) {
        this(dVar, looper, b.f15842a);
    }

    public e(d dVar, Looper looper, b bVar) {
        super(4);
        this.f15845b = (d) a.b(dVar);
        this.f15846c = looper == null ? null : ad.a(looper, (Handler.Callback) this);
        this.f15844a = (b) a.b(bVar);
        this.f15847d = new c();
        this.f15848e = new Metadata[5];
        this.f15849f = new long[5];
    }

    private void A() {
        Arrays.fill(this.f15848e, (Object) null);
        this.f15850g = 0;
        this.f15851h = 0;
    }

    private void a(Metadata metadata) {
        Handler handler = this.f15846c;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            b(metadata);
        }
    }

    private void a(Metadata metadata, List<Metadata.Entry> list) {
        for (int i2 = 0; i2 < metadata.a(); i2++) {
            Format a2 = metadata.a(i2).a();
            if (a2 == null || !this.f15844a.a(a2)) {
                list.add(metadata.a(i2));
            } else {
                a b2 = this.f15844a.b(a2);
                byte[] bArr = (byte[]) a.b(metadata.a(i2).b());
                this.f15847d.clear();
                this.f15847d.b(bArr.length);
                ((ByteBuffer) ad.a(this.f15847d.f13099b)).put(bArr);
                this.f15847d.d();
                Metadata a3 = b2.a(this.f15847d);
                if (a3 != null) {
                    a(a3, list);
                }
            }
        }
    }

    private void b(Metadata metadata) {
        this.f15845b.a(metadata);
    }

    public int a(Format format) {
        if (!this.f15844a.a(format)) {
            return aa.CC.b(0);
        }
        return aa.CC.b(a((b<?>) null, format.f15095l) ? 4 : 2);
    }

    public void a(long j2, long j3) {
        if (!this.f15853j && this.f15851h < 5) {
            this.f15847d.clear();
            o t2 = t();
            int a2 = a(t2, (fi.e) this.f15847d, false);
            if (a2 == -4) {
                if (this.f15847d.isEndOfStream()) {
                    this.f15853j = true;
                } else if (!this.f15847d.isDecodeOnly()) {
                    this.f15847d.f15843f = this.f15854k;
                    this.f15847d.d();
                    Metadata a3 = ((a) ad.a(this.f15852i)).a(this.f15847d);
                    if (a3 != null) {
                        ArrayList arrayList = new ArrayList(a3.a());
                        a(a3, (List<Metadata.Entry>) arrayList);
                        if (!arrayList.isEmpty()) {
                            Metadata metadata = new Metadata((List<? extends Metadata.Entry>) arrayList);
                            int i2 = (this.f15850g + this.f15851h) % 5;
                            this.f15848e[i2] = metadata;
                            this.f15849f[i2] = this.f15847d.f13101d;
                            this.f15851h++;
                        }
                    }
                }
            } else if (a2 == -5) {
                this.f15854k = ((Format) a.b(t2.f15972c)).f15096m;
            }
        }
        if (this.f15851h > 0) {
            long[] jArr = this.f15849f;
            int i3 = this.f15850g;
            if (jArr[i3] <= j2) {
                a((Metadata) ad.a(this.f15848e[i3]));
                Metadata[] metadataArr = this.f15848e;
                int i4 = this.f15850g;
                metadataArr[i4] = null;
                this.f15850g = (i4 + 1) % 5;
                this.f15851h--;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(long j2, boolean z2) {
        A();
        this.f15853j = false;
    }

    /* access modifiers changed from: protected */
    public void a(Format[] formatArr, long j2) {
        this.f15852i = this.f15844a.b(formatArr[0]);
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            b((Metadata) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: protected */
    public void r() {
        A();
        this.f15852i = null;
    }

    public boolean y() {
        return true;
    }

    public boolean z() {
        return this.f15853j;
    }
}
