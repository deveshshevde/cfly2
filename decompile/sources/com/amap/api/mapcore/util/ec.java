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
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.cfly.uav_pro.R;
import java.util.ArrayList;
import java.util.List;

public final class ec extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    /* renamed from: a  reason: collision with root package name */
    List<OfflineMapProvince> f8429a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private boolean[] f8430b;

    /* renamed from: c  reason: collision with root package name */
    private Context f8431c;

    /* renamed from: d  reason: collision with root package name */
    private eh f8432d;

    /* renamed from: e  reason: collision with root package name */
    private List<OfflineMapProvince> f8433e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ej f8434f;

    /* renamed from: g  reason: collision with root package name */
    private OfflineMapManager f8435g;

    public final class a {

        /* renamed from: a  reason: collision with root package name */
        public eh f8438a;

        public a() {
        }
    }

    public ec(Context context, ej ejVar, OfflineMapManager offlineMapManager, List<OfflineMapProvince> list) {
        this.f8431c = context;
        this.f8434f = ejVar;
        this.f8435g = offlineMapManager;
        if (list != null && list.size() > 0) {
            this.f8433e.clear();
            this.f8433e.addAll(list);
            for (OfflineMapProvince next : this.f8433e) {
                if (next != null && next.getDownloadedCityList().size() > 0) {
                    this.f8429a.add(next);
                }
            }
        }
        this.f8430b = new boolean[this.f8429a.size()];
    }

    public final void a() {
        for (OfflineMapProvince next : this.f8433e) {
            if (next.getDownloadedCityList().size() > 0 && !this.f8429a.contains(next)) {
                this.f8429a.add(next);
            }
        }
        this.f8430b = new boolean[this.f8429a.size()];
        notifyDataSetChanged();
    }

    public final void b() {
        try {
            for (int size = this.f8429a.size(); size > 0; size--) {
                OfflineMapProvince offlineMapProvince = this.f8429a.get(size - 1);
                if (offlineMapProvince.getDownloadedCityList().size() == 0) {
                    this.f8429a.remove(offlineMapProvince);
                }
            }
            this.f8430b = new boolean[this.f8429a.size()];
            notifyDataSetChanged();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final Object getChild(int i2, int i3) {
        return this.f8429a.get(i2).getDownloadedCityList().get(i3);
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
            eh ehVar = new eh(this.f8431c, this.f8435g);
            this.f8432d = ehVar;
            ehVar.a(2);
            view = this.f8432d.a();
            aVar.f8438a = this.f8432d;
            view.setTag(aVar);
        }
        OfflineMapProvince offlineMapProvince = this.f8429a.get(i2);
        if (i3 < offlineMapProvince.getDownloadedCityList().size()) {
            final OfflineMapCity offlineMapCity = offlineMapProvince.getDownloadedCityList().get(i3);
            aVar.f8438a.a(offlineMapCity);
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    ec.this.f8434f.a(offlineMapCity);
                }
            });
        }
        return view;
    }

    public final int getChildrenCount(int i2) {
        return this.f8429a.get(i2).getDownloadedCityList().size();
    }

    public final Object getGroup(int i2) {
        return this.f8429a.get(i2).getProvinceName();
    }

    public final int getGroupCount() {
        return this.f8429a.size();
    }

    public final long getGroupId(int i2) {
        return (long) i2;
    }

    public final View getGroupView(int i2, boolean z2, View view, ViewGroup viewGroup) {
        int i3;
        Resources resources;
        if (view == null) {
            view = (RelativeLayout) el.a(this.f8431c, (int) R.array.ExampleCameraArray);
        }
        ImageView imageView = (ImageView) view.findViewById(R.dimen.abc_button_inset_horizontal_material);
        ((TextView) view.findViewById(R.dimen.abc_alert_dialog_button_dimen)).setText(this.f8429a.get(i2).getProvinceName());
        if (this.f8430b[i2]) {
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
        return false;
    }

    public final boolean isChildSelectable(int i2, int i3) {
        return true;
    }

    public final void onGroupCollapse(int i2) {
        this.f8430b[i2] = false;
    }

    public final void onGroupExpand(int i2) {
        this.f8430b[i2] = true;
    }
}
