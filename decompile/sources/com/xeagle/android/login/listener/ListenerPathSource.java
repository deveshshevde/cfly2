package com.xeagle.android.login.listener;

import com.flypro.core.drone.variables.ListenerData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kh.a;

public class ListenerPathSource implements a.e {
    private ArrayList<ListenerData> listenerDatas;

    public ListenerPathSource(ArrayList<ListenerData> arrayList) {
        this.listenerDatas = arrayList;
    }

    public List<ef.a> getPathPoints() {
        ArrayList arrayList = new ArrayList();
        Iterator<ListenerData> it2 = this.listenerDatas.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().h());
        }
        return arrayList;
    }
}
