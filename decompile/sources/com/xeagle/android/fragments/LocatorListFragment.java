package com.xeagle.android.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.fragment.app.Fragment;
import com.MAVLink.common.msg_global_position_int;
import com.cfly.uav_pro.R;
import com.xeagle.android.activities.LocatorActivity;
import com.xeagle.android.widgets.adapterViews.b;
import it.sephiroth.android.library.widget.AdapterView;
import it.sephiroth.android.library.widget.HListView;

public class LocatorListFragment extends Fragment implements AdapterView.c {

    /* renamed from: a  reason: collision with root package name */
    private HListView f23238a;

    /* renamed from: b  reason: collision with root package name */
    private b f23239b;

    /* renamed from: c  reason: collision with root package name */
    private a f23240c;

    public interface a {
        void a(msg_global_position_int msg_global_position_int);
    }

    public void a() {
        View view = getView();
        b bVar = this.f23239b;
        if (bVar != null && view != null) {
            view.setVisibility(bVar.getCount() > 0 ? 0 : 4);
        }
    }

    public void a(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f23240c.a((msg_global_position_int) adapterView.f(i2));
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f23240c = (a) activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_locator_list, viewGroup, false);
        LocatorActivity locatorActivity = (LocatorActivity) getActivity();
        this.f23239b = new b(locatorActivity, locatorActivity.b());
        HListView hListView = (HListView) inflate.findViewById(R.id.locator_item_list);
        this.f23238a = hListView;
        hListView.setOnItemClickListener(this);
        this.f23238a.setChoiceMode(1);
        this.f23238a.setAdapter((ListAdapter) this.f23239b);
        return inflate;
    }

    public void onStart() {
        super.onStart();
        a();
    }
}
