package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;

public interface ContainerHolder extends f, g {

    public interface ContainerAvailableListener {
        void onContainerAvailable(ContainerHolder containerHolder, String str);
    }
}
