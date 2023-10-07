package cy;

import android.content.res.Resources;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import android.view.Surface;
import com.ctoo.mediaedit.entity.MediaEditEntity;
import com.ctoo.mediaedit.filter.gpu.GPUImageFilterType;
import com.ctoo.mediaedit.filter.gpu.a;
import cy.e;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

public class i extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private e f26608a;

    /* renamed from: b  reason: collision with root package name */
    private MediaFormat f26609b;

    /* renamed from: c  reason: collision with root package name */
    private List<MediaEditEntity> f26610c;

    /* renamed from: d  reason: collision with root package name */
    private List<MediaExtractor> f26611d;

    /* renamed from: e  reason: collision with root package name */
    private List<d> f26612e;

    /* renamed from: f  reason: collision with root package name */
    private MediaEditEntity f26613f;

    /* renamed from: g  reason: collision with root package name */
    private Resources f26614g;

    /* renamed from: h  reason: collision with root package name */
    private e.a f26615h;

    public i(List<MediaEditEntity> list, e eVar, Resources resources, e.a aVar) {
        this.f26608a = eVar;
        this.f26610c = list;
        this.f26614g = resources;
        this.f26615h = aVar;
    }

    private f a(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        int intValue = Integer.valueOf(mediaMetadataRetriever.extractMetadata(18)).intValue();
        int intValue2 = Integer.valueOf(mediaMetadataRetriever.extractMetadata(19)).intValue();
        mediaMetadataRetriever.release();
        return new f(intValue, intValue2);
    }

    private void a() throws IOException {
        int i2;
        int i3;
        this.f26611d = new ArrayList();
        this.f26612e = new ArrayList();
        for (int i4 = 0; i4 < this.f26610c.size(); i4++) {
            f a2 = a(this.f26610c.get(i4).a().a());
            this.f26610c.get(i4).a().a(a2.a());
            this.f26610c.get(i4).a().b(a2.b());
            MediaExtractor mediaExtractor = new MediaExtractor();
            MediaEditEntity mediaEditEntity = this.f26610c.get(i4);
            mediaExtractor.setDataSource(mediaEditEntity.a().a());
            this.f26611d.add(mediaExtractor);
            d dVar = new d();
            dVar.f26533a = mediaEditEntity.a().a();
            dVar.f26534b = mediaExtractor;
            dVar.f26535c = Long.valueOf(mediaEditEntity.b());
            dVar.f26536d = Long.valueOf(mediaEditEntity.c());
            dVar.f26537e = Long.valueOf(mediaEditEntity.c());
            this.f26612e.add(dVar);
        }
        MediaExtractor mediaExtractor2 = this.f26611d.get(0);
        int trackCount = mediaExtractor2.getTrackCount();
        for (int i5 = 0; i5 < trackCount; i5++) {
            if (mediaExtractor2.getTrackFormat(i5).getString(IMediaFormat.KEY_MIME).startsWith("video/")) {
                MediaEditEntity mediaEditEntity2 = this.f26610c.get(0);
                this.f26613f = mediaEditEntity2;
                if (mediaEditEntity2.a().e() == 0 || this.f26613f.a().e() == 180) {
                    i3 = this.f26613f.a().c();
                    i2 = this.f26613f.a().d();
                } else {
                    i3 = this.f26613f.a().d();
                    i2 = this.f26613f.a().c();
                }
                this.f26609b = MediaFormat.createVideoFormat("video/avc", i3, i2);
                this.f26609b.setInteger("color-format", 2130708361);
                MediaFormat mediaFormat = this.f26609b;
                double c2 = (double) this.f26613f.a().c();
                Double.isNaN(c2);
                double d2 = (double) this.f26613f.a().d();
                Double.isNaN(d2);
                mediaFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, (int) (c2 * 24.0d * d2));
                this.f26609b.setInteger("frame-rate", 30);
                this.f26609b.setInteger("i-frame-interval", 1);
                return;
            }
        }
    }

    private void a(MediaFormat mediaFormat) throws IOException {
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        createEncoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
        c cVar = new c(createEncoderByType.createInputSurface());
        cVar.b();
        createEncoderByType.start();
        b bVar = new b(this.f26613f.a().c(), this.f26613f.a().d(), this.f26614g);
        bVar.a(a.a(GPUImageFilterType.valueOf(this.f26613f.d())));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        while (i2 < this.f26610c.size()) {
            try {
                MediaExtractor mediaExtractor = this.f26611d.get(i2);
                int trackCount = mediaExtractor.getTrackCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= trackCount) {
                        break;
                    }
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
                    if (trackFormat.getString(IMediaFormat.KEY_MIME).startsWith("video/")) {
                        arrayList.add(MediaCodec.createDecoderByType("video/avc"));
                        arrayList2.add(trackFormat);
                        mediaExtractor.selectTrack(i3);
                        break;
                    }
                    i3++;
                }
                i2++;
            } finally {
                bVar.a();
                cVar.a();
                createEncoderByType.stop();
                createEncoderByType.release();
            }
        }
        a(this.f26612e, arrayList, arrayList2, bVar, cVar, createEncoderByType);
    }

    private void a(List<d> list, List<MediaCodec> list2, List<MediaFormat> list3, b bVar, c cVar, MediaCodec mediaCodec) {
        MediaCodec mediaCodec2;
        boolean z2;
        long j2;
        List<d> list4 = list;
        List<MediaCodec> list5 = list2;
        List<MediaFormat> list6 = list3;
        b bVar2 = bVar;
        MediaCodec mediaCodec3 = mediaCodec;
        long currentTimeMillis = System.currentTimeMillis();
        MediaCodec mediaCodec4 = list5.get(0);
        mediaCodec4.configure(list6.get(0), bVar.b(), (MediaCrypto) null, 0);
        mediaCodec4.start();
        ByteBuffer[] inputBuffers = mediaCodec4.getInputBuffers();
        ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        ByteBuffer[] byteBufferArr = outputBuffers;
        long c2 = this.f26613f.c() * 1000;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = false;
        int i2 = 0;
        boolean z7 = true;
        d dVar = list4.get(0);
        ByteBuffer[] byteBufferArr2 = inputBuffers;
        MediaCodec mediaCodec5 = mediaCodec4;
        boolean z8 = false;
        while (!z3) {
            long j8 = currentTimeMillis;
            if (!z4) {
                int dequeueInputBuffer = mediaCodec5.dequeueInputBuffer(j3);
                Log.e("videoo", "---解码器 是否可用  " + dequeueInputBuffer);
                if (dequeueInputBuffer >= 0) {
                    ByteBuffer byteBuffer = byteBufferArr2[dequeueInputBuffer];
                    byteBuffer.clear();
                    int readSampleData = dVar.f26534b.readSampleData(byteBuffer, 0);
                    if (readSampleData < 0 || j4 >= c2) {
                        Log.e("send", "-----发送end--flag");
                        mediaCodec5.queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
                        z4 = true;
                    } else {
                        if (z8) {
                            j5 += 30000;
                            z8 = false;
                        } else if (z5) {
                            z5 = false;
                            j5 = 0;
                        } else {
                            j5 += dVar.f26534b.getSampleTime() - j6;
                        }
                        j6 = dVar.f26534b.getSampleTime();
                        mediaCodec5.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, j5, 0);
                        dVar.f26534b.advance();
                    }
                }
            }
            boolean z9 = false;
            boolean z10 = false;
            while (true) {
                if (z9 && z10) {
                    break;
                }
                boolean z11 = z10;
                int dequeueOutputBuffer = mediaCodec5.dequeueOutputBuffer(bufferInfo2, 0);
                Log.e("videoo", "  解码器出来的index   " + dequeueOutputBuffer);
                if (dequeueOutputBuffer == -1) {
                    c cVar2 = cVar;
                    z10 = z11;
                    z9 = true;
                } else {
                    if (dequeueOutputBuffer != -3) {
                        if (dequeueOutputBuffer == -2) {
                            mediaCodec5.getOutputFormat();
                        } else if (dequeueOutputBuffer >= 0) {
                            boolean z12 = bufferInfo2.presentationTimeUs <= 0 ? false : bufferInfo2.size != 0;
                            mediaCodec5.releaseOutputBuffer(dequeueOutputBuffer, z12);
                            if (z12) {
                                bVar.c();
                                bVar.d();
                                if (z7) {
                                    j2 = j4;
                                    z7 = false;
                                } else if (z6) {
                                    Log.e("videoo", "---更换了一个视频源===+30000");
                                    j2 = j4 + 30000;
                                    z6 = false;
                                } else {
                                    j2 = j4 + (bufferInfo2.presentationTimeUs - j7);
                                }
                                StringBuilder sb = new StringBuilder();
                                z2 = z9;
                                sb.append("---在编码画面帧的时候，重置时间戳===");
                                sb.append(j2);
                                Log.e("videooo", sb.toString());
                                cVar.a(j2 * 1000);
                                cVar.c();
                                j4 = j2;
                            } else {
                                c cVar3 = cVar;
                                z2 = z9;
                                Log.e("videoo", "---解码出来的视频有问题=== " + z12 + "   " + true);
                            }
                            long j9 = bufferInfo2.presentationTimeUs;
                            if ((bufferInfo2.flags & 4) != 0) {
                                int i3 = i2 + 1;
                                if (i3 < list.size()) {
                                    c2 += this.f26610c.get(i3).c() * 1000;
                                    dVar.f26534b.release();
                                    dVar = list4.get(i3);
                                    mediaCodec5.stop();
                                    mediaCodec5.release();
                                    mediaCodec5 = list5.get(i3);
                                    mediaCodec5.configure(list6.get(i3), bVar.b(), (MediaCrypto) null, 0);
                                    mediaCodec5.start();
                                    byteBufferArr2 = mediaCodec5.getInputBuffers();
                                    bVar2.a(a.a(GPUImageFilterType.valueOf(this.f26610c.get(i3).d())));
                                    bVar2.a(this.f26610c.get(i3).a().c(), this.f26610c.get(i3).a().d());
                                    Log.e("videoo", "---更换分离器 and 解码器---==");
                                    i2 = i3;
                                    j7 = j9;
                                    z10 = z11;
                                    z9 = z2;
                                    z4 = false;
                                    z8 = true;
                                    z6 = true;
                                } else {
                                    mediaCodec.signalEndOfInputStream();
                                    Log.e("videoo", "---所有视频都解码完成了 告诉编码器 可以结束了---==");
                                    i2 = i3;
                                    j7 = j9;
                                    z10 = z11;
                                    z9 = z2;
                                    z4 = true;
                                }
                            } else {
                                j7 = j9;
                                z10 = z11;
                                z9 = z2;
                            }
                        }
                    }
                    c cVar4 = cVar;
                    z10 = z11;
                }
                while (true) {
                    mediaCodec2 = mediaCodec;
                    if (z10) {
                        break;
                    }
                    int dequeueOutputBuffer2 = mediaCodec2.dequeueOutputBuffer(bufferInfo, 0);
                    if (dequeueOutputBuffer2 == -1) {
                        z10 = true;
                    } else if (dequeueOutputBuffer2 == -3) {
                        byteBufferArr = mediaCodec.getOutputBuffers();
                    } else if (dequeueOutputBuffer2 == -2) {
                        this.f26608a.a(2, mediaCodec.getOutputFormat());
                        Log.e("videoo", "---添加MediaFormat");
                    } else if (dequeueOutputBuffer2 >= 0) {
                        boolean z13 = (bufferInfo.flags & 4) != 0;
                        if (z13) {
                            z3 = z13;
                            break;
                        }
                        if ((bufferInfo.flags & 2) != 0) {
                            bufferInfo.size = 0;
                        }
                        ByteBuffer byteBuffer2 = byteBufferArr[dequeueOutputBuffer2];
                        if (bufferInfo.size != 0) {
                            this.f26615h.a((((float) (bufferInfo.presentationTimeUs * 30)) * 100.0f) / ((float) (this.f26613f.c() * 30)));
                            Log.e("videoo", "--写入混合器的数据----presentationTime===" + bufferInfo.presentationTimeUs + "===size===" + bufferInfo.size + "----flags==" + bufferInfo.flags);
                            this.f26608a.a(2, byteBuffer2, bufferInfo);
                        }
                        mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer2, false);
                        z3 = z13;
                    }
                    List<MediaFormat> list7 = list3;
                    b bVar3 = bVar;
                }
                list5 = list2;
                list6 = list3;
                bVar2 = bVar;
                MediaCodec mediaCodec6 = mediaCodec2;
                list4 = list;
            }
            currentTimeMillis = j8;
            j3 = 0;
        }
        mediaCodec5.stop();
        mediaCodec5.release();
        this.f26608a.b();
        long currentTimeMillis2 = System.currentTimeMillis();
        Log.e("timee", "---视频编码完成---视频编码耗时-==" + (currentTimeMillis2 - currentTimeMillis));
    }

    public void run() {
        try {
            a();
            a(this.f26609b);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
