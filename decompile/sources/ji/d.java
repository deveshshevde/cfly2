package ji;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.GSYVideoType;
import com.shuyu.gsyvideoplayer.utils.RawDataSourceProvider;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import je.b;
import jh.a;
import jh.c;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkLibLoader;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;

public class d extends a {

    /* renamed from: b  reason: collision with root package name */
    private static int f13814b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static IjkLibLoader f13815c;

    /* renamed from: d  reason: collision with root package name */
    private IjkMediaPlayer f13816d;

    /* renamed from: e  reason: collision with root package name */
    private List<c> f13817e;

    /* renamed from: f  reason: collision with root package name */
    private Surface f13818f;

    /* renamed from: g  reason: collision with root package name */
    private long f13819g = 0;

    private void a(IjkMediaPlayer ijkMediaPlayer, List<c> list) {
        if (list != null && list.size() > 0) {
            for (c next : list) {
                if (next.a() == 0) {
                    ijkMediaPlayer.setOption(next.b(), next.d(), (long) next.c());
                } else {
                    ijkMediaPlayer.setOption(next.b(), next.d(), next.e());
                }
            }
        }
    }

    public float a(float f2) {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.getSpeed(f2);
        }
        return f2;
    }

    public int a(String str) {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.getCurrentFrame(str);
        }
        return 0;
    }

    public IMediaPlayer a() {
        return this.f13816d;
    }

    public void a(float f2, boolean z2) {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setSpeed(f2);
            this.f13816d.setOption(4, "soundtouch", z2 ? 1 : 0);
        }
    }

    public void a(long j2) {
        this.f13819g = j2;
    }

    public void a(Context context, Message message, List<c> list, b bVar) {
        IjkMediaPlayer ijkMediaPlayer;
        IjkMediaPlayer ijkMediaPlayer2;
        Map<String, String> b2;
        IjkLibLoader ijkLibLoader = f13815c;
        IjkMediaPlayer ijkMediaPlayer3 = ijkLibLoader == null ? new IjkMediaPlayer() : new IjkMediaPlayer(ijkLibLoader);
        this.f13816d = ijkMediaPlayer3;
        ijkMediaPlayer3.setAudioStreamType(3);
        this.f13816d.setOnNativeInvokeListener(new IjkMediaPlayer.OnNativeInvokeListener() {
            public boolean onNativeInvoke(int i2, Bundle bundle) {
                return true;
            }
        });
        a aVar = (a) message.obj;
        String a2 = aVar.a();
        try {
            if (GSYVideoType.isMediaCodec()) {
                Debuger.printfLog("enable mediaCodec");
                this.f13816d.setOption(4, "mediacodec-hevc", 1);
                this.f13816d.setOption(4, "mediacodec-auto-rotate", 1);
                ijkMediaPlayer = this.f13816d;
            } else {
                Log.i("CmdChannel", "initVideoPlayer: ----soft decode");
                this.f13816d.setOption(4, "mediacodec-hevc", 0);
                this.f13816d.setOption(4, "videotoolbox", 0);
                this.f13816d.setOption(4, "mediacodec-auto-rotate", 1);
                ijkMediaPlayer = this.f13816d;
            }
            ijkMediaPlayer.setOption(4, "mediacodec-handle-resolution-change", 1);
            this.f13816d.setOption(4, "overlay-format", 842225234);
            if (!aVar.e() || bVar == null) {
                if (!TextUtils.isEmpty(a2)) {
                    Uri parse = Uri.parse(a2);
                    if (parse.getScheme().equals("android.resource")) {
                        this.f13816d.setDataSource((IMediaDataSource) RawDataSourceProvider.create(context, parse));
                    } else if (parse.getScheme().equals("content")) {
                        try {
                            this.f13816d.setDataSource(context.getContentResolver().openFileDescriptor(parse, "r").getFileDescriptor());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        ijkMediaPlayer2 = this.f13816d;
                        b2 = aVar.b();
                    }
                } else {
                    ijkMediaPlayer2 = this.f13816d;
                    b2 = aVar.b();
                }
                ijkMediaPlayer2.setDataSource(a2, b2);
            } else {
                bVar.a(context, this.f13816d, a2, aVar.b(), aVar.f());
            }
            this.f13816d.setLooping(aVar.c());
            if (aVar.d() != 1.0f && aVar.d() > 0.0f) {
                this.f13816d.setSpeed(aVar.d());
            }
            IjkMediaPlayer.native_setLogLevel(f13814b);
            a(this.f13816d, list);
            this.f13816d.setOption(1, "analyzeduration", 1);
            this.f13816d.setOption(1, "analyzemaxduration", 100);
            this.f13816d.setOption(4, "start-on-prepared", 1);
            this.f13816d.setOption(4, "packet-buffering", 0);
            this.f13816d.setOption(1, "rtsp_transport", "udp");
            this.f13816d.setOption(4, "reconnect", 1);
            this.f13816d.setOption(4, "max_cached_duration", 30);
            this.f13816d.setOption(4, "max-fps", 60);
            this.f13816d.setOption(4, "framedrop", 1);
            this.f13816d.setOption(4, "infbuf", 1);
            this.f13816d.setOption(1, "max-buffer-size", 256);
            this.f13816d.setOption(1, "buffer-size", 128);
            this.f13816d.setOption(4, "min-frames", 1);
            this.f13816d.setOption(1, "probesize", 200);
            this.f13816d.setOption(1, "max_delay", 300);
            this.f13816d.setOption(2, "skip_loop_filter", 0);
            this.f13816d.setOption(2, "skip_frame", 0);
            this.f13816d.setOption(1, "stimeout", "5000000");
            this.f13816d.setOption(4, "enable-accurate-seek", 1);
            this.f13816d.setOption(1, "fflags", "fastseek");
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        a(aVar);
    }

    public void a(Message message) {
        Surface surface;
        IjkMediaPlayer ijkMediaPlayer;
        if (message.obj != null || (ijkMediaPlayer = this.f13816d) == null) {
            surface = (Surface) message.obj;
            this.f13818f = surface;
            if (this.f13816d != null && surface.isValid()) {
                ijkMediaPlayer = this.f13816d;
            } else {
                return;
            }
        } else {
            surface = null;
        }
        ijkMediaPlayer.setSurface(surface);
    }

    public void a(List<c> list) {
        this.f13817e = list;
    }

    public void a(boolean z2) {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            float f2 = z2 ? 0.0f : 1.0f;
            ijkMediaPlayer.setVolume(f2, f2);
        }
    }

    public boolean a(Bitmap bitmap) {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.getCurrentFrame(bitmap);
        }
        return false;
    }

    public int b(String str) {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.startRecord(str);
        }
        return 0;
    }

    public void b() {
        if (this.f13818f != null) {
            this.f13818f = null;
        }
    }

    public void b(float f2, boolean z2) {
        if (f2 > 0.0f) {
            try {
                IjkMediaPlayer ijkMediaPlayer = this.f13816d;
                if (ijkMediaPlayer != null) {
                    ijkMediaPlayer.setSpeed(f2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (z2) {
                c cVar = new c(4, "soundtouch", 1);
                List z3 = z();
                if (z3 == null) {
                    z3 = new ArrayList();
                }
                z3.add(cVar);
                a((List<c>) z3);
            }
        }
    }

    public void b(long j2) {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.seekTo(j2);
        }
    }

    public void c() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.release();
            this.f13816d = null;
        }
    }

    public int d() {
        return -1;
    }

    public long e() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.getTcpSpeed();
        }
        return 0;
    }

    public float f() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.getVideoDecodeFramesPerSecond();
        }
        return 0.0f;
    }

    public float g() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.getVideoOutputFramesPerSecond();
        }
        return 0.0f;
    }

    public long h() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.getVideoCachedDuration();
        }
        return 0;
    }

    public long i() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.getVideoCachedBytes();
        }
        return 0;
    }

    public void j() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.flushQueue(0.0f);
        }
    }

    public void k() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.pauseLocalRecord();
        }
    }

    public void l() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.resumeLocalRecord();
        }
    }

    public int m() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.stopRecord();
        }
        return 0;
    }

    public int n() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.isRecord();
        }
        return 0;
    }

    public boolean o() {
        return true;
    }

    public void p() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.start();
        }
    }

    public void q() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.stop();
        }
    }

    public void r() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.pause();
        }
    }

    public int s() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.getVideoWidth();
        }
        return 0;
    }

    public int t() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.getVideoHeight();
        }
        return 0;
    }

    public boolean u() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.isPlaying();
        }
        return false;
    }

    public long v() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public long w() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        return ijkMediaPlayer != null ? ijkMediaPlayer.getDuration() : this.f13819g;
    }

    public int x() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.getVideoSarNum();
        }
        return 1;
    }

    public int y() {
        IjkMediaPlayer ijkMediaPlayer = this.f13816d;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.getVideoSarDen();
        }
        return 1;
    }

    public List<c> z() {
        return this.f13817e;
    }
}
