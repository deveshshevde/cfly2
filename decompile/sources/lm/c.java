package lm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.xeagle.android.widgets.wheelView.common.WheelData;
import com.xeagle.android.widgets.wheelView.widget.WheelItem;

public class c extends b<WheelData> {

    /* renamed from: e  reason: collision with root package name */
    private Context f30947e;

    public View a(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new WheelItem(this.f30947e);
        }
        WheelItem wheelItem = (WheelItem) view;
        wheelItem.setImage(((WheelData) this.f30942a.get(i2)).a());
        wheelItem.setText(((WheelData) this.f30942a.get(i2)).b());
        return view;
    }
}
