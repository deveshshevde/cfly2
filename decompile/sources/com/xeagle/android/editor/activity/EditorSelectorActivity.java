package com.xeagle.android.editor.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.core.app.a;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.xeagle.android.editor.database.EditorData;
import com.xeagle.android.login.pickImage.ImageBaseActivity;
import com.xeagle.android.login.pickImage.ImagePicker;
import com.xeagle.android.login.pickImage.ImagePickerLauncher;
import com.xeagle.android.login.pickImage.ImagePickerOption;
import com.xeagle.android.login.pickImage.adapter.ImageItemDecoration;
import com.xeagle.android.login.pickImage.adapter.ImageSectionAdapter;
import com.xeagle.android.login.pickImage.adapter.vh.ImageItemViewHolder;
import com.xeagle.android.login.pickImage.data.AbsDataSource;
import com.xeagle.android.login.pickImage.data.AllDataSource;
import com.xeagle.android.login.pickImage.data.DataSourceFactory;
import com.xeagle.android.login.pickImage.data.GLImage;
import com.xeagle.android.login.pickImage.data.ImageDataSource;
import com.xeagle.android.login.pickImage.data.ImageFolder;
import com.xeagle.android.login.pickImage.data.VideoDataSource;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kx.d;

public class EditorSelectorActivity extends ImageBaseActivity implements View.OnClickListener, ImagePicker.OnImageSelectedListener, AbsDataSource.OnImagesLoadedListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public TextView f22829a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f22830b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f22831c;

    /* renamed from: d  reason: collision with root package name */
    private CheckedTextView f22832d;

    /* renamed from: e  reason: collision with root package name */
    private CheckedTextView f22833e;

    /* renamed from: f  reason: collision with root package name */
    private CheckedTextView f22834f;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView f22835g;

    /* renamed from: h  reason: collision with root package name */
    private IButton f22836h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f22837i = false;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public ImagePicker f22838j;

    /* renamed from: k  reason: collision with root package name */
    private ImageDataSource f22839k;

    /* renamed from: l  reason: collision with root package name */
    private VideoDataSource f22840l;

    /* renamed from: m  reason: collision with root package name */
    private AllDataSource f22841m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public ImageSectionAdapter f22842n;

    /* renamed from: com.xeagle.android.editor.activity.EditorSelectorActivity$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22848a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.xeagle.android.login.pickImage.ImagePickerOption$PickType[] r0 = com.xeagle.android.login.pickImage.ImagePickerOption.PickType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22848a = r0
                com.xeagle.android.login.pickImage.ImagePickerOption$PickType r1 = com.xeagle.android.login.pickImage.ImagePickerOption.PickType.Image     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22848a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xeagle.android.login.pickImage.ImagePickerOption$PickType r1 = com.xeagle.android.login.pickImage.ImagePickerOption.PickType.Video     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22848a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xeagle.android.login.pickImage.ImagePickerOption$PickType r1 = com.xeagle.android.login.pickImage.ImagePickerOption.PickType.All     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.editor.activity.EditorSelectorActivity.AnonymousClass4.<clinit>():void");
        }
    }

    private void a() {
        this.f22829a = (TextView) findViewById(R.id.tv_editor_select);
        this.f22830b = (TextView) findViewById(R.id.tv_editor_cancel);
        this.f22832d = (CheckedTextView) findViewById(R.id.tv_select_pic);
        this.f22834f = (CheckedTextView) findViewById(R.id.tv_select_all);
        this.f22833e = (CheckedTextView) findViewById(R.id.tv_select_video);
        this.f22831c = (TextView) findViewById(R.id.tv_file_warn);
        this.f22835g = (RecyclerView) findViewById(R.id.select_editor_list);
        this.f22836h = (IButton) findViewById(R.id.ib_start_editor);
        a(0);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        gridLayoutManager.a((GridLayoutManager.b) new GridLayoutManager.b() {
            public int getSpanSize(int i2) {
                return EditorSelectorActivity.this.f22842n.getSpanSize(i2);
            }
        });
        this.f22835g.setLayoutManager(gridLayoutManager);
        this.f22835g.a((RecyclerView.g) new ImageItemDecoration(getApplicationContext()));
        this.f22835g.setRecyclerListener(new RecyclerView.o() {
            public void onViewRecycled(RecyclerView.v vVar) {
                if (vVar instanceof ImageItemViewHolder) {
                    ((ImageItemViewHolder) vVar).clearRequest();
                }
            }
        });
        ImageSectionAdapter imageSectionAdapter = new ImageSectionAdapter(this);
        this.f22842n = imageSectionAdapter;
        this.f22835g.setAdapter(imageSectionAdapter);
        onImageSelected((GLImage) null, false);
        if (checkPermission("android.permission.WRITE_EXTERNAL_STORAGE")) {
            a(this.f22838j.getOption(), d.q(getApplicationContext()), (String) null);
        } else {
            a.a(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
        this.f22830b.setOnClickListener(this);
        this.f22833e.setOnClickListener(this);
        this.f22832d.setOnClickListener(this);
        this.f22834f.setOnClickListener(this);
        this.f22836h.setOnClickListener(this);
    }

    private void a(int i2) {
        if (i2 == 1) {
            this.f22832d.setChecked(true);
            this.f22833e.setChecked(false);
        } else if (i2 == 2) {
            this.f22832d.setChecked(false);
            this.f22833e.setChecked(false);
            this.f22834f.setChecked(true);
            return;
        } else {
            this.f22832d.setChecked(false);
            this.f22833e.setChecked(true);
        }
        this.f22834f.setChecked(false);
    }

    private void a(Bundle bundle) {
        ImagePicker instance = ImagePicker.getInstance();
        this.f22838j = instance;
        instance.clear();
        this.f22838j.addOnImageSelectedListener(this);
        if (bundle != null) {
            this.f22838j.setOption((ImagePickerOption) bundle.getSerializable("editor_select"));
        }
    }

    private void a(ImagePickerOption imagePickerOption, String str, String str2) {
        Log.i("editor", "loadImageData:---type--- " + imagePickerOption.getPickType());
        int i2 = AnonymousClass4.f22848a[imagePickerOption.getPickType().ordinal()];
        if (i2 == 1) {
            ImageDataSource imageDataSource = this.f22839k;
            if (imageDataSource == null) {
                ImageDataSource imageDataSource2 = (ImageDataSource) DataSourceFactory.create(this, (String) null, imagePickerOption.getPickType());
                this.f22839k = imageDataSource2;
                imageDataSource2.setLoadedListener(this);
            } else {
                imageDataSource.restartLoad();
            }
            this.f22839k.setFilePath(str);
            this.f22839k.setType(str2);
            this.f22839k.reload();
        } else if (i2 != 3) {
            VideoDataSource videoDataSource = this.f22840l;
            if (videoDataSource == null) {
                VideoDataSource videoDataSource2 = (VideoDataSource) DataSourceFactory.create(this, (String) null, imagePickerOption.getPickType());
                this.f22840l = videoDataSource2;
                videoDataSource2.setLoadedListener(this);
            } else {
                videoDataSource.restartLoad();
            }
            this.f22840l.setFilePath(str);
            this.f22840l.setType(str2);
            this.f22840l.reload();
        } else {
            AllDataSource allDataSource = this.f22841m;
            if (allDataSource == null) {
                AllDataSource allDataSource2 = (AllDataSource) DataSourceFactory.create(this, (String) null, imagePickerOption.getPickType());
                this.f22841m = allDataSource2;
                allDataSource2.setLoadedListener(this);
            } else {
                allDataSource.restartLoad();
            }
            this.f22841m.setFilePath(str);
            this.f22841m.setType(str2);
            this.f22841m.reload();
        }
    }

    public void clearMemoryCache() {
        this.f22838j.getImageLoader().clearMemoryCache();
    }

    public void clearRequest() {
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onClick(View view) {
        Intent intent;
        String str;
        ImagePickerOption imagePickerOption;
        String str2;
        switch (view.getId()) {
            case R.id.ib_start_editor:
                ArrayList<EditorData> a2 = com.xeagle.android.editor.database.a.a();
                if (a2 == null || a2.size() <= 0) {
                    if (this.f22838j.getSelectImageCount() > this.f22838j.getSelectMin()) {
                        intent = new Intent(this, EditorMultiActivity.class);
                        startActivity(intent);
                        return;
                    }
                } else if (this.f22838j.getSelectImageCount() > this.f22838j.getSelectMin()) {
                    if (a2.size() + this.f22838j.getSelectImageCount() > 9) {
                        str = getString(R.string.editor_video_max);
                        ToastUtils.showShort((CharSequence) str);
                        return;
                    }
                    intent = new Intent(this, EditorMultiActivity.class);
                    startActivity(intent);
                    return;
                }
                str = getString(R.string.editor_select_mmin);
                ToastUtils.showShort((CharSequence) str);
                return;
            case R.id.tv_editor_cancel:
                finish();
                return;
            case R.id.tv_select_all:
                a(2);
                this.f22838j.setOption(new ImagePickerOption().setPickType(ImagePickerOption.PickType.All).setCrop(false).setMixMode(true).setMultiMode(true).setSelectMax(9).setMaxVideoDuration(600));
                a(this.f22838j.getOption(), (String) null, (String) null);
                return;
            case R.id.tv_select_pic:
                a(1);
                this.f22838j.setOption(new ImagePickerOption().setPickType(ImagePickerOption.PickType.Image).setCrop(false).setMixMode(true).setMultiMode(true).setSelectMax(9).setMaxVideoDuration(600));
                imagePickerOption = this.f22838j.getOption();
                str2 = d.s(getApplicationContext());
                break;
            case R.id.tv_select_video:
                a(0);
                this.f22838j.setOption(new ImagePickerOption().setPickType(ImagePickerOption.PickType.Video).setCrop(false).setMixMode(true).setMultiMode(true).setSelectMax(9).setMaxVideoDuration(600));
                imagePickerOption = this.f22838j.getOption();
                str2 = d.q(getApplicationContext());
                break;
            default:
                return;
        }
        a(imagePickerOption, str2, (String) null);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.editor_selector_layout);
        a(bundle);
        a();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f22838j.removeOnImageSelectedListener(this);
        super.onDestroy();
    }

    public void onImageSelected(final GLImage gLImage, final boolean z2) {
        if (gLImage != null) {
            runOnUiThread(new Runnable() {
                public void run() {
                    Log.i("editor", "onImageSelected:---select==== " + gLImage.getPath() + "--isAdd===" + z2);
                    EditorSelectorActivity.this.f22829a.setText(String.format(Locale.US, EditorSelectorActivity.this.getString(R.string.select_images_num), new Object[]{Integer.valueOf(EditorSelectorActivity.this.f22838j.getSelectImageCount())}));
                }
            });
        }
    }

    public void onImagesLoaded(List<ImageFolder> list) {
        if (list.size() > 0) {
            Log.i("editor", "onImagesLoaded:----size--- " + list.size() + "--images---" + list.get(0).images.size() + "---path---" + list.get(0).images.get(0).getPath());
            this.f22842n.refreshData(list.get(0).images);
            this.f22831c.setVisibility(8);
            return;
        }
        Log.i("editor", "onImagesLoaded:---no files ");
        this.f22831c.setVisibility(0);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        int i3;
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 1) {
            if (iArr[0] == 0) {
                a(this.f22838j.getOption(), d.q(getApplicationContext()), (String) null);
                return;
            }
            i3 = R.string.permission_no_select;
        } else if (i2 != 2) {
            return;
        } else {
            if (iArr[0] == 0) {
                ImagePickerLauncher.takePicture((Activity) this, 1001, this.f22838j.getOption());
                return;
            }
            i3 = R.string.permission_no_camera;
        }
        showToast(getString(i3));
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("editor_select", this.f22838j.getOption());
    }
}
