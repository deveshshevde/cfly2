package com.huantansheng.easyphotos.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.b;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.w;
import com.huantansheng.easyphotos.R;
import com.huantansheng.easyphotos.models.album.entity.Photo;
import com.huantansheng.easyphotos.ui.widget.PressedTextView;
import hr.a;
import hr.f;
import hr.g;
import java.util.ArrayList;

public class PuzzleSelectorActivity extends AppCompatActivity implements View.OnClickListener, a.b, f.a, g.a {

    /* renamed from: a  reason: collision with root package name */
    private hj.a f20642a;

    /* renamed from: b  reason: collision with root package name */
    private AnimatorSet f20643b;

    /* renamed from: c  reason: collision with root package name */
    private AnimatorSet f20644c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f20645d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f20646e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView f20647f;

    /* renamed from: g  reason: collision with root package name */
    private a f20648g;

    /* renamed from: h  reason: collision with root package name */
    private PressedTextView f20649h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<Photo> f20650i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private f f20651j;

    /* renamed from: k  reason: collision with root package name */
    private RecyclerView f20652k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f20653l;

    /* renamed from: m  reason: collision with root package name */
    private g f20654m;

    /* renamed from: n  reason: collision with root package name */
    private ArrayList<Photo> f20655n = new ArrayList<>();

    /* renamed from: o  reason: collision with root package name */
    private PressedTextView f20656o;

    private void a() {
        a(R.id.iv_back);
        PressedTextView pressedTextView = (PressedTextView) findViewById(R.id.tv_album_items);
        this.f20649h = pressedTextView;
        pressedTextView.setText(this.f20642a.c().get(0).f20315a);
        this.f20646e = (RelativeLayout) findViewById(R.id.m_selector_root);
        PressedTextView pressedTextView2 = (PressedTextView) findViewById(R.id.tv_done);
        this.f20656o = pressedTextView2;
        pressedTextView2.setOnClickListener(this);
        this.f20649h.setOnClickListener(this);
        d();
        c();
        b();
    }

    public static void a(Activity activity) {
        activity.startActivityForResult(new Intent(activity, PuzzleSelectorActivity.class), 16);
    }

    private void a(boolean z2) {
        AnimatorSet animatorSet;
        if (this.f20643b == null) {
            e();
        }
        if (z2) {
            this.f20645d.setVisibility(0);
            animatorSet = this.f20643b;
        } else {
            animatorSet = this.f20644c;
        }
        animatorSet.start();
    }

    private void a(int... iArr) {
        for (int findViewById : iArr) {
            findViewById(findViewById).setOnClickListener(this);
        }
    }

    private void b() {
        this.f20653l = (RecyclerView) findViewById(R.id.rv_preview_selected_photos);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 0, false);
        this.f20654m = new g(this, this.f20655n, this);
        this.f20653l.setLayoutManager(linearLayoutManager);
        this.f20653l.setAdapter(this.f20654m);
    }

    private void c() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_photos);
        this.f20652k = recyclerView;
        ((w) recyclerView.getItemAnimator()).a(false);
        this.f20650i.addAll(this.f20642a.a(0));
        this.f20651j = new f(this, this.f20650i, this);
        this.f20652k.setLayoutManager(new GridLayoutManager(this, getResources().getInteger(R.integer.photos_columns_easy_photos)));
        this.f20652k.setAdapter(this.f20651j);
    }

    private void c(int i2) {
        this.f20650i.clear();
        this.f20650i.addAll(this.f20642a.a(i2));
        this.f20651j.notifyDataSetChanged();
        this.f20652k.a(0);
    }

    private void d() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.root_view_album_items);
        this.f20645d = relativeLayout;
        relativeLayout.setOnClickListener(this);
        a(R.id.iv_album_items);
        this.f20647f = (RecyclerView) findViewById(R.id.rv_album_items);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.f20648g = new a(this, new ArrayList(this.f20642a.c()), 0, this);
        this.f20647f.setLayoutManager(linearLayoutManager);
        this.f20647f.setAdapter(this.f20648g);
    }

    private void e() {
        g();
        f();
    }

    private void f() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f20647f, "translationY", new float[]{(float) this.f20646e.getTop(), 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f20645d, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(300);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f20643b = animatorSet;
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f20643b.play(ofFloat).with(ofFloat2);
    }

    private void g() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f20647f, "translationY", new float[]{0.0f, (float) this.f20646e.getTop()});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f20645d, "alpha", new float[]{1.0f, 0.0f});
        ofFloat.setDuration(200);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f20644c = animatorSet;
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                PuzzleSelectorActivity.this.f20645d.setVisibility(8);
            }
        });
        this.f20644c.setInterpolator(new AccelerateInterpolator());
        this.f20644c.play(ofFloat).with(ofFloat2);
    }

    public void a(int i2) {
        if (this.f20655n.size() > 8) {
            Toast.makeText(getApplicationContext(), getString(R.string.selector_reach_max_image_hint_easy_photos, new Object[]{9}), 0).show();
            return;
        }
        this.f20655n.add(this.f20650i.get(i2));
        this.f20654m.notifyDataSetChanged();
        this.f20653l.c(this.f20655n.size() - 1);
        this.f20656o.setText(getString(R.string.selector_action_done_easy_photos, new Object[]{Integer.valueOf(this.f20655n.size()), 9}));
        if (this.f20655n.size() > 1) {
            this.f20656o.setVisibility(0);
        }
    }

    public void a(int i2, int i3) {
        c(i3);
        a(false);
        this.f20649h.setText(this.f20642a.c().get(i3).f20315a);
    }

    public void b(int i2) {
        this.f20655n.remove(i2);
        this.f20654m.notifyDataSetChanged();
        this.f20656o.setText(getString(R.string.selector_action_done_easy_photos, new Object[]{Integer.valueOf(this.f20655n.size()), 9}));
        if (this.f20655n.size() < 2) {
            this.f20656o.setVisibility(4);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 15) {
            setResult(-1, intent);
            finish();
        }
    }

    public void onBackPressed() {
        RelativeLayout relativeLayout = this.f20645d;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            super.onBackPressed();
        } else {
            a(false);
        }
    }

    public void onClick(View view) {
        int id2 = view.getId();
        boolean z2 = false;
        if (R.id.iv_back == id2) {
            setResult(0);
            finish();
            return;
        }
        if (R.id.tv_album_items == id2 || R.id.iv_album_items == id2) {
            if (8 == this.f20645d.getVisibility()) {
                z2 = true;
            }
        } else if (R.id.root_view_album_items != id2) {
            if (R.id.tv_done == id2) {
                ArrayList<Photo> arrayList = this.f20655n;
                PuzzleActivity.a(this, arrayList, Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + getString(R.string.app_name), "IMG", 15, false, hq.a.f13402z);
                return;
            }
            return;
        }
        a(z2);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_puzzle_selector_easy_photos);
        if (Build.VERSION.SDK_INT >= 23) {
            int statusBarColor = getWindow().getStatusBarColor();
            if (statusBarColor == 0) {
                statusBarColor = b.c(this, R.color.easy_photos_status_bar);
            }
            if (ht.a.b(statusBarColor)) {
                ia.b.a().a((Activity) this, true);
            }
        }
        hj.a a2 = hj.a.a();
        this.f20642a = a2;
        if (a2 == null || a2.c().isEmpty()) {
            finish();
        } else {
            a();
        }
    }
}
