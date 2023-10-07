package com.flypro.core.drone.variables;

import android.util.Log;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.common.msg_statustext;
import com.flypro.core.MAVLink.e;
import com.flypro.core.drone.d;
import en.a;

public class c extends d {

    /* renamed from: a  reason: collision with root package name */
    private a f14294a;

    /* renamed from: c  reason: collision with root package name */
    private String f14295c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14296d;

    public c(a aVar) {
        super(aVar);
        this.f14294a = aVar;
    }

    public void a(int i2) {
        e.a(i2, this.f14294a);
    }

    public void a(MAVLinkMessage mAVLinkMessage) {
        if (mAVLinkMessage.f6280c == 253) {
            this.f14295c = ((msg_statustext) mAVLinkMessage).a();
            org.greenrobot.eventbus.c.a().d(new dy.c(27));
        }
    }

    public void a(boolean z2) {
        this.f14296d = z2;
    }

    public boolean a() {
        if (this.f14294a.d().d()) {
            this.f14296d = false;
        } else {
            this.f14296d = true;
            Log.i("ImuTest", "startCalibration: =======");
            e.a(this.f14294a);
        }
        return this.f14296d;
    }

    public boolean b() {
        if (this.f14294a.d().d()) {
            this.f14296d = false;
        } else {
            this.f14296d = true;
            e.b(this.f14294a);
        }
        return this.f14296d;
    }

    public String c() {
        return this.f14295c;
    }

    public boolean d() {
        return this.f14296d;
    }
}
