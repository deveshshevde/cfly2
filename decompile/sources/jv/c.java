package jv;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.io.IOException;
import java.nio.ByteBuffer;
import jv.b;
import kotlin.jvm.internal.h;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public final class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private boolean f29805a;

    /* renamed from: b  reason: collision with root package name */
    private MediaMuxer f29806b;

    /* renamed from: c  reason: collision with root package name */
    private int f29807c = -1;

    /* renamed from: d  reason: collision with root package name */
    private b f29808d = new b();

    /* renamed from: e  reason: collision with root package name */
    private int f29809e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f29810f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f29811g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f29812h;

    /* renamed from: i  reason: collision with root package name */
    private final String f29813i;

    /* renamed from: j  reason: collision with root package name */
    private final int f29814j;

    /* renamed from: k  reason: collision with root package name */
    private final int f29815k;

    /* renamed from: l  reason: collision with root package name */
    private final int f29816l;

    public c(String str, int i2, int i3, int i4, byte[] bArr, byte[] bArr2) {
        h.d(str, "filePath");
        this.f29813i = str;
        this.f29814j = i2;
        this.f29815k = i3;
        this.f29816l = i4;
        try {
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i2, i3);
            h.b(createVideoFormat, "MediaFormat.createVideoF…VIDEO_AVC, width, height)");
            if (!(bArr2 == null || bArr == null)) {
                createVideoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(bArr));
                createVideoFormat.setByteBuffer("csd-1", ByteBuffer.wrap(bArr2));
            }
            createVideoFormat.setInteger("color-format", 19);
            createVideoFormat.setInteger("max-input-size", i2 * i3);
            createVideoFormat.setInteger("capture-rate", i4);
            createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i2 * i3);
            createVideoFormat.setInteger("width", i2);
            createVideoFormat.setInteger("height", i3);
            createVideoFormat.setInteger("frame-rate", i4);
            createVideoFormat.setInteger("i-frame-interval", 1);
            createVideoFormat.setLong("repeat-previous-frame-after", 1000000 / ((long) i4));
            MediaMuxer mediaMuxer = new MediaMuxer(str, 0);
            this.f29806b = mediaMuxer;
            h.a((Object) mediaMuxer);
            this.f29807c = mediaMuxer.addTrack(createVideoFormat);
            this.f29805a = true;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public final void a() {
        MediaMuxer mediaMuxer = this.f29806b;
        if (mediaMuxer != null) {
            this.f29805a = false;
            this.f29810f = false;
            this.f29811g = false;
            this.f29812h = false;
            this.f29809e = 0;
            if (mediaMuxer != null) {
                try {
                    mediaMuxer.stop();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            MediaMuxer mediaMuxer2 = this.f29806b;
            if (mediaMuxer2 != null) {
                mediaMuxer2.release();
            }
            this.f29806b = null;
            this.f29808d.b();
            interrupt();
        }
    }

    public final void a(b.C0201b bVar) {
        h.d(bVar, "frame");
        this.f29808d.a(bVar);
    }

    public void run() {
        while (this.f29805a) {
            b.C0201b a2 = this.f29808d.a();
            if (a2 != null) {
                if ((a2.a()[4] & 31) == 7) {
                    this.f29811g = true;
                } else if ((a2.a()[4] & 31) == 8) {
                    this.f29812h = true;
                }
                if (this.f29812h && this.f29811g && (a2.a()[4] & 31) == 5 && !this.f29810f) {
                    this.f29810f = true;
                    MediaMuxer mediaMuxer = this.f29806b;
                    h.a((Object) mediaMuxer);
                    mediaMuxer.start();
                }
                if (this.f29810f) {
                    ByteBuffer allocate = ByteBuffer.allocate(a2.a().length);
                    allocate.put(a2.a(), 0, a2.a().length);
                    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                    bufferInfo.size = a2.a().length;
                    bufferInfo.flags = 1;
                    bufferInfo.offset = 0;
                    bufferInfo.presentationTimeUs = (((long) (this.f29809e * 1000)) * 1000) / ((long) this.f29816l);
                    MediaMuxer mediaMuxer2 = this.f29806b;
                    h.a((Object) mediaMuxer2);
                    mediaMuxer2.writeSampleData(this.f29807c, allocate, bufferInfo);
                    if (!((a2.a()[4] & 31) == 7 || (a2.a()[4] & 31) == 8 || (a2.a()[4] & 31) == 6)) {
                        this.f29809e++;
                    }
                }
            }
        }
    }
}
