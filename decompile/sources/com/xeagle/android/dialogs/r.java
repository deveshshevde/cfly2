package com.xeagle.android.dialogs;

import android.os.Bundle;
import com.xeagle.android.dialogs.c;
import com.xeagle.android.login.common.ip.TipsDialog;
import com.xeagle.android.login.common.ip.WifiConnectDlg;
import com.xeagle.android.newUI.fragment.remindFragment.a;

public class r {

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final r f22730a = new r();
    }

    public static r a() {
        return a.f22730a;
    }

    public c a(String str, String str2, c.a aVar) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, str);
        bundle.putString("extra_unlock_content", str2);
        cVar.setArguments(bundle);
        cVar.f22600b = aVar;
        return cVar;
    }

    public c a(String str, String str2, String str3, c.a aVar) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, str);
        bundle.putString("extra_unlock_content", str3);
        bundle.putString(TipsDialog.EXTRAL_COPY_STR, str2);
        cVar.setArguments(bundle);
        cVar.f22600b = aVar;
        return cVar;
    }

    public m a(String str, String str2) {
        m mVar = new m();
        Bundle bundle = new Bundle();
        bundle.putString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, str);
        bundle.putString("extra_unlock_content", str2);
        mVar.setArguments(bundle);
        return mVar;
    }

    public TipsDialog a(boolean z2, String str, TipsDialog.Listener listener) {
        TipsDialog tipsDialog = new TipsDialog();
        Bundle bundle = new Bundle();
        bundle.putBoolean(TipsDialog.EXTRAL_PREF_KEY, z2);
        bundle.putString("extra_unlock_content", str);
        tipsDialog.setArguments(bundle);
        tipsDialog.listener = listener;
        return tipsDialog;
    }

    public com.xeagle.android.newUI.fragment.remindFragment.a a(a.C0150a aVar) {
        com.xeagle.android.newUI.fragment.remindFragment.a aVar2 = new com.xeagle.android.newUI.fragment.remindFragment.a();
        aVar2.f24031b = aVar;
        return aVar2;
    }
}
