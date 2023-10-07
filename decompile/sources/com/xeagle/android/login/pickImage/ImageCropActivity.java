package com.xeagle.android.login.pickImage;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.pickImage.CropImageView;
import com.xeagle.android.login.pickImage.data.GLImage;
import com.xeagle.android.login.pickImage.loader.GlideImageLoader;
import java.io.File;
import java.util.ArrayList;

public class ImageCropActivity extends ImageBaseActivity implements View.OnClickListener, CropImageView.OnBitmapSaveCompleteListener {
    /* access modifiers changed from: private */
    public TextView btn_ok;
    private CropImageView cropImageView;
    private ImagePicker imagePicker;
    private ArrayList<GLImage> mGLImages;
    private boolean mIsSaveRectangle;
    private int mOutputX;
    private int mOutputY;
    private TextView tv_des;

    public int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (i5 > i3 || i4 > i2) {
            return i4 > i5 ? i4 / i2 : i5 / i3;
        }
        return 1;
    }

    public void clearMemoryCache() {
        this.imagePicker.getImageLoader().clearMemoryCache();
    }

    public void clearRequest() {
    }

    public void onBitmapSaveError(File file) {
    }

    public void onBitmapSaveSuccess(File file) {
        this.mGLImages.add(0, GLImage.Builder.newBuilder(this.mGLImages.remove(0)).setPath(file.getAbsolutePath()).build());
        Intent intent = new Intent();
        intent.putExtra(Constants.EXTRA_RESULT_ITEMS, this.mGLImages);
        setResult(-1, intent);
        finish();
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.btn_back) {
            setResult(0);
            finish();
        } else if (id2 == R.id.btn_ok && !this.cropImageView.saveBitmapToFile(this.imagePicker.getCropCacheFolder(this), this.mOutputX, this.mOutputY, this.mIsSaveRectangle)) {
            Toast.makeText(this, getString(R.string.crop_failed), 1).show();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.image_take_activity);
        this.imagePicker = ImagePicker.getInstance();
        findViewById(R.id.btn_back).setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.btn_ok);
        this.btn_ok = textView;
        textView.setText(getString(R.string.complete));
        this.btn_ok.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.tv_des);
        this.tv_des = textView2;
        textView2.setText(getString(R.string.photo_crop));
        CropImageView cropImageView2 = (CropImageView) findViewById(R.id.cv_crop_image);
        this.cropImageView = cropImageView2;
        cropImageView2.setOnBitmapSaveCompleteListener(this);
        this.mOutputX = this.imagePicker.getOutPutX();
        this.mOutputY = this.imagePicker.getOutPutY();
        this.mIsSaveRectangle = this.imagePicker.isSaveRectangle();
        ArrayList<GLImage> selectedImages = this.imagePicker.getSelectedImages();
        this.mGLImages = selectedImages;
        String path = selectedImages.get(0).getPath();
        this.cropImageView.setFocusStyle(this.imagePicker.getStyle());
        this.cropImageView.setFocusWidth(this.imagePicker.getFocusWidth());
        this.cropImageView.setFocusHeight(this.imagePicker.getFocusHeight());
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        final View findViewById = findViewById(R.id.pb_loading);
        this.btn_ok.setEnabled(false);
        ImagePicker.getInstance().getImageLoader().displayImage(this, path, this.cropImageView, displayMetrics.widthPixels, displayMetrics.heightPixels, new GlideImageLoader.LoadListener() {
            public void onLoadFailed() {
            }

            public void onLoadSuccess() {
                findViewById.setVisibility(8);
                ImageCropActivity.this.btn_ok.setEnabled(true);
            }
        });
    }
}
