package com.xeagle.android.login.fragment;

final class DeviceFragment$setStatus$1 implements Runnable {
    final /* synthetic */ int $status;
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$setStatus$1(DeviceFragment deviceFragment, int i2) {
        this.this$0 = deviceFragment;
        this.$status = i2;
    }

    /* JADX WARNING: type inference failed for: r0v22, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r0v59, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r0v142, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0236  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            int r0 = r10.$status
            r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r2 = 2131232042(0x7f08052a, float:1.8080182E38)
            r3 = 2131822055(0x7f1105e7, float:1.927687E38)
            r4 = 2131232041(0x7f080529, float:1.808018E38)
            java.lang.String r5 = "Drone"
            r6 = 0
            r7 = 1
            r8 = 0
            if (r0 == 0) goto L_0x0287
            r9 = 2
            if (r0 == r7) goto L_0x00d4
            if (r0 == r9) goto L_0x001b
            goto L_0x032e
        L_0x001b:
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x002c
            int r1 = com.xeagle.R.id.tv_device_name
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x002d
        L_0x002c:
            r0 = r8
        L_0x002d:
            kotlin.jvm.internal.h.a((java.lang.Object) r0)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x004a
            int r1 = com.xeagle.R.id.iv_status
            android.view.View r0 = r0.findViewById(r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x004a
            r0.setImageResource(r4)
        L_0x004a:
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x005b
            int r1 = com.xeagle.R.id.tv_device_status
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x005c
        L_0x005b:
            r0 = r8
        L_0x005c:
            kotlin.jvm.internal.h.a((java.lang.Object) r0)
            r0.setText(r3)
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x0077
            int r1 = com.xeagle.R.id.iv_fly
            android.view.View r0 = r0.findViewById(r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0077
            r0.setImageResource(r2)
        L_0x0077:
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x0088
            int r1 = com.xeagle.R.id.tv_bottom_name
            android.view.View r0 = r0.findViewById(r1)
            com.xeagle.android.vjoystick.IWidgets.IButton r0 = (com.xeagle.android.vjoystick.IWidgets.IButton) r0
            goto L_0x0089
        L_0x0088:
            r0 = r8
        L_0x0089:
            kotlin.jvm.internal.h.a((java.lang.Object) r0)
            r1 = 2131820967(0x7f1101a7, float:1.9274664E38)
            r0.setText(r1)
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x00a3
            int r1 = com.xeagle.R.id.tv_bottom_name
            android.view.View r0 = r0.findViewById(r1)
            com.xeagle.android.vjoystick.IWidgets.IButton r0 = (com.xeagle.android.vjoystick.IWidgets.IButton) r0
            goto L_0x00a4
        L_0x00a3:
            r0 = r8
        L_0x00a4:
            kotlin.jvm.internal.h.a((java.lang.Object) r0)
            r1 = -7829368(0xffffffffff888888, float:NaN)
            r0.setTextColor(r1)
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x00be
            int r1 = com.xeagle.R.id.tv_bottom_name
            android.view.View r0 = r0.findViewById(r1)
            r8 = r0
            com.xeagle.android.vjoystick.IWidgets.IButton r8 = (com.xeagle.android.vjoystick.IWidgets.IButton) r8
        L_0x00be:
            kotlin.jvm.internal.h.a((java.lang.Object) r8)
            r8.setEnabled(r6)
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            boolean r0 = r0.isUsbDevice()
            if (r0 == 0) goto L_0x032e
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            r1 = 5
            r0.timeoutReset(r1)
            goto L_0x032e
        L_0x00d4:
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x00ec
            int r2 = com.xeagle.R.id.iv_status
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x00ec
            r2 = 2131231968(0x7f0804e0, float:1.8080032E38)
            r0.setImageResource(r2)
        L_0x00ec:
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x00fd
            int r2 = com.xeagle.R.id.tv_device_status
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x00fe
        L_0x00fd:
            r0 = r8
        L_0x00fe:
            kotlin.jvm.internal.h.a((java.lang.Object) r0)
            r2 = 2131822012(0x7f1105bc, float:1.9276783E38)
            r0.setText(r2)
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            com.xeagle.android.utils.prefs.a r0 = com.xeagle.android.login.fragment.DeviceFragment.access$getPrefs$p(r0)
            java.lang.String r0 = r0.j()
            java.lang.String r2 = "prefs.droneType"
            kotlin.jvm.internal.h.b(r0, r2)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r3 = "809-D"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r0 = kotlin.text.f.a((java.lang.CharSequence) r0, (java.lang.CharSequence) r3, (boolean) r6, (int) r9, (java.lang.Object) r8)
            if (r0 == 0) goto L_0x013c
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x0225
            int r2 = com.xeagle.R.id.iv_fly
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0225
            r2 = 2131231970(0x7f0804e2, float:1.8080036E38)
        L_0x0137:
            r0.setImageResource(r2)
            goto L_0x0225
        L_0x013c:
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            com.xeagle.android.utils.prefs.a r0 = com.xeagle.android.login.fragment.DeviceFragment.access$getPrefs$p(r0)
            java.lang.String r0 = r0.j()
            kotlin.jvm.internal.h.b(r0, r2)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r2 = "816"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r0 = kotlin.text.f.a((java.lang.CharSequence) r0, (java.lang.CharSequence) r2, (boolean) r6, (int) r9, (java.lang.Object) r8)
            if (r0 == 0) goto L_0x016b
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x0225
            int r2 = com.xeagle.R.id.iv_fly
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0225
            r2 = 2131231974(0x7f0804e6, float:1.8080044E38)
            goto L_0x0137
        L_0x016b:
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            com.xeagle.android.utils.prefs.a r0 = com.xeagle.android.login.fragment.DeviceFragment.access$getPrefs$p(r0)
            java.lang.String r0 = r0.j()
            java.lang.String r2 = "808-D"
            boolean r0 = kotlin.text.f.a(r0, r2, r7)
            if (r0 == 0) goto L_0x0193
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x0225
            int r2 = com.xeagle.R.id.iv_fly
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0225
            r2 = 2131231969(0x7f0804e1, float:1.8080034E38)
            goto L_0x0137
        L_0x0193:
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            com.xeagle.android.utils.prefs.a r0 = com.xeagle.android.login.fragment.DeviceFragment.access$getPrefs$p(r0)
            java.lang.String r0 = r0.j()
            java.lang.String r2 = "812-D"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x01bc
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x0225
            int r2 = com.xeagle.R.id.iv_fly
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0225
            r2 = 2131231972(0x7f0804e4, float:1.808004E38)
            goto L_0x0137
        L_0x01bc:
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            com.xeagle.android.utils.prefs.a r0 = com.xeagle.android.login.fragment.DeviceFragment.access$getPrefs$p(r0)
            java.lang.String r0 = r0.j()
            java.lang.String r2 = "812-E"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x01e5
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x0225
            int r2 = com.xeagle.R.id.iv_fly
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0225
            r2 = 2131231973(0x7f0804e5, float:1.8080042E38)
            goto L_0x0137
        L_0x01e5:
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            com.xeagle.android.utils.prefs.a r0 = com.xeagle.android.login.fragment.DeviceFragment.access$getPrefs$p(r0)
            java.lang.String r0 = r0.j()
            java.lang.String r2 = "809-E"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x020e
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x0225
            int r2 = com.xeagle.R.id.iv_fly
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0225
            r2 = 2131231971(0x7f0804e3, float:1.8080038E38)
            goto L_0x0137
        L_0x020e:
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x0225
            int r2 = com.xeagle.R.id.iv_fly
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0225
            r2 = 2131231975(0x7f0804e7, float:1.8080046E38)
            goto L_0x0137
        L_0x0225:
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x0236
            int r2 = com.xeagle.R.id.tv_bottom_name
            android.view.View r0 = r0.findViewById(r2)
            com.xeagle.android.vjoystick.IWidgets.IButton r0 = (com.xeagle.android.vjoystick.IWidgets.IButton) r0
            goto L_0x0237
        L_0x0236:
            r0 = r8
        L_0x0237:
            kotlin.jvm.internal.h.a((java.lang.Object) r0)
            r2 = 2131822049(0x7f1105e1, float:1.9276858E38)
            r0.setText(r2)
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x0251
            int r2 = com.xeagle.R.id.tv_bottom_name
            android.view.View r0 = r0.findViewById(r2)
            com.xeagle.android.vjoystick.IWidgets.IButton r0 = (com.xeagle.android.vjoystick.IWidgets.IButton) r0
            goto L_0x0252
        L_0x0251:
            r0 = r8
        L_0x0252:
            kotlin.jvm.internal.h.a((java.lang.Object) r0)
            r0.setEnabled(r7)
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x0269
            int r2 = com.xeagle.R.id.tv_bottom_name
            android.view.View r0 = r0.findViewById(r2)
            r8 = r0
            com.xeagle.android.vjoystick.IWidgets.IButton r8 = (com.xeagle.android.vjoystick.IWidgets.IButton) r8
        L_0x0269:
            kotlin.jvm.internal.h.a((java.lang.Object) r8)
            r8.setTextColor(r1)
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            boolean r0 = r0.isUsbDevice()
            if (r0 == 0) goto L_0x027c
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            r0.timeoutReset(r9)
        L_0x027c:
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            com.xeagle.android.utils.prefs.a r0 = com.xeagle.android.login.fragment.DeviceFragment.access$getPrefs$p(r0)
            r0.n((boolean) r7)
            goto L_0x032e
        L_0x0287:
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x0298
            int r9 = com.xeagle.R.id.tv_device_name
            android.view.View r0 = r0.findViewById(r9)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x0299
        L_0x0298:
            r0 = r8
        L_0x0299:
            kotlin.jvm.internal.h.a((java.lang.Object) r0)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x02b6
            int r5 = com.xeagle.R.id.iv_status
            android.view.View r0 = r0.findViewById(r5)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x02b6
            r0.setImageResource(r4)
        L_0x02b6:
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x02c7
            int r4 = com.xeagle.R.id.tv_device_status
            android.view.View r0 = r0.findViewById(r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x02c8
        L_0x02c7:
            r0 = r8
        L_0x02c8:
            kotlin.jvm.internal.h.a((java.lang.Object) r0)
            r0.setText(r3)
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x02e3
            int r3 = com.xeagle.R.id.iv_fly
            android.view.View r0 = r0.findViewById(r3)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x02e3
            r0.setImageResource(r2)
        L_0x02e3:
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            r0.setTv_bottom_name()
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x02f9
            int r2 = com.xeagle.R.id.tv_bottom_name
            android.view.View r0 = r0.findViewById(r2)
            com.xeagle.android.vjoystick.IWidgets.IButton r0 = (com.xeagle.android.vjoystick.IWidgets.IButton) r0
            goto L_0x02fa
        L_0x02f9:
            r0 = r8
        L_0x02fa:
            kotlin.jvm.internal.h.a((java.lang.Object) r0)
            r0.setEnabled(r7)
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            android.view.View r0 = r0.mLayoutView
            if (r0 == 0) goto L_0x0311
            int r2 = com.xeagle.R.id.tv_bottom_name
            android.view.View r0 = r0.findViewById(r2)
            r8 = r0
            com.xeagle.android.vjoystick.IWidgets.IButton r8 = (com.xeagle.android.vjoystick.IWidgets.IButton) r8
        L_0x0311:
            kotlin.jvm.internal.h.a((java.lang.Object) r8)
            r8.setTextColor(r1)
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            boolean r0 = r0.isUsbDevice()
            if (r0 == 0) goto L_0x0325
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            r1 = 4
            r0.timeoutReset(r1)
        L_0x0325:
            com.xeagle.android.login.fragment.DeviceFragment r0 = r10.this$0
            com.xeagle.android.utils.prefs.a r0 = com.xeagle.android.login.fragment.DeviceFragment.access$getPrefs$p(r0)
            r0.n((boolean) r6)
        L_0x032e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.fragment.DeviceFragment$setStatus$1.run():void");
    }
}
