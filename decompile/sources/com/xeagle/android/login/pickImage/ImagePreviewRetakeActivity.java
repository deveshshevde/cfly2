package com.xeagle.android.login.pickImage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.ViewPagerFixed;
import com.xeagle.android.login.pickImage.adapter.ImagePageAdapter;
import com.xeagle.android.login.pickImage.adapter.LocalImagePageAdapter;
import com.xeagle.android.login.pickImage.data.GLImage;
import java.util.ArrayList;
import java.util.List;

public class ImagePreviewRetakeActivity extends ImageBaseActivity implements View.OnClickListener {
    protected ImagePageAdapter mAdapter;
    private ImageView mBtnOk;
    protected ArrayList<GLImage> mGLImages;
    protected ViewPagerFixed mViewPager;
    private ImageView retake;

    public static void start(Activity activity, GLImage gLImage) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(gLImage);
        start(activity, (List<GLImage>) arrayList);
    }

    public static void start(Activity activity, List<GLImage> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Intent intent = new Intent(activity, ImagePreviewRetakeActivity.class);
        intent.putExtra(Constants.EXTRA_SELECTED_IMAGE_POSITION, 0);
        intent.putExtra(Constants.EXTRA_IMAGE_ITEMS, arrayList);
        activity.startActivityForResult(intent, Constants.RESULT_CODE_CONFIRM_IMAGE);
    }

    public void clearMemoryCache() {
    }

    public void clearRequest() {
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.btn_ok) {
            Intent intent = new Intent();
            intent.putExtra(Constants.RESULT_EXTRA_CONFIRM_IMAGES, this.mGLImages);
            setResult(-1, intent);
        } else if (id2 != R.id.retake) {
            return;
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.image_preview_retake_activity);
        ImageView imageView = (ImageView) findViewById(R.id.btn_ok);
        this.mBtnOk = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) findViewById(R.id.retake);
        this.retake = imageView2;
        imageView2.setOnClickListener(this);
        this.mGLImages = (ArrayList) getIntent().getSerializableExtra(Constants.EXTRA_IMAGE_ITEMS);
        this.mViewPager = (ViewPagerFixed) findViewById(R.id.viewpager);
        LocalImagePageAdapter localImagePageAdapter = new LocalImagePageAdapter(this, this.mGLImages);
        this.mAdapter = localImagePageAdapter;
        this.mViewPager.setAdapter(localImagePageAdapter);
        this.mViewPager.setCurrentItem(0, false);
    }
}
