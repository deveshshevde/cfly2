package com.xeagle.android.login.listener;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.flypro.core.drone.variables.ListenerData;
import com.xeagle.android.fragments.e;
import com.xeagle.android.login.event.ListenerIndexEvent;
import com.xeagle.android.utils.prefs.AutoPanMode;
import fg.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kh.a;
import kh.b;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class ListenerMapFragment extends e {
    /* access modifiers changed from: private */
    public static final String TAG = "ListenerMapFragment";
    private static final int UPDATE_LISTENER_DATA = 1;
    /* access modifiers changed from: private */
    public Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ListenerMapFragment.this.updateHomePosition();
                String access$000 = ListenerMapFragment.TAG;
                Log.i(access$000, "updateDroneLeashPath: =======3333====" + ListenerMapFragment.this.pathSource.getPathPoints().size());
                ListenerMapFragment.this.mMapFragment.a((a.e) ListenerMapFragment.this.pathSource);
            }
            return true;
        }
    });
    private ArrayList<ListenerData> listenerDatas;
    private ListenerDrone listenerDrone;
    private ListenerHome listenerHome;
    /* access modifiers changed from: private */
    public ListenerPathSource pathSource;

    public void clearFlightPath() {
        Log.i("TAG", "clearFlightPath: 11111111111111111111");
        this.mMapFragment.a();
    }

    /* access modifiers changed from: protected */
    public boolean isMissionDraggable() {
        return false;
    }

    @l(a = ThreadMode.MAIN)
    public void listenerIndexEvent(ListenerIndexEvent listenerIndexEvent) {
        this.mMapFragment.a(this.listenerDatas.get(listenerIndexEvent.getIndex()).h());
        if (!this.listenerDatas.get(listenerIndexEvent.getIndex()).R().equals("-")) {
            this.listenerDrone.setSnippet(this.listenerDatas.get(listenerIndexEvent.getIndex()).R());
            this.listenerDrone.setSnippet("-");
        }
        updateLastDronePosition(this.listenerDatas.get(listenerIndexEvent.getIndex()));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.listenerDatas = new ArrayList<>();
        this.listenerDrone = new ListenerDrone();
        return onCreateView;
    }

    public void onStart() {
        super.onStart();
    }

    public boolean setAutoPanMode(AutoPanMode autoPanMode) {
        return false;
    }

    public void updateDroneLeashPath() {
        this.mMapFragment.b((a.e) this.pathSource);
    }

    public void updateFirstFlight() {
        this.mMapFragment.a(this.listenerDatas.get(0).h());
    }

    public void updateFlightPath(boolean z2, int i2) {
        if (z2) {
            Iterator<ListenerData> it2 = this.listenerDatas.iterator();
            while (it2.hasNext()) {
                this.mMapFragment.a(it2.next().h());
                try {
                    Thread.sleep((long) (120 / i2));
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void updateHomePosition() {
        ArrayList<ListenerData> arrayList = this.listenerDatas;
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            while (i2 < this.listenerDatas.size()) {
                if (this.listenerDatas.get(i2).h().d() == i.f27244a || this.listenerDatas.get(i2).h().c() == i.f27244a) {
                    i2++;
                } else {
                    this.listenerHome.setHomePosition(this.listenerDatas.get(i2).h());
                    this.mMapFragment.a((b) this.listenerHome);
                    this.mMapFragment.a(this.listenerDatas.get(i2).h(), 18.0f);
                    SystemClock.sleep(800);
                    this.mMapFragment.a(this.listenerDatas.get(i2).h(), 18.0f);
                    return;
                }
            }
        }
    }

    public void updateLastDronePosition(ListenerData listenerData) {
        this.listenerDrone.updateListenerData(listenerData);
        this.mMapFragment.a((b) this.listenerDrone);
    }

    public void updateListenerDatas(ArrayList<ListenerData> arrayList) {
        this.listenerDatas = arrayList;
        this.pathSource = new ListenerPathSource(arrayList);
        this.listenerHome = new ListenerHome(arrayList.get(0).h());
        this.handler.postDelayed(new Runnable() {
            public void run() {
                ListenerMapFragment.this.handler.sendEmptyMessage(1);
            }
        }, 800);
    }

    public void zoomToFit() {
        zoomToFit(this.pathSource.getPathPoints());
    }

    public void zoomToFit(List<ef.a> list) {
        if (!list.isEmpty()) {
            this.mMapFragment.c(list);
        }
    }
}
