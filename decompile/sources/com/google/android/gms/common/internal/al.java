package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.d;

public final class al extends RemoteCreator<ag> {

    /* renamed from: a  reason: collision with root package name */
    private static final al f17779a = new al();

    private al() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View a(Context context, int i2, int i3) throws RemoteCreator.RemoteCreatorException {
        al alVar = f17779a;
        try {
            zax zax = new zax(1, i2, i3, (Scope[]) null);
            return (View) d.a(((ag) alVar.a(context)).a(d.a(context), zax));
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("Could not get button with size ");
            sb.append(i2);
            sb.append(" and color ");
            sb.append(i3);
            throw new RemoteCreator.RemoteCreatorException(sb.toString(), e2);
        }
    }

    public final /* synthetic */ Object a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return queryLocalInterface instanceof ag ? (ag) queryLocalInterface : new ag(iBinder);
    }
}
