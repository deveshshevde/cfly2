package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import java.io.IOException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public final class t implements g<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final k f10511a;

    public t(k kVar) {
        this.f10511a = kVar;
    }

    private boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        return (!"HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) && !"HONOR".equalsIgnoreCase(Build.MANUFACTURER)) || parcelFileDescriptor.getStatSize() <= IjkMediaMeta.AV_CH_STEREO_LEFT;
    }

    public s<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, f fVar) throws IOException {
        return this.f10511a.a(parcelFileDescriptor, i2, i3, fVar);
    }

    public boolean a(ParcelFileDescriptor parcelFileDescriptor, f fVar) {
        return a(parcelFileDescriptor) && this.f10511a.a(parcelFileDescriptor);
    }
}
