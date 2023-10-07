package com.xeagle.android.login.pickImage.loader;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.xeagle.android.login.pickImage.loader.GlideImageLoader;
import java.io.Serializable;

public interface ImageLoader extends Serializable {
    void clearMemoryCache();

    void clearRequest(View view);

    void displayImage(Context context, String str, ImageView imageView, int i2, int i3);

    void displayImage(Context context, String str, ImageView imageView, int i2, int i3, GlideImageLoader.LoadListener loadListener);

    void downloadImage(Context context, String str, GlideImageLoader.LoadListener loadListener);
}
