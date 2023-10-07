package com.xeagle.android.fragments.calibration;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.XEagleApp;
import dy.c;
import dy.k;
import en.a;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class BoardLevelFragment extends Fragment implements DroneInterfaces.c {
    private XEagleApp app;
    @BindView(2131296713)
    Button buttonStep;
    @BindView(2131299132)
    TextView textViewDesc;

    /* renamed from: com.xeagle.android.fragments.calibration.BoardLevelFragment$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$flypro$core$drone$DroneInterfaces$DroneEventsType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$flypro$core$drone$DroneInterfaces$DroneEventsType = r0
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.CALIBRATION_IMU     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$flypro$core$drone$DroneInterfaces$DroneEventsType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$flypro$core$drone$DroneInterfaces$DroneEventsType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.calibration.BoardLevelFragment.AnonymousClass1.<clinit>():void");
        }
    }

    public static CharSequence getTitle(Context context) {
        return context.getText(R.string.setup_imu_title);
    }

    private void processMAVMessage(String str, boolean z2) {
        if (str.contains("Initialising APM")) {
            this.buttonStep.setEnabled(true);
            this.buttonStep.setText(R.string.button_setup_done);
        }
    }

    private void startCalibration() {
        if (this.app.k() != null && !this.app.k().x().b()) {
            Toast.makeText(getActivity(), getString(R.string.failed_start_calibration_message), 1).show();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void calibrateImuEvent(c cVar) {
        if (cVar.a() == 27) {
            processMAVMessage(this.app.k().x().c(), true);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void disconnectEvent(dy.l lVar) {
        if (lVar.a() == 1) {
            this.buttonStep.setEnabled(false);
            this.buttonStep.setText(R.string.button_setup_calibrate);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void droneConnectEvent(k kVar) {
        Button button;
        int i2;
        if (kVar.a() == 0) {
            if (this.app.k().x().a()) {
                button = this.buttonStep;
                i2 = R.string.button_setup_cancel;
            } else {
                button = this.buttonStep;
                i2 = R.string.button_setup_calibrate;
            }
            button.setText(i2);
            this.buttonStep.setEnabled(true);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.app = (XEagleApp) getActivity().getApplication();
    }

    @OnClick({2131296713})
    public void onClick() {
        if (this.buttonStep.getText().equals(getString(R.string.button_setup_calibrate))) {
            startCalibration();
        } else if (this.buttonStep.getText().equals(getString(R.string.button_setup_done)) || this.buttonStep.getText().equals(getString(R.string.button_setup_cancel))) {
            this.buttonStep.setText(R.string.button_setup_calibrate);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.board_level_fragment, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        return inflate;
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        int i2 = AnonymousClass1.$SwitchMap$com$flypro$core$drone$DroneInterfaces$DroneEventsType[droneEventsType.ordinal()];
        if (i2 == 1) {
            processMAVMessage(aVar.x().c(), true);
        } else if (i2 == 2) {
            if (this.app.k().x().a()) {
                this.buttonStep.setText(R.string.button_setup_cancel);
            } else {
                this.buttonStep.setText(R.string.button_setup_calibrate);
            }
            this.buttonStep.setEnabled(true);
        } else if (i2 == 3) {
            this.buttonStep.setEnabled(false);
            this.buttonStep.setText(R.string.button_setup_calibrate);
        }
    }

    public void onPause() {
        super.onPause();
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
        this.app.k().b((DroneInterfaces.c) this);
    }

    public void onResume() {
        super.onResume();
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
        this.app.k().a((DroneInterfaces.c) this);
    }

    public void onStart() {
        super.onStart();
        a k2 = this.app.k();
        if (k2 == null || !k2.j().a() || k2.d().d()) {
            this.buttonStep.setEnabled(false);
        } else {
            this.buttonStep.setEnabled(true);
            if (k2.x().d()) {
                processMAVMessage(k2.x().c(), false);
                return;
            }
        }
        this.buttonStep.setText(R.string.button_setup_calibrate);
    }
}
