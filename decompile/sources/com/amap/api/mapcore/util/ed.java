package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.cfly.uav_pro.R;
import java.util.List;

public final class ed extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    /* renamed from: a  reason: collision with root package name */
    private boolean[] f8440a;

    /* renamed from: b  reason: collision with root package name */
    private int f8441b = -1;

    /* renamed from: c  reason: collision with root package name */
    private List<OfflineMapProvince> f8442c = null;

    /* renamed from: d  reason: collision with root package name */
    private OfflineMapManager f8443d;

    /* renamed from: e  reason: collision with root package name */
    private Context f8444e;

    public final class a {

        /* renamed from: a  reason: collision with root package name */
        public eh f8445a;

        public a() {
        }
    }

    public ed(List<OfflineMapProvince> list, OfflineMapManager offlineMapManager, Context context) {
        this.f8442c = list;
        this.f8443d = offlineMapManager;
        this.f8444e = context;
        this.f8440a = new boolean[list.size()];
    }

    private boolean a(int i2) {
        return (i2 == 0 || i2 == getGroupCount() - 1) ? false : true;
    }

    public final void a() {
        this.f8441b = -1;
        notifyDataSetChanged();
    }

    public final void b() {
        this.f8441b = 0;
        notifyDataSetChanged();
    }

    public final Object getChild(int i2, int i3) {
        return null;
    }

    public final long getChildId(int i2, int i3) {
        return (long) i3;
    }

    public final View getChildView(int i2, int i3, boolean z2, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            aVar = new a();
            eh ehVar = new eh(this.f8444e, this.f8443d);
            ehVar.a(1);
            View a2 = ehVar.a();
            aVar.f8445a = ehVar;
            a2.setTag(aVar);
            view = a2;
        }
        aVar.f8445a.a(this.f8442c.get(i2).getCityList().get(i3));
        return view;
    }

    public final int getChildrenCount(int i2) {
        boolean a2 = a(i2);
        return this.f8442c.get(i2).getCityList().size();
    }

    public final Object getGroup(int i2) {
        return this.f8442c.get(i2).getProvinceName();
    }

    public final int getGroupCount() {
        int i2 = this.f8441b;
        return i2 == -1 ? this.f8442c.size() : i2;
    }

    public final long getGroupId(int i2) {
        return (long) i2;
    }

    public final View getGroupView(int i2, boolean z2, View view, ViewGroup viewGroup) {
        int i3;
        Resources resources;
        if (view == null) {
            view = (RelativeLayout) el.a(this.f8444e, (int) R.array.ExampleCameraArray);
        }
        ImageView imageView = (ImageView) view.findViewById(R.dimen.abc_button_inset_horizontal_material);
        ((TextView) view.findViewById(R.dimen.abc_alert_dialog_button_dimen)).setText(this.f8442c.get(i2).getProvinceName());
        if (this.f8440a[i2]) {
            resources = el.a();
            i3 = R.animator.fragment_fade_enter;
        } else {
            resources = el.a();
            i3 = R.animator.fragment_fade_exit;
        }
        imageView.setImageDrawable(resources.getDrawable(i3));
        return view;
    }

    public final boolean hasStableIds() {
        return true;
    }

    public final boolean isChildSelectable(int i2, int i3) {
        return true;
    }

    public final void onGroupCollapse(int i2) {
        this.f8440a[i2] = false;
    }

    public final void onGroupExpand(int i2) {
        this.f8440a[i2] = true;
    }
}
