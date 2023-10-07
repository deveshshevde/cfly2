package kk;

import ci.a;
import com.cfly.uav_pro.R;
import com.flypro.core.database.ListenerInfoBeans;
import java.util.List;

public class b extends a<ListenerInfoBeans, ci.b> {
    public b(int i2, List<ListenerInfoBeans> list) {
        super(i2, list);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(ci.b bVar, ListenerInfoBeans listenerInfoBeans) {
        int i2;
        int i3;
        String str;
        if (listenerInfoBeans.getFlying_off().contains(":")) {
            bVar.a((int) R.id.tv_fly_date, (CharSequence) listenerInfoBeans.getFlying_off().substring(0, 10));
            str = listenerInfoBeans.getFlying_off();
            i3 = 11;
            i2 = 19;
        } else {
            bVar.a((int) R.id.tv_fly_date, (CharSequence) listenerInfoBeans.getFlying_off().substring(0, 8));
            str = listenerInfoBeans.getFlying_off();
            i3 = 9;
            i2 = 15;
        }
        bVar.a((int) R.id.tv_fly_time, (CharSequence) str.substring(i3, i2));
        if (listenerInfoBeans.isUpload()) {
            bVar.b((int) R.id.iv_not_upload, false);
        } else {
            bVar.b((int) R.id.iv_not_upload, true);
        }
        bVar.a((int) R.id.tv_fly_mileage, (CharSequence) listenerInfoBeans.getMileage() + "m");
        bVar.a((int) R.id.tv_fly_duration, (CharSequence) listenerInfoBeans.getFly_total_time() + "s");
    }
}
