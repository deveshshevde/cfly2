package com.xeagle.android.newUI.activity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.google.android.exoplayer2.ae;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.util.ad;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import java.lang.reflect.Field;

public class ExoPlayerActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private PlayerView f23845a;

    /* renamed from: b  reason: collision with root package name */
    private ae f23846b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f23847c;

    /* renamed from: d  reason: collision with root package name */
    private IImageButton f23848d;

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    private void a(String str) {
        ae a2 = new ae.a(this).a();
        this.f23846b = a2;
        a2.a(true);
        this.f23845a.setPlayer(this.f23846b);
        this.f23846b.a((i) new l.a(new com.google.android.exoplayer2.upstream.l(getApplicationContext(), ad.a(getApplicationContext(), "C-FLY2"))).a(Uri.parse(str)));
    }

    public void a() {
        try {
            Field declaredField = this.f23845a.getClass().getDeclaredField("controller");
            declaredField.setAccessible(true);
            PlayerControlView playerControlView = (PlayerControlView) declaredField.get(this.f23845a);
            View findViewById = playerControlView.findViewById(R.id.exo_prev);
            View findViewById2 = playerControlView.findViewById(R.id.exo_next);
            View findViewById3 = playerControlView.findViewById(R.id.exo_rew);
            View findViewById4 = playerControlView.findViewById(R.id.exo_ffwd);
            ViewGroup viewGroup = (ViewGroup) findViewById4.getParent();
            viewGroup.removeView(findViewById);
            viewGroup.removeView(findViewById2);
            viewGroup.removeView(findViewById3);
            viewGroup.removeView(findViewById4);
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
        this.f23846b.G();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.exo_player_activity);
        this.f23845a = (PlayerView) findViewById(R.id.exo_player);
        this.f23847c = (TextView) findViewById(R.id.video_tv);
        this.f23848d = (IImageButton) findViewById(R.id.go_back);
        String stringExtra = getIntent().getStringExtra("open_video");
        String stringExtra2 = getIntent().getStringExtra("video_info");
        if (getIntent().getBooleanExtra("hide_ctrl_btn", false)) {
            a();
        }
        this.f23847c.setText(stringExtra2);
        this.f23848d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ExoPlayerActivity.this.a(view);
            }
        });
        a(stringExtra);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ae aeVar = this.f23846b;
        if (aeVar != null) {
            aeVar.G();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        ae aeVar = this.f23846b;
        if (aeVar != null) {
            aeVar.a(false);
        }
    }
}
