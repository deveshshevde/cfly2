package com.xeagle.android.login.fragment;

import android.view.View;
import android.widget.TextView;
import com.xeagle.R;
import com.xeagle.android.XEagleApp;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.l;
import kotlin.text.f;
import lv.d;

final class DeviceFragment$initView$1<T> implements d<Long> {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$initView$1(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public final void accept(Long l2) {
        XEagleApp access$getXEagleApp$p = this.this$0.xEagleApp;
        h.a((Object) access$getXEagleApp$p);
        if (access$getXEagleApp$p.e().i() && DeviceFragment.access$getPrefs$p(this.this$0).j() != null) {
            View access$getMLayoutView$p = this.this$0.mLayoutView;
            TextView textView = access$getMLayoutView$p != null ? (TextView) access$getMLayoutView$p.findViewById(R.id.tv_device_name) : null;
            h.a((Object) textView);
            l lVar = l.f30252a;
            Locale locale = Locale.US;
            String j2 = DeviceFragment.access$getPrefs$p(this.this$0).j();
            h.b(j2, "prefs.droneType");
            String format = String.format(locale, "DF%s", Arrays.copyOf(new Object[]{f.a(j2, "-", "", false, 4, (Object) null)}, 1));
            h.b(format, "java.lang.String.format(locale, format, *args)");
            textView.setText(format);
        }
    }
}
