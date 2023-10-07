package com.xeagle.android.editor.activity;

import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.editor.database.EditorData;
import com.xeagle.android.editor.videoView.GlVideoView;
import com.xeagle.android.editor.widget.VideoRangeSlider;
import com.xeagle.android.editor.widget.b;
import com.xeagle.android.editor.widget.indicatorSeekbar.IndicatorSeekBar;
import com.xeagle.android.login.pickImage.ImageBaseActivity;
import com.xeagle.android.login.pickImage.ImagePicker;
import com.xeagle.android.login.pickImage.data.GLImage;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jz.a;
import kx.g;

public class EditorMultiActivity extends ImageBaseActivity implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f22795b = true;
    /* access modifiers changed from: private */
    public boolean A;
    /* access modifiers changed from: private */
    public long B;
    /* access modifiers changed from: private */
    public long C;
    /* access modifiers changed from: private */
    public int D;
    private d E;
    /* access modifiers changed from: private */
    public b F;

    /* renamed from: a  reason: collision with root package name */
    Runnable f22796a = new Runnable() {
        public void run() {
            EditorMultiActivity.this.d();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private IImageButton f22797c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public IImageButton f22798d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f22799e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f22800f;

    /* renamed from: g  reason: collision with root package name */
    private GlVideoView f22801g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f22802h;

    /* renamed from: i  reason: collision with root package name */
    private IndicatorSeekBar f22803i;

    /* renamed from: j  reason: collision with root package name */
    private IImageButton f22804j;

    /* renamed from: k  reason: collision with root package name */
    private IImageButton f22805k;

    /* renamed from: l  reason: collision with root package name */
    private IImageButton f22806l;

    /* renamed from: m  reason: collision with root package name */
    private IImageButton f22807m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public VideoRangeSlider f22808n;

    /* renamed from: o  reason: collision with root package name */
    private RecyclerView f22809o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public a f22810p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public ImagePicker f22811q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public SurfaceTexture f22812r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public MediaPlayer f22813s;

    /* renamed from: t  reason: collision with root package name */
    private List<GLImage> f22814t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public boolean f22815u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public int f22816v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public int f22817w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public int f22818x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public float f22819y;

    /* renamed from: z  reason: collision with root package name */
    private Handler f22820z = new Handler(Looper.getMainLooper());

    private void a() {
        this.f22797c = (IImageButton) findViewById(R.id.ib_editor_cancel);
        this.f22798d = (IImageButton) findViewById(R.id.ib_editor_controller);
        this.f22799e = (TextView) findViewById(R.id.tv_editor_complete);
        this.f22800f = (RelativeLayout) findViewById(R.id.rl_video);
        this.f22801g = (GlVideoView) findViewById(R.id.gl_video_player);
        this.f22802h = (TextView) findViewById(R.id.tv_player_time);
        this.f22803i = (IndicatorSeekBar) findViewById(R.id.seek_video);
        this.f22804j = (IImageButton) findViewById(R.id.ib_editor_movie);
        this.f22805k = (IImageButton) findViewById(R.id.ib_editor_music);
        this.f22806l = (IImageButton) findViewById(R.id.ib_editor_filter);
        this.f22807m = (IImageButton) findViewById(R.id.ib_editor_text);
        f();
        this.f22809o = (RecyclerView) findViewById(R.id.video_list);
        this.f22811q = ImagePicker.getInstance();
        this.f22809o.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f22809o.setHasFixedSize(true);
        Log.i("editor", "onCreate: --select count===" + this.f22811q.getSelectImageCount());
        this.f22814t = new ArrayList(this.f22811q.getSelectedImages());
        b();
        a aVar = this.f22810p;
        if (aVar != null) {
            aVar.a((ArrayList<GLImage>) (ArrayList) this.f22814t);
            Log.i("editor", "run: ---===update");
            runOnUiThread(new Runnable() {
                public void run() {
                    EditorMultiActivity.this.f22810p.notifyDataSetChanged();
                }
            });
        }
        if (this.f22810p == null) {
            this.f22810p = new a(this, this.f22814t);
        }
        this.f22809o.setAdapter(this.f22810p);
        b bVar = new b(this, this.f22809o);
        this.F = bVar;
        this.D = 0;
        bVar.a(0);
        this.f22809o.a((RecyclerView.g) this.F);
        this.F.a((b.a) new b.a() {
            public void a() {
                if (EditorMultiActivity.this.f22811q.getSelectImageCount() == 9) {
                    ToastUtils.showShort((CharSequence) "已经达到最大数");
                    return;
                }
                EditorMultiActivity.this.f22811q.clearSelectedImages();
                Intent intent = new Intent(EditorMultiActivity.this, EditorSelectorActivity.class);
                boolean unused = EditorMultiActivity.this.A = true;
                EditorMultiActivity.this.startActivity(intent);
            }

            public void a(int i2) {
            }

            public void a(int i2, float f2, float f3) {
            }
        });
        this.f22810p.a((a.b) new a.b() {
            public void a(int i2, int i3) {
                float f2;
                EditorMultiActivity editorMultiActivity;
                int unused = EditorMultiActivity.this.f22818x = i2;
                if (EditorMultiActivity.this.D != i3) {
                    int unused2 = EditorMultiActivity.this.D = i3;
                    EditorMultiActivity.this.F.a(EditorMultiActivity.this.D);
                    EditorMultiActivity editorMultiActivity2 = EditorMultiActivity.this;
                    editorMultiActivity2.a(editorMultiActivity2.f22812r, i3);
                    EditorMultiActivity.this.f22810p.a(i3);
                    editorMultiActivity = EditorMultiActivity.this;
                    f2 = 0.0f;
                } else {
                    editorMultiActivity = EditorMultiActivity.this;
                    f2 = (float) editorMultiActivity.f22813s.getCurrentPosition();
                }
                float unused3 = editorMultiActivity.f22819y = f2;
            }

            public void a(int i2, int i3, int i4, long j2, long j3) {
                int i5;
                MediaPlayer mediaPlayer;
                if (EditorMultiActivity.this.f22813s != null && i4 == i3) {
                    long unused = EditorMultiActivity.this.B = j2;
                    long unused2 = EditorMultiActivity.this.C = j3;
                    boolean unused3 = EditorMultiActivity.this.f22815u = true;
                    if (i2 == 1) {
                        mediaPlayer = EditorMultiActivity.this.f22813s;
                        i5 = (int) j2;
                    } else if (i2 == 2) {
                        mediaPlayer = EditorMultiActivity.this.f22813s;
                        i5 = (int) j3;
                    } else {
                        return;
                    }
                    mediaPlayer.seekTo(i5);
                }
            }

            public void a(VideoRangeSlider videoRangeSlider, int i2) {
                VideoRangeSlider unused = EditorMultiActivity.this.f22808n = videoRangeSlider;
                if (videoRangeSlider.getLeftIndex() > 0 && EditorMultiActivity.this.f22813s != null) {
                    MediaPlayer f2 = EditorMultiActivity.this.f22813s;
                    double leftIndex = (double) videoRangeSlider.getLeftIndex();
                    Double.isNaN(leftIndex);
                    double totalTime = (double) videoRangeSlider.getTotalTime();
                    Double.isNaN(totalTime);
                    f2.seekTo((int) ((leftIndex / 100.0d) * totalTime));
                }
                EditorMultiActivity.this.d();
            }

            public void a(VideoRangeSlider videoRangeSlider, int i2, float f2, float f3) {
                Log.i("editor", "onItemClick: --slider---==" + videoRangeSlider.getTotalTime() + "POS-===" + i2);
                VideoRangeSlider unused = EditorMultiActivity.this.f22808n = videoRangeSlider;
                int unused2 = EditorMultiActivity.this.D = i2;
                EditorMultiActivity.this.F.a(EditorMultiActivity.this.D);
                EditorMultiActivity editorMultiActivity = EditorMultiActivity.this;
                editorMultiActivity.a(editorMultiActivity.f22812r, i2);
                EditorMultiActivity.this.f22810p.notifyItemChanged(i2);
            }
        });
        g();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(SurfaceTexture surfaceTexture) {
        this.f22812r = surfaceTexture;
        a(surfaceTexture, 0);
    }

    /* access modifiers changed from: private */
    public void a(SurfaceTexture surfaceTexture, int i2) {
        MediaPlayer mediaPlayer = this.f22813s;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f22813s.release();
        }
        MediaPlayer mediaPlayer2 = new MediaPlayer();
        this.f22813s = mediaPlayer2;
        try {
            mediaPlayer2.setDataSource(this.f22814t.get(i2).getPath());
            Surface surface = new Surface(surfaceTexture);
            this.f22813s.setSurface(surface);
            surface.release();
            this.f22813s.setLooping(false);
            this.f22813s.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mediaPlayer) {
                    ViewGroup.LayoutParams layoutParams = EditorMultiActivity.this.f22800f.getLayoutParams();
                    int videoWidth = mediaPlayer.getVideoWidth();
                    int videoHeight = mediaPlayer.getVideoHeight();
                    float f2 = ((float) videoWidth) / ((float) videoHeight);
                    int width = EditorMultiActivity.this.f22800f.getWidth();
                    int height = EditorMultiActivity.this.f22800f.getHeight();
                    float f3 = (float) width;
                    float f4 = (float) height;
                    if (f2 > f3 / f4) {
                        layoutParams.width = width;
                        layoutParams.height = (int) (f3 / f2);
                    } else {
                        layoutParams.width = (int) (f2 * f4);
                        layoutParams.height = height;
                    }
                    EditorMultiActivity.this.f22800f.setLayoutParams(layoutParams);
                    int unused = EditorMultiActivity.this.f22816v = videoWidth;
                    int unused2 = EditorMultiActivity.this.f22817w = videoHeight;
                    Log.e("editor", "videoWidth:" + videoWidth + ", videoHeight:" + videoHeight);
                    mediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            Log.d("editor", "------ok----real---start-----");
                            Log.d("editor", "------isSeeking-----" + EditorMultiActivity.this.f22815u);
                            if (!EditorMultiActivity.this.f22815u) {
                                EditorMultiActivity.this.f22813s.start();
                            } else {
                                if (EditorMultiActivity.this.f22818x == 1) {
                                    EditorMultiActivity.this.f22813s.seekTo((int) EditorMultiActivity.this.B);
                                } else if (EditorMultiActivity.this.f22818x == 2) {
                                    EditorMultiActivity.this.f22813s.seekTo((int) EditorMultiActivity.this.f22819y);
                                }
                                boolean unused = EditorMultiActivity.this.f22815u = false;
                            }
                            EditorMultiActivity.this.f22798d.setImageResource(R.drawable.editor_video_pause);
                        }
                    });
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            EditorMultiActivity.this.h();
                        }
                    });
                }
            });
            this.f22813s.prepare();
            this.f22813s.start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ec A[LOOP:2: B:28:0x00e6->B:30:0x00ec, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r10 = this;
            java.util.ArrayList r0 = com.xeagle.android.editor.database.a.a()
            r1 = 1
            r2 = 0
            java.lang.String r3 = "editor"
            if (r0 != 0) goto L_0x002e
            r10.c()
            java.util.ArrayList r0 = com.xeagle.android.editor.database.a.a()
            boolean r4 = f22795b
            if (r4 != 0) goto L_0x001e
            if (r0 == 0) goto L_0x0018
            goto L_0x001e
        L_0x0018:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x001e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "initDatabase: ---=="
        L_0x0025:
            r4.append(r5)
            int r5 = r0.size()
            goto L_0x00db
        L_0x002e:
            int r4 = r0.size()
            if (r4 <= 0) goto L_0x00ac
            java.util.List<com.xeagle.android.login.pickImage.data.GLImage> r4 = r10.f22814t
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x00e5
            r4 = 0
        L_0x003d:
            java.util.List<com.xeagle.android.login.pickImage.data.GLImage> r5 = r10.f22814t
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0074
            com.xeagle.android.editor.database.EditorData r5 = new com.xeagle.android.editor.database.EditorData
            r5.<init>()
            java.util.List<com.xeagle.android.login.pickImage.data.GLImage> r6 = r10.f22814t
            java.lang.Object r6 = r6.get(r4)
            com.xeagle.android.login.pickImage.data.GLImage r6 = (com.xeagle.android.login.pickImage.data.GLImage) r6
            r5.setGlImage(r6)
            r5.setLeftProgress(r2)
            java.util.List<com.xeagle.android.login.pickImage.data.GLImage> r6 = r10.f22814t
            java.lang.Object r6 = r6.get(r4)
            com.xeagle.android.login.pickImage.data.GLImage r6 = (com.xeagle.android.login.pickImage.data.GLImage) r6
            long r6 = r6.getDuration()
            int r7 = (int) r6
            r5.setRightProgress(r7)
            boolean r6 = r0.contains(r5)
            if (r6 != 0) goto L_0x0071
            com.xeagle.android.editor.database.a.a((com.xeagle.android.editor.database.EditorData) r5)
        L_0x0071:
            int r4 = r4 + 1
            goto L_0x003d
        L_0x0074:
            java.util.ArrayList r0 = com.xeagle.android.editor.database.a.a()
            java.util.List<com.xeagle.android.login.pickImage.data.GLImage> r4 = r10.f22814t
            r4.clear()
            com.xeagle.android.login.pickImage.ImagePicker r4 = r10.f22811q
            r4.clearSelectedImages()
            r4 = 0
        L_0x0083:
            int r5 = r0.size()
            if (r4 >= r5) goto L_0x009b
            com.xeagle.android.login.pickImage.ImagePicker r5 = r10.f22811q
            java.lang.Object r6 = r0.get(r4)
            com.xeagle.android.editor.database.EditorData r6 = (com.xeagle.android.editor.database.EditorData) r6
            com.xeagle.android.login.pickImage.data.GLImage r6 = r6.getGlImage()
            r5.addSelectedImageItem(r6, r1)
            int r4 = r4 + 1
            goto L_0x0083
        L_0x009b:
            com.xeagle.android.login.pickImage.ImagePicker r4 = r10.f22811q
            java.util.ArrayList r4 = r4.getSelectedImages()
            r10.f22814t = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "initDatabase:====== "
            goto L_0x0025
        L_0x00ac:
            r10.c()
            java.util.ArrayList r0 = com.xeagle.android.editor.database.a.a()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "initDatabase: -aaa--=="
            r4.append(r5)
            int r5 = r0.size()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.util.Log.i(r3, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "initDatabase: -bbbb====="
            r4.append(r5)
            java.util.List<com.xeagle.android.login.pickImage.data.GLImage> r5 = r10.f22814t
            int r5 = r5.size()
        L_0x00db:
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.util.Log.i(r3, r4)
        L_0x00e5:
            r4 = 0
        L_0x00e6:
            int r5 = r0.size()
            if (r2 >= r5) goto L_0x0135
            double r4 = (double) r4
            java.lang.Object r6 = r0.get(r2)
            com.xeagle.android.editor.database.EditorData r6 = (com.xeagle.android.editor.database.EditorData) r6
            int r6 = r6.getRightProgress()
            java.lang.Object r7 = r0.get(r2)
            com.xeagle.android.editor.database.EditorData r7 = (com.xeagle.android.editor.database.EditorData) r7
            int r7 = r7.getLeftProgress()
            int r6 = r6 - r7
            double r6 = (double) r6
            r8 = 4636737291354636288(0x4059000000000000, double:100.0)
            java.lang.Double.isNaN(r6)
            double r6 = r6 / r8
            java.lang.Object r8 = r0.get(r2)
            com.xeagle.android.editor.database.EditorData r8 = (com.xeagle.android.editor.database.EditorData) r8
            long r8 = r8.getDuration()
            double r8 = (double) r8
            java.lang.Double.isNaN(r8)
            double r6 = r6 * r8
            java.lang.Double.isNaN(r4)
            double r4 = r4 + r6
            int r4 = (int) r4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "initDatabase: ==sum===="
            r5.append(r6)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            android.util.Log.i(r3, r5)
            int r2 = r2 + 1
            goto L_0x00e6
        L_0x0135:
            com.xeagle.android.editor.widget.indicatorSeekbar.IndicatorSeekBar r2 = r10.f22803i
            float r3 = (float) r4
            r2.setMax(r3)
            com.xeagle.android.editor.widget.indicatorSeekbar.IndicatorSeekBar r2 = r10.f22803i
            r3 = 0
            r2.setMin(r3)
            com.xeagle.android.editor.widget.indicatorSeekbar.IndicatorSeekBar r2 = r10.f22803i
            r2.a((java.util.ArrayList<com.xeagle.android.editor.database.EditorData>) r0)
            com.xeagle.android.editor.widget.indicatorSeekbar.IndicatorSeekBar r2 = r10.f22803i
            int r0 = r0.size()
            int r0 = r0 + r1
            r2.setTickCount(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.editor.activity.EditorMultiActivity.b():void");
    }

    private void c() {
        if (this.f22814t.size() > 0) {
            for (int i2 = 0; i2 < this.f22814t.size(); i2++) {
                EditorData editorData = new EditorData();
                editorData.setGlImage(this.f22814t.get(i2));
                editorData.setLeftProgress(0);
                editorData.setRightProgress(100);
                com.xeagle.android.editor.database.a.a(editorData);
            }
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        VideoRangeSlider videoRangeSlider;
        MediaPlayer mediaPlayer = this.f22813s;
        if (!(mediaPlayer == null || (videoRangeSlider = this.f22808n) == null)) {
            videoRangeSlider.setFrameProgress(((float) mediaPlayer.getCurrentPosition()) / ((float) this.f22813s.getDuration()));
            double rightIndex = (double) this.f22808n.getRightIndex();
            Double.isNaN(rightIndex);
            if (rightIndex / 100.0d < 1.0d) {
                double rightIndex2 = (double) this.f22808n.getRightIndex();
                Double.isNaN(rightIndex2);
                double totalTime = (double) this.f22808n.getTotalTime();
                Double.isNaN(totalTime);
                if ((rightIndex2 / 100.0d) * totalTime <= ((double) this.f22813s.getCurrentPosition())) {
                    h();
                }
            }
        }
        if (this.D < this.f22814t.size() - 1) {
            this.f22820z.postDelayed(this.f22796a, 1000);
        }
    }

    private void e() {
        if (this.E == null) {
            this.E = d.a(getString(R.string.warning), getString(R.string.editor_save_video), new d.a() {
                public void onNo() {
                    EditorMultiActivity.this.f22811q.clearSelectedImages();
                    com.xeagle.android.editor.database.a.b();
                    EditorMultiActivity.this.finish();
                }

                public void onYes() {
                }
            });
        }
        if (!this.E.isAdded()) {
            this.E.show(getSupportFragmentManager(), "editorWarn");
        }
    }

    private void f() {
        this.f22801g.a((com.xeagle.android.editor.videoView.b) new com.xeagle.android.editor.videoView.b() {
            public final void onCreated(SurfaceTexture surfaceTexture) {
                EditorMultiActivity.this.a(surfaceTexture);
            }
        });
    }

    private void g() {
        this.f22797c.setOnClickListener(this);
        this.f22798d.setOnClickListener(this);
        this.f22799e.setOnClickListener(this);
        this.f22804j.setOnClickListener(this);
        this.f22805k.setOnClickListener(this);
        this.f22806l.setOnClickListener(this);
        this.f22807m.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    public void h() {
        this.f22820z.removeCallbacks(this.f22796a);
        if (this.D < this.f22814t.size() - 1) {
            int i2 = this.D + 1;
            this.D = i2;
            this.F.a(i2);
            this.f22810p.a(this.D);
            int i3 = this.D;
            RecyclerView.h layoutManager = this.f22809o.getLayoutManager();
            Objects.requireNonNull(layoutManager);
            if (i3 == ((LinearLayoutManager) layoutManager).q()) {
                this.f22809o.c(this.D);
            }
            a(this.f22812r, this.D);
            return;
        }
        this.f22798d.setImageResource(R.drawable.editor_video_play);
    }

    public void clearMemoryCache() {
    }

    public void clearRequest() {
    }

    public void onBackPressed() {
        e();
    }

    public void onClick(View view) {
        IImageButton iImageButton;
        int i2;
        switch (view.getId()) {
            case R.id.ib_editor_cancel:
                e();
                return;
            case R.id.ib_editor_controller:
                MediaPlayer mediaPlayer = this.f22813s;
                if (mediaPlayer != null) {
                    if (mediaPlayer.isPlaying()) {
                        this.f22813s.pause();
                        iImageButton = this.f22798d;
                        i2 = R.drawable.editor_video_play;
                    } else {
                        this.f22813s.start();
                        iImageButton = this.f22798d;
                        i2 = R.drawable.editor_video_pause;
                    }
                    iImageButton.setImageResource(i2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.editor_multi_layout);
        a();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.A) {
            this.A = false;
        } else if (new File(kx.d.f(getApplicationContext())).exists()) {
            g.d(kx.d.f(getApplicationContext()));
        }
    }
}
