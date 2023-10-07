package ao;

import ag.f;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.b;
import androidx.room.k;
import java.util.ArrayList;
import java.util.List;

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f5464a;

    /* renamed from: b  reason: collision with root package name */
    private final b<a> f5465b;

    public c(RoomDatabase roomDatabase) {
        this.f5464a = roomDatabase;
        this.f5465b = new b<a>(roomDatabase) {
            public String a() {
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            }

            public void a(f fVar, a aVar) {
                if (aVar.f5462a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, aVar.f5462a);
                }
                if (aVar.f5463b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, aVar.f5463b);
                }
            }
        };
    }

    public void a(a aVar) {
        this.f5464a.f();
        this.f5464a.g();
        try {
            this.f5465b.a(aVar);
            this.f5464a.j();
        } finally {
            this.f5464a.h();
        }
    }

    public boolean a(String str) {
        boolean z2 = true;
        k a2 = k.a("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5464a.f();
        boolean z3 = false;
        Cursor a3 = af.c.a(this.f5464a, a2, false, (CancellationSignal) null);
        try {
            if (a3.moveToFirst()) {
                if (a3.getInt(0) == 0) {
                    z2 = false;
                }
                z3 = z2;
            }
            return z3;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public List<String> b(String str) {
        k a2 = k.a("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5464a.f();
        Cursor a3 = af.c.a(this.f5464a, a2, false, (CancellationSignal) null);
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

    public boolean c(String str) {
        boolean z2 = true;
        k a2 = k.a("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5464a.f();
        boolean z3 = false;
        Cursor a3 = af.c.a(this.f5464a, a2, false, (CancellationSignal) null);
        try {
            if (a3.moveToFirst()) {
                if (a3.getInt(0) == 0) {
                    z2 = false;
                }
                z3 = z2;
            }
            return z3;
        } finally {
            a3.close();
            a2.a();
        }
    }
}
