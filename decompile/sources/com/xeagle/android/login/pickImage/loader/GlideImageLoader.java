package com.xeagle.android.login.pickImage.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import bz.j;
import com.bumptech.glide.c;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.resource.bitmap.v;
import com.bumptech.glide.request.a;
import com.bumptech.glide.request.g;
import com.bumptech.glide.request.h;
import com.cfly.uav_pro.R;
import java.io.File;

public class GlideImageLoader implements ImageLoader {

    public interface LoadListener {
        void onLoadFailed();

        void onLoadSuccess();
    }

    private static i<Bitmap> createRounded() {
        return createRounded(4);
    }

    private static i<Bitmap> createRounded(int i2) {
        return new v(4);
    }

    private static void displayAlbum(ImageView imageView, String str, i<Bitmap> iVar, int i2) {
        a aVar;
        Context context = imageView.getContext();
        h hVar = (h) ((h) ((h) new h().b(i2)).a(i2)).a(com.bumptech.glide.load.engine.h.f10304d);
        if (iVar != null) {
            aVar = hVar.a((i<Bitmap>[]) new i[]{new com.bumptech.glide.load.resource.bitmap.i(), iVar});
        } else {
            aVar = hVar.a((i<Bitmap>) new com.bumptech.glide.load.resource.bitmap.i());
        }
        c.b(context).j().b((a<?>) (h) aVar).a(Uri.fromFile(new File(str))).a(imageView);
    }

    public static void displayAlbumThumb(ImageView imageView, String str, int i2) {
        displayAlbum(imageView, str, createRounded(), i2);
    }

    public static void displayVideo(ImageView imageView, Uri uri) {
        if (uri != null) {
            displayAlbum(imageView, uri.getPath(), (i<Bitmap>) null, R.drawable.ic_launcher);
        }
    }

    public static void displayVideo(ImageView imageView, String str) {
        if (!TextUtils.isEmpty(str)) {
            c.b(imageView.getContext()).j().b((a<?>) (h) ((h) ((h) ((h) new h().b((int) R.drawable.ic_launcher)).a((int) R.drawable.ic_launcher)).a(com.bumptech.glide.load.engine.h.f10304d)).i()).a(str).a(imageView);
        }
    }

    public void clearMemoryCache() {
    }

    public void clearRequest(View view) {
        c.a(view).a(view);
    }

    public void displayImage(Context context, String str, ImageView imageView, int i2, int i3) {
        i[] iVarArr = {new com.bumptech.glide.load.resource.bitmap.i(), new v(4)};
        c.b(context).j().b((a<?>) (h) ((h) ((h) ((h) ((h) ((h) new h().a((int) R.drawable.ic_launcher)).b((int) R.drawable.ic_launcher)).a(com.bumptech.glide.load.engine.h.f10301a)).a((i<Bitmap>[]) iVarArr)).c(i2, i3)).l()).a(Uri.fromFile(new File(str))).a(imageView);
    }

    public void displayImage(Context context, String str, ImageView imageView, int i2, int i3, final LoadListener loadListener) {
        c.b(context).j().b((a<?>) (h) ((h) ((h) ((h) new h().b(0)).a(0)).a(com.bumptech.glide.load.engine.h.f10301a)).g()).a(Uri.fromFile(new File(str))).a(new g<Drawable>() {
            public boolean onLoadFailed(GlideException glideException, Object obj, j<Drawable> jVar, boolean z2) {
                return false;
            }

            public boolean onResourceReady(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z2) {
                LoadListener loadListener = loadListener;
                if (loadListener == null) {
                    return false;
                }
                loadListener.onLoadSuccess();
                return false;
            }
        }).a(imageView);
    }

    public void downloadImage(Context context, String str, final LoadListener loadListener) {
        c.b(context).k().b((a<?>) (h) ((h) ((h) ((h) new h().b(0)).a(0)).a(com.bumptech.glide.load.engine.h.f10301a)).g()).a(Uri.fromFile(new File(str))).a(new g<File>() {
            public boolean onLoadFailed(GlideException glideException, Object obj, j<File> jVar, boolean z2) {
                return false;
            }

            public boolean onResourceReady(File file, Object obj, j<File> jVar, DataSource dataSource, boolean z2) {
                LoadListener loadListener = loadListener;
                if (loadListener == null) {
                    return true;
                }
                loadListener.onLoadSuccess();
                return true;
            }
        }).b();
    }
}
