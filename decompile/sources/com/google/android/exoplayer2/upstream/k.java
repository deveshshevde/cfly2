package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class k implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17041a;

    /* renamed from: b  reason: collision with root package name */
    private final List<t> f17042b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final f f17043c;

    /* renamed from: d  reason: collision with root package name */
    private f f17044d;

    /* renamed from: e  reason: collision with root package name */
    private f f17045e;

    /* renamed from: f  reason: collision with root package name */
    private f f17046f;

    /* renamed from: g  reason: collision with root package name */
    private f f17047g;

    /* renamed from: h  reason: collision with root package name */
    private f f17048h;

    /* renamed from: i  reason: collision with root package name */
    private f f17049i;

    /* renamed from: j  reason: collision with root package name */
    private f f17050j;

    /* renamed from: k  reason: collision with root package name */
    private f f17051k;

    public k(Context context, f fVar) {
        this.f17041a = context.getApplicationContext();
        this.f17043c = (f) a.b(fVar);
    }

    private void a(f fVar) {
        for (int i2 = 0; i2 < this.f17042b.size(); i2++) {
            fVar.a(this.f17042b.get(i2));
        }
    }

    private void a(f fVar, t tVar) {
        if (fVar != null) {
            fVar.a(tVar);
        }
    }

    private f d() {
        if (this.f17048h == null) {
            UdpDataSource udpDataSource = new UdpDataSource();
            this.f17048h = udpDataSource;
            a((f) udpDataSource);
        }
        return this.f17048h;
    }

    private f e() {
        if (this.f17044d == null) {
            FileDataSource fileDataSource = new FileDataSource();
            this.f17044d = fileDataSource;
            a((f) fileDataSource);
        }
        return this.f17044d;
    }

    private f f() {
        if (this.f17045e == null) {
            AssetDataSource assetDataSource = new AssetDataSource(this.f17041a);
            this.f17045e = assetDataSource;
            a((f) assetDataSource);
        }
        return this.f17045e;
    }

    private f g() {
        if (this.f17046f == null) {
            ContentDataSource contentDataSource = new ContentDataSource(this.f17041a);
            this.f17046f = contentDataSource;
            a((f) contentDataSource);
        }
        return this.f17046f;
    }

    private f h() {
        if (this.f17047g == null) {
            try {
                f fVar = (f) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                this.f17047g = fVar;
                a(fVar);
            } catch (ClassNotFoundException unused) {
                com.google.android.exoplayer2.util.k.c("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating RTMP extension", e2);
            }
            if (this.f17047g == null) {
                this.f17047g = this.f17043c;
            }
        }
        return this.f17047g;
    }

    private f i() {
        if (this.f17049i == null) {
            e eVar = new e();
            this.f17049i = eVar;
            a((f) eVar);
        }
        return this.f17049i;
    }

    private f j() {
        if (this.f17050j == null) {
            RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.f17041a);
            this.f17050j = rawResourceDataSource;
            a((f) rawResourceDataSource);
        }
        return this.f17050j;
    }

    public int a(byte[] bArr, int i2, int i3) throws IOException {
        return ((f) a.b(this.f17051k)).a(bArr, i2, i3);
    }

    public long a(h hVar) throws IOException {
        f fVar;
        a.b(this.f17051k == null);
        String scheme = hVar.f16995a.getScheme();
        if (ad.a(hVar.f16995a)) {
            String path = hVar.f16995a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                fVar = e();
                this.f17051k = fVar;
                return this.f17051k.a(hVar);
            }
        } else if (!"asset".equals(scheme)) {
            fVar = "content".equals(scheme) ? g() : "rtmp".equals(scheme) ? h() : "udp".equals(scheme) ? d() : AeUtil.ROOT_DATA_PATH_OLD_NAME.equals(scheme) ? i() : "rawresource".equals(scheme) ? j() : this.f17043c;
            this.f17051k = fVar;
            return this.f17051k.a(hVar);
        }
        fVar = f();
        this.f17051k = fVar;
        return this.f17051k.a(hVar);
    }

    public Uri a() {
        f fVar = this.f17051k;
        if (fVar == null) {
            return null;
        }
        return fVar.a();
    }

    public void a(t tVar) {
        this.f17043c.a(tVar);
        this.f17042b.add(tVar);
        a(this.f17044d, tVar);
        a(this.f17045e, tVar);
        a(this.f17046f, tVar);
        a(this.f17047g, tVar);
        a(this.f17048h, tVar);
        a(this.f17049i, tVar);
        a(this.f17050j, tVar);
    }

    public Map<String, List<String>> b() {
        f fVar = this.f17051k;
        return fVar == null ? Collections.emptyMap() : fVar.b();
    }

    public void c() throws IOException {
        f fVar = this.f17051k;
        if (fVar != null) {
            try {
                fVar.c();
            } finally {
                this.f17051k = null;
            }
        }
    }
}
