package com.xeagle.android.login.event;

import com.xeagle.android.login.beans.O;

public class RcJsonEvent {
    private O O;

    public RcJsonEvent(O o2) {
        this.O = o2;
    }

    public O getBeans() {
        return this.O;
    }
}
