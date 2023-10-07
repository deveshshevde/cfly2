package com.xeagle.android.dialogs;

import ad.a;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.c;
import androidx.fragment.app.s;
import com.cfly.uav_pro.R;
import com.xeagle.android.fragments.FlightInfoFragment;
import com.xeagle.android.fragments.calibration.CompassFragment;
import com.xeagle.android.fragments.calibration.imu.FragmentSetupIMU;
import com.xeagle.android.fragments.f;

public class ak extends c {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f22565b = true;

    /* renamed from: d  reason: collision with root package name */
    private static final IntentFilter f22566d;

    /* renamed from: a  reason: collision with root package name */
    BroadcastReceiver f22567a = new BroadcastReceiver() {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ boolean f22569a = true;

        static {
            Class<ak> cls = ak.class;
        }

        public void onReceive(Context context, Intent intent) {
            s sVar;
            Fragment fragment;
            String action = intent.getAction();
            if (f22569a || action != null) {
                action.hashCode();
                char c2 = 65535;
                switch (action.hashCode()) {
                    case -498464637:
                        if (action.equals("imu_six_cal")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -328530719:
                        if (action.equals("compass_back_action")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 475844341:
                        if (action.equals("compass_start")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1287622291:
                        if (action.equals("dialog_dismiss")) {
                            c2 = 3;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        sVar = ak.this.getChildFragmentManager().a();
                        fragment = new FragmentSetupIMU();
                        break;
                    case 1:
                        s a2 = ak.this.getChildFragmentManager().a();
                        a2.b(R.id.dialog_content, new f());
                        a2.c(4097);
                        a2.a("compass");
                        a2.d();
                        return;
                    case 2:
                        sVar = ak.this.getChildFragmentManager().a();
                        fragment = new CompassFragment();
                        break;
                    case 3:
                        Log.i("newUI", "onReceive: ----dismiss");
                        ak.this.dismiss();
                        return;
                    default:
                        return;
                }
                sVar.b(R.id.dialog_content, fragment);
                sVar.a("setting");
                sVar.c(4097);
                sVar.d();
                return;
            }
            throw new AssertionError();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private a f22568c;

    static {
        IntentFilter intentFilter = new IntentFilter();
        f22566d = intentFilter;
        intentFilter.addAction("compass_back_action");
        intentFilter.addAction("compass_start");
        intentFilter.addAction("imu_six_cal");
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.newDialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        if (f22565b || window != null) {
            window.setGravity(5);
            create.show();
            window.setLayout((getActivity().getWindowManager().getDefaultDisplay().getWidth() * 4) / 5, (getActivity().getWindowManager().getDefaultDisplay().getHeight() * 9) / 9);
            return create;
        }
        throw new AssertionError();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.drone_set_dialog, viewGroup, false);
        this.f22568c = a.a((Context) getActivity());
        s a2 = getChildFragmentManager().a();
        if (bundle == null) {
            a2.a((int) R.id.dialog_content, (Fragment) new FlightInfoFragment());
            a2.d();
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                if (i2 != 4) {
                    return false;
                }
                dialogInterface.dismiss();
                return false;
            }
        });
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f22568c.a(this.f22567a);
    }

    public void onResume() {
        super.onResume();
        this.f22568c.a(this.f22567a, f22566d);
    }
}
