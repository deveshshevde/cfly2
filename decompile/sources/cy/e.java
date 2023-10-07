package cy;

import android.content.res.Resources;
import android.media.MediaCodec;
import android.media.MediaMuxer;
import android.text.TextUtils;
import com.ctoo.mediaedit.entity.MediaEditEntity;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

public class e extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private a f26538a;

    /* renamed from: b  reason: collision with root package name */
    private i f26539b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f26540c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private String f26541d;

    /* renamed from: e  reason: collision with root package name */
    private MediaMuxer f26542e;

    /* renamed from: f  reason: collision with root package name */
    private int f26543f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f26544g = -1;

    /* renamed from: h  reason: collision with root package name */
    private boolean f26545h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f26546i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f26547j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f26548k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f26549l = true;

    /* renamed from: m  reason: collision with root package name */
    private a f26550m;

    /* renamed from: n  reason: collision with root package name */
    private List<MediaEditEntity> f26551n;

    /* renamed from: o  reason: collision with root package name */
    private Resources f26552o;

    public interface a {
        void a();

        void a(float f2);

        void b();
    }

    public e(Resources resources) {
        this.f26552o = resources;
    }

    private void d() {
        e();
        try {
            this.f26542e = new MediaMuxer(this.f26541d, 0);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void e() {
        List<MediaEditEntity> list = this.f26551n;
        if (list == null || list.size() == 0) {
            throw new IllegalStateException(" 必须先设置要处理的视频");
        } else if (TextUtils.isEmpty(this.f26541d)) {
            throw new IllegalStateException(" 必须设置视频输出路径");
        }
    }

    private void f() {
        MediaMuxer mediaMuxer = this.f26542e;
        if (mediaMuxer != null) {
            mediaMuxer.stop();
            this.f26542e.release();
            this.f26546i = false;
            this.f26545h = false;
            this.f26542e = null;
        }
    }

    public void a() {
        this.f26549l = true;
        c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r5, android.media.MediaFormat r6) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f26540c
            monitor-enter(r0)
            android.media.MediaMuxer r1 = r4.f26542e     // Catch:{ all -> 0x0043 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            return
        L_0x0009:
            r2 = 1
            if (r5 != r2) goto L_0x0017
            if (r6 == 0) goto L_0x0014
            int r5 = r1.addTrack(r6)     // Catch:{ all -> 0x0043 }
            r4.f26544g = r5     // Catch:{ all -> 0x0043 }
        L_0x0014:
            r4.f26546i = r2     // Catch:{ all -> 0x0043 }
            goto L_0x0022
        L_0x0017:
            r3 = 2
            if (r5 != r3) goto L_0x0022
            int r5 = r1.addTrack(r6)     // Catch:{ all -> 0x0043 }
            r4.f26543f = r5     // Catch:{ all -> 0x0043 }
            r4.f26545h = r2     // Catch:{ all -> 0x0043 }
        L_0x0022:
            boolean r5 = r4.f26546i     // Catch:{ all -> 0x0043 }
            if (r5 == 0) goto L_0x0041
            boolean r5 = r4.f26545h     // Catch:{ all -> 0x0043 }
            if (r5 == 0) goto L_0x0041
            boolean r5 = r4.f26547j     // Catch:{ all -> 0x0043 }
            if (r5 != 0) goto L_0x0041
            android.media.MediaMuxer r5 = r4.f26542e     // Catch:{ all -> 0x0043 }
            r5.start()     // Catch:{ all -> 0x0043 }
            r4.f26547j = r2     // Catch:{ all -> 0x0043 }
            java.lang.Object r5 = r4.f26540c     // Catch:{ all -> 0x0043 }
            r5.notify()     // Catch:{ all -> 0x0043 }
            java.lang.String r5 = "muxer"
            java.lang.String r6 = "start media muxer waiting for data..."
            android.util.Log.e(r5, r6)     // Catch:{ all -> 0x0043 }
        L_0x0041:
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            return
        L_0x0043:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cy.e.a(int, android.media.MediaFormat):void");
    }

    public void a(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        MediaMuxer mediaMuxer;
        int i3;
        if (!this.f26547j) {
            synchronized (this.f26540c) {
                if (!this.f26547j) {
                    try {
                        this.f26540c.wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        if (i2 == 1) {
            mediaMuxer = this.f26542e;
            i3 = this.f26544g;
        } else if (i2 == 2) {
            mediaMuxer = this.f26542e;
            i3 = this.f26543f;
        } else {
            return;
        }
        mediaMuxer.writeSampleData(i3, byteBuffer, bufferInfo);
    }

    public void a(a aVar) {
        this.f26550m = aVar;
    }

    public void a(List<MediaEditEntity> list, String str) {
        this.f26551n = list;
        this.f26541d = str;
    }

    public void b() {
        this.f26548k = true;
        c();
    }

    public void c() {
        synchronized (this.f26540c) {
            if (this.f26549l && this.f26548k) {
                f();
                a aVar = this.f26550m;
                if (aVar != null) {
                    aVar.b();
                }
            }
        }
    }

    public void run() {
        a aVar = this.f26550m;
        if (aVar != null) {
            aVar.a();
        }
        d();
        this.f26538a = new a(this.f26551n, this);
        this.f26539b = new i(this.f26551n, this, this.f26552o, this.f26550m);
        this.f26538a.start();
        this.f26539b.start();
    }
}
