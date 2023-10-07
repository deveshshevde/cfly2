package com.xeagle.android.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import androidx.fragment.app.Fragment;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.activities.helpers.SuperUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lg.a;
import lg.c;
import lg.d;
import li.b;

public class b extends Fragment implements DroneInterfaces.c, a.C0217a, b.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f23251a;

    /* renamed from: b  reason: collision with root package name */
    private en.a f23252b;

    /* renamed from: c  reason: collision with root package name */
    private ExpandableListView f23253c;

    /* renamed from: d  reason: collision with root package name */
    private List<String> f23254d;

    /* renamed from: e  reason: collision with root package name */
    private List<lg.b> f23255e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<String, List<lg.b>> f23256f;

    /* renamed from: g  reason: collision with root package name */
    private a f23257g;

    /* renamed from: h  reason: collision with root package name */
    private c f23258h;

    private void a(boolean z2, boolean z3) {
        for (int i2 = 0; i2 < this.f23254d.size(); i2++) {
            boolean a2 = this.f23257g.a(i2);
            if (!a2 && z2) {
                this.f23253c.expandGroup(i2);
            } else if (a2 && z3) {
                this.f23253c.collapseGroup(i2);
            }
        }
    }

    private void c() {
        d dVar = new d("checklist_ext.xml", this.f23251a, R.xml.checklist_default);
        dVar.a((b.a) this);
        this.f23254d = dVar.a();
        this.f23255e = dVar.b();
    }

    private void d() {
        this.f23256f = new HashMap<>();
        for (int i2 = 0; i2 < this.f23254d.size(); i2++) {
            ArrayList arrayList = new ArrayList();
            for (lg.b next : this.f23255e) {
                if (next.k() == i2) {
                    arrayList.add(next);
                }
            }
            this.f23256f.put(this.f23254d.get(i2), arrayList);
        }
    }

    private void e() {
        a aVar = new a((LayoutInflater) this.f23251a.getSystemService("layout_inflater"), this.f23254d, this.f23256f);
        this.f23257g = aVar;
        aVar.b(R.layout.list_group_header);
        this.f23257g.a((a.C0217a) this);
    }

    public void a() {
        for (lg.b next : this.f23255e) {
            if (next.c() != null) {
                this.f23258h.a(next, next.c());
            }
        }
        a aVar = this.f23257g;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void a(lg.b bVar) {
        this.f23258h.a(bVar);
        this.f23257g.notifyDataSetChanged();
        a(false, true);
    }

    public void a(lg.b bVar, String str) {
        this.f23258h.a(bVar, str);
    }

    public void b() {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f23251a = activity;
        c();
        d();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_checklist, viewGroup, false);
        this.f23253c = (ExpandableListView) inflate.findViewById(R.id.expListView);
        e();
        this.f23253c.setAdapter(this.f23257g);
        a(true, true);
        return inflate;
    }

    public void onDetach() {
        this.f23258h = null;
        this.f23257g = null;
        this.f23254d = null;
        this.f23256f = null;
        this.f23255e = null;
        super.onDetach();
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        a();
    }

    public void onStart() {
        super.onStart();
        en.a aVar = ((SuperUI) this.f23251a).f12358g;
        this.f23252b = aVar;
        this.f23258h = new c(aVar);
        this.f23252b.a((DroneInterfaces.c) this);
    }

    public void onStop() {
        super.onStop();
        this.f23252b.b((DroneInterfaces.c) this);
    }
}
