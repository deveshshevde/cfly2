package com.xeagle.android.widgets.CarouselView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f25543a;

    /* renamed from: b  reason: collision with root package name */
    private List<Drawable> f25544b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25545c = true;

    /* renamed from: d  reason: collision with root package name */
    private CarouselItemImage[] f25546d = null;

    public c(Context context, List<Drawable> list, boolean z2) {
        this.f25543a = context;
        this.f25544b = list;
        this.f25545c = z2;
        a();
    }

    public void a() {
        this.f25546d = new CarouselItemImage[this.f25544b.size()];
        for (int i2 = 0; i2 < this.f25544b.size(); i2++) {
            Bitmap bitmap = ((BitmapDrawable) this.f25544b.get(i2)).getBitmap();
            if (this.f25545c) {
                bitmap = a.a(bitmap);
            }
            CarouselItemImage carouselItemImage = new CarouselItemImage(this.f25543a);
            carouselItemImage.setImageBitmap(bitmap);
            carouselItemImage.setIndex(i2);
            this.f25546d[i2] = carouselItemImage;
        }
    }

    public int getCount() {
        List<Drawable> list = this.f25544b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Object getItem(int i2) {
        return Integer.valueOf(i2);
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        return this.f25546d[i2];
    }
}
