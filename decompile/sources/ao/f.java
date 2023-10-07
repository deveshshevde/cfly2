package ao;

import af.c;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.b;
import androidx.room.k;

public final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f5469a;

    /* renamed from: b  reason: collision with root package name */
    private final b<d> f5470b;

    public f(RoomDatabase roomDatabase) {
        this.f5469a = roomDatabase;
        this.f5470b = new b<d>(roomDatabase) {
            public String a() {
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            }

            public void a(ag.f fVar, d dVar) {
                if (dVar.f5467a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, dVar.f5467a);
                }
                if (dVar.f5468b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, dVar.f5468b.longValue());
                }
            }
        };
    }

    public Long a(String str) {
        k a2 = k.a("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5469a.f();
        Long l2 = null;
        Cursor a3 = c.a(this.f5469a, a2, false, (CancellationSignal) null);
        try {
            if (a3.moveToFirst()) {
                if (!a3.isNull(0)) {
                    l2 = Long.valueOf(a3.getLong(0));
                }
            }
            return l2;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public void a(d dVar) {
        this.f5469a.f();
        this.f5469a.g();
        try {
            this.f5470b.a(dVar);
            this.f5469a.j();
        } finally {
            this.f5469a.h();
        }
    }
}
