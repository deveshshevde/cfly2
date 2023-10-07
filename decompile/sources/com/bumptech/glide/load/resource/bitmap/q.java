package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.k;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

interface q {

    public static final class a implements q {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f10499a;

        /* renamed from: b  reason: collision with root package name */
        private final List<ImageHeaderParser> f10500b;

        /* renamed from: c  reason: collision with root package name */
        private final bl.b f10501c;

        a(ByteBuffer byteBuffer, List<ImageHeaderParser> list, bl.b bVar) {
            this.f10499a = byteBuffer;
            this.f10500b = list;
            this.f10501c = bVar;
        }

        private InputStream d() {
            return cc.a.b(cc.a.c(this.f10499a));
        }

        public Bitmap a(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(d(), (Rect) null, options);
        }

        public ImageHeaderParser.ImageType a() throws IOException {
            return com.bumptech.glide.load.b.a(this.f10500b, cc.a.c(this.f10499a));
        }

        public int b() throws IOException {
            return com.bumptech.glide.load.b.a(this.f10500b, cc.a.c(this.f10499a), this.f10501c);
        }

        public void c() {
        }
    }

    public static final class b implements q {

        /* renamed from: a  reason: collision with root package name */
        private final k f10502a;

        /* renamed from: b  reason: collision with root package name */
        private final bl.b f10503b;

        /* renamed from: c  reason: collision with root package name */
        private final List<ImageHeaderParser> f10504c;

        b(InputStream inputStream, List<ImageHeaderParser> list, bl.b bVar) {
            this.f10503b = (bl.b) cc.k.a(bVar);
            this.f10504c = (List) cc.k.a(list);
            this.f10502a = new k(inputStream, bVar);
        }

        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.f10502a.a(), (Rect) null, options);
        }

        public ImageHeaderParser.ImageType a() throws IOException {
            return com.bumptech.glide.load.b.a(this.f10504c, this.f10502a.a(), this.f10503b);
        }

        public int b() throws IOException {
            return com.bumptech.glide.load.b.b(this.f10504c, this.f10502a.a(), this.f10503b);
        }

        public void c() {
            this.f10502a.d();
        }
    }

    public static final class c implements q {

        /* renamed from: a  reason: collision with root package name */
        private final bl.b f10505a;

        /* renamed from: b  reason: collision with root package name */
        private final List<ImageHeaderParser> f10506b;

        /* renamed from: c  reason: collision with root package name */
        private final ParcelFileDescriptorRewinder f10507c;

        c(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, bl.b bVar) {
            this.f10505a = (bl.b) cc.k.a(bVar);
            this.f10506b = (List) cc.k.a(list);
            this.f10507c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f10507c.a().getFileDescriptor(), (Rect) null, options);
        }

        public ImageHeaderParser.ImageType a() throws IOException {
            return com.bumptech.glide.load.b.a(this.f10506b, this.f10507c, this.f10505a);
        }

        public int b() throws IOException {
            return com.bumptech.glide.load.b.b(this.f10506b, this.f10507c, this.f10505a);
        }

        public void c() {
        }
    }

    Bitmap a(BitmapFactory.Options options) throws IOException;

    ImageHeaderParser.ImageType a() throws IOException;

    int b() throws IOException;

    void c();
}
