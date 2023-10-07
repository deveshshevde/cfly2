package com.liulishuo.filedownloader;

import com.liulishuo.filedownloader.a;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.message.c;
import iq.d;
import java.util.List;

public class aa implements c.b {
    private boolean a(List<a.b> list, MessageSnapshot messageSnapshot) {
        boolean a2;
        if (list.size() > 1 && messageSnapshot.b() == -3) {
            for (a.b next : list) {
                synchronized (next.J()) {
                    if (next.B().c(messageSnapshot)) {
                        d.c(this, "updateMoreLikelyCompleted", new Object[0]);
                        return true;
                    }
                }
            }
        }
        for (a.b next2 : list) {
            synchronized (next2.J()) {
                if (next2.B().b(messageSnapshot)) {
                    d.c(this, "updateKeepFlow", new Object[0]);
                    return true;
                }
            }
        }
        if (-4 == messageSnapshot.b()) {
            for (a.b next3 : list) {
                synchronized (next3.J()) {
                    if (next3.B().d(messageSnapshot)) {
                        d.c(this, "updateSampleFilePathTaskRunning", new Object[0]);
                        return true;
                    }
                }
            }
        }
        if (list.size() != 1) {
            return false;
        }
        a.b bVar = list.get(0);
        synchronized (bVar.J()) {
            d.c(this, "updateKeepAhead", new Object[0]);
            a2 = bVar.B().a(messageSnapshot);
        }
        return a2;
    }

    public void a(MessageSnapshot messageSnapshot) {
        synchronized (Integer.toString(messageSnapshot.m()).intern()) {
            List<a.b> b2 = h.a().b(messageSnapshot.m());
            if (b2.size() > 0) {
                a A = b2.get(0).A();
                if (d.f29057a) {
                    d.c(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(A.r()), Byte.valueOf(messageSnapshot.b()), Integer.valueOf(b2.size()));
                }
                if (!a(b2, messageSnapshot)) {
                    StringBuilder sb = new StringBuilder("The event isn't consumed, id:" + messageSnapshot.m() + " status:" + messageSnapshot.b() + " task-count:" + b2.size());
                    for (a.b A2 : b2) {
                        sb.append(" | ");
                        sb.append(A2.A().r());
                    }
                    d.b(this, sb.toString(), new Object[0]);
                }
            } else {
                d.b(this, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(messageSnapshot.b()));
            }
        }
    }
}
