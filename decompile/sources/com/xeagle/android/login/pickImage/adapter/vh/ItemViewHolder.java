package com.xeagle.android.login.pickImage.adapter.vh;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.pickImage.ImagePicker;
import com.xeagle.android.login.pickImage.adapter.AdvancedAdapter;
import com.xeagle.android.login.pickImage.adapter.BaseViewHolder;
import com.xeagle.android.login.pickImage.adapter.vh.SectionModel;

public abstract class ItemViewHolder extends BaseViewHolder<SectionModel> {
    /* access modifiers changed from: private */
    public final AdvancedAdapter adapter;
    /* access modifiers changed from: private */
    public TextView cbCheck;
    final ImagePicker imagePicker;
    protected ImageView ivThumb;
    private SectionModel.Listener listener = new SectionModel.Listener() {
        public void onChanged() {
            int adapterPosition = ItemViewHolder.this.getAdapterPosition();
            if (adapterPosition != -1) {
                ItemViewHolder.this.adapter.notifyItemChanged(adapterPosition);
            }
        }
    };
    protected View mask;
    /* access modifiers changed from: private */
    public SectionModel model;
    protected TextView timeMask;
    protected ImageView videoIcon;

    ItemViewHolder(ViewGroup viewGroup, ImagePicker imagePicker2, AdvancedAdapter advancedAdapter) {
        super(viewGroup, R.layout.adapter_image_list_item);
        this.imagePicker = imagePicker2;
        this.adapter = advancedAdapter;
    }

    public void findViews() {
        this.ivThumb = (ImageView) this.itemView.findViewById(R.id.iv_thumb);
        this.mask = this.itemView.findViewById(R.id.mask);
        this.cbCheck = (TextView) this.itemView.findViewById(R.id.cb_check);
        this.timeMask = (TextView) this.itemView.findViewById(R.id.time_mask);
        this.videoIcon = (ImageView) this.itemView.findViewById(R.id.video_icon);
        this.cbCheck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ItemViewHolder.this.model != null) {
                    ItemViewHolder.this.cbCheck.setSelected(!ItemViewHolder.this.cbCheck.isSelected());
                    if (ItemViewHolder.this.cbCheck.isSelected()) {
                        Context context = ItemViewHolder.this.cbCheck.getContext();
                        String isSelectEnable = ItemViewHolder.this.imagePicker.isSelectEnable(context, ItemViewHolder.this.model.getImage());
                        if (!TextUtils.isEmpty(isSelectEnable)) {
                            Toast.makeText(context.getApplicationContext(), isSelectEnable, 0).show();
                            ItemViewHolder.this.cbCheck.setSelected(false);
                            return;
                        }
                    }
                    ItemViewHolder.this.imagePicker.addSelectedImageItem(ItemViewHolder.this.model.getImage(), ItemViewHolder.this.cbCheck.isSelected());
                }
            }
        });
        this.ivThumb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ItemViewHolder.this.model != null) {
                    ItemViewHolder.this.model.notifyClicked(view);
                }
            }
        });
    }

    public ImagePicker getImagePicker() {
        return this.imagePicker;
    }

    /* access modifiers changed from: protected */
    public void onBindViewHolder(SectionModel sectionModel) {
        this.mask.setVisibility(8);
        this.videoIcon.setVisibility(8);
        this.model = sectionModel;
        sectionModel.setListener(this.listener);
        if (this.imagePicker.isMultiMode()) {
            boolean z2 = false;
            this.cbCheck.setVisibility(0);
            int selectOrder = this.imagePicker.selectOrder(sectionModel.getImage());
            TextView textView = this.cbCheck;
            if (selectOrder > 0) {
                z2 = true;
            }
            textView.setSelected(z2);
            TextView textView2 = this.cbCheck;
            String str = "";
            if (selectOrder > 0) {
                str = selectOrder + str;
            }
            textView2.setText(str);
            return;
        }
        this.cbCheck.setVisibility(8);
    }
}
