package com.flypro.core.drone;

import com.flypro.core.drone.DroneInterfaces;
import en.a;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class b extends d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentLinkedQueue<DroneInterfaces.DroneEventsType> f14205a = new ConcurrentLinkedQueue<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final DroneInterfaces.b f14206c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f14207d = new Runnable() {
        public void run() {
            do {
                b.this.f14206c.removeCallbacks(this);
                DroneInterfaces.DroneEventsType droneEventsType = (DroneInterfaces.DroneEventsType) b.this.f14205a.poll();
                if (droneEventsType != null && !b.this.f14208e.isEmpty()) {
                    Iterator it2 = b.this.f14208e.iterator();
                    while (it2.hasNext()) {
                        ((DroneInterfaces.c) it2.next()).onDroneEvent(droneEventsType, b.this.f11557b);
                    }
                }
            } while (!b.this.f14205a.isEmpty());
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ConcurrentLinkedQueue<DroneInterfaces.c> f14208e = new ConcurrentLinkedQueue<>();

    public b(a aVar, DroneInterfaces.b bVar) {
        super(aVar);
        this.f14206c = bVar;
    }

    public void a(DroneInterfaces.DroneEventsType droneEventsType) {
        this.f14205a.offer(droneEventsType);
        this.f14206c.post(this.f14207d);
    }

    public void a(DroneInterfaces.c cVar) {
        if ((true ^ this.f14208e.contains(cVar)) && (cVar != null)) {
            this.f14208e.add(cVar);
        }
    }

    public void b(DroneInterfaces.c cVar) {
        if (cVar != null && this.f14208e.contains(cVar)) {
            this.f14208e.remove(cVar);
        }
    }
}
