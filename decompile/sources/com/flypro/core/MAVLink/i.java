package com.flypro.core.MAVLink;

import android.content.Context;
import com.MAVLink.common.msg_heartbeat;
import ec.b;
import en.a;

public class i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f11520a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f11521b;

    /* renamed from: c  reason: collision with root package name */
    private int f11522c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f11523d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f11524e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f11525f = false;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f11526g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f11527h = 0;

    /* renamed from: i  reason: collision with root package name */
    private boolean f11528i = false;

    /* renamed from: j  reason: collision with root package name */
    private long f11529j = 0;

    /* renamed from: k  reason: collision with root package name */
    private b f11530k = new b();

    public i(a aVar, Context context) {
        this.f11520a = aVar;
        this.f11521b = context;
    }

    private void b(msg_heartbeat msg_heartbeat) {
        byte b2 = msg_heartbeat.f6736h;
    }

    private void c(msg_heartbeat msg_heartbeat) {
        if ((msg_heartbeat.f6735g & Byte.MIN_VALUE) == Byte.MIN_VALUE) {
            this.f11520a.d().a(1);
        } else {
            this.f11520a.d().a(0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:285:0x0aac, code lost:
        r0.d(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x0aef, code lost:
        r13.d(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:331:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.MAVLink.Messages.MAVLinkMessage r13) {
        /*
            r12 = this;
            en.a r0 = r12.f11520a
            dz.a r0 = r0.e()
            r0.a((com.MAVLink.Messages.MAVLinkMessage) r13)
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.ae r0 = r0.N()
            r0.a((com.MAVLink.Messages.MAVLinkMessage) r13)
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.c r0 = r0.x()
            r0.a((com.MAVLink.Messages.MAVLinkMessage) r13)
            int r0 = r13.f6280c
            r1 = 3
            r2 = 4
            r3 = 0
            r4 = 4711630319722168320(0x416312d000000000, double:1.0E7)
            r6 = 1
            switch(r0) {
                case 0: goto L_0x0ab0;
                case 8: goto L_0x0a8e;
                case 10: goto L_0x0a6c;
                case 12: goto L_0x0a0c;
                case 15: goto L_0x095f;
                case 17: goto L_0x0952;
                case 27: goto L_0x0933;
                case 30: goto L_0x08ff;
                case 35: goto L_0x08f2;
                case 36: goto L_0x08e5;
                case 42: goto L_0x08d6;
                case 44: goto L_0x08d2;
                case 47: goto L_0x08c3;
                case 62: goto L_0x08a2;
                case 72: goto L_0x0808;
                case 77: goto L_0x07f9;
                case 116: goto L_0x07f5;
                case 150: goto L_0x07da;
                case 158: goto L_0x07cd;
                case 241: goto L_0x07ba;
                case 253: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0af2
        L_0x002b:
            com.MAVLink.common.msg_statustext r13 = (com.MAVLink.common.msg_statustext) r13
            java.lang.String r0 = r13.a()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "text:----"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "version"
            android.util.Log.i(r5, r4)
            byte r4 = r13.f7267d
            if (r4 == r1) goto L_0x07a3
            byte r13 = r13.f7267d
            if (r13 != r2) goto L_0x0051
            goto L_0x07a3
        L_0x0051:
            java.lang.String r13 = "Low Battery!"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x006c
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.low_battery_warn
        L_0x0063:
            java.lang.String r0 = r0.getString(r1)
            r13.d(r0)
            goto L_0x0af2
        L_0x006c:
            java.lang.String r13 = "FLIGHT-DF"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0098
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r1 = "receiveData: --->>>>"
            r13.append(r1)
            r1 = 7
            java.lang.String r2 = r0.substring(r1)
            r13.append(r2)
            java.lang.String r13 = r13.toString()
            android.util.Log.i(r5, r13)
            en.a r13 = r12.f11520a
            java.lang.String r0 = r0.substring(r1)
            r13.a((java.lang.String) r0)
            goto L_0x0af2
        L_0x0098:
            java.lang.String r13 = "FLIGHT-S-DF816"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x00a9
            en.a r13 = r12.f11520a
            java.lang.String r0 = "DF816-S-v5.0-2021.8.12"
            r13.a((java.lang.String) r0)
            java.lang.String r0 = "FLIGHT-DF816-S-v5.0-2021.8.12"
        L_0x00a9:
            java.lang.String r13 = "PX"
            boolean r13 = r0.contains(r13)
            if (r13 != 0) goto L_0x0af2
            java.lang.String r13 = "Frame"
            boolean r13 = r0.contains(r13)
            if (r13 != 0) goto L_0x0af2
            java.lang.String r13 = "blox"
            boolean r13 = r0.contains(r13)
            if (r13 != 0) goto L_0x0af2
            java.lang.String r13 = r0.toLowerCase()
            java.lang.String r1 = "apm"
            boolean r13 = r13.contains(r1)
            if (r13 != 0) goto L_0x0af2
            java.lang.String r13 = "Flight plan"
            boolean r13 = r0.contains(r13)
            if (r13 != 0) goto L_0x0af2
            java.lang.String r13 = "Imu0"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x00df
            goto L_0x0af2
        L_0x00df:
            java.lang.String r13 = "Ready to take off"
            boolean r13 = r0.contains(r13)
            java.lang.String r1 = ""
            if (r13 == 0) goto L_0x013c
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            boolean r13 = r13.d()
            if (r13 != 0) goto L_0x0af2
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            java.lang.String r13 = r13.g()
            boolean r13 = r13.equals(r1)
            if (r13 != 0) goto L_0x0117
        L_0x0105:
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.ready_take_off
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            goto L_0x0124
        L_0x0117:
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            boolean r13 = r13.i()
            if (r13 != 0) goto L_0x0124
            goto L_0x0105
        L_0x0124:
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            long r0 = java.lang.System.currentTimeMillis()
            r13.a((long) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            r13.a((boolean) r6)
            goto L_0x0af2
        L_0x013c:
            java.lang.String r13 = "RC not calibrated"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0161
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_rc_cal
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_rc_cal_detail
            goto L_0x0063
        L_0x0161:
            java.lang.String r13 = "Barometer not healthy"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0186
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_baro_hel
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_baro_hel_detail
            goto L_0x0063
        L_0x0186:
            java.lang.String r13 = "Altitude disparity"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x01ab
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_alt_display
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_alt_display_detail
            goto L_0x0063
        L_0x01ab:
            java.lang.String r13 = "Compass not healthy"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x01d0
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_comp_hel
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_comp_hel_detail
            goto L_0x0063
        L_0x01d0:
            java.lang.String r13 = "Compass not calibrated"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x01f5
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_comp_cal
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_comp_cal_detail
            goto L_0x0063
        L_0x01f5:
            java.lang.String r13 = "Compass offsets too high"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x021a
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_comp_offset
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_comp_offset_detail
            goto L_0x0063
        L_0x021a:
            java.lang.String r13 = "Check mag field"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x023f
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.compass_variance
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.compass_variance
            goto L_0x0063
        L_0x023f:
            java.lang.String r13 = "Accels not calibrated"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x026b
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_acc_cal
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_acc_cal_detail
        L_0x0262:
            java.lang.String r0 = r0.getString(r1)
            r13.c(r0)
            goto L_0x0af2
        L_0x026b:
            java.lang.String r13 = "Accelerometers not healthy"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0290
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_acc_hel
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_acc_hel_detail
            goto L_0x0063
        L_0x0290:
            java.lang.String r13 = "Gyros not healthy"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x02b5
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_gyro_hel
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_gyro_hel_detail
            goto L_0x0063
        L_0x02b5:
            java.lang.String r13 = "gimb motor failure"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x02bf
            goto L_0x0af2
        L_0x02bf:
            java.lang.String r13 = "Check Battery"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x02e4
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_che_bat_detail
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_che_bat_detail
            goto L_0x0063
        L_0x02e4:
            java.lang.String r13 = "Throttle below Failsafe"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0309
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_thr_fs
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.prearm_thr_fs_detail
            goto L_0x0063
        L_0x0309:
            java.lang.String r13 = "Bad AHR"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x032e
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.bad_ahs_error
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.bad_ahs_error
            goto L_0x0063
        L_0x032e:
            java.lang.String r13 = "Beginner Mode"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0353
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.fence_beginner_mode
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.fence_beginner_mode_detail
            goto L_0x0063
        L_0x0353:
            java.lang.String r13 = "Attitude failure"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0378
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.attitude_failure
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.attitude_failure
            goto L_0x0063
        L_0x0378:
            java.lang.String r13 = "Accelerometers calibrated requires reboot"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x03a4
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.acc_cal_reboot
            java.lang.String r0 = r0.getString(r1)
            r13.d(r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.acc_cal_reboot
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            goto L_0x0af2
        L_0x03a4:
            java.lang.String r13 = "compass variance"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x03f7
            boolean r13 = r12.f11524e
            if (r13 != 0) goto L_0x03c0
            r12.f11524e = r6
            r12.f11523d = r6
            ec.b r13 = r12.f11530k
            com.flypro.core.MAVLink.i$1 r0 = new com.flypro.core.MAVLink.i$1
            r0.<init>()
            r1 = 10000(0x2710, double:4.9407E-320)
            r13.a(r0, r1)
        L_0x03c0:
            boolean r13 = r12.f11524e
            if (r13 == 0) goto L_0x0af2
            int r13 = r12.f11523d
            r0 = 8
            if (r13 >= r0) goto L_0x03cf
            int r13 = r13 + r6
            r12.f11523d = r13
            goto L_0x0af2
        L_0x03cf:
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.compass_variance
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.compass_variance
            java.lang.String r0 = r0.getString(r1)
            r13.d(r0)
            r12.f11523d = r3
            r12.f11524e = r3
            goto L_0x0af2
        L_0x03f7:
            java.lang.String r13 = "flow invalid"
            boolean r13 = r0.contains(r13)
            r2 = 3000(0xbb8, double:1.482E-320)
            if (r13 == 0) goto L_0x041e
            boolean r13 = r12.f11525f
            if (r13 != 0) goto L_0x0413
            r12.f11525f = r6
            r12.f11526g = r6
            ec.b r13 = r12.f11530k
            com.flypro.core.MAVLink.i$2 r0 = new com.flypro.core.MAVLink.i$2
            r0.<init>()
            r13.a(r0, r2)
        L_0x0413:
            boolean r13 = r12.f11525f
            if (r13 == 0) goto L_0x0af2
            int r13 = r12.f11526g
            int r13 = r13 + r6
            r12.f11526g = r13
            goto L_0x0af2
        L_0x041e:
            java.lang.String r13 = "flow valid"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x044f
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            java.lang.String r13 = r13.g()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.flow_invalid
            java.lang.String r0 = r0.getString(r1)
            boolean r13 = r13.contains(r0)
            if (r13 == 0) goto L_0x0af2
            int r13 = r12.f11527h
            int r13 = r13 + r6
            r12.f11527h = r13
            ec.b r13 = r12.f11530k
            com.flypro.core.MAVLink.i$3 r0 = new com.flypro.core.MAVLink.i$3
            r0.<init>()
            r13.a(r0, r2)
            goto L_0x0af2
        L_0x044f:
            java.lang.String r13 = "Beyond the radius limit"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x046a
            org.greenrobot.eventbus.c r13 = org.greenrobot.eventbus.c.a()
            dy.a r0 = new dy.a
            android.content.Context r1 = r12.f11521b
            int r2 = com.flypro.core.R.string.beyond_radius
            java.lang.String r1 = r1.getString(r2)
            r0.<init>(r1)
            goto L_0x0aef
        L_0x046a:
            java.lang.String r13 = "PreArm: gimb init"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x04a3
            boolean r13 = r12.f11528i
            if (r13 != 0) goto L_0x048a
            r12.f11528i = r6
            long r0 = java.lang.System.currentTimeMillis()
            r12.f11529j = r0
        L_0x047e:
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.gimbal_init
            goto L_0x0063
        L_0x048a:
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = r12.f11529j
            long r0 = r0 - r2
            r2 = 30000(0x7530, double:1.4822E-319)
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 < 0) goto L_0x047e
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.gimbal_tips
            goto L_0x0063
        L_0x04a3:
            java.lang.String r13 = "PreArm: battery invalid"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x04b7
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.battert_invalid
            goto L_0x0063
        L_0x04b7:
            java.lang.String r13 = "single ok"
            boolean r2 = r0.contains(r13)
            if (r2 == 0) goto L_0x04ca
            org.greenrobot.eventbus.c r0 = org.greenrobot.eventbus.c.a()
            dy.e r1 = new dy.e
            r1.<init>(r13)
            goto L_0x0aac
        L_0x04ca:
            java.lang.String r13 = "Mode not arm"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x04ef
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.mode_not_arm
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.mode_not_arm
            goto L_0x0063
        L_0x04ef:
            java.lang.String r13 = "set height success"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0503
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.rtl_height_success_detail
            goto L_0x0262
        L_0x0503:
            java.lang.String r13 = "Invalid height setting"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0517
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.rtl_height_invalid_detail
            goto L_0x0063
        L_0x0517:
            java.lang.String r13 = "Exceeds safe rtl height"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x052b
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.rtl_height_exceeds_detail
            goto L_0x0063
        L_0x052b:
            java.lang.String r13 = "set battery time"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x053f
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.set_battery_time_detail
            goto L_0x0063
        L_0x053f:
            java.lang.String r13 = "set battery earse"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0549
            goto L_0x0af2
        L_0x0549:
            java.lang.String r13 = "set battery sn"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x055d
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.set_battery_sn_detail
            goto L_0x0063
        L_0x055d:
            java.lang.String r13 = "set drone sn"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0571
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.set_drone_sn_detail
            goto L_0x0063
        L_0x0571:
            java.lang.String r13 = "set drone time"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0585
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.set_drone_time_detail
            goto L_0x0063
        L_0x0585:
            java.lang.String r13 = "Home is lock"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0599
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.set_rtl_home_success
            goto L_0x0262
        L_0x0599:
            java.lang.String r13 = "Set speed success"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x05ad
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.level_speed_success
            goto L_0x0262
        L_0x05ad:
            java.lang.String r13 = "Set up_sp success"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x05c1
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.up_speed_success
            goto L_0x0262
        L_0x05c1:
            java.lang.String r13 = "Set dw_sp success"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x05d5
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.down_speed_success
            goto L_0x0262
        L_0x05d5:
            java.lang.String r13 = "Beginner not set"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x05e9
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.beginner_not_set
            goto L_0x0063
        L_0x05e9:
            java.lang.String r13 = "Cancel RTL success"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x060e
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.cancel_rtl_success
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.cancel_rtl_success
            goto L_0x0063
        L_0x060e:
            java.lang.String r13 = "Cancel RTL error"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0633
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.cancel_rtl_error
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.cancel_rtl_error
            goto L_0x0063
        L_0x0633:
            java.lang.String r13 = "End of countdown"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0647
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.end_of_countdown
            goto L_0x0063
        L_0x0647:
            java.lang.String r13 = "Countdown error"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x065b
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.count_down_error
            goto L_0x0063
        L_0x065b:
            java.lang.String r13 = "Need GPS positioning is required"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x066f
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.set_rtl_home_fail_gps
            goto L_0x0063
        L_0x066f:
            java.lang.String r13 = "Not enough power to new position"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0683
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.set_rtl_home_fail_power
            goto L_0x0063
        L_0x0683:
            java.lang.String r13 = "Althold limit hight"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0697
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.althold_limit_warn
            goto L_0x0262
        L_0x0697:
            java.lang.String r13 = "The wind is too large"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x06bc
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.wind_too_high
            java.lang.String r0 = r0.getString(r1)
            r13.a((java.lang.String) r0)
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.wind_too_high
            goto L_0x0262
        L_0x06bc:
            java.lang.String r13 = "Battery unactivated"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x06d0
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.battery_unactivated
            goto L_0x0063
        L_0x06d0:
            java.lang.String r13 = "Unknown battery type"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x06e4
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.unknown_battery
            goto L_0x0063
        L_0x06e4:
            java.lang.String r13 = "Drone unactivated"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x06f8
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.drone_unactived
            goto L_0x0063
        L_0x06f8:
            java.lang.String r13 = "The vibration is too large"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x070c
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.vibration_large_detail
            goto L_0x0262
        L_0x070c:
            java.lang.String r13 = "The power is saturated on RTL"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0720
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.rtl_power_saturated
            goto L_0x0262
        L_0x0720:
            java.lang.String r13 = "GPS not locked"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0734
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.gps_not_locked
            goto L_0x0262
        L_0x0734:
            java.lang.String r13 = "Optical flow invalid"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0748
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.optical_flow_invalid
            goto L_0x0262
        L_0x0748:
            java.lang.String r13 = "GPS satellites are few"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x075c
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.gps_satellites_few
            goto L_0x0262
        L_0x075c:
            java.lang.String r13 = "The drone early return"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0770
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.drone_early_rtl
            goto L_0x0262
        L_0x0770:
            java.lang.String r13 = "Not take photo"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0784
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.not_take_photo
            goto L_0x0262
        L_0x0784:
            java.lang.String r13 = "Not take vedio"
            boolean r13 = r0.contains(r13)
            if (r13 == 0) goto L_0x0798
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            android.content.Context r0 = r12.f11521b
            int r1 = com.flypro.core.R.string.not_take_video
            goto L_0x0262
        L_0x0798:
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            r13.a((java.lang.String) r1)
            goto L_0x0af2
        L_0x07a3:
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            boolean r13 = r13.d()
            if (r13 != 0) goto L_0x0af2
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.aa r13 = r13.d()
            r13.a((boolean) r3)
            goto L_0x0af2
        L_0x07ba:
            com.MAVLink.common.msg_vibration r13 = (com.MAVLink.common.msg_vibration) r13
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.i r0 = r0.O()
            float r1 = r13.f7314e
            float r2 = r13.f7315f
            float r13 = r13.f7316g
            r0.a(r1, r2, r13)
            goto L_0x0af2
        L_0x07cd:
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.d r0 = r0.K()
            com.MAVLink.ardupilotmega.msg_mount_status r13 = (com.MAVLink.ardupilotmega.msg_mount_status) r13
            r0.a(r13)
            goto L_0x0af2
        L_0x07da:
            com.MAVLink.ardupilotmega.msg_sensor_offsets r13 = (com.MAVLink.ardupilotmega.msg_sensor_offsets) r13
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.ListenerData r0 = r0.Q()
            int r1 = r13.f6465e
            double r1 = (double) r1
            r0.u(r1)
            org.greenrobot.eventbus.c r0 = org.greenrobot.eventbus.c.a()
            dy.v r1 = new dy.v
            int r13 = r13.f6465e
            r1.<init>(r13)
            goto L_0x0aac
        L_0x07f5:
            com.MAVLink.common.msg_scaled_imu2 r13 = (com.MAVLink.common.msg_scaled_imu2) r13
            goto L_0x0af2
        L_0x07f9:
            com.MAVLink.common.msg_command_ack r13 = (com.MAVLink.common.msg_command_ack) r13
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.e r0 = r0.C()
            byte r13 = r13.f6565e
            r0.a(r13)
            goto L_0x0af2
        L_0x0808:
            com.MAVLink.common.msg_data_add_msg r13 = (com.MAVLink.common.msg_data_add_msg) r13
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.k r0 = r0.F()
            byte r1 = r13.f6599g
            r1 = r1 & 255(0xff, float:3.57E-43)
            double r3 = (double) r1
            r7 = 4621819117588971520(0x4024000000000000, double:10.0)
            java.lang.Double.isNaN(r3)
            double r3 = r3 / r7
            r0.a(r3)
            en.a r0 = r12.f11520a
            java.lang.String r0 = r0.y()
            if (r0 == 0) goto L_0x0879
            en.a r0 = r12.f11520a
            java.lang.String r0 = r0.y()
            java.lang.String r1 = "v"
            int r3 = r0.indexOf(r1)
            int r3 = r3 + r6
            int r1 = r0.indexOf(r1)
            int r1 = r1 + r2
            java.lang.String r0 = r0.substring(r3, r1)
            double r0 = java.lang.Double.parseDouble(r0)
            r2 = 4612811918334230528(0x4004000000000000, double:2.5)
            r4 = 4613712638259704627(0x4007333333333333, double:2.9)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 < 0) goto L_0x085f
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x085f
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.z r0 = r0.G()
            byte r1 = r13.f6598f
            r1 = r1 & 255(0xff, float:3.57E-43)
            double r1 = (double) r1
            java.lang.Double.isNaN(r1)
            double r1 = r1 / r7
            goto L_0x088a
        L_0x085f:
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.z r0 = r0.G()
            if (r2 < 0) goto L_0x0873
            short r1 = r13.f6596d
            double r1 = (double) r1
            java.lang.Double.isNaN(r1)
            double r1 = r1 / r7
            byte r3 = r13.f6598f
            goto L_0x088c
        L_0x0873:
            byte r1 = r13.f6598f
            r1 = r1 & 255(0xff, float:3.57E-43)
            double r1 = (double) r1
            goto L_0x088a
        L_0x0879:
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.z r0 = r0.G()
            byte r1 = r13.f6598f
            r1 = r1 & 255(0xff, float:3.57E-43)
            double r1 = (double) r1
            java.lang.Double.isNaN(r1)
            double r1 = r1 / r7
            double r1 = r1 * r7
        L_0x088a:
            short r3 = r13.f6596d
        L_0x088c:
            double r3 = (double) r3
            java.lang.Double.isNaN(r3)
            double r3 = r3 / r7
            r0.a(r1, r3)
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.af r0 = r0.H()
            short r13 = r13.f6597e
            double r1 = (double) r13
            r0.a(r1)
            goto L_0x0af2
        L_0x08a2:
            com.MAVLink.common.msg_nav_controller_output r13 = (com.MAVLink.common.msg_nav_controller_output) r13
            en.a r0 = r12.f11520a
            short r1 = r13.f6990k
            double r1 = (double) r1
            float r3 = r13.f6985f
            double r3 = (double) r3
            float r5 = r13.f6986g
            double r5 = (double) r5
            r0.a(r1, r3, r5)
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.q r0 = r0.v()
            float r1 = r13.f6984e
            float r2 = r13.f6983d
            short r13 = r13.f6988i
            r0.a(r1, r2, r13)
            goto L_0x0af2
        L_0x08c3:
            com.MAVLink.common.msg_mission_ack r13 = (com.MAVLink.common.msg_mission_ack) r13
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.o r0 = r0.M()
            byte r13 = r13.f6924f
            r0.a(r13)
            goto L_0x0af2
        L_0x08d2:
            com.MAVLink.common.msg_mission_count r13 = (com.MAVLink.common.msg_mission_count) r13
            goto L_0x0af2
        L_0x08d6:
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.p r0 = r0.s()
            com.MAVLink.common.msg_mission_current r13 = (com.MAVLink.common.msg_mission_current) r13
            short r13 = r13.f6930d
            r0.a((short) r13)
            goto L_0x0af2
        L_0x08e5:
            com.MAVLink.common.msg_servo_output_raw r13 = (com.MAVLink.common.msg_servo_output_raw) r13
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.s r0 = r0.m()
            r0.a((com.MAVLink.common.msg_servo_output_raw) r13)
            goto L_0x0af2
        L_0x08f2:
            com.MAVLink.common.msg_rc_channels_raw r13 = (com.MAVLink.common.msg_rc_channels_raw) r13
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.s r0 = r0.m()
            r0.a((com.MAVLink.common.msg_rc_channels_raw) r13)
            goto L_0x0af2
        L_0x08ff:
            com.MAVLink.common.msg_attitude r13 = (com.MAVLink.common.msg_attitude) r13
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.r r1 = r0.u()
            float r0 = r13.f6517e
            double r2 = (double) r0
            r4 = 4640537203540230144(0x4066800000000000, double:180.0)
            java.lang.Double.isNaN(r2)
            double r2 = r2 * r4
            r6 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r2 = r2 / r6
            float r0 = r13.f6518f
            double r8 = (double) r0
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r4
            double r8 = r8 / r6
            float r13 = r13.f6519g
            double r10 = (double) r13
            java.lang.Double.isNaN(r10)
            double r10 = r10 * r4
            double r6 = r10 / r6
            r4 = r8
            r1.a(r2, r4, r6)
            goto L_0x0af2
        L_0x0933:
            com.MAVLink.common.msg_raw_imu r13 = (com.MAVLink.common.msg_raw_imu) r13
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.u r1 = r0.I()
            short r2 = r13.f7060e
            short r3 = r13.f7061f
            short r4 = r13.f7062g
            short r5 = r13.f7063h
            short r6 = r13.f7064i
            short r7 = r13.f7065j
            short r8 = r13.f7066k
            short r9 = r13.f7067l
            short r10 = r13.f7068m
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x0af2
        L_0x0952:
            com.MAVLink.common.msg_complex_data r13 = (com.MAVLink.common.msg_complex_data) r13
            org.greenrobot.eventbus.c r0 = org.greenrobot.eventbus.c.a()
            dy.f r1 = new dy.f
            r1.<init>(r13)
            goto L_0x0aac
        L_0x095f:
            com.MAVLink.common.msg_attachment2 r13 = (com.MAVLink.common.msg_attachment2) r13
            byte r0 = r13.f6515o
            if (r0 != r1) goto L_0x09b3
            byte r0 = r13.f6514n
            r2 = 2
            if (r0 != r2) goto L_0x09b3
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.g r0 = r0.S()
            byte r1 = r13.f6514n
            r0.c(r1)
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.g r0 = r0.S()
            byte r1 = r13.f6515o
            r0.b(r1)
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.g r0 = r0.S()
            int r1 = r13.f6504d
            int r2 = r13.f6505e
            int r3 = r13.f6506f
            r0.a(r1, r2, r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "receiveData:===time=== "
            r0.append(r1)
            int r1 = r13.f6507g
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Drone"
            android.util.Log.i(r1, r0)
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.g r0 = r0.S()
        L_0x09ad:
            int r1 = r13.f6507g
            r0.d(r1)
            goto L_0x0a08
        L_0x09b3:
            byte r0 = r13.f6515o
            if (r0 != r1) goto L_0x0a08
            byte r0 = r13.f6514n
            if (r0 != r6) goto L_0x0a08
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.g r0 = r0.T()
            byte r1 = r13.f6514n
            r0.c(r1)
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.g r0 = r0.T()
            byte r1 = r13.f6515o
            r0.b(r1)
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.g r0 = r0.T()
            int r1 = r13.f6506f
            r0.a(r1)
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.g r0 = r0.T()
            int r1 = r13.f6504d
            int r2 = r13.f6505e
            int r3 = r13.f6506f
            r0.a(r1, r2, r3)
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.g r0 = r0.T()
            int r1 = r13.f6510j
            r0.e(r1)
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.g r0 = r0.T()
            int r1 = r13.f6511k
            r0.f(r1)
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.g r0 = r0.T()
            goto L_0x09ad
        L_0x0a08:
            int r13 = r13.f6507g
            goto L_0x0af2
        L_0x0a0c:
            com.MAVLink.common.msg_data_msg r13 = (com.MAVLink.common.msg_data_msg) r13
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.j r0 = r0.b()
            byte r1 = r13.f6605h
            r0.a((int) r1)
            en.a r0 = r12.f11520a
            short r1 = r13.f6603f
            double r1 = (double) r1
            r0.a((double) r1)
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.b r0 = r0.o()
            short r1 = r13.f6604g
            double r1 = (double) r1
            r0.a(r1)
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.v r0 = r0.E()
            byte r1 = r13.f6606i
            r0.a(r1)
            int r0 = r13.f6601d
            double r0 = (double) r0
            java.lang.Double.isNaN(r0)
            double r0 = r0 / r4
            int r13 = r13.f6602e
            double r2 = (double) r13
            java.lang.Double.isNaN(r2)
            double r2 = r2 / r4
            r4 = 0
            int r13 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0a60
            int r13 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0a60
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.j r13 = r13.b()
            ef.a r4 = new ef.a
            r4.<init>(r0, r2)
            r13.a((ef.a) r4)
            goto L_0x0af2
        L_0x0a60:
            en.a r13 = r12.f11520a
            com.flypro.core.drone.variables.j r13 = r13.b()
            r0 = 0
            r13.a((ef.a) r0)
            goto L_0x0af2
        L_0x0a6c:
            com.MAVLink.common.msg_attachment r13 = (com.MAVLink.common.msg_attachment) r13
            byte r0 = r13.f6503l
            if (r0 == r6) goto L_0x0a76
            byte r0 = r13.f6503l
            if (r0 != 0) goto L_0x0af2
        L_0x0a76:
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.f r0 = r0.R()
            int r1 = r13.f6495d
            double r1 = (double) r1
            java.lang.Double.isNaN(r1)
            double r1 = r1 / r4
            int r13 = r13.f6496e
            double r6 = (double) r13
            java.lang.Double.isNaN(r6)
            double r6 = r6 / r4
            r0.a(r1, r6)
            goto L_0x0af2
        L_0x0a8e:
            com.MAVLink.common.msg_sonar_dug r13 = (com.MAVLink.common.msg_sonar_dug) r13
            com.flypro.core.util.a r0 = com.flypro.core.util.a.a()
            r0.a((com.MAVLink.common.msg_sonar_dug) r13)
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.ListenerData r0 = r0.Q()
            short r1 = r13.f7259d
            double r1 = (double) r1
            r0.v(r1)
            org.greenrobot.eventbus.c r0 = org.greenrobot.eventbus.c.a()
            dy.ba r1 = new dy.ba
            r1.<init>(r13)
        L_0x0aac:
            r0.d(r1)
            goto L_0x0af2
        L_0x0ab0:
            com.MAVLink.common.msg_heartbeat r13 = (com.MAVLink.common.msg_heartbeat) r13
            en.a r0 = r12.f11520a
            byte r1 = r13.f6733e
            r0.a((int) r1)
            byte r0 = r13.f6736h
            if (r0 != r2) goto L_0x0abe
            r3 = 1
        L_0x0abe:
            en.a r0 = r12.f11520a
            com.flypro.core.drone.variables.aa r0 = r0.d()
            r0.b((boolean) r3)
            r12.a((com.MAVLink.common.msg_heartbeat) r13)
            int r0 = r13.f6732d
            en.a r1 = r12.f11520a
            int r1 = r1.f()
            com.MAVLink.Messages.ApmModes r0 = com.MAVLink.Messages.ApmModes.a(r0, r1)
            en.a r1 = r12.f11520a
            com.flypro.core.drone.variables.aa r1 = r1.d()
            r1.a((com.MAVLink.Messages.ApmModes) r0)
            en.a r0 = r12.f11520a
            r0.a((com.MAVLink.common.msg_heartbeat) r13)
            org.greenrobot.eventbus.c r13 = org.greenrobot.eventbus.c.a()
            dy.ax r0 = new dy.ax
            r1 = 67
            r0.<init>(r1)
        L_0x0aef:
            r13.d(r0)
        L_0x0af2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flypro.core.MAVLink.i.a(com.MAVLink.Messages.MAVLinkMessage):void");
    }

    public void a(msg_heartbeat msg_heartbeat) {
        c(msg_heartbeat);
        b(msg_heartbeat);
    }
}
