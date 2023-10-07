package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

final class bh implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bi f17812a;

    /* synthetic */ bh(bi biVar, bg bgVar) {
        this.f17812a = biVar;
    }

    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            synchronized (this.f17812a.f17813b) {
                be beVar = (be) message.obj;
                bf bfVar = (bf) this.f17812a.f17813b.get(beVar);
                if (bfVar != null && bfVar.d()) {
                    if (bfVar.e()) {
                        bfVar.a("GmsClientSupervisor");
                    }
                    this.f17812a.f17813b.remove(beVar);
                }
            }
            return true;
        } else if (i2 != 1) {
            return false;
        } else {
            synchronized (this.f17812a.f17813b) {
                be beVar2 = (be) message.obj;
                bf bfVar2 = (bf) this.f17812a.f17813b.get(beVar2);
                if (bfVar2 != null && bfVar2.a() == 3) {
                    String valueOf = String.valueOf(beVar2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName b2 = bfVar2.b();
                    if (b2 == null) {
                        b2 = beVar2.b();
                    }
                    if (b2 == null) {
                        String c2 = beVar2.c();
                        m.a(c2);
                        b2 = new ComponentName(c2, IjkMediaMeta.IJKM_VAL_TYPE__UNKNOWN);
                    }
                    bfVar2.onServiceDisconnected(b2);
                }
            }
            return true;
        }
    }
}
