package com.xeagle.android.widgets.CarouselView;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.volley.toolbox.h;

public class b implements h.b {

    /* renamed from: a  reason: collision with root package name */
    private LruCache<String, Bitmap> f25541a = new LruCache<String, Bitmap>(10485760) {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    };

    public Bitmap a(String str) {
        return this.f25541a.get(str);
    }

    public void a(String str, Bitmap bitmap) {
        this.f25541a.put(str, bitmap);
    }
}
