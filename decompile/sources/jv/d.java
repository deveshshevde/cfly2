package jv;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.xeagle.android.login.pickImage.data.GLImage;
import java.io.BufferedOutputStream;
import java.nio.ByteBuffer;
import jo.e;
import jv.b;
import kotlin.jvm.internal.h;
import org.greenrobot.eventbus.c;

public final class d extends a {

    /* renamed from: a  reason: collision with root package name */
    private MediaFormat f29817a;

    /* renamed from: b  reason: collision with root package name */
    private final Surface f29818b;

    /* renamed from: c  reason: collision with root package name */
    private final String f29819c;

    /* renamed from: d  reason: collision with root package name */
    private final int f29820d;

    /* renamed from: e  reason: collision with root package name */
    private final int f29821e;

    /* renamed from: f  reason: collision with root package name */
    private final int f29822f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f29823g;

    /* renamed from: h  reason: collision with root package name */
    private final b f29824h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Surface surface, String str, int i2, int i3, int i4, boolean z2, b bVar) {
        super(i2, i3, i4);
        h.d(str, GLImage.KEY_MIMETYPE);
        h.d(bVar, "videoFrameQueue");
        this.f29818b = surface;
        this.f29819c = str;
        this.f29820d = i2;
        this.f29821e = i3;
        this.f29822f = i4;
        this.f29823g = z2;
        this.f29824h = bVar;
    }

    public void run() {
        MediaCodec.BufferInfo bufferInfo;
        c j2;
        if (b()) {
            Log.i(a(), "VideoDecodeThread started");
        }
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(this.f29819c);
        h.b(createDecoderByType, "MediaCodec.createDecoderByType(mimeType)");
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.f29819c, this.f29820d, this.f29821e);
        this.f29817a = createVideoFormat;
        h.a((Object) createVideoFormat);
        createVideoFormat.setInteger("frame-rate", this.f29822f);
        MediaFormat mediaFormat = this.f29817a;
        h.a((Object) mediaFormat);
        boolean z2 = false;
        mediaFormat.setInteger("bitrate-mode", 0);
        MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
        while (true) {
            if (!Thread.interrupted() && e()) {
                b.C0201b a2 = this.f29824h.a();
                if (a2 != null) {
                    if ((a2.a()[4] & 31) == 7) {
                        a(a2.a());
                    } else if ((a2.a()[4] & 31) == 8) {
                        b(a2.a());
                    }
                    if (!(!g() || n() == null || o() == null)) {
                        if (!(o() == null || n() == null)) {
                            MediaFormat mediaFormat2 = this.f29817a;
                            h.a((Object) mediaFormat2);
                            mediaFormat2.setByteBuffer("csd-0", ByteBuffer.wrap(n()));
                            MediaFormat mediaFormat3 = this.f29817a;
                            h.a((Object) mediaFormat3);
                            mediaFormat3.setByteBuffer("csd-1", ByteBuffer.wrap(o()));
                        }
                        try {
                            createDecoderByType.reset();
                            createDecoderByType.configure(this.f29817a, this.f29818b, (MediaCrypto) null, z2 ? 1 : 0);
                            createDecoderByType.start();
                            if ((a2.a()[4] & 31) == 5) {
                                b(z2);
                            }
                        } catch (Exception e2) {
                            String a3 = a();
                            Log.i(a3, "run:===config==error==== " + e2.getMessage());
                            c.a().d(new e());
                            e2.printStackTrace();
                            return;
                        }
                    }
                    if (!g()) {
                        if ((a2.a()[4] & 31) == 6 || (a2.a()[4] & 31) == 7 || (a2.a()[4] & 31) == 8) {
                            bufferInfo = bufferInfo2;
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (l() == -1) {
                                b(System.currentTimeMillis());
                                bufferInfo = bufferInfo2;
                            } else {
                                a(currentTimeMillis - l());
                                bufferInfo = bufferInfo2;
                                long j3 = (long) 3;
                                if ((1000 / ((long) this.f29822f)) - k() > j3) {
                                    SystemClock.sleep(((1000 / ((long) this.f29822f)) - k()) - j3);
                                }
                            }
                            b(System.currentTimeMillis());
                        }
                        try {
                            int dequeueInputBuffer = createDecoderByType.dequeueInputBuffer(c());
                            if (dequeueInputBuffer >= 0) {
                                if ((a2.a()[4] & 31) == 5) {
                                    c(1);
                                } else if (!((a2.a()[4] & 31) == 6 || (a2.a()[4] & 31) == 7 || (a2.a()[4] & 31) == 8)) {
                                    a2.a()[6] = (byte) ((int) m());
                                    a2.a()[7] = (byte) ((int) m());
                                    c(m() + 1);
                                }
                                ByteBuffer inputBuffer = createDecoderByType.getInputBuffer(dequeueInputBuffer);
                                if (inputBuffer != null) {
                                    inputBuffer.rewind();
                                }
                                h.a((Object) inputBuffer);
                                inputBuffer.put(a2.a(), a2.b(), a2.a().length);
                                if (d()) {
                                    if (!h() && (a2.a()[4] & 31) == 7) {
                                        c(true);
                                    }
                                    if (h()) {
                                        BufferedOutputStream i2 = i();
                                        if (i2 != null) {
                                            i2.write(a2.a(), a2.b(), a2.a().length);
                                        }
                                        BufferedOutputStream i3 = i();
                                        if (i3 != null) {
                                            i3.flush();
                                        }
                                    }
                                } else {
                                    c(false);
                                }
                                if (f() && (j2 = j()) != null) {
                                    j2.a(a2);
                                }
                                createDecoderByType.queueInputBuffer(dequeueInputBuffer, a2.b(), a2.a().length, a2.c(), 0);
                            } else if (dequeueInputBuffer != -2 && dequeueInputBuffer == -1) {
                                try {
                                    Thread.sleep(1);
                                } catch (InterruptedException e3) {
                                    InterruptedException interruptedException = e3;
                                    interruptedException.printStackTrace();
                                    String a4 = a();
                                    Log.i(a4, "3onRtspVideoNalUnitReceived run: =====rtsp exception===" + interruptedException.getMessage());
                                }
                            }
                            try {
                                MediaCodec.BufferInfo bufferInfo3 = bufferInfo;
                                int dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo3, c());
                                if (dequeueOutputBuffer == -2) {
                                    String a5 = a();
                                    Log.i(a5, "Decoder format changed: " + createDecoderByType.getOutputFormat());
                                } else if (dequeueOutputBuffer >= 0 && !Thread.interrupted()) {
                                    createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, a2.c());
                                }
                                if ((bufferInfo3.flags & 4) == 0) {
                                    bufferInfo2 = bufferInfo3;
                                    z2 = false;
                                } else if (b()) {
                                    Log.i(a(), "OutputBuffer BUFFER_FLAG_END_OF_STREAM");
                                }
                            } catch (Exception e4) {
                                c.a().d(new e());
                                String a6 = a();
                                Log.i(a6, "2onRtspVideoNalUnitReceived run: =====rtsp exception===" + e4.getMessage());
                                e4.printStackTrace();
                                return;
                            }
                        } catch (IllegalStateException e5) {
                            c.a().d(new e());
                            e5.printStackTrace();
                            String a7 = a();
                            Log.i(a7, "onRtspVideoNalUnitReceived run: =====rtsp exception===" + e5.getMessage());
                            return;
                        }
                    } else {
                        continue;
                    }
                } else {
                    MediaCodec.BufferInfo bufferInfo4 = bufferInfo2;
                }
            }
        }
        try {
            createDecoderByType.stop();
            createDecoderByType.release();
            this.f29824h.b();
        } catch (Exception e6) {
            String a8 = a();
            Log.i(a8, "4onRtspVideoNalUnitReceived run: =====rtsp exception===" + e6.getMessage());
            e6.printStackTrace();
        }
    }
}
