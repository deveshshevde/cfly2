package com.xeagle.android.login.pickImage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.NetworkUtil;
import com.xeagle.android.login.common.SuperCheckBox;
import com.xeagle.android.login.common.ToastHelper;
import com.xeagle.android.login.pickImage.ImagePicker;
import com.xeagle.android.login.pickImage.adapter.BaseAdapter;
import com.xeagle.android.login.pickImage.adapter.BaseDelegate;
import com.xeagle.android.login.pickImage.adapter.BaseViewHolder;
import com.xeagle.android.login.pickImage.adapter.ItemClickListerAdapter;
import com.xeagle.android.login.pickImage.data.GLImage;
import com.xeagle.android.utils.s;
import java.util.Iterator;

public class ImagePreviewActivity extends ImagePreviewBaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, ImagePicker.OnImageSelectedListener {
    private View bottomBar;
    private BaseAdapter chooseAdapter;
    /* access modifiers changed from: private */
    public int imageSize;
    private boolean isOrigin;
    private TextView mBtnOk;
    /* access modifiers changed from: private */
    public TextView mCbCheck;
    private SuperCheckBox mCbOrigin;
    private RecyclerView recyclerView;

    private class ChooseViewHolder extends BaseViewHolder<GLImage> {
        private ImageView chooseItem;
        private View maskItem;

        public ChooseViewHolder(ViewGroup viewGroup) {
            super(viewGroup, R.layout.image_preview_item);
        }

        public void findViews() {
            this.chooseItem = (ImageView) this.itemView.findViewById(R.id.choose_item);
            this.maskItem = this.itemView.findViewById(R.id.mask_item);
        }

        /* access modifiers changed from: protected */
        public void onBindViewHolder(GLImage gLImage) {
            int i2;
            View view;
            if (gLImage.equals(ImagePreviewActivity.this.mGLImages.get(ImagePreviewActivity.this.mCurrentPosition))) {
                view = this.maskItem;
                i2 = 0;
            } else {
                view = this.maskItem;
                i2 = 8;
            }
            view.setVisibility(i2);
            ImagePreviewActivity.this.imagePicker.getImageLoader().displayImage(ImagePreviewActivity.this, gLImage.getPath(), this.chooseItem, ImagePreviewActivity.this.imageSize, ImagePreviewActivity.this.imageSize);
        }
    }

