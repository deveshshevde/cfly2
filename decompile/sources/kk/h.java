package kk;

import android.widget.TextView;
import ci.a;
import ci.b;
import com.cfly.uav_pro.R;
import java.util.List;

public class h extends a<String, b> {

    /* renamed from: a  reason: collision with root package name */
    private int f30133a;

    public h(int i2, List<String> list) {
        super(i2, list);
    }

    public void a(int i2) {
        this.f30133a = i2;
        notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(b bVar, String str) {
        float f2;
        TextView textView = (TextView) bVar.c(R.id.tv_wheel);
        bVar.a((int) R.id.tv_wheel, (CharSequence) str);
        if (bVar.getAdapterPosition() == this.f30133a) {
            textView.setTextColor(this.mContext.getResources().getColor(R.color.white));
            f2 = 20.0f;
        } else {
            textView.setTextColor(this.mContext.getResources().getColor(R.color.gray));
            f2 = 14.0f;
        }
        textView.setTextSize(2, f2);
    }
}
