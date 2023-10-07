package kk;

import android.widget.ImageView;
import ci.a;
import ci.b;
import com.cfly.uav_pro.R;
import com.flypro.core.database.PdfInfo;
import com.xeagle.android.vjoystick.utils.c;

public class e extends a<PdfInfo, b> {
    public e(int i2) {
        super(i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(b bVar, PdfInfo pdfInfo) {
        bVar.a((int) R.id.tv_device_name, (CharSequence) pdfInfo.getFlag());
        bVar.a((int) R.id.tv_instruction, (CharSequence) pdfInfo.getName());
        bVar.a((int) R.id.download_pb, false);
        c.a().a(this.mContext, pdfInfo.getImage_url(), (ImageView) bVar.c(R.id.iv_school_instruction), R.drawable.newui_instruction_pic, R.drawable.newui_instruction_pic, 15, true);
    }
}
