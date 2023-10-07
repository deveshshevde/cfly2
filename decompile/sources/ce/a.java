package ce;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import ci.b;
import com.cfly.customeui.R;
import java.util.List;

public class a extends ci.a<cf.a, b> {

    /* renamed from: a  reason: collision with root package name */
    private Context f6204a;

    public a(Context context, int i2, List<cf.a> list) {
        super(i2, list);
        this.f6204a = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(b bVar, cf.a aVar) {
        Resources resources;
        View view;
        int i2;
        if (aVar != null) {
            bVar.a(R.id.cl_item);
            bVar.a(R.id.main_text, (CharSequence) aVar.b());
            if (aVar.a()) {
                bVar.c(R.id.main_text, this.f6204a.getResources().getColor(R.color.white));
                bVar.b(R.id.sub_text, true);
                view = bVar.itemView;
                resources = this.f6204a.getResources();
                i2 = R.drawable.bt_corner_blue;
            } else {
                bVar.c(R.id.main_text, this.f6204a.getResources().getColor(R.color.black));
                bVar.a(R.id.sub_text, true);
                view = bVar.itemView;
                resources = this.f6204a.getResources();
                i2 = R.drawable.bt_corner_white;
            }
            view.setBackground(resources.getDrawable(i2));
        }
    }
}
