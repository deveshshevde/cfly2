package com.xeagle.android.fragments.calibration.imu;

import ad.a;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import dy.am;
import dy.c;
import dy.d;
import dy.k;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class FragmentSetupIMU extends Fragment implements DroneInterfaces.c {
    private static final String EXTRA_UPDATE_TIMESTAMP = "extra_update_timestamp";
    private static final long TIMEOUT_MAX = 30000;
    private static final long UPDATE_TIMEOUT_PERIOD = 100;
    private XEagleApp app;
    private IButton btnStep;
    /* access modifiers changed from: private */
    public int calibration_step = 0;
    private Drawable drawableGood;
    private Drawable drawablePoor;
    private Drawable drawableWarning;
    /* access modifiers changed from: private */
    public final Handler handler = new Handler();
    private String msg;
    private ProgressBar pbTimeOut;
    private Runnable runnable = new Runnable() {
        public void run() {
            FragmentSetupIMU.this.handler.removeCallbacks(this);
            FragmentSetupIMU.this.updateTimeOutProgress();
            FragmentSetupIMU.this.handler.postDelayed(this, FragmentSetupIMU.UPDATE_TIMEOUT_PERIOD);
        }
    };
    private TextView textDesc;
    private TextView textViewOffset;
    private TextView textViewScaling;
    private TextView textViewStep;
    private TextView textViewTimeOut;
    private String timeLeftStr;
    private long updateTimestamp;

    /* renamed from: com.xeagle.android.fragments.calibration.imu.FragmentSetupIMU$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$flypro$core$drone$DroneInterfaces$DroneEventsType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
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
                int[] r0 = $SwitchMap$com$flypro$core$drone$DroneInterfaces$DroneEventsType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.CALIBRATION_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.calibration.imu.FragmentSetupIMU.AnonymousClass3.<clinit>():void");
        }
    }

    public static CharSequence getTitle(Context context) {
        return context.getText(R.string.setup_imu_title);
    }

    /* access modifiers changed from: private */
    public void processCalibrationStep(int i2) {
        if (i2 == 0) {
            startCalibration();
            this.updateTimestamp = System.currentTimeMillis();
        } else if (i2 <= 0 || i2 >= 7) {
            this.calibration_step = 0;
            this.textViewStep.setText(R.string.setup_imu_step);
            this.textViewOffset.setVisibility(4);
            this.textViewScaling.setVisibility(4);
            updateDescription(this.calibration_step);
            a.a((Context) getActivity()).a(new Intent("compass_back_action"));
        } else {
            sendAck(i2);
        }
    }

    private void processMAVMessage(String str, boolean z2) {
        TextView textView;
        if (str.contains("Place") || str.contains("Calibration")) {
            if (z2) {
                this.updateTimestamp = System.currentTimeMillis();
            }
            processOrientation(str);
            return;
        }
        if (str.contains("Offsets")) {
            this.textViewOffset.setVisibility(0);
            textView = this.textViewOffset;
        } else if (str.contains("Scaling")) {
            this.textViewScaling.setVisibility(0);
            textView = this.textViewScaling;
        } else {
            return;
        }
        textView.setText(str);
    }

    private void processOrientation(String str) {
        int i2;
        if (str.contains("level")) {
            i2 = 1;
        } else if (str.contains("LEFT")) {
            i2 = 2;
        } else if (str.contains("RIGHT")) {
            i2 = 3;
        } else if (str.contains("DOWN")) {
            i2 = 4;
        } else if (str.contains("UP")) {
            i2 = 5;
        } else if (str.contains("BACK")) {
            i2 = 6;
        } else {
            if (str.contains("Calibration")) {
                i2 = 7;
            }
            this.msg = str.replace("any key.", "'Next'");
            updateDescription(this.calibration_step);
        }
        this.calibration_step = i2;
        this.msg = str.replace("any key.", "'Next'");
        updateDescription(this.calibration_step);
    }

    private void resetCalibration() {
        this.calibration_step = 0;
        updateDescription(0);
    }

    private void sendAck(int i2) {
        if (this.app.k() != null) {
            this.app.k().x().a(i2);
        }
    }

    private void startCalibration() {
        if (this.app.k() != null && !this.app.k().x().a()) {
            Toast.makeText(getActivity(), getString(R.string.failed_start_calibration_message), 1).show();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void calibrateImuEvent(c cVar) {
        if (cVar.a() == 27) {
            processMAVMessage(this.app.k().x().c(), true);
        }
    }

    @l(a = ThreadMode.ASYNC)
    public void calibrateTimeoutEvent(d dVar) {
        if (dVar.a() == 28 && this.app.k() != null) {
            com.flypro.core.drone.variables.c x2 = this.app.k().x();
            if (!x2.d() || !TextUtils.isEmpty(this.msg)) {
                Toast.makeText(getActivity(), this.msg, 0).show();
                return;
            }
            x2.a(false);
            org.greenrobot.eventbus.c.a().d(new am(5));
        }
    }

    @l(a = ThreadMode.MAIN)
    public void disConnectedEvent(dy.l lVar) {
        if (lVar.a() == 1) {
            resetCalibration();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void droneConnectEvent(k kVar) {
        if (kVar.a() == 0 && this.calibration_step == 0) {
            resetCalibration();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.app = (XEagleApp) getActivity().getApplication();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_setup_imu_main, viewGroup, false);
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        int i2 = AnonymousClass3.$SwitchMap$com$flypro$core$drone$DroneInterfaces$DroneEventsType[droneEventsType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4 && aVar != null) {
                        com.flypro.core.drone.variables.c x2 = aVar.x();
                        if (!x2.d() || !TextUtils.isEmpty(this.msg)) {
                            Toast.makeText(getActivity(), this.msg, 0).show();
                            return;
                        }
                        x2.a(false);
                        aVar.a(DroneInterfaces.DroneEventsType.HEARTBEAT_TIMEOUT);
                        return;
                    }
                    return;
                }
            } else if (this.calibration_step != 0) {
                return;
            }
            resetCalibration();
            return;
        }
        processMAVMessage(aVar.x().c(), true);
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

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong(EXTRA_UPDATE_TIMESTAMP, this.updateTimestamp);
    }

    public void onStart() {
        super.onStart();
        en.a k2 = this.app.k();
        if (k2 == null || !k2.j().a() || k2.d().d() || !k2.x().d()) {
            resetCalibration();
        } else {
            processMAVMessage(k2.x().c(), true);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.textViewStep = (TextView) view.findViewById(R.id.textViewIMUStep);
        this.textViewOffset = (TextView) view.findViewById(R.id.TextViewIMUOffset);
        this.textViewScaling = (TextView) view.findViewById(R.id.TextViewIMUScaling);
        this.textViewTimeOut = (TextView) view.findViewById(R.id.textViewIMUTimeOut);
        this.pbTimeOut = (ProgressBar) view.findViewById(R.id.progressBarTimeOut);
        this.textDesc = (TextView) view.findViewById(R.id.textViewDesc);
        IButton iButton = (IButton) view.findViewById(R.id.buttonStep);
        this.btnStep = iButton;
        iButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentSetupIMU fragmentSetupIMU = FragmentSetupIMU.this;
                fragmentSetupIMU.processCalibrationStep(fragmentSetupIMU.calibration_step);
            }
        });
        this.pbTimeOut.setVisibility(4);
        this.textViewTimeOut.setVisibility(4);
        this.textViewOffset.setVisibility(4);
        this.textViewScaling.setVisibility(4);
        this.timeLeftStr = getString(R.string.setup_imu_timeleft);
        this.drawableGood = getResources().getDrawable(R.drawable.pstate_good);
        this.drawableWarning = getResources().getDrawable(R.drawable.pstate_warning);
        this.drawablePoor = getResources().getDrawable(R.drawable.pstate_poor);
        if (bundle != null) {
            this.updateTimestamp = bundle.getLong(EXTRA_UPDATE_TIMESTAMP);
        }
    }

    public void updateDescription(int i2) {
        int i3;
        switch (i2) {
            case 0:
                i3 = R.string.setup_imu_start;
                break;
            case 1:
                i3 = R.string.setup_imu_normal;
                break;
            case 2:
                i3 = R.string.setup_imu_left;
                break;
            case 3:
                i3 = R.string.setup_imu_right;
                break;
            case 4:
                i3 = R.string.setup_imu_nosedown;
                break;
            case 5:
                i3 = R.string.setup_imu_noseup;
                break;
            case 6:
                i3 = R.string.setup_imu_back;
                break;
            case 7:
                i3 = R.string.setup_imu_completed;
                break;
            default:
                return;
        }
        TextView textView = this.textDesc;
        if (textView != null) {
            textView.setText(i3);
        }
        Toast.makeText(getActivity(), i3, 0).show();
        TextView textView2 = this.textViewStep;
        if (textView2 != null) {
            textView2.setText(i3);
        }
        IButton iButton = this.btnStep;
        if (iButton != null) {
            iButton.setText(i2 == 0 ? R.string.button_setup_calibrate : i2 == 7 ? R.string.button_setup_done : R.string.button_setup_next);
        }
        if (i2 == 7 || i2 == 0) {
            this.handler.removeCallbacks(this.runnable);
            this.pbTimeOut.setVisibility(4);
            this.textViewTimeOut.setVisibility(4);
            return;
        }
        this.handler.removeCallbacks(this.runnable);
        this.textViewTimeOut.setVisibility(0);
        this.pbTimeOut.setIndeterminate(true);
        this.pbTimeOut.setVisibility(0);
        this.handler.postDelayed(this.runnable, UPDATE_TIMEOUT_PERIOD);
    }

    /* access modifiers changed from: protected */
    public void updateTimeOutProgress() {
        ProgressBar progressBar;
        Drawable drawable;
        long currentTimeMillis = (long) ((int) (TIMEOUT_MAX - (System.currentTimeMillis() - this.updateTimestamp)));
        if (currentTimeMillis >= 0) {
            int i2 = ((int) (currentTimeMillis / 1000)) + 1;
            this.pbTimeOut.setIndeterminate(false);
            this.pbTimeOut.setMax(30000);
            this.pbTimeOut.setProgress((int) currentTimeMillis);
            TextView textView = this.textViewTimeOut;
            textView.setText(this.timeLeftStr + String.valueOf(i2) + "s");
            if (i2 > 15) {
                progressBar = this.pbTimeOut;
                drawable = this.drawableGood;
            } else if (i2 <= 15 && i2 > 5) {
                progressBar = this.pbTimeOut;
                drawable = this.drawableWarning;
            } else if (i2 == 5) {
                progressBar = this.pbTimeOut;
                drawable = this.drawablePoor;
            } else {
                return;
            }
            progressBar.setProgressDrawable(drawable);
            return;
        }
        TextView textView2 = this.textViewTimeOut;
        textView2.setText(this.timeLeftStr + "0s");
    }
}
