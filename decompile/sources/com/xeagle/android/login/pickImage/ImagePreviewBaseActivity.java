package com.xeagle.android.login.pickImage;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.flypro.photoview_library.PhotoView;
import com.xeagle.android.login.common.ViewPagerFixed;
import com.xeagle.android.login.pickImage.adapter.ImagePageAdapter;
import com.xeagle.android.login.pickImage.adapter.LocalImagePageAdapter;
import com.xeagle.android.login.pickImage.data.GLImage;
import java.util.ArrayList;

public abstract class ImagePreviewBaseActivity extends ImageBaseActivity {
    protected ImagePicker imagePicker;
    protected ImagePageAdapter mAdapter;
    protected int mCurrentPosition = 0;
    protected ArrayList<GLImage> mGLImages;
    protected TextView mTitleCount;
    protected ViewPagerFixed mViewPager;

    public void clearMemoryCache() {
        this.imagePicker.getImageLoader().clearMemoryCache();
    }

    public void clearRequest() {
    }

    /* access modifiers changed from: protected */
    public void getIntentData() {
        this.mCurrentPosition = getIntent().getIntExtra(Constants.EXTRA_SELECTED_IMAGE_POSITION, 0);
        this.imagePicker = ImagePicker.getInstance();
        this.mGLImages = getIntent().getBooleanExtra(Constants.EXTRA_IMAGE_PREVIEW_FROM_PICKER, false) ? this.imagePicker.getCurrentImageFolderItems() : (ArrayList) getIntent().getSerializableExtra(Constants.EXTRA_IMAGE_ITEMS);
    }

    public int getLayoutResId() {
        return R.layout.image_preview_activity;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getLayoutResId());
        getIntentData();
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImagePreviewBaseActivity.this.finish();
            }
        });
        this.mTitleCount = (TextView) findViewById(R.id.tv_des);
        this.mViewPager = (ViewPagerFixed) findViewById(R.id.viewpager);
        LocalImagePageAdapter localImagePageAdapter = new LocalImagePageAdapter(this, this.mGLImages);
        this.mAdapter = localImagePageAdapter;
        localImagePageAdapter.setPhotoViewClickListener(new ImagePageAdapter.PhotoViewClickListener() {
            public void OnPhotoTapListener(View view, float f2, float f3) {
                ImagePreviewBaseActivity.this.onImageSingleTap();
            }

            public void onPhotoLongListener(PhotoView photoView, String str) {
                ImagePreviewBaseActivity.this.onImageLongTap(photoView, str);
            }
        });
        this.mViewPager.setAdapter(this.mAdapter);
        this.mViewPager.setCurrentItem(this.mCurrentPosition, false);
        this.mTitleCount.setText(getString(R.string.preview_image_count, new Object[]{Integer.valueOf(this.mCurrentPosition + 1), Integer.valueOf(this.mGLImages.size())}));
    }

    /* access modifiers changed from: protected */
    public abstract void onImageLongTap(View view, String str);

    public abstract void onImageSingleTap();
}
