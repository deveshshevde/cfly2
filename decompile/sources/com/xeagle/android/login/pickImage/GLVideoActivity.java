package com.xeagle.android.login.pickImage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.GLMediaPlayerManager;
import com.xeagle.android.login.common.GLVideoModel;
import com.xeagle.android.login.common.GLVideoPlaceholder;
import com.xeagle.android.login.common.TimeUtil;

public class GLVideoActivity extends AppCompatActivity implements GLVideoModel.ModelObserver {
    protected static final String KEY_Duration = "duration";
    /* access modifiers changed from: private */
    public TextView current_time;
    /* access modifiers changed from: private */
    public GLMediaPlayerManager mediaPlayerManager = new GLMediaPlayerManager();
    private GLVideoPlaceholder placeholder;
    /* access modifiers changed from: private */
    public GLVideoModel videoModel;
    private LinearLayout video_control_ll;
    private TextView video_name;
    /* access modifiers changed from: private */
    public SeekBar video_seekBar;
    /* access modifiers changed from: private */
    public TextView video_total;

    private void bindData() {
        Uri data = getIntent().getData();
        String stringExtra = getIntent().getStringExtra("video_info");
        GLVideoModel gLVideoModel = new GLVideoModel(data, getIntent().getLongExtra(KEY_Duration, 0));
        this.videoModel = gLVideoModel;
        gLVideoModel.attachVideoView(this.placeholder.getVideoView());
        this.videoModel.removeObservers();
        this.videoModel.addObserver(this);
        this.videoModel.fireAttachSurface();
        this.placeholder.setFullScreenEnabled(false);
        this.placeholder.bind(this.videoModel, true);
        this.video_name.setText(stringExtra);
        GLMediaPlayerManager gLMediaPlayerManager = this.mediaPlayerManager;
        if (gLMediaPlayerManager != null) {
            gLMediaPlayerManager.setPlayInfoListener(new GLMediaPlayerManager.PlayInfoListener() {
                public void playInfoListener(int i2, int i3) {
                    GLVideoActivity.this.current_time.setText(String.format("%s", new Object[]{TimeUtil.secToTime(i2 / 1000)}));
                    GLVideoActivity.this.video_total.setText(String.format("%s", new Object[]{TimeUtil.secToTime(i3 / 1000)}));
                    GLVideoActivity.this.video_seekBar.setProgress(i2);
                    GLVideoActivity.this.video_seekBar.setMax(i3);
                }
            });
        }
        this.video_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                if (GLVideoActivity.this.mediaPlayerManager != null) {
                    GLVideoActivity.this.mediaPlayerManager.play(seekBar.getProgress());
                }
            }
        });
        AnonymousClass4 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                GLVideoActivity.this.mediaPlayerManager.attach(view.getContext(), GLVideoActivity.this.videoModel);
                GLVideoActivity.this.videoModel.userPlay();
            }
        };
        this.placeholder.setOnPlayClicked(r0);
        this.placeholder.setOnPauseClicked(new View.OnClickListener() {
            public void onClick(View view) {
                GLVideoActivity.this.videoModel.userPause();
            }
        });
        r0.onClick(this.placeholder);
    }

    private void initView() {
        this.placeholder = (GLVideoPlaceholder) findViewById(R.id.placeholder);
        findViewById(R.id.btn_back).setVisibility(0);
        findViewById(R.id.retake).setVisibility(8);
        findViewById(R.id.confirm).setVisibility(8);
        this.current_time = (TextView) findViewById(R.id.video_current);
        this.video_seekBar = (SeekBar) findViewById(R.id.video_seek);
        this.video_total = (TextView) findViewById(R.id.video_total);
        this.video_control_ll = (LinearLayout) findViewById(R.id.video_control_ll);
        this.video_name = (TextView) findViewById(R.id.video_name);
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GLVideoActivity.this.finish();
            }
        });
    }

    public static void start(Context context, Uri uri, long j2) {
        Intent intent = new Intent(context, GLVideoActivity.class);
        intent.setData(uri);
        intent.putExtra(KEY_Duration, j2);
        context.startActivity(intent);
    }

    public static void start(Context context, Uri uri, long j2, String str) {
        Intent intent = new Intent(context, GLVideoActivity.class);
        intent.setData(uri);
        intent.putExtra("video_info", str);
        intent.putExtra(KEY_Duration, j2);
        context.startActivity(intent);
    }

    public static void start(Context context, String str, long j2) {
        start(context, Uri.parse(str), j2);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.gl_video_activity);
        initView();
        bindData();
    }

    public void onModelChanged(GLVideoModel gLVideoModel) {
        this.placeholder.bind(gLVideoModel, false);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mediaPlayerManager.detach();
    }
}
