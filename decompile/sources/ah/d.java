package ah;

import android.database.sqlite.SQLiteProgram;

class d implements ag.d {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteProgram f120a;

    d(SQLiteProgram sQLiteProgram) {
        this.f120a = sQLiteProgram;
    }

    public void a(int i2) {
        this.f120a.bindNull(i2);
    }

    public void a(int i2, double d2) {
        this.f120a.bindDouble(i2, d2);
    }

    public void a(int i2, long j2) {
        this.f120a.bindLong(i2, j2);
    }

    public void a(int i2, String str) {
        this.f120a.bindString(i2, str);
    }

    public void a(int i2, byte[] bArr) {
        this.f120a.bindBlob(i2, bArr);
    }

    public void close() {
        this.f120a.close();
    }
}
