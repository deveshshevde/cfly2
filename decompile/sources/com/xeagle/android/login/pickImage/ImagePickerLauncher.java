package com.xeagle.android.login.pickImage;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.xeagle.android.login.pickImage.ImagePickerOption;

public class ImagePickerLauncher {
    private static final String TAG = "com.xeagle.android.login.pickImage.ImagePickerLauncher";

    public static void selectImage(Activity activity, int i2, ImagePickerOption imagePickerOption) {
        ImagePicker.getInstance().setOption(imagePickerOption);
        activity.startActivityForResult(new Intent(activity, ImageGridActivity.class), i2);
    }

    protected static void selectImageFromAlbum(Activity activity, int i2) {
        ImagePickerOption crop = DefaultImagePickerOption.getInstance().setCrop(true);
        crop.setPickType(ImagePickerOption.PickType.Image).setMultiMode(false).setSelectMax(1).setShowCamera(false);
        selectImage(activity, i2, crop);
    }

    public static void takePhoto(Activity activity, int i2) {
        ImagePickerOption instance = DefaultImagePickerOption.getInstance();
        instance.setPickType(ImagePickerOption.PickType.Image).setShowCamera(true).setMultiMode(false).setSelectMax(1).setCrop(true);
        ImagePicker.getInstance().setOption(instance);
        activity.startActivityForResult(new Intent(activity, ImageTakeActivity.class), i2);
    }

    public static void takePicture(Activity activity, int i2, ImagePickerOption imagePickerOption) {
        ImagePicker.getInstance().setOption(imagePickerOption);
        activity.startActivityForResult(new Intent(activity, ImageTakeActivity.class), i2);
    }

    public static void takePicture(Fragment fragment, int i2, ImagePickerOption imagePickerOption) {
        ImagePicker.getInstance().setOption(imagePickerOption);
        fragment.startActivityForResult(new Intent(fragment.getActivity(), ImageTakeActivity.class), i2);
    }
}
