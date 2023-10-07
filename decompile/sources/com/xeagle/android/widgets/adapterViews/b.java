package com.xeagle.android.widgets.adapterViews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.MAVLink.common.msg_global_position_int;
import com.cfly.uav_pro.R;
import java.util.List;

public class b extends ArrayAdapter<msg_global_position_int> {

    /* renamed from: a  reason: collision with root package name */
    private final LayoutInflater f25712a = ((LayoutInflater) getContext().getSystemService("layout_inflater"));

    public b(Context context, List<msg_global_position_int> list) {
        super(context, 0, list);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        msg_global_position_int msg_global_position_int = (msg_global_position_int) getItem(i2);
        if (view == null) {
            view = this.f25712a.inflate(R.layout.fragment_locator_list_item, viewGroup, false);
        }
        ((TextView) view.findViewById(R.id.titleView)).setText(String.valueOf(i2 + 1));
        ((TextView) view.findViewById(R.id.timeView)).setText(String.format("%dm%02d.%01ds", new Object[]{Integer.valueOf(msg_global_position_int.f6644d / 60000), Integer.valueOf((msg_global_position_int.f6644d % 60000) / 1000), Integer.valueOf((msg_global_position_int.f6644d % 1000) / 100)}));
        return view;
    }
}
