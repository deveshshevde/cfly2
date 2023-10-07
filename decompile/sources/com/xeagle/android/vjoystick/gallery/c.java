package com.xeagle.android.vjoystick.gallery;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.pickImage.loader.GlideImageLoader;
import java.io.File;
import java.util.List;
import java.util.regex.Pattern;
import kx.d;

public class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<d> f25310a;

    /* renamed from: b  reason: collision with root package name */
    private a f25311b;

    public interface a {
        void a(List<d> list, int i2);

        boolean a();

        void b(List<d> list, int i2);
    }

    private class b {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public ImageView f25313b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public CheckBox f25314c;

        private b() {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, View view) {
        if (this.f25311b == null) {
            return;
        }
        if (((d) view.getTag()).d()) {
            this.f25311b.b(this.f25310a, i2);
        } else {
            this.f25311b.a(this.f25310a, i2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(View view) {
        a aVar = this.f25311b;
        if (aVar == null) {
            return true;
        }
        aVar.a();
        return true;
    }

    public static boolean a(String str, String str2) {
        return Pattern.compile("\\b" + str2 + "\\b").matcher(str).find();
    }

    public void a(a aVar) {
        this.f25311b = aVar;
    }

    public void a(List<d> list) {
        this.f25310a = list;
    }

    public int getCount() {
        List<d> list = this.f25310a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Object getItem(int i2) {
        return this.f25310a.get(i2);
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        View view2;
        Context context = viewGroup.getContext();
        int i3 = 0;
        String str = null;
        if (view == null) {
            bVar = new b();
            View inflate = LayoutInflater.from(context).inflate(R.layout.select_grid_item, (ViewGroup) null, false);
            ImageView unused = bVar.f25313b = (ImageView) inflate.findViewById(R.id.thumbImage);
            CheckBox unused2 = bVar.f25314c = (CheckBox) inflate.findViewById(R.id.mul_check);
            bVar.f25314c.setOnCheckedChangeListener($$Lambda$c$LuGjJDuDmXu_krwX3sIMjeuw5Fw.INSTANCE);
            bVar.f25313b.setOnClickListener(new View.OnClickListener(i2) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    c.this.a(this.f$1, view);
                }
            });
            bVar.f25313b.setOnLongClickListener(new View.OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    return c.this.a(view);
                }
            });
            inflate.setTag(bVar);
            view2 = inflate;
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        d dVar = this.f25310a.get(i2);
        bVar.f25314c.setTag(dVar);
        bVar.f25313b.setTag(dVar);
        String a2 = dVar.a();
        if (a(a2, "jpg")) {
            if (Build.VERSION.SDK_INT >= 21) {
                bVar.f25313b.setTransitionName("img" + i2);
            }
            GlideImageLoader.displayAlbumThumb(bVar.f25313b, a2, R.drawable.ic_launcher);
            dVar.c(false);
        } else if (a(a2, "mp4")) {
            if (a2.contains("mp4")) {
                str = "file://" + a2.replace(".mp4", ".jpg");
            }
            if (new File(d.p(context) + com.flypro.core.util.d.b(str)).exists()) {
                com.xeagle.android.vjoystick.utils.c.a().a(context, d.p(context) + com.flypro.core.util.d.b(str), bVar.f25313b, R.drawable.ic_launcher, R.drawable.ic_launcher);
            } else {
                GlideImageLoader.displayVideo(bVar.f25313b, a2);
            }
            dVar.c(true);
        }
        CheckBox a3 = bVar.f25314c;
        if (!dVar.c()) {
            i3 = 8;
        }
        a3.setVisibility(i3);
        if (dVar.c()) {
            bVar.f25314c.setChecked(dVar.b());
        }
        return view2;
    }
}
