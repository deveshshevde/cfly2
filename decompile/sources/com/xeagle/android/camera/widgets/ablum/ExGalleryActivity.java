package com.xeagle.android.camera.widgets.ablum;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.cfly.uav_pro.R;
import com.flypro.photoview_library.PhotoView;
import com.xeagle.android.utils.Utils;
import com.xeagle.android.vjoystick.utils.d;
import com.xeagle.android.widgets.HackyViewPager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExGalleryActivity extends AppCompatActivity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ViewPager f22419a;

    /* renamed from: b  reason: collision with root package name */
    private int f22420b;

    /* renamed from: c  reason: collision with root package name */
    private a f22421c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f22422d = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public List<String> f22423e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private boolean f22424f = false;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public PhotoView f22425g;

    /* renamed from: h  reason: collision with root package name */
    private Toolbar f22426h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f22427i = false;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Handler f22428j = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public Runnable f22429k = new Runnable() {
        public void run() {
            if (ExGalleryActivity.this.f22423e.size() > 0) {
                ExGalleryActivity.this.f22419a.setCurrentItem((ExGalleryActivity.this.f22419a.getCurrentItem() + 1) % ExGalleryActivity.this.f22423e.size(), false);
                ExGalleryActivity.this.f22428j.postDelayed(ExGalleryActivity.this.f22429k, 3000);
            }
        }
    };

    /* renamed from: l  reason: collision with root package name */
    private Toolbar.b f22430l = new Toolbar.b() {
        public boolean a(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.action_auto) {
                ExGalleryActivity.this.a(menuItem);
                return true;
            } else if (itemId == R.id.action_lock) {
                ExGalleryActivity.this.a();
                ExGalleryActivity.this.b(menuItem);
                return true;
            } else if (itemId != R.id.action_share) {
                return true;
            } else {
                File file = new File((String) ExGalleryActivity.this.f22423e.get(ExGalleryActivity.this.f22419a.getCurrentItem()));
                if (!file.exists()) {
                    return true;
                }
                Uri fromFile = Uri.fromFile(file);
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.STREAM", fromFile);
                intent.setType("image/*");
                ExGalleryActivity exGalleryActivity = ExGalleryActivity.this;
                exGalleryActivity.startActivity(Intent.createChooser(intent, exGalleryActivity.getString(R.string.string_share_to)));
                return true;
            }
        }
    };

    class a extends androidx.viewpager.widget.a {

        /* renamed from: b  reason: collision with root package name */
        private List<String> f22435b;

        public a(List<String> list) {
            this.f22435b = list;
        }

        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return this.f22435b.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            PhotoView unused = ExGalleryActivity.this.f22425g = new PhotoView(viewGroup.getContext());
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            ExGalleryActivity.this.f22425g.setImageBitmap(BitmapFactory.decodeFile((String) ExGalleryActivity.this.f22423e.get(i2), options));
            viewGroup.addView(ExGalleryActivity.this.f22425g, -1, -1);
            return ExGalleryActivity.this.f22425g;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        if (b()) {
            ((HackyViewPager) this.f22419a).a();
        }
    }

    /* access modifiers changed from: private */
    public void a(MenuItem menuItem) {
        if (this.f22427i) {
            menuItem.setTitle(getString(R.string.menu_auto_play));
            this.f22428j.removeCallbacks(this.f22429k);
        } else {
            menuItem.setTitle(getString(R.string.menu_stop_play));
            this.f22428j.postDelayed(this.f22429k, 3000);
        }
        this.f22427i = !this.f22427i;
    }

    /* access modifiers changed from: private */
    public void b(MenuItem menuItem) {
        boolean b2 = b() ? ((HackyViewPager) this.f22419a).b() : false;
        int i2 = b2 ? R.drawable.unlock_64 : R.drawable.lock_64;
        String string = getString(b2 ? R.string.menu_unlock : R.string.menu_lock);
        if (menuItem != null) {
            menuItem.setTitle(string);
            menuItem.setIcon(i2);
        }
    }

    private boolean b() {
        ViewPager viewPager = this.f22419a;
        return viewPager != null && (viewPager instanceof HackyViewPager);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.exgallery_activity);
        Utils.b(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool);
        this.f22426h = toolbar;
        toolbar.setNavigationIcon((int) R.drawable.go_back);
        this.f22426h.setTitle((CharSequence) "");
        setSupportActionBar(this.f22426h);
        this.f22426h.setOnMenuItemClickListener(this.f22430l);
        this.f22426h.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ExGalleryActivity.this.finish();
            }
        });
        this.f22423e.clear();
        this.f22423e = d.b(new File(d.a(getApplicationContext()) + d.f25365a));
        this.f22420b = getIntent().getExtras().getInt("position");
        this.f22419a = (HackyViewPager) findViewById(R.id.view_pager);
        a aVar = new a(this.f22423e);
        this.f22421c = aVar;
        this.f22419a.setAdapter(aVar);
        this.f22419a.setCurrentItem(this.f22420b);
        if (bundle != null) {
            ((HackyViewPager) this.f22419a).setLocked(bundle.getBoolean("isLocked", false));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f22422d.removeCallbacksAndMessages((Object) null);
        Handler handler = this.f22428j;
        if (handler != null) {
            handler.removeCallbacks(this.f22429k);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        if (b()) {
            bundle.putBoolean("isLocked", ((HackyViewPager) this.f22419a).b());
        }
        super.onSaveInstanceState(bundle);
    }
}
