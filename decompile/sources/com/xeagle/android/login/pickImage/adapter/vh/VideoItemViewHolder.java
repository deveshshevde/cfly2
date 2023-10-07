package com.xeagle.android.login.pickImage.adapter.vh;

import android.view.ViewGroup;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.TimeUtil;
import com.xeagle.android.login.pickImage.ImagePicker;
import com.xeagle.android.login.pickImage.adapter.AdvancedAdapter;
import com.xeagle.android.login.pickImage.data.GLImage;
import com.xeagle.android.login.pickImage.loader.GlideImageLoader;

public class VideoItemViewHolder extends ItemViewHolder {
    public VideoItemViewHolder(ViewGroup viewGroup, ImagePicker imagePicker, AdvancedAdapter advancedAdapter) {
        super(viewGroup, imagePicker, advancedAdapter);
    }

    public void clearRequest() {
        ImagePicker.getInstance().getImageLoader().clearRequest(this.ivThumb);
    }

    /* access modifiers changed from: protected */
    public void onBindViewHolder(SectionModel sectionModel) {
        super.onBindViewHolder(sectionModel);
        this.mask.setVisibility(0);
        this.videoIcon.setVisibility(0);
        GLImage image = sectionModel.getImage();
        this.timeMask.setVisibility(0);
        this.timeMask.setText(TimeUtil.secToTime((int) (((float) image.getDuration()) / 1000.0f)));
        GlideImageLoader.displayAlbumThumb(this.ivThumb, image.getPath(), R.drawable.ic_launcher);
    }
}
