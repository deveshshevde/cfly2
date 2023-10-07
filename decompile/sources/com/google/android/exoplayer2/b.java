package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import com.google.android.exoplayer2.audio.c;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private final AudioManager f15407a;

    /* renamed from: b  reason: collision with root package name */
    private final a f15408b;

    /* renamed from: c  reason: collision with root package name */
    private C0109b f15409c;

    /* renamed from: d  reason: collision with root package name */
    private c f15410d;

    /* renamed from: e  reason: collision with root package name */
    private int f15411e;

    /* renamed from: f  reason: collision with root package name */
    private int f15412f;

    /* renamed from: g  reason: collision with root package name */
    private float f15413g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    private AudioFocusRequest f15414h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f15415i;

    private class a implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private final Handler f15417b;

        public a(Handler handler) {
            this.f15417b = handler;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(int i2) {
            b.this.c(i2);
        }

        public void onAudioFocusChange(int i2) {
            this.f15417b.post(new Runnable(i2) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    b.a.this.a(this.f$1);
                }
            });
        }
    }

    /* renamed from: com.google.android.exoplayer2.b$b  reason: collision with other inner class name */
    public interface C0109b {
        void a(float f2);

        void a(int i2);
    }

    public b(Context context, Handler handler, C0109b bVar) {
        this.f15407a = (AudioManager) context.getApplicationContext().getSystemService("audio");
        this.f15409c = bVar;
        this.f15408b = new a(handler);
        this.f15411e = 0;
    }

    private boolean a(int i2) {
        return i2 == 1 || this.f15412f != 1;
    }

    private void b(int i2) {
        if (this.f15411e != i2) {
            this.f15411e = i2;
            float f2 = i2 == 3 ? 0.2f : 1.0f;
            if (this.f15413g != f2) {
                this.f15413g = f2;
                C0109b bVar = this.f15409c;
                if (bVar != null) {
                    bVar.a(f2);
                }
            }
        }
    }

    private int c() {
        if (this.f15411e == 1) {
            return 1;
        }
        if ((ad.f11755a >= 26 ? f() : e()) == 1) {
            b(1);
            return 1;
        }
        b(0);
        return -1;
    }

    /* access modifiers changed from: private */
    public void c(int i2) {
        int i3;
        if (i2 == -3 || i2 == -2) {
            if (i2 == -2 || i()) {
                d(0);
                i3 = 2;
            } else {
                i3 = 3;
            }
            b(i3);
        } else if (i2 == -1) {
            d(-1);
            d();
        } else if (i2 != 1) {
            StringBuilder sb = new StringBuilder(38);
            sb.append("Unknown focus change type: ");
            sb.append(i2);
            k.c("AudioFocusManager", sb.toString());
        } else {
            b(1);
            d(1);
        }
    }

    private void d() {
        if (this.f15411e != 0) {
            if (ad.f11755a >= 26) {
                h();
            } else {
                g();
            }
            b(0);
        }
    }

    private void d(int i2) {
        C0109b bVar = this.f15409c;
        if (bVar != null) {
            bVar.a(i2);
        }
    }

    private int e() {
        return this.f15407a.requestAudioFocus(this.f15408b, ad.g(((c) com.google.android.exoplayer2.util.a.b(this.f15410d)).f15270d), this.f15412f);
    }

    private int f() {
        AudioFocusRequest audioFocusRequest = this.f15414h;
        if (audioFocusRequest == null || this.f15415i) {
            this.f15414h = (audioFocusRequest == null ? new AudioFocusRequest.Builder(this.f15412f) : new AudioFocusRequest.Builder(this.f15414h)).setAudioAttributes(((c) com.google.android.exoplayer2.util.a.b(this.f15410d)).a()).setWillPauseWhenDucked(i()).setOnAudioFocusChangeListener(this.f15408b).build();
            this.f15415i = false;
        }
        return this.f15407a.requestAudioFocus(this.f15414h);
    }

    private void g() {
        this.f15407a.abandonAudioFocus(this.f15408b);
    }

    private void h() {
        AudioFocusRequest audioFocusRequest = this.f15414h;
        if (audioFocusRequest != null) {
            this.f15407a.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    private boolean i() {
        c cVar = this.f15410d;
        return cVar != null && cVar.f15268b == 1;
    }

    public float a() {
        return this.f15413g;
    }

    public int a(boolean z2, int i2) {
        if (a(i2)) {
            d();
            return z2 ? 1 : -1;
        } else if (z2) {
            return c();
        } else {
            return -1;
        }
    }

    public void b() {
        this.f15409c = null;
        d();
    }
}
