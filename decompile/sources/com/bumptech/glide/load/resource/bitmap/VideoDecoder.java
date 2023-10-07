package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class VideoDecoder<T> implements g<T, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public static final com.bumptech.glide.load.e<Long> f10446a = com.bumptech.glide.load.e.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new e.a<Long>() {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f10452a = ByteBuffer.allocate(8);

        public void a(byte[] bArr, Long l2, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f10452a) {
                this.f10452a.position(0);
                messageDigest.update(this.f10452a.putLong(l2.longValue()).array());
            }
        }
    });

    /* renamed from: b  reason: collision with root package name */
    public static final com.bumptech.glide.load.e<Integer> f10447b = com.bumptech.glide.load.e.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new e.a<Integer>() {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f10453a = ByteBuffer.allocate(4);

        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.f10453a) {
                    this.f10453a.position(0);
                    messageDigest.update(this.f10453a.putInt(num.intValue()).array());
                }
            }
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private static final c f10448c = new c();

    /* renamed from: d  reason: collision with root package name */
    private final d<T> f10449d;

    /* renamed from: e  reason: collision with root package name */
    private final bl.e f10450e;

    /* renamed from: f  reason: collision with root package name */
    private final c f10451f;

    private static final class VideoDecoderException extends RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    private static final class a implements d<AssetFileDescriptor> {
        private a() {
        }

        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    static final class b implements d<ByteBuffer> {
        b() {
        }

        public void a(MediaMetadataRetriever mediaMetadataRetriever, final ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new MediaDataSource() {
                public void close() {
                }

                public long getSize() {
                    return (long) byteBuffer.limit();
                }

                public int readAt(long j2, byte[] bArr, int i2, int i3) {
                    if (j2 >= ((long) byteBuffer.limit())) {
                        return -1;
                    }
                    byteBuffer.position((int) j2);
                    int min = Math.min(i3, byteBuffer.remaining());
                    byteBuffer.get(bArr, i2, min);
                    return min;
                }
            });
        }
    }

    static class c {
        c() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    interface d<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t2);
    }

    static final class e implements d<ParcelFileDescriptor> {
        e() {
        }

        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    VideoDecoder(bl.e eVar, d<T> dVar) {
        this(eVar, dVar, f10448c);
    }

    VideoDecoder(bl.e eVar, d<T> dVar, c cVar) {
        this.f10450e = eVar;
        this.f10449d = dVar;
        this.f10451f = cVar;
    }

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2) {
        return mediaMetadataRetriever.getFrameAtTime(j2, i2);
    }

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, DownsampleStrategy downsampleStrategy) {
        Bitmap b2 = (Build.VERSION.SDK_INT < 27 || i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f10433f) ? null : b(mediaMetadataRetriever, j2, i2, i3, i4, downsampleStrategy);
        if (b2 == null) {
            b2 = a(mediaMetadataRetriever, j2, i2);
        }
        if (b2 != null) {
            return b2;
        }
        throw new VideoDecoderException();
    }

    public static g<AssetFileDescriptor, Bitmap> a(bl.e eVar) {
        return new VideoDecoder(eVar, new a());
    }

    private static Bitmap b(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, DownsampleStrategy downsampleStrategy) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                int i5 = parseInt2;
                parseInt2 = parseInt;
                parseInt = i5;
            }
            float a2 = downsampleStrategy.a(parseInt, parseInt2, i3, i4);
            return mediaMetadataRetriever.getScaledFrameAtTime(j2, i2, Math.round(((float) parseInt) * a2), Math.round(a2 * ((float) parseInt2)));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
            return null;
        }
    }

    public static g<ParcelFileDescriptor, Bitmap> b(bl.e eVar) {
        return new VideoDecoder(eVar, new e());
    }

    public static g<ByteBuffer, Bitmap> c(bl.e eVar) {
        return new VideoDecoder(eVar, new b());
    }

    public s<Bitmap> a(T t2, int i2, int i3, f fVar) throws IOException {
        int i4;
        long longValue = ((Long) fVar.a(f10446a)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) fVar.a(f10447b);
            if (num == null) {
                num = 2;
            }
            DownsampleStrategy downsampleStrategy = (DownsampleStrategy) fVar.a(DownsampleStrategy.f10435h);
            if (downsampleStrategy == null) {
                downsampleStrategy = DownsampleStrategy.f10434g;
            }
            DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
            MediaMetadataRetriever a2 = this.f10451f.a();
            try {
                this.f10449d.a(a2, t2);
                Bitmap a3 = a(a2, longValue, num.intValue(), i2, i3, downsampleStrategy2);
                if (i4 < 29) {
                    a2.release();
                }
                return e.a(a3, this.f10450e);
            } finally {
                if (Build.VERSION.SDK_INT >= 29) {
                    a2.close();
                } else {
                    a2.release();
                }
            }
        } else {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
    }

    public boolean a(T t2, f fVar) {
        return true;
    }
}
