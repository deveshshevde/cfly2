package jv;

import android.util.Log;
import com.autonavi.base.amap.mapcore.AeUtil;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.jvm.internal.h;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f29798a = new a((f) null);

    /* renamed from: c  reason: collision with root package name */
    private static final String f29799c = b.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final LinkedBlockingQueue<C0201b> f29800b = new LinkedBlockingQueue<>();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* renamed from: jv.b$b  reason: collision with other inner class name */
    public static final class C0201b {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f29801a;

        /* renamed from: b  reason: collision with root package name */
        private final int f29802b;

        /* renamed from: c  reason: collision with root package name */
        private final int f29803c;

        /* renamed from: d  reason: collision with root package name */
        private final long f29804d;

        public C0201b(byte[] bArr, int i2, int i3, long j2) {
            h.d(bArr, AeUtil.ROOT_DATA_PATH_OLD_NAME);
            this.f29801a = bArr;
            this.f29802b = i2;
            this.f29803c = i3;
            this.f29804d = j2;
        }

        public final byte[] a() {
            return this.f29801a;
        }

        public final int b() {
            return this.f29802b;
        }

        public final long c() {
            return this.f29804d;
        }
    }

    public final C0201b a() {
        try {
            C0201b take = this.f29800b.take();
            if (take != null) {
                return take;
            }
            Log.i("RTSP", "onRtspVideoNalUnitReceived queue pop is empty, queue size:" + this.f29800b.size());
            return null;
        } catch (Exception unused) {
            Log.i("RTSP", "onRtspVideoNalUnitReceived queue pop error, queue size:" + this.f29800b.size());
            return null;
        }
    }

    public final boolean a(C0201b bVar) {
        h.d(bVar, "frame");
        try {
            if (this.f29800b.size() > 30) {
                b();
            }
            this.f29800b.put(bVar);
            return false;
        } catch (Exception unused) {
            Log.i("RTSP", "onRtspVideoNalUnitReceived queue frame size:" + bVar.a().length + ", queue size:" + this.f29800b.size() + " offer error");
            return false;
        }
    }

    public final void b() {
        this.f29800b.clear();
    }
}
