package com.xeagle.android.login.pickImage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.app.a;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.DialogMaker;
import com.xeagle.android.login.common.NetworkUtil;
import com.xeagle.android.login.common.ToastHelper;
import com.xeagle.android.login.pickImage.FolderPopUpWindow;
import com.xeagle.android.login.pickImage.ImagePicker;
import com.xeagle.android.login.pickImage.adapter.ImageFolderAdapter;
import com.xeagle.android.login.pickImage.adapter.ImageItemDecoration;
import com.xeagle.android.login.pickImage.adapter.ImageSectionAdapter;
import com.xeagle.android.login.pickImage.adapter.vh.ImageItemViewHolder;
import com.xeagle.android.login.pickImage.data.AbsDataSource;
import com.xeagle.android.login.pickImage.data.DataSourceFactory;
import com.xeagle.android.login.pickImage.data.GLImage;
import com.xeagle.android.login.pickImage.data.ImageFolder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageGridActivity extends ImageBaseActivity implements View.OnClickListener, ImagePicker.OnImageSelectedListener, ImageSectionAdapter.OnImageClickListener, AbsDataSource.OnImagesLoadedListener {
    private static final String KEY_PICKER_OPTION = "picker_option";
    private AbsDataSource dataSource;
    /* access modifiers changed from: private */
    public ImagePicker imagePicker;
    private boolean isOrigin = false;
    private TextView mBtnOk;
    /* access modifiers changed from: private */
    public FolderPopUpWindow mFolderPopupWindow;
    private View mFooterBar;
    /* access modifiers changed from: private */
    public RecyclerView mGridView;
    /* access modifiers changed from: private */
    public ImageFolderAdapter mImageFolderAdapter;
    private List<ImageFolder> mImageFolders;
    /* access modifiers changed from: private */
    public ImageSectionAdapter sectionAdapter;
    /* access modifiers changed from: private */
    public TextView title;

    /* renamed from: com.xeagle.android.login.pickImage.ImageGridActivity$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$xeagle$android$login$pickImage$ImagePickerOption$PickType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.xeagle.android.login.pickImage.ImagePickerOption$PickType[] r0 = com.xeagle.android.login.pickImage.ImagePickerOption.PickType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$xeagle$android$login$pickImage$ImagePickerOption$PickType = r0
                com.xeagle.android.login.pickImage.ImagePickerOption$PickType r1 = com.xeagle.android.login.pickImage.ImagePickerOption.PickType.All     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$xeagle$android$login$pickImage$ImagePickerOption$PickType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xeagle.android.login.pickImage.ImagePickerOption$PickType r1 = com.xeagle.android.login.pickImage.ImagePickerOption.PickType.Video     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$xeagle$android$login$pickImage$ImagePickerOption$PickType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xeagle.android.login.pickImage.ImagePickerOption$PickType r1 = com.xeagle.android.login.pickImage.ImagePickerOption.PickType.Image     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.pickImage.ImageGridActivity.AnonymousClass5.<clinit>():void");
        }
    }

    private void createPopupFolderList() {
        if (this.mFolderPopupWindow == null) {
            FolderPopUpWindow folderPopUpWindow = new FolderPopUpWindow(this, this.mImageFolderAdapter);
            this.mFolderPopupWindow = folderPopUpWindow;
            folderPopUpWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                public void onDismiss() {
                    ImageGridActivity.this.title.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.my_flight_downitemable, 0);
                }
            });
            this.mFolderPopupWindow.setOnItemClickListener(new FolderPopUpWindow.OnItemClickListener() {
                /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                    /*
                        r0 = this;
                        com.xeagle.android.login.pickImage.ImageGridActivity r2 = com.xeagle.android.login.pickImage.ImageGridActivity.this
                        com.xeagle.android.login.pickImage.adapter.ImageFolderAdapter r2 = r2.mImageFolderAdapter
                        r2.setSelectIndex(r3)
                        com.xeagle.android.login.pickImage.ImageGridActivity r2 = com.xeagle.android.login.pickImage.ImageGridActivity.this
                        com.xeagle.android.login.pickImage.ImagePicker r2 = r2.imagePicker
                        r2.setCurrentImageFolderPosition(r3)
                        com.xeagle.android.login.pickImage.ImageGridActivity r2 = com.xeagle.android.login.pickImage.ImageGridActivity.this
                        com.xeagle.android.login.pickImage.FolderPopUpWindow r2 = r2.mFolderPopupWindow
                        r2.dismiss()
                        android.widget.Adapter r1 = r1.getAdapter()
                        java.lang.Object r1 = r1.getItem(r3)
                        com.xeagle.android.login.pickImage.data.ImageFolder r1 = (com.xeagle.android.login.pickImage.data.ImageFolder) r1
                        if (r1 == 0) goto L_0x0032
                        com.xeagle.android.login.pickImage.ImageGridActivity r2 = com.xeagle.android.login.pickImage.ImageGridActivity.this
                        com.xeagle.android.login.pickImage.adapter.ImageSectionAdapter r2 = r2.sectionAdapter
                        java.util.ArrayList<com.xeagle.android.login.pickImage.data.GLImage> r1 = r1.images
                        r2.refreshData(r1)
                    L_0x0032:
                        com.xeagle.android.login.pickImage.ImageGridActivity r1 = com.xeagle.android.login.pickImage.ImageGridActivity.this
                        r1.updateImageFolderTitle()
                        com.xeagle.android.login.pickImage.ImageGridActivity r1 = com.xeagle.android.login.pickImage.ImageGridActivity.this
                        androidx.recyclerview.widget.RecyclerView r1 = r1.mGridView
                        r2 = 0
                        r1.c((int) r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.pickImage.ImageGridActivity.AnonymousClass4.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
        }
    }

    private void findViews() {
        this.title = (TextView) findViewById(R.id.tv_des);
        this.mBtnOk = (TextView) findViewById(R.id.btn_ok);
        this.mFooterBar = findViewById(R.id.footer_bar);
        this.mGridView = (RecyclerView) findViewById(R.id.gridview);
    }

    private void handleResultData(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    private void initOption(Bundle bundle) {
        ImagePicker instance = ImagePicker.getInstance();
        this.imagePicker = instance;
        instance.clear();
        this.imagePicker.addOnImageSelectedListener(this);
        if (bundle != null) {
            this.imagePicker.setOption((ImagePickerOption) bundle.getSerializable(KEY_PICKER_OPTION));
        }
    }

    private void initRV() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        gridLayoutManager.a((GridLayoutManager.b) new GridLayoutManager.b() {
            public int getSpanSize(int i2) {
                return ImageGridActivity.this.sectionAdapter.getSpanSize(i2);
            }
        });
        this.mGridView.setLayoutManager(gridLayoutManager);
        this.mGridView.a((RecyclerView.g) new ImageItemDecoration(getApplicationContext()));
        this.mGridView.setRecyclerListener(new RecyclerView.o() {
            public void onViewRecycled(RecyclerView.v vVar) {
                if (vVar instanceof ImageItemViewHolder) {
                    ((ImageItemViewHolder) vVar).clearRequest();
                }
            }
        });
        ImageSectionAdapter imageSectionAdapter = new ImageSectionAdapter(this);
        this.sectionAdapter = imageSectionAdapter;
        this.mGridView.setAdapter(imageSectionAdapter);
        this.sectionAdapter.setOnImageItemClickListener(this);
        this.mImageFolderAdapter = new ImageFolderAdapter(this, (List<ImageFolder>) null);
        onImageSelected((GLImage) null, false);
        if (checkPermission("android.permission.WRITE_EXTERNAL_STORAGE")) {
            loadImageData(this.imagePicker.getOption());
        } else {
            a.a(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
    }

    private void initView() {
        if (!TextUtils.isEmpty(this.imagePicker.getTitle())) {
            this.title.setText(this.imagePicker.getTitle());
        } else {
            this.title.setText(this.imagePicker.getPickType().getTitle());
        }
        if (this.imagePicker.isMultiMode()) {
            setOkButtonVisible(true);
        } else {
            this.mFooterBar.setVisibility(8);
        }
    }

    private void loadImageData(ImagePickerOption imagePickerOption) {
        AbsDataSource create = DataSourceFactory.create(this, (String) null, imagePickerOption.getPickType());
        this.dataSource = create;
        create.setLoadedListener(this);
        AbsDataSource absDataSource = this.dataSource;
        if (absDataSource != null) {
            absDataSource.reload();
        }
    }

    private void onImageItemClick(GLImage gLImage, int i2) {
        Intent intent;
        int i3;
        if (this.imagePicker.isMultiMode()) {
            intent = new Intent(this, ImagePreviewActivity.class);
            intent.putExtra(Constants.EXTRA_SELECTED_IMAGE_POSITION, i2);
            intent.putExtra(Constants.EXTRA_IMAGE_PREVIEW_FROM_PICKER, true);
            intent.putExtra(Constants.IS_ORIGIN, this.isOrigin);
            i3 = 1003;
        } else {
            this.imagePicker.clearSelectedImages();
            this.imagePicker.addSelectedImageItem(gLImage, true);
            if (this.imagePicker.isCrop()) {
                intent = new Intent(this, ImageCropActivity.class);
                i3 = 1002;
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra(Constants.EXTRA_RESULT_ITEMS, this.imagePicker.getSelectedImages());
                setResult(-1, intent2);
                finish();
                return;
            }
        }
        startActivityForResult(intent, i3);
    }

    private void onVideoItemClick(GLImage gLImage, int i2) {
        GLVideoActivity.start((Context) this, Uri.fromFile(new File(gLImage.getPath())), gLImage.getDuration());
    }

    private void setOkButtonEnable(boolean z2) {
        TextView textView;
        boolean z3;
        if (z2) {
            textView = this.mBtnOk;
            z3 = true;
        } else {
            textView = this.mBtnOk;
            z3 = false;
        }
        textView.setEnabled(z3);
        syncButtonText();
    }

    private void setOkButtonVisible(boolean z2) {
        TextView textView;
        int i2;
        if (z2) {
            textView = this.mBtnOk;
            i2 = 0;
        } else {
            textView = this.mBtnOk;
            i2 = 4;
        }
        textView.setVisibility(i2);
        syncButtonText();
    }

    private void setViewsListener() {
        findViewById(R.id.btn_cancel).setOnClickListener(this);
        this.mBtnOk.setOnClickListener(this);
        this.title.setOnClickListener(this);
    }

    private void syncButtonText() {
        ImagePicker imagePicker2 = this.imagePicker;
        if (imagePicker2 != null) {
            int selectImageCount = imagePicker2.getSelectImageCount();
            if (selectImageCount == 0) {
                this.mBtnOk.setText(R.string.button_setup_send);
                return;
            }
            TextView textView = this.mBtnOk;
            textView.setText(textView.getContext().getString(R.string.send_d, new Object[]{Integer.valueOf(selectImageCount)}));
        }
    }

    /* access modifiers changed from: private */
    public void updateImageFolderTitle() {
        ImageFolder currentImageFolder = this.imagePicker.getCurrentImageFolder();
        if (currentImageFolder != null) {
            this.title.setText(currentImageFolder.name);
        }
    }

    public void clearMemoryCache() {
        this.imagePicker.getImageLoader().clearMemoryCache();
    }

    public void clearRequest() {
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1001) {
            if (i3 != -1) {
                return;
            }
        } else if (i2 == 1002) {
            if (i3 != -1) {
                return;
            }
        } else if (i2 == 1003) {
            if (i3 == 1) {
                if (intent != null) {
                    this.isOrigin = intent.getBooleanExtra(Constants.IS_ORIGIN, false);
                    return;
                }
                return;
            } else if (i3 != -1) {
                return;
            }
        } else if (!(i2 == 1006 && i3 == -1)) {
            return;
        }
        handleResultData(intent);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.btn_ok) {
            if (this.imagePicker.getSelectImageCount() < this.imagePicker.getSelectMin()) {
                ToastHelper.showToast((Context) this, getString(R.string.choose_min_num, new Object[]{Integer.valueOf(this.imagePicker.getSelectMin())}));
                return;
            } else if (!this.imagePicker.needCheckNetwork() || NetworkUtil.isNetAvailable(this)) {
                Intent intent = new Intent();
                intent.putExtra(Constants.EXTRA_RESULT_ITEMS, this.imagePicker.getSelectedImages());
                setResult(-1, intent);
            } else {
                ToastHelper.showToast((Context) this, (int) R.string.network_available);
                return;
            }
        } else if (id2 == R.id.tv_des) {
            List<ImageFolder> list = this.mImageFolders;
            if (list == null || list.get(0).images.size() == 0) {
                Log.i("ImageGridActivity", "您的手机没有图片");
                return;
            }
            createPopupFolderList();
            this.mImageFolderAdapter.refreshData(this.mImageFolders);
            if (this.mFolderPopupWindow.isShowing()) {
                this.mFolderPopupWindow.dismiss();
                return;
            }
            this.title.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.my_flight_upitemable, 0);
            this.mFolderPopupWindow.showAsDropDown(this.title, 48, 0, 0);
            int selectIndex = this.mImageFolderAdapter.getSelectIndex();
            if (selectIndex != 0) {
                selectIndex--;
            }
            this.mFolderPopupWindow.setSelection(selectIndex);
            return;
        } else if (id2 == R.id.btn_cancel) {
            int i2 = AnonymousClass5.$SwitchMap$com$xeagle$android$login$pickImage$ImagePickerOption$PickType[ImagePicker.getInstance().getPickType().ordinal()];
        } else {
            return;
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.image_grid_activity);
        initOption(bundle);
        findViews();
        setViewsListener();
        initView();
        initRV();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.imagePicker.removeOnImageSelectedListener(this);
        super.onDestroy();
    }

    public void onImageItemClick(View view, GLImage gLImage, int i2) {
        if (gLImage.isVideo()) {
            onVideoItemClick(gLImage, i2);
        } else {
            onImageItemClick(gLImage, i2);
        }
    }

    public void onImageSelected(GLImage gLImage, boolean z2) {
        boolean z3;
        if (this.imagePicker.getSelectImageCount() > this.imagePicker.getSelectMin()) {
            this.mBtnOk.setText(R.string.button_setup_send);
            z3 = true;
        } else {
            this.mBtnOk.setText(getString(R.string.button_setup_send));
            z3 = false;
        }
        setOkButtonEnable(z3);
        this.sectionAdapter.notifyDataSetChanged();
    }

    public void onImagesLoaded(List<ImageFolder> list) {
        ArrayList<GLImage> arrayList;
        ImageSectionAdapter imageSectionAdapter;
        this.mImageFolders = list;
        this.imagePicker.setImageFolders(list);
        if (list.size() == 0) {
            imageSectionAdapter = this.sectionAdapter;
            arrayList = null;
        } else {
            imageSectionAdapter = this.sectionAdapter;
            arrayList = list.get(this.imagePicker.getCurrentImageFolderPosition()).images;
        }
        imageSectionAdapter.refreshData(arrayList);
        this.mImageFolderAdapter.refreshData(list);
        updateImageFolderTitle();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        DialogMaker.dismissProgressDialog();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        int i3;
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 1) {
            if (iArr[0] == 0) {
                loadImageData(this.imagePicker.getOption());
                return;
            }
            i3 = R.string.permission_no_select;
        } else if (i2 != 2) {
            return;
        } else {
            if (iArr[0] == 0) {
                ImagePickerLauncher.takePicture((Activity) this, 1001, this.imagePicker.getOption());
                return;
            }
            i3 = R.string.permission_no_camera;
        }
        showToast(getString(i3));
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(KEY_PICKER_OPTION, this.imagePicker.getOption());
    }
}
