package kk;

import android.widget.ImageView;
import ci.a;
import com.bumptech.glide.c;
import com.bumptech.glide.request.h;
import com.cfly.uav_pro.R;
import com.xeagle.android.newUI.beans.b;
import com.xeagle.android.newUI.widgets.roundedimageview.RoundedImageView;
import java.util.List;

public class i extends a<b, ci.b> {
    public i(int i2, List<b> list) {
        super(i2, list);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(ci.b bVar, b bVar2) {
        bVar.a((int) R.id.tv_device_name, (CharSequence) bVar2.e());
        bVar.a((int) R.id.tv_duration, (CharSequence) bVar2.d());
        RoundedImageView roundedImageView = (RoundedImageView) bVar.itemView.findViewById(R.id.iv_school_instruction);
        if (bVar2.c() != null) {
            c.b(this.mContext).b((h) ((h) ((h) ((h) new h().a(com.bumptech.glide.load.engine.h.f10301a)).i()).a((int) R.drawable.newui_instruction_pic)).b((int) R.drawable.newui_instruction_pic)).j().a(bVar2.c()).a((ImageView) roundedImageView);
        }
    }
}
