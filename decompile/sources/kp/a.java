package kp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.flypro.core.mission.MissionItemType;

public class a extends ArrayAdapter<MissionItemType> {
    public a(Context context, int i2, MissionItemType[] missionItemTypeArr) {
        super(context, i2, missionItemTypeArr);
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        return getView(i2, view, viewGroup);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i2, view, viewGroup);
        ((TextView) view2).setText(((MissionItemType) getItem(i2)).a());
        return view2;
    }
}
