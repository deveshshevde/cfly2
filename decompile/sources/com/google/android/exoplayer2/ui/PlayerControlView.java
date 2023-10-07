package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.n;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.ui.c;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.v;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.x;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class PlayerControlView extends FrameLayout {
    private final Drawable A;
    private final Drawable B;
    private final float C;
    private final float D;
    private final String E;
    private final String F;
    /* access modifiers changed from: private */
    public x G;
    /* access modifiers changed from: private */
    public f H;
    private b I;
    /* access modifiers changed from: private */
    public w J;
    private boolean K;
    private boolean L;
    private boolean M;
    /* access modifiers changed from: private */
    public boolean N;
    private int O;
    private int P;
    private int Q;
    private int R;
    /* access modifiers changed from: private */
    public int S;
    private boolean T;
    private long U;
    private long[] V;
    private boolean[] W;

    /* renamed from: a  reason: collision with root package name */
    private final a f16803a;

    /* renamed from: aa  reason: collision with root package name */
    private long[] f16804aa;

    /* renamed from: ab  reason: collision with root package name */
    private boolean[] f16805ab;

    /* renamed from: ac  reason: collision with root package name */
    private long f16806ac;

    /* renamed from: b  reason: collision with root package name */
    private final CopyOnWriteArrayList<c> f16807b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final View f16808c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final View f16809d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final View f16810e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final View f16811f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final View f16812g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final View f16813h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final ImageView f16814i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final ImageView f16815j;

    /* renamed from: k  reason: collision with root package name */
    private final View f16816k;

    /* renamed from: l  reason: collision with root package name */
    private final TextView f16817l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final TextView f16818m;

    /* renamed from: n  reason: collision with root package name */
    private final c f16819n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final StringBuilder f16820o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final Formatter f16821p;

    /* renamed from: q  reason: collision with root package name */
    private final af.a f16822q;

    /* renamed from: r  reason: collision with root package name */
    private final af.b f16823r;

    /* renamed from: s  reason: collision with root package name */
    private final Runnable f16824s;

    /* renamed from: t  reason: collision with root package name */
    private final Runnable f16825t;

    /* renamed from: u  reason: collision with root package name */
    private final Drawable f16826u;

    /* renamed from: v  reason: collision with root package name */
    private final Drawable f16827v;

    /* renamed from: w  reason: collision with root package name */
    private final Drawable f16828w;

    /* renamed from: x  reason: collision with root package name */
    private final String f16829x;

    /* renamed from: y  reason: collision with root package name */
    private final String f16830y;

    /* renamed from: z  reason: collision with root package name */
    private final String f16831z;

    private final class a implements View.OnClickListener, c.a, x.a {
        private a() {
        }

        public /* synthetic */ void a(ExoPlaybackException exoPlaybackException) {
            x.a.CC.$default$a((x.a) this, exoPlaybackException);
        }

        public void a(af afVar, int i2) {
            PlayerControlView.this.g();
            PlayerControlView.this.j();
        }

        public /* synthetic */ void a(af afVar, Object obj, int i2) {
            x.a.CC.$default$a(this, afVar, obj, i2);
        }

        public /* synthetic */ void a(TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.f fVar) {
            x.a.CC.$default$a((x.a) this, trackGroupArray, fVar);
        }

        public void a(c cVar, long j2) {
            boolean unused = PlayerControlView.this.N = true;
            if (PlayerControlView.this.f16818m != null) {
                PlayerControlView.this.f16818m.setText(ad.a(PlayerControlView.this.f16820o, PlayerControlView.this.f16821p, j2));
            }
        }

        public void a(c cVar, long j2, boolean z2) {
            boolean unused = PlayerControlView.this.N = false;
            if (!z2 && PlayerControlView.this.G != null) {
                PlayerControlView playerControlView = PlayerControlView.this;
                playerControlView.b(playerControlView.G, j2);
            }
        }

        public /* synthetic */ void a(v vVar) {
            x.a.CC.$default$a((x.a) this, vVar);
        }

        public /* synthetic */ void a(boolean z2) {
            x.a.CC.$default$a((x.a) this, z2);
        }

        public void a(boolean z2, int i2) {
            PlayerControlView.this.f();
            PlayerControlView.this.k();
        }

        public /* synthetic */ void b() {
            x.a.CC.$default$b(this);
        }

        public /* synthetic */ void b(int i2) {
            x.a.CC.$default$b((x.a) this, i2);
        }

        public void b(c cVar, long j2) {
            if (PlayerControlView.this.f16818m != null) {
                PlayerControlView.this.f16818m.setText(ad.a(PlayerControlView.this.f16820o, PlayerControlView.this.f16821p, j2));
            }
        }

        public void b(boolean z2) {
            PlayerControlView.this.k();
        }

        public void c(int i2) {
            PlayerControlView.this.h();
            PlayerControlView.this.g();
        }

        public void c(boolean z2) {
            PlayerControlView.this.i();
            PlayerControlView.this.g();
        }

        public void d(int i2) {
            PlayerControlView.this.g();
            PlayerControlView.this.j();
        }

        public void onClick(View view) {
            x d2 = PlayerControlView.this.G;
            if (d2 != null) {
                if (PlayerControlView.this.f16809d == view) {
                    PlayerControlView.this.b(d2);
                } else if (PlayerControlView.this.f16808c == view) {
                    PlayerControlView.this.a(d2);
                } else if (PlayerControlView.this.f16812g == view) {
                    PlayerControlView.this.d(d2);
                } else if (PlayerControlView.this.f16813h == view) {
                    PlayerControlView.this.c(d2);
                } else if (PlayerControlView.this.f16810e == view) {
                    if (d2.k() == 1) {
                        if (PlayerControlView.this.J != null) {
                            PlayerControlView.this.J.a();
                        }
                    } else if (d2.k() == 4) {
                        boolean unused = PlayerControlView.this.a(d2, d2.t(), -9223372036854775807L);
                    }
                    PlayerControlView.this.H.a(d2, true);
                } else if (PlayerControlView.this.f16811f == view) {
                    PlayerControlView.this.H.a(d2, false);
                } else if (PlayerControlView.this.f16814i == view) {
                    PlayerControlView.this.H.a(d2, u.a(d2.o(), PlayerControlView.this.S));
                } else if (PlayerControlView.this.f16815j == view) {
                    PlayerControlView.this.H.b(d2, !d2.p());
                }
            }
        }
    }

    public interface b {
        void a(long j2, long j3);
    }

    public interface c {
        void a(int i2);
    }

    static {
        n.a("goog.exo.ui");
    }

    public PlayerControlView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PlayerControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerControlView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0192  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PlayerControlView(android.content.Context r4, android.util.AttributeSet r5, int r6, android.util.AttributeSet r7) {
        /*
            r3 = this;
            r3.<init>(r4, r5, r6)
            int r5 = com.google.android.exoplayer2.ui.R.layout.exo_player_control_view
            r6 = 5000(0x1388, float:7.006E-42)
            r3.O = r6
            r0 = 15000(0x3a98, float:2.102E-41)
            r3.P = r0
            r3.Q = r6
            r6 = 0
            r3.S = r6
            r0 = 200(0xc8, float:2.8E-43)
            r3.R = r0
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r3.U = r0
            r3.T = r6
            if (r7 == 0) goto L_0x0075
            android.content.res.Resources$Theme r0 = r4.getTheme()
            int[] r1 = com.google.android.exoplayer2.ui.R.styleable.PlayerControlView
            android.content.res.TypedArray r0 = r0.obtainStyledAttributes(r7, r1, r6, r6)
            int r1 = com.google.android.exoplayer2.ui.R.styleable.PlayerControlView_rewind_increment     // Catch:{ all -> 0x0070 }
            int r2 = r3.O     // Catch:{ all -> 0x0070 }
            int r1 = r0.getInt(r1, r2)     // Catch:{ all -> 0x0070 }
            r3.O = r1     // Catch:{ all -> 0x0070 }
            int r1 = com.google.android.exoplayer2.ui.R.styleable.PlayerControlView_fastforward_increment     // Catch:{ all -> 0x0070 }
            int r2 = r3.P     // Catch:{ all -> 0x0070 }
            int r1 = r0.getInt(r1, r2)     // Catch:{ all -> 0x0070 }
            r3.P = r1     // Catch:{ all -> 0x0070 }
            int r1 = com.google.android.exoplayer2.ui.R.styleable.PlayerControlView_show_timeout     // Catch:{ all -> 0x0070 }
            int r2 = r3.Q     // Catch:{ all -> 0x0070 }
            int r1 = r0.getInt(r1, r2)     // Catch:{ all -> 0x0070 }
            r3.Q = r1     // Catch:{ all -> 0x0070 }
            int r1 = com.google.android.exoplayer2.ui.R.styleable.PlayerControlView_controller_layout_id     // Catch:{ all -> 0x0070 }
            int r5 = r0.getResourceId(r1, r5)     // Catch:{ all -> 0x0070 }
            int r1 = r3.S     // Catch:{ all -> 0x0070 }
            int r1 = a((android.content.res.TypedArray) r0, (int) r1)     // Catch:{ all -> 0x0070 }
            r3.S = r1     // Catch:{ all -> 0x0070 }
            int r1 = com.google.android.exoplayer2.ui.R.styleable.PlayerControlView_show_shuffle_button     // Catch:{ all -> 0x0070 }
            boolean r2 = r3.T     // Catch:{ all -> 0x0070 }
            boolean r1 = r0.getBoolean(r1, r2)     // Catch:{ all -> 0x0070 }
            r3.T = r1     // Catch:{ all -> 0x0070 }
            int r1 = com.google.android.exoplayer2.ui.R.styleable.PlayerControlView_time_bar_min_update_interval     // Catch:{ all -> 0x0070 }
            int r2 = r3.R     // Catch:{ all -> 0x0070 }
            int r1 = r0.getInt(r1, r2)     // Catch:{ all -> 0x0070 }
            r3.setTimeBarMinUpdateInterval(r1)     // Catch:{ all -> 0x0070 }
            r0.recycle()
            goto L_0x0075
        L_0x0070:
            r4 = move-exception
            r0.recycle()
            throw r4
        L_0x0075:
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>()
            r3.f16807b = r0
            com.google.android.exoplayer2.af$a r0 = new com.google.android.exoplayer2.af$a
            r0.<init>()
            r3.f16822q = r0
            com.google.android.exoplayer2.af$b r0 = new com.google.android.exoplayer2.af$b
            r0.<init>()
            r3.f16823r = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r3.f16820o = r0
            java.util.Formatter r1 = new java.util.Formatter
            java.util.Locale r2 = java.util.Locale.getDefault()
            r1.<init>(r0, r2)
            r3.f16821p = r1
            long[] r0 = new long[r6]
            r3.V = r0
            boolean[] r0 = new boolean[r6]
            r3.W = r0
            long[] r0 = new long[r6]
            r3.f16804aa = r0
            boolean[] r0 = new boolean[r6]
            r3.f16805ab = r0
            com.google.android.exoplayer2.ui.PlayerControlView$a r0 = new com.google.android.exoplayer2.ui.PlayerControlView$a
            r1 = 0
            r0.<init>()
            r3.f16803a = r0
            com.google.android.exoplayer2.g r2 = new com.google.android.exoplayer2.g
            r2.<init>()
            r3.H = r2
            com.google.android.exoplayer2.ui.-$$Lambda$PlayerControlView$Z_IBx2WWvSVS6SUO7bHZvi77_1g r2 = new com.google.android.exoplayer2.ui.-$$Lambda$PlayerControlView$Z_IBx2WWvSVS6SUO7bHZvi77_1g
            r2.<init>()
            r3.f16824s = r2
            com.google.android.exoplayer2.ui.-$$Lambda$3-JPVCMjzOr_jY2Ib8V2AwePTmI r2 = new com.google.android.exoplayer2.ui.-$$Lambda$3-JPVCMjzOr_jY2Ib8V2AwePTmI
            r2.<init>()
            r3.f16825t = r2
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r4)
            r2.inflate(r5, r3)
            r5 = 262144(0x40000, float:3.67342E-40)
            r3.setDescendantFocusability(r5)
            int r5 = com.google.android.exoplayer2.ui.R.id.exo_progress
            android.view.View r5 = r3.findViewById(r5)
            com.google.android.exoplayer2.ui.c r5 = (com.google.android.exoplayer2.ui.c) r5
            int r2 = com.google.android.exoplayer2.ui.R.id.exo_progress_placeholder
            android.view.View r2 = r3.findViewById(r2)
            if (r5 == 0) goto L_0x00e8
        L_0x00e5:
            r3.f16819n = r5
            goto L_0x010e
        L_0x00e8:
            if (r2 == 0) goto L_0x010c
            com.google.android.exoplayer2.ui.DefaultTimeBar r5 = new com.google.android.exoplayer2.ui.DefaultTimeBar
            r5.<init>(r4, r1, r6, r7)
            int r7 = com.google.android.exoplayer2.ui.R.id.exo_progress
            r5.setId(r7)
            android.view.ViewGroup$LayoutParams r7 = r2.getLayoutParams()
            r5.setLayoutParams(r7)
            android.view.ViewParent r7 = r2.getParent()
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            int r1 = r7.indexOfChild(r2)
            r7.removeView(r2)
            r7.addView(r5, r1)
            goto L_0x00e5
        L_0x010c:
            r3.f16819n = r1
        L_0x010e:
            int r5 = com.google.android.exoplayer2.ui.R.id.exo_duration
            android.view.View r5 = r3.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.f16817l = r5
            int r5 = com.google.android.exoplayer2.ui.R.id.exo_position
            android.view.View r5 = r3.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.f16818m = r5
            com.google.android.exoplayer2.ui.c r5 = r3.f16819n
            if (r5 == 0) goto L_0x0129
            r5.a(r0)
        L_0x0129:
            int r5 = com.google.android.exoplayer2.ui.R.id.exo_play
            android.view.View r5 = r3.findViewById(r5)
            r3.f16810e = r5
            if (r5 == 0) goto L_0x0136
            r5.setOnClickListener(r0)
        L_0x0136:
            int r5 = com.google.android.exoplayer2.ui.R.id.exo_pause
            android.view.View r5 = r3.findViewById(r5)
            r3.f16811f = r5
            if (r5 == 0) goto L_0x0143
            r5.setOnClickListener(r0)
        L_0x0143:
            int r5 = com.google.android.exoplayer2.ui.R.id.exo_prev
            android.view.View r5 = r3.findViewById(r5)
            r3.f16808c = r5
            if (r5 == 0) goto L_0x0150
            r5.setOnClickListener(r0)
        L_0x0150:
            int r5 = com.google.android.exoplayer2.ui.R.id.exo_next
            android.view.View r5 = r3.findViewById(r5)
            r3.f16809d = r5
            if (r5 == 0) goto L_0x015d
            r5.setOnClickListener(r0)
        L_0x015d:
            int r5 = com.google.android.exoplayer2.ui.R.id.exo_rew
            android.view.View r5 = r3.findViewById(r5)
            r3.f16813h = r5
            if (r5 == 0) goto L_0x016a
            r5.setOnClickListener(r0)
        L_0x016a:
            int r5 = com.google.android.exoplayer2.ui.R.id.exo_ffwd
            android.view.View r5 = r3.findViewById(r5)
            r3.f16812g = r5
            if (r5 == 0) goto L_0x0177
            r5.setOnClickListener(r0)
        L_0x0177:
            int r5 = com.google.android.exoplayer2.ui.R.id.exo_repeat_toggle
            android.view.View r5 = r3.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r3.f16814i = r5
            if (r5 == 0) goto L_0x0186
            r5.setOnClickListener(r0)
        L_0x0186:
            int r5 = com.google.android.exoplayer2.ui.R.id.exo_shuffle
            android.view.View r5 = r3.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r3.f16815j = r5
            if (r5 == 0) goto L_0x0195
            r5.setOnClickListener(r0)
        L_0x0195:
            int r5 = com.google.android.exoplayer2.ui.R.id.exo_vr
            android.view.View r5 = r3.findViewById(r5)
            r3.f16816k = r5
            r3.setShowVrButton(r6)
            android.content.res.Resources r4 = r4.getResources()
            int r5 = com.google.android.exoplayer2.ui.R.integer.exo_media_button_opacity_percentage_enabled
            int r5 = r4.getInteger(r5)
            float r5 = (float) r5
            r6 = 1120403456(0x42c80000, float:100.0)
            float r5 = r5 / r6
            r3.C = r5
            int r5 = com.google.android.exoplayer2.ui.R.integer.exo_media_button_opacity_percentage_disabled
            int r5 = r4.getInteger(r5)
            float r5 = (float) r5
            float r5 = r5 / r6
            r3.D = r5
            int r5 = com.google.android.exoplayer2.ui.R.drawable.exo_controls_repeat_off
            android.graphics.drawable.Drawable r5 = r4.getDrawable(r5)
            r3.f16826u = r5
            int r5 = com.google.android.exoplayer2.ui.R.drawable.exo_controls_repeat_one
            android.graphics.drawable.Drawable r5 = r4.getDrawable(r5)
            r3.f16827v = r5
            int r5 = com.google.android.exoplayer2.ui.R.drawable.exo_controls_repeat_all
            android.graphics.drawable.Drawable r5 = r4.getDrawable(r5)
            r3.f16828w = r5
            int r5 = com.google.android.exoplayer2.ui.R.drawable.exo_controls_shuffle_on
            android.graphics.drawable.Drawable r5 = r4.getDrawable(r5)
            r3.A = r5
            int r5 = com.google.android.exoplayer2.ui.R.drawable.exo_controls_shuffle_off
            android.graphics.drawable.Drawable r5 = r4.getDrawable(r5)
            r3.B = r5
            int r5 = com.google.android.exoplayer2.ui.R.string.exo_controls_repeat_off_description
            java.lang.String r5 = r4.getString(r5)
            r3.f16829x = r5
            int r5 = com.google.android.exoplayer2.ui.R.string.exo_controls_repeat_one_description
            java.lang.String r5 = r4.getString(r5)
            r3.f16830y = r5
            int r5 = com.google.android.exoplayer2.ui.R.string.exo_controls_repeat_all_description
            java.lang.String r5 = r4.getString(r5)
            r3.f16831z = r5
            int r5 = com.google.android.exoplayer2.ui.R.string.exo_controls_shuffle_on_description
            java.lang.String r5 = r4.getString(r5)
            r3.E = r5
            int r5 = com.google.android.exoplayer2.ui.R.string.exo_controls_shuffle_off_description
            java.lang.String r4 = r4.getString(r5)
            r3.F = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.PlayerControlView.<init>(android.content.Context, android.util.AttributeSet, int, android.util.AttributeSet):void");
    }

    private static int a(TypedArray typedArray, int i2) {
        return typedArray.getInt(R.styleable.PlayerControlView_repeat_toggle_modes, i2);
    }

    /* access modifiers changed from: private */
    public void a(x xVar) {
        af E2 = xVar.E();
        if (!E2.a() && !xVar.x()) {
            int t2 = xVar.t();
            E2.a(t2, this.f16823r);
            int e2 = xVar.e();
            if (e2 == -1 || (xVar.v() > 3000 && (!this.f16823r.f15179h || this.f16823r.f15178g))) {
                a(xVar, t2, 0);
            } else {
                a(xVar, e2, -9223372036854775807L);
            }
        }
    }

    private void a(x xVar, long j2) {
        long v2 = xVar.v() + j2;
        long u2 = xVar.u();
        if (u2 != -9223372036854775807L) {
            v2 = Math.min(v2, u2);
        }
        a(xVar, xVar.t(), Math.max(v2, 0));
    }

    private void a(boolean z2, View view) {
        if (view != null) {
            view.setEnabled(z2);
            view.setAlpha(z2 ? this.C : this.D);
            view.setVisibility(0);
        }
    }

    private static boolean a(int i2) {
        return i2 == 90 || i2 == 89 || i2 == 85 || i2 == 126 || i2 == 127 || i2 == 87 || i2 == 88;
    }

    private static boolean a(af afVar, af.b bVar) {
        if (afVar.b() > 100) {
            return false;
        }
        int b2 = afVar.b();
        for (int i2 = 0; i2 < b2; i2++) {
            if (afVar.a(i2, bVar).f15184m == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean a(x xVar, int i2, long j2) {
        return this.H.a(xVar, i2, j2);
    }

    /* access modifiers changed from: private */
    public void b(x xVar) {
        af E2 = xVar.E();
        if (!E2.a() && !xVar.x()) {
            int t2 = xVar.t();
            int d2 = xVar.d();
            if (d2 != -1) {
                a(xVar, d2, -9223372036854775807L);
            } else if (E2.a(t2, this.f16823r).f15179h) {
                a(xVar, t2, -9223372036854775807L);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(x xVar, long j2) {
        int i2;
        af E2 = xVar.E();
        if (this.M && !E2.a()) {
            int b2 = E2.b();
            i2 = 0;
            while (true) {
                long c2 = E2.a(i2, this.f16823r).c();
                if (j2 < c2) {
                    break;
                } else if (i2 == b2 - 1) {
                    j2 = c2;
                    break;
                } else {
                    j2 -= c2;
                    i2++;
                }
            }
        } else {
            i2 = xVar.t();
        }
        if (!a(xVar, i2, j2)) {
            k();
        }
    }

    /* access modifiers changed from: private */
    public void c(x xVar) {
        int i2;
        if (xVar.f() && (i2 = this.O) > 0) {
            a(xVar, (long) (-i2));
        }
    }

    private void d() {
        removeCallbacks(this.f16825t);
        if (this.Q > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i2 = this.Q;
            this.U = uptimeMillis + ((long) i2);
            if (this.K) {
                postDelayed(this.f16825t, (long) i2);
                return;
            }
            return;
        }
        this.U = -9223372036854775807L;
    }

    /* access modifiers changed from: private */
    public void d(x xVar) {
        int i2;
        if (xVar.f() && (i2 = this.P) > 0) {
            a(xVar, (long) i2);
        }
    }

    private void e() {
        f();
        g();
        h();
        i();
        j();
    }

    /* access modifiers changed from: private */
    public void f() {
        boolean z2;
        if (c() && this.K) {
            boolean m2 = m();
            View view = this.f16810e;
            int i2 = 8;
            boolean z3 = true;
            if (view != null) {
                z2 = (m2 && view.isFocused()) | false;
                this.f16810e.setVisibility(m2 ? 8 : 0);
            } else {
                z2 = false;
            }
            View view2 = this.f16811f;
            if (view2 != null) {
                if (m2 || !view2.isFocused()) {
                    z3 = false;
                }
                z2 |= z3;
                View view3 = this.f16811f;
                if (m2) {
                    i2 = 0;
                }
                view3.setVisibility(i2);
            }
            if (z2) {
                l();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g() {
        /*
            r8 = this;
            boolean r0 = r8.c()
            if (r0 == 0) goto L_0x0082
            boolean r0 = r8.K
            if (r0 != 0) goto L_0x000c
            goto L_0x0082
        L_0x000c:
            com.google.android.exoplayer2.x r0 = r8.G
            r1 = 0
            if (r0 == 0) goto L_0x0063
            com.google.android.exoplayer2.af r2 = r0.E()
            boolean r3 = r2.a()
            if (r3 != 0) goto L_0x0063
            boolean r3 = r0.x()
            if (r3 != 0) goto L_0x0063
            int r3 = r0.t()
            com.google.android.exoplayer2.af$b r4 = r8.f16823r
            r2.a((int) r3, (com.google.android.exoplayer2.af.b) r4)
            com.google.android.exoplayer2.af$b r2 = r8.f16823r
            boolean r2 = r2.f15178g
            r3 = 1
            if (r2 != 0) goto L_0x0040
            com.google.android.exoplayer2.af$b r4 = r8.f16823r
            boolean r4 = r4.f15179h
            if (r4 == 0) goto L_0x0040
            boolean r4 = r0.b()
            if (r4 == 0) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r4 = 0
            goto L_0x0041
        L_0x0040:
            r4 = 1
        L_0x0041:
            if (r2 == 0) goto L_0x0049
            int r5 = r8.O
            if (r5 <= 0) goto L_0x0049
            r5 = 1
            goto L_0x004a
        L_0x0049:
            r5 = 0
        L_0x004a:
            if (r2 == 0) goto L_0x0052
            int r6 = r8.P
            if (r6 <= 0) goto L_0x0052
            r6 = 1
            goto L_0x0053
        L_0x0052:
            r6 = 0
        L_0x0053:
            com.google.android.exoplayer2.af$b r7 = r8.f16823r
            boolean r7 = r7.f15179h
            if (r7 != 0) goto L_0x005f
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0060
        L_0x005f:
            r1 = 1
        L_0x0060:
            r0 = r1
            r1 = r4
            goto L_0x0067
        L_0x0063:
            r0 = 0
            r2 = 0
            r5 = 0
            r6 = 0
        L_0x0067:
            android.view.View r3 = r8.f16808c
            r8.a((boolean) r1, (android.view.View) r3)
            android.view.View r1 = r8.f16813h
            r8.a((boolean) r5, (android.view.View) r1)
            android.view.View r1 = r8.f16812g
            r8.a((boolean) r6, (android.view.View) r1)
            android.view.View r1 = r8.f16809d
            r8.a((boolean) r0, (android.view.View) r1)
            com.google.android.exoplayer2.ui.c r0 = r8.f16819n
            if (r0 == 0) goto L_0x0082
            r0.setEnabled(r2)
        L_0x0082:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.PlayerControlView.g():void");
    }

    /* access modifiers changed from: private */
    public void h() {
        ImageView imageView;
        String str;
        ImageView imageView2;
        if (c() && this.K && (imageView = this.f16814i) != null) {
            if (this.S == 0) {
                imageView.setVisibility(8);
                return;
            }
            x xVar = this.G;
            if (xVar == null) {
                a(false, (View) imageView);
                this.f16814i.setImageDrawable(this.f16826u);
                this.f16814i.setContentDescription(this.f16829x);
                return;
            }
            a(true, (View) imageView);
            int o2 = xVar.o();
            if (o2 == 0) {
                this.f16814i.setImageDrawable(this.f16826u);
                imageView2 = this.f16814i;
                str = this.f16829x;
            } else if (o2 != 1) {
                if (o2 == 2) {
                    this.f16814i.setImageDrawable(this.f16828w);
                    imageView2 = this.f16814i;
                    str = this.f16831z;
                }
                this.f16814i.setVisibility(0);
            } else {
                this.f16814i.setImageDrawable(this.f16827v);
                imageView2 = this.f16814i;
                str = this.f16830y;
            }
            imageView2.setContentDescription(str);
            this.f16814i.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        ImageView imageView;
        ImageView imageView2;
        String str;
        if (c() && this.K && (imageView = this.f16815j) != null) {
            x xVar = this.G;
            if (!this.T) {
                imageView.setVisibility(8);
                return;
            }
            if (xVar == null) {
                a(false, (View) imageView);
                this.f16815j.setImageDrawable(this.B);
                imageView2 = this.f16815j;
            } else {
                a(true, (View) imageView);
                this.f16815j.setImageDrawable(xVar.p() ? this.A : this.B);
                imageView2 = this.f16815j;
                if (xVar.p()) {
                    str = this.E;
                    imageView2.setContentDescription(str);
                }
            }
            str = this.F;
            imageView2.setContentDescription(str);
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        int i2;
        long j2;
        x xVar = this.G;
        if (xVar != null) {
            boolean z2 = true;
            this.M = this.L && a(xVar.E(), this.f16823r);
            this.f16806ac = 0;
            af E2 = xVar.E();
            if (!E2.a()) {
                int t2 = xVar.t();
                boolean z3 = this.M;
                int i3 = z3 ? 0 : t2;
                int b2 = z3 ? E2.b() - 1 : t2;
                long j3 = 0;
                i2 = 0;
                while (true) {
                    if (i3 > b2) {
                        break;
                    }
                    if (i3 == t2) {
                        this.f16806ac = e.a(j3);
                    }
                    E2.a(i3, this.f16823r);
                    if (this.f16823r.f15184m == -9223372036854775807L) {
                        com.google.android.exoplayer2.util.a.b(this.M ^ z2);
                        break;
                    }
                    for (int i4 = this.f16823r.f15181j; i4 <= this.f16823r.f15182k; i4++) {
                        E2.a(i4, this.f16822q);
                        int d2 = this.f16822q.d();
                        for (int i5 = 0; i5 < d2; i5++) {
                            long a2 = this.f16822q.a(i5);
                            if (a2 == Long.MIN_VALUE) {
                                if (this.f16822q.f15169d == -9223372036854775807L) {
                                } else {
                                    a2 = this.f16822q.f15169d;
                                }
                            }
                            long c2 = a2 + this.f16822q.c();
                            if (c2 >= 0) {
                                long[] jArr = this.V;
                                if (i2 == jArr.length) {
                                    int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                    this.V = Arrays.copyOf(jArr, length);
                                    this.W = Arrays.copyOf(this.W, length);
                                }
                                this.V[i2] = e.a(j3 + c2);
                                this.W[i2] = this.f16822q.c(i5);
                                i2++;
                            }
                        }
                    }
                    j3 += this.f16823r.f15184m;
                    i3++;
                    z2 = true;
                }
                j2 = j3;
            } else {
                j2 = 0;
                i2 = 0;
            }
            long a3 = e.a(j2);
            TextView textView = this.f16817l;
            if (textView != null) {
                textView.setText(ad.a(this.f16820o, this.f16821p, a3));
            }
            c cVar = this.f16819n;
            if (cVar != null) {
                cVar.setDuration(a3);
                int length2 = this.f16804aa.length;
                int i6 = i2 + length2;
                long[] jArr2 = this.V;
                if (i6 > jArr2.length) {
                    this.V = Arrays.copyOf(jArr2, i6);
                    this.W = Arrays.copyOf(this.W, i6);
                }
                System.arraycopy(this.f16804aa, 0, this.V, i2, length2);
                System.arraycopy(this.f16805ab, 0, this.W, i2, length2);
                this.f16819n.a(this.V, this.W, i6);
            }
            k();
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        long j2;
        if (c() && this.K) {
            x xVar = this.G;
            long j3 = 0;
            if (xVar != null) {
                j3 = this.f16806ac + xVar.A();
                j2 = this.f16806ac + xVar.B();
            } else {
                j2 = 0;
            }
            TextView textView = this.f16818m;
            if (textView != null && !this.N) {
                textView.setText(ad.a(this.f16820o, this.f16821p, j3));
            }
            c cVar = this.f16819n;
            if (cVar != null) {
                cVar.setPosition(j3);
                this.f16819n.setBufferedPosition(j2);
            }
            b bVar = this.I;
            if (bVar != null) {
                bVar.a(j3, j2);
            }
            removeCallbacks(this.f16824s);
            int k2 = xVar == null ? 1 : xVar.k();
            long j4 = 1000;
            if (xVar != null && xVar.a()) {
                c cVar2 = this.f16819n;
                long min = Math.min(cVar2 != null ? cVar2.getPreferredUpdateDelay() : 1000, 1000 - (j3 % 1000));
                float f2 = xVar.q().f17192b;
                if (f2 > 0.0f) {
                    j4 = (long) (((float) min) / f2);
                }
                postDelayed(this.f16824s, ad.a(j4, (long) this.R, 1000));
            } else if (k2 != 4 && k2 != 1) {
                postDelayed(this.f16824s, 1000);
            }
        }
    }

    private void l() {
        View view;
        View view2;
        boolean m2 = m();
        if (!m2 && (view2 = this.f16810e) != null) {
            view2.requestFocus();
        } else if (m2 && (view = this.f16811f) != null) {
            view.requestFocus();
        }
    }

    private boolean m() {
        x xVar = this.G;
        return (xVar == null || xVar.k() == 4 || this.G.k() == 1 || !this.G.n()) ? false : true;
    }

    public void a() {
        if (!c()) {
            setVisibility(0);
            Iterator<c> it2 = this.f16807b.iterator();
            while (it2.hasNext()) {
                it2.next().a(getVisibility());
            }
            e();
            l();
        }
        d();
    }

    public void a(c cVar) {
        this.f16807b.add(cVar);
    }

    public void a(long[] jArr, boolean[] zArr) {
        boolean z2 = false;
        if (jArr == null) {
            this.f16804aa = new long[0];
            this.f16805ab = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) com.google.android.exoplayer2.util.a.b(zArr);
            if (jArr.length == zArr2.length) {
                z2 = true;
            }
            com.google.android.exoplayer2.util.a.a(z2);
            this.f16804aa = jArr;
            this.f16805ab = zArr2;
        }
        j();
    }

    public boolean a(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        x xVar = this.G;
        if (xVar == null || !a(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() == 0) {
            if (keyCode == 90) {
                d(xVar);
            } else if (keyCode == 89) {
                c(xVar);
            } else if (keyEvent.getRepeatCount() == 0) {
                if (keyCode == 85) {
                    this.H.a(xVar, !xVar.n());
                } else if (keyCode == 87) {
                    b(xVar);
                } else if (keyCode == 88) {
                    a(xVar);
                } else if (keyCode == 126) {
                    this.H.a(xVar, true);
                } else if (keyCode == 127) {
                    this.H.a(xVar, false);
                }
            }
        }
        return true;
    }

    public void b() {
        if (c()) {
            setVisibility(8);
            Iterator<c> it2 = this.f16807b.iterator();
            while (it2.hasNext()) {
                it2.next().a(getVisibility());
            }
            removeCallbacks(this.f16824s);
            removeCallbacks(this.f16825t);
            this.U = -9223372036854775807L;
        }
    }

    public void b(c cVar) {
        this.f16807b.remove(cVar);
    }

    public boolean c() {
        return getVisibility() == 0;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.f16825t);
        } else if (motionEvent.getAction() == 1) {
            d();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public x getPlayer() {
        return this.G;
    }

    public int getRepeatToggleModes() {
        return this.S;
    }

    public boolean getShowShuffleButton() {
        return this.T;
    }

    public int getShowTimeoutMs() {
        return this.Q;
    }

    public boolean getShowVrButton() {
        View view = this.f16816k;
        return view != null && view.getVisibility() == 0;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.K = true;
        long j2 = this.U;
        if (j2 != -9223372036854775807L) {
            long uptimeMillis = j2 - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                b();
            } else {
                postDelayed(this.f16825t, uptimeMillis);
            }
        } else if (c()) {
            d();
        }
        e();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.K = false;
        removeCallbacks(this.f16824s);
        removeCallbacks(this.f16825t);
    }

    public void setControlDispatcher(f fVar) {
        if (fVar == null) {
            fVar = new g();
        }
        this.H = fVar;
    }

    public void setFastForwardIncrementMs(int i2) {
        this.P = i2;
        g();
    }

    public void setPlaybackPreparer(w wVar) {
        this.J = wVar;
    }

    public void setPlayer(x xVar) {
        boolean z2 = true;
        com.google.android.exoplayer2.util.a.b(Looper.myLooper() == Looper.getMainLooper());
        if (!(xVar == null || xVar.j() == Looper.getMainLooper())) {
            z2 = false;
        }
        com.google.android.exoplayer2.util.a.a(z2);
        x xVar2 = this.G;
        if (xVar2 != xVar) {
            if (xVar2 != null) {
                xVar2.b((x.a) this.f16803a);
            }
            this.G = xVar;
            if (xVar != null) {
                xVar.a((x.a) this.f16803a);
            }
            e();
        }
    }

    public void setProgressUpdateListener(b bVar) {
        this.I = bVar;
    }

    public void setRepeatToggleModes(int i2) {
        int i3;
        f fVar;
        x xVar;
        this.S = i2;
        x xVar2 = this.G;
        if (xVar2 != null) {
            int o2 = xVar2.o();
            if (i2 != 0 || o2 == 0) {
                i3 = 2;
                if (i2 == 1 && o2 == 2) {
                    this.H.a(this.G, 1);
                } else if (i2 == 2 && o2 == 1) {
                    fVar = this.H;
                    xVar = this.G;
                }
            } else {
                fVar = this.H;
                xVar = this.G;
                i3 = 0;
            }
            fVar.a(xVar, i3);
        }
        h();
    }

    public void setRewindIncrementMs(int i2) {
        this.O = i2;
        g();
    }

    public void setShowMultiWindowTimeBar(boolean z2) {
        this.L = z2;
        j();
    }

    public void setShowShuffleButton(boolean z2) {
        this.T = z2;
        i();
    }

    public void setShowTimeoutMs(int i2) {
        this.Q = i2;
        if (c()) {
            d();
        }
    }

    public void setShowVrButton(boolean z2) {
        View view = this.f16816k;
        if (view != null) {
            view.setVisibility(z2 ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i2) {
        this.R = ad.a(i2, 16, 1000);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.f16816k;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
