package com.flypro.core.drone.variables.helpers;

import com.MAVLink.common.msg_raw_imu;
import com.MAVLink.common.msg_scaled_imu2;
import com.flypro.core.drone.d;
import com.flypro.core.parameters.Parameter;
import dy.r;
import org.greenrobot.eventbus.c;

public class FMStateMachine extends d {

    /* renamed from: a  reason: collision with root package name */
    private boolean f14316a;

    /* renamed from: c  reason: collision with root package name */
    private int f14317c;

    /* renamed from: d  reason: collision with root package name */
    private int f14318d;

    /* renamed from: e  reason: collision with root package name */
    private int f14319e;

    /* renamed from: f  reason: collision with root package name */
    private int f14320f;

    /* renamed from: g  reason: collision with root package name */
    private int f14321g;

    /* renamed from: h  reason: collision with root package name */
    private int f14322h;

    /* renamed from: i  reason: collision with root package name */
    private float f14323i;

    /* renamed from: j  reason: collision with root package name */
    private float f14324j;

    /* renamed from: k  reason: collision with root package name */
    private float f14325k;

    /* renamed from: l  reason: collision with root package name */
    private float f14326l;

    /* renamed from: m  reason: collision with root package name */
    private float f14327m;

    /* renamed from: n  reason: collision with root package name */
    private float f14328n;

    /* renamed from: o  reason: collision with root package name */
    private int f14329o;

    /* renamed from: p  reason: collision with root package name */
    private int f14330p;

    /* renamed from: q  reason: collision with root package name */
    private int f14331q;

    /* renamed from: r  reason: collision with root package name */
    private int f14332r;

    /* renamed from: s  reason: collision with root package name */
    private int f14333s;

    /* renamed from: t  reason: collision with root package name */
    private int f14334t;

    /* renamed from: u  reason: collision with root package name */
    private int f14335u;

    /* renamed from: v  reason: collision with root package name */
    private long f14336v;

    public void a(int i2, boolean z2) {
        this.f14329o = z2 ? i2 | this.f14329o : i2 & this.f14329o;
    }

    public int getCmp_xmag_extern() {
        return this.f14317c;
    }

    public int getCmp_xmag_intern() {
        return this.f14320f;
    }

    public int getCmp_ymag_extern() {
        return this.f14318d;
    }

    public int getCmp_ymag_intern() {
        return this.f14321g;
    }

    public int getCmp_zmag_extern() {
        return this.f14319e;
    }

    public int getCmp_zmag_intern() {
        return this.f14322h;
    }

    public int getGyro_x_extern() {
        return this.f14333s;
    }

    public int getGyro_x_intern() {
        return this.f14330p;
    }

    public int getGyro_y_extern() {
        return this.f14334t;
    }

    public int getGyro_y_intern() {
        return this.f14331q;
    }

    public int getGyro_z_extern() {
        return this.f14335u;
    }

    public int getGyro_z_intern() {
        return this.f14332r;
    }

    public float getOcmp2_x_ofs() {
        return this.f14326l;
    }

    public float getOcmp2_y_ofs() {
        return this.f14327m;
    }

    public float getOcmp2_z_ofs() {
        return this.f14328n;
    }

    public float getOcmp_x_ofs() {
        return this.f14323i;
    }

    public float getOcmp_y_ofs() {
        return this.f14324j;
    }

    public float getOcmp_z_ofs() {
        return this.f14325k;
    }

    public int getOfs_get() {
        return this.f14329o;
    }

    public void getOldOffset2() {
        Parameter b2 = this.f11557b.e().b("COMPASS_OFS2_X");
        if (b2 != null) {
            setOcmp2_x_ofs((float) b2.f14456b);
            a(4096, true);
        }
        Parameter b3 = this.f11557b.e().b("COMPASS_OFS2_Y");
        if (b3 != null) {
            setOcmp2_y_ofs((float) b3.f14456b);
            a(2048, true);
        }
        Parameter b4 = this.f11557b.e().b("COMPASS_OFS2_Z");
        if (b4 != null) {
            setOcmp2_z_ofs((float) b4.f14456b);
            a(1024, true);
        }
    }

    public void getOldOffsets1() {
        Parameter b2 = this.f11557b.e().b("COMPASS_OFS_X");
        if (b2 != null) {
            setOcmp_x_ofs((float) b2.f14456b);
            a(32768, true);
        }
        Parameter b3 = this.f11557b.e().b("COMPASS_OFS_Y");
        if (b3 != null) {
            setOcmp_y_ofs((float) b3.f14456b);
            a(16384, true);
        }
        Parameter b4 = this.f11557b.e().b("COMPASS_OFS_Z");
        if (b4 != null) {
            setOcmp_z_ofs((float) b4.f14456b);
            a(8192, true);
        }
    }

    public long get_last_take_calib_millis() {
        return this.f14336v;
    }

    public boolean is_data_received() {
        return this.f14316a;
    }

    public void setCmp_ymag_intern(int i2) {
        this.f14321g = i2;
    }

    public void setOcmp2_x_ofs(float f2) {
        this.f14326l = f2;
    }

    public void setOcmp2_y_ofs(float f2) {
        this.f14327m = f2;
    }

    public void setOcmp2_z_ofs(float f2) {
        this.f14328n = f2;
    }

    public void setOcmp_x_ofs(float f2) {
        this.f14323i = f2;
    }

    public void setOcmp_y_ofs(float f2) {
        this.f14324j = f2;
    }

    public void setOcmp_z_ofs(float f2) {
        this.f14325k = f2;
    }

    public void set_data_received(boolean z2) {
        this.f14316a = z2;
    }

    public void set_raw_imu(msg_raw_imu msg_raw_imu) {
        this.f14320f = msg_raw_imu.f7066k;
        this.f14321g = msg_raw_imu.f7067l;
        this.f14322h = msg_raw_imu.f7068m;
        this.f14330p = msg_raw_imu.f7063h;
        this.f14331q = msg_raw_imu.f7064i;
        this.f14332r = msg_raw_imu.f7065j;
        c.a().d(new r(42));
    }

    public void set_scaled_imu2(msg_scaled_imu2 msg_scaled_imu2) {
        this.f14317c = msg_scaled_imu2.f7171k;
        this.f14318d = msg_scaled_imu2.f7172l;
        this.f14319e = msg_scaled_imu2.f7173m;
        this.f14333s = msg_scaled_imu2.f7168h;
        this.f14334t = msg_scaled_imu2.f7169i;
        this.f14335u = msg_scaled_imu2.f7170j;
        c.a().d(new r(42));
    }
}
