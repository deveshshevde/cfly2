package ah;

import ag.f;
import android.database.sqlite.SQLiteStatement;

class e extends d implements f {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteStatement f121a;

    e(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f121a = sQLiteStatement;
    }

    public int a() {
        return this.f121a.executeUpdateDelete();
    }

    public long b() {
        return this.f121a.executeInsert();
    }
}
