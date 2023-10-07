package ao;

import af.c;
import ag.f;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.b;
import androidx.room.k;
import java.util.ArrayList;
import java.util.List;

public final class u implements t {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f5542a;

    /* renamed from: b  reason: collision with root package name */
    private final b<s> f5543b;

    public u(RoomDatabase roomDatabase) {
        this.f5542a = roomDatabase;
        this.f5543b = new b<s>(roomDatabase) {
            public String a() {
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
            }

            public void a(f fVar, s sVar) {
                if (sVar.f5540a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, sVar.f5540a);
                }
                if (sVar.f5541b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, sVar.f5541b);
                }
            }
        };
    }

    public List<String> a(String str) {
        k a2 = k.a("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5542a.f();
        Cursor a3 = c.a(this.f5542a, a2, false, (CancellationSignal) null);
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

    public void a(s sVar) {
        this.f5542a.f();
        this.f5542a.g();
        try {
            this.f5543b.a(sVar);
            this.f5542a.j();
        } finally {
            this.f5542a.h();
        }
    }
}
