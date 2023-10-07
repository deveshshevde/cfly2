package bs;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import cc.l;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageHeaderParser> f5981a;

    /* renamed from: b  reason: collision with root package name */
    private final bl.b f5982b;

    /* renamed from: bs.a$a  reason: collision with other inner class name */
    private static final class C0059a implements s<Drawable> {

        /* renamed from: a  reason: collision with root package name */
        private final AnimatedImageDrawable f5983a;

        C0059a(AnimatedImageDrawable animatedImageDrawable) {
            this.f5983a = animatedImageDrawable;
        }

        /* renamed from: a */
        public AnimatedImageDrawable d() {
            return this.f5983a;
        }

        public Class<Drawable> c() {
            return Drawable.class;
        }

        public int e() {
            return this.f5983a.getIntrinsicWidth() * this.f5983a.getIntrinsicHeight() * l.a(Bitmap.Config.ARGB_8888) * 2;
        }

        public void f() {
            this.f5983a.stop();
            this.f5983a.clearAnimationCallbacks();
        }
    }

    private static final class b implements g<ByteBuffer, Drawable> {

        /* renamed from: a  reason: collision with root package name */
        private final a f5984a;

        b(a aVar) {
            this.f5984a = aVar;
        }

        public s<Drawable> a(ByteBuffer byteBuffer, int i2, int i3, f fVar) throws IOException {
            return this.f5984a.a(ImageDecoder.createSource(byteBuffer), i2, i3, fVar);
        }

        public boolean a(ByteBuffer byteBuffer, f fVar) throws IOException {
            return this.f5984a.a(byteBuffer);
        }
    }

    private static final class c implements g<InputStream, Drawable> {

        /* renamed from: a  reason: collision with root package name */
        private final a f5985a;

        c(a aVar) {
            this.f5985a = aVar;
        }

        public s<Drawable> a(InputStream inputStream, int i2, int i3, f fVar) throws IOException {
            return this.f5985a.a(ImageDecoder.createSource(cc.a.a(inputStream)), i2, i3, fVar);
        }

        public boolean a(InputStream inputStream, f fVar) throws IOException {
            return this.f5985a.a(inputStream);
        }
    }

    private a(List<ImageHeaderParser> list, bl.b bVar) {
        this.f5981a = list;
        this.f5982b = bVar;
    }

    public static g<InputStream, Drawable> a(List<ImageHeaderParser> list, bl.b bVar) {
        return new c(new a(list, bVar));
    }

    private boolean a(ImageHeaderParser.ImageType imageType) {
        return imageType == ImageHeaderParser.ImageType.ANIMATED_WEBP;
    }

    public static g<ByteBuffer, Drawable> b(List<ImageHeaderParser> list, bl.b bVar) {
        return new b(new a(list, bVar));
    }

    /* access modifiers changed from: package-private */
    public s<Drawable> a(ImageDecoder.Source source, int i2, int i3, f fVar) throws IOException {
        Drawable decodeDrawable = ImageDecoder.decodeDrawable(source, new bq.a(i2, i3, fVar));
        if (decodeDrawable instanceof AnimatedImageDrawable) {
            return new C0059a((AnimatedImageDrawable) decodeDrawable);
        }
        throw new IOException("Received unexpected drawable type for animated webp, failing: " + decodeDrawable);
    }

    /* access modifiers changed from: package-private */
    public boolean a(InputStream inputStream) throws IOException {
        return a(com.bumptech.glide.load.b.a(this.f5981a, inputStream, this.f5982b));
    }

    /* access modifiers changed from: package-private */
    public boolean a(ByteBuffer byteBuffer) throws IOException {
        return a(com.bumptech.glide.load.b.a(this.f5981a, byteBuffer));
    }
}
