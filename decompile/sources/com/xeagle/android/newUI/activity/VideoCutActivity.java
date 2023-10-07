package com.xeagle.android.newUI.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.cfly.uav_pro.R;
import com.shuyu.gsyvideoplayer.c;
import com.shuyu.gsyvideoplayer.utils.GSYVideoType;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.xeagle.android.login.common.ListenerStickView;
import ji.d;
import ji.e;
import kotlin.jvm.internal.h;

public final class VideoCutActivity extends AppCompatActivity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public StandardGSYVideoPlayer f23924a;

    /* renamed from: b  reason: collision with root package name */
    private jd.a f23925b = new jd.a();

    /* renamed from: c  reason: collision with root package name */
    private com.ctoo.mediaedit.dialog.a f23926c;

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VideoCutActivity f23927a;

        a(VideoCutActivity videoCutActivity) {
            this.f23927a = videoCutActivity;
        }

        public final void onClick(View view) {
            StandardGSYVideoPlayer a2 = this.f23927a.f23924a;
            h.a((Object) a2);
            a2.startWindowFullscreen(this.f23927a, false, false);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_video_cut);
        this.f23924a = (StandardGSYVideoPlayer) findViewById(R.id.videoPlayer);
        Context context = this;
        this.f23926c = new com.ctoo.mediaedit.dialog.a(context);
        com.ctoo.mediaedit.utils.a a2 = com.ctoo.mediaedit.utils.a.a();
        h.b(a2, "ConfigUtils.getInstance()");
        a2.b();
        e.a(d.class);
        GSYVideoType.setShowType(1);
        jd.a aVar = this.f23925b;
        h.a((Object) aVar);
        aVar.setUrl("/storage/emulated/0/C-FLY2/Movie/temp.mp4").setIsTouchWiget(false).setThumbImageView(new ImageView(context)).setCacheWithPlay(true).setRotateViewAuto(true).setLockLand(true).setShowFullAnimation(true).setNeedLockFull(true).setAutoFullWithSize(true).setDismissControlTime(ListenerStickView.RC_TRIM).build(this.f23924a);
        StandardGSYVideoPlayer standardGSYVideoPlayer = this.f23924a;
        h.a((Object) standardGSYVideoPlayer);
        standardGSYVideoPlayer.getFullscreenButton().setOnClickListener(new a(this));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        c.b();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        c.d();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        c.b(false);
    }
}
