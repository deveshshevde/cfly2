package org.apache.commons.net;

import java.io.Serializable;
import java.util.EventListener;
import java.util.Iterator;
import org.apache.commons.net.util.ListenerList;

public class ProtocolCommandSupport implements Serializable {
    private static final long serialVersionUID = -8017692739988399978L;

    /* renamed from: a  reason: collision with root package name */
    private final Object f32756a;

    /* renamed from: b  reason: collision with root package name */
    private final ListenerList f32757b = new ListenerList();

    public ProtocolCommandSupport(Object obj) {
        this.f32756a = obj;
    }

    public int a() {
        return this.f32757b.a();
    }

    public void a(int i2, String str) {
        ProtocolCommandEvent protocolCommandEvent = new ProtocolCommandEvent(this.f32756a, i2, str);
        Iterator<EventListener> it2 = this.f32757b.iterator();
        while (it2.hasNext()) {
            ((b) it2.next()).b(protocolCommandEvent);
        }
    }

    public void a(String str, String str2) {
        ProtocolCommandEvent protocolCommandEvent = new ProtocolCommandEvent(this.f32756a, str, str2);
        Iterator<EventListener> it2 = this.f32757b.iterator();
        while (it2.hasNext()) {
            ((b) it2.next()).a(protocolCommandEvent);
        }
    }

    public void a(b bVar) {
        this.f32757b.a(bVar);
    }
}
