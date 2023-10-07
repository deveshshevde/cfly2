package com.xeagle.android.login.event;

import com.flypro.core.drone.variables.ListenerData;
import java.util.ArrayList;

public class ListenerDatasEvent {
    private ArrayList<ListenerData> datas;

    public ListenerDatasEvent(ArrayList<ListenerData> arrayList) {
        this.datas = arrayList;
    }

    public ArrayList<ListenerData> getDatas() {
        return this.datas;
    }
}
