package com.xeagle.android.login.pickImage.adapter;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.a;
import com.flypro.photoview_library.PhotoView;
import com.xeagle.android.login.common.Utils;
import com.xeagle.android.login.pickImage.ImagePicker;
import com.xeagle.android.login.pickImage.data.GLImage;
import java.util.ArrayList;

public abstract class ImagePageAdapter extends a {
    protected ArrayList<GLImage> images;
    public PhotoViewClickListener listener;
    protected Activity mActivity;
    private int screenHeight;
    private int screenWidth;

    public interface PhotoViewClickListener {
        void OnPhotoTapListener(View view, float f2, float f3);

        void onPhotoLongListener(PhotoView photoView, String str);
    }

    public ImagePageAdapter(Activity activity, ArrayList<GLImage> arrayList) {
        this.mActivity = activity;
        this.images = arrayList;
        DisplayMetrics screenPix = Utils.getScreenPix(activity);
        this.screenWidth = screenPix.widthPixels;
        this.screenHeight = screenPix.heightPixels;
    }

    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        if (obj instanceof View) {
            View view = (View) obj;
            ImagePicker.getInstance().getImageLoader().clearRequest(view);
            viewGroup.removeView(view);
        }
    }

    public int getCount() {
        return this.images.size();
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    /* access modifiers changed from: protected */
    public int getScreenHeight() {
        return this.screenHeight;
    }

    /* access modifiers changed from: protected */
    public int getScreenWidth() {
        return this.screenWidth;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void setData(ArrayList<GLImage> arrayList) {
        this.images = arrayList;
    }

    public void setPhotoViewClickListener(PhotoViewClickListener photoViewClickListener) {
        this.listener = photoViewClickListener;
    }
}
