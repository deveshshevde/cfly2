package ao;

import ag.f;
import androidx.room.RoomDatabase;
import androidx.room.b;
import androidx.room.n;
import androidx.work.d;

public final class o implements n {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f5486a;

    /* renamed from: b  reason: collision with root package name */
    private final b<m> f5487b;

    /* renamed from: c  reason: collision with root package name */
    private final n f5488c;

    /* renamed from: d  reason: collision with root package name */
    private final n f5489d;

    public o(RoomDatabase roomDatabase) {
        this.f5486a = roomDatabase;
        this.f5487b = new b<m>(roomDatabase) {
            public String a() {
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            }

            public void a(f fVar, m mVar) {
                if (mVar.f5484a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, mVar.f5484a);
                }
                byte[] a2 = d.a(mVar.f5485b);
                if (a2 == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, a2);
                }
            }
        };
        this.f5488c = new n(roomDatabase) {
            public String a() {
                return "DELETE from WorkProgress where work_spec_id=?";
            }
        };
        this.f5489d = new n(roomDatabase) {
            public String a() {
                return "DELETE FROM WorkProgress";
            }
        };
    }

    public void a() {
        this.f5486a.f();
        f c2 = this.f5489d.c();
        this.f5486a.g();
        try {
            c2.a();
            this.f5486a.j();
        } finally {
            this.f5486a.h();
            this.f5489d.a(c2);
        }
    }

    public void a(String str) {
        this.f5486a.f();
        f c2 = this.f5488c.c();
        if (str == null) {
            c2.a(1);
        } else {
            c2.a(1, str);
        }
        this.f5486a.g();
        try {
            c2.a();
            this.f5486a.j();
        } finally {
            this.f5486a.h();
            this.f5488c.a(c2);
        }
    }
}
