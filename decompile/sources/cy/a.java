package cy;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;
import com.ctoo.mediaedit.entity.MediaEditEntity;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

public class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final int f26502a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f26503b = -1;

    /* renamed from: c  reason: collision with root package name */
    private MediaFormat f26504c;

    /* renamed from: d  reason: collision with root package name */
    private e f26505d;

    /* renamed from: e  reason: collision with root package name */
    private d f26506e;

    /* renamed from: f  reason: collision with root package name */
    private List<MediaEditEntity> f26507f;

    /* renamed from: g  reason: collision with root package name */
    private List<Integer> f26508g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<d> f26509h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private AtomicBoolean f26510i = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    private AtomicBoolean f26511j = new AtomicBoolean(false);

    /* renamed from: k  reason: collision with root package name */
    private AtomicInteger f26512k = new AtomicInteger(0);

    /* renamed from: l  reason: collision with root package name */
    private AtomicInteger f26513l = new AtomicInteger(0);

    /* renamed from: m  reason: collision with root package name */
    private long f26514m = 23219;

    /* renamed from: n  reason: collision with root package name */
    private List<Long> f26515n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private List<Long> f26516o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private List<Integer> f26517p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private int f26518q = 0;

    /* renamed from: r  reason: collision with root package name */
    private long f26519r = 0;

    public a(List<MediaEditEntity> list, e eVar) {
        this.f26505d = eVar;
        this.f26507f = list;
    }

    private void a() throws IOException {
        for (int i2 = 0; i2 < this.f26507f.size(); i2++) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            MediaEditEntity mediaEditEntity = this.f26507f.get(i2);
            mediaExtractor.setDataSource(mediaEditEntity.a().a());
            d dVar = new d();
            dVar.f26534b = mediaExtractor;
            dVar.f26533a = mediaEditEntity.a().a();
            dVar.f26535c = Long.valueOf(mediaEditEntity.b());
            dVar.f26536d = Long.valueOf(mediaEditEntity.c());
            dVar.f26537e = Long.valueOf(mediaEditEntity.a().f());
            this.f26509h.add(dVar);
        }
        for (int i3 = 0; i3 < this.f26509h.size(); i3++) {
            MediaExtractor mediaExtractor2 = this.f26509h.get(i3).f26534b;
            int trackCount = mediaExtractor2.getTrackCount();
            int i4 = 0;
            while (true) {
                if (i4 >= trackCount) {
                    break;
                } else if (mediaExtractor2.getTrackFormat(i4).getString(IMediaFormat.KEY_MIME).startsWith("audio/")) {
                    mediaExtractor2.selectTrack(i4);
                    this.f26508g.add(Integer.valueOf(i4));
                    break;
                } else {
                    i4++;
                }
            }
        }
    }

    private void b() {
        long j2;
        boolean z2;
        long j3;
        boolean z3;
        int i2;
        MediaExtractor mediaExtractor;
        int i3;
        ByteBuffer byteBuffer;
        int i4;
        int i5 = 0;
        MediaExtractor mediaExtractor2 = this.f26509h.get(0).f26534b;
        this.f26506e = this.f26509h.get(0);
        int trackCount = mediaExtractor2.getTrackCount();
        int i6 = 0;
        while (true) {
            if (i6 >= trackCount) {
                break;
            }
            MediaFormat trackFormat = mediaExtractor2.getTrackFormat(i6);
            if (trackFormat.getString(IMediaFormat.KEY_MIME).startsWith("audio/")) {
                this.f26503b = i6;
                this.f26504c = trackFormat;
                break;
            }
            i6++;
        }
        this.f26505d.a(1, this.f26504c);
        ByteBuffer allocate = ByteBuffer.allocate(51200);
        long longValue = this.f26506e.f26536d.longValue();
        if (this.f26503b != -1) {
            long j4 = 1000;
            if (this.f26506e.f26535c.longValue() >= 0) {
                mediaExtractor2.seekTo(this.f26506e.f26535c.longValue() * 1000, 0);
                mediaExtractor = mediaExtractor2;
                j3 = 0;
                j2 = 0;
                i2 = 0;
                z3 = false;
                z2 = true;
            } else {
                mediaExtractor = mediaExtractor2;
                j3 = 0;
                j2 = 0;
                i2 = 0;
                z3 = false;
                z2 = false;
            }
            boolean z4 = true;
            while (true) {
                try {
                    i3 = mediaExtractor.readSampleData(allocate, i5);
                } catch (Exception e2) {
                    e2.getStackTrace();
                    i3 = -1;
                }
                if (i3 >= 0) {
                    ByteBuffer byteBuffer2 = allocate;
                    long sampleTime = this.f26506e.f26534b.getSampleTime();
                    Log.e("videooo", "mAudioDecode.cutDuration==" + this.f26506e.f26536d + "---mAudioDecode===" + sampleTime);
                    if (this.f26506e.f26536d.longValue() > 0 && longValue <= j3) {
                        i2++;
                        if (i2 >= this.f26509h.size()) {
                            break;
                        }
                        mediaExtractor.release();
                        d dVar = this.f26509h.get(i2);
                        this.f26506e = dVar;
                        mediaExtractor = dVar.f26534b;
                        longValue += this.f26506e.f26536d.longValue() * j4;
                        if (this.f26506e.f26535c.longValue() >= 0) {
                            mediaExtractor.seekTo(this.f26506e.f26535c.longValue(), 0);
                        }
                        allocate = byteBuffer2;
                        i5 = 0;
                        z3 = true;
                    } else {
                        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                        bufferInfo.offset = 0;
                        bufferInfo.size = i3;
                        bufferInfo.flags = 1;
                        if (z3) {
                            bufferInfo.presentationTimeUs = j3 + 23219;
                            z3 = false;
                        } else if (z2) {
                            bufferInfo.presentationTimeUs = 0;
                            z2 = false;
                        } else if (z4) {
                            bufferInfo.presentationTimeUs = 0;
                            z4 = false;
                        } else {
                            bufferInfo.presentationTimeUs = (mediaExtractor.getSampleTime() - j2) + j3;
                        }
                        long j5 = bufferInfo.presentationTimeUs;
                        j2 = mediaExtractor.getSampleTime();
                        Log.e("videooo", "lastTime==" + j5 + "---samptime===" + sampleTime + "currentTotalTime:" + longValue);
                        byteBuffer = byteBuffer2;
                        this.f26505d.a(1, byteBuffer, bufferInfo);
                        mediaExtractor.advance();
                        j3 = j5;
                        allocate = byteBuffer;
                        i5 = 0;
                        j4 = 1000;
                    }
                } else {
                    int i7 = i2 + 1;
                    if (i7 >= this.f26509h.size()) {
                        break;
                    }
                    mediaExtractor.release();
                    MediaExtractor mediaExtractor3 = this.f26509h.get(i7).f26534b;
                    d dVar2 = this.f26509h.get(i7);
                    this.f26506e = dVar2;
                    if (dVar2.f26535c.longValue() > 0) {
                        i4 = i7;
                        mediaExtractor3.seekTo(this.f26506e.f26535c.longValue(), i5);
                    } else {
                        i4 = i7;
                    }
                    mediaExtractor = mediaExtractor3;
                    byteBuffer = allocate;
                    i2 = i4;
                    z3 = true;
                    allocate = byteBuffer;
                    i5 = 0;
                    j4 = 1000;
                }
            }
            mediaExtractor.release();
            this.f26505d.a();
        }
    }

    public void run() {
        try {
            a();
            b();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
