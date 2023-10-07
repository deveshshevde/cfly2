package com.xeagle.android.vjoystick.gallery;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.util.ToastUtils;
import com.flypro.photoview_library.PhotoView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.xeagle.R;
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.dialogs.t;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import com.xeagle.android.widgets.HackyViewPager;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.h;

public final class PhotoPreviewActivity extends SuperUI implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f25282a = new a((f) null);

    /* renamed from: b  reason: collision with root package name */
    private c f25283b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<String> f25284c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public PhotoView f25285k;

    /* renamed from: l  reason: collision with root package name */
    private int f25286l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public String f25287m;

    /* renamed from: n  reason: collision with root package name */
    private HashMap f25288n;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private final class b implements Comparator<String> {
        public b() {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            if (str == null || str2 == null) {
                return 0;
            }
            return -kotlin.text.f.d(str, str2, true);
        }
    }

    private final class c extends androidx.viewpager.widget.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PhotoPreviewActivity f25290a;

        /* renamed from: b  reason: collision with root package name */
        private final List<String> f25291b;

        public c(PhotoPreviewActivity photoPreviewActivity, List<String> list) {
            h.d(list, "list");
            this.f25290a = photoPreviewActivity;
            this.f25291b = list;
        }

        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            h.d(viewGroup, "container");
            h.d(obj, "object");
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return this.f25291b.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            h.d(viewGroup, "container");
            this.f25290a.f25285k = new PhotoView(viewGroup.getContext());
            PhotoView a2 = this.f25290a.f25285k;
            h.a((Object) a2);
            a2.setTransitionName(this.f25290a.f25287m);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap decodeFile = BitmapFactory.decodeFile((String) this.f25290a.f25284c.get(i2), options);
            PhotoView a3 = this.f25290a.f25285k;
            h.a((Object) a3);
            a3.setImageBitmap(decodeFile);
            viewGroup.addView(this.f25290a.f25285k, -1, -1);
            PhotoView a4 = this.f25290a.f25285k;
            h.a((Object) a4);
            return a4;
        }

        public boolean isViewFromObject(View view, Object obj) {
            h.d(view, Promotion.ACTION_VIEW);
            h.d(obj, "object");
            return view == obj;
        }
    }

    public static final class d implements d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PhotoPreviewActivity f25292a;

        d(PhotoPreviewActivity photoPreviewActivity) {
            this.f25292a = photoPreviewActivity;
        }

        public void onNo() {
        }

        public void onYes() {
            List c2 = this.f25292a.f25284c;
            HackyViewPager hackyViewPager = (HackyViewPager) this.f25292a.a(R.id.view_pager);
            h.a((Object) hackyViewPager);
            kw.a.a(new File((String) c2.get(hackyViewPager.getCurrentItem())));
            ToastUtils.showShort((int) com.cfly.uav_pro.R.string.local_photo_del);
            ha.b.a().a("notify_photo").a(true);
            this.f25292a.finish();
        }
    }

    public static final class e implements t.a {
        e() {
        }

        public void a() {
        }
    }

    public static final class f implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PhotoPreviewActivity f25293a;

        f(PhotoPreviewActivity photoPreviewActivity) {
            this.f25293a = photoPreviewActivity;
        }

        public void onPageScrollStateChanged(int i2) {
        }

        public void onPageScrolled(int i2, float f2, int i3) {
        }

        public void onPageSelected(int i2) {
            TextView textView = (TextView) this.f25293a.a(R.id.photo_id);
            h.a((Object) textView);
            textView.setText(String.valueOf(i2 + 1) + "/" + this.f25293a.f25284c.size());
        }
    }

    private final void a() {
        IImageButton iImageButton = (IImageButton) a(R.id.iv_go_back);
        h.a((Object) iImageButton);
        View.OnClickListener onClickListener = this;
        iImageButton.setOnClickListener(onClickListener);
        IImageButton iImageButton2 = (IImageButton) a(R.id.photo_info);
        h.a((Object) iImageButton2);
        iImageButton2.setOnClickListener(onClickListener);
        IImageButton iImageButton3 = (IImageButton) a(R.id.photo_delete);
        h.a((Object) iImageButton3);
        iImageButton3.setOnClickListener(onClickListener);
        IImageButton iImageButton4 = (IImageButton) a(R.id.photo_share);
        h.a((Object) iImageButton4);
        iImageButton4.setOnClickListener(onClickListener);
    }

    public View a(int i2) {
        if (this.f25288n == null) {
            this.f25288n = new HashMap();
        }
        View view = (View) this.f25288n.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f25288n.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void onClick(View view) {
        Uri uri;
        String str;
        h.d(view, "v");
        switch (view.getId()) {
            case com.cfly.uav_pro.R.id.iv_go_back:
                finish();
                return;
            case com.cfly.uav_pro.R.id.photo_delete:
                com.xeagle.android.dialogs.d a2 = com.xeagle.android.dialogs.d.a(getString(com.cfly.uav_pro.R.string.confirm_to_delete), getString(com.cfly.uav_pro.R.string.delete_not_restore), new d(this));
                if (a2 != null) {
                    a2.show(getSupportFragmentManager(), "delete");
                    return;
                }
                return;
            case com.cfly.uav_pro.R.id.photo_info:
                HackyViewPager hackyViewPager = (HackyViewPager) a(R.id.view_pager);
                h.a((Object) hackyViewPager);
                int currentItem = hackyViewPager.getCurrentItem();
                File file = new File(this.f25284c.get(currentItem));
                String name = file.getName();
                String str2 = this.f25284c.get(currentItem);
                Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                String substring = str2.substring(40, 48);
                h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                StringBuilder sb = new StringBuilder();
                Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
                String substring2 = substring.substring(0, 4);
                h.b(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring2);
                sb.append("/");
                Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
                String substring3 = substring.substring(4, 6);
                h.b(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring3);
                sb.append("/");
                Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
                String substring4 = substring.substring(6, 8);
                h.b(substring4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring4);
                String sb2 = sb.toString();
                float f2 = (float) 1024;
                String format = new DecimalFormat("0.00").format((double) ((((float) file.length()) / f2) / f2));
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(this.f25284c.get(currentItem), options);
                t a3 = t.a(name, sb2, String.valueOf(options.outWidth) + "*" + options.outHeight, format, new e());
                if (a3 != null) {
                    a3.show(getSupportFragmentManager(), "info");
                    return;
                }
                return;
            case com.cfly.uav_pro.R.id.photo_share:
                HackyViewPager hackyViewPager2 = (HackyViewPager) a(R.id.view_pager);
                h.a((Object) hackyViewPager2);
                File file2 = new File(this.f25284c.get(hackyViewPager2.getCurrentItem()));
                if (file2.exists()) {
                    if (Build.VERSION.SDK_INT >= 30) {
                        uri = FileProvider.getUriForFile(getApplicationContext(), "com.cfly.uav_pro.fileProvider", file2);
                        str = "FileProvider.getUriForFi…                        )";
                    } else {
                        uri = Uri.fromFile(file2);
                        str = "Uri.fromFile(file1)";
                    }
                    h.b(uri, str);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.STREAM", uri);
                    intent.setType("image/*");
                    startActivity(Intent.createChooser(intent, getString(com.cfly.uav_pro.R.string.string_share_to)));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) com.cfly.uav_pro.R.layout.photo_preview_activity);
        getWindow().addFlags(128);
        Collections.sort(this.f25284c, new b());
        Intent intent = getIntent();
        h.b(intent, "this.intent");
        Bundle extras = intent.getExtras();
        h.a((Object) extras);
        this.f25286l = extras.getInt("pic_pos", 0);
        this.f25284c.clear();
        ArrayList<String> stringArrayList = extras.getStringArrayList("list");
        h.a((Object) stringArrayList);
        this.f25284c = stringArrayList;
        this.f25287m = extras.getString("shared_name", "img");
        TextView textView = (TextView) a(R.id.photo_id);
        h.a((Object) textView);
        textView.setText(String.valueOf(this.f25286l + 1) + "/" + this.f25284c.size());
        this.f25283b = new c(this, this.f25284c);
        HackyViewPager hackyViewPager = (HackyViewPager) a(R.id.view_pager);
        h.a((Object) hackyViewPager);
        hackyViewPager.setAdapter(this.f25283b);
        HackyViewPager hackyViewPager2 = (HackyViewPager) a(R.id.view_pager);
        h.a((Object) hackyViewPager2);
        hackyViewPager2.setCurrentItem(this.f25286l);
        HackyViewPager hackyViewPager3 = (HackyViewPager) a(R.id.view_pager);
        h.a((Object) hackyViewPager3);
        hackyViewPager3.setOnPageChangeListener(new f(this));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        a();
    }
}
