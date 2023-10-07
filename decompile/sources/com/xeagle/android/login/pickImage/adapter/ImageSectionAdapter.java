package com.xeagle.android.login.pickImage.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.xeagle.android.login.common.MediaUtil;
import com.xeagle.android.login.pickImage.ImageBaseActivity;
import com.xeagle.android.login.pickImage.ImagePicker;
import com.xeagle.android.login.pickImage.adapter.vh.CameraViewHolder;
import com.xeagle.android.login.pickImage.adapter.vh.ImageItemViewHolder;
import com.xeagle.android.login.pickImage.adapter.vh.SectionModel;
import com.xeagle.android.login.pickImage.adapter.vh.SectionViewHolder;
import com.xeagle.android.login.pickImage.adapter.vh.VideoItemViewHolder;
import com.xeagle.android.login.pickImage.data.GLImage;
import java.util.List;
import java.util.Map;

public class ImageSectionAdapter extends AdvancedAdapter {
    private static final int sTypeItemCamera = 3;
    private static final int sTypeItemImage = 0;
    private static final int sTypeItemTitle = 2;
    private static final int sTypeItemVideo = 1;
    /* access modifiers changed from: private */
    public ImageBaseActivity activity;
    /* access modifiers changed from: private */
    public ImagePicker imagePicker = ImagePicker.getInstance();
    private OnImageClickListener listener;

    public interface OnImageClickListener {
        void onImageItemClick(View view, GLImage gLImage, int i2);
    }

    public ImageSectionAdapter(ImageBaseActivity imageBaseActivity) {
        this.activity = imageBaseActivity;
        setDelegate(new AdvancedDelegate() {
            public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
                if (i2 == 0) {
                    return new ImageItemViewHolder(viewGroup, ImageSectionAdapter.this.imagePicker, ImageSectionAdapter.this);
                }
                if (i2 == 1) {
                    return new VideoItemViewHolder(viewGroup, ImageSectionAdapter.this.imagePicker, ImageSectionAdapter.this);
                }
                if (i2 == 2) {
                    return new SectionViewHolder(viewGroup, ImageSectionAdapter.this.imagePicker, ImageSectionAdapter.this);
                }
                if (i2 != 3) {
                    return null;
                }
                return new CameraViewHolder(viewGroup, ImageSectionAdapter.this.activity, ImageSectionAdapter.this.imagePicker);
            }
        });
    }

    public int getSpanSize(int i2) {
        return getItemViewType(i2) != 2 ? 1 : 4;
    }

    public void refreshData(List<GLImage> list) {
        clear();
        if (list != null && list.size() > 0) {
            Map<String, List<GLImage>> divideMedias = MediaUtil.divideMedias(list);
            int i2 = 0;
            for (int i3 = 0; i3 < divideMedias.keySet().size(); i3++) {
                String str = (String) divideMedias.keySet().toArray()[i3];
                List<GLImage> list2 = divideMedias.get(str);
                SectionModel begin = SectionModel.begin(str, list2, i2, this.listener);
                if (this.imagePicker.isShowSection()) {
                    add(2, begin);
                }
                int i4 = 0;
                for (GLImage isVideo : list2) {
                    SectionModel wrap = SectionModel.wrap(i4, begin);
                    if (isVideo.isVideo()) {
                        add(1, wrap);
                    } else {
                        add(0, wrap);
                    }
                    i4++;
                }
                i2 += list2.size();
            }
        }
        if (this.imagePicker.isShowCamera()) {
            add(3, (Object) null, 0);
        }
        notifyDataSetChanged();
    }

    public void setOnImageItemClickListener(OnImageClickListener onImageClickListener) {
        this.listener = onImageClickListener;
    }
}
