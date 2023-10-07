package kk;

import android.widget.TextView;
import ci.a;
import ci.b;
import com.cfly.uav_pro.R;
import com.xeagle.android.newUI.beans.OperationItemBean;
import java.util.List;

public class f extends a<OperationItemBean, b> {
    public f(List<OperationItemBean> list) {
        super(R.layout.newui_wheel_item_layout, list);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(b bVar, OperationItemBean operationItemBean) {
        float f2;
        TextView textView = (TextView) bVar.c(R.id.tv_wheel);
        bVar.a((int) R.id.tv_wheel, (CharSequence) operationItemBean.a() + "秒");
        if (operationItemBean.d()) {
            textView.setTextColor(this.mContext.getResources().getColor(R.color.white));
            f2 = 20.0f;
        } else {
            textView.setTextColor(this.mContext.getResources().getColor(R.color.gray));
            f2 = 14.0f;
        }
        textView.setTextSize(2, f2);
    }
}
