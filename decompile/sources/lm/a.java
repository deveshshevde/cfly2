package lm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.xeagle.android.widgets.wheelView.widget.WheelItem;

public class a<T> extends b<T> {

    /* renamed from: e  reason: collision with root package name */
    private Context f30941e;

    public a(Context context) {
        this.f30941e = context;
    }

    public View a(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new WheelItem(this.f30941e);
        }
        WheelItem wheelItem = (WheelItem) view;
        Object item = getItem(i2);
        wheelItem.setText(wheelItem instanceof CharSequence ? (CharSequence) item : item.toString());
        return view;
    }
}
