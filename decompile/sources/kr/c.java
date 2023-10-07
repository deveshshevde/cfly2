package kr;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.cfly.uav_pro.R;
import em.d;
import fg.i;
import java.util.ArrayList;
import java.util.List;
import kh.b;
import ko.a;

public abstract class c extends b.a {

    /* renamed from: a  reason: collision with root package name */
    protected final a f30555a;

    /* renamed from: kr.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30556a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.flypro.core.mission.MissionItemType[] r0 = com.flypro.core.mission.MissionItemType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f30556a = r0
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.LAND     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f30556a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.CIRCLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f30556a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.WAYPOINT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f30556a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.SPLINE_WAYPOINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.c.AnonymousClass1.<clinit>():void");
        }
    }

    protected c(a aVar) {
        this.f30555a = aVar;
    }

    public static List<b> a(a aVar) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        int i2 = AnonymousClass1.f30556a[aVar.b().a().ordinal()];
        if (i2 == 1) {
            obj = new a(aVar);
        } else if (i2 == 2) {
            obj = new b(aVar);
        } else if (i2 != 3) {
            if (i2 == 4) {
                obj = new e(aVar);
            }
            return arrayList;
        } else {
            obj = new f(aVar);
        }
        arrayList.add(obj);
        return arrayList;
    }

    private String d() {
        try {
            int i2 = (this.f30555a.a().c(this.f30555a).a() > i.f27244a ? 1 : (this.f30555a.a().c(this.f30555a).a() == i.f27244a ? 0 : -1));
        } catch (Exception unused) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract int a();

    /* access modifiers changed from: protected */
    public abstract int b();

    public a c() {
        return this.f30555a;
    }

    public float getAnchorU() {
        return 0.5f;
    }

    public float getAnchorV() {
        return 0.5f;
    }

    public Bitmap getIcon(Resources resources) {
        kn.a a2 = this.f30555a.a();
        return kh.c.a(a2.f13910a.d(this.f30555a) ? a() : a2.b(this.f30555a) == 1 ? R.drawable.ic_wp_start : (a2.b(this.f30555a) != a2.b().size() || a2.b().size() == 1) ? b() : R.drawable.ic_wp_end, Integer.toString(a2.b(this.f30555a)), d(), resources);
    }

    public ef.a getPosition() {
        return ((d) this.f30555a.b()).e();
    }

    public boolean isDraggable() {
        return true;
    }

    public boolean isVisible() {
        return true;
    }

    public void setPosition(ef.a aVar) {
        ((d) this.f30555a.b()).a(aVar);
    }
}
