package com.xeagle.android.newUI.fragment.remindFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.utils.w;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import dy.ac;
import dy.am;
import dy.bc;
import dy.c;
import dy.d;
import dy.k;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class ImuCalibrationDialog extends com.xeagle.android.dialogs.a implements View.OnClickListener, DroneInterfaces.e {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f12736b = true;

    /* renamed from: c  reason: collision with root package name */
    private String f12737c;

    /* renamed from: d  reason: collision with root package name */
    private IButton f12738d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f12739e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f12740f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f12741g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f12742h;

    /* renamed from: i  reason: collision with root package name */
    private XEagleApp f12743i;

    /* renamed from: j  reason: collision with root package name */
    private Context f12744j;

    /* renamed from: k  reason: collision with root package name */
    private en.a f12745k;

    /* renamed from: l  reason: collision with root package name */
    private String f12746l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f12747m = false;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final Handler f12748n = new Handler(Looper.myLooper());
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public long f12749o;

    /* renamed from: p  reason: collision with root package name */
    private IMU_states f12750p = IMU_states.IMU_IDLE;

    /* renamed from: q  reason: collision with root package name */
    private a f12751q;

    /* renamed from: r  reason: collision with root package name */
    private w f12752r;

    /* renamed from: s  reason: collision with root package name */
    private int f12753s = 0;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public Runnable f12754t = new Runnable() {
        public void run() {
            int i2 = (((long) ((int) (30000 - (System.currentTimeMillis() - ImuCalibrationDialog.this.f12749o)))) > 0 ? 1 : (((long) ((int) (30000 - (System.currentTimeMillis() - ImuCalibrationDialog.this.f12749o)))) == 0 ? 0 : -1));
            ImuCalibrationDialog imuCalibrationDialog = ImuCalibrationDialog.this;
            if (i2 < 0) {
                if (imuCalibrationDialog.f12755u) {
                    boolean unused = ImuCalibrationDialog.this.f12755u = false;
                }
                if (!ImuCalibrationDialog.this.f12747m) {
                    ToastUtils.showLong((int) R.string.calibration_time_out);
                    ImuCalibrationDialog.this.f12748n.removeCallbacks(ImuCalibrationDialog.this.f12754t);
                    return;
                }
                return;
            }
            imuCalibrationDialog.f12748n.removeCallbacks(this);
            ImuCalibrationDialog.this.f12748n.postDelayed(this, 100);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public boolean f12755u;

    /* renamed from: v  reason: collision with root package name */
    private int f12756v = 0;

    /* renamed from: com.xeagle.android.newUI.fragment.remindFragment.ImuCalibrationDialog$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24014a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.xeagle.android.newUI.fragment.remindFragment.ImuCalibrationDialog$IMU_states[] r0 = com.xeagle.android.newUI.fragment.remindFragment.ImuCalibrationDialog.IMU_states.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24014a = r0
                com.xeagle.android.newUI.fragment.remindFragment.ImuCalibrationDialog$IMU_states r1 = com.xeagle.android.newUI.fragment.remindFragment.ImuCalibrationDialog.IMU_states.IMU_LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24014a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xeagle.android.newUI.fragment.remindFragment.ImuCalibrationDialog$IMU_states r1 = com.xeagle.android.newUI.fragment.remindFragment.ImuCalibrationDialog.IMU_states.IMU_RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f24014a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xeagle.android.newUI.fragment.remindFragment.ImuCalibrationDialog$IMU_states r1 = com.xeagle.android.newUI.fragment.remindFragment.ImuCalibrationDialog.IMU_states.IMU_UP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f24014a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.xeagle.android.newUI.fragment.remindFragment.ImuCalibrationDialog$IMU_states r1 = com.xeagle.android.newUI.fragment.remindFragment.ImuCalibrationDialog.IMU_states.IMU_DOWN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.newUI.fragment.remindFragment.ImuCalibrationDialog.AnonymousClass4.<clinit>():void");
        }
    }

    enum IMU_states {
        IMU_IDLE,
        IMU_ERROR,
        IMU_START,
        IMU_LEVEL,
        IMU_LEFT,
        IMU_RIGHT,
        IMU_DOWN,
        IMU_UP,
        IMU_BACK,
        IMU_COMPLETE,
        IMU_FAILED
    }

    public interface a {
    }

    public static ImuCalibrationDialog a(String str, a aVar) {
        ImuCalibrationDialog imuCalibrationDialog = new ImuCalibrationDialog();
        imuCalibrationDialog.f12751q = aVar;
        Bundle bundle = new Bundle();
        bundle.putString("remind_view_type", str);
        imuCalibrationDialog.setArguments(bundle);
        return imuCalibrationDialog;
    }

    private void a() {
        en.a aVar = this.f12745k;
        if (aVar != null && !aVar.x().a()) {
            ToastUtils.showShort((CharSequence) this.f12744j.getString(R.string.failed_start_calibration_message));
        }
    }

    private void a(String str) {
        IMU_states iMU_states;
        if (str.contains("level")) {
            this.f12752r.b();
            this.f12753s = 1;
            iMU_states = IMU_states.IMU_LEVEL;
        } else if (str.contains("LEFT")) {
            this.f12753s = 2;
            iMU_states = IMU_states.IMU_LEFT;
        } else if (str.contains("RIGHT")) {
            this.f12753s = 3;
            iMU_states = IMU_states.IMU_RIGHT;
        } else if (str.contains("DOWN")) {
            this.f12753s = 4;
            iMU_states = IMU_states.IMU_DOWN;
        } else if (str.contains("UP")) {
            this.f12753s = 5;
            iMU_states = IMU_states.IMU_UP;
        } else if (str.contains("BACK")) {
            this.f12753s = 6;
            iMU_states = IMU_states.IMU_BACK;
        } else if (str.contains("Calibration successful") || str.contains("Accelerometers calibrated requires reboot")) {
            this.f12753s = 7;
            iMU_states = IMU_states.IMU_COMPLETE;
        } else {
            if (str.contains("Calibration FAILED") || str.contains("Attitude failure")) {
                this.f12752r.b();
                this.f12753s = 8;
                iMU_states = IMU_states.IMU_START;
            }
            c();
            this.f12747m = true;
            this.f12746l = str.replace("any key.", "'Next'");
            a(this.f12753s);
        }
        this.f12750p = iMU_states;
        c();
        this.f12747m = true;
        this.f12746l = str.replace("any key.", "'Next'");
        a(this.f12753s);
    }

    private void a(String str, boolean z2) {
        if (str.contains("Place") || str.contains("Calibration") || str.contains("reboot") || str.contains("Attitude failure")) {
            if (z2) {
                this.f12749o = System.currentTimeMillis();
            }
            this.f12755u = false;
            a(str);
        }
    }

    private void b() {
        this.f12753s = 0;
        this.f12755u = false;
        this.f12750p = IMU_states.IMU_START;
        a(this.f12753s);
        this.f12745k.x().a(false);
    }

    private void b(int i2) {
        this.f12747m = false;
        if (i2 == 0) {
            a();
            this.f12752r.a(3);
            this.f12752r.a(10000);
            this.f12752r.c();
            this.f12749o = System.currentTimeMillis();
        } else if (i2 <= 0 || i2 >= 7) {
            if (i2 == 8) {
                dismiss();
                b();
            } else {
                b();
                dismiss();
            }
            a(0);
        } else {
            c(i2);
        }
    }

    private void b(final String str) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    if (ImuCalibrationDialog.this.f12741g.getVisibility() == 8) {
                        ImuCalibrationDialog.this.f12741g.setVisibility(0);
                    }
                    ImuCalibrationDialog.this.f12741g.setText(str);
                }
            });
        }
    }

    private void c() {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    if (ImuCalibrationDialog.this.f12741g.getVisibility() == 0) {
                        ImuCalibrationDialog.this.f12748n.postDelayed(new Runnable() {
                            public void run() {
                                ImuCalibrationDialog.this.f12741g.setVisibility(8);
                            }
                        }, 3000);
                    }
                }
            });
        }
    }

    private void c(int i2) {
        if (this.f12745k != null && !this.f12755u) {
            this.f12755u = true;
            Log.d("version", "sendAck: ---step====" + i2);
            this.f12745k.x().a(i2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x00e7, code lost:
        r0.setImageResource(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x011a, code lost:
        r10.f12740f.setImageResource(com.cfly.uav_pro.R.drawable.imu_start);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0121, code lost:
        if (r10.f12739e == null) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0123, code lost:
        r0 = new android.text.SpannableString(r1);
        r0.setSpan(new android.text.style.ForegroundColorSpan(android.graphics.Color.parseColor("#1CB7E7")), r1.indexOf("("), r1.length(), 34);
        r10.f12739e.setText(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0147, code lost:
        r0 = r10.f12742h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x014b, code lost:
        if (r0 == null) goto L_0x0177;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x014d, code lost:
        r0.setText(r7);
        r0 = r10.f12753s;
        r2 = 18.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0154, code lost:
        if (r0 != 8) goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0156, code lost:
        r0 = r10.f12742h;
        r3 = -65536;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x015a, code lost:
        r0.setTextColor(r3);
        r0 = r10.f12742h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x015f, code lost:
        r0.setTextSize(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0163, code lost:
        if (r0 != 7) goto L_0x016b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0165, code lost:
        r0 = r10.f12742h;
        r3 = -16711936;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x016b, code lost:
        r10.f12742h.setTextColor(-16777216);
        r0 = r10.f12742h;
        r2 = 12.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0177, code lost:
        r0 = r10.f12738d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0179, code lost:
        if (r0 == null) goto L_0x01a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x017b, code lost:
        if (r11 != 0) goto L_0x0189;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x017d, code lost:
        r0.setVisibility(0);
        r0 = r10.f12738d;
        r2 = com.cfly.uav_pro.R.string.setup_radio_cal_title;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0185, code lost:
        r0.setText(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0189, code lost:
        if (r11 != 7) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x018b, code lost:
        r0.setVisibility(0);
        r0 = r10.f12738d;
        r2 = com.cfly.uav_pro.R.string.button_setup_done;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0194, code lost:
        if (r11 != 8) goto L_0x019f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0196, code lost:
        r0.setVisibility(0);
        r0 = r10.f12738d;
        r2 = com.cfly.uav_pro.R.string.close;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x019f, code lost:
        r0.setVisibility(8);
        r0 = r10.f12738d;
        r2 = com.cfly.uav_pro.R.string.button_setup_next;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x01a8, code lost:
        if (r11 == 7) goto L_0x01c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x01aa, code lost:
        if (r11 == 0) goto L_0x01c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x01ac, code lost:
        if (r11 != 8) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01af, code lost:
        r10.f12748n.removeCallbacks(r10.f12754t);
        r10.f12748n.postDelayed(r10.f12754t, 100);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01c0, code lost:
        r10.f12748n.removeCallbacks(r10.f12754t);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r11) {
        /*
            r10 = this;
            r0 = 2131231708(0x7f0803dc, float:1.8079505E38)
            r1 = 2131821529(0x7f1103d9, float:1.9275804E38)
            r2 = 2
            r3 = 1
            r4 = 0
            r5 = 7
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            switch(r11) {
                case 0: goto L_0x0103;
                case 1: goto L_0x00eb;
                case 2: goto L_0x00cb;
                case 3: goto L_0x00ad;
                case 4: goto L_0x008f;
                case 5: goto L_0x0071;
                case 6: goto L_0x0053;
                case 7: goto L_0x0030;
                case 8: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            return
        L_0x0012:
            com.xeagle.android.XEagleApp r7 = r10.f12743i
            com.xeagle.android.a r7 = r7.m()
            r7.h(r3)
            r7 = 2131821527(0x7f1103d7, float:1.92758E38)
            java.util.Locale r8 = java.util.Locale.US
            java.lang.String r1 = r10.getString(r1)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r6
            r2[r3] = r6
            java.lang.String r1 = java.lang.String.format(r8, r1, r2)
            goto L_0x011a
        L_0x0030:
            r7 = 2131821528(0x7f1103d8, float:1.9275802E38)
            java.util.Locale r8 = java.util.Locale.US
            java.lang.String r1 = r10.getString(r1)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r6
            r2[r3] = r6
            java.lang.String r1 = java.lang.String.format(r8, r1, r2)
            android.widget.ImageView r2 = r10.f12740f
            r2.setImageResource(r0)
            com.xeagle.android.XEagleApp r0 = r10.f12743i
            com.xeagle.android.a r0 = r0.m()
            r0.h(r3)
            goto L_0x011f
        L_0x0053:
            r7 = 2131821524(0x7f1103d4, float:1.9275794E38)
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r1 = r10.getString(r1)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r8 = 6
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r2[r4] = r8
            r2[r3] = r6
            java.lang.String r1 = java.lang.String.format(r0, r1, r2)
            android.widget.ImageView r0 = r10.f12740f
            r2 = 2131231704(0x7f0803d8, float:1.8079497E38)
            goto L_0x00e7
        L_0x0071:
            r7 = 2131821534(0x7f1103de, float:1.9275814E38)
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r1 = r10.getString(r1)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r8 = 5
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r2[r4] = r8
            r2[r3] = r6
            java.lang.String r1 = java.lang.String.format(r0, r1, r2)
            android.widget.ImageView r0 = r10.f12740f
            r2 = 2131231706(0x7f0803da, float:1.80795E38)
            goto L_0x00e7
        L_0x008f:
            r7 = 2131821533(0x7f1103dd, float:1.9275812E38)
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r1 = r10.getString(r1)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r8 = 4
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r2[r4] = r8
            r2[r3] = r6
            java.lang.String r1 = java.lang.String.format(r0, r1, r2)
            android.widget.ImageView r0 = r10.f12740f
            r2 = 2131231709(0x7f0803dd, float:1.8079507E38)
            goto L_0x00e7
        L_0x00ad:
            r7 = 2131821535(0x7f1103df, float:1.9275816E38)
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r1 = r10.getString(r1)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r8 = 3
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r2[r4] = r8
            r2[r3] = r6
            java.lang.String r1 = java.lang.String.format(r0, r1, r2)
            android.widget.ImageView r0 = r10.f12740f
            r2 = 2131231707(0x7f0803db, float:1.8079503E38)
            goto L_0x00e7
        L_0x00cb:
            r7 = 2131821531(0x7f1103db, float:1.9275808E38)
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r1 = r10.getString(r1)
            java.lang.Object[] r8 = new java.lang.Object[r2]
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r8[r4] = r2
            r8[r3] = r6
            java.lang.String r1 = java.lang.String.format(r0, r1, r8)
            android.widget.ImageView r0 = r10.f12740f
            r2 = 2131231705(0x7f0803d9, float:1.8079499E38)
        L_0x00e7:
            r0.setImageResource(r2)
            goto L_0x011f
        L_0x00eb:
            r7 = 2131821532(0x7f1103dc, float:1.927581E38)
            java.util.Locale r8 = java.util.Locale.US
            java.lang.String r1 = r10.getString(r1)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
            r2[r4] = r9
            r2[r3] = r6
            java.lang.String r1 = java.lang.String.format(r8, r1, r2)
            goto L_0x011a
        L_0x0103:
            r7 = 2131822692(0x7f110864, float:1.9278163E38)
            java.util.Locale r8 = java.util.Locale.US
            java.lang.String r1 = r10.getString(r1)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
            r2[r4] = r9
            r2[r3] = r6
            java.lang.String r1 = java.lang.String.format(r8, r1, r2)
        L_0x011a:
            android.widget.ImageView r2 = r10.f12740f
            r2.setImageResource(r0)
        L_0x011f:
            android.widget.TextView r0 = r10.f12739e
            if (r0 == 0) goto L_0x0147
            android.text.SpannableString r0 = new android.text.SpannableString
            r0.<init>(r1)
            android.text.style.ForegroundColorSpan r2 = new android.text.style.ForegroundColorSpan
            java.lang.String r3 = "#1CB7E7"
            int r3 = android.graphics.Color.parseColor(r3)
            r2.<init>(r3)
            java.lang.String r3 = "("
            int r3 = r1.indexOf(r3)
            int r1 = r1.length()
            r6 = 34
            r0.setSpan(r2, r3, r1, r6)
            android.widget.TextView r1 = r10.f12739e
            r1.setText(r0)
        L_0x0147:
            android.widget.TextView r0 = r10.f12742h
            r1 = 8
            if (r0 == 0) goto L_0x0177
            r0.setText(r7)
            int r0 = r10.f12753s
            r2 = 1099956224(0x41900000, float:18.0)
            if (r0 != r1) goto L_0x0163
            android.widget.TextView r0 = r10.f12742h
            r3 = -65536(0xffffffffffff0000, float:NaN)
        L_0x015a:
            r0.setTextColor(r3)
            android.widget.TextView r0 = r10.f12742h
        L_0x015f:
            r0.setTextSize(r2)
            goto L_0x0177
        L_0x0163:
            if (r0 != r5) goto L_0x016b
            android.widget.TextView r0 = r10.f12742h
            r3 = -16711936(0xffffffffff00ff00, float:-1.7146522E38)
            goto L_0x015a
        L_0x016b:
            android.widget.TextView r0 = r10.f12742h
            r2 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0.setTextColor(r2)
            android.widget.TextView r0 = r10.f12742h
            r2 = 1094713344(0x41400000, float:12.0)
            goto L_0x015f
        L_0x0177:
            com.xeagle.android.vjoystick.IWidgets.IButton r0 = r10.f12738d
            if (r0 == 0) goto L_0x01a8
            if (r11 != 0) goto L_0x0189
            r0.setVisibility(r4)
            com.xeagle.android.vjoystick.IWidgets.IButton r0 = r10.f12738d
            r2 = 2131822699(0x7f11086b, float:1.9278177E38)
        L_0x0185:
            r0.setText(r2)
            goto L_0x01a8
        L_0x0189:
            if (r11 != r5) goto L_0x0194
            r0.setVisibility(r4)
            com.xeagle.android.vjoystick.IWidgets.IButton r0 = r10.f12738d
            r2 = 2131820791(0x7f1100f7, float:1.9274307E38)
            goto L_0x0185
        L_0x0194:
            if (r11 != r1) goto L_0x019f
            r0.setVisibility(r4)
            com.xeagle.android.vjoystick.IWidgets.IButton r0 = r10.f12738d
            r2 = 2131820894(0x7f11015e, float:1.9274516E38)
            goto L_0x0185
        L_0x019f:
            r0.setVisibility(r1)
            com.xeagle.android.vjoystick.IWidgets.IButton r0 = r10.f12738d
            r2 = 2131820792(0x7f1100f8, float:1.9274309E38)
            goto L_0x0185
        L_0x01a8:
            if (r11 == r5) goto L_0x01c0
            if (r11 == 0) goto L_0x01c0
            if (r11 != r1) goto L_0x01af
            goto L_0x01c0
        L_0x01af:
            android.os.Handler r11 = r10.f12748n
            java.lang.Runnable r0 = r10.f12754t
            r11.removeCallbacks(r0)
            android.os.Handler r11 = r10.f12748n
            java.lang.Runnable r0 = r10.f12754t
            r1 = 100
            r11.postDelayed(r0, r1)
            goto L_0x01c7
        L_0x01c0:
            android.os.Handler r11 = r10.f12748n
            java.lang.Runnable r0 = r10.f12754t
            r11.removeCallbacks(r0)
        L_0x01c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.newUI.fragment.remindFragment.ImuCalibrationDialog.a(int):void");
    }

    @l(a = ThreadMode.MAIN)
    public void calibrateImuEvent(c cVar) {
        if (cVar.a() == 27) {
            Log.i("msg", "calibrateImuEvent:--- " + this.f12745k.x().c());
            a(this.f12745k.x().c(), true);
        }
    }

    @l(a = ThreadMode.ASYNC)
    public void calibrateTimeoutEvent(d dVar) {
        en.a aVar;
        if (dVar.a() == 28 && (aVar = this.f12745k) != null) {
            com.flypro.core.drone.variables.c x2 = aVar.x();
            if (!x2.d() || !TextUtils.isEmpty(this.f12746l)) {
                ToastUtils.showShort((CharSequence) this.f12746l);
                return;
            }
            x2.a(false);
            org.greenrobot.eventbus.c.a().d(new am(5));
        }
    }

    @l(a = ThreadMode.MAIN)
    public void disConnectedEvent(dy.l lVar) {
        if (lVar.a() == 1) {
            b();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void droneConnectEvent(k kVar) {
        if (kVar.a() == 0 && this.f12753s == 0) {
            b();
            this.f12738d.setEnabled(true);
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void droneVibrationEvent(ac acVar) {
        if (acVar.a() == 69) {
            float a2 = this.f12745k.O().a();
            float b2 = this.f12745k.O().b();
            float c2 = this.f12745k.O().c();
            if ((((double) a2) > 0.8d || ((double) b2) > 0.8d || ((double) c2) > 0.8d) && this.f12756v > 0) {
                this.f12756v = 0;
                if (this.f12753s != 7) {
                    b(this.f12744j.getString(R.string.imu_static_drone));
                    return;
                }
                return;
            }
            c();
        }
    }

    public void notifyTimeOut(int i2) {
        if (i2 < this.f12752r.a()) {
            a();
            this.f12749o = System.currentTimeMillis();
            return;
        }
        a("Calibration FAILED", true);
        this.f12752r.a(false);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f12744j = context;
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.ib_cancel) {
            b();
            dismiss();
        } else if (id2 == R.id.ib_next) {
            b(this.f12753s);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int i2;
        int i3;
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        if (f12736b || window != null) {
            window.setGravity(17);
            create.show();
            int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
            int height = getActivity().getWindowManager().getDefaultDisplay().getHeight();
            if (width >= height) {
                i3 = (width / 3) * 2;
                i2 = height * 4;
            } else {
                i3 = (width * 4) / 5;
                i2 = height * 2;
            }
            window.setLayout(i3, i2 / 5);
            return create;
        }
        throw new AssertionError();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.imu_calibration_dialog, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f12737c = arguments.getString("remind_view_type", "remind");
        }
        XEagleApp xEagleApp = (XEagleApp) this.f12744j.getApplicationContext();
        this.f12743i = xEagleApp;
        this.f12745k = xEagleApp.k();
        this.f12742h = (TextView) inflate.findViewById(R.id.tv_step_description);
        this.f12740f = (ImageView) inflate.findViewById(R.id.iv_step);
        this.f12738d = (IButton) inflate.findViewById(R.id.ib_next);
        this.f12739e = (TextView) inflate.findViewById(R.id.notify_title);
        this.f12741g = (TextView) inflate.findViewById(R.id.tv_warn);
        this.f12752r = new w(this);
        inflate.findViewById(R.id.ib_cancel).setOnClickListener(this);
        this.f12738d.setOnClickListener(this);
        a(0);
        return inflate;
    }

    public void onStart() {
        super.onStart();
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
    }

    public void onStop() {
        super.onStop();
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void updateImuEvent(bc bcVar) {
        Context context;
        String str;
        int i2;
        if (bcVar.a() == 60) {
            float a2 = (float) this.f12745k.I().a();
            float b2 = (float) this.f12745k.I().b();
            float c2 = (float) this.f12745k.I().c();
            if (a2 < -200.0f || a2 > 200.0f || b2 < -200.0f || b2 > 200.0f || c2 < -1040.0f || c2 > -940.0f) {
                if (a2 < -200.0f || a2 > 200.0f || b2 < 940.0f || b2 > 1040.0f || c2 < -200.0f || c2 > 200.0f) {
                    if (a2 < -200.0f || a2 > 200.0f || b2 < -1040.0f || b2 > -940.0f || c2 < -200.0f || c2 > 200.0f) {
                        if (a2 < -1040.0f || a2 > -940.0f || b2 < -200.0f || b2 > 200.0f || c2 < -200.0f || c2 > 200.0f) {
                            if (a2 < 940.0f || a2 > 1040.0f || b2 < -200.0f || b2 > 200.0f || c2 < -200.0f || c2 > 200.0f) {
                                if (a2 < -200.0f || a2 > 200.0f || b2 < -200.0f || b2 > 200.0f || c2 < 940.0f || c2 > 1040.0f) {
                                    this.f12756v = 0;
                                    int i3 = AnonymousClass4.f24014a[this.f12750p.ordinal()];
                                    int i4 = R.string.imu_turn_left;
                                    if (i3 == 1) {
                                        if (c2 <= 200.0f) {
                                            if (c2 >= -200.0f) {
                                                return;
                                            }
                                            context = this.f12744j;
                                        }
                                        str = this.f12744j.getString(R.string.imu_turn_right);
                                        b(str);
                                        return;
                                    } else if (i3 == 2) {
                                        if (c2 >= -200.0f) {
                                            if (c2 <= 200.0f) {
                                                return;
                                            }
                                            context = this.f12744j;
                                        }
                                        str = this.f12744j.getString(R.string.imu_turn_right);
                                        b(str);
                                        return;
                                    } else if (i3 != 3 && i3 != 4) {
                                        return;
                                    } else {
                                        if (c2 > 200.0f || c2 < -200.0f) {
                                            context = this.f12744j;
                                            i4 = R.string.imu_go_straight;
                                        } else {
                                            return;
                                        }
                                    }
                                    str = context.getString(i4);
                                    b(str);
                                    return;
                                } else if (this.f12750p == IMU_states.IMU_BACK) {
                                    int i5 = this.f12756v + 1;
                                    this.f12756v = i5;
                                    if (i5 > 2) {
                                        i2 = 6;
                                    } else {
                                        return;
                                    }
                                }
                            } else if (this.f12750p == IMU_states.IMU_UP) {
                                int i6 = this.f12756v + 1;
                                this.f12756v = i6;
                                if (i6 > 2) {
                                    i2 = 5;
                                } else {
                                    return;
                                }
                            }
                            c(i2);
                        } else if (this.f12750p == IMU_states.IMU_DOWN) {
                            int i7 = this.f12756v + 1;
                            this.f12756v = i7;
                            if (i7 > 2) {
                                c(4);
                            } else {
                                return;
                            }
                        }
                    } else if (this.f12750p == IMU_states.IMU_RIGHT) {
                        int i8 = this.f12756v + 1;
                        this.f12756v = i8;
                        if (i8 > 2) {
                            c(3);
                        } else {
                            return;
                        }
                    }
                } else if (this.f12750p == IMU_states.IMU_LEFT) {
                    int i9 = this.f12756v + 1;
                    this.f12756v = i9;
                    if (i9 > 2) {
                        c(2);
                    } else {
                        return;
                    }
                }
            } else if (this.f12750p == IMU_states.IMU_LEVEL) {
                int i10 = this.f12756v + 1;
                this.f12756v = i10;
                if (i10 > 2) {
                    c(1);
                } else {
                    return;
                }
            }
            this.f12756v = 0;
        }
    }
}
