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

public final class l implements k {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f5481a;

    /* renamed from: b  reason: collision with root package name */
    private final b<j> f5482b;

    public l(RoomDatabase roomDatabase) {
        this.f5481a = roomDatabase;
        this.f5482b = new b<j>(roomDatabase) {
            public String a() {
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            }

            public void a(f fVar, j jVar) {
                if (jVar.f5479a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, jVar.f5479a);
                }
                if (jVar.f5480b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, jVar.f5480b);
                }
            }
        };
    }

    public List<String> a(String str) {
        k a2 = k.a("SELECT name FROM workname WHERE work_spec_id=?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5481a.f();
        Cursor a3 = c.a(this.f5481a, a2, false, (CancellationSignal) null);
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

    public void a(j jVar) {
        this.f5481a.f();
        this.f5481a.g();
        try {
            this.f5482b.a(jVar);
            this.f5481a.j();
        } finally {
            this.f5481a.h();
        }
    }
}
