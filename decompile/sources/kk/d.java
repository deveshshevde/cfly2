package kk;

import ci.a;
import ci.b;
import com.cfly.uav_pro.R;
import com.xeagle.android.bean.GuideSelectBean;
import java.util.List;

public class d extends a<GuideSelectBean, b> {
    public d(int i2, List<GuideSelectBean> list) {
        super(i2, list);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(b bVar, GuideSelectBean guideSelectBean) {
        if (guideSelectBean != null) {
            bVar.a((int) R.id.tv_drone_type, (CharSequence) guideSelectBean.getDroneType());
            bVar.b((int) R.id.iv_drone_type, guideSelectBean.getDrawableId());
        }
    }
}
