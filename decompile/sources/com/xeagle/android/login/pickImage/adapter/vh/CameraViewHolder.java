package com.xeagle.android.login.pickImage.adapter.vh;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.a;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.pickImage.CaptureActivity;
import com.xeagle.android.login.pickImage.Constants;
import com.xeagle.android.login.pickImage.ImageBaseActivity;
import com.xeagle.android.login.pickImage.ImagePicker;
import com.xeagle.android.login.pickImage.ImagePickerLauncher;
import com.xeagle.android.login.pickImage.adapter.BaseViewHolder;

public class CameraViewHolder extends BaseViewHolder<Object> {
    /* access modifiers changed from: private */
    public final ImageBaseActivity activity;
    /* access modifiers changed from: private */
    public final ImagePicker imagePicker;

    public CameraViewHolder(ViewGroup viewGroup, ImageBaseActivity imageBaseActivity, ImagePicker imagePicker2) {
        super(viewGroup, R.layout.adapter_image_list_camera);
        this.imagePicker = imagePicker2;
        this.activity = imageBaseActivity;
    }

    public void findViews() {
        this.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (CameraViewHolder.this.imagePicker.videoOnly()) {
                    CaptureActivity.RECORD_MAX_TIME = CameraViewHolder.this.imagePicker.getOption().getMaxVideoDuration();
                    CaptureActivity.RECORD_MIN_TIME = 1;
                    CaptureActivity.start(CameraViewHolder.this.activity);
                } else if (!CameraViewHolder.this.imagePicker.imageOnly()) {
                    CaptureActivity.start(CameraViewHolder.this.activity, Constants.RESULT_CODE_RECORD_VIDEO);
                } else if (!CameraViewHolder.this.activity.checkPermission("android.permission.CAMERA")) {
                    a.a(CameraViewHolder.this.activity, new String[]{"android.permission.CAMERA"}, 2);
                } else {
                    ImagePickerLauncher.takePicture((Activity) CameraViewHolder.this.activity, 1001, CameraViewHolder.this.imagePicker.getOption());
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onBindViewHolder(Object obj) {
    }
}
