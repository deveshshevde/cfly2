package com.xeagle.android.login.pickImage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import androidx.core.app.a;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.TimeUtil;
import com.xeagle.android.login.common.Utils;
import com.xeagle.android.login.pickImage.data.GLImage;
import com.xeagle.android.login.pickImage.data.GenericFileProvider;
import java.io.File;

public class ImageTakeActivity extends ImageBaseActivity {
    private ImagePicker imagePicker;

    private void takePicture() {
        File file;
        Uri uri;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.setFlags(67108864);
        if (intent.resolveActivity(getPackageManager()) != null) {
            file = Utils.createFile(Utils.existSDCard() ? new File(Environment.getExternalStorageDirectory(), "/DCIM/camera/") : Environment.getDataDirectory(), "IMG_", ".jpg");
            if (file != null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    uri = GenericFileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".fileProvider", file);
                } else {
                    uri = Uri.fromFile(file);
                }
                intent.putExtra("output", uri);
            }
        } else {
            file = null;
        }
        if (file != null) {
            this.imagePicker.setTakeImageFile(file);
            startActivityForResult(intent, 1001);
        }
    }

    public void clearMemoryCache() {
    }

    public void clearRequest() {
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1001) {
            if (i3 == -1) {
                Utils.galleryAddPic(this, this.imagePicker.getTakeImageFile());
                GLImage build = GLImage.Builder.newBuilder().setAddTime(TimeUtil.getNow_millisecond()).setPath(this.imagePicker.getTakeImageFile().getAbsolutePath()).setMimeType("image/jpeg").build();
                this.imagePicker.clearSelectedImages();
                this.imagePicker.addSelectedImageItem(build, true);
                if (this.imagePicker.isCrop()) {
                    startActivityForResult(new Intent(this, ImageCropActivity.class), 1002);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra(Constants.EXTRA_RESULT_ITEMS, this.imagePicker.getSelectedImages());
                setResult(-1, intent2);
            }
            finish();
        } else if (i2 == 1002) {
            if (i3 == -1) {
                setResult(-1, intent);
            }
            finish();
        } else {
            return;
        }
        finish();
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.image_take_activity);
        this.imagePicker = ImagePicker.getInstance();
        if (bundle != null) {
            return;
        }
        if (!checkPermission("android.permission.CAMERA")) {
            a.a(this, new String[]{"android.permission.CAMERA"}, 2);
        } else {
            takePicture();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 2) {
            return;
        }
        if (iArr[0] == 0) {
            ImagePickerLauncher.takePicture((Activity) this, 1001, this.imagePicker.getOption());
            return;
        }
        showToast(getString(R.string.permission_no_camera));
        finish();
    }
}
