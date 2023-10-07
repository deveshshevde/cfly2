package jy;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseArray;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kb.e;
import kb.g;
import kb.h;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f29841a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final MediaMetadataRetriever f29842b = new MediaMetadataRetriever();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final h<g> f29843c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Canvas f29844d = new Canvas();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Rect f29845e;

    /* renamed from: f  reason: collision with root package name */
    private SparseArray f29846f;

    /* renamed from: g  reason: collision with root package name */
    private String f29847g;

    /* renamed from: jy.a$a  reason: collision with other inner class name */
    public interface C0203a {
        void a(g gVar, long j2);
    }

    private class b extends AsyncTask<Void, Void, g> {

        /* renamed from: b  reason: collision with root package name */
        private final long f29849b;

        /* renamed from: c  reason: collision with root package name */
        private C0203a f29850c;

        public b(C0203a aVar, long j2) {
            this.f29850c = aVar;
            this.f29849b = j2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public g doInBackground(Void... voidArr) {
            Bitmap frameAtTime;
            if (isCancelled() || (frameAtTime = a.this.f29842b.getFrameAtTime(TimeUnit.NANOSECONDS.toMicros(this.f29849b))) == null || isCancelled()) {
                return null;
            }
            g gVar = (g) a.this.f29843c.a();
            a.this.f29844d.setBitmap(gVar.d());
            Rect rect = new Rect();
            int width = frameAtTime.getWidth();
            int height = frameAtTime.getHeight();
            if (width >= height) {
                int i2 = (width - height) / 2;
                rect.left = i2;
                rect.right = i2 + height;
                rect.top = 0;
            } else {
                rect.left = 0;
                rect.right = width;
                int i3 = (height - width) / 2;
                rect.top = i3;
                height = i3 + width;
            }
            rect.bottom = height;
            a.this.f29844d.drawBitmap(frameAtTime, rect, a.this.f29845e, (Paint) null);
            frameAtTime.recycle();
            return gVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onCancelled(g gVar) {
            if (gVar != null) {
                gVar.c();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(g gVar) {
            this.f29850c.a(gVar, this.f29849b);
        }
    }

    public a() {
        Rect rect = new Rect();
        this.f29845e = rect;
        this.f29846f = new SparseArray();
        this.f29841a = Executors.newSingleThreadExecutor();
        this.f29843c = new h<>(new e(128, 128));
        rect.set(0, 0, 128, 128);
    }

    public long a() {
        String str;
        Long valueOf;
        Object obj = this.f29846f.get(9);
        if (obj != null) {
            valueOf = (Long) obj;
        } else {
            if (this.f29847g != null) {
                String extractMetadata = this.f29842b.extractMetadata(9);
                if (extractMetadata == null || "".equals(extractMetadata)) {
                    str = "Retrieve video duration failed";
                } else {
                    valueOf = Long.valueOf(Long.parseLong(extractMetadata));
                    this.f29846f.put(9, valueOf);
                }
            } else {
                str = "Has no video source,so duration is 0";
            }
            Log.e("FrameExtractor", str);
            return 0;
        }
        return valueOf.longValue();
    }

    public AsyncTask<Void, Void, g> a(C0203a aVar, long j2) {
        return new b(aVar, j2).executeOnExecutor(this.f29841a, new Void[0]);
    }

    public boolean a(String str) {
        try {
            this.f29847g = str;
            this.f29842b.setDataSource(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
