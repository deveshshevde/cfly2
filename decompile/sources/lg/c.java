package lg;

import dy.g;
import en.a;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private a f30835a;

    public c(a aVar) {
        this.f30835a = aVar;
    }

    private void b(b bVar) {
        this.f30835a.r().a(new ej.a((double) bVar.q()));
    }

    private void c(b bVar) {
        a aVar;
        boolean z2;
        if (this.f30835a.j().a()) {
            if (!bVar.n() || this.f30835a.d().c()) {
                aVar = this.f30835a;
                z2 = false;
            } else {
                org.greenrobot.eventbus.c.a().d(new g(8));
                aVar = this.f30835a;
                z2 = true;
            }
            com.flypro.core.MAVLink.c.a(aVar, z2);
        }
    }

    private void d(b bVar) {
        if (bVar.n() != this.f30835a.j().a()) {
            this.f30835a.j().a(19);
        }
    }

    public void a(b bVar) {
        if (bVar.c() != null) {
            if (bVar.c().equalsIgnoreCase("SYS_CONNECTION_STATE")) {
                d(bVar);
            } else if (bVar.c().equalsIgnoreCase("SYS_ARM_STATE")) {
                c(bVar);
            } else if (bVar.c().equalsIgnoreCase("SYS_DEF_ALT")) {
                b(bVar);
            }
        }
    }

    public void a(b bVar, String str) {
        boolean a2;
        double a3;
        if (str != null) {
            if (str.equalsIgnoreCase("SYS_BATTREM_LVL")) {
                a3 = this.f30835a.o().b();
            } else if (str.equalsIgnoreCase("SYS_BATTVOL_LVL")) {
                a3 = this.f30835a.o().a();
            } else if (str.equalsIgnoreCase("SYS_BATTCUR_LVL")) {
                a3 = this.f30835a.o().c();
            } else if (str.equalsIgnoreCase("SYS_GPS3D_LVL")) {
                a3 = (double) this.f30835a.b().d();
            } else if (str.equalsIgnoreCase("SYS_DEF_ALT")) {
                a3 = this.f30835a.r().a().a();
            } else {
                if (str.equalsIgnoreCase("SYS_ARM_STATE")) {
                    a2 = this.f30835a.d().c();
                } else if (str.equalsIgnoreCase("SYS_FAILSAFE_STATE")) {
                    a2 = this.f30835a.d().b();
                } else if (str.equalsIgnoreCase("SYS_CONNECTION_STATE")) {
                    a2 = this.f30835a.j().a();
                } else {
                    return;
                }
                bVar.a(a2);
                return;
            }
            bVar.a(a3);
        }
    }
}
