package com.flypro.core.MAVLink;

import com.MAVLink.common.msg_rc_channels_override;
import en.a;
import java.util.List;

public class k {
    public static void a(a aVar, msg_rc_channels_override msg_rc_channels_override) {
        aVar.j().a(msg_rc_channels_override.a());
    }

    public static void a(a aVar, int[] iArr) {
        msg_rc_channels_override msg_rc_channels_override = new msg_rc_channels_override();
        msg_rc_channels_override.f7095d = (short) iArr[0];
        msg_rc_channels_override.f7096e = (short) iArr[1];
        msg_rc_channels_override.f7097f = (short) iArr[2];
        msg_rc_channels_override.f7098g = (short) iArr[3];
        msg_rc_channels_override.f7099h = (short) iArr[4];
        msg_rc_channels_override.f7100i = (short) iArr[5];
        msg_rc_channels_override.f7101j = (short) iArr[6];
        msg_rc_channels_override.f7102k = (short) iArr[7];
        msg_rc_channels_override.f7103l = (short) iArr[8];
        msg_rc_channels_override.f7104m = (short) iArr[9];
        msg_rc_channels_override.f7105n = -1;
        msg_rc_channels_override.f7106o = 1;
        aVar.j().a(msg_rc_channels_override.a());
    }

    public static void a(a aVar, int[] iArr, boolean z2, List<msg_rc_channels_override> list) {
        msg_rc_channels_override msg_rc_channels_override = new msg_rc_channels_override();
        msg_rc_channels_override.f7095d = (short) iArr[0];
        msg_rc_channels_override.f7096e = (short) iArr[1];
        msg_rc_channels_override.f7097f = (short) iArr[2];
        msg_rc_channels_override.f7098g = (short) iArr[3];
        msg_rc_channels_override.f7099h = (short) iArr[4];
        msg_rc_channels_override.f7100i = (short) iArr[5];
        msg_rc_channels_override.f7101j = (short) iArr[6];
        msg_rc_channels_override.f7102k = (short) iArr[7];
        msg_rc_channels_override.f7103l = (short) iArr[8];
        msg_rc_channels_override.f7104m = (short) iArr[9];
        msg_rc_channels_override.f7105n = -1;
        msg_rc_channels_override.f7106o = 1;
        if (z2) {
            if (list.size() < 2250) {
                list.add(msg_rc_channels_override);
            } else {
                aVar.D().c(false);
            }
        }
        aVar.j().a(msg_rc_channels_override.a());
    }
}
