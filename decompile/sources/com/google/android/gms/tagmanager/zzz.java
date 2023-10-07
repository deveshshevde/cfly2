package com.google.android.gms.tagmanager;

import android.os.Message;
import com.google.android.gms.internal.gtm.zzga;
import com.google.android.gms.tagmanager.ContainerHolder;

final class zzz extends zzga {
    final /* synthetic */ zzaa zza;
    private final ContainerHolder.ContainerAvailableListener zzb;

    public final void handleMessage(Message message) {
        if (message.what != 1) {
            zzdh.zza("Don't know how to handle this message.");
            return;
        }
        this.zzb.onContainerAvailable(this.zza, (String) message.obj);
    }
}
