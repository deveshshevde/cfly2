package com.shuyu.gsyvideoplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import je.b;
import jh.c;
import ji.e;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public abstract class b implements GSYVideoViewBridge, b.a, IMediaPlayer.OnBufferingUpdateListener, IMediaPlayer.OnCompletionListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnInfoListener, IMediaPlayer.OnPreparedListener, IMediaPlayer.OnSeekCompleteListener, IMediaPlayer.OnVideoSizeChangedListener {

    /* renamed from: d  reason: collision with root package name */
    public static String f21619d = "GSYVideoBaseManager";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public long f21620a = 0;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f21621b = new Runnable() {
        public void run() {
            if (b.this.f21625h != null) {
                Debuger.printfError("time out for error listener");
                b.this.listener().onError(-192, -192);
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    protected Context f21622e;

    /* renamed from: f  reason: collision with root package name */
    protected a f21623f;

    /* renamed from: g  reason: collision with root package name */
    protected Handler f21624g;

    /* renamed from: h  reason: collision with root package name */
    protected WeakReference<jg.a> f21625h;

    /* renamed from: i  reason: collision with root package name */
    protected WeakReference<jg.a> f21626i;

    /* renamed from: j  reason: collision with root package name */
    protected ji.b f21627j;

    /* renamed from: k  reason: collision with root package name */
    protected List<c> f21628k;

    /* renamed from: l  reason: collision with root package name */
    protected String f21629l = "";

    /* renamed from: m  reason: collision with root package name */
    protected ji.c f21630m;

    /* renamed from: n  reason: collision with root package name */
    protected je.b f21631n;

    /* renamed from: o  reason: collision with root package name */
    protected int f21632o = 0;

    /* renamed from: p  reason: collision with root package name */
    protected int f21633p = 0;

    /* renamed from: q  reason: collision with root package name */
    protected int f21634q;

    /* renamed from: r  reason: collision with root package name */
    protected int f21635r = -22;

    /* renamed from: s  reason: collision with root package name */
    protected int f21636s;

    /* renamed from: t  reason: collision with root package name */
    protected int f21637t = 8000;

    /* renamed from: u  reason: collision with root package name */
    protected boolean f21638u = false;

    /* renamed from: v  reason: collision with root package name */
    protected boolean f21639v;

    private class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 0) {
                b.this.b(message);
            } else if (i2 != 2) {
                if (i2 == 3) {
                    b.this.c(message);
                } else if (i2 == 4) {
                    Log.i("rtsp", "handleMessage: --release video cahces");
                    if (b.this.f21631n != null) {
                        b.this.f21631n.a();
                    }
                }
            } else if (System.currentTimeMillis() - b.this.f21620a > 5000) {
                if (b.this.f21630m != null) {
                    b.this.f21630m.c();
                }
                if (b.this.f21631n != null) {
                    Log.i("rtsp", "handleMessage: ----release videos ");
                    b.this.f21631n.a();
                }
                b.this.f21636s = 0;
                b.this.a(false);
                b.this.i();
                long unused = b.this.f21620a = System.currentTimeMillis();
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(Message message) {
        try {
            this.f21632o = 0;
            this.f21633p = 0;
            ji.c cVar = this.f21630m;
            if (cVar != null) {
                cVar.c();
            }
            this.f21630m = f();
            je.b g2 = g();
            this.f21631n = g2;
            if (g2 != null) {
                g2.a(this);
            }
            ji.c cVar2 = this.f21630m;
            if (cVar2 instanceof ji.a) {
                ((ji.a) cVar2).a(this.f21627j);
            }
            this.f21630m.a(this.f21622e, message, this.f21628k, this.f21631n);
            a(this.f21638u);
            IMediaPlayer a2 = this.f21630m.a();
            a2.setOnCompletionListener(this);
            a2.setOnBufferingUpdateListener(this);
            a2.setScreenOnWhilePlaying(true);
            a2.setOnPreparedListener(this);
            a2.setOnSeekCompleteListener(this);
            a2.setOnErrorListener(this);
            a2.setOnInfoListener(this);
            a2.setOnVideoSizeChangedListener(this);
            a2.prepareAsync();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void c(Message message) {
        ji.c cVar;
        if (message.obj != null && (cVar = this.f21630m) != null) {
            cVar.b();
        }
    }

    private void d(Message message) {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            cVar.a(message);
        }
    }

    public void a(Context context, File file, String str) {
        je.b bVar = this.f21631n;
        if (bVar == null) {
            if (g() != null) {
                bVar = g();
            } else {
                return;
            }
        }
        bVar.a(context, file, str);
    }

    /* access modifiers changed from: protected */
    public void a(Message message) {
        this.f21623f.sendMessage(message);
    }

    public void a(File file, String str, int i2) {
        this.f21636s = i2;
    }

    public void a(boolean z2) {
        this.f21638u = z2;
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            cVar.a(z2);
        }
    }

    public void b(Context context) {
        this.f21622e = context.getApplicationContext();
    }

    public boolean cachePreview(Context context, File file, String str) {
        if (g() != null) {
            return g().b(context, file, str);
        }
        return false;
    }

    public void clearCache(Context context, File file, String str) {
        a(context, file, str);
    }

    /* access modifiers changed from: protected */
    public void e() {
        this.f21623f = new a(Looper.getMainLooper());
        this.f21624g = new Handler(Looper.myLooper());
    }

    /* access modifiers changed from: protected */
    public ji.c f() {
        return e.a();
    }

    public void flushQueue() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            cVar.j();
        }
    }

    /* access modifiers changed from: protected */
    public je.b g() {
        return je.a.a();
    }

    public int getBufferedPercentage() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            return cVar.d();
        }
        return 0;
    }

    public boolean getCurrentBitmap(Bitmap bitmap) {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            return cVar.a(bitmap);
        }
        return false;
    }

    public int getCurrentFrame(String str) {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            return cVar.a(str);
        }
        return 0;
    }

    public long getCurrentPosition() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            return cVar.v();
        }
        return 0;
    }

    public int getCurrentVideoHeight() {
        return this.f21633p;
    }

    public int getCurrentVideoWidth() {
        return this.f21632o;
    }

    public float getDecodeFps() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            return cVar.f();
        }
        return 0.0f;
    }

    public long getDuration() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            return cVar.w();
        }
        return 0;
    }

    public int getLastState() {
        return this.f21634q;
    }

    public long getNetSpeed() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            return cVar.e();
        }
        return 0;
    }

    public float getOutputFps() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            return cVar.g();
        }
        return 0.0f;
    }

    public int getPlayPosition() {
        return this.f21635r;
    }

    public String getPlayTag() {
        return this.f21629l;
    }

    public ji.c getPlayer() {
        return this.f21630m;
    }

    public int getRotateInfoFlag() {
        return 10001;
    }

    public float getSpeed(float f2) {
        ji.c cVar = this.f21630m;
        return cVar != null ? cVar.a(f2) : f2;
    }

    public long getVideoCachedDuration() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            return cVar.h();
        }
        return 0;
    }

    public long getVideoCahcedBytes() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            return cVar.i();
        }
        return 0;
    }

    public int getVideoHeight() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            return cVar.t();
        }
        return 0;
    }

    public int getVideoSarDen() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            return cVar.y();
        }
        return 0;
    }

    public int getVideoSarNum() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            return cVar.x();
        }
        return 0;
    }

    public int getVideoWidth() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            return cVar.s();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void h() {
        Debuger.printfError("startTimeOutBuffer");
        this.f21624g.postDelayed(this.f21621b, (long) this.f21637t);
    }

    /* access modifiers changed from: protected */
    public void i() {
        Debuger.printfError("cancelTimeOutBuffer");
        if (this.f21639v) {
            this.f21624g.removeCallbacks(this.f21621b);
        }
    }

    public boolean isCacheFile() {
        je.b bVar = this.f21631n;
        return bVar != null && bVar.b();
    }

    public int isLocalRecording() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            return cVar.n();
        }
        return 0;
    }

    public boolean isPlaying() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            return cVar.u();
        }
        return false;
    }

    public boolean isSurfaceSupportLockCanvas() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            return cVar.o();
        }
        return false;
    }

    public jg.a lastListener() {
        WeakReference<jg.a> weakReference = this.f21626i;
        if (weakReference == null) {
            return null;
        }
        return (jg.a) weakReference.get();
    }

    public jg.a listener() {
        WeakReference<jg.a> weakReference = this.f21625h;
        if (weakReference == null) {
            return null;
        }
        return (jg.a) weakReference.get();
    }

    public void onBufferingUpdate(IMediaPlayer iMediaPlayer, final int i2) {
        this.f21624g.post(new Runnable() {
            public void run() {
                int i2;
                jg.a aVar;
                if (b.this.listener() != null) {
                    if (i2 > b.this.f21636s) {
                        aVar = b.this.listener();
                        i2 = i2;
                    } else {
                        aVar = b.this.listener();
                        i2 = b.this.f21636s;
                    }
                    aVar.onBufferingUpdate(i2);
                }
            }
        });
    }

    public void onCompletion(IMediaPlayer iMediaPlayer) {
        this.f21624g.post(new Runnable() {
            public void run() {
                b.this.i();
                if (b.this.listener() != null) {
                    b.this.listener().onAutoCompletion();
                }
            }
        });
    }

    public boolean onError(IMediaPlayer iMediaPlayer, final int i2, final int i3) {
        this.f21624g.post(new Runnable() {
            public void run() {
                b.this.i();
                if (b.this.listener() != null) {
                    b.this.listener().onError(i2, i3);
                    Log.i("Sochip", "run: ----error---" + i2 + "----extra---" + i3);
                    org.greenrobot.eventbus.c.a().d(new f(System.currentTimeMillis()));
                }
            }
        });
        return true;
    }

    public boolean onInfo(IMediaPlayer iMediaPlayer, final int i2, final int i3) {
        this.f21624g.post(new Runnable() {
            public void run() {
                if (b.this.f21639v) {
                    int i2 = i2;
                    if (i2 == 701) {
                        b.this.h();
                    } else if (i2 == 702) {
                        b.this.i();
                    }
                }
                if (b.this.listener() != null) {
                    b.this.listener().onInfo(i2, i3);
                    Log.i("Sochip", "run: --info---what--" + i2 + "---extra--" + i3);
                }
            }
        });
        return false;
    }

    public void onPrepared(IMediaPlayer iMediaPlayer) {
        this.f21624g.post(new Runnable() {
            public void run() {
                b.this.i();
                if (b.this.listener() != null) {
                    b.this.listener().onPrepared();
                }
            }
        });
    }

    public void onSeekComplete(IMediaPlayer iMediaPlayer) {
        this.f21624g.post(new Runnable() {
            public void run() {
                b.this.i();
                if (b.this.listener() != null) {
                    b.this.listener().onSeekComplete();
                }
            }
        });
    }

    public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i2, int i3, int i4, int i5) {
        this.f21632o = iMediaPlayer.getVideoWidth();
        this.f21633p = iMediaPlayer.getVideoHeight();
        this.f21624g.post(new Runnable() {
            public void run() {
                if (b.this.listener() != null) {
                    b.this.listener().onVideoSizeChanged();
                }
            }
        });
    }

    public void pause() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            cVar.r();
        }
    }

    public void pauseLocalRecord() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            cVar.k();
        }
    }

    public void prepare(String str, Map<String, String> map, boolean z2, float f2, boolean z3, File file) {
        prepare(str, map, z2, f2, z3, file, (String) null);
    }

    public void prepare(String str, Map<String, String> map, boolean z2, float f2, boolean z3, File file, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Message message = new Message();
            message.what = 0;
            message.obj = new jh.a(str, map, z2, f2, z3, file, str2);
            a(message);
            if (this.f21639v) {
                h();
            }
        }
    }

    public void releaseMediaPlayer() {
        Message message = new Message();
        message.what = 2;
        a(message);
        this.f21629l = "";
        this.f21635r = -22;
    }

    public void releaseSurface(Surface surface) {
        Message message = new Message();
        message.what = 3;
        message.obj = surface;
        a(message);
    }

    public void releaseVideoCache() {
        Message message = new Message();
        message.what = 4;
        a(message);
    }

    public void resumeLocalRecord() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            cVar.l();
        }
    }

    public void seekTo(long j2) {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            cVar.b(j2);
        }
    }

    public void setCurrentVideoHeight(int i2) {
        this.f21633p = i2;
    }

    public void setCurrentVideoWidth(int i2) {
        this.f21632o = i2;
    }

    public void setDisplay(Surface surface) {
        Message message = new Message();
        message.what = 1;
        message.obj = surface;
        d(message);
    }

    public void setDuration(long j2) {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            cVar.a(j2);
        }
    }

    public void setLastListener(jg.a aVar) {
        if (aVar == null) {
            this.f21626i = null;
        } else {
            this.f21626i = new WeakReference<>(aVar);
        }
    }

    public void setLastState(int i2) {
        this.f21634q = i2;
    }

    public void setListener(jg.a aVar) {
        if (aVar == null) {
            this.f21625h = null;
        } else {
            this.f21625h = new WeakReference<>(aVar);
        }
    }

    public void setPlayPosition(int i2) {
        this.f21635r = i2;
    }

    public void setPlayTag(String str) {
        this.f21629l = str;
    }

    public void setSpeed(float f2, boolean z2) {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            cVar.b(f2, z2);
        }
    }

    public void setSpeedPlaying(float f2, boolean z2) {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            cVar.a(f2, z2);
        }
    }

    public void start() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            cVar.p();
        }
    }

    public int startLocalRecord(String str) {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            return cVar.b(str);
        }
        return 0;
    }

    public void stop() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            cVar.q();
        }
    }

    public int stopLocalRecord() {
        ji.c cVar = this.f21630m;
        if (cVar != null) {
            return cVar.m();
        }
        return 0;
    }
}
