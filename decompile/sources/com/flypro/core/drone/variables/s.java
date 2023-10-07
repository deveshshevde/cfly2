package com.flypro.core.drone.variables;

import com.MAVLink.common.msg_rc_channels_raw;
import com.MAVLink.common.msg_servo_output_raw;
import com.flypro.core.drone.d;
import dy.au;
import dy.av;
import en.a;
import org.greenrobot.eventbus.c;

public class s extends d {

    /* renamed from: a  reason: collision with root package name */
    public int[] f14374a = new int[8];

    /* renamed from: c  reason: collision with root package name */
    public int[] f14375c = new int[8];

    public s(a aVar) {
        super(aVar);
    }

    public void a(msg_rc_channels_raw msg_rc_channels_raw) {
        this.f14374a[0] = msg_rc_channels_raw.f7108e;
        this.f14374a[1] = msg_rc_channels_raw.f7109f;
        this.f14374a[2] = msg_rc_channels_raw.f7110g;
        this.f14374a[3] = msg_rc_channels_raw.f7111h;
        this.f14374a[4] = msg_rc_channels_raw.f7112i;
        this.f14374a[5] = msg_rc_channels_raw.f7113j;
        this.f14374a[6] = msg_rc_channels_raw.f7114k;
        this.f14374a[7] = msg_rc_channels_raw.f7115l;
        this.f11557b.Q().c((int) msg_rc_channels_raw.f7108e);
        this.f11557b.Q().d((int) msg_rc_channels_raw.f7109f);
        this.f11557b.Q().e((int) msg_rc_channels_raw.f7110g);
        this.f11557b.Q().f((int) msg_rc_channels_raw.f7111h);
        this.f11557b.Q().g((int) msg_rc_channels_raw.f7112i);
        this.f11557b.Q().h((int) msg_rc_channels_raw.f7113j);
        this.f11557b.Q().i((int) msg_rc_channels_raw.f7114k);
        this.f11557b.Q().j((int) msg_rc_channels_raw.f7115l);
        c.a().d(new au(17));
    }

    public void a(msg_servo_output_raw msg_servo_output_raw) {
        this.f14375c[0] = msg_servo_output_raw.f7185e;
        this.f14375c[1] = msg_servo_output_raw.f7186f;
        this.f14375c[2] = msg_servo_output_raw.f7187g;
        this.f14375c[3] = msg_servo_output_raw.f7188h;
        this.f14375c[4] = msg_servo_output_raw.f7189i;
        this.f14375c[5] = msg_servo_output_raw.f7190j;
        this.f14375c[6] = msg_servo_output_raw.f7191k;
        this.f14375c[7] = msg_servo_output_raw.f7192l;
        this.f11557b.Q().k((int) msg_servo_output_raw.f7185e);
        this.f11557b.Q().l((int) msg_servo_output_raw.f7186f);
        this.f11557b.Q().m((int) msg_servo_output_raw.f7187g);
        this.f11557b.Q().n((int) msg_servo_output_raw.f7188h);
        c.a().d(new av(18));
    }

    public int[] a() {
        return this.f14375c;
    }

    public int[] b() {
        return this.f14374a;
    }
}
