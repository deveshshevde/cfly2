package com.huantansheng.easyphotos.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.huantansheng.easyphotos.R;
import com.huantansheng.easyphotos.models.album.entity.Photo;
import com.huantansheng.easyphotos.models.puzzle.DegreeSeekBar;
import com.huantansheng.easyphotos.models.puzzle.PuzzleView;
import com.huantansheng.easyphotos.models.puzzle.c;
import com.huantansheng.easyphotos.models.puzzle.d;
import hn.a;
import hr.e;
import hr.h;
import hx.a;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PuzzleActivity extends AppCompatActivity implements View.OnClickListener, e.a, h.a {

    /* renamed from: f  reason: collision with root package name */
    private static WeakReference<Class<? extends Activity>> f20603f;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<Photo> f20604a = null;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<Bitmap> f20605b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    String f20606c;

    /* renamed from: d  reason: collision with root package name */
    String f20607d;

    /* renamed from: e  reason: collision with root package name */
    FloatingActionButton f20608e;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public PuzzleView f20609g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f20610h;

    /* renamed from: i  reason: collision with root package name */
    private e f20611i;

    /* renamed from: j  reason: collision with root package name */
    private ProgressBar f20612j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public int f20613k = 0;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public LinearLayout f20614l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public DegreeSeekBar f20615m;

    /* renamed from: n  reason: collision with root package name */
    private ArrayList<ImageView> f20616n = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public ArrayList<Integer> f20617o = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public int f20618p = -1;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public int f20619q;

    /* renamed from: r  reason: collision with root package name */
    private int f20620r = 0;

    /* renamed from: s  reason: collision with root package name */
    private int f20621s = 0;

    /* renamed from: t  reason: collision with root package name */
    private TextView f20622t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f20623u;

    /* renamed from: v  reason: collision with root package name */
    private RelativeLayout f20624v;

    /* renamed from: w  reason: collision with root package name */
    private RelativeLayout f20625w;

    /* renamed from: x  reason: collision with root package name */
    private h f20626x;

    /* renamed from: y  reason: collision with root package name */
    private a f20627y;

    /* access modifiers changed from: private */
    public Bitmap a(String str, Uri uri) {
        Bitmap bitmap;
        try {
            bitmap = hq.a.f13402z.a(this, uri, this.f20620r / 2, this.f20621s / 2);
        } catch (Exception unused) {
            bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(str), this.f20620r / 2, this.f20621s / 2, true);
        }
        return bitmap == null ? Bitmap.createScaledBitmap(BitmapFactory.decodeFile(str), this.f20620r / 2, this.f20621s / 2, true) : bitmap;
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        int size = this.f20616n.size();
        for (int i3 = 0; i3 < size; i3++) {
            ImageView imageView = this.f20616n.get(i3);
            if (imageView.getId() == i2) {
                imageView.setColorFilter(b.c(this, R.color.easy_photos_fg_accent));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    private void a(int i2, int i3, int i4, float f2) {
        this.f20619q = i2;
        this.f20615m.setVisibility(0);
        this.f20615m.a(i3, i4);
        this.f20615m.setCurrentDegrees((int) f2);
    }

    public static void a(Activity activity, ArrayList<Photo> arrayList, String str, String str2, int i2, boolean z2, hh.a aVar) {
        WeakReference<Class<? extends Activity>> weakReference = f20603f;
        if (weakReference != null) {
            weakReference.clear();
            f20603f = null;
        }
        if (hq.a.f13402z != aVar) {
            hq.a.f13402z = aVar;
        }
        Intent intent = new Intent(activity, PuzzleActivity.class);
        intent.putExtra("keyOfPuzzleFilesTypeIsPhoto", true);
        intent.putParcelableArrayListExtra("keyOfPuzzleFiles", arrayList);
        intent.putExtra("keyOfPuzzleSaveDir", str);
        intent.putExtra("keyOfPuzzleSaveNamePrefix", str2);
        if (z2) {
            f20603f = new WeakReference<>(activity.getClass());
        }
        activity.startActivityForResult(intent, i2);
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

    private void b() {
        c();
        e();
        d();
        this.f20612j = (ProgressBar) findViewById(R.id.progress);
        a(R.id.tv_back, R.id.tv_done);
    }

    private void c() {
        this.f20608e = (FloatingActionButton) findViewById(R.id.fab);
        this.f20622t = (TextView) findViewById(R.id.tv_template);
        this.f20623u = (TextView) findViewById(R.id.tv_text_sticker);
        this.f20624v = (RelativeLayout) findViewById(R.id.m_root_view);
        this.f20625w = (RelativeLayout) findViewById(R.id.m_bottom_layout);
        this.f20614l = (LinearLayout) findViewById(R.id.ll_menu);
        ImageView imageView = (ImageView) findViewById(R.id.iv_rotate);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_corner);
        ImageView imageView3 = (ImageView) findViewById(R.id.iv_padding);
        a(R.id.iv_replace, R.id.iv_mirror, R.id.iv_flip);
        a(imageView, imageView2, imageView3, this.f20608e, this.f20623u, this.f20622t);
        this.f20616n.add(imageView);
        this.f20616n.add(imageView2);
        this.f20616n.add(imageView3);
        DegreeSeekBar degreeSeekBar = (DegreeSeekBar) findViewById(R.id.degree_seek_bar);
        this.f20615m = degreeSeekBar;
        degreeSeekBar.setScrollingListener(new DegreeSeekBar.a() {
            public void a() {
            }

            public void a(int i2) {
                int a2 = PuzzleActivity.this.f20619q;
                if (a2 == 0) {
                    PuzzleActivity.this.f20609g.setPiecePadding((float) i2);
                } else if (a2 == 1) {
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    PuzzleActivity.this.f20609g.setPieceRadian((float) i2);
                } else if (a2 == 2) {
                    PuzzleActivity.this.f20609g.a((float) (i2 - ((Integer) PuzzleActivity.this.f20617o.get(PuzzleActivity.this.f20618p)).intValue()));
                    PuzzleActivity.this.f20617o.remove(PuzzleActivity.this.f20618p);
                    PuzzleActivity.this.f20617o.add(PuzzleActivity.this.f20618p, Integer.valueOf(i2));
                }
            }

            public void b() {
            }
        });
    }

    private void d() {
        this.f20610h = (RecyclerView) findViewById(R.id.rv_puzzle_template);
        e eVar = new e();
        this.f20611i = eVar;
        eVar.a((e.a) this);
        this.f20610h.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.f20610h.setAdapter(this.f20611i);
        this.f20611i.a(com.huantansheng.easyphotos.models.puzzle.e.a(this.f20613k));
        this.f20626x = new h(this, this);
    }

    private void e() {
        int i2 = this.f20613k > 3 ? 1 : 0;
        PuzzleView puzzleView = (PuzzleView) findViewById(R.id.puzzle_view);
        this.f20609g = puzzleView;
        puzzleView.setPuzzleLayout(com.huantansheng.easyphotos.models.puzzle.e.a(i2, this.f20613k, 0));
        this.f20609g.setOnPieceSelectedListener(new PuzzleView.a() {
            public void a(d dVar, int i2) {
                if (dVar == null) {
                    PuzzleActivity.this.a(R.id.iv_replace);
                    PuzzleActivity.this.f20614l.setVisibility(8);
                    PuzzleActivity.this.f20615m.setVisibility(8);
                    int unused = PuzzleActivity.this.f20618p = -1;
                    int unused2 = PuzzleActivity.this.f20619q = -1;
                    return;
                }
                if (PuzzleActivity.this.f20618p != i2) {
                    int unused3 = PuzzleActivity.this.f20619q = -1;
                    PuzzleActivity.this.a(R.id.iv_replace);
                    PuzzleActivity.this.f20615m.setVisibility(8);
                }
                PuzzleActivity.this.f20614l.setVisibility(0);
                int unused4 = PuzzleActivity.this.f20618p = i2;
            }
        });
    }

    /* access modifiers changed from: private */
    public void f() {
        this.f20609g.a((List<Bitmap>) this.f20605b);
    }

    private void g() {
        this.f20627y = new a();
        this.f20620r = getResources().getDisplayMetrics().widthPixels;
        this.f20621s = getResources().getDisplayMetrics().heightPixels;
        Intent intent = getIntent();
        this.f20606c = intent.getStringExtra("keyOfPuzzleSaveDir");
        this.f20607d = intent.getStringExtra("keyOfPuzzleSaveNamePrefix");
        ArrayList<Photo> parcelableArrayListExtra = intent.getParcelableArrayListExtra("keyOfPuzzleFiles");
        this.f20604a = parcelableArrayListExtra;
        int i2 = 9;
        if (parcelableArrayListExtra.size() <= 9) {
            i2 = this.f20604a.size();
        }
        this.f20613k = i2;
        new Thread(new Runnable() {
            public void run() {
                for (int i2 = 0; i2 < PuzzleActivity.this.f20613k; i2++) {
                    PuzzleActivity puzzleActivity = PuzzleActivity.this;
                    PuzzleActivity.this.f20605b.add(puzzleActivity.a(puzzleActivity.f20604a.get(i2).f20303c, PuzzleActivity.this.f20604a.get(i2).f20301a));
                    PuzzleActivity.this.f20617o.add(0);
                }
                PuzzleActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        PuzzleActivity.this.f20609g.post(new Runnable() {
                            public void run() {
                                PuzzleActivity.this.f();
                            }
                        });
                    }
                });
            }
        }).start();
    }

    private void h() {
        int i2;
        FloatingActionButton floatingActionButton;
        if (this.f20625w.getVisibility() == 0) {
            this.f20625w.setVisibility(8);
            floatingActionButton = this.f20608e;
            i2 = R.drawable.ic_arrow_up_easy_photos;
        } else {
            this.f20625w.setVisibility(0);
            floatingActionButton = this.f20608e;
            i2 = R.drawable.ic_arrow_down_easy_photos;
        }
        floatingActionButton.setImageResource(i2);
    }

    /* access modifiers changed from: private */
    public void i() {
        this.f20625w.setVisibility(8);
        this.f20608e.setVisibility(8);
        this.f20612j.setVisibility(0);
        findViewById(R.id.tv_done).setVisibility(4);
        findViewById(R.id.progress_frame).setVisibility(0);
        this.f20609g.d();
        this.f20609g.invalidate();
        a aVar = this.f20627y;
        RelativeLayout relativeLayout = this.f20624v;
        PuzzleView puzzleView = this.f20609g;
        aVar.a(this, relativeLayout, puzzleView, puzzleView.getWidth(), this.f20609g.getHeight(), this.f20606c, this.f20607d, true, new hv.b() {
            public void a() {
                PuzzleActivity.this.setResult(-1);
                PuzzleActivity.this.finish();
            }

            public void a(File file) {
                Intent intent = new Intent();
                String name = file.getName();
                Uri a2 = ib.a.a((Context) PuzzleActivity.this, file);
                String absolutePath = file.getAbsolutePath();
                int width = PuzzleActivity.this.f20609g.getWidth();
                int height = PuzzleActivity.this.f20609g.getHeight();
                Photo photo = r2;
                Photo photo2 = new Photo(name, a2, absolutePath, file.lastModified() / 1000, width, height, 0, file.length(), hw.a.a(file.getAbsolutePath()), "image/png");
                intent.putExtra("keyOfEasyPhotosResult", photo);
                PuzzleActivity.this.setResult(-1, intent);
                PuzzleActivity.this.finish();
            }

            public void a(IOException iOException) {
                iOException.printStackTrace();
                PuzzleActivity.this.setResult(-1);
                PuzzleActivity.this.finish();
            }
        });
    }

    private void j() {
        this.f20614l.setVisibility(8);
        this.f20615m.setVisibility(8);
        this.f20618p = -1;
        int size = this.f20617o.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f20617o.remove(i2);
            this.f20617o.add(i2, 0);
        }
    }

    public void a(int i2, int i3) {
        this.f20609g.setPuzzleLayout(com.huantansheng.easyphotos.models.puzzle.e.a(i2, this.f20613k, i3));
        f();
        j();
    }

    public void a(String str) {
        if (str.equals("-1")) {
            c puzzleLayout = this.f20609g.getPuzzleLayout();
            int b2 = puzzleLayout.b();
            for (int i2 = 0; i2 < b2; i2++) {
                this.f20627y.a(this, getSupportFragmentManager(), new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Long.valueOf(this.f20604a.get(i2).f20310j)), this.f20624v);
                this.f20627y.f13372e.f20489a = true;
                com.huantansheng.easyphotos.models.puzzle.a a2 = puzzleLayout.a(i2);
                this.f20627y.f13372e.a(a2.e(), a2.f());
            }
            return;
        }
        this.f20627y.a(this, getSupportFragmentManager(), str, this.f20624v);
    }

    /* access modifiers changed from: protected */
    public String[] a() {
        return Build.VERSION.SDK_INT >= 16 ? new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"} : new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 14) {
            if (hx.a.a(this, a())) {
                i();
            }
        } else if (i3 == -1) {
            int i4 = this.f20618p;
            if (i4 != -1) {
                this.f20617o.remove(i4);
                this.f20617o.add(this.f20618p, 0);
            }
            Photo photo = (Photo) intent.getParcelableArrayListExtra("keyOfEasyPhotosResult").get(0);
            final String str = photo.f20303c;
            final Uri uri = photo.f20301a;
            new Thread(new Runnable() {
                public void run() {
                    final Bitmap a2 = PuzzleActivity.this.a(str, uri);
                    PuzzleActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            PuzzleActivity.this.f20609g.a(a2);
                        }
                    });
                }
            }).start();
        }
    }

    public void onBackPressed() {
        if (this.f20625w.getVisibility() == 0) {
            h();
        } else {
            super.onBackPressed();
        }
    }

    public void onClick(View view) {
        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        int i2;
        int id2 = view.getId();
        if (R.id.tv_back == id2) {
            finish();
        } else if (R.id.tv_done != id2) {
            int i3 = 0;
            if (R.id.iv_replace == id2) {
                this.f20619q = -1;
                this.f20615m.setVisibility(8);
                a(R.id.iv_replace);
                if (f20603f == null) {
                    com.huantansheng.easyphotos.a.a(this, true, false, hq.a.f13402z).a(1).b(91);
                } else {
                    startActivityForResult(new Intent(this, (Class) f20603f.get()), 91);
                }
            } else {
                if (R.id.iv_rotate == id2) {
                    if (this.f20619q != 2) {
                        a(2, -360, SpatialRelationUtil.A_CIRCLE_DEGREE, (float) this.f20617o.get(this.f20618p).intValue());
                        i2 = R.id.iv_rotate;
                    } else if (this.f20617o.get(this.f20618p).intValue() % 90 != 0) {
                        this.f20609g.a((float) (-this.f20617o.get(this.f20618p).intValue()));
                        this.f20617o.remove(this.f20618p);
                        this.f20617o.add(this.f20618p, 0);
                        this.f20615m.setCurrentDegrees(0);
                        return;
                    } else {
                        this.f20609g.a(90.0f);
                        int intValue = this.f20617o.get(this.f20618p).intValue() + 90;
                        if (!(intValue == 360 || intValue == -360)) {
                            i3 = intValue;
                        }
                        this.f20617o.remove(this.f20618p);
                        this.f20617o.add(this.f20618p, Integer.valueOf(i3));
                        this.f20615m.setCurrentDegrees(this.f20617o.get(this.f20618p).intValue());
                        return;
                    }
                } else if (R.id.iv_mirror == id2) {
                    this.f20615m.setVisibility(8);
                    this.f20619q = -1;
                    a(R.id.iv_mirror);
                    this.f20609g.b();
                    return;
                } else if (R.id.iv_flip == id2) {
                    this.f20619q = -1;
                    this.f20615m.setVisibility(8);
                    a(R.id.iv_flip);
                    this.f20609g.a();
                    return;
                } else if (R.id.iv_corner == id2) {
                    a(1, 0, 1000, this.f20609g.getPieceRadian());
                    i2 = R.id.iv_corner;
                } else if (R.id.iv_padding == id2) {
                    a(0, 0, 100, this.f20609g.getPiecePadding());
                    i2 = R.id.iv_padding;
                } else {
                    if (R.id.tv_template == id2) {
                        this.f20622t.setTextColor(b.c(this, R.color.easy_photos_fg_accent));
                        this.f20623u.setTextColor(b.c(this, R.color.easy_photos_fg_primary));
                        recyclerView = this.f20610h;
                        adapter = this.f20611i;
                    } else if (R.id.tv_text_sticker == id2) {
                        this.f20623u.setTextColor(b.c(this, R.color.easy_photos_fg_accent));
                        this.f20622t.setTextColor(b.c(this, R.color.easy_photos_fg_primary));
                        recyclerView = this.f20610h;
                        adapter = this.f20626x;
                    } else if (R.id.fab == id2) {
                        h();
                        return;
                    } else {
                        return;
                    }
                    recyclerView.setAdapter(adapter);
                    return;
                }
                a(i2);
            }
        } else if (hx.a.a(this, a())) {
            i();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.flags |= 1024;
        getWindow().setAttributes(attributes);
        setContentView(R.layout.activity_puzzle_easy_photos);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.c();
        }
        if (hq.a.f13402z == null) {
            finish();
            return;
        }
        g();
        b();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        WeakReference<Class<? extends Activity>> weakReference = f20603f;
        if (weakReference != null) {
            weakReference.clear();
            f20603f = null;
        }
        super.onDestroy();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        hx.a.a(this, strArr, iArr, new a.C0099a() {
            public void a() {
                PuzzleActivity.this.i();
            }

            public void b() {
                Snackbar.a((View) PuzzleActivity.this.f20610h, R.string.permissions_again_easy_photos, -2).a("go", new View.OnClickListener() {
                    public void onClick(View view) {
                        if (hx.a.a(PuzzleActivity.this, PuzzleActivity.this.a())) {
                            PuzzleActivity.this.i();
                        }
                    }
                }).e();
            }

            public void c() {
                Snackbar.a((View) PuzzleActivity.this.f20610h, R.string.permissions_die_easy_photos, -2).a("go", new View.OnClickListener() {
                    public void onClick(View view) {
                        hz.a.a(PuzzleActivity.this, PuzzleActivity.this.getPackageName());
                    }
                }).e();
            }
        });
    }
}
