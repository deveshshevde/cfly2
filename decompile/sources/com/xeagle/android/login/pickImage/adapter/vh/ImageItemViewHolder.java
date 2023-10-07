package com.xeagle.android.login.pickImage.adapter.vh;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xeagle.android.login.common.Utils;
import com.xeagle.android.login.pickImage.ImagePicker;
import com.xeagle.android.login.pickImage.adapter.AdvancedAdapter;
import com.xeagle.android.login.pickImage.data.GLImage;
import com.xeagle.android.login.pickImage.loader.ImageLoader;

public class ImageItemViewHolder extends ItemViewHolder {
    private final int imageSize;

    public ImageItemViewHolder(ViewGroup viewGroup, ImagePicker imagePicker, AdvancedAdapter advancedAdapter) {
        super(viewGroup, imagePicker, advancedAdapter);
        this.imageSize = Utils.getImageItemWidth(viewGroup.getContext());
    }

    public void clearRequest() {
        ImagePicker.getInstance().getImageLoader().clearRequest(this.ivThumb);
    }

    /* access modifiers changed from: protected */
    public void onBindViewHolder(SectionModel sectionModel) {
        super.onBindViewHolder(sectionModel);
        GLImage image = sectionModel.getImage();
        this.timeMask.setVisibility(8);
        ImageLoader imageLoader = getImagePicker().getImageLoader();
        Context context = this.ivThumb.getContext();
        String path = image.getPath();
        ImageView imageView = this.ivThumb;
        int i2 = this.imageSize;
        imageLoader.displayImage(context, path, imageView, i2, i2);
    }
}
