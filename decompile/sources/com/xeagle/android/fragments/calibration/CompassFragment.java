package com.xeagle.android.fragments.calibration;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.flypro.core.MAVLink.f;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import dy.al;
import dy.k;
import dy.w;
import en.a;
import jo.q;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class CompassFragment extends Fragment implements View.OnClickListener, DroneInterfaces.c {
    private static final int CALIB_FAIL_M = 20;
    private static final int CALIB_FAIL_S = 30;
    private static final int CALIB_SUCCESS_M = 1;
    private static final int CALIB_SUCCESS_NORC_M = 0;
    private static final int CALIB_SUCCESS_NORC_S = 10;
    private static final int CALIB_SUCCESS_S = 11;
    private static final int CLB_START_M = 8;
    private static final int CLB_START_S = 18;
    private static final int FAIL_ENVIOR_M = 7;
    private static final int FAIL_ENVIOR_S = 17;
    private static final int FAIL_USER_M = 6;
    private static final int FAIL_USER_S = 16;
    private static final int FIRST_C_DONE_M = 4;
    private static final int FIRST_C_DONE_S = 14;
    private static final int FIRST_TURN_AGAIN_M = 3;
    private static final int FIRST_TURN_AGAIN_S = 13;
    private static final int NO_EXT_CMP_M = 2;
    private static final int NO_EXT_CMP_S = 12;
    private static final int NO_INT_CMP = 2;
    private static final int NO_SIGNAL = 2;
    private static final int SEC_TURN_AGAIN_M = 5;
    private static final int SEC_TURN_AGAIN_S = 15;
    private IButton btnCalibrate;
    /* access modifiers changed from: private */
    public int cal_status;
    private TextView calibrateInfo;
    private int calibrationStatus = -1;
    private IImageButton compassBack;
    private a drone;
    private boolean isCalibrate;
    private boolean isFailed;
    private boolean isSuccess;
    private ImageView iv_compass;
    private long round_time = 0;
    private long take_calib_time = 0;
    private View view;
    private XEagleApp xEagleApp;

    /* renamed from: com.xeagle.android.fragments.calibration.CompassFragment$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
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
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$flypro$core$drone$DroneInterfaces$DroneEventsType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$flypro$core$drone$DroneInterfaces$DroneEventsType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.RC_CONTROL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.calibration.CompassFragment.AnonymousClass2.<clinit>():void");
        }
    }

    private void fit() {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    CompassFragment compassFragment = CompassFragment.this;
                    compassFragment.setCalibrationStatus(compassFragment.cal_status);
                    CompassFragment.this.updateBtnCalibrateState();
                }
            });
        }
    }

    private void initView(View view2) {
        this.compassBack = (IImageButton) view2.findViewById(R.id.compass_back);
        this.calibrateInfo = (TextView) view2.findViewById(R.id.calibrate_info);
        this.btnCalibrate = (IButton) view2.findViewById(R.id.btn_calibrate);
        this.iv_compass = (ImageView) view2.findViewById(R.id.iv_compass);
        this.compassBack.setOnClickListener(this);
        this.btnCalibrate.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004e, code lost:
        r14.calibrateInfo.setTextColor(-1);
        r14.calibrateInfo.setText(getString(com.cfly.uav_pro.R.string.cal_start));
        r14.iv_compass.setImageResource(com.cfly.uav_pro.R.drawable.newui_compass_port);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0063, code lost:
        r14.calibrateInfo.setTextColor(-65536);
        r15 = r14.calibrateInfo;
        r0 = getString(com.cfly.uav_pro.R.string.cal_fail_environ);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x006f, code lost:
        r14.calibrateInfo.setTextColor(-65536);
        r15 = r14.calibrateInfo;
        r0 = getString(com.cfly.uav_pro.R.string.cal_fail_user);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007b, code lost:
        r14.calibrateInfo.setTextColor(-1);
        r14.calibrateInfo.setText(getString(com.cfly.uav_pro.R.string.cal_first_done));
        r14.iv_compass.setImageResource(com.cfly.uav_pro.R.drawable.newui_compass_land);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x008f, code lost:
        r14.calibrateInfo.setTextColor(-1);
        r14.calibrateInfo.setText(getString(com.cfly.uav_pro.R.string.cal_turn_again));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x009e, code lost:
        r14.calibrateInfo.setTextColor(-65536);
        r15 = r14.calibrateInfo;
        r0 = getString(com.cfly.uav_pro.R.string.cal_no_cmp);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b0, code lost:
        r14.calibrateInfo.setTextColor(-1);
        r14.btnCalibrate.setVisibility(0);
        r14.btnCalibrate.setText(getString(com.cfly.uav_pro.R.string.button_setup_done));
        r14.calibrateInfo.setText(getString(com.cfly.uav_pro.R.string.cal_success));
        r14.isCalibrate = false;
        r14.drone.x().a(false);
        stopCalibration();
        r14.isFailed = false;
        r14.isSuccess = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCalibrationStatus(int r15) {
        /*
            r14 = this;
            int r0 = r14.calibrationStatus
            if (r0 != r15) goto L_0x0005
            return
        L_0x0005:
            r14.calibrationStatus = r15
            r0 = 20
            r1 = 2131820798(0x7f1100fe, float:1.9274321E38)
            r2 = -65536(0xffffffffffff0000, float:NaN)
            if (r15 == r0) goto L_0x00df
            r0 = 30
            if (r15 == r0) goto L_0x00df
            r0 = 2131231934(0x7f0804be, float:1.8079963E38)
            r1 = 2131820808(0x7f110108, float:1.9274341E38)
            r3 = 2131820799(0x7f1100ff, float:1.9274323E38)
            r4 = 2131820800(0x7f110100, float:1.9274325E38)
            r5 = 2131231933(0x7f0804bd, float:1.807996E38)
            r6 = 2131820801(0x7f110101, float:1.9274327E38)
            r7 = 2131820805(0x7f110105, float:1.9274335E38)
            r8 = 1
            r9 = 2131820809(0x7f110109, float:1.9274343E38)
            r10 = 2131820791(0x7f1100f7, float:1.9274307E38)
            r11 = 2131820811(0x7f11010b, float:1.9274347E38)
            r12 = 0
            r13 = -1
            switch(r15) {
                case 0: goto L_0x00b0;
                case 1: goto L_0x00b0;
                case 2: goto L_0x009e;
                case 3: goto L_0x008f;
                case 4: goto L_0x007b;
                case 5: goto L_0x008f;
                case 6: goto L_0x006f;
                case 7: goto L_0x0063;
                case 8: goto L_0x004e;
                default: goto L_0x0038;
            }
        L_0x0038:
            switch(r15) {
                case 10: goto L_0x00b0;
                case 11: goto L_0x00b0;
                case 12: goto L_0x009e;
                case 13: goto L_0x008f;
                case 14: goto L_0x007b;
                case 15: goto L_0x008f;
                case 16: goto L_0x006f;
                case 17: goto L_0x0063;
                case 18: goto L_0x004e;
                default: goto L_0x003b;
            }
        L_0x003b:
            com.xeagle.android.vjoystick.IWidgets.IButton r15 = r14.btnCalibrate
            r15.setVisibility(r12)
            com.xeagle.android.vjoystick.IWidgets.IButton r15 = r14.btnCalibrate
            r0 = 2131820789(0x7f1100f5, float:1.9274303E38)
            java.lang.String r0 = r14.getString(r0)
            r15.setText(r0)
            goto L_0x00eb
        L_0x004e:
            android.widget.TextView r15 = r14.calibrateInfo
            r15.setTextColor(r13)
            android.widget.TextView r15 = r14.calibrateInfo
            java.lang.String r1 = r14.getString(r1)
            r15.setText(r1)
            android.widget.ImageView r15 = r14.iv_compass
            r15.setImageResource(r0)
            goto L_0x00eb
        L_0x0063:
            android.widget.TextView r15 = r14.calibrateInfo
            r15.setTextColor(r2)
            android.widget.TextView r15 = r14.calibrateInfo
            java.lang.String r0 = r14.getString(r3)
            goto L_0x00a9
        L_0x006f:
            android.widget.TextView r15 = r14.calibrateInfo
            r15.setTextColor(r2)
            android.widget.TextView r15 = r14.calibrateInfo
            java.lang.String r0 = r14.getString(r4)
            goto L_0x00a9
        L_0x007b:
            android.widget.TextView r15 = r14.calibrateInfo
            r15.setTextColor(r13)
            android.widget.TextView r15 = r14.calibrateInfo
            java.lang.String r0 = r14.getString(r6)
            r15.setText(r0)
            android.widget.ImageView r15 = r14.iv_compass
            r15.setImageResource(r5)
            goto L_0x00eb
        L_0x008f:
            android.widget.TextView r15 = r14.calibrateInfo
            r15.setTextColor(r13)
            android.widget.TextView r15 = r14.calibrateInfo
            java.lang.String r0 = r14.getString(r11)
            r15.setText(r0)
            goto L_0x00eb
        L_0x009e:
            android.widget.TextView r15 = r14.calibrateInfo
            r15.setTextColor(r2)
            android.widget.TextView r15 = r14.calibrateInfo
            java.lang.String r0 = r14.getString(r7)
        L_0x00a9:
            r15.setText(r0)
            r14.stopCalibration()
            goto L_0x00eb
        L_0x00b0:
            android.widget.TextView r15 = r14.calibrateInfo
            r15.setTextColor(r13)
            com.xeagle.android.vjoystick.IWidgets.IButton r15 = r14.btnCalibrate
            r15.setVisibility(r12)
            com.xeagle.android.vjoystick.IWidgets.IButton r15 = r14.btnCalibrate
            java.lang.String r0 = r14.getString(r10)
            r15.setText(r0)
            android.widget.TextView r15 = r14.calibrateInfo
            java.lang.String r0 = r14.getString(r9)
            r15.setText(r0)
            r14.isCalibrate = r12
            en.a r15 = r14.drone
            com.flypro.core.drone.variables.c r15 = r15.x()
            r15.a((boolean) r12)
            r14.stopCalibration()
            r14.isFailed = r12
            r14.isSuccess = r8
            goto L_0x00eb
        L_0x00df:
            android.widget.TextView r15 = r14.calibrateInfo
            r15.setTextColor(r2)
            android.widget.TextView r15 = r14.calibrateInfo
            java.lang.String r0 = r14.getString(r1)
            goto L_0x00a9
        L_0x00eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.calibration.CompassFragment.setCalibrationStatus(int):void");
    }

    private void startCalibration() {
        this.isCalibrate = false;
        this.drone.x().a(false);
        this.isFailed = false;
        this.isSuccess = false;
        f.a(this.drone);
        this.drone.a((DroneInterfaces.c) this);
    }

    private void stopCalibration() {
        this.drone.b((DroneInterfaces.c) this);
        c.a().d(new al(7));
        this.isCalibrate = false;
        this.isFailed = true;
        this.isSuccess = false;
        this.drone.x().a(false);
    }

    /* access modifiers changed from: private */
    public void updateBtnCalibrateState() {
        IButton iButton;
        int i2;
        boolean z2 = this.isCalibrate;
        if (z2 || !this.isFailed) {
            if (z2 && !this.isFailed) {
                iButton = this.btnCalibrate;
                i2 = R.string.cal_going;
            } else if (!z2 && this.isSuccess) {
                this.btnCalibrate.setEnabled(true);
                iButton = this.btnCalibrate;
                i2 = R.string.button_setup_done;
            } else if (!z2) {
                this.btnCalibrate.setText(getString(R.string.button_setup_calibrate));
                this.btnCalibrate.setEnabled(true);
                return;
            } else {
                return;
            }
            iButton.setText(getString(i2));
            return;
        }
        this.btnCalibrate.setEnabled(true);
        this.btnCalibrate.setText(getString(R.string.cal_retry));
        this.isFailed = false;
    }

    @l(a = ThreadMode.BACKGROUND)
    public void disConnectEvent(dy.l lVar) {
        if (lVar.a() == 1) {
            this.btnCalibrate.setEnabled(false);
            if (this.isCalibrate) {
                stopCalibration();
            }
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void droneConnectEvent(k kVar) {
        if (kVar.a() == 0) {
            this.btnCalibrate.setEnabled(true);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void droneRcControlEvent(w wVar) {
        if (wVar.a() == 46) {
            this.cal_status = this.drone.E().a();
            fit();
        }
    }

    public void onClick(View view2) {
        int id2 = view2.getId();
        if (id2 != R.id.btn_calibrate) {
            if (id2 == R.id.compass_back) {
                c.a().d(new q("CompassFragment"));
                if (this.isCalibrate) {
                    stopCalibration();
                }
            }
        } else if (!this.drone.d().d()) {
            long currentTimeMillis = System.currentTimeMillis();
            this.take_calib_time = currentTimeMillis;
            if (currentTimeMillis - this.round_time > 3000) {
                if (this.btnCalibrate.getText().equals(getString(R.string.button_setup_done))) {
                    c.a().d(new q("CompassFragment"));
                } else if (this.isCalibrate) {
                    stopCalibration();
                    this.isFailed = false;
                    this.calibrateInfo.setText(getString(R.string.setup_mag_start));
                    updateBtnCalibrateState();
                } else {
                    startCalibration();
                    this.isCalibrate = true;
                    this.drone.x().a(true);
                }
                this.round_time = SystemClock.currentThreadTimeMillis();
                return;
            }
            ToastUtils.showShort((CharSequence) getActivity().getString(R.string.btn_click_fast));
        } else {
            ToastUtils.showShort((int) R.string.flying_operate_warn);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.view = layoutInflater.inflate(R.layout.compass_calibrate_fragment, viewGroup, false);
        XEagleApp xEagleApp2 = (XEagleApp) getActivity().getApplication();
        this.xEagleApp = xEagleApp2;
        this.drone = xEagleApp2.k();
        return this.view;
    }

    public void onDestroy() {
        super.onDestroy();
        stopCalibration();
        if (c.a().b(this)) {
            c.a().c(this);
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        int i2 = AnonymousClass2.$SwitchMap$com$flypro$core$drone$DroneInterfaces$DroneEventsType[droneEventsType.ordinal()];
        if (i2 == 1) {
            this.btnCalibrate.setEnabled(true);
        } else if (i2 == 2) {
            this.btnCalibrate.setEnabled(false);
            if (this.isCalibrate) {
                stopCalibration();
            }
        } else if (i2 == 3) {
            this.cal_status = aVar.E().a();
            fit();
        }
    }

    public void onResume() {
        super.onResume();
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
        updateBtnCalibrateState();
    }

    public void onViewCreated(View view2, Bundle bundle) {
        super.onViewCreated(view2, bundle);
        initView(view2);
    }
}
