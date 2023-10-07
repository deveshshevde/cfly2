package com.xeagle.android.login.fragment;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.c;
import com.bumptech.glide.g;
import com.xeagle.R;
import com.xeagle.android.helpers.AdHelper;
import com.xeagle.android.login.beans.AdBeans;
import kotlin.jvm.internal.h;

final class DeviceFragment$callBack$1 implements AdHelper.ILoadAdCallBack {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$callBack$1(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public final void onLoadAd(AdBeans.AdContent adContent) {
        if (adContent != null) {
            View access$getMLayoutView$p = this.this$0.mLayoutView;
            h.a((Object) access$getMLayoutView$p);
            ImageView imageView = (ImageView) access$getMLayoutView$p.findViewById(R.id.iv_home_icon_ad);
            h.b(imageView, "mLayoutView!!.iv_home_icon_ad");
            imageView.setVisibility(0);
            View access$getMLayoutView$p2 = this.this$0.mLayoutView;
            h.a((Object) access$getMLayoutView$p2);
            ImageView imageView2 = (ImageView) access$getMLayoutView$p2.findViewById(R.id.iv_home_icon_ad_close);
            h.b(imageView2, "mLayoutView!!.iv_home_icon_ad_close");
            imageView2.setVisibility(0);
            View access$getMLayoutView$p3 = this.this$0.mLayoutView;
            h.a((Object) access$getMLayoutView$p3);
            ImageView imageView3 = (ImageView) access$getMLayoutView$p3.findViewById(R.id.iv_home_icon_ad);
            h.a((Object) imageView3);
            imageView3.setTag(adContent.getDetailUrl());
            g<Drawable> a2 = c.a((Fragment) this.this$0).a(adContent.getImageUrl());
            View access$getMLayoutView$p4 = this.this$0.mLayoutView;
            h.a((Object) access$getMLayoutView$p4);
            a2.a((ImageView) access$getMLayoutView$p4.findViewById(R.id.iv_home_icon_ad));
        }
    }
}
