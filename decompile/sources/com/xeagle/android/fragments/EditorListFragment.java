package com.xeagle.android.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import androidx.fragment.app.Fragment;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.widgets.adapterViews.c;
import dy.ar;
import it.sephiroth.android.library.widget.AdapterView;
import it.sephiroth.android.library.widget.HListView;
import java.util.List;
import kn.a;
import kn.b;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class EditorListFragment extends Fragment implements View.OnClickListener, DroneInterfaces.c, AdapterView.c, AdapterView.d, b.a {

    /* renamed from: a  reason: collision with root package name */
    private HListView f12499a;

    /* renamed from: b  reason: collision with root package name */
    private a f12500b;

    /* renamed from: c  reason: collision with root package name */
    private c f12501c;

    /* renamed from: d  reason: collision with root package name */
    private jq.a f12502d;

    /* renamed from: e  reason: collision with root package name */
    private ImageButton f12503e;

    /* renamed from: f  reason: collision with root package name */
    private ImageButton f12504f;

    /* renamed from: g  reason: collision with root package name */
    private en.a f12505g;

    public void a() {
        View view = getView();
        c cVar = this.f12501c;
        if (cVar != null && view != null) {
            view.setVisibility(cVar.getCount() > 0 ? 0 : 4);
            this.f12502d.b();
        }
    }

    public void a(int i2) {
        if (i2 == 1 || i2 == 2) {
            this.f12499a.setChoiceMode(i2);
        }
    }

    public void a(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f12502d.a((ko.a) adapterView.f(i2), true);
    }

    public void a(List<ko.a> list) {
        this.f12499a.a();
        for (ko.a position : list) {
            this.f12499a.a(this.f12501c.getPosition(position), true);
        }
        this.f12501c.notifyDataSetChanged();
    }

    public void a(boolean z2) {
        ImageButton imageButton;
        int i2;
        if (z2) {
            imageButton = this.f12503e;
            i2 = 0;
        } else {
            imageButton = this.f12503e;
            i2 = 4;
        }
        imageButton.setVisibility(i2);
        this.f12504f.setVisibility(i2);
    }

    public boolean b(AdapterView<?> adapterView, View view, int i2, long j2) {
        return this.f12502d.a((ko.a) adapterView.f(i2));
    }

    @l(a = ThreadMode.MAIN)
    public void missionUpdateEvent(ar arVar) {
        if (arVar.a() == 20) {
            this.f12501c.notifyDataSetChanged();
            a();
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f12502d = (jq.a) activity;
    }

    public void onClick(View view) {
        if (view == this.f12503e) {
            this.f12500b.a(false);
            this.f12501c.notifyDataSetChanged();
        }
        if (view == this.f12504f) {
            this.f12500b.a(true);
            this.f12501c.notifyDataSetChanged();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_editor_list, viewGroup, false);
        XEagleApp xEagleApp = (XEagleApp) getActivity().getApplication();
        this.f12505g = xEagleApp.k();
        this.f12500b = xEagleApp.o();
        this.f12501c = new c(getActivity(), this.f12500b.b());
        HListView hListView = (HListView) inflate.findViewById(R.id.mission_item_list);
        this.f12499a = hListView;
        hListView.setOnItemClickListener(this);
        this.f12499a.setOnItemLongClickListener(this);
        this.f12499a.setChoiceMode(1);
        this.f12499a.setAdapter((ListAdapter) this.f12501c);
        this.f12503e = (ImageButton) inflate.findViewById(R.id.listLeftArrow);
        this.f12504f = (ImageButton) inflate.findViewById(R.id.listRightArrow);
        this.f12503e.setOnClickListener(this);
        this.f12504f.setOnClickListener(this);
        return inflate;
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        if (droneEventsType == DroneInterfaces.DroneEventsType.MISSION_UPDATE) {
            this.f12501c.notifyDataSetChanged();
            a();
        }
    }

    public void onStart() {
        super.onStart();
        a();
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
        this.f12505g.a((DroneInterfaces.c) this);
        this.f12500b.f13910a.a((b.a) this);
    }

    public void onStop() {
        super.onStop();
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
        this.f12505g.b((DroneInterfaces.c) this);
        this.f12500b.f13910a.b((b.a) this);
    }
}
