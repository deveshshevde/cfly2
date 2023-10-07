package kk;

import android.content.res.Resources;
import android.widget.ImageView;
import ci.a;
import ci.b;
import com.cfly.uav_pro.R;
import com.xeagle.android.newUI.beans.OperationItemBean;
import java.util.List;

public class g extends a<OperationItemBean, b> {
    public g(List<OperationItemBean> list) {
        super(R.layout.newui_item_operation_layout, list);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(b bVar, OperationItemBean operationItemBean) {
        Resources resources;
        int i2;
        bVar.a((int) R.id.tv_op, (CharSequence) operationItemBean.b());
        bVar.b((int) R.id.iv_op, operationItemBean.c());
        ((ImageView) bVar.c(R.id.iv_op)).setSelected(operationItemBean.d());
        if (operationItemBean.d()) {
            resources = this.mContext.getResources();
            i2 = R.color.colorAccent_blue;
        } else {
            resources = this.mContext.getResources();
            i2 = R.color.white;
        }
        bVar.c(R.id.tv_op, resources.getColor(i2));
    }
}
