package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import cc.k;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import java.io.IOException;

public class a<DataType> implements g<DataType, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final g<DataType, Bitmap> f10456a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f10457b;

    public a(Resources resources, g<DataType, Bitmap> gVar) {
        this.f10457b = (Resources) k.a(resources);
        this.f10456a = (g) k.a(gVar);
    }

    public s<BitmapDrawable> a(DataType datatype, int i2, int i3, f fVar) throws IOException {
        return s.a(this.f10457b, this.f10456a.a(datatype, i2, i3, fVar));
    }

    public boolean a(DataType datatype, f fVar) throws IOException {
        return this.f10456a.a(datatype, fVar);
    }
}
