package com.xeagle.android.vjoystick;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.blankj.utilcode.constant.CacheConstants;
import com.cfly.uav_pro.R;
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.vjoystick.utils.e;
import com.xeagle.android.vjoystick.view.ReplaySurfaceView;

public class ReplayActivity extends SuperUI {

    /* renamed from: a  reason: collision with root package name */
    public e f24849a = new e(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what == 3) {
                int intValue = ((Integer) message.obj).intValue();
                ReplayActivity.this.f24862u.setProgress(intValue);
                int i2 = intValue / CacheConstants.HOUR;
                int i3 = (intValue % CacheConstants.HOUR) / 60;
                int i4 = intValue % 60;
                if (i2 > 0) {
                    ReplayActivity replayActivity = ReplayActivity.this;
                    String unused = replayActivity.f24858q = String.format("%02d", new Object[]{Integer.valueOf(i2)}) + ":" + String.format("%02d", new Object[]{Integer.valueOf(i3)}) + ":" + String.format("%02d", new Object[]{Integer.valueOf(i4)});
                } else {
                    ReplayActivity replayActivity2 = ReplayActivity.this;
                    String unused2 = replayActivity2.f24858q = String.format("%02d", new Object[]{Integer.valueOf(i3)}) + ":" + String.format("%02d", new Object[]{Integer.valueOf(i4)});
                }
                TextView g2 = ReplayActivity.this.f24861t;
                g2.setText(ReplayActivity.this.f24858q + "/" + ReplayActivity.this.f24857p);
            }
            return false;
        }
    });

    /* renamed from: b  reason: collision with root package name */
    private ReplaySurfaceView f24850b;

    /* renamed from: c  reason: collision with root package name */
    private int f24851c;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f24852k = false;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public RelativeLayout f24853l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public RelativeLayout f24854m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f24855n = true;

    /* renamed from: o  reason: collision with root package name */
    private int f24856o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public String f24857p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public String f24858q;

    /* renamed from: r  reason: collision with root package name */
    private ImageView f24859r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f24860s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public TextView f24861t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public SeekBar f24862u;

    /* renamed from: v  reason: collision with root package name */
    private View.OnClickListener f24863v = new View.OnClickListener() {
        public void onClick(View view) {
            ReplayActivity replayActivity;
            int id2 = view.getId();
            if (id2 == R.id.iv_replay_top_back) {
                ReplayActivity.this.onBackPressed();
            } else if (id2 == R.id.replaySurfaceView) {
                boolean z2 = false;
                if (ReplayActivity.this.f24855n) {
                    ReplayActivity.this.f24854m.setVisibility(4);
                    ReplayActivity.this.f24853l.setVisibility(4);
                    replayActivity = ReplayActivity.this;
                } else {
                    ReplayActivity.this.f24854m.setVisibility(0);
                    ReplayActivity.this.f24853l.setVisibility(0);
                    replayActivity = ReplayActivity.this;
                    z2 = true;
                }
                boolean unused = replayActivity.f24855n = z2;
            }
        }
    };

    private void a() {
        this.f24853l = (RelativeLayout) findViewById(R.id.layout_replay_top_menubar);
        this.f24854m = (RelativeLayout) findViewById(R.id.layout_replay_bottom_menubar);
        this.f24859r = (ImageView) findViewById(R.id.iv_replay_top_back);
        this.f24860s = (TextView) findViewById(R.id.txt_replay_top_title);
        this.f24861t = (TextView) findViewById(R.id.txt_replay_bottom_time);
        this.f24862u = (SeekBar) findViewById(R.id.seekbar_replay_play);
        this.f24859r.setOnClickListener(this.f24863v);
        b();
        this.f24862u.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void b() {
        String str;
        int i2 = this.f24856o;
        int i3 = i2 / CacheConstants.HOUR;
        int i4 = (i2 % CacheConstants.HOUR) / 60;
        int i5 = i2 % 60;
        if (i3 > 0) {
            str = String.format("%02d", new Object[]{Integer.valueOf(i3)}) + ":" + String.format("%02d", new Object[]{Integer.valueOf(i4)}) + ":" + String.format("%02d", new Object[]{Integer.valueOf(i5)});
        } else {
            str = String.format("%02d", new Object[]{Integer.valueOf(i4)}) + ":" + String.format("%02d", new Object[]{Integer.valueOf(i5)});
        }
        this.f24857p = str;
        ReplaySurfaceView replaySurfaceView = (ReplaySurfaceView) findViewById(R.id.replaySurfaceView);
        this.f24850b = replaySurfaceView;
        replaySurfaceView.setOnClickListener(this.f24863v);
    }

    private void d() {
        new Thread(new Runnable() {
            public void run() {
                while (!ReplayActivity.this.f24852k) {
                    try {
                        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                        Message message = new Message();
                        message.what = 3;
                        message.obj = Integer.valueOf(currentTimeMillis);
                        ReplayActivity.this.f24849a.a(message);
                        Thread.sleep(200);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.f24852k = true;
        this.f24850b.a();
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        setContentView((int) R.layout.activity_replay);
        this.f24851c = getIntent().getIntExtra("position", 0);
        a();
        d();
    }
}
