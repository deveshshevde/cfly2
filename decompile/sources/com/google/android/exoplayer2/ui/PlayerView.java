package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.b;
import com.google.android.exoplayer2.text.j;
import com.google.android.exoplayer2.trackselection.e;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView;
import com.google.android.exoplayer2.ui.spherical.d;
import com.google.android.exoplayer2.util.f;
import com.google.android.exoplayer2.v;
import com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView;
import com.google.android.exoplayer2.video.i;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.x;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class PlayerView extends FrameLayout {
    private static final int PICTURE_TYPE_FRONT_COVER = 3;
    private static final int PICTURE_TYPE_NOT_SET = -1;
    public static final int SHOW_BUFFERING_ALWAYS = 2;
    public static final int SHOW_BUFFERING_NEVER = 0;
    public static final int SHOW_BUFFERING_WHEN_PLAYING = 1;
    private static final int SURFACE_TYPE_NONE = 0;
    private static final int SURFACE_TYPE_SPHERICAL_GL_SURFACE_VIEW = 3;
    private static final int SURFACE_TYPE_SURFACE_VIEW = 1;
    private static final int SURFACE_TYPE_TEXTURE_VIEW = 2;
    private static final int SURFACE_TYPE_VIDEO_DECODER_GL_SURFACE_VIEW = 4;
    private final FrameLayout adOverlayFrameLayout;
    private final ImageView artworkView;
    private final View bufferingView;
    private final a componentListener;
    /* access modifiers changed from: private */
    public final AspectRatioFrameLayout contentFrame;
    private final PlayerControlView controller;
    private boolean controllerAutoShow;
    /* access modifiers changed from: private */
    public boolean controllerHideDuringAds;
    private boolean controllerHideOnTouch;
    private int controllerShowTimeoutMs;
    private PlayerControlView.c controllerVisibilityListener;
    private CharSequence customErrorMessage;
    private Drawable defaultArtwork;
    private f<? super ExoPlaybackException> errorMessageProvider;
    private final TextView errorMessageView;
    private boolean isTouching;
    private boolean keepContentOnPlayerReset;
    private final FrameLayout overlayFrameLayout;
    /* access modifiers changed from: private */
    public x player;
    private int showBuffering;
    /* access modifiers changed from: private */
    public final View shutterView;
    /* access modifiers changed from: private */
    public final SubtitleView subtitleView;
    /* access modifiers changed from: private */
    public final View surfaceView;
    /* access modifiers changed from: private */
    public int textureViewRotation;
    private boolean useArtwork;
    private boolean useController;
    private boolean useSensorRotation;

    private final class a implements View.OnLayoutChangeListener, j, PlayerControlView.c, d, i, x.a {

        /* renamed from: b  reason: collision with root package name */
        private final af.a f16834b = new af.a();

        /* renamed from: c  reason: collision with root package name */
        private Object f16835c;

        public a() {
        }

        public void a(int i2) {
            PlayerView.this.updateContentDescription();
        }

        public /* synthetic */ void a(int i2, int i3) {
            i.CC.$default$a(this, i2, i3);
        }

        public void a(int i2, int i3, int i4, float f2) {
            float f3 = (i3 == 0 || i2 == 0) ? 1.0f : (((float) i2) * f2) / ((float) i3);
            if (PlayerView.this.surfaceView instanceof TextureView) {
                if (i4 == 90 || i4 == 270) {
                    f3 = 1.0f / f3;
                }
                if (PlayerView.this.textureViewRotation != 0) {
                    PlayerView.this.surfaceView.removeOnLayoutChangeListener(this);
                }
                int unused = PlayerView.this.textureViewRotation = i4;
                if (PlayerView.this.textureViewRotation != 0) {
                    PlayerView.this.surfaceView.addOnLayoutChangeListener(this);
                }
                PlayerView.applyTextureViewRotation((TextureView) PlayerView.this.surfaceView, PlayerView.this.textureViewRotation);
            }
            PlayerView playerView = PlayerView.this;
            playerView.onContentAspectRatioChanged(f3, playerView.contentFrame, PlayerView.this.surfaceView);
        }

        public /* synthetic */ void a(ExoPlaybackException exoPlaybackException) {
            x.a.CC.$default$a((x.a) this, exoPlaybackException);
        }

        public /* synthetic */ void a(af afVar, int i2) {
            x.a.CC.$default$a((x.a) this, afVar, i2);
        }

        public /* synthetic */ void a(af afVar, Object obj, int i2) {
            x.a.CC.$default$a(this, afVar, obj, i2);
        }

        public void a(TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.f fVar) {
            x xVar = (x) com.google.android.exoplayer2.util.a.b(PlayerView.this.player);
            af E = xVar.E();
            if (!E.a()) {
                if (!xVar.C().a()) {
                    this.f16835c = E.a(xVar.s(), this.f16834b, true).f15167b;
                } else {
                    Object obj = this.f16835c;
                    if (obj != null) {
                        int a2 = E.a(obj);
                        if (a2 != -1 && xVar.t() == E.a(a2, this.f16834b).f15168c) {
                            return;
                        }
                    }
                }
                PlayerView.this.updateForCurrentTrackSelections(false);
            }
            this.f16835c = null;
            PlayerView.this.updateForCurrentTrackSelections(false);
        }

        public /* synthetic */ void a(v vVar) {
            x.a.CC.$default$a((x.a) this, vVar);
        }

        public void a(List<b> list) {
            if (PlayerView.this.subtitleView != null) {
                PlayerView.this.subtitleView.a(list);
            }
        }

        public /* synthetic */ void a(boolean z2) {
            x.a.CC.$default$a((x.a) this, z2);
        }

        public void a(boolean z2, int i2) {
            PlayerView.this.updateBuffering();
            PlayerView.this.updateErrorMessage();
            if (!PlayerView.this.isPlayingAd() || !PlayerView.this.controllerHideDuringAds) {
                PlayerView.this.maybeShowController(false);
            } else {
                PlayerView.this.hideController();
            }
        }

        public boolean a(MotionEvent motionEvent) {
            return PlayerView.this.toggleControllerVisibility();
        }

        public /* synthetic */ void b() {
            x.a.CC.$default$b(this);
        }

        public /* synthetic */ void b(int i2) {
            x.a.CC.$default$b((x.a) this, i2);
        }

        public /* synthetic */ void b(boolean z2) {
            x.a.CC.$default$b((x.a) this, z2);
        }

        public /* synthetic */ void c(int i2) {
            x.a.CC.$default$c((x.a) this, i2);
        }

        public /* synthetic */ void c(boolean z2) {
            x.a.CC.$default$c((x.a) this, z2);
        }

        public void d() {
            if (PlayerView.this.shutterView != null) {
                PlayerView.this.shutterView.setVisibility(4);
            }
        }

        public void d(int i2) {
            if (PlayerView.this.isPlayingAd() && PlayerView.this.controllerHideDuringAds) {
                PlayerView.this.hideController();
            }
        }

        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            PlayerView.applyTextureViewRotation((TextureView) view, PlayerView.this.textureViewRotation);
        }
    }

    public PlayerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: android.view.TextureView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: android.view.TextureView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: android.view.TextureView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: android.view.SurfaceView} */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PlayerView(android.content.Context r21, android.util.AttributeSet r22, int r23) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            r20.<init>(r21, r22, r23)
            com.google.android.exoplayer2.ui.PlayerView$a r3 = new com.google.android.exoplayer2.ui.PlayerView$a
            r3.<init>()
            r1.componentListener = r3
            boolean r4 = r20.isInEditMode()
            r5 = 0
            if (r4 == 0) goto L_0x0049
            r1.contentFrame = r5
            r1.shutterView = r5
            r1.surfaceView = r5
            r1.artworkView = r5
            r1.subtitleView = r5
            r1.bufferingView = r5
            r1.errorMessageView = r5
            r1.controller = r5
            r1.adOverlayFrameLayout = r5
            r1.overlayFrameLayout = r5
            android.widget.ImageView r2 = new android.widget.ImageView
            r2.<init>(r0)
            int r0 = com.google.android.exoplayer2.util.ad.f11755a
            r3 = 23
            if (r0 < r3) goto L_0x003e
            android.content.res.Resources r0 = r20.getResources()
            configureEditModeLogoV23(r0, r2)
            goto L_0x0045
        L_0x003e:
            android.content.res.Resources r0 = r20.getResources()
            configureEditModeLogo(r0, r2)
        L_0x0045:
            r1.addView(r2)
            return
        L_0x0049:
            int r4 = com.google.android.exoplayer2.ui.R.layout.exo_player_view
            r6 = 5000(0x1388, float:7.006E-42)
            r7 = 1
            r1.useSensorRotation = r7
            r8 = 0
            if (r2 == 0) goto L_0x00e4
            android.content.res.Resources$Theme r9 = r21.getTheme()
            int[] r10 = com.google.android.exoplayer2.ui.R.styleable.PlayerView
            android.content.res.TypedArray r9 = r9.obtainStyledAttributes(r2, r10, r8, r8)
            int r10 = com.google.android.exoplayer2.ui.R.styleable.PlayerView_shutter_background_color     // Catch:{ all -> 0x00df }
            boolean r10 = r9.hasValue(r10)     // Catch:{ all -> 0x00df }
            int r11 = com.google.android.exoplayer2.ui.R.styleable.PlayerView_shutter_background_color     // Catch:{ all -> 0x00df }
            int r11 = r9.getColor(r11, r8)     // Catch:{ all -> 0x00df }
            int r12 = com.google.android.exoplayer2.ui.R.styleable.PlayerView_player_layout_id     // Catch:{ all -> 0x00df }
            int r4 = r9.getResourceId(r12, r4)     // Catch:{ all -> 0x00df }
            int r12 = com.google.android.exoplayer2.ui.R.styleable.PlayerView_use_artwork     // Catch:{ all -> 0x00df }
            boolean r12 = r9.getBoolean(r12, r7)     // Catch:{ all -> 0x00df }
            int r13 = com.google.android.exoplayer2.ui.R.styleable.PlayerView_default_artwork     // Catch:{ all -> 0x00df }
            int r13 = r9.getResourceId(r13, r8)     // Catch:{ all -> 0x00df }
            int r14 = com.google.android.exoplayer2.ui.R.styleable.PlayerView_use_controller     // Catch:{ all -> 0x00df }
            boolean r14 = r9.getBoolean(r14, r7)     // Catch:{ all -> 0x00df }
            int r15 = com.google.android.exoplayer2.ui.R.styleable.PlayerView_surface_type     // Catch:{ all -> 0x00df }
            int r15 = r9.getInt(r15, r7)     // Catch:{ all -> 0x00df }
            int r5 = com.google.android.exoplayer2.ui.R.styleable.PlayerView_resize_mode     // Catch:{ all -> 0x00df }
            int r5 = r9.getInt(r5, r8)     // Catch:{ all -> 0x00df }
            int r8 = com.google.android.exoplayer2.ui.R.styleable.PlayerView_show_timeout     // Catch:{ all -> 0x00df }
            int r6 = r9.getInt(r8, r6)     // Catch:{ all -> 0x00df }
            int r8 = com.google.android.exoplayer2.ui.R.styleable.PlayerView_hide_on_touch     // Catch:{ all -> 0x00df }
            boolean r8 = r9.getBoolean(r8, r7)     // Catch:{ all -> 0x00df }
            r16 = r4
            int r4 = com.google.android.exoplayer2.ui.R.styleable.PlayerView_auto_show     // Catch:{ all -> 0x00df }
            boolean r4 = r9.getBoolean(r4, r7)     // Catch:{ all -> 0x00df }
            int r7 = com.google.android.exoplayer2.ui.R.styleable.PlayerView_show_buffering     // Catch:{ all -> 0x00df }
            r17 = r4
            r4 = 0
            int r7 = r9.getInteger(r7, r4)     // Catch:{ all -> 0x00df }
            int r4 = com.google.android.exoplayer2.ui.R.styleable.PlayerView_keep_content_on_player_reset     // Catch:{ all -> 0x00df }
            r18 = r5
            boolean r5 = r1.keepContentOnPlayerReset     // Catch:{ all -> 0x00df }
            boolean r4 = r9.getBoolean(r4, r5)     // Catch:{ all -> 0x00df }
            r1.keepContentOnPlayerReset = r4     // Catch:{ all -> 0x00df }
            int r4 = com.google.android.exoplayer2.ui.R.styleable.PlayerView_hide_during_ads     // Catch:{ all -> 0x00df }
            r5 = 1
            boolean r4 = r9.getBoolean(r4, r5)     // Catch:{ all -> 0x00df }
            int r5 = com.google.android.exoplayer2.ui.R.styleable.PlayerView_use_sensor_rotation     // Catch:{ all -> 0x00df }
            r19 = r4
            boolean r4 = r1.useSensorRotation     // Catch:{ all -> 0x00df }
            boolean r4 = r9.getBoolean(r5, r4)     // Catch:{ all -> 0x00df }
            r1.useSensorRotation = r4     // Catch:{ all -> 0x00df }
            r9.recycle()
            r9 = r15
            r4 = r16
            r5 = r17
            r16 = r6
            r17 = r14
            r6 = r19
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r8
            r8 = r18
            goto L_0x00f2
        L_0x00df:
            r0 = move-exception
            r9.recycle()
            throw r0
        L_0x00e4:
            r5 = 1
            r6 = 1
            r7 = 0
            r8 = 0
            r9 = 1
            r10 = 1
            r11 = 0
            r12 = 0
            r13 = 1
            r14 = 0
            r16 = 5000(0x1388, float:7.006E-42)
            r17 = 1
        L_0x00f2:
            android.view.LayoutInflater r15 = android.view.LayoutInflater.from(r21)
            r15.inflate(r4, r1)
            r4 = 262144(0x40000, float:3.67342E-40)
            r1.setDescendantFocusability(r4)
            int r4 = com.google.android.exoplayer2.ui.R.id.exo_content_frame
            android.view.View r4 = r1.findViewById(r4)
            com.google.android.exoplayer2.ui.AspectRatioFrameLayout r4 = (com.google.android.exoplayer2.ui.AspectRatioFrameLayout) r4
            r1.contentFrame = r4
            if (r4 == 0) goto L_0x010d
            setResizeModeRaw(r4, r8)
        L_0x010d:
            int r8 = com.google.android.exoplayer2.ui.R.id.exo_shutter
            android.view.View r8 = r1.findViewById(r8)
            r1.shutterView = r8
            if (r8 == 0) goto L_0x011c
            if (r11 == 0) goto L_0x011c
            r8.setBackgroundColor(r12)
        L_0x011c:
            if (r4 == 0) goto L_0x015c
            if (r9 == 0) goto L_0x015c
            android.view.ViewGroup$LayoutParams r8 = new android.view.ViewGroup$LayoutParams
            r11 = -1
            r8.<init>(r11, r11)
            r11 = 2
            if (r9 == r11) goto L_0x0149
            r11 = 3
            if (r9 == r11) goto L_0x013b
            r11 = 4
            if (r9 == r11) goto L_0x0135
            android.view.SurfaceView r9 = new android.view.SurfaceView
            r9.<init>(r0)
            goto L_0x014e
        L_0x0135:
            com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView r9 = new com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView
            r9.<init>(r0)
            goto L_0x014e
        L_0x013b:
            com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView r9 = new com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView
            r9.<init>(r0)
            r9.setSingleTapListener(r3)
            boolean r11 = r1.useSensorRotation
            r9.setUseSensorRotation(r11)
            goto L_0x014e
        L_0x0149:
            android.view.TextureView r9 = new android.view.TextureView
            r9.<init>(r0)
        L_0x014e:
            r1.surfaceView = r9
            android.view.View r9 = r1.surfaceView
            r9.setLayoutParams(r8)
            android.view.View r8 = r1.surfaceView
            r9 = 0
            r4.addView(r8, r9)
            goto L_0x015f
        L_0x015c:
            r4 = 0
            r1.surfaceView = r4
        L_0x015f:
            int r4 = com.google.android.exoplayer2.ui.R.id.exo_ad_overlay
            android.view.View r4 = r1.findViewById(r4)
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            r1.adOverlayFrameLayout = r4
            int r4 = com.google.android.exoplayer2.ui.R.id.exo_overlay
            android.view.View r4 = r1.findViewById(r4)
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            r1.overlayFrameLayout = r4
            int r4 = com.google.android.exoplayer2.ui.R.id.exo_artwork
            android.view.View r4 = r1.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r1.artworkView = r4
            if (r13 == 0) goto L_0x0183
            if (r4 == 0) goto L_0x0183
            r4 = 1
            goto L_0x0184
        L_0x0183:
            r4 = 0
        L_0x0184:
            r1.useArtwork = r4
            if (r14 == 0) goto L_0x0192
            android.content.Context r4 = r20.getContext()
            android.graphics.drawable.Drawable r4 = androidx.core.content.b.a((android.content.Context) r4, (int) r14)
            r1.defaultArtwork = r4
        L_0x0192:
            int r4 = com.google.android.exoplayer2.ui.R.id.exo_subtitles
            android.view.View r4 = r1.findViewById(r4)
            com.google.android.exoplayer2.ui.SubtitleView r4 = (com.google.android.exoplayer2.ui.SubtitleView) r4
            r1.subtitleView = r4
            if (r4 == 0) goto L_0x01a4
            r4.b()
            r4.a()
        L_0x01a4:
            int r4 = com.google.android.exoplayer2.ui.R.id.exo_buffering
            android.view.View r4 = r1.findViewById(r4)
            r1.bufferingView = r4
            r8 = 8
            if (r4 == 0) goto L_0x01b3
            r4.setVisibility(r8)
        L_0x01b3:
            r1.showBuffering = r7
            int r4 = com.google.android.exoplayer2.ui.R.id.exo_error_message
            android.view.View r4 = r1.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r1.errorMessageView = r4
            if (r4 == 0) goto L_0x01c4
            r4.setVisibility(r8)
        L_0x01c4:
            int r4 = com.google.android.exoplayer2.ui.R.id.exo_controller
            android.view.View r4 = r1.findViewById(r4)
            com.google.android.exoplayer2.ui.PlayerControlView r4 = (com.google.android.exoplayer2.ui.PlayerControlView) r4
            int r7 = com.google.android.exoplayer2.ui.R.id.exo_controller_placeholder
            android.view.View r7 = r1.findViewById(r7)
            if (r4 == 0) goto L_0x01d8
            r1.controller = r4
            r8 = 0
            goto L_0x0204
        L_0x01d8:
            if (r7 == 0) goto L_0x0200
            com.google.android.exoplayer2.ui.PlayerControlView r4 = new com.google.android.exoplayer2.ui.PlayerControlView
            r8 = 0
            r9 = 0
            r4.<init>(r0, r9, r8, r2)
            r1.controller = r4
            int r0 = com.google.android.exoplayer2.ui.R.id.exo_controller
            r4.setId(r0)
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            r4.setLayoutParams(r0)
            android.view.ViewParent r0 = r7.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r2 = r0.indexOfChild(r7)
            r0.removeView(r7)
            r0.addView(r4, r2)
            goto L_0x0204
        L_0x0200:
            r0 = 0
            r8 = 0
            r1.controller = r0
        L_0x0204:
            com.google.android.exoplayer2.ui.PlayerControlView r0 = r1.controller
            if (r0 == 0) goto L_0x020b
            r4 = r16
            goto L_0x020c
        L_0x020b:
            r4 = 0
        L_0x020c:
            r1.controllerShowTimeoutMs = r4
            r1.controllerHideOnTouch = r10
            r1.controllerAutoShow = r5
            r1.controllerHideDuringAds = r6
            if (r17 == 0) goto L_0x021a
            if (r0 == 0) goto L_0x021a
            r7 = 1
            goto L_0x021b
        L_0x021a:
            r7 = 0
        L_0x021b:
            r1.useController = r7
            r20.hideController()
            r20.updateContentDescription()
            com.google.android.exoplayer2.ui.PlayerControlView r0 = r1.controller
            if (r0 == 0) goto L_0x022a
            r0.a((com.google.android.exoplayer2.ui.PlayerControlView.c) r3)
        L_0x022a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.PlayerView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: private */
    public static void applyTextureViewRotation(TextureView textureView, int i2) {
        Matrix matrix = new Matrix();
        float width = (float) textureView.getWidth();
        float height = (float) textureView.getHeight();
        if (!(width == 0.0f || height == 0.0f || i2 == 0)) {
            float f2 = width / 2.0f;
            float f3 = height / 2.0f;
            matrix.postRotate((float) i2, f2, f3);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f2, f3);
        }
        textureView.setTransform(matrix);
    }

    private void closeShutter() {
        View view = this.shutterView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private static void configureEditModeLogo(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R.drawable.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(R.color.exo_edit_mode_background_color));
    }

    private static void configureEditModeLogoV23(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R.drawable.exo_edit_mode_logo, (Resources.Theme) null));
        imageView.setBackgroundColor(resources.getColor(R.color.exo_edit_mode_background_color, (Resources.Theme) null));
    }

    private void hideArtwork() {
        ImageView imageView = this.artworkView;
        if (imageView != null) {
            imageView.setImageResource(17170445);
            this.artworkView.setVisibility(4);
        }
    }

    private boolean isDpadKey(int i2) {
        return i2 == 19 || i2 == 270 || i2 == 22 || i2 == 271 || i2 == 20 || i2 == 269 || i2 == 21 || i2 == 268 || i2 == 23;
    }

    /* access modifiers changed from: private */
    public boolean isPlayingAd() {
        x xVar = this.player;
        return xVar != null && xVar.x() && this.player.n();
    }

    /* access modifiers changed from: private */
    public void maybeShowController(boolean z2) {
        if ((!isPlayingAd() || !this.controllerHideDuringAds) && useController()) {
            boolean z3 = this.controller.c() && this.controller.getShowTimeoutMs() <= 0;
            boolean shouldShowControllerIndefinitely = shouldShowControllerIndefinitely();
            if (z2 || z3 || shouldShowControllerIndefinitely) {
                showController(shouldShowControllerIndefinitely);
            }
        }
    }

    @RequiresNonNull({"artworkView"})
    private boolean setArtworkFromMetadata(Metadata metadata) {
        byte[] bArr;
        int i2;
        int i3 = 0;
        int i4 = -1;
        boolean z2 = false;
        while (i3 < metadata.a()) {
            Metadata.Entry a2 = metadata.a(i3);
            if (a2 instanceof ApicFrame) {
                ApicFrame apicFrame = (ApicFrame) a2;
                bArr = apicFrame.f15890d;
                i2 = apicFrame.f15889c;
            } else if (a2 instanceof PictureFrame) {
                PictureFrame pictureFrame = (PictureFrame) a2;
                bArr = pictureFrame.f15872h;
                i2 = pictureFrame.f15865a;
            } else {
                continue;
                i3++;
            }
            if (i4 == -1 || i2 == 3) {
                z2 = setDrawableArtwork(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
                if (i2 == 3) {
                    break;
                }
                i4 = i2;
                i3++;
            } else {
                i3++;
            }
        }
        return z2;
    }

    @RequiresNonNull({"artworkView"})
    private boolean setDrawableArtwork(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                onContentAspectRatioChanged(((float) intrinsicWidth) / ((float) intrinsicHeight), this.contentFrame, this.artworkView);
                this.artworkView.setImageDrawable(drawable);
                this.artworkView.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private static void setResizeModeRaw(AspectRatioFrameLayout aspectRatioFrameLayout, int i2) {
        aspectRatioFrameLayout.setResizeMode(i2);
    }

    private boolean shouldShowControllerIndefinitely() {
        x xVar = this.player;
        if (xVar == null) {
            return true;
        }
        int k2 = xVar.k();
        return this.controllerAutoShow && (k2 == 1 || k2 == 4 || !this.player.n());
    }

    private void showController(boolean z2) {
        if (useController()) {
            this.controller.setShowTimeoutMs(z2 ? 0 : this.controllerShowTimeoutMs);
            this.controller.a();
        }
    }

    public static void switchTargetView(x xVar, PlayerView playerView, PlayerView playerView2) {
        if (playerView != playerView2) {
            if (playerView2 != null) {
                playerView2.setPlayer(xVar);
            }
            if (playerView != null) {
                playerView.setPlayer((x) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean toggleControllerVisibility() {
        if (!useController() || this.player == null) {
            return false;
        }
        if (!this.controller.c()) {
            maybeShowController(true);
        } else if (this.controllerHideOnTouch) {
            this.controller.b();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void updateBuffering() {
        int i2;
        if (this.bufferingView != null) {
            x xVar = this.player;
            boolean z2 = true;
            int i3 = 0;
            if (xVar == null || xVar.k() != 2 || ((i2 = this.showBuffering) != 2 && (i2 != 1 || !this.player.n()))) {
                z2 = false;
            }
            View view = this.bufferingView;
            if (!z2) {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    /* access modifiers changed from: private */
    public void updateContentDescription() {
        PlayerControlView playerControlView = this.controller;
        String str = null;
        if (playerControlView != null && this.useController) {
            if (playerControlView.getVisibility() != 0) {
                setContentDescription(getResources().getString(R.string.exo_controls_show));
                return;
            } else if (this.controllerHideOnTouch) {
                str = getResources().getString(R.string.exo_controls_hide);
            }
        }
        setContentDescription(str);
    }

    /* access modifiers changed from: private */
    public void updateErrorMessage() {
        f<? super ExoPlaybackException> fVar;
        TextView textView = this.errorMessageView;
        if (textView != null) {
            CharSequence charSequence = this.customErrorMessage;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.errorMessageView.setVisibility(0);
                return;
            }
            x xVar = this.player;
            ExoPlaybackException m2 = xVar != null ? xVar.m() : null;
            if (m2 == null || (fVar = this.errorMessageProvider) == null) {
                this.errorMessageView.setVisibility(8);
                return;
            }
            this.errorMessageView.setText((CharSequence) fVar.a(m2).second);
            this.errorMessageView.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void updateForCurrentTrackSelections(boolean z2) {
        x xVar = this.player;
        if (xVar != null && !xVar.C().a()) {
            if (z2 && !this.keepContentOnPlayerReset) {
                closeShutter();
            }
            com.google.android.exoplayer2.trackselection.f D = xVar.D();
            int i2 = 0;
            while (i2 < D.f16744a) {
                if (xVar.b(i2) != 2 || D.a(i2) == null) {
                    i2++;
                } else {
                    hideArtwork();
                    return;
                }
            }
            closeShutter();
            if (useArtwork()) {
                for (int i3 = 0; i3 < D.f16744a; i3++) {
                    e a2 = D.a(i3);
                    if (a2 != null) {
                        int i4 = 0;
                        while (i4 < a2.h()) {
                            Metadata metadata = a2.a(i4).f15090g;
                            if (metadata == null || !setArtworkFromMetadata(metadata)) {
                                i4++;
                            } else {
                                return;
                            }
                        }
                        continue;
                    }
                }
                if (setDrawableArtwork(this.defaultArtwork)) {
                    return;
                }
            }
            hideArtwork();
        } else if (!this.keepContentOnPlayerReset) {
            hideArtwork();
            closeShutter();
        }
    }

    @EnsuresNonNullIf(expression = {"artworkView"}, result = true)
    private boolean useArtwork() {
        if (!this.useArtwork) {
            return false;
        }
        com.google.android.exoplayer2.util.a.a(this.artworkView);
        return true;
    }

    @EnsuresNonNullIf(expression = {"controller"}, result = true)
    private boolean useController() {
        if (!this.useController) {
            return false;
        }
        com.google.android.exoplayer2.util.a.a(this.controller);
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        x xVar = this.player;
        if (xVar != null && xVar.x()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean isDpadKey = isDpadKey(keyEvent.getKeyCode());
        if ((isDpadKey && useController() && !this.controller.c()) || dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            maybeShowController(true);
            return true;
        } else if (!isDpadKey || !useController()) {
            return false;
        } else {
            maybeShowController(true);
            return false;
        }
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        return useController() && this.controller.a(keyEvent);
    }

    public View[] getAdOverlayViews() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.overlayFrameLayout;
        if (frameLayout != null) {
            arrayList.add(frameLayout);
        }
        PlayerControlView playerControlView = this.controller;
        if (playerControlView != null) {
            arrayList.add(playerControlView);
        }
        return (View[]) arrayList.toArray(new View[0]);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) com.google.android.exoplayer2.util.a.a(this.adOverlayFrameLayout, (Object) "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.controllerAutoShow;
    }

    public boolean getControllerHideOnTouch() {
        return this.controllerHideOnTouch;
    }

    public int getControllerShowTimeoutMs() {
        return this.controllerShowTimeoutMs;
    }

    public Drawable getDefaultArtwork() {
        return this.defaultArtwork;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.overlayFrameLayout;
    }

    public x getPlayer() {
        return this.player;
    }

    public int getResizeMode() {
        com.google.android.exoplayer2.util.a.a(this.contentFrame);
        return this.contentFrame.getResizeMode();
    }

    public SubtitleView getSubtitleView() {
        return this.subtitleView;
    }

    public boolean getUseArtwork() {
        return this.useArtwork;
    }

    public boolean getUseController() {
        return this.useController;
    }

    public View getVideoSurfaceView() {
        return this.surfaceView;
    }

    public void hideController() {
        PlayerControlView playerControlView = this.controller;
        if (playerControlView != null) {
            playerControlView.b();
        }
    }

    public boolean isControllerVisible() {
        PlayerControlView playerControlView = this.controller;
        return playerControlView != null && playerControlView.c();
    }

    /* access modifiers changed from: protected */
    public void onContentAspectRatioChanged(float f2, AspectRatioFrameLayout aspectRatioFrameLayout, View view) {
        if (aspectRatioFrameLayout != null) {
            if (view instanceof SphericalGLSurfaceView) {
                f2 = 0.0f;
            }
            aspectRatioFrameLayout.setAspectRatio(f2);
        }
    }

    public void onPause() {
        View view = this.surfaceView;
        if (view instanceof SphericalGLSurfaceView) {
            ((SphericalGLSurfaceView) view).onPause();
        }
    }

    public void onResume() {
        View view = this.surfaceView;
        if (view instanceof SphericalGLSurfaceView) {
            ((SphericalGLSurfaceView) view).onResume();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!useController() || this.player == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.isTouching = true;
            return true;
        } else if (action != 1 || !this.isTouching) {
            return false;
        } else {
            this.isTouching = false;
            performClick();
            return true;
        }
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!useController() || this.player == null) {
            return false;
        }
        maybeShowController(true);
        return true;
    }

    public boolean performClick() {
        super.performClick();
        return toggleControllerVisibility();
    }

    public void setAspectRatioListener(AspectRatioFrameLayout.a aVar) {
        com.google.android.exoplayer2.util.a.a(this.contentFrame);
        this.contentFrame.setAspectRatioListener(aVar);
    }

    public void setControlDispatcher(com.google.android.exoplayer2.f fVar) {
        com.google.android.exoplayer2.util.a.a(this.controller);
        this.controller.setControlDispatcher(fVar);
    }

    public void setControllerAutoShow(boolean z2) {
        this.controllerAutoShow = z2;
    }

    public void setControllerHideDuringAds(boolean z2) {
        this.controllerHideDuringAds = z2;
    }

    public void setControllerHideOnTouch(boolean z2) {
        com.google.android.exoplayer2.util.a.a(this.controller);
        this.controllerHideOnTouch = z2;
        updateContentDescription();
    }

    public void setControllerShowTimeoutMs(int i2) {
        com.google.android.exoplayer2.util.a.a(this.controller);
        this.controllerShowTimeoutMs = i2;
        if (this.controller.c()) {
            showController();
        }
    }

    public void setControllerVisibilityListener(PlayerControlView.c cVar) {
        com.google.android.exoplayer2.util.a.a(this.controller);
        PlayerControlView.c cVar2 = this.controllerVisibilityListener;
        if (cVar2 != cVar) {
            if (cVar2 != null) {
                this.controller.b(cVar2);
            }
            this.controllerVisibilityListener = cVar;
            if (cVar != null) {
                this.controller.a(cVar);
            }
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        com.google.android.exoplayer2.util.a.b(this.errorMessageView != null);
        this.customErrorMessage = charSequence;
        updateErrorMessage();
    }

    @Deprecated
    public void setDefaultArtwork(Bitmap bitmap) {
        setDefaultArtwork((Drawable) bitmap == null ? null : new BitmapDrawable(getResources(), bitmap));
    }

    public void setDefaultArtwork(Drawable drawable) {
        if (this.defaultArtwork != drawable) {
            this.defaultArtwork = drawable;
            updateForCurrentTrackSelections(false);
        }
    }

    public void setErrorMessageProvider(f<? super ExoPlaybackException> fVar) {
        if (this.errorMessageProvider != fVar) {
            this.errorMessageProvider = fVar;
            updateErrorMessage();
        }
    }

    public void setExtraAdGroupMarkers(long[] jArr, boolean[] zArr) {
        com.google.android.exoplayer2.util.a.a(this.controller);
        this.controller.a(jArr, zArr);
    }

    public void setFastForwardIncrementMs(int i2) {
        com.google.android.exoplayer2.util.a.a(this.controller);
        this.controller.setFastForwardIncrementMs(i2);
    }

    public void setKeepContentOnPlayerReset(boolean z2) {
        if (this.keepContentOnPlayerReset != z2) {
            this.keepContentOnPlayerReset = z2;
            updateForCurrentTrackSelections(false);
        }
    }

    public void setPlaybackPreparer(w wVar) {
        com.google.android.exoplayer2.util.a.a(this.controller);
        this.controller.setPlaybackPreparer(wVar);
    }

    public void setPlayer(x xVar) {
        com.google.android.exoplayer2.util.a.b(Looper.myLooper() == Looper.getMainLooper());
        com.google.android.exoplayer2.util.a.a(xVar == null || xVar.j() == Looper.getMainLooper());
        x xVar2 = this.player;
        if (xVar2 != xVar) {
            if (xVar2 != null) {
                xVar2.b((x.a) this.componentListener);
                x.c h2 = xVar2.h();
                if (h2 != null) {
                    h2.b((i) this.componentListener);
                    View view = this.surfaceView;
                    if (view instanceof TextureView) {
                        h2.b((TextureView) view);
                    } else if (view instanceof SphericalGLSurfaceView) {
                        ((SphericalGLSurfaceView) view).setVideoComponent((x.c) null);
                    } else if (view instanceof VideoDecoderGLSurfaceView) {
                        h2.a((com.google.android.exoplayer2.video.e) null);
                    } else if (view instanceof SurfaceView) {
                        h2.b((SurfaceView) view);
                    }
                }
                x.b i2 = xVar2.i();
                if (i2 != null) {
                    i2.b(this.componentListener);
                }
            }
            this.player = xVar;
            if (useController()) {
                this.controller.setPlayer(xVar);
            }
            SubtitleView subtitleView2 = this.subtitleView;
            if (subtitleView2 != null) {
                subtitleView2.setCues((List<b>) null);
            }
            updateBuffering();
            updateErrorMessage();
            updateForCurrentTrackSelections(true);
            if (xVar != null) {
                x.c h3 = xVar.h();
                if (h3 != null) {
                    View view2 = this.surfaceView;
                    if (view2 instanceof TextureView) {
                        h3.a((TextureView) view2);
                    } else if (view2 instanceof SphericalGLSurfaceView) {
                        ((SphericalGLSurfaceView) view2).setVideoComponent(h3);
                    } else if (view2 instanceof VideoDecoderGLSurfaceView) {
                        h3.a(((VideoDecoderGLSurfaceView) view2).getVideoDecoderOutputBufferRenderer());
                    } else if (view2 instanceof SurfaceView) {
                        h3.a((SurfaceView) view2);
                    }
                    h3.a((i) this.componentListener);
                }
                x.b i3 = xVar.i();
                if (i3 != null) {
                    i3.a(this.componentListener);
                }
                xVar.a((x.a) this.componentListener);
                maybeShowController(false);
                return;
            }
            hideController();
        }
    }

    public void setRepeatToggleModes(int i2) {
        com.google.android.exoplayer2.util.a.a(this.controller);
        this.controller.setRepeatToggleModes(i2);
    }

    public void setResizeMode(int i2) {
        com.google.android.exoplayer2.util.a.a(this.contentFrame);
        this.contentFrame.setResizeMode(i2);
    }

    public void setRewindIncrementMs(int i2) {
        com.google.android.exoplayer2.util.a.a(this.controller);
        this.controller.setRewindIncrementMs(i2);
    }

    public void setShowBuffering(int i2) {
        if (this.showBuffering != i2) {
            this.showBuffering = i2;
            updateBuffering();
        }
    }

    @Deprecated
    public void setShowBuffering(boolean z2) {
        setShowBuffering(z2 ? 1 : 0);
    }

    public void setShowMultiWindowTimeBar(boolean z2) {
        com.google.android.exoplayer2.util.a.a(this.controller);
        this.controller.setShowMultiWindowTimeBar(z2);
    }

    public void setShowShuffleButton(boolean z2) {
        com.google.android.exoplayer2.util.a.a(this.controller);
        this.controller.setShowShuffleButton(z2);
    }

    public void setShutterBackgroundColor(int i2) {
        View view = this.shutterView;
        if (view != null) {
            view.setBackgroundColor(i2);
        }
    }

    public void setUseArtwork(boolean z2) {
        com.google.android.exoplayer2.util.a.b(!z2 || this.artworkView != null);
        if (this.useArtwork != z2) {
            this.useArtwork = z2;
            updateForCurrentTrackSelections(false);
        }
    }

    public void setUseController(boolean z2) {
        PlayerControlView playerControlView;
        x xVar;
        com.google.android.exoplayer2.util.a.b(!z2 || this.controller != null);
        if (this.useController != z2) {
            this.useController = z2;
            if (useController()) {
                playerControlView = this.controller;
                xVar = this.player;
            } else {
                PlayerControlView playerControlView2 = this.controller;
                if (playerControlView2 != null) {
                    playerControlView2.b();
                    playerControlView = this.controller;
                    xVar = null;
                }
                updateContentDescription();
            }
            playerControlView.setPlayer(xVar);
            updateContentDescription();
        }
    }

    public void setUseSensorRotation(boolean z2) {
        if (this.useSensorRotation != z2) {
            this.useSensorRotation = z2;
            View view = this.surfaceView;
            if (view instanceof SphericalGLSurfaceView) {
                ((SphericalGLSurfaceView) view).setUseSensorRotation(z2);
            }
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        View view = this.surfaceView;
        if (view instanceof SurfaceView) {
            view.setVisibility(i2);
        }
    }

    public void showController() {
        showController(shouldShowControllerIndefinitely());
    }
}