    /* access modifiers changed from: private */
    public int findPos(GLImage gLImage) {
        Iterator it2 = this.mGLImages.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            if (((GLImage) it2.next()).equals(gLImage)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private void init() {
        initTitle();
        onImageSelected((GLImage) null, false);
        this.mViewPager.addOnPageChangeListener(new ViewPager.h() {
            public void onPageSelected(int i2) {
                ImagePreviewActivity.this.mCurrentPosition = i2;
                ImagePreviewActivity.this.initTitle();
                ImagePreviewActivity.this.updateCheckState();
            }
        });
        this.mCbCheck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GLImage gLImage = (GLImage) ImagePreviewActivity.this.mGLImages.get(ImagePreviewActivity.this.mCurrentPosition);
                ImagePreviewActivity.this.mCbCheck.setSelected(!ImagePreviewActivity.this.mCbCheck.isSelected());
                if (ImagePreviewActivity.this.mCbCheck.isSelected()) {
                    String isSelectEnable = ImagePreviewActivity.this.imagePicker.isSelectEnable(view.getContext(), gLImage);
                    if (!TextUtils.isEmpty(isSelectEnable)) {
                        ImagePreviewActivity.this.mCbCheck.setSelected(false);
                        Toast.makeText(ImagePreviewActivity.this, isSelectEnable, 0).show();
                        return;
                    }
                }
                ImagePreviewActivity.this.imagePicker.addSelectedImageItem(gLImage, ImagePreviewActivity.this.mCbCheck.isSelected());
                ImagePreviewActivity.this.updateCheckState();
            }
        });
    }

    private void initRv() {
        BaseAdapter baseAdapter = new BaseAdapter(this.imagePicker.getSelectedImages(), new ItemClickListerAdapter<GLImage>() {
            public void onClick(View view, int i2, GLImage gLImage) {
                int access$000 = ImagePreviewActivity.this.findPos(gLImage);
                if (access$000 != -1) {
                    ImagePreviewActivity.this.mViewPager.setCurrentItem(access$000, false);
                }
            }
        });
        this.chooseAdapter = baseAdapter;
        baseAdapter.setDelegate(new BaseDelegate<GLImage>() {
            public int getItemViewType(GLImage gLImage, int i2) {
                return 0;
            }

            public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
                return new ChooseViewHolder(viewGroup);
            }
        });
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.recyclerView.setAdapter(this.chooseAdapter);
    }

    /* access modifiers changed from: private */
    public void initTitle() {
        this.mTitleCount.setText(getString(R.string.preview_image_count, new Object[]{Integer.valueOf(this.mCurrentPosition + 1), Integer.valueOf(this.mGLImages.size())}));
    }

    private void setOkButtonEnable(boolean z2) {
        TextView textView;
        boolean z3;
        if (z2) {
            textView = this.mBtnOk;
            z3 = true;
        } else {
            textView = this.mBtnOk;
            z3 = false;
        }
        textView.setEnabled(z3);
        syncButtonText();
    }

    private void syncButtonText() {
        if (this.imagePicker != null) {
            int selectImageCount = this.imagePicker.getSelectImageCount();
            if (selectImageCount == 0) {
                this.mBtnOk.setText(R.string.button_setup_send);
                return;
            }
            TextView textView = this.mBtnOk;
            textView.setText(textView.getContext().getString(R.string.send_d, new Object[]{Integer.valueOf(selectImageCount)}));
        }
    }

    /* access modifiers changed from: private */
    public void updateCheckState() {
        GLImage gLImage = (GLImage) this.mGLImages.get(this.mCurrentPosition);
        int selectOrder = this.imagePicker.selectOrder(gLImage);
        int i2 = 0;
        this.mCbCheck.setSelected(selectOrder > 0);
        TextView textView = this.mCbCheck;
        String str = "";
        if (selectOrder > 0) {
            str = selectOrder + str;
        }
        textView.setText(str);
        this.chooseAdapter.notifyDataSetChanged();
        if (selectOrder > 0) {
            Iterator<GLImage> it2 = this.imagePicker.getSelectedImages().iterator();
            while (it2.hasNext() && !it2.next().equals(gLImage)) {
                i2++;
            }
            this.recyclerView.a(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void getIntentData() {
        super.getIntentData();
        this.isOrigin = getIntent().getBooleanExtra(Constants.IS_ORIGIN, false);
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(Constants.IS_ORIGIN, this.isOrigin);
        setResult(1, intent);
        finish();
        super.onBackPressed();
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        if (compoundButton.getId() == R.id.cb_origin) {
            this.isOrigin = z2;
        }
    }

    public void onClick(View view) {
        Intent intent;
        int i2;
        int id2 = view.getId();
        if (id2 == R.id.btn_ok) {
            if (!this.imagePicker.needCheckNetwork() || NetworkUtil.isNetAvailable(this)) {
                intent = new Intent();
                intent.putExtra(Constants.EXTRA_RESULT_ITEMS, this.imagePicker.getSelectedImages());
                i2 = -1;
            } else {
                ToastHelper.showToast((Context) this, (int) R.string.network_available);
                return;
            }
        } else if (id2 == R.id.btn_back) {
            intent = new Intent();
            intent.putExtra(Constants.IS_ORIGIN, this.isOrigin);
            i2 = 1;
        } else {
            return;
        }
        setResult(i2, intent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getIntentData();
        this.imagePicker.addOnImageSelectedListener(this);
        TextView textView = (TextView) findViewById(R.id.btn_ok);
        this.mBtnOk = textView;
        textView.setOnClickListener(this);
        View findViewById = findViewById(R.id.bottom_bar);
        this.bottomBar = findViewById;
        findViewById.setVisibility(0);
        this.mCbCheck = (TextView) findViewById(R.id.cb_check);
        this.mCbOrigin = (SuperCheckBox) findViewById(R.id.cb_origin);
        this.recyclerView = (RecyclerView) findViewById(R.id.choose_list);
        this.mCbOrigin.setOnCheckedChangeListener(this);
        this.mCbOrigin.setChecked(this.isOrigin);
        this.imageSize = s.a(55.0f);
        syncButtonText();
        init();
        initRv();
        updateCheckState();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.imagePicker.removeOnImageSelectedListener(this);
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onImageLongTap(View view, String str) {
    }

    public void onImageSelected(GLImage gLImage, boolean z2) {
        boolean z3;
        if (this.imagePicker.getSelectImageCount() > this.imagePicker.getSelectMin()) {
            this.mBtnOk.setText(R.string.complete);
            z3 = true;
        } else {
            this.mBtnOk.setText(R.string.complete);
            z3 = false;
        }
        setOkButtonEnable(z3);
    }

    public void onImageSingleTap() {
    }
}
