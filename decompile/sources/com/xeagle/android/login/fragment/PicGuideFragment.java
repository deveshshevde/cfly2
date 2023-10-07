package com.xeagle.android.login.fragment;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.c;
import com.cfly.uav_pro.R;

public class PicGuideFragment extends LazyLoadFragment {
    private ImageView pic_guide;

    /* access modifiers changed from: protected */
    public void lazyLoad() {
        this.pic_guide = (ImageView) findViewById(R.id.pic_guide);
    }

    /* access modifiers changed from: protected */
    public int setContentView() {
        return R.layout.pic_guide_layout;
    }

    public void updateImageView(Context context, String str) {
        c.b(context).j().a(str).a(this.pic_guide);
    }
}
