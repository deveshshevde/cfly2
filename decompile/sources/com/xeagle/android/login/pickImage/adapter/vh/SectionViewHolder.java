package com.xeagle.android.login.pickImage.adapter.vh;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.pickImage.ImagePicker;
import com.xeagle.android.login.pickImage.adapter.AdvancedAdapter;
import com.xeagle.android.login.pickImage.adapter.BaseViewHolder;
import com.xeagle.android.login.pickImage.adapter.vh.SectionModel;
import com.xeagle.android.login.pickImage.data.GLImage;
import java.util.List;

public class SectionViewHolder extends BaseViewHolder<SectionModel> {
    /* access modifiers changed from: private */
    public final AdvancedAdapter adapter;
    public CheckBox chooseAll;
    /* access modifiers changed from: private */
    public final ImagePicker imagePicker;
    private SectionModel.Listener listener = new SectionModel.Listener() {
        public void onChanged() {
            int adapterPosition = SectionViewHolder.this.getAdapterPosition();
            if (adapterPosition != -1) {
                SectionViewHolder.this.adapter.notifyItemChanged(adapterPosition);
            }
        }
    };
    /* access modifiers changed from: private */
    public SectionModel model;
    public TextView sectionTitle;

    public SectionViewHolder(ViewGroup viewGroup, ImagePicker imagePicker2, AdvancedAdapter advancedAdapter) {
        super(viewGroup, R.layout.adapter_image_list_section);
        this.imagePicker = imagePicker2;
        this.adapter = advancedAdapter;
    }

    /* access modifiers changed from: private */
    public int countSizeOfUnselected(List<GLImage> list, ImagePicker imagePicker2) {
        int i2 = 0;
        for (GLImage isSelect : list) {
            if (imagePicker2.isSelect(isSelect)) {
                i2++;
            }
        }
        return list.size() - i2;
    }

    public void findViews() {
        this.sectionTitle = (TextView) this.itemView.findViewById(R.id.section_title);
        CheckBox checkBox = (CheckBox) this.itemView.findViewById(R.id.choose_all);
        this.chooseAll = checkBox;
        checkBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (SectionViewHolder.this.model != null) {
                    List<GLImage> images = SectionViewHolder.this.model.getImages();
                    if (!SectionViewHolder.this.chooseAll.isChecked()) {
                        for (int i2 = 0; i2 < images.size(); i2++) {
                            SectionViewHolder.this.imagePicker.addSelectedImageItem(images.get(i2), false);
                        }
                    } else if (!SectionViewHolder.this.imagePicker.isMaxLimitOk()) {
                        Context context = SectionViewHolder.this.itemView.getContext();
                        Toast.makeText(context.getApplicationContext(), context.getString(R.string.choose_max_num, new Object[]{Integer.valueOf(SectionViewHolder.this.imagePicker.getSelectMax())}), 1).show();
                        SectionViewHolder.this.chooseAll.setChecked(false);
                    } else {
                        SectionViewHolder sectionViewHolder = SectionViewHolder.this;
                        int min = Math.min(SectionViewHolder.this.imagePicker.getSelectImageLeftCount(), sectionViewHolder.countSizeOfUnselected(images, sectionViewHolder.imagePicker));
                        int i3 = 0;
                        boolean z2 = true;
                        for (GLImage next : images) {
                            if (i3 >= min) {
                                break;
                            } else if (!SectionViewHolder.this.imagePicker.isSelect(next)) {
                                if (!TextUtils.isEmpty(SectionViewHolder.this.imagePicker.isSelectEnable(SectionViewHolder.this.context, next))) {
                                    z2 = false;
                                } else {
                                    SectionViewHolder.this.imagePicker.addSelectedImageItem(next, true);
                                    i3++;
                                }
                            }
                        }
                        if (!z2) {
                            SectionViewHolder.this.chooseAll.setChecked(false);
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onBindViewHolder(SectionModel sectionModel) {
        this.model = sectionModel;
        sectionModel.setListener(this.listener);
        this.sectionTitle.setText(sectionModel.getKey());
        if (this.imagePicker.isMultiMode()) {
            this.chooseAll.setVisibility(0);
            this.chooseAll.setChecked(this.imagePicker.isSelectAll(sectionModel.getImages()));
            return;
        }
        this.chooseAll.setVisibility(8);
    }
}
