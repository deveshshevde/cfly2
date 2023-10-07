package com.huantansheng.easyphotos.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.w;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.huantansheng.easyphotos.R;
import com.huantansheng.easyphotos.models.album.entity.Photo;
import com.huantansheng.easyphotos.ui.widget.PressedTextView;
import hi.a;
import hj.a;
import hr.a;
import hr.b;
import hx.a;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class EasyPhotosActivity extends AppCompatActivity implements View.OnClickListener, a, a.b, b.C0098b {

    /* renamed from: a  reason: collision with root package name */
    public static long f20531a;
    /* access modifiers changed from: private */
    public TextView A;
    private View B;
    private boolean C = false;
    /* access modifiers changed from: private */
    public Uri D = null;
    private boolean E = false;

    /* renamed from: b  reason: collision with root package name */
    hs.a f20532b;

    /* renamed from: c  reason: collision with root package name */
    String f20533c;

    /* renamed from: d  reason: collision with root package name */
    String f20534d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public File f20535e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public hj.a f20536f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<Object> f20537g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<Object> f20538h = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<Photo> f20539i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private RecyclerView f20540j;

    /* renamed from: k  reason: collision with root package name */
    private b f20541k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public GridLayoutManager f20542l;

    /* renamed from: m  reason: collision with root package name */
    private RecyclerView f20543m;

    /* renamed from: n  reason: collision with root package name */
    private hr.a f20544n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public RelativeLayout f20545o;

    /* renamed from: p  reason: collision with root package name */
    private PressedTextView f20546p;

    /* renamed from: q  reason: collision with root package name */
    private PressedTextView f20547q;

    /* renamed from: r  reason: collision with root package name */
    private PressedTextView f20548r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f20549s;

    /* renamed from: t  reason: collision with root package name */
    private AnimatorSet f20550t;

    /* renamed from: u  reason: collision with root package name */
    private AnimatorSet f20551u;

    /* renamed from: v  reason: collision with root package name */
    private int f20552v = 0;

    /* renamed from: w  reason: collision with root package name */
    private ImageView f20553w;

    /* renamed from: x  reason: collision with root package name */
    private TextView f20554x;

    /* renamed from: y  reason: collision with root package name */
    private LinearLayout f20555y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public RelativeLayout f20556z;

    /* access modifiers changed from: private */
    public Photo a(Uri uri) {
        int i2;
        int i3;
        int i4;
        String[] d2 = hj.a.a().d();
        boolean z2 = d2.length > 8;
        Cursor query = getContentResolver().query(uri, d2, (String) null, (String[]) null, (String) null);
        Photo photo = null;
        if (query == null) {
            return null;
        }
        int columnIndex = query.getColumnIndex("bucket_display_name");
        if (query.moveToFirst()) {
            String string = query.getString(1);
            String string2 = query.getString(2);
            long j2 = query.getLong(3);
            String string3 = query.getString(4);
            long j3 = query.getLong(5);
            if (z2) {
                int i5 = query.getInt(query.getColumnIndex("width"));
                int i6 = query.getInt(query.getColumnIndex("height"));
                int i7 = query.getInt(query.getColumnIndex("orientation"));
                if (90 == i7 || 270 == i7) {
                    i4 = i6;
                    i2 = i7;
                    i3 = i5;
                } else {
                    i3 = i6;
                    i2 = i7;
                    i4 = i5;
                }
            } else {
                i4 = 0;
                i3 = 0;
                i2 = 0;
            }
            if (columnIndex > 0) {
                String string4 = query.getString(columnIndex);
                this.f20534d = string4;
                this.f20533c = string4;
            }
            photo = new Photo(string2, uri, string, j2, i4, i3, i2, j3, 0, string3);
        }
        query.close();
        return photo;
    }

    private void a(int i2) {
        if (TextUtils.isEmpty(hq.a.f13391o)) {
            throw new RuntimeException("AlbumBuilder : 请执行 setFileProviderAuthority()方法");
        } else if (!f()) {
            this.f20556z.setVisibility(0);
            this.A.setText(R.string.permissions_die_easy_photos);
            this.f20556z.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    EasyPhotosActivity easyPhotosActivity = EasyPhotosActivity.this;
                    hz.a.a(easyPhotosActivity, easyPhotosActivity.getPackageName());
                }
            });
        } else {
            b(i2);
        }
    }

    public static void a(Activity activity, int i2) {
        if (!a()) {
            activity.startActivityForResult(new Intent(activity, EasyPhotosActivity.class), i2);
        }
    }

    public static void a(Fragment fragment, int i2) {
        if (!a()) {
            fragment.startActivityForResult(new Intent(fragment.getActivity(), EasyPhotosActivity.class), i2);
        }
    }

    public static void a(androidx.fragment.app.Fragment fragment, int i2) {
        if (!a()) {
            fragment.startActivityForResult(new Intent(fragment.getContext(), EasyPhotosActivity.class), i2);
        }
    }

    /* access modifiers changed from: private */
    public void a(Photo photo) {
        Integer num;
        photo.f20312l = hq.a.f13390n;
        if (!this.C) {
            hw.b.a((Context) this, photo.f20303c);
            String absolutePath = new File(photo.f20303c).getParentFile().getAbsolutePath();
            this.f20533c = absolutePath;
            this.f20534d = hu.a.a(absolutePath);
        }
        this.f20536f.f13327b.a(this.f20536f.a((Context) this)).a(0, photo);
        this.f20536f.f13327b.a(this.f20534d, this.f20533c, photo.f20303c, photo.f20301a);
        this.f20536f.f13327b.a(this.f20534d).a(0, photo);
        this.f20538h.clear();
        this.f20538h.addAll(this.f20536f.c());
        if (hq.a.d()) {
            int i2 = 2;
            if (this.f20538h.size() < 3) {
                i2 = this.f20538h.size() - 1;
            }
            this.f20538h.add(i2, hq.a.f13382f);
        }
        this.f20544n.notifyDataSetChanged();
        if (hq.a.f13380d == 1) {
            hp.a.c();
        } else if (hp.a.e() >= hq.a.f13380d) {
            num = null;
            a(num);
            this.f20543m.a(0);
            this.f20544n.a(0);
            x();
        }
        num = Integer.valueOf(hp.a.a(photo));
        a(num);
        this.f20543m.a(0);
        this.f20544n.a(0);
        x();
    }

    private void a(boolean z2) {
        AnimatorSet animatorSet;
        if (this.f20551u == null) {
            u();
        }
        if (z2) {
            this.f20545o.setVisibility(0);
            animatorSet = this.f20551u;
        } else {
            animatorSet = this.f20550t;
        }
        animatorSet.start();
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

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f20531a < 600) {
            return true;
        }
        f20531a = currentTimeMillis;
        return false;
    }

    private void b(int i2) {
        Context applicationContext;
        int i3;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) == null && !getPackageManager().hasSystemFeature("android.hardware.camera.any")) {
            applicationContext = getApplicationContext();
            i3 = R.string.msg_no_camera_easy_photos;
        } else if (this.C) {
            Uri j2 = j();
            this.D = j2;
            intent.putExtra("output", j2);
            intent.addFlags(1);
            intent.addFlags(2);
            startActivityForResult(intent, i2);
            return;
        } else {
            k();
            File file = this.f20535e;
            if (file == null || !file.isFile()) {
                applicationContext = getApplicationContext();
                i3 = R.string.camera_temp_file_error_easy_photos;
            } else {
                Uri a2 = ib.a.a((Context) this, this.f20535e);
                intent.addFlags(1);
                intent.addFlags(2);
                intent.putExtra("output", a2);
                startActivityForResult(intent, i2);
                return;
            }
        }
        Toast.makeText(applicationContext, i3, 0).show();
    }

    private void c(int i2) {
        this.f20552v = i2;
        this.f20537g.clear();
        this.f20537g.addAll(this.f20536f.a(i2));
        if (hq.a.c()) {
            this.f20537g.add(0, hq.a.f13381e);
        }
        if (hq.a.f13392p && !hq.a.e()) {
            this.f20537g.add(hq.a.c() ? 1 : 0, (Object) null);
        }
        this.f20541k.a();
        this.f20540j.a(0);
    }

    private void g() {
        if (Build.VERSION.SDK_INT >= 23) {
            int statusBarColor = getWindow().getStatusBarColor();
            if (statusBarColor == 0) {
                statusBarColor = androidx.core.content.b.c(this, R.color.colorPrimaryDark);
            }
            if (ht.a.b(statusBarColor)) {
                ia.b.a().a((Activity) this, true);
            }
        }
    }

    private void h() {
        this.B = findViewById(R.id.m_bottom_bar);
        this.f20556z = (RelativeLayout) findViewById(R.id.rl_permissions_view);
        this.A = (TextView) findViewById(R.id.tv_permission);
        this.f20545o = (RelativeLayout) findViewById(R.id.root_view_album_items);
        this.f20554x = (TextView) findViewById(R.id.tv_title);
        if (hq.a.b()) {
            this.f20554x.setText(R.string.video_selection_easy_photos);
        }
        findViewById(R.id.iv_second_menu).setVisibility((hq.a.f13395s || hq.a.f13399w || hq.a.f13387k) ? 0 : 8);
        a(R.id.iv_back);
    }

    /* access modifiers changed from: private */
    public void i() {
        this.f20556z.setVisibility(8);
        if (hq.a.f13394r) {
            a(11);
            return;
        }
        AnonymousClass1 r0 = new a.C0095a() {
            public void a() {
                EasyPhotosActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        EasyPhotosActivity.this.f20532b.dismiss();
                        EasyPhotosActivity.this.n();
                    }
                });
            }
        };
        this.f20532b.show();
        hj.a a2 = hj.a.a();
        this.f20536f = a2;
        a2.a((Context) this, (a.C0095a) r0);
    }

    private Uri j() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", String.valueOf(System.currentTimeMillis()));
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", "Pictures");
        }
        contentValues.put("mime_type", "image/JPEG");
        return getContentResolver().insert(MediaStore.Images.Media.getContentUri("external"), contentValues);
    }

    private void k() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (externalStoragePublicDirectory == null) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            externalStoragePublicDirectory = new File(externalStorageDirectory, File.separator + "DCIM" + File.separator + "Camera" + File.separator);
        }
        if (!externalStoragePublicDirectory.isDirectory() && !externalStoragePublicDirectory.mkdirs() && (((externalStoragePublicDirectory = getExternalFilesDir((String) null)) == null || !externalStoragePublicDirectory.exists()) && (((externalStoragePublicDirectory = getFilesDir()) == null || !externalStoragePublicDirectory.exists()) && ((externalStoragePublicDirectory = getFilesDir()) == null || !externalStoragePublicDirectory.exists())))) {
            File file = new File(File.separator + AeUtil.ROOT_DATA_PATH_OLD_NAME + File.separator + AeUtil.ROOT_DATA_PATH_OLD_NAME + File.separator + getPackageName() + File.separator + "cache" + File.separator);
            if (!file.exists()) {
                file.mkdirs();
            }
            externalStoragePublicDirectory = file;
        }
        try {
            this.f20535e = File.createTempFile("IMG", ".jpg", externalStoragePublicDirectory);
        } catch (IOException e2) {
            e2.printStackTrace();
            this.f20535e = null;
        }
    }

    private void l() {
        this.f20532b.show();
        new Thread(new Runnable() {
            public void run() {
                EasyPhotosActivity easyPhotosActivity = EasyPhotosActivity.this;
                final Photo a2 = easyPhotosActivity.a(easyPhotosActivity.D);
                if (a2 == null) {
                    Log.e("easyPhotos", "onCameraResultForQ() -》photo = null");
                } else {
                    EasyPhotosActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            EasyPhotosActivity.this.f20532b.dismiss();
                            if (hq.a.f13394r || EasyPhotosActivity.this.f20536f.c().isEmpty()) {
                                Intent intent = new Intent();
                                a2.f20312l = hq.a.f13390n;
                                EasyPhotosActivity.this.f20539i.add(a2);
                                intent.putParcelableArrayListExtra("keyOfEasyPhotosResult", EasyPhotosActivity.this.f20539i);
                                intent.putExtra("keyOfEasyPhotosResultSelectedOriginal", hq.a.f13390n);
                                EasyPhotosActivity.this.setResult(-1, intent);
                                EasyPhotosActivity.this.finish();
                                return;
                            }
                            EasyPhotosActivity.this.a(a2);
                        }
                    });
                }
            }
        }).start();
    }

    private void m() {
        hs.a.a(this);
        new Thread(new Runnable() {
            public void run() {
                int i2;
                int i3;
                int i4;
                File file = new File(EasyPhotosActivity.this.f20535e.getParentFile(), String.format("IMG_%s.jpg", new Object[]{new SimpleDateFormat("yyyyMMdd_HH_mm_ss", Locale.getDefault()).format(new Date())}));
                if (!file.exists() && EasyPhotosActivity.this.f20535e.renameTo(file)) {
                    File unused = EasyPhotosActivity.this.f20535e = file;
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(EasyPhotosActivity.this.f20535e.getAbsolutePath(), options);
                EasyPhotosActivity easyPhotosActivity = EasyPhotosActivity.this;
                hw.b.a((Context) easyPhotosActivity, easyPhotosActivity.f20535e);
                EasyPhotosActivity easyPhotosActivity2 = EasyPhotosActivity.this;
                Uri a2 = ib.a.a((Context) easyPhotosActivity2, easyPhotosActivity2.f20535e);
                if (hq.a.f13385i) {
                    int i5 = options.outWidth;
                    int i6 = options.outHeight;
                    z.a aVar = null;
                    try {
                        aVar = new z.a(EasyPhotosActivity.this.f20535e);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    if (aVar != null) {
                        int a3 = aVar.a("Orientation", -1);
                        if (a3 == 6 || a3 == 8) {
                            i4 = options.outHeight;
                            i3 = options.outWidth;
                            i2 = a3;
                        } else {
                            i4 = i5;
                            i2 = a3;
                            i3 = i6;
                        }
                        final Photo photo = new Photo(EasyPhotosActivity.this.f20535e.getName(), a2, EasyPhotosActivity.this.f20535e.getAbsolutePath(), EasyPhotosActivity.this.f20535e.lastModified() / 1000, i4, i3, i2, EasyPhotosActivity.this.f20535e.length(), hw.a.a(EasyPhotosActivity.this.f20535e.getAbsolutePath()), options.outMimeType);
                        EasyPhotosActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                if (hq.a.f13394r || EasyPhotosActivity.this.f20536f.c().isEmpty()) {
                                    Intent intent = new Intent();
                                    photo.f20312l = hq.a.f13390n;
                                    EasyPhotosActivity.this.f20539i.add(photo);
                                    intent.putParcelableArrayListExtra("keyOfEasyPhotosResult", EasyPhotosActivity.this.f20539i);
                                    intent.putExtra("keyOfEasyPhotosResultSelectedOriginal", hq.a.f13390n);
                                    EasyPhotosActivity.this.setResult(-1, intent);
                                    EasyPhotosActivity.this.finish();
                                    return;
                                }
                                EasyPhotosActivity.this.a(photo);
                            }
                        });
                    }
                    i4 = i5;
                    i3 = i6;
                } else {
                    i4 = 0;
                    i3 = 0;
                }
                i2 = 0;
                final Photo photo2 = new Photo(EasyPhotosActivity.this.f20535e.getName(), a2, EasyPhotosActivity.this.f20535e.getAbsolutePath(), EasyPhotosActivity.this.f20535e.lastModified() / 1000, i4, i3, i2, EasyPhotosActivity.this.f20535e.length(), hw.a.a(EasyPhotosActivity.this.f20535e.getAbsolutePath()), options.outMimeType);
                EasyPhotosActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        if (hq.a.f13394r || EasyPhotosActivity.this.f20536f.c().isEmpty()) {
                            Intent intent = new Intent();
                            photo2.f20312l = hq.a.f13390n;
                            EasyPhotosActivity.this.f20539i.add(photo2);
                            intent.putParcelableArrayListExtra("keyOfEasyPhotosResult", EasyPhotosActivity.this.f20539i);
                            intent.putExtra("keyOfEasyPhotosResultSelectedOriginal", hq.a.f13390n);
                            EasyPhotosActivity.this.setResult(-1, intent);
                            EasyPhotosActivity.this.finish();
                            return;
                        }
                        EasyPhotosActivity.this.a(photo2);
                    }
                });
            }
        }).start();
    }

    /* access modifiers changed from: private */
    public void n() {
        o();
    }

    private void o() {
        if (!this.f20536f.c().isEmpty()) {
            com.huantansheng.easyphotos.a.a((hi.a) this);
            if (hq.a.c()) {
                findViewById(R.id.m_tool_bar_bottom_line).setVisibility(8);
            }
            this.f20553w = (ImageView) findViewById(R.id.fab_camera);
            if (hq.a.f13392p && hq.a.e()) {
                this.f20553w.setVisibility(0);
            }
            if (!hq.a.f13395s) {
                findViewById(R.id.tv_puzzle).setVisibility(8);
            }
            this.f20555y = (LinearLayout) findViewById(R.id.m_second_level_menu);
            int integer = getResources().getInteger(R.integer.photos_columns_easy_photos);
            PressedTextView pressedTextView = (PressedTextView) findViewById(R.id.tv_album_items);
            this.f20546p = pressedTextView;
            pressedTextView.setText(this.f20536f.c().get(0).f20315a);
            this.f20547q = (PressedTextView) findViewById(R.id.tv_done);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_photos);
            this.f20540j = recyclerView;
            ((w) recyclerView.getItemAnimator()).a(false);
            this.f20537g.clear();
            this.f20537g.addAll(this.f20536f.a(0));
            if (hq.a.c()) {
                this.f20537g.add(0, hq.a.f13381e);
            }
            if (hq.a.f13392p && !hq.a.e()) {
                this.f20537g.add(hq.a.c() ? 1 : 0, (Object) null);
            }
            this.f20541k = new b(this, this.f20537g, this);
            this.f20542l = new GridLayoutManager(this, integer);
            if (hq.a.c()) {
                this.f20542l.a((GridLayoutManager.b) new GridLayoutManager.b() {
                    public int getSpanSize(int i2) {
                        if (i2 == 0) {
                            return EasyPhotosActivity.this.f20542l.b();
                        }
                        return 1;
                    }
                });
            }
            this.f20540j.setLayoutManager(this.f20542l);
            this.f20540j.setAdapter(this.f20541k);
            this.f20549s = (TextView) findViewById(R.id.tv_original);
            if (hq.a.f13387k) {
                t();
            } else {
                this.f20549s.setVisibility(8);
            }
            this.f20548r = (PressedTextView) findViewById(R.id.tv_preview);
            q();
            x();
            a(R.id.iv_album_items, R.id.tv_clear, R.id.iv_second_menu, R.id.tv_puzzle);
            a(this.f20546p, this.f20545o, this.f20547q, this.f20549s, this.f20548r, this.f20553w);
        } else if (hq.a.b()) {
            Toast.makeText(getApplicationContext(), R.string.no_videos_easy_photos, 1).show();
            finish();
        } else {
            Toast.makeText(getApplicationContext(), R.string.no_photos_easy_photos, 1).show();
            if (hq.a.f13392p) {
                a(11);
            } else {
                finish();
            }
        }
    }

    private void p() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.c();
        }
    }

    private void q() {
        this.f20543m = (RecyclerView) findViewById(R.id.rv_album_items);
        this.f20538h.clear();
        this.f20538h.addAll(this.f20536f.c());
        if (hq.a.d()) {
            int i2 = 2;
            if (this.f20538h.size() < 3) {
                i2 = this.f20538h.size() - 1;
            }
            this.f20538h.add(i2, hq.a.f13382f);
        }
        this.f20544n = new hr.a(this, this.f20538h, 0, this);
        this.f20543m.setLayoutManager(new LinearLayoutManager(this));
        this.f20543m.setAdapter(this.f20544n);
    }

    private void r() {
        if (!this.E) {
            this.E = true;
            s();
        }
    }

    private void s() {
        Intent intent = new Intent();
        hp.a.b();
        this.f20539i.addAll(hp.a.f13376a);
        intent.putParcelableArrayListExtra("keyOfEasyPhotosResult", this.f20539i);
        intent.putExtra("keyOfEasyPhotosResultSelectedOriginal", hq.a.f13390n);
        setResult(-1, intent);
        finish();
    }

    private void t() {
        TextView textView;
        int i2;
        if (hq.a.f13387k) {
            if (hq.a.f13390n) {
                textView = this.f20549s;
                i2 = R.color.easy_photos_fg_accent;
            } else if (hq.a.f13388l) {
                textView = this.f20549s;
                i2 = R.color.easy_photos_fg_primary;
            } else {
                textView = this.f20549s;
                i2 = R.color.easy_photos_fg_primary_dark;
            }
            textView.setTextColor(androidx.core.content.b.c(this, i2));
        }
    }

    private void u() {
        w();
        v();
    }

    private void v() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f20543m, "translationY", new float[]{(float) this.B.getTop(), 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f20545o, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(300);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f20551u = animatorSet;
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f20551u.play(ofFloat).with(ofFloat2);
    }

    private void w() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f20543m, "translationY", new float[]{0.0f, (float) this.B.getTop()});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f20545o, "alpha", new float[]{1.0f, 0.0f});
        ofFloat.setDuration(200);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f20550t = animatorSet;
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                EasyPhotosActivity.this.f20545o.setVisibility(8);
            }
        });
        this.f20550t.setInterpolator(new AccelerateInterpolator());
        this.f20550t.play(ofFloat).with(ofFloat2);
    }

    private void x() {
        if (hp.a.d()) {
            if (this.f20547q.getVisibility() == 0) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f);
                scaleAnimation.setDuration(200);
                this.f20547q.startAnimation(scaleAnimation);
            }
            this.f20547q.setVisibility(4);
            this.f20548r.setVisibility(4);
        } else {
            if (4 == this.f20547q.getVisibility()) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f);
                scaleAnimation2.setDuration(200);
                this.f20547q.startAnimation(scaleAnimation2);
            }
            this.f20547q.setVisibility(0);
            this.f20548r.setVisibility(0);
        }
        this.f20547q.setText(getString(R.string.selector_action_done_easy_photos, new Object[]{Integer.valueOf(hp.a.e()), Integer.valueOf(hq.a.f13380d)}));
    }

    public void a(int i2, int i3) {
        c(i3);
        a(false);
        this.f20546p.setText(this.f20536f.c().get(i3).f20315a);
    }

    public void a(Integer num) {
        Context context;
        String str;
        Context applicationContext;
        String string;
        if (num == null) {
            if (hq.a.b()) {
                applicationContext = getApplicationContext();
                string = getString(R.string.selector_reach_max_video_hint_easy_photos, new Object[]{Integer.valueOf(hq.a.f13380d)});
            } else if (hq.a.f13398v) {
                applicationContext = getApplicationContext();
                string = getString(R.string.selector_reach_max_hint_easy_photos, new Object[]{Integer.valueOf(hq.a.f13380d)});
            } else {
                applicationContext = getApplicationContext();
                string = getString(R.string.selector_reach_max_image_hint_easy_photos, new Object[]{Integer.valueOf(hq.a.f13380d)});
            }
            Toast.makeText(applicationContext, string, 0).show();
            return;
        }
        int intValue = num.intValue();
        if (intValue == -3) {
            context = getApplicationContext();
            str = getString(R.string.selector_single_type_hint_easy_photos);
        } else if (intValue == -2) {
            context = getApplicationContext();
            str = getString(R.string.selector_reach_max_video_hint_easy_photos, new Object[]{Integer.valueOf(hq.a.C)});
        } else if (intValue == -1) {
            context = getApplicationContext();
            str = getString(R.string.selector_reach_max_image_hint_easy_photos, new Object[]{Integer.valueOf(hq.a.D)});
        } else {
            return;
        }
        Toast.makeText(context, str, 0).show();
    }

    public void b(int i2, int i3) {
        PreviewActivity.a(this, this.f20552v, i3);
    }

    /* access modifiers changed from: protected */
    public String[] b() {
        return hq.a.f13392p ? Build.VERSION.SDK_INT >= 16 ? new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"} : new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"} : Build.VERSION.SDK_INT >= 16 ? new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"} : new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
    }

    public void c() {
        LinearLayout linearLayout = this.f20555y;
        if (linearLayout != null) {
            if (linearLayout.getVisibility() == 0) {
                this.f20555y.setVisibility(4);
                if (hq.a.f13392p && hq.a.e()) {
                    this.f20553w.setVisibility(0);
                    return;
                }
                return;
            }
            this.f20555y.setVisibility(0);
            if (hq.a.f13392p && hq.a.e()) {
                this.f20553w.setVisibility(4);
            }
        }
    }

    public void d() {
        a(11);
    }

    public void e() {
        x();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0011 A[SYNTHETIC, Splitter:B:10:0x0011] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f() {
        /*
            r2 = this;
            android.hardware.Camera r0 = android.hardware.Camera.open()     // Catch:{ Exception -> 0x000d }
            android.hardware.Camera$Parameters r1 = r0.getParameters()     // Catch:{ Exception -> 0x000e }
            r0.setParameters(r1)     // Catch:{ Exception -> 0x000e }
            r1 = 1
            goto L_0x000f
        L_0x000d:
            r0 = 0
        L_0x000e:
            r1 = 0
        L_0x000f:
            if (r0 == 0) goto L_0x0019
            r0.release()     // Catch:{ Exception -> 0x0015 }
            goto L_0x0019
        L_0x0015:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huantansheng.easyphotos.ui.EasyPhotosActivity.f():boolean");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 14) {
            if (hx.a.a(this, b())) {
                i();
            } else {
                this.f20556z.setVisibility(0);
            }
        } else if (i3 != -1) {
            if (i3 == 0) {
                if (11 == i2) {
                    File file = this.f20535e;
                    if (file != null && file.exists()) {
                        this.f20535e.delete();
                        this.f20535e = null;
                    }
                    if (hq.a.f13394r) {
                        finish();
                    }
                } else if (13 == i2) {
                    t();
                }
            }
        } else if (11 == i2) {
            if (this.C) {
                l();
                return;
            }
            File file2 = this.f20535e;
            if (file2 == null || !file2.isFile()) {
                throw new RuntimeException("EasyPhotos拍照保存的图片不存在");
            }
            m();
        } else if (13 == i2) {
            if (intent.getBooleanExtra("keyOfPreviewClickDone", false)) {
                r();
                return;
            }
            this.f20541k.a();
            t();
            x();
        } else if (16 == i2) {
            a((Photo) intent.getParcelableExtra("keyOfEasyPhotosResult"));
        }
    }

    public void onBackPressed() {
        RelativeLayout relativeLayout = this.f20545o;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            LinearLayout linearLayout = this.f20555y;
            if (linearLayout == null || linearLayout.getVisibility() != 0) {
                hj.a aVar = this.f20536f;
                if (aVar != null) {
                    aVar.b();
                }
                if (hq.a.c()) {
                    this.f20541k.b();
                }
                if (hq.a.d()) {
                    this.f20544n.a();
                }
                setResult(0);
                finish();
                return;
            }
            c();
            return;
        }
        a(false);
    }

    public void onClick(View view) {
        int id2 = view.getId();
        boolean z2 = true;
        if (R.id.tv_album_items == id2 || R.id.iv_album_items == id2) {
            if (8 != this.f20545o.getVisibility()) {
                z2 = false;
            }
            a(z2);
        } else if (R.id.root_view_album_items == id2) {
            a(false);
        } else if (R.id.iv_back == id2) {
            onBackPressed();
        } else if (R.id.tv_done == id2) {
            r();
        } else {
            if (R.id.tv_clear == id2) {
                if (hp.a.d()) {
                    c();
                    return;
                }
                hp.a.a();
                this.f20541k.a();
                x();
            } else if (R.id.tv_original == id2) {
                if (!hq.a.f13388l) {
                    Toast.makeText(getApplicationContext(), hq.a.f13389m, 0).show();
                    return;
                } else {
                    hq.a.f13390n = !hq.a.f13390n;
                    t();
                }
            } else if (R.id.tv_preview == id2) {
                PreviewActivity.a(this, -1, 0);
                return;
            } else if (R.id.fab_camera == id2) {
                a(11);
                return;
            } else if (R.id.iv_second_menu != id2) {
                if (R.id.tv_puzzle == id2) {
                    c();
                    PuzzleSelectorActivity.a((Activity) this);
                    return;
                }
                return;
            }
            c();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_easy_photos);
        p();
        g();
        this.f20532b = hs.a.a(this);
        this.C = Build.VERSION.SDK_INT == 29;
        if (hq.a.f13394r || hq.a.f13402z != null) {
            h();
            if (hx.a.a(this, b())) {
                i();
            } else {
                this.f20556z.setVisibility(0);
            }
        } else {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        hj.a aVar = this.f20536f;
        if (aVar != null) {
            aVar.b();
        }
        super.onDestroy();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        hx.a.a(this, strArr, iArr, new a.C0099a() {
            public void a() {
                EasyPhotosActivity.this.i();
            }

            public void b() {
                EasyPhotosActivity.this.A.setText(R.string.permissions_again_easy_photos);
                EasyPhotosActivity.this.f20556z.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (hx.a.a(EasyPhotosActivity.this, EasyPhotosActivity.this.b())) {
                            EasyPhotosActivity.this.i();
                        }
                    }
                });
            }

            public void c() {
                EasyPhotosActivity.this.A.setText(R.string.permissions_die_easy_photos);
                EasyPhotosActivity.this.f20556z.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        hz.a.a(EasyPhotosActivity.this, EasyPhotosActivity.this.getPackageName());
                    }
                });
            }
        });
    }
}
