package com.xeagle.android.login.gsy.recycleView.adapter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import ci.a;
import ci.b;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.gsy.recycleView.ToolUtil;
import com.xeagle.android.vjoystick.utils.c;
import java.io.File;
import java.util.Objects;
import kotlin.jvm.internal.h;
import kotlin.text.f;
import kx.d;

public final class SdPhotoAdapter extends a<lc.a, b> {
    private TextView photo_info;
    private int position;

    public SdPhotoAdapter() {
        super((int) R.layout.list_photo_item);
    }

    /* access modifiers changed from: protected */
    public void convert(b bVar, lc.a aVar) {
        h.d(bVar, "helper");
        h.d(aVar, "photoModel");
        this.position = bVar.getAdapterPosition();
        View c2 = bVar.c(R.id.photo_info);
        h.b(c2, "helper.getView<TextView>(R.id.photo_info)");
        this.photo_info = (TextView) c2;
        ImageView imageView = (ImageView) bVar.c(R.id.list_item_photo);
        bVar.a((int) R.id.photo_download);
        bVar.a((int) R.id.photo_delete);
        Log.i("LOOK_LOG", "convert: " + aVar.c());
        boolean z2 = true;
        bVar.a((int) R.id.photo_download, f.a((CharSequence) aVar.c(), (CharSequence) "JPG", false, 2, (Object) null) || f.a((CharSequence) aVar.c(), (CharSequence) "MP4", false, 2, (Object) null));
        if (!f.a((CharSequence) aVar.c(), (CharSequence) "JPG", false, 2, (Object) null) && !f.a((CharSequence) aVar.c(), (CharSequence) "MP4", false, 2, (Object) null)) {
            z2 = false;
        }
        bVar.a((int) R.id.photo_delete, z2);
        c.a().a(this.mContext, new File(d.s(this.mContext) + "/" + ToolUtil.getInstance().getAmbaPath(aVar.c())).getAbsolutePath(), imageView, 0, 0, true);
        if (f.a((CharSequence) aVar.c(), (CharSequence) "/20", false, 2, (Object) null)) {
            int b2 = f.b((CharSequence) aVar.c(), "/20", 0, false, 6, (Object) null);
            TextView textView = this.photo_info;
            if (textView == null) {
                h.b("photo_info");
            }
            String c3 = aVar.c();
            int length = aVar.c().length();
            Objects.requireNonNull(c3, "null cannot be cast to non-null type java.lang.String");
            String substring = c3.substring(b2, length);
            h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            textView.setText(substring);
            return;
        }
        TextView textView2 = this.photo_info;
        if (textView2 == null) {
            h.b("photo_info");
        }
        textView2.setText(aVar.c());
    }
}
