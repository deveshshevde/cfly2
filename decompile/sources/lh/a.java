package lh;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.xeagle.android.widgets.checklist.row.d;
import java.util.HashMap;
import java.util.List;

public abstract class a extends BaseExpandableListAdapter {

    /* renamed from: a  reason: collision with root package name */
    protected LayoutInflater f30841a;

    /* renamed from: b  reason: collision with root package name */
    protected List<String> f30842b;

    /* renamed from: c  reason: collision with root package name */
    protected HashMap<String, List<d>> f30843c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    protected int f30844d;

    public a(LayoutInflater layoutInflater, List<String> list) {
        this.f30841a = layoutInflater;
        this.f30842b = list;
    }

    public void a(TextView textView, int i2) {
    }

    public void b(int i2) {
        this.f30844d = i2;
    }

    public Object getChild(int i2, int i3) {
        return this.f30843c.get(this.f30842b.get(i2)).get(i3);
    }

    public long getChildId(int i2, int i3) {
        return (long) i3;
    }

    public int getChildType(int i2, int i3) {
        return ((d) getChild(i2, i3)).c();
    }

    public int getChildTypeCount() {
        return 0;
    }

    public View getChildView(int i2, int i3, boolean z2, View view, ViewGroup viewGroup) {
        return ((d) getChild(i2, i3)).a(view);
    }

    public int getChildrenCount(int i2) {
        return this.f30843c.get(this.f30842b.get(i2)).size();
    }

    public Object getGroup(int i2) {
        return this.f30842b.get(i2);
    }

    public int getGroupCount() {
        return this.f30842b.size();
    }

    public long getGroupId(int i2) {
        return (long) i2;
    }

    public View getGroupView(int i2, boolean z2, View view, ViewGroup viewGroup) {
        String str = (String) getGroup(i2);
        if (view == null) {
            view = this.f30841a.inflate(this.f30844d, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.lblListHeader);
        if (textView != null) {
            textView.setTypeface((Typeface) null, 1);
            textView.setText(str);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.lblChkRatio);
        if (textView2 != null) {
            a(textView2, i2);
        }
        return view;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i2, int i3) {
        return true;
    }
}
