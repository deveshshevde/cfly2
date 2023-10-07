package com.xeagle.android.login.pickImage.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cfly.uav_pro.R;
import com.flypro.photoview_library.PhotoView;
import com.flypro.photoview_library.d;
import com.xeagle.android.login.pickImage.ImagePicker;
import com.xeagle.android.login.pickImage.data.GLImage;
import com.xeagle.android.login.pickImage.loader.GlideImageLoader;
import java.util.ArrayList;

public class LocalImagePageAdapter extends ImagePageAdapter {
    public LocalImagePageAdapter(Activity activity, ArrayList<GLImage> arrayList) {
        super(activity, arrayList);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_preview_item, viewGroup, false);
        PhotoView photoView = (PhotoView) inflate.findViewById(R.id.pv_preview);
        final View findViewById = inflate.findViewById(R.id.pb_loading);
        ImagePicker.getInstance().getImageLoader().displayImage(this.mActivity, ((GLImage) this.images.get(i2)).getPath(), photoView, getScreenWidth(), getScreenHeight(), new GlideImageLoader.LoadListener() {
            public void onLoadFailed() {
            }

            public void onLoadSuccess() {
                findViewById.setVisibility(8);
            }
        });
        photoView.setOnPhotoTapListener(new d.C0104d() {
            public void onPhotoTap(View view, float f2, float f3) {
                if (LocalImagePageAdapter.this.listener != null) {
                    LocalImagePageAdapter.this.listener.OnPhotoTapListener(view, f2, f3);
                }
            }
        });
        viewGroup.addView(inflate);
        return inflate;
    }
}
