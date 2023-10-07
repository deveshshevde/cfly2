package com.flypro.core.drone.variables;

import android.os.SystemClock;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.common.msg_mission_count;
import com.MAVLink.common.msg_mission_item;
import com.MAVLink.common.msg_mission_item_reached;
import com.MAVLink.common.msg_set_mode;
import com.flypro.core.MAVLink.o;
import com.flypro.core.drone.d;
import dy.be;
import en.a;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.c;

public class ae extends d {

    /* renamed from: a  reason: collision with root package name */
    private List<msg_mission_item> f14286a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private int f14287c;

    public ae(a aVar) {
        super(aVar);
    }

    private void a() {
        msg_mission_count msg_mission_count = new msg_mission_count();
        msg_mission_count.f6928e = -1;
        msg_mission_count.f6929f = 1;
        msg_mission_count.f6927d = (short) this.f14286a.size();
        this.f11557b.j().a(msg_mission_count.a());
    }

    private void a(boolean z2) {
        long j2 = z2 ? 130 : 20;
        for (int i2 = 0; i2 < this.f14286a.size(); i2++) {
            this.f14286a.get(i2).f6938k = (short) i2;
            this.f11557b.j().a(this.f14286a.get(i2).a());
            SystemClock.sleep(j2);
        }
        o.a(this.f11557b);
        SystemClock.sleep(30);
        o.a(this.f11557b);
        SystemClock.sleep(30);
        o.a(this.f11557b);
        for (int i3 = 0; i3 < 3; i3++) {
            msg_set_mode msg_set_mode = new msg_set_mode();
            msg_set_mode.f7208e = -1;
            msg_set_mode.f7209f = 1;
            msg_set_mode.f7207d = 3;
            this.f11557b.j().a(msg_set_mode.a());
            SystemClock.sleep(100);
        }
    }

    public void a(int i2, int i3) {
        if (i2 == i3) {
            SystemClock.sleep(100);
            c.a().d(new be(62));
        }
    }

    public void a(MAVLinkMessage mAVLinkMessage) {
        int i2 = mAVLinkMessage.f6280c;
        if (i2 == 44) {
            msg_mission_count msg_mission_count = (msg_mission_count) mAVLinkMessage;
            if (msg_mission_count.f6927d > 0) {
                this.f14287c = msg_mission_count.f6927d;
            }
        } else if (i2 == 46) {
            a((int) ((msg_mission_item_reached) mAVLinkMessage).f6960d, this.f14287c - 1);
        }
    }

    public void a(boolean z2, List<msg_mission_item> list) {
        o.b(this.f11557b);
        o.b(this.f11557b);
        o.b(this.f11557b);
        if (!this.f14286a.isEmpty()) {
            this.f14286a.clear();
        }
        this.f14286a.addAll(list);
        a();
        SystemClock.sleep(110);
        a();
        SystemClock.sleep(110);
        a();
        SystemClock.sleep(800);
        a(z2);
    }
}
