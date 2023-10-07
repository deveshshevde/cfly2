package ah;

import ag.b;
import ag.e;
import ag.f;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.IOException;
import java.util.List;

class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f101a = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f102b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    private final SQLiteDatabase f103c;

    a(SQLiteDatabase sQLiteDatabase) {
        this.f103c = sQLiteDatabase;
    }

    public f a(String str) {
        return new e(this.f103c.compileStatement(str));
    }

    public Cursor a(final e eVar) {
        return this.f103c.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() {
            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                eVar.a(new d(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, eVar.b(), f102b, (String) null);
    }

    public Cursor a(final e eVar, CancellationSignal cancellationSignal) {
        return this.f103c.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() {
            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                eVar.a(new d(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, eVar.b(), f102b, (String) null, cancellationSignal);
    }

    public void a() {
        this.f103c.beginTransaction();
    }

    public void a(String str, Object[] objArr) throws SQLException {
        this.f103c.execSQL(str, objArr);
    }

    /* access modifiers changed from: package-private */
    public boolean a(SQLiteDatabase sQLiteDatabase) {
        return this.f103c == sQLiteDatabase;
    }

    public Cursor b(String str) {
        return a((e) new ag.a(str));
    }

    public void b() {
        this.f103c.endTransaction();
    }

    public void c() {
        this.f103c.setTransactionSuccessful();
    }

    public void c(String str) throws SQLException {
        this.f103c.execSQL(str);
    }

    public void close() throws IOException {
        this.f103c.close();
    }

    public boolean d() {
        return this.f103c.inTransaction();
    }

    public boolean e() {
        return this.f103c.isOpen();
    }

    public String f() {
        return this.f103c.getPath();
    }

    public List<Pair<String, String>> g() {
        return this.f103c.getAttachedDbs();
    }
}
