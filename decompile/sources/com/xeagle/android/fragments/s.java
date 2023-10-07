package com.xeagle.android.fragments;

import ad.a;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.c;
import com.cfly.uav_pro.R;

public class s extends c {

    /* renamed from: b  reason: collision with root package name */
    private static String f23489b = "CAMERA";

    /* renamed from: d  reason: collision with root package name */
    private static final IntentFilter f23490d;

    /* renamed from: a  reason: collision with root package name */
    BroadcastReceiver f23491a = new BroadcastReceiver() {
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x006d, code lost:
            r4.a(r5);
            r4.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0083, code lost:
            r0.b(com.cfly.uav_pro.R.id.setting_content, r2);
            r0.a("setting");
            r0.c(4097);
            r0.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r4, android.content.Intent r5) {
            /*
                r3 = this;
                java.lang.String r4 = r5.getAction()
                r4.hashCode()
                int r5 = r4.hashCode()
                r0 = -1
                switch(r5) {
                    case -1075306569: goto L_0x0031;
                    case -498464637: goto L_0x0026;
                    case -328530719: goto L_0x001b;
                    case 475844341: goto L_0x0010;
                    default: goto L_0x000f;
                }
            L_0x000f:
                goto L_0x003b
            L_0x0010:
                java.lang.String r5 = "compass_start"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0019
                goto L_0x003b
            L_0x0019:
                r0 = 3
                goto L_0x003b
            L_0x001b:
                java.lang.String r5 = "compass_back_action"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x0024
                goto L_0x003b
            L_0x0024:
                r0 = 2
                goto L_0x003b
            L_0x0026:
                java.lang.String r5 = "imu_six_cal"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x002f
                goto L_0x003b
            L_0x002f:
                r0 = 1
                goto L_0x003b
            L_0x0031:
                java.lang.String r5 = "accel_back_action"
                boolean r4 = r4.equals(r5)
                if (r4 != 0) goto L_0x003a
                goto L_0x003b
            L_0x003a:
                r0 = 0
            L_0x003b:
                java.lang.String r4 = "setting"
                r5 = 4097(0x1001, float:5.741E-42)
                r1 = 2131298890(0x7f090a4a, float:1.8215766E38)
                switch(r0) {
                    case 0: goto L_0x0090;
                    case 1: goto L_0x0074;
                    case 2: goto L_0x0056;
                    case 3: goto L_0x0046;
                    default: goto L_0x0045;
                }
            L_0x0045:
                goto L_0x00a8
            L_0x0046:
                com.xeagle.android.fragments.s r0 = com.xeagle.android.fragments.s.this
                androidx.fragment.app.FragmentManager r0 = r0.getChildFragmentManager()
                androidx.fragment.app.s r0 = r0.a()
                com.xeagle.android.fragments.calibration.CompassFragment r2 = new com.xeagle.android.fragments.calibration.CompassFragment
                r2.<init>()
                goto L_0x0083
            L_0x0056:
                com.xeagle.android.fragments.s r4 = com.xeagle.android.fragments.s.this
                androidx.fragment.app.FragmentManager r4 = r4.getChildFragmentManager()
                androidx.fragment.app.s r4 = r4.a()
                com.xeagle.android.fragments.f r0 = new com.xeagle.android.fragments.f
                r0.<init>()
                r4.b(r1, r0)
                r4.c((int) r5)
                java.lang.String r5 = "compass"
            L_0x006d:
                r4.a((java.lang.String) r5)
                r4.d()
                goto L_0x00a8
            L_0x0074:
                com.xeagle.android.fragments.s r0 = com.xeagle.android.fragments.s.this
                androidx.fragment.app.FragmentManager r0 = r0.getChildFragmentManager()
                androidx.fragment.app.s r0 = r0.a()
                com.xeagle.android.fragments.calibration.imu.FragmentSetupIMU r2 = new com.xeagle.android.fragments.calibration.imu.FragmentSetupIMU
                r2.<init>()
            L_0x0083:
                r0.b(r1, r2)
                r0.a((java.lang.String) r4)
                r0.c((int) r5)
                r0.d()
                goto L_0x00a8
            L_0x0090:
                com.xeagle.android.fragments.s r4 = com.xeagle.android.fragments.s.this
                androidx.fragment.app.FragmentManager r4 = r4.getChildFragmentManager()
                androidx.fragment.app.s r4 = r4.a()
                com.xeagle.android.fragments.f r0 = new com.xeagle.android.fragments.f
                r0.<init>()
                r4.b(r1, r0)
                r4.c((int) r5)
                java.lang.String r5 = "imu"
                goto L_0x006d
            L_0x00a8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.s.AnonymousClass1.onReceive(android.content.Context, android.content.Intent):void");
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private a f23492c;

    static {
        IntentFilter intentFilter = new IntentFilter();
        f23490d = intentFilter;
        intentFilter.addAction("compass_back_action");
        intentFilter.addAction("accel_back_action");
        intentFilter.addAction("compass_start");
        intentFilter.addAction("imu_six_cal");
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        window.setGravity(17);
        create.show();
        window.setLayout((getActivity().getWindowManager().getDefaultDisplay().getWidth() * 4) / 5, (getActivity().getWindowManager().getDefaultDisplay().getHeight() * 4) / 5);
        return create;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.common_setting_layout, viewGroup, false);
        this.f23492c = a.a((Context) getActivity());
        androidx.fragment.app.s a2 = getChildFragmentManager().a();
        if (bundle == null) {
            a2.a((int) R.id.setting_content, (Fragment) new f());
            a2.a("setting");
            a2.d();
        }
        inflate.findViewById(R.id.go_back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                s.this.dismiss();
            }
        });
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f23492c.a(this.f23491a);
    }

    public void onResume() {
        super.onResume();
        this.f23492c.a(this.f23491a, f23490d);
    }
}
