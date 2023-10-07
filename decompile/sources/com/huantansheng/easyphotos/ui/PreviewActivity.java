package com.huantansheng.easyphotos.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.t;
import com.huantansheng.easyphotos.R;
import com.huantansheng.easyphotos.models.album.entity.Photo;
import com.huantansheng.easyphotos.ui.PreviewFragment;
import com.huantansheng.easyphotos.ui.widget.PressedTextView;
import hq.a;
import hr.c;
import ia.b;
import java.util.ArrayList;

public class PreviewActivity extends AppCompatActivity implements View.OnClickListener, PreviewFragment.a, c.a {

    /* renamed from: a  reason: collision with root package name */
    View f20571a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f20572b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f20573c = new Runnable() {
        public void run() {
            b a2 = b.a();
            PreviewActivity previewActivity = PreviewActivity.this;
            a2.b((Activity) previewActivity, previewActivity.f20571a);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f20574d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f20575e;

    /* renamed from: f  reason: collision with root package name */
    private final Runnable f20576f = new Runnable() {
        public void run() {
            PreviewActivity.this.f20574d.setVisibility(0);
            PreviewActivity.this.f20575e.setVisibility(0);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private boolean f20577g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f20578h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextView f20579i;

    /* renamed from: j  reason: collision with root package name */
    private PressedTextView f20580j;

    /* renamed from: k  reason: collision with root package name */
    private ImageView f20581k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f20582l;

    /* renamed from: m  reason: collision with root package name */
    private c f20583m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public t f20584n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public LinearLayoutManager f20585o;

    /* renamed from: p  reason: collision with root package name */
    private int f20586p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public ArrayList<Photo> f20587q = new ArrayList<>();

    /* renamed from: r  reason: collision with root package name */
    private int f20588r = 0;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public int f20589s = 0;

    /* renamed from: t  reason: collision with root package name */
    private boolean f20590t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f20591u;

    /* renamed from: v  reason: collision with root package name */
    private FrameLayout f20592v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public PreviewFragment f20593w;

    /* renamed from: x  reason: collision with root package name */
    private int f20594x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f20595y;

    public PreviewActivity() {
        boolean z2 = true;
        this.f20590t = a.f13380d == 1;
        this.f20591u = hp.a.e() != a.f13380d ? false : z2;
        this.f20595y = false;
    }

    public static void a(Activity activity, int i2, int i3) {
        Intent intent = new Intent(activity, PreviewActivity.class);
        intent.putExtra("keyOfPreviewAlbumItemIndex", i2);
        intent.putExtra("keyOfPreviewPhotoIndex", i3);
        activity.startActivityForResult(intent, 13);
    }

    private void a(Photo photo) {
        if (!hp.a.d()) {
            if (hp.a.b(0).equals(photo.f20303c)) {
                hp.a.b(photo);
                m();
            }
            hp.a.a(0);
        }
        hp.a.a(photo);
        m();
    }

    private void a(int... iArr) {
        for (int findViewById : iArr) {
            findViewById(findViewById).setOnClickListener(this);
        }
    }

    private void a(View... viewArr) {
        for (View onClickListener : viewArr) {
            onClickListener.setOnClickListener(this);
        }
    }

    private void c() {
        if (Build.VERSION.SDK_INT >= 23) {
            int c2 = androidx.core.content.b.c(this, R.color.easy_photos_status_bar);
            this.f20594x = c2;
            if (ht.a.b(c2)) {
                getWindow().addFlags(67108864);
            }
        }
    }

    private void d() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.c();
        }
    }

    private void e() {
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("keyOfPreviewAlbumItemIndex", 0);
        this.f20587q.clear();
        if (intExtra == -1) {
            this.f20587q.addAll(hp.a.f13376a);
        } else {
            this.f20587q.addAll(hj.a.f13326a.a(intExtra));
        }
        int intExtra2 = intent.getIntExtra("keyOfPreviewPhotoIndex", 0);
        this.f20586p = intExtra2;
        this.f20589s = intExtra2;
        this.f20577g = true;
    }

    private void f() {
        if (this.f20577g) {
            g();
        } else {
            h();
        }
    }

    private void g() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                PreviewActivity.this.f20574d.setVisibility(8);
                PreviewActivity.this.f20575e.setVisibility(8);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        alphaAnimation.setDuration(300);
        this.f20574d.startAnimation(alphaAnimation);
        this.f20575e.startAnimation(alphaAnimation);
        this.f20577g = false;
        this.f20572b.removeCallbacks(this.f20576f);
        this.f20572b.postDelayed(this.f20573c, 300);
    }

    private void h() {
        if (Build.VERSION.SDK_INT >= 16) {
            b.a().c((Activity) this, this.f20571a);
        }
        this.f20577g = true;
        this.f20572b.removeCallbacks(this.f20573c);
        this.f20572b.post(this.f20576f);
    }

    private void i() {
        Intent intent = new Intent();
        intent.putExtra("keyOfPreviewClickDone", false);
        setResult(this.f20588r, intent);
        finish();
    }

    private void j() {
        a(R.id.iv_back, R.id.tv_edit, R.id.tv_selector);
        this.f20575e = (FrameLayout) findViewById(R.id.m_top_bar_layout);
        if (!b.a().a((Activity) this)) {
            ((FrameLayout) findViewById(R.id.m_root_view)).setFitsSystemWindows(true);
            this.f20575e.setPadding(0, b.a().a((Context) this), 0, 0);
            if (ht.a.b(this.f20594x)) {
                b.a().a((Activity) this, true);
            }
        }
        this.f20574d = (RelativeLayout) findViewById(R.id.m_bottom_bar);
        this.f20581k = (ImageView) findViewById(R.id.iv_selector);
        this.f20579i = (TextView) findViewById(R.id.tv_number);
        this.f20580j = (PressedTextView) findViewById(R.id.tv_done);
        this.f20578h = (TextView) findViewById(R.id.tv_original);
        this.f20592v = (FrameLayout) findViewById(R.id.fl_fragment);
        this.f20593w = (PreviewFragment) getSupportFragmentManager().d(R.id.fragment_preview);
        if (a.f13387k) {
            l();
        } else {
            this.f20578h.setVisibility(8);
        }
        a(this.f20578h, this.f20580j, this.f20581k);
        k();
        o();
    }

    private void k() {
        this.f20582l = (RecyclerView) findViewById(R.id.rv_photos);
        this.f20583m = new c(this, this.f20587q, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 0, false);
        this.f20585o = linearLayoutManager;
        this.f20582l.setLayoutManager(linearLayoutManager);
        this.f20582l.setAdapter(this.f20583m);
        this.f20582l.a(this.f20586p);
        m();
        t tVar = new t();
        this.f20584n = tVar;
        tVar.a(this.f20582l);
        this.f20582l.a((RecyclerView.l) new RecyclerView.l() {
            public void a(RecyclerView recyclerView, int i2) {
                int d2;
                super.a(recyclerView, i2);
                View a2 = PreviewActivity.this.f20584n.a(PreviewActivity.this.f20585o);
                if (a2 != null && PreviewActivity.this.f20589s != (d2 = PreviewActivity.this.f20585o.d(a2))) {
                    int unused = PreviewActivity.this.f20589s = d2;
                    PreviewActivity.this.f20593w.b(-1);
                    PreviewActivity.this.f20579i.setText(PreviewActivity.this.getString(R.string.preview_current_number_easy_photos, new Object[]{Integer.valueOf(PreviewActivity.this.f20589s + 1), Integer.valueOf(PreviewActivity.this.f20587q.size())}));
                    PreviewActivity.this.m();
                }
            }
        });
        this.f20579i.setText(getString(R.string.preview_current_number_easy_photos, new Object[]{Integer.valueOf(this.f20586p + 1), Integer.valueOf(this.f20587q.size())}));
    }

    private void l() {
        TextView textView;
        int i2;
        if (a.f13390n) {
            textView = this.f20578h;
            i2 = R.color.easy_photos_fg_accent;
        } else if (a.f13388l) {
            textView = this.f20578h;
            i2 = R.color.easy_photos_fg_primary;
        } else {
            textView = this.f20578h;
            i2 = R.color.easy_photos_fg_primary_dark;
        }
        textView.setTextColor(androidx.core.content.b.c(this, i2));
    }

    /* access modifiers changed from: private */
    public void m() {
        if (this.f20587q.get(this.f20589s).f20311k) {
            this.f20581k.setImageResource(R.drawable.ic_selector_true_easy_photos);
            if (!hp.a.d()) {
                int e2 = hp.a.e();
                int i2 = 0;
                while (true) {
                    if (i2 >= e2) {
                        break;
                    } else if (this.f20587q.get(this.f20589s).f20303c.equals(hp.a.b(i2))) {
                        this.f20593w.b(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        } else {
            this.f20581k.setImageResource(R.drawable.ic_selector_easy_photos);
        }
        this.f20593w.a();
        o();
    }

    private void n() {
        String str;
        Context context;
        Context applicationContext;
        String string;
        this.f20588r = -1;
        Photo photo = this.f20587q.get(this.f20589s);
        if (this.f20590t) {
            a(photo);
        } else if (!this.f20591u) {
            photo.f20311k = !photo.f20311k;
            if (photo.f20311k) {
                int a2 = hp.a.a(photo);
                if (a2 != 0) {
                    photo.f20311k = false;
                    if (a2 == -3) {
                        context = getApplicationContext();
                        str = getString(R.string.selector_single_type_hint_easy_photos);
                    } else if (a2 == -2) {
                        context = getApplicationContext();
                        str = getString(R.string.selector_reach_max_video_hint_easy_photos, new Object[]{Integer.valueOf(a.C)});
                    } else if (a2 == -1) {
                        context = getApplicationContext();
                        str = getString(R.string.selector_reach_max_image_hint_easy_photos, new Object[]{Integer.valueOf(a.D)});
                    } else {
                        return;
                    }
                    Toast.makeText(context, str, 0).show();
                    return;
                } else if (hp.a.e() == a.f13380d) {
                    this.f20591u = true;
                }
            } else {
                hp.a.b(photo);
                this.f20593w.b(-1);
                if (this.f20591u) {
                    this.f20591u = false;
                }
            }
            m();
        } else if (photo.f20311k) {
            hp.a.b(photo);
            if (this.f20591u) {
                this.f20591u = false;
            }
            m();
        } else {
            if (a.b()) {
                applicationContext = getApplicationContext();
                string = getString(R.string.selector_reach_max_video_hint_easy_photos, new Object[]{Integer.valueOf(a.f13380d)});
            } else if (a.f13398v) {
                applicationContext = getApplicationContext();
                string = getString(R.string.selector_reach_max_hint_easy_photos, new Object[]{Integer.valueOf(a.f13380d)});
            } else {
                applicationContext = getApplicationContext();
                string = getString(R.string.selector_reach_max_image_hint_easy_photos, new Object[]{Integer.valueOf(a.f13380d)});
            }
            Toast.makeText(applicationContext, string, 0).show();
        }
    }

    private void o() {
        if (hp.a.d()) {
            if (this.f20580j.getVisibility() == 0) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f);
                scaleAnimation.setDuration(200);
                this.f20580j.startAnimation(scaleAnimation);
            }
            this.f20580j.setVisibility(8);
            this.f20592v.setVisibility(8);
            return;
        }
        if (8 == this.f20580j.getVisibility()) {
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f);
            scaleAnimation2.setDuration(200);
            this.f20580j.startAnimation(scaleAnimation2);
        }
        this.f20592v.setVisibility(0);
        this.f20580j.setVisibility(0);
        this.f20580j.setText(getString(R.string.selector_action_done_easy_photos, new Object[]{Integer.valueOf(hp.a.e()), Integer.valueOf(a.f13380d)}));
    }

    public void a() {
        f();
    }

    public void a(int i2) {
        String b2 = hp.a.b(i2);
        int size = this.f20587q.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (TextUtils.equals(b2, this.f20587q.get(i3).f20303c)) {
                this.f20582l.a(i3);
                this.f20589s = i3;
                this.f20579i.setText(getString(R.string.preview_current_number_easy_photos, new Object[]{Integer.valueOf(this.f20589s + 1), Integer.valueOf(this.f20587q.size())}));
                this.f20593w.b(i2);
                m();
                return;
            }
        }
    }

    public void b() {
        if (this.f20577g) {
            g();
        }
    }

    public void onBackPressed() {
        i();
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (R.id.iv_back == id2) {
            i();
        } else if (R.id.tv_selector == id2 || R.id.iv_selector == id2) {
            n();
        } else if (R.id.tv_original == id2) {
            if (!a.f13388l) {
                Toast.makeText(getApplicationContext(), a.f13389m, 0).show();
                return;
            }
            a.f13390n = !a.f13390n;
            l();
        } else if (R.id.tv_done == id2 && !this.f20595y) {
            this.f20595y = true;
            Intent intent = new Intent();
            intent.putExtra("keyOfPreviewClickDone", true);
            setResult(-1, intent);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f20571a = getWindow().getDecorView();
        b.a().a((Activity) this, this.f20571a);
        setContentView(R.layout.activity_preview_easy_photos);
        d();
        c();
        if (hj.a.f13326a == null) {
            finish();
            return;
        }
        e();
        j();
    }
}
