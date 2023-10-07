package bu;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import bj.a;
import bj.c;
import bj.d;
import bj.e;
import cc.l;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public class a implements g<ByteBuffer, c> {

    /* renamed from: a  reason: collision with root package name */
    private static final C0060a f5989a = new C0060a();

    /* renamed from: b  reason: collision with root package name */
    private static final b f5990b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final Context f5991c;

    /* renamed from: d  reason: collision with root package name */
    private final List<ImageHeaderParser> f5992d;

    /* renamed from: e  reason: collision with root package name */
    private final b f5993e;

    /* renamed from: f  reason: collision with root package name */
    private final C0060a f5994f;

    /* renamed from: g  reason: collision with root package name */
    private final b f5995g;

    /* renamed from: bu.a$a  reason: collision with other inner class name */
    static class C0060a {
        C0060a() {
        }

        /* access modifiers changed from: package-private */
        public bj.a a(a.C0050a aVar, c cVar, ByteBuffer byteBuffer, int i2) {
            return new e(aVar, cVar, byteBuffer, i2);
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<d> f5996a = l.a(0);

        b() {
        }

        /* access modifiers changed from: package-private */
        public synchronized d a(ByteBuffer byteBuffer) {
            d poll;
            poll = this.f5996a.poll();
            if (poll == null) {
                poll = new d();
            }
            return poll.a(byteBuffer);
        }

        /* access modifiers changed from: package-private */
        public synchronized void a(d dVar) {
            dVar.a();
            this.f5996a.offer(dVar);
        }
    }

    public a(Context context, List<ImageHeaderParser> list, bl.e eVar, bl.b bVar) {
        this(context, list, eVar, bVar, f5990b, f5989a);
    }

    a(Context context, List<ImageHeaderParser> list, bl.e eVar, bl.b bVar, b bVar2, C0060a aVar) {
        this.f5991c = context.getApplicationContext();
        this.f5992d = list;
        this.f5994f = aVar;
        this.f5995g = new b(eVar, bVar);
        this.f5993e = bVar2;
    }

    private static int a(c cVar, int i2, int i3) {
        int min = Math.min(cVar.a() / i3, cVar.b() / i2);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i2 + "x" + i3 + "], actual dimens: [" + cVar.b() + "x" + cVar.a() + "]");
        }
        return max;
    }

    private e a(ByteBuffer byteBuffer, int i2, int i3, d dVar, f fVar) {
        long a2 = cc.g.a();
        try {
            c b2 = dVar.b();
            if (b2.c() > 0) {
                if (b2.d() == 0) {
                    Bitmap.Config config = fVar.a(i.f6037a) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                    bj.a a3 = this.f5994f.a(this.f5995g, b2, byteBuffer, a(b2, i2, i3));
                    a3.a(config);
                    a3.b();
                    Bitmap h2 = a3.h();
                    if (h2 == null) {
                        if (Log.isLoggable("BufferGifDecoder", 2)) {
                            Log.v("BufferGifDecoder", "Decoded GIF from stream in " + cc.g.a(a2));
                        }
                        return null;
                    }
                    e eVar = new e(new c(this.f5991c, a3, bq.c.a(), i2, i3, h2));
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + cc.g.a(a2));
                    }
                    return eVar;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + cc.g.a(a2));
            }
        }
    }

    public e a(ByteBuffer byteBuffer, int i2, int i3, f fVar) {
        d a2 = this.f5993e.a(byteBuffer);
        try {
            return a(byteBuffer, i2, i3, a2, fVar);
        } finally {
            this.f5993e.a(a2);
        }
    }

    public boolean a(ByteBuffer byteBuffer, f fVar) throws IOException {
        return !((Boolean) fVar.a(i.f6038b)).booleanValue() && com.bumptech.glide.load.b.a(this.f5992d, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }
}
