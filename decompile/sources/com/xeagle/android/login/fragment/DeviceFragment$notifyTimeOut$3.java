package com.xeagle.android.login.fragment;

final class DeviceFragment$notifyTimeOut$3 implements Runnable {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$notifyTimeOut$3(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    /* JADX WARNING: type inference failed for: r0v15, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r0v22, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r12 = this;
            com.xeagle.android.login.fragment.DeviceFragment r0 = r12.this$0
            en.a r0 = r0.drone
            kotlin.jvm.internal.h.a((java.lang.Object) r0)
            java.lang.String r0 = r0.y()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x003b
            com.xeagle.android.login.fragment.DeviceFragment r0 = r12.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x0022
            int r1 = com.xeagle.R.id.tv_device_name
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x0022:
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            java.lang.String r0 = "Drone"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            com.xeagle.android.login.fragment.DeviceFragment r0 = r12.this$0
            com.xeagle.android.utils.prefs.a r0 = com.xeagle.android.login.fragment.DeviceFragment.access$getPrefs$p(r0)
            kotlin.jvm.internal.h.a((java.lang.Object) r0)
            java.lang.String r1 = "808"
            r0.d((java.lang.String) r1)
            goto L_0x0089
        L_0x003b:
            com.xeagle.android.login.fragment.DeviceFragment r0 = r12.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x004c
            int r1 = com.xeagle.R.id.tv_device_name
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x004c:
            kotlin.jvm.internal.h.a((java.lang.Object) r1)
            kotlin.jvm.internal.l r0 = kotlin.jvm.internal.l.f30252a
            java.util.Locale r0 = java.util.Locale.US
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            com.xeagle.android.login.fragment.DeviceFragment r5 = r12.this$0
            com.xeagle.android.utils.prefs.a r5 = com.xeagle.android.login.fragment.DeviceFragment.access$getPrefs$p(r5)
            kotlin.jvm.internal.h.a((java.lang.Object) r5)
            java.lang.String r6 = r5.j()
            java.lang.String r5 = "prefs!!.droneType"
            kotlin.jvm.internal.h.b(r6, r5)
            r9 = 0
            r10 = 4
            r11 = 0
            java.lang.String r7 = "-"
            java.lang.String r8 = ""
            java.lang.String r5 = kotlin.text.f.a((java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (boolean) r9, (int) r10, (java.lang.Object) r11)
            r3[r4] = r5
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r2)
            java.lang.String r4 = "DF%s"
            java.lang.String r0 = java.lang.String.format(r0, r4, r3)
            java.lang.String r3 = "java.lang.String.format(locale, format, *args)"
            kotlin.jvm.internal.h.b(r0, r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
        L_0x0089:
            java.lang.String r0 = "setStatus"
            java.lang.String r1 = "DRONE_CONNECTED: 5"
            hf.d.b(r0, r1)
            com.xeagle.android.login.fragment.DeviceFragment r0 = r12.this$0
            com.xeagle.android.XEagleApp r0 = r0.xEagleApp
            if (r0 == 0) goto L_0x00a5
            boolean r0 = r0.c()
            if (r0 != r2) goto L_0x00a5
            com.xeagle.android.login.fragment.DeviceFragment r0 = r12.this$0
            r1 = 2
            r0.timeoutReset(r1)
            goto L_0x00ab
        L_0x00a5:
            com.xeagle.android.login.fragment.DeviceFragment r0 = r12.this$0
            r1 = 3
            r0.setStatus(r2, r1)
        L_0x00ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.fragment.DeviceFragment$notifyTimeOut$3.run():void");
    }
}
