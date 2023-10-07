package hn;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import com.huantansheng.easyphotos.models.sticker.entity.TextStickerData;
import com.huantansheng.easyphotos.models.sticker.view.BitmapSticker;
import com.huantansheng.easyphotos.models.sticker.view.TextSticker;
import hv.b;
import java.util.ArrayList;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final ArrayList<TextStickerData> f13368a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public List<BitmapSticker> f13369b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<TextSticker> f13370c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public BitmapSticker f13371d;

    /* renamed from: e  reason: collision with root package name */
    public TextSticker f13372e;

    public void a(Activity activity, ViewGroup viewGroup, View view, int i2, int i3, String str, String str2, boolean z2, b bVar) {
        Bitmap bitmap;
        BitmapSticker bitmapSticker = this.f13371d;
        if (bitmapSticker != null && bitmapSticker.a()) {
            this.f13371d.setUsing(false);
        }
        TextSticker textSticker = this.f13372e;
        if (textSticker != null && textSticker.b()) {
            this.f13372e.setUsing(false);
        }
        for (BitmapSticker next : this.f13369b) {
            if (next.a()) {
                next.setUsing(false);
            }
        }
        for (TextSticker next2 : this.f13370c) {
            if (next2.b()) {
                next2.setUsing(false);
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(viewGroup.getWidth(), viewGroup.getHeight(), Bitmap.Config.ARGB_8888);
        viewGroup.draw(new Canvas(createBitmap));
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, view.getLeft(), view.getTop(), view.getWidth(), view.getHeight());
        hv.a.a(createBitmap);
        if (view.getWidth() > i2 || view.getHeight() > i3) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap2, i2, i3, true);
            hv.a.a(createBitmap2);
            bitmap = createScaledBitmap;
        } else {
            bitmap = createBitmap2;
        }
        com.huantansheng.easyphotos.a.a(activity, str, str2, bitmap, z2, bVar);
    }

    public void a(Context context, final FragmentManager fragmentManager, String str, ViewGroup viewGroup) {
        if (this.f13370c.size() > 0) {
            List<TextSticker> list = this.f13370c;
            if (!list.get(list.size() - 1).f20489a) {
                List<TextSticker> list2 = this.f13370c;
                list2.get(list2.size() - 1).a();
            }
        }
        final TextSticker textSticker = new TextSticker(context, str, viewGroup.getWidth() / 2, viewGroup.getHeight() / 2);
        textSticker.setOnStickerClickListener(new ho.a() {
            public void a() {
                a.this.f13370c.remove(textSticker);
            }

            public void b() {
                com.huantansheng.easyphotos.models.sticker.view.a.a(fragmentManager, textSticker);
            }

            public void c() {
                a.this.f13370c.remove(textSticker);
                a.this.f13370c.add(textSticker);
            }

            public void d() {
                if (a.this.f13372e != null && a.this.f13372e != textSticker) {
                    a.this.f13372e.setUsing(false);
                    a.this.f13372e = textSticker;
                }
            }
        });
        BitmapSticker bitmapSticker = this.f13371d;
        if (bitmapSticker != null) {
            bitmapSticker.setUsing(false);
        }
        viewGroup.addView(textSticker);
        this.f13372e = textSticker;
        this.f13370c.add(textSticker);
    }
}
