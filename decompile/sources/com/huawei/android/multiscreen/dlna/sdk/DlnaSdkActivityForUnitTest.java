package com.huawei.android.multiscreen.dlna.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class DlnaSdkActivityForUnitTest extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private static Context f20662a;

    public DlnaSdkActivityForUnitTest() {
        a(this);
    }

    public static void a(Context context) {
        f20662a = context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
