package ao;

import af.c;
import ag.f;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.b;
import androidx.room.k;
import androidx.room.n;
import java.util.ArrayList;
import java.util.List;

public final class i implements h {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f5474a;

    /* renamed from: b  reason: collision with root package name */
    private final b<g> f5475b;

    /* renamed from: c  reason: collision with root package name */
    private final n f5476c;

    public i(RoomDatabase roomDatabase) {
        this.f5474a = roomDatabase;
        this.f5475b = new b<g>(roomDatabase) {
            public String a() {
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
            }

            public void a(f fVar, g gVar) {
                if (gVar.f5472a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, gVar.f5472a);
                }
                fVar.a(2, (long) gVar.f5473b);
            }
        };
        this.f5476c = new n(roomDatabase) {
            public String a() {
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            }
        };
    }

    public g a(String str) {
        k a2 = k.a("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5474a.f();
        g gVar = null;
        Cursor a3 = c.a(this.f5474a, a2, false, (CancellationSignal) null);
        try {
            int a4 = af.b.a(a3, "work_spec_id");
            int a5 = af.b.a(a3, "system_id");
            if (a3.moveToFirst()) {
                gVar = new g(a3.getString(a4), a3.getInt(a5));
            }
            return gVar;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public List<String> a() {
        k a2 = k.a("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.f5474a.f();
        Cursor a3 = c.a(this.f5474a, a2, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                arrayList.add(a3.getString(0));
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public void a(g gVar) {
        this.f5474a.f();
        this.f5474a.g();
        try {
            this.f5475b.a(gVar);
            this.f5474a.j();
        } finally {
            this.f5474a.h();
        }
    }

    public void b(String str) {
        this.f5474a.f();
        f c2 = this.f5476c.c();
        if (str == null) {
            c2.a(1);
        } else {
            c2.a(1, str);
        }
        this.f5474a.g();
        try {
            c2.a();
            this.f5474a.j();
        } finally {
            this.f5474a.h();
            this.f5476c.a(c2);
        }
    }
}
