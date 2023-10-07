package com.xeagle.android.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.xeagle.android.activities.FlightActionActivity;
import com.xeagle.android.newUI.activity.BaseActivity;
import com.xeagle.android.utils.prefs.AutoPanMode;
import em.d;
import java.util.List;
import jo.be;
import jo.u;
import jo.x;
import kh.a;
import kh.b;
import kr.c;

public class EditorMapFragment extends e implements a.C0209a, a.b, a.c, a.d {

    /* renamed from: a  reason: collision with root package name */
    private BaseActivity f23179a;

    private void e(b bVar) {
        if (d.class.isInstance(bVar)) {
            ((d) bVar).a(bVar.getPosition());
            this.mMapFragment.b((a.e) this.missionProxy);
        }
    }

    private void f(b bVar) {
        if (bVar instanceof c) {
            this.missionProxy.a(((c) bVar).c(), bVar.getPosition());
        } else if (bVar instanceof kr.d) {
            kr.d dVar = (kr.d) bVar;
            this.missionProxy.a(dVar.a(), dVar.b(), bVar.getPosition());
        }
    }

    public void a() {
        List<ef.a> g2 = this.missionProxy.g();
        ef.a c2 = this.drone.q().c();
        if (c2 != null && !c2.e()) {
            g2.add(c2);
        }
        a(g2);
    }

    public void a(ef.a aVar) {
    }

    public void a(ef.a aVar, boolean z2) {
        if (z2) {
            org.greenrobot.eventbus.c.a().d(new x(aVar));
        }
        if (((FlightActionActivity) this.f23179a).f()) {
            Log.i("Map", "switch map ic active!");
            org.greenrobot.eventbus.c.a().d(new be(true));
        }
    }

    public void a(List<ef.a> list) {
        if (!list.isEmpty()) {
            this.mMapFragment.c(list);
        }
    }

    public void a(b bVar) {
        e(bVar);
    }

    public void b(b bVar) {
        e(bVar);
    }

    public void c(b bVar) {
        f(bVar);
    }

    public boolean d(b bVar) {
        if (((FlightActionActivity) this.f23179a).f()) {
            org.greenrobot.eventbus.c.a().d(new be(true));
        }
        if (!(bVar instanceof c)) {
            return false;
        }
        org.greenrobot.eventbus.c.a().d(new u(((c) bVar).c(), false));
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isMissionDraggable() {
        return true;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f23179a = (BaseActivity) activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.mMapFragment.a((a.d) this);
        this.mMapFragment.a((a.c) this);
        this.mMapFragment.a((a.C0209a) this);
        this.mMapFragment.a((a.b) this);
        return onCreateView;
    }

    public void onStart() {
        super.onStart();
        a();
    }

    public boolean setAutoPanMode(AutoPanMode autoPanMode) {
        if (autoPanMode == AutoPanMode.DISABLED) {
            return true;
        }
        Toast.makeText(getActivity(), "Auto pan is not supported on this map.", 1).show();
        return false;
    }
}
